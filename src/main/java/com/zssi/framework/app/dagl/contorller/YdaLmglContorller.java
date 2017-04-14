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
import com.zssi.framework.app.dagl.model.YdaLmgl;
import com.zssi.framework.app.dagl.service.YdaLmglService;
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 档案信息contorller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:27:15 
 */
@Controller
@RequestMapping("/dagl/YdaLmgl")
public class YdaLmglContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YdaLmglContorller.class);
	
	@Autowired
	private YdaLmglService yDaLmglService;
	
	/**
	 * 后台：档案信息
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getDaLmglList")
	@ResponseBody
	public Pagination<Map<String, Object>> getDaLmglList(Integer start,Integer limit,String code){
		return yDaLmglService.getDaLmglList(start, limit,code);
	}
	
	@RequestMapping(value = "/DaLmglPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/dagl/yDaLmglList");
		return modelAndView;
		}
	
//	选择档案类目list查询
	@RequestMapping(value = "/getDalm")
	@ResponseBody
	public List<Map<String,Object>> getDalm(HttpServletRequest request,
			HttpServletResponse response){
		String lmmc = request.getParameter("lmmc");
		List<Map<String,Object>> dalm = yDaLmglService.getDaLm(lmmc);
		return dalm;
	}
	
//点击选择后查询出该id下的档案类目信息并返回
	@RequestMapping(value = "/getDalmById")
	@ResponseBody
	public List<Map<String, Object>> getDalmById(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		List<Map<String, Object>> wtdw = yDaLmglService.getDalmById(Integer.parseInt(id));
		return wtdw;
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
	public ResponseData save(ModelMap model,YdaLmgl entity,
			HttpServletRequest request,HttpServletResponse response){
		yDaLmglService.save(entity);
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
	public ResponseData update(YdaLmgl entity, String id) {
		yDaLmglService.update(entity, id);
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
		yDaLmglService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}

	
@RequestMapping(value = "/dalmAddView")
	
	public ModelAndView dalmAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/DalmAdd");
		return mav;
	}


@RequestMapping(value = "/dalmXgView")
@ResponseBody
public ModelAndView dalmXgView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/dagl/jsp/DalmXg");
	String id = request.getParameter("id");
	YdaLmgl dalmxx = yDaLmglService.getXg(id);
	if (dalmxx != null) {
		mav.addObject("dalmxx", dalmxx);
	}
	return mav;
}

}
