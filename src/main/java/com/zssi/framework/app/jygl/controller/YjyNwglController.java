package com.zssi.framework.app.jygl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.service.YjyNwglService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;

/**
 * 内委管理
 * @author liujiansen
 * @date 2015年12月30日
 */
@Controller
@RequestMapping("/jygl/YjyNwgl")
public class YjyNwglController extends BaseController{
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyNwglController.class);
	@Autowired
	private YjyNwglService service;
	
	/**
	 * 访问页面地址
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @return
	 */
	@RequestMapping(value = "/nwglPage")
	public ModelAndView openPage(){
		ModelAndView mav = new ModelAndView("/jygl/yjyNwglList");
		SysYh user=AppUtil.getCurrentUser();
		String str=service.getYhJs(user.getUsername());
		mav.addObject("str", str);
		mav.addObject("userName", user.getUsername());
		mav.addObject("bmbh", user.getBmbh());
		return mav;
	}
	
	/**
	 * 内委管理列表
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getNwglList")
	@ResponseBody
	public Pagination<Map<String, Object>> getNwglList(Integer start,Integer limit,String canshu){
		return service.getNwglList(start, limit, canshu);
	}
	
	/**
	 * 新增页面地址
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @return
	 */
	@RequestMapping(value = "/nwglAddView")
	public ModelAndView nwglAddView(){
		ModelAndView mav = new ModelAndView("/jygl/jsp/nwglAdd");
		SysYh user=AppUtil.getCurrentUser();
		List<Map<String,Object>> yhbm=service.getBmmc(user.getBmbh());
		if(yhbm.size()!=0){
			mav.addObject("wtbmmc", yhbm.get(0).get("bmmc"));
		}
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,Object>> cjbm=service.getBm("100250");
		if(cjbm.size()!=0){
			mav.addObject("cjbm", cjbm);
		}
		mav.addObject("wtrq", sim.format(new Date()));
		mav.addObject("wtbm", user.getBmbh());
		return mav;
	}
	
	/**
	 * 获取样品信息
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getYpxx")
	@ResponseBody
	public List<Map<String, Object>> getYpxx(HttpServletRequest request,
			HttpServletResponse response) {
		String cpbhcx = request.getParameter("cpbhcx");
		String cpmccx = request.getParameter("cpmccx");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String jzcs = request.getParameter("jzcs");
		List<Map<String, Object>> ypxx = service.getYpxx(cpbhcx, cpmccx, start, end, jzcs);
		return ypxx;
	}
	
	/**
	 * 获取样品信息
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getYpxxList")
	@ResponseBody
	public List<Map<String, Object>> getYpxxList(HttpServletRequest request,HttpServletResponse response) {
		String ypmc = request.getParameter("ypmc");
		String wtdw = request.getParameter("wtdw");
		String djsj = request.getParameter("xmmccx");
		List<Map<String, Object>> ypxx = service.getYpxxList(ypmc, wtdw, djsj);
		return ypxx;
	}
	
	/**
	 * 删除
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		service.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 获取检验项目
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getJyxm")
	@ResponseBody
	public List<Map<String, Object>> getJyxm(HttpServletRequest request,
			HttpServletResponse response) {
		String ypbh = request.getParameter("ypbh");
		List<Map<String, Object>> jyxm = service.getJyxm(ypbh);
		return jyxm;
	}
	
	/**
	 * 获取人员
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getYhbyBm")
	@ResponseBody
	public List<Map<String, Object>> getYhbyBm(HttpServletRequest request,
			HttpServletResponse response) {
		String bmbh = request.getParameter("bmbh");
		List<Map<String, Object>> yh = service.getYhbyBm(bmbh);
		return yh;
	}
	
	/**
	 * 新增保存
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(HttpServletRequest request,HttpServletResponse response){
		String str=service.saveLzd(request,response);
		return str;
	}
	
	/**
	 * 接收页面地址
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @return
	 */
	@RequestMapping(value = "/nwglJsView")
	public ModelAndView nwglJsView(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/jygl/jsp/nwglJs");
		String id=request.getParameter("id");
		List<Map<String,Object>> nwxx=service.getNwgl(id);
		List<Map<String,Object>> nwmx=service.getNwmx(id);
		if(nwxx.size()!=0){
			mav.addObject("nwxx", nwxx.get(0));
		}
		if(nwmx.size()!=0){
			mav.addObject("nwmx", nwmx);
			mav.addObject("size", nwmx.size());
		}
		return mav;
	}
	
	/**
	 * 更新费用
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveFy")
	@ResponseBody
	public String saveFy(HttpServletRequest request,HttpServletResponse response){
		String str=service.saveFy(request,response);
		return str;
	}
	
	/**
	 * 批阅页面地址
	 * @author liujiansen
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/nwglShView")
	public ModelAndView nwglShView(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/jygl/jsp/nwglSh");
		String id=request.getParameter("id");
		List<Map<String,Object>> nwxx=service.getNwgl(id);
		List<Map<String,Object>> nwmx=service.getNwmx(id);
		if(nwxx.size()!=0){
			mav.addObject("nwxx", nwxx.get(0));
		}
		if(nwmx.size()!=0){
			mav.addObject("nwmx", nwmx);
			mav.addObject("size", nwmx.size());
		}
		return mav;
	}
	
	/**
	 * 更新费用
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveSh")
	@ResponseBody
	public String saveSh(HttpServletRequest request,HttpServletResponse response){
		String str=service.saveSh(request,response);
		return str;
	}
	
	/**
	 * 查看页面地址
	 * @author liujiansen
	 * @date 2016年1月6日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/nwglCkView")
	public ModelAndView nwglCkView(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/jygl/jsp/nwglCk");
		String id=request.getParameter("id");
		List<Map<String,Object>> nwxx=service.getNwgl(id);
		List<Map<String,Object>> nwmx=service.getNwmx(id);
		if(nwxx.size()!=0){
			mav.addObject("nwxx", nwxx.get(0));
		}
		if(nwmx.size()!=0){
			mav.addObject("nwmx", nwmx);
			mav.addObject("size", nwmx.size());
		}
		return mav;
	}
	
	/**
	 * 修改页面地址
	 * @author liujiansen
	 * @date 2016年1月6日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/nwglXgView")
	public ModelAndView nwglXgView(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/jygl/jsp/nwglXg");
		String id=request.getParameter("id");
		List<Map<String,Object>> nwxx=service.getNwgl(id);
		List<Map<String,Object>> nwmx=service.getNwmxList(id);
		if(nwxx.size()!=0){
			mav.addObject("nwxx", nwxx.get(0));
		}
		if(nwmx.size()!=0){
			mav.addObject("nwmx", nwmx);
			mav.addObject("size", nwmx.size());
		}
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,Object>> cjbm=service.getBm("100250");
		if(cjbm.size()!=0){
			mav.addObject("cjbm", cjbm);
		}
		mav.addObject("wtrq", sim.format(new Date()));
		SysYh user=AppUtil.getCurrentUser();
		mav.addObject("wtbm", user.getBmbh());
		List<Map<String,Object>> yhbm=service.getBmmc(user.getBmbh());
		if(yhbm.size()!=0){
			mav.addObject("wtbmmc", yhbm.get(0).get("bmmc"));
		}
		return mav;
	}
	
	/**
	 * 修改
	 * @author liujiansen
	 * @date 2016年1月6日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response){
		String str=service.updateLzd(request,response);
		return str;
	}
}
