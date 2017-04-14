package com.zssi.framework.app.jsfwgl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.jsfwgl.dao.YjsfwcxDao;
import com.zssi.framework.app.jsfwgl.model.YjsfwXyxx;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YjsfwcxService extends BaseBO<YjsfwXyxx>{
	@Autowired
	private YjsfwcxDao dao;
	@Transactional
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-1-13
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getZdmc(String tabName) {
		return dao.getZdmc(tabName);
	}
	
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-1-14
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @return
	 */
	public List<Map<String, Object>> getJsfwcxList(Integer start, Integer limit,String cs,String cxtj) {
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
		return dao.getJsfwcxList(start,limit,strs,join,cxtj,"Y_JSFW_XYXX");
	}

/**
 * 
 * @author liangkaidi
 * @date 2016-1-13
 * @param start
 * @param limit
 * @param cs
 * @param cxtj
 * @return
 */
	public int getYjsfwcxcxCount(Integer start, Integer limit,String cs,String cxtj) {
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
		return Integer.parseInt(dao.getYjsfwcxcxCount(start,limit,strs,join,cxtj,"Y_JSFW_XYXX").get(0).get("cnt").toString());
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
		if (bt != null && !"".equals(bt)) {
			bt=java.net.URLDecoder.decode(bt,"UTF-8");
			btStr = bt.split(",");
		}
		if(cxtj!=null&&!"".equals(cxtj)){
			cxtj=java.net.URLDecoder.decode(cxtj,"UTF-8");
		}
		List<Map<String,Object>> list=dao.getExcelList(strs, join, cxtj, "Y_JSFW_XYXX");
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
				if(arr[i].equals("DJRQ")||arr[i].equals("SXRQ")||arr[i].equals("ZZRQ")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+",";
				}else if(arr[i].equals("FKFS")){
					strs=strs+"b.zdmc as "+arr[i]+",";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='fkfs' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
				}else if(arr[i].equals("YEKS_ID")){
					strs=strs+"c.bmmc as "+arr[i]+",";
					join=join+" left join sys_zzjg c on a."+arr[i]+"=c.bmbh ";
				}else if(arr[i].equals("JYKS_ID")){
					strs=strs+"d.bmmc as "+arr[i]+",";
					join=join+" left join sys_zzjg d on a."+arr[i]+"=d.bmbh ";
				}else if(arr[i].equals("KS_ID")){
					strs=strs+"e.bmmc as "+arr[i]+",";
					join=join+" left join sys_zzjg e on a."+arr[i]+"=e.bmbh ";
				}else{
					strs=strs+"a."+arr[i]+",";
				}
			}else{
				if(arr[i].equals("DJRQ")||arr[i].equals("SXRQ")||arr[i].equals("ZZRQ")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+"";
				}else if(arr[i].equals("FKFS")){
					strs=strs+"b.zdmc as "+arr[i]+"";
					join=join+" left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on a."+arr[i]+"=b.zdz ";
				}else if(arr[i].equals("YEKS_ID")){
					strs=strs+"c.bmmc as "+arr[i]+"";
					join=join+" left join sys_zzjg c on a."+arr[i]+"=c.bmbh ";
				}else if(arr[i].equals("JYKS_ID")){
					strs=strs+"d.bmmc as "+arr[i]+"";
					join=join+" left join sys_zzjg d on a."+arr[i]+"=d.bmbh ";
				}else if(arr[i].equals("KS_ID")){
					strs=strs+"e.zdmc as "+arr[i]+"";
					join=join+" left join sys_zzjg e on a."+arr[i]+"=e.bmbh ";
				}else{
					strs=strs+"a."+arr[i]+"";
				}
			}
		}
		str=strs+"#"+join+"#";
		return str;
	}
}




