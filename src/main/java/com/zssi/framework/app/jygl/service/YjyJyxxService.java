package com.zssi.framework.app.jygl.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jybzgl.dao.YjyBzxxDao;
import com.zssi.framework.app.jybzgl.dao.YjyXmxxDao;
import com.zssi.framework.app.jybzgl.model.YjyBzxx;
import com.zssi.framework.app.jygl.dao.YjyBgzhDao;
import com.zssi.framework.app.jygl.dao.YjyJyxxDao;
import com.zssi.framework.app.jygl.dao.YjyRztbDao;
import com.zssi.framework.app.jygl.model.YjyJyxx;
import com.zssi.framework.app.jygl.model.YjySbxx;
import com.zssi.framework.app.sbgl.dao.YsbXxDao;
import com.zssi.framework.app.sbgl.model.YsbSyjl;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sbgl.service.YsbSyjlService;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.ypgl.dao.YypYpxxDao;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/**
 * 检验信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Service
public class YjyJyxxService extends BaseBO<YjyJyxx>{

	@Autowired
	private YjyJyxxDao dao;
	@Autowired
	private YypYpxxDao ypxxdao;
	@Autowired
	private YsbXxDao sbxxdao;
	@Autowired
	private YjyBzxxDao jybzdao;
	@Autowired
	private YjyXmxxDao jyxmdao;
	@Autowired
	private YjyRztbDao rztbdao;
	@Autowired
	private YsbXxService sbxxservice;
	@Autowired
	private YsbSyjlService sbsyjlservice;
	@Autowired
	private YjySbxxService jysbxxservice;
	@Autowired
	private YypYpxxService ypxxService;
	@Autowired
	private YjyBgzhDao bgzhdao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 后台：检验信息
	 * @author duanpeijun
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String , Object>> getJyxxList(Integer start,Integer limit,String canshu){
		return dao.getJyxxList(start, limit, canshu);
	}
	
	/**
	 * 催办状态（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByCbzt(String zdzl) {
		return dao.getDicByCbzt(zdzl);
	}
	
	/**
	 * 根据检验信息ID查询该表所有数据
	 * @author duanpeijun
	 * @date 2015年11月30日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyJyxx getJyxxById(Integer id) {
		YjyJyxx entity = dao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjyJyxx entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
	
	/**
	 * 从设备信息增加数据到检验设备信息表时，判断检验设备信息表中有无当前数据
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getjysbxxList(String sbbh){
		return dao.getjysbxxList(sbbh);
	}

	/**
	 * 从设备信息增加数据到设备使用记录表时，判断设备使用记录表中有无当前数据
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getsbsyjlList(String sbbh){
		return dao.getsbsyjlList(sbbh);
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击检验跳转的Jsp页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getJy(String id){
		return dao.getJy(id);
	}
	
	/**
	 * 根据样品信息的报告编号查询报告整合表中有无该报告编号的数据（样品信息的报告编号和检验信息的报告编号是相同的）
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getbgzhList(String bgbh){
		return bgzhdao.getbgzh(bgbh);
	}
	
	/**
	 * 根据样品信息的报告编号查询检验信息有无该条数据。（样品信息的报告编号和检验信息的报告编号是相同的）
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getjyxxList(String bgbh){
		return dao.getjyxxList(bgbh);
	}
	
	/**
	 * 检验页面————样品信息
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param bgbh   报告编号
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYp(String bgbh){
		return ypxxdao.getYp(bgbh);
	}
	
	/**
	 * 检验页面————设备页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param code    设备名称
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getSbxx(String code){
		return sbxxdao.getSbxx(code);
	}
	
	/**
	 * 检验页面————检验标准页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param code  检验标准名称
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getJybzxx(String code){
		return jybzdao.getJybzxx(code);
	}
	
	/**
	 * 检验页面————检验项目页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param bzbh    检验标准编号
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getJyxm(String bzbh,String code){
		return jyxmdao.getJyxm(bzbh,code);
	}
	
	/**
	 * 检验页面上显示的图标名称
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @return
	 */
	public List<Map<String, Object>> getTbList(String fl){
		return rztbdao.getTbList(fl);
	}
	
	/**
	 * 检验页面上的单位名称（隐藏）
	 * @author duanpeijun
	 * @date 2016年3月9日
	 * @param fl
	 * @return
	 */
	public List<Map<String, Object>> getDwList(String fl){
		return rztbdao.getDwList(fl);
	}
	
	/**
	 * 检验页面上的 批准章（隐藏）
	 * @author duanpeijun
	 * @date 2016年3月18日
	 * @param fl
	 * @return
	 */
	public List<Map<String, Object>> getPzzList(String fl){
		return rztbdao.getPzzList(fl);
	}
	
	/**
	 * 流程中----- 点击编制报告，查询出该条检验信息的认证图标
	 * @author duanpeijun
	 * @date 2015年12月1日
	 * @param rztb
	 * @return
	 */
	public List<Map<String, Object>> getlctb(String rztb){
		return rztbdao.getlctb(rztb);
	}
	
	
	/**
	 * 在设备信息页面点击提交获取该条设备信息的数据（根据id获取）
	 * @author duanpeijun
	 * @date 2015年11月12日
	 * @param id
	 * @return
	 */
	@Transactional
	public YsbXx getsbxx(String id){
		return sbxxdao.get(Integer.parseInt(id));
	}
	
	/**
	 * 选择设备信息提交保存到设备使用记录表中
	 * @author duanpeijun
	 * @date 2015年11月9日
	 * @param request
	 * @return
	 */
	@Transactional
	public String sbxxsavesbsjsl(HttpServletRequest request) {
		String str="";
		String sbxxid = request.getParameter("sbxxid");
		YsbXx sbxx = sbxxservice.getSbxxById(Integer.parseInt(sbxxid));
		YsbSyjl sbsyjl = new YsbSyjl();
		List<Map<String, Object>> b = this.getsbsyjlList(sbxx.getSbbh());
		sbsyjl.setSbbh(sbxx.getSbbh());
		sbsyjl.setSbtxm(sbxx.getEwmbh());
		sbsyjl.setSbmc(sbxx.getSbmc());
		sbsyjl.setSysj(Calendar.getInstance().getTime());
		sbsyjl.setSyzt(sbxx.getSyzt());
		if(b.size() != 0){
			sbsyjl.setId(Integer.parseInt(b.get(0).get("id").toString()));
			sbsyjlservice.update(sbsyjl);
		}else{
			sbsyjlservice.save(sbsyjl);
		}
		str="1";
		return str;
	}
	
	/**
	 * 选择设备信息提交保存到检验设备信息表中
	 * @author duanpeijun
	 * @date 2015年11月9日
	 * @param request
	 * @return
	 */
	@Transactional
	public String sbxxsavejysbxx(HttpServletRequest request) {
		String str="";
		String sbxxid = request.getParameter("sbxxid");
		YsbXx sbxx = sbxxservice.getSbxxById(Integer.parseInt(sbxxid));
		YjySbxx jysbxx=new YjySbxx();
		jysbxx.setSbbh(sbxx.getSbbh());
		Integer it = sbxx.getSyzt();
	    String syzt = it.toString();
		jysbxx.setSyqzt(syzt);
//		jysbxx.setDw(sbxx.getDw());    //单位
//		Integer num=0;
//		for (int i = 0; i < num; i++) {
//			String sysl=request.getParameter("sysl"+(i+1));
//			System.out.println("--------------1-------------->");
//		}
//		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
//			num=Integer.parseInt(request.getParameter("num"));
//		}
		List<Map<String, Object>> a = this.getjysbxxList(sbxx.getSbbh());
		if(a.size() != 0){
			jysbxx.setId(Integer.parseInt(a.get(0).get("id").toString()));
			jysbxxservice.update(jysbxx);
		}else{
			jysbxxservice.save(jysbxx);
		}
		str="1";
		return str;
	}
	
	
	
	/**
	 * 在检验标页面中点击提交，保存检验标准名称这个字段到样品检验页面的检验依据字段
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyBzxx getjybzmc(String id){
		return jybzdao.get(Integer.parseInt(id));
	}
	
	/**
	 * 检验页面的提交功能
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @param request
	 * @param id
	 * @return
	 */
	@Transactional
	public String tijiao(HttpServletRequest request,String[] rztbid) {
		String str="";
		str = this.sbxxsavesbsjsl(request);
		str = this.sbxxsavejysbxx(request);
		String id = request.getParameter("id");
		String bzbh = request.getParameter("bzbh");
		String yplx = request.getParameter("yplx");
		String jylb = request.getParameter("jylb");
		String djrq = request.getParameter("djrq");
		String jyyj = request.getParameter("jyyj");
		String zjr = request.getParameter("zjr");
		String jyrq = request.getParameter("ksrq");
		String hjtj = request.getParameter("hjtj");
		String xmms = request.getParameter("xmms");
		String jyff = request.getParameter("jyff");
		String pdyq = request.getParameter("pdyq");
		String jyfy = request.getParameter("jyfy");
		String jjfy = request.getParameter("jjfy");
		String qtfy = request.getParameter("qtfy");
		String swpd = request.getParameter("swpd");
		String bzpd = request.getParameter("bzpd");
		String jyjl = request.getParameter("jyjl");
		String rztbidStr = "";
		for(int i=0;i<rztbid.length;i++){
			if(i<rztbid.length-1){
				rztbidStr=rztbidStr+rztbid[i]+",";
			}else{
				rztbidStr=rztbidStr+rztbid[i];
			}
		}
		//System.out.println("----------1------------>"+rztbidStr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		YjyJyxx jyxx = dao.get(Integer.parseInt(id));
		jyxx.setYplb(yplx);         //样品类型
		jyxx.setJylb(jylb);         //检验类别
		try {
			Date rq  = sdf.parse(jyrq);            //	登记日期	String 转DATE
			System.out.println("--------------->使用日期"+rq);
			jyxx.setKsrq(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jyxx.setBzmc(jyyj);         //标准名称
		jyxx.setBzbh(bzbh);         //标准编号
		jyxx.setZjr(zjr);           //主检人
		try {
			Date rq  = sdf.parse(djrq);            //	检验日期	String 转DATE
			System.out.println("--------------->使用日期"+rq);
			jyxx.setDjrq(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jyxx.setHjtj(hjtj);         //环境条件
		jyxx.setXmms(xmms);         //项目描述
		jyxx.setJyff(jyff);         //检验方法
		jyxx.setPdyq(pdyq);         //判定要求
		BigDecimal fy1=new BigDecimal(jyfy);
		jyxx.setJyfy(fy1);          //检验费用
		BigDecimal fy2=new BigDecimal(jjfy);
		jyxx.setJjfy(fy2);          //加急费用
		BigDecimal fy3=new BigDecimal(qtfy);
		jyxx.setQtfy(fy3);          //其他费用
		jyxx.setSwpd(swpd);         //实物判定
		jyxx.setBzpd(bzpd);         //标识判定
		jyxx.setJyjl(jyjl);         //检验结论
		jyxx.setRzfs(rztbidStr);    //认证方式
		dao.update(jyxx);
		str="1";
		return str;
	}
	
	/**
	 * 在流程中提交————————本质：增加样品信息的报告编号字段相对应的检验信息
	 * @author duanpeijun
	 * @date 2015年11月29日
	 * @param request
	 * @return
	 */
	@Transactional
	public String lctijiao(HttpServletRequest request,String[] rztbid){
		String str="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ypid = request.getParameter("ypid");
		YjyJyxx jyxx = new YjyJyxx();
		YypYpxx ypxx = ypxxService.getYpxxById(Integer.parseInt(ypid));
		String bgbh = request.getParameter("bgbh");
		String yplx = request.getParameter("yplx");
		String jylx = request.getParameter("jylx");
		String djsj1 = request.getParameter("djsj");
		try {
			Date djsj = sdf.parse(djsj1);
			jyxx.setDjrq(djsj);              //登记日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String jyyj = request.getParameter("jyyj");
		String zjr  = request.getParameter("zjr");
		String ksrq1 = request.getParameter("ksrq");
		try {
			Date ksrq = sdf.parse(ksrq1);
			jyxx.setKsrq(ksrq);        		 //开始日期
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hjtj = request.getParameter("hjtj");
		String xmms = request.getParameter("xmms");
		String jyff = request.getParameter("jyff");
		String pdyq = request.getParameter("pdyq");
		String jyfy1 = request.getParameter("jyfy");
		BigDecimal jyfy = new BigDecimal(jyfy1);  
		String jjfy1 = request.getParameter("jjfy");
		BigDecimal jjfy = new BigDecimal(jjfy1);  
		String qtfy1 = request.getParameter("qtfy");
		BigDecimal qtfy = new BigDecimal(qtfy1);  
		BigDecimal fyhj = jyfy.add(jjfy).add(qtfy); //检验费用+加急费用+其他费用
		String jyqx1 = request.getParameter("jyqx");
		try {
			Date jyqx = sdf.parse(jyqx1);
			jyxx.setJyqx(jyqx);              //检验期限
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String bzbh = request.getParameter("bzbh");
		String rztbidStr = "";
		for(int i=0;i<rztbid.length;i++){
			if(i<rztbid.length-1){
				rztbidStr=rztbidStr+rztbid[i]+",";
			}else{
				rztbidStr=rztbidStr+rztbid[i];
			}
		}
		String swpd = request.getParameter("swpd");
		String bzpd = request.getParameter("bzpd");
		String jyjl = request.getParameter("jyjl");
		jyxx.setBgbh(bgbh);              //报告编号
		jyxx.setYpbh(ypxx.getYpbh());    //样品编号
		jyxx.setJylb(jylx);       		 //检验类别
		jyxx.setYplb(yplx);		  		 //样品类别
		jyxx.setBmbh(ypxx.getJyks());    //检验科室
		jyxx.setJyyj(jyyj);				 //检验依据
		jyxx.setBzbh(bzbh);              //检验标准编号
		jyxx.setBzmc(jyyj);              //检验标准名称
		jyxx.setZjr(zjr);                //主检人
		jyxx.setHjtj(hjtj);              //环境条件
		jyxx.setXmms(xmms);              //项目描述
		jyxx.setJyff(jyff);              //检验方法
		jyxx.setPdyq(pdyq);              //判定要求
//		jyxx.setQtsm(qtsm);				 //其他说明
		jyxx.setJyfy(jyfy);				 //检验费用
		jyxx.setJjfy(jjfy);              //检验费用
		jyxx.setQtfy(qtfy);           	 //其他费用
		jyxx.setFyhj(fyhj);              //费用合计
		jyxx.setRzfs(rztbidStr);         //认证方式
		jyxx.setSwpd(swpd);              //实物判定
		jyxx.setBzpd(bzpd);              //标准判定
		jyxx.setJyjl(jyjl);              //检验结论
		List<Map<String, Object>> a = this.getjyxxList(bgbh);
		if(a.size() != 0){
			jyxx.setId(Integer.parseInt(a.get(0).get("id").toString()));
			this.update(jyxx);
		}else{
			this.save(jyxx);
		}
		str="1";
		return str;
	}
}
