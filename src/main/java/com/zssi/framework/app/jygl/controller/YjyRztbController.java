package com.zssi.framework.app.jygl.controller;

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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyRztb;
import com.zssi.framework.app.jygl.service.YjyRztbService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 检验认证图标
 * @author duanpeijun
 * @date 2015年10月15日
 */
@Controller
@RequestMapping(value="/jygl/YjyRztb")
public class YjyRztbController extends BaseController{

	@Autowired
	private YjyRztbService service;
	
	/**
	 * 打开认证图标页面
	 * @return
	 */
	@RequestMapping(value = "/rztbView")
	public ModelAndView openMaterialMgrPage(){
		ModelAndView view = new ModelAndView("/jygl/yjyRztbList");
		return view;
	}
	
	/**
	 * 打开上传认证图标 页面
	 * @return
	 */
	@RequestMapping(value = "/scRztbView")
	public ModelAndView openImageMaterialView(){
		ModelAndView view = new ModelAndView("/jygl/yjyScRztb");
		return view;
	}
	
	/**
	 * 后台：检验认证图标
	 * @author duanpeijun
	 * @date 2015年10月15日
	 * @param start
	 * @param limit
	 * @param rzmc  认证名称
	 * @return
	 */
	@RequestMapping(value = "/getRztbList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String,Object>> getRztbList(Integer start,Integer limit, String rzmc) {
		return service.getRztbList(start, limit, rzmc);
	}
	
	/**
	 * 上传图片素材
	 * @return
	 */
	@RequestMapping(value="/uploadImage")
	@ResponseBody
	public String UploadImageMaterial(@RequestParam("attachMentFile") MultipartFile attachMentFile,YjyRztb rztb,
			HttpServletResponse actioncontext,HttpServletRequest request){    
		try{
			service.UploadImageMaterial(attachMentFile, rztb, actioncontext, request);
			return "{\"success\":\"上传成功\"}";	
		}catch(Exception e) {
			return "{\"failure\":\""+e.getMessage()+"\"}";
		}
	}
	
	/**
	 * 取得素材表中3天内的图片列表(上传的素材大于3天微信平台将会删除)
	 * @return
	 */
	@RequestMapping(value = "/getImageList", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getImageList(String id) {
		return service.getImageList(id);
	}
	
	/**
	 * 认证分类（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByRzfl", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByRzfl(String zdzl) {
		return service.getDicByRzfl("rzfl");
	}
	
	/**
	 * 删除图文名称 信息
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		service.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
}
