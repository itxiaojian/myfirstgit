package com.zssi.framework.app.tjgl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.tjgl.dao.YpcxDao;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.ypgl.model.YypYpxx;

@Service
public class YpcxService extends BaseBO<YypYpxx> {
	@Autowired
	private YpcxDao dao;
	
	@Transactional
	public List<Map<String, Object>> getZdmc(String tabName) {
		return dao.getZdmc(tabName);
	}
	
	@Transactional
	public List<Map<String, Object>> getZdmc1(String tabName,String tabName1) {
		return dao.getZdmc1(tabName,tabName1);
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
	public List<Map<String, Object>> getYpcxList(Integer start, Integer limit,String cs,String cxtj) {
		String[] arr=null;
		String strs="";
		String join="";
		if(cs!=null&&!"".equals(cs)){
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
		return dao.getYpcxList(start,limit,strs,join,cxtj,"Y_YP_YPXX");
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
	public int getYpcxCount(Integer start, Integer limit,String cs,String cxtj) {
		String[] arr=null;
		String strs="";
		String join="";
		if(cs!=null&&!"".equals(cs)){
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
		return Integer.parseInt(dao.getYpcxCount(start,limit,strs,join,cxtj,"Y_YP_YPXX").get(0).get("cnt").toString());
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param cs
	 * @param arr
	 * @param strs
	 * @param join
	 */
	public String doSomeThing(String cs,String[] arr,String strs,String join){
		String str="";
		arr=cs.split(",");
		for(int i=0;i<arr.length;i++){
			if(i<arr.length-1){
				if(arr[i].equals("CYRQ")||arr[i].equals("DJSJ")||arr[i].equals("DYRQ")
				   ||arr[i].equals("LYRQ")||arr[i].equals("WCQX")||arr[i].equals("DJRQ")||arr[i].equals("XGSJ")||arr[i].equals("JSYJZRQ")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+",";
				}else if(arr[i].equals("FFRQ") || arr[i].equals("TJRQ")|| arr[i].equals("BGBZRQ") || arr[i].equals("BGDYSJ")){
					strs = strs + "to_char(z." + arr[i] + ",'yyyy-mm-dd') as "+ arr[i] + ",";
				}else if(arr[i].equals("YPJYZT")){
					strs=strs+"b.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on a."+arr[i]+"=b.zdz ";
				}else if(arr[i].equals("YWKS")){
					strs=strs+"c.bmmc as "+arr[i]+",";
					join=join+" left join sys_zzjg c on a."+arr[i]+"=c.bmbh ";
				}else if(arr[i].equals("JYKS")){
					strs=strs+"d.bmmc as "+arr[i]+",";
					join=join+" left join sys_zzjg d on a."+arr[i]+"=d.bmbh ";
				}else if(arr[i].equals("BGFSFS")){
					strs=strs+"e.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='bgfsfs' and jb=2) e on to_char(a."+arr[i]+")=e.zdz ";
				}else if(arr[i].equals("YHXTK")){
					strs=strs+"f.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='yhxtk' and jb=2) f on to_char(a."+arr[i]+")=f.zdz ";
				}else if(arr[i].equals("JYFYDD")){
					strs=strs+"g.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jyfydd' and jb=2) g on to_char(a."+arr[i]+")=g.zdz ";
				}else if(arr[i].equals("LYFS")){
					strs=strs+"h.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='lyfs' and jb=2) h on to_char(a."+arr[i]+")=h.zdz ";
				}else if(arr[i].equals("DJLX")){
					strs=strs+"i.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='djlx' and jb=2) i on to_char(a."+arr[i]+")=i.zdz ";
				}else if(arr[i].equals("PZR")){
					strs=strs+"nvl(k.xgjdry,x.shr) as "+arr[i]+",";
					join=join+" left join view_shxgjd k on a.id = k.bgbh ";
					strs=strs+"x.shr as PZR1,";
				}else if(arr[i].equals("SHR")){
					strs=strs+"l.xgjdry as "+arr[i]+",";
					join=join+" left join view_jyxgjd l on a.id = l.bgbh";
				}else if(arr[i].equals("QSR")){
					strs=strs+" t.ASSIGNEE_ as "+arr[i]+",";
				    join=join+" left join view_actmeg t on t.id=a.id ";
				}else if(arr[i].equals("FPSJ")){
					strs=strs+"to_char(fp.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
					join=join+" left join view_fpjdsj fp on fp.bgbh=a.id";
				}else if(arr[i].equals("BSSJ")){
					strs=strs+"to_char(bs.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
					join=join+" left join view_jyjdsj bs on bs.bgbh=a.id";
				}else if(arr[i].equals("BPSJ")){
					strs=strs+"to_char(bp.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
					join=join+" left join view_shjdsj bp on bp.bgbh=a.id";
				}else if(arr[i].equals("PZSJ")){
					strs=strs+"to_char(x.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
				}else if(arr[i].equals("JSSJ")){
					strs=strs+"to_char(js.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
					join=join+" left join view_jsjdsj js on js.bgbh=a.id";
				}else if(arr[i].equals("GDSJ")){
					strs=strs+"to_char(gd.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
					join=join+" left join view_gdjdsj gd on gd.bgbh=a.id";
				}else if(arr[i].equals("BZR")){
					strs=strs+"n.xgjdry as "+arr[i]+",";
					join=join+" left join view_fpjd n on a.id = n.bgbh ";
					strs=strs+"n1.shr as BZR1,";
					join=join+" left join view_jyjd n1 on z.id = n1.bgbh ";
				}else if(arr[i].equals("JYJSRQ")){
					strs=strs+"p.jyjsrq as "+arr[i]+",";
					join=join+" left join (select to_char(max(jyjsrq),'yyyy-MM-dd')as jyjsrq,bgbh from y_cw_bgsfjl group by bgbh)p on a.ypbh=p.bgbh ";
				}else if(arr[i].equals("YSFJE")){
					strs=strs+"q.ysfje as "+arr[i]+",";
				}else if (arr[i].equals("FFZT")) {
					strs = strs + "case z." + arr[i] + " when 1 then '已发放' when 0 then '未发放' end as " + arr[i] + ",";
				}else if (arr[i].equals("DYZT")) {
					strs = strs + "case z." + arr[i] + " when 1 then '已打印' when 0 then '未打印' end as " + arr[i] + ",";
				}else if (arr[i].equals("SFJS")) {
					strs = strs + "case z." + arr[i] + " when 1 then '已解锁' when 0 then '未解锁' end as " + arr[i] + ",";
				}else if (arr[i].equals("YPYJ")) {
					strs = strs + "case a." + arr[i] + " when 1 then '已移交' when 0 then '未移交' end as " + arr[i] + ",";
				}else if (arr[i].equals("YJZT")) {
					strs = strs + "case a." + arr[i] + " when 1 then '已移交' when 0 then '未移交' end as " + arr[i] + ",";
				}else if (arr[i].equals("YWBY")) {
					strs = strs + "case a." + arr[i] + " when 1 then '有' when 0 then '无' end as " + arr[i] + ",";
				}else if (arr[i].equals("SFWCKCP")) {
					strs = strs + "case a." + arr[i] + " when 1 then '是' when 0 then '否' end as " + arr[i] + ",";
				}else if (arr[i].equals("BZFS")) {
					strs = strs + "j.zdmc as " + arr[i] + ",";
					join = join + " left join (select zdz,zdmc from sys_sjzd where zl='djlx' and jb=2) j on to_char(z." + arr[i] + ")=j.zdz ";
				}else if(arr[i].equals("JYRQ")||arr[i].equals("BGBH")||arr[i].equals("BGMC")||arr[i].equals("JSDW1")||arr[i].equals("TJYY")
						||arr[i].equals("JYJL")||arr[i].equals("BSDX")||arr[i].equals("DYCS")
						||arr[i].equals("JYQKSM")||arr[i].equals("RZFS")||arr[i].equals("TJR")||arr[i].equals("JSR")){
					strs=strs+"z."+arr[i]+",";
				}else{
					strs=strs+"a."+arr[i]+",";
				}
			}else{
				if(arr[i].equals("CYRQ")||arr[i].equals("DJSJ")||arr[i].equals("DYRQ")
						   ||arr[i].equals("LYRQ")||arr[i].equals("WCQX")||arr[i].equals("DJRQ")||arr[i].equals("XGSJ")||arr[i].equals("JSYJZRQ")){
							strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+"";
						}else if(arr[i].equals("FFRQ") || arr[i].equals("TJRQ") || arr[i].equals("BGBZRQ")|| arr[i].equals("BGDYSJ")){
							strs = strs + "to_char(z." + arr[i] + ",'yyyy-mm-dd') as "+ arr[i] + "";
						}else if(arr[i].equals("YPJYZT")){
							strs=strs+"b.zdmc as "+arr[i]+"";
							join=join+" left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
						}else if(arr[i].equals("YWKS")){
							strs=strs+"c.bmmc as "+arr[i]+"";
							join=join+" left join sys_zzjg c on a."+arr[i]+"=c.bmbh ";
						}else if(arr[i].equals("JYKS")){
							strs=strs+"d.bmmc as "+arr[i]+"";
							join=join+" left join sys_zzjg d on a."+arr[i]+"=d.bmbh ";
						}else if(arr[i].equals("BGFSFS")){
							strs=strs+"e.zdmc as "+arr[i]+"";
							join=join+" left join (select zdz,zdmc from sys_sjzd where zl='bgfsfs' and jb=2) e on to_char(a."+arr[i]+")=e.zdz ";
						}else if(arr[i].equals("YHXTK")){
							strs=strs+"f.zdmc as "+arr[i]+"";
							join=join+" left join (select zdz,zdmc from sys_sjzd where zl='yhxtk' and jb=2) f on to_char(a."+arr[i]+")=f.zdz ";
						}else if(arr[i].equals("JYFYDD")){
							strs=strs+"g.zdmc as "+arr[i]+"";
							join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jyfydd' and jb=2) g on to_char(a."+arr[i]+")=g.zdz ";
						}else if(arr[i].equals("LYFS")){
							strs=strs+"h.zdmc as "+arr[i]+"";
							join=join+" left join (select zdz,zdmc from sys_sjzd where zl='lyfs' and jb=2) h on to_char(a."+arr[i]+")=h.zdz ";
						}else if(arr[i].equals("DJLX")){
							strs=strs+"i.zdmc as "+arr[i]+"";
							join=join+" left join (select zdz,zdmc from sys_sjzd where zl='djlx' and jb=2) i on to_char(a."+arr[i]+")=i.zdz ";
						}else if(arr[i].equals("PZR")){
							strs=strs+"nvl(k.xgjdry,x.shr) as "+arr[i]+"";
							join=join+" left join view_shxgjd k on a.id = k.bgbh ";
							strs=strs+"x.shr as PZR1 ";
						}else if(arr[i].equals("SHR")){
							strs=strs+"l.xgjdry as "+arr[i]+"";
							join=join+" left join view_jyxgjd l on z.id = l.bgbh";
						}else if(arr[i].equals("QSR")){
							strs=strs+" t.ASSIGNEE_ as "+arr[i]+"";
						    join=join+" left join view_actmeg t on t.id=a.id ";
						}else if(arr[i].equals("FPSJ")){
							strs=strs+"to_char(fp.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+"";
							join=join+" left join view_fpjdsj fp on fp.bgbh=a.id";
						}else if(arr[i].equals("BSSJ")){
							strs=strs+"to_char(bs.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+"";
							join=join+" left join view_jyjdsj bs on bs.bgbh=a.id";
						}else if(arr[i].equals("BPSJ")){
							strs=strs+"to_char(bp.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+"";
							join=join+" left join view_shjdsj bp on bp.bgbh=a.id";
						}else if(arr[i].equals("PZSJ")){
							strs=strs+"to_char(x.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+"";
						}else if(arr[i].equals("JSSJ")){
							strs=strs+"to_char(js.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+",";
							join=join+" left join view_jsjdsj js on js.bgbh=a.id";
						}else if(arr[i].equals("GDSJ")){
							strs=strs+"to_char(gd.shsj,'yyyy-MM-dd HH24:mi:ss') as "+arr[i]+"";
							join=join+" left join view_gdjdsj gd on gd.bgbh=a.id";
						}else if(arr[i].equals("BZR")){
							strs=strs+"n.xgjdry as "+arr[i]+"";
							join=join+" left join view_fpjd n on a.id = n.bgbh ";
							strs=strs+"n1.shr as BZR1";
							join=join+" left join view_jyjd n1 on z.id = n1.bgbh ";
						}else if(arr[i].equals("JYJSRQ")){
							strs=strs+"p.jyjsrq as "+arr[i]+"";
							join=join+" left join (select max(to_char(jyjsrq,'yyyy-MM-dd'))as jyjsrq,bgbh from y_cw_bgsfjl group by bgbh) p on a.ypbh=p.bgbh ";
						}else if(arr[i].equals("YSFJE")){
							strs=strs+"q.ysfje as "+arr[i]+"";
						}else if (arr[i].equals("FFZT")) {
							strs = strs + "case z." + arr[i] + " when 1 then '已发放' when 0 then '未发放' end as " + arr[i] + "";
						}else if (arr[i].equals("DYZT")) {
							strs = strs + "case z." + arr[i] + " when 1 then '已打印' when 0 then '未打印' end as " + arr[i] + "";
						}else if (arr[i].equals("SFJS")) {
							strs = strs + "case z." + arr[i] + " when 1 then '已解锁' when 0 then '未解锁' end as " + arr[i] + "";
						}else if (arr[i].equals("YPYJ")) {
							strs = strs + "case a." + arr[i] + " when 1 then '已移交' when 0 then '未移交' end as " + arr[i] + "";
						}else if (arr[i].equals("YJZT")) {
							strs = strs + "case a." + arr[i] + " when 1 then '已移交' when 0 then '未移交' end as " + arr[i] + "";
						}else if (arr[i].equals("YWBY")) {
							strs = strs + "case a." + arr[i] + " when 1 then '有' when 0 then '无' end as " + arr[i] + "";
						}else if (arr[i].equals("SFWCKCP")) {
							strs = strs + "case a." + arr[i] + " when 1 then '是' when 0 then '否' end as " + arr[i] + "";
						}else if (arr[i].equals("BZFS")) {
							strs = strs + "j.zdmc as " + arr[i] + "";
							join = join + " left join (select zdz,zdmc from sys_sjzd where zl='djlx' and jb=2) j on to_char(z." + arr[i] + ")=j.zdz ";
						}else if(arr[i].equals("JYRQ")||arr[i].equals("BGBH")||arr[i].equals("BGMC")||arr[i].equals("JSDW1")||arr[i].equals("TJYY")
								||arr[i].equals("JYJL")||arr[i].equals("BSDX")||arr[i].equals("DYCS")
								||arr[i].equals("JYQKSM")||arr[i].equals("RZFS")||arr[i].equals("TJR")||arr[i].equals("JSR")){
							strs=strs+"z."+arr[i]+"";
						}else{
							strs=strs+"a."+arr[i]+"";
						}
			}
		}
		str=strs+"#"+join+"#";
		return str;
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
		String[] btNew = null;
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
		btNew = cs.split(",");
		if(btNew.length>0){
			for(int i=0;i<btNew.length;i++){
				if(i<btNew.length-1){
//					if(btNew[i].equals("BZR")||btNew[i].equals("SHR")||btNew[i].equals("PZR")||btNew[i].equals("QSR")){
//						str=str+"";
////						System.out.println("===================1111====="+btNew[i]);
//					}else{
						str=str+"'"+btNew[i]+"',";
//					}
				}else{
					str=str+"'"+btNew[i]+"'";
				}
			}
		}
		List<Map<String, Object>> btList = dao.getBt(str);
//		int k=0;
		for(int i=0;i<btNew.length;i++){
//			if(btNew[i].equals("BZR")){
//				btNew[i]="编制人";
//				k++;
//				}
//			if(btNew[i].equals("SHR")){
//				btNew[i]="审核人";
//				k++;
//			}
//			if(btNew[i].equals("PZR")){
//				btNew[i]="批准人";
//				k++;
//			}
//			if(btNew[i].equals("QSR")){
//				btNew[i]="签收人";
//				k++;
//			}
////			System.out.println("===================2222====="+btNew[i]);
//			if(btNew[i]!="编制人" && btNew[i]!="审核人"&& btNew[i]!="批准人" && btNew[i]!="签收人"){
				btNew[i]=btList.get(i).get("name").toString();
//			}
		}
		if(cxtj!=null&&!"".equals(cxtj)){
			cxtj=java.net.URLDecoder.decode(cxtj,"UTF-8");
		}
		List<Map<String,Object>> list=dao.getExcelList(strs, join, cxtj, "Y_YP_YPXX");
		String[] header=btNew;
		String[] keys=arr;
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}
