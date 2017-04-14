package com.zssi.framework.app.jyzxxx.controller;

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
import com.zssi.framework.app.jyzxxx.service.YjyXxcxService;


@Controller
@RequestMapping("/jyzxxx/YJyXxcx")
public class YjyXxcxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyXxcxController.class);
	@Autowired
	private YjyXxcxService service;
	
	/**
	 * 检验咨询信息查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	@RequestMapping(value = "/XxcxPage")
	public ModelAndView xxcxPage(String kobe) throws ParseException{
		ModelAndView mav = new ModelAndView("/jyzxxx/cplxPage");
		List<Map<String,Object>> xxcx=service.getXxcx(0,20);
		mav.addObject("xxcx", xxcx);
		return mav;
	}
	
	/**
	 * 检验咨询信息查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/XxcxPage1")
	public ModelAndView xxcxPage1(String cplx,String cpmc,String jyyj) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		cpmc = new String(cpmc.getBytes("ISO-8859-1"),"UTF-8");
		jyyj = new String(jyyj.getBytes("ISO-8859-1"),"UTF-8");
		String url = "";
		ModelAndView mav = new ModelAndView();
		if (jyyj!=null && !("").equals(jyyj)) {
			url = "/jyzxxx/jyyjPage";
			List<Map<String,Object>> xxcx=service.getList(0, 20, cplx, cpmc, jyyj);
			mav.addObject("xxcx", xxcx);
		} else if(cpmc!=null && !("").equals(cpmc)){
			url = "/jyzxxx/cpmcPage";
			List<Map<String,Object>> xxcx=service.getList(0, 20, cplx, cpmc, jyyj);
			mav.addObject("xxcx", xxcx);
		} else {
			url = "/jyzxxx/cplxPage";
			List<Map<String,Object>> xxcx=service.getXxcx(0,20,cplx);
			mav.addObject("xxcx", xxcx);
		}
		mav.addObject("cplx", cplx);
		mav.addObject("cpmc", cpmc);
		mav.addObject("jyyj", jyyj);
		
		mav.setViewName(url);
		return mav;
	}
	
//	/**
//	 * 查询产品类型List
//	 * @author wangyong
//	 * @date 2016年6月15日
//	 * @return
//	 */
//	@RequestMapping(value="getCplxlist")
//	@ResponseBody
//	public List<Map<String, Object>> getCplxlist(Integer start,Integer limit,Integer size) throws ParseException{
//		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
//		List<Map<String, Object>> value=service.getXxcx(start, limit);
//		int count=service.getBgxxCount(start, limit);
//		for(int i=0;i<value.size();i++){
//			Map<String,Object> map=value.get(i);
//			map.put("count", count);
//			if(count%size==0){
//				map.put("pages", count/size);
//			}else{
//				map.put("pages", count/size+1);
//			}
//			list.add(map);
//		}
//		return list;
//	}
	
	/**
	 * 查询产品类型List
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	@RequestMapping(value="getCplxlist1")
	@ResponseBody
	public List<Map<String, Object>> getCplxlist(Integer start,Integer limit,Integer size,HttpServletRequest request,
			HttpServletResponse response) throws ParseException{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		String cplx = request.getParameter("cplx");
//		String cpmc = request.getParameter("cpmc");
//		String jyyj = request.getParameter("jyyj");
		List<Map<String, Object>> value=new ArrayList<Map<String,Object>>();
//		if (jyyj!=null && !("").equals(jyyj)) {
//			value=service.getList(start, limit, cplx, cpmc, jyyj);
//		} else if(cpmc!=null && !("").equals(cpmc)){
//			value=service.getList(start, limit, cplx, cpmc, jyyj);
//		} else {
//			value=service.getXxcx(start, limit, cplx);
//		}
		value=service.getXxcx(start, limit, cplx);
		int count=service.getBgxxCount(start, limit,cplx);
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
	 * 查询产品信息页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/cpmcView")
	public ModelAndView cpcxPage(String cplx,String cpbh,String cpmc) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		ModelAndView mav = new ModelAndView("/jyzxxx/cpmcPage");
		List<Map<String,Object>> cpcx=service.getCpcx(0,20,cplx);
		mav.addObject("cpcx", cpcx);
		mav.addObject("cplx", cplx);
		mav.addObject("cpbh", cpbh);
		mav.addObject("cpmc", cpmc);
		return mav;
	}
	
	/**
	 * 查询产品名称List
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="getCpmclist")
	@ResponseBody
	public List<Map<String, Object>> getCpmclist(Integer start,Integer limit,Integer size,String cplx,String cpmc,String jyyj) throws ParseException, Exception{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=service.getCpList(start, limit, cplx, cpmc, jyyj);
		int count=service.getCpCount(start, limit, cplx,cpmc, jyyj);
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
	 * 查询产品检验依据页面
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/jyyjView")
	public ModelAndView jyyjPage(String cplx,String cpbh,String cpmc,String jyyj) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		ModelAndView mav = new ModelAndView("/jyzxxx/jyyjPage");
		List<Map<String,Object>> cpcx=service.getJyyj(0,20,cplx,cpbh);
		mav.addObject("cpcx", cpcx);
		mav.addObject("cplx", cplx);
		mav.addObject("cpbh", cpbh);
		mav.addObject("cpmc", cpmc);
		mav.addObject("jyyj", jyyj);
		return mav;
	}
	
	/**
	 * 查询产品检验依据List
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="getJyyjlist")
	@ResponseBody
	public List<Map<String, Object>> getJyyjList(Integer start,Integer limit,Integer size,String cplx, String cpbh, String cpmc, String jyyj) 
			throws ParseException, Exception{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=service.getJyyjList(start, limit, cplx, cpbh, cpmc, jyyj);
		int count=service.getJyyjCount(start, limit, cplx, cpbh, jyyj);
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
	 * 查询产品检验项目页面
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/jyxmView")
	public ModelAndView jyxmPage(String cplx,String cpbh,String cpmc,String jyyj) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		jyyj = new String(jyyj.getBytes("ISO-8859-1"),"UTF-8");
		ModelAndView mav = new ModelAndView("/jyzxxx/jyxmPage");
		List<Map<String,Object>> xmcx=service.getJyxm(0, 20, cplx, cpbh, jyyj);
		mav.addObject("xmcx", xmcx);
		mav.addObject("cplx", cplx);
		mav.addObject("cpbh", cpbh);
		mav.addObject("cpmc", cpmc);
		mav.addObject("jyyj", jyyj);
		return mav;
	}
	
	/**
	 * 查询产品检验项目List
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="getJyxmlist")
	@ResponseBody
	public List<Map<String, Object>> getJyxmList(Integer start,Integer limit,Integer size,String cplx, String cpbh, String cpmc, String jyyj, String jyxm) 
			throws ParseException, Exception{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=service.getJyxmList(start, limit, cplx, cpbh, cpmc, jyyj, jyxm);
		int count=service.getJyxmCount(start, limit, cplx, cpbh, jyyj, jyxm);
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
	
}

