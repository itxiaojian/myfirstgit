package com.zssi.framework.app.process.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.model.TestProcess;
import com.zssi.framework.app.process.support.ProcessXNUtils;
import com.zssi.framework.app.process.support.file.CpsConstant;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

import org.springframework.web.servlet.ModelAndView;

@Repository
public class BusinessXNDao extends HibernateBaseDaoImpl<TestProcess, String> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	public Map<String, Object> getTestProcess(String businessKey) {
		String sql = "select t.ID as \"pid\",t.NAME as \"name\", t.PROCESSCODE as \"processCode\",t.PROCESS_STATUS as \"processStatus\",t.PROC_INST_ID as \"procInstId\" "
				+ " from TEST_PROCESS t where t.ID = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,
				businessKey);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public List<Map<String, Object>> getListTestProcess(String businessKey) {
		String sql = "select t.ID as \"pid\",t.NAME as \"name\", t.PROCESSCODE as \"processCode\",t.PROCESS_STATUS as \"processStatus\",t.PROC_INST_ID as \"procInstId\" "
				+ " from TEST_PROCESS t where t.ID = ?";
		return jdbcTemplate.queryForList(sql, businessKey);
	}

	/**
	 * 强制结束流程时，删除主表信息
	 *
	 * @param processInstanceId
	 */
	public void deleteTestProcess(String processInstanceId) {
		String hql = "delete from TestProcess t where t.procInstId = ?";
		this.bulkUpdate(hql, processInstanceId);
	}

	public void updateTestProcess(String processInstanceId, String businessKey) {
		String hql = "update TestProcess t set t.processStatus='2',t.procInstId=? where t.id = ?";
		String sql = "update test_process t set t.process_status='2',t.proc_inst_id='"
				+ processInstanceId + "' where t.id='" + businessKey + "' ";

		this.jdbcTemplate.update(sql);
		// this.bulkUpdate(hql, processInstanceId, businessKey);
	}

	// /**
	// * 得到经理角色
	// * @return
	// */
	// public List<Map<String, Object>> getJlUserList() {
	// String sql = "select t.USER_CODE as \"userCode\""
	// +
	// " from UNTECK_USER t,UNTECK_USER_ROLE c,UNTECK_ROLE d, UNTECK_ORGANIZATION e"
	// +
	// " where t.id=c.USER_ID and c.ROLE_ID = d.id and t.ORG_ID = e.id and d.CODE = '"
	// + CpsConstant.ROLE_SQUAD + "'";
	// return jdbcTemplate.queryForList(sql);
	// }

	/**
	 * 的到经理角色的用户
	 *
	 * @param userCode
	 * @return
	 */
	public List<Map<String, Object>> getXNBranchUsersByUserCode() {
		String sql = "select a.username as \"userCode\" from sys_user a,sys_role b,sys_user_role c "
				+ "where a.id=c.user_id and b.role_id=c.role_id and b.role_name='"
				+ CpsConstant.ROLE_JL + "'";

		// String sql =
		// "select t.USER_NAME as \"userName\", t.USER_CODE as \"userCode\""
		// +
		// " from UNTECK_USER t,UNTECK_USER_ROLE c,UNTECK_ROLE d, UNTECK_ORGANIZATION e"
		// +
		// " where t.id=c.USER_ID and c.ROLE_ID = d.id and t.ORG_ID = e.id and d.CODE = '"
		// + CpsConstant.ROLE_JL + "'" + " and e.id=" +
		// orgId+" and t.DEL_FLAG = '0'";
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 的到Boss角色的用户
	 *
	 * @param userCode
	 * @return
	 */
	public List<Map<String, Object>> getXNBossUserCode() {
		String sql = "select a.username as \"userCode\" from sys_user a,sys_role b,sys_user_role c "
				+ "where a.id=c.user_id and b.role_id=c.role_id and b.role_name='"
				+ CpsConstant.ROLE_BOSS + "'";

		// String sql =
		// "select t.USER_NAME as \"userName\", t.USER_CODE as \"userCode\""
		// +
		// " from UNTECK_USER t,UNTECK_USER_ROLE c,UNTECK_ROLE d, UNTECK_ORGANIZATION e"
		// +
		// " where t.id=c.USER_ID and c.ROLE_ID = d.id and t.ORG_ID = e.id and d.CODE = '"
		// + CpsConstant.ROLE_JL + "'" + " and e.id=" +
		// orgId+" and t.DEL_FLAG = '0'";
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 根据用户登录名找出用户的角色
	 *
	 * @author zhangyi
	 * @since 2015-4-16
	 * @param username
	 * @return
	 */
	public String getUserRoleByUserCode(String username) {
		String sql = "select b.JSMC as \"roleKind\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and a.DLM='"
				+ username + "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return list.get(0).get("roleKind").toString();
		}
		return null;
	}

	/**
	 * 获取上级本部门领导code
	 *
	 * @author zhangyi
	 * @since 2015-4-17
	 * @param userCode
	 * @param orgCode
	 * @param roleBmjl
	 * @return
	 */
	public String getSjldUserCodeInOrgCode(String userCode, String orgCode,
										   String roleName) {
		String sql = "select a.DLM as \"userCode\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and a.BMBH='"
				+ orgCode + "' and b.JSMC='" + roleName + "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return list.get(0).get("userCode").toString();
		}
		return null;
	}

	/**
	 * 获取领导层code
	 *
	 * @author zhangyi
	 * @since 2015-4-17
	 * @param userCode
	 * @param roleBmjl
	 * @return
	 */
	public String getLeaderUserCode(String userCode, String roleName) {
		String sql = "select a.DLM as \"userCode\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and b.JSMC='"
				+ roleName + "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return list.get(0).get("userCode").toString();
		}
		return null;
	}

	/**
	 * 根据样品编号查询样品信息
	 * @author:zhangyi
	 * @version 创建时间：2015年11月10日 下午4:28:44 
	 * @param businessKey
	 * @return
	 */
	public List<Map<String, Object>> getListProcessByYpbhb(String businessKey,String cxtj,String ypcs) {
		String sql = "";
		SysYh user = AppUtil.getCurrentUser();
		String bmbh = user.getBmbh();
		String str = "";
		String tjtr = "";
		String sql1 = "";

		if("0".equalsIgnoreCase(ypcs)){//科室主任分配任务
			str = " and a.JYKSBH='"+bmbh+"' ";
		}else if("2".equalsIgnoreCase(ypcs)||"3".equalsIgnoreCase(ypcs)){//技术中心批准
			str = " and (a.JYKSBH in (select t.jyksbh from sys_jglsgx t where t.jszxbh='"+bmbh+"') "
					+ "or a.JYKSBH in (select tt.jyksbh from sys_jglsgx tt where tt.jszxbh in (select ttt.jszxbh from sys_jglsgx ttt where ttt.jyksbh='"+bmbh+"')))";
		}


//		if("ROLE_KSZR".equalsIgnoreCase(rolename)||"ROLE_JYSHRY".equalsIgnoreCase(rolename)){//科室主任审核；科室报告审核角色
//			str = " and (a.JYKSBH='"+bmbh+"' or a.JYKSBH in (select t.jyksbh from sys_jglsgx t where t.jszxbh='"+bmbh+"'))";//1、科室主任在检验科室；2、科室主任在技术中心，这样会放大科室
//		}else if("ROLE_GCJSZXPZR".equalsIgnoreCase(rolename)||"ROLE_GCJSZXJSR".equalsIgnoreCase(rolename)){//工程技术中心批准人/解锁人
//			str = " and a.jyksbh in (select jyksbh from sys_jglsgx  where jszxbh='\"+bmbh+\"'\n" +//1、技术中心主任在技术中心
//					"union all\n" +
//					"select b.jyksbh from \n" +//2、技术中心主任在检验科室
//					"(select jszxbh from sys_jglsgx  where jyksbh='"+bmbh+"') a\n" +
//					"left join sys_jglsgx b\n" +
//					"on b.jszxbh = a.jszxbh)";
//		}else if("ROLE_YWKSJSR".equalsIgnoreCase(rolename)){
//			str = " ";
//		}

		if(StringUtils.hasText(cxtj)) {
			tjtr = " and (a.id like '%"+cxtj+"%' or a.ypbh like '%"+cxtj+"%' or a.ypmc like '%"+cxtj+"%' or a.yplx like '%"+cxtj+"%' or "
					+ "a.jylx like '%"+cxtj+"%' or b.bmmc like '%"+cxtj+"%' or c.bmmc like '%"+cxtj+"%' or a.lxr like '%"+cxtj+"%' or "
					+ " a.yb like '%"+cxtj+"%' or a.cyjs like '%"+cxtj+"%' or a.scdw like '%"+cxtj+"%' or a.cyry like '%"+cxtj+"%')";
		}
		//判断任务所处的状态，分类查询
		if(StringUtils.hasText(ypcs)) {
			if("1".equalsIgnoreCase(ypcs)){
				tjtr = " and a.YPJYZT=1 or a.YPJYZT=7 ";
			}else{
				tjtr = " and a.YPJYZT="+Integer.parseInt(ypcs);
			}
		}
		sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,a.jyksbh,b.bmmc as jyksmc,a.ywksbh,c.bmmc as ywksmc, "
				+ "a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,"
				+ "a.ypsl,a.wtdw,a.wtdwdz,a.sjdw,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
				+ "a.scdwyb,a.bgfsfs,a.yhxtk,a.cyry,a.jyfy,e.ysfje,to_char(e.jyjsrq,'yyyy-MM-dd')as jyjsrq,"
				+ "a.jcfyry,a.jyks,a.ywks,a.jyhth,a.ewmtp,a.jyfy,a.jyfydd,a.bz,a.bgbh,a.djlx,a.djry,d.bz,d.ysjlsjm,d.id as did "
				+ "from y_yp_ypxx a left join SYS_ZZJG b on a.jyksbh=b.BMBH left join  SYS_ZZJG c on a.ywksbh=c.bmbh "
				+ "left join Y_JY_YSJLGL d on a.ypbh = d.bgbh left join y_cw_bgsf e on a.ypbh = e.bgbh "
				+ "where a.id=? " +str+tjtr;
		return jdbcTemplate.queryForList(sql, businessKey);
	}
	
	
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
		+ "c.id,c.ypbh,c.ypmc,c.jylx,d.bmmc as jyksmc,e.bmmc as ywksmc,to_char(c.wcqx,'YYYY-MM-dd') as wcqx,c.lxr,c.wtdw,c.jyfy,ROWNUM rnum,g.ysfje,to_char(p.jyjsrq,'yyyy-MM-dd')as jyjsrq,n.xgjdry as bzr,n.shr as QSR,m.shr as SHR,m.xgjdry as PZR from "
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
        + "left join view_fpjdsj n on c.id = n.bgbh "
//        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)k on c.id = k.bgbh "
//        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)l on c.id = l.bgbh "
        + "left join view_shxgjd m on c.id = m.bgbh "
        + "where  1=1 "+tjtr+str+" order by nvl(f.CLAIM_TIME_,to_date('1900-01-01','yyyy-mm-dd')) desc,c.ypbh asc  )a " ;   //a.CREATE_TIME_ desc,任务创建时间
		if(userCode.equals("admin")){
			sql ="select "+ypcs+" as \"ypcs\", a.ID_ as \"taskId\",0 as \"processFlag\",a.TASK_DEF_KEY_ as \"activityId\",a.PROC_INST_ID_ as \"processInstanceId\",a.NAME_ as \"name\",a.ASSIGNEE_ as \"assignee\",a.CREATE_TIME_ as \"createTime\", a.BUSINESS_KEY_ as \"businessKey\",a.ypbh as \"ypbh\",a.ypmc as \"ypmc\",a.id as \"id\",a.wcqx as \"wcqx\", "
					+ "a.jylx as \"jylx\",a.jyfy as \"jyfy\",a.wtdw as \"wtdw\",a.lxr as \"lxr\",a.jyksmc as \"jyksmc\",a.ywksmc as \"ywksmc\",a.ysfje as \"ysfje\",a.jyjsrq as \"jyjsrq\",a.bzr as \"bzr\", a.shr as \"shr\",a.pzr as \"pzr\", a.qsr as \"qsr\"  "
					+ "from( select a.ID_,a.REV_,a.EXECUTION_ID_,a.PROC_INST_ID_,a.PROC_DEF_ID_,a.NAME_,a.PARENT_TASK_ID_,a.DESCRIPTION_,a.TASK_DEF_KEY_,a.OWNER_,a.ASSIGNEE_,a.DELEGATION_,a.PRIORITY_,a.CREATE_TIME_,a.DUE_DATE_,a.SUSPENSION_STATE_,b.BUSINESS_KEY_, "
					+ "c.id,c.ypbh,c.ypmc,c.jylx,d.bmmc as jyksmc,e.bmmc as ywksmc,to_char(c.wcqx,'YYYY-MM-dd') as wcqx,c.lxr,c.wtdw,c.jyfy,ROWNUM rnum,g.ysfje,to_char(p.jyjsrq,'yyyy-MM-dd')as jyjsrq,n.xgjdry as bzr,n.shr as QSR,m.shr as SHR,m.xgjdry as PZR from "
			        +" (select distinct RES.ID_,RES.REV_,RES.EXECUTION_ID_,RES.PROC_INST_ID_,RES.PROC_DEF_ID_,RES.NAME_,RES.PARENT_TASK_ID_,RES.DESCRIPTION_,RES.TASK_DEF_KEY_,RES.OWNER_,RES.ASSIGNEE_,RES.DELEGATION_,RES.PRIORITY_,to_char(RES.CREATE_TIME_,'yyyy-MM-dd HH24:mi:ss')as CREATE_TIME_,RES.DUE_DATE_,RES.SUSPENSION_STATE_    "          
			        +" from ACT_RU_TASK RES inner join ACT_RU_IDENTITYLINK I on I.TASK_ID_ = RES.ID_ inner join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_               "
			        +" WHERE D.KEY_ = 'zjyProcess' and RES.ASSIGNEE_ is null and I.TYPE_ = 'candidate' and RES.SUSPENSION_STATE_ = 1 union   "
			        +" select distinct RES.ID_,RES.REV_,RES.EXECUTION_ID_,RES.PROC_INST_ID_,RES.PROC_DEF_ID_,RES.NAME_,RES.PARENT_TASK_ID_,RES.DESCRIPTION_,RES.TASK_DEF_KEY_,RES.OWNER_,RES.ASSIGNEE_,RES.DELEGATION_,RES.PRIORITY_,to_char(RES.CREATE_TIME_,'yyyy-MM-dd HH24:mi:ss')as CREATE_TIME_,RES.DUE_DATE_,RES.SUSPENSION_STATE_  "            
			        +" from ACT_RU_TASK RES inner join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_             "     
			        +" WHERE  D.KEY_ = '"+ProcessXNUtils.bzProcessKey+"' and RES.SUSPENSION_STATE_ = 1 ) a "
			        +" left join ACT_RU_EXECUTION b on a.execution_id_= b.id_ left join y_yp_ypxx c on b.BUSINESS_KEY_ = c.id left join sys_zzjg d on c.jyks = d.id "
			        + "left join sys_zzjg e on c.ywks = e.id left join ACT_HI_TASKINST f on f.ID_ = a.ID_ left join y_cw_bgsf g on c.ypbh = g.bgbh "
			        + "left join (select max(jyjsrq) as jyjsrq,bgbh from y_cw_bgsfjl group by bgbh) p on c.ypbh=p.bgbh "
			        + "left join view_fpjdsj n on c.id = n.bgbh "
//			        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)k on c.id = k.bgbh "
//			        + "left join (select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)l on c.id = l.bgbh "
			        + "left join view_shxgjd m on c.id = m.bgbh "
			        + "where  1=1 "+tjtr+str+" order by nvl(f.CLAIM_TIME_,to_date('1900-01-01','yyyy-mm-dd')) desc,a.CREATE_TIME_ desc  )a " ;
		}
		return jdbcTemplate.queryForList(sql); 
	}
	
	/**
	 * 流程分页
	 * @author duanpeijun
	 * @date 2016年7月24日
	 * @param cxtj
	 * @param ypcs
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getPendPoolListToo(String cxtj,String ypcs,Integer start,Integer limit) {
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
        + "where  1=1 "+tjtr+str+" order by nvl(f.CLAIM_TIME_,to_date('1900-01-01','yyyy-mm-dd')) desc,c.ypbh asc  )a " ;   //a.CREATE_TIME_ desc,任务创建时间
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
		return jdbcPager.queryPage(sql, start, limit);
	}

	/**
	 * 强制结束流程，修改考核状态和删除公共
	 * @author zhangyi
	 * @since  2015-4-23
	 * @param bkhr
	 * @param khqh
	 * @param bdlcid
	 * @param tname
	 */
	public void forceProcess(String ypbh) {
		String sql = "delete from y_yp_ypxx where id='"+ypbh+"'";
		jdbcTemplate.execute(sql);
	}

	/**
	 * 根据角色和部门查出对应人员
	 * @author:zhangyi
	 * @version 创建时间：2015年11月10日 上午10:25:14
	 * @param jyks
	 * @param roleJszxzr
	 * @return
	 */
	public String getUserByUserRoleAndorgCode(String jyks, String roleName) {
		String sql = "select a.dlm as \"dlm\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and (a.BMBH='"+ jyks + "' or a.jbm1='"+ jyks + "' or a.jbm2='"+ jyks + "' or a.jbm3='"+ jyks + "' or a.jbm4 = '"+ jyks + "') and b.JSMC='"+roleName+"'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return list.get(0).get("dlm").toString();
		}
		return null;
	}

	/**
	 * 根据角色和部门查出对应人员
	 * @author:zhangyi
	 * @version 创建时间：2015年11月10日 上午10:25:14
	 * @param jyks
	 * @param roleJszxzr
	 * @return
	 */
	public String getUserByUserRole(String roleName) {
		String sql = "select a.dlm as \"dlm\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and b.JSMC='"+roleName+"'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list.size() > 0) {
			return list.get(0).get("dlm").toString();
		}
		return null;
	}

	/**
	 * 根据角色和部门查出对应人员列表
	 * @author:zhangyi
	 * @version 创建时间：2015年11月10日 上午10:25:14
	 * @param jyks
	 * @param roleJszxzr
	 * @return
	 */
	public List<Map<String, Object>> getUserListByUserRoleAndorgCode(String ypjyks,String jyks, String roleName) {
		SysYh user = AppUtil.getCurrentUser();
		String userName= user.getUsername();
		String sql = "select a.dlm as \"dlm\",a.xm as \"xm\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and (a.BMBH='"+ jyks + "' or a.jbm1='"+ jyks + "' or a.jbm2='"+ jyks + "' or a.jbm3='"+ jyks + "' or a.jbm4 = '"+ jyks + "') and b.JSMC='"+roleName+"' and a.dlm !='"+userName+"'";
		if(roleName.equals("ROLE_JYRY")) {
			sql = "select a.dlm as \"dlm\",a.xm as \"xm\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
					+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and (a.BMBH='" + jyks + "' or a.jbm1='" + jyks + "' or a.jbm2='" + jyks + "' or a.jbm3='" + jyks + "' or a.jbm4 = '" + jyks + "'or a.bmbh ='"+ypjyks+"') and b.JSMC='" + roleName + "'";
		}
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	/**
	 * 根据角色和部门查出对应人员列表(取出当前登陆人姓名）
	 * @author duanpeijun
	 * @date 2016年4月29日
	 * @param jyks
	 * @param roleName
	 * @return
	 */
	public List<Map<String, Object>> getUserListByUserRoleAndorgCodeQcdq(String ypjyks,String jyks, String roleName,String username) {
		String sql = "select a.dlm as \"dlm\",a.xm as \"xm\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
				+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and (a.BMBH='"+ jyks + "' or a.jbm1='"+ jyks + "' or a.jbm2='"+ jyks + "' or a.jbm3='"+ jyks + "' or a.jbm4 = '"+ jyks + "') and b.JSMC='"+roleName+"' and a.dlm not in '"+username+"'";
		if(roleName.equals("ROLE_JYSHRY"))
		{
			sql = "select a.dlm as \"dlm\",a.xm as \"xm\" from SYS_YH a,SYS_JS b,SYS_YHJS c "
					+ "where a.YHBH=c.YHBH and b.JSBH=c.JSBH and (a.BMBH='"+ jyks + "' or a.jbm1='"+ jyks + "' or a.jbm2='"+ jyks + "' or a.jbm3='"+ jyks + "' or a.jbm4 = '"+ jyks + "' or a.bmbh ='"+ypjyks+"') and b.JSMC='"+roleName+"' and a.dlm not in '"+username+"'";

		}
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	/**
	 * 根据样品id获取对应任务id
	 * @author:zhangyi
	 * @version 创建时间：2015年12月28日 下午1:42:17 
	 * @param ypid
	 */
	public List<Map<String, Object>> getTaskId(Integer ypid) {
		String sql = "select t.id_ as \"taskId\",t.name_ as \"tname\" from act_ru_task t left join act_ru_execution tt on t.execution_id_=tt.id_ where tt.business_key_=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,ypid+"");
		return list;
	}
	
	public List<Map<String, Object>> getzjr(String bgbh){
		String str = "";
		if(bgbh!=null&&!"".equals(bgbh)){
			str=str+" and a.bgbh = '"+ bgbh+ "'";
		}
		String sql = "select a.id,a.bgbh,b.xm as bzr "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh where 1=1 " +str ;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据检验科室编号去查询技术中心的编号
	 * @author duanpeijun
	 * @date 2016年4月29日
	 * @param bgbh
	 * @return
	 */
	public List<Map<String, Object>> getJszxbh(String jyksbh){
		String sql = "select distinct t.jszxbh as \"jszxbh\" from sys_jglsgx t where t.jyksbh = '"+jyksbh+"' or t.jszxbh = '"+jyksbh+"'" ;
		return jdbcTemplate.queryForList(sql);
	}
}