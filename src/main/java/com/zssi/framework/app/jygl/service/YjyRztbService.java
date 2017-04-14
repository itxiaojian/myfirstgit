package com.zssi.framework.app.jygl.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyRztbDao;
import com.zssi.framework.app.jygl.model.YjyRztb;
import com.zssi.framework.app.mass.dao.AttachMentDao;
import com.zssi.framework.app.support.file.FileCommonOperate;
import com.zssi.framework.app.support.random.RandomUtil;

/**
 * 检验认证图标
 * @author duanpeijun
 * @date 2015年10月15日
 */
@Service
public class YjyRztbService {

	@Value("${file.store.path}")
	private String filePath;
	
	@Autowired
	private YjyRztbDao dao;
	
	@Autowired
	private AttachMentDao attachMentDao;
	
	/**
	 * 后台：检验认证图标
	 * @author duanpeijun
	 * @date 2015年10月15日
	 * @param start
	 * @param limit
	 * @param rzmc  认证名称
	 * @return
	 */
	public Pagination<Map<String, Object>> getRztbList(Integer start,Integer limit,String rzmc){
		return dao.getRztbList(start, limit, rzmc);
	}
	
	/**
	 * 上传图片素材
	 */
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,YjyRztb rztb,HttpServletResponse actioncontext,HttpServletRequest request){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String date = sdf.format(new Date());		//当前日期格式化到秒
		String random = RandomUtil.generateWord();	//获得随机数
		String filename = "";       //文件名（带后缀名）
		String file = "";           //文件名（不带后缀名）
		String fileNameSuffix ="";  //文件后缀名
//		String result = "";
		String fileNameU = "";
//		String mediaId = "";
		String path = "";
		InputStream inputStream = null;
		String re=null;
        String sub=null;
		
		try {
			//FileInputStream fileInputStream = new FileInputStream(attachMentFile.toString());
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			List<String> fileTypes = new ArrayList<String>();
	        fileTypes.add("jpg");
	        fileTypes.add("jpeg");
	        fileTypes.add("bmp");
	        fileTypes.add("gif");
	        fileTypes.add("png");
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
	                String[] a = filename.split("\\.");      
//	                System.out.println("----1--->"+a[0]);
	                file = a[0];
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            //int i=re.lastIndexOf("\\");
	        	            sub=re.substring(re.lastIndexOf("\\")+1);
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
	            		rztb.setRzmc(file);//文件原名
	            		rztb.setFjlj(p);
	            		rztb.setSub(sub);
						dao.save(rztb);
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
	 * 取得素材表中3天内的图片列表(上传的素材大于3天微信平台将会删除)
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getImageList(String id) {
		return dao.getImageList(id);
	}
	
	/**
	 * 认证分类（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getDicByRzfl(String zdzl) {
		return dao.getDicByRzfl(zdzl);
	}
	
	/**
	 * 删除认证图标
	 * @param id
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
}
