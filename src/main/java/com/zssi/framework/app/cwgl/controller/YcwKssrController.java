package com.zssi.framework.app.cwgl.controller;

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
import com.zssi.framework.app.cwgl.model.YcwKssr;
import com.zssi.framework.app.cwgl.service.YcwKssrService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/cwgl/YCwKssr")
public class YcwKssrController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YcwKssrController.class);
	@Autowired
	private YcwKssrService ycwKssrService;
	
	/**
	 * 后台：科室收入
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getKssrList")
	@ResponseBody
	public Pagination<Map<String, Object>> getKssrList(Integer start,Integer limit,String code){
		return ycwKssrService.getKssrList(start, limit, code);
	}
	
	@RequestMapping(value = "/KssrPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/cwgl/ycwKssrList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加科室收入信息
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcwKssr entity,
			HttpServletRequest request,HttpServletResponse response){
		ycwKssrService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:修改科室收入信息
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YcwKssr entity, String id) {
		ycwKssrService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除科室收入信息
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ycwKssrService.delete(ids);
	    return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月28日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = ycwKssrService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月28日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ycwKssrService.exportExcel(request,response,code);
	}
	
	/**
	 * 点击增加跳转到新增窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年11月12日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/kssrAddView")
	public ModelAndView ygflAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/kssrAdd");
		return mav;
	}
	
	/**
	 * 点击增加跳转到新增窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年11月19日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/kssrUpdateView")
	public ModelAndView cbxxUpdateView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/kssrUpdate");
		String id = request.getParameter("id");
		List<Map<String, Object>> kssr = ycwKssrService.getKssr(Integer.parseInt(id));
		if (kssr != null) {
			mav.addObject("kssr", kssr);
		}
		return mav;
	}
	
}

