package com.zssi.framework.app.tsxx.controller;

import java.text.SimpleDateFormat;
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
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.tsxx.model.YtsXx;
import com.zssi.framework.app.tsxx.service.YtsXxService;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.yhgl.model.SysYhxx;

@Controller 
@RequestMapping("/tsxx/YtsXx")
public class YtsXxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YtsXx.class);
	

	@Autowired
	private YtsXxService ytsXxService;
	@RequestMapping(value = "/getTsxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTestList(Integer start,Integer limit,String cs){
		return ytsXxService.getTsxxList(start, limit, cs);
		
	}
	
	
	@RequestMapping(value = "/TsxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/tsxx/YtsXxList");
		return modelAndView;
	}
	
	/**
	 * 投诉页面中————用户信息
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	 
	@RequestMapping(value = "/Yh")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/tsxx/jsp/Yh");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Yh = ytsXxService.getYh(code);
		if (Yh != null) {
			mav.addObject("Yh", Yh);
		}
		return mav;
	}
	
	/**
	 * 增加提交jspsave
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, YtsXx entity) {
		String str = "1";
		SysYh yh =AppUtil.getCurrentUser();
		entity.setTsr(yh.getXm());
		 
		str=ytsXxService.saveTs(request, entity);
		return str;
	}	
	
	
//	/**
//	 * 投诉页面中————客户信息
//	 * @author liangkaidi
//	 * @date 2015-11-12
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/khxx")
//	public ModelAndView khxx(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("/tsxx/jsp/Khxx");
//		String khbh = request.getParameter("khbh");
//		List<Map<String, Object>> khxx = ytsXxService.getKhxx(khbh);
//		if (khxx != null) {
//			mav.addObject("khxx", khxx);
//		}
//		return mav;
//	}
	/**
	 * jsp页面的修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response, String id,YtsXx entity) {
		String str = "1";
		ytsXxService.update(request, id);
		return str;
	}

	
	
	/**
	 * jsp页面的处理
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deal", method = RequestMethod.POST)
	@ResponseBody
	public String deal(HttpServletRequest request,HttpServletResponse response, String id,YtsXx entity) {
		String str = "1";
		SysYh yh =AppUtil.getCurrentUser();
		entity.setClr(yh.getXm());
		
		ytsXxService.deal(request, id);
		return str;
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-10-9
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ytsXxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
/**
 * 
 * @author liangkaidi
 * @date 2015-10-9
 * @return
 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx() {
		return ytsXxService.getDicByLx("tslx");
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击增加跳转的Jsp页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */

@RequestMapping(value = "/tsAddView")
	
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response,String ids) {
		ModelAndView mav = new ModelAndView("/tsxx/jsp/Tsxx");
		String yhbh = request.getParameter("yhbh");
		if (ids != null && !"".equals(ids)) {
			SysYhxx getyh = ytsXxService.getyhmc(ids);
			String bzbh = getyh.getXm();
			if (getyh != null) {
				mav.addObject("getyh", getyh.getXm());
			}
		}
		List<Map<String, Object>> clzt = ytsXxService.getDicByList("clzt");
		List<Map<String, Object>> tslx = ytsXxService.getDicByList("tslx");
		mav.addObject("clzt", clzt);
		mav.addObject("tslx", tslx);
		
		return mav; 
	}
/**
 * 点击修改跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-11
 * @param request
 * @param response
 * @return
 */


@RequestMapping(value = "/tsXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response,String ids) {
	ModelAndView mav = new ModelAndView("/tsxx/jsp/TsxxXg");
//	做下拉框
	List<Map<String, Object>> clzt = ytsXxService.getDicByList("clzt");
	List<Map<String, Object>> tslx = ytsXxService.getDicByList("tslx");
	mav.addObject("clzt", clzt);
	mav.addObject("tslx", tslx);
//	获取用户
	String id = request.getParameter("id");
	YtsXx tsxx = ytsXxService.getXg(id);
	String yhbh = request.getParameter("yhbh");
	if (ids != null && !"".equals(ids)) {
		SysYhxx getyh = ytsXxService.getyhmc(ids);
		String bzbh = getyh.getXm();
		if (getyh != null) {
			mav.addObject("getyh", getyh.getXm());
		}
	}
	if (tsxx != null) {
		if (tsxx != null) {
			if(tsxx.getTsrq()!=null){
				SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				mav.addObject("tsrq", sim.format(tsxx.getTsrq()));
			}
			mav.addObject("tsxx", tsxx);
		}
		mav.addObject("tsxx", tsxx);
	}
	return mav;
}

/**
 * 点击处理跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-11
 * @param request
 * @param response
 * @return
 */


@RequestMapping(value = "/tsClView")
public ModelAndView clDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/tsxx/jsp/TsxxCl");
	List<Map<String, Object>> clzt = ytsXxService.getDicByList("clzt");
	mav.addObject("clzt", clzt);
	String id = request.getParameter("id");
	YtsXx tsxx = ytsXxService.getCl(id);
	if (tsxx != null) {
		if(tsxx.getTsrq()!=null){
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mav.addObject("tsrq", sim.format(tsxx.getTsrq()));
		}
		mav.addObject("tsxx", tsxx);
	}
	return mav;
}

/**
 * 点击处理跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-11
 * @param request
 * @param response
 * @return
 */


@RequestMapping(value = "/khxxXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/khgl/jsp/khxxXg");
	String id = request.getParameter("id");
	System.out.println(id+"-------------------------------");
	YtsXx tsxx = ytsXxService.getXg(id);
	if (tsxx != null) {
		mav.addObject("tsxx", tsxx);
	}
	return mav;
}
/**
 * 查看
 * @author liangkaidi
 * @date 2015-12-3
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = "/tsCkView")
public ModelAndView tsCkView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/tsxx/jsp/TsxxCk");
	
	String id = request.getParameter("id");
	YtsXx tsxx = ytsXxService.getCk(id);
	if (tsxx != null) {
		if(tsxx.getTsrq()!=null){
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mav.addObject("tsrq", sim.format(tsxx.getTsrq()));
		}
		mav.addObject("tsxx", tsxx);
	}
	return mav;
}
/**
 * 查看
 * @author liangkaidi
 * @date 2015-12-3
 * @param request
 * @param response
 * @return
 */

@RequestMapping(value = "/tsClCkView")
public ModelAndView tsClCkView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/tsxx/jsp/TsxxClCk");
	
	String id = request.getParameter("id");
	YtsXx tsxx = ytsXxService.getClCk(id);
	if (tsxx != null) {
		if(tsxx.getTsrq()!=null){
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mav.addObject("tsrq", sim.format(tsxx.getTsrq()));
		}
		mav.addObject("tsxx", tsxx);
	}
	return mav;
}
}
