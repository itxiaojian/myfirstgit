package com.zssi.framework.app.ypgl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwBgsf;
import com.zssi.framework.app.cwgl.service.YcwBgsfService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypWsdjfh;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypWsdjfhService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/**
 * 
 * @author liujiansen
 * @date 2015年12月24日
 */
@Controller
@RequestMapping("/ypgl/YypWsdjfh")
public class YypWsdjfhController extends BaseController {

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypWsdjfhController.class);

	@Autowired
	private YypWsdjfhService service;
	@Autowired
	private YypYpxxService yypYpxxService;
	@Autowired
	private YcwBgsfService bgsfService;

	/**
	 * 样品预处理页面
	 * 
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @return
	 */
	@RequestMapping(value = "/openPage")
	public ModelAndView openPage() {
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypWsdjfhList");
		return modelAndView;
	}

	/**
	 * 后台：样品预登记信息
	 * 
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/getYpWsdxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYpWsdxxList(Integer start,
			Integer limit, String canshu, String bgbh) {
		return service.getYpWsdxxList(start, limit, canshu, bgbh);

	}

	/**
	 * 点击处理按钮跳转到样品登记的jsp页面
	 * 
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxAddView")
	public ModelAndView ypxxUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypdjYcl");
		String id = request.getParameter("id");
		YypWsdjfh ypxx = service.get(Integer.parseInt(id));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			if(ypxx.getCyrq()!=null){
				mav.addObject("cyrq", sim.format(ypxx.getCyrq()));
			}
			if(ypxx.getDyrq()!=null){
				mav.addObject("dyrq", sim.format(ypxx.getDyrq()));
			}
			if(ypxx.getWcqx()!=null){
				mav.addObject("wcqx", sim.format(ypxx.getWcqx()));
			}
			if(ypxx.getDjsj()!=null){
				mav.addObject("djsj", sim.format(ypxx.getDjsj()));
			}
		}
		List<Map<String, Object>> zhList = service.getZh();
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService
				.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService
				.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService
				.getDicByJylx("ypjyzt");
		mav.addObject("zhList", zhList);
		mav.addObject("jylx", jylx);
		mav.addObject("lyfs", lyfs);
		mav.addObject("ypzt", ypzt);
		mav.addObject("bgfsfs", bgfsfs);
		mav.addObject("yhxtk", yhxtk);
		mav.addObject("jyfydd", jyfydd);
		mav.addObject("ypjyzt", ypjyzt);
		return mav;
	}

	/**
	 * 保存处理
	 * 
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param request
	 * @param entity
	 * @param entity1
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(ModelMap model, YypYpxx entity, YcwBgsf entity1,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		SysYh yh = AppUtil.getCurrentUser();
		entity.setDjry(yh.getXm());
		entity.setYpjyzt(0);
		entity.setDjlx(0);
		String ypbh = request.getParameter("ypbh");
		if (ypbh.length() == 11) {
			String zh = ypbh.substring(4, 6);
			entity.setZh(zh);
		} else if (ypbh.length() == 12) {
			String zh = ypbh.substring(4, 7);
			entity.setZh(zh);
		}
		String xMurl = request.getRequestURL().toString();
		String str = xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url = str + "/toSbDetail?ypbh=" + ypbh;
		entity.setEwmbh(url);
		// //添加样品附件
		// String filename = "";
		// if(attachMentFile.isEmpty()){
		// throw new RuntimeException("文件未上传");
		// }else{
		// filename = attachMentFile.getOriginalFilename();
		// }
		// entity.setFj(filename);
		String result = yypYpxxService.saveYpxx(request,entity,entity1);
		if("1".equals(result)) {
			service.update(id);
			return ResponseData.SUCCESS_NO_DATA;
		}else {
			return ResponseData.FAILED_NO_DATA;
		}
	}
}
