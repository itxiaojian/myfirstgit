package com.zssi.framework.app.ypgl.controller;

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
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypTy;
import com.zssi.framework.app.ypgl.model.YypYj;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYjService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

@Controller
@RequestMapping("/ypgl/YYpYj")
public class YypYjController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypYjController.class);
	
	@Autowired
	private YypYjService service;
	
	@Autowired
	private YypYpxxService yypYpxxService;
	
	/**
	 * 查询样品移交列表
	 * @author wangyong
	 * @date 2016年3月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYjList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYjList(Integer start,Integer limit, String code){
		return service.getYjList(start, limit, code);
	}
	
	@RequestMapping(value = "/yjjlPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypYjList");
		return modelAndView;
	}
	
	/**
	 * 查询getYpxxList
	 * @author wangyong
	 * @date 2016年3月10日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getYpxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYpxxList(Integer start,Integer limit,String canshu){
		return service.getYpxxList(start, limit,canshu);
	}
	
	@RequestMapping(value = "/ypyjPage")
	public ModelAndView openYjPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypYpyjxx");
		return modelAndView;
	}
	/**
	 * 删除
	 * @author wangyong
	 * @date 2016年3月9日
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
	 * 点击查看按钮跳转都查看的jsp页面
	 * @author wangyong
	 * @date 2016年3月10日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxOnLookView")
	public ModelAndView ypxxOnLookView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String ypbh=request.getParameter("ypbh");
		String djlx = request.getParameter("djlx");
		System.out.println(djlx);
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxOnLook");
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/ypxxOnLook";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcypxxOnLook";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syypxxOnLook";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", ewmurl);
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("rwly",rwly);
		return mav;
		
	}
	
	/**
	 * 跳转到样品移交页面
	 * @author wangyong
	 * @date 2016年3月10日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxYjiaoView")
	public ModelAndView ypxxYjiaokView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		//ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String ypbh=request.getParameter("ypbh");
		String djlx = request.getParameter("djlx");
		System.out.println(djlx);
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxYjiao");
//		if (djlx.equals("0")) {
//			url = "/ypgl/jsp/ypxxOnLook";
//		} else if(djlx.equals("1")){
//			url = "/ypgl/jsp/gcypxxOnLook";
//		} else if(djlx.equals("2")){
//			url = "/ypgl/jsp/syypxxOnLook";
//		}
//		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", ewmurl);
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("rwly",rwly);
		return mav;
		
	}
	
	/**
	 * 样品明细
	 * @author duanpeijun
	 * @date 2015年12月01日
	 * @return
	 */
	@RequestMapping(value = "/toSbDetail")
	public ModelAndView toSbDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/ewmxx");
		String ypbh=request.getParameter("ypbh");
		List<Map<String,Object>> list=yypYpxxService.getYpewm(ypbh);
		if(list.size()!=0){
			mav.addObject("map", list.get(0));
		}
		return mav;
	}
	
	/**
	 * 移交
	 * @author wangyong
	 * @date 2016年3月10日
	 * @param entity
	 * @param id
	 * @param Ty
	 * @return
	 */
	@RequestMapping(value = "/Yjiao", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData Tyang(String id,YypYj Yj) {
		service.save(Yj);
		YypYpxx ypxxEntity = yypYpxxService.getYpxxById(Integer.parseInt(id));
		ypxxEntity.setYjzt(1);
		yypYpxxService.update(ypxxEntity);
		return ResponseData.SUCCESS_NO_DATA;
	}
}
