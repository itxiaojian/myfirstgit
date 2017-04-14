package com.zssi.framework.app.khgl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.jsfwgl.model.YjsfwXyxx;
import com.zssi.framework.app.khgl.service.YkhKhxxService;
import com.zssi.framework.app.khgl.service.YkhKhxxcxService;
@Controller
@RequestMapping("/khgl/khxxcx")
public class YkhKhxxcxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YjsfwXyxx.class);

@Autowired
private YkhKhxxcxService service;

@Autowired
private YkhKhxxService yKhKhxxService;


/**
 * 
 * @author liangkaidi
 * @date 2016-1-15
 * @return
 */
@RequestMapping(value = "/openPage")
public ModelAndView openPage(){
	ModelAndView mav = new ModelAndView("/khgl/Khxxcx");
	List<Map<String,Object>> zdmc=service.getZdmc("Y_KH_KHXX");
	List<Map<String, Object>> zjlx = yKhKhxxService.getDicByList("zjlx");
	mav.addObject("zdmc", zdmc);
	mav.addObject("zjlx", zjlx);
	return mav;
}
/**
 * 
 * @author liangkaidi
 * @date 2016-1-13
 * @param start
 * @param limit
 * @param cs
 * @param cxtj
 * @param size
 * @return
 */

@RequestMapping(value = "/getKhxxcxList")
@ResponseBody
public List<Map<String, Object>> getJsfwcxList(Integer start,Integer limit,String cs,String cxtj,Integer size){
	List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> value=service.getKhxxcxList(start, limit, cs,cxtj);
	int count=service.getKhxxcxcxCount(start, limit, cs, cxtj);
	for(int i=0;i<value.size();i++){
		Map<String,Object> map=value.get(i);
		map.put("count", count);
		if(count%size==0){
			map.put("pages", count/size);
		}else{
			map.put("pages", count/size+1);
		}
		list.add(map);
	}
	return list;
	
}
/**
 * exl导出
 *  @author liangkaidi
 * @date 2016年1月14日
 * @param request
 * @param response
 * @param code
 * @throws Exception
 */

@RequestMapping(value = "/export")
public void exportExcel(HttpServletRequest request, HttpServletResponse response,String cs,String cxtj,String bt) throws Exception{
	service.exportExcel(request, response, cs, cxtj, bt);
}
}



