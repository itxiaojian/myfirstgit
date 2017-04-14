package com.zssi.framework.app.rsgl.controller;

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
import com.zssi.framework.app.rsgl.model.YrsPxjlInfo;
import com.zssi.framework.app.rsgl.model.YrsRydaxx;
import com.zssi.framework.app.rsgl.service.YrsRydaxxService;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.sfwgl.model.YsfwHfb;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.yhgl.model.SysYhxx;
import com.zssi.framework.app.yhgl.service.SysYhService;


@Controller
@RequestMapping("/rsgl/YRsRydaxx")
public class YrsRydaxxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YrsRydaxxController.class);
	@Autowired
	private YrsRydaxxService yrsRydaxxService;
	@Autowired
	private SysYhService sysYhService;
	
	/**
	 * 后台：人员档案信息
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getRydaxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getRydaxxList(Integer start,Integer limit,String chaxun ){
		return yrsRydaxxService.getRydaxxList(start, limit, chaxun);
	}
	
	@RequestMapping(value = "/RydaxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/rsgl/yrsRydaxxList");
		return modelAndView;
	}
	
	/**
	 * 编辑并上传附件
	 * @author liangkaidi
	 * @date 2015-11-30
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/save1", method = RequestMethod.POST)
	@ResponseBody
	public String  save1(ModelMap model, YrsRydaxx entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		try{
			yrsRydaxxService.UploadImageMaterial( entity, actioncontext, request);			
			return "1";	
		}catch(Exception e) {
			return "0";
		}
	}
	/**
	 * 修改
	 * @author liangkaidi
	 * @date 2015-11-30
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(SysYhxx entity, String yhbh) {
		sysYhService.update(entity, yhbh);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YrsRydaxx entity,
			HttpServletRequest request,HttpServletResponse response){
		yrsRydaxxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除人员档案信息
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrsRydaxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yrsRydaxxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yrsRydaxxService.exportExcel(request,response,code);
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击增加跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param response
	 * @return
	 */   
	

@RequestMapping(value = "/daxxAddView")
	
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/Rydaxx");
		List<Map<String, Object>> xb = yrsRydaxxService.getDicByList("xb");
		mav.addObject("xb", xb);
		return mav;
	}

/**
 * 点击修改跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-11
 * @param request
 * @param response
 * @return
 */


@RequestMapping(value = "/rydaxxXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/rsgl/jsp/RydaxxXg");
	String yhbh = request.getParameter("yhbh");
	List<Map<String, Object>> rydaxx = sysYhService.getCk(yhbh);
	if (rydaxx != null) {
		
		mav.addObject("rydaxx", rydaxx);
	}
	
	return mav;
}
/**
 *查看跳转jsp
 * @author liangkaidi
 * @date 2016-1-8
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = "/rydaxxCkView")
public ModelAndView rydaxxCkView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/rsgl/jsp/RydaxxCk");
	String yhbh = request.getParameter("yhbh");
	List<Map<String, Object>> rydaxx = sysYhService.getCk(yhbh);
	if (rydaxx != null) {
		mav.addObject("rydaxx", rydaxx);
	}
	
	return mav;
}
}
