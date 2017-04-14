package com.zssi.framework.app.dagl.contorller; 

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
import com.zssi.framework.app.dagl.model.YdaXx;
import com.zssi.framework.app.dagl.service.YdaXxService;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/** 
 * 档案信息contorller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:27:15 
 */
@Controller
@RequestMapping("/dagl/YdaXx")
public class YdaXxContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YdaXxContorller.class);
	
	@Autowired
	private YdaXxService yDaXxService;
	
	@Autowired
	private YypYpxxService ypxxService;
	
	/**
	 * 后台：档案信息
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getDaXxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getDaXxList(Integer start,Integer limit,String code){
		return yDaXxService.getDaXxList(start, limit,code);
	}
	
	@RequestMapping(value = "/DaXxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/dagl/yDaXxList");
		return modelAndView;
		}
	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YdaXx entity,String ssjg,
			HttpServletRequest request,HttpServletResponse response,String bgbh){
		SysYh gdr =AppUtil.getCurrentUser();
		entity.setGdr(gdr.getXm());
		entity.setSslmid(bgbh);
		yDaXxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 流程中报告归档
	 * @author liusong
	 * @date 2015年12月21日
	 * @return
	 */
	@RequestMapping(value = "/lcdaxx")
	public ModelAndView daxx(HttpServletRequest request,
			HttpServletResponse response,String ypid,String pdfName) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/daxxAdd");
		List<Map<String, Object>> ypxx = ypxxService.getYpxx(Integer.parseInt(ypid));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
		}
		List<Map<String, Object>> dalx = yDaXxService.getDicByJylx("dalx");
		mav.addObject("dalx",dalx);
		return mav;
	}
	
	/**
	 * 更新
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YdaXx entity, String id) {
		yDaXxService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 流程中报告归档
	 * @author liusong
	 * @date 2015年12月21日
	 * @return
	 */
	@RequestMapping(value = "/daxxAddView")
	public ModelAndView daxxAddView(HttpServletRequest request,
			HttpServletResponse response,String ypid,String pdfName) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/DaxxAdd");
		List<Map<String, Object>> dalx = yDaXxService.getDicByJylx("dalx");
		mav.addObject("dalx",dalx);
		return mav;
	}
	
	/**
	 * 查看档案信息
	 * @author liusong
	 * @date 2015年12月21日
	 * @return
	 */
	@RequestMapping(value = "/daxxOnlookView")
	public ModelAndView daxxOnlookView(HttpServletRequest request,
			HttpServletResponse response,String ypid,String pdfName) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/DaxxOnlook");
		String id = request.getParameter("id");
		List<Map<String, Object>> daxx = yDaXxService.getDa(id);
		if (daxx != null) {
			mav.addObject("daxx", daxx);
		}
		return mav;
	}
	
	/**
	 * 档案延期跳转页面
	 * @author liusong
	 * @date 2015年12月21日
	 * @return
	 */
	@RequestMapping(value = "/daxxOnYqiView")
	public ModelAndView daxxOnYqiView(HttpServletRequest request,
			HttpServletResponse response,String ypid,String pdfName) {
		ModelAndView mav = new ModelAndView("/dagl/jsp/DaxxOnyqi");
		String id = request.getParameter("id");
		List<Map<String, Object>> daxx = yDaXxService.getDa(id);
		if (daxx != null) {
			mav.addObject("daxx", daxx);
		}
		List<Map<String, Object>> bgqx = yDaXxService.getDicByJylx("bgqx");
		mav.addObject("bgqx",bgqx);
		return mav;
	}
	
	/**
	 * 档案延期保存
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/Yqi", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData Yqi(HttpServletRequest request,
			HttpServletResponse response,String bgqx,String id){
//		System.out.println("获取到的id是: " + ids);
		YdaXx entity = yDaXxService.get(Integer.parseInt(id));
		entity.setBgqx(bgqx);
		yDaXxService.update(entity, id);
			return ResponseData.SUCCESS_NO_DATA;

		}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年10月12日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yDaXxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 档案清档（实际就是把是否清档状态改成1）
	 * @author liusong
	 * @date 2015年11月29日
	 * @return
	 */
	@RequestMapping(value="/onQdang", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData onQdang(String id){
//		System.out.println("获取到的id是: " + ids);
		YdaXx entity = yDaXxService.get(Integer.parseInt(id));
		entity.setSfqd(1);
		yDaXxService.update(entity, id);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 档案信息导出
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yDaXxService.exportExcel(request,response,code);
	}
	
	/**
	 * 档案信息导入
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yDaXxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 在线查看原始记录文档
	 * @return
	 */
	@RequestMapping(value="/WordOnLine")
	public ModelAndView openPage1(String ysjlsjm,String bz){
		String url = null ;
		if(bz.equals("1")){
			url ="/jygl/jsp/PicOnLine";
		}
		if(bz.equals("2")){
			url ="/jygl/jsp/WordOnLine";
		}
		if(bz.equals("3")){
			url ="/jygl/jsp/PdfOnLine";
		}
		ModelAndView modelAndView = new ModelAndView(url);
		if (ysjlsjm != null) {
			modelAndView.addObject("ysjlsjm", ysjlsjm);
		}
		return modelAndView;
	}
	
	/**
	 * 查看档案报告
	 * @author liusong
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/bgOnLine")
	public ModelAndView bgck(HttpServletRequest request,
			HttpServletResponse response,String bgbh){
		ModelAndView mav = new ModelAndView("/jygl/jsp/WordOnLinebyBgbh");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	
}
