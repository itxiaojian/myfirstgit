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
import com.zssi.framework.app.ypgl.model.YypLy;
import com.zssi.framework.app.ypgl.service.YypLyService;

@Controller
@RequestMapping("/ypgl/YYpLy")
public class YypLyController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypLyController.class);
	@Autowired
	private YypLyService service;
	
	/**
	 * 后台：样品领用列表
	 * @author duanpeijun
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getLyList")
	@ResponseBody
	Pagination<Map<String, Object>> getLyList(Integer start,Integer limit,String code){
		return service.getLyList(start, limit,code);
	}
	@RequestMapping(value = "/yplyPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypLyList");
		return modelAndView;
	}
	
	/**
	 * 修改
	 * @author duanpeijun
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YypLy entity, String id) {
		service.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
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
