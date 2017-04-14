package com.zssi.framework.app.yrwgl.controller;

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
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.controller.YypGhController;
import com.zssi.framework.app.yrwgl.model.YrwWdrw;
import com.zssi.framework.app.yrwgl.service.YrwWdrwService;
/**
 * 主页--我的任务
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/yrwgl/ywdrw")
public class YrwWdrwController extends BaseController {
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypGhController.class);
			
	@Autowired
	private YrwWdrwService yrwWdrwService;
	
	/**
	 * 功能--我的任务详细信息
	 * @author mabiao
	 * @version 2015年10月12日上午9:56:27
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYrwWdrwList")
	@ResponseBody

	public Pagination<Map<String, Object>> getYrwWdrwList(Integer start, 
			Integer limit, String code1, String code2, String code3, String code4){
		return yrwWdrwService.getYrwWdrwList(start, limit, code1, code2, code3, code4);
	}
	
	/**
	 * 功能--跳转
	 * @author mabiao
	 * @version 2015年10月12日上午9:55:43
	 * @return
	 */
	@RequestMapping(value = "/ywdrwPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/yrwgl/ywdrwList");
		return modelAndView;
	}
	
	/**
	 * 功能--保存
	 * @author mabiao
	 * @version 2015年10月12日上午10:28:41
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YrwWdrw entity,
			HttpServletRequest request,HttpServletResponse response){
		yrwWdrwService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--修改
	 * @author mabiao
	 * @version 2015年10月12日上午10:27:33
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YrwWdrw entity, String id) {
		yrwWdrwService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--删除
	 * @author mabiao
	 * @version 2015年10月12日上午9:57:29
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrwWdrwService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--任务类型（数据字典）
	 * @author mabiao
	 * @date 2015年10月12日上午10:57:29
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx() {
		return yrwWdrwService.getDicByLx("xxlx");
	}
	
}
