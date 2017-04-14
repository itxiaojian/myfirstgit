package com.zssi.framework.app.cwgl.controller;

import java.util.Date;
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
import com.zssi.framework.app.cwgl.model.YcwGlbmsf;
import com.zssi.framework.app.cwgl.service.YcwGlbmsfService;
import com.zssi.framework.app.cwgl.service.YcwJsfwxysfService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.yhgl.dao.SysYhDao;

//管理部门收费controller类
//liusong 2015-12-24
@Controller
@RequestMapping(value = "/cwgl/YcwGlbmsf")
public class YcwGlbmsfController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(YcwGlbmsfController.class);
	
	@Autowired
	private YcwGlbmsfService glbmsfService;
	
	@Autowired
	private YcwJsfwxysfService xysfService;
	
	@Autowired
	private SysYhDao sysYhDao;

	@RequestMapping(value = "/getGlbmsfList")
	@ResponseBody
	public Pagination<Map<String, Object>> getGlbmsfList(Integer start,Integer limit,String code,String bmbh){
		return glbmsfService.getGlbmsfList(start, limit, code,bmbh);
	}
	
	@RequestMapping(value = "/GlbmsfPage")
	public ModelAndView openPage(){
		ModelAndView addView = new ModelAndView("/cwgl/ycwGlbmsfList");
		return addView;
	}
	
	/**
	 * 点击增加跳转的Jsp页面
	 * @author liusong
	 * @date 2015-11-23
	 * @param request
	 * @param response
	 * @return
	 */
	
@RequestMapping(value = "/glsfAddView")
@ResponseBody
	public ModelAndView glsfAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/glsfAdd");
		List<Map<String, Object>> srfl = xysfService.getDicByLx("srfl");
		List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
		List<Map<String, Object>> glbm = xysfService.getGlbm();
		mav.addObject("glbm",glbm);
		mav.addObject("pjfl",pjfl);
		mav.addObject("srfl", srfl);
		return mav;
	}

/**
 * 点击修改
 * @author liusong
 * @date 2015-11-23
 * @param request
 * @param response
 * @return
 */

@RequestMapping(value = "/glsfUpdateView")
@ResponseBody
public ModelAndView glsfUpdateView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/cwgl/jsp/glsfUpdate");
	String id = request.getParameter("id");
	List<Map<String, Object>> glsf = glbmsfService.getGlsf(id);
	if (glsf != null) {
		mav.addObject("glsf", glsf);
	}
	List<Map<String, Object>> srfl = xysfService.getDicByLx("srfl");
	List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
	List<Map<String, Object>> glbm = xysfService.getGlbm();
	mav.addObject("glbm",glbm);
	mav.addObject("pjfl",pjfl);
	mav.addObject("srfl", srfl);
	return mav;
	
	}

/**
 * 点击修改
 * @author liusong
 * @date 2015-11-23
 * @param request
 * @param response
 * @return
 */

@RequestMapping(value = "/glsfonLookView")
@ResponseBody
public ModelAndView glsfonLookView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/cwgl/jsp/glsfOnlook");
	String id = request.getParameter("id");
	List<Map<String, Object>> glsf = glbmsfService.getGlsf(id);
	if (glsf != null) {
		mav.addObject("glsf", glsf);
	}
	List<Map<String, Object>> srfl = xysfService.getDicByLx("srfl");
	List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
	List<Map<String, Object>> glbm = xysfService.getGlbm();
	mav.addObject("glbm",glbm);
	mav.addObject("pjfl",pjfl);
	mav.addObject("srfl", srfl);
	return mav;
	
}

/**
 * 新增保存
 * @author liusong
 * @date 2015年10月9日
 * @return
 */
@RequestMapping(value="/save")
@ResponseBody
public ResponseData save(ModelMap model,YcwGlbmsf entity,
		HttpServletRequest request,HttpServletResponse response){
//	entity.setDjrq(Calendar.getInstance().getTime());
	SysYh sfr =AppUtil.getCurrentUser();
	Date date = new Date();
	entity.setSfr(sfr.getXm());
	entity.setSfrq(date);
	glbmsfService.save(entity);
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
public ResponseData update(YcwGlbmsf entity, String id,String bmbh) {
			entity.setBmbh(bmbh);
	        glbmsfService.update(entity, id);
	return ResponseData.SUCCESS_NO_DATA;
}

/**
 * 删除
 * @author liusong
 * @date 2015年10月9日
 * @param ids
 * @return
 */
@RequestMapping(value="/delete", method = RequestMethod.POST)
@ResponseBody
public ResponseData delete(Integer[] ids){
	glbmsfService.delete(ids);
return ResponseData.SUCCESS_NO_DATA;
}
	

}
