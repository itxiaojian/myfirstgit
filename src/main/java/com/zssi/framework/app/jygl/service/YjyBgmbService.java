package com.zssi.framework.app.jygl.service;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyBgmbDao;
import com.zssi.framework.app.jygl.model.YjyBgmb;
import com.zssi.framework.app.process.support.file.FileCommonOperate;
import com.zssi.framework.app.support.random.RandomUtil;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * 检验报告模版
 * @author duanpeijun
 * @date 2015年10月13日
 */
@Service
public class YjyBgmbService extends BaseBO<YjyBgmbDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	@Autowired
	private YjyBgmbDao dao;
	
	/**
	 * 后台：检验报告模版
	 * @author duanpeijun
	 * @date 2015年10月13日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getBgmbList(Integer start,Integer limit,String canshu){
		return dao.getBgmbList(start, limit, canshu);
	}
	
	/**
	 * 增加
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 */
	@Transactional
	public void save(YjyBgmb entity) {
		dao.save(entity);
	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjyBgmb entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
	
	
	/**
	 * liusong 15-11-17 
	 * 上传模板
	 */
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,YjyBgmb bgmb,HttpServletResponse actioncontext,HttpServletRequest request){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String date = sdf.format(new Date());		//当前日期格式化到秒
		String random = RandomUtil.generateWord();	//获得随机数
		String filename = "";       //文件名（带后缀名）
		String file = "";           //文件名（不带后缀名）
		String fileNameSuffix ="";  //文件后缀名
		String fileNameU = "";
		String path = "";
		InputStream inputStream = null;
		String re=null;
		SysYh xzr =AppUtil.getCurrentUser();
		Date xzsj = new Date();
        String sub=null;
		
		try {
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			String p = path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			List<String> fileTypes = new ArrayList<String>();
	        fileTypes.add("doc");
	        fileTypes.add("docx");
	            if(attachMentFile.isEmpty()){  
	                throw new RuntimeException("文件未上传");
	            }else{  
	                filename = attachMentFile.getOriginalFilename();//文件原名
	                fileNameSuffix = filename.substring( filename.lastIndexOf('.') );
	                System.out.println("文件后缀名："+fileNameSuffix);
	                String[] a = filename.split("\\.");      
	                file = a[0];
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            sub = re.substring(re.lastIndexOf("\\")+1);
	        	            actioncontext.setContentType("text/html");
	            }  
	                    bgmb.setMbmc(file);//文件原名
	                    bgmb.setMbdz(p);
	                    bgmb.setXzr(xzr.getXm());
	                    bgmb.setXzsj(xzsj);
	                    bgmb.setSub(sub);
	            		dao.saveOrUpdate(bgmb);
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
		 * liusong 15-11-17
		 * 模板类型、模板类别下拉框
		 * @return
		 */
	 @Transactional
		public List<Map<String, Object>> getDicByLx(String zdzl) {
			return dao.getDicByLx(zdzl);
		}

}
