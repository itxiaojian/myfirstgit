package com.zssi.framework.app.yhgl.service; 


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
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
import com.likegene.framework.core.SettingUtil;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sys.model.SysZzjg;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.yhgl.model.SysYhxx;
import com.zssi.framework.app.yhgl.dao.SysYhDao;

/** 
 * 用户管理service类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:06:59 
 * 类说明 
 */
@Service
public class SysYhService extends BaseBO<SysYhxx>{
	
	@Autowired
	private SysYhDao sysYhDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	/** 
	 * 系统用户信息分页查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@Transactional
	public Pagination<Map<String, Object>> getSysyhList(Integer start,Integer limit,String code){
		
		return sysYhDao.getSysyhList(start, limit, code);
	}
	
	/** 
	 * 预登记信息分页查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@Transactional
	public Pagination<Map<String, Object>> getYdjyhList(Integer start,Integer limit,String code){
		
		return sysYhDao.getYdjyhList(start, limit, code);
	}
	
	/** 
	 * 更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@Transactional
	public void update(SysYhxx entity,String yhbh){
		entity.setYhbh(Integer.parseInt(yhbh));
		sysYhDao.update(entity);
	}
	
	/** 
	 * 删除
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			sysYhDao.delete(ids[i]);
		}
	}
	
	/** 
	 * 下拉框数据字典查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return sysYhDao.getDicByLx(zdzl);
	}
	
	
//	报告归档时查询档案类目
	@Transactional
	public List<Map<String, Object>> getKckr(String xm,String bmmc) {
		return sysYhDao.getKckr(xm,bmmc);
	}
	
//	点击选择后查出改id下人员信息并返回页面
	@Transactional
	public List<Map<String, Object>> getKckrById(Integer yhbh) {
		return sysYhDao.getKckrById(yhbh);
	}
	
	/**
	 * liusong 
	 * 上传电子签名
	 */
	@Transactional					
	public void UploadImageMaterial(MultipartFile attachMentFile,SysYhxx yhxx,SysZzjg zzjg,HttpServletResponse actioncontext,HttpServletRequest request){
		
		String fileNameSuffix ="";  //文件后缀名
		String fileNameU = "";
		String path = "";
		String re=null;
        String sub=null;
		String filename = "";   //文件名
		String bmmc = request.getParameter("bmmc");
		String jbm1 = request.getParameter("jbm1");
		String jbm2 = request.getParameter("jbm2");
		String jbm3 = request.getParameter("jbm3");
		String jbm4 = request.getParameter("jbm4");
		String yhbh = request.getParameter("yhbh");
		String dlm = request.getParameter("dlm");
//		SysYhxx yh = sysYhDao.get(Integer.parseInt(yhbh));
//		根据部门名称查出部门编号并set进去
		List<Map<String,Object>> bmmc1 = sysYhDao.getbmbh(bmmc);
		String bmbh = bmmc1.get(0).get("bmbh").toString();
		if(jbm1!=null&&!"".equals(jbm1)){
			jbm1= sysYhDao.getbmbh(jbm1).get(0).get("bmbh").toString();
		}
		if(jbm2!=null&&!"".equals(jbm2)){
			jbm2= sysYhDao.getbmbh(jbm2).get(0).get("bmbh").toString();
		}
		if(jbm3!=null&&!"".equals(jbm3)){
			jbm3= sysYhDao.getbmbh(jbm3).get(0).get("bmbh").toString();
		}
		if(jbm4!=null&&!"".equals(jbm4)){
			jbm4= sysYhDao.getbmbh(jbm4).get(0).get("bmbh").toString();
		}
		try {
			path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
		        	+ File.separator +"home";
			//保存的文件在项目中的路径
			String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
			List<String> fileTypes = new ArrayList<String>();
	        fileTypes.add("png");
//	        如果上传文件为空且登录名为空，不执行保存
	            if(attachMentFile.isEmpty() && request.getParameter("dlm") == null ){  
	                throw new RuntimeException("文件未上传");
//	                如果上传文件为空且登录名不为空，执行保存，下面还有两种情况：一是用户修改（上传文件为空，判断有无yhbh），二是新增用户未上传
	            }else if(attachMentFile.isEmpty() && request.getParameter("dlm") != null ){ 
	            	        String qm = yhxx.getDzqmlj();
//	            	        如果yhbh为空，则为新增用户
	            	        if(yhbh==null){
	            	        	yhxx.setMm(md5PasswordEncoder.encodePassword(
	    	            				(String) SettingUtil.getSetting("default.password", null),
	    	            				yhxx.getDlm()));
	    	            		yhxx.setYhzt(1);
	            	        	sysYhDao.saveOrUpdate(yhxx);
//	            	        	如果签名不为空，则为老用户修改
	            	        }else if(qm != null&&!"".equals(qm)){
//	     	    	            yhxx.setYhzt(1);
	            	        	yhxx.setBmbh(bmbh);
	            	        	yhxx.setJbm1(jbm1);
	            	        	yhxx.setJbm2(jbm2);
	            	        	yhxx.setJbm3(jbm3);
	            	        	yhxx.setJbm4(jbm4);
	            	        	yhxx.setDzqm(dlm+".png");
	            	        	sysYhDao.update(yhxx);
	            	        	}else{
//	            	        		上传文件为空且登录名不为空的此外情况，貌似不走这块
	            	        	if(yhxx.getMm()==null||"".equals(yhxx.getMm())){
	            	        	yhxx.setMm(md5PasswordEncoder.encodePassword(
	    	            				(String) SettingUtil.getSetting("default.password", null),
	    	            				yhxx.getDlm()));
	            	        	}
	            	        	yhxx.setBmbh(bmbh);
	            	        	yhxx.setJbm1(jbm1);
	            	        	yhxx.setJbm2(jbm2);
	            	        	yhxx.setJbm3(jbm3);
	            	        	yhxx.setJbm4(jbm4);
//	    	            		yhxx.setYhzt(1);
	            	        	sysYhDao.update(yhxx);
	            	        }
	            } else{
//	            	大条件下的此外情况，即是有上传文件的，直接执行新增保存or修改
	                filename = attachMentFile.getOriginalFilename();//文件原名
	                fileNameSuffix = filename.substring( filename.lastIndexOf('.')+1 );
	        	            File file1 = this.getFile(attachMentFile, path, fileTypes);
	        	            re=file1.toString();
	        	            sub=re.substring(re.lastIndexOf("\\")+1);
	        	            actioncontext.setContentType("text/html");
			            //拼装上传路径
			            //文件名称 （登录名+原文件后缀名）
			            fileNameU = request.getParameter("dlm") +"."+fileNameSuffix;
	            		yhxx.setDzqm(fileNameU);//登录名.png来命名电子签名
	            		yhxx.setDzqmlj(p);
	            		if(yhxx.getMm()==null||"".equals(yhxx.getMm())){
	            			yhxx.setMm(md5PasswordEncoder.encodePassword(
	            					(String) SettingUtil.getSetting("default.password", null),
	            					yhxx.getDlm()));
	            		}
//	            		yhxx.setYhzt(1);
	            		yhxx.setYhjs(sub);
	                    yhxx.setBmbh(bmbh);
	                    yhxx.setJbm1(jbm1);
        	        	yhxx.setJbm2(jbm2);
        	        	yhxx.setJbm3(jbm3);
        	        	yhxx.setJbm4(jbm4);
	            		sysYhDao.saveOrUpdate(yhxx);
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
	            this.scale(file);
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
	 
	 
	 /**
	 * 将一个图片缩放
	 */
	 public void scale(File file) {
	        BufferedImage src = null; // java.awt.image 包下的
	        Image image = null; // 抽象类 Image 是表示图形图像的所有类的超类。 java.awt 包下的
	        BufferedImage tag = null;
	        String type="png";
	        String a= file.getName();
	        System.out.println("=========2222"+a);
	        String path = file.getPath();
	        System.out.println("-----------------12------------->"+path);
	        try {
	        	src = ImageIO.read(new File(path)); // 读入文件
	        	if (src != null) {
	        		int width = src.getWidth(); // 得到源图宽
	                int height = src.getHeight(); // 得到源图长
	                width = 120; // 设置新图片的宽度
	                height = 55; // 设置新图片的长度
	                image = src.getScaledInstance(width, height,Image.SCALE_DEFAULT);
	                tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	                Graphics g = tag.getGraphics();
	                g.drawImage(image, 0, 0, null); // 绘制缩小后的图
	                g.dispose();
	                ImageIO.write(tag, type, new File(path));// 输出到文件流
	                }
	        	} catch (IOException e) {
	        		e.printStackTrace();
	        		}  finally {
	        			if (src != null) {
	        				src.flush();
	        				image.flush();
	        				tag.flush();
	        				}
	        			}
	        } 
	
	
	//正则表达式判断导入信息类型
			@Transactional
			private String validate(Row row) {
//		        String v = getSV(row.getCell(0));
//		        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
//		            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//		        }
		        return null;
		    }

			/** 
			 * 获取当前exl表格内容
			 * @author liusong E-mail: 2629690209@qq.com
			 * @version 创建时间：2015年11月11日 上午10:19:22 
			 * 方法说明 
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
			 * 上传exl表格内容
			 * @author liusong E-mail: 2629690209@qq.com
			 * @version 创建时间：2015年11月11日 上午10:19:22 
			 * 方法说明 
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
		                        SysYhxx yhxx = new SysYhxx();
		                        
		                        String dlm=getSV(hssfRow.getCell(0));
		                        yhxx.setDlm(dlm);
		                        
		                        String xm=getSV(hssfRow.getCell(1));
		                        yhxx.setXm(xm);
		                        
		                        String mm= md5PasswordEncoder.encodePassword(
		                				(String) SettingUtil.getSetting("default.password", null),yhxx);
		                        yhxx.setMm(mm);
		                        
		                        String yhzt=getSV(hssfRow.getCell(2));
		                        if(yhzt != null && !("").equals(yhzt)){
		                        	Double xbNumber = Double.parseDouble(yhzt);    //String 转 Integer
		                        	int zt = xbNumber.intValue();
		                        	yhxx.setYhzt(zt);
		                        }
		                        
		                        String bmmc=getSV(hssfRow.getCell(3));
		                        yhxx.setBmmc(bmmc);
		                        List<Map<String,Object>> bmmc1 = sysYhDao.getbmbh(bmmc);
		                		for (int i=0;i<bmmc1.size();i++){
		                	        Map<String, Object> map=(Map<String, Object>)bmmc1.get(i);
		                	        Iterator<String> iterator = map.keySet().iterator();
		                            while (iterator.hasNext())
		                            {
		                                String key = (String)iterator.next();
		                                Object bgbhObj = map.get(key);
		                				String bmbh = bgbhObj.toString();
		                             yhxx.setBmbh(bmbh);
		                             }
		                            }
		                        String zw=getSV(hssfRow.getCell(4));
		                        yhxx.setZw(zw);
		                        String glfw=getSV(hssfRow.getCell(5));
		                        yhxx.setGlfw(glfw);
		                        String yhpxh=getSV(hssfRow.getCell(6));
		                        if(yhpxh != null && !("").equals(yhpxh)){
		                        	Double xbNumber = Double.parseDouble(yhpxh);    //String 转 Integer
		                        	int pxh = xbNumber.intValue();
		                        	yhxx.setYhpxh(pxh);
		                        }
		                        String cyzt=getSV(hssfRow.getCell(7));
		                        if(cyzt != null && !("").equals(cyzt)){
		                        	Double xbNumber = Double.parseDouble(cyzt);    //String 转 Integer
		                        	int zt = xbNumber.intValue();
		                        	yhxx.setCyzt(zt);
		                        }
		                        String sgzbh=getSV(hssfRow.getCell(8));
		                        yhxx.setSgzbh(sgzbh);
		                        
		                        String xb=getSV(hssfRow.getCell(9));
		                        if(xb != null && !("").equals(xb)){
		                        	Double xbNumber = Double.parseDouble(xb);    //String 转 Integer
		                        	int zt = xbNumber.intValue();
		                        	yhxx.setXb(zt);
		                        }
		                        String sr=getSV(hssfRow.getCell(10));
		                        if(sr != null && !("").equals(sr)){
		                        	Date birthday = sdf.parse(sr);   // String 转 Date
		                        	yhxx.setSr(birthday);
		                        }
		                        String mz=getSV(hssfRow.getCell(11));
		                        yhxx.setMz(mz);
		                        String zzmm=getSV(hssfRow.getCell(12));
		                        yhxx.setZzmm(zzmm);
		                        String sjh=getSV(hssfRow.getCell(13));
		                        yhxx.setSjh(sjh);
		                        String lxdh=getSV(hssfRow.getCell(14));
		                        yhxx.setLxdh(lxdh);
		                        String yx=getSV(hssfRow.getCell(15));
		                        yhxx.setYx(yx);
		                        String qq=getSV(hssfRow.getCell(16));
		                        yhxx.setQq(qq);
		                        String xl=getSV(hssfRow.getCell(17));
		                        yhxx.setXl(xl);
		                        String byyx=getSV(hssfRow.getCell(18));
		                        yhxx.setByyx(byyx);
		                        String bm=getSV(hssfRow.getCell(19));
		                        yhxx.setBm(bm);
		                        String jtdz=getSV(hssfRow.getCell(20));
		                        yhxx.setJtdz(jtdz);
		                        sysYhDao.save(yhxx);
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
			 * 点击查看电子签名获取图片
			 * @return
			 */
			@Transactional
			public List<Map<String, Object>> getImageList(String dlm) {
				return sysYhDao.getImageList(dlm);
			}
			
			/** 
			 * 导出信息至exl表格
			 * @author liusong E-mail: 2629690209@qq.com
			 * @version 创建时间：2015年11月11日 上午10:19:22 
			 * 方法说明 
			 */
			@Transactional
			public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
				if(code!=null&&!"".equals(code)){
					code=java.net.URLDecoder.decode(code,"UTF-8");
					}
				List<Map<String,Object>> list=sysYhDao.getList(code);
				String[] header=new String[]{"登录名","用户名","部门","职务","管理范围","用户排序号","是否持有上岗证（0；持有；1：未持有）","上岗证编号","状态（0：已删除；1：启用；2：禁用）",
						"性别（0：男；1：女）","生日","民族","政治面貌","手机号","联系电话","邮箱","QQ","学历","毕业院校","别名","家庭地址"};
				String[] keys=new String[]{"DLM","XM","BMMC","ZW","GLFW","YHPXH","CYZT","SGZBH","YHZT","XB","SR","MZ","ZZMM","SJH","LXDH","YX","QQ","XL","BYYX","BM","JTDZ"};
				ExportExcelUtil.exportExcel(request, response, header, keys, list);
			}
			
			@Transactional
			public void exportydj(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
				if(code!=null&&!"".equals(code)){
					code=java.net.URLDecoder.decode(code,"UTF-8");
					}
				List<Map<String,Object>> list=sysYhDao.getydjList(code);
				String[] header=new String[]{"登录名","客户姓名","客户分类","状态（0：已删除；1：启用；2：禁用）","生日","联系电话","邮箱","QQ"};
				String[] keys=new String[]{"DLM","XM","KHFL","YHZT","SR","SJH","YX","QQ"};
				ExportExcelUtil.exportExcel(request, response, header, keys, list);
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
			public void delete(String dlm) {
					sysYhDao.delete(dlm);
			}
			
			/**
			 * 档案信息查看
			 * @author liangkaidi
			 * @date 2016-1-8
			 * @param id
			 * @return
			 */
			@Transactional
			public List<Map<String, Object>> getCk(String yhbh) {
				return sysYhDao.getrydaxx(yhbh);
			}
	
}
