package com.zssi.framework.app.rzcpgl.service;

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
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.rzcpgl.dao.YrzCpxxDao;
import com.zssi.framework.app.rzcpgl.model.YrzCpxx;
import com.zssi.framework.app.sgzgl.model.YsgzXx;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YrzCpxxService extends BaseBO<YrzCpxxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YrzCpxxDao yrzCpxxDao;
	
	/**
	 * 后台：产品信息列表
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getCpxxList(Integer start,Integer limit,String code){
		return yrzCpxxDao.getCpxxList(start, limit, code);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param entity
	 */
	@Transactional
	public void save(YrzCpxx entity) {
		yrzCpxxDao.save(entity);
	}
	
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yrzCpxxDao.delete(ids[i]);
		}
	}
	
	/**
	 * 认证类型
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param zdzl
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yrzCpxxDao.getDicByLx(zdzl);
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月27日
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
	 * @date 2015年10月27日
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
	 * @date 2015年10月27日
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
                        YrzCpxx yrzCpxx = new YrzCpxx();
                        String cpbh=getSV(hssfRow.getCell(0));
                        String cpmc=getSV(hssfRow.getCell(1));
                        String cpxh=getSV(hssfRow.getCell(2));
                        String cpcs=getSV(hssfRow.getCell(3));
                        String zzs=getSV(hssfRow.getCell(4));
                        String scgc=getSV(hssfRow.getCell(5));
                        String rzrq=getSV(hssfRow.getCell(6));
                        String rzlx=getSV(hssfRow.getCell(7));
                        String bgbh_id=getSV(hssfRow.getCell(8));
                        String yxq = getSV(hssfRow.getCell(9));
                        String xgsj=getSV(hssfRow.getCell(10));
                        String xgr=getSV(hssfRow.getCell(11));
                        String bz =getSV(hssfRow.getCell(12));
                        
                        yrzCpxx.setCpbh(cpbh);
                        yrzCpxx.setCpmc(cpmc);
                        yrzCpxx.setCpxh(cpxh);
                        yrzCpxx.setCpcs(cpcs);
                        yrzCpxx.setZzs(zzs);
                        yrzCpxx.setScgc(scgc);
                        if(rzrq != null && !("").equals(rzrq)){
                        	Date rzrqDate = sdf.parse(rzrq);   // String 转 Date
                        	yrzCpxx.setRzrq(rzrqDate);
                        }
                        yrzCpxx.setRzlx(rzlx);
                        yrzCpxx.setBgbh_id(bgbh_id);
                        if (yxq != null && !("").equals(yxq)) {
							Date yxqDate = sdf.parse(yxq);     // String 转 Date
							yrzCpxx.setYxq(yxqDate);
						}
                        if (xgsj != null && !("").equals(xgsj)) {
							Date xgsjDate = sdf.parse(xgsj);   // String 转 Date
							yrzCpxx.setXgsj(xgsjDate);
						}
                        yrzCpxx.setXgr(xgr);
                        yrzCpxx.setBz(bz);
                        yrzCpxxDao.save(yrzCpxx);
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
	 * @date 2015年10月27日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yrzCpxxDao.getList(code);
		String[] header=new String[]{"产品编号","产品名称","产品型号","产品参数","制造商","生产工厂","认证日期","认证类型",
				"报告编号ID","有效期","修改时间","修改人","备注"};
		String[] keys=new String[]{"CPBH","CPMC","CPXH","CPCS","ZZS","SCGC","RZRQ","RZLX",
				"BGBH_ID","YXQ","XGSJ","XGR","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

	/**
	 * 认证产品信息增加提交
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param request
	 * @param entity
	 * @return
	 */
	@Transactional
	public String saveRb(HttpServletRequest request, YrzCpxx entity) {
		String str="";
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //用于存日期
		 YrzCpxx rzcpxx=new YrzCpxx();
		String cpbh = request.getParameter("cpbh");
		String cpmc = request.getParameter("cpmc");
		String cpxh = request.getParameter("cpxh");
		String cpcs = request.getParameter("cpcs");
		String zzs = request.getParameter("zzs");
		String scgc = request.getParameter("scgc");
		String rzrq = request.getParameter("rzrq");
		Date rzrqDate = null;
		 if(rzrq != null && !("").equals(rzrq)){
			 try {
				 rzrqDate = sdf.parse(rzrq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 rzcpxx.setRzrq(rzrqDate);
       }
		String rzlx = request.getParameter("rzlx");
		String yxq = request.getParameter("yxq");
		
		Date yxqDate = null;
		 if(yxq != null && !("").equals(yxq)){
			 try {
				 yxqDate = sdf.parse(yxq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 rzcpxx.setYxq(yxqDate);
        }
		String bgbh_id = request.getParameter("bgbh_id");
		String bz = request.getParameter("bz");
		 
		entity.setCpbh(cpbh);
		entity.setCpmc(cpmc);
		entity.setCpxh(cpxh);
		entity.setCpcs(cpcs);
		entity.setZzs(zzs);
		entity.setScgc(scgc);
		entity.setRzrq(rzrqDate);
		entity.setRzlx(rzlx);
		entity.setBgbh_id(bgbh_id);
		entity.setYxq(yxqDate);
		entity.setBz(bz);
		
		yrzCpxxDao.save(entity);
		str="1";
		return str;
	}

	/**
	 * （数据字典）
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getRzlx(String zdzl) {
		return yrzCpxxDao.getRzlx(zdzl);
	}
/**
 * 拉取修改内容
 * @author liangkaidi
 * @date 2015-11-24
 * @param id
 * @return
 */
	@Transactional

	public List<Map<String, Object>> getXg(String id){
		return yrzCpxxDao.gerzcpxx(id);
	}

	/**
	 * 认证产品信息增加提交
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param request
	 * @param entity
	 * @return
	 */
	@Transactional
	public String update(HttpServletRequest request, String id) {
		String str="";
		YrzCpxx	 entity=yrzCpxxDao.get(Integer.parseInt(id));
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //用于存日期
		 
		 YrzCpxx rzcpxx=new YrzCpxx();
		String cpbh = request.getParameter("cpbh");
		String cpmc = request.getParameter("cpmc");
		String cpxh = request.getParameter("cpxh");
		String cpcs = request.getParameter("cpcs");
		String zzs = request.getParameter("zzs");
		String scgc = request.getParameter("scgc");
		String xgr = request.getParameter("xgr");
		String rzrq = request.getParameter("rzrq");
		Date rzrqDate = null;
		 if(rzrq != null && !("").equals(rzrq)){
			 try {
				 rzrqDate = sdf.parse(rzrq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 rzcpxx.setRzrq(rzrqDate);
       }
		 String xgsj = request.getParameter("xgsj");
			Date xgsjDate = null;
			 if(xgsj != null && !("").equals(xgsj)){
				 try {
					 rzrqDate = sdf.parse(xgsj);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				 rzcpxx.setXgsj(xgsjDate);
	       }
		String rzlx = request.getParameter("rzlx");
		String yxq = request.getParameter("yxq");
		
		Date yxqDate = null;
		 if(yxq != null && !("").equals(yxq)){
			 try {
				 yxqDate = sdf.parse(yxq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 rzcpxx.setYxq(yxqDate);
        }
		String bgbh_id = request.getParameter("bgbh_id");
		String bz = request.getParameter("bz");
		 
		entity.setCpbh(cpbh);
		entity.setCpmc(cpmc);
		entity.setCpxh(cpxh);
		entity.setCpcs(cpcs);
		entity.setZzs(zzs);
		entity.setScgc(scgc);
		entity.setXgr(xgr);
		entity.setXgsj(xgsjDate);
		entity.setRzrq(rzrqDate);
		entity.setRzlx(rzlx);
		entity.setBgbh_id(bgbh_id);
		entity.setYxq(yxqDate);
		entity.setBz(bz);
		
		yrzCpxxDao.save(entity);
		str="1";
		return str;
	}
}
