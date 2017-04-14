package com.zssi.framework.app.zjpad.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.process.support.ProcessXNUtils;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.ypgl.model.YypYpxx;

/** 
 * pad端dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:07:19 
 * 类说明 
 */

@Repository
public class ZjPadDao extends HibernateBaseDaoImpl<YypYpxx, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	public List<Map<String, Object>> getPendPoolList(String cxtj,String ypcs) {
		String sql = "";
		String req = "";
		SysYh user = AppUtil.getCurrentUser();
		String bmbh = user.getBmbh();
		String jbm1 = user.getJbm1();
		String jbm2 = user.getJbm2();
		String jbm3 = user.getJbm3();
		String jbm4 = user.getJbm4();
		String userCode = user.getUsername();
		String str = "";
		String tjtr = "";
		if((!"".equals(jbm1))&&jbm1!=null){
			req=req+"'"+user.getJbm1()+"',";
		}
		if((!"".equals(jbm2))&&jbm2!=null){
			req=req+"'"+user.getJbm2()+"',";
		}
		if((!"".equals(jbm3))&&jbm3!=null){
			req=req+"'"+user.getJbm3()+"',";
		}
		if((!"".equals(jbm4))&&jbm4!=null){
			req=req+"'"+user.getJbm4()+"',";
		}
		if((!"".equals(bmbh))&&bmbh!=null){
			req=req+"'"+user.getBmbh()+"',";
		}
		if(!userCode.equals("admin")){
			if("0".equalsIgnoreCase(ypcs)){//科室主任分配任务
				str = " and c.JYKSBH in ("+req+" '24') ";
			}else if("2".equalsIgnoreCase(ypcs) ){//技术中心批准
				str = " and (c.JYKSBH in (select t.jyksbh from sys_jglsgx t where t.jszxbh in ("+req+" '24') "
						+ "or c.JYKSBH in (select tt.jyksbh from sys_jglsgx tt where tt.jszxbh in (select ttt.jszxbh from sys_jglsgx ttt where ttt.jyksbh in ("+req+" '24')))))";
			}else if("3".equalsIgnoreCase(ypcs) ){
				str = " and (c.JYKSBH in (select t.jyksbh from sys_jglsgx t where t.jszxbh in ("+req+" '24') "
						+ "or c.JYKSBH in (select tt.jyksbh from sys_jglsgx tt where tt.jszxbh in (select ttt.jszxbh from sys_jglsgx ttt where ttt.jyksbh in ("+req+" '24')))))"
				        + "and m.xgjdry = '"+userCode+"' ";
			}
		}
		if(StringUtils.hasText(cxtj)) {
			tjtr = " and (c.id like '%"+cxtj+"%' or c.ypbh like '%"+cxtj+"%' or c.ypmc like '%"+cxtj+"%' or c.yplx like '%"+cxtj+"%' or "
					+ "c.jylx like '%"+cxtj+"%' or d.bmmc like '%"+cxtj+"%' or e.bmmc like '%"+cxtj+"%' or c.lxr like '%"+cxtj+"%' or "
					+ " c.yb like '%"+cxtj+"%' or c.cyjs like '%"+cxtj+"%' or c.scdw like '%"+cxtj+"%' or c.cyry like '%"+cxtj+"%')";
		}
		//判断任务所处的状态，分类查询
		if(StringUtils.hasText(ypcs)) {
			if("1".equalsIgnoreCase(ypcs)){
				tjtr =tjtr+ " and c.YPJYZT=1 or c.YPJYZT=7 ";
			}else{
				tjtr =tjtr+ " and c.YPJYZT="+Integer.parseInt(ypcs);
			}
		}
		sql = "select "+ypcs+" as \"ypcs\", a.ID_ as \"taskId\",0 as \"processFlag\",a.TASK_DEF_KEY_ as \"activityId\",a.PROC_INST_ID_ as \"processInstanceId\",a.NAME_ as \"name\",a.ASSIGNEE_ as \"assignee\",a.CREATE_TIME_ as \"createTime\", a.BUSINESS_KEY_ as \"businessKey\",a.ypbh as \"ypbh\",a.ypmc as \"ypmc\",a.id as \"id\",a.wcqx as \"wcqx\", "
		+ "a.jylx as \"jylx\",a.jyfy as \"jyfy\",a.wtdw as \"wtdw\",a.lxr as \"lxr\",a.jyksmc as \"jyksmc\",a.ywksmc as \"ywksmc\",a.ysfje as \"ysfje\",a.jyjsrq as \"jyjsrq\",a.bzr as \"bzr\", a.shr as \"shr\",a.pzr as \"pzr\", a.qsr as \"qsr\"  "
		+ "from( select a.ID_,a.REV_,a.EXECUTION_ID_,a.PROC_INST_ID_,a.PROC_DEF_ID_,a.NAME_,a.PARENT_TASK_ID_,a.DESCRIPTION_,a.TASK_DEF_KEY_,a.OWNER_,a.ASSIGNEE_,a.DELEGATION_,a.PRIORITY_,a.CREATE_TIME_,a.DUE_DATE_,a.SUSPENSION_STATE_,b.BUSINESS_KEY_, "
		+ "c.id,c.ypbh,c.ypmc,c.jylx,d.bmmc as jyksmc,e.bmmc as ywksmc,to_char(c.wcqx,'YYYY-MM-dd') as wcqx,c.lxr,c.wtdw,c.jyfy,ROWNUM rnum,g.ysfje,to_char(p.jyjsrq,'yyyy-MM-dd')as jyjsrq,n.xgjdry as bzr,k.shr as QSR,l.shr as SHR,m.xgjdry as PZR from "
        +" (select distinct RES.ID_,RES.REV_,RES.EXECUTION_ID_,RES.PROC_INST_ID_,RES.PROC_DEF_ID_,RES.NAME_,RES.PARENT_TASK_ID_,RES.DESCRIPTION_,RES.TASK_DEF_KEY_,RES.OWNER_,RES.ASSIGNEE_,RES.DELEGATION_,RES.PRIORITY_,to_char(RES.CREATE_TIME_,'yyyy-MM-dd HH24:mi:ss')as CREATE_TIME_,RES.DUE_DATE_,RES.SUSPENSION_STATE_    "          
        +" from ACT_RU_TASK RES inner join ACT_RU_IDENTITYLINK I on I.TASK_ID_ = RES.ID_ inner join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_               "
        +" WHERE D.KEY_ = 'zjyProcess' and RES.ASSIGNEE_ is null and I.TYPE_ = 'candidate'and (I.USER_ID_ ='"+userCode+"' or I.GROUP_ID_ IN  (select membership.GROUP_ID_ from ACT_ID_MEMBERSHIP membership where membership.USER_ID_ = '"+userCode+"')  "                  
        +" ) and RES.SUSPENSION_STATE_ = 1 union   "
        +" select distinct RES.ID_,RES.REV_,RES.EXECUTION_ID_,RES.PROC_INST_ID_,RES.PROC_DEF_ID_,RES.NAME_,RES.PARENT_TASK_ID_,RES.DESCRIPTION_,RES.TASK_DEF_KEY_,RES.OWNER_,RES.ASSIGNEE_,RES.DELEGATION_,RES.PRIORITY_,to_char(RES.CREATE_TIME_,'yyyy-MM-dd HH24:mi:ss')as CREATE_TIME_,RES.DUE_DATE_,RES.SUSPENSION_STATE_  "            
        +" from ACT_RU_TASK RES inner join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_             "     
        +" WHERE RES.ASSIGNEE_ = '"+userCode+"' and D.KEY_ = '"+ProcessXNUtils.bzProcessKey+"' and RES.SUSPENSION_STATE_ = 1 ) a "
        +" left join ACT_RU_EXECUTION b on a.execution_id_= b.id_ left join y_yp_ypxx c on b.BUSINESS_KEY_ = c.id left join sys_zzjg d on c.jyks = d.id "
        + "left join sys_zzjg e on c.ywks = e.id left join ACT_HI_TASKINST f on f.ID_ = a.ID_ left join y_cw_bgsf g on c.ypbh = g.bgbh "
        + "left join (select max(jyjsrq) as jyjsrq,bgbh from y_cw_bgsfjl group by bgbh) p on c.ypbh=p.bgbh "
        + "left join (select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)n on c.id = n.bgbh "
        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)k on c.id = k.bgbh "
        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)l on c.id = l.bgbh "
        + "left join (select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)m on c.id = m.bgbh "
        + "where  1=1 "+tjtr+str+" order by nvl(f.CLAIM_TIME_,to_date('1900-01-01','yyyy-mm-dd')) desc,a.CREATE_TIME_ desc  )a " ;
		if(userCode.equals("admin")){
			sql ="select "+ypcs+" as \"ypcs\", a.ID_ as \"taskId\",0 as \"processFlag\",a.TASK_DEF_KEY_ as \"activityId\",a.PROC_INST_ID_ as \"processInstanceId\",a.NAME_ as \"name\",a.ASSIGNEE_ as \"assignee\",a.CREATE_TIME_ as \"createTime\", a.BUSINESS_KEY_ as \"businessKey\",a.ypbh as \"ypbh\",a.ypmc as \"ypmc\",a.id as \"id\",a.wcqx as \"wcqx\", "
					+ "a.jylx as \"jylx\",a.jyfy as \"jyfy\",a.wtdw as \"wtdw\",a.lxr as \"lxr\",a.jyksmc as \"jyksmc\",a.ywksmc as \"ywksmc\",a.ysfje as \"ysfje\",a.jyjsrq as \"jyjsrq\",a.bzr as \"bzr\", a.shr as \"shr\",a.pzr as \"pzr\", a.qsr as \"qsr\"  "
					+ "from( select a.ID_,a.REV_,a.EXECUTION_ID_,a.PROC_INST_ID_,a.PROC_DEF_ID_,a.NAME_,a.PARENT_TASK_ID_,a.DESCRIPTION_,a.TASK_DEF_KEY_,a.OWNER_,a.ASSIGNEE_,a.DELEGATION_,a.PRIORITY_,a.CREATE_TIME_,a.DUE_DATE_,a.SUSPENSION_STATE_,b.BUSINESS_KEY_, "
					+ "c.id,c.ypbh,c.ypmc,c.jylx,d.bmmc as jyksmc,e.bmmc as ywksmc,to_char(c.wcqx,'YYYY-MM-dd') as wcqx,c.lxr,c.wtdw,c.jyfy,ROWNUM rnum,g.ysfje,to_char(p.jyjsrq,'yyyy-MM-dd')as jyjsrq,n.xgjdry as bzr,k.shr as QSR,l.shr as SHR,m.xgjdry as PZR from "
			        +" (select distinct RES.ID_,RES.REV_,RES.EXECUTION_ID_,RES.PROC_INST_ID_,RES.PROC_DEF_ID_,RES.NAME_,RES.PARENT_TASK_ID_,RES.DESCRIPTION_,RES.TASK_DEF_KEY_,RES.OWNER_,RES.ASSIGNEE_,RES.DELEGATION_,RES.PRIORITY_,to_char(RES.CREATE_TIME_,'yyyy-MM-dd HH24:mi:ss')as CREATE_TIME_,RES.DUE_DATE_,RES.SUSPENSION_STATE_    "          
			        +" from ACT_RU_TASK RES inner join ACT_RU_IDENTITYLINK I on I.TASK_ID_ = RES.ID_ inner join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_               "
			        +" WHERE D.KEY_ = 'zjyProcess' and RES.ASSIGNEE_ is null and I.TYPE_ = 'candidate' and RES.SUSPENSION_STATE_ = 1 union   "
			        +" select distinct RES.ID_,RES.REV_,RES.EXECUTION_ID_,RES.PROC_INST_ID_,RES.PROC_DEF_ID_,RES.NAME_,RES.PARENT_TASK_ID_,RES.DESCRIPTION_,RES.TASK_DEF_KEY_,RES.OWNER_,RES.ASSIGNEE_,RES.DELEGATION_,RES.PRIORITY_,to_char(RES.CREATE_TIME_,'yyyy-MM-dd HH24:mi:ss')as CREATE_TIME_,RES.DUE_DATE_,RES.SUSPENSION_STATE_  "            
			        +" from ACT_RU_TASK RES inner join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_             "     
			        +" WHERE  D.KEY_ = '"+ProcessXNUtils.bzProcessKey+"' and RES.SUSPENSION_STATE_ = 1 ) a "
			        +" left join ACT_RU_EXECUTION b on a.execution_id_= b.id_ left join y_yp_ypxx c on b.BUSINESS_KEY_ = c.id left join sys_zzjg d on c.jyks = d.id "
			        + "left join sys_zzjg e on c.ywks = e.id left join ACT_HI_TASKINST f on f.ID_ = a.ID_ left join y_cw_bgsf g on c.ypbh = g.bgbh "
			        + "left join (select max(jyjsrq) as jyjsrq,bgbh from y_cw_bgsfjl group by bgbh) p on c.ypbh=p.bgbh "
			        + "left join (select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)n on c.id = n.bgbh "
			        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)k on c.id = k.bgbh "
			        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)l on c.id = l.bgbh "
			        + "left join (select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)m on c.id = m.bgbh "
			        + "where  1=1 "+tjtr+str+" order by nvl(f.CLAIM_TIME_,to_date('1900-01-01','yyyy-mm-dd')) desc,a.CREATE_TIME_ desc  )a " ;
		}
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String,Object>> getBgsf(){
//		String sql="select count(t.ypbh) as je,to_char(t.djsj,'yyyy-MM')as yf from Y_YP_YPXX t where t.djsj is not null  group by to_char(t.djsj,'yyyy-MM')";
		SimpleDateFormat sim=new SimpleDateFormat("yyyy");
		String sql="SELECT a.zdz as yf, nvl(count(b.ypbh),'0') as je,nvl(count(b.ypbh)/5000*100,'0') as bfb FROM "
				+ "(SELECT  ZDMC, ZDZ FROM SYS_SJZD where zl='tjyf' and jb=2) a left join (select ypbh,to_char(djsj,'MM')as djsj from Y_YP_YPXX where to_char(djsj,'yyyy')='"+sim.format(new Date())+"') b on "
				+ "a.zdz=to_number(b.djsj)  group by a.zdz order by to_number(a.zdz)";
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String,Object>> getYwkssf(){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM");
		String sql="select count(t.ypbh)as ywl,count(t.ypbh)/1000*100 as bfb,t.djry  from Y_YP_YPXX t where t.djsj is not null and t.djry <> 'admin' and to_char(t.djsj,'yyyy-MM')= '"+sim.format(new Date())+"' group by t.djry order by ywl";
		return jdbcTemplate.queryForList(sql);
	}

}
