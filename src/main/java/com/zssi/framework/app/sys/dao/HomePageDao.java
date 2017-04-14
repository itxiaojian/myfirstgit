package com.zssi.framework.app.sys.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zssi.framework.app.util.AppUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.sys.model.SysYh;

/** 
 * @author:zhangyi 
 * @version 创建时间：2015年12月17日 上午9:40:37 
 * 类说明 
 */
@Repository
public class HomePageDao extends HibernateBaseDaoImpl<SysYh,Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据用户找出角色
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月17日 上午10:48:38 
	 * @param yh
	 * @return
	 */
	public List<Map<String, Object>> getRoleByYh(SysYh yh) {
		String sql = "";
		sql = "select a.jsbh,a.jsmc,b.yhbh from sys_js a,sys_yh b,sys_yhjs c where b.yhbh=c.yhbh and c.jsbh=a.jsbh and b.yhbh=?";
		return jdbcTemplate.queryForList(sql,yh.getYhbh());
	}
	
	/**
	 * 报告费用统计
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getBgsf(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="SELECT a.zdz as yf, nvl(sum(b.BCSS)/10000,'0') as je,nvl(sum(b.BCSS)/10000/1000*100,'0') as bfb FROM "
				+ "(SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a left join (select bcss,to_char(JYJSRQ,'MM')as jyjsrq from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')='"+sim.format(new Date())+"') b on "
				+ "a.zdz=to_number(b.JYJSRQ)  group by a.zdz order by to_number(a.zdz)";
		
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 业务科室收费统计
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYwkssf(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select a.bmmc, nvl(sum(b.BCSS)/10000,'0') as je,nvl(sum(b.BCSS)/10000/500*100,'0') as bfb from "
				+ "(SELECT BMBH, BMMC FROM SYS_ZZJG where SJBH ='100230') a "
				+ "left join Y_CW_BGSFJL b on a.bmbh=b.ssywks(+) where to_char(b.JYJSRQ,'yyyy')='"+sim.format(new Date())+"' or b.JYJSRQ is null group by a.bmmc,a.bmbh order by a.bmbh";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 业务科室收费排行
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYwkssfph(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select d.bmmc,d.je,d.bfb,c.rs from (select a.bmmc,a.bmbh, nvl(sum(b.BCSS)/10000,'0') as je,nvl(sum(b.BCSS)/10000/500*100,'0') as bfb "
				+ "from (SELECT BMBH, BMMC FROM SYS_ZZJG where SJBH ='100230') a left join Y_CW_BGSFJL b on a.bmbh=b.ssywks "
				+ "where to_char(b.JYJSRQ,'yyyy')='"+sim.format(new Date())+"' "
				+ "group by a.bmmc,a.bmbh) d left join (select b.bmbh,count(a.yhbh) as rs from SYS_YH a left join SYS_ZZJG b on a.bmbh=b.bmbh group by b.bmbh) c "
				+ "on d.BMBH=c.BMBH order by d.bmbh";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 工程技术主任查看标准过期提醒
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getBzgq(){
		String sql="select a.bzmc,to_char(a.qyrq,'yyyy-mm-ss') as qyrq,to_char(a.fzrq,'yyyy-mm-ss') as fzrq from y_jy_bzxx a where 1 = 1 ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 科研项目进度查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getKyxm(){
		String sql="select a.kymc,to_char(a.kssj,'yyyy-mm-ss') as kssj,b.bmmc as ks_id from y_ky_xxgl a left join sys_zzjg b "
				+ "on a.ks_id = b.id where 1 = 1 ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检测室排行查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getJcs(){
		String sql="select sum(c.rws)as rws,c.assignee_ as name_,e.bmmc as jyks from (select count(a.start_time_)as rws,a.assignee_,b.business_key_ from "
				+ "ACT_HI_TASKINST a left join act_hi_procinst b on a.proc_inst_id_ = b.proc_inst_id_ where to_char(a.end_time_,'yyyy') = to_char(sysdate,'yyyy') "
				+ "group by a.assignee_,a.assignee_,b.business_key_ )c left join y_yp_ypxx d on c.business_key_ = d.id left join sys_zzjg e on d.jyks = e.id "
				+ "group by c.assignee_,e.bmmc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 报告进度查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getBgjd(){
		String sql= "select k.bmmc as jyks,j.ywc,i.wwc from (select count(1) as ywc,g.jyks from(SELECT e.BUSINESS_KEY_ AS businessKey,f.jyks FROM(SELECT t.*  "  
		           + " FROM ACT_HI_PROCINST t,ACT_RE_PROCDEF k WHERE t.PROC_DEF_ID_ = k.ID_ AND k.KEY_ = 'zjyProcess' AND NOT EXISTS (SELECT b.PROC_INST_ID_  "    
		             + " FROM ACT_RU_EXECUTION b WHERE t.PROC_INST_ID_ = b.PROC_INST_ID_ )) e INNER JOIN y_yp_ypxx f ON e.BUSINESS_KEY_ = f.id WHERE 1 = 1 ) g "
		             + " GROUP BY g.jyks )j left join (select count(1) as wwc,h.jyks  from(SELECT e.BUSINESS_KEY_ AS businessKey,f.jyks FROM (SELECT  DISTINCT t.*, "
		             + " b.ACT_ID_ FROM ACT_HI_PROCINST t,ACT_RU_EXECUTION b,ACT_RE_PROCDEF c WHERE t.PROC_INST_ID_ = b.PROC_INST_ID_ AND t.PROC_DEF_ID_ = c.ID_ " 
		             + " AND b.ACT_ID_ IS NOT NULL AND c.KEY_ = 'zjyProcess') e LEFT JOIN y_yp_ypxx f ON e.BUSINESS_KEY_ = f.id  WHERE 1 = 1 ) h GROUP BY h.jyks)i "
		             + " on j.jyks= i.jyks left join sys_zzjg k on i.jyks = k.id ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 设备情况查看
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getSbqk(){
		String sql="select * from(select a.sbmc,to_char(a.gmrq,'yyyy-mm-ss') as gmrq,b.zdmc as syzt from y_sb_xx a "
				+ "left join (select zdmc,zdz from sys_sjzd where zl='syzt'and jb=2) b on a.syzt = b.zdz) where rownum<=100";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 缴费情况查看
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getJfqk(){
		String sql=  "select a.bgbh,a.ypmc,a.jyfy,a.ysfje from y_cw_bgsf a where a.jyfy >0 order by a.jyjsrq desc ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 按月协议费用统计
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getJyfy(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql=  "SELECT a.zdz as yf, nvl(sum(b.BCSS)/10000,'0') as je,nvl(sum(b.BCSS)/10000/10000*100,'0') as bfb FROM "
				+ "(SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a left join (select * from Y_CW_FWXYSFJL where to_char(SFRQ,'yyyy')='"+sim.format(new Date())+"') b on "
				+ "a.zdz=to_number(to_char(b.SFRQ,'MM'))  group by a.zdz order by to_number(a.zdz) ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 按月其他费用统计
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getQtfy(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql=  "SELECT a.zdz as yf, nvl(sum(b.SFJE)/10000,'0') as je,nvl(sum(b.SFJE)/10000/10000*100,'0') as bfb FROM "
				+ "(SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a left join (select * from Y_CW_GLBMSF where to_char(SFRQ,'yyyy')='"+sim.format(new Date())+"') b on "
				+ "a.zdz=to_number(to_char(b.SFRQ,'MM'))  group by a.zdz order by to_number(a.zdz) ";
		return jdbcTemplate.queryForList(sql);
	}
	/**
	 * 协议总收费合计
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getxysfhj(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql= " select nvl(sum(BCSS)/10000,'0') as je from Y_CW_FWXYSFJL where to_char(SFRQ,'yyyy')='"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 其他总收费合计
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getqtsfhj(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql= " select nvl(sum(SFJE)/10000,'0') as je from Y_CW_GLBMSF where to_char(SFRQ,'yyyy')='"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql);
	}
	/**
	 * 业务科室收费饼图
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYwksBt(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select a.bmmc as \"label\",case when zje='0' then 0 else "
				+ "round(nvl(sum(b.BCSS)/c.zje*100,'0')) end as \"value\" from (SELECT BMBH, BMMC "
				+ "FROM SYS_ZZJG where SJBH = '100230') a left join  "
				+ "Y_CW_BGSFJL b on a.bmbh=b.ssywks and to_char(b.JYJSRQ,'yyyy')='"+sim.format(new Date())+"' left join (select nvl(sum(BCSS),'0') as zje "
				+ "from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')='"+sim.format(new Date())+"' ) c on 1=1 group by a.bmmc,a.bmbh,c.zje order by a.bmbh";
		return jdbcTemplate.queryForList(sql);
	}
	/**
	 * 当月新增客户量
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYxzkhl(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="SELECT a.zdz as yf,count(b.id) as rs  FROM (SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a "
				+ "left join ( select * from Y_KH_KHXX where to_char(LRSJ,'yyyy')='"+sim.format(new Date())+"' ) b on a.zdz=to_number(to_char(b.LRSJ,'MM')) "
				+ "group by a.zdz order by to_number(a.zdz)";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 当月新增客户量
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYkhbfl(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="SELECT a.zdz as yf,count(b.id) as rs  FROM (SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a "
				+ "left join ( select * from Y_KH_KHHF where to_char(BFRQ,'yyyy')='"+sim.format(new Date())+"' ) b on a.zdz = to_number(to_char(b.BFRQ,'MM')) "
				+ "group by a.zdz order by to_number(a.zdz)";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 现有客户量
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getXykhl(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="SELECT a.zdz as yf,count(b.id) as rs  FROM (SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a "
				+ "left join ( select * from Y_KH_KHXX where to_char(LRSJ,'yyyy')='"+sim.format(new Date())+"' ) b on a.zdz = to_number(to_char(b.LRSJ,'MM')) "
				+ "group by a.zdz order by to_number(a.zdz)";
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 年度总收费
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getNdzsf(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select nvl(sum(BCSS)/10000,'0') as je from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')='"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 报告收费
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getBgzsf(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select nvl(sum(BCSS)/10000,'0') as je from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')='"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 报告总数
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public int getBgzs(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select id,bgbh from Y_JY_BGXX where substr(JYRQ,0,4) ='"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql).size();
	}

	/**
	 * 成本费用
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getCbfy(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="select nvl(sum(JE)/10000,'0') as je from Y_CW_CBMX where to_char(FSSJ,'yyyy')='"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 档案总数
	 * @author liangkaidi
	 * @date 2015-12-25
	 * @return
	 */
	public int getDazs() {
		String  sql="select id  from y_da_xx  where 1 = 1";
		return jdbcTemplate.queryForList(sql).size();
	}

/**
 * 工作量汇总
 * @author liangkaidi
 * @date 2015-12-28
 * @return
 */
	public int getGzlhz() {
		String  sql="select id ypbh from y_yp_ypxx  where 1=1";
		return jdbcTemplate.queryForList(sql).size();
	}
	
	/**
	 * 单位收费
	 * @author liangkaidi
	 * @date 2015-12-28
	 * @return
	 */
	public List<Map<String,Object>> getDwsf(){
		String sql = "select sum(bcss)/10000 as je  from (select bcss from y_cw_jsfwxysf union  select bcss from y_cw_bgsfjl union  select sfje from y_cw_glbmsf)";
		return jdbcTemplate.queryForList(sql);
	}
/**
 * 合同汇总
 * @author liangkaidi
 * @date 2015-12-28
 * @return
 */
	public int getHthz() {
		String  sql="select a.jyhth from y_yp_ypxx a WHERE 1=1";
		return jdbcTemplate.queryForList(sql).size();
	}
/**
 * 采购统计
 * @author liangkaidi
 * @date 2015-12-28
 * @return
 */
public int getCgtj() {
	return 0;
}
/**
 * 缴费情况
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getJfqk1() {
	String sql ="select sum(ysfje)/10000 as je  from (select ysfje from y_cw_bgsf union select ysfje from y_cw_jsfwxysf) ";
	
	return jdbcTemplate.queryForList(sql);
}
/**
 * 业务月收入
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getywYsr() {
	SimpleDateFormat sim=new SimpleDateFormat("mm");
	String sql ="select nvl(sum(ysfje)/10000,0) as je from (select sum(nvl(a.ysfje,0)) ysfje from y_cw_bgsfjl a where to_char(JYJSRQ,'mm')='"+sim.format(new Date())+
			"' union all select sum(nvl(b.ysfje,0)) ysfje from y_cw_jsfwxysf b where to_char(SXRQ,'mm')='"+sim.format(new Date())+"')";
    return jdbcTemplate.queryForList(sql);
}
/**
 * 年收入
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getNsr() {
	SimpleDateFormat sim=new SimpleDateFormat("yyyy");
	String sql ="select nvl(sum(ysfje)/10000,0) as je from (select sum(nvl(a.ysfje,0)) ysfje from y_cw_bgsfjl a where to_char(JYJSRQ,'yyyy')='"+sim.format(new Date())+
			"' union all select sum(nvl(b.ysfje,0)) ysfje from y_cw_jsfwxysf b where to_char(SXRQ,'yyyy')='"+sim.format(new Date())+"')";
	return jdbcTemplate.queryForList(sql);
	
}
/**
 * 去年收入
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getDnsrtj2() {
	String sql="select sum(nvl(je,0))/10000 je from \n" +
			"(\n" +
			"SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2\n" +
			")b\n" +
			"left join\n" +
			"(\n" +
			"select nvl(BCSS,0) je ,to_char(JYJSRQ,'mm') yf from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')=to_char(ADD_MONTHS(sysdate,-12),'yyyy') \n"+
			"union all\n" +
			"select nvl(BCSS,0) je, to_char(SFRQ,'mm') yf from Y_CW_FWXYSFJL where to_char(SFRQ,'yyyy')=to_char(ADD_MONTHS(sysdate,-12),'yyyy') \n" +
			"union all\n" +
			"select nvl(SFJE,0) je,to_char(SFRQ,'mm') yf from Y_CW_GLBMSF where to_char(SFRQ,'yyyy')=to_char(ADD_MONTHS(sysdate,-12),'yyyy') \n"+
			")a \n" +
			"on a.yf = b.zdz\n" +
			"group BY b.zdz order by to_number(b.zdz)";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 今年收入
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */

public List<Map<String, Object>> getDnsrtj1() {
	String sql="select sum(nvl(je,0))/10000 je from \n" +
			"(\n" +
			"SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2\n" +
			")b\n" +
			"left join\n" +
			"(\n" +
			"select nvl(BCSS,0) je ,to_char(JYJSRQ,'mm') yf from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')=to_char(sysdate,'yyyy')\n"+
			"union all\n" +
			"select nvl(BCSS,0) je, to_char(SFRQ,'mm') yf from Y_CW_FWXYSFJL where to_char(SFRQ,'yyyy')=to_char(sysdate,'yyyy') \n"+
			"union all\n" +
			"select nvl(SFJE,0) je,to_char(SFRQ,'mm') yf from Y_CW_GLBMSF where to_char(SFRQ,'yyyy')=to_char(sysdate,'yyyy')\n"+
			")a \n" +
			"on a.yf = b.zdz\n" +
			"group BY b.zdz order by to_number(b.zdz)";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 客户现有量
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public int getKhxyl() {
	String  sql="select a.id from y_kh_khxx a WHERE 1=1";
	return jdbcTemplate.queryForList(sql).size();
}

public List<Map<String, Object>> getBgsf1() {
	SysYh user=AppUtil.getCurrentUser();
	String str="";
	List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
	List<Map<String,Object>> jsbm=this.getBm("100230", user.getBmbh());//判断当前登录人是否是业务科
	if(jybm.size()!=0){
		str=str+" and a.ssywks='"+user.getBmbh()+"' ";
	}else if(jsbm.size()!=0){
		str=str+" and a.ssywks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
	}
		String sql = "select a.sfr,sum(a.jyfy)as ydk,sum(a.ysfje)as sdk from y_cw_bgsfjl a where 1 =1"+str+" group by a.sfr";
		return jdbcTemplate.queryForList(sql);
		
	}

public List<Map<String, Object>> getYwypx1() {
	String sql = " select count(*) as cishu,t.djry from Y_YP_YPXX t group by t.djry order by cishu desc ";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 档案统计
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getDatj() {
	String sql = " select count(*) as cishu,t.dalx from Y_DA_XX t group by t.dalx  ";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 单位收费汇总
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getDwsfhz() {
	String sql="select sum(nvl(je,0))/10000 je,b.zdz yf,sum(nvl(je,0))/10000*100 bfb from \n" +
			" (\n" +
			"         SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2\n" +
			"         )b\n" +
			"          left join\n" +
			"        (\n" +
			"        select nvl(BCSS,0) je ,to_char(JYJSRQ,'mm') yf from Y_CW_BGSFJL where to_char(JYJSRQ,'yyyy')=to_char(sysdate,'yyyy') \n" +
			"        union all\n" +
			"         select nvl(BCSS,0) je, to_char(SFRQ,'mm') yf from Y_CW_FWXYSFJL where to_char(SFRQ,'yyyy')=to_char(sysdate,'yyyy') \n" +
			"         union all\n" +
			"         select nvl(SFJE,0) je,to_char(SFRQ,'mm') yf from Y_CW_GLBMSF where to_char(SFRQ,'yyyy')=to_char(sysdate,'yyyy') \n" +
			"         )a \n" +
			"         on a.yf = b.zdz\n" +
			"         group BY b.zdz order by to_number(b.zdz)";
	return jdbcTemplate.queryForList(sql);
}

/**
 * 检测室收入
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getJcssr() {
	String sql="select sum(bcss)/10000 as je  from(select bcss,ks_id  from y_cw_bgsf where  to_char(JYJSRQ,'mm')=to_char(sysdate,'mm') "
			+ "union all select bcss,jyks_id as ks_id from  y_cw_jsfwxysf where to_char(SXRQ,'mm')=to_char(sysdate,'mm') ) group by ks_id";
	
	return jdbcTemplate.queryForList(sql);
}
/**
 * 总收费
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getZsf() {

	String sql ="select sum(bcss)/10000 as je from (select sum(nvl(a.bcss,0)) bcss from y_cw_bgsf a where to_char(JYJSRQ,'mm')=to_char(sysdate,'mm')union "
			+ "all select sum(nvl(b.bcss,0)) bcss from y_cw_jsfwxysf b where to_char(SXRQ,'mm')=to_char(sysdate,'mm'))";
    return jdbcTemplate.queryForList(sql);
     
}
/**
 * 业务科室总收入
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getYwzsf() {
	String sql ="select sum(bcss)/10000 as je from (select sum(nvl(a.bcss,0)) bcss from y_cw_bgsf a where to_char(JYJSRQ,'mm')=to_char(sysdate,'mm') "
			+ "union all select sum(nvl(b.bcss,0)) bcss from y_cw_jsfwxysf b where to_char(SXRQ,'mm')=to_char(sysdate,'mm'))";
    return jdbcTemplate.queryForList(sql);
}
/**
 * 业务科室收入
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getYwkssr() {
	String  sql="select sum(bcss)/10000 as je from(select bcss,ssywks  from y_cw_bgsf where to_char(JYJSRQ,'mm')=to_char(sysdate,'mm') "
			+ "union all select bcss,ywks_id as ssywks from y_cw_jsfwxysf where to_char(SXRQ,'mm')=to_char(sysdate,'mm') ) group by ssywks";
	return jdbcTemplate.queryForList(sql);

}

/**
 * 任务列表
 * @author liangkaidi
 * @date 2015-12-31
 * @return
 */
public List<Map<String, Object>> getRwlb() {
	String str="";
	str=str+this.getBmxx(str);
	String sql="select c.stime,c.assignee_ as name,d.bgbh from (select to_char(a.start_time_,'yyyy-MM-dd') as stime,a.assignee_,b.business_key_ from "
			+ "ACT_HI_TASKINST a left join act_hi_procinst b on a.proc_inst_id_ = b.proc_inst_id_ where to_char(a.start_time_,'yyyy') "
			+ "= to_char(sysdate,'yyyy')and a.end_time_ is null)c left join y_yp_ypxx d on c.business_key_ = d.id where c.assignee_ is not null " +str+ " "
			+ "order by c.stime desc";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 人员工作汇总查询
 * @author liusong
 * @date 2015-12-31
 * @return
 */
public List<Map<String, Object>> getGzhz() {
	String str="";
	str=str+this.getBmxx(str);
	String sql="select sum(c.srws)as srws,sum(c.erws)as erws,c.assignee_ as name_,e.bmmc as jyks from (select count(a.start_time_)as srws,"
			+ "count(a.end_time_)as erws,a.assignee_,b.business_key_ from ACT_HI_TASKINST a left join act_hi_procinst b on a.proc_inst_id_ "
			+ "= b.proc_inst_id_ where to_char(a.start_time_,'yyyy') = to_char(sysdate,'yyyy') group by a.assignee_,a.assignee_,b.business_key_ )c "
			+ "left join y_yp_ypxx d on c.business_key_ = d.id " +str+ " left join sys_zzjg e on d.jyks = e.id where c.assignee_ is not null "
			+ "group by c.assignee_,e.bmmc";
	return jdbcTemplate.queryForList(sql);
}
 

public List<Map<String, Object>> getRwlblist() {
	String str="";
	str=str+this.getBmxx(str);
	String sql = "  select a.id,a.rwmc,a.ssxm,a.rwlx,a.yqksrq,a.yqjsrq,a.sjksrq,a.sjjsrq,a.wcjd,a.rwfzr,a.rwly from y_rw_wdrw a  where 1=1"+str;
	return jdbcTemplate.queryForList(sql);
	
}

/**
 * 获取过滤条件
 * @author liusong
 * @date 2016年1月15日
 * @param str
 * @return
 */
public String getBmxx(String str){
	SysYh user=AppUtil.getCurrentUser();
	List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
	List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
	if(jybm.size()!=0){
		str=str+" and d.jyks='"+user.getBmbh()+"' ";
	}else if(jsbm.size()!=0){
		str=str+" and d.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
	}
	return str;
}
/**
 * 获取部门信息
 * @author liusong
 * @date 2016年1月15日
 * @param bmbh
 * @return
 */
public List<Map<String,Object>> getBm(String sjbh,String bmbh){
	String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where sjbh='"+sjbh+"' and bmbh='"+bmbh+"'";
	return jdbcTemplate.queryForList(sql);
}
}
