package com.zssi.framework.app.cwgl.controller;

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
import com.zssi.framework.app.cwgl.model.YcwYgfl;
import com.zssi.framework.app.cwgl.model.YcwYgflmx;
import com.zssi.framework.app.cwgl.service.YcwYgflmxService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/cwgl/YCwYgflmx")
public class YcwYgflmxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YcwYgflmxController.class);
	@Autowired
	private YcwYgflmxService ycwYgflmxService;
	
	/**
	 * 后台：员工福利明细
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYgflmxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYgflmxList(Integer start,Integer limit,String flbh){
		return ycwYgflmxService.getYgflmxList(start, limit, flbh);
	}
	
	@RequestMapping(value = "/YgflmxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/cwgl/ycwYgflmxList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加员工福利明细
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcwYgflmx entity,
			HttpServletRequest request,HttpServletResponse response){
		ycwYgflmxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 存储多条员工福利明细数据
	 * @author wangyong
	 * @date 2015年11月12日
	 * @param request
	 */
	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(ModelMap model,YcwYgfl entity,HttpServletRequest request) {
		ycwYgflmxService.insert(entity,request);
	}
	
	/**
	 * 后台:修改员工福利明细
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YcwYgflmx entity, String id) {
		ycwYgflmxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除员工福利明细
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ycwYgflmxService.delete(ids);
	    return ResponseData.SUCCESS_NO_DATA;
	}
}

