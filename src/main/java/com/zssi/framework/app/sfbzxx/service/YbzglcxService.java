package com.zssi.framework.app.sfbzxx.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.sfbzxx.dao.YsfglcxDao;
import com.zssi.framework.app.sfbzxx.model.YsfBzxx;
import com.zssi.framework.app.util.ExportExcelUtil;
@Service
public class YbzglcxService extends BaseBO<YsfBzxx>{

	@Autowired
	private YsfglcxDao dao;
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-1-14
	 * @param string
	 * @return
	 */
	@Transactional
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
	@Transactional
	public List<Map<String, Object>> getJsfwcxList(Integer start,
			Integer limit, String cs, String cxtj) {
		String[] arr=null;
		String strs="";
		String join="";
//		this.doSomeThing(cs, arr, strs, join);
		if(cs!=null&&!"".equals(cs)){
			arr=cs.split(",");
			for(int i=0;i<arr.length;i++){
				if(i<arr.length-1){
					if (arr[i].equals("JLDW")) {
						strs=strs+"b.zdmc as "+arr[i]+",";
						join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jldw' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
					}else{
						strs=strs+"a."+arr[i]+",";
						}
				}else{
					if (arr[i].equals("JLDW")) {
						strs=strs+"b.zdmc as "+arr[i]+",";
						join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jldw' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
					}else{
						strs=strs+"a."+arr[i]+"";
					}
					}
				}
		}
		return dao.getJsfwcxList(start,limit,strs,join,cxtj);
	
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
	public int getYjsfwcxcxCount(Integer start, Integer limit, String cs,
			String cxtj) {
		String[] arr=null;
		String strs="";
		String join="";
//		this.doSomeThing(cs, arr, strs, join);
		if(cs!=null&&!"".equals(cs)){
			arr=cs.split(",");
			for(int i=0;i<arr.length;i++){
				if(i<arr.length-1){
					if (arr[i].equals("JLDW")) {
						strs=strs+"b.zdmc as "+arr[i]+",";
						join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jldw' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
					}else{
						strs=strs+"a."+arr[i]+",";
						}
				}else{
					if (arr[i].equals("JLDW")) {
						strs=strs+"b.zdmc as "+arr[i]+",";
						join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jldw' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
					}else{
						strs=strs+"a."+arr[i]+"";
					}
					}
				}
			}
		return Integer.parseInt(dao.getYjsfwcxcxCount(start,limit,strs,join,cxtj, join).get(0).get("cnt").toString());
	}
//	
	
//	public int getYjsfwcxcxCount(Integer start, Integer limit,String cs,String cxtj) {
//		String[] arr=null;
//		String strs="";
//		String join="";
//		if(cs!=null&&!"".equals(cs)){
//			String str=this.doSomeThing(cs, arr, strs, join);
//			if(str!=null&&!"".equals(str)){
//				String[] sz=str.split("#");
//				if(sz.length>1){
//					strs=sz[0];
//					join=sz[1];
//				}else{
//					strs=sz[0];
//				}
//			}
//		}
//		return Integer.parseInt(dao.getYjsfwcxcxCount(start,limit,strs,join,cxtj,"Y_YP_YPXX").get(0).get("cnt").toString());
//	}
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
			arr = cs.split(",");
			for(int i=0;i<arr.length;i++){
				if(i<arr.length-1){
					if (arr[i].equals("JLDW")) {
						strs=strs+"b.zdmc as "+arr[i]+",";
						join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jldw' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
					}else{
						strs=strs+"a."+arr[i]+",";
						}
				}else{
					if (arr[i].equals("JLDW")) {
						strs=strs+"b.zdmc as "+arr[i]+",";
						join=join+" left join (select zdz,zdmc from sys_sjzd where zl='jldw' and jb=2) b on to_char(a."+arr[i]+")=b.zdz ";
					}else{
						strs=strs+"a."+arr[i]+"";
					}
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
		List<Map<String,Object>> list=dao.getExcelList(strs, join, cxtj);
		String[] header=btStr;
		String[] keys=arr;
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
}
