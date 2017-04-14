package com.zssi.framework.app.jygl.controller;

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
import com.zssi.framework.app.jygl.model.YjyXmml;
import com.zssi.framework.app.jygl.service.YjyXmmlService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 检验项目目录
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Controller
@RequestMapping("/jygl/YjyXmml")
public class YjyXmmlController extends BaseController{
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyXmmlController.class);
	@Autowired
	private YjyXmmlService service;
	
	/**
	 * 后台：检验项目目录
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getXmmlList")
	@ResponseBody
	public Pagination<Map<String, Object>> getJyxmmlList(Integer start,Integer limit,String canshu){
		return service.getJyxmmlList(start, limit, canshu);
	}
	
	@RequestMapping(value = "/XmmlPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyXmmlList");
		return modelAndView;
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YjyXmml entity,
			HttpServletRequest request,HttpServletResponse response){
		service.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjyXmml entity, String id) {
		service.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		service.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
}
