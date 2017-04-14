package com.zssi.framework.app.ypgl.controller;

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
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypSfxmmx;
import com.zssi.framework.app.ypgl.service.YypSfxmmxService;


@Controller
@RequestMapping("/ypgl/YYpSfxmmx")
public class YypSfxmmxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypSfxmmxController.class);
	@Autowired
	private YypSfxmmxService service;
	
	/**
	 * 收费项目明细列表
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getSfxmmxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getSfxmmxList(Integer start,Integer limit,String code){
		return service.getSfxmmxList(start, limit, code);
	}
	
	@RequestMapping(value = "/SfxmmxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypSfxmmxList");
		return modelAndView;
	}
	
	/**
	 * 增加 收费项目明细
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(HttpServletRequest request,HttpServletResponse response){
		String bgbh = request.getParameter("bgbh1");
		service.deleteSfxmmx(bgbh);
		return service.save(request,response);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YypSfxmmx entity, String id) {
		service.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
//	/**
//	 * 删除
//	 * @author wangyong
//	 * @date 2015年12月9日
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping(value="/delete", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseData delete(Integer[] ids){
//		service.delete(ids);
//	return ResponseData.SUCCESS_NO_DATA;
//	}
	
	/**
	 * 
	 * @author wangyong
	 * @date 2015年12月20日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/deleteSfxmmx", method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response){
		String bgbh = request.getParameter("sfxmBgbh");
		service.deleteSfxmmx(bgbh);
		return "1";
	}
	
}
