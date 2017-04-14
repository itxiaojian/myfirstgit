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
import com.zssi.framework.app.cwgl.model.YcwYgfl;
import com.zssi.framework.app.cwgl.service.YcwYgflService;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.service.YypYpxxService;


@Controller
@RequestMapping("/cwgl/YCwYgfl")
public class YcwYgflController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YcwYgflController.class);
	@Autowired
	private YcwYgflService ycwYgflService;
	
	@Autowired
	private YypYpxxService yypYpxxService;
	
	/**
	 * 后台：员工福利
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYgflList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYgflList(Integer start,Integer limit,String code){
		return ycwYgflService.getYgflList(start, limit, code);
	}
	
	@RequestMapping(value = "/YgflPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/cwgl/ycwYgflList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加员工福利
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcwYgfl entity,
			HttpServletRequest request,HttpServletResponse response){
		ycwYgflService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:修改员工福利
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YcwYgfl entity, String id,
			HttpServletRequest request, HttpServletResponse response) {
		String ksbh = request.getParameter("ksbh");
		entity.setKs_id(ksbh);
		ycwYgflService.update(entity, id, request, response);
//		String ygxm1 = request.getParameter("xm");
//		String ygxm2 = entity.getYgxm();
//		ycwYgflService.updateFlmxYgbh(ygxm1, ygxm2);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除员工福利
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids,String[] ygxms){
		ycwYgflService.delete(ids,ygxms);
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
        String message = ycwYgflService.importMember(fileData);
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
		ycwYgflService.exportExcel(request,response,code);
	}
	
	/**
	 * 点击增加跳转到新增窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年11月11日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ygflAddView")
	public ModelAndView ygflAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/ygflAdd");
		List<Map<String, Object>> fllx = yypYpxxService.getDicByJylx("fllx");
		mav.addObject("fllx",fllx);
		return mav;
	}
	
	/**
	 * 点击增加跳转到修改窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年11月19日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ygflUpdateView")
	public ModelAndView cbxxUpdateView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/ygflUpdate");
		String id = request.getParameter("id");
//		String flbh = request.getParameter("flbh");
		List<Map<String, Object>> ygfl = ycwYgflService.getYgfl(Integer.parseInt(id));
		if (ygfl != null) {
			mav.addObject("ygfl", ygfl);
		}
		List<Map<String, Object>> fllx = yypYpxxService.getDicByJylx("fllx");
		mav.addObject("fllx",fllx);
		return mav;
	}
	
	/**
	 * 福利类型从数据字典取值
	 * @author wangyong
	 * @date 2016年1月14日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByFllx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByFLlx(String zdzl) {
		return yypYpxxService.getDicByJylx("fllx");
	}
}

