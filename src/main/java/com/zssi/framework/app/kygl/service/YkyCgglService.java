package com.zssi.framework.app.kygl.service; 

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.zssi.framework.app.kygl.dao.YkyCgglDao;
import com.zssi.framework.app.kygl.model.YkyCggl;
import com.zssi.framework.app.kygl.model.YkyJfgl;
import com.zssi.framework.app.util.ExportExcelUtil;

/** 
 * 科研信息管理service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:04:15 
 * 类说明 
 */
@Service
public class YkyCgglService extends BaseBO<YkyCgglDao> {
	
	@Autowired
	private YkyCgglDao ykyCgglDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	@Transactional
	public Pagination<Map<String, Object>> getKyCgglList(Integer start,
			Integer limit, String code) {
		return ykyCgglDao.getKyCgglList(start, limit, code);
	}
	
	/**
	 * liusong 
	 * 上传图片素材
	 */
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,YkyCggl cggl,HttpServletResponse actioncontext,HttpServletRequest request){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
//		String date = sdf.format(new Date());		//当前日期格式化到秒
//		String random = RandomUtil.generateWord();	//获得随机数
		String filename = "";       //文件名
		String fileNameSuffix ="";  //文件后缀名
//		String result = "";
		String fileNameU = "";
//		String mediaId = "";
		String path = "";
		InputStream inputStream = null;
		String re=null;
//        String sub=null;
		
		try {
			//FileInputStream fileInputStream = new FileInputStream(attachMentFile.toString());
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			//保存的文件在项目中的路径
//			String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			List<String> fileTypes = new ArrayList<String>();
	        fileTypes.add("jpg");
	        fileTypes.add("jpeg");
	        fileTypes.add("bmp");
	        fileTypes.add("gif");
	        fileTypes.add("png");
	        fileTypes.add("pdf");
	        fileTypes.add("doc");
	        fileTypes.add("docx");
	        fileTypes.add("mpp");
	        fileTypes.add("txt");
	        fileTypes.add("xls");
	        fileTypes.add("xlsx");
	        fileTypes.add("zip");
	        fileTypes.add("rar");
	        fileTypes.add("ppt");
	        fileTypes.add("pptx");
	            if(attachMentFile.isEmpty()){  
//	                System.out.println("文件未上传");  
	                throw new RuntimeException("文件未上传");
	            }else{  
//	                System.out.println("文件长度: " + attachMentFile.getSize());  
//	                System.out.println("文件类型: " + attachMentFile.getContentType());  
//	                System.out.println("文件名称: " + attachMentFile.getName());  
//	                System.out.println("文件原名: " + attachMentFile.getOriginalFilename()); 
	                filename = attachMentFile.getOriginalFilename();//文件原名
	                fileNameSuffix = filename.substring( filename.lastIndexOf('.')+1 );
//	                System.out.println("文件后缀名："+fileNameSuffix);
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            //int i=re.lastIndexOf("\\");
//	        	            sub=re.substring(re.lastIndexOf("\\")+1);
	        	            actioncontext.setContentType("text/html");
	            }  
	            //文件输入流
//	            inputStream = attachMentFile.getInputStream();
	            //拼装上传路径
	            //文件名称 （日期+随机数+原文件后缀名）
//	            fileNameU = date+random+"."+fileNameSuffix;
	            
//	            System.out.println("文件保存路径："+path);
//	            System.out.println("上传后的文件名："+fileNameU);
//	            System.out.println("========================================");
	            //上传到本地服务器
//	            String temp = new FileCommonOperate().uploadFile(inputStream, path, fileNameU.trim());
//	            System.out.println(temp);
//	            System.out.println("文件保存的绝对路径："+path+File.separator+fileNameU);
	            //上传到微信服务器
	            /*result = WeixinUtils.uploadMedia("image", path+File.separator+fileNameU);
	            System.out.println("微信服务器返回结果："+result);*/
	            	
	            		//保存到数据库
//	            		mediaId = result;
//	            		YjyRztb rztb = new YjyRztb();    //素材对象
	            		cggl.setCgnr(filename);//文件原名
//	            		rztb.setFjlj(p);
//	            		rztb.setSub(sub);
	            		ykyCgglDao.saveOrUpdate(cggl);
	            		System.out.println("-------------1------------>" + cggl);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	 private File getFile(MultipartFile imgFile, String brandName, List fileTypes) {
	        String fileName = imgFile.getOriginalFilename();
	        // 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
	        String ext = fileName.substring(fileName.lastIndexOf(".") + 1,
	                fileName.length());
	        // 对扩展名进行小写转换
	        ext = ext.toLowerCase();
	        File file = null;
	        if (fileTypes.contains(ext)) { // 如果扩展名属于允许上传的类型，则创建文件
	            file = this.creatFolder(brandName, fileName);
	            try {
	                imgFile.transferTo(file); // 保存上传的文件
	            } catch (IllegalStateException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return file;
	    }
	 
	 private File creatFolder(String brandName, String fileName) {
	        File file = null;
	        File firstFolder = new File(brandName);
	        String suffix = fileName.substring(fileName.lastIndexOf('.'));
	        String prefix = System.currentTimeMillis() + "";
	        String newfileName = prefix + suffix;
	        if (firstFolder.exists()) { // 如果一级文件夹存在，则检测二级文件夹
	            file = new File(brandName + "\\" + newfileName);
	        } else { // 如果一级不存在，则创建一级文件夹
	            firstFolder.mkdir();
	            file = new File(brandName + "\\" + newfileName);
	        }
	        return file;
	    }

	/**
	 * 保存
	 * @author liusong
	 * @version 2015年9月21日下午2:53:43
	 * @param entity
	 */
	@Transactional
	public void save(YkyCggl entity) {
		ykyCgglDao.save(entity);
	}

	/**
	 * 修改
	 * @author liusong
	 * @version 2015年9月21日下午2:54:11
	 * @param entity
	 * @param id 主键ID
	 */
	@Transactional
	public void update(YkyCggl entity, String id) {
		entity.setId(Integer.parseInt(id));
        ykyCgglDao.update(entity);
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
			ykyCgglDao.delete(ids[i]);
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
		 * 成果信息管理导入
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
	                        YkyCggl cggl = new YkyCggl();
	                        String kybh=getSV(hssfRow.getCell(0));
	                        cggl.setKybh(kybh);
	                        String kymc=getSV(hssfRow.getCell(1));
	                        cggl.setKymc(kymc);
	                        String kyxmnr=getSV(hssfRow.getCell(2));
	                        cggl.setKyxmnr(kyxmnr);
	                        String ssks=getSV(hssfRow.getCell(3));
	                        cggl.setSsks(ssks);
	                        String cyry=getSV(hssfRow.getCell(4));
	                        cggl.setCyry(cyry);
	                        String kssj=getSV(hssfRow.getCell(5));
	                        if(kssj != null && !("").equals(kssj)){
	                        	Date birthday = sdf.parse(kssj);   // String 转 Date
	                        	cggl.setKssj(birthday);
	                        }
	                        String jssj=getSV(hssfRow.getCell(6));
	                        if(jssj != null && !("").equals(jssj)){
	                        	Date birthday = sdf.parse(jssj);   // String 转 Date
	                        	cggl.setJssj(birthday);
	                        }
	                        String cglx=getSV(hssfRow.getCell(7));
	                        cggl.setCglx(cglx);
	                        String cgnr=getSV(hssfRow.getCell(8));
	                        cggl.setCgnr(cgnr);
	                        String bz=getSV(hssfRow.getCell(9));
	                        cggl.setBz(bz);
	                        ykyCgglDao.save(cggl);
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
		 * 成果管理信息导出
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月15日 上午10:19:22 
		 * 类说明 
		 */
		@Transactional
		public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
			List<Map<String,Object>> list=ykyCgglDao.getList(code);
			String[] header=new String[]{"科研编号","科研名称","科研项目内容","所属科室","参与人员","开始时间","结束时间","成果类型",
					"成果内容","备注"};
			String[] keys=new String[]{"KYBH","KYMC","KYXMNR","SSKS","CYRY","KSSJ","JSSJ","CGLX","CGNR","BZ"};
			ExportExcelUtil.exportExcel(request, response, header, keys, list);
		}

		/**
		 * 拉取修改内容
		 * @author liangkaidi
		 * @date 2015-11-27
		 * @param id
		 * @return
		 */
           @Transactional
			public List<Map<String, Object>> getXg(String id) {
				return ykyCgglDao.getList(id);
			}
/**
 * 数据字典
 * @author liangkaidi
 * @date 2016-1-20
 * @param string
 * @return
 */
           @Transactional
		public List<Map<String, Object>> getDicByList(String zdzl) {
			// TODO Auto-generated method stub
			return ykyCgglDao.getDicByList(zdzl);
		}
}
	


