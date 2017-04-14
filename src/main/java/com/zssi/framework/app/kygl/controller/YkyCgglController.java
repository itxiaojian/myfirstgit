package com.zssi.framework.app.kygl.controller; 

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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.kygl.model.YkyCggl;
import com.zssi.framework.app.kygl.service.YkyCgglService;
import com.zssi.framework.app.util.ResponseData;

import freemarker.core._RegexBuiltins.replace_reBI;

/** 
 * 科研信息管理controller层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午9:54:28 
 * 类说明 
 */
@Controller
@RequestMapping("/kygl/YkyCggl")
public class YkyCgglController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YkyCgglController.class);
	
	@Autowired
	private YkyCgglService ykyCgglService;
	
	@RequestMapping(value = "/getKyCgglList")
	@ResponseBody
	public Pagination<Map<String,Object>> getKyCgglList(Integer start,Integer limit,String code){
		return ykyCgglService.getKyCgglList(start, limit,code);
	}
	
	@RequestMapping(value = "/KyCgglPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/kygl/yKyCgglList");
		return modelAndView;
	}
	
	/**
	 * 上传图片素材
	 * @return
	 */
	@RequestMapping(value="/uploadImage")
	@ResponseBody
	public String UploadImageMaterial(@RequestParam("attachMentFile") MultipartFile attachMentFile,YkyCggl cggl,
			HttpServletResponse actioncontext,HttpServletRequest request){ 
//		    alert("程序跑到这里");
		try{
			ykyCgglService.UploadImageMaterial(attachMentFile, cggl, actioncontext, request);
			return "{\"success\":\"上传成功\"}";	
		}catch(Exception e) {
			return "{\"failure\":\""+e.getMessage()+"\"}";
		}
	}
	
	/**
	 * 增加提交save
	 * @author liusong
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YkyCggl entity,
			HttpServletRequest request,HttpServletResponse response){
		ykyCgglService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	

	/**
	 * jsp页面的修改
	 * @author liusong
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YkyCggl entity, String id,HttpServletRequest request, HttpServletResponse response) {
		
		String  ksbh=request.getParameter("ksbh");
		entity.setSsks(ksbh);
		ykyCgglService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ykyCgglService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 成果管理导出exl
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ykyCgglService.exportExcel(request,response,code);
	}
	
	
	/**
	 * 上传exl表格
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = ykyCgglService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 *  点击增加跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-27
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	

@RequestMapping(value = "/cgglAddView")
	
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response, String ids) {
		ModelAndView mav = new ModelAndView("/kygl/jsp/Cggl");
		List<Map<String, Object>> ks_id = ykyCgglService.getDicByList("ks_id");
		mav.addObject("ks_id", ks_id);
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
@RequestMapping(value = "/cgglXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/kygl/jsp/CgglXg");
	String id = request.getParameter("id");
	List<Map<String, Object>> ks_id = ykyCgglService.getDicByList("ks_id");
	mav.addObject("ks_id", ks_id);
	List<Map<String, Object>> cggl = ykyCgglService.getXg(id);
	if (cggl != null) {
		mav.addObject("cggl", cggl);
	}
	return mav;
}
}
