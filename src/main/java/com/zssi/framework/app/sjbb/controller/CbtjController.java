package com.zssi.framework.app.sjbb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.sjbb.service.CbtjService;
import com.zssi.framework.app.sjbb.service.YgfltjService;

@Controller
@RequestMapping("/sjbb/Cbtj")
public class CbtjController extends BaseController {

	protected final transient Logger logger = LoggerFactory.getPresentationLog(CbtjController.class);
	
	@Autowired
	private CbtjService service;
	
	@Autowired
	private YgfltjService ygfltjService;

	@RequestMapping(value = "/CbtjPage")
	@ResponseBody
	public ModelAndView openPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/sjbb/CbtjList");
//		String ksmccx = request.getParameter("ksmc");
//		String ssyfcx = request.getParameter("ssyf");
		//List<Map<String,Object>> sjbbCbtj=service.getCbtjList(ksmccx, ssyfcx);
		List<Map<String, Object>> ksmc = ygfltjService.getKsmc();
		//modelAndView.addObject("sjbbCbtj", sjbbCbtj);
		modelAndView.addObject("ksmc",ksmc);
		return modelAndView;
	}
	
	@RequestMapping(value = "/getCbtj")
	@ResponseBody
	public List<Map<String,Object>> getCbtj(HttpServletRequest request, HttpServletResponse response) {
		String ksmccx = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		List<Map<String,Object>> sjbbCbtj=service.getCbtjList(ksmccx, ksyf,jsyf);
		return sjbbCbtj;
	}
	
	/**
	 * 查看成本明细页面
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/CbmxPage")
	public ModelAndView openBqPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sjbb/CbmxPage");
		String ksmccx = request.getParameter("ksmccx");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		List<Map<String,Object>> cbmx=service.getCbmx(ksmccx, ksyf,jsyf);
		List<Map<String,Object>> bmmc=service.getBmmc(ksmccx);
		mav.addObject("cbmx", cbmx);
		mav.addObject("bmmc", bmmc);
		mav.addObject("ksmccx", ksmccx);
		mav.addObject("ksyf", ksyf);
		mav.addObject("jsyf", jsyf);
		return mav;
	}
	
	/**
	 * 成本统计导出Excle
	 * @author wangyong
	 * @date 2016年1月26日
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportCbtj")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ksmc = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		service.exportExcel(request,response,ksmc,ksyf,jsyf);
	}
	
	/**
	 * 成本统计明细导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportCbtjmx")
	public void exportCbtjmx(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ksmc = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		service.exportCbtjmx(request,response,ksmc,ksyf,jsyf);
	}

}
