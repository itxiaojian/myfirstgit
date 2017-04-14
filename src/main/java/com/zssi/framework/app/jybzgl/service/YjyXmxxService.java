package com.zssi.framework.app.jybzgl.service;

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
import com.zssi.framework.app.jybzgl.dao.YjyXmxxDao;
import com.zssi.framework.app.jybzgl.model.YjyXmxx;
import com.zssi.framework.app.util.ExportExcelUtil;




/**
 * 检验标准
 * @author mabiao
 *
 */
@Service
public class YjyXmxxService extends BaseBO<YjyXmxxDao>{

	@Autowired
	private YjyXmxxDao yjyXmxxDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	
	/**
	 * 功能--分页查询
	 * @author mabiao
	 * @version 2015-9-22上午2:02:03
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYJyXmxxList(Integer start, Integer limit,String code,String sjid){
		
		return yjyXmxxDao.getYJyXmxxList(start, limit,code,sjid);
	}
	
	/**
	 * 功能--添加
	 * @author mabiao
	 * @version 2015-9-22上午2:04:26
	 * @param entity
	 */
	@Transactional
	public void save(YjyXmxx entity) {
		yjyXmxxDao.save(entity);
	}
	
	/**
	 * 功能--修改
	 * @author mabiao
	 * @version 2015-9-22上午2:05:05
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjyXmxx entity,String id){
		entity.setId(Integer.parseInt(id));
		yjyXmxxDao.update(entity);
	}
	
	/**
	 * 功能--删除
	 * @author mabiao
	 * @version 2015-9-22上午2:06:16
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yjyXmxxDao.delete(ids[i]);
		}
	}

	/**
	 * 功能--项目类型
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByxlx(String zdzl) {
		return yjyXmxxDao.getDicByxlx(zdzl);
	}

	/**
	 * 功能--评定用语
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicBypd(String zdzl) {
		return yjyXmxxDao.getDicBypd(zdzl);
	}
	
	/**
	 * 验证表格中的数据
	 * @author duanpeijun
	 * @date 2015年10月22日
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
	 * @author duanpeijun
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
	 * @author duanpeijun
	 * @date 2015年10月22日
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
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YjyXmxx xmxx = new YjyXmxx();
                        String bzbh=getSV(hssfRow.getCell(0));
                        String bgbh=getSV(hssfRow.getCell(1));
                        String xmbh=getSV(hssfRow.getCell(2));
                        String xmmc=getSV(hssfRow.getCell(3));
                        String jldw=getSV(hssfRow.getCell(4));
                        String xmlx=getSV(hssfRow.getCell(5));
                        String xmyq=getSV(hssfRow.getCell(6));
                        String bzmax=getSV(hssfRow.getCell(7));
                        String bzmin=getSV(hssfRow.getCell(8));
                        String pdyy = getSV(hssfRow.getCell(9));
                        String jyyj=getSV(hssfRow.getCell(10));
                        String dj=getSV(hssfRow.getCell(11));
                        if(dj != null && !("").equals(dj)){
                        	Double djs = Double.parseDouble(dj);    //String 转 Integer
                        	int jd = djs.intValue();
                        	xmxx.setDj(jd);
                        }
                        String pdfs=getSV(hssfRow.getCell(12));
                        String mjyy =getSV(hssfRow.getCell(13));
                        String zdcx = getSV(hssfRow.getCell(14));
                        String xmpx  = getSV(hssfRow.getCell(15));
                        if(xmpx != null && !("").equals(xmpx)){
                        	Double pxxms = Double.parseDouble(xmpx);    //String 转 Integer
                        	int pxxm = pxxms.intValue();
                        	xmxx.setDj(pxxm);
                        }
                        String zxm_id=getSV(hssfRow.getCell(16));
                        String kssj = getSV(hssfRow.getCell(17));
                        if(kssj != null && !("").equals(kssj)){
                        	Date sjks = sdf.parse(kssj);     // String 转 Date
                        	xmxx.setKssj(sjks);
                        }
                        String jssj = getSV(hssfRow.getCell(18));
                        if(jssj != null && !("").equals(jssj)){
                        	Date sjjs = sdf.parse(jssj);     // String 转 Date
                        	xmxx.setJssj(sjjs);
                        }
                        String bz=getSV(hssfRow.getCell(19));
                        
                        xmxx.setBzbh(bzbh);
                        xmxx.setBgbh(bgbh);
                        xmxx.setXmbh(xmbh);
                        xmxx.setXmmc(xmmc);
                        xmxx.setJldw(jldw);
                        xmxx.setXmlx(xmlx);
                        xmxx.setXmyq(xmyq);
                        xmxx.setBzmax(bzmax);
                        xmxx.setBzmin(bzmin);
                        xmxx.setPdyy(pdyy);
                        xmxx.setJyyj(jyyj);
                        xmxx.setPdfs(pdfs);
                        xmxx.setMjyy(mjyy);
                        xmxx.setZdcx(zdcx);
                        xmxx.setZxm_id(zxm_id);
                        xmxx.setBz(bz);
                        yjyXmxxDao.save(xmxx);
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
	 * 导出Excel
	 * @author duanpeijun
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code,String sjid) throws Exception {
		List<Map<String,Object>> list=yjyXmxxDao.getList(code,sjid);
		String[] header=new String[]{"标准编号","报告编号","项目编号","项目名称","计量单位","项目类型","项目要求","标准最大值","标准最小值","评定用语","检验依据及方法","单价","评定方式","默认检验员",
				"最低检出限排序","项目排序","子项目ID","开始时间(yyyy-mm-dd)","结束时间(yyyy-mm-dd)","备注"};
		String[] keys=new String[]{"BZBH","BGBH","XMBH","XMMC","JLDW","XMLX","XMYQ","BZMAX","BZMIN","PDYY","JYYJ","DJ","PDFS","MJYY","ZDCX","XMPX","ZXM_ID",
				"KSSJ","JSSJ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}
