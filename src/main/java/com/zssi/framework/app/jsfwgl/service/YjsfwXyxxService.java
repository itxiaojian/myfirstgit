package com.zssi.framework.app.jsfwgl.service; 

import java.math.BigDecimal;
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
import com.zssi.framework.app.cwgl.dao.YcwJsfwxysfDao;
import com.zssi.framework.app.cwgl.dao.YcwJsfwxysfjlDao;
import com.zssi.framework.app.jsfwgl.dao.YjsfwXyxxDao;
import com.zssi.framework.app.jsfwgl.model.YjsfwXyxx;
import com.zssi.framework.app.util.ExportExcelUtil;

/**
 * 技术服务信息service层
 * @author liusong
 * @date 2015年10月9日
 * @return
 */
@Service
public class YjsfwXyxxService extends BaseBO<YjsfwXyxxDao> {
	
	@Autowired
	private YjsfwXyxxDao yjsfwXyxxDao;
	@Autowired
	private YcwJsfwxysfDao xysfDao;
	@Autowired
	private YcwJsfwxysfjlDao xysfjlDao;

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	
	/**
	 * 后台：技术服务协议信息
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getJsfwXyxxList(Integer start,
			Integer limit, String code) {
		return yjsfwXyxxDao.getJsfwXyxxList(start, limit, code);
	}

	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年10月9日
	 * @param entity
	 */
	@Transactional
	public void save(YjsfwXyxx entity) {
		yjsfwXyxxDao.save(entity);
	}

	/**
	 * 更新
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	public void update(YjsfwXyxx entity, String id) {
		entity.setId(Integer.parseInt(id));
		yjsfwXyxxDao.update(entity);
	}

	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids,String[] xybh) {
		for(int i=0;i<ids.length;i++){
			yjsfwXyxxDao.delete(ids[i]);
			xysfDao.deletesf(xybh[i]);
			xysfjlDao.deletejl(xybh[i]);
		}
	}

	/**
	 * 下拉菜单查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yjsfwXyxxDao.getDicByLx(zdzl);
	}
	
	/**
	 * 根据协议编号查出收费id
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getIdbyXybh(String xybh) {
		return yjsfwXyxxDao.getIdbyXybh(xybh);
	}
	
	/**
	 * 技术服务信息导入正则判断
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	private String validate(Row row) {
        String v = getSV(row.getCell(0));
        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
        }
        return null;
    }

	/**
	 * 技术服务信息导入获取当前exl表格内容
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
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
	 * 技术服务信息导入
	 * @author liusong
	 * @date 2015年10月9日
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
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YjsfwXyxx xyxx = new YjsfwXyxx();
                        String xybh=getSV(hssfRow.getCell(0));
                        xyxx.setXybh(xybh);
                        String khmc=getSV(hssfRow.getCell(1));
                        xyxx.setKhmc(khmc);
                        String khdz=getSV(hssfRow.getCell(2));
                        xyxx.setKhdz(khdz);
                        String frdb=getSV(hssfRow.getCell(3));
                        xyxx.setFrdb(frdb);
                        String lxdh=getSV(hssfRow.getCell(4));
                        xyxx.setLxdh(lxdh);
                        String cpmc=getSV(hssfRow.getCell(5));
                        xyxx.setCpmc(cpmc);
                        String fwxm=getSV(hssfRow.getCell(6));
                        xyxx.setFwxm(fwxm);
                        String xylx=getSV(hssfRow.getCell(7));
                        xyxx.setXylx(xylx);
                        String sxrq=getSV(hssfRow.getCell(8));
                        if(sxrq != null && !("").equals(sxrq)){
                        	Date birthday = sdf.parse(sxrq);   // String 转 Date
                        	xyxx.setSxrq(birthday);
                        }
                        String zzrq=getSV(hssfRow.getCell(9));
                        if(zzrq != null && !("").equals(zzrq)){
                        	Date birthday = sdf.parse(zzrq);   // String 转 Date
                        	xyxx.setZzrq(birthday);
                        }
                        String ks_id=getSV(hssfRow.getCell(10));
                        xyxx.setKs_id(ks_id);
                        String xyzy=getSV(hssfRow.getCell(11));
                        xyxx.setXyzy(xyzy);
                        String xykh=getSV(hssfRow.getCell(12));
                        if(xykh != null && !("").equals(xykh)){
                        	Double xbNumber = Double.parseDouble(xykh);    //String 转 Integer
                        	int bx = xbNumber.intValue();
                        	xyxx.setXykh(new BigDecimal(bx));
                        }
                        String fkfs=getSV(hssfRow.getCell(13));
                        if(fkfs != null && !("").equals(fkfs)){
                        	Double xbNumber = Double.parseDouble(fkfs);    //String 转 Integer
                        	int bx = xbNumber.intValue();
                        	xyxx.setFkfs(bx);
                        }
                        String bz_id=getSV(hssfRow.getCell(14));
                        xyxx.setBz_id(bz_id);
                        String jybh_id=getSV(hssfRow.getCell(15));
                        xyxx.setJybh_id(jybh_id);
                        String khjlgm=getSV(hssfRow.getCell(16));
                        xyxx.setKhjlgm(khjlgm);
                        String khhz_info=getSV(hssfRow.getCell(17));
                        xyxx.setKhhz_info(khhz_info);
                        String xyfzr=getSV(hssfRow.getCell(18));
                        xyxx.setXyfzr(xyfzr);
                        String djrq=getSV(hssfRow.getCell(19));
                        if(djrq != null && !("").equals(djrq)){
                        	Date birthday = sdf.parse(djrq);   // String 转 Date
                        	xyxx.setDjrq(birthday);
                        }
                        String jyks_id=getSV(hssfRow.getCell(20));
                        xyxx.setJyks_id(jyks_id);
                        String yeks_id=getSV(hssfRow.getCell(21));
                        xyxx.setYeks_id(yeks_id);
                        String bz=getSV(hssfRow.getCell(22));
                        xyxx.setBz(bz);
                        yjsfwXyxxDao.save(xyxx);
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
	 * 技术服务信息导出
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yjsfwXyxxDao.getList(code);
		String[] header=new String[]{"协议编号","客户名称","客户地址","法人代表","联系电话","涉及产品名称","服务项目","协议类型","生效日期","终止日期","协议科室","协议摘要","协议金额",
				"付款方式（0：电汇；1：现金）","执行标准","已出具报告编号","客户经济类型及规模","客户已获取证情况","协议负责人","登记日期","检验科室","业务科室","备注"};
		String[] keys=new String[]{"XYBH","KHMC","KHDZ","FRDB","LXDH","CPMC","FWXM","XYLX","SXRQ","ZZRQ","KS_ID","XYZY","XYKH","FKFS",
				"BZ_ID","JYBH_ID","KHJLGM","KHHZ_INFO","XYFZR","DJRQ","JYKS_ID","YEKS_ID","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
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
	return yjsfwXyxxDao.getDicByLx(zdzl);
}

	/**
	 * jsp中点击修改拉取内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getXg(String id){
//		System.out.println("service层获取到的id是: " + id);
//		System.out.println(yjsfwXyxxDao.getList(id));
		return yjsfwXyxxDao.getList(id);
	}
	
	/**
	 * 检验合同号从协议信息获取，获取协议信息方法	
	 * @author wangyong
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getJyhth(String jyhthkhmc,String jyhthkhdz){
		return yjsfwXyxxDao.getJyhth(jyhthkhmc, jyhthkhdz);
	}

}
