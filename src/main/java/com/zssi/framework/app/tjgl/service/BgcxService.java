package com.zssi.framework.app.tjgl.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.tjgl.dao.BgcxDao;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class BgcxService extends BaseBO<YjyBgxx> {
	@Autowired
	private BgcxDao dao;

	@Transactional
	public List<Map<String, Object>> getZdmc(String tabName) {
		return dao.getZdmc(tabName);
	}
	@Transactional
	public List<Map<String, Object>> getZdmc1(String tabName,String tabName1) {
		return dao.getZdmc1(tabName,tabName1);
	}
	
	public List<Map<String, Object>> getJyksList() {
		return dao.getJyksList();
	}
	
	public List<Map<String, Object>> getBzrList() {
		return dao.getBzrList();
	}
	
	public List<Map<String, Object>> getYwksList() {
		return dao.getYwksList();
	}
	
	/**
	 * 查询未完成报告信息
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 * @throws ParseException 
	 */
	public List<Map<String, Object>>getBgxx(Integer start, Integer limit) throws ParseException {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd");
		List<Map<String,Object>> bgyj=dao.getBgxx(start, limit);
		for(int i = 0;i < bgyj.size();i++){
//			首先如果样品状态在批准前，那么久就用当前时间和完成期限相比较
			   Map<String, Object> map = bgyj.get(i);
				Date dqsj = sdf.parse(sdf.format(new Date()));
				if(bgyj.get(i).get("wcqx")!=null&&!"".equals(bgyj.get(i).get("wcqx").toString())){
					Date wcqx = sdf.parse(bgyj.get(i).get("wcqx").toString());
					//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24. 
					long workDayVal = (wcqx.getTime() - dqsj.getTime())/86400000 + 1;  
		   			//工时的余数  
		   			long remainder = workDayVal % 7; 
		   			//工时向下取整的除数  
		   			double divisor = Math.floor(workDayVal / 7);  
		   			double weekendDay = 2 * divisor;  
		   			//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
		   			@SuppressWarnings("deprecation")
					int nextDay = dqsj.getDay();  
		   			//从起始日期的星期开始 遍历remainder天  
		   			for(long tempDay = remainder; tempDay>=1; tempDay--) {  
		   				//第一天不用加1  
		   				if(tempDay == remainder) {  
		   					nextDay = nextDay + 0;  
		   				} else if(tempDay != remainder) {  
		   					nextDay = nextDay + 1;  
		   				}  
		   				//周日，变更为0  
		   				if(nextDay == 7) {  
		   					nextDay = 0;  
		   				}  
		   				//周六日  
		   				if(nextDay == 0 || nextDay == 6) {  
		   					weekendDay = weekendDay + 1;  
		   				}  
		   			} 
		   		    //实际工时（天） = 起止日期差 - 周六日数目。  
//				   	workDayVal = (long) (workDayVal - weekendDay); 
					workDayVal = (long) (workDayVal);
				   	map.put("workDayVal", workDayVal);//当前环节
				}else{
					map.put("workDayVal", "8");
				}
		}
		return bgyj;
	}
	
	/**
	 * 主视图查询未完成报告信息
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 * @throws ParseException 
	 */
	public List<Map<String, Object>>getBgxxindex(Integer start, Integer limit) throws ParseException {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd");
		List<Map<String,Object>> bgyj=dao.getBgxx(start, limit);
		for(int i = 0;i < bgyj.size();i++){
//			首先如果样品状态在批准前，那么久就用当前时间和完成期限相比较
			   Map<String, Object> map = bgyj.get(i);
				Date dqsj = sdf.parse(sdf.format(new Date()));
				if(bgyj.get(i).get("wcqx")!=null&&!"".equals(bgyj.get(i).get("wcqx").toString())){
					Date wcqx = sdf.parse(bgyj.get(i).get("wcqx").toString());
					//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24. 
					long workDayVal = (wcqx.getTime() - dqsj.getTime())/86400000 + 1;  
		   			//工时的余数  
		   			long remainder = workDayVal % 7; 
		   			//工时向下取整的除数  
		   			double divisor = Math.floor(workDayVal / 7);  
		   			double weekendDay = 2 * divisor;  
		   			//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
		   			@SuppressWarnings("deprecation")
					int nextDay = dqsj.getDay();  
		   			//从起始日期的星期开始 遍历remainder天  
		   			for(long tempDay = remainder; tempDay>=1; tempDay--) {  
		   				//第一天不用加1  
		   				if(tempDay == remainder) {  
		   					nextDay = nextDay + 0;  
		   				} else if(tempDay != remainder) {  
		   					nextDay = nextDay + 1;  
		   				}  
		   				//周日，变更为0  
		   				if(nextDay == 7) {  
		   					nextDay = 0;  
		   				}  
		   				//周六日  
		   				if(nextDay == 0 || nextDay == 6) {  
		   					weekendDay = weekendDay + 1;  
		   				}  
		   			} 
		   		    //实际工时（天） = 起止日期差 - 周六日数目。  
				   	workDayVal = (long) (workDayVal - weekendDay); 
				   	map.put("workDayVal", workDayVal);//当前环节
				}else{
					map.put("workDayVal", "8");
				}
		}
		return bgyj;
	}
	
	/**
	 * 主视图查询已完成报告信息
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 * @throws ParseException 
	 */
	public List<Map<String, Object>>getBgxxindex1(Integer start, Integer limit) throws ParseException {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd");
		List<Map<String,Object>> bgyj=dao.getBgxx1(start, limit);
		for(int i = 0;i < bgyj.size();i++){
//			首先如果样品状态在批准前，那么久就用当前时间和完成期限相比较
			Map<String, Object> map = bgyj.get(i);
				Date dqsj = sdf.parse(bgyj.get(i).get("pzsj").toString());
				if(bgyj.get(i).get("wcqx")!=null&&!"".equals(bgyj.get(i).get("wcqx").toString())){
					Date wcqx = sdf.parse(bgyj.get(i).get("wcqx").toString());
					//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24. 
					long workDayVal = (wcqx.getTime() - dqsj.getTime())/86400000 + 1;  
		   			//工时的余数  
		   			long remainder = workDayVal % 7; 
		   			//工时向下取整的除数  
		   			double divisor = Math.floor(workDayVal / 7);  
		   			double weekendDay = 2 * divisor;  
		   			//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
		   			@SuppressWarnings("deprecation")
					int nextDay = dqsj.getDay();  
		   			//从起始日期的星期开始 遍历remainder天  
		   			for(long tempDay = remainder; tempDay>=1; tempDay--) {  
		   				//第一天不用加1  
		   				if(tempDay == remainder) {  
		   					nextDay = nextDay + 0;  
		   				} else if(tempDay != remainder) {  
		   					nextDay = nextDay + 1;  
		   				}  
		   				//周日，变更为0  
		   				if(nextDay == 7) {  
		   					nextDay = 0;  
		   				}  
		   				//周六日  
		   				if(nextDay == 0 || nextDay == 6) {  
		   					weekendDay = weekendDay + 1;  
		   				}  
		   			} 
		   		    //实际工时（天） = 起止日期差 - 周六日数目。  
				   	workDayVal = (long) (workDayVal - weekendDay); 
				   	map.put("workDayVal", workDayVal);//当前环节
				}else{
					map.put("workDayVal", "8");
				}
		}
		return bgyj;
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @return
	 */
	public int getBgxxCount(Integer start, Integer limit) {
		return Integer.parseInt(dao.getBgxxCount(start, limit).get(0).get("cnt").toString());
	}
	
	/**
	 * 查询已完成报告信息
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 * @throws ParseException 
	 */
	public List<Map<String, Object>>getBgxx1(Integer start1, Integer limit1) throws ParseException {
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd");
		List<Map<String,Object>> bgyj=dao.getBgxx1(start1, limit1);
		for(int i = 0;i < bgyj.size();i++){
//			首先如果样品状态在批准前，那么久就用当前时间和完成期限相比较
			Map<String, Object> map = bgyj.get(i);
				Date dqsj = sdf.parse(bgyj.get(i).get("pzsj").toString());
				if(bgyj.get(i).get("wcqx")!=null&&!"".equals(bgyj.get(i).get("wcqx").toString())){
					Date wcqx = sdf.parse(bgyj.get(i).get("wcqx").toString());
					//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24. 
					long workDayVal = (wcqx.getTime() - dqsj.getTime())/86400000 + 1;  
		   			//工时的余数  
		   			long remainder = workDayVal % 7; 
		   			//工时向下取整的除数  
		   			double divisor = Math.floor(workDayVal / 7);  
		   			double weekendDay = 2 * divisor;  
		   			//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
		   			@SuppressWarnings("deprecation")
					int nextDay = dqsj.getDay();  
		   			//从起始日期的星期开始 遍历remainder天  
		   			for(long tempDay = remainder; tempDay>=1; tempDay--) {  
		   				//第一天不用加1  
		   				if(tempDay == remainder) {  
		   					nextDay = nextDay + 0;  
		   				} else if(tempDay != remainder) {  
		   					nextDay = nextDay + 1;  
		   				}  
		   				//周日，变更为0  
		   				if(nextDay == 7) {  
		   					nextDay = 0;  
		   				}  
		   				//周六日  
		   				if(nextDay == 0 || nextDay == 6) {  
		   					weekendDay = weekendDay + 1;  
		   				}  
		   			} 
		   		    //实际工时（天） = 起止日期差 - 周六日数目。  
				   	workDayVal = (long) (workDayVal - weekendDay); 
				   	map.put("workDayVal", workDayVal);//当前环节
				}else{
					map.put("workDayVal", "8");
				}
		}
		return bgyj;
	}
	
	public int getBgxx1Count(Integer start1, Integer limit1) {
		return Integer.parseInt(dao.getBgxx1Count(start1, limit1).get(0).get("cnt").toString());
	}

	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @return
	 */
	public List<Map<String, Object>> getBgcxList(Integer start, Integer limit,
			String cs, String cxtj) {
		String[] arr = null;
		String strs = "";
		String join = "";
		if (cs != null && !"".equals(cs)) {
			String str=this.doSomeThing(cs, arr, strs, join);
			if(str!=null&&!"".equals(str)){
				String[] sz=str.split("#");
				if(sz.length>1){
					strs=sz[0];
					join=sz[1];
				}else{
					strs=sz[0];
				}
			}
		}
		return dao.getBgcxList(start, limit, strs, join, cxtj, "Y_JY_BGXX");
	}

	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @return
	 */
	public int getBgcxCount(Integer start, Integer limit, String cs, String cxtj) {
		String[] arr = null;
		String strs = "";
		String join = "";
		if (cs != null && !"".equals(cs)) {
			String str=this.doSomeThing(cs, arr, strs, join);
			if(str!=null&&!"".equals(str)){
				String[] sz=str.split("#");
				if(sz.length>1){
					strs=sz[0];
					join=sz[1];
				}else{
					strs=sz[0];
				}
			}
		}
		return Integer.parseInt(dao.getBgcxCount(start, limit, strs, join, cxtj, "Y_JY_BGXX").get(0).get("cnt").toString());
	}
	
	/**
	 * excel导出
	 * @author liujiansen
	 * @date 2016年1月14日
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String cs, String cxtj,String bt) throws Exception {
		String[] arr = null;
		String[] btStr = null;
		String strs = "";
		String join = "";
		if (cs != null && !"".equals(cs)) {
			cs=java.net.URLDecoder.decode(cs,"UTF-8");
			String str=this.doSomeThing(cs, arr, strs, join);
			arr=cs.split(",");
			if(str!=null&&!"".equals(str)){
				String[] sz=str.split("#");
				if(sz.length>1){
					strs=sz[0];
					join=sz[1];
				}else{
					strs=sz[0];
				}
			}
		}
		String str="";
		btStr = cs.split(",");
		if(btStr.length>0){
			for(int i=0;i<btStr.length;i++){
				if(i<btStr.length-1){
//					if(btStr[i].equals("BZR")||btStr[i].equals("SHR")||btStr[i].equals("XGJDRY")||btStr[i].equals("QSR")){
//						str=str+"";
////						System.out.println("===================1111====="+btNew[i]);
//					}else{
					str=str+"'"+btStr[i]+"',";
//					}
				}else{
					str=str+"'"+btStr[i]+"'";
				}
			}
		}
		
		List<Map<String, Object>> btList = dao.getBt(str);
//		int k =0;
		for(int i=0;i<btStr.length;i++){
//		for(int i=0;i<btStr.length-(4-k);i++){
//			if(btStr[i].equals("BZR")){
//				btStr[i]="编制人";
//				k++;
//				}
//			if(btStr[i].equals("SHR")){
//				btStr[i]="审核人";
//				k++;
//			}
//			if(btStr[i].equals("XGJDRY")){
//				btStr[i]="批准人";
//				k++;
//			}
//			if(btStr[i].equals("QSR")){
//				btStr[i]="签收人";
//				k++;
//			}
////			System.out.println("===================2222====="+btNew[i]);
//			if(btStr[i]!="编制人" && btStr[i]!="审核人"&& btStr[i]!="批准人" && btStr[i]!="签收人"){
//				btStr[i]=btList.get(i-k).get("name").toString();			
//				}
			btStr[i]=btList.get(i).get("name").toString();
		}
		if(cxtj!=null&&!"".equals(cxtj)){
			cxtj=java.net.URLDecoder.decode(cxtj,"UTF-8");
		}
		List<Map<String,Object>> list=dao.getExcelList(strs, join, cxtj, "Y_JY_BGXX");
		String[] header=btStr;
		String[] keys=arr;
		for(int i=0;i < list.size();i++){
			Map<String, Object> map = list.get(i);
			if(map.get("YPJYZT").equals("待分配")){
				map.put("FPSJ", null);
				map.put("BZR", null);
				map.put("BSSJ", null);
				map.put("SHR", null);
				map.put("BPSJ", null);
				map.put("PZR", null);
				map.put("PZSJ", null);
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("编制中")){
				map.put("BSSJ", null);
				map.put("SHR", null);
				map.put("BPSJ", null);
				map.put("PZR", null);
				map.put("PZSJ", null);
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("审核中")){
				map.put("BPSJ", null);
				map.put("PZR", null);
				map.put("PZSJ", null);
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("批准中")){
				map.put("PZSJ", null);
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("待接收")){
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("待接归档")){
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("驳回修改")){
				map.put("QSR", null);
				map.put("FPSJ", null);
				map.put("BZR", null);
				map.put("BSSJ", null);
				map.put("SHR", null);
				map.put("BPSJ", null);
				map.put("PZR", null);
				map.put("PZSJ", null);
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}else if(map.get("YPJYZT").equals("已解锁")){
				map.put("BSSJ", null);
				map.put("SHR", null);
				map.put("BPSJ", null);
				map.put("PZR", null);
				map.put("PZSJ", null);
				map.put("JSSJ", null);
				map.put("GDSJ", null);
			}
		}
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月15日
	 * @param cs
	 * @param arr
	 * @param strs
	 * @param join
	 * @return
	 */
	public String doSomeThing(String cs,String[] arr,String strs,String join){
		String str="";
		arr = cs.split(",");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("CYRQ")||arr[i].equals("DJSJ")||arr[i].equals("DYRQ")||arr[i].equals("LYRQ")||arr[i].equals("WCQX")||arr[i].equals("DJRQ")
			   ||arr[i].equals("XGSJ")||arr[i].equals("FFRQ") || arr[i].equals("TJRQ") ||arr[i].equals("JYJSRQ")||arr[i].equals("BGBZRQ") || arr[i].equals("BGDYSJ")){
				strs=strs+"to_char(z."+arr[i]+",'yyyy-MM-dd') as "+arr[i]+",";
//			}else if(arr[i].equals("YPJYZT")){
//				strs=strs+"b.zdmc as "+arr[i]+",";
//				join=join+" left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on to_char(z."+arr[i]+")=b.zdz ";
			}else if(arr[i].equals("YWKS")){
				strs=strs+"c.bmmc as "+arr[i]+",";
				join=join+" left join sys_zzjg c on z."+arr[i]+"=c.bmbh ";
			}else if(arr[i].equals("JYKS")){
				strs=strs+"d.bmmc as "+arr[i]+",";
				join=join+" left join sys_zzjg d on z."+arr[i]+"=d.bmbh ";
//			}else if(arr[i].equals("BGFSFS")){
//				strs=strs+"e.zdmc as "+arr[i]+",";
//				join=join+" left join (select zdz,zdmc from sys_sjzd where zl='bgfsfs' and jb=2) e on to_char(z."+arr[i]+")=e.zdz ";
//			}else if(arr[i].equals("YHXTK")){
//				strs=strs+"f.zdmc as "+arr[i]+",";
//				join=join+" left join (select zdz,zdmc from sys_sjzd where zl='yhxtk' and jb=2) f on to_char(z."+arr[i]+")=f.zdz ";
//			}else if(arr[i].equals("JYFYDD")){
//				strs=strs+"g.zdmc as "+arr[i]+",";
//				join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jyfydd' and jb=2) g on to_char(z."+arr[i]+")=g.zdz ";
//			}else if(arr[i].equals("LYFS")){
//				strs=strs+"h.zdmc as "+arr[i]+",";
//				join=join+" left join (select zdz,zdmc from sys_sjzd where zl='lyfs' and jb=2) h on to_char(z."+arr[i]+")=h.zdz ";
//			}else if(arr[i].equals("DJLX")){
//				strs=strs+"i.zdmc as "+arr[i]+",";
//				join=join+" left join (select zdz,zdmc from sys_sjzd where zl='djlx' and jb=2) i on to_char(z."+arr[i]+")=i.zdz ";
//			}else if(arr[i].equals("PZR")){
//				strs=strs+"nvl(k.xgjdry,x.shr) as "+arr[i]+",";
//				join=join+" left join view_shxgjd k on z.id = k.bgbh ";
//				strs=strs+"x.shr as PZR1,";
//			}else if(arr[i].equals("SHR")){
//				strs=strs+"l.xgjdry as "+arr[i]+",";
//				join=join+" left join view_jyxgjd l on z.id = l.bgbh"; 
//			}else if(arr[i].equals("QSR")){
//				strs=strs+" t.ASSIGNEE_ as "+arr[i]+",";
//			    join=join+" left join view_actmeg t on t.id=z.id ";
			}else if(arr[i].equals("FPSJ")||arr[i].equals("BSSJ")||arr[i].equals("BPSJ")||arr[i].equals("PZSJ")||arr[i].equals("JSSJ")||arr[i].equals("GDSJ")){
				strs=strs+"to_char(z."+arr[i]+",'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
//				join=join+" left join view_fpjdsj fp on fp.bgbh=z.id";
//			}else if(arr[i].equals("BSSJ")){
//				strs=strs+"to_char(z."+arr[i]+",'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
////				join=join+" left join view_jyjdsj bs on bs.bgbh=z.id";
//			}else if(arr[i].equals("BPSJ")){
//				strs=strs+"to_char(z."+arr[i]+",'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
////				join=join+" left join view_shjdsj bp on bp.bgbh=z.id";
//			}else if(arr[i].equals("PZSJ")){
//				strs=strs+"to_char(z."+arr[i]+",'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
//			}else if(arr[i].equals("JSSJ")){
//				strs=strs+"to_char(z."+arr[i]+",'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
////				join=join+" left join view_jsjdsj js on js.bgbh=z.id";
//			}else if(arr[i].equals("GDSJ")){
//				strs=strs+"to_char(z.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
//				join=join+" left join view_gdjdsj gd on gd.bgbh=z.id";
//			}else if(arr[i].equals("BZR")){
//				strs=strs+"z."+arr[i]+",";
//				join=join+" left join view_fpjd n on z.id = n.bgbh ";
//				strs=strs+"z.BZR1,";
//				join=join+" left join view_jyjd n1 on z.id = n1.bgbh ";
//			}else if(arr[i].equals("JYJSRQ")){
//				strs=strs+"p.jyjsrq as "+arr[i]+",";
//				join=join+" left join (select to_char(max(jyjsrq),'yyyy-MM-dd')as jyjsrq,bgbh from y_cw_bgsfjl group by bgbh) p on z.ypbh=p.bgbh ";
//			}else if(arr[i].equals("YSFJE")){
//				strs=strs+"q.ysfje as "+arr[i]+",";
//			}else if (arr[i].equals("FFZT")) {
//				strs = strs + "case a." + arr[i] + " when 1 then '已发放' when 0 then '未发放' end as " + arr[i] + ",";
//			}else if (arr[i].equals("DYZT")) {
//				strs = strs + "case a." + arr[i] + " when 1 then '已打印' when 0 then '未打印' end as " + arr[i] + ",";
//			}else if (arr[i].equals("SFJS")) {
//				strs = strs + "case a." + arr[i] + " when 1 then '已解锁' when 0 then '未解锁' end as " + arr[i] + ",";
//			}else if (arr[i].equals("YPYJ")) {
//				strs = strs + "case z." + arr[i] + " when 1 then '已移交' when 0 then '未移交' end as " + arr[i] + ",";
//			}else if (arr[i].equals("YJZT")) {
//				strs = strs + "case z." + arr[i] + " when 1 then '已移交' when 0 then '未移交' end as " + arr[i] + ",";
//			}else if (arr[i].equals("YWBY")) {
//				strs = strs + "case z." + arr[i] + " when 1 then '有' when 0 then '无' end as " + arr[i] + ",";
//			}else if (arr[i].equals("SFWCKCP")) {
//				strs = strs + "case z." + arr[i] + " when 1 then '是' when 0 then '否' end as " + arr[i] + ",";
//			}else if (arr[i].equals("BZFS")) {
//				strs = strs + "j.zdmc as " + arr[i] + ",";
//				join = join + " left join (select zdz,zdmc from sys_sjzd where zl='djlx' and jb=2) j on to_char(a." + arr[i] + ")=j.zdz ";
//			}else if(arr[i].equals("JYRQ")||arr[i].equals("BGBH")||arr[i].equals("BGMC")||arr[i].equals("JSDW1")||arr[i].equals("TJYY")
//					||arr[i].equals("JYJL")||arr[i].equals("BSDX")||arr[i].equals("DYCS")
//					||arr[i].equals("JYQKSM")||arr[i].equals("RZFS")||arr[i].equals("TJR")||arr[i].equals("JSR")){
//				strs=strs+"a."+arr[i]+",";
			}else {
				strs = strs + "z." + arr[i] + ",";
			}
		}
		str=strs+"#"+join+"#";
		return str;
	}
	
	/**
	 * 后台:报告拖期查询
	 * @author liusong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 * @throws ParseException 
	 */
	public List<Map<String, Object>> getBgyqList(String ksmc,String ksyf,String jsyf) throws ParseException{
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd");
		List<Map<String, Object>> BgyqList = dao.getBgyqList(ksmc, ksyf,jsyf);

		for(int i = 0;i < BgyqList.size();i++){
//		首先如果样品状态在批准前，那么久就用当前时间和完成期限相比较
		   Map<String, Object> map = BgyqList.get(i);
			Date pzsj = sdf.parse(BgyqList.get(i).get("pzsj").toString());
			if(BgyqList.get(i).get("wcqx")!=null&&!"".equals(BgyqList.get(i).get("wcqx").toString())){
				Date wcqx = sdf.parse(BgyqList.get(i).get("wcqx").toString());
				//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24. 
				long workDayVal = (wcqx.getTime() - pzsj.getTime())/86400000 + 1;  
	   			//工时的余数  
	   			long remainder = workDayVal % 7; 
	   			//工时向下取整的除数  
	   			double divisor = Math.floor(workDayVal / 7);  
	   			double weekendDay = 2 * divisor;  
	   			//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
	   			@SuppressWarnings("deprecation")
				int nextDay = pzsj.getDay();  
	   			//从起始日期的星期开始 遍历remainder天  
	   			for(long tempDay = remainder; tempDay>=1; tempDay--) {  
	   				//第一天不用加1  
	   				if(tempDay == remainder) {  
	   					nextDay = nextDay + 0;  
	   				} else if(tempDay != remainder) {  
	   					nextDay = nextDay + 1;  
	   				}  
	   				//周日，变更为0  
	   				if(nextDay == 7) {  
	   					nextDay = 0;  
	   				}  
	   				//周六日  
	   				if(nextDay == 0 || nextDay == 6) {  
	   					weekendDay = weekendDay + 1;  
	   				}  
	   			} 
	   		    //实际工时（天） = 起止日期差 - 周六日数目。  
			   	workDayVal = (long) (workDayVal); 
			   	map.put("TQTS", 1-workDayVal);//当前环节
				map.put("COUNT", BgyqList.size());
			}
			}
	
		return BgyqList;
	}
	
	/**
	 * 成本统计导出Excle
	 * @author wangyong
	 * @date 2016年1月26日
	 * @param ksmccx
	 * @param ssyfcx
	 * @throws Exception 
	 */
	@Transactional
	public void exportBgtq(HttpServletRequest request,HttpServletResponse response,String ksmc,String ksyf,String jsyf) throws Exception{
		List<Map<String,Object>> list= getBgyqList(ksmc, ksyf,jsyf);
		String[] header=new String[]{"检验报告编号","主检科室","样品名称","编制人","样品登记时间","审核日期","接收日期","发放日期","检验类别","完成期限","批准日期","拖期天数","拖期原因（检验室）","拖期原因（业务科）","拖期原因（工程技术中心）","拖期原因（设备中心）","拖期原因（行政部）"};
		String[] keys=new String[]{"YPBH","JYKS","YPMC","BZR","DJSJ","BPSJ","JSSJ","FFRQ","JYLX","WCQX","PZSJ","TQTS","","","","",""};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}

