package com.zssi.framework.app.sys.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.likegene.framework.core.BaseController;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.sys.service.HomePageService;
import com.zssi.framework.app.tjgl.service.BgcxService;
import com.zssi.framework.app.util.AppUtil;

@Controller
@RequestMapping(value = "/sys/home")
public class HomePageController extends BaseController{

	@Autowired
	private HomePageService service;
	
	@Autowired
	private BgcxService bgcxservice;
	
	@RequestMapping(value = "/Rwlb")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/sys/home/Rwlb");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Rwlb = service.getRwlblist();
		if (Rwlb != null) {
			mav.addObject("Rwlb", Rwlb);
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/index")
	public ModelAndView indexPage(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		ModelAndView mav = new ModelAndView();
		String url = "";
		url = "/sys/home/index";
		SysYh yh = AppUtil.getCurrentUser();
		String rolename = service.getRoleByYh(yh);
//		String bm = yh.getBmbh();
		List<Map<String,Object>> ndzsf=service.getNdzsf();
		List<Map<String,Object>> cbfy=service.getCbfy();
		if(ndzsf.size()!=0){
			mav.addObject("ndzsf", ndzsf.get(0).get("je"));
		}else{
			mav.addObject("ndzsf", 0);
		}
		
		List<Map<String,Object>> bgsf=service.getBgzsf();
		if(bgsf.size()!=0){
			mav.addObject("bgsf", bgsf.get(0).get("je"));
		}else{
			mav.addObject("bgsf", 0);
		}
		
//		报告预警
		List<Map<String,Object>> bgyj=bgcxservice.getBgxxindex(0,10);
		mav.addObject("bgyj", bgyj);
		List<Map<String,Object>> bgyj1=bgcxservice.getBgxxindex1(0,10);
		mav.addObject("bgyj1", bgyj1);
		
		mav.addObject("bgzs", service.getBgzs());
		mav.addObject("cbfy", cbfy.get(0).get("je"));
		
		//客户业务量
		List<Map<String,Object>> aybgsf=service.getBgsf();
		mav.addObject("aybgsf", aybgsf);
		//科室费用统计
		List<Map<String,Object>> ywkssf=service.getYwkssf();
		mav.addObject("ywkssf", ywkssf);
		//科室费用排行
		List<Map<String,Object>> ywksph=service.getYwkssfph();
		mav.addObject("ywksph", ywksph);
		//科室费用饼图
		List<Map<String,Object>> ywksbt=service.getYwksBt();
		Gson gson = new Gson();
		mav.addObject("ywksbt", gson.toJson(ywksbt));
		//当月新增客户量
		List<Map<String,Object>> yxzkhl=service.getYxzkhl();
		mav.addObject("yxzkhl", yxzkhl);
		//当月客户拜访量
		List<Map<String,Object>> ykhbfl=service.getYkhbfl();
		mav.addObject("ykhbfl", ykhbfl);
		//客户业务量
		List<Map<String,Object>> khywl=service.getBgsf();
//		现有客户量
		List<Map<String,Object>> xykhl=service.getXykhl();
		mav.addObject("xykhl", xykhl);
		if("ROLE_YLD".equalsIgnoreCase(rolename)){//院领导
			url = "/sys/home/index";
		}else if("ROLE_GCJSZXPZR".equalsIgnoreCase(rolename)){//工程技术中心主任
			url = "/sys/home/indexgcjs";
			mav.addObject("aybgsf", aybgsf);
			mav.addObject("bzgqtx", service.getBzgq());
			mav.addObject("kyxmjd", service.getKyxm());
//			mav.addObject("jcsph", service.getJcs(bm));
			mav.addObject("jcsph", service.getJcs());
			mav.addObject("bgjd", service.getBgjd());
			
		}else if("ROLE_JYRY".equalsIgnoreCase(rolename)){//检验人员
			url = "/sys/home/indexjyry";
			List<Map<String,Object>> Rwlb=service.getRwlb();
			mav.addObject("Rwlb", Rwlb);
//			人员工作汇总
			List<Map<String,Object>> Gzhz=service.getGzhz();
			mav.addObject("Gzhz", Gzhz);
			mav.addObject("sbqk", service.getSbqk());
			mav.addObject("jfqk", service.getJfqk());
//			报告预警
			mav.addObject("bgyj", bgyj);
			mav.addObject("bgyj1", bgyj1);
			
		}else if("ROLE_XZGLJS".equalsIgnoreCase(rolename)){//行政管理角色
//			*************************************************************行政管理角色********************************************************
			url = "/sys/home/indexxzb";
			mav.addObject("dazs", service.getDazs());
			mav.addObject("hthz", service.getHthz());
			mav.addObject("cgtj", service.getCgtj());
			List<Map<String,Object>> dwsf=service.getDwsf();
			if(dwsf.size()!=0){
				mav.addObject("dwsf", dwsf.get(0).get("je"));
			}else{
				mav.addObject("dwsf", 0);
			}
			//单位收费汇总
			List<Map<String,Object>> dwsfhz=service.getDwsfhz();
			mav.addObject("dwsfhz", dwsfhz);
//			检测室收入
			List<Map<String,Object>> jcssr=service.getJcssr();
			String dasrtj="[";
			String data="";
			for(int i=0;i<jcssr.size();i++) {
				data+=jcssr.get(i).get("je")+",";
			}
			dasrtj=dasrtj+data.substring(0,data.length()-1)+"]";
			mav.addObject("jcssr", dasrtj);
			mav.addObject("jcssrData", jcssr);
            //档案统计
			List<Map<String,Object>> Datj=service.getDatj();
			mav.addObject("Datj", Datj);
//			检验科室总收费
			List<Map<String,Object>> zsf=service.getZsf();
			if(zsf.size()!=0){
				mav.addObject("zsf", zsf.get(0).get("je"));
			}else{
				mav.addObject("zsf", 0);
			}
//			获取当前月份
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis( System.currentTimeMillis());
			int dqyf = cal.get(Calendar.MONTH) + 1; // 因为月是从0开始算起的，所以加个1
			mav.addObject("dqyf", dqyf);
//			业务科室收入
			List<Map<String,Object>> ywkssr=service.getYwkssr();
			String dasrtj1="[";
			String data1=" ";
			for(int i=0;i<ywkssr.size();i++) {
				data1+=ywkssr.get(i).get("je")+",";
			}
			dasrtj1=dasrtj1+data1.substring(0,data1.length()-1)+"]";
			mav.addObject("ywkssr", dasrtj1);
//			业务科室总收费
			List<Map<String,Object>> ywzsf=service.getYwzsf();
			if(ywzsf.size()!=0){
				mav.addObject("ywzsf", ywzsf.get(0).get("je"));
			}else{
				mav.addObject("ywzsf", 0);
			}
			
		   }else if("ROLE_YWQT".equalsIgnoreCase(rolename)){//样品登记角色
			url = "/sys/home/indexypdj";
		}
		/*************************************************************业务部**************************************************************************/
		else if("ROLE_YWBMJS".equalsIgnoreCase(rolename)){//业务科室主任
			url = "/sys/home/indexywb";
			//客户业务量
			mav.addObject("khywl", khywl);
			//当月客户拜访量
			mav.addObject("ykhbfl", ykhbfl);
//			现有客户量
			mav.addObject("xykhl", xykhl);
			mav.addObject("bgjd", service.getBgjd()); //报告进度
			mav.addObject("gzlhz", service.getGzlhz());//工作量总汇
			List<Map<String,Object>> ywjfqk=service.getJfqk1();//缴费情况
			if(ywjfqk.size()!=0){
				mav.addObject("ywjfqk", ywjfqk.get(0).get("je"));
			}else{
				mav.addObject("jfqk", 0);
			}  
			List<Map<String,Object>> ywysr=service.getywYsr();//月收入
			if(ywysr.size()!=0){
				mav.addObject("ywysr", ywysr.get(0).get("je"));
			}else{
				mav.addObject("ywysr", 0);
			}  
			List<Map<String,Object>> ywnsr=service.getNsr();//年收入
			if(ywnsr.size()!=0){
				mav.addObject("ywnsr", ywnsr.get(0).get("je"));
			}else{
				mav.addObject("ywnsr", 0);
			}  
			//今年收入统计
			List<Map<String, Object>> dnsrtj1=service.getDnsrtj1();
			String dasrtj="[";
			String data="";
			for(int i=0;i<dnsrtj1.size();i++) {
				data+=dnsrtj1.get(i).get("je")+",";
			}
			dasrtj=dasrtj+data.substring(0,data.length()-1)+"]";
			mav.addObject("dnsrtj1", dasrtj);
            //去年收入
			List<Map<String, Object>> dnsrtj2=service.getDnsrtj2();
			 dasrtj="[";
			 data="";
			for(int i=0;i<dnsrtj2.size();i++) {
				data+=dnsrtj2.get(i).get("je")+",";
			}
			dasrtj=dasrtj+data.substring(0,data.length()-1)+"]";
			mav.addObject("dnsrtj2", dasrtj);
			//客户信息统计
			List<Map<String,Object>> khxxtjywl=service.getBgsf();
			mav.addObject("khxxtjywl", khxxtjywl);
			//当月新增客户量
			List<Map<String,Object>> khxzl=service.getYxzkhl();
			mav.addObject("khxzl", khxzl);
			mav.addObject("Bgsf", service.getBgsf1());
			//业务月排行
			mav.addObject("Ywyph", service.getYwypx1());
			//业务月排行当前月份
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis( System.currentTimeMillis());
			int dqyf = cal.get(Calendar.MONTH) + 1; // 因为月是从0开始算起的，所以加个1
			mav.addObject("dqyf", dqyf);
			
		}else if("ROLE_JYSHRY".equalsIgnoreCase(rolename) || "ROLE_KSZR".equalsIgnoreCase(rolename)){//检测室主任
			url="/sys/home/indexjys";
			mav.addObject("bzgqtx", service.getBzgq());
			mav.addObject("sbqk", service.getSbqk());
			mav.addObject("jfqk", service.getJfqk());
			mav.addObject("ayxysf", service.getJyfy());
			mav.addObject("ayqtsf", service.getQtfy());
			mav.addObject("bgyj", bgyj);
			mav.addObject("bgyj1", bgyj1);
			if(bgsf.size()!=0){
				mav.addObject("bgsf", bgsf.get(0).get("je"));
			}else{
				mav.addObject("bgsf", 0);
			}
			if(service.getxysfhj().size()!=0){
				mav.addObject("xysf", service.getxysfhj().get(0).get("je"));
			}else{
				mav.addObject("xysf", 0);
			}
			if(service.getqtsfhj().size()!=0){
				mav.addObject("qtsf", service.getqtsfhj().get(0).get("je"));
			}else{
				mav.addObject("qtsf", 0);
			}
			
		}else if("ROLE_ADMIN".equalsIgnoreCase(rolename)||"ROLE_WXPTGL".equalsIgnoreCase(rolename)){
			url = "/sys/home/index";
		}else{
//			*************************************************************院职工********************************************************
			url = "/sys/home/indexyzg";
			//客户业务量
			mav.addObject("khywl", khywl);
			//当月客户拜访量
			mav.addObject("ykhbfl", ykhbfl);
//			现有客户量
			mav.addObject("xykhl", xykhl);
			mav.addObject("ayxysf", service.getJyfy());
			mav.addObject("ayqtsf", service.getQtfy());
			if(bgsf.size()!=0){
				mav.addObject("bgsf", bgsf.get(0).get("je"));
			}else{
				mav.addObject("bgsf", 0);
			}
			if(service.getxysfhj().size()!=0){
				mav.addObject("xysf", service.getxysfhj().get(0).get("je"));
			}else{
				mav.addObject("xysf", 0);
			}
			if(service.getqtsfhj().size()!=0){
				mav.addObject("qtsf", service.getqtsfhj().get(0).get("je"));
			}else{
				mav.addObject("qtsf", 0);
			}
			//当月新增客户量
			List<Map<String,Object>> khxzl=service.getYxzkhl();
			mav.addObject("khxzl", khxzl);
			
			List<Map<String,Object>> Rwlb=service.getRwlb();
			mav.addObject("Rwlb", Rwlb);

//			人员工作汇总
			List<Map<String,Object>> Gzhz=service.getGzhz();
			mav.addObject("Gzhz", Gzhz);
//			报告预警
			mav.addObject("bgyj", bgyj);
			mav.addObject("bgyj1", bgyj1);
		}
		mav.setViewName(url);
		return mav;
	}
}
