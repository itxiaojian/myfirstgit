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
import com.zssi.framework.app.khgl.dao.YkhHyxxDao;
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.khgl.service.YkhHyxxService;
import com.zssi.framework.app.util.ResponseData;
/**
 * 
 * @author liangkaidi
 * @date 2015-9-22
 */
@Controller 
@RequestMapping("/khgl/YKhHyxx")
public class YkhHyxxController   extends  BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YkhHyxx.class);
	
	@Autowired
	private YkhHyxxService yKhHyxxService;
	@Autowired
	private YkhHyxxDao ykhHyxxDao;
	
	@RequestMapping(value = "/getHyxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getHyxxList(Integer start,Integer limit,String code){
		return yKhHyxxService.getHyxxList(start, limit,code);
		
	}
	@RequestMapping(value = "/HyxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/khgl/ykhHyxxList");
		return modelAndView;
	}
	
	/**
	 * ext转jsp增加内容提交到grid里
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param entity
	 * @return
	 */

	
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(YkhHyxx entity,HttpServletRequest request,HttpServletResponse response) {
//		String str="";
//		String hymc = request.getParameter("hymc");
//		List<Map<String, Object>> hybhList = yKhHyxxService.getHybh(hymc);
//		boolean flag = true;
//		for (int i=0;i<hybhList.size();i++){
//	        Map<String, Object> map=(Map<String, Object>)hybhList.get(i);
//	        Iterator<String> iterator = map.keySet().iterator();
//            while (iterator.hasNext())
//            {
//                String key = (String)iterator.next();
//                Object hybhObj = map.get(key);
//                String hybhitem = hybhObj.toString();
//                if (hybhitem.equals(hymc)) {
//					System.out.println("该行业名称已存在！");
//					flag = false;
//					break;
//				}
//            }
//		}
//		 if (flag == true) {
 			yKhHyxxService.save(entity);
 			return ResponseData.SUCCESS_NO_DATA;
// 		}
//		return str;
	}

	/**
	 * jsp页面的修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YkhHyxx entity, String id) {
//		String str = "0";
		yKhHyxxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
//		return str;
	}
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 * 删除
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yKhHyxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击增加跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/hyAddView")
	public ModelAndView dalmAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/khgl/jsp/hyxx");
		List<Map<String, Object>> jb = yKhHyxxService.getDicByLx("damj");
		List<Map<String, Object>> ssfl = yKhHyxxService.getSsfl();
		mav.addObject("jb", jb);
		mav.addObject("ssfl", ssfl);
		return mav;
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击修改跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/hyxxXgView")
	public ModelAndView jyDetailView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/khgl/jsp/hyxxXg");
		String id = request.getParameter("id");
		YkhHyxx hyxx = yKhHyxxService.getXg(id);
		List<Map<String, Object>> jb = yKhHyxxService.getDicByLx("damj");
		List<Map<String, Object>> ssfl = yKhHyxxService.getSsfl();
		mav.addObject("ssfl", ssfl);
		mav.addObject("jb", jb);
		if (hyxx != null) {
			mav.addObject("hyxx", hyxx);
		}
		return mav;
	}

}
