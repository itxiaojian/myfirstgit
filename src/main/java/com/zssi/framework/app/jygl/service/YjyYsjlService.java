package com.zssi.framework.app.jygl.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyYsjlDao;
import com.zssi.framework.app.jygl.model.YjyYsjl;
import com.zssi.framework.app.util.AppUtil;

//检验原始记录service
//liusong 2016-03-09
@Service
public class YjyYsjlService extends BaseBO<YjyYsjl>{
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YjyYsjlDao ysjlDao;
	
	@Transactional
	public Pagination<Map<String, Object>> getYsjlList(Integer start,Integer limit,String code){
		return ysjlDao.getYsjlList(start, limit, code);
	}
	
	@Transactional
	public List<Map<String, Object>> getYsjl(String bid){
		return ysjlDao.getYsjl(bid);
	}
	
	//报告归档时用bgbh进行查询
	@Transactional
	public List<Map<String, Object>> getYsjlbyBgbh(String bgbh){
		return ysjlDao.getYsjlbyBgbh(bgbh);
	}
	
	@Transactional
	public List<Map<String, Object>> getYpjyzt(String zdzl){
		return ysjlDao.getYpjyzt(zdzl);
	}
	
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,YjyYsjl entity,HttpServletResponse actioncontext,HttpServletRequest request){
		
		String fileNameSuffix ="";  //文件后缀名
		String path = "";
		String re=null;
        String sub=null;
        String ysjlsjm = request.getParameter("ysjlsjm");
        String bgbh = request.getParameter("bgbh");
        String bz = request.getParameter("bz");
		String filename = "";   //文件名
		try {
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			//保存的文件在项目中的路径
			String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			List<String> fileTypes = new ArrayList<String>();
	        fileTypes.add("png");
	        fileTypes.add("jpg");
	        fileTypes.add("doc");
	        fileTypes.add("docx");
	        fileTypes.add("pdf");
	        List<String> fileTypes1 = new ArrayList<String>();
	        fileTypes1.add("png");
	        fileTypes1.add("jpg");
	        List<String> fileTypes2 = new ArrayList<String>();
	        fileTypes2.add("doc");
	        fileTypes2.add("docx");
	        List<String> fileTypes3 = new ArrayList<String>();
	        fileTypes3.add("pdf");
	            if(attachMentFile.isEmpty()&& bz==null){  
	                throw new RuntimeException("文件未上传");
	            }else if(attachMentFile.isEmpty()&& bz!=null){
	            	entity.setYsjlwjm(ysjlsjm);
	            	ysjlDao.saveOrUpdate(entity);
	            }else { 
	                filename = attachMentFile.getOriginalFilename();//文件原名
	                fileNameSuffix = filename.substring( filename.lastIndexOf('.')+1 );
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            sub=re.substring(re.lastIndexOf("\\")+1);
	        	            actioncontext.setContentType("text/html");
			            if(fileTypes1.contains(fileNameSuffix)){
			            	entity.setYsjllj(p);
			            	entity.setYsjlsjm(sub);
			            	entity.setYsjlwjm(sub);
			            	entity.setBz("1");
			            	entity.setBgbh(bgbh);
			            	entity.setYwysjl(0);
			            	entity.setScsj(Calendar.getInstance().getTime());
			            	entity.setScry(AppUtil.getCurrentUser().getXm());
			            	ysjlDao.saveOrUpdate(entity);
			            }else if(fileTypes2.contains(fileNameSuffix)){
			            	entity.setYsjllj(p);
			            	entity.setYsjlsjm(sub);
			            	entity.setYsjlwjm(sub);
			            	entity.setBz("2");
			            	entity.setBgbh(bgbh);
			            	entity.setYwysjl(0);
			            	entity.setScsj(Calendar.getInstance().getTime());
			            	entity.setScry(AppUtil.getCurrentUser().getXm());
			            	ysjlDao.saveOrUpdate(entity);
			            }else if(fileTypes3.contains(fileNameSuffix)){
			            	entity.setYsjllj(p);
			            	entity.setYsjlsjm(sub);
			            	entity.setYsjlwjm(sub);
			            	entity.setBz("3");
			            	entity.setBgbh(bgbh);
			            	entity.setYwysjl(0);
			            	entity.setScsj(Calendar.getInstance().getTime());
			            	entity.setScry(AppUtil.getCurrentUser().getXm());
			            	ysjlDao.saveOrUpdate(entity);
			            }
	            } 
	            		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			}
		}
	
	
	@Transactional					
	public void UploadMaterial(YjyYsjl entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		MultipartFile attachMentFile=request.getFile("attachMentFile");
		String fileNameSuffix ="";  //文件后缀名
		String path = "";
		String re=null;
        String sub=null;
        String ysjlsjm = request.getParameter("ysjlsjm");
        String bgbh = request.getParameter("bgbh");
        String bz = request.getParameter("bz");
		String filename = "";   //文件名
		try {
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			//保存的文件在项目中的路径
			String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			List<String> fileTypes = new ArrayList<String>();
	        fileTypes.add("png");
	        fileTypes.add("jpg");
	        fileTypes.add("doc");
	        fileTypes.add("docx");
	        fileTypes.add("pdf");
	        List<String> fileTypes1 = new ArrayList<String>();
	        fileTypes1.add("png");
	        fileTypes1.add("jpg");
	        List<String> fileTypes2 = new ArrayList<String>();
	        fileTypes2.add("doc");
	        fileTypes2.add("docx");
	        List<String> fileTypes3 = new ArrayList<String>();
	        fileTypes3.add("pdf");
	            if(attachMentFile.isEmpty()&& bz!=null){
	            	entity.setYsjlwjm(ysjlsjm);
	            	ysjlDao.saveOrUpdate(entity);
	            }else { 
	                filename = attachMentFile.getOriginalFilename();//文件原名
	                fileNameSuffix = filename.substring( filename.lastIndexOf('.')+1 );
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            sub=re.substring(re.lastIndexOf("\\")+1);
	        	            actioncontext.setContentType("text/html");
			            if(fileTypes1.contains(fileNameSuffix)){
			            	entity.setYsjllj(p);
			            	entity.setYsjlsjm(sub);
			            	entity.setYsjlwjm(sub);
			            	entity.setBz("1");
			            	entity.setBgbh(bgbh);
			            	entity.setYwysjl(0);
			            	entity.setScsj(Calendar.getInstance().getTime());
			            	entity.setScry(AppUtil.getCurrentUser().getXm());
			            	ysjlDao.saveOrUpdate(entity);
			            }else if(fileTypes2.contains(fileNameSuffix)){
			            	entity.setYsjllj(p);
			            	entity.setYsjlsjm(sub);
			            	entity.setYsjlwjm(sub);
			            	entity.setBz("2");
			            	entity.setBgbh(bgbh);
			            	entity.setYwysjl(0);
			            	entity.setScsj(Calendar.getInstance().getTime());
			            	entity.setScry(AppUtil.getCurrentUser().getXm());
			            	ysjlDao.saveOrUpdate(entity);
			            }else if(fileTypes3.contains(fileNameSuffix)){
			            	entity.setYsjllj(p);
			            	entity.setYsjlsjm(sub);
			            	entity.setYsjlwjm(sub);
			            	entity.setBz("3");
			            	entity.setBgbh(bgbh);
			            	entity.setYwysjl(0);
			            	entity.setScsj(Calendar.getInstance().getTime());
			            	entity.setScry(AppUtil.getCurrentUser().getXm());
			            	ysjlDao.saveOrUpdate(entity);
			            }
	            } 
	            		
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
//	            file = new File("C:\\Users\\Administrator\\Desktop\\20160225.png");
	            file = new File(brandName + "\\"+ newfileName);
//	            System.out.println("====111========"+brandName + "\\"+ newfileName);
	            
	        } else { // 如果一级不存在，则创建一级文件夹
	            firstFolder.mkdir();
	            file = new File(brandName + "\\" + newfileName);
	        }
	        return file;
	    }
	 
	 @Transactional
		public List<Map<String, Object>> getDicByLx(String zdzl) {
			return ysjlDao.getDicByLx(zdzl);
		}
	 
	 @Transactional
		public List<Map<String, Object>> getImageList(String id) {
			return ysjlDao.getImageList(id);
		}
	 
	 @Transactional
		public void delete(Integer[] ids) {
			for(int i=0;i<ids.length;i++){
				ysjlDao.delete(ids[i]);
			}
		}

}
