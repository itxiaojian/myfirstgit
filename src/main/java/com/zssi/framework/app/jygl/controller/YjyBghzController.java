package com.zssi.framework.app.jygl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.zssi.framework.app.jygl.service.YjyBghzService;
import com.zssi.framework.app.util.ResponseData;


/**
 * 检验报告的汇总
 * @author oufeng
 * @date 2016年5月33日
 */
@Controller
@RequestMapping("/jygl/YjyBghz")
public class YjyBghzController extends BaseController {
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyJyxxController.class);
	
	@Autowired
	private YjyBghzService service;
	
	
	/**
	 * 报告查询的列表
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/tobghz")
	@ResponseBody
	public ResponseData tobghz(String[] ids,HttpServletRequest request,String [] ypzt){
		 service.tobghz(ids,request,ypzt);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 报告查询的列表
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/toexcelBgfyxx")
	@ResponseBody
	public String toexcelBgfyxx(HttpServletRequest request){
		String str= service.toexcelBgfyxx(request);
		 return str;
	}
		 
	
	/**
	 * 报告查询的列表
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getBghzxx")
	@ResponseBody
	public Pagination<Map<String, Object>> getBghz(Integer start,Integer limit,String starttime,String endtime,String jylx,String canshu){
		return service.getBgxxList(start, limit, starttime,endtime,jylx,canshu);
	}
	
	/**
	 * 报告汇总的初始页面
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/BghzPage")
	public ModelAndView bghzPage(){
		ModelAndView modelAndView = new ModelAndView("/jygl/jyhz/yjyBghzList");
		return modelAndView;
	}

	
	/**
	 * 属性的列表
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getSx")
	@ResponseBody
	public List<Map<String, Object>> getSx(){
		return service.getSx("Y_YP_YPXX","Y_JY_BGXX");
	}
	
	/**
	 * 属性的列表
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getTj")
	@ResponseBody
	public List<Map<String, Object>> getTj(){
		return service.getTj();
	}
	
	/**
	 * 检验状态
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getZt")
	@ResponseBody
	public List<Map<String, Object>> getZt(){
		return service.getZt();
	}
	
	/**
	 * 属性的列表
	 * @author 
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getBgfyxx",method = RequestMethod.POST)
	@ResponseBody
	public String getBgfyxx(String[] ids,HttpServletRequest request,String [] ypzt){
		String str   =service.getBgfyxx(ids,request,ypzt);
		return str;
	}
	
}
