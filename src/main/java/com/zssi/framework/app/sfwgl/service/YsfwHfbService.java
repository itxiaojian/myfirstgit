package com.zssi.framework.app.sfwgl.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.zssi.framework.app.sfwgl.dao.YsfwHfbDao;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.sfwgl.model.YsfwHfb;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Service
public class YsfwHfbService  extends BaseBO<YsfwHfb>{
	@Autowired
	private YsfwHfbDao ysfwHfbDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	 
	public Pagination<Map<String, Object>> getHfbList( Integer start, Integer limit,String code) {
		
		return ysfwHfbDao.getHfbList(start, limit, code);
			
		}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * 增加
	 */
//	@Transactional
//	public void save(YsfwHfb entity,String filename ) {
////		SysYh yh =AppUtil.getCurrentUser();
////		entity.setHfr(yh.getXm());
//		entity.setFj(filename);
//		ysfwHfbDao.save(entity);
//	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * @param ID
	 * 修改
	 */
	@Transactional
	public void update(YsfwHfb entity,String ID){
		entity.setId(Integer.parseInt(ID));
		ysfwHfbDao.update(entity);
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param ids
	 * 删除
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ysfwHfbDao.delete(ids[i]);
		}
}
	
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,YsfwHfb fwxx ,HttpServletResponse actioncontext,HttpServletRequest request){
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
	        fileTypes.add("doc");
	        fileTypes.add("pdf");
	        fileTypes.add("txt");
	        fileTypes.add("class");
	        fileTypes.add("psc");
	        fileTypes.add("xls");
	        
//    判断附件是否为空     
   /*if(attachMentFile.isEmpty()){  
	                throw new RuntimeException("文件未上传");
	            }else{  
	                filename = attachMentFile.getOriginalFilename();//文件原名
	                fileNameSuffix = filename.substring( filename.lastIndexOf('.')+1 );
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            actioncontext.setContentType("text/html");
	            } */ 
	            
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
	            		fwxx.setFj(filename);//文件原名
	            	/*	SysYh yh =AppUtil.getCurrentUser();
	            		fwxx.setFwr(yh.getXm());*/
//	            		rztb.setFjlj(p);
//	            		rztb.setSub(sub);
	            		ysfwHfbDao.saveOrUpdate(fwxx);
	            		
//	            		ysfwFwxxDao.save(fwxx);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	/*@Transactional					
	public void UploadImageMaterial(YsfwHfb entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		MultipartFile attachMentFile=request.getFile("attachMentFile");
		String filename = "";       //文件名
		String re=null;
        String sub=null;
		String path = "";
		
		try {
			//FileInputStream fileInputStream = new FileInputStream(attachMentFile.toString());
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			//保存的文件在项目中的路径
			String p = path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			
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
	        if(attachMentFile != null){
				filename = attachMentFile.getOriginalFilename();
	            File file = this.getFile(attachMentFile, path, fileTypes);
	            re=file.toString();
	            sub=re.substring(re.lastIndexOf("\\")+1);
	            actioncontext.setContentType("text/html");
				entity.setFj(filename);
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
	            result = WeixinUtils.uploadMedia("image", path+File.separator+fileNameU);
	            System.out.println("微信服务器返回结果："+result);
	            	
	            //保存到数据库
//			            生成二维码编号url
	            		ysfwHfbDao.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}*/
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
	 * 回复信息增加提交
	 * @author liangkaidi
	 * @date 2015-11-23
	 * @param request
	 * @param entity
	 * @return
	 */
	 
	 
	@Transactional
	public String saveRb(HttpServletRequest request, YsfwHfb entity) {
		String str="";
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
		 SysYh yh =AppUtil.getCurrentUser();
		 YsfwHfb hfxx=new YsfwHfb();
		String hfbr = request.getParameter("hfbr");
		
		String zt = request.getParameter("zt");
		String hfr = request.getParameter("hfr");
		String fj = request.getParameter("fj");
		
		String hfsj = request.getParameter("hfsj");
		Date qyrq = null;
		 if(hfsj != null && !("").equals(hfsj)){// String 转 Date
			 try {
				qyrq = sdf.parse(hfsj);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 hfxx.setHfsj(qyrq);
         }
		entity.setHfr(yh.getXm());
		entity.setHfbr(hfbr);
		entity.setHfr(hfr);
		entity.setHfsj(qyrq);
		entity.setFj(fj);
		ysfwHfbDao.save(entity);
		str="1";
		return str;
	}
	/**
		 * 点击修改拉取内容
		 * @author liangkaidi
		 * @date 2015-11-11
		 * @param id
		 * @return
		 */		
	@Transactional
	public YsfwHfb getXg(String id) {
		return ysfwHfbDao.get(Integer.parseInt(id));
	}
	
	
		
	}



