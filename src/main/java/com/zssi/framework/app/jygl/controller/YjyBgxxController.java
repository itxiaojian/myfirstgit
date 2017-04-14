package com.zssi.framework.app.jygl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.enmu.KGQfzModeEnum;
import com.kinggrid.pdf.executes.PdfElectronicSeal4KG;
import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyBgzhDao;
import com.zssi.framework.app.jygl.model.YbgYqjl;
import com.zssi.framework.app.jygl.model.YjyBgmb;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.jygl.model.YjyBgzh;
import com.zssi.framework.app.jygl.model.YjyRztb;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.jygl.service.YjyBgzhService;
import com.zssi.framework.app.jygl.service.YjyJyxxService;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/**
 * 检验报告信息
 * 
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Controller
@RequestMapping("/jygl/YjyBgxx")
public class YjyBgxxController extends BaseController {

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YjyJyxxController.class);
	@Autowired
	private YjyBgxxService service;
//	@Autowired
//	private static YjyBgxxService servicetwo;
	@Autowired
	private YjyJyxxService jyxxservice;
//	@Autowired
//	private static YypYpxxService ypxxservice;
	@Autowired
	private YypYpxxService ypxxservice;
	@Autowired
	private YjyBgzhDao bgzhdao;
	@Autowired
	private YjyBgzhService bgzhservice;
	@Autowired
	private YsbXxService ySbXxService;

	/**
	 * 后台：检验报告信息
	 * 
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgbzList")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgbzList(Integer start,
			Integer limit, String canshu) {
		return service.getBgbzList(start, limit, canshu);
	}

	@RequestMapping(value = "/BgbzPage")
	public ModelAndView openPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgbzList");
		return modelAndView;
	}

	/**
	 * 报告信息
	 * 
	 * @author duanpeijun
	 * @date 2015年12月3日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgxxList(Integer start,
			Integer limit, String ypbh, String ypmc, String yplx, String ypdj,
			String jylx, String szcs, String wtdw, String sjdw, String scdw,
			String jyks, String ywks, String djsj, String djsjStr,
			String djsjEnd, String gcmc, String sgdw, String gcsjdw,
			String jsdw1, String jldw, String jzdw, String wtlxr) {
		return service.getBgxxList(start, limit, ypbh, ypmc, yplx, ypdj, jylx,
				szcs, wtdw, sjdw, scdw, jyks, ywks, djsj, djsjStr, djsjEnd,
				gcmc, sgdw, gcsjdw, jsdw1, jldw, jzdw, wtlxr);
	}

	@RequestMapping(value = "/BgxxPage")
	public ModelAndView bgxxPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgxxList");
		return modelAndView;
	}

	/**
	 * 报告解锁List
	 * 
	 * @author duanpeijun
	 * @date 2015年12月22日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgjs")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgjs(Integer start,
			Integer limit, String canshu) {
		return service.getBgjs(start, limit, canshu);
	}

	@RequestMapping(value = "/BgjsPage")
	public ModelAndView bgjsPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgjsList");
		return modelAndView;
	}

	/**
	 * 报告延期List
	 * 
	 * @author duanpeijun
	 * @date 2016年1月5日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgyq")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgyq(Integer start,
			Integer limit, String canshu) {
		return service.getBgyq(start, limit, canshu);
	}

	@RequestMapping(value = "/BgyqPage")
	public ModelAndView BgyqPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgyqList");
		return modelAndView;
	}

	/**
	 * 报告多次打印
	 * 
	 * @author duanpeijun
	 * @date 2016年1月5日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgdy")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgdy(Integer start,
			Integer limit, String canshu) {
		return service.getBgdy(start, limit, canshu);
	}

	@RequestMapping(value = "/BgdyPage")
	public ModelAndView BgdyPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgdyList");
		return modelAndView;
	}

	/**
	 * 报告打印
	 * 
	 * @author duanpeijun
	 * @date 2016年2月19日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgdydan")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgdydan(Integer start,
			Integer limit, String canshu) {
		return service.getBgdydan(start, limit, canshu);
	}

	@RequestMapping(value = "/BgdydanPage")
	public ModelAndView BgdydanPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgdydanList");
		return modelAndView;
	}

	/**
	 * 报告自定义打印
	 * 
	 * @author duanpeijun
	 * @date 2016年2月19日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@RequestMapping(value = "/getBgzdydy")
	@ResponseBody
	public Pagination<Map<String, Object>> getBgzdydy(Integer start,
			Integer limit, String canshu) {
		return service.getBgdydan(start, limit, canshu);
	}

	@RequestMapping(value = "/BgzdydyPage")
	public ModelAndView BgzdydyPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/yjyBgzdydyList");
		return modelAndView;
	}

	/**
	 * 发放状态（数据字典）
	 * 
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByFfzt", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByFfzt(String zdzl) {
		return service.getDicByFfzt("ffzt");
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
	public ResponseData save(ModelMap model, YjyBgxx entity,
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
	public ResponseData update(YjyBgxx entity, String id) {
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

	// 页面查询条件中查询样品类型下拉框
	// liusong 2016-1-5
	@RequestMapping(value = "/getYplx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getYplx(String zdzl) {
		return service.getDicByLx("cplx");
	}

	// 页面查询条件中查询检验类型下拉框
	// liusong 2016-1-5
	@RequestMapping(value = "/getJylx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getJylx(String zdzl) {
		return service.getDicByLx("jylx");
	}

	// 页面查询条件中查询检验科室下拉框
	// liusong 2016-1-5
	@RequestMapping(value = "/getJyks", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getJyks(String bmbh) {
		return service.getJyks("100250");
	}

	// 页面查询条件中查询检验科室下拉框
	// liusong 2016-1-5
	@RequestMapping(value = "/getGlbm", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getGlbm() {
		return service.getBm();
	}

	// 页面查询条件中查询科室名称下拉框
	// liusong 2016-1-5
	@RequestMapping(value = "/getKsmc", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getKsmc() {
		return service.getKsmc();
	}

	// 页面查询条件中查询产品类型下拉框
	// wangyogn 2016-7-5
	@RequestMapping(value = "/getCplx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getCplx() {
		return service.getCplx();
	}

	// 页面查询条件中查询业务科室下拉框
	// liusong 2016-1-5
	@RequestMapping(value = "/getYwks", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getYwks(String sjbh) {
		return service.getJyks("100230");
	}

	/**
	 * 报告信息的列表
	 * 
	 * @author duanpeijun
	 * @date 2016年1月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bgxx")
	@ResponseBody
	public List<Map<String, Object>> bgxx(HttpServletRequest request,
			HttpServletResponse response) {
		String fenye = request.getParameter("fenye");
		String bgbh = request.getParameter("bgbh");
		String bzr = request.getParameter("bzr");
		String wtdw = request.getParameter("wtdw");
		String sjdw = request.getParameter("sjdw");
		String ypmc = request.getParameter("ypmc");
		String jyrq = request.getParameter("jyrq");
		String jylx = request.getParameter("jylx");
		String jyyj = request.getParameter("jyyj");
		// String jyjsrq = request.getParameter("jyjsrq");
		List<Map<String, Object>> list = service.getBgList(fenye, bgbh, bzr,
				wtdw, sjdw, ypmc, jyrq, jylx, jyyj);
		return list;
	}

	@RequestMapping(value = "/clyy")
	@ResponseBody
	public List<Map<String, Object>> clyy(HttpServletRequest request,
			HttpServletResponse response) {
		String type = request.getParameter("value");
		String num = request.getParameter("value2");
		SysYh yh = AppUtil.getCurrentUser();
		String xm = yh.getXm();
		List<Map<String, Object>> list = service.getClyy(type, num, xm);
		return list;
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
		List<Map<String, Object>> ypxx = jyxxservice.getYp(bgbh);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
		}
		return mav;
	}

	/**
	 * 保存WORD文件
	 * 
	 * @author duanpeijun
	 * @date 2015年11月24日
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/savePage")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		FileSaver fs = new FileSaver(request, response);
		if (fs.getFileExtName().equals(".doc")) {
			System.out.println(request.getSession().getServletContext()
					.getRealPath("resources/doc")
					+ "/" + fs.getFileName());
			fs.saveToFile(request.getSession().getServletContext()
					.getRealPath("resources/doc")
					+ "/" + fs.getFileName());
		} else if (fs.getFileExtName().equals(".pdf")) {
			System.out.println(request.getSession().getServletContext()
					.getRealPath("resources/pdf")
					+ "/" + fs.getFileName());
			fs.saveToFile(request.getSession().getServletContext()
					.getRealPath("resources/pdf")
					+ "/" + fs.getFileName());
		}
		fs.close();
	}

	/**
	 * 打开二维码页面
	 * 
	 * @author liujiansen
	 * @date 2015年11月20日
	 * @return
	 */
	@RequestMapping(value = "/bgxxewm")
	public ModelAndView openBqPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/bgxxewm");
		String bgbh = request.getParameter("bgbh");
		List<Map<String, Object>> list = service.getewmbgxx(bgbh);
		int id = Integer.parseInt(list.get(0).get("id").toString());
		YjyBgxx bgxx = service.getbgxxById(id);
		if (list.size() != 0) {
			String url = bgxx.getEwmbh();
			mav.addObject("url", url);
			mav.addObject("map", list.get(0));
		}
		return mav;
	}

	/**
	 * 保存PDF文件
	 * 
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/savePDF")
	public void savePDF(HttpServletRequest request, HttpServletResponse response) {
		FileSaver fs = new FileSaver(request, response);
		System.out.println(request.getSession().getServletContext()
				.getRealPath("")
				+ "/" + fs.getFileName());
		fs.saveToFile(request.getSession().getServletContext().getRealPath("")
				+ "/" + fs.getFileName());
		fs.close();
	}

	/**
	 * 保存三个封面为pdf
	 * 
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
	@RequestMapping(value = "/saveToThreePdfPage")
	public ModelAndView saveToThreePdfPage(String fileName) {
		ModelAndView modelAndView = new ModelAndView("/bggl/OpenThreePDF");
		if (fileName != null && !"".equals(fileName)) {
			modelAndView.addObject("fileName", fileName);
		}
		return modelAndView;
	}

	/**
	 * 保存word为pdf
	 * 
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
	@RequestMapping(value = "/saveToPdf")
	public ModelAndView saveToPdf(String fileName) {
		ModelAndView modelAndView = new ModelAndView("/bggl/OpenPDF");
		if (fileName != null && !"".equals(fileName)) {
			modelAndView.addObject("fileName", fileName);
		}
		return modelAndView;
	}

	/*********************************** 在流程中，直接编制报告 ******************************************************/
	/**
	 * 保存到报告信息表中
	 * 
	 * @author duanpeijun
	 * @date 2015年12月13日
	 * @param request
	 * @param rztbid
	 *            认证图标ID
	 * @return
	 */
	@RequestMapping(value = "/tijiao")
	@ResponseBody
	public String saveJybz(HttpServletRequest request) {
		String str = "";
		str = service.tijiao(request);
		str = "1";
		return str;
	}

	/**
	 * 保存首页(一般)
	 * 
	 * @author duanpeijun
	 * @date 2016年6月7日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/bcsy")
	@ResponseBody
	public String bcsy(HttpServletRequest request) {
		String str = "";
		str = service.bcsy(request);
		str = "1";
		return str;
	}

	/**
	 * 保存首页(特殊)
	 * 
	 * @author duanpeijun
	 * @date 2016年6月7日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/TSbcsy")
	@ResponseBody
	public String TSbcsy(HttpServletRequest request) {
		String str = "";
		str = service.TSbcsy(request);
		str = "1";
		return str;
	}

	/**
	 * 特殊报告提交
	 * 
	 * @author duanpeijun
	 * @date 2016年5月26日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/tsbgtijiao")
	@ResponseBody
	public String tsbgtijiao(HttpServletRequest request) {
		String str = "";
		str = service.tsbgtijiao(request);
		str = "1";
		return str;
	}

	/**
	 * 报告整合页面，点击确定,跳转到在线编辑WORD页面
	 * 
	 * @author duanpeijun
	 * @date 2015年11月24日
	 * @param request
	 * @param response
	 * @param zhid
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView zaixianbianji(HttpServletRequest request,
			HttpServletResponse response, String fyid, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/bjfy");
		YjyBgmb bgmb = service.getbgmbList(fyid);
		String sub = bgmb.getSub();
		if (sub != null) {
			mav.addObject("sub", sub);
		}
		request.setAttribute("bgbh", bgbh);
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }else{
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }
		// }else{
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }
		return mav;
	}

	/**
	 * 编辑附页————打开附页另存文件
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/fylc")
	public ModelAndView fylc(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/fylc");
		request.setAttribute("bgbh", bgbh);
		SysYh yh = AppUtil.getCurrentUser();
		String xm = yh.getXm();
		request.setAttribute("xm", xm);
		return mav;
	}

	/**
	 * 编辑特殊报告
	 * 
	 * @author duanpeijun
	 * @date 2016年5月24日
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/tsbg")
	public ModelAndView tsbg(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/tsbg");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx); // 报审对象
		}
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		return mav;
	}

	/**
	 * 复制报告--打开复制报告附页
	 * 
	 * @author duanpeijun
	 * @date 2016年1月14日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @param bg
	 * @return
	 */
	@RequestMapping(value = "/fzfy")
	public ModelAndView fzfy(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String bg) {
		ModelAndView mav = new ModelAndView("/bggl/fzfy");
		request.setAttribute("bgbh", bgbh);
		request.setAttribute("bg", bg);
		return mav;
	}

	/**
	 * 解锁————附页另存
	 * 
	 * @author duanpeijun
	 * @date 2015年12月29日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/jsfylc")
	public ModelAndView jsfylc(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/bgjs/jsfylc");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	/**
	 * 编制报告查看
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/bzbgck")
	public ModelAndView bzbgck(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/bzbgck");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
		}
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		mav.addObject("bgbh", bgbh);
		return mav;
	}

	/**
	 * 编制报告修改查看
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/bzbgxgck")
	public ModelAndView bzbgxgck(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/bzbgxgck");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
		}
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		mav.addObject("bgbh", bgbh);
		return mav;
	}

	/**
	 * 审核报告查看
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/shbgck")
	public ModelAndView shbgck(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar,
			String pzr) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/shbgck");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
		}
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx);
			String bztsbg = bgxx.getBz();
			mav.addObject("bztsbg", bztsbg);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		mav.addObject("bgbh", bgbh);
		if (pzr != null && !"".equals(pzr)) {
			String pzr2 = new String(pzr.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("pzr", pzr2);
		}
		return mav;
	}

	/**
	 * 批准报告查看
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/pzbgck")
	public ModelAndView pzbgck(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/pzbgck");
		request.setAttribute("bgbh", bgbh);
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0 ){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
		}
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx);
			String bztsbg = bgxx.getBz();
			mav.addObject("bztsbg", bztsbg);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		mav.addObject("bgbh", bgbh);
		return mav;
	}

	/**
	 * 审核人员点击提交检验报告
	 * 
	 * @author duanpeijun
	 * @date 2016年1月6日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/sh")
	@ResponseBody
	public ModelAndView sh(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/sh");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	/**
	 * 批准人员点击提交检验报告
	 * 
	 * @author duanpeijun
	 * @date 2016年1月7日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/pz")
	@ResponseBody
	public ModelAndView pz(HttpServletRequest request, String bgbh, String key) {
		ModelAndView mav = new ModelAndView("/bggl/pz");
		request.setAttribute("bgbh", bgbh);
		request.setAttribute("key", key);
		return mav;
	}

	/**
	 * 报告审核时，添加审核人的电子签名
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param bgbh
	 * @param taskId
	 * @param businessKey
	 * @return
	 */
	@RequestMapping(value = "/shr")
	@ResponseBody
	public ModelAndView shr(HttpServletRequest request, String bgbh, String key) {
		ModelAndView mav = new ModelAndView("/bggl/sysh");
		request.setAttribute("bgbh", bgbh);
		SysYh yh = AppUtil.getCurrentUser();
		String shr = yh.getYhjs();
		mav.addObject("shr", shr);
		// 主检人
		List<Map<String, Object>> zjrList = service.getZjr(key);
		if (zjrList.size() != 0) {
			String shrxm = zjrList.get(0).get("shr").toString();
			List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
			if (shrtpList.size() != 0) {
				String zjr = shrtpList.get(0).get("yhjs").toString();
				mav.addObject("zjr", zjr);
			}
		}
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if(b.size() != 0){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		return mav;
	}

	/**
	 * 在微信端审核没有审核人签名，在电脑端批准时加上其电子签名
	 * 
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param request
	 * @param bgbh
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/shrtoo")
	@ResponseBody
	public ModelAndView shrtoo(HttpServletRequest request, String bgbh,
			String key) {
		ModelAndView mav = new ModelAndView("/bggl/sysh");
		request.setAttribute("bgbh", bgbh);
		// 审核人
		List<Map<String, Object>> shrList = service.getShr(key);
		if (shrList.size() != 0) {
			String shrxm = shrList.get(0).get("shr").toString();
			List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
			if (shrtpList.size() != 0) {
				String shr = shrtpList.get(0).get("yhjs").toString();
				mav.addObject("shr", shr);
			}
		}
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if(b.size() != 0){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		return mav;
	}

	/**
	 * 报告批准时，添加批准人的电子签名
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param bgbh
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/pzr")
	@ResponseBody
	public ModelAndView pzr(HttpServletRequest request, String bgbh, String key,String pzr) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/sypz");
		request.setAttribute("bgbh", bgbh);
		// 批准人
//		SysYh yh = AppUtil.getCurrentUser();
//		String pzr = yh.getYhjs();
		if (pzr != null && !"".equals(pzr)) {
			String pzr2 = new String(pzr.getBytes("ISO-8859-1"), "UTF-8");
			List<Map<String, Object>> pzrtpList = service.getShrtp(pzr2);
			if (pzrtpList.size() != 0) {
				if (pzrtpList.get(0).get("yhjs") != null) {
					String pzr3 = pzrtpList.get(0).get("yhjs").toString();
					mav.addObject("pzr", pzr3);
				}
			}
		}
		// 检验日期
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		mav.addObject("year", year);
		int month = c.get(Calendar.MONTH);
		int mon = month + 1;
		mav.addObject("mon", mon);
		int date = c.get(Calendar.DATE);
		mav.addObject("date", date);

		// 主检人
		List<Map<String, Object>> zjrList = service.getZjr(key);
		if (zjrList.size() != 0) {
			String shrxm = zjrList.get(0).get("shr").toString();
			List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
			if (shrtpList.size() != 0) {
				if (shrtpList.get(0).get("yhjs") != null) {
					String zjr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("zjr", zjr);
				}
			}
		}
		// 审核人
		List<Map<String, Object>> shrList = service.getShr(key);
		if (shrList.size() != 0) {
			String shrxm = shrList.get(0).get("shr").toString();
			List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
			if (shrtpList.size() != 0) {
				if (shrtpList.get(0).get("yhjs") != null) {
					String shr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("shr", shr);
				}
			}
		}

		List<Map<String, Object>> b = service.getbgxxList(bgbh);
		if (b.size() != 0) {
			int bgid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String pzz = bgxx.getYzmctp();
			mav.addObject("pzz", pzz);
		}
		return mav;
	}

	/**
	 * 报告批准环节，为防止sypz没有生成，所以加判断（保证sypz必须生成）
	 * @author duanpeijun
	 * @date 2016年7月20日
	 * @param request
	 * @param bgbh
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/pzrtwo")
	@ResponseBody
	public ModelAndView pzrtwo(HttpServletRequest request, String bgbh, String key){
		ModelAndView mav = new ModelAndView("/bggl/sypz");
		request.setAttribute("bgbh", bgbh);
		// 批准人
		SysYh yh = AppUtil.getCurrentUser();
		String pzr = yh.getYhjs();
		mav.addObject("pzr", pzr);
		// 检验日期
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		mav.addObject("year", year);
		int month = c.get(Calendar.MONTH);
		int mon = month + 1;
		mav.addObject("mon", mon);
		int date = c.get(Calendar.DATE);
		mav.addObject("date", date);

		// 主检人
		List<Map<String, Object>> zjrList = service.getZjr(key);
		if (zjrList.size() != 0) {
			String shrxm = zjrList.get(0).get("shr").toString();
			List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
			if (shrtpList.size() != 0) {
				if (shrtpList.get(0).get("yhjs") != null) {
					String zjr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("zjr", zjr);
				}
			}
		}
		// 审核人
		List<Map<String, Object>> shrList = service.getShr(key);
		if (shrList.size() != 0) {
			String shrxm = shrList.get(0).get("shr").toString();
			List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
			if (shrtpList.size() != 0) {
				if (shrtpList.get(0).get("yhjs") != null) {
					String shr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("shr", shr);
				}
			}
		}

		List<Map<String, Object>> b = service.getbgxxList(bgbh);
		if (b.size() != 0) {
			int bgid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String pzz = bgxx.getYzmctp();
			mav.addObject("pzz", pzz);
		}
		return mav;
	}

	/**
	 * 点击报告生成，后台自动另存一份完成的报告
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/bgcc")
	public ModelAndView bgcc(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/bgcc");
		request.setAttribute("bgbh", bgbh);
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0 ){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				mav.addObject("fl", fl);
			}
		}
		return mav;
	}

	/**
	 * 批准的报告需要在此方法下生成完整报告 fm.doc+sypz.doc+fy.doc
	 * 
	 * @author duanpeijun
	 * @date 2016年4月21日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/bgcctwo")
	@ResponseBody
	public ModelAndView bgcctwo(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/bgcctwo");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				mav.addObject("fl", fl);
			}
		}
		return mav;
	}

	/**
	 * 生成报告封面和首页以及报告模版
	 * 
	 * @author duanpeijun
	 * @date 2016年1月13日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/ccfmsy")
	@ResponseBody
	public ModelAndView ccfmsy(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/ccfmsy");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	/**
	 * 生成报告封面和首页
	 * 
	 * @author duanpeijun
	 * @date 2016年5月4日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/fmsy")
	@ResponseBody
	public ModelAndView fmsy(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/fmsy");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	@RequestMapping(value = "/ybbg")
	@ResponseBody
	public ModelAndView ybbg(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView();
		String url = "";
		request.setAttribute("bgbh", bgbh);
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		/** 获取页数 */
		WordExtractor doc;
		try {
			doc = new WordExtractor(new FileInputStream(request.getSession()
					.getServletContext().getRealPath("resources/doc")
					+ "/" + bgbh + "fy.doc"));
			int pages = doc.getSummaryInformation().getPageCount() + 1;// 总页数
			request.setAttribute("pages", pages);
			System.out.println("页数预览报告————————————————————————————>" + pages);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				if ("0".equals(fl) || "4".equals(fl) || "6".equals(fl)) {
					url = "/bggl/bgmb/ybbg"; // 安徽省产品质量监督检验研究院检验报告附页
				} else if ("1".equals(fl)) {
					url = "/bggl/bgmb/gpbg"; // 国家排灌及节水设备产品质量监督检验中心检验报告附页
				} else if ("2".equals(fl) || "5".equals(fl)) {
					url = "/bggl/bgmb/gjbg"; // 国家建筑节能产品质量监督检验中心检验报告附页
				}
			}
		}
		mav.setViewName(url);
		return mav;
	}

	/**
	 * 自定义报告单独生成附页的模版
	 * 
	 * @author duanpeijun
	 * @date 2016年3月2日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/ybbgfy")
	@ResponseBody
	public ModelAndView ybbgfy(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView();
		String url = "";
		request.setAttribute("bgbh", bgbh);
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		WordExtractor doc;
		try {
			doc = new WordExtractor(new FileInputStream(request.getSession()
					.getServletContext().getRealPath("resources/doc")
					+ "/" + bgbh + "fy.doc"));
			int pages = doc.getSummaryInformation().getPageCount() + 1;// 总页数
			request.setAttribute("pages", pages);
			System.out.println("页数预览报告————————————————————————————>" + pages);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				if ("0".equals(fl) || "4".equals(fl) || "6".equals(fl)) {
					url = "/bggl/bgmb/ybbgfy"; // 安徽省产品质量监督检验研究院检验报告附页
				} else if ("1".equals(fl)) {
					url = "/bggl/bgmb/gpbgfy"; // 国家排灌及节水设备产品质量监督检验中心检验报告附页
				} else if ("2".equals(fl) || "5".equals(fl)) {
					url = "/bggl/bgmb/gjbgfy"; // 国家建筑节能产品质量监督检验中心检验报告附页
				}
			}
		}
		mav.setViewName(url);
		return mav;
	}

	/**
	 * 自定义报告生成封面&附页或者首页&附页的模版
	 * 
	 * @author duanpeijun
	 * @date 2016年3月2日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/ybbgfsfy")
	@ResponseBody
	public ModelAndView ybbgfsfy(HttpServletRequest request, String bgbh) {
		ModelAndView mav = new ModelAndView();
		String url = "";
		request.setAttribute("bgbh", bgbh);
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		WordExtractor doc;
		try {
			doc = new WordExtractor(new FileInputStream(request.getSession()
					.getServletContext().getRealPath("resources/doc")
					+ "/" + bgbh + "fy.doc"));
			int pages = doc.getSummaryInformation().getPageCount() + 1;// 总页数
			request.setAttribute("pages", pages);
			System.out.println("页数预览报告————————————————————————————>" + pages);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				if ("0".equals(fl) || "4".equals(fl) || "6".equals(fl)) {
					url = "/bggl/bgmb/ybbgfsfy"; // 安徽省产品质量监督检验研究院检验报告附页
				} else if ("1".equals(fl)) {
					url = "/bggl/bgmb/gpbgfsfy"; // 国家排灌及节水设备产品质量监督检验中心检验报告附页
				} else if ("2".equals(fl) || "5".equals(fl)) {
					url = "/bggl/bgmb/gjbgfsfy"; // 国家建筑节能产品质量监督检验中心检验报告附页
				}
			}
		}
		mav.setViewName(url);
		return mav;
	}

	/**
	 * 接收人员预览报告
	 * 
	 * @author duanpeijun
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/jsbgck")
	public ModelAndView bgck(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/jsbgck");
		request.setAttribute("bgbh", bgbh);
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0 ){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		return mav;
	}

	/**
	 * 查看原始记录
	 * 
	 * @author liusong
	 * @date 2016年1月4日
	 * @param request
	 * @param response
	 * @param ysjlwjm
	 *            ,bz
	 * @return
	 */
	@RequestMapping(value = "/ysjlck")
	public ModelAndView ysjl(HttpServletRequest request,
			HttpServletResponse response, String ysjlwjm, String bz) {
		String url = null;
		if (bz.equals("2")) {
			url = "/bggl/ysjldocOnLine";
		}
		if (bz.equals("3")) {
			url = "/bggl/ysjlpdfOnLine";
		}
		if (bz.equals("1")) {
			url = "/bggl/ysjltpOnLine";
		}
		ModelAndView modelAndView = new ModelAndView(url);
		if (ysjlwjm != null) {
			modelAndView.addObject("ysjlwjm", ysjlwjm);
		}
		return modelAndView;
	}

	/**
	 * 生成Word文档
	 * 
	 * @author duanpeijun
	 * @date 2015年11月26日
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/ylbg")
	public ModelAndView hbWord(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar)
			throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("/bggl/ylbg");
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0 ){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				mav.addObject("fl", fl);
			}
		}
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		return mav;
	}

	/**
	 * 封面的预览
	 * 
	 * @author duanpeijun
	 * @date 2015年11月27日
	 * @param request
	 * @param response
	 * @param zhid
	 * @return
	 */
	@RequestMapping(value = "/fengmian")
	public ModelAndView fmian(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/fmyl");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if (d.size() != 0) {
			int zhid = Integer.parseInt(d.get(0).get("id").toString());
			YjyBgzh bgzh = service.getbgzhById(zhid);
			String sub = bgzh.getFmdz();
			if (sub != null) {
				mav.addObject("sub", sub);
			}
		}
		List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
		if (a.size() != 0) {
			int id = Integer.parseInt(a.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(id);
			String ypmc = ypxx.getYpmc();
			String scdw = ypxx.getScdw();
			String sjdw = ypxx.getSjdw();
			String jylx = ypxx.getJylx();
			String wtdw = ypxx.getWtdw();
			request.setAttribute("ypmc", ypmc);
			request.setAttribute("sjdw", sjdw);
			request.setAttribute("jylx", jylx);
			request.setAttribute("scdw", scdw);
			request.setAttribute("wtdw", wtdw);
			// 建工中心（院）
			String gcmc = ypxx.getGcmc();
			request.setAttribute("gcmc", gcmc);
			String jsdw = ypxx.getJsdw();
			request.setAttribute("jsdw", jsdw);
			String sgdw = ypxx.getSgdw();
			request.setAttribute("sgdw", sgdw);
		}
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		List<Map<String, Object>> b = service.getbgxxList(bgbh);
		if (b.size() != 0) {
			int bgid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			// Integer sfjs = bgxx.getSfjs();
			// if(sfjs == 0){
			// String gai = "0";
			// mav.addObject("gai", gai);
			// }else if(sfjs == 1){
			// String gai = "1";
			// mav.addObject("gai", gai);
			// }
			String dwmctp = bgxx.getDwmctp();
			mav.addObject("dwmctp", dwmctp);
			String rzfs1 = bgxx.getRzfs();
			if (rzfs1 != null && !"".equals(rzfs1)) {
				String[] rztbid = rzfs1.split(",");
				for (int i = 0; i < rztbid.length; i++) {
					YjyRztb rztb = service.getrztbById(Integer
							.parseInt(rztbid[i]));
					switch (i) {
					case 0:
						String rztbdz1 = rztb.getSub();
						mav.addObject("rztbdz1", rztbdz1);
						break;
					case 1:
						String rztbdz2 = rztb.getSub();
						mav.addObject("rztbdz2", rztbdz2);
						break;
					case 2:
						String rztbdz3 = rztb.getSub();
						mav.addObject("rztbdz3", rztbdz3);
						break;
					case 3:
						String rztbdz4 = rztb.getSub();
						mav.addObject("rztbdz4", rztbdz4);
						break;
					}
				}
			}
		}
		return mav;
	}

	/**
	 * 首页的预览
	 * 
	 * @author duanpeijun
	 * @date 2015年11月27日
	 * @param request
	 * @param response
	 * @param zhid
	 * @return
	 */
	@RequestMapping(value = "/shouye")
	public ModelAndView shouye(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/syyl");
		request.setAttribute("bgbh", bgbh);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if (d.size() != 0) {
			int zhid = Integer.parseInt(d.get(0).get("id").toString());
			YjyBgzh bgzh = service.getbgzhById(zhid);
			String sub = bgzh.getSydz();
			if (sub != null) {
				mav.addObject("sub", sub);
			}
		}
		SysYh yh = AppUtil.getCurrentUser();
		String zjr = yh.getYhjs();
		mav.addObject("zjr", zjr);
		List<Map<String, Object>> b = service.getbgxxList(bgbh);
		if (b.size() != 0) {
			int bgxxid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgxxid);
			String cydw = bgxx.getCydw();
			request.setAttribute("cydw", cydw);
			String jyqksm = bgxx.getJyqksm();
			request.setAttribute("jyqksm", jyqksm);
			String jyrq = bgxx.getJyrq();
			request.setAttribute("jyrq", jyrq);
			// Date jyrq1 = bgxx.getJyrq();
			// if(jyrq1 != null){
			// String jyrq = sdf.format(jyrq1);
			// request.setAttribute("jyrq", jyrq);
			// }
			// Date jyjsrq1 = bgxx.getJyjsrq();
			// if(jyjsrq1 != null){
			// String jyjsrq = sdf.format(jyjsrq1);
			// request.setAttribute("jyjsrq", jyjsrq);
			// }
			String jyjl = bgxx.getJyjl();
			request.setAttribute("jyjl", jyjl);
			// Integer sfjs = bgxx.getSfjs();
			// if(sfjs == 0){
			// String gai = "0";
			// mav.addObject("gai", gai);
			// }else if(sfjs == 1){
			// String gai = "1";
			// mav.addObject("gai", gai);
			// }
		}
		/** 获取页数 */
		WordExtractor doc;
		try {
			doc = new WordExtractor(new FileInputStream(request.getSession()
					.getServletContext().getRealPath("resources/doc")
					+ "/" + bgbh + "fy.doc"));
			int pages = doc.getSummaryInformation().getPageCount() + 1;// 总页数
			System.out.println("页数————————————————————————————>" + pages);
			request.setAttribute("pages", pages);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
		if (a.size() != 0) {
			int id = Integer.parseInt(a.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(id);
			String ypmc = ypxx.getYpmc();
			request.setAttribute("ypmc", ypmc);
			String cpmc = ypxx.getCpmc();
			request.setAttribute("cpmc", cpmc);
			String sjdw = ypxx.getSjdw();
			request.setAttribute("sjdw", sjdw);
			String scdw = ypxx.getScdw();
			request.setAttribute("scdw", scdw);
			String cydd = ypxx.getCydd();
			request.setAttribute("cydd", cydd);
			String ypsl = ypxx.getYpsl();
			request.setAttribute("ypsl", ypsl);
			String cyjs = ypxx.getCyjs();
			request.setAttribute("cyjs", cyjs);
			String ypzt = ypxx.getYpzt();
			request.setAttribute("ypzt", ypzt);
			String wtdw = ypxx.getWtdw();
			request.setAttribute("wtdw", wtdw);
			String cyry = ypxx.getCyry();
			request.setAttribute("cyry", cyry);
			String ggxh = ypxx.getGgxh();
			request.setAttribute("ggxh", ggxh);
			String jylx = ypxx.getJylx();
			request.setAttribute("jylx", jylx);
			String ypdj = ypxx.getYpdj();
			request.setAttribute("ypdj", ypdj);
			Date dyrq1 = ypxx.getDyrq();
			if (dyrq1 != null) {
				String dyrq = sdf.format(dyrq1);
				request.setAttribute("dyrq", dyrq);
			}
			Date cyrq1 = ypxx.getCyrq();
			if (cyrq1 != null) {
				String cyrq = sdf.format(cyrq1);
				request.setAttribute("cyrq", cyrq);
			}
			String jyxm = ypxx.getJyxm();
			request.setAttribute("jyxm", jyxm);
			String scrqpc = ypxx.getScrqpc();
			request.setAttribute("scrqpc", scrqpc);
			String jcfyry = ypxx.getJcfyry();
			request.setAttribute("jcfyry", jcfyry);
			String jyyj = ypxx.getJyyj();
			request.setAttribute("jyyj", jyyj);
			String sb = ypxx.getSb();
			request.setAttribute("sb", sb);
			String wtdwdz = ypxx.getWtdwdz();
			request.setAttribute("wtdwdz", wtdwdz);
			String bz = ypxx.getBz();
			request.setAttribute("bz", bz);
			String sgdw = ypxx.getSgdw();
			request.setAttribute("sgdw", sgdw);
			String jldw = ypxx.getJldw();
			request.setAttribute("jldw", jldw);
			String jlr = ypxx.getJlr();
			request.setAttribute("jlr", jlr);
			String jzdw = ypxx.getJzdw();
			request.setAttribute("jzdw", jzdw);
			String jzr = ypxx.getJzr();
			request.setAttribute("jzr", jzr);
			String gcmc = ypxx.getGcmc();
			request.setAttribute("gcmc", gcmc);
			String gcdz = ypxx.getGcdz();
			request.setAttribute("gcdz", gcdz);
			String gcsjdw = ypxx.getGcsjdw();
			request.setAttribute("gcsjdw", gcsjdw);
			String jsdw = ypxx.getJsdw();
			request.setAttribute("jsdw", jsdw);
			String dh = ypxx.getDh();
			request.setAttribute("dh", dh);
			String scdwdh = ypxx.getScdwdh();
			request.setAttribute("scdwdh", scdwdh);
			String cydbh = ypxx.getCydbh();
			request.setAttribute("cydbh", cydbh);
			String rwly = ypxx.getRwly();
			List<Map<String, Object>> rwlylist = ypxxservice
					.getDicByJylx("rwly");
			if (rwly != null) {
				for (int i = 0; i < rwlylist.size(); i++) {
					System.out.println("-----------1-------->"
							+ rwlylist.get(i).get("ZDZ"));
					if (rwlylist.get(i).get("ZDZ").toString().equals(rwly)) {
						request.setAttribute("rwly", rwlylist.get(i)
								.get("ZDMC"));
					}
				}
			}
			Integer lyfs = ypxx.getLyfs();
			List<Map<String, Object>> lyfslist = ypxxservice
					.getDicByJylx("lyfs");
			if (lyfs != null) {
				for (int i = 0; i < lyfslist.size(); i++) {
					// System.out.println("-----------1-------->"+lyfslist.get(i).get("ZDZ"));
					// System.out.println("----------2--------->"+lyfslist.get(i).get("zdz"));
					if (Integer.parseInt(lyfslist.get(i).get("ZDZ").toString()) == lyfs) {
						request.setAttribute("zdmc", lyfslist.get(i)
								.get("ZDMC"));
					}
				}
			}
		}
		return mav;
	}

	/**
	 * 报告延期
	 * 
	 * @author liujiansen
	 * @date 2015年12月19日
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/saveYqjl")
	@ResponseBody
	public ResponseData saveYqjl(YbgYqjl entity, HttpServletRequest request,
			HttpServletResponse response) {
		SysYh user = AppUtil.getCurrentUser();
		entity.setXgr(user.getYhbh().toString());
		entity.setXgsj(new Date());
		service.saveYqjl(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 获取延期记录列表
	 * 
	 * @author liujiansen
	 * @date 2015年12月19日
	 * @param start
	 * @param limit
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/getYqjlList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYqjlList(Integer start,
			Integer limit, String bgbh) {
		return service.getYqjlList(start, limit, bgbh);
	}

	/**
	 * 查询报审对象字段的人员列表（根据"报告审核角色和本部门的人员列表"）
	 * 
	 * @author duanpeijun
	 * @date 2015年12月18日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getbsdx")
	@ResponseBody
	public List<Map<String, Object>> getbsdx(HttpServletRequest request,
			HttpServletResponse response, String bmbh) {
		List<Map<String, Object>> list = service.getbsdx(bmbh);
		return list;
	}

	/**
	 * 单次打印页面
	 * 
	 * @author duanpeijun
	 * @date 2016年3月2日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/dcdyym")
	public ModelAndView dcdyym(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/bggl/bgdcdy/dcdyym");
		modelAndView.addObject("bgbh", request.getParameter("bgbh"));
		return modelAndView;
	}

	/**
	 * 自定义报告
	 * 
	 * @author duanpeijun
	 * @date 2016年3月2日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/zdybg")
	public ModelAndView zdybg(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView();
		String url = "";
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0 ){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		String ymids = request.getParameter("ymids");
		if ("1".equalsIgnoreCase(ymids) || "2".equalsIgnoreCase(ymids)
				|| "1,4".equalsIgnoreCase(ymids)
				|| "1,5".equalsIgnoreCase(ymids)
				|| "1,4,5".equalsIgnoreCase(ymids)) {
			url = "/bggl/bgzdydy/onedy"; // 单独打印封面 或者 单独打印首页
		} else if ("3".equalsIgnoreCase(ymids)) {
			url = "/bggl/bgzdydy/fydy"; // 单独打印附页
			List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
			if (yp.size() != 0) {
				int ypid = Integer.parseInt(yp.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
				String zh = ypxx.getZh();
				String djlx = ypxx.getDjlx().toString();
				List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
				if (abc.size() != 0) {
					String fl = abc.get(0).get("zhfl").toString();
					mav.addObject("fl", fl);
				}
			}
		} else if ("1,2".equalsIgnoreCase(ymids)
				|| "1,2,4".equalsIgnoreCase(ymids)
				|| "1,2,5".equalsIgnoreCase(ymids)
				|| "1,2,4,5".equalsIgnoreCase(ymids)) {
			url = "/bggl/bgzdydy/fsdy"; // 封面&首页 打印
		} else if ("1,3".equalsIgnoreCase(ymids)
				|| "2,3".equalsIgnoreCase(ymids)
				|| "1,3,4".equalsIgnoreCase(ymids)
				|| "1,3,5".equalsIgnoreCase(ymids)
				|| "1,3,4,5".equalsIgnoreCase(ymids)) {
			url = "/bggl/bgzdydy/fsfdy"; // 封面&附页 首页&附页 打印
			List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
			if (yp.size() != 0) {
				int ypid = Integer.parseInt(yp.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
				String zh = ypxx.getZh();
				String djlx = ypxx.getDjlx().toString();
				List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
				if (abc.size() != 0) {
					String fl = abc.get(0).get("zhfl").toString();
					mav.addObject("fl", fl);
				}
			}
		} else if ("1,2,3".equalsIgnoreCase(ymids)
				|| "1,2,3,4".equalsIgnoreCase(ymids)
				|| "1,2,3,5".equalsIgnoreCase(ymids)
				|| "1,2,3,4,5".equalsIgnoreCase(ymids)) {
			url = "/bggl/bgzdydy/threedy"; // 封面&首页&附页 打印
			List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
			if (yp.size() != 0) {
				int ypid = Integer.parseInt(yp.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
				String zh = ypxx.getZh();
				String djlx = ypxx.getDjlx().toString();
				List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
				if (abc.size() != 0) {
					String fl = abc.get(0).get("zhfl").toString();
					mav.addObject("fl", fl);
				}
			}
		}
		request.setAttribute("ymids", ymids);
		mav.setViewName(url);
		return mav;
	}

	/**
	 * 在线打开Word
	 * 
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
	@RequestMapping(value = "/wordOnLine")
	public ModelAndView openPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/bggl/Word");
		modelAndView.addObject("bgbh", request.getParameter("bgbh"));
		String bgbh = request.getParameter("bgbh");
		modelAndView.addObject("fileName", request.getParameter("bgbh")
				+ ".doc");
		List<Map<String, Object>> b = service.getbgxxList(bgbh);
		if (b.size() != 0) {
			int bgid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bztsbg = bgxx.getBz();
			modelAndView.addObject("bztsbg", bztsbg);
		}
		return modelAndView;
	}

	/**
	 * 更新报告信息次数
	 * 
	 * @author liujiansen
	 * @date 2015年12月19日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateDycs")
	@ResponseBody
	public ResponseData updateDycs(HttpServletRequest request,
			HttpServletResponse response) {
		String bgbh = request.getParameter("bgbh");
		service.updateDycs(bgbh);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 重新生成报告（另存为）
	 * 
	 * @author duanpeijun
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @param filename
	 */
	@RequestMapping(value = "/savePageTest")
	@ResponseBody
	public void savePageTest(HttpServletRequest request,
			HttpServletResponse response, String filename) {
		FileSaver fs = new FileSaver(request, response);
		System.out.println(filename + "---------------------------");
		String err = "";
		if (filename != null && filename.length() > 0) {
			String fileName = "\\" + filename + fs.getFileExtName();
			fs.saveToFile(request.getSession().getServletContext()
					.getRealPath("/resources/doc")
					+ fileName);
		} else {
			err = "<script>alert('未获得文件名称');</script>";
		}
		fs.close();
	}

	/**
	 * 附页的另存为
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @param filename
	 */
	@RequestMapping(value = "/saveFyPage")
	@ResponseBody
	public void saveFyPage(HttpServletRequest request,
			HttpServletResponse response, String filename) {
		FileSaver fs = new FileSaver(request, response);
		System.out.println(filename + "---------------------------");
		String err = "";
		if (filename != null && filename.length() > 0) {
			String fileName = "\\" + filename + fs.getFileExtName();
			fs.saveToFile(request.getSession().getServletContext()
					.getRealPath("/resources/fylc")
					+ fileName);
		} else {
			err = "<script>alert('未获得文件名称');</script>";
		}
		fs.close();
	}

	/**
	 * 点击打开报告解锁的JSP页面
	 * 
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/Bgjs")
	public ModelAndView Bgjs(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/bggl/bgjs");
		String id = request.getParameter("id");
		List<Map<String, Object>> bgxx = service.getBgxx(Integer.parseInt(id));
		if (bgxx.size() != 0) {
			modelAndView.addObject("bgxx", bgxx);
			YjyBgxx bg = service.get(Integer.parseInt(bgxx.get(0).get("id")
					.toString()));
			List<Map<String, Object>> ypxx = ypxxservice
					.getYpByBh(bg.getBgbh());
			modelAndView.addObject("ypxx", ypxx.get(0));
		}
		return modelAndView;
	}

	/**
	 * 自定义报告打印页面
	 * 
	 * @author duanpeijun
	 * @date 2016年3月1日
	 * @return
	 */
	@RequestMapping(value = "/dyym")
	public ModelAndView dyym(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/bgzdydy/dyym");
		String bgbh = request.getParameter("bgbh");
		mav.addObject("bgbh", bgbh);
		return mav;
	}

	/**
	 * 自定义报告打印窗口
	 * 
	 * @author duanpeijun
	 * @date 2016年3月2日
	 * @return
	 */
	@RequestMapping(value = "/dyck")
	public ModelAndView dyck(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/bgzdydy/dyck");
		String bgbh = request.getParameter("bgbh");
		String ymids = request.getParameter("ymids");
		request.setAttribute("bgbh", bgbh);
		request.setAttribute("ymids", ymids);
		return mav;
	}

	/**
	 * 报告单次打印窗口
	 * 
	 * @author duanpeijun
	 * @date 2016年3月3日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/dcck")
	public ModelAndView dcck(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/bgdcdy/dcck");
		String bgbh = request.getParameter("bgbh");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	/**
	 * 自定义报告打印
	 * 
	 * @author duanpeijun
	 * @date 2016年3月1日
	 * @return
	 */
	@RequestMapping(value = "/zdydy")
	public ModelAndView zdydy(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String bgbh = request.getParameter("bgbh");
		String url = "";
		String ymids = request.getParameter("ymids");
		if ("1".equalsIgnoreCase(ymids) || "1,2".equalsIgnoreCase(ymids)
				|| "1,3".equalsIgnoreCase(ymids)
				|| "1,2,3".equalsIgnoreCase(ymids)) {
			url = "/bggl/bgzdydy/fmzdy";
			request.setAttribute("bgbh", bgbh);
			List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
			if (d.size() != 0) {
				int zhid = Integer.parseInt(d.get(0).get("id").toString());
				YjyBgzh bgzh = service.getbgzhById(zhid);
				String sub = bgzh.getFmdz();
				if (sub != null) {
					mav.addObject("sub", sub);
				}
			}
			List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
			if (a.size() != 0) {
				int id = Integer.parseInt(a.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(id);
				String ypmc = ypxx.getYpmc();
				String scdw = ypxx.getScdw();
				String sjdw = ypxx.getSjdw();
				String jylx = ypxx.getJylx();
				String wtdw = ypxx.getWtdw();
				request.setAttribute("ypmc", ypmc);
				request.setAttribute("sjdw", sjdw);
				request.setAttribute("jylx", jylx);
				request.setAttribute("scdw", scdw);
				request.setAttribute("wtdw", wtdw);
				// 建工中心（院）
				String gcmc = ypxx.getGcmc();
				request.setAttribute("gcmc", gcmc);
				String jsdw = ypxx.getJsdw();
				request.setAttribute("jsdw", jsdw);
				String sgdw = ypxx.getSgdw();
				request.setAttribute("sgdw", sgdw);
			}
			String nf = bgbh.substring(2, 4);
			request.setAttribute("nf", nf);
			String z = bgbh.substring(4, bgbh.length() - 5);
			request.setAttribute("z", z);
			String h = bgbh.substring(bgbh.length() - 5);
			request.setAttribute("h", h);
			// List<Map<String, Object>> b = service.getbgxxList(bgbh);
			// if (b.size() != 0) {
			// int bgid = Integer.parseInt(b.get(0).get("id").toString());
			// YjyBgxx bgxx = service.getbgxxById(bgid);
			// Integer sfjs = bgxx.getSfjs();
			// if (sfjs == 0) {
			// String gai = "0";
			// mav.addObject("gai", gai);
			// } else if (sfjs == 1) {
			// String gai = "1";
			// mav.addObject("gai", gai);
			// }
			// }
		} else if ("1,4".equalsIgnoreCase(ymids)
				|| "1,2,4".equalsIgnoreCase(ymids)
				|| "1,3,4".equalsIgnoreCase(ymids)
				|| "1,2,3,4".equalsIgnoreCase(ymids)) { // 认证章
			url = "/bggl/bgzdydy/fmzdy";
			request.setAttribute("bgbh", bgbh);
			List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
			if (d.size() != 0) {
				int zhid = Integer.parseInt(d.get(0).get("id").toString());
				YjyBgzh bgzh = service.getbgzhById(zhid);
				String sub = bgzh.getFmdz();
				if (sub != null) {
					mav.addObject("sub", sub);
				}
			}
			List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
			if (a.size() != 0) {
				int id = Integer.parseInt(a.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(id);
				String ypmc = ypxx.getYpmc();
				String scdw = ypxx.getScdw();
				String sjdw = ypxx.getSjdw();
				String jylx = ypxx.getJylx();
				String wtdw = ypxx.getWtdw();
				request.setAttribute("ypmc", ypmc);
				request.setAttribute("sjdw", sjdw);
				request.setAttribute("jylx", jylx);
				request.setAttribute("scdw", scdw);
				request.setAttribute("wtdw", wtdw);
				// 建工中心（院）
				String gcmc = ypxx.getGcmc();
				request.setAttribute("gcmc", gcmc);
				String jsdw = ypxx.getJsdw();
				request.setAttribute("jsdw", jsdw);
				String sgdw = ypxx.getSgdw();
				request.setAttribute("sgdw", sgdw);
			}
			String nf = bgbh.substring(2, 4);
			request.setAttribute("nf", nf);
			String z = bgbh.substring(4, bgbh.length() - 5);
			request.setAttribute("z", z);
			String h = bgbh.substring(bgbh.length() - 5);
			request.setAttribute("h", h);
			List<Map<String, Object>> b = service.getbgxxList(bgbh);
			if (b.size() != 0) {
				int bgid = Integer.parseInt(b.get(0).get("id").toString());
				YjyBgxx bgxx = service.getbgxxById(bgid);
				// Integer sfjs = bgxx.getSfjs();
				// if (sfjs == 0) {
				// String gai = "0";
				// mav.addObject("gai", gai);
				// } else if (sfjs == 1) {
				// String gai = "1";
				// mav.addObject("gai", gai);
				// }
				String rzfs1 = bgxx.getRzfs();
				String[] rztbid = rzfs1.split(",");
				for (int i = 0; i < rztbid.length; i++) {
					YjyRztb rztb = service.getrztbById(Integer
							.parseInt(rztbid[i]));
					switch (i) {
					case 0:
						String rztbdz1 = rztb.getSub();
						mav.addObject("rztbdz1", rztbdz1);
						break;
					case 1:
						String rztbdz2 = rztb.getSub();
						mav.addObject("rztbdz2", rztbdz2);
						break;
					case 2:
						String rztbdz3 = rztb.getSub();
						mav.addObject("rztbdz3", rztbdz3);
						break;
					case 3:
						String rztbdz4 = rztb.getSub();
						mav.addObject("rztbdz4", rztbdz4);
						break;
					}
				}
			}
		} else if ("1,5".equalsIgnoreCase(ymids)
				|| "1,2,5".equalsIgnoreCase(ymids)
				|| "1,3,5".equalsIgnoreCase(ymids)
				|| "1,2,3,5".equalsIgnoreCase(ymids)) { // 单位图片
			url = "/bggl/bgzdydy/fmzdy";
			request.setAttribute("bgbh", bgbh);
			List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
			if (d.size() != 0) {
				int zhid = Integer.parseInt(d.get(0).get("id").toString());
				YjyBgzh bgzh = service.getbgzhById(zhid);
				String sub = bgzh.getFmdz();
				if (sub != null) {
					mav.addObject("sub", sub);
				}
			}
			List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
			if (a.size() != 0) {
				int id = Integer.parseInt(a.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(id);
				String ypmc = ypxx.getYpmc();
				String scdw = ypxx.getScdw();
				String sjdw = ypxx.getSjdw();
				String jylx = ypxx.getJylx();
				String wtdw = ypxx.getWtdw();
				request.setAttribute("ypmc", ypmc);
				request.setAttribute("sjdw", sjdw);
				request.setAttribute("jylx", jylx);
				request.setAttribute("scdw", scdw);
				request.setAttribute("wtdw", wtdw);
				// 建工中心（院）
				String gcmc = ypxx.getGcmc();
				request.setAttribute("gcmc", gcmc);
				String jsdw = ypxx.getJsdw();
				request.setAttribute("jsdw", jsdw);
				String sgdw = ypxx.getSgdw();
				request.setAttribute("sgdw", sgdw);
			}
			String nf = bgbh.substring(2, 4);
			request.setAttribute("nf", nf);
			String z = bgbh.substring(4, bgbh.length() - 5);
			request.setAttribute("z", z);
			String h = bgbh.substring(bgbh.length() - 5);
			request.setAttribute("h", h);
			List<Map<String, Object>> b = service.getbgxxList(bgbh);
			if (b.size() != 0) {
				int bgid = Integer.parseInt(b.get(0).get("id").toString());
				YjyBgxx bgxx = service.getbgxxById(bgid);
				String dwmctp = bgxx.getDwmctp();
				mav.addObject("dwmctp", dwmctp);
				// Integer sfjs = bgxx.getSfjs();
				// if (sfjs == 0) {
				// String gai = "0";
				// mav.addObject("gai", gai);
				// } else if (sfjs == 1) {
				// String gai = "1";
				// mav.addObject("gai", gai);
				// }
			}
		}
		mav.setViewName(url);
		return mav;
	}

	/**
	 * 报告单次打印
	 * 
	 * @author duanpeijun
	 * @date 2016年3月3日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/dcdy")
	public ModelAndView dcdy(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/bgzdydy/fmzdy");
		String bgbh = request.getParameter("bgbh");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if (d.size() != 0) {
			int zhid = Integer.parseInt(d.get(0).get("id").toString());
			YjyBgzh bgzh = service.getbgzhById(zhid);
			String sub = bgzh.getFmdz();
			if (sub != null) {
				mav.addObject("sub", sub);
			}
		}
		List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
		if (a.size() != 0) {
			int id = Integer.parseInt(a.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(id);
			String ypmc = ypxx.getYpmc();
			String scdw = ypxx.getScdw();
			String sjdw = ypxx.getSjdw();
			String jylx = ypxx.getJylx();
			String wtdw = ypxx.getWtdw();
			request.setAttribute("ypmc", ypmc);
			request.setAttribute("sjdw", sjdw);
			request.setAttribute("jylx", jylx);
			request.setAttribute("scdw", scdw);
			request.setAttribute("wtdw", wtdw);
			// 建工中心（院）
			String gcmc = ypxx.getGcmc();
			request.setAttribute("gcmc", gcmc);
			String jsdw = ypxx.getJsdw();
			request.setAttribute("jsdw", jsdw);
			String sgdw = ypxx.getSgdw();
			request.setAttribute("sgdw", sgdw);
		}
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if (b.size() != 0) {
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if (sfjs == 0) {
		// String gai = "0";
		// mav.addObject("gai", gai);
		// } else if (sfjs == 1) {
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	/**
	 * 预览单次报告
	 * 
	 * @author duanpeijun
	 * @date 2016年3月3日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/yldcbg")
	public ModelAndView yldcbg(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/bgdcdy/yldcbg");
		// List<Map<String, Object>> b = service.getbgxxList(bgbh);
		// if( b.size() != 0 ){
		// int bgid = Integer.parseInt(b.get(0).get("id").toString());
		// YjyBgxx bgxx = service.getbgxxById(bgid);
		// Integer sfjs = bgxx.getSfjs();
		// if(sfjs == 0){
		// String gai = "0";
		// mav.addObject("gai", gai);
		// }else if(sfjs == 1){
		// String gai = "1";
		// mav.addObject("gai", gai);
		// }
		// }
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				mav.addObject("fl", fl);
			}
		}
		// String xm = AppUtil.getCurrentUser().getXm();
		// request.setAttribute("xm", xm);
		return mav;
	}

	/**
	 * 多次打印窗口
	 * 
	 * @author duanpeijun
	 * @date 2016年4月7日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/duocdy")
	public ModelAndView duocdy(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/duocdy/duock");
		String bgbh = request.getParameter("bgbh");
		request.setAttribute("bgbh", bgbh);
		return mav;
	}

	/**
	 * 多次打印封面（封面没有认证章和单位名称）
	 * 
	 * @author duanpeijun
	 * @date 2016年4月7日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/duocidayinfm")
	public ModelAndView duocidayinfm(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/duocdy/fm");
		String bgbh = request.getParameter("bgbh");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if (d.size() != 0) {
			int zhid = Integer.parseInt(d.get(0).get("id").toString());
			YjyBgzh bgzh = service.getbgzhById(zhid);
			String sub = bgzh.getFmdz();
			if (sub != null) {
				mav.addObject("sub", sub);
			}
		}
		List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
		if (a.size() != 0) {
			int id = Integer.parseInt(a.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(id);
			String ypmc = ypxx.getYpmc();
			String scdw = ypxx.getScdw();
			String sjdw = ypxx.getSjdw();
			String jylx = ypxx.getJylx();
			String wtdw = ypxx.getWtdw();
			request.setAttribute("ypmc", ypmc);
			request.setAttribute("sjdw", sjdw);
			request.setAttribute("jylx", jylx);
			request.setAttribute("scdw", scdw);
			request.setAttribute("wtdw", wtdw);
			// 建工中心（院）
			String gcmc = ypxx.getGcmc();
			request.setAttribute("gcmc", gcmc);
			String jsdw = ypxx.getJsdw();
			request.setAttribute("jsdw", jsdw);
			String sgdw = ypxx.getSgdw();
			request.setAttribute("sgdw", sgdw);
		}
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		/*
		 * List<Map<String, Object>> b = service.getbgxxList(bgbh); if (b.size()
		 * != 0) { int bgid = Integer.parseInt(b.get(0).get("id").toString());
		 * YjyBgxx bgxx = service.getbgxxById(bgid); Integer sfjs =
		 * bgxx.getSfjs(); if (sfjs == 0) { String gai = "0";
		 * mav.addObject("gai", gai); } else if (sfjs == 1) { String gai = "1";
		 * mav.addObject("gai", gai); } }
		 */
		return mav;
	}

	/**
	 * 多次打印首页（没有院章）
	 * 
	 * @author duanpeijun
	 * @date 2016年4月7日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/duocidayinsy")
	public ModelAndView duocidayinsy(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/bggl/duocdy/sy");
		String bgbh = request.getParameter("bgbh");
		request.setAttribute("bgbh", bgbh);
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if (d.size() != 0) {
			int zhid = Integer.parseInt(d.get(0).get("id").toString());
			YjyBgzh bgzh = service.getbgzhById(zhid);
			String sub = bgzh.getSydz();
			if (sub != null) {
				mav.addObject("sub", sub);
			}
		}
		// SysYh yh = AppUtil.getCurrentUser();
		// String zjr = yh.getYhjs();
		// mav.addObject("zjr", zjr);
		List<Map<String, Object>> b = service.getbgxxList(bgbh);
		if (b.size() != 0) {
			int bgxxid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgxxid);
			String cydw = bgxx.getCydw();
			request.setAttribute("cydw", cydw);
			String jyqksm = bgxx.getJyqksm();
			request.setAttribute("jyqksm", jyqksm);
			String jyrq = bgxx.getJyrq();
			request.setAttribute("jyrq", jyrq);
			String jyjl = bgxx.getJyjl();
			request.setAttribute("jyjl", jyjl);
			/*
			 * Integer sfjs = bgxx.getSfjs(); if(sfjs == 0){ String gai = "0";
			 * mav.addObject("gai", gai); }else if(sfjs == 1){ String gai = "1";
			 * mav.addObject("gai", gai); }
			 */
		}
		WordExtractor doc;
		try {
			doc = new WordExtractor(new FileInputStream(request.getSession()
					.getServletContext().getRealPath("resources/doc")
					+ "/" + bgbh + ".doc"));
			int pages = doc.getSummaryInformation().getPageCount() - 1;// 总页数
			System.out.println("页数————————————————————————————>" + pages);
			request.setAttribute("pages", pages);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String nf = bgbh.substring(2, 4);
		request.setAttribute("nf", nf);
		String z = bgbh.substring(4, bgbh.length() - 5);
		request.setAttribute("z", z);
		String h = bgbh.substring(bgbh.length() - 5);
		request.setAttribute("h", h);
		List<Map<String, Object>> a = jyxxservice.getYp(bgbh);
		if (a.size() != 0) {
			int id = Integer.parseInt(a.get(0).get("id").toString());
			String key = a.get(0).get("id").toString();
			// 主检人
			List<Map<String, Object>> zjrList = service.getZjr(key);
			if (zjrList.size() != 0) {
				String shrxm = zjrList.get(0).get("shr").toString();
				List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
				if (shrtpList.size() != 0) {
					String zjr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("zjr", zjr);
				}
			}
			// 审核人
			List<Map<String, Object>> shrList = service.getShr(key);
			if (shrList.size() != 0) {
				String shrxm = shrList.get(0).get("shr").toString();
				List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
				if (shrtpList.size() != 0) {
					String shr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("shr", shr);
				}
			}
			// 批准人
			List<Map<String, Object>> pzrList = service.getPzr(key);
			if (pzrList.size() != 0) {
				String shrxm = pzrList.get(0).get("shr").toString();
				List<Map<String, Object>> shrtpList = service.getShrtp(shrxm);
				if (shrtpList.size() != 0) {
					String pzr = shrtpList.get(0).get("yhjs").toString();
					mav.addObject("pzr", pzr);
				}
				String shsj = pzrList.get(0).get("shsj").toString();
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// 检验日期
					Date dat = sdf.parse(shsj);
					Calendar c = Calendar.getInstance();
					c.setTime(dat);
					int year = c.get(Calendar.YEAR);
					mav.addObject("year", year);
					int month = c.get(Calendar.MONTH);
					int mon = month + 1;
					mav.addObject("mon", mon);
					int date = c.get(Calendar.DATE);
					mav.addObject("date", date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			YypYpxx ypxx = ypxxservice.getYpxxById(id);
			String ypmc = ypxx.getYpmc();
			request.setAttribute("ypmc", ypmc);
			String cpmc = ypxx.getCpmc();
			request.setAttribute("cpmc", cpmc);
			String sjdw = ypxx.getSjdw();
			request.setAttribute("sjdw", sjdw);
			String scdw = ypxx.getScdw();
			request.setAttribute("scdw", scdw);
			String cydd = ypxx.getCydd();
			request.setAttribute("cydd", cydd);
			String ypsl = ypxx.getYpsl();
			request.setAttribute("ypsl", ypsl);
			String cyjs = ypxx.getCyjs();
			request.setAttribute("cyjs", cyjs);
			String ypzt = ypxx.getYpzt();
			request.setAttribute("ypzt", ypzt);
			String wtdw = ypxx.getWtdw();
			request.setAttribute("wtdw", wtdw);
			String cyry = ypxx.getCyry();
			request.setAttribute("cyry", cyry);
			String ggxh = ypxx.getGgxh();
			request.setAttribute("ggxh", ggxh);
			String jylx = ypxx.getJylx();
			request.setAttribute("jylx", jylx);
			String ypdj = ypxx.getYpdj();
			request.setAttribute("ypdj", ypdj);
			Date dyrq1 = ypxx.getDyrq();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			if (dyrq1 != null) {
				String dyrq = sdf.format(dyrq1);
				request.setAttribute("dyrq", dyrq);
			}
			Date cyrq1 = ypxx.getCyrq();
			if (cyrq1 != null) {
				String cyrq = sdf.format(cyrq1);
				request.setAttribute("cyrq", cyrq);
			}
			String jyxm = ypxx.getJyxm();
			request.setAttribute("jyxm", jyxm);
			String scrqpc = ypxx.getScrqpc();
			request.setAttribute("scrqpc", scrqpc);
			String jcfyry = ypxx.getJcfyry();
			request.setAttribute("jcfyry", jcfyry);
			String jyyj = ypxx.getJyyj();
			request.setAttribute("jyyj", jyyj);
			String sb = ypxx.getSb();
			request.setAttribute("sb", sb);
			String wtdwdz = ypxx.getWtdwdz();
			request.setAttribute("wtdwdz", wtdwdz);
			String bz = ypxx.getBz();
			request.setAttribute("bz", bz);
			String sgdw = ypxx.getSgdw();
			request.setAttribute("sgdw", sgdw);
			String jldw = ypxx.getJldw();
			request.setAttribute("jldw", jldw);
			String jlr = ypxx.getJlr();
			request.setAttribute("jlr", jlr);
			String jzdw = ypxx.getJzdw();
			request.setAttribute("jzdw", jzdw);
			String jzr = ypxx.getJzr();
			request.setAttribute("jzr", jzr);
			String gcmc = ypxx.getGcmc();
			request.setAttribute("gcmc", gcmc);
			String gcdz = ypxx.getGcdz();
			request.setAttribute("gcdz", gcdz);
			String gcsjdw = ypxx.getGcsjdw();
			request.setAttribute("gcsjdw", gcsjdw);
			String jsdw = ypxx.getJsdw();
			request.setAttribute("jsdw", jsdw);
			String dh = ypxx.getDh();
			request.setAttribute("dh", dh);
			String scdwdh = ypxx.getScdwdh();
			request.setAttribute("scdwdh", scdwdh);
			String cydbh = ypxx.getCydbh();
			request.setAttribute("cydbh", cydbh);
			String rwly = ypxx.getRwly();
			request.setAttribute("rwly", rwly);
			List<Map<String, Object>> rwlylist = ypxxservice
					.getDicByJylx("rwly");
			if (rwly != null) {
				for (int i = 0; i < rwlylist.size(); i++) {
					System.out.println("-----------1-------->"
							+ rwlylist.get(i).get("ZDZ"));
					if (rwlylist.get(i).get("ZDZ").toString().equals(rwly)) {
						request.setAttribute("rwly", rwlylist.get(i)
								.get("ZDMC"));
					}
				}
			}
			Integer lyfs = ypxx.getLyfs();
			List<Map<String, Object>> lyfslist = ypxxservice
					.getDicByJylx("lyfs");
			if (lyfs != null) {
				for (int i = 0; i < lyfslist.size(); i++) {
					if (Integer.parseInt(lyfslist.get(i).get("ZDZ").toString()) == lyfs) {
						request.setAttribute("zdmc", lyfslist.get(i)
								.get("ZDMC"));
					}
				}
			}
		}
		return mav;
	}

	/**
	 * 多次打印报告预览（封面没有认证章和单位名称，首页没有院章）
	 * 
	 * @author duanpeijun
	 * @date 2016年4月7日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/ylbgduo")
	public ModelAndView ylbgduo(HttpServletRequest request,
			HttpServletResponse response, String bgbh) {
		ModelAndView mav = new ModelAndView("/bggl/duocdy/ylbgduo");
		/*
		 * List<Map<String, Object>> b = service.getbgxxList(bgbh); if( b.size()
		 * != 0 ){ int bgid = Integer.parseInt(b.get(0).get("id").toString());
		 * YjyBgxx bgxx = service.getbgxxById(bgid); Integer sfjs =
		 * bgxx.getSfjs(); if(sfjs == 0){ String gai = "0"; mav.addObject("gai",
		 * gai); }else if(sfjs == 1){ String gai = "1"; mav.addObject("gai",
		 * gai); } }
		 */
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String zh = ypxx.getZh();
			String djlx = ypxx.getDjlx().toString();
			List<Map<String, Object>> abc = service.getBhszList(zh, djlx);
			if (abc.size() != 0) {
				String fl = abc.get(0).get("zhfl").toString();
				mav.addObject("fl", fl);
			}
		}
		mav.addObject("bgbh", bgbh);
		// String xm = AppUtil.getCurrentUser().getXm();
		// request.setAttribute("xm", xm);
		return mav;
	}

	/**
	 * 通过样品ID查询最新的检验依据
	 * 
	 * @author duanpeijun
	 * @date 2016年4月21日
	 * @param jyksbh
	 * @param zhmc
	 * @return
	 */
	@RequestMapping(value = "/findJyyj")
	@ResponseBody
	public List<Map<String, Object>> findJyyj(String yp) {
		List<Map<String, Object>> list = ypxxservice.getYpxx(Integer
				.parseInt(yp));
		return list;
	}

	/**
	 * 1:审核人预览报告 2:批准人预览报告
	 * 
	 * @author duanpeijun
	 * @date 2016年4月20日
	 * @param request
	 */
	@RequestMapping(value = "/CS")
	public ModelAndView shCS(HttpServletRequest request,
			HttpServletResponse response, String bgbh, String taskId,
			String tname, String businessKey, String userCode, String lineVar,
			String cs) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		String url = "";
		List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
		if (yp.size() != 0) {
			int ypid = Integer.parseInt(yp.get(0).get("id").toString());
			YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
			String ypbh = ypxx.getYpbh();
			String ypmc = ypxx.getYpmc();
			mav.addObject("ypbh", ypbh);
			mav.addObject("ypmc", ypmc);
		}
		List<Map<String, Object>> c = service.getbgxxList(bgbh);
		if (c.size() != 0) {
			int bgid = Integer.parseInt(c.get(0).get("id").toString());
			YjyBgxx bgxx = service.getbgxxById(bgid);
			String bsdx = bgxx.getBsdx();
			mav.addObject("bsdx", bsdx);
		}
		mav.addObject("taskId", taskId);
		mav.addObject("businessKey", businessKey);
		if (tname != null && !"".equals(tname)) {
			String tname2 = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
			mav.addObject("tname", tname2);
		}
		if (userCode != null && !"".equals(userCode)) {
			String usercode = new String(userCode.getBytes("ISO-8859-1"),
					"UTF-8");
			mav.addObject("userCode", usercode);
		}
		mav.addObject("lineVar", lineVar);
		if ("1".equals(cs)) {
			url = "/bggl/shCS";
		} else if ("2".equals(cs)) {
			url = "/bggl/pzCS";
		}
		mav.setViewName(url);
		return mav;
	}

	/**
	 * 报告解锁时，bgbhsypz.doc
	 * 
	 * @author duanpeijun
	 * @date 2016年5月4日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deletebg")
	@ResponseBody
	public String deleteFile(HttpServletRequest request, String bgbh) {
		String flag = "0";
		// System.out.println("--bgbhsypz.doc-->"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sypz.doc");
		// System.out.println("----bgbh.doc---->"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+".doc");
		File sypz = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "sypz.doc");
		// File file = new
		// File(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+".doc");
		// 路径为文件且不为空则进行删除
		if (sypz.exists()) {
			sypz.delete();
			// file.delete();
			flag = "1";
		}
		return flag;
	}

	/**
	 * 报告审核不通过时，删除bgbhsypz.doc文档
	 * 报告批准不通过时，删除bgbhsypz.doc文档
	 * @author duanpeijun
	 * @date 2016年7月11日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deletesypz")
	@ResponseBody
	public String deletesypz(HttpServletRequest request, String bgbh) {
		String flag = "0";
		// System.out.println(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sypz.doc");
		File file = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "sypz.doc");
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = "1";
		}
		return flag;
	}

	/**
	 * 删除附页
	 * 
	 * @author duanpeijun
	 * @date 2016年7月14日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deletefy")
	@ResponseBody
	public String deletefy(HttpServletRequest request, String bgbh) {
		String flag = "0";
		// System.out.println(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy.doc");
		File file = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "fy.doc");
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = "1";
		} else if (!file.exists()) {
			flag = "2";
		}
		return flag;
	}
	
	/**
	 * 删除特殊报告
	 * @author duanpeijun
	 * @date 2016年8月1日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deletetsbg")
	@ResponseBody
	public String deletetsbg(HttpServletRequest request, String bgbh) {
		String flag = "0";
		// System.out.println(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy.doc");
		File file = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + ".doc");
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = "1";
		} else if (!file.exists()) {
			flag = "2";
		}
		return flag;
	}

	/**
	 * 报告批准通过后，删除fylc.doc文档
	 * 
	 * @author duanpeijun
	 * @date 2016年7月15日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deletefylc")
	@ResponseBody
	public String deletefylc(HttpServletRequest request, String bgbh) {
		String flag = "0";
//		System.out.println(request.getSession().getServletContext().getRealPath("resources/fylc")+ "/" + bgbh + "fy.doc");
		File file = new File(request.getSession().getServletContext().getRealPath("resources/fylc")+ "/" + bgbh + "fy.doc");
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = "1";
		} else if (!file.exists()) {
			flag = "2";
		}
		return flag;
	}

	/**
	 * 多次打印时，删除fm.doc, sy.doc, fmdc.doc, sydc.doc
	 * 
	 * @author duanpeijun
	 * @date 2016年7月15日
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deletefmsy")
	@ResponseBody
	public String deletefmsy(HttpServletRequest request, String bgbh) {
		String flag = "0";
		// System.out.println("----fm.doc---->"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fm.doc");
		// System.out.println("----sy.doc---->"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sypz.doc");
		// System.out.println("---fmdc.doc--->"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fmdc.doc");
		// System.out.println("---sydc.doc--->"+request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sydc.doc");
		File fm = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "fm.doc");
		File sypz = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "sypz.doc");
		File fmdc = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "fmdc.doc");
		File sydc = new File(request.getSession().getServletContext()
				.getRealPath("resources/doc")
				+ "/" + bgbh + "sydc.doc");
		// 路径为文件且不为空则进行删除
		if (fm.exists() && sypz.exists() && fmdc.exists() && sydc.exists()) {
			fm.delete();
			sypz.delete();
			fmdc.delete();
			sydc.delete();
			flag = "1";
		} else if (fmdc.exists() && sydc.exists()) {
			fmdc.delete();
			sydc.delete();
			flag = "1";
		}
		service.updateDycs(bgbh);
		return flag;
	}
	
	/**
	 * 骑缝章打印时，删除qfz文件夹下的对应pdf文档
	 * @author duanpeijun
	 * @date 2016年7月18日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/deleteqfz")
	@ResponseBody
	public String deleteqfz(HttpServletRequest request, String bgbh) {
		String flag = "0";
		// System.out.println(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"sypz.doc");
		File file = new File(request.getSession().getServletContext().getRealPath("resources/qfz")+ "/" + bgbh + ".pdf");
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = "1";
		}
		return flag;
	}

	/**
	 * 查询样品有无修改时间
	 * 
	 * @author duanpeijun
	 * @date 2016年5月4日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/cxxgsj")
	@ResponseBody
	public String cxxgsj(HttpServletRequest request, String bgbh) {
		String str = "";
		System.out.println("---------------------------->修改时间");
		List<Map<String, Object>> xgsjList = service.xgsjList(bgbh);
		if (xgsjList.size() != 0) {
			if (xgsjList.get(0).get("XGSJ") != null) {
				str = "1"; // 修改字段有值
			} else {
				str = "2"; // 修改字段没有值
			}
		}
		return str;
	}

	/**
	 * 整体报告打印
	 * 
	 * @author duanpeijun
	 * @date 2016年7月6日
	 * @return
	 */
	@RequestMapping(value = "/QfzPage")
	public ModelAndView QfzPage() {
		ModelAndView modelAndView = new ModelAndView("/jygl/QfzList");
		return modelAndView;
	}

	/**
	 * 骑缝章
	 * @author duanpeijun
	 * @date 2016年8月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/Qfz")
	public ModelAndView testQfz(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/bggl/qfz");
		modelAndView.addObject("bgbh", request.getParameter("bgbh"));
		String bgbh = request.getParameter("bgbh");
		modelAndView.addObject("bgbh", bgbh);
		modelAndView.addObject("fileName", request.getParameter("bgbh")
				+ ".pdf");
		KGPdfHummer hummer = null;
		FileInputStream cert = null;
		FileOutputStream fileOutputStream = null;
		try {
			cert = new FileInputStream(request.getSession().getServletContext()
					.getRealPath("resources/temp")
					+ "/server.pfx");
			fileOutputStream = new FileOutputStream(request.getSession()
					.getServletContext().getRealPath("resources/qfz")
					+ "/" + bgbh + ".pdf");
			hummer = KGPdfHummer.createSignature(request.getSession()
					.getServletContext().getRealPath("resources/pdf")
					+ "/" + bgbh + ".pdf", null, true, fileOutputStream,
					new File(request.getSession().getServletContext()
							.getRealPath("resources/temp")), true);
			hummer.setCertificate(cert, "123456", "123456");
			
			//根据bgbh获取样品的ID
			List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
			if(yp.size() != 0){
				int ypid=Integer.parseInt(yp.get(0).get("id").toString());
				YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
				Integer mbfl = ypxx.getDjlx();
				String zh = ypxx.getZh();
				String djlx = mbfl.toString();
				//根据字号和登记类型获取编号设置表中的分类数据
				List<Map<String, Object>> abc = service.getBhszList(zh,djlx);
				if(abc.size() != 0){
					String fl = abc.get(0).get("zhfl").toString();
					if("0".equals(fl) || "4".equals(fl) || "6".equals(fl)){     //一般院(yb)
						PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(
								request.getSession().getServletContext().getRealPath("resources/temp")+ "/yb.key", 0, "123456");
						if (hummer.getNumberOfPages() < 33) {
							pdfElectronicSeal4KG.qfz(hummer.getNumberOfPages(),
									KGQfzModeEnum.ALLPAGE, 400); // 骑缝章 参数一多少页均分一个章 参数二// 页数是所有页 还是奇、偶数// 参数三印章距离底部高度
						} else {
							pdfElectronicSeal4KG.qfz(32, KGQfzModeEnum.ALLPAGE, 400);
						}
						hummer.addExecute(pdfElectronicSeal4KG);
					}else if("2".equals(fl) || "5".equals(fl)){   //国建(gj)
						PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(
								request.getSession().getServletContext().getRealPath("resources/temp")+ "/gj.key", 0, "123456");
						if (hummer.getNumberOfPages() < 33) {
							pdfElectronicSeal4KG.qfz(hummer.getNumberOfPages(),
									KGQfzModeEnum.ALLPAGE, 400); // 骑缝章 参数一多少页均分一个章 参数二// 页数是所有页 还是奇、偶数// 参数三印章距离底部高度
						} else {
							pdfElectronicSeal4KG.qfz(32, KGQfzModeEnum.ALLPAGE, 400);
						}
						hummer.addExecute(pdfElectronicSeal4KG);
					}else if("1".equals(fl)){       //国排(gb)
						PdfElectronicSeal4KG pdfElectronicSeal4KG = new PdfElectronicSeal4KG(
								request.getSession().getServletContext().getRealPath("resources/temp")+ "/gb.key", 0, "123456");
						if (hummer.getNumberOfPages() < 33) {
							pdfElectronicSeal4KG.qfz(hummer.getNumberOfPages(),
									KGQfzModeEnum.ALLPAGE, 400); // 骑缝章 参数一多少页均分一个章 参数二// 页数是所有页 还是奇、偶数// 参数三印章距离底部高度
						} else {
							pdfElectronicSeal4KG.qfz(32, KGQfzModeEnum.ALLPAGE, 400);
						}
						hummer.addExecute(pdfElectronicSeal4KG);
					}
				}
			}

			hummer.doSignature();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				cert.close();
				fileOutputStream.close();
				if (hummer != null)
					hummer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				cert.close();
				fileOutputStream.close();
				if (hummer != null)
					hummer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return modelAndView;
	}

	public void main(String[] args) {
		testQfz(null, null);
	}

	/**
	 * 报告整体打印时，查询有无生成PDF文件
	 * 
	 * @author duanpeijun
	 * @date 2016年7月9日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/cxywpdf")
	@ResponseBody
	public String cxywpdf(HttpServletRequest request, String bgbh) {
		String str = "";
		File file = new File(request.getSession().getServletContext()
				.getRealPath("resources/pdf")
				+ "/" + bgbh + ".pdf");
		if (!file.exists()) {
			str = "1";
		} else {
			str = "2";
		}
		return str;
	}
}
