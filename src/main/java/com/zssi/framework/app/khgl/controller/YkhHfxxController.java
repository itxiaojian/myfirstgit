package com.zssi.framework.app.khgl.controller;

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
import com.zssi.framework.app.khgl.model.YkhHfxx;
import com.zssi.framework.app.khgl.service.YkhHfxxService;
import com.zssi.framework.app.khgl.service.YkhKhxxService;
import com.zssi.framework.app.util.ResponseData;

//客户回访信息controller
//liusong 2016-3-7
@Controller
@RequestMapping("/khgl/YKhHfxx")
public class YkhHfxxController extends BaseController {
	protected final transient Logger logger=LoggerFactory.getPresentationLog(YkhHfxx.class);

	@Autowired
	private YkhHfxxService hfxxService;
	
	@Autowired
	private YkhKhxxService khxxService;
	
	/**
	 * 分页查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getHfxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getHfxxList(Integer start,Integer limit,String code){
		return hfxxService.getHfzzList(start, limit, code);
	}
	
	/**
	 * 点击跳转链接
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/HfxxPage")
	public ModelAndView openPage(){
		ModelAndView andView = new ModelAndView("/khgl/ykhHfxxList");
		return andView;
	}
	
	/**
	 * 点击增加跳转页面
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/hfAddView")
	public ModelAndView hfAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/khgl/jsp/hfxxAdd");
//		List<Map<String, Object>> ssfl = yKhHyxxService.getSsfl();
//		mav.addObject("ssfl", ssfl);
		return mav;
	}
	
	/**
	 * 点击修改跳转页面
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/hfxxXgView")
	public ModelAndView hfxxXgView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/khgl/jsp/hfxxUpdate");
		String id = request.getParameter("id");
		List<Map<String, Object>> hfxx = hfxxService.getHfxx(id);
////	List<Map<String, Object>> ssfl = yKhHyxxService.getSsfl();
////	mav.addObject("ssfl", ssfl);
				if (hfxx != null) {
			mav.addObject("hfxx", hfxx);
		}
		return mav;
	}
	
	/**
	 * 点击查看跳转页面
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/hfOnlookView")
	public ModelAndView hfOnlookView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/khgl/jsp/hfxxOnlook");
		String id = request.getParameter("id");
		List<Map<String, Object>> hfxx = hfxxService.getHfxx(id);
////		List<Map<String, Object>> ssfl = yKhHyxxService.getSsfl();
////		mav.addObject("ssfl", ssfl);
		if (hfxx != null) {
			mav.addObject("hfxx", hfxx);
		}
		return mav;
	}
	
	/**
	 * 保存方法
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(YkhHfxx entity,HttpServletRequest request,HttpServletResponse response) {
		    hfxxService.save(entity);
 			return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 更新方法
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YkhHfxx entity, String id) {
//		String str = "0";
		hfxxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
//		return str;
	}
	
	/**
	 * 回访记录查询客户信息
	 * @author liusogn
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getKh", method = RequestMethod.POST)
	@ResponseBody
		public List<Map<String, Object>> getKh(HttpServletRequest request,
				HttpServletResponse response,String code) {
			List<Map<String, Object>> list = khxxService.getKh(code);
			return list;
    }
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		hfxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	

}
