package com.zssi.framework.app.jygl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjySbxxDao;
import com.zssi.framework.app.jygl.model.YjyBgzh;
import com.zssi.framework.app.jygl.model.YjyJyxx;
import com.zssi.framework.app.jygl.service.YjyBgzhService;
import com.zssi.framework.app.jygl.service.YjyJyxxService;
import com.zssi.framework.app.jygl.service.YjySbxxService;
import com.zssi.framework.app.sbgl.dao.YsbXxDao;
import com.zssi.framework.app.sbgl.service.YsbSyjlService;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/**
 * 检验信息
 * 
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Controller
@RequestMapping("/jygl/YjyJyxx")
public class YjyJyxxController extends BaseController {

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyJyxxController.class);
	@Autowired
	private YjyJyxxService service;
	@Autowired
	private YsbXxService sbxxservice;
	@Autowired
	private YjySbxxService jysbxxservice;
	@Autowired
	private YsbSyjlService sbsyjlservice;
	@Autowired
	private YsbXxDao SbDao;
	@Autowired
	private YjySbxxDao jysbdao;
	@Autowired
	private YypYpxxService ypxxservice;
	@Autowired
	private YjyBgzhService bgzhservice;
	

	/**
	 * 后台：检验信息
	 * 
	 * @author duanpeijun
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getJyxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getJyxxList(Integer start,
			Integer limit, String canshu) {
		return service.getJyxxList(start, limit, canshu);
	}

	@RequestMapping(value = "/JyxxPage")
	public ModelAndView openPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyJyxxList");
		return modelAndView;
	}

	/**
	 * 催办状态（数据字典）
	 * 
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByCbzt", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByCbzt(String zdzl) {
		return service.getDicByCbzt("cbzt");
	}

	/**
	 * 检验状态（数据字典）
	 * 
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByJyzt", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByJyzt(String zdzl) {
		return service.getDicByCbzt("jyzt");
	}

	/**
	 * 增加
	 * 
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(ModelMap model, YjyJyxx entity,
			HttpServletRequest request, HttpServletResponse response) {
		service.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 修改
	 * 
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjyJyxx entity, String id) {
		service.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 删除
	 * 
	 * @author wangyong
	 * @date 2015年9月23日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids) {
		service.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/************************************ 2015-11-4针对“检验”,由Ext转向Jsp页面 ****************************************************/

	/**
	 * 检验页面中————样品信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxx")
	public ModelAndView ypxx(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ypxx");
		String bgbh = request.getParameter("bgbh");
		List<Map<String, Object>> ypxx = service.getYp(bgbh);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
		}
		return mav;
	}

	/**
	 * 检验页面中————设备信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypsbxx")
	public ModelAndView ypsbxx(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ypsbxx");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> sbxx = service.getSbxx(code);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		return mav;
	}

	/**
	 * 检验页面中————检验标准信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypjybz")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ypjybz");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> jybz = service.getJybzxx(code);
		if (jybz != null) {
			mav.addObject("jybz", jybz);
		}
		return mav;
	}

	/**
	 * 检验标准页面中————检验项目信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypjybzxm")
	public ModelAndView ypjybzxm(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ypjybzxm");
		String bzbh = request.getParameter("bzbh");
		String code = request.getParameter("code");
		List<Map<String, Object>> jyxm = service.getJyxm(bzbh, code);
		if (jyxm != null) {
			mav.addObject("jyxm", jyxm);
			mav.addObject("bzbh", bzbh);
		}
		return mav;
	}

	/**
	 * 在检验标页面中点击提交 1.保存检验标准名称这个字段到样品检验页面的检验依据字段, 2.保存设备信息到设备使用记录表和检验设备设备表中
	 * 
	 * @author duanpeijun
	 * @date 2015年11月9日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tijiao")
	@ResponseBody
	public String saveJybz(HttpServletRequest request, String[] rztbid) {
		String str = "";
		str = service.tijiao(request, rztbid);
		str = "1";
		return str;
	}
/************************************ 2015-11-29 在流程中进行样品的检验 ****************************************************/
	/**
	 * 流程中————样品信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/lcypxx")
	public ModelAndView ypxx111(HttpServletRequest request,
			HttpServletResponse response,String ypid,String djlx) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ypxx");
		List<Map<String, Object>> ypxx = ypxxservice.getYpxx(Integer.parseInt(ypid),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ypbh = ypxx.get(0).get("ypbh").toString();
			if(!"".equals(ypbh) && ypbh != null){
				String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
				mav.addObject("url", ewmurl);
			}
		}
		List<Map<String, Object>> lyfs = ypxxservice.getDicByJylx("lyfs");
		List<Map<String, Object>> bgfsfs = ypxxservice.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = ypxxservice.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = ypxxservice.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = ypxxservice.getDicByJylx("ypjyzt");
		mav.addObject("lyfs",lyfs);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		return mav;
	}
	
	/**
	 * 在流程中————设备信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/lcypsbxx")
	public ModelAndView lcypsbxx(HttpServletRequest request,
			HttpServletResponse response, String ypid,String taskId) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/ypsbxx");
		String code = request.getParameter("code");
		if (ypid != null) {
			mav.addObject("id", ypid);
			mav.addObject("taskId", taskId);
		}
		List<Map<String, Object>> sbxx = service.getSbxx(code);
		if (sbxx != null) {
			mav.addObject("sbxx", sbxx);
		}
		return mav;
	}
	
	/**
	 * 流程中————检验标准信息
	 * 
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/lcypjybz")
	public ModelAndView lcypjybz(HttpServletRequest request,
			HttpServletResponse response, String ypid) {
		ModelAndView mav = new ModelAndView("/jygl/jsp/lcypjybz");
		String code = request.getParameter("code");
		if (ypid != null) {
			mav.addObject("id", ypid);
		}
		List<Map<String, Object>> jybz = service.getJybzxx(code);
		if (jybz != null) {
			mav.addObject("jybz", jybz);
		}
		return mav;
	}
	
	/**
	 * 在流程中提交————————本质：增加样品信息的报告编号字段相对应的检验信息
	 * @author duanpeijun
	 * @date 2015年11月29日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/lctijiao")
	@ResponseBody
	public String lctijiao(HttpServletRequest request,String[] rztbid){
		String str = "";
		str = service.lctijiao(request,rztbid);
		str = "1";
		return str;
	}
	
	/**
	 * 在流程中------------点击编制报告跳转编制报告页面
	 * @author duanpeijun
	 * @date 2015年11月30日
	 * @param requese
	 * @param response
	 * @param ypid
	 * @return
	 */
	@RequestMapping(value = "/jyyl")
	public ModelAndView jyyl(HttpServletRequest request,
			HttpServletResponse response,String ypid){
		ModelAndView mav = new ModelAndView("/jygl/jsp/lcbzbg");
		List<Map<String, Object>> a = ypxxservice.getYpxx(Integer.parseInt(ypid));
		int id=Integer.parseInt(a.get(0).get("id").toString());
		YypYpxx ypxx = ypxxservice.getYpxxById(id);
		mav.addObject("ypxx", ypxx);
		String bgbh = ypxx.getBgbh();
		List<Map<String, Object>> b = service.getjyxxList(bgbh);
		int jyid=Integer.parseInt(b.get(0).get("id").toString());
		YjyJyxx jyxx = service.getJyxxById(jyid);
		mav.addObject("jyxx", jyxx);
		String bzbh = jyxx.getBzbh();
		String code = null;
		List<Map<String, Object>> getxmxx = service.getJyxm(bzbh, code);
		mav.addObject("getxmxx", getxmxx);
		String rzfs = jyxx.getRzfs();
		List<Map<String, Object>> tb = service.getlctb(rzfs);
		mav.addObject("tb", tb);
		return mav;
	}
	
	/**
	 * 主检科室审核-----点击查看检验信息
	 * @author duanpeijun
	 * @date 2015年12月1日
	 * @param requese
	 * @param response
	 * @param ypid
	 * @return
	 */
	@RequestMapping(value = "/ckjyxx")
	public ModelAndView ckjyxx(HttpServletRequest request,
			HttpServletResponse response,String ypid){
		ModelAndView mav = new ModelAndView("/jygl/jsp/lcckjyxx");
		List<Map<String, Object>> a = ypxxservice.getYpxx(Integer.parseInt(ypid));
		int id=Integer.parseInt(a.get(0).get("id").toString());
		YypYpxx ypxx = ypxxservice.getYpxxById(id);
		mav.addObject("ypxx", ypxx);
		String bgbh = ypxx.getBgbh();
		List<Map<String, Object>> b = service.getjyxxList(bgbh);
		int jyid=Integer.parseInt(b.get(0).get("id").toString());
		YjyJyxx jyxx = service.getJyxxById(jyid);
		mav.addObject("jyxx", jyxx);
		String bzbh = jyxx.getBzbh();
		String code = null;
		List<Map<String, Object>> getxmxx = service.getJyxm(bzbh, code);
		mav.addObject("getxmxx", getxmxx);
		String rzfs = jyxx.getRzfs();
		List<Map<String, Object>> tb = service.getlctb(rzfs);
		mav.addObject("tb", tb);
		return mav;
	}
	
	/**
	 * 主检科室审核-----点击预览报告信息
	 * @author duanpeijun
	 * @date 2015年12月1日
	 * @param requese
	 * @param response
	 * @param ypid
	 * @return
	 */
	@RequestMapping(value = "/bgyl")
	public ModelAndView bgyl(HttpServletRequest request,
			HttpServletResponse response,String ypid){
		ModelAndView mav = new ModelAndView("/bggl/bgcc");
		List<Map<String, Object>> a = ypxxservice.getYpxx(Integer.parseInt(ypid));
		int id=Integer.parseInt(a.get(0).get("id").toString());
		YypYpxx ypxx = ypxxservice.getYpxxById(id);
		mav.addObject("ypxx", ypxx);
		String bgbh = ypxx.getBgbh();
		List<Map<String, Object>> b = service.getbgzhList(bgbh);
		int bgzhid=Integer.parseInt(b.get(0).get("id").toString());
		YjyBgzh bgzh = bgzhservice.getBgzhById(bgzhid);
		String fm = bgzh.getFmdz();
		String sy = bgzh.getSydz();
		String fy = bgzh.getFydz();
		String fd = bgzh.getFddz();
		request.setAttribute("fm", fm);
		request.setAttribute("sy", sy);
		request.setAttribute("fy", fy);
		request.setAttribute("fd", fd);
		return mav;
	}
}
