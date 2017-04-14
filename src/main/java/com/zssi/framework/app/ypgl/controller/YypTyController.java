package com.zssi.framework.app.ypgl.controller;

import java.util.Map;

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
import com.zssi.framework.app.ypgl.service.YypTyService;

@Controller
@RequestMapping("/ypgl/YYpTy")
public class YypTyController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypTyController.class);
	
	@Autowired
	private YypTyService service;
	
	/**
	 * 后台：样品退样
	 * @author duanpeijun
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getTyList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTyList(Integer start,Integer limit, String code){
		return service.getTyList(start, limit, code);
	}
	
	@RequestMapping(value = "/yptyPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypTyList");
		return modelAndView;
	}
	
	/**
	 * 删除
	 * @author duanpeijun
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
