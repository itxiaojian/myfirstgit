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
import com.zssi.framework.app.cwgl.model.YcwKssrmx;
import com.zssi.framework.app.cwgl.service.YcwKssrmxService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/cwgl/YCwKssrmx")
public class YcwKssrmxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YcwKssrmxController.class);
	@Autowired
	private YcwKssrmxService ycwKssrmxService;
	
	/**
	 * 后台：科室收入明细
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getKssrmxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getKssrmxList(Integer start,Integer limit,String jybh){
		return ycwKssrmxService.getKssrmxList(start, limit, jybh);
	}
	
	@RequestMapping(value = "/KssrmxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/cwgl/ycwKssrmxList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加科室收入明细信息
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcwKssrmx entity,
			HttpServletRequest request,HttpServletResponse response){
		ycwKssrmxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 存储多条科室收入明细数据
	 * @author wangyong
	 * @date 2015年11月12日
	 * @param request
	 */
	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(HttpServletRequest request) {
		ycwKssrmxService.insert(request);
	}
	
	
	/**
	 * 后台:修改科室收入明细信息
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YcwKssrmx entity, String id) {
		ycwKssrmxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除科室收入信息
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ycwKssrmxService.delete(ids);
	    return ResponseData.SUCCESS_NO_DATA;
	}
}

