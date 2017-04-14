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
import com.zssi.framework.app.jybzgl.dao.YjyBzxxDao;
import com.zssi.framework.app.jybzgl.model.YjyBzxx;
import com.zssi.framework.app.util.ExportExcelUtil;


/**
 * 检验标准
 * @author mabiao
 *
 */
@Service
public class YjyBzxxService extends BaseBO<YjyBzxx>{

	@Autowired
	private YjyBzxxDao yjyBzxxDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	
	/**
	 * 分页查询
	 * @author mabiao
	 * @version 2015-9-22上午2:02:03
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYJyBzxxList(Integer start, Integer limit,String code){
		
		return yjyBzxxDao.getYJyBzxxList(start, limit,code);
		
	}
	
	/**
	 * 微信平台检验标准信息查询
	 * @author liusong
	 * @date 2015年11月16日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBz(String id){
		return yjyBzxxDao.getList(id);
	}
	
	@Transactional
	public List<Map<String, Object>> getBz1(String id){
		return yjyBzxxDao.getList1(id);
	}
	
	/**
	 * 添加
	 * @author mabiao
	 * @version 2015-9-22上午2:04:26
	 * @param entity
	 */
//	@Transactional
//	public void save(YjyBzxx entity) {
//		yjyBzxxDao.save(entity);
//	}
	
	/**
	 * 修改
	 * @author mabiao
	 * @version 2015-9-22上午2:05:05
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjyBzxx entity,String id){
		entity.setId(Integer.parseInt(id));
		yjyBzxxDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author mabiao
	 * @version 2015-9-22上午2:06:16
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yjyBzxxDao.delete(ids[i]);
		}
	}

	/**
	 * 功能--标准级别
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yjyBzxxDao.getDicByLx(zdzl);
	}

	/**
	 * 功能--标准类型
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByjb(String zdzl) {
		return yjyBzxxDao.getDicByjb(zdzl);
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
                        YjyBzxx bzxx = new YjyBzxx();
                        String bzbh=getSV(hssfRow.getCell(0));
                        String bzmc=getSV(hssfRow.getCell(1));
                        String bzmcfz=getSV(hssfRow.getCell(2));
                        String pyjm=getSV(hssfRow.getCell(3));
                        String bzlx=getSV(hssfRow.getCell(4));
                        String bzjb=getSV(hssfRow.getCell(5));
                        String bzqyrq=getSV(hssfRow.getCell(6));
                        if(bzqyrq != null && !("").equals(bzqyrq)){
                        	Date qyrq = sdf.parse(bzqyrq);   // String 转 Date
                        	bzxx.setQyrq(qyrq);
                        }
                        String syks=getSV(hssfRow.getCell(7));
                        String xsxmbh=getSV(hssfRow.getCell(8));
                        String zhxgrq = getSV(hssfRow.getCell(9));
                        if(zhxgrq != null && !("").equals(zhxgrq)){
                        	Date xgrq = sdf.parse(zhxgrq);   // String 转 Date
                        	bzxx.setZhxgrq(xgrq);
                        }
                        String xgr=getSV(hssfRow.getCell(10));
                        String fzdjr=getSV(hssfRow.getCell(11));
                        String fzrq =getSV(hssfRow.getCell(12));
                        if(fzrq != null && !("").equals(fzrq)){
                        	Date rqfz = sdf.parse(fzrq);     // String 转 Date
                        	bzxx.setFzrq(rqfz);
                        }
                        String fzzt=getSV(hssfRow.getCell(13));
                        if(fzzt != null && !("").equals(fzzt)){
                        	Double ztfzs = Double.parseDouble(fzzt);    //String 转 Integer
                        	int ztfz = ztfzs.intValue();
                        	bzxx.setFzzt(ztfz);
                        }
                        String shzt = getSV(hssfRow.getCell(14));
//                        String[] arr = shzt.split(".");
                        if(shzt != null && !("").equals(shzt)){
                        	Double ztshs = Double.parseDouble(shzt);    //String 转 Integer
                        	int ztsh=ztshs.intValue();
                        	bzxx.setShzt(ztsh);
                        }
                        String shrq  = getSV(hssfRow.getCell(15));
                        if(shrq != null && !("").equals(shrq)){
                        	Date rqsh = sdf.parse(shrq);     // String 转 Date
                    	    bzxx.setShrq(rqsh);
                        }
                        String shr=getSV(hssfRow.getCell(16));
                        String kssj = getSV(hssfRow.getCell(17));
                        if(kssj != null && !("").equals(kssj)){
                        	Date sjks = sdf.parse(kssj);     // String 转 Date
                        	bzxx.setKssj(sjks);
                        }
                        String jssj = getSV(hssfRow.getCell(18));
                        if(jssj != null && !("").equals(jssj)){
                        	Date sjjs = sdf.parse(jssj);     // String 转 Date
                        	bzxx.setJssj(sjjs);
                        }
                        String bz=getSV(hssfRow.getCell(19));
                        
                        bzxx.setBzbh(bzbh);
                        bzxx.setBzmc(bzmc);
                        bzxx.setBzmc_fz(bzmcfz);
                        bzxx.setPyjm(pyjm);
                        bzxx.setBzlb(bzlx);
                        bzxx.setBzjb(bzjb);
                        bzxx.setKs_id(syks);
                        bzxx.setXmbh_id(xsxmbh);
                        bzxx.setXgr(xgr);
                        bzxx.setFzdjr(fzdjr);
                        bzxx.setShr(shr);
                        bzxx.setBz(bz);
                        yjyBzxxDao.save(bzxx);
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
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yjyBzxxDao.getList(code);
		String[] header=new String[]{"标准编号","检验标准名称","标准名称附注","拼音简码","标准类型","标准级别","标准启用日期(yyyy-mm-dd)","使用科室ID","下属项目编号","最后修改日期","修改人",
				"废止状态","废止日期","废止登记人","审核状态","审核日期","审核人","开始时间","结束时间","备注"};
		String[] keys=new String[]{"BZBH","BZMC","BZMC_FZ","PYJM","BZLB","BZJB","QYRQ","KS_ID","XMBH_ID","ZHXGRQ","XGR","BZDMC","FZRQ","FZDJR","CZDMC","SHRQ","SHR",
				"KSSJ","JSSJ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}
