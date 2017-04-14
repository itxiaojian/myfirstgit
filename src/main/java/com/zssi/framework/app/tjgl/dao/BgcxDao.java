package com.zssi.framework.app.tjgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Repository
public class BgcxDao extends HibernateBaseDaoImpl<YjyBgxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 获取表字段
	 * @author liujiansen
	 * @date 2016年1月11日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getZdmc(String tabName) {
		String sql="select b.column_name as code,b.comments as name from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='"+tabName+"') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='"+tabName+"') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('EWMTP','EWMBH','BZ','ID','RZFS','FFZT','DYZT','DWMCTP','YZMCTP') order by a.COLUMN_ID";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取表字段
	 * @author liujiansen
	 * @date 2016年1月11日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getZdmc2(String tabName,String tabName1) {
		String sql="select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='"+tabName+"') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='"+tabName+"') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('BZ','EWMBH','EWMTP','ID','JYKSBH','YWKSBH','SSBH','ZH','BGBH','BGBH','CYDW','SSBH','SB','YWBY','LYSL') union "
				+ "select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='"+tabName1+"') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='"+tabName1+"') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('EWMBH','EWMTP','DWMCTP','JYKSBH','YZMCTP','BZ','ID','BGMC','RZFS','JYKS','YWKS','JSDW1','JSR','BZR')"
				+ "order by COLUMN_ID";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取表字段
	 * @author liusong
	 * @date 2016年1月11日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getZdmc1(String tabName,String tabName1) {
		String sql="select zdmc as name,zdz as code from sys_sjzd where zl='bgzd' and jb = 2 order by px ";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getBzrList() {
		String sql =" select b.yhbh,b.xm from sys_yh b where b.yhbh in(select distinct bzr from y_jy_bgxx)";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String, Object>> getJyksList() {
		String sql =" select a.id,a.bmmc from sys_zzjg a where a.sjbh='100250' order by a.px asc";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String, Object>> getYwksList() {
		String sql =" select a.id,a.bmmc from sys_zzjg a where a.sjbh='100230' order by a.px asc";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 报告预警查询未完成报告信息
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getBgxx(Integer start, Integer limit) {
		String str="";
		str=str+this.getBmxx1(str);
		String sql ="SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM ( SELECT X.*,rownum FROM ( select a.id,a.djlx,a.ypbh,a.ypmc,to_char(a.djsj,'yyyy-MM-dd')as djsj,to_char(a.wcqx,'yyyy-MM-dd')as wcqx,b.zdmc as ypjyzt,t.ASSIGNEE_ as qsr,d.xgjdry as bzr,e.shr as shr,f.xgjdry as pzr, "
			+"to_char(f.shsj,'yyyy-MM-dd') as pzsj,g.ysfje,g.jyfy,a.ypyj,a.yjzt,a.ypjyzt as ypzt1 from y_yp_ypxx a " 
			+"left join (select a.ASSIGNEE_,a.claim_time_,a.id from(select t.ASSIGNEE_,max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by a.id,t.ASSIGNEE_)a "
    		+"right join(select max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by  a.id)b on a.id = b.id and a.claim_time_= b.claim_time_)t on t.id=a.id " 
			+"left join(select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)d on a.id = d.bgbh " 
			+"left join(select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)e on a.id = e.bgbh "
			+"left join(select a.shsj,b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)f on a.id = f.bgbh "
			+"left join y_cw_bgsf g on a.ypbh = g.bgbh left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on to_char(a.YPJYZT)=b.zdz "
			+"where 1=1 and a.ypjyzt < 4 and (g.jyfy is null or g.jyfy >=0) "+str+" order by a.wcqx ) X ) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param join
	 * @param cxtj
	 * @param tabName
	 * @return
	 */
	public List<Map<String,Object>> getBgxxCount(Integer start, Integer limit) {
		String str="";
		str=str+this.getBmxx1(str);
		String sql="SELECT count(1) as cnt from y_yp_ypxx a " 
				+"left join (select a.ASSIGNEE_,a.claim_time_,a.id from(select t.ASSIGNEE_,max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by a.id,t.ASSIGNEE_)a "
	    		+"right join(select max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by  a.id)b on a.id = b.id and a.claim_time_= b.claim_time_)t on t.id=a.id " 
				+"left join(select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)d on a.id = d.bgbh " 
				+"left join(select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)e on a.id = e.bgbh "
				+"left join(select a.shsj,b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)f on a.id = f.bgbh "
				+"left join y_cw_bgsf g on a.ypbh = g.bgbh left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on to_char(a.YPJYZT)=b.zdz "
				+"where 1=1 and a.ypjyzt < 4 and (g.jyfy is null or g.jyfy >=0) "+str+"  order by a.wcqx  ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 报告预警查询未完成报告信息
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getBgxx1(Integer start1,Integer limit1) {
		String str="";
		str=str+this.getBmxx1(str);
		String sql ="SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM ( select a.id,a.djlx,a.ypbh,a.ypmc,to_char(a.djsj,'yyyy-MM-dd HH24:mi:ss')as djsj,to_char(a.wcqx,'yyyy-MM-dd')as wcqx,b.zdmc as ypjyzt,t.ASSIGNEE_ as qsr,d.xgjdry as bzr,e.shr as shr,f.xgjdry as pzr, "
				+"to_char(f.shsj,'yyyy-MM-dd') as pzsj,g.ysfje,g.jyfy,a.ypyj,a.yjzt,a.ypjyzt as ypzt1  from y_yp_ypxx a " 
				+"left join (select a.ASSIGNEE_,a.claim_time_,a.id from(select t.ASSIGNEE_,max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by a.id,t.ASSIGNEE_)a "
	    		+"right join(select max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by  a.id)b on a.id = b.id and a.claim_time_= b.claim_time_)t on t.id=a.id " 
				+"left join(select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)d on a.id = d.bgbh " 
				+"left join(select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)e on a.id = e.bgbh "
				+"left join(select a.shsj,b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)f on a.id = f.bgbh "
				+"left join y_cw_bgsf g on a.ypbh = g.bgbh left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on to_char(a.YPJYZT)=b.zdz "
				+"where a.wcqx is not null and a.ypjyzt > 3 and (g.jyfy is null or g.jyfy >=0) and f.shsj is not null and trunc(sysdate)-trunc(f.shsj)<=15 "+str+" order by a.wcqx ) X WHERE ROWNUM <="+limit1+" ) XX WHERE RN >"+start1;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String,Object>> getBgxx1Count(Integer start1, Integer limit1) {
		String str="";
		str=str+this.getBmxx1(str);
		String sql="SELECT count(1) as cnt from y_yp_ypxx a " 
				+"left join (select a.ASSIGNEE_,a.claim_time_,a.id from(select t.ASSIGNEE_,max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by a.id,t.ASSIGNEE_)a "
	    		+"right join(select max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by  a.id)b on a.id = b.id and a.claim_time_= b.claim_time_)t on t.id=a.id " 
				+"left join(select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配')b on a.shsj = b.shsj and a.bgbh= b.bgbh)d on a.id = d.bgbh " 
				+"left join(select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员')b on a.shsj = b.shsj and a.bgbh= b.bgbh)e on a.id = e.bgbh "
				+"left join(select b.xgjdry,b.bgbh,a.shsj from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='主检科室审核人员' group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='主检科室审核人员')b on a.shsj = b.shsj and a.bgbh= b.bgbh)f on a.id = f.bgbh "
				+"left join y_cw_bgsf g on a.ypbh = g.bgbh left join (select zdz,zdmc from sys_sjzd where zl='ypjyzt' and jb=2) b on to_char(a.YPJYZT)=b.zdz "
				+"where a.wcqx is not null and a.ypjyzt > 3 and (g.jyfy is null or g.jyfy >=0) and f.shsj is not null and trunc(sysdate)-trunc(f.shsj)<=15 "+str+" order by a.wcqx ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取过滤条件
	 * @author liujiansen
	 * @date 2016年1月15日
	 * @param str
	 * @return
	 */
	public String getBmxx(String str){
		String req="";
		String rep="";
	     SysYh user=AppUtil.getCurrentUser();
	     if(("".equals(user.getJbm1())||user.getJbm1()==null)&&("".equals(user.getJbm2())||user.getJbm2()==null)
					&&("".equals(user.getJbm3())||user.getJbm3()==null)&&("".equals(user.getJbm4())||user.getJbm4()==null)){
				List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
				List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
				if(jybm.size()!=0){
					req=req+"'"+user.getBmbh()+"',";
				}else if(jsbm.size()!=0){
					rep=rep+"'"+user.getBmbh()+"',";
				}
				if(!"".equals(req) && "".equals(rep)){
					str=str+" and z.jyks in("+req+" '101') ";
				}else if(!"".equals(rep) && "".equals(req)){
					str=str+" and z.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) ";
				}
			}else{
				List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
				List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
				List<Map<String,Object>> jybm1=this.getBm("100250", user.getJbm1());//判断当前登录人是否是科室人员
				List<Map<String,Object>> jsbm1=this.getBm("100240", user.getJbm1());//判断当前登录人是否是技术中心人员
				List<Map<String,Object>> jybm2=this.getBm("100250", user.getJbm2());//判断当前登录人是否是科室人员
				List<Map<String,Object>> jsbm2=this.getBm("100240", user.getJbm2());//判断当前登录人是否是技术中心人员
				List<Map<String,Object>> jybm3=this.getBm("100250", user.getJbm3());//判断当前登录人是否是科室人员
				List<Map<String,Object>> jsbm3=this.getBm("100240", user.getJbm3());//判断当前登录人是否是技术中心人员
				List<Map<String,Object>> jybm4=this.getBm("100250", user.getJbm4());//判断当前登录人是否是科室人员
				List<Map<String,Object>> jsbm4=this.getBm("100240", user.getJbm4());//判断当前登录人是否是技术中心人员
				if(jybm.size()!=0){
					req=req+"'"+user.getBmbh()+"',";
				}else if(jsbm.size()!=0){
					rep=rep+"'"+user.getBmbh()+"',";
				}
				if(jybm1.size()!=0){
					req=req+"'"+user.getJbm1()+"',";
				}else if(jsbm1.size()!=0){
					rep=rep+"'"+user.getJbm1()+"',";
				}
				if(jybm2.size()!=0){
					req=req+"'"+user.getJbm2()+"',";
				}else if(jsbm2.size()!=0){
					rep=rep+"'"+user.getJbm2()+"',";
				}
				if(jybm3.size()!=0){
					req=req+"'"+user.getJbm3()+"',";
				}else if(jsbm3.size()!=0){
					rep=rep+"'"+user.getJbm3()+"',";
				}
				if(jybm4.size()!=0){
					req=req+"'"+user.getJbm4()+"',";
				}else if(jsbm4.size()!=0){
					rep=rep+"'"+user.getJbm4()+"',";
				}
//			if(!"".equals(req) && "".equals(rep)){
//				str=str+" and a.jyks in("+req+" '101') ";
//			}else if(!"".equals(rep) && "".equals(req)){
//				str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) ";
//			}else 
				if(!"".equals(rep) && !"".equals(req)){
					str=str+" and (z.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) or z.jyks in("+req+" '101')) ";
				}
				
			}
		return str;
	}
	
	public String getBmxx1(String str){
		String req="";
		String rep="";
		SysYh user=AppUtil.getCurrentUser();
		if(("".equals(user.getJbm1())||user.getJbm1()==null)&&("".equals(user.getJbm2())||user.getJbm2()==null)
				&&("".equals(user.getJbm3())||user.getJbm3()==null)&&("".equals(user.getJbm4())||user.getJbm4()==null)){
			List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
			if(jybm.size()!=0){
				req=req+"'"+user.getBmbh()+"',";
			}else if(jsbm.size()!=0){
				rep=rep+"'"+user.getBmbh()+"',";
			}
			if(!"".equals(req) && "".equals(rep)){
				str=str+" and a.jyks in("+req+" '101') ";
			}else if(!"".equals(rep) && "".equals(req)){
				str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) ";
			}
		}else{
			List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
			List<Map<String,Object>> jybm1=this.getBm("100250", user.getJbm1());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm1=this.getBm("100240", user.getJbm1());//判断当前登录人是否是技术中心人员
			List<Map<String,Object>> jybm2=this.getBm("100250", user.getJbm2());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm2=this.getBm("100240", user.getJbm2());//判断当前登录人是否是技术中心人员
			List<Map<String,Object>> jybm3=this.getBm("100250", user.getJbm3());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm3=this.getBm("100240", user.getJbm3());//判断当前登录人是否是技术中心人员
			List<Map<String,Object>> jybm4=this.getBm("100250", user.getJbm4());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm4=this.getBm("100240", user.getJbm4());//判断当前登录人是否是技术中心人员
			if(jybm.size()!=0){
				req=req+"'"+user.getBmbh()+"',";
			}else if(jsbm.size()!=0){
				rep=rep+"'"+user.getBmbh()+"',";
			}
			if(jybm1.size()!=0){
				req=req+"'"+user.getJbm1()+"',";
			}else if(jsbm1.size()!=0){
				rep=rep+"'"+user.getJbm1()+"',";
			}
			if(jybm2.size()!=0){
				req=req+"'"+user.getJbm2()+"',";
			}else if(jsbm2.size()!=0){
				rep=rep+"'"+user.getJbm2()+"',";
			}
			if(jybm3.size()!=0){
				req=req+"'"+user.getJbm3()+"',";
			}else if(jsbm3.size()!=0){
				rep=rep+"'"+user.getJbm3()+"',";
			}
			if(jybm4.size()!=0){
				req=req+"'"+user.getJbm4()+"',";
			}else if(jsbm4.size()!=0){
				rep=rep+"'"+user.getJbm4()+"',";
			}
//		if(!"".equals(req) && "".equals(rep)){
//			str=str+" and a.jyks in("+req+" '101') ";
//		}else if(!"".equals(rep) && "".equals(req)){
//			str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) ";
//		}else 
			if(!"".equals(rep) && !"".equals(req)){
				str=str+" and (a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) or a.jyks in("+req+" '101')) ";
			}
			
		}
		return str;
	}

	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @return
	 */
	public List<Map<String, Object>> getBgcxList(Integer start, Integer limit,String cs,String join,String cxtj,String tabName) {
		String str="";
		str=str+this.getBmxx(str);
		if(cxtj!=null&&!"".equals(cxtj)){
			str=str+cxtj;
		}
//		String sql=" SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM (SELECT distinct z.ypbh as s,"+cs+" a.BGMC as WJMC,to_char(z.WCQX,'yyyy-MM-dd')as wcqx1, "
//				+ " to_char(x.shsj,'yyyy-MM-dd')as pzsj1,z.ypjyzt as ypzt1 "
//				+ " FROM y_yp_ypxx z left join "+tabName+" a on a.bgbh=z.ypbh left join y_cw_bgsf q on z.ypbh=q.bgbh  "
//				+ "	left join view_pzjd x on z.id = x.bgbh "+join+" "
//				+ " where 1=1 and (q.jyfy is null or q.jyfy>=0) "+str+"  order by z.ypbh desc ) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
		String sql=" SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM (SELECT z.s,"+cs+" z.WJMC,to_char(z.WCQX1,'yyyy-MM-dd')as wcqx1,to_char(z.pzsj1,'yyyy-MM-dd')as pzsj1,z.ypzt1 "
				+ " FROM VIEW_BG_GJCX1 z "+join+" where 1=1 "+str+"  order by z.ypbh desc ) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param join
	 * @param cxtj
	 * @param tabName
	 * @return
	 */
	public List<Map<String,Object>> getBgcxCount(Integer start, Integer limit,String cs,String join,String cxtj,String tabName) {
		String str="";
		str=str+this.getBmxx(str);
		if(cxtj!=null&&!"".equals(cxtj)){
			str=str+cxtj;
		}
//		String sql="SELECT count(1) as cnt from(select distinct z.ypbh FROM y_yp_ypxx z left join "+tabName+" a on a.bgbh=z.ypbh left join y_cw_bgsf q on z.ypbh=q.bgbh "
//				+ " left join view_pzjd x on z.id = x.bgbh "+join+" "
//				+ " where 1=1 and (q.jyfy is null or q.jyfy>=0) "+str+" ) ";
		String sql="SELECT count(1) as cnt from VIEW_BG_GJCX1 z "+join+" where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * excel导出
	 * @author liujiansen
	 * @date 2016年1月14日
	 * @param cs
	 * @param join
	 * @param cxtj
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getExcelList(String cs,String join,String cxtj,String tabName) {
		String str="";
		str=str+this.getBmxx(str);
		if(cxtj!=null&&!"".equals(cxtj)){
			str=str+cxtj;
		}
		String sql=" SELECT distinct z.s,"+cs+" z.WJMC,to_char(z.WCQX1,'yyyy-MM-dd')as wcqx1,to_char(z.pzsj1,'yyyy-MM-dd')as pzsj1,z.ypzt1 "
				+ " FROM VIEW_BG_GJCX1 z "+join+" where 1=1 "+str+"  order by z.ypbh desc ";
		
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取部门信息
	 * @author liujiansen
	 * @date 2016年1月15日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String,Object>> getBm(String sjbh,String bmbh){
		String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where sjbh='"+sjbh+"' and bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getBt1(String cs){
		String str="";
		if(cs!=null&&!"".equals(cs)){
			str= str+"and code in ("+cs+")";
		}
		String sql="select name from(select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='Y_YP_YPXX') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='Y_YP_YPXX') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('BZ','EWMBH','EWMTP','ID','JYKSBH','YWKSBH','SSBH','ZH','BGBH','BGBH','CYDW','SSBH','SB','YWBY','LYSL') union "
				+ "select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='Y_JY_BGXX') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='Y_JY_BGXX') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('EWMBH','EWMTP','DWMCTP','JYKSBH','YZMCTP','BZ','ID','BGMC','RZFS','JYKS','YWKS','JSDW1','JSR','BZR')"
				+ "order by COLUMN_ID) where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getBt(String cs){
		String str="";
		if(cs!=null&&!"".equals(cs)){
			str= str+"and zdz in ("+cs+")";
		}
		String sql="select zdmc as name,zdz as code from sys_sjzd where zl='bgzd' and jb = 2 "+str+" order by px ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 分报告拖期查询
	 * 
	 * @author liusong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getBgyqList(String ksmc,String ksyf,String jsyf) {
		String str = "";
//		str=str+this.getBmxx(str);
		if (ksmc != null && !"".equals(ksmc)) {
			str = str + " and z.jyks = '"+ksmc+"'";
		}
		if(ksyf !=null&&!"".equals(ksyf)){
			str = str + " and to_char(x.shsj,'yyyy-MM-dd') between '"+ksyf+"' and '"+jsyf+"' ";
		}
			String sql ="SELECT X.* FROM("
			 	+" SELECT distinct z.ypbh as YPBH,z.YPMC,to_char(z.WCQX,'yyyy-MM-dd') as WCQX,n.xgjdry as BZR,'/'as FFRQ,to_char(bp.shsj,'yyyy-MM-dd') as BPSJ,"
			 	+" to_char(x.shsj,'yyyy-MM-dd') as PZSJ,nvl(to_char(js.shsj,'yyyy-MM-dd'),'/') as JSSJ,z.JYLX,d.bmmc as JYKS,to_char(z.DJSJ,'yyyy-MM-dd') as DJSJ "
			 	+" FROM y_yp_ypxx z left join Y_JY_BGXX a on a.bgbh=z.ypbh "
                +" left join(select b.shr,b.bgbh,a.shsj from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='技术中心批准人员' and shzt =1 group by bgbh)a "
                +" left join(select shr,bgbh,shsj from y_sh_yjb t where t.shjdmc='技术中心批准人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)x on z.id = x.bgbh "
                +" left join(select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a "
                +" left join(select xgjdry,bgbh,shsj from y_sh_yjb t where t.shjdmc='科室主任任务分配' and t.shzt =1 )b on a.shsj = b.shsj and a.bgbh= b.bgbh)n on z.id = n.bgbh "
                +" left join(select bgbh,max(shsj)as shsj from y_sh_yjb where shjdmc='主检科室审核人员' and shzt=1 group by bgbh)bp on bp.bgbh=z.id " 
                +" left join(select bgbh,max(shsj)as shsj from y_sh_yjb where shjdmc='业务科室接收人员' and shzt=1 group by bgbh)js on js.bgbh=z.id "
                +" left join sys_zzjg d on z.JYKS=d.bmbh where 1=1 and bp.shsj is not null "+str+" order by z.ypbh desc ) X "
                +" WHERE X.pzsj > X.wcqx";
			return jdbcTemplate.queryForList(sql);
	}

}
