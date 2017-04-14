package com.zssi.framework.app.dagl.service; 

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
import com.zssi.framework.app.dagl.dao.YdaXxDao;
import com.zssi.framework.app.dagl.model.YdaXx;
import com.zssi.framework.app.util.ExportExcelUtil;

/** 
 * 档案信息service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:34:08 
 * 类说明 
 */
@Service
public class YdaXxService extends BaseBO<YdaXx>{
	
	@Autowired
	private YdaXxDao ydaXxDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	@Transactional
	public Pagination<Map<String, Object>> getDaXxList(Integer start,
			Integer limit, String code) {
		return ydaXxDao.getDaXxList(start, limit, code);
	}


	/**
	 * 更新
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void update(YdaXx entity, String id) {
		entity.setId(Integer.parseInt(id));
		ydaXxDao.update(entity);
	}

	/**
	 * 删除
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ydaXxDao.delete(ids[i]);
		}
	}
	
	/**
	 * jsp中点击修改拉取档案信息内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDa(String id){
		return ydaXxDao.getDa(id);
	}
	
	/**
	 * 档案类型（数据字典）
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getDicByJylx(String zdzl) {
		return ydaXxDao.getDicByJylx(zdzl);
	}
	
	
	//正则表达式判断导入信息类型，暂时搁置
	@Transactional
	private String validate(Row row) {
//        String v = getSV(row.getCell(0));
//        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
//            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//        }
        return null;
    }

	/**
	 * 档案信息导入获取exl表格内容
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
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
	 * 档案信息导入进行每条信息判断
	 * @author liusong
	 * @date 2015年10月9日
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
                        YdaXx daxx = new YdaXx();
                        String dabt=getSV(hssfRow.getCell(0));
                        String dagjz=getSV(hssfRow.getCell(1));
                        String dalx=getSV(hssfRow.getCell(2));
                        String sslmmc=getSV(hssfRow.getCell(3));
                        String damj=getSV(hssfRow.getCell(4));
                        String ssjgid=getSV(hssfRow.getCell(5));
                        String gdnr=getSV(hssfRow.getCell(6));
                        String fjid=getSV(hssfRow.getCell(7));
                        String bgqx=getSV(hssfRow.getCell(8));
                        String gdr=getSV(hssfRow.getCell(9));
                        String kckrxm=getSV(hssfRow.getCell(10));
                        String sfqd=getSV(hssfRow.getCell(11));
                        if(sfqd != null && !("").equals(sfqd)){
                        	Double xbNumber = Double.parseDouble(sfqd);    //String 转 Integer
                        	int bx = xbNumber.intValue();
                        	daxx.setSfqd(bx);
                        }
                        String bz=getSV(hssfRow.getCell(12));
                        
                        daxx.setDabt(dabt);
                        daxx.setDagjz(dagjz);
                        daxx.setDalx(dalx);
                        daxx.setLmmc(sslmmc);
                        daxx.setDamj(damj);
                        daxx.setDamj(damj);
                        daxx.setSsjgid(ssjgid);
                        daxx.setGdnr(gdnr);
                        daxx.setFjid(fjid);
                        daxx.setBgqx(bgqx);
                        daxx.setGdr(gdr);
                        daxx.setKckrxm(kckrxm);
                        daxx.setBz(bz);
                        ydaXxDao.save(daxx);
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
	 * 档案信息导出
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=ydaXxDao.getList(code);
		String[] header=new String[]{"档案标题","档案关键字","档案类型","所属类目","档案密级","所属机构","归档内容","附件",
				"保管期限","归档人","可查看人","是否清档（0：否；1：是）","备注"};
		String[] keys=new String[]{"DABT","DAGJZ","DALX","SSLMMC","DAMJ","SSJGID","GDNR","FJID","BGQX","GDR","KCKRXM","SFQD","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

}
