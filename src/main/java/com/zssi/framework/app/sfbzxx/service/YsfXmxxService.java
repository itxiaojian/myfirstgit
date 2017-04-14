package com.zssi.framework.app.sfbzxx.service;

import java.math.BigDecimal;
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
import com.zssi.framework.app.sfbzxx.dao.YsfXmxxDao;
import com.zssi.framework.app.sfbzxx.model.YsfBzxx;
import com.zssi.framework.app.sfbzxx.model.YsfXmxx;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YsfXmxxService extends BaseBO<YsfXmxxDao>{
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YsfXmxxDao ysfXmxxDao;
	
	
	/**
	 * 后台:成本明细列表
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param start
	 * @param limit
	 * @param xmbh
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getxmxxList(Integer start,Integer limit,String sfbzbh){
		return ysfXmxxDao.getxmxxList(start, limit, sfbzbh);
	}
	
	/**
	 * 增加
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param entity
	 */
	@Transactional
	public void save(YsfXmxx entity) {
		ysfXmxxDao.save(entity);
	}
	
	/**
	 * 增加多条数据
	 * @author wangyong
	 * @date 2015年11月11日
	 * @param request
	 * @param rbbh
	 */

	
@Transactional
public void insert(HttpServletRequest request){
	Integer num=0;
	if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
		num=Integer.parseInt(request.getParameter("num"));
	}
	for (int i = 0; i < num; i++) {
		String sfbzbh=request.getParameter("sfbzbh"+(i+1));
		String xmbh=request.getParameter("xmbh"+(i+1));
		String xmmc=request.getParameter("xmmc"+(i+1));
		String cplx=request.getParameter("cplx"+(i+1));
		String cplxbh=request.getParameter("cplxbh"+(i+1));
		String jldw=request.getParameter("jldw"+(i+1));
		String dj=request.getParameter("dj"+(i+1));
		String bz=request.getParameter("bz"+(i+1));
		
		YsfXmxx ysXmxx=new YsfXmxx();
		
		ysXmxx.setSfbzbh(sfbzbh);
		ysXmxx.setXmbh(xmbh);
		ysXmxx.setXmmc(xmmc);
		ysXmxx.setCplx(cplx);
		ysXmxx.setCplxbh(cplxbh);
		ysXmxx.setJldw(jldw);
		if (dj != null && !("").equals(dj)) {
			BigDecimal jeBigDecimal = new BigDecimal(dj);
			jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			ysXmxx.setDj(jeBigDecimal);
		}
		ysXmxx.setBz(bz);
		ysfXmxxDao.save(ysXmxx);
	}
}
	/**
	 * 修改
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YsfXmxx entity,String id){
		entity.setId(Integer.parseInt(id));
		ysfXmxxDao.update(entity);
	}
	/**
	 * 删除
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ysfXmxxDao.delete(ids[i]);
		}
	}
/**
 * 数据字典中取值
 * @author liangkaidi
 * @date 2015-12-10
 * @param zdzl
 * @return
 */
	@Transactional
	public List<Map<String, Object>> getDicByList(String zdzl) {
		return ysfXmxxDao.getDicByList(zdzl);
	}

/**
	 * 验证表格中的数据
	 * 
	 * @author liangkaidi
	 * @date 2015-10-24
	 * @param row
	 * @return
	 */
	@Transactional
	private String validate(Row row) {
		String v = getSV(row.getCell(0));
		if (v != null && !v.matches("^[0-9A-Za-z]{1,12}$")) {
			return "第" + (row.getRowNum() + 1) + "行第1列，必需是数字字母且长度不超过12";
		}
		return null;
	}

	/**
	 * 获取单元格
	 * 
	 * @author liangkaidi
	 * @date 2015-10-24
	 * @param cell
	 * @return
	 */
	@Transactional
	private String getSV(Cell cell) {
		if (cell == null)
			return null;
		switch (cell.getCellType()) {
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
 * 导入excel
 * @author liangkaidi
 * @date 2015-12-11
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
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //用于存日期
                        
                        YsfXmxx xmxx=new YsfXmxx();
                        String sfbzbh1=getSV(hssfRow.getCell(0));
                        String xmbh=getSV(hssfRow.getCell(1));
                        String xmmc=getSV(hssfRow.getCell(2));
                        String cplx=getSV(hssfRow.getCell(3));
                        String cplxbh=getSV(hssfRow.getCell(4));
                        String jldw=getSV(hssfRow.getCell(5));
                        String dj=getSV(hssfRow.getCell(6));
                        //dj字段String转BigDecimal
                        if (dj != null && !("").equals(dj)) {
							BigDecimal djBigDecimal = new BigDecimal(dj);
							djBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							xmxx.setDj(djBigDecimal);
						}
                        
                        String bz=getSV(hssfRow.getCell(7));
                        
                        
                      
                      
                     
                      
                       
                        
                        xmxx.setSfbzbh(sfbzbh1);
                        xmxx.setXmbh(xmbh);
                        xmxx.setXmmc(xmmc);
                        xmxx.setCplx(cplx);
                        xmxx.setCplxbh(cplxbh);
                        xmxx.setJldw(jldw);
                        xmxx.setBz(bz);
                        ysfXmxxDao.save(xmxx);
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
	 * @author liangkaidi
	 * @date 2015-10-23
	 * @param request
	 * @param response
	 * @param canshu
	 * @throws Exception
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String canshu) throws Exception {
		if(canshu!=null){
			canshu=java.net.URLDecoder.decode(canshu,"UTF-8");
		}
		List<Map<String, Object>> list=ysfXmxxDao.getList(canshu);
		
		String[] header=new String[]{"收费标准编号","项目编号","项目名称","产品类型","产品类型编号","单位","单价","备注"};
		String[] keys=new String[]{"SFBZBH","XMBH","XMMC","CPLX","CPLXBH","JLDW","DJ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
/**
 * 从数据字典取值
 * @author liangkaidi
 * @date 2015-12-11
 * @param zdzl
 * @return
 */
	@Transactional
	public List<Map<String, Object>> getDicByjb(String zdzl) {
		return ysfXmxxDao.getDicByjb(zdzl);
	}
}
