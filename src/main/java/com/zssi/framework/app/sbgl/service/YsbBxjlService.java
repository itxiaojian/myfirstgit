package com.zssi.framework.app.sbgl.service; 

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
import com.zssi.framework.app.sbgl.dao.YsbBxjlDao;
import com.zssi.framework.app.sbgl.model.YsbBxjl;
import com.zssi.framework.app.util.ExportExcelUtil;


@Service
public class YsbBxjlService extends BaseBO<YsbBxjlDao> {

	@Autowired
	private YsbBxjlDao ysbBxjlDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 后台：设备保修记录
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getSbbxjlList(Integer start,
			Integer limit, String code) {
		return ysbBxjlDao.getSbbxjlList(start, limit, code);
	}

	/**
	 * 保存
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void save(YsbBxjl entity) {
		ysbBxjlDao.save(entity);
		
	}

	/**
	 * 修改
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void update(YsbBxjl entity, String id) {
		entity.setId(Integer.parseInt(id));
		ysbBxjlDao.update(entity);
	}

	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i = 0; i<ids.length;i++){
			ysbBxjlDao.delete(ids[i]);
			
		}
	}
	
	/**
	 * 设备维保记录修改查询
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBx(String id){
		return ysbBxjlDao.getBx(id);
	}
	
	/** 
	 * 下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ysbBxjlDao.getDicByLx(zdzl);
	}
	
	/** 
	 * 正则表达式进行导入exl表格内容进行判断
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
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
	 * 获取当前exl表格内容
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
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
	 * 导入exl表格内容
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
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
                        YsbBxjl sbbxjl = new YsbBxjl();
                        String sbbh=getSV(hssfRow.getCell(0));
                        String sbmc=getSV(hssfRow.getCell(1));
//                        String txmbh=getSV(hssfRow.getCell(2));
                        String wbsj=getSV(hssfRow.getCell(2));
                        if(wbsj != null && !("").equals(wbsj)){
                        	Date birthday = sdf.parse(wbsj);   // String 转 Date
                        	sbbxjl.setWbsj(birthday);
                        }
                        String wbnr=getSV(hssfRow.getCell(3));
                        String wbr=getSV(hssfRow.getCell(4));
                        String wbzt=getSV(hssfRow.getCell(5));
                        if(wbzt != null && !("").equals(wbzt)){
                        	Double xbNumber = Double.parseDouble(wbzt);    //String 转 Integer
                        	int bx = xbNumber.intValue();
                        	sbbxjl.setWbzt(bx);
                        }
                        String wbfy=getSV(hssfRow.getCell(6));
                        String bz=getSV(hssfRow.getCell(7));
                        
                        sbbxjl.setSbbh(sbbh);
//                        sbbxjl.setTxmbh(txmbh);
                        sbbxjl.setSbmc(sbmc);
                        sbbxjl.setWbnr(wbnr);
                        sbbxjl.setWbr(wbr);
                        sbbxjl.setWbfy(wbfy);
                        sbbxjl.setBz(bz);
                        ysbBxjlDao.save(sbbxjl);
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
	 * exl导出
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=ysbBxjlDao.getList(code);
		String[] header=new String[]{"设备编号","设备名称","设备条形码","维保时间","维保内容","维保人","维保状态（0：正常；1：需保修）","维保费用","备注"};
		String[] keys=new String[]{"SBBH","SBMC","TXMBH","WBSJ","WBNR","WBR","WBZT","WBFY","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

}
