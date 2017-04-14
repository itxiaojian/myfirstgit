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
import com.zssi.framework.app.ypgl.service.YypGhService;

@Controller
@RequestMapping("/ypgl/YYpGh")
public class YypGhController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypGhController.class);
	@Autowired
	private YypGhService service;
	
	/**
	 * 后台：样品归还列表
	 * @author duanpeijun
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getGhList")
	@ResponseBody
	public Pagination<Map<String, Object>> getGhList(Integer start,Integer limit,String code){
		return service.getGhList(start, limit,code);
	}
	
	@RequestMapping(value = "/ypghPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypGhList");
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
