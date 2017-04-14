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
import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sfwgl.dao.YsfwFwxxDao;
import com.zssi.framework.app.sfwgl.dao.YsfwHfbDao;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.sfwgl.model.YsfwHfb;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;
import com.zssi.framework.app.yhgl.model.SysYhxx;

@Service
public class YsfwFwxxService extends BaseBO<YsfwFwxx>{
	@Autowired
	private YsfwFwxxDao ysfwFwxxDao;
	
	@Autowired
	private YsfwHfbDao ysfwHfbDao;
	
	@Autowired
	private SysYhDao sysYhDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	public Pagination<Map<String, Object>> getFwxxList( Integer start, Integer limit,String code) {
		
		return ysfwFwxxDao.getFwxxList(start, limit, code);
			
		}
	
//	@Transactional
//	public void save(YsfwFwxx entity) {
//		SysYh yh =AppUtil.getCurrentUser();
//		entity.setFwr(yh.getXm());
//		ysfwFwxxDao.save(entity);
//	}
	
	@Transactional
	public YsfwFwxx getFwxxById(Integer id) {
		YsfwFwxx entity = ysfwFwxxDao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}	
	@Transactional
	public void update(YsfwFwxx entity,String ID){
		entity.setId(Integer.parseInt(ID));
		ysfwFwxxDao.update(entity);
	}
	
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ysfwFwxxDao.delete(ids[i]);
		}
	}
	
	/**
	 * 上传附件
	 * @author liangkaidi
	 * @date 2015-10-28
	 * @param attachMentFile
	 * @param fwxx
	 * @param actioncontext
	 * @param request
	 */
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,YsfwFwxx fwxx ,HttpServletResponse actioncontext,HttpServletRequest request){
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
	            		SysYh yh =AppUtil.getCurrentUser();
	            		fwxx.setFwr(yh.getXm());
//	            		rztb.setFjlj(p);
//	            		rztb.setSub(sub);
	            		ysfwFwxxDao.saveOrUpdate(fwxx);
	            		
//	            		ysfwFwxxDao.save(fwxx);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	

	
	/**
	 * 向消息回复中保存数据
	 * @author liangkaidi
	 * @date 2015-10-31
	 * @param attachMentFile
	 * @param hfb
	 * @param actioncontext
	 * @param request
	 */
	
	@Transactional					
	public void UploadMaterial(MultipartFile attachMentFile,YsfwHfb hfb ,HttpServletResponse actioncontext,HttpServletRequest request){
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
//	            		fwxx.setFj(filename);//文件原名
//	            hfb.setFj(filename);
	            		SysYh yh =AppUtil.getCurrentUser();
	            		hfb.setHfr(yh.getXm());
//	            		ysfwHfbDao.save(hfb );
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
	 * 客户信息增加提交
	 * @author liangkaidi
	 * @date 2015-11-23
	 * @param request
	 * @param entity
	 * @return
	 */
	 
	 
	@Transactional
	public String saveRb(HttpServletRequest request, YsfwFwxx entity) {
		String str="";
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
		 SysYh yh =AppUtil.getCurrentUser();
              YsfwFwxx fwxx=new YsfwFwxx();
		String sjr = request.getParameter("sjr");
		String cs = request.getParameter("cs");
		String zt = request.getParameter("zt");
		String zw = request.getParameter("zw");
		String fj = request.getParameter("fj");
		String fwr = request.getParameter("fwr");
		String bmbh = request.getParameter("bmbh");
		String fssj = request.getParameter("fssj");
		Date qyrq = null;
		 if(fssj != null && !("").equals(fssj)){// String 转 Date
			 try {
				qyrq = sdf.parse(fssj);
			} catch (ParseException e) {
				e.printStackTrace();
			}
         	fwxx.setFssj(qyrq);
         }
		entity.setFwr(yh.getXm());
		entity.setSjr(sjr);
		entity.setCs(cs);
		entity.setZt(zt);
		entity.setZw(zw);
		entity.setFj(fj);
		entity.setFwr(fwr);
		entity.setBmbh(bmbh);
		entity.setFssj(qyrq);
		ysfwFwxxDao.save(entity);
		str="1";
		return str;
	}

		/**
		 * 点击查看拉取内容
		 * @author liangkaidi
		 * @date 2015-11-11
		 * @param id
		 * @return
		 */		

		
	@Transactional
		public YsfwFwxx getXg(String id) {
			return ysfwFwxxDao.get(Integer.parseInt(id));
		}

	/**
	 * 发文页面————用户信息
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param code
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYh(String code){
		return sysYhDao.getYh(code);
	}
	
	

	/**
	 * 发文页面————用户信息
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param code
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYhCs(String code){
		return sysYhDao.getYhCs(code);
	}
	/**
	 * 发文页面拉取用户信息
	 * @author liangkaidi
	 * @date 2015-11-30
	 * @param yhbh
	 * @return
	 */
@Transactional
	public SysYhxx getyhmc(String yhbh) {
		return sysYhDao.get(Integer.parseInt(yhbh));
	}
	 
/**
 * 发文页面拉取用户信息
 * @author liangkaidi
 * @date 2015-11-30
 * @param yhbh
 * @return
 */

@Transactional
public SysYhxx getyhmcCs(String yhbh) {
	// TODO Auto-generated method stub
	return sysYhDao.get(Integer.parseInt(yhbh));
}

@Transactional
public List<Map<String, Object>> getYhb(String code) {
	// TODO Auto-generated method stub
	return sysYhDao.getYhb(code);
}

@Transactional
	public SysYhxx getyh(String yhbh){
		return sysYhDao.get(Integer.parseInt(yhbh));
	}

//@Transactional
//public SysYhxx getclyy(String yhbh) {
//	// TODO Auto-generated method stub
//	return sysYhDao.get(Integer.parseInt(yhbh));
//}
}
