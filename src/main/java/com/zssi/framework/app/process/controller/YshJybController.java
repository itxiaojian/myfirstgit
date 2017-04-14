package com.zssi.framework.app.process.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.likegene.framework.core.BaseController;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.model.YshJyb;
import com.zssi.framework.app.process.service.YshJybService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 审批建议表
 * @author : zhangyi
 * @version 创建时间：2015年11月11日 上午10:37:50
 */
@Controller
@RequestMapping(value = "/process/jyb")
public class YshJybController extends BaseController{

	@Autowired
	private YshJybService yshJybService;
	
	@RequestMapping(value = "/menuPage")
	public String openYshJybPage() {		
		return "/weixin/menu/menuList";
	}
	
	/**
	 * 分页查询意见信息
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getJyList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Object> getJyList(Integer start,Integer limit) {
		return yshJybService.getJyList(start, limit);
	}
	
	
	/**
	 * 添加意见
	 * 
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData save(ModelMap model, YshJyb entity,
			HttpServletRequest request, HttpServletResponse response) {
		
		String result = yshJybService.save(entity);
		if (!"1".equalsIgnoreCase(result)) {
			return ResponseData.FAILED_NO_DATA;
		}
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改意见
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月4日 上午9:19:04 
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(ModelMap model, YshJyb entity,
			HttpServletRequest request, HttpServletResponse response) {
		
		String result = yshJybService.update(entity);
		if (!"1".equalsIgnoreCase(result)) {
			return ResponseData.FAILED_NO_DATA;
		}
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除意见
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月4日 上午10:10:07 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete")
    @ResponseBody
    public ResponseData deleteTuWenMcInfo(Long[] ids)
    {
      for (Long id : ids)
      {
    	 yshJybService.delete(id);
      }
      return ResponseData.SUCCESS_NO_DATA;
    }
	
}
