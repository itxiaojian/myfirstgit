package com.zssi.framework.app.rsgl.service;

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
import com.zssi.framework.app.rsgl.dao.YrsPxjlInfoDao;
import com.zssi.framework.app.rsgl.model.YrsPxjlInfo;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YrsPxjlInfoService extends BaseBO<YrsPxjlInfo>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YrsPxjlInfoDao yrsPxjlInfoDao;
	
	/**
	 * 后台：培训记录信息列表
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getPxjlInfoList(Integer start,Integer limit,String code){
		return yrsPxjlInfoDao.getPxjlInfoList(start, limit, code);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YrsPxjlInfo entity,String id){
		entity.setId(Integer.parseInt(id));
		yrsPxjlInfoDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yrsPxjlInfoDao.delete(ids[i]);
		}
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月26日
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
	 * @date 2015年10月26日
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
	 * @date 2015年10月26日
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
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        YrsPxjlInfo pxjlInfo = new YrsPxjlInfo();
                        String rybh=getSV(hssfRow.getCell(0));
                        String ryzh=getSV(hssfRow.getCell(1));
                        String ryxm=getSV(hssfRow.getCell(2));
                        String ks_id=getSV(hssfRow.getCell(3));
                        String xb=getSV(hssfRow.getCell(4));
                        if(xb != null && !("").equals(xb)){
                        	Double xbNumber = Double.parseDouble(xb);    //String 转 Integer
                        	int bx = xbNumber.intValue();
                        	pxjlInfo.setXb(bx);
                        }
                        String sr=getSV(hssfRow.getCell(5));
                        if(sr != null && !("").equals(sr)){
                        	Date birthday = sdf.parse(sr);   // String 转 Date
                        	pxjlInfo.setSr(birthday);
                        }
                        String lxdh=getSV(hssfRow.getCell(6));
                        String sjhm=getSV(hssfRow.getCell(7));
                        String jtzz=getSV(hssfRow.getCell(8));
                        String pxmc=getSV(hssfRow.getCell(9));
                        String hdzsmc=getSV(hssfRow.getCell(10));
                        String pxsj=getSV(hssfRow.getCell(11));
                        if(pxsj != null && !("").equals(pxsj)){
                        	Date sj = sdf.parse(pxsj);   // String 转 Date
                        	pxjlInfo.setPxsj(sj);
                        }
                        String pxnr=getSV(hssfRow.getCell(12));
                        String bz=getSV(hssfRow.getCell(13));
                        
                        pxjlInfo.setRybh(rybh);
                        pxjlInfo.setRyzh(ryzh);
                        pxjlInfo.setRyxm(ryxm);
                        pxjlInfo.setKs_id(ks_id);
                        pxjlInfo.setLxdh(lxdh);
                        pxjlInfo.setSjhm(sjhm);
                        pxjlInfo.setJtzz(jtzz);
                        pxjlInfo.setPxmc(pxmc);
                        pxjlInfo.setHdzsmc(hdzsmc);
                        pxjlInfo.setPxnr(pxnr);
                        pxjlInfo.setBz(bz);
                        
                        yrsPxjlInfoDao.save(pxjlInfo);
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
	 * @date 2015年10月26日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yrsPxjlInfoDao.getList(code);
		String[] header=new String[]{"人员编号","人员账号","人员姓名","所属科室","性别","生日","联系电话",
				"手机号码","家庭住址","培训名称","获得证书名称","培训时间","培训内容","备注"};
		String[] keys=new String[]{"RYBH","RYZH","RYXM","KS_ID","XB","SR","LXDH","SJHM","JTZZ","PXMC","HDZSMC","PXSJ","PXNR","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

	public List<Map<String, Object>> getpxjl(Integer id) {
		return yrsPxjlInfoDao.getPxjl(id);
	}
/**
 * 
 * @author liangkaidi
 * @date 2015-11-26
 * @param request
 * @param entity
 * @return
 */
	@Transactional
	public String saveRb(HttpServletRequest request, YrsPxjlInfo entity) {
			String str="";
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
			 YrsPxjlInfo pxjlInfo=new YrsPxjlInfo();
//			request.getParameter("hybh")是获取前台jsp中的input里的name
			String rybh = request.getParameter("rybh");
			String ryzh = request.getParameter("ryzh");
			String ryxm = request.getParameter("ryxm");
			String ks_id = request.getParameter("ks_id");
			String xb = request.getParameter("xb");
			Integer xbInteger=null;

			 if(xb != null && !("").equals(xb)){
				 xbInteger  =Integer.parseInt(xb);
				 pxjlInfo.setXb(xbInteger);
				 
			 }
			String lxdh = request.getParameter("lxdh");
			String sjhm = request.getParameter("sjhm");
			String jtzz = request.getParameter("jtzz");
			String pxmc = request.getParameter("pxmc");
			String hdzsmc = request.getParameter("hdzsmc");
			String pxsj = request.getParameter("pxsj");
			Date qyrq = null;
			 if(pxsj != null && !("").equals(pxsj)){
//	         	Date qyrq = sdf.parse(pxsj);   // String 转 Date
				 try {
					qyrq = sdf.parse(pxsj);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 pxjlInfo.setPxsj(qyrq);
	         }
			String pxnr = request.getParameter("pxnr");
			String bz = request.getParameter("bz");
//		
			String sr = request.getParameter("sr");
			Date rqfz=null;
	          if(sr != null && !("").equals(sr)){
	          	 try {
					rqfz = sdf.parse(sr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}     // String 转 Date
	          	pxjlInfo.setSr(rqfz);
	          }
			
			 
			entity.setRybh(rybh);
			entity.setRyxm(ryxm);
			entity.setRyzh(ryzh);
			entity.setKs_id(ks_id);
			entity.setXb(xbInteger);
			entity.setSr(rqfz);
			entity.setLxdh(lxdh);
			entity.setSjhm(sjhm);
			entity.setJtzz(jtzz);
			entity.setPxmc(pxmc);
			entity.setHdzsmc(hdzsmc);
			entity.setPxsj(qyrq);
			entity.setPxnr(pxnr);
			entity.setBz(bz);
			yrsPxjlInfoDao.save(entity);
			str="1";
			return str;
		}
	/**
	 * 修改内容
	 * @author liangkaidi
	 * @date 2015-11-28
	 * @param request
	 * @param id
	 * @return
	 */
@Transactional
public String update(HttpServletRequest request, String id) {
	String str="";
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss"); //用于存日期
	 YrsPxjlInfo pxjlInfo=new YrsPxjlInfo();
	 YrsPxjlInfo entity=yrsPxjlInfoDao.get(Integer.parseInt(id));
//	request.getParameter("hybh")是获取前台jsp中的input里的name
	String rybh = request.getParameter("rybh");
	String ryzh = request.getParameter("ryzh");
	String ryxm = request.getParameter("ryxm");
	String ks_id = request.getParameter("ks_id");
	String xb = request.getParameter("xb");
	Integer xbInteger=null;

	 if(xb != null && !("").equals(xb)){
		 xbInteger  =Integer.parseInt(xb);
		 pxjlInfo.setXb(xbInteger);
		 
	 }
	String lxdh = request.getParameter("lxdh");
	String sjhm = request.getParameter("sjhm");
	String jtzz = request.getParameter("jtzz");
	String pxmc = request.getParameter("pxmc");
	String hdzsmc = request.getParameter("hdzsmc");
	String pxsj = request.getParameter("pxsj");
	Date qyrq = null;
	 if(pxsj != null && !("").equals(pxsj)){
//    	Date qyrq = sdf.parse(pxsj);   // String 转 Date
		 try {
			qyrq = sdf.parse(pxsj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pxjlInfo.setPxsj(qyrq);
    }
	String pxnr = request.getParameter("pxnr");
	String bz = request.getParameter("bz");
//
	String sr = request.getParameter("sr");
	Date rqfz=null;
     if(sr != null && !("").equals(sr)){
     	 try {
			rqfz = sdf.parse(sr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     // String 转 Date
     	pxjlInfo.setSr(rqfz);
     }
	
	 
	entity.setRybh(rybh);
	entity.setRyxm(ryxm);
	entity.setRyzh(ryzh);
	entity.setKs_id(ks_id);
	entity.setXb(xbInteger);
	entity.setSr(rqfz);
	entity.setLxdh(lxdh);
	entity.setSjhm(sjhm);
	entity.setJtzz(jtzz);
	entity.setPxmc(pxmc);
	entity.setHdzsmc(hdzsmc);
	entity.setPxsj(qyrq);
	entity.setPxnr(pxnr);
	entity.setBz(bz);
	yrsPxjlInfoDao.update(entity);
	str="1";
	return str;
	
}
/**
 * 修改
 * @author liangkaidi
 * @date 2015-12-1
 * @param id
 * @return
 */
@Transactional
	public YrsPxjlInfo getXg(String id) {
		// TODO Auto-generated method stub
		return yrsPxjlInfoDao.get(Integer.parseInt(id));
	}
/**
 * 获取用户信息
 * @author liangkaidi
 * @date 2016-1-8
 * @param code
 * @return
 */
@Transactional
public List<Map<String, Object>> getYh(String code) {
	// TODO Auto-generated method stub
	return yrsPxjlInfoDao.getYh(code);
}

public List<Map<String, Object>> getDicByList(String zdzl) {
	
	return yrsPxjlInfoDao.getDicByList(zdzl);
}



}
