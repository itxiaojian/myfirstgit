package com.zssi.framework.app.jygl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.zssi.framework.app.jygl.model.YjyClyy;
import com.zssi.framework.app.jygl.service.YjyClyyService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 常用检验结论用语
 * @author duanpeijun
 * @date 2016年1月26日
 */
@Controller
@RequestMapping("/jygl/YjyClyy")
public class YjyClyyController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyClyyController.class);
	@Autowired
	private YjyClyyService service;
	
	/**
	 * 常用检验结论用语后台
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getClyyList")
	@ResponseBody
	public Pagination<Map<String, Object>> getClyyList(Integer start,Integer limit,String canshu){
		return service.getClyyList(start, limit, canshu);
	}
	
	@RequestMapping(value = "/ClyyPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyClyyList");
		return modelAndView;
	}
	
	/**
	 * 点击打开新增的JSP页面
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("/jygl/clyy/clyyadd");
		List<Map<String, Object>> jllb1 = service.getDicByJylx("jllb1");
		List<Map<String, Object>> jllb2 = service.getDicByJylx("jllb2");
		modelAndView.addObject("jllb1", jllb1);
		modelAndView.addObject("jllb2", jllb2);
		return modelAndView;
	}
	
	/**
	 * 提交
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request) {
		String str = "";
		str = service.tijiao(request);
		str = "1";
		return str;
	}
	
	/**
	 * 点击打开修改的JSP页面
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response,String id){
		ModelAndView modelAndView = new ModelAndView("/jygl/clyy/clyyedit");
		List<Map<String, Object>> jl1 = service.getDicByJylx("jllb1");
		List<Map<String, Object>> jl2 = service.getDicByJylx("jllb2");
		modelAndView.addObject("jl1", jl1);
		modelAndView.addObject("jl2", jl2);
		YjyClyy clyy = service.getclyyById(Integer.parseInt(id));
		String cgjlyy = clyy.getCgjlyy();
		String bz = clyy.getBz();
		String jllb1 = clyy.getJllb1();
		String jllb2 = clyy.getJllb2();
		modelAndView.addObject("cgjlyy", cgjlyy);
		modelAndView.addObject("bz", bz);
		modelAndView.addObject("jllb1", jllb1);
		modelAndView.addObject("jllb2", jllb2);
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	/**
	 * 提交
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(HttpServletRequest request) {
		String str = "";
		str = service.update(request);
		str = "1";
		return str;
	}
	
	/**
	 * 删除
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids) {
		service.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
}
