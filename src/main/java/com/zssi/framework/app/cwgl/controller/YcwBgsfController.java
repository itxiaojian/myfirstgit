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
import com.zssi.framework.app.cwgl.model.YcwBgsf;
import com.zssi.framework.app.cwgl.model.YcwBgsfjl;
import com.zssi.framework.app.cwgl.service.YcwBgsfService;
import com.zssi.framework.app.cwgl.service.YcwBgsfjlService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 报告收费controller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月11日 下午5:06:14 
 * 类说明 
 */
@Controller
@RequestMapping("/cwgl/YcwBgsf")
public class YcwBgsfController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(YcwBgsfController.class);
	
	@Autowired
	private YcwBgsfService bgsfService;
	
	@Autowired
	private YcwBgsfjlService bgsfjlService;

//	报告待收费查询
	@RequestMapping(value = "/getBgsfList")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgsfList(Integer start,Integer limit,String code,String jyks,String ywks){
		return bgsfService.getBgsfList(start, limit,code,jyks,ywks);
	}
	
	@RequestMapping(value = "/BgsfPage")
	public ModelAndView openPage(){
	ModelAndView andView = new ModelAndView("/cwgl/ycwBgsfList");
	return andView;
	}
	
//	报告已收费查询
	@RequestMapping(value = "/getBgysfList")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgysfList(Integer start,Integer limit,String code,String jyks,String ywks){
		return bgsfService.getBgysfList(start, limit,code,jyks,ywks);
	}
	
	@RequestMapping(value = "/BgysfPage")
	public ModelAndView openyPage(){
	ModelAndView andView = new ModelAndView("/cwgl/ycwBgysfList");
	return andView;
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
		bgsfService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 点击报告收费弹出jsp进行收费登记
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	
	@RequestMapping(value = "/bgsfonSfeiView")
	public ModelAndView bgsfonSfeiView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/bgsfonSfei");
		String id = request.getParameter("id");
		String bgbh = request.getParameter("bgbh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> bgsf = bgsfService.getbgsf(id);
		if (bgsf != null) {
			mav.addObject("bgsf", bgsf);
		}
		List<Map<String, Object>> bgsfjl = bgsfjlService.getbgsfjl(bgbh);
		if (bgsfjl != null) {
			mav.addObject("bgsfjl", bgsfjl);
		}
		System.out.println(bgsfjl);
		List<Map<String, Object>> srfl = bgsfService.getDicByLx("srfl");
		List<Map<String, Object>> sfzt = bgsfService.getDicByLx("sfzt");
		List<Map<String, Object>> pjfl = bgsfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("srfl",srfl);
		mav.addObject("sfzt",sfzt);
		return mav;
	}
	
	/**
	 * 查看报告收费
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/bgsfonLookView")
	public ModelAndView bgsfonLookView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/bgsfonLook");
		String id = request.getParameter("id");
		String bgbh = request.getParameter("bgbh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> bgsf = bgsfService.getbgsf(id);
		if (bgsf != null) {
			mav.addObject("bgsf", bgsf);
		}
		List<Map<String, Object>> sfxm = bgsfService.getsfxm(bgbh);
		if (sfxm != null) {
			mav.addObject("sfxm", sfxm);
		}
		List<Map<String, Object>> srfl = bgsfService.getDicByLx("srfl");
		List<Map<String, Object>> sfzt = bgsfService.getDicByLx("sfzt");
		List<Map<String, Object>> pjfl = bgsfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("srfl",srfl);
		mav.addObject("sfzt",sfzt);
		return mav;
	}
	
	/**
	 * 查看报告收费缴费记录
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/bgsfonLookjlView")
	public ModelAndView bgsfonLookjlView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/bgsfonLookjl");
		String id = request.getParameter("id");
		String bgbh = request.getParameter("bgbh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> bgsf = bgsfService.getbgsf(id);
		if (bgsf != null) {
			mav.addObject("bgsf", bgsf);
		}
		List<Map<String, Object>> bgsfjl = bgsfjlService.getbgsfjl(bgbh);
		if (bgsfjl != null) {
			mav.addObject("bgsfjl", bgsfjl);
		}
		List<Map<String, Object>> srfl = bgsfService.getDicByLx("srfl");
		List<Map<String, Object>> sfzt = bgsfService.getDicByLx("sfzt");
		List<Map<String, Object>> pjfl = bgsfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("srfl",srfl);
		mav.addObject("sfzt",sfzt);
		return mav;
	}
	
	/**
	 * 修改报告收费缴费记录
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/updatejlView")
	public ModelAndView updatejlView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/bgsfonUpdatejl");
		String id = request.getParameter("id");
		String bgbh = request.getParameter("bgbh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> bgsf = bgsfService.getbgsf(id);
		if (bgsf != null) {
			mav.addObject("bgsf", bgsf);
		}
		List<Map<String, Object>> bgsfjl = bgsfjlService.getbgsfjl(bgbh);
		if (bgsfjl != null) {
			mav.addObject("bgsfjl", bgsfjl);
			mav.addObject("num",bgsfjl.size());
		}
		List<Map<String, Object>> srfl = bgsfService.getDicByLx("srfl");
		List<Map<String, Object>> sfzt = bgsfService.getDicByLx("sfzt");
		List<Map<String, Object>> pjfl = bgsfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("srfl",srfl);
		mav.addObject("sfzt",sfzt);
		return mav;
	}
	
	/**
	 * 报告退费
	 * @author liusong
	 * @date 2015年12月13日
	 * @return
	 */
	
	@RequestMapping(value = "/bgsfonTfeiView")
	public ModelAndView bgsfonTfeiView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/bgsfonTfei");
		String id = request.getParameter("id");
		String bgbh = request.getParameter("bgbh");
//		System.out.println("conteoller层获取到的id是: " + id);
		List<Map<String, Object>> bgsf = bgsfService.getbgsf(id);
		if (bgsf != null) {
			mav.addObject("bgsf", bgsf);
		}
		List<Map<String, Object>> bgsfjl = bgsfjlService.getbgsfjl(bgbh);
		if (bgsfjl != null) {
			mav.addObject("bgsfjl", bgsfjl);
		}
		List<Map<String, Object>> srfl = bgsfService.getDicByLx("srfl");
		List<Map<String, Object>> sfzt = bgsfService.getDicByLx("sfzt");
		List<Map<String, Object>> pjfl = bgsfService.getDicByLx("pjfl");
		mav.addObject("pjfl",pjfl);
		mav.addObject("srfl",srfl);
		mav.addObject("sfzt",sfzt);
		return mav;
	}
	
	/**
	 * 报告收费保存
	 * @author liusong
	 * @date 2015年12月13日
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/sFei", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData sFei(String id,String ysje,String jyfy,String bcss,String srfl,String pjfl,String pjhm,String bz,YcwBgsfjl entity1) {
		YcwBgsf entity = bgsfService.get(Integer.parseInt(id));
//		System.out.println("conteoller层获取到的id是: " + ids);
		if(entity.getYsje().compareTo(new BigDecimal(0))>0 ) {
		      entity.setSrfl(srfl);
		      entity.setPjfl(pjfl);
	    	  entity.setYsfje(entity.getYsfje().add(new BigDecimal(bcss)));
	    	  entity.setYsje(entity.getYsje().subtract(new BigDecimal(bcss)));
	    	  entity.setXgje(new BigDecimal(-1));
	    	  SysYh sfr =AppUtil.getCurrentUser();
	    	  bgsfService.update(entity, id);
	    	  entity1.setBgbh(entity.getBgbh());
	          entity1.setYpmc(entity.getYpmc());
	          entity1.setSjdw(entity.getSjdw());
	          entity1.setKs_id(entity.getKs_id());
	          entity1.setSsywks(entity.getSsywks());
	          entity1.setJyfy(entity.getJyfy());
	    	  entity1.setBcss(new BigDecimal(bcss));
	          entity1.setSrfl(srfl);
	          entity1.setPjfl(pjfl);
	          entity1.setPjhm(pjhm);
	          entity1.setBz(bz);
	          entity1.setYsje(entity.getYsje());
	          entity1.setYsfje(entity.getYsfje());
		      entity1.setSfr(sfr.getXm());
		      entity1.setJyjsrq(Calendar.getInstance().getTime());
		      bgsfjlService.save(entity1);
	      }else if(entity.getYsje().compareTo(new BigDecimal(0)) == 0 ) {
		      entity.setSrfl(srfl);
		      entity.setPjfl(pjfl);
	    	  entity.setYsfje(entity.getYsfje().add(new BigDecimal(bcss)));
	    	  entity.setYsje(new BigDecimal(ysje).subtract(new BigDecimal(bcss)));
	    	  entity.setJyfy(new BigDecimal(jyfy));
	    	  entity.setXgje(new BigDecimal(-1));
	    	  SysYh sfr =AppUtil.getCurrentUser();
	    	  bgsfService.update(entity, id);
	    	  entity1.setBgbh(entity.getBgbh());
	          entity1.setYpmc(entity.getYpmc());
	          entity1.setSjdw(entity.getSjdw());
	          entity1.setKs_id(entity.getKs_id());
	          entity1.setSsywks(entity.getSsywks());
	          entity1.setJyfy(entity.getJyfy());
	    	  entity1.setBcss(new BigDecimal(bcss));
	          entity1.setSrfl(srfl);
	          entity1.setPjfl(pjfl);
	          entity1.setPjhm(pjhm);
	          entity1.setBz(bz);
	          entity1.setYsje(new BigDecimal(ysje).subtract(new BigDecimal(bcss)));
	          entity1.setYsfje(entity.getYsfje());
		      entity1.setSfr(sfr.getXm());
		      entity1.setJyjsrq(Calendar.getInstance().getTime());
		      bgsfjlService.save(entity1);
	      }
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 报告退费保存（实际就是将原报告的检验费用予以修改成负数并保存一条收费记录和报告收费，对三个表进行操作）
	 * @author liusong
	 * @date 2015年12月13日
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/tFei", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData tFei(String id,String jyfy,String bz,YcwBgsfjl entity1) {
		Integer ids = Integer.parseInt(id);
		BigDecimal bigjyfy = new BigDecimal(jyfy);
		YcwBgsf entity = bgsfService.get(ids);
		YcwBgsf entity2 = bgsfService.get(ids);
			  entity.setBgbh(entity.getBgbh());
	          entity.setYpmc(entity.getYpmc());
	          entity.setSjdw(entity.getSjdw());
	          entity.setKs_id(entity.getKs_id());
	          entity.setSsywks(entity.getSsywks());
	          entity.setJyfy(new BigDecimal(0).subtract(bigjyfy));
	  	      entity.setBcss(new BigDecimal(0).subtract(bigjyfy));
	  	      entity.setXgje(new BigDecimal(-1));
		      entity.setSrfl(entity.getSrfl());
		      entity.setPjfl(entity.getPjfl());
	    	  entity.setYsfje(new BigDecimal(0).subtract(bigjyfy));
	    	  entity.setJyjsrq(Calendar.getInstance().getTime());
	    	  entity.setYsje(new BigDecimal(0));
	    	  SysYh sfr =AppUtil.getCurrentUser();
	    	  bgsfService.save(entity);
	    	  entity2.setXgje(new BigDecimal(2));
	    	  bgsfService.update(entity2,id);
	    	  entity1.setBgbh(entity.getBgbh());
	          entity1.setYpmc(entity.getYpmc());
	          entity1.setSjdw(entity.getSjdw());
	          entity1.setKs_id(entity.getKs_id());
	          entity1.setSsywks(entity.getSsywks());
	          entity1.setJyfy(new BigDecimal(0).subtract(bigjyfy));
	    	  entity1.setBcss(new BigDecimal(0).subtract(bigjyfy));
	    	  entity1.setXgje(new BigDecimal(0));
	          entity1.setSrfl(entity.getSrfl());
	          entity1.setPjfl(entity.getPjfl());
	          entity1.setBz(bz);
	          entity1.setYsje(new BigDecimal(0));
	          entity1.setYsfje(new BigDecimal(0).subtract(bigjyfy));
		      entity1.setSfr(sfr.getXm());
		      entity1.setJyjsrq(Calendar.getInstance().getTime());
		      bgsfjlService.save(entity1);
//	      }
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
		YcwBgsf bgsf = bgsfService.get(Integer.parseInt(id));
		bgsf.setSrfl(request.getParameter("srfl"));
		bgsfService.update(bgsf);
		for (int i = 0; i < num;i++) {
			String ids=request.getParameter("id"+(i+1));
			String pjhm=request.getParameter("pjhm"+(i+1));
			YcwBgsfjl entity = bgsfjlService.get(Integer.parseInt(ids));
			entity.setPjhm(pjhm);
			bgsfjlService.saveOrUpdate(entity);
			
		}
		return ResponseData.SUCCESS_NO_DATA;
	}
}
