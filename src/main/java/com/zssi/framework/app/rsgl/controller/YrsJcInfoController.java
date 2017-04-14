package com.zssi.framework.app.rsgl.controller;

import java.text.SimpleDateFormat;
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
import com.zssi.framework.app.cwgl.model.YcwYgfl;
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.rsgl.model.YrsJcInfo;
import com.zssi.framework.app.rsgl.model.YrsPxjlInfo;
import com.zssi.framework.app.rsgl.model.YrsRydaxx;
import com.zssi.framework.app.rsgl.service.YrsJcInfoService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/rsgl/YRsJcInfo")
public class YrsJcInfoController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YrsJcInfoController.class);
	@Autowired
	private YrsJcInfoService yrsJcInfoService;
	
	/**
	 * 后台：奖惩管理信息
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getJcInfoList")
	@ResponseBody
	public Pagination<Map<String, Object>> getJcInfoList(Integer start,Integer limit,String code){
		return yrsJcInfoService.getJcInfoList(start, limit, code);
	}
	
	@RequestMapping(value = "/JcInfoPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/rsgl/yrsJcInfoList");
		return modelAndView;
	}
	
	/**
	 * 增加提交save
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, YrsJcInfo entity) {
		String str = "";
		str=yrsJcInfoService.saveRb(request, entity);
		return str;
	}	
	
	/**
	 * jsp页面的修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YrsJcInfo entity, String id) {
		yrsJcInfoService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除奖惩管理信息
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrsJcInfoService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月23日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yrsJcInfoService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月23日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yrsJcInfoService.exportExcel(request,response,code);
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
	

@RequestMapping(value = "/jcAddView")
	
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/Jcgl");
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


@RequestMapping(value = "/jcXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/rsgl/jsp/JcglXg");
	String id = request.getParameter("id");
	System.out.println(id+"-------------------------------");
	YrsJcInfo jcInfo = yrsJcInfoService.getXg(id);
	if (jcInfo != null) {
		mav.addObject("jcInfo", jcInfo);
	}
	return mav;
}
}
