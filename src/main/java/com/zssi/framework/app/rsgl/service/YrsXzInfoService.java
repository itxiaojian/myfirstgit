package com.zssi.framework.app.rsgl.service;

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
import com.zssi.framework.app.rsgl.dao.YrsXzInfoDao;
import com.zssi.framework.app.rsgl.model.YrsXzInfo;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YrsXzInfoService extends BaseBO<YrsXzInfo>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YrsXzInfoDao yrsXzInfoDao;
	
	/**
	 * 后台：薪资管理信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getXzInfoList(Integer start,Integer limit,String code){
		return yrsXzInfoDao.getXzInfoList(start, limit, code);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YrsXzInfo entity,String id){
		entity.setId(Integer.parseInt(id));
		yrsXzInfoDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yrsXzInfoDao.delete(ids[i]);
		}
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月24日
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
	 * @author wangyong
	 * @date 2015年10月24日
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
	 * @author wangyong
	 * @date 2015年10月24日
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
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YrsXzInfo xzInfo = new YrsXzInfo();
                        String rybh=getSV(hssfRow.getCell(0));
                        String ryxm=getSV(hssfRow.getCell(1));
                        String yf=getSV(hssfRow.getCell(2));
                        String jbgz=getSV(hssfRow.getCell(3));
                        String jxgz=getSV(hssfRow.getCell(4));
                        String jbf=getSV(hssfRow.getCell(5));
                        String qt=getSV(hssfRow.getCell(6));
                        String wcbz=getSV(hssfRow.getCell(7));
                        String yfgz=getSV(hssfRow.getCell(8));
                        String sfgz=getSV(hssfRow.getCell(9));
                        String bz=getSV(hssfRow.getCell(10));
                        
                        xzInfo.setRybh(rybh);
                        xzInfo.setRyxm(ryxm);
                        xzInfo.setYf(yf);
                        if (jbgz!=null && !("").equals(jbgz)) {
                        	Double jbgzDouble = Double.parseDouble(jbgz);
                        	int jbgzInt = jbgzDouble.intValue();
                        	xzInfo.setJbgz(jbgzInt);
							
						}
                        if (jxgz!=null && !("").equals(jxgz)) {
                        	Double jxgzDouble = Double.parseDouble(jxgz);
                        	int jxgzInt = jxgzDouble.intValue();
                        	xzInfo.setJxgz(jxgzInt);
							
						}
                        if (jbf!=null && !("").equals(jbf)) {
                        	Double jbfDouble = Double.parseDouble(jbf);
                        	int jbfInt = jbfDouble.intValue();
                        	xzInfo.setJbf(jbfInt);
							
						}
                        if (qt!=null && !("").equals(qt)) {
                        	Double qtDouble = Double.parseDouble(qt);
                        	int qtInt = qtDouble.intValue();
                        	xzInfo.setQt(qtInt);
							
						}
                        if (wcbz!=null && !("").equals(wcbz)) {
                        	Double wcbzDouble = Double.parseDouble(wcbz);
                        	int wcbzInt = wcbzDouble.intValue();
                        	xzInfo.setWcbz(wcbzInt);
							
						}
                        if (yfgz!=null && !("").equals(yfgz)) {
                        	Double yfgzDouble = Double.parseDouble(yfgz);
                        	int yfgzInt = yfgzDouble.intValue();
                        	xzInfo.setYfgz(yfgzInt);
							
						}
                        if (sfgz!=null && !("").equals(sfgz)) {
                        	Double sfgzDouble = Double.parseDouble(sfgz);
                        	int sfgzInt = sfgzDouble.intValue();
                        	xzInfo.setSfgz(sfgzInt);
							
						}
                        
                        xzInfo.setBz(bz);
                        yrsXzInfoDao.save(xzInfo);
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
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月24日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yrsXzInfoDao.getList(code);
		String[] header=new String[]{"人员编号","人员姓名","月份","基本工资","绩效工资","加班费","其他","午餐补助",
				"应发工资","实发工资","备注"};
		String[] keys=new String[]{"RYBH","RYXM","YF","JBGZ","JXGZ","JBF","QT","WCBZ","YFGZ",
				"SFGZ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}


	@Transactional
	public List<Map<String, Object>> getXzgl(Integer id){
		return yrsXzInfoDao.getXzgl(id);
	}
}
