package com.zssi.framework.app.sjbb.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.sjbb.service.CbtjService;
import com.zssi.framework.app.sjbb.service.YgfltjService;

//员工福利统计model类
//liusong 2015-12-30
@Controller
@RequestMapping("/sjbb/Ygfltj")
public class YgfltjController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(YgfltjController.class);
    
	@Autowired
	private YgfltjService ygfltjService;
	
	@Autowired
	private YjyBgxxService bgxxservice;
	
	@Autowired
	private CbtjService service;
	
//	跳转福利查询页面
	@RequestMapping(value = "/FltjPage")
	public ModelAndView openPage(){
		ModelAndView  andView = new ModelAndView("/sjbb/Ygfltj");
		List<Map<String, Object>> fllx = ygfltjService.getDicByLx("fllx");
		List<Map<String, Object>> ksmc = ygfltjService.getKsmc();
		List<Map<String, Object>> ygfltj = ygfltjService.getFltj();
		if (ygfltj != null) {
			andView.addObject("ygfltj", ygfltj);
		}
		andView.addObject("ksmc",ksmc);
		andView.addObject("fllx",fllx);
		return andView;
	}

//	跳转福利汇总统计页面
	@RequestMapping(value = "/FltjhzPage")
	public ModelAndView addPage(){
		ModelAndView  andView = new ModelAndView("/sjbb/Ygfltjhz");
		return andView;
	}
	
	
//员工福利汇总查询	
//	liusong 2016-1-19
	@RequestMapping(value = "/getYgflhz")
	@ResponseBody
	public List<Map<String,Object>> getYgflhz(HttpServletRequest request, HttpServletResponse response) {
		String ksmccx = request.getParameter("ksmc");
		String ssyfcx = request.getParameter("ssyf");
		List<Map<String, Object>> ygflhz = ygfltjService.getFlhz(ksmccx,ssyfcx);
		return ygflhz;
	}
	
//	跳转科室收入统计页面
//	liusong 2016-1-19
	@RequestMapping(value = "/KssrtjPage")
	public ModelAndView KssrtjPage(){
		ModelAndView  andView = new ModelAndView("/sjbb/Kssrtj");
		List<Map<String, Object>> srfl = ygfltjService.getDicByLx("srfl");
		andView.addObject("srfl", srfl);
		return andView;
	}
	
	//科室收入统计查询	
//	liusong 2016-1-19
		@RequestMapping(value = "/getKssrtj")
		@ResponseBody
		public List<Map<String,Object>> getKssrtj(HttpServletRequest request, HttpServletResponse response) {
			String srfl = request.getParameter("srfl");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			List<Map<String, Object>> kssrtj = ygfltjService.getKssrtj(srfl,cxsjstr,cxsjend);
			for(int i=0;i<kssrtj.size();i++){
				 Map<String, Object> map = kssrtj.get(i);
				 BigDecimal hjysk = ((BigDecimal) map.get("jysfysk")).add((BigDecimal) map.get("jsfwysk"));
				 BigDecimal hjysf = ((BigDecimal) map.get("jysfysf")).add((BigDecimal) map.get("jsfwysf"));
				 map.put("HJYSK", hjysk);
				 map.put("HJYSF", hjysf);
			}
			return kssrtj;
		}
		
		
		/**
		 * 点击菜单查看收费记录报表页面
		 * @author liusong
		 * @date 2016年1月20日
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value = "/SfjlhzPage")
		public ModelAndView SfjlhzPage(){
			ModelAndView  andView = new ModelAndView("/sjbb/Sfjlhz");
			List<Map<String, Object>> srfl = ygfltjService.getDicByLx("srfl");
			andView.addObject("srfl", srfl);
			List<Map<String, Object>> jyks =bgxxservice.getJyks("100250");
			andView.addObject("jyks", jyks);
			List<Map<String, Object>> ywks =bgxxservice.getJyks("100230");
			andView.addObject("ywks", ywks);
			List<Map<String, Object>> glbm =bgxxservice.getBm();
			andView.addObject("glbm", glbm);
			List<Map<String, Object>> sfr = ygfltjService.getSfr();
			andView.addObject("sfr", sfr);
			return andView;
		}
		
		//点击查询查看报告收费记录	
//		liusong 2016-1-19
			@RequestMapping(value = "/getBgsfjl")
			@ResponseBody
			public List<Map<String,Object>> getBgsfjl(HttpServletRequest request, HttpServletResponse response) {
				String srfl = request.getParameter("srfl");
				String sfr = request.getParameter("sfr");
				String cxsjstr = request.getParameter("cxsjstr");
				String cxsjend = request.getParameter("cxsjend");
				String jyks = request.getParameter("jyks");
				String ywks = request.getParameter("ywks");
				List<Map<String, Object>> bgsfjl = ygfltjService.getBgsfjl(srfl,sfr,cxsjstr,cxsjend,jyks,ywks);
				return bgsfjl;
			}
			
			//点击查询查看协议收费记录	
//			liusong 2016-1-19
				@RequestMapping(value = "/getXysfjl")
				@ResponseBody
				public List<Map<String,Object>> getXysfjl(HttpServletRequest request, HttpServletResponse response) {
					String sfr = request.getParameter("sfr");
					String cxsjstr = request.getParameter("cxsjstr");
					String cxsjend = request.getParameter("cxsjend");
					String jyks = request.getParameter("jyks");
					String ywks = request.getParameter("ywks");
					List<Map<String, Object>> bgsfjl = ygfltjService.getXysfjl(sfr,cxsjstr,cxsjend,jyks,ywks);
					return bgsfjl;
				}
				
				//点击查询查看协议收费记录	
//				liusong 2016-1-19
					@RequestMapping(value = "/getGlsfjl")
					@ResponseBody
					public List<Map<String,Object>> getGlsfjl(HttpServletRequest request, HttpServletResponse response) {
						String sfr = request.getParameter("sfr");
						String srfl = request.getParameter("srfl");
						String cxsjstr = request.getParameter("cxsjstr");
						String cxsjend = request.getParameter("cxsjend");
						String glbm = request.getParameter("glbm");
						List<Map<String, Object>> bgsfjl = ygfltjService.getGlsfjl(sfr,srfl,cxsjstr,cxsjend,glbm);
						return bgsfjl;
					}
		
		
		/**
		 * 查看员工福利明细页面
		 * @author wangyong
		 * @date 2016年1月20日
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value = "/YgflmxPage")
		public ModelAndView openBqPage(HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav = new ModelAndView("/sjbb/YgflmxPage");
			String ksmccx = request.getParameter("ksmccx");
			String ssyfcx = request.getParameter("ssyfcx");
			List<Map<String,Object>> ygflmx=ygfltjService.getYgflmx(ksmccx, ssyfcx);
			List<Map<String,Object>> bmmc=service.getBmmc(ksmccx);
			mav.addObject("ygflmx", ygflmx);
			mav.addObject("bmmc", bmmc);
			mav.addObject("ksmccx", ksmccx);
			mav.addObject("ssyfcx", ssyfcx);
			return mav;
		}
		
		/**
		 * 查看科室收入明细页面
		 * @author wangyong
		 * @date 2016年1月20日
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping(value = "/KssrmxPage")
		public ModelAndView KssrmxPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("octets/stream");
//			String srfl = request.getParameter("srfl");
//			//转码防止乱码
//			srfl=URLDecoder.decode(srfl,"UTF-8");
			String px = request.getParameter("px");
			String ksmccx = request.getParameter("ksmccx");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			List<Map<String,Object>> bmmc=service.getBmmc(ksmccx);
			
			String url = "";
			ModelAndView mav = new ModelAndView();
			if (px.equals("1")) {
				url = "/sjbb/jyksmxPage";
				List<Map<String,Object>> bgsfmx=ygfltjService.jyksbgsfmx(ksmccx,cxsjstr,cxsjend);
				List<Map<String,Object>> xysfmx=ygfltjService.jyksxysfmx(ksmccx,cxsjstr,cxsjend);
				List<Map<String,Object>> nwglmx=ygfltjService.nwglmx(ksmccx,cxsjstr,cxsjend);
				mav.addObject("nwglmx", nwglmx);
				mav.addObject("bgsfmx", bgsfmx);
				mav.addObject("xysfmx", xysfmx);
				mav.addObject("cxsjstr", cxsjstr);
				mav.addObject("cxsjend", cxsjend);
				mav.addObject("bmmc", bmmc);
				mav.addObject("ksmccx", ksmccx);
				mav.addObject("px", px);
			} else if(px.equals("3")){
				url = "/sjbb/ywksmxPage";
				List<Map<String,Object>> bgsfmx=ygfltjService.ywksbgsfmx(ksmccx,cxsjstr,cxsjend);
				List<Map<String,Object>> xysfmx=ygfltjService.ywksxysfmx(ksmccx,cxsjstr,cxsjend);
				mav.addObject("bgsfmx", bgsfmx);
				mav.addObject("xysfmx", xysfmx);
				mav.addObject("cxsjstr", cxsjstr);
				mav.addObject("cxsjend", cxsjend);
				mav.addObject("bmmc", bmmc);
				mav.addObject("ksmccx", ksmccx);
				mav.addObject("px", px);
			} else if(px.equals("5")){
				url = "/sjbb/jszxmxPage";
				List<Map<String,Object>> jszxbgsfmx=ygfltjService.jszxbgsfmx(ksmccx,cxsjstr,cxsjend);
				List<Map<String,Object>> jszxxysfmx=ygfltjService.jszxxysfmx(ksmccx,cxsjstr,cxsjend);
				List<Map<String,Object>> jszxnwmx=ygfltjService.jszxnwmx(ksmccx,cxsjstr,cxsjend);
				mav.addObject("jszxnwmx", jszxnwmx);
				mav.addObject("jszxbgsfmx", jszxbgsfmx);
				mav.addObject("jszxxysfmx", jszxxysfmx);
				mav.addObject("cxsjstr", cxsjstr);
				mav.addObject("cxsjend", cxsjend);
				mav.addObject("bmmc", bmmc);
				mav.addObject("ksmccx", ksmccx);
				mav.addObject("px", px);
			} else if(px.equals("7")){
				url = "/sjbb/glbmmxPage";
				List<Map<String,Object>> glbmsfmx=ygfltjService.glbmsfmx(ksmccx,cxsjstr,cxsjend);
				mav.addObject("glbmsfmx", glbmsfmx);
				mav.addObject("cxsjstr", cxsjstr);
				mav.addObject("cxsjend", cxsjend);
				mav.addObject("bmmc", bmmc);
				mav.addObject("ksmccx", ksmccx);
				mav.addObject("px", px);
			}
			mav.setViewName(url);
			return mav;
		}
		
		/**
		 * exl导出
		 * @author liusong
		 * @date 2015年9月24日
		 */
		
		@RequestMapping(value = "/export")
		public void exportExcel(HttpServletRequest request, HttpServletResponse response,String srfl,String cxsjstr,String cxsjend) throws Exception{
			ygfltjService.exportExcel(request,response,srfl,cxsjstr,cxsjend);
		}
		
		/**
		 * 工资薪金汇总导出Excle
		 * @author wangyong
		 * @date 2016年1月26日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportYgfl")
		public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String ksmc = request.getParameter("ksmc");
			String ssyf = request.getParameter("ssyf");
			ygfltjService.exportExcel(request,response,ksmc,ssyf);
		}
		
		/**
		 * 员工福利明细导出Excle
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportYgflmx")
		public void exportCbtjmx(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String ksmc = request.getParameter("ksmc");
			String ssyf = request.getParameter("ssyf");
			ygfltjService.exportYgflmx(request,response,ksmc,ssyf);
		}
		
		/**
		 * 科室收入报告收费明细检验报告导出Excle
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportKssrmx1")
		public void exportKssrmx1(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String ksmc = request.getParameter("ksmccx");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			String px = request.getParameter("px");
			ygfltjService.exportKssrmx1(request, response, ksmc, cxsjstr, cxsjend, px);
		}
		
		/**
		 * 报告收费记录导出
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportBgsfjl")
		public void exportBgsfjl(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String jyks = request.getParameter("jyks");
			String ywks = request.getParameter("ywks");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			String sfr = request.getParameter("sfr");
			String srfl = request.getParameter("srfl");
			ygfltjService.exportBgsfjl(request, response,srfl,sfr,cxsjstr,cxsjend,jyks,ywks);
		}
		
		/**
		 * 协议收费记录导出
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportXysfjl")
		public void exportXysfjl(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String jyks = request.getParameter("jyks");
			String ywks = request.getParameter("ywks");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			String sfr = request.getParameter("sfr");
			ygfltjService.exportXysfjl(request, response,sfr,cxsjstr,cxsjend,jyks,ywks);
		}
		
		/**
		 * 管理收费记录导出
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportGlbmjl")
		public void exportGlbmjl(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String glbm = request.getParameter("glbm");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			String sfr = request.getParameter("sfr");
			String srfl = request.getParameter("srfl");
			ygfltjService.exportGlbmjl(request, response,sfr,srfl,cxsjstr,cxsjend,glbm);
		}
		
		/**
		 * 科室收入协议收费明细导出Excle
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportKssrmx2")
		public void exportKssrmx2(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String ksmc = request.getParameter("ksmccx");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			String px = request.getParameter("px");
			ygfltjService.exportKssrmx2(request, response, ksmc, cxsjstr, cxsjend, px);
		}
		
		/**
		 * 科室收入协议收费明细内委收费导出Excle
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportKssrmx4")
		public void exportKssrmx4(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String ksmc = request.getParameter("ksmccx");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			String px = request.getParameter("px");
			ygfltjService.exportKssrmx4(request, response, ksmc, cxsjstr, cxsjend, px);
		}
		
		/**
		 * 管理部门科室收入明细导出Excle
		 * @author wangyong
		 * @date 2016年1月27日
		 * @param request
		 * @param response
		 * @throws Exception
		 */
		@RequestMapping(value = "/exportKssrmx3")
		public void exportKssrmx3(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String ksmc = request.getParameter("ksmccx");
			String cxsjstr = request.getParameter("cxsjstr");
			String cxsjend = request.getParameter("cxsjend");
			ygfltjService.exportKssrmx3(request, response, ksmc, cxsjstr, cxsjend);
		}
		
}
