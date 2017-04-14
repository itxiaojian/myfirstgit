package com.zssi.framework.app.sbgl.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.dao.YsbXxDao;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;

@Service
public class YsbXxService extends BaseBO<YsbXx>{

	@Autowired
	private YsbXxDao ySbXxDao;
	
	@Autowired
	private SysYhDao sysYhDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	
	/**
	 * 后台：设备信息
	 * @author liusong
	 * @date 2015年9月21日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getSbxxList(Integer start,Integer limit,String code){
		
		return ySbXxDao.getSbxxList(start, limit, code);
		
	}
	
	/**
	 * 微信平台设备信息查询
	 * @author liusong
	 * @date 2015年11月16日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getSb(){
		return ySbXxDao.getList2(null);
	}
	
	/**
	 * 根据设备编号获取设备信息生成二维码
	 * @author duanpeijun
	 * @date 2015年12月01日
	 * @param sbbh
	 * @return
	 */
	public List<Map<String, Object>> getSbewm(String sbbh) {
		return ySbXxDao.getSbewm(sbbh);
	}
	
	/**
	 * 
	 * @author duanpeijun
	 * @date 2015年10月29日
	 * @param id
	 * @return
	 */
	@Transactional
	public YsbXx getSbxxById(Integer id) {
		YsbXx entity = ySbXxDao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}	
	

//	/**
//	 * 保存
//	 * @author liusong
//	 * @version 2015年9月21日下午2:53:43
//	 * @param entity
//	 */
//	@Transactional
//	public void save(YsbXx entity) {
//		ySbXxDao.save(entity);
//	}
	
	
	/**
	 * 上传附件保存
	 * @author liusong
	 * @date 2015-10-28
	 * @param attachMentFile
	 * @param fwxx
	 * @param actioncontext
	 * @param request
	 */
	@Transactional					
	public void UploadImageMaterial(YsbXx entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		MultipartFile attachMentFile=request.getFile("attachMentFile");
		MultipartFile attachMentFile1=request.getFile("attachMentFile1");
		MultipartFile attachMentFile2=request.getFile("attachMentFile2");
		MultipartFile attachMentFile3=request.getFile("attachMentFile3");
		MultipartFile attachMentFile4=request.getFile("attachMentFile4");
		MultipartFile attachMentFile5=request.getFile("attachMentFile5");
		MultipartFile attachMentFile6=request.getFile("attachMentFile6");
		MultipartFile attachMentFile7=request.getFile("attachMentFile7");
		String filename = "";       //文件名
		String filename1 = "";
		String filename2 = "";
		String filename3 = "";
		String filename4 = "";
		String filename5 = "";
		String filename6 = "";
		String filename7 = "";
		String re=null;
		String re1=null;
		String re2=null;
		String re3=null;
		String re4=null;
		String re5=null;
		String re6=null;
		String re7=null;
        String sub=null;
        String sub1=null;
        String sub2=null;
        String sub3=null;
        String sub4=null;
        String sub5=null;
        String sub6=null;
        String sub7=null;
		String path = "";
		
		try {
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
				entity.setCzgc(filename);
				entity.setCzgclj(p);
				entity.setCzgcsub(sub);
	        }
			if(attachMentFile1 != null){
				filename1 = attachMentFile1.getOriginalFilename();
	            File file1 = this.getFile(attachMentFile1, path, fileTypes);
	            re1 =file1.toString();
	            sub1=re1.substring(re1.lastIndexOf("\\")+1);
	            actioncontext.setContentType("text/html");
				entity.setQjhcff(filename1);
				entity.setQjhcjl(p);
				entity.setQjhcsub(sub1);
	        }
			if(attachMentFile2 != null){
				filename2 = attachMentFile2.getOriginalFilename();
				 File file2 = this.getFile(attachMentFile2, path, fileTypes);
		            re2 =file2.toString();
		            sub2=re2.substring(re2.lastIndexOf("\\")+1);
		            actioncontext.setContentType("text/html");
				entity.setSysms(filename2);
				entity.setSmslj(p);
				entity.setSmssub(sub2);
	        }
			if(attachMentFile3 != null){
				filename3 = attachMentFile3.getOriginalFilename();
				 File file3 = this.getFile(attachMentFile3, path, fileTypes);
		            re3 =file3.toString();
		            sub3=re3.substring(re3.lastIndexOf("\\")+1);
		            actioncontext.setContentType("text/html");
				entity.setSysmffj(filename3);
				entity.setSmsfjjl(p);
				entity.setSmsfjsub(sub3);
	        }
			if(attachMentFile4 != null){
				filename4 = attachMentFile4.getOriginalFilename();
				 File file4 = this.getFile(attachMentFile4, path, fileTypes);
		            re4 =file4.toString();
		            sub4=re4.substring(re4.lastIndexOf("\\")+1);
		            actioncontext.setContentType("text/html");
				entity.setGnjcff(filename4);
				entity.setGnjcjl(p);
				entity.setGnjcsub(sub4);
	        }
			if(attachMentFile5 != null){
				filename5 = attachMentFile5.getOriginalFilename();
				 File file5 = this.getFile(attachMentFile5, path, fileTypes);
		            re5 =file5.toString();
		            sub5=re5.substring(re5.lastIndexOf("\\")+1);
		            actioncontext.setContentType("text/html");
				entity.setSbzp(filename5);
				entity.setSbzplj(p);
				entity.setSbzpsub(sub5);
	        }
			if(attachMentFile6 != null){
				filename6 = attachMentFile6.getOriginalFilename();
				 File file6 = this.getFile(attachMentFile6, path, fileTypes);
		            re6 =file6.toString();
		            sub6=re6.substring(re6.lastIndexOf("\\")+1);
		            actioncontext.setContentType("text/html");
				entity.setSbfj(filename6);
				entity.setSbfjjl(p);
				entity.setSbfjsub(sub6);
	        }
			if(attachMentFile7 != null){
				filename7 = attachMentFile7.getOriginalFilename();
				 File file7 = this.getFile(attachMentFile7, path, fileTypes);
		            re7 =file7.toString();
		            sub7=re7.substring(re7.lastIndexOf("\\")+1);
		            actioncontext.setContentType("text/html");
				entity.setJdzs(filename7);
				entity.setJdzssub(p+"/"+sub7);
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
//			            生成二维码编号url
						entity.setCcrq(Calendar.getInstance().getTime());
						String sbbh = request.getParameter("sbbh");
						String xMurl=request.getRequestURL().toString();
						String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
						String url=str+"/toSbDetail?sbbh="+sbbh;
						entity.setEwmbh(url);
	            		ySbXxDao.saveOrUpdate(entity);
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
	 * 修改
	 * @author liusong
	 * @version 2015年9月21日下午2:54:11
	 * @param entity
	 * @param id 主键ID
	 */
	@Transactional
	public void up(YsbXx entity,String id){
		entity.setId(Integer.parseInt(id));
		ySbXxDao.update(entity);
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
			ySbXxDao.delete(ids[i]);
		}
	}
	
	/** 
	 * 设备信息list查询用于jsp页面
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@Transactional
	public List<Map<String, Object>> getSb(String id){
		return ySbXxDao.getList1(id);
	}
	
	/**
	 * 获取下拉框查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ySbXxDao.getDicByLx(zdzl);
	}
	
	/**
	 * jsp中点击修改拉取内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getXg(String id){
		return ySbXxDao.getSb(id);
	}
	
	/**
	 * 查询下次检定日期
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getXcrq(String id){
		return ySbXxDao.getXcrq(id);
	}
	
	
	/**
	 * exl表格导入正则判断
	 * @author liusong
	 * @date 2015-11-17
	 * @return
	 */
	@Transactional
	private String validate(Row row) {
//        String v = getSV(row.getCell(0));
//        if(v==null || v.matches("^[0-9A-Za-z]{1,12}$")){
//        	System.out.println("第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12");
//			return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//        }else{
        	return null;
//        }
    }
	/**
	 * 微服务————设备信息搜索
	 * @author panweichi
	 * @date 2015年11月24日
	 * @param search    设备名称
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getSbxx1(String search){
		return ySbXxDao.getSbxx1(search);
	}

	/**
	 * exl导入获取当前表格里内容
	 * @author liusong
	 * @date 2015-11-17
	 * @return
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
	 * exl表格导入
	 * @author liusong
	 * @date 2015-11-17
	 * @return
	 */
	@Transactional
	public String importMember(MultipartFile file) {
		System.out.println(file.getSize());
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
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
                        
                        YsbXx sbxx = new YsbXx();
                        String sbbh=getSV(hssfRow.getCell(0));
                        sbxx.setSbbh(sbbh);
                        String sbmc=getSV(hssfRow.getCell(1));
                        sbxx.setSbmc(sbmc);
                        String ccbh=getSV(hssfRow.getCell(2));
                        sbxx.setCcbh(ccbh);
                        String sccj=getSV(hssfRow.getCell(3));
                        sbxx.setSccj(sccj);
                        String gmrq1=getSV(hssfRow.getCell(4));
                        if(gmrq1 != null && !("").equals(gmrq1)){
                        	Date gmrq = sdf1.parse(gmrq1);   // String 转 Date
                        	sbxx.setGmrq(gmrq);
                        }
                        String syzt1=getSV(hssfRow.getCell(5));
                        if(syzt1 != null && !("").equals(syzt1)){
                        	Double xbNumber = Double.parseDouble(syzt1);    //String 转 Integer
                        	int syzt = xbNumber.intValue();
                        	sbxx.setSyzt(syzt);
                        }
                        String sbxh=getSV(hssfRow.getCell(6));
                        sbxx.setSbxh(sbxh);
                        String gmjg1=getSV(hssfRow.getCell(7));
                        if(gmjg1 != null && !("").equals(gmjg1)){
                        	BigDecimal gmjg=new BigDecimal(gmjg1);
                        	sbxx.setGmjg(gmjg);
                        }
                        String clfw=getSV(hssfRow.getCell(8));
                        sbxx.setClfw(clfw);
                        String syks=getSV(hssfRow.getCell(9));
                        List<Map<String,Object>> bmmc1 = sysYhDao.getbmbh(syks);
                		for (int i=0;i<bmmc1.size();i++){
                	        Map<String, Object> map=(Map<String, Object>)bmmc1.get(i);
                	        Iterator<String> iterator = map.keySet().iterator();
                            while (iterator.hasNext())
                            {
                                String key = (String)iterator.next();
                                Object bgbhObj = map.get(key);
                				String bmbh = bgbhObj.toString();
                			    sbxx.setSyks(bmbh);
                             }
                            }
                        String sbzt1=getSV(hssfRow.getCell(10));
                        if(sbzt1 != null && !("").equals(sbzt1)){
                        	Double xbNumber = Double.parseDouble(sbzt1);    //String 转 Integer
                        	int sbzt = xbNumber.intValue();
                        	sbxx.setSbzt(sbzt);
                        }
                        String xcjdrq1=getSV(hssfRow.getCell(11));
                        if(xcjdrq1 != null && !("").equals(xcjdrq1)){
                        	Date xcjdrq = sdf.parse(xcjdrq1);   // String 转 Date
                        	sbxx.setXcjdrq(xcjdrq);
                        }
                        String bzddj=getSV(hssfRow.getCell(12));
                        sbxx.setBzddj(bzddj);
                        String jlqk=getSV(hssfRow.getCell(13));
                        sbxx.setJlqk(jlqk);
                        String jddw=getSV(hssfRow.getCell(14));
                        sbxx.setJddw(jddw);
                        String jdzq1=getSV(hssfRow.getCell(15));
                        if(jdzq1 != null && !("").equals(jdzq1)){
                        	Double xbNumber = Double.parseDouble(jdzq1);    //String 转 Integer
                        	int jyzq = xbNumber.intValue();
                        	sbxx.setJyzq(jyzq);
                        }
                        String jljg=getSV(hssfRow.getCell(16));
                        sbxx.setJljg(jljg);
                        String yqzt1=getSV(hssfRow.getCell(17));
                        if(yqzt1 != null && !("").equals(yqzt1)){
                        	Double xbNumber = Double.parseDouble(yqzt1);    //String 转 Integer
                        	int yqzk = xbNumber.intValue();
                        	sbxx.setYqzk(yqzk);
                        }
                        String tyrq1=getSV(hssfRow.getCell(18));
                        if(tyrq1 != null && !("").equals(tyrq1)){
                        	Date tyrq = sdf.parse(tyrq1);   // String 转 Date
                        	sbxx.setTyrq(tyrq);
                        }
                        String sybm=getSV(hssfRow.getCell(19));
                        sbxx.setSybm(sybm);
                        ySbXxDao.save(sbxx);
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
	 * exl表格导出
	 * @author liusong
	 * @date 2015-11-17
	 * @return
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		if(code!=null){
			code=java.net.URLDecoder.decode(code,"UTF-8");
		}
		List<Map<String,Object>> list=ySbXxDao.getList(code);
		String[] header=new String[]{"使用状态（0在用；1报废；2检定；3维修；4停用）","设备编号","二维码编号","设备名称","规格型号","设备精度","测量范围（精确度/不确定度）","计量单位（0套；1台）","使用科室（编号）","使用参数","放置地点",
				"启用时间","生产厂家","厂家联系人","厂家电话","厂家地址","出厂编号","购买价格（元）","购买日期","操作人","登记日期","检定周期（0半年；1一年；2两年；3三年；4五年）","上次检定日期","下次检定日期",
				"设备状态（0合格；1不合格）","保管人","配件信息","标准度等级/不确定度","计量情况","计量结果","检定费用（元）","检定单位","仪器状况（0在用；1报废；2检定；3维修；4停用）","备注"};
		String[] keys=new String[]{"SYZT","SBBH","EWMBH","SBMC","SBXH","SBJB","CLFW","DW","SYKS","SYFW","FZDD","QYSJ","SCCJ","CJLXR","CJDH","CJDZ","CCBH",
				"GMJG","GMRQ","SBCZR","CCRQ","JYZQ","SCJDRQ","XCJDRQ","SBZT","SBWHR","PJXX","BZDDJ","JLQK","JLJG","JDFY","JDDW","YQZK","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

	} 
