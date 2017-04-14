package com.zssi.framework.app.cwgl.service;

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
import com.zssi.framework.app.cwgl.dao.YcwKssrDao;
import com.zssi.framework.app.cwgl.model.YcwKssr;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YcwKssrService extends BaseBO<YcwKssrDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwKssrDao ycwKssrDao;
	
	/**
	 * 后台:科室收入列表
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getKssrList(Integer start,Integer limit,String code){
		return ycwKssrDao.getKssrList(start, limit, code);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param entity
	 */
	@Transactional
	public void save(YcwKssr entity) {
		SysYh yh = AppUtil.getCurrentUser();
		entity.setLrr(yh.getXm());
		Date date = new Date();
		entity.setLrrq(date);
		ycwKssrDao.save(entity);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YcwKssr entity,String id){
		entity.setId(Integer.parseInt(id));
		SysYh yh = AppUtil.getCurrentUser();
		entity.setXgr(yh.getXm());
		Date date = new Date();
		entity.setXgrq(date);
		ycwKssrDao.update(entity);
	}
	
	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015-11-19
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getKssr(Integer id){
		return ycwKssrDao.getKssr(id);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ycwKssrDao.delete(ids[i]);
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
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YcwKssr kssr = new YcwKssr();
                        String ksbh=getSV(hssfRow.getCell(0));
                        String ksmc=getSV(hssfRow.getCell(1));
                        String jybh=getSV(hssfRow.getCell(2));
                        String ypmc=getSV(hssfRow.getCell(3));
                        String ypxq=getSV(hssfRow.getCell(4));
                        String cbje=getSV(hssfRow.getCell(5));
                        String skje=getSV(hssfRow.getCell(6));
                        String hssr=getSV(hssfRow.getCell(7));
                        String lrr=getSV(hssfRow.getCell(8));
                        String lrrq=getSV(hssfRow.getCell(9));
                        String xgje=getSV(hssfRow.getCell(10));
                        String xgr=getSV(hssfRow.getCell(11));
                        String xgrq=getSV(hssfRow.getCell(12));
                        String xgyy=getSV(hssfRow.getCell(13));
                        String bz=getSV(hssfRow.getCell(14));
                        
                        kssr.setKsbh(ksbh);
                        kssr.setKsmc(ksmc);
                        kssr.setJybh(jybh);
                        kssr.setYpmc(ypmc);
                        kssr.setYpxq(ypxq);
                        //成本金额字段Sting转BigDecimal
                        if (cbje != null && !("").equals(cbje)) {
							BigDecimal cbjeBigDecimal = new BigDecimal(cbje);
							cbjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							kssr.setCbje(cbjeBigDecimal);
						}
                        //收款金额字段Sting转BigDecimal
                        if (skje != null && !("").equals(skje)) {
							BigDecimal skjeBigDecimal = new BigDecimal(skje);
							skjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							kssr.setSkje(skjeBigDecimal);
						}
                        //核算收入字段Sting转BigDecimal
                        if (hssr != null && !("").equals(hssr)) {
							BigDecimal hssrBigDecimal = new BigDecimal(hssr);
							hssrBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							kssr.setHssr(hssrBigDecimal);
						}
                        kssr.setLrr(lrr);
                        //录入日期字段Sting转Date
                        if (lrrq != null && !("").equals(lrrq)) {
							Date lrrqdDate = sdf.parse(lrrq);
							kssr.setLrrq(lrrqdDate);
						}
                        //修改金额字段Sting转BigDecimal
                        if (xgje != null && !("").equals(xgje)) {
							BigDecimal xgjeBigDecimal = new BigDecimal(xgje);
							xgjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							kssr.setXgje(xgjeBigDecimal);
						}
                        kssr.setXgr(xgr);
                        //修改日期字段Sting转Date
                        if (xgrq != null && !("").equals(xgrq)) {
							Date xgrqdDate = sdf.parse(xgrq);
							kssr.setXgrq(xgrqdDate);
						}
                        kssr.setXgyy(xgyy);
                        kssr.setBz(bz);
                        ycwKssrDao.save(kssr);
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
		List<Map<String,Object>> list=ycwKssrDao.getList(code);
		String[] header=new String[]{"科室编号","科室名称","检验编号","项目编号","样品详情","成本金额","收款金额","核算收入",
				"录入人","录入日期","修改金额","修改人","修改日期","修改原因","备注"};
		String[] keys=new String[]{"KSBH","KSMC","JYBH","XMBH","YPXQ","CBJE","SKJE","HSSR","LRR",
				"LRRQ","XGJE","XGR","XGRQ","XGYY","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}	
}
