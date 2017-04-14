package com.zssi.framework.app.zjpad.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.FormService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.jygl.service.YjyClyyService;
import com.zssi.framework.app.jygl.service.YjyJyxxService;
import com.zssi.framework.app.jyzxxx.service.YjyXxcxService;
import com.zssi.framework.app.jyzxxx.service.YjyZxxxService;
import com.zssi.framework.app.process.dao.BusinessXNDao;
import com.zssi.framework.app.process.dao.YshJybDao;
import com.zssi.framework.app.process.support.file.CpsConstant;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.sjbb.service.CbtjService;
import com.zssi.framework.app.sjbb.service.YgfltjService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.sys.service.HomePageService;
import com.zssi.framework.app.tjgl.service.BgcxService;
import com.zssi.framework.app.tjgl.service.SbcxService;
import com.zssi.framework.app.tjgl.service.YpcxService;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypSfxmmxService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;
import com.zssi.framework.app.zjpad.service.ZjPadService;

/** 
 * pad端controller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:06:00 
 * 类说明 
 */

@Controller
@RequestMapping("/ZjPad")
public class ZjPadController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(ZjPadController.class);
	@Autowired
	private YypYpxxService yypYpxxService;
	@Autowired
	private YypSfxmmxService sfxmmxService;
	@Autowired
	private YjyZxxxService yjyZxxxservice;
	@Autowired
	private YpcxService ypcxservice;
	@Autowired
	private BgcxService bgcxService;
	@Autowired
	private YjyBgxxService bgxxservice;
	@Autowired
	private SbcxService sbcxservice;
	@Autowired
	private YsbXxService sbxxService;
	@Autowired
	private YypYpxxService ypxxService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FormService formService;
	@Autowired
	private BusinessXNDao businessDao;
	@Autowired
	private YshJybDao yshJybDao;
	@Autowired
	private YjyJyxxService  jyxxservice;
	@Autowired
	private YjyClyyService clyyservice;
	@Autowired
	private YgfltjService ygfltjService;
	@Autowired
	private CbtjService cbtjservice;
	@Autowired
	private HomePageService homeservice;
	@Autowired
	private YjyXxcxService zxxxservice;
    @Autowired
    private ZjPadService service;
	/**
	 * 抽样登记页面
	 * 
	 * @author liusong
	 * @date 2016年3月11日
	 * @return
	 */
	@RequestMapping(value = "/CydjPage")
	public ModelAndView openCydjPage() {
		ModelAndView mav = new ModelAndView("/zjpad/ypcyAdd");
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
		List<Map<String, Object>> ybzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		mav.addObject("jylx", jylx);
		mav.addObject("lyfs", lyfs);
		mav.addObject("ypzt", ypzt);
		mav.addObject("bgfsfs", bgfsfs);
		mav.addObject("yhxtk", yhxtk);
		mav.addObject("jyfydd", jyfydd);
		mav.addObject("ypjyzt", ypjyzt);
		mav.addObject("ybzh", ybzh);
		mav.addObject("cydw", cydw);
		mav.addObject("rwly", rwly);
		mav.addObject("jjlx", jjlx);
		mav.addObject("zslx", zslx);
		return mav;
	}
	
	/**
	 * 后台：咨询信息页面跳转
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/ZxxxList")
	public ModelAndView ZxxxList() throws ParseException{
		ModelAndView modelAndView = new ModelAndView("/zjpad/jyZxxxList");
		List<Map<String,Object>> xxcx=zxxxservice.getXxcx(0,20);
		modelAndView.addObject("xxcx", xxcx);
		return modelAndView;
	}
	
	@RequestMapping(value="getCplxlist")
	@ResponseBody
	public List<Map<String, Object>> getCplxlist(Integer start,Integer limit,Integer size) throws ParseException{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=zxxxservice.getXxcx(start, limit);
		int count=bgcxService.getBgxxCount(start, limit);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping(value = "/cpmcView")
	public ModelAndView cpcxPage(String cplx,String cpbh,String cpmc) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		ModelAndView mav = new ModelAndView("/zjpad/cpmcPage");
		List<Map<String,Object>> cpcx=zxxxservice.getCpcx(0,20,cplx);
		mav.addObject("cpcx", cpcx);
		mav.addObject("cplx", cplx);
		mav.addObject("cpbh", cpbh);
		mav.addObject("cpmc", cpmc);
		return mav;
	}
	
	@RequestMapping(value="getCpmclist")
	@ResponseBody
	public List<Map<String, Object>> getCpmclist(Integer start,Integer limit,Integer size,String cplx, String cpbh, String cpmc) throws ParseException, Exception{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=zxxxservice.getCpList(start, limit, cplx, cpbh, cpmc);
		int count=zxxxservice.getCpCount(start, limit, cplx,cpbh, cpmc);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping(value = "/jyyjView")
	public ModelAndView jyyjPage(String cplx,String cpbh,String cpmc,String jyyj) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		ModelAndView mav = new ModelAndView("/zjpad/jyyjPage");
		List<Map<String,Object>> cpcx=zxxxservice.getJyyj(0,20,cplx,cpbh);
		mav.addObject("cpcx", cpcx);
		mav.addObject("cplx", cplx);
		mav.addObject("cpbh", cpbh);
		mav.addObject("cpmc", cpmc);
		mav.addObject("jyyj", jyyj);
		return mav;
	}
	
	@RequestMapping(value="getJyyjlist")
	@ResponseBody
	public List<Map<String, Object>> getJyyjList(Integer start,Integer limit,Integer size,String cplx, String cpbh, String cpmc, String jyyj) 
			throws ParseException, Exception{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=zxxxservice.getJyyjList(start, limit, cplx, cpbh, cpmc, jyyj);
		int count=zxxxservice.getJyyjCount(start, limit, cplx, cpbh, jyyj);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping(value = "/jyxmView")
	public ModelAndView jyxmPage(String cplx,String cpbh,String cpmc,String jyyj) throws ParseException, Exception{
		cplx = new String(cplx.getBytes("ISO-8859-1"),"UTF-8");
		ModelAndView mav = new ModelAndView("/zjpad/jyxmPage");
		List<Map<String,Object>> xmcx=zxxxservice.getJyxm(0, 20, cplx, cpbh, jyyj);
		mav.addObject("xmcx", xmcx);
		mav.addObject("cplx", cplx);
		mav.addObject("cpbh", cpbh);
		mav.addObject("cpmc", cpmc);
		mav.addObject("jyyj", jyyj);
		return mav;
	}
	
	@RequestMapping(value="getJyxmlist")
	@ResponseBody
	public List<Map<String, Object>> getJyxmList(Integer start,Integer limit,Integer size,String cplx, String cpbh, String cpmc, String jyyj, String jyxm) 
			throws ParseException, Exception{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=zxxxservice.getJyxmList(start, limit, cplx, cpbh, cpmc, jyyj, jyxm);
		int count=zxxxservice.getJyxmCount(start, limit, cplx, cpbh, jyyj, jyxm);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 后台：样品查询页面跳转
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	
	@RequestMapping(value = "/ypcxPage")
	public ModelAndView ypcxPage() {
		ModelAndView mav = new ModelAndView("/zjpad/ypcxView");
		List<Map<String, Object>> zdmc = ypcxservice.getZdmc("Y_YP_YPXX");
		List<Map<String, Object>> zdmc1 = ypcxservice.getZdmc1("Y_YP_YPXX",
				"Y_JY_BGXX");
		List<Map<String, Object>> jyksList = bgcxService.getJyksList();
		List<Map<String, Object>> ywksList = bgcxService.getYwksList();
		List<Map<String, Object>> bzrlist = bgcxService.getBzrList();
		List<Map<String, Object>> bgfsfs = ypxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> ypjyzt = ypxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> jylx = ypxxService.getDicByJylx("jylx");
		mav.addObject("zdmc", zdmc);
		mav.addObject("zdmc1", zdmc1);
		mav.addObject("bzrlist", bzrlist);
		mav.addObject("jyksList", jyksList);
		mav.addObject("ywksList", ywksList);
		mav.addObject("bgfsfs", bgfsfs);
		mav.addObject("ypjyzt", ypjyzt);
		mav.addObject("jylx", jylx);
		return mav;
	}
	
	@RequestMapping(value = "/bgcxPage")
	public ModelAndView bgcxPage() {
		ModelAndView mav = new ModelAndView("/zjpad/bgcxView");
		List<Map<String, Object>> zdmc = bgcxService.getZdmc("Y_JY_BGXX");
		List<Map<String, Object>> zdmc1 = bgcxService.getZdmc1("Y_YP_YPXX",
				"Y_JY_BGXX");
		List<Map<String, Object>> bzrlist = bgcxService.getBzrList();
		List<Map<String, Object>> jyksList = bgcxService.getJyksList();
		List<Map<String, Object>> ywksList = bgcxService.getYwksList();
		List<Map<String, Object>> bgfsfs = ypxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> ypjyzt = ypxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> jylx = ypxxService.getDicByJylx("jylx");
		mav.addObject("zdmc", zdmc);
		mav.addObject("zdmc1", zdmc1);
		mav.addObject("bzrlist", bzrlist);
		mav.addObject("jyksList", jyksList);
		mav.addObject("ywksList", ywksList);
		mav.addObject("bgfsfs", bgfsfs);
		mav.addObject("ypjyzt", ypjyzt);
		mav.addObject("jylx", jylx);
		return mav;
	}

	/**
	 * pad端获取报告信息(审核、批准)
	 * @author liangkaidi
	 * @date 2016-3-6
	 * @param cxtj
	 * @param ypcs
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/bgshlist")
	public ModelAndView wglbgshlist(String cxtj,String ypcs) {
		ModelAndView modelAndView = new ModelAndView("/zjpad/bgshlist");
	
		List<Map<String, Object>> wdrw = service.getPendPoolList(cxtj,ypcs);
		if (wdrw.size() != 0) {
			modelAndView.addObject("getwdrw", wdrw);
		}
		modelAndView.addObject("ypcs",ypcs);
		if(cxtj==null||"".equals(cxtj)){
			cxtj="样品名称";
		}
		modelAndView.addObject("cxtj",cxtj);
		return modelAndView;
	}
	
	@RequestMapping(value = "/sbcxPage")
	public ModelAndView sbcxPage() {
		ModelAndView mav = new ModelAndView("/zjpad/sbcxView");
		List<Map<String, Object>> zdmc = sbcxservice.getZdmc("Y_SB_XX");
		List<Map<String, Object>> jyksList = bgcxService.getJyksList();
		List<Map<String, Object>> jyzq = sbxxService.getDicByLx("jyzq");
		List<Map<String, Object>> jddw = sbxxService.getDicByLx("jddw");
		List<Map<String, Object>> sbzt = sbxxService.getDicByLx("sbzt");
		List<Map<String, Object>> syzt = sbxxService.getDicByLx("syzt");
		mav.addObject("jyksList", jyksList);
		mav.addObject("jyzq", jyzq);
		mav.addObject("jddw", jddw);
		mav.addObject("sbzt", sbzt);
		mav.addObject("syzt", syzt);
		mav.addObject("zdmc", zdmc);
		return mav;
	}
	
	/**
	 * 报告预警页面打开
	 * 
	 * @author liusong
	 * @date 2016年1月13日
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/warnPage")
	public ModelAndView warnPage(String kobe) throws ParseException {
		ModelAndView mav = new ModelAndView("/zjpad/bgyjView");
		List<Map<String, Object>> bgxx = bgcxService.getBgxx(0, 10);
		List<Map<String, Object>> bgxx1 = bgcxService.getBgxx1(0, 10);
		mav.addObject("bgxx", bgxx);
		mav.addObject("bgxx1", bgxx1);
		if (kobe != null || !"".equals(kobe)) {
			mav.addObject("kobe", kobe);
		}
		return mav;
	}
	
	/*
	 * 报告预警翻页查询
	 * liusong
	 * 2016-04-21*/
	@RequestMapping(value="/getBgxxlist")
	@ResponseBody
	public List<Map<String, Object>> getBgxxlist(Integer start,Integer limit,Integer size) throws ParseException{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=bgcxService.getBgxx(start, limit);
		int count=bgcxService.getBgxxCount(start, limit);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
		
		/*
		 * 报告预警翻页查询
		 * liusong
		 * 2016-04-21*/
		@RequestMapping(value="/getBgxx1list")
		@ResponseBody
		public List<Map<String, Object>> getBgxx1list(Integer start1,Integer limit1,Integer size1) throws ParseException{
		List<Map<String, Object>> list1=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value1=bgcxService.getBgxx1(start1, limit1);
		int count1=bgcxService.getBgxx1Count(start1, limit1);
		for(int i=0;i<value1.size();i++){
			Map<String,Object> map=value1.get(i);
			map.put("count1", count1);
			if(count1%size1==0){
				map.put("pages1", count1/size1);
			}else{
				map.put("pages1", count1/size1+1);
			}
			list1.add(map);
		}
		return list1;
	}
	
		@RequestMapping(value = "/tjbbPage")
		public ModelAndView tjbbPage(){
			ModelAndView modelAndView = new ModelAndView("/zjpad/tjtbPage");
			return modelAndView;
		}
		
	@RequestMapping(value = "/tjtbPage")
	public ModelAndView tjtpPage(){
		ModelAndView modelAndView = new ModelAndView("/zjpad/tjtbPage1");
		List<Map<String,Object>> aybgsf=service.getBgsf();
		modelAndView.addObject("aybgsf", aybgsf);
		List<Map<String,Object>> ywkssf=service.getYwkssf();
		modelAndView.addObject("ywkssf", ywkssf);
		//科室费用饼图
		List<Map<String,Object>> ywksbt=homeservice.getYwksBt();
		Gson gson = new Gson();
		modelAndView.addObject("ywksbt", gson.toJson(ywksbt));
		return modelAndView;
	}
	
	@RequestMapping(value = "/tjPage")
	public ModelAndView tjPage(String cs) throws ParseException{
		String url="";
		ModelAndView modelAndView = new ModelAndView();
		if(cs.equals("1")){
			url="/zjpad/CbtjList";
			List<Map<String, Object>> ksmc = ygfltjService.getKsmc();
			modelAndView.addObject("ksmc",ksmc);
		}
		if(cs.equals("2")){
			url="/zjpad/CbtjList";
			List<Map<String, Object>> ksmc = ygfltjService.getKsmc();
			modelAndView.addObject("ksmc",ksmc);
		}
		if(cs.equals("3")){
			url="/zjpad/Ygfltj";
			List<Map<String, Object>> fllx = ygfltjService.getDicByLx("fllx");
			List<Map<String, Object>> ksmc = ygfltjService.getKsmc();
			List<Map<String, Object>> ygfltj = ygfltjService.getFltj();
			if (ygfltj != null) {
				modelAndView.addObject("ygfltj", ygfltj);
			}
			modelAndView.addObject("ksmc",ksmc);
			modelAndView.addObject("fllx",fllx);
		}
		if(cs.equals("4")){
			url="/sjbb/CbtjList";
		}
		if(cs.equals("5")){
			url="/zjpad/Kssrtj";
			List<Map<String, Object>> srfl = ygfltjService.getDicByLx("srfl");
			modelAndView.addObject("srfl", srfl);
		}
		if(cs.equals("6")){
			url="/zjpad/jxkhtj";
			List<Map<String,Object>> ksmc=bgcxService.getJyksList();
			modelAndView.addObject("ksmc", ksmc);
		}
		if(cs.equals("7")){
			url="/sjbb/jxkhtj";
		}
		if(cs.equals("8")){
			url="/sjbb/CbtjList";
		}
		modelAndView.setViewName(url);
		return modelAndView;
	}
	
	/**
	 * 查询报告延期
	 * @author liusong
	 * @date 2016年1月14日
	 * @param request
	 * @param response
	 * @param code
	 * @throws ParseException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/getBgyq")
	@ResponseBody
	public List<Map<String,Object>> getBgyq(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String ksmccx = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		List<Map<String,Object>> sjbbCbtj=bgcxService.getBgyqList(ksmccx, ksyf,jsyf);
		return sjbbCbtj;
	}
	
	@RequestMapping(value = "/CbmxPage")
	public ModelAndView CbmxPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/zjpad/CbmxPage");
		String ksmccx = request.getParameter("ksmccx");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		List<Map<String,Object>> cbmx=cbtjservice.getCbmx(ksmccx, ksyf,jsyf);
		List<Map<String,Object>> bmmc=cbtjservice.getBmmc(ksmccx);
		mav.addObject("cbmx", cbmx);
		mav.addObject("bmmc", bmmc);
		mav.addObject("ksmccx", ksmccx);
		mav.addObject("ksyf", ksyf);
		mav.addObject("jsyf", jsyf);
		return mav;
	}
	
	@RequestMapping(value = "/YgflmxPage")
	public ModelAndView YgflmxPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/zjpad/YgflmxPage");
		String ksmccx = request.getParameter("ksmccx");
		String ssyfcx = request.getParameter("ssyfcx");
		List<Map<String,Object>> ygflmx=ygfltjService.getYgflmx(ksmccx, ssyfcx);
		List<Map<String,Object>> bmmc=cbtjservice.getBmmc(ksmccx);
		mav.addObject("ygflmx", ygflmx);
		mav.addObject("bmmc", bmmc);
		mav.addObject("ksmccx", ksmccx);
		mav.addObject("ssyfcx", ssyfcx);
		return mav;
	}
	
	@RequestMapping(value = "/KssrmxPage")
	public ModelAndView KssrmxPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String px = request.getParameter("px");
		String ksmccx = request.getParameter("ksmccx");
		String cxsjstr = request.getParameter("cxsjstr");
		String cxsjend = request.getParameter("cxsjend");
		List<Map<String,Object>> bmmc=cbtjservice.getBmmc(ksmccx);
		
		String url = "";
		ModelAndView mav = new ModelAndView();
		if (px.equals("1")) {
			url = "/zjpad/jyksmxPage";
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
			url = "/zjpad/ywksmxPage";
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
			url = "/zjpad/jszxmxPage";
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
			url = "/zjpad/glbmmxPage";
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
	@RequestMapping(value = "/getYpcxList")
	@ResponseBody
	public List<Map<String, Object>> getYpcxList(Integer start,Integer limit,String cs,String cxtj,Integer size){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=ypcxservice.getYpcxList(start, limit, cs,cxtj);
		int count=ypcxservice.getYpcxCount(start, limit, cs, cxtj);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping(value="/getBgcxList")
	@ResponseBody
	public List<Map<String, Object>> getBgcxList(Integer start,Integer limit,Integer size) throws ParseException{
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=bgcxService.getBgxx(start, limit);
		int count=bgcxService.getBgxxCount(start, limit);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping(value = "/getSbcxList")
	@ResponseBody
	public List<Map<String, Object>> getSbcxList(Integer start,Integer limit,String cs,String cxtj,Integer size){
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> value=sbcxservice.getYpcxList(start, limit, cs,cxtj);
		int count=sbcxservice.getYpcxCount(start, limit, cs, cxtj);
		for(int i=0;i<value.size();i++){
			Map<String,Object> map=value.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 根据传入的任务ID找到对应的FormKey并打开此FormKey指向的页面,
	 * 同时取得该任务环节配置的FORM变量(即此环节后面的连线变量),传至前台
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/openTaskDealPage/{taskId}/{businessKey}/{ypcs}")
	public ModelAndView openTaskDealPage(@PathVariable String taskId,@PathVariable String businessKey,@PathVariable String ypcs,HttpServletRequest request) {
		SysYh user = AppUtil.getCurrentUser();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userCode", user.getUsername());
		TaskFormData taskFormData = formService.getTaskFormData(taskId);
//		String formKey = taskFormData.getFormKey();
		String tname = taskFormData.getTask().getName();
		modelAndView.addObject("tname", tname);
		List<FormProperty> listProperty = taskFormData.getFormProperties();
		if (!listProperty.isEmpty()) {
			String lineVar = listProperty.get(0).getId();//获取传入下层的连线值
			modelAndView.addObject("lineVar", lineVar);
		}
		String url = "";
		if(ypcs.equals("2")){
			url="/zjpad/ypzjshApprove";
		}else if(ypcs.equals("3")){
			url="/zjpad/jszxpzApprove";
		}
		modelAndView.setViewName(url);
		// 查询对应业务数据传至处理页面
		if (StringUtils.hasText(businessKey)) {
			modelAndView.addObject("businessKey", businessKey);
			 List<Map<String, Object>> listmap= businessDao.getListProcessByYpbhb(businessKey,"","");
			String ypjyks="";
			if(listmap.size()>0) {
				Map<String, Object> mapBusi = listmap.get(0);
				ypjyks = mapBusi.get("jyksbh").toString();
			}
			 //根据报告编号获取审批建议信息
			 List<Map<String, Object>> listOption = yshJybDao.getYshJybListByYpbh(businessKey);
			 if(listOption.size()>0){
				 modelAndView.addObject("listOption",listOption);
			 }
			 String thisOrg = "";
			 String thisName = "";
			 if(user!=null){
				 thisOrg = user.getBmbh();
				 thisName = user.getUsername();
			 }
			 List<Map<String, Object>> listypzjUser = businessDao.getUserListByUserRoleAndorgCode(ypjyks,thisOrg, CpsConstant.ROLE_JYRY);
			 List<Map<String, Object>> listypzjshUser = businessDao.getUserListByUserRoleAndorgCodeQcdq(ypjyks,thisOrg, CpsConstant.ROLE_JYSHRY,thisName);
			 List<Map<String, Object>> jszxList = businessDao.getJszxbh(thisOrg);
			 if(jszxList.size()!=0){
			 		String jszxbh =jszxList.get(0).get("jszxbh").toString();
			 		List<Map<String, Object>> pzone= businessDao.getUserListByUserRoleAndorgCodeQcdq(ypjyks,jszxbh, CpsConstant.ROLE_GCJSZXPZR,thisName);
			 		List<Map<String, Object>> listypzjpzUser = new ArrayList<Map<String, Object>>();
			 		listypzjpzUser.addAll(pzone);
			 		if(listypzjpzUser.size()>0){
						 modelAndView.addObject("listypzjpzUser",listypzjpzUser);//传入批准人员
					 }
			 }
			 if(listypzjUser.size()>0){
				 modelAndView.addObject("listypzjUser",listypzjUser);//传入样品主检人员
			 }
			 if(listypzjshUser.size()>0){
				 modelAndView.addObject("listypzjshUser",listypzjshUser);//传入样品主检审核人员
			 }
			 if(listmap.size()>0){
			 Map<String, Object> mapBusi = listmap.get(0);
			 if (mapBusi != null) {
				 modelAndView.addObject("mapBusi", mapBusi);
			 }
			 //报告编制中样品修改时，获取样品信息
			 String id1 = mapBusi.get("id").toString();
			 List<Map<String, Object>> ypxx1 = yypYpxxService.getYpxx(Integer.parseInt(id1));
			 String djlxStr = ypxx1.get(0).get("djlx").toString();
			 String bgbhStr = ypxx1.get(0).get("bgbh").toString();
			 String sfzt = ypxx1.get(0).get("xgje").toString();
			 List<Map<String, Object>> list = yypYpxxService.getYpxx(Integer.parseInt(id1),djlxStr);
			 if (list != null) {
				 modelAndView.addObject("list", list);
			 }
			 List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbhStr);
				if (ysfxm != null) {
					modelAndView.addObject("ysfxm", ysfxm);
					int ysfxmLen = ysfxm.size();
					modelAndView.addObject("ysfxmLen", ysfxmLen);
					System.out.println(ysfxm.size());
				}
				List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
				List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
				List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
				List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
				List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
				List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
				List<Map<String, Object>> ypjyzt1 = yypYpxxService.getDicByJylx("ypjyzt");
				List<Map<String, Object>> cydw1 = yypYpxxService.getDicByJylx("jddw");
				List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
				List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
				List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
				List<Map<String, Object>> cydd = yypYpxxService.getDicByJylx("cydd");
				modelAndView.addObject("jylx",jylx);
				modelAndView.addObject("lyfs",lyfs);
				modelAndView.addObject("ypzt",ypzt);
				modelAndView.addObject("bgfsfs",bgfsfs);
				modelAndView.addObject("yhxtk",yhxtk);
				modelAndView.addObject("jyfydd",jyfydd);
				modelAndView.addObject("ypjyzt1",ypjyzt1);
				modelAndView.addObject("cydw1",cydw1);
				modelAndView.addObject("rwly",rwly);
				modelAndView.addObject("jjlx",jjlx);
				modelAndView.addObject("zslx",zslx);
				modelAndView.addObject("sfzt",sfzt);
				modelAndView.addObject("cydd",cydd);
			 
			 	String bgbh=mapBusi.get("bgbh").toString();
			 	request.setAttribute("bgbh", bgbh);
			 	List<Map<String, Object>> yp = yypYpxxService.getid(bgbh);
			 	if(yp.size() != 0){
					int ypid=Integer.parseInt(yp.get(0).get("id").toString());
					modelAndView.addObject("ypid", ypid);
					List<Map<String, Object>> shztList = bgxxservice.getShzt(businessKey); //审核状态
					if(shztList.size() != 0){
						String shzt = shztList.get(0).get("shzt").toString();
						modelAndView.addObject("shzt", shzt);
					}
					List<Map<String, Object>> pzztList = bgxxservice.getPzzt(businessKey); //批准状态
					if(pzztList.size() != 0){
						String pzzt = pzztList.get(0).get("shzt").toString();
						modelAndView.addObject("pzzt", pzzt);
					}
					YypYpxx ypxx = yypYpxxService.getYpxxById(ypid);
					modelAndView.addObject("ypxx", ypxx);
					List<Map<String, Object>> ypjyzt = bgxxservice.getYpzyzt("ypjyzt");
					modelAndView.addObject("ypjyzt", ypjyzt);
					String jyksbh = ypxx.getJyksbh();
					Integer mbfl = ypxx.getDjlx();
					String zh = ypxx.getZh();
					List<Map<String, Object>> b = bgxxservice.getThreeId(jyksbh, mbfl, zh);
						if(b.size() != 0){
							int fmid=Integer.parseInt(b.get(0).get("fm_id").toString());
							int syid=Integer.parseInt(b.get(0).get("sy_id").toString());
							int fyid=Integer.parseInt(b.get(0).get("fy_id").toString());
							modelAndView.addObject("fmid", fmid);
							modelAndView.addObject("syid", syid);
							modelAndView.addObject("fyid", fyid);
						}
					String djlx = mbfl.toString();
					List<Map<String, Object>> abc = bgxxservice.getBhszList(zh,djlx);
					if(abc.size() != 0){
						String fl = abc.get(0).get("zhfl").toString();
						List<Map<String, Object>> rztb = jyxxservice.getTbList(fl);
						modelAndView.addObject("rztb", rztb);
						List<Map<String, Object>> dwmc = jyxxservice.getDwList(fl);
						if(dwmc.size() != 0){
							String dw = dwmc.get(0).get("sub").toString();
							modelAndView.addObject("dw", dw);
						}
						List<Map<String, Object>> Pzz = jyxxservice.getPzzList(fl);
						if(Pzz.size() != 0){
							String pzz = Pzz.get(0).get("sub").toString();
							modelAndView.addObject("pzz", pzz);
						}
					}
					List<Map<String, Object>> c = bgxxservice.getbgxxList(bgbh);
					if(c.size() != 0){
						int bgid = Integer.parseInt(c.get(0).get("id").toString());
						YjyBgxx bgxx = bgxxservice.getbgxxById(bgid);
						String jyrq = bgxx.getJyrq();
						String cydw = bgxx.getCydw();
						String jyjl = bgxx.getJyjl();
						String rzfs = bgxx.getRzfs();
						String bsdx = bgxx.getBsdx();
						String jyqksm = bgxx.getJyqksm();
						String bztsbg = bgxx.getBz();
						modelAndView.addObject("jyrq",jyrq);
						modelAndView.addObject("jyqksm",jyqksm);
						modelAndView.addObject("cydw",cydw);
						modelAndView.addObject("jyjl",jyjl);
						modelAndView.addObject("rzfs",rzfs);
						modelAndView.addObject("bsdx",bsdx);
						modelAndView.addObject("bztsbg",bztsbg);
					}
				}
			 	List<Map<String, Object>> jllb1 = clyyservice.getDicByJylx("jllb1");
				List<Map<String, Object>> jllb2 = clyyservice.getDicByJylx("jllb2");
				modelAndView.addObject("jllb1", jllb1);
				modelAndView.addObject("jllb2", jllb2);
			 	modelAndView.addObject("bgbh",bgbh);
			 }
		}
		return modelAndView;
	}
	
}
