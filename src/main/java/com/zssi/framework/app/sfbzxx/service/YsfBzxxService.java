package com.zssi.framework.app.sfbzxx.service;

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
import com.zssi.framework.app.jybzgl.dao.YjyBzxxDao;
import com.zssi.framework.app.jybzgl.dao.YjyXmxxDao;
import com.zssi.framework.app.jybzgl.model.YjyBzxx;
import com.zssi.framework.app.jybzgl.model.YjyXmxx;
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.sfbzxx.dao.YsfBzxxDao;
import com.zssi.framework.app.sfbzxx.dao.YsfXmxxDao;
import com.zssi.framework.app.sfbzxx.model.YsfBzxx;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YsfBzxxService extends BaseBO<YsfBzxxDao> {

	@Autowired
	private YsfBzxxDao ysfBzxxDao;
	@Autowired
	private YjyBzxxDao yjyBzxxDao;
	@Autowired
	private YjyXmxxDao yjyXmxxDao;
	@Autowired
	private YsfXmxxDao ysfXmxxDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	public Pagination<Map<String, Object>> getBzxxList(Integer start,
			Integer limit, String canshu) {

		return ysfBzxxDao.getBzxxList(start, limit, canshu);

	}

	/**
	 * 收费标准信息增加提交
	 * 
	 * @author liujiansen
	 * @date 2015年9月16日
	 * @param request
	 * @param entity
	 * @return
	 * @throws
	 */
	@Transactional
	public String saveRb(HttpServletRequest request, YsfBzxx entity) {
		String str = "";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 用于存日期
		YsfBzxx bzxx = new YsfBzxx();
		// request.getParameter("hybh")是获取前台jsp中的input里的name
		String sfbzbh = request.getParameter("sfbzbh");
		String cpmc = request.getParameter("cpmc");
		String cplx = request.getParameter("cplx");
		String ggxh = request.getParameter("ggxh");
		

		entity.setSfbzbh(sfbzbh);
		entity.setCpmc(cpmc);
		entity.setCplx(cplx);
		entity.setGgxh(ggxh);
		
		ysfBzxxDao.save(entity);
		str = "1";
		return str;
	}

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
		return ysfBzxxDao.getbzxx(id);
	}
//	public List<Map<String, Object>> getXg(String id){
//		return ysfBzxxDao.get(Integer.parseInt(id));
//	}

	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * @param ID
	 *            修改内容上传
	 */
	@Transactional
	public String update(HttpServletRequest request, String id) {
		String str = "";
		YsfBzxx entity = ysfBzxxDao.get(Integer.parseInt(id));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 用于存日期
		YsfBzxx bzxx = new YsfBzxx();

		String sfbzbh = request.getParameter("sfbzbh");
		String cpmc = request.getParameter("cpmc");
		String cplx = request.getParameter("cplx");
		String ggxh = request.getParameter("ggxh");

		entity.setSfbzbh(sfbzbh);
		entity.setCpmc(cpmc);
		entity.setCplx(cplx);
		entity.setGgxh(ggxh);
//		entity.setJe(jeFloat);
		ysfBzxxDao.update(entity);
		str = "1";
		return str;
	}

	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-28
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for (int i = 0; i < ids.length; i++) {
			ysfBzxxDao.delete(ids[i]);
		}

	}

	
	

	

	/**
	 * 导出Excel
	 * 
	 * @author liangkaidi
	 * @date 2015-10-23
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response, String canshu) throws Exception {
		if(canshu!=null){
			canshu=java.net.URLDecoder.decode(canshu,"UTF-8");
		}
		List<Map<String, Object>> list = ysfBzxxDao.getList(canshu);
		
		String[] header = new String[] { "收费标准编号", "产品名称","产品类型","规格型号" };
		String[] keys = new String[] { "SFBZBH", "CPMC","CPLX","GGXH" };
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

	/**
	 * 产品类型（行业信息表）
	 * 
	 * @author liangkaidi
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getHymc() {
		return ysfBzxxDao.getHymc();
	}

	/**
	 * （数据字典）
	 * 
	 * @author liangkaidi
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByList(String zdzl) {
		return ysfBzxxDao.getDicByList(zdzl);
	}

	/**
	 * 检验页面————检验标准页面
	 * @author liangkaidi
	 * @date 2015-11-27
	 * @param code
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getJybzxx(String code) {
		return yjyBzxxDao.getJybz(code);
	}
	
	
	@Transactional
	public List<Map<String, Object>> getJyxmxx(String code) {
return yjyXmxxDao.getJyxm(code);
	
	}

	/**
	 * 在检验标页面中点击提交，保存检验标准名称这个字段到样品检验页面的检验依据字段
	 * 
	 * @authorliangkaidi
	 * @date 2015年11月11日
	 * @return
	 */
	@Transactional
	public YjyBzxx getjybzmc(String id) {
		return yjyBzxxDao.get(Integer.parseInt(id));
	}
	/**
	 * 在检验标页面中点击提交，保存检验标准名称这个字段到样品检验页面的检验依据字段
	 * 
     * @authorliangkaidi
	 * @date 2015年11月11日
	 * @return
	 */
	
	@Transactional
	public YjyXmxx getjyxmmc(String id) {
		return yjyXmxxDao.get(Integer.parseInt(id));
	}
	
	/**
	 * 验证表格中的数据
	 * 
	 * @author liangkaidi
	 * @date 2015-10-24
	 * @param row
	 * @return
	 */
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
                        YsfBzxx bzxx = new YsfBzxx();
                        String sfbzbh=getSV(hssfRow.getCell(0));
                        String cpmc=getSV(hssfRow.getCell(1));
                        String cplx=getSV(hssfRow.getCell(2));
                        String ggxh=getSV(hssfRow.getCell(3));
                        
                      
                        bzxx.setSfbzbh(sfbzbh);
                        bzxx.setCpmc(cpmc);
                        bzxx.setCplx(cplx);
                        bzxx.setGgxh(ggxh);
                        
                        ysfBzxxDao.save(bzxx);
                        
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
 * 获取查看信息
 * @author liangkaidi
 * @date 2015-12-17
 * @param id
 * @return
 */
	@Transactional
public List<Map<String, Object>> getCk(String id) {
		return ysfBzxxDao.getbzxx(id);
}
	
}
