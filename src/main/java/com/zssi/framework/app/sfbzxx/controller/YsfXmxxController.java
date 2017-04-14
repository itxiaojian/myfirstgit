package com.zssi.framework.app.sfbzxx.controller;

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
import com.zssi.framework.app.sfbzxx.model.YsfXmxx;
import com.zssi.framework.app.sfbzxx.service.YsfXmxxService;
import com.zssi.framework.app.util.ResponseData;

@Controller
@RequestMapping("/sfgl/Ysfxmxx")
public class YsfXmxxController extends BaseController{
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YsfXmxxController.class);
	@Autowired
	private YsfXmxxService ysfXmxxService;
	
	@RequestMapping(value = "/getXmxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getCbmxList(Integer start,Integer limit,String sfbzbh){
		return ysfXmxxService.getxmxxList(start, limit, sfbzbh);
	}
	
	@RequestMapping(value = "/XmxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sfgl/YsfXmxxList");
		return modelAndView;
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YsfXmxx entity,
			HttpServletRequest request,HttpServletResponse response){
		ysfXmxxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	/**
	 * 存储多条项目信息数据
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param request
	 */
	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(HttpServletRequest request) {
		ysfXmxxService.insert(request);
	}
	/**
	 * 后台:修改
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YsfXmxx entity, String id) {
		ysfXmxxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	/**
	 * 后台:删除
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ysfXmxxService.delete(ids);
	    return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导出Excel
	 * @author liangkaidi
	 * @date 2015-10-23
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@RequestMapping(value = "/xmxxexport")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ysfXmxxService.exportExcel(request,response,code);
	}
	
	/**
	 * 数据字典--标准级别
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByjb", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByjb(String zdzl) {
		return ysfXmxxService.getDicByjb("jldw");
	}
}
