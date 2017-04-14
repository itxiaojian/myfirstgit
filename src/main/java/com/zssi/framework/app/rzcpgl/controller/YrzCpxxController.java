package com.zssi.framework.app.rzcpgl.controller;

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
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.rzcpgl.model.YrzCpxx;
import com.zssi.framework.app.rzcpgl.service.YrzCpxxService;
import com.zssi.framework.app.sgzgl.model.YsgzXx;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/rzcpgl/YRzCpxx")
public class YrzCpxxController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YrzCpxxController.class);
	@Autowired
	private YrzCpxxService yrzCpxxService;
	
	/**
	 * 后台：产品信息
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getCpxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getCpxxList(Integer start,Integer limit,String code){
		return yrzCpxxService.getCpxxList(start, limit, code);
	}
	
	@RequestMapping(value = "/CpxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/rzcpgl/yrzCpxxList");
		return modelAndView;
	}
	
	/**
	 * 数据字典--认证类型
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yrzCpxxService.getDicByLx("rzlx");
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
	public String save(HttpServletRequest request, YrzCpxx entity) {
		String str = "1";
		str=yrzCpxxService.saveRb(request, entity);
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
	public String update(HttpServletRequest request,HttpServletResponse response, String id) {
		String str = "1";
		yrzCpxxService.update(request, id);
		return str;
	}
	
	/**
	 * 后台:删除产品信息
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrzCpxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 产品信息--导入Excel数据
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String jybzupload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yrzCpxxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 产品信息--导出Excel数据
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param request
	 * @param response
	 * @param code
	 * @throws Exception
	 */
	@RequestMapping(value = "/export")
	public void jybzexportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yrzCpxxService.exportExcel(request,response,code);
	}
	/**
	 * 点击增加跳转jsp页面
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param request
	 * @param response
	 * @return
	 */
@RequestMapping(value = "/rzcpAddView")
	
	public ModelAndView sgzAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rzcpgl/jsp/Rzcpxx");
		List<Map<String, Object>> rzlx = yrzCpxxService.getRzlx("rzlx");
		mav.addObject("rzlx", rzlx);
		return mav;
	}

/**
 * 点击修改跳转的Jsp页面
 * @author liangkaidi
 * @date 2015-11-24
 * @param request
 * @param response
 * @return
 */


@RequestMapping(value = "/rzcpxxXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/rzcpgl/jsp/RzcpxxXg");
	List<Map<String, Object>> rzlx = yrzCpxxService.getRzlx("rzlx");
	mav.addObject("rzlx", rzlx);
	String id = request.getParameter("id");
	List<Map<String, Object>> rzCpxx = yrzCpxxService.getXg(id);
	if (rzCpxx != null) {
		mav.addObject("rzCpxx", rzCpxx);
	}
	return mav;
}

}
