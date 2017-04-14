package com.zssi.framework.app.process.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.model.TestProcess;
import com.zssi.framework.app.process.support.ProcessXNUtils;

/**
 * 授信审批流程相关
 * @author zhangyi
 */
@Repository
public class ProcessApiXNDao extends HibernateBaseDaoImpl<TestProcess, Long>{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 查询当前用户已经处理过的任务
	 * @return
	 */
	public Pagination<Map<String,Object>> getInvolvedProcess(Integer start, Integer limit, String userCode, String ypbh, String ypmc,String rolekind) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ASSIGNEE_", userCode);
		paramMap.put("KEY_", ProcessXNUtils.bzProcessKey);
		String key =ProcessXNUtils.bzProcessKey;
		StringBuffer sql = new StringBuffer("");
		
		sql = new StringBuffer(
				"select distinct t.PROC_DEF_ID_ as \"processDefinitionId\",b.START_TIME_ as \"STARTTIME_\", " +
				"t.PROC_INST_ID_ as \"processInstanceId\", t.TASK_DEF_KEY_ as \"taskDefinitionKey\", " +
				"t.NAME_ as \"taskName\",to_char(b.START_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"startTime\", to_char(b.END_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"endTime\",b.BUSINESS_KEY_ as \"businessKey\"," +
				"c.ypbh as \"ypbh\",c.ypmc as \"ypmc\",to_char(c.wcqx,'YYYY-MM-dd') as \"wcqx\",c.jylx as \"jylx\",c.szcs as \"szcs\",c.wtdw as \"wtdw\",c.lxr as \"lxr\",d.bmmc as \"jyks\",f.bmmc as \"ywks\","
				+" nvl(jdxx.jdxx,'科室主任任务分配') as \"jdxx\" " +
				" from ACT_HI_TASKINST t" +
				" left join ACT_HI_PROCINST b on t.PROC_INST_ID_ = b.PROC_INST_ID_" +
				" left join ACT_RE_PROCDEF g on b.PROC_DEF_ID_ = g.ID_" +
				" inner join y_yp_ypxx c on b.BUSINESS_KEY_ = c.id " +
				" left join sys_zzjg d on c.jyks= d.bmbh "+ 
				" left join sys_zzjg f on c.ywks= f.bmbh "+ 
				" left join (select a.bgbh, replace(WMSYS.WM_CONCAT(a.jdxx),',','<--') jdxx from("+
				" select bgbh,shjdmc||'|'||shr||'|'||to_char(shsj,'yyyy-MM-dd HH24:mi')||'|'||nvl(xgjdry,'无')||'|'||case shzt when 1 then '通过' when 0 then '不通过' end as jdxx "+
				" from y_sh_yjb order by shsj desc)a group by bgbh)jdxx on c.id=jdxx.bgbh "
				);
		String cxtj ="";
		if(userCode.equals("admin")){
			cxtj =" where g.KEY_=:KEY_";
		}else{
			cxtj =" where t.ASSIGNEE_ = :ASSIGNEE_ and g.KEY_=:KEY_ ";
		}
		sql.append(cxtj);
		if(StringUtils.hasText(ypbh)) {
			sql.append(" and c.ypbh like :ypbh");
			paramMap.put("ypbh", "%"+ypbh+"%");
		}
		if(StringUtils.hasText(ypmc)) {
			sql.append(" and c.ypmc like :ypmc");
			paramMap.put("ypmc", "%"+ypmc+"%");
		}
		sql.append(" order by b.START_TIME_ desc");
		
//		return null;
		
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);
	}
	
	/**
	 * 查询当前用户发起的流程数据
	 * @param start
	 * @param limit
	 * @param userCode
	 * @param customerId
	 * @param custName
	 * @return
	 */
	public Pagination<Map<String,Object>> getMyProcess(Integer start, Integer limit, String userCode, String ypbh, String ypmc) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userCode", userCode);
		paramMap.put("KEY_", ProcessXNUtils.bzProcessKey);
		StringBuffer sql = new StringBuffer("select t.PROC_DEF_ID_ as \"processDefinitionId\",t.PROC_INST_ID_ as \"processInstanceId\", " +
				" t.BUSINESS_KEY_ as \"businessKey\",to_char(t.START_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"startTime\", to_char(t.END_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"endTime\",t.DELETE_REASON_ as \"deleteReason\"," +
				" b.ypbh as \"ypbh\",b.ypmc as \"ypmc\",to_char(b.wcqx,'YYYY-MM-dd') as \"wcqx\",b.jylx as \"jylx\",b.szcs as \"szcs\",b.wtdw as \"wtdw\",b.lxr as \"lxr\",b.jyks as \"jyks\",b.ywks as \"ywks\"  " +
				" from ACT_HI_PROCINST t left join ACT_RE_PROCDEF g on t.PROC_DEF_ID_ = g.ID_" +
				" left join y_yp_ypxx b on t.BUSINESS_KEY_ = b.id" + 
				" where t.START_USER_ID_ = :userCode and g.KEY_=:KEY_");
		if(StringUtils.hasText(ypbh)) {
			sql.append(" and b.ypbh like :ypbh");
			paramMap.put("ypbh", "%"+ypbh+"%");
		}
		if(StringUtils.hasText(ypmc)) {
			sql.append(" and b.ypmc like :ypmc");
			paramMap.put("ypmc", "%"+ypmc+"%");
		}
		sql.append(" order by t.END_TIME_ desc,t.START_TIME_ desc");
//		return null;
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);
	}
	
	
	/**
	 * 与业务表关联查询运行中流程
	 * @param start
	 * @param limit
	 * @param customerId 客户号
	 * @param custName 客户名
	 * @return
	 */
	public Pagination<Map<String,Object>> getRunningProcess(Integer start, Integer limit, String ypbh, String ypmc) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("KEY_", ProcessXNUtils.bzProcessKey);
		StringBuffer sql = new StringBuffer("select e.ACT_ID_ as \"activityId\",e.PROC_DEF_ID_ as \"processDefinitionId\",e.PROC_INST_ID_ as \"processInstanceId\"," +
				" e.BUSINESS_KEY_ as \"businessKey\",to_char(e.START_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"startTime\", to_char(e.END_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"endTime\"," +
				" e.DELETE_REASON_ as \"deleteReason\"," +
				" f.ypbh as \"ypbh\",f.ypmc as \"ypmc\",to_char(f.wcqx,'YYYY-MM-dd') as \"wcqx\",f.jylx as \"jylx\",f.szcs as \"szcs\",f.wtdw as \"wtdw\",f.lxr as \"lxr\",f.jyks as \"jyks\",f.ywks as \"ywks\"  " +
				" from(select distinct t.*,b.ACT_ID_ from ACT_HI_PROCINST t,ACT_RU_EXECUTION b,ACT_RE_PROCDEF c" +
				" where t.PROC_INST_ID_ = b.PROC_INST_ID_ and t.PROC_DEF_ID_ = c.ID_ and b.ACT_ID_ is not null and c.KEY_ = :KEY_) e" +
				" left join y_yp_ypxx f on e.BUSINESS_KEY_ = f.id where 1=1");
		
		if(StringUtils.hasText(ypbh)) {
			sql.append(" and f.ypbh like :ypbh");
			paramMap.put("ypbh", "%"+ypbh+"%");
		}
		if(StringUtils.hasText(ypmc)) {
			sql.append(" and f.ypmc like :ypmc");
			paramMap.put("ypmc", "%"+ypmc+"%");
		}
		sql.append(" order by e.START_TIME_ desc");
//		return null;
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);		
	}
	
	/**
	 * 与业务表关联查询历史流程
	 * @param start
	 * @param limit
	 * @param customerId
	 * @param custName
	 * @return
	 */
	public Pagination<Map<String,Object>> getHistoryProcess(Integer start, Integer limit, String ypbh, String yplx) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("KEY_", ProcessXNUtils.bzProcessKey);
		StringBuffer sql = new StringBuffer("select  e.PROC_DEF_ID_ as \"processDefinitionId\",e.PROC_INST_ID_ as \"processInstanceId\"," +
				"e.BUSINESS_KEY_ as \"businessKey\",to_char(e.START_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"startTime\", to_char(e.END_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"endTime\"," +
				"e.DELETE_REASON_ as \"deleteReason\", b.bmmc as \"jyksmc\",c.bmmc as \"ywksmc\", " +
				" f.ypbh as \"ypbh\",f.ypmc as \"ypmc\",f.yplx as \"yplx\",f.jylx as \"jylx\",f.szcs as \"szcs\",f.wtdw as \"wtdw\",f.lxr as \"lxr\",f.jyks as \"jyks\",f.ywks as \"ywks\"  " +
				" from(select t.* from ACT_HI_PROCINST t,ACT_RE_PROCDEF k where t.PROC_DEF_ID_ = k.ID_ and k.KEY_=:KEY_" +
				" and not exists(select b.PROC_INST_ID_ from ACT_RU_EXECUTION b where t.PROC_INST_ID_ = b.PROC_INST_ID_)) e" +
				" inner join y_yp_ypxx f  on e.BUSINESS_KEY_ = f.id left join SYS_ZZJG b on f.jyksbh=b.BMBH left join  SYS_ZZJG c on f.ywksbh=c.bmbh where 1=1");
		if(StringUtils.hasText(ypbh)) {
			sql.append(" and f.ypbh like :ypbh");
			paramMap.put("ypbh", "%"+ypbh+"%");
		}
		if(StringUtils.hasText(yplx)) {
			sql.append(" and f.yplx like :yplx");
			paramMap.put("yplx", "%"+yplx+"%");
		}
		sql.append(" order by e.START_TIME_ desc");
//		return null;
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);			
	}
	
	public Integer getAppNum(String ste,String ste1){
		int flag = 0;
		Session session = sessionFactory.openSession();
		String sql = "select nvl(max(APP_NUM),0) from CPS_APPROVAL_NUM where CREATE_TIME >= to_date('"+ste+"',"
				+ "'yyyy-MM-dd hh24:mi:ss') and CREATE_TIME <= to_date('"+ste1+"','yyyy-MM-dd hh24:mi:ss') ";
		List appNumList = session.createSQLQuery(sql).list();
		Object object = appNumList.get(0);
		if(null != object){
			flag = Integer.parseInt(object.toString());
		}
		session.flush();
		session.clear();
		session.close();
		System.out.println(flag);
		return flag;
	}
	
	/**
	 * 任务撤回
	 * @author duanpeijun
	 * @date 2016年2月1日
	 */
	public Pagination<Map<String,Object>> getRwch(Integer start, Integer limit, String userCode, String ypbh, String ypmc,String rolekind) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ASSIGNEE_", userCode);
		paramMap.put("KEY_", ProcessXNUtils.bzProcessKey);
		String key =ProcessXNUtils.bzProcessKey;
		StringBuffer sql = new StringBuffer("");
		
		sql = new StringBuffer(
				"select distinct t.PROC_DEF_ID_ as \"processDefinitionId\",b.START_TIME_ as \"STARTTIME_\", " +
						"t.PROC_INST_ID_ as \"processInstanceId\", t.TASK_DEF_KEY_ as \"taskDefinitionKey\", " +
						"t.NAME_ as \"taskName\",to_char(b.START_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"startTime\", to_char(b.END_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"endTime\",b.BUSINESS_KEY_ as \"businessKey\"," +
						"c.ypbh as \"ypbh\",c.id as \"ypid\",c.ypmc as \"ypmc\",to_char(c.wcqx,'YYYY-MM-dd') as \"wcqx\",c.jylx as \"jylx\",c.szcs as \"szcs\",c.wtdw as \"wtdw\",c.lxr as \"lxr\"," + 
						"d.bmmc as \"jyks\",e.bmmc as \"ywks\"  " +
						" from ACT_HI_TASKINST t" +
						" left join ACT_HI_PROCINST b on t.PROC_INST_ID_ = b.PROC_INST_ID_" +
						" left join ACT_RE_PROCDEF g on b.PROC_DEF_ID_ = g.ID_" +
						" inner join y_yp_ypxx c on b.BUSINESS_KEY_ = c.id "+ 
						" left join sys_zzjg d on c.jyks = d.id " + 
						" left join sys_zzjg e on c.ywks = e.id " +
						" where t.ASSIGNEE_ = :ASSIGNEE_ and g.KEY_=:KEY_ and c.ypjyzt = '1' and t.NAME_ = '科室主任任务分配'" 
				);
		
		if(StringUtils.hasText(ypbh)) {
			sql.append(" and c.ypbh like :ypbh");
			paramMap.put("ypbh", "%"+ypbh+"%");
		}
		if(StringUtils.hasText(ypmc)) {
			sql.append(" and c.ypmc like :ypmc");
			paramMap.put("ypmc", "%"+ypmc+"%");
		}
		sql.append(" order by b.START_TIME_ desc");
		
//		return null;
		
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);
	}
	
	/**
	 * 驳回样品修改
	 * @author duanpeijun
	 * @date 2016年4月13日
	 */
	public Pagination<Map<String,Object>> getBhypxg(Integer start, Integer limit, String userCode, String ypbh, String ypmc,String rolekind) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ASSIGNEE_", userCode);
		paramMap.put("KEY_", ProcessXNUtils.bzProcessKey);
		String key =ProcessXNUtils.bzProcessKey;
		StringBuffer sql = new StringBuffer("");
		
		sql = new StringBuffer(
				"select distinct t.PROC_DEF_ID_ as \"processDefinitionId\",b.START_TIME_ as \"STARTTIME_\", " +
				"t.PROC_INST_ID_ as \"processInstanceId\", t.TASK_DEF_KEY_ as \"taskDefinitionKey\", " +
				"t.NAME_ as \"taskName\",to_char(b.START_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"startTime\", to_char(b.END_TIME_,'YYYY-MM-dd HH24:mi:ss') as \"endTime\",b.BUSINESS_KEY_ as \"businessKey\"," +
				"c.ypbh as \"ypbh\",c.id as \"ypid\",c.ypmc as \"ypmc\",to_char(c.wcqx,'YYYY-MM-dd') as \"wcqx\",c.jylx as \"jylx\",c.szcs as \"szcs\","+
				"c.wtdw as \"wtdw\",c.lxr as \"lxr\",c.djlx as \"djlx\", " +
				"d.bmmc as \"jyks\",e.bmmc as \"ywks\"  " +
				" from ACT_HI_TASKINST t" +
				" left join ACT_HI_PROCINST b on t.PROC_INST_ID_ = b.PROC_INST_ID_" +
				" left join ACT_RE_PROCDEF g on b.PROC_DEF_ID_ = g.ID_" +
				" inner join y_yp_ypxx c on b.BUSINESS_KEY_ = c.id "+ 
				" left join sys_zzjg d on c.jyks = d.id " + 
				" left join sys_zzjg e on c.ywks = e.id " +
				" where t.ASSIGNEE_ = :ASSIGNEE_ and g.KEY_=:KEY_  and c.ypjyzt = '8' "  
				);
		
		if(StringUtils.hasText(ypbh)) {
			sql.append(" and c.ypbh like :ypbh");
			paramMap.put("ypbh", "%"+ypbh+"%");
		}
		if(StringUtils.hasText(ypmc)) {
			sql.append(" and c.ypmc like :ypmc");
			paramMap.put("ypmc", "%"+ypmc+"%");
		}
		sql.append(" order by b.START_TIME_ desc");
		
//		return null;
		
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);
	}
}
