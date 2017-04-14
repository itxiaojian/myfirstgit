package com.zssi.framework.app.jyzxxx.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.zssi.framework.app.jyzxxx.model.YjyZxxx;
import com.zssi.framework.app.jyzxxx.service.YjyZxxxService;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.service.YypYpxxService;


@Controller
@RequestMapping("/jyzxxx/YJyZxxx")
public class YjyZxxxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyZxxxController.class);
	@Autowired
	private YjyZxxxService service;
	
	@Autowired
	private YypYpxxService yypYpxxService;
	
	/**
	 * 后台：成本明细
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getZxxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getCbmxList(Integer start,Integer limit,String code,String ksbh,String cpbh,String cpmc,
			String cplx,String jyyj){
		return service.getZxxxList(start, limit, code, ksbh, cpbh, cpmc, cplx, jyyj);
	}
	
	@RequestMapping(value = "/ZxxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/jyzxxx/yjyZxxxList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加成本明细
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
	public String save(ModelMap model,YjyZxxx entity,
			HttpServletRequest request,HttpServletResponse response){
		service.save(entity,request,response);
		return "1";
	}
	
	
	/**
	 * 后台:修改咨询信息
	 * @author wangyong
	 * @date 2016年6月4日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response) {
		service.update(request, response);
		return "1";
	}
	
	/**
	 * 后台:删除成本信息
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(String[] cpbhs,String[] jyyjs){
		service.delete(cpbhs,jyyjs);
	    return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 点击增加跳转到新增窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年6月2日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/zxxxAddView")
	public ModelAndView zxxxAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/jyzxxx/zxxxAdd");
		List<Map<String, Object>> cplx = yypYpxxService.getDicByJylx("cplx");
		mav.addObject("cplx",cplx);
		return mav;
	}
	
	/**
	 * 点击修改跳转到新增窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年6月2日
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/zxxxUpdateView")
	public ModelAndView zxxxUpdateView(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/jyzxxx/zxxxUpdate");
		String cpbh = request.getParameter("cpbh");
		String jyyj2 = request.getParameter("jyyj");
		String jyyj = new String(jyyj2.getBytes("ISO-8859-1"), "UTF-8");
		List<Map<String, Object>> zxxx = service.getZxxx(cpbh,jyyj);
		Integer zxxxLen=zxxx.size();
		String fhCpbh=(String) zxxx.get(0).get("cpbh");
		String fhCpmc=(String) zxxx.get(0).get("cpmc");
		String fhCplx=(String) zxxx.get(0).get("cplx");
		String fhJyyj=(String) zxxx.get(0).get("jyyj");
		String fhSfpz=(String) zxxx.get(0).get("bz1");
		List<Map<String, Object>> cplx = yypYpxxService.getDicByJylx("cplx");
		
		mav.addObject("zxxx",zxxx);
		mav.addObject("zxxxLen",zxxxLen);
		mav.addObject("cplx",cplx);
		mav.addObject("fhCpbh",fhCpbh);
		mav.addObject("fhCpmc",fhCpmc);
		mav.addObject("fhCplx",fhCplx);
		mav.addObject("fhJyyj",fhJyyj);
		mav.addObject("fhSfpz",fhSfpz);
		return mav;
	}
	
	/**
	 * 点击查看跳转到查看页面
	 * 
	 * @author wangyong
	 * @date 2015年6月4日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/zxxxOnLookView")
	public ModelAndView zxxxOnLookView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jyzxxx/zxxxOnLook");
		String cpbh = request.getParameter("cpbh");
		String jyyj = request.getParameter("jyyj");
		jyyj = new String(jyyj.getBytes("ISO-8859-1"),"UTF-8");
		List<Map<String, Object>> zxxx = service.getZxxx(cpbh,jyyj);
		
		Integer zxxxLen=zxxx.size();
		String fhCpbh=(String) zxxx.get(0).get("cpbh");
		String fhCpmc=(String) zxxx.get(0).get("cpmc");
		String fhCplx=(String) zxxx.get(0).get("cplx");
		String fhJyyj=(String) zxxx.get(0).get("jyyj");
		List<Map<String, Object>> cplx = yypYpxxService.getDicByJylx("cplx");
		
		mav.addObject("zxxx",zxxx);
		mav.addObject("zxxxLen",zxxxLen);
		mav.addObject("cplx",cplx);
		mav.addObject("fhCpbh",fhCpbh);
		mav.addObject("fhCpmc",fhCpmc);
		mav.addObject("fhCplx",fhCplx);
		mav.addObject("fhJyyj",fhJyyj);
		return mav;
	}
	
	/**
	 * 获取已有的产品	
	 * @author wangyong
	 * @date 2015年6月12日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/yccpList")
	@ResponseBody
		public List<Map<String, Object>> ypfzList(HttpServletRequest request,
				HttpServletResponse response) {
			String cpbhcx = request.getParameter("cpbhcx");
			String cpmccx = request.getParameter("cpmccx");
			String ypjzcs = request.getParameter("ypjzcs");
			List<Map<String, Object>> list = service.yccpList(cpbhcx, cpmccx, ypjzcs);
			return list;
    }
	
	/**
	 * exl导出
	 * @author wangyong
	 * @date 2015年6月6日
	 */
	
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		service.exportExcel(request,response);
	}
	
	/**
	 * exl导入
	 * @author wangyong
	 * @date 2015年6月6日
	 * @throws UnsupportedEncodingException 
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
    {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        String message = service.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
        	message=URLDecoder.decode(message,"utf-8");
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
}

