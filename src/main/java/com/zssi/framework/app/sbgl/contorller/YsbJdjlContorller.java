package com.zssi.framework.app.sbgl.contorller; 

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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbJdjl;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sbgl.service.YsbJdjlService;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 设备检定记录controller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月1日 下午8:32:05 
 * 类说明 
 */
@Controller
@RequestMapping("/sbgl/YsbJdjl")
public class YsbJdjlContorller extends BaseController {
	protected final transient Logger logger = com.likegene.framework.core.logger.LoggerFactory.getPersistenceLog(YsbJdjlContorller.class);
	
	@Autowired
	private YsbJdjlService ysbJdjlService;
	
	@Autowired
	private YsbXxService ySbXxService;
	
	/**
	 * 后台：设备检定记录
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getSbjdjlList")
	@ResponseBody
	public Pagination<Map<String,Object>> getSbjdjlList(Integer start,Integer limit,String code){
		return ysbJdjlService.getSbjdjlList(start,limit,code);
	}
	
	@RequestMapping(value = "/SbjdjlPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sbgl/ySbjdjlList");
		return modelAndView;
	}
	
	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YsbJdjl entity,
			HttpServletRequest request,HttpServletResponse response){
		ysbJdjlService.save(entity);
				return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YsbJdjl entity,String id){
		ysbJdjlService.update(entity,id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ysbJdjlService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * jsp设备检定记录新增
	 * @author liusong
	 * @date 2015年11月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sbjdjlAddView")
	public ModelAndView sbjdjlAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbjdjlAdd");
		List<Map<String, Object>> jdzt = ysbJdjlService.getDicByLx("jdzt");
		mav.addObject("jdzt",jdzt);
		return mav;
	}
	
	/**
	 * jsp中设备维保记录修改
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbjdjlUpdateView")
	public ModelAndView sbjdjlUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbjdjlUpdate");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbjdjl = ysbJdjlService.getJd(id);
		if (sbjdjl != null) {
			mav.addObject("sbjdjl", sbjdjl);
		}
		List<Map<String, Object>> jdzt = ysbJdjlService.getDicByLx("jdzt");
		mav.addObject("jdzt",jdzt);
		return mav;
	}
	
	/**
	 * 查看设备检定信息
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbjdjlOnlookView")
	public ModelAndView sbjdjlOnlookView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbjdjlOnlook");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbjdjl = ysbJdjlService.getJd(id);
		if (sbjdjl != null) {
			mav.addObject("sbjdjl", sbjdjl);
		}
		List<Map<String, Object>> jdzt = ysbJdjlService.getDicByLx("jdzt");
		mav.addObject("jdzt",jdzt);
		return mav;
	}
	
	/**
	 * 完成设备检定跳转页面
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbjdjlOnstopView")
	public ModelAndView sbjdjlOnstopView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbjdjlOnstop");
		String id = request.getParameter("id");
		String sbid = request.getParameter("sbid");
		System.out.println("获取到的sbid是: " + sbid);
		List<Map<String, Object>> sbjdjl = ysbJdjlService.getJd(id);
		if (sbjdjl != null) {
			mav.addObject("sbjdjl", sbjdjl);
			mav.addObject("sbid", sbid);
		}
		List<Map<String, Object>> jdzt = ysbJdjlService.getDicByLx("jdzt");
		mav.addObject("jdzt",jdzt);
		return mav;
	}
	
	/**
	 * 完成设备检定保存方法
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/jdingStop", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData jding(YsbJdjl entity1, String id,String sbid) {
		System.out.println("获取到的sbid是: " + sbid);
		System.out.println("获取到的id是: " + id);
		    YsbXx entity = ySbXxService.get(Integer.parseInt(sbid));
			entity.setSyzt(0);
			entity1.setJdzt(0);
			ySbXxService.up(entity, sbid);
			ysbJdjlService.update(entity1,id);
			return ResponseData.SUCCESS_NO_DATA;

		}
	

}
