package com.zssi.framework.app.jygl.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyBgmb;
import com.zssi.framework.app.jygl.service.YjyBgmbService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 检验报告模版
 * @author duanpeijun
 * @date 2015年10月13日
 */
@Controller
@RequestMapping("/jygl/YjyBgmb")
public class YjyBgmbController extends BaseController{
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyJyxxController.class);
	@Autowired
	private YjyBgmbService service;
	
	/**
	 * 
	 * @author duanpeijun
	 * @date 2015年10月13日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgmbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgmbList(Integer start,Integer limit,String canshu){
		return service.getBgmbList(start, limit, canshu);
	}
	
	@RequestMapping(value = "/BgmbPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgmbList");
		return modelAndView;
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YjyBgmb entity,
			HttpServletRequest request,HttpServletResponse response){
		service.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 在线编辑word保存
	 * @author liusong
	 * @date 2015年11月24日
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/savepage")
	public void save(HttpServletRequest request,HttpServletResponse response){
		FileSaver fs=new FileSaver(request,response);
		System.out.println(request.getSession().getServletContext().getRealPath("resources/")+"/"+fs.getFileName());
		fs.saveToFile(request.getSession().getServletContext().getRealPath("resources/")+"/"+fs.getFileName());
		fs.close();
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjyBgmb entity, String id) {
		service.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		service.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * liusong 15-11-17
	 * 上传附件素材
	 * @return
	 */
	@RequestMapping(value="/uploadImage")
	@ResponseBody
	public String UploadImageMaterial(@RequestParam("attachMentFile") MultipartFile attachMentFile,YjyBgmb bgmb,
			HttpServletResponse actioncontext,HttpServletRequest request){ 
//		    alert("程序跑到这里");
		try{
			service.UploadImageMaterial(attachMentFile, bgmb, actioncontext, request);
			return "{\"success\":\"上传成功\"}";	
		}catch(Exception e) {
			return "{\"failure\":\""+e.getMessage()+"\"}";
		}
	}
	
	
	/**
	 * liusong 15-11-17
	 * 模板类型、模板类别下拉框
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return service.getDicByLx("mblb");
	}
	
	@RequestMapping(value = "/getDicByLx1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return service.getDicByLx("mblx");
	}
	
	/**
	 * liusong 15-11-17
	 * 在线编辑
	 * @return
	 */
	
	@RequestMapping(value="/testWordOnLine")
	public ModelAndView openPage1(String sub){
//		System.out.println("获取到的sub是: " + sub);
		ModelAndView modelAndView = new ModelAndView("/jygl/jsp/Word");
//		String code = request.getParameter("code");
		if (sub != null) {
			modelAndView.addObject("sub", sub);
//			System.out.println("获取到的sub是: " + sub);
		}
		return modelAndView;
	}
}
