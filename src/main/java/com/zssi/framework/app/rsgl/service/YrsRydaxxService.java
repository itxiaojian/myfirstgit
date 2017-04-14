package com.zssi.framework.app.rsgl.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.rsgl.dao.YrsRydaxxDao;
import com.zssi.framework.app.rsgl.model.YrsRydaxx;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YrsRydaxxService extends BaseBO<YrsRydaxx>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YrsRydaxxDao yrsRydaxxDao;
	
	/**
	 * 后台：人员档案信息列表
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getRydaxxList(Integer start,Integer limit,String chaxun){
		return yrsRydaxxDao.getRydaxxList(start,  limit, chaxun);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YrsRydaxx entity,String id){
		entity.setId(Integer.parseInt(id));
		yrsRydaxxDao.update(entity);
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
			yrsRydaxxDao.delete(ids[i]);
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
	public void UploadImageMaterial(YrsRydaxx entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
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
	            entity.setDafj(filename);
			
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
						
	            		yrsRydaxxDao.saveOrUpdate(entity);
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
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月22日
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
	 * @date 2015年10月22日
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
	 * @date 2015年10月22日
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
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YrsRydaxx rydaxx = new YrsRydaxx();
                        String rybh=getSV(hssfRow.getCell(0));
                        String ryzh=getSV(hssfRow.getCell(1));
                        String ryxm=getSV(hssfRow.getCell(2));
                        String ks_id=getSV(hssfRow.getCell(3));
                        String xb=getSV(hssfRow.getCell(4));
                        if(xb != null && !("").equals(xb)){
                        	Double xbNumber = Double.parseDouble(xb);    //String 转 Integer
                        	int bx = xbNumber.intValue();
                        	rydaxx.setXb(bx);
                        }
                        String sr=getSV(hssfRow.getCell(5));
                        if(sr != null && !("").equals(sr)){
                        	Date birthday = sdf.parse(sr);   // String 转 Date
                        	rydaxx.setSr(birthday);
                        }
                        String lxdh=getSV(hssfRow.getCell(6));
                        String sjhm=getSV(hssfRow.getCell(7));
                        String jtzz=getSV(hssfRow.getCell(8));
                        String zwid=getSV(hssfRow.getCell(9));
                        String dafj=getSV(hssfRow.getCell(10));
                        String bz=getSV(hssfRow.getCell(11));
                        
                        rydaxx.setRybh(rybh);
                        rydaxx.setRyzh(ryzh);
                        rydaxx.setRyxm(ryxm);
                        rydaxx.setKs_id(ks_id);
                        rydaxx.setLxdh(lxdh);
                        rydaxx.setSjhm(sjhm);
                        rydaxx.setJtzz(jtzz);
                        rydaxx.setZwid(zwid);
                        rydaxx.setDafj(dafj);
                        rydaxx.setBz(bz);
                        yrsRydaxxDao.save(rydaxx);
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
	 * @date 2015年10月22日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yrsRydaxxDao.getList(code);
		String[] header=new String[]{"人员编号","人员账号","人员姓名","所属科室","性别","生日","联系电话",
				"手机号码","家庭住址","职务ID","档案附件","备注"};
		String[] keys=new String[]{"RYBH","RYZH","RYXM","KS_ID","XB","SR","LXDH","SJHM","JTZZ","ZWID","DAFJ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

//	/**
//	 * 客户信息增加提交
//	 * @author liujiansen
//	 * @date 2015年9月16日
//	 * @param request
//	 * @param entity 
//	 * @return
//	 * @throws  
//	 */
//	@Transactional
//	public String saveRb(HttpServletRequest request, YrsRydaxx entity) {
//		String str="";
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
//		 YrsRydaxx rydaxx=new YrsRydaxx();
////		request.getParameter("hybh")是获取前台jsp中的input里的name
//		String rybh = request.getParameter("rybh");
//		String ryzh = request.getParameter("ryzh");
//		String ryxm = request.getParameter("ryxm");
//		String ks_id = request.getParameter("ks_id");
//		String xb = request.getParameter("xb");
//		Integer xbInteger=null;
//		 if(xb != null && !("").equals(xb)){
//			 xbInteger  =Integer.parseInt(xb);
//			 rydaxx.setXb(xbInteger);
//		 }
//		String lxdh = request.getParameter("lxdh");
//		String sjhm = request.getParameter("sjhm");
//		String jtzz = request.getParameter("jtzz");
//		String zwid = request.getParameter("zwid");
//		String dafj = request.getParameter("dafj");
//		
//		String sr = request.getParameter("sr");
//		Date qyrq = null;
//		 if(sr != null && !("").equals(sr)){
////         	Date qyrq = sdf.parse(clsj);   // String 转 Date
//			 try {
//				qyrq = sdf.parse(sr);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			 rydaxx.setSr(qyrq);
//         }
//		
//		String bz = request.getParameter("bz");
//		entity.setRybh(rybh);
//		entity.setRyzh(ryzh);
//		entity.setRyxm(ryxm);
//		entity.setKs_id(ks_id);
//		entity.setXb(xbInteger);
//		entity.setSr(qyrq);
//		entity.setLxdh(lxdh);
//		entity.setSjhm(sjhm);
//		entity.setJtzz(jtzz);
//		entity.setZwid(zwid);
//		entity.setDafj(dafj);
//		entity.setBz(bz);
//		yrsRydaxxDao.save(entity);
//		str="1";
//		return str;
//	}

	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面**********************************************/
	/**
	 * 点击修改拉取内容
	 * 
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param id
	 * @return
	 */

	@Transactional
	public List<Map<String, Object>> getXg(String yhbh){
		return yrsRydaxxDao.getSgzxx(yhbh);
	}
///**
// * 上传修改内容
// * @author liangkaidi
// * @date 2015-11-25
// * @param request
// * @param id
// */
//	public String update(HttpServletRequest request, String id) {
//		String str="";
//		YrsRydaxx entity=yrsRydaxxDao.get(Integer.parseInt(id));
//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
//		 YrsRydaxx rydaxx=new YrsRydaxx();
////		request.getParameter("hybh")是获取前台jsp中的input里的name
//		String rybh = request.getParameter("rybh");
//		String ryzh = request.getParameter("ryzh");
//		String ryxm = request.getParameter("ryxm");
//		String ks_id = request.getParameter("ks_id");
//		String xb = request.getParameter("xb");
//		Integer xbInteger=null;
//
//		 if(xb != null && !("").equals(xb)){
//			 xbInteger  =Integer.parseInt(xb);
//			 rydaxx.setXb(xbInteger);
//			 
//		 }
//		String lxdh = request.getParameter("lxdh");
//		String sjhm = request.getParameter("sjhm");
//		String jtzz = request.getParameter("jtzz");
//		String zwid = request.getParameter("zwid");
//		String dafj = request.getParameter("dafj");
//		
//		String sr = request.getParameter("sr");
//		Date qyrq = null;
//		 if(sr != null && !("").equals(sr)){
////        	Date qyrq = sdf.parse(clsj);   // String 转 Date
//			 try {
//				qyrq = sdf.parse(sr);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			 rydaxx.setSr(qyrq);
//        }
//		
//		String bz = request.getParameter("bz");
//		entity.setRybh(rybh);
//		entity.setRyzh(ryzh);
//		entity.setRyxm(ryxm);
//		entity.setKs_id(ks_id);
//		entity.setXb(xbInteger);
//		entity.setSr(qyrq);
//		entity.setLxdh(lxdh);
//		entity.setSjhm(sjhm);
//		entity.setJtzz(jtzz);
//		entity.setZwid(zwid);
//		entity.setDafj(dafj);
//		entity.setBz(bz);
//		yrsRydaxxDao.update(entity);
//		str="1";
//		return str;
//	}
/**
 * 数据字典
 * @author liangkaidi
 * @date 2016-1-7
 * @param string
 * @return
 */
	@Transactional
	public List<Map<String, Object>> getDicByList(String zdzl) {
		return yrsRydaxxDao.getDicByList(zdzl);
	}
		
	}

	

