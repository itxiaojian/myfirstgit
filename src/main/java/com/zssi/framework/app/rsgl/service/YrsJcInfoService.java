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
import com.zssi.framework.app.rsgl.dao.YrsJcInfoDao;
import com.zssi.framework.app.rsgl.model.YrsJcInfo;
import com.zssi.framework.app.rsgl.model.YrsRydaxx;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YrsJcInfoService extends BaseBO<YrsJcInfo>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YrsJcInfoDao yrsJcInfoDao;
	
	/**
	 * 后台：奖惩管理信息
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getJcInfoList(Integer start,Integer limit,String code){
		return yrsJcInfoDao.getJcInfoList(start, limit, code);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YrsJcInfo entity,String id){
		entity.setId(Integer.parseInt(id));
		yrsJcInfoDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yrsJcInfoDao.delete(ids[i]);
		}
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月23日
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
	 * @date 2015年10月23日
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
	 * @date 2015年10月23日
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
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YrsJcInfo jcInfo = new YrsJcInfo();
                        String rybh=getSV(hssfRow.getCell(0));
                        String ryxm=getSV(hssfRow.getCell(1));
                        String khyf=getSV(hssfRow.getCell(2));
                        String jcqk=getSV(hssfRow.getCell(3));
                        String bz=getSV(hssfRow.getCell(4));
                        
                        jcInfo.setRybh(rybh);
                        jcInfo.setRyxm(ryxm);
                        jcInfo.setKhyf(khyf);
                        jcInfo.setJcqk(jcqk);
                        jcInfo.setBz(bz);
                        yrsJcInfoDao.save(jcInfo);
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
	 * @date 2015年10月23日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yrsJcInfoDao.getList(code);
		String[] header=new String[]{"人员编号","人员姓名","考核月份","奖惩情况","备注"};
		String[] keys=new String[]{"RYBH","RYXM","KHYF","JCQK","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

		/**
	 * 客户信息增加提交
	 * @author liujiansen
	 * @date 2015年9月16日
	 * @param request
	 * @param entity 
	 * @return
	 * @throws  
	 */
	@Transactional
	public String saveRb(HttpServletRequest request, YrsJcInfo entity) {
		String str="";
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); //用于存日期
		 YrsJcInfo jcInfo=new YrsJcInfo();
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		String rybh = request.getParameter("rybh");
		String khyf = request.getParameter("khyf");
		String ryxm = request.getParameter("ryxm");
		String jcqk = request.getParameter("jcqk");
		String bz = request.getParameter("bz");
		entity.setRybh(rybh);
		entity.setRyxm(ryxm);
		entity.setKhyf(khyf);
		entity.setJcqk(jcqk);
		entity.setBz(bz);
		yrsJcInfoDao.save(entity);
		str="1";
		return str;
	}
	/**
	 * 拉取修改内容
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param id
	 * @return
	 */
	@Transactional
	public YrsJcInfo getXg(String id) {
		return yrsJcInfoDao.get(Integer.parseInt(id));
	}

	
	/**
	 * 修改内容
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param id
	 * @return
	 */
	@Transactional
	public String update(HttpServletRequest request, String id) {
		String str="";
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); //用于存日期
		 YrsJcInfo entity=yrsJcInfoDao.get(Integer.parseInt(id));
		 YrsJcInfo jcInfo=new YrsJcInfo();
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		String rybh = request.getParameter("rybh");
	
		String ryxm = request.getParameter("ryxm");
		String jcqk = request.getParameter("jcqk");
		String bz = request.getParameter("bz");
		
		String khyf = request.getParameter("khyf");
		Date date=new Date();
		String khyfString=new SimpleDateFormat("yyyy-MM").format(date);
		
		entity.setRybh(rybh);
		entity.setRyxm(ryxm);
		entity.setKhyf(khyfString);
		entity.setJcqk(jcqk);
		entity.setBz(bz);
		yrsJcInfoDao.save(entity);
		str="1";
		return str;
		
	}

}
