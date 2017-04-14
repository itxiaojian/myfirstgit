package com.zssi.framework.app.sbgl.contorller;

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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbBxjl;
import com.zssi.framework.app.sbgl.service.YsbBxjlService;
import com.zssi.framework.app.util.ResponseData;



@Controller
@RequestMapping("/sbgl/YsbBxjl")
public class YsbBxjlContorller extends BaseController {
	protected final transient Logger logger = com.likegene.framework.core.logger.LoggerFactory.getPersistenceLog(YsbBxjlContorller.class);
	
	@Autowired
	private YsbBxjlService ySbbxjlService;
	
	
	/**
	 * 后台：设备报修记录
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getSbbxjlList")
	@ResponseBody
	public Pagination<Map<String, Object>> getSbbxjlList(Integer start,Integer limit,String code){
		return ySbbxjlService.getSbbxjlList(start, limit,code);
	}
	
	@RequestMapping(value = "/SbbxjlPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sbgl/ySbbxjlList");
		return modelAndView;
	}
	
	/** 
	 * 维保状态下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ySbbxjlService.getDicByLx("wbzt");
	}
	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YsbBxjl entity,
			HttpServletRequest request,HttpServletResponse response){
		ySbbxjlService.save(entity);
				return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YsbBxjl entity,String id){
		ySbbxjlService.update(entity,id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ySbbxjlService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/** 
	 * 设备保修记录导出
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ySbbxjlService.exportExcel(request,response,code);
	}
	
	/** 
	 * 设备保修记录导入
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = ySbbxjlService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * jsp设备维保记录新增
	 * @author liusong
	 * @date 2015年11月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sbbxjlAddView")
	public ModelAndView sbbxjlAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbbxjlAdd");
		List<Map<String, Object>> wbzt = ySbbxjlService.getDicByLx("wbzt");
		mav.addObject("wbzt",wbzt);
		return mav;
	}
	
	/**
	 * jsp中设备维保记录修改
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbbxjlUpdateView")
	public ModelAndView sbbxjlUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbbxjlUpdate");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbbxjl = ySbbxjlService.getBx(id);
		if (sbbxjl != null) {
			mav.addObject("sbbxjl", sbbxjl);
		}
		List<Map<String, Object>> wbzt = ySbbxjlService.getDicByLx("wbzt");
		mav.addObject("wbzt",wbzt);
		return mav;
	}
}
