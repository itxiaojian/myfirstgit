package com.zssi.framework.app.sbgl.contorller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.service.YjyNwglService;
import com.zssi.framework.app.sbgl.model.YsbJdjl;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sbgl.service.YsbJdjlService;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.util.ResponseData;

@Controller
@RequestMapping("/sbgl/YSbXx")
public class YsbXxContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPresentationLog(YsbXxContorller.class);
	@Autowired
	private YsbXxService ySbXxService;
	
	@Autowired
	private YsbJdjlService ysbJdjlService;
	
	@Autowired
	private YjyNwglService nwglservice;
	
	public String scjdrq;
	
	/**
	 * 后台：设备信息contorller类
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getSbxxList")
	@ResponseBody
	public Pagination<Map<String,Object>> getSbxxList(Integer start,Integer limit,String code){
		return ySbXxService.getSbxxList(start, limit,code);
	}
	
	@RequestMapping(value = "/SbxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/sbgl/ySbxxList");
		return modelAndView;
		}
	
	/**
	 * 以下依次为设备级别、检验状态、单位的下拉框
	 * @author liusong
	 * @date 2015年9月24日
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ySbXxService.getDicByLx("sbjb");
	}
	
	@RequestMapping(value = "/getDicByLx1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return ySbXxService.getDicByLx("syzt");
	}
	
	@RequestMapping(value = "/getDicByLx2", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx2(String zdzl) {
		return ySbXxService.getDicByLx("dw_id");
	}
	
	@RequestMapping(value = "/getDw", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDw(String zdzl) {
		return ySbXxService.getDicByLx("dw_id");
	}
	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
//	@RequestMapping(value="/save")
//	@ResponseBody
//	public ResponseData save(ModelMap model,YsbXx entity,
//			HttpServletRequest request,HttpServletResponse response){
//		String sbbh = request.getParameter("sbbh");
//		String xMurl=request.getRequestURL().toString();
//		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
//		String url=str+"/toSbDetail?sbbh="+sbbh;
//		entity.setEwmbh(url);
//		ySbXxService.save(entity);
//		return ResponseData.SUCCESS_NO_DATA;
//	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String  save(ModelMap model, YsbXx entity, HttpServletResponse actioncontext, MultipartHttpServletRequest request){
		try{
			if (request instanceof MultipartHttpServletRequest){
				ySbXxService.UploadImageMaterial(entity, actioncontext, request);
				}			
				return "1";	
		}catch(Exception e) {
			return "0";
		}
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
	public ResponseData update(YsbXx entity, String id) {
		ySbXxService.up(entity, id);
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
		ySbXxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * exl导出
	 * @author liusong
	 * @date 2015年9月24日
	 */
	
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		ySbXxService.exportExcel(request,response,code);
	}
	
	/**
	 * exl导入
	 * @author liusong
	 * @throws UnsupportedEncodingException 
	 * @date 2015年9月24日
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
    {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        String message = ySbXxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
        	message=URLDecoder.decode(message,"utf-8");
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }

	/**
	 * 点击增加按钮跳转到新增窗口的jsp页面
	 * @author liusong
	 * @date 2015年11月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sbxxAddView")
	public ModelAndView sbxxAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxAdd");
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		/********新增时生成二维码图片***********/
		String sbbh=request.getParameter("sbbh");
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url=str+"/toSbDetail?sbbh="+sbbh;
		mav.addObject("url", url);
		return mav;
	}
	
	/**
	 * 点击修改按钮跳转到修改窗口的jsp页面
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbxxUpdateView")
	public ModelAndView sbxxUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxUpdate");
		String id = request.getParameter("id");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> sbxx = ySbXxService.getXg(id);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		return mav;
	}
	
	/**
	 * 查看设备信息
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbxxOnlookView")
	public ModelAndView sbxxOnlookView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxOnlook");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbxx = ySbXxService.getXg(id);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		return mav;
	}
	/**
	 * 停用设备信息
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbxxOnstopView")
	public ModelAndView sbxxOnstopView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxOnstop");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbxx = ySbXxService.getXg(id);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		return mav;
	}
	
	/**
	 * 设备停用
	 * @author liusong
	 * @date 2015年11月29日
	 * @return
	 */
	@RequestMapping(value="/onStop", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData onStop(String ids){
		System.out.println("获取到的id是: " + ids);
		YsbXx entity = ySbXxService.get(Integer.parseInt(ids));
		entity.setSyzt(4);
		entity.setYqzk(4);
		ySbXxService.up(entity, ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 设备停用后的启用（实际就是把使用状态改成启用）
	 * @author liusong
	 * @date 2015年11月29日
	 * @return
	 */
	@RequestMapping(value="/onQyong", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData onQyong(String ids){
//		System.out.println("获取到的id是: " + ids);
		YsbXx entity = ySbXxService.get(Integer.parseInt(ids));
		entity.setSyzt(0);
		entity.setYqzk(0);
		ySbXxService.up(entity, ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 报废设备跳转页面
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbxxOnbfeiView")
	public ModelAndView sbxxOnbfeiView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxOnbfei");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbxx = ySbXxService.getXg(id);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		return mav;
	}
	
	/**
	 * 设备报废保存报废信息
	 * @author liusong
	 * @date 2015年11月29日
	 * @return
	 */
	@RequestMapping(value="/onBfei", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData onBfei(String ids){
		System.out.println("获取到的id是: " + ids);
		YsbXx entity = ySbXxService.get(Integer.parseInt(ids));
		entity.setSyzt(1);
		entity.setYqzk(1);
		ySbXxService.up(entity, ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 设备检定跳转页面（其实就是新增下次检定日期并将之前的下次检定日期赋值给上次检定日期）
	 * @author liusong
	 * @date 2015年11月29日
	 * @return
	 */
	@RequestMapping(value = "/sbxxOnjdingView")
	public ModelAndView sbxxOnjdingView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxOnjding");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
//		通过id查询出上次的上次检定时间list 然后传给这次的上次检定时间。。。
		List<Map<String,Object>> scjdrq1 = ySbXxService.getXcrq(id);
		for (int i=0;i<scjdrq1.size();i++){
	        Map<String, Object> map=(Map<String, Object>)scjdrq1.get(i);
	        Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext())
            {
                String key = (String)iterator.next();
                Object bgbhObj = map.get(key);
                scjdrq = bgbhObj.toString();
//                System.out.println("获取到上次检定时间: " +scjdrq+"获取到的id是: " + id);
            }
		}
		List<Map<String, Object>> sbxx = ySbXxService.getXg(id);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		return mav;
	}
	/**
	 * 设备检定保存
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/jding", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData jding(HttpServletRequest request,
			HttpServletResponse response,YsbJdjl entity1,String id,String xcjdrq) {
//		String ids = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		YsbXx entity = ySbXxService.get(Integer.parseInt(id));
			entity.setScjdrq(Date.valueOf(scjdrq));
			entity.setXcjdrq(Date.valueOf(xcjdrq));
			entity.setSyzt(2);
			entity.setYqzk(2);
			ySbXxService.up(entity, id);
			entity1.setJdzt(0);
			entity1.setSbbh(entity.getSbbh());
			entity1.setSbmc(entity.getSbmc());
			entity1.setSbtxm(entity.getEwmbh());
			ysbJdjlService.save(entity1);
			return ResponseData.SUCCESS_NO_DATA;

		}
	
	/**
	 * 设备维修跳转页面（类似检定）
	 * @author liusong
	 * @date 2015年11月29日
	 * @return
	 */
	@RequestMapping(value = "/sbxxOnwxiuView")
	public ModelAndView sbxxOnwxiuView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbxxOnwxiu");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbxx = ySbXxService.getXg(id);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		List<Map<String, Object>> jddw = ySbXxService.getDicByLx("jddw");
		List<Map<String, Object>> sfyczgc = ySbXxService.getDicByLx("sfyczgc");
		List<Map<String, Object>> sfyqjhc = ySbXxService.getDicByLx("sfyqjhc");
		List<Map<String, Object>> sfysyjl = ySbXxService.getDicByLx("sfysyjl");
		List<Map<String, Object>> sfygnjc = ySbXxService.getDicByLx("sfygnjc");
		List<Map<String, Object>> jyzq = ySbXxService.getDicByLx("jyzq");
		List<Map<String, Object>> sbzt = ySbXxService.getDicByLx("sbzt");
		List<Map<String, Object>> yqzk = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> syzt = ySbXxService.getDicByLx("syzt");
		List<Map<String, Object>> dw = ySbXxService.getDicByLx("dw");
		List<Map<String,Object>> syks=nwglservice.getBm("100250");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("jddw",jddw);
		mav.addObject("sfyczgc",sfyczgc);
		mav.addObject("sfyqjhc",sfyqjhc);
		mav.addObject("sfysyjl",sfysyjl);
		mav.addObject("sfygnjc",sfygnjc);
		mav.addObject("jyzq",jyzq);
		mav.addObject("sbzt",sbzt);
		mav.addObject("yqzk",yqzk);
		mav.addObject("syzt",syzt);
		mav.addObject("dw",dw);
		return mav;
	}
	
	/**
	 * 设备维修保存
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/wxiu", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData wxiu(YsbXx entity,YsbJdjl entity1, String id) {
//		System.out.println("获取到的id是: " + id);
			entity.setScjdrq(Date.valueOf(scjdrq));
			entity.setSyzt(3);
			ySbXxService.up(entity, id);
			entity1.setJdzt(0);
			entity1.setSbbh(entity.getSbbh());
			entity1.setSbmc(entity.getSbmc());
			entity1.setSbtxm(entity.getEwmbh());
			ysbJdjlService.save(entity1);
			return ResponseData.SUCCESS_NO_DATA;

		}
	
	
	/**
	 * 设备二维码生成
	 * @author liujiansen
	 * @date 2015年11月20日
	 * @return
	 */
	@RequestMapping(value = "/sbbqPage")
	public ModelAndView openBqPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/sbSbbq");
		String sbbh=request.getParameter("sbbh");
		List<Map<String,Object>> list=ySbXxService.getSbewm(sbbh);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if(list.size()!=0){
			String url=str+"/toSbDetail?sbbh="+sbbh;
			mav.addObject("url", url);
			mav.addObject("map", list.get(0));
		}
		return mav;
	}
	
	/**
	 * 设备二维码生成-设备明细
	 * @author liujiansen
	 * @date 2015年11月23日
	 * @return
	 */
	@RequestMapping(value = "/toSbDetail")
	public ModelAndView toSbDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/sbSbDetail");
		String sbbh=request.getParameter("sbbh");
		List<Map<String,Object>> list=ySbXxService.getSbewm(sbbh);
		if(list.size()!=0){
			mav.addObject("map", list.get(0));
		}
		return mav;
	}
	
	/**
	 * 查看设备检定证书
	 * @author liusong
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @param ysjlwjm,bz
	 * @return
	 */
	@RequestMapping(value = "/jdzsck")
	public ModelAndView jdzs(HttpServletRequest request,
			HttpServletResponse response,String jdzs,String jdzssub,String cs){
		String sub = jdzssub.substring(jdzssub.lastIndexOf('.'));//一个参数表示截取传递的序号之后的部分
		String url = null ;
		List<String> fileTypes1 = new ArrayList<String>();
        fileTypes1.add(".png");
        fileTypes1.add(".jpg");
        List<String> fileTypes2 = new ArrayList<String>();
        fileTypes2.add(".doc");
        fileTypes2.add(".docx");
        List<String> fileTypes3 = new ArrayList<String>();
        fileTypes3.add(".pdf");
		if(fileTypes1.contains(sub)){
			url ="/sbgl/jsp/ysjltpOnLine";
		}
		if(fileTypes2.contains(sub)){
			url ="/sbgl/jsp/ysjldocOnLine";
		}
		if(fileTypes3.contains(sub)){
			url ="/sbgl/jsp/ysjlpdfOnLine";
		}
		ModelAndView modelAndView = new ModelAndView(url);
		if (jdzssub != null) {
			modelAndView.addObject("jdzssub", jdzssub);
		}
		modelAndView.addObject("cs", cs);
		return modelAndView;
	}
	
	/**
	 * 点击修改按钮跳转到修改窗口的jsp页面
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/gyyOnUse")
	public ModelAndView gyyOnUse(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
	        	+ File.separator +"home/";
		ModelAndView mav = new ModelAndView("/sbgl/jsp/gyyOnUse");
			mav.addObject("id", id);
			mav.addObject("path", path);
		return mav;
	}
	
	@RequestMapping(value="/saveGyy", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData save(HttpServletRequest request,String ids,String imgeId,String szPostfix) {
		String path =  request.getSession().getServletContext().getRealPath("/")+ "resources"
	        	+ File.separator +"home";
		String p=path.substring(path.length()-14,path.length()-5)+"/"+path.substring(path.length()-4,path.length());
		    YsbXx entity = ySbXxService.get(Integer.parseInt(ids));
    		entity.setJdzssub(p+"/"+ imgeId + szPostfix);
    		entity.setJdzs(imgeId + szPostfix);
    		ySbXxService.saveOrUpdate(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
}
