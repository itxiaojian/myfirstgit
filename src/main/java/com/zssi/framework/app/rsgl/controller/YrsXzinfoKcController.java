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
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.model.YrsXzinfoKc;
import com.zssi.framework.app.rsgl.service.YrsXzinfoKcService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/rsgl/YRsXzinfoKc")
public class YrsXzinfoKcController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YrsXzinfoKcController.class);
	@Autowired
	private YrsXzinfoKcService yrsXzinfoKcService;
	
	/**
	 * 后台：薪资扣除信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getXzinfoKcList")
	@ResponseBody
	public Pagination<Map<String, Object>> getXzinfoKcList(Integer start,Integer limit,String rybh){
		return yrsXzinfoKcService.getXzinfoKcList(start, limit, rybh);
	}
	
	@RequestMapping(value = "/XzinfoKcPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/rsgl/yrsXzinfoKcList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加薪资扣除信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YrsXzinfoKc entity,
			HttpServletRequest request,HttpServletResponse response){
		yrsXzinfoKcService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 存储多条薪资扣除的信息
	 * 
	 * @author wangyong
	 * @date 2015年11月27日
	 * @param request
	 */
	@RequestMapping(value = "/insert")
	@ResponseBody
	public void insert(HttpServletRequest request) {
		yrsXzinfoKcService.insert(request);
	}
	
	/**
	 * 后台:修改薪资扣除信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YrsXzinfoKc entity, String id) {
		yrsXzinfoKcService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除薪资扣除信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrsXzinfoKcService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月26日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yrsXzinfoKcService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月26日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yrsXzinfoKcService.exportExcel(request,response,code);
	}
	
	/**
	 * 点击增加跳转jsp页面
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/xzkcAddView")
	public ModelAndView ygflAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/Xzkc");
		return mav;
	}
	/**
	 * 点击修改跳转到修改窗口的JSP页面
	 * 
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/xzkcXgView")
	public ModelAndView cbxxUpdateView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/XzkcXg");
		String id = request.getParameter("id");
		List<Map<String, Object>> xzkc = yrsXzinfoKcService.getxzkc(Integer.parseInt(id));
		if (xzkc != null) {
			mav.addObject("xzkc", xzkc);
		}
		return mav;
	}
}
