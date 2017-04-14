package com.zssi.framework.app.sfwgl.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sfwgl.dao.YsfwHfbDao;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.sfwgl.model.YsfwHfb;
import com.zssi.framework.app.sfwgl.service.YsfwHfbService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;

@Controller
@RequestMapping("/sfwgl/YsfwHfb")
public class YsfwHfbController extends BaseController{
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog( YsfwHfb.class);
		
	@Autowired
	private YsfwHfbService ysfwHfbService;
	
	
	@RequestMapping(value = "/getHfbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTestList(Integer start,
			Integer limit, String code) {
		return ysfwHfbService.getHfbList(start, limit, code);
	}
	
	@RequestMapping(value = "/HfbPage")
	public ModelAndView openPage() {
		ModelAndView modelAndView = new ModelAndView("/sfwgl/YsfwHfb");
		return modelAndView;
	}

//	 * 增加
//	 * @author liangkaidi
//	 * @date 2015-10-29
//	 * @param model
//	 * @param entity
//	 * @param request
//	 * @param response
//	 * @return
	 

//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@ResponseBody
//	public String save(YsfwHfb entity,
//		@RequestParam("attachMentFile") MultipartFile attachMentFile,YsfwHfb hfb,String hfbr,String hfr,String fwr ,
//			HttpServletResponse actioncontext,HttpServletRequest request) {
//
////		ysfwSwxxService.UploadImageMaterial(attachMentFile, swxx, actioncontext, request);//		向收文中保存并上传
//		try{
//
//
//			//			ysfwHfbService.UploadImageMaterial(attachMentFile, hfb, hfbr, hfr, fwr, actioncontext, request);		
//			ysfwHfbService.UploadImageMaterial(attachMentFile, hfb, hfbr, hfr, fwr, actioncontext, request);
//			return "{\"success\":\"上传成功\"}";	
//		}catch(Exception e) {
//			return "{\"failure\":\""+e.getMessage()+"\"}";
//		}
//		
//		
//	}
	
	/**
	 * 增加提交save
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @param arg0 
	 * @return
	 */
	/*@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String  save(ModelMap model,YsfwHfb entity,
			@RequestParam("attachMentFile") MultipartFile attachMentFile,YsfwHfb hfb ,String hfbr,String hfr,
			HttpServletResponse actioncontext,HttpServletRequest request, YsfwHfbDao arg0){
		String filename = null;
		
		if(attachMentFile.isEmpty()){  
            throw new RuntimeException("文件未上传");
        }else{
        	filename = attachMentFile.getOriginalFilename();
        }
		    entity.setFj(filename);
		    ysfwHfbService.save(entity);
		try{
			ysfwHfbService.UploadImageMaterial(attachMentFile, hfb, filename, filename, filename, actioncontext, request);			
			return "1";	
		}catch(Exception e) {
			return "0";
		}
	}*/
//	@RequestMapping(value="/save", method = RequestMethod.POST)
//	@ResponseBody
//	public String  save(ModelMap model, YsfwHfb entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
//		SysYh yh=AppUtil.getCurrentUser();
//		entity.setHfr(yh.getXm());
//		try{
//			ysfwHfbService.UploadImageMaterial(entity, actioncontext, request);			
//			return "1";	
//		}catch(Exception e) {
//			return "0";
//		}
//	}
//	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String  save(ModelMap model, YsfwHfb entity, YsfwHfb sbxx, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		MultipartFile attachMentFile=request.getFile("attachMentFile");
		   String filename = null;
		if(attachMentFile!=null){
			filename = attachMentFile.getOriginalFilename();
			entity.setFj(filename);
        }
		ysfwHfbService.saveOrUpdate(entity);
		try{
			ysfwHfbService.UploadImageMaterial(attachMentFile,sbxx, actioncontext, request);			
			return "1";	
		}catch(Exception e) {
			return "0";
		}
	}
	
	/**
	 * 修改
	 * @author liangkaidi
	 * @date 2015-11-2
	 * @param entity
	 * @param id
	 * @param attachMentFile
	 * @param hfb
	 * @param actioncontext
	 * @param request
	 * @return
	 */
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	@ResponseBody
//	public String update(YsfwHfb entity, String id,@RequestParam("attachMentFile") MultipartFile attachMentFile,YsfwHfb hfb,String fwr,String hfbr,String hfr ,
//			HttpServletResponse actioncontext,HttpServletRequest request) {
//		ysfwHfbService.update(entity, id);
//		try{
//			ysfwHfbService.UploadImageMaterial(attachMentFile, hfb, fwr , hfbr, hfr, actioncontext, request);		
//			return "{\"success\":\"上传成功\"}";	
//		}catch(Exception e) {
//			return "{\"failure\":\""+e.getMessage()+"\"}";
//		}
////		return ResponseData.SUCCESS_NO_DATA;
//	}
	
	
	
	/**
	 * 删除
	 * @author liangkaidi
	 * @date 2015-10-26
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids) {
		ysfwHfbService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 点击查看跳转jsp页面
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/hfCkView")
	public ModelAndView jyDetailView(HttpServletRequest request,
			HttpServletResponse response,String ids) {
		ModelAndView mav = new ModelAndView("/sfwgl/jsp/HfxxCk");
		
		String id = request.getParameter("id");
		YsfwHfb hfxx = ysfwHfbService.getXg(id);
		
		if (hfxx != null) {
			if (hfxx != null) {
				mav.addObject("hfxx", hfxx);
			}

			mav.addObject("hfxx", hfxx);
		}
		return mav;
	}
}
