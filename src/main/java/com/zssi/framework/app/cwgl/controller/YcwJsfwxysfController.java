package com.zssi.framework.app.cwgl.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysf;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysfjl;
import com.zssi.framework.app.cwgl.service.YcwJsfwxysfService;
import com.zssi.framework.app.cwgl.service.YcwJsfwxysfjlService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;

//技术服务协议收费controller类
//liusong 2015-12-24
@Controller
@RequestMapping("/cwgl/YcwJsfwxysf")
public class YcwJsfwxysfController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(YcwJsfwxysfController.class);
	
	@Autowired
	private YcwJsfwxysfService xysfService;
	
	@Autowired
	private YcwJsfwxysfjlService xysfjlService;

//	技术服务协议收费待收费查询
	@RequestMapping(value = "/getXysfList")
	@ResponseBody
	public Pagination<Map<String, Object>> getXysfList(Integer start,Integer limit,String code,String jyks,String ywks){
		return xysfService.getXysfList(start, limit,code,jyks,ywks);
		
	}
//  协议收费已收费查询	
	@RequestMapping(value = "/getXyysfList")
	@ResponseBody
	public Pagination<Map<String, Object>> getXyysfList(Integer start,Integer limit,String code,String jyks,String ywks){
		System.out.println("controller层"+code);
		return xysfService.getXyysfList(start, limit,code,jyks,ywks);
		
	}

//	技术服务协议收费待收费分页查询
	@RequestMapping(value = "/XysfPage")
	public ModelAndView openPage(){
		ModelAndView addView = new ModelAndView("/cwgl/ycwJsfwxysfList");
		return addView;
		
	}
	
//	技术服务协议收费已收费查询
	@RequestMapping(value = "/XyysfPage")
	public ModelAndView open1Page(){
		ModelAndView addView = new ModelAndView("/cwgl/ycwJsfwxyysfList");
		return addView;
		
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
	public ResponseData delete(Integer[] ids,String[] xybh){
		xysfService.delete(ids,xybh);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 查看协议收费缴费+记录
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/xysfonLookView")
	public ModelAndView xysfonLookView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/xysfonLook");
		String id = request.getParameter("id");
		String xybh = request.getParameter("xybh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> xysf = xysfService.getxysf(id);
		if (xysf != null) {
			mav.addObject("xysf", xysf);
		}
		List<Map<String, Object>> xysfjl = xysfjlService.getxysfjl(xybh);
		if (xysfjl != null) {
			mav.addObject("xysfjl", xysfjl);
		}
		List<Map<String, Object>> fkfs = xysfService.getDicByLx("fkfs");
		List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("fkfs",fkfs);
		return mav;
	}
	
	/**
	 * 修改协议收费缴费+记录
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/onUpdatejl")
	public ModelAndView onUpdatejl(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/xysfonUpdatejl");
		String id = request.getParameter("id");
		String xybh = request.getParameter("xybh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> xysf = xysfService.getxysf(id);
		List<Map<String, Object>> srfl = xysfService.getDicByLx("srfl");
		if (xysf != null) {
			mav.addObject("xysf", xysf);
			mav.addObject("srfl", srfl);
		}
		List<Map<String, Object>> xysfjl = xysfjlService.getxysfjl(xybh);
		if (xysfjl != null) {
			mav.addObject("xysfjl", xysfjl);
			mav.addObject("num",xysfjl.size());
		}
		List<Map<String, Object>> fkfs = xysfService.getDicByLx("fkfs");
		List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("fkfs",fkfs);
		return mav;
	}
	
	/**
	 * 收费
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/xysfonSfeiView")
	public ModelAndView xysfonSfeiView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/xysfonSfei");
		String id = request.getParameter("id");
		String xybh = request.getParameter("xybh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> xysf = xysfService.getxysf(id);
		if (xysf != null) {
			mav.addObject("xysf", xysf);
		}
		List<Map<String, Object>> xysfjl = xysfjlService.getxysfjl(xybh);
		if (xysfjl != null) {
			mav.addObject("xysfjl", xysfjl);
		}
		List<Map<String, Object>> fkfs = xysfService.getDicByLx("fkfs");
		List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
		List<Map<String, Object>> srfl = xysfService.getDicByLx("srfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("fkfs",fkfs);
		mav.addObject("srfl",srfl);
		return mav;
	}
	
	/**
	 * 收费
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/xysfonTfeiView")
	public ModelAndView xysfonTfeiView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/xysfonTfei");
		String id = request.getParameter("id");
		String xybh = request.getParameter("xybh");
		List<Map<String, Object>> xysf = xysfService.getxysf(id);
		if (xysf != null) {
			mav.addObject("xysf", xysf);
		}
		List<Map<String, Object>> xysfjl = xysfjlService.getxysfjl(xybh);
		if (xysfjl != null) {
			mav.addObject("xysfjl", xysfjl);
		}
		List<Map<String, Object>> fkfs = xysfService.getDicByLx("fkfs");
		List<Map<String, Object>> pjfl = xysfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("fkfs",fkfs);
		return mav;
	}
	
	/**
	 * 技术服务协议收费保存
	 * @author liusong
	 * @date 2015年12月13日
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/sFei", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData sFei(String id,String bcss,String bz,String srfl,String pjfl,String pjhm,YcwJsfwxysfjl entity1) {
		Integer ids = Integer.parseInt(id);
		SysYh sfr =AppUtil.getCurrentUser();
		BigDecimal bigbcss = new BigDecimal(bcss);
		YcwJsfwxysf entity = xysfService.get(ids);
//		System.out.println("conteoller层获取到的id是: " + ids);
	    	  entity.setYsfje(entity.getYsfje().add(bigbcss));
	    	  entity.setYsje(entity.getYsje().subtract(bigbcss));
	    	  entity.setSrfl(srfl);
	    	  entity.setPjfl(pjfl);
	    	  entity.setSfr("-1");
	    	  xysfService.update(entity, id);
	    	  entity1.setXybh(entity.getXybh());
	    	  entity1.setXyks_id(entity.getXyks_id());
	  		  entity1.setJyks_id(entity.getJyks_id());
	  		  entity1.setYwks_id(entity.getYwks_id());
	  		  entity1.setSsks_id(entity.getSsks_id());
	          entity1.setXyje(entity.getXyje());
	    	  entity1.setBcss(bigbcss);
	    	  entity1.setPjhm(pjhm);
	          entity1.setBz(bz);
	          entity1.setYsje(entity.getYsje());
	          entity1.setYsfje(entity.getYsfje());
		      entity1.setSfr(sfr.getXm());
		      entity1.setSfrq(Calendar.getInstance().getTime());
		      xysfjlService.save(entity1);
//	      }
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 技术服务协议收费保存
	 * @author liusong
	 * @date 2015年12月13日
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/tFei", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData tFei(String id,String bcss,String bz,String pjfl,String pjhm,YcwJsfwxysfjl entity1) {
		Integer ids = Integer.parseInt(id);
		SysYh sfr =AppUtil.getCurrentUser();
		BigDecimal bigbcss = new BigDecimal(bcss);
		YcwJsfwxysf entity = xysfService.get(ids);
		YcwJsfwxysf entity2 = xysfService.get(ids);
	    	  entity.setSfr("1");
	    	  entity.setPjfl(pjfl);
	    	  xysfService.update(entity, id);
	    	  entity2.setSfr("2");
	    	  entity2.setBcss(new BigDecimal(0).subtract(bigbcss));
	    	  entity2.setXyje(new BigDecimal(0).subtract(bigbcss));
	    	  entity2.setYsje(new BigDecimal(0));
	    	  entity2.setPjfl(pjfl);
	          entity2.setYsfje(new BigDecimal(0).subtract(bigbcss));
	    	  entity2.setSfrq(Calendar.getInstance().getTime());
	    	  entity2.setBz(bz);
	    	  xysfService.save(entity2);
	    	  entity1.setXybh(entity.getXybh());
	    	  entity1.setXyks_id(entity.getXyks_id());
	  		  entity1.setJyks_id(entity.getJyks_id());
	  		  entity1.setYwks_id(entity.getYwks_id());
	  		  entity1.setSsks_id(entity.getSsks_id());
	  		  entity1.setXyje(new BigDecimal(0).subtract(bigbcss));
	  		  entity1.setBcss(new BigDecimal(0).subtract(bigbcss));
	          entity1.setBz(bz);
	          entity1.setPjhm(pjhm);
	          entity1.setYsje(new BigDecimal(0));
	          entity1.setYsfje(new BigDecimal(0).subtract(bigbcss));
		      entity1.setSfr(sfr.getXm());
		      entity1.setSfrq(Calendar.getInstance().getTime());
		      xysfjlService.save(entity1);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 已收费报告修改收费记录保存
	 * @author liusong
	 * @date 2015年12月13日
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/jlUpdate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData jlUpdate(HttpServletRequest request) {
		Integer num = 0;
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		String id = request.getParameter("id");
		YcwJsfwxysf xysf = xysfService.get(Integer.parseInt(id));
		xysf.setSrfl(request.getParameter("srfl"));
		xysfService.update(xysf);
		for (int i = 0; i < num;i++) {
			String ids=request.getParameter("id"+(i+1));
			String pjhm=request.getParameter("pjhm"+(i+1));
			YcwJsfwxysfjl entity = xysfjlService.get(Integer.parseInt(ids));
			entity.setPjhm(pjhm);
			xysfjlService.saveOrUpdate(entity);
		}
		return ResponseData.SUCCESS_NO_DATA;
	}

}
