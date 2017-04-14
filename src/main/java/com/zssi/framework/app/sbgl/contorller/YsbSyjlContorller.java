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
import com.zssi.framework.app.sbgl.model.YsbSyjl;
import com.zssi.framework.app.sbgl.service.YsbSyjlService;
import com.zssi.framework.app.util.ResponseData;



@Controller
@RequestMapping("/sbgl/YsbSyjl")
public class YsbSyjlContorller extends BaseController {
	protected final transient Logger logger = com.likegene.framework.core.logger.LoggerFactory.getPersistenceLog(YsbSyjlContorller.class);
	
	@Autowired
	private YsbSyjlService ySbSyjlService;
	
	/**
	 * 后台：设备使用记录
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getSbsyjlList")
	@ResponseBody
	public Pagination<Map<String,Object>> getSbsyjlList(Integer start,Integer limit,String code){
		return ySbSyjlService.getSbsyjlList(start,limit,code);
	}
	
	@RequestMapping(value = "/SbsyjlPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sbgl/ySbsyjlList");
		return modelAndView;
	}
	
	/** 
	 * 设备使用状态下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ySbSyjlService.getDicByLx("syzt");
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
	public ResponseData save(ModelMap model,YsbSyjl entity, HttpServletRequest response){
		ySbSyjlService.save(entity);
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
	public ResponseData update(YsbSyjl entity,String id){
		ySbSyjlService.update(entity,id);
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
		ySbSyjlService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * jsp设备使用记录新增
	 * @author liusong
	 * @date 2015年11月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sbsyjlAddView")
	public ModelAndView sbsyjlAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbsyjlAdd");
		List<Map<String, Object>> syzt = ySbSyjlService.getDicByLx("syzt");
		mav.addObject("syzt",syzt);
		return mav;
	}
	
	/**
	 * jsp中设备使用记录修改
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbsyjlUpdateView")
	public ModelAndView sbxxUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbsyjlUpdate");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbsyjl = ySbSyjlService.getXg(id);
		if (sbsyjl != null) {
			mav.addObject("sbsyjl", sbsyjl);
		}
		List<Map<String, Object>> syzt = ySbSyjlService.getDicByLx("syzt");
		mav.addObject("syzt",syzt);
		return mav;
	}

}
