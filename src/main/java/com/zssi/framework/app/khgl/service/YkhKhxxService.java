package com.zssi.framework.app.khgl.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.likegene.framework.core.BaseBO;
import com.likegene.framework.core.SettingUtil;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.dao.YkhKhxxDao;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;
import com.zssi.framework.app.yhgl.model.SysYhxx;

/**
 * 
 * @author liangkaidi
 * @date 2015-9-24
 */

@Service
public class YkhKhxxService  extends BaseBO<YkhKhxxDao> {
	@Autowired
	private YkhKhxxDao yKhKhxxDao;
	@Autowired
	private SysYhDao sysYhDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	 
	public Pagination<Map<String, Object>> getKhxxList( Integer start, Integer limit,String code) {
		
		return yKhKhxxDao.getKhxxList(start, limit, code);
			
		}
	
	/**
	 * 样品登记时委托单位从客户信息中查询获取
	 * @author wangyong
	 * @date 2015年12月18日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getWtdwKhxx(String khmccx,String khflcx){
		return yKhKhxxDao.getWtdwKhxx(khmccx, khflcx);
	}
	
	public List<Map<String, Object>> getKhxxById(Integer id){
		return yKhKhxxDao.getKhxxById(id);
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * 增加
	 */
	@Transactional
	public void save(YkhKhxx entity) {
		yKhKhxxDao.save(entity);
	}
	
	/**
	 * 回访记录查询客户信息
	 * @author liusogn
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getKh(String code){
		return yKhKhxxDao.getJsfwgl(code);
	}
	
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面**********************************************/
	/**
	 * 点击修改拉取内容
	 * 
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param id
	 * @return
	 */

	@Transactional
	public List<Map<String, Object>> getXg(String id){
		return yKhKhxxDao.getkhxx(id);
	}

	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * @param ID
	 * 修改内容上传
	 */
	@Transactional
	public String update(HttpServletRequest request,YkhKhxx entity){
		String str="";
		SysYhxx sysyh= new SysYhxx();
		sysyh.setDlm(entity.getKhbh());
		sysyh.setXm(entity.getKhmc());
		sysyh.setSjh(entity.getGddh1());
		sysyh.setYx(entity.getDzyx1());
		sysyh.setYhzt(1);
		sysyh.setKhfl(1);
		sysYhDao.update(sysyh);
		yKhKhxxDao.update(entity);
		str="1";
		return str;
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param ids
	 * 删除
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			sysYhDao.delete(yKhKhxxDao.getyhbh(ids[i]));
			yKhKhxxDao.delete(ids[i]);
		}
}
	
	/**
	 * 验证表格中的数据
	 * @author liangkaidi
	 * @date 2015年10月22日
	 * @param row
	 * @return
	 */
	private String validate(Row row) {
//        String v = getSV(row.getCell(0));
//        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
//            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//        }
        return null;
    }
	
	/**
	 * 获取单元格
	 * @author liangkaidi
	 * @date 2015年10月22日
	 * @param cell
	 * @return
	 */
	private String getSV(Cell cell)
    {
        if (cell == null)
            return null;
        switch (cell.getCellType())
        {
        case Cell.CELL_TYPE_NUMERIC:
            return "" + cell.getNumericCellValue();
        case Cell.CELL_TYPE_STRING:
            return StringUtils.trim(cell.getStringCellValue());
        default:
            break;
        }

        return null;
    }
	
	/**
	 * 导入EXCEL数据
	 * @author liangkaidi
	 * @date 2015-10-23
	 * @param file
	 * @return
	 */
	@Transactional
	public String importMember(MultipartFile file) {
		String khbh = yKhKhxxDao.getyhbh().get(0).get("khbh").toString();
		if (file.getSize() == 0)
        {
            return "上传文件为空";
        }
		try
        {
			 Workbook hssfWorkbook = null;
		        try {
		        	hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		        } catch (Exception ex) {
		        	hssfWorkbook = new XSSFWorkbook(file.getInputStream());
		        }
		    Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if (hssfSheet != null)
            {
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++)
                {
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null)
                    {
                        String result = validate(hssfRow);
                        if (result != null) {
                            return result;
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //用于存日期
                        YkhKhxx khxx = new YkhKhxx();
                        String khmc=getSV(hssfRow.getCell(0));
                        String khfl=getSV(hssfRow.getCell(1));
                        String dwxz=getSV(hssfRow.getCell(2));
                        String khdz=getSV(hssfRow.getCell(3));
                        String lxr=getSV(hssfRow.getCell(4));
                        String sjhm=getSV(hssfRow.getCell(5));
                        String gddh=getSV(hssfRow.getCell(6));
                        String cz=getSV(hssfRow.getCell(7));
                        String frxm=getSV(hssfRow.getCell(8));
                        String clsj=getSV(hssfRow.getCell(9));
                        if(clsj != null && !("").equals(clsj)){
                        	Date qyrq = sdf.parse(clsj);   // String 转 Date
                        	khxx.setClsj(qyrq);
                        }
                        String zczj=getSV(hssfRow.getCell(10));
                        String jycpmc=getSV(hssfRow.getCell(11));
                        String sr =getSV(hssfRow.getCell(12));
                        if(sr != null && !("").equals(sr)){
                        	Date srs = sdf.parse(sr);   // String 转 Date
                        	khxx.setSr(srs);
                        }
                        String zjlx=getSV(hssfRow.getCell(13));
                        String zjhm =getSV(hssfRow.getCell(14));
                        String bz=getSV(hssfRow.getCell(15));
                        khxx.setLrsj(new Date());
                        khxx.setKhbh(String.valueOf(Integer.parseInt(khbh)+rowNum));
                        khxx.setKhmc(khmc);
                        khxx.setKhfl(khfl);
                        khxx.setDwxz(dwxz);
                        khxx.setKhdz(khdz);
                        khxx.setLxr(lxr);
                        khxx.setSjhm(sjhm);
                        khxx.setGddh(gddh);
                        khxx.setCz(cz);
                        khxx.setFrxm(frxm);
                        khxx.setZczj(zczj);
                        khxx.setJycpmc(jycpmc);
                        khxx.setZjlx(zjlx);
                        khxx.setZjhm(zjhm);
                        khxx.setBz(bz);
                        yKhKhxxDao.save(khxx);
                        SysYhxx sysyh= new SysYhxx();
                		sysyh.setDlm(String.valueOf(Integer.parseInt(khbh)+rowNum));
                		sysyh.setMm(md5PasswordEncoder.encodePassword(
                				(String) SettingUtil.getSetting("ydjuser.password", null),
                				String.valueOf(Integer.parseInt(khbh)+rowNum)));
                		sysyh.setXm(khmc);
                		sysyh.setSjh(sjhm);
                		sysyh.setYhzt(1);
                		sysyh.setKhfl(1);
                		int yhbh = sysYhDao.save(sysyh);
                		yKhKhxxDao.saveJs(yhbh);
                    }
                }
            }
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
        	return e.getMessage();
        }               
		return null;
	}
	
	/**
	 * 根据字典种类找到菜单
	 * @author:liangkaidi
	 * @version 创建时间：2015年9月25日 
	 * @param string
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yKhKhxxDao.getDicByLx(zdzl);
	}
	
	
	
	@Transactional
	public List<Map<String, Object>> getKhlx(String zdzl) {
		return yKhKhxxDao.getKhlx(zdzl);
	}
	
	/**
	 * 导出Excel
	 * @author liangkaidi
	 * @date 2015-10-23
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		if(code!=null){
			code=java.net.URLDecoder.decode(code,"UTF-8");
		}
		List<Map<String, Object>> list=yKhKhxxDao.getList(code);
		String[] header=new String[]{"客户编号","客户名称","客户分类","单位性质","客户地址","联系人","手机号码","固定电话","传真","法人姓名","成立时间(yyyy-mm-dd)",
				"注册资金","检验产品名称","录入时间(yyyy-mm-dd)","生日(yyyy-mm-dd)","证件类型","证件号码","备注"};
		String[] keys=new String[]{"KHBH","KHMC","KHFL","DWXZ","KHDZ","LXR","SJHM","GDDH","CZ","FRXM","CLSJ","ZCZJ","JYCPMC","LRSJ","SR","ZJLX","ZJHM","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 客户信息增加提交
	 * @author liujiansen
	 * @date 2015年9月16日
	 * @param request
	 * @param entity 
	 * @return
	 * @throws  
	 */
	@Transactional
	public String saveRb(HttpServletRequest request, YkhKhxx entity) {
		String str="";
		SysYhxx sysyh= new SysYhxx();
		sysyh.setDlm(entity.getKhbh());
		sysyh.setMm(md5PasswordEncoder.encodePassword(
				(String) SettingUtil.getSetting("ydjuser.password", null),
				entity.getKhbh()));
		sysyh.setXm(entity.getKhmc());
		sysyh.setSjh(entity.getGddh1());
		sysyh.setYx(entity.getDzyx1());
		sysyh.setYhzt(1);
		sysyh.setKhfl(1);
		int yhbh = sysYhDao.save(sysyh);
		yKhKhxxDao.saveJs(yhbh);
		entity.setLrsj(new Date());
		yKhKhxxDao.save(entity);
		str="1";
		return str;
	}
		/**
	 * 客户分类（行业信息表）
	 * @author liangkaidi
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>>getHymc() {
		return yKhKhxxDao.getHymc();
	}
	
	/**
	 * （数据字典）
	 * @author liangkaidi
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>>getDicByList(String zdzl) {
		return yKhKhxxDao.getDicByList(zdzl);
	}
/**
 * 获取客户编号
 * @author liangkaidi
 * @date 2015-11-30
 * @param khbh
 * @return
 */
	@Transactional
	public List<Map<String, Object>>getZjhm(String khbh) {
		return yKhKhxxDao.getZjhm(khbh);
	}
	/**
	 * 查看
	 * @author liangkaidi
	 * @date 2015-12-3
	 * @param id
	 * @return
	 */
	@Transactional
public List<Map<String, Object>> getCk(String id) {
		return yKhKhxxDao.getCk(id);
	}
/**
 * 
 * @author liangkaidi
 * @date 2016-1-15
 * @param id
 * @return
 */
	public List<Map<String, Object>> getJsfwglById(Integer id){
		return yKhKhxxDao.getJsfwglById(id);
	}
}
