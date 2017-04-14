package com.zssi.framework.app.ypgl.controller;

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
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypJyfa;
import com.zssi.framework.app.ypgl.service.YypJyfaService;


@Controller
@RequestMapping("/ypgl/YYpJyfa")
public class YypJyfaController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypJyfaController.class);
	@Autowired
	private YypJyfaService service;
	
	/**
	 * 后台：预检方案
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getYjfaList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYjfaList(Integer start,Integer limit,String code){
		return service.getJyfaList(start, limit, code);
	}
	
	@RequestMapping(value = "/YjfaPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypJyfaList");
		return modelAndView;
	}
	
	/**
	 * 后台：预检方案增加
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
	public ResponseData save(ModelMap model,YypJyfa entity,
			HttpServletRequest request,HttpServletResponse response){
		service.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
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
	public ResponseData update(YypJyfa entity, String id) {
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
	 * 导入EXCEL数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = service.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author liujiansen
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		service.exportExcel(request,response,code);
	}
}
