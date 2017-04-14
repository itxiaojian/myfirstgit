package com.zssi.framework.app.tjgl.controller;

import java.text.ParseException;
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
import com.zssi.framework.app.tsxx.model.YtsXx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

@Controller 
@RequestMapping("/tjgl/bgcx")
public class BgcxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YtsXx.class);
	
	@Autowired
	private BgcxService service;
	@Autowired
	private YypYpxxService ypxxService;
	
	@RequestMapping(value = "/openPage")
	public ModelAndView openPage(){
		ModelAndView mav = new ModelAndView("/tjgl/bgcxView");
		List<Map<String,Object>> zdmc=service.getZdmc("Y_JY_BGXX");
		List<Map<String,Object>> zdmc1=service.getZdmc1("Y_YP_YPXX","Y_JY_BGXX");
		List<Map<String,Object>> bzrlist=service.getBzrList();
		List<Map<String,Object>> jyksList=service.getJyksList();
		List<Map<String,Object>> ywksList=service.getYwksList();
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
	
	@RequestMapping(value = "/openypPage")
	public ModelAndView openypPage(){
		ModelAndView mav = new ModelAndView("/tjgl/ypcxView");
		List<Map<String,Object>> zdmc=service.getZdmc("Y_JY_BGXX");
		List<Map<String,Object>> zdmc1=service.getZdmc1("Y_YP_YPXX","Y_JY_BGXX");
		List<Map<String,Object>> bzrlist=service.getBzrList();
		List<Map<String,Object>> jyksList=service.getJyksList();
		List<Map<String,Object>> ywksList=service.getYwksList();
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
	/**
	 * 报告预警页面打开
	 * @author liusong
	 * @date 2016年1月13日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @param size
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/warnPage")
	public ModelAndView warnPage(String kobe) throws ParseException{
		ModelAndView mav = new ModelAndView("/tjgl/bgyjView");
		List<Map<String,Object>> bgxx=service.getBgxx(0,10);
		List<Map<String,Object>> bgxx1=service.getBgxx1(0,10);
		mav.addObject("bgxx", bgxx);
		mav.addObject("bgxx1",bgxx1);
		if(kobe != null||!"".equals(kobe)){
			mav.addObject("kobe",kobe);
		}
		return mav;
	}
	
	/*
	 * 报告预警翻页查询
	 * liusong
	 * 2016-04-21*/
	@RequestMapping(value="getBgxxlist")
	@ResponseBody
	public List<Map<String, Object>> getBgxxlist(Integer start,Integer limit,Integer size) throws ParseException{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=service.getBgxx(start, limit);
		int count=service.getBgxxCount(start, limit);
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
		
		/*
		 * 报告预警翻页查询
		 * liusong
		 * 2016-04-21*/
		@RequestMapping(value="getBgxx1list")
		@ResponseBody
		public List<Map<String, Object>> getBgxx1list(Integer start1,Integer limit1,Integer size1) throws ParseException{
		List<Map<String, Object>> list1=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value1=service.getBgxx1(start1, limit1);
		int count1=service.getBgxx1Count(start1, limit1);
		for(int i=0;i<value1.size();i++){
			Map<String,Object> map=value1.get(i);
			map.put("count1", count1);
			if(count1%size1==0){
				map.put("pages1", count1/size1);
			}else{
				map.put("pages1", count1/size1+1);
			}
			list1.add(map);
		}
		return list1;
	}
	
	/**
	 * 报告查询
	 * @author liujiansen
	 * @date 2016年1月13日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/getBgcxList")
	@ResponseBody
	public List<Map<String, Object>> getYpcxList(Integer start,Integer limit,String cs,String cxtj,Integer size){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=service.getBgcxList(start, limit, cs,cxtj);
		int count=service.getBgcxCount(start, limit, cs, cxtj);
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
		Integer count=service.getBgcxCount(start, limit, cs, cxtj);
		return count.toString();
	}
	
	/**
	 * 报告详情
	 * @author liujiansen
	 * @date 2016年1月13日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/bgxxView")
	public ModelAndView bgxxView(HttpServletRequest request,HttpServletResponse response,String bgbh){
		ModelAndView mav = new ModelAndView("/tjgl/bgxxView");
		mav.addObject("bgbh", request.getParameter("bgbh"));
		mav.addObject("fileName", request.getParameter("bgbh")+".doc");
		return mav;
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
	 * 报告延期查询页面跳转
	 * @author liusong
	 * @date 2016年1月14日
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@RequestMapping(value = "/opentqPage")
	public ModelAndView opentqPage(){
		ModelAndView mav = new ModelAndView("/tjgl/bgtqView");
		List<Map<String,Object>> ksmc=service.getJyksList();
		mav.addObject("ksmc", ksmc);
		return mav;
	}
	
	/**
	 * 查询报告延期
	 * @author liusong
	 * @date 2016年1月14日
	 * @param request
	 * @param response
	 * @param code
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/getBgyq")
	@ResponseBody
	public List<Map<String,Object>> getBgyq(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String ksmccx = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		List<Map<String,Object>> sjbbCbtj=service.getBgyqList(ksmccx, ksyf,jsyf);
		return sjbbCbtj;
	}
	
	/**
	 * 报告拖期统计导出Excle
	 * @author liusong
	 * @date 2016年1月26日
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportBgtq")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ksmc = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		service.exportBgtq(request,response,ksmc,ksyf,jsyf);
	}
}
