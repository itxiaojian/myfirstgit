package com.zssi.framework.app.sgzgl.service;

import java.text.ParseException;
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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sgzgl.dao.YsgzXxDao;
import com.zssi.framework.app.sgzgl.model.YsgzXx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;

/**
 * 
 * @author liangkaidi
 * @date 2015-10-21
 */
@Service
public class YsgzXxService extends BaseBO<YsgzXxDao> { // BaseBO<T>泛型中写实体类默认有save方法
	@Autowired
	private YsgzXxDao ysgzXxDao;   
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	

	public Pagination<Map<String, Object>> getSgzxxList(Integer start,
			Integer limit, String code) {

		return ysgzXxDao.getSgzxxList(start, limit, code);

	}

	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-10-21
	 * @param entity
	 * 增加
	 */
	@Transactional
	public void save(YsgzXx entity) {
		SysYh yh =AppUtil.getCurrentUser();
		entity.setXgr_id(yh.getXm());
		ysgzXxDao.save(entity);
	}

	/**
	 * jsp修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param id
	 * @return 
	 */
	@Transactional
	public String update(HttpServletRequest request,String id){
		YsgzXx entity=ysgzXxDao.get(Integer.parseInt(id));
		String str="";
		
		String ks_id = request.getParameter("ksbh");
		entity.setKs_id(ks_id);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
		 YsgzXx sgzXx=new YsgzXx();
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		 
		String sgzbh = request.getParameter("sgzbh");
		String rybh = request.getParameter("rybh");
		//String ks_id = request.getParameter("ks_id");
		String zcid = request.getParameter("zcid");
		Integer zciInteger=null;
		
         if(zcid != null && !("").equals(zcid)){
        	 zciInteger  =Integer.parseInt(zcid);
        	 sgzXx.setZcid(zciInteger);
        	 
         }
		String cplx = request.getParameter("cplx");
		String yxq = request.getParameter("yxq");
		
		Date yxqDate = null;
		 if(yxq != null && !("").equals(yxq)){
			 try {
				 yxqDate = sdf.parse(yxq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 sgzXx.setXgrq(yxqDate);
        }
		String kczsb = request.getParameter("kczsb");
		
		String xgrq = request.getParameter("xgrq");
		Date qyrq = null;
		 if(xgrq != null && !("").equals(xgrq)){
			 try {
				qyrq = sdf.parse(xgrq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 sgzXx.setXgrq(qyrq);
         }
		String xgr_id = request.getParameter("xgr_id");
		
		String bz = request.getParameter("bz");
		
		 
		 
		entity.setSgzbh(sgzbh);
		entity.setRybh(rybh);
		//entity.setKs_id(ks_id);
		entity.setZcid(zciInteger);
		entity.setCplx(cplx);
		entity.setYxq(yxqDate);
		entity.setKczsb(kczsb);
		entity.setXgrq(qyrq);
		entity.setXgr_id(xgr_id);
		entity.setBz(bz);
		
		ysgzXxDao.update(entity);
		
		
		
		str="1";
		return str;
	}

	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-10-21
	 * @param ids
	 *            删除
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for (int i = 0; i < ids.length; i++) {
			ysgzXxDao.delete(ids[i]);
		}
	}
	
	
	
	
	/**
	 * 验证表格中的数据
	 * @author liangkaidi
	 * @date 2015-10-22
	 * @param row
	 * @return
	 */
	private String validate(Row row) {
        String v = getSV(row.getCell(0));
        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
        }
        return null;
    }

	/**
	 * 获取单元格
	 * @author liangkaidi
	 * @date 2015-10-22
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
	 * @date 2015-10-22
	 * @param file
	 * @return
	 */
	@Transactional
	public String importMember(MultipartFile file) {
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
            //HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		    Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if (hssfSheet != null)
            {
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++)
                {
                    //HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null)
                    {
                        String result = validate(hssfRow);
                        if (result != null) {
                            return result;
                        }
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//导入日期
                        YsgzXx fa = new YsgzXx();
                        String sgzbh=getSV(hssfRow.getCell(0));
                        String rybh=getSV(hssfRow.getCell(1));
                        String ks_id=getSV(hssfRow.getCell(2));
                        
                        String zcid=getSV(hssfRow.getCell(3));
                        if(zcid != null && !("").equals(zcid)){
                        	Double ztshs = Double.parseDouble(zcid);    //String 转 Integer
                        	int ztsh=ztshs.intValue();
                        	fa.setZcid(ztsh);
                        }
                        
                        String cplx=getSV(hssfRow.getCell(4));
                        String yxq=getSV(hssfRow.getCell(5));
                        if(yxq != null && !("").equals(yxq)){
                        	Date sjks = sdf.parse(yxq);   // String 转 Date
                        	fa.setYxq(sjks);
                        }
                        String kczsb=getSV(hssfRow.getCell(6));
                        String xgrq=getSV(hssfRow.getCell(7));
                        if(xgrq != null && !("").equals(xgrq)){
                        	Date sjks = sdf.parse(xgrq);   // String 转 Date
                        	fa.setXgrq(sjks);
                        }
                        String xgr_id=getSV(hssfRow.getCell(8));
                        String bz=getSV(hssfRow.getCell(9));
                        
                        fa.setSgzbh(sgzbh);
                        fa.setRybh(rybh);
                        fa.setKs_id(ks_id);
                        fa.setCplx(cplx);
                        fa.setKczsb(kczsb);
                        fa.setXgr_id(xgr_id);
                        fa.setBz(bz);
                        
                        dao.save(fa);
                    }
                }
            }
        }
        catch (Exception e)
        {
          return e.getMessage();
        }               
		return null;
	}
	/**
	 * 下载查询结果
	 * @author liangkaidi
	 * @date 2015-10-22
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

		List<Map<String,Object>> list=ysgzXxDao.getList(code);
		String[] header=new String[]{"上岗证编号","人员编号","所属科室","职称","产品类别","有效期","可操作设备","修改日期","修改人","备注"};
		String[] keys=new String[]{"SGZBH","RYBH","KS_ID","ZCID","CPLX","YXQ","KCZSB","XGRQ","ZGR_ID","BZ"};
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
	public String saveRb(HttpServletRequest request, YsgzXx entity) {
		String str="";
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
		 YsgzXx sgzXx=new YsgzXx();
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		 
		String sgzbh = request.getParameter("sgzbh");
		String rybh = request.getParameter("rybh");
		String ks_id = request.getParameter("ks_id");
		String zcid = request.getParameter("zcid");
		Integer zciInteger=null;
		
         if(zcid != null && !("").equals(zcid)){
        	 zciInteger  =Integer.parseInt(zcid);
        	 sgzXx.setZcid(zciInteger);
        	 
         }
		String cplx = request.getParameter("cplx");
		String yxq = request.getParameter("yxq");
		
		Date yxqDate = null;
		 if(yxq != null && !("").equals(yxq)){
			 try {
				 yxqDate = sdf.parse(yxq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 sgzXx.setXgrq(yxqDate);
        }
		String kczsb = request.getParameter("kczsb");
		
		String xgrq = request.getParameter("xgrq");
		Date qyrq = null;
		 if(xgrq != null && !("").equals(xgrq)){
			 try {
				qyrq = sdf.parse(xgrq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 sgzXx.setXgrq(qyrq);
         }
		String xgr_id = request.getParameter("xgr_id");
		
		String bz = request.getParameter("bz");
		
		 
		 
		entity.setSgzbh(sgzbh);
		entity.setRybh(rybh);
		entity.setKs_id(ks_id);
		entity.setZcid(zciInteger);
		entity.setCplx(cplx);
		entity.setYxq(yxqDate);
		entity.setKczsb(kczsb);
		entity.setXgrq(qyrq);
		entity.setXgr_id(xgr_id);
		entity.setBz(bz);
		
		ysgzXxDao.save(entity);
		str="1";
		return str;
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
		return ysgzXxDao.getSgzxx(id);
	}
	
	/**
	 * 修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param id
	 * @return
	 */

	

	@Transactional
	public List<Map<String, Object>> getCk(String id){
		return ysgzXxDao.getSgzxx(id);
	}
/**
 * 数据字典
 * @author liangkaidi
 * @date 2016-1-5
 * @param string
 * @return
 */
	public List<Map<String, Object>> getDicByList(String zdzl) {
		// TODO Auto-generated method stub
		return ysgzXxDao.getDicByList(zdzl);
	}
	
	
	

}
