package com.zssi.framework.app.sfwgl.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.List;
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
import com.zssi.framework.app.jybzgl.model.YjyBzxx;
import com.zssi.framework.app.jygl.model.YjyClyy;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.sfwgl.model.YsfwHfb;
import com.zssi.framework.app.sfwgl.service.YsfwFwxxService;
import com.zssi.framework.app.sfwgl.service.YsfwHfbService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.yhgl.model.SysYhxx;

@Controller
@RequestMapping("/sfwgl/YsfwFwxx")
public class YsfwFwxxController extends BaseController{
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YsfwFwxx.class);

	@Autowired
	private YsfwFwxxService ysfwFwxxService;
	
	@Autowired
	private YsfwHfbService ysfwHfbService;
	
	
	@RequestMapping(value = "/getFwxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTestList(Integer start,
			Integer limit, String code) {
		return ysfwFwxxService.getFwxxList(start, limit, code);
	}
	@RequestMapping(value = "/FwxxPage")
	public ModelAndView openPage() {
		ModelAndView modelAndView = new ModelAndView("/sfwgl/YsfwFwxxList");
		return modelAndView;
	}
//	/**
//	 * 增加和向收文信息中传送
//	 * @author liangkaidi
//	 * @date 2015-10-26
//	 * @param model
//	 * @param entity
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@ResponseBody
//	public String save(YsfwFwxx entity,
//			 @RequestParam("attachMentFile") MultipartFile attachMentFile,YsfwFwxx fwxx,
//			HttpServletResponse actioncontext,HttpServletRequest request) {
//		
//		try{
//			ysfwFwxxService.UploadImageMaterial(attachMentFile, fwxx, actioncontext, request);			
//			return "{\"success\":\"上传成功\"}";	
//		}catch(Exception e) {
//			return "{\"failure\":\""+e.getMessage()+"\"}";
//		}
//		
//		
//	}
	
	/**
	 * 发文页面中————用户信息
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	 
	@RequestMapping(value = "/Yh")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/sfwgl/jsp/Yh");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Yh = ysfwFwxxService.getYh(code);
		if (Yh != null) {
			mav.addObject("Yh", Yh);
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/YhCs")
	public ModelAndView Yhcs(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/sfwgl/jsp/YhCs");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Yh = ysfwFwxxService.getYhCs(code);
		if (Yh != null) {
			mav.addObject("Yh", Yh);
		}
		return mav;
	}
	
	@RequestMapping(value = "/Yhb")
	public ModelAndView Yhb(HttpServletRequest request,
			HttpServletResponse response, String id, String value, String type) {
		System.out.println(type);
		ModelAndView mav = new ModelAndView("/sfwgl/jsp/Yhb");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Yh = ysfwFwxxService.getYhb(code);
		if (Yh != null) {
			mav.addObject("Yh", Yh);
		}
		mav.addObject("value", value);
		mav.addObject("type", type);
		
		return mav;
	}
	/**
	 * 发文页面中————回复信息
	 * @author liangkaidi
	 * @date 2015-11-17
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Hfxx")
	public ModelAndView khxx(HttpServletRequest request,
			HttpServletResponse response,String id) {
		ModelAndView mav = new ModelAndView("/sfwgl/jsp/Hfxx");
		
		
		return mav;
	}
	
	/**
	 * 增加提交save
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
	
//	@RequestMapping(value="/save", method = RequestMethod.POST)
//	@ResponseBody
//	public String  save(ModelMap model,YsfwFwxx entity,
//			@RequestParam("attachMentFile") MultipartFile attachMentFile,YsfwHfb hfb ,YsfwFwxx fwxx,
//			HttpServletResponse actioncontext,HttpServletRequest request){
//		
//		    SysYh yh =AppUtil.getCurrentUser();
//		    entity.setFwr(yh.getXm());
//		    
//		   String filename = null;
//		   
//		if(attachMentFile.isEmpty()){  
//            throw new RuntimeException("文件未上传");
//        }else{
//        	filename = attachMentFile.getOriginalFilename();
//        }
//		entity.setFj(filename);
//		ysfwFwxxService.save(entity);
//		try{
//			ysfwFwxxService.UploadImageMaterial(attachMentFile, fwxx, actioncontext, request);			
//			return "1";	
//		}catch(Exception e) {
//			return "0";
//		}
//	}
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String  save(ModelMap model, YsfwFwxx entity, YsfwFwxx sbxx, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		MultipartFile attachMentFile=request.getFile("attachMentFile");
		   String filename = null;
		if(attachMentFile!=null){
			filename = attachMentFile.getOriginalFilename();
			entity.setFj(filename);
        }
		ysfwFwxxService.saveOrUpdate(entity);
		try{
			ysfwFwxxService.UploadImageMaterial(attachMentFile,sbxx, actioncontext, request);			
			return "1";	
		}catch(Exception e) {
			return "0";
		}
	}
	
	/**
	 * 向回复信息中传附件
	 * @author liangkaidi
	 * @date 2015-10-30
	 * @param entity
	 * @param attachMentFile
	 * @param fwxx
	 * @param actioncontext
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/hfsave", method = RequestMethod.POST)
	@ResponseBody
	
	public String UploadMaterial(YsfwHfb entity,@RequestParam("attachMentFile") MultipartFile attachMentFile,YsfwHfb hfb ,String hfbr,	YsfwFwxx fwxx,String hfr,
			HttpServletResponse actioncontext,HttpServletRequest request){ 
	
		try{
			String filename =  attachMentFile.getOriginalFilename();//文件原名
			  SysYh yh =AppUtil.getCurrentUser();
			  entity.setHfr(yh.getXm());
//			ysfwHfbService.save(hfb,filename);
			ysfwFwxxService.UploadMaterial(attachMentFile, hfb , actioncontext, request);
			return "{\"success\":\"上传成功\"}";	
		}catch(Exception e) {
			return "{\"failure\":\""+e.getMessage()+"\"}";
		}
	}
	
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
		ysfwFwxxService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}	
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击增加跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-23
	 * @param request
	 * @param response
	 * @return
	 */
	

@RequestMapping(value = "/fwAddView")
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response,String yhbh,String type, String value) {
		ModelAndView mav = new ModelAndView("/sfwgl/jsp/Fwxx");
		String ids = request.getParameter("yhbh");
		System.out.println("ynbh是"+ids);
//		System.out.println("****************"+yhbh );
//		if (ids != null && !"".equals(ids)) {
//			SysYhxx sjr = ysfwFwxxService.getyhmc(ids);
////			String bzbh = getyh.getXm();
//			if (sjr != null) {
//				mav.addObject("sjr", sjr.getXm());
//			}
//		}
		if(value==null||"".equals(value)){
			value="//";
		}else{
			try {
				value = URLDecoder.decode(value.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  String[] arr=value.split("/");
		if (yhbh!= null && !"".equals(yhbh)) {
			SysYhxx Yh = ysfwFwxxService.getyh(yhbh);
			if ("1".equals(type)) {
				if (Yh != null) {
					mav.addObject("sjr", Yh.getDlm());
					mav.addObject("sjrid", Yh);
					if(arr.length>=2){
						SysYhxx cs = ysfwFwxxService.getyh(arr[1]);
						mav.addObject("csid", arr[1]);
						mav.addObject("cs", cs.getDlm());
					}else 
						if(arr.length==1){
						mav.addObject("csid", "");
						mav.addObject("cs", "");
					}
				}
			} 
			else if ("2".equals(type)) {
				if (Yh != null) {
					try {
						arr[0]  = new String(arr[0] .getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}   
					mav.addObject("cs", Yh.getDlm());
					mav.addObject("csid", yhbh);
					
					if(arr.length>=2){
						SysYhxx sjr = ysfwFwxxService.getyh(arr[0]);
						mav.addObject("sjrid", arr[0]);
						mav.addObject("sjr", sjr.getDlm());
					}else if (arr.length==1) {
						mav.addObject("sjrid", arr[0]);
						mav.addObject("sjr",  arr[0]);
					}else {
						mav.addObject("sjrid", "");
						mav.addObject("sjr",  "");
					}
				}
			} else {
				if (Yh != null) {
					if( arr.length==2){
						SysYhxx sjr = ysfwFwxxService.getyh(arr[0]);
						SysYhxx cs = ysfwFwxxService.getyh(arr[1]);
						mav.addObject("sjrid", arr[0]);
						mav.addObject("csid", arr[1]);
						mav.addObject("sjr", sjr.getDlm());
						mav.addObject("cs", cs.getDlm());
					}else if(arr.length==1){
						SysYhxx sjr = ysfwFwxxService.getyh(arr[0]);
						mav.addObject("sjrid", arr[0]);
						mav.addObject("csid", "");
						mav.addObject("sjr", sjr.getDlm());
						mav.addObject("cs", "");
					}else{
						mav.addObject("sjrid", "");
						mav.addObject("csid", "");
						mav.addObject("sjr", "");
						mav.addObject("cs", "");
					}
				}    
			}
		}
		
		return mav;
	}
/**
 *  点击增加拉取抄送人
 * @author liangkaidi
 * @date 2015-12-3
 * @param request
 * @param response
 * @param ids
 * @return
 */
@RequestMapping(value = "/fwAddCsView")
public ModelAndView fwAddCsView(HttpServletRequest request,
		HttpServletResponse response, String ids) {
	ModelAndView mav = new ModelAndView("/sfwgl/jsp/Fwxx");
	String yhbh = request.getParameter("yhbh");
	if (ids != null && !"".equals(ids)) {
		SysYhxx cs =ysfwFwxxService.getyhmcCs(ids);
//		String bzbh = getyhcs.getXm();
		if (cs != null) {
			mav.addObject("cs", cs.getXm());
		}
	}
	
	return mav;
}
/**
 * 
 * @author liangkaidi
 * @date 2015-11-23
 * @param request
 * @param response
 * @param ids
 * @return
 */
@RequestMapping(value = "/fwCkView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/sfwgl/jsp/FwxxCk");
	String id = request.getParameter("id");
	
	YsfwFwxx fwxx = ysfwFwxxService.getXg(id);
	if (fwxx != null) {
		mav.addObject("fwxx", fwxx);
	}
	return mav;
}


}
