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
import com.zssi.framework.app.tjgl.service.BgcxService;
import com.zssi.framework.app.tjgl.service.YpcxService;
import com.zssi.framework.app.tsxx.model.YtsXx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

@Controller 
@RequestMapping("/tjgl/ypcx")
public class YpcxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YtsXx.class);
	
	@Autowired
	private YpcxService service;
	
	@Autowired
	private BgcxService bgcxService;
	
	@Autowired
	private YypYpxxService ypxxService;
	
	@RequestMapping(value = "/openPage")
	public ModelAndView openPage(){
		ModelAndView mav = new ModelAndView("/tjgl/ypcxView");
		List<Map<String,Object>> zdmc=service.getZdmc("Y_YP_YPXX");
		List<Map<String,Object>> zdmc1=service.getZdmc1("Y_YP_YPXX","Y_JY_BGXX");
		List<Map<String,Object>> jyksList=bgcxService.getJyksList();
		List<Map<String,Object>> ywksList=bgcxService.getYwksList();
		List<Map<String,Object>> bzrlist=bgcxService.getBzrList();
		List<Map<String, Object>> bgfsfs = ypxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> ypjyzt = ypxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> jylx = ypxxService.getDicByJylx("jylx");
		mav.addObject("zdmc", zdmc);
		mav.addObject("zdmc1", zdmc1);
		mav.addObject("bzrlist", bzrlist);
		mav.addObject("jyksList", jyksList);
		mav.addObject("ywksList", ywksList);
		mav.addObject("bgfsfs", bgfsfs);
		mav.addObject("ypjyzt", ypjyzt);
		mav.addObject("jylx",jylx);
		return mav;
	}
	
	
	@RequestMapping(value = "/getYpcxList")
	@ResponseBody
	public List<Map<String, Object>> getYpcxList(Integer start,Integer limit,String cs,String cxtj,Integer size){
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
	
	/**
	 * exl导出
	 * @author liujiansen
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
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月19日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @return
	 */
	@RequestMapping(value = "/getCount")
	@ResponseBody
	public String getCount(Integer start,Integer limit,String cs,String cxtj){
		Integer count=service.getYpcxCount(start, limit, cs, cxtj);
		return count.toString();
	}
}
