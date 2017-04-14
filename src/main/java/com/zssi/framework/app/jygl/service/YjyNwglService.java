package com.zssi.framework.app.jygl.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyNwglDao;
import com.zssi.framework.app.jygl.dao.YjyNwmxDao;
import com.zssi.framework.app.jygl.model.YjyNwgl;
import com.zssi.framework.app.jygl.model.YjyNwmx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * 内委管理
 * @author liujiansen
 * @date 2015年12月30日
 */
@Service
public class YjyNwglService extends BaseBO<YjyNwgl>{

	@Autowired
	private YjyNwglDao dao;
	@Autowired
	private YjyNwmxDao mxDao;
	
	/**
	 * 内委管理列表
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getNwglList(Integer start,Integer limit,String canshu){
		return dao.getNwglList(start, limit, canshu);
	}
	
	/**
	 * 删除
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}

	/**
	 * 获取样品信息
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param cpmccx
	 * @param xmmccx
	 * @param jzcs
	 * @return
	 */
	public List<Map<String, Object>> getYpxx(String cpbhcx,String cpmccx, String start,String end,String jzcs) {
		return dao.getYpxx(cpbhcx, cpmccx, start, end, jzcs);
	}

	/**
	 * 根据部门编号获取部门名称
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBmmc(String bmbh) {
		return dao.getBmmc(bmbh);
	}
	
	/**
	 * 获取信息
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param ypmc
	 * @param wtdw
	 * @param djsj
	 * @return
	 */
	public List<Map<String, Object>> getYpxxList(String ypmc,String wtdw,String djsj) {
		String[] ypmcArr=ypmc.split(",");
		String[] wtdwArr=wtdw.split(",");
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		if(ypmcArr.length!=0&&wtdwArr.length!=0&&wtdwArr.length==ypmcArr.length){
			for(int i=0;i<ypmcArr.length;i++){
				List<Map<String, Object>> ypxx=dao.getYpxxList(ypmcArr[i], wtdwArr[i], djsj);
				Map<String, Object> map=new HashMap<String, Object>();
				if(ypxx.size()!=0){
					String ypbh="";
					for(int j=0;j<ypxx.size();j++){
						map.put("ypmc", ypxx.get(j).get("ypmc"));
						map.put("ggxh", ypxx.get(j).get("ggxh"));
						map.put("wtdw", ypxx.get(j).get("wtdw"));
						map.put("jyyj", ypxx.get(j).get("jyyj"));
						if(j<ypxx.size()-1){
							ypbh=ypbh+ypxx.get(j).get("ypbh")+",";
						}else{
							ypbh=ypbh+ypxx.get(j).get("ypbh");
						}
						map.put("ypbh", ypbh);
					}
				}
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * 获取检验项目
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getJyxm(String ypbh) {
		String[] arr=ypbh.split(",");
		String ypbhs="";
		for(int i=0;i<arr.length;i++){
			if(i<arr.length-1){
				ypbhs=ypbhs+"'"+arr[i]+"',";
			}else{
				ypbhs=ypbhs+"'"+arr[i]+"'";
			}
		}
		return dao.getJyxm(ypbhs);
	}
	
	/**
	 * 根据部门编号获取所属部门
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBm(String bmbh) {
		return dao.getBmmcList(bmbh);
	}

	/**
	 * 获取人员
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getYhbyBm(String bmbh) {
		return dao.getYhbyBm(bmbh);
	}

	/**
	 * 新增保存
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	public String saveLzd(HttpServletRequest request, HttpServletResponse response) {
		String str="0";
		SysYh user=AppUtil.getCurrentUser();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String yqwcrq=request.getParameter("yqwcrq");
		Integer num=Integer.parseInt(request.getParameter("num"));
		Date date=new Date();
		if(yqwcrq!=null&&!"".equals(yqwcrq)){
			try {
				date=sim.parse(yqwcrq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		YjyNwgl nwgl=new YjyNwgl();
		nwgl.setWtbm(user.getBmbh());
		nwgl.setCjbm(request.getParameter("cjbm"));
		nwgl.setWtrq(new Date());
		nwgl.setYqwcrq(date);
		nwgl.setJbr(user.getUsername());
		nwgl.setJbrq(new Date());
		nwgl.setJsr(request.getParameter("jsr"));
		nwgl.setLzdzt(0);
		nwgl.setWtyps(num);
		Integer id=dao.save(nwgl);
		for(int i=1;i<=num;i++){
			YjyNwmx mx=new YjyNwmx();
			mx.setBgbh(request.getParameter("ypbh"+i));
			mx.setGgxh(request.getParameter("ggxh"+i));
			mx.setNwbh(id);
			mx.setYpmc(request.getParameter("ypmc"+i));
			mx.setJyyj(request.getParameter("jyyj"+i));
			mx.setJyxm(request.getParameter("jyxm"+i));
			String jyfyStr=request.getParameter("je"+i);
			if(jyfyStr!=null&&!"".equals(jyfyStr)){
				mx.setJyfy(Integer.parseInt(jyfyStr));
			}
			mx.setSfty(Integer.parseInt(request.getParameter("sfty"+i)));
			String ypbgqx=request.getParameter("bcqx"+i);
			if(ypbgqx!=null&&!"".equals(ypbgqx)){
				mx.setYpbgqx(ypbgqx);
			}else{
				mx.setYpbgqx("/");
			}
//			mx.setWtdw(request.getParameter("ypbh"+i));
			mxDao.save(mx);
		}
		str="1";
		return str;
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getNwgl(String id){
		return dao.getNwgl(id);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getNwmx(String id){
		return dao.getNwmx(id);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getNwmxList(String id){
		return dao.getNwmxList(id);
	}

	/**
	 * 更新费用
	 * @author liujiansen
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	public String saveFy(HttpServletRequest request,HttpServletResponse response) {
		String str="0";
		String num=request.getParameter("num");
		if(num==null||"".equals(num)){
			num="0";
		}
		int size=Integer.parseInt(num);
		int zje=0;
		Integer nwbh=Integer.parseInt(request.getParameter("nwbh"));
		for(int i=1;i<=size;i++){
			Integer id=Integer.parseInt(request.getParameter("mxid"+i));
			Integer je=Integer.parseInt(request.getParameter("je"+i));
			YjyNwmx mx=mxDao.get(id);
			mx.setJyfy(je);
			mxDao.update(mx);
			zje=zje+je;
		}
		YjyNwgl nwgl=dao.get(nwbh);
		if(zje!=0){
			nwgl.setJyfy(zje);
		}
		nwgl.setJsrq(new Date());
		nwgl.setLzdzt(1);
		dao.update(nwgl);
		str="1";
		return str;
	}
	
	/**
	 * 获取角色信息
	 * @author liujiansen
	 * @date 2016年1月4日
	 * @param userName
	 * @return
	 */
	public String getYhJs(String userName){
		String str="0";
		List<Map<String,Object>> yhjs=dao.getYhJs(userName);
		for(int i=0;i<yhjs.size();i++){
			if("ROLE_YKSZR".equals(yhjs.get(i).get("jsmc"))){
				str="1";
			}
		}
		return str;
	}

	/**
	 * 批阅
	 * @author liujiansen
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	public String saveSh(HttpServletRequest request,HttpServletResponse response) {
		String str="0";
		SysYh user=AppUtil.getCurrentUser();
		Integer nwbh=Integer.parseInt(request.getParameter("nwbh"));
		YjyNwgl nwgl=dao.get(nwbh);
		nwgl.setBmld(user.getUsername());
		nwgl.setQzrq(new Date());
		nwgl.setLzdzt(2);
		dao.update(nwgl);
		str="1";
		return str;
	}

	/**
	 * 修改
	 * @author liujiansen
	 * @date 2016年1月6日
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	public String updateLzd(HttpServletRequest request,
			HttpServletResponse response) {
		String str="0";
		String nwbh=request.getParameter("nwbh");
		SysYh user=AppUtil.getCurrentUser();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String yqwcrq=request.getParameter("yqwcrq");
		Integer num=Integer.parseInt(request.getParameter("num"));
		Date date=new Date();
		if(yqwcrq!=null&&!"".equals(yqwcrq)){
			try {
				date=sim.parse(yqwcrq);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		YjyNwgl nwgl=dao.get(Integer.parseInt(nwbh));
		nwgl.setWtbm(user.getBmbh());
		nwgl.setCjbm(request.getParameter("cjbm"));
		nwgl.setWtrq(new Date());
		nwgl.setYqwcrq(date);
		nwgl.setJbr(user.getUsername());
		nwgl.setJbrq(new Date());
		nwgl.setJsr(request.getParameter("jsr"));
		nwgl.setLzdzt(0);
		nwgl.setWtyps(num);
		dao.update(nwgl);
		mxDao.deleteByNwbh(Integer.parseInt(nwbh));
		for(int i=1;i<=num;i++){
			YjyNwmx mx=new YjyNwmx();
			mx.setBgbh(request.getParameter("ypbh"+i));
			if(request.getParameter("ypbh"+i)!=null&&!"".equals(request.getParameter("ypbh"+i))){
				mx.setGgxh(request.getParameter("ggxh"+i));
				mx.setNwbh(Integer.parseInt(nwbh));
				mx.setYpmc(request.getParameter("ypmc"+i));
				mx.setJyyj(request.getParameter("jyyj"+i));
				mx.setJyxm(request.getParameter("jyxm"+i));
				String jyfyStr=request.getParameter("je"+i);
				if(jyfyStr!=null&&!"".equals(jyfyStr)){
					mx.setJyfy(Integer.parseInt(jyfyStr));
				}
				mx.setSfty(Integer.parseInt(request.getParameter("sfty"+i)));
				String ypbgqx=request.getParameter("bcqx"+i);
				if(ypbgqx!=null&&!"".equals(ypbgqx)){
					mx.setYpbgqx(ypbgqx);
				}else{
					mx.setYpbgqx("/");
				}
//				mx.setWtdw(request.getParameter("ypbh"+i));
				mxDao.save(mx);
			}
			
		}
		str="1";
		return str;
	}
	
	
}
