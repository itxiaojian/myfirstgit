package com.zssi.framework.app.jygl.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyBgmb;
import com.zssi.framework.app.jygl.model.YjyYdmb;
import com.zssi.framework.app.jygl.service.YjyYdmbService;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.service.YypYpxxService;


@Controller
@RequestMapping("/ydmb/YJyYdmb")
public class YjyYdmbController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyYdmbController.class);
	@Autowired
	private YjyYdmbService service;
	
	@Autowired
	private YypYpxxService ypxxService;
	
	/**
	 * 模板设置列表
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYdmbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYdmbList(Integer start,Integer limit,String code){
		return service.getYdmbList(start, limit, code);
	}
	
	@RequestMapping(value = "/YdmbPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ydmb/yjyYdmbList");
		return modelAndView;
	}
	
	/**
	 * 模板增加
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YjyYdmb entity,
		HttpServletRequest request,HttpServletResponse response){
		String fy = request.getParameter("fy");
		String fm = request.getParameter("fm");
		String sy = request.getParameter("sy");
		System.out.println(sy);
		String mbfl = request.getParameter("mbfl");
		
		entity.setFy_id(Integer.parseInt(fy));
		entity.setFm_id(Integer.parseInt(fm));
		entity.setSy_id(Integer.parseInt(sy));
		entity.setMbfl(Integer.parseInt(mbfl));
		
		String bmbh = entity.getBmbh();
		System.out.println(bmbh);
		String zh = entity.getZh();
		
		String zhString = ypxxService.findZh(bmbh, zh);
		if (zhString.length()==11) {
			entity.setZh(zhString.substring(4, 6));
			entity.setSsbh(service.getBh(zhString.substring(4, 6)));
		} else {
			entity.setZh(zhString.substring(4, 7));
			entity.setSsbh(service.getBh(zhString.substring(4, 7)));
		}
		service.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjyYdmb entity, String id,HttpServletRequest request,HttpServletResponse response) {
		
		String fy = request.getParameter("fy");
		String fm = request.getParameter("fm");
		String sy = request.getParameter("sy");
		
		System.out.println("================="+sy);
		
		String mbfl = request.getParameter("mbfl");
		
		entity.setFy_id(Integer.parseInt(fy));
		entity.setFm_id(Integer.parseInt(fm));
		entity.setSy_id(Integer.parseInt(sy));
		entity.setMbfl(Integer.parseInt(mbfl));
		
		String bmbh = entity.getBmbh();
		System.out.println(bmbh);
		String zh = entity.getZh();
		
		String zhString = ypxxService.findZh(bmbh, zh);
		System.out.println("-------------"+zhString);
		if (zhString.length()==11) {
			entity.setZh(zhString.substring(4, 6));
			entity.setSsbh(service.getBh(zhString.substring(4, 6)));
		} else {
			entity.setZh(zhString.substring(4, 7));
			entity.setSsbh(service.getBh(zhString.substring(4, 7)));
		}
		service.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年12月9日
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
	 * 查询模板名称
	 * @author liangkaidi
	 * @date 2015-12-17
	 * @param request
	 * @param response
	 * @param id
	 * @param value
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/mb")
	@ResponseBody
	public List<Map<String, Object>> swpd(HttpServletRequest request,
			HttpServletResponse response, String id, String value, String type) {
//		ModelAndView mav = new ModelAndView("/ydmb/jsp/mbList");
//		if (id != null) {
//			mav.addObject("id", id);
//		}
//		List<Map<String, Object>> mb = service.getmbList();
//		if (mb != null) {
//			mav.addObject("mb", mb);
//		}
//		mav.addObject("value", value);
//		mav.addObject("type", type);
//		return mav;
		List<Map<String, Object>> list = service.getmbList();
		return list;
	}
	
	/**
	 * 模板设置新增页面
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/ydmbAddView")
	public ModelAndView ypxxAddView(HttpServletRequest request, HttpServletResponse response,String mbid, String type, String value) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/ydmb/jsp/ydmbAdd");
		List<Map<String, Object>> mbfl = service.getDicByList("mbfl");
		List<Map<String, Object>> zh = service.getDicByList("zh");
		mav.addObject("mbfl", mbfl);
		mav.addObject("zh", zh);
		return mav;
	}
	
	/**
	 * 模板设置修改页面
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ydmbUpdateView")
	public ModelAndView ypxxUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ydmb/jsp/ydmbUpdate");
		List<Map<String, Object>> zh = service.getDicByList("zh");
		List<Map<String, Object>> mbfl = service.getDicByList("mbfl");
		mav.addObject("mbfl", mbfl);
		mav.addObject("zh", zh);
		String id = request.getParameter("id");
		List<Map<String, Object>> ydmb = service.getYdmb(Integer.parseInt(id));
		if (ydmb != null) {
			mav.addObject("ydmb", ydmb);
		}
		return mav;
	}
}
