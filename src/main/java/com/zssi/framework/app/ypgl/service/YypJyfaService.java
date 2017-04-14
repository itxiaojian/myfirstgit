package com.zssi.framework.app.ypgl.service;

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
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.ypgl.dao.YypJyfaDao;
import com.zssi.framework.app.ypgl.model.YypJyfa;

@Service
public class YypJyfaService extends BaseBO<YypJyfaDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YypJyfaDao dao;
	
	/**
	 * 后台：预检方案列表
	 * @author wangyong 
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getJyfaList(Integer start,Integer limit,String code){
		return dao.getJyfaList(start, limit, code);
	}
	
	/**
	 * 增加
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 */
	@Transactional
	public void save(YypJyfa entity) {
		dao.save(entity);
	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YypJyfa entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
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
                        YypJyfa fa = new YypJyfa();
                        String fabh=getSV(hssfRow.getCell(0));
                        String jylb=getSV(hssfRow.getCell(1));
                        String ypmc=getSV(hssfRow.getCell(2));
                        String bzmc=getSV(hssfRow.getCell(3));
                        String xmbh=getSV(hssfRow.getCell(4));
                        String xmmc=getSV(hssfRow.getCell(5));
                        String zxmbh=getSV(hssfRow.getCell(6));
                        String zxmmc=getSV(hssfRow.getCell(7));
                        String bz=getSV(hssfRow.getCell(8));
                        
                        fa.setFabh(fabh);
                        fa.setBz(bz);
                        fa.setBzmc(bzmc);
                        fa.setJylb(jylb);
                        fa.setXmbh(xmbh);
                        fa.setXmmc(xmmc);
                        fa.setYpmc(ypmc);
                        fa.setZxmbh(zxmbh);
                        fa.setZxmmc(zxmmc);
                        
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
	 * 导出Excel
	 * @author liujiansen
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=dao.getList(code);
		String[] header=new String[]{"方案编号","检验类别","样品名称","标准名称","项目编号","项目名称","子项目编号","子项目名称","备注"};
		String[] keys=new String[]{"FABH","JYLB","YPMC","BZMC","XMBH","XMMC","ZXMBH","ZXMMC","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}
