package com.zssi.framework.app.tjgl.controller;

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
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.tjgl.service.BgcxService;
import com.zssi.framework.app.tjgl.service.SbcxService;
import com.zssi.framework.app.tsxx.model.YtsXx;

@Controller 
@RequestMapping("/tjgl/sbcx")
public class SbcxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YtsXx.class);
	
	@Autowired
	private SbcxService service;
	
	@Autowired
	private BgcxService bgservice;
	
	@Autowired
	private YsbXxService sbService;
	
	@RequestMapping(value = "/openPage")
	public ModelAndView openPage(){
		ModelAndView mav = new ModelAndView("/tjgl/sbcxView");
		List<Map<String,Object>> zdmc=service.getZdmc("Y_SB_XX");
		List<Map<String,Object>> jyksList=bgservice.getJyksList();
		List<Map<String, Object>> jyzq = sbService.getDicByLx("jyzq");
		List<Map<String, Object>> jddw = sbService.getDicByLx("jddw");
		List<Map<String, Object>> sbzt = sbService.getDicByLx("sbzt");
		List<Map<String, Object>> syzt = sbService.getDicByLx("syzt");
		mav.addObject("jyksList", jyksList);
		mav.addObject("jyzq",jyzq);
		mav.addObject("jddw",jddw);
		mav.addObject("sbzt",sbzt);
		mav.addObject("syzt",syzt);
		mav.addObject("zdmc", zdmc);
		return mav;
	}
	
	
	@RequestMapping(value = "/getSbcxList")
	@ResponseBody
	public List<Map<String, Object>> getSbcxList(Integer start,Integer limit,String cs,String cxtj,Integer size){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=service.getYpcxList(start, limit, cs,cxtj);
		int count=service.getYpcxCount(start, limit, cs, cxtj);
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
	
	@RequestMapping(value = "/getJdzs")
	@ResponseBody
	public List<Map<String, Object>> getJdzs(Integer id){
		List<Map<String, Object>> list=service.getJdzs(id);
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
