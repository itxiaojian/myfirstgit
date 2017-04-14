package com.zssi.framework.app.sgzgl.controller;

import java.util.Iterator;
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
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.sgzgl.model.YsgzXx;
import com.zssi.framework.app.sgzgl.service.YsgzXxService;
import com.zssi.framework.app.util.ResponseData;


@Controller 
@RequestMapping("/sgzgl/YsgzXx")
public class YsgzXxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog( YsgzXx.class);
	@Autowired
	private YsgzXxService ysgzXxService;  
	
/**
 * 查询
 * @author liangkaidi
 * @date 2015-10-22
 * @param start
 * @param limit
 * @param code
 * @return
 */
	
	@RequestMapping(value = "/getSgzxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTestList(Integer start,Integer limit,String code ){
		return ysgzXxService.getSgzxxList(start, limit, code);
		
	}
	@RequestMapping(value = "/SgzxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sgzgl/ySgzXxList");
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
	public String save(HttpServletRequest request, YsgzXx entity) {
		String str = "1";
		str=ysgzXxService.saveRb(request, entity);
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
	public String update(HttpServletRequest request,HttpServletRequest response, String id) {
		String str = "1";
		ysgzXxService.update(request, id);
		return str;
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-10-21
	 * @param ids
	 * @return
	 * 删除
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ysgzXxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	/**
	 * 导入EXCEL数据
	 * @author liangkaidi
	 * @date 2015-10-22
	 * @param fileData
	 * @return
	 * 
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = ysgzXxService.importMember(fileData);
	
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	/**
	 * 下载数据
	 * @author liangkaidi
	 * @date 2015-10-22
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@RequestMapping(value = "/sgzexport")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ysgzXxService.exportExcel(request,response,code);
	}
	
	/**
	 * 点击增加跳转的Jsp页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */

@RequestMapping(value = "/sgzAddView")
	
	public ModelAndView sgzAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sgzgl/jsp/Sgzgl");
		List<Map<String, Object>> cplx = ysgzXxService.getDicByList("cplx");
		mav.addObject("cplx", cplx);
		return mav;
	}
/************************************2015-11-4针对“修改”,由Ext转向Jsp页面****************************************************/
/**
 * 点击修改跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-11
 * @param request
 * @param response
 * @return
 */

@RequestMapping(value = "/sgzxxXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/sgzgl/jsp/SgzglXg");
	String id = request.getParameter("id");
	List<Map<String, Object>> cplx = ysgzXxService.getDicByList("cplx");
	mav.addObject("cplx", cplx);
	List<Map<String, Object>> sgzxx = ysgzXxService.getXg(id);
	if (sgzxx != null) {
		mav.addObject("sgzxx", sgzxx);
	}
	return mav;
}

/************************************2015-11-4针对“查看”,由Ext转向Jsp页面****************************************************/
/**
 * 点击修改跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-11
 * @param request
 * @param response
 * @return
 */

@RequestMapping(value = "/sgzxxCkView")
public ModelAndView sgzxxCkView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/sgzgl/jsp/SgzglCk");
	String id = request.getParameter("id");
	List<Map<String, Object>> sgzxx = ysgzXxService.getCk(id);
	if (sgzxx != null) {
		mav.addObject("sgzxx", sgzxx);
	}
	return mav;
}
}


