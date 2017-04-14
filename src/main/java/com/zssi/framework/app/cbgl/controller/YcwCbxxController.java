package com.zssi.framework.app.cbgl.controller;

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
import com.zssi.framework.app.cbgl.model.YcwCbxx;
import com.zssi.framework.app.cbgl.service.YcwCbxxService;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

@Controller
@RequestMapping("/cbgl/YCwCbxx")
public class YcwCbxxController extends BaseController {

	protected final transient Logger logger = LoggerFactory.getPresentationLog(YcwCbxxController.class);
	
	@Autowired
	private YcwCbxxService YcwCbxxService;
	
	@Autowired
	private YypYpxxService yypYpxxService;

	/**
	 * 后台：成本信息
	 * 
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getCbxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getCpxxList(Integer start, Integer limit, String code,String ksbh,String jybh,String ypmc,
			String lrrq,String lrr,String xgrq,String xgr) {
		return YcwCbxxService.getCbxxList(start, limit, code, ksbh, jybh, ypmc, lrrq, lrr, xgrq, xgr);
	}

	@RequestMapping(value = "/CbxxPage")
	public ModelAndView openPage() {
		ModelAndView modelAndView = new ModelAndView("/cbgl/ycwCbxxList");
		return modelAndView;
	}

	/**
	 * 后台:增加成本信息
	 * 
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(ModelMap model, YcwCbxx entity, 
			HttpServletRequest request, HttpServletResponse response) {
		YcwCbxxService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 后台:修改成本信息
	 * 
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YcwCbxx entity, String id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ks_id = request.getParameter("ks_id");
		entity.setKsbh(ks_id);
		YcwCbxxService.update(entity, id, request, response);
//		String jybh1 = request.getParameter("bh");
//		String jybh2 = entity.getJybh();
//		YcwCbxxService.updateCbmxJybh(jybh1, jybh2);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 后台:删除成本信息
	 * 
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids,String[] ksbhs,String[] lrrqs) {
		//System.out.println(jybhs);
		YcwCbxxService.delete(ids,ksbhs,lrrqs);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 导入EXCEL数据
	 * 
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(@RequestParam("fileData") MultipartFile fileData) {
		String message = YcwCbxxService.importMember(fileData);
		if (message == null)
			return "{\"success\":true}";
		else
			return "{\"success\":false,\"message\":\"" + message + "\"}";
	}

	/**
	 * 导出Excel
	 * 
	 * @author wangyong
	 * @throws Exception
	 * @date 2015年10月27日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, String code) 
			throws Exception {
		YcwCbxxService.exportExcel(request, response, code);
	}

	/**
	 * 点击增加跳转到新增窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年11月6日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cbxxAddView")
	public ModelAndView cbxxAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/cbxxAdd");
		List<Map<String, Object>> cblx = yypYpxxService.getDicByJylx("cblx");
		mav.addObject("cblx",cblx);
		return mav;
	}
	
	/**
	 * 点击增加跳转到修改窗口的JSP页面
	 * 
	 * @author wangyong
	 * @date 2015年11月19日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cbxxUpdateView")
	public ModelAndView cbxxUpdateView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/cwgl/jsp/cbxxUpdate");
		String id = request.getParameter("id");
		String cbbh = request.getParameter("cbbh");
		List<Map<String, Object>> cbxx = YcwCbxxService.getCbxx(Integer.parseInt(id));
		List<Map<String, Object>> cbmx = YcwCbxxService.getCbmx(cbbh);
		if (cbxx != null) {
			mav.addObject("cbxx", cbxx);
		}
		if (cbmx != null) {
			mav.addObject("cbmx", cbmx);
			int cbmxLen = cbmx.size();
			mav.addObject("cbmxLen", cbmxLen);
		}
		List<Map<String, Object>> cblx = yypYpxxService.getDicByJylx("cblx");
		mav.addObject("cblx",cblx);
		return mav;
	}
	
	/**
	 * 费用类型从数据字典取值
	 * @author wangyong
	 * @date 2016年1月14日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByJylx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByJylx(String zdzl) {
		return yypYpxxService.getDicByJylx("cblx");
	}
	
}
