package com.zssi.framework.app.jygl.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyYsjl;
import com.zssi.framework.app.jygl.service.YjyYsjlService;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;

//报告原始信息管理
//liusong  2016-03-09
@Controller
@RequestMapping("/jygl/YjyYsjl")
public class YjyYsjlController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(YjyYsjl.class);
	
	@Autowired
	private YjyYsjlService ysjlService;
	
	@RequestMapping(value = "/YsjlPage")
	public ModelAndView openPage(){
		ModelAndView andView = new ModelAndView("/jygl/yYsjlList");
		return andView;
	}
	
	@RequestMapping(value = "/getYsjlList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYsjlList(Integer start,Integer limit,String code){
		return ysjlService.getYsjlList(start, limit, code);
	}
	
	@RequestMapping(value = "/ysjlUpdateView")
	public ModelAndView ysjlUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ysjlUpdate");
		String bid = request.getParameter("bid");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> ysjl = ysjlService.getYsjl(bid);
		List<Map<String, Object>> ypjyzt = ysjlService.getYpjyzt("ypjyzt");
		if (ysjl != null) {
			mav.addObject("ysjl", ysjl);
			mav.addObject("ypjyzt", ypjyzt);
		}
		return mav;
	}
	
	@RequestMapping(value="/uploadImage")
	@ResponseBody
	public String UploadImageMaterial(@RequestParam("attachMentFile") MultipartFile attachMentFile,YjyYsjl entity,
			HttpServletResponse actioncontext,HttpServletRequest request){ 
		try{
			ysjlService.UploadImageMaterial(attachMentFile, entity,actioncontext, request);
			return "{\"success\":\"上传成功\"}";	
		}catch(Exception e) {
			return "{\"failure\":\""+e.getMessage()+"\"}";
		}
	}
	
	/**
	 * 点击查看电子签名
	 * @return
	 */
	@RequestMapping(value = "/getImageList", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getImageList(String id) {
		return ysjlService.getImageList(id);
	}
	
	@RequestMapping(value="/WordOnLine")
	public ModelAndView openPage1(String ysjlsjm,String bz){
		String url = null ;
		if(bz.equals("2")){
			url ="/jygl/jsp/WordOnLine";
		}
		if(bz.equals("3")){
			url ="/jygl/jsp/PdfOnLine";
		}
		ModelAndView modelAndView = new ModelAndView(url);
		if (ysjlsjm != null) {
			modelAndView.addObject("ysjlsjm", ysjlsjm);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ysjlService.getDicByLx("sfyczgc");
	}
	
	@RequestMapping(value = "/getDicByLx1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return ysjlService.getDicByLx("ypjyzt");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		System.out.println(ids);
		ysjlService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 点击修改按钮跳转到修改窗口的jsp页面
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/gyyOnUse")
	public ModelAndView gyyOnUse(HttpServletRequest request,
			HttpServletResponse response) {
		String bgbh = request.getParameter("bgbh");
		List<Map<String, Object>> ysjl = ysjlService.getYsjlbyBgbh(bgbh);
		String path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
	        	+ File.separator +"home/";
		ModelAndView mav = new ModelAndView("/jygl/jsp/gyyOnUse");
			mav.addObject("path", path);
			mav.addObject("bgbh", bgbh);
			if(ysjl.size()!=0){
				mav.addObject("ysjl", ysjl);
			}
			
		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData save(HttpServletRequest request,String bgbh,String imgeId,String szPostfix,YjyYsjl entity) {
		String path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
	        	+ File.separator +"home";
		String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
		List<String> fileTypes1 = new ArrayList<String>();
        fileTypes1.add(".png");
        fileTypes1.add(".jpg");
        List<String> fileTypes2 = new ArrayList<String>();
        fileTypes2.add(".pdf");
        if(fileTypes1.contains(szPostfix)){
        	entity.setBgbh(bgbh);
    		entity.setBz("1");
    		entity.setYwysjl(0);
    		entity.setYsjllj(p);
    		entity.setYsjlsjm(imgeId + szPostfix);
    		entity.setYsjlwjm(imgeId + szPostfix);
    		entity.setScsj(Calendar.getInstance().getTime());
        	entity.setScry(AppUtil.getCurrentUser().getXm());
    		ysjlService.saveOrUpdate(entity);
        }else if(fileTypes2.contains(szPostfix)){
        	entity.setBgbh(bgbh);
    		entity.setBz("3");
    		entity.setYwysjl(0);
    		entity.setYsjllj(p);
    		entity.setYsjlsjm(imgeId + szPostfix);
    		entity.setYsjlwjm(imgeId + szPostfix);
    		entity.setScsj(Calendar.getInstance().getTime());
        	entity.setScry(AppUtil.getCurrentUser().getXm());
    		ysjlService.saveOrUpdate(entity);
        }
		return ResponseData.SUCCESS_NO_DATA;
	}
	

}
