package com.zssi.framework.app.khgl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.khgl.dao.YkhKhxxcxDao;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YkhKhxxcxService extends BaseBO<YkhKhxx>{
@Autowired
private YkhKhxxcxDao dao;

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
public List<Map<String, Object>> getKhxxcxList(Integer start, Integer limit,String cs,String cxtj) {
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
	return dao.getKhxxcxList(start,limit,strs,join,cxtj,"Y_KH_KHXX");
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
public int getKhxxcxcxCount(Integer start, Integer limit,String cs,String cxtj) {
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
	return Integer.parseInt(dao.getKhxxcxcxCount(start,limit,strs,join,cxtj,"Y_KH_KHXX").get(0).get("cnt").toString());
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
		List<Map<String,Object>> list=dao.getExcelList(strs, join, cxtj, "Y_KH_KHXX");
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
				if(arr[i].equals("CLSJ")||arr[i].equals("LRSJ")||arr[i].equals("SR")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+",";
				}else{
					strs=strs+"a."+arr[i]+",";
				}
			}else{
				if(arr[i].equals("CLSJ")||arr[i].equals("LRSJ")||arr[i].equals("SR")){
					strs=strs+"to_char(a."+arr[i]+",'yyyy-mm-dd') as "+arr[i]+"";
				}else{
					strs=strs+"a."+arr[i]+"";
				}
			}
		}
		str=strs+"#"+join+"#";
		return str;
	}
}




