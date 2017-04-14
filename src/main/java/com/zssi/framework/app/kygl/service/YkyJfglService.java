package com.zssi.framework.app.kygl.service; 

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
import com.zssi.framework.app.kygl.dao.YkyJfglDao;
import com.zssi.framework.app.kygl.model.YkyJfgl;
import com.zssi.framework.app.util.ExportExcelUtil;

/** 
 * 
 * 经费管理service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 下午1:06:55 
 * 类说明 
 */
	@Service
	public class YkyJfglService extends BaseBO<YkyJfglDao> {
		
		@Autowired
		private YkyJfglDao ykyJfglDao;
		@Autowired
		private Md5PasswordEncoder md5PasswordEncoder;

		/** 
		 * 经费管理分页查询
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月15日 上午10:19:22 
		 * 类说明 
		 */
		@Transactional
		public Pagination<Map<String, Object>> getKyJfglList(Integer start,
				Integer limit, String code) {
			return ykyJfglDao.getKyJfglList(start, limit, code);
		}

		/**
		 * 保存
		 * @author liusong
		 * @version 2015年9月21日下午2:53:43
		 * @param entity
		 */
		@Transactional
		public void save(YkyJfgl entity) {
			ykyJfglDao.save(entity);
		}

		/**
		 * 修改
		 * @author liusong
		 * @version 2015年9月21日下午2:54:11
		 * @param entity
		 * @param id 主键ID
		 */
		@Transactional
		public void update(YkyJfgl entity, String id) {
			entity.setId(Integer.parseInt(id));
	        ykyJfglDao.update(entity);
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
			for(int i=0;i<ids.length;i++){
				ykyJfglDao.delete(ids[i]);
			}
		}
		
		//正则表达式判断导入信息类型，暂时搁置
		@Transactional
		private String validate(Row row) {
//	        String v = getSV(row.getCell(0));
//	        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
//	            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//	        }
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
		 * 导入exl内容
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
	                        YkyJfgl jfgl = new YkyJfgl();
	                        String kybh=getSV(hssfRow.getCell(0));
	                        jfgl.setKybh(kybh);
	                        String kymc=getSV(hssfRow.getCell(1));
	                        jfgl.setKymc(kymc);
	                        String kyxmnr=getSV(hssfRow.getCell(2));
	                        jfgl.setKyxmnr(kyxmnr);
	                        String ks_id=getSV(hssfRow.getCell(3));
	                        jfgl.setKs_id(ks_id);
	                        String cyry=getSV(hssfRow.getCell(4));
	                        jfgl.setCyry(cyry);
	                        String lxsj=getSV(hssfRow.getCell(5));
	                        if(lxsj != null && !("").equals(lxsj)){
	                        	Date birthday = sdf.parse(lxsj);   // String 转 Date
	                        	jfgl.setLxsj(birthday);
	                        }
	                        String htsj=getSV(hssfRow.getCell(6));
	                        if(htsj != null && !("").equals(htsj)){
	                        	Date birthday = sdf.parse(htsj);   // String 转 Date
	                        	jfgl.setHtsj(birthday);
	                        }
	                        String jfje=getSV(hssfRow.getCell(7));
	                        jfgl.setJfje(jfje);
	                        String bksj=getSV(hssfRow.getCell(8));
	                        if(bksj != null && !("").equals(bksj)){
	                        	Date birthday = sdf.parse(bksj);   // String 转 Date
	                        	jfgl.setBksj(birthday);
	                        }
	                        String bz=getSV(hssfRow.getCell(9));
	                        jfgl.setBz(bz);
	                        ykyJfglDao.save(jfgl);
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
		 * 经费信息导出exl
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月15日 上午10:19:22 
		 * 类说明 
		 */
		@Transactional
		public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
			List<Map<String,Object>> list=ykyJfglDao.getList(code);
			String[] header=new String[]{"科研编号","科研名称","科研项目内容","所属科室","参与人员","立项时间","合同时间","经费金额",
					"拨款时间","备注"};
			String[] keys=new String[]{"KYBH","KYMC","KYXMNR","KS_ID","CYRY","LXSJ","HTSJ","JFJE","BKSJ","BZ"};
			ExportExcelUtil.exportExcel(request, response, header, keys, list);
		}

		
/**
 * 拉取修改内容
 * @author liusong
 * @date 2015-11-27
 * @param id
 * @return
 */
		@Transactional
		public List<Map<String, Object>> getXg(String id) {
			return ykyJfglDao.getList(id);
		}

	
}
