package com.zssi.framework.app.tjgl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.tjgl.dao.SbcxDao;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class SbcxService extends BaseBO<YsbXx> {
	@Autowired
	private SbcxDao dao;

	@Transactional
	public List<Map<String, Object>> getZdmc(String tabName) {
		return dao.getZdmc(tabName);
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
		return dao.getYpcxList(start,limit,strs,join,cxtj,"Y_SB_XX");
	}
	
	/**
	 * 
	 * @author wangyong
	 * @date 2016年6月1日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getJdzs(Integer id) {
		return dao.getJdzs(id);
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
		return Integer.parseInt(dao.getYpcxCount(start,limit,strs,join,cxtj,"Y_SB_XX").get(0).get("cnt").toString());
	}
	/**
	 * excel导出
	 *  @author liangkaidi
	 * @date 2016年1月14日
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
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
		if (bt != null && !"".equals(bt)) {
			bt=java.net.URLDecoder.decode(bt,"UTF-8");
			btStr = bt.split(",");
		}
		if(cxtj!=null&&!"".equals(cxtj)){
			cxtj=java.net.URLDecoder.decode(cxtj,"UTF-8");
		}
		List<Map<String,Object>> list=dao.getExcelList(strs, join, cxtj, "Y_SB_XX");
		String[] header=btStr;
		String[] keys=arr;
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-1-18
	 * @param cs
	 * @param arr
	 * @param strs
	 * @param join
	 * @return
	 */
	public String doSomeThing(String cs,String[] arr,String strs,String join){
		String str="";
		arr=cs.split(",");
		for(int i=0;i<arr.length;i++){
			if(i<arr.length-1){
				if(arr[i].equals("CCRQ")||arr[i].equals("GMRQ")||arr[i].equals("SCJDRQ")
						   ||arr[i].equals("XCJDRQ")||arr[i].equals("TYRQ")||arr[i].equals("QYSJ")||arr[i].equals("BFRQ")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+",";
				}else if(arr[i].equals("SYKS")){
					strs=strs+"c.bmmc as "+arr[i]+",";
					join=join+" left join sys_zzjg c on a."+arr[i]+"=c.bmbh ";
				}else if(arr[i].equals("SFYCZGC")){
					strs=strs+"e.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfyczgc' and jb=2) e on to_char(a."+arr[i]+")=e.zdz ";
				}else if(arr[i].equals("SFYQJHC")){
					strs=strs+"f.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfyqjhc' and jb=2) f on to_char(a."+arr[i]+")=f.zdz ";
				}else if(arr[i].equals("SFYSYJL")){
					strs=strs+"g.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfysyjl' and jb=2) g on to_char(a."+arr[i]+")=g.zdz ";
				}else if(arr[i].equals("SFYGNJC")){
					strs=strs+"h.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfygnjc' and jb=2) h on to_char(a."+arr[i]+")=h.zdz ";
				}else if(arr[i].equals("JYZQ")){
					strs=strs+"i.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jyzq' and jb=2) i on to_char(a."+arr[i]+")=i.zdz ";
				}else if(arr[i].equals("SBZT")){
					strs=strs+"j.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sbzt' and jb=2) j on to_char(a."+arr[i]+")=j.zdz ";
				}else if(arr[i].equals("YQZK")){
					strs=strs+"k.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='syzt' and jb=2) k on to_char(a."+arr[i]+")=k.zdz ";
				}else if(arr[i].equals("SYZT")){
					strs=strs+"l.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='syzt' and jb=2) l on to_char(a."+arr[i]+")=l.zdz ";
				}else if(arr[i].equals("DW")){
					strs=strs+"m.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='dw' and jb=2) m on to_char(a."+arr[i]+")=m.zdz ";
				}else{
					strs=strs+"a."+arr[i]+",";
				}
			}else{
				if(arr[i].equals("CYRQ")||arr[i].equals("DJSJ")||arr[i].equals("DYRQ")
				   ||arr[i].equals("LYRQ")||arr[i].equals("WCQX")||arr[i].equals("DJRQ")||arr[i].equals("XGSJ")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+"";
				}else if(arr[i].equals("SYKS")){
					strs=strs+"c.bmmc as "+arr[i]+"";
					join=join+" left join sys_zzjg c on a."+arr[i]+"=c.bmbh ";
				}else if(arr[i].equals("SFYCZGC")){
					strs=strs+"e.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfyczgc' and jb=2) e on to_char(a."+arr[i]+")=e.zdz ";
				}else if(arr[i].equals("SFYQJHC")){
					strs=strs+"f.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfyqjhc' and jb=2) f on to_char(a."+arr[i]+")=f.zdz ";
				}else if(arr[i].equals("SFYSYJL")){
					strs=strs+"g.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfysyjl' and jb=2) g on to_char(a."+arr[i]+")=g.zdz ";
				}else if(arr[i].equals("SFYGNJC")){
					strs=strs+"h.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sfygnjc' and jb=2) h on to_char(a."+arr[i]+")=h.zdz ";
				}else if(arr[i].equals("JYZQ")){
					strs=strs+"i.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jyzq' and jb=2) i on to_char(a."+arr[i]+")=i.zdz ";
				}else if(arr[i].equals("SBZT")){
					strs=strs+"j.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='sbzt' and jb=2) j on to_char(a."+arr[i]+")=j.zdz ";
				}else if(arr[i].equals("YQZK")){
					strs=strs+"k.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='syzt' and jb=2) k on to_char(a."+arr[i]+")=k.zdz ";
				}else if(arr[i].equals("SYZT")){
					strs=strs+"l.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='syzt' and jb=2) l on to_char(a."+arr[i]+")=l.zdz ";
				}else if(arr[i].equals("DW")){
					strs=strs+"m.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='dw' and jb=2) m on to_char(a."+arr[i]+")=m.zdz ";
				}else{
					strs=strs+"a."+arr[i]+"";
				}
			}
		}
		str=strs+"#"+join+"#";
		return str;
	}
}




