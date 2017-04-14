package com.zssi.framework.app.dagl.contorller; 

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
import com.zssi.framework.app.dagl.model.YdaBgqx;
import com.zssi.framework.app.dagl.service.YdaBgqxService;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 档案保管期限contorller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午6:44:25 
 * 类说明 
 */
@Controller
@RequestMapping("/dagl/YdaBgqx")
public class YdaBgqxContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YdaBgqxContorller.class);
	
	@Autowired
	private YdaBgqxService yDaBgqxService;
	
	@RequestMapping(value = "/getDaBgqxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getDaBgqxList(Integer start,Integer limit,String code){
		return yDaBgqxService.getDaBgqxList(start, limit,code);
	}
	
	/**
	 * 保管期限下拉菜单
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yDaBgqxService.getDicByLx("bgqx");
	}
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-12-23
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Lmmc")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/Lmmc");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Lmmc = yDaBgqxService.getLmmc(code);
		if (Lmmc != null) {
			mav.addObject("Lmmc", Lmmc);
		}
		return mav;
	}
	
	/**
	 * 档案密级下拉菜单
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return yDaBgqxService.getDicByLx("damj");
	}
	
	@RequestMapping(value = "/DaBgqxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/dagl/yDaBgqxList");
		return modelAndView;
		}
	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YdaBgqx entity,
			HttpServletRequest request,HttpServletResponse response){
		yDaBgqxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 更新
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YdaBgqx entity, String id) {
		yDaBgqxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年10月12日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yDaBgqxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}

@RequestMapping(value = "/bgqxAddView")
	
	public ModelAndView dalmAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/BgqxAdd");
		List<Map<String, Object>> damj = yDaBgqxService.getDicByList("damj");
		List<Map<String, Object>> bgqx = yDaBgqxService.getDicByList("bgqx");
		
		mav.addObject("damj", damj);
		mav.addObject("bgqx", bgqx);
		return mav;
	}

@RequestMapping(value = "/bgxqXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/dagl/jsp/BgqxUpdate");
	
	List<Map<String, Object>> damj = yDaBgqxService.getDicByList("damj");
	List<Map<String, Object>> bgqx = yDaBgqxService.getDicByList("bgqx");
	
	mav.addObject("damj", damj);
	mav.addObject("bgqx", bgqx);
	
	String id = request.getParameter("id");
	List<Map<String, Object>> bgqxxx = yDaBgqxService.getXg(id);
	if (bgqxxx != null) {
		mav.addObject("bgqxxx", bgqxxx);
	}
	return mav;
}

}
