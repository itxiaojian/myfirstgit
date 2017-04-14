package com.zssi.framework.app.tszf.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.zssi.framework.app.kygl.model.YkyCggl;
import com.zssi.framework.app.tszf.model.SysTszf;
import com.zssi.framework.app.tszf.service.SysTszfService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 
 * @author liangkaidi
 * @date 2015-12-21
 */
@Controller 
@RequestMapping("/tszf/SysTszf")
public class SysTszfController extends BaseController{
	protected final transient Logger logger=LoggerFactory.getPresentationLog(SysTszf.class);	
	@Autowired
	private SysTszfService sysTszfService;
	
	@RequestMapping(value = "/getTszfList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTszfList(Integer start,Integer limit,String code){
		return sysTszfService.getTszfList(start, limit,code);
		
	}
	
	/**
	 * 根据当前登陆用户取得该用户的待办任务列表数目
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/getTszf", method = RequestMethod.POST)
	@ResponseBody
	public String getTszf(Integer start,
			Integer limit, String rolekind) throws UnsupportedEncodingException {
		List<Map<String, Object>> list = sysTszfService.getTszf(null);
		List<String> newlist = new ArrayList<String>();
		for(Map<String, Object> map : list){
			String tszf = new String(map.get("tszf").toString().getBytes("iso8859_1"),"utf-8");
			newlist.add(tszf);
		}
		int size = list.size();
//		ResponseData res = new ResponseData(true,size+"");
		String res = "{\"success\":true,\"msg\":"+size+",\"list\":"+newlist+"}";
		return res;
	}
	
	
	@RequestMapping(value = "/TszfPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/tszf/TszfList");
		return modelAndView;
	}
	/**
	 * 保存
	 * @author liangkaidi
	 * @date 2015-12-21
	 * @param request
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, SysTszf entity) {
		String str = "0";
		String tszf = request.getParameter("tszf");
		List<Map<String, Object>> tszfList = sysTszfService.getTszf(tszf);
		boolean flag = true;
		for (int i=0;i<tszfList.size();i++){
	        Map<String, Object> map=(Map<String, Object>)tszfList.get(i);
	        Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext())
            {
                String key = (String)iterator.next();
                Object tszfObj = map.get(key);
                String tszfitem = tszfObj.toString();
                if (tszfitem.equals(tszf)) {
					System.out.println("该编号已存在！");
					flag = false;
					break;
				}
            }
		}
		if (flag == true) {
			str=sysTszfService.saveRb(request, entity);
		}
		return str;
	}
	
	/**
	 * 增加提交save
	 * @author liusong
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */

	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response, String id) {
		String str = "1";
		sysTszfService.update(request, id);
		return str;
	}
	
	
	
	
	
	@RequestMapping(value = "/tszfXgView")
//	public ModelAndView jyDetailView(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("/tszf/jsp/TszfXg");
//		
//		String id = request.getParameter("id");
//		List<Map<String, Object>> tszfxx = sysTszfService.getXg(id);
//		if (tszfxx != null) {
//			mav.addObject("tszfxx", tszfxx);
//		}
//		return mav;
//	}
	
	
	public ModelAndView jyDetailView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/tszf/jsp/TszfXg");
		
		String id = request.getParameter("id");
		List<Map<String, Object>> tszfxx = sysTszfService.getXg(id);
		if (tszfxx != null) {
			mav.addObject("tszfxx", tszfxx);
		}
		return mav;
	}
	
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		sysTszfService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	
	
	
@RequestMapping(value = "/tszfAddView")
@ResponseBody
	public ModelAndView tszfAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/tszf/jsp/TszfAdd");
		return mav;
	}
}
