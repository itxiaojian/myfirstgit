package com.zssi.framework.app.cwgl.controller;

import java.text.ParseException;
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
import com.zssi.framework.app.cbgl.model.YcwCbxx;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwCbmx;
import com.zssi.framework.app.cwgl.service.YcwCbmxService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/cwgl/YCwCbmx")
public class YcwCbmxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YcwCbmxController.class);
	@Autowired
	private YcwCbmxService ycwCbmxService;
	
	/**
	 * 后台：成本明细
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getCbmxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getCbmxList(Integer start,Integer limit,String jybh,String ksbh,String lrrq){
		return ycwCbmxService.getCbmxList(start, limit, jybh,ksbh,lrrq);
	}
	
	@RequestMapping(value = "/CbmxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/cwgl/ycwCbmxList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加成本明细
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcwCbmx entity,
			HttpServletRequest request,HttpServletResponse response){
		ycwCbmxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 存储多条成本明细数据
	 * 
	 * @author wangyong
	 * @date 2015年11月11日
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(ModelMap model, YcwCbxx entity,HttpServletRequest request) throws ParseException {
		ycwCbmxService.insert(entity,request);
	}
	
	/**
	 * 后台:修改成本明细
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YcwCbmx entity, String id) {
		ycwCbmxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除成本信息
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ycwCbmxService.delete(ids);
	    return ResponseData.SUCCESS_NO_DATA;
	}
}

