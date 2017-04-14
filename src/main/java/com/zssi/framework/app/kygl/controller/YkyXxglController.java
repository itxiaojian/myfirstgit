package com.zssi.framework.app.kygl.controller; 

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
import com.zssi.framework.app.kygl.model.YkyXxgl;
import com.zssi.framework.app.kygl.service.YkyXxglService;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 科研信息管理controller层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午9:54:28 
 * 类说明 
 */
@Controller
@RequestMapping("/kygl/YkyXxgl")
public class YkyXxglController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YkyXxglController.class);
	
	@Autowired
	private YkyXxglService ykyXxglService;
	
	@RequestMapping(value = "/getKyXxglList")
	@ResponseBody
	public Pagination<Map<String,Object>> getKyXxglList(Integer start,Integer limit,String code){
		return ykyXxglService.getKyXxglList(start, limit,code);
	}
	
	@RequestMapping(value = "/KyXxglPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/kygl/yKyXxglList");
		return modelAndView;
	}
	
	/**
	 * 增加提交save
	 * @author liusong
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YkyXxgl entity,
			HttpServletRequest request,HttpServletResponse response){
		ykyXxglService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	/**
	 * jsp页面的修改
	 * @author liusong
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YkyXxgl entity, String id,HttpServletRequest request,HttpServletResponse response) {
		
		String ksbh=request.getParameter("ksbh");
		entity.setKs_id(ksbh);
		ykyXxglService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ykyXxglService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 科研信息导出
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ykyXxglService.exportExcel(request,response,code);
	}
	
	/**
	 * 科研信息导入
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = ykyXxglService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击增加跳转的Jsp页面
	 * @author liusong
	 * @date 2015-11-23
	 * @param request
	 * @param response
	 * @return
	 */
	

@RequestMapping(value = "/KyxxAddView")
	
	public ModelAndView KyxxAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/kygl/jsp/Xxgl");
		
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


@RequestMapping(value = "/KyxxXgView")
public ModelAndView KyxxXgView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/kygl/jsp/XxglXg");
	String id = request.getParameter("id");
	List<Map<String, Object>> xxgl = ykyXxglService.getXg(id);
	
	if (xxgl != null) {
		mav.addObject("xxgl", xxgl);
	}
	return mav;
}

}
