package com.zssi.framework.app.jyzxxx.service;

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
import com.zssi.framework.app.jyzxxx.dao.YjyZxxxDao;
import com.zssi.framework.app.jyzxxx.model.YjyZxxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;

@Service
public class YjyZxxxService extends BaseBO<YjyZxxxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YjyZxxxDao dao;
	
	@Autowired
	private SysYhDao sysYhDao;
	
	/**
	 * 分页查询咨询信息
	 * 
	 * @author wangyong
	 * @date 2015年6月2日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getZxxxList(Integer start, Integer limit, String code,String ksbh,String cpbh,String cpmc,
			String cplx,String jyyj) {
		return dao.getZxxxList(start, limit, code, ksbh, cpbh, cpmc, cplx, jyyj);
	}
	
	/**
	 * 通过id获取咨询信息
	 * @author wangyong
	 * @date 2016年6月3日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getZxxx(String cpbh, String jyyj){
		return dao.getZxxx(cpbh,jyyj);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2016年6月3日
	 * @param entity
	 */
	@Transactional
	public void save(YjyZxxx entity,HttpServletRequest request,HttpServletResponse response) {
		Integer num = 0;
		String cpbh = request.getParameter("cpbh");
		String cpmc = request.getParameter("cpmc");
		String cplx = request.getParameter("cplx");
		String jyyj = request.getParameter("jyyj");
		String sfpz = request.getParameter("sfpz");
		SysYh yh = AppUtil.getCurrentUser();
		String xgr = yh.getXm();
		Date xgsj = new Date();
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		boolean flag=true;
		String str="XM";
		for (int i = 0; i < num; i++) {
			String jcxm=request.getParameter("jcxm"+(i+1));
			String dybztkh=request.getParameter("dybztkh"+(i+1));
			String ggxh=request.getParameter("ggxh"+(i+1));
			String ypsl=request.getParameter("ypsl"+(i+1));
			String jcfy=request.getParameter("jcfy"+(i+1));
			String jldw=request.getParameter("jldw"+(i+1));
			String jyzq=request.getParameter("jyzq"+(i+1));
			String yzzrd=request.getParameter("yzzrd"+(i+1));
			String yzz=request.getParameter("yzz"+(i+1));
			String gpzz=request.getParameter("gpzz"+(i+1));
			String gjzz=request.getParameter("gjzz"+(i+1));
			String yspzz=request.getParameter("yspzz"+(i+1));
			String hjyq=request.getParameter("hjyq"+(i+1));
			String sbbh=request.getParameter("sbbh"+(i+1));
			String sbmc=request.getParameter("sbmc"+(i+1));
			String ry=request.getParameter("ry"+(i+1));
			String bz=request.getParameter("bz"+(i+1));
			
			if (jcxm!=null && !"".equals(jcxm)) {
				YjyZxxx yjyZxxx=new YjyZxxx();
				SysYh user=AppUtil.getCurrentUser();
				String bmbh = user.getBmbh();
				yjyZxxx.setKsbh(bmbh);
				if (cpbh!=null && !"".equals(cpbh)) {
					yjyZxxx.setCpbh(cpbh);
				}else{
					cpbh=this.getCpbh();
					yjyZxxx.setCpbh(cpbh);
				}
				yjyZxxx.setCpmc(cpmc);
				yjyZxxx.setCplx(cplx);
				yjyZxxx.setJyyj(jyyj);
				yjyZxxx.setBz1(sfpz);
				yjyZxxx.setJcxm(jcxm);
				yjyZxxx.setDybztkh(dybztkh);
				yjyZxxx.setGgxh(ggxh);
				yjyZxxx.setYpsl(ypsl);
				yjyZxxx.setJcfy(jcfy);
				yjyZxxx.setJldw(jldw);
				yjyZxxx.setJyzq(jyzq);
				if (yzzrd != null && !("").equals(yzzrd)) {
					yjyZxxx.setYzzrd(Integer.parseInt(yzzrd));
				}
				if (yzz != null && !("").equals(yzz)) {
					yjyZxxx.setYzz(Integer.parseInt(yzz));
				}
				if (gpzz != null && !("").equals(gpzz)) {
					yjyZxxx.setGpzz(Integer.parseInt(gpzz));
				}
				if (gjzz != null && !("").equals(gjzz)) {
					yjyZxxx.setGjzz(Integer.parseInt(gjzz));
				}
				if (yspzz != null && !("").equals(yspzz)) {
					yjyZxxx.setYspzz(Integer.parseInt(yspzz));
				}
				yjyZxxx.setHjyq(hjyq);
				yjyZxxx.setSbbh(sbbh);
				yjyZxxx.setSbmc(sbmc);
				yjyZxxx.setRy(ry);
				yjyZxxx.setBz(bz);
				yjyZxxx.setXgr(xgr);
				yjyZxxx.setXgsj(xgsj);
				
				String jyxmbh="";
				
				if(flag){
					jyxmbh = this.getXmbh();
					yjyZxxx.setJyxmbh(jyxmbh);
				}else{
					jyxmbh=str;
					yjyZxxx.setJyxmbh(jyxmbh);
				}
				
				dao.save(yjyZxxx);
				flag=false;
				
				Integer maxCydbh = Integer.parseInt(jyxmbh.substring(2,9));
				Integer newBh = maxCydbh + 1;
				String tempBh = "" + newBh;
				int bgbhlength = tempBh.length();
				if (bgbhlength==1) {
					str += "000000"+tempBh; 
				}else if (bgbhlength==2) {
					str += "00000"+tempBh; 
				}else if (bgbhlength==3) {
					str += "0000"+tempBh; 
				}else if (bgbhlength==4) {
					str += "000"+tempBh; 
				}else if (bgbhlength==5) {
					str += "00"+tempBh; 
				}else if (bgbhlength==6) {
					str += "0"+tempBh; 
				}else {
					str += tempBh; 
				}
				
			}
			
		}
		
	}
	
	//后台自动生成产品编号
	public String getCpbh(){
		String str1 = "CP";
		List<Map<String, Object>> cpbhList = dao.getMaxcpbh();
		String cpbhStr = (String) cpbhList.get(0).get("cpbh");
		if (cpbhStr!=null) {
			Integer maxCydbh = Integer.parseInt(cpbhStr.substring(2,8));
			Integer newBh = maxCydbh + 1;
			String tempBh = "" + newBh;
			int bgbhlength = tempBh.length();
			if (bgbhlength==1) {
				str1 += "00000"+tempBh; 
			}else if (bgbhlength==2) {
				str1 += "0000"+tempBh; 
			}else if (bgbhlength==3) {
				str1 += "000"+tempBh; 
			}else if (bgbhlength==4) {
				str1 += "00"+tempBh; 
			}else if (bgbhlength==5) {
				str1 += "0"+tempBh; 
			}else {
				str1 += tempBh; 
			}
		}else {
		    str1 += "000001";
		}
		return str1;
	}
	
	//检验项目编号自动生成
	public String getXmbh(){
		String str = "XM";
		List<Map<String, Object>> bhList = dao.getMaxxmbh();
		String xmbhStr = (String) bhList.get(0).get("jyxmbh");
		if (xmbhStr!=null) {
			Integer maxCydbh = Integer.parseInt(xmbhStr.substring(2,9));
			Integer newBh = maxCydbh + 1;
			String tempBh = "" + newBh;
			int bgbhlength = tempBh.length();
			if (bgbhlength==1) {
				str += "000000"+tempBh; 
			}else if (bgbhlength==2) {
				str += "00000"+tempBh; 
			}else if (bgbhlength==3) {
				str += "0000"+tempBh; 
			}else if (bgbhlength==4) {
				str += "000"+tempBh; 
			}else if (bgbhlength==5) {
				str += "00"+tempBh; 
			}else if (bgbhlength==6) {
				str += "0"+tempBh; 
			}else {
				str += tempBh; 
			}
		}else {
		    str += "0000001";
		}
		return str;
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(HttpServletRequest request,HttpServletResponse response){
		//保存新的项目之前删除旧的项目
		String cpbh=request.getParameter("cpbh");
		String jyyjOld=request.getParameter("jyyjOld");
		String jyyj=request.getParameter("jyyj");
		dao.deleteCp(cpbh,jyyjOld);
		
		Integer num = 0;
		String cpmc = request.getParameter("cpmc");
		String cplx = request.getParameter("cplx");
		String sfpz = request.getParameter("sfpz");
		SysYh yh = AppUtil.getCurrentUser();
		String xgr = yh.getXm();
		Date xgsj = new Date();
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		boolean flag=true;
		String str="XM";
		for (int i = 0; i < num; i++) {
			String jcxm=request.getParameter("jcxm"+(i+1));
			String dybztkh=request.getParameter("dybztkh"+(i+1));
			String ggxh=request.getParameter("ggxh"+(i+1));
			String ypsl=request.getParameter("ypsl"+(i+1));
			String jcfy=request.getParameter("jcfy"+(i+1));
			String jldw=request.getParameter("jldw"+(i+1));
			String jyzq=request.getParameter("jyzq"+(i+1));
			String yzzrd=request.getParameter("yzzrd"+(i+1));
			String yzz=request.getParameter("yzz"+(i+1));
			String gpzz=request.getParameter("gpzz"+(i+1));
			String gjzz=request.getParameter("gjzz"+(i+1));
			String yspzz=request.getParameter("yspzz"+(i+1));
			String hjyq=request.getParameter("hjyq"+(i+1));
			String sbbh=request.getParameter("sbbh"+(i+1));
			String sbmc=request.getParameter("sbmc"+(i+1));
			String ry=request.getParameter("ry"+(i+1));
			String bz=request.getParameter("bz"+(i+1));
			
			if (jcxm!=null && !"".equals(jcxm)) {
				YjyZxxx yjyZxxx=new YjyZxxx();
				SysYh user=AppUtil.getCurrentUser();
				String bmbh = user.getBmbh();
				yjyZxxx.setKsbh(bmbh);
				yjyZxxx.setCpbh(cpbh);
				yjyZxxx.setCpmc(cpmc);
				yjyZxxx.setCplx(cplx);
				yjyZxxx.setBz1(sfpz);
				yjyZxxx.setJyyj(jyyj);
				yjyZxxx.setJcxm(jcxm);
				yjyZxxx.setDybztkh(dybztkh);
				yjyZxxx.setGgxh(ggxh);
				yjyZxxx.setYpsl(ypsl);
				yjyZxxx.setJcfy(jcfy);
				yjyZxxx.setJldw(jldw);
				yjyZxxx.setJyzq(jyzq);
				if (yzzrd != null && !("").equals(yzzrd)) {
					yjyZxxx.setYzzrd(Integer.parseInt(yzzrd));
				}
				if (yzz != null && !("").equals(yzz)) {
					yjyZxxx.setYzz(Integer.parseInt(yzz));
				}
				if (gpzz != null && !("").equals(gpzz)) {
					yjyZxxx.setGpzz(Integer.parseInt(gpzz));
				}
				if (gjzz != null && !("").equals(gjzz)) {
					yjyZxxx.setGjzz(Integer.parseInt(gjzz));
				}
				if (yspzz != null && !("").equals(yspzz)) {
					yjyZxxx.setYspzz(Integer.parseInt(yspzz));
				}
				yjyZxxx.setHjyq(hjyq);
				yjyZxxx.setSbbh(sbbh);
				yjyZxxx.setSbmc(sbmc);
				yjyZxxx.setRy(ry);
				yjyZxxx.setBz(bz);
				yjyZxxx.setXgr(xgr);
				yjyZxxx.setXgsj(xgsj);
				
				String jyxmbh="";
				
				if(flag){
					jyxmbh = this.getXmbh();
					yjyZxxx.setJyxmbh(jyxmbh);
				}else{
					jyxmbh=str;
					yjyZxxx.setJyxmbh(jyxmbh);
				}
				
				dao.save(yjyZxxx);
				flag=false;
				
				Integer maxCydbh = Integer.parseInt(jyxmbh.substring(2,9));
				Integer newBh = maxCydbh + 1;
				String tempBh = "" + newBh;
				int bgbhlength = tempBh.length();
				if (bgbhlength==1) {
					str += "000000"+tempBh; 
				}else if (bgbhlength==2) {
					str += "00000"+tempBh; 
				}else if (bgbhlength==3) {
					str += "0000"+tempBh; 
				}else if (bgbhlength==4) {
					str += "000"+tempBh; 
				}else if (bgbhlength==5) {
					str += "00"+tempBh; 
				}else if (bgbhlength==6) {
					str += "0"+tempBh; 
				}else {
					str += tempBh; 
				}
				
			}
			
		}
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 */
	@Transactional
	public void delete(String[] cpbhs,String[] jyyjs) {
		for(int i=0;i<cpbhs.length;i++){
			System.out.print(cpbhs[i]+"========="+jyyjs[i]);
			dao.deleteCp(cpbhs[i], jyyjs[i]);
		}
		
	}
	
	/**
	 * 获取已有的产品	
	 * @author wangyong
	 * @date 2015年6月12日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> yccpList(String cpbhcx,String cpmccx,String ypjzcs){
		return dao.yccpList(cpbhcx, cpmccx, ypjzcs);
	}
	
	/**
	 * exl表格导入正则判断
	 * @author liusong
	 * @date 2015-11-17
	 * @return
	 */
	@Transactional
	private String validate(Row row) {
//       String v = getSV(row.getCell(0));
//       if(v==null || v.matches("^[0-9A-Za-z]{1,12}$")){
//       	System.out.println("第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12");
//			return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//       }else{
       	return null;
//       }
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
	 * @author wangyong
	 * @date 2016-6-6
	 * @return
	 */
	@Transactional
	public String importMember(MultipartFile file) {
		System.out.println(file.getSize());
		String checkcpmc = "";
		String checkxmmc = "";
		int s = 0;
		int kobe = 0;
		String cpbh = "";
		String xmbh = "";
		String maxcpbh  = dao.getMaxCpbh();
		if(!"1000000".equals(maxcpbh)){
			maxcpbh = "1"+maxcpbh.substring(2, 8);
		}
		String maxxmbh = dao.getMaxXmbh();
 	   if(!"10000000".equals(maxxmbh)){
 		  maxxmbh = "1"+maxxmbh.substring(2, 9);
		 }
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
                       YjyZxxx zxxx = new YjyZxxx();
                       String ksbhStr=getSV(hssfRow.getCell(0));
                       List<Map<String,Object>> bmbhList = sysYhDao.getbmbh(ksbhStr);
                       if(bmbhList.size()==1){
                    	   String bmbh=(String) bmbhList.get(0).get("bmbh");
                    	   zxxx.setKsbh(bmbh);
                       }
                       String cpmc=getSV(hssfRow.getCell(2));
                       if(!cpmc.equals(checkcpmc)){
                    	   checkcpmc = cpmc;
                    	   
                    	   s++;
                    	   cpbh= "CP"+ String.valueOf((Integer.parseInt(maxcpbh)+s)).substring(1, 7);
                       }
                       zxxx.setCpmc(cpmc);
                       zxxx.setCpbh(cpbh);
                       String cplx=getSV(hssfRow.getCell(1));
                       zxxx.setCplx(cplx);
                       String jyyj=getSV(hssfRow.getCell(3));
                       zxxx.setJyyj(jyyj);
                       String sfpz=getSV(hssfRow.getCell(4));
                       zxxx.setBz1(sfpz);
                       String jcxm=getSV(hssfRow.getCell(5));
                       if(!jcxm.equals(checkxmmc)){
                    	   checkxmmc = jcxm;
                    	   kobe++;
                    	   xmbh= "XM"+ String.valueOf((Integer.parseInt(maxxmbh)+kobe)).substring(1, 8);
                       }
                       zxxx.setJcxm(jcxm);
                       zxxx.setJyxmbh(xmbh);
                       String dybztkh=getSV(hssfRow.getCell(6));
                       zxxx.setDybztkh(dybztkh);
                       String ggxh=getSV(hssfRow.getCell(7));
                       zxxx.setGgxh(ggxh);
                       String ypsl=getSV(hssfRow.getCell(8));
                       zxxx.setYpsl(ypsl);
                       String jcfyStr=getSV(hssfRow.getCell(9));
                       zxxx.setJcfy(jcfyStr);
                       String jyzq=getSV(hssfRow.getCell(10));
                       zxxx.setJyzq(jyzq);
                       String yzzrd=getSV(hssfRow.getCell(11));
                       if(yzzrd!=null&&!"".equals(yzzrd)){
                    	   if(yzzrd.equals("是")){
                        	   zxxx.setYzzrd(0);
                           }else if(yzzrd.equals("否")){
                        	   zxxx.setYzzrd(1);
                           }
                       }
                       
                       String yzz=getSV(hssfRow.getCell(12));
                       if(yzz!=null&&!"".equals(yzz)){
                    	   if(yzz.equals("是")){
                        	   zxxx.setYzz(0);
                           }else if(yzz.equals("否")){
                        	   zxxx.setYzz(1);
                           }
                       }
                       String gpzz=getSV(hssfRow.getCell(13));
                       if(gpzz!=null&&!"".equals(gpzz)){
                    	   if(gpzz.equals("是")){
                        	   zxxx.setGpzz(0);
                           }else if(gpzz.equals("否")){
                        	   zxxx.setGpzz(1);
                           }
                       }
                       String gjzz=getSV(hssfRow.getCell(14));
                       if(gjzz!=null&&!"".equals(gjzz)){
                    	   if(gjzz.equals("是")){
                        	   zxxx.setGjzz(0);
                           }else if(gjzz.equals("否")){
                        	   zxxx.setGjzz(1);
                           }
                       }
                       String yspzz=getSV(hssfRow.getCell(15));
                       if(yspzz!=null&&!"".equals(yspzz)){
                    	   if(yspzz.equals("是")){
                        	   zxxx.setYspzz(0);
                           }else if(yspzz.equals("否")){
                        	   zxxx.setYspzz(1);
                           }
                       }
                       String hjyq=getSV(hssfRow.getCell(16));
                       zxxx.setHjyq(hjyq);
                       String sbbh=getSV(hssfRow.getCell(17));
                       zxxx.setSbbh(sbbh);
                       String sbmc=getSV(hssfRow.getCell(18));
                       zxxx.setSbmc(sbmc);
                       String ry=getSV(hssfRow.getCell(19));
                       zxxx.setRy(ry);
                       String bz=getSV(hssfRow.getCell(20));
                       zxxx.setBz(bz);
                       dao.save(zxxx);
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
	public void exportExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ksbh =request.getParameter("ksbh");
		String cpbh =request.getParameter("cpbh");
		String cpmc =request.getParameter("cpmc");
		String cplx =request.getParameter("cplx");
		String jyyj =request.getParameter("jyyj");
		if(ksbh!=null){
			ksbh=java.net.URLDecoder.decode(ksbh,"UTF-8");
		}
		if(cpbh!=null){
			cpbh=java.net.URLDecoder.decode(cpbh,"UTF-8");
		}
		if(cpmc!=null){
			cpmc=java.net.URLDecoder.decode(cpmc,"UTF-8");
		}
		if(cplx!=null){
			cplx=java.net.URLDecoder.decode(cplx,"UTF-8");
		}
		if(jyyj!=null){
			jyyj=java.net.URLDecoder.decode(jyyj,"UTF-8");
		}
		List<Map<String,Object>> list=dao.getList(ksbh,cpbh,cpmc,cplx,jyyj);
		String[] header=new String[]{"科室名称","产品名称","产品编号","产品类型","规格型号","样品数量","检验依据","对应标准条款号","检验项目编号","检验项目名称","检测费用","检验周期（天）",
				"院资质认定","院CNAS","国排中心CMA/CAL","国建中心CMA/CAL","院食品省级资质认定","环境要求","设备编号","设备名称","人员","备注"};
		String[] keys=new String[]{"KSBH","CPMC","CPBH","CPLX","GGXH","YPSL","JYYJ","DYBZTKH","JYXMBH","JCXM","JCFY","JYZQ","YSPZZ","YZZ","GPZZ","GJZZ",
				"YSPZZ","HJYQ","SBBH","SBMC","RY","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}
