package com.zssi.framework.app.jybzgl.controller;

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

import com.likegene.framework.core.BaseController;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jybzgl.model.YjyBzxx;
import com.zssi.framework.app.jybzgl.model.YjyXmxx;
import com.zssi.framework.app.jybzgl.service.YjyBzxxService;
import com.zssi.framework.app.jybzgl.service.YjyXmxxService;
import com.zssi.framework.app.util.ResponseData;
/**
 * 主页-检验标准管理
 * @author mabiao
 *
 */
@Controller
@RequestMapping(value = "/jybzgl")
public class YjyBzglController extends BaseController{

	@Autowired
	private YjyBzxxService yjyBzxxService;
	
	@Autowired
	private YjyXmxxService yjyXmxxService;
	
	@RequestMapping(value = "/jybzglPage")
	public String openWxZdycdPage() {		
		return "/jybzgl/yjyBzglList";
	}
	
	/**
	 * 功能--查询检验信息
	 * @author mabiao
	 * @version 2015年9月29日下午1:45:23
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYjyBzxxList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getYJyBzxxList(Integer start,Integer limit,String code){
		
		return yjyBzxxService.getYJyBzxxList(start, limit,code);
		
	}
	
	/**
	 * 功能--查询项目信息
	 * @author mabiao
	 * @version 2015年9月29日下午1:45:23
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYjyXmxxList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getYJyXmxxList(Integer start,Integer limit,String code,String sjid){
		
		return yjyXmxxService.getYJyXmxxList(start, limit,code,sjid);
		
	}
	
	/**
	 * 功能--添加
	 * @author mabiao
	 * @version 2015年9月29日下午1:49:32
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/jybzgl/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData save(ModelMap model,YjyBzxx entity,
			HttpServletRequest request,HttpServletResponse response){
		yjyBzxxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--添加
	 * @author mabiao
	 * @version 2015年9月29日下午1:50:23
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/jyxmgl/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData save(ModelMap model,YjyXmxx entity,
			HttpServletRequest request,HttpServletResponse response){
		yjyXmxxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改
	 * @author mabiao
	 * @version 2015年9月29日下午1:51:24
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/jybzgl/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjyBzxx entity, String scid) {
		yjyBzxxService.update(entity, scid);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--修改
	 * @author mabiao
	 * @version 2015年9月29日下午1:55:56
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/jyxmgl/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjyXmxx entity, String xmid) {
		yjyXmxxService.update(entity, xmid);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--刪除
	 * @author mabiao
	 * @version 2015年9月29日下午1:56:44
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/jybzgl/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yjyBzxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--刪除
	 * @author mabiao
	 * @version 2015年9月29日下午1:57:33
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/jyxmgl/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData deletes(Integer[] ids){
		yjyXmxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--审核
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/jybzgl/check", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData check(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			YjyBzxx entity=yjyBzxxService.get(ids[i]);
			entity.setShzt(1);
			yjyBzxxService.update(entity);
		}
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 功能--废止
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/jybzgl/abolish", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData abolish(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			YjyBzxx entity=yjyBzxxService.get(ids[i]);
			entity.setShzt(2);
			yjyBzxxService.update(entity);
		}
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 数据字典--标准级别
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByjb", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByjb(String zdzl) {
		return yjyBzxxService.getDicByjb("bzjb");
	}
	
	/**
	 * 数据字典--标准类型
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yjyBzxxService.getDicByLx("bzlb");
	}
	
	/**
	 * 功能--项目类型
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByxlx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByxlx(String zdzl) {
		return yjyXmxxService.getDicByxlx("xmlx");
	}
	
	/**
	 * 功能--评定用语
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicBypd", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicBypd(String zdzl) {
		return yjyXmxxService.getDicBypd("pdyy");
	}
	
	/**
	 * 检验标准导入EXCEL数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/jybzupload")
    @ResponseBody
    public String jybzupload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yjyBzxxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 检验标准导出Excel
	 * @author duanpeijun
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	@RequestMapping(value = "/jybzexport")
	public void jybzexportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yjyBzxxService.exportExcel(request,response,code);
	}
	
	/**
	 * 检验项目导入EXCEL数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/jyxmupload")
    @ResponseBody
    public String jyxmupload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yjyXmxxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 检验项目导出Excel
	 * @author duanpeijun
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	@RequestMapping(value = "/jyxmexport")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code,String sjid) throws Exception{
		yjyXmxxService.exportExcel(request,response,code,sjid);
	}
	
}
