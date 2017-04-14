package com.zssi.framework.app.cwgl.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
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
import com.zssi.framework.app.cwgl.dao.YcwYgflDao;
import com.zssi.framework.app.cwgl.dao.YcwYgflmxDao;
import com.zssi.framework.app.cwgl.model.YcwYgfl;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;

@Service
public class YcwYgflService extends BaseBO<YcwYgflDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwYgflDao ycwYgflDao;
	
	@Autowired
	private YcwYgflmxDao ycYgflmxDao;
	
	@Autowired
	private SysYhDao sysYhDao;
	/**
	 * 后台:员工福利列表
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYgflList(Integer start,Integer limit,String code){
		return ycwYgflDao.getYgflList(start, limit, code);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 */
	@Transactional
	public void save(YcwYgfl entity) {
		SysYh yh = AppUtil.getCurrentUser();
		entity.setLrr(yh.getXm());
		Date date = new Date();
		entity.setLrrq(date);
		ycwYgflDao.save(entity);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YcwYgfl entity,String id,HttpServletRequest request, HttpServletResponse response){
		entity.setId(Integer.parseInt(id));
		SysYh yh = AppUtil.getCurrentUser();
		entity.setXgr(yh.getXm());
		Date date = new Date();
		entity.setXgrq(date);
		ycwYgflDao.update(entity);
		
//		//保存新的成本明细之前删除旧的成本明细
//		String flbh=entity.getFlbh();
//		ycwYgflDao.deleteFlmxByFlbh(flbh);
//		
//		//保存新的成本明细
//		Integer num = 0;
//		String ygxm = entity.getYgxm();
//		String ks_id = entity.getKs_id();
//		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
//			num=Integer.parseInt(request.getParameter("num"));
//		}
//		for (int i = 0; i <= num; i++) {
//			String flmc=request.getParameter("flmc"+(i+1));
//			String flxq=request.getParameter("flxq"+(i+1));
//			String ssyf = request.getParameter("ssyf"+(i+1));
//			String je=request.getParameter("je"+(i+1));
//			
//			if (flmc!=null && !"".equals(flmc)) {
//				YcwYgflmx ygflmx=new YcwYgflmx();
//				ygflmx.setYgxm(ygxm);
//				ygflmx.setKs_id(ks_id);
//				ygflmx.setSsyf(ssyf);
//				ygflmx.setFlmc(flmc);
//				ygflmx.setFlxq(flxq);
//				ygflmx.setFlbh(flbh);
//				ygflmx.setLrrq(date);
//				if (je != null && !("").equals(je)) {
//					BigDecimal jeBigDecimal = new BigDecimal(je);
//					jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//					ygflmx.setJe(jeBigDecimal);
//				}
//				ycYgflmxDao.save(ygflmx);
//			}
//			
//		}
	}
	
	/**
	 * 修改员工福利明细的员工编号
	 * @author wangyong
	 * @date 2015年12月8日
	 * @param jybh1
	 * @param jybh2
	 */
	public void updateFlmxYgbh(String ygxm1,String ygxm2) {
		ycwYgflDao.updateFlmxYgbh(ygxm1, ygxm2);
	}
	
	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015-11-19
	 * @param id
	 * @return
	 */
	@Transactional
	public YcwYgfl getXg(String id){
		return ycwYgflDao.get(Integer.parseInt(id));
	}
	
	@Transactional
	public List<Map<String, Object>> getYgfl(Integer id){
		return ycwYgflDao.getYgfl(id);
	}
	
	@Transactional
	public List<Map<String, Object>> getYgflmx(String flbh){
		return ycwYgflDao.getYgflmx(flbh);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids,String[] ygxms) {
		for(int i=0;i<ids.length;i++){
			ycwYgflDao.delete(ids[i]);
		}
		
		for(int i=0;i<ygxms.length;i++){
			ycwYgflDao.deleteFlmxByYgxm(ygxms[i]);
		}
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月28日
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
	 * @author wangyong
	 * @date 2015年10月28日
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
	 * @date 2015年10月28日
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
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                        YcwYgfl ygfl = new YcwYgfl();
                        SysYh yh = AppUtil.getCurrentUser();
                		ygfl.setLrr(yh.getXm());
                		Date date = new Date();
                		ygfl.setLrrq(date);
                        String ksbhStr=getSV(hssfRow.getCell(0));
                        List<Map<String,Object>> bmmc1 = sysYhDao.getbmbh(ksbhStr);
                   	    for (int i=0;i<bmmc1.size();i++){
                   	       Map<String, Object> map=(Map<String, Object>)bmmc1.get(i);
                   	       Iterator<String> iterator = map.keySet().iterator();
                            while (iterator.hasNext()){
                                 String key = (String)iterator.next();
                                 Object bgbhObj = map.get(key);
                   				String bmbh = bgbhObj.toString();
                   			    ygfl.setKs_id(bmbh);
                            }
                        }
                        String ssyf=getSV(hssfRow.getCell(1));
                        ygfl.setSsyf(ssyf);
                        
                        String gzxjmc=getSV(hssfRow.getCell(2));
                        List<Map<String, Object>> mcList = ycwYgflDao.getGzxjmc(gzxjmc);
                        if(mcList.size()==1){
                        	String zdz = (String) ycwYgflDao.getGzxjmc(gzxjmc).get(0).get("zdz");
                        	ygfl.setGzxjmc(zdz);
                        }
                        
                        String gzxjxq=getSV(hssfRow.getCell(3));
                        ygfl.setGzxjxq(gzxjxq);
                        
                        String flhj=getSV(hssfRow.getCell(4));
                        //福利合计字段String转BigDecimal
                        if (flhj != null && !("").equals(flhj)) {
							BigDecimal flhjBigDecimal = new BigDecimal(flhj);
							flhjBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							ygfl.setFlhj(flhjBigDecimal);
						}
                        ycwYgflDao.save(ygfl);
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
	 * @date 2015年10月28日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=ycwYgflDao.getList(code);
		String[] header=new String[]{"所属科室","员工姓名","所属月份","工资薪金名称","工资薪金详情","金额","录入人","录入日期","修改人","修改日期"};
		String[] keys=new String[]{"KS_ID","YGXM","SSYF","GZXJMC","GZXJXQ","FLHJ","LRR","LRRQ","XGR","XGRQ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}	
}
