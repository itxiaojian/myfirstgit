package com.zssi.framework.app.tjgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.ypgl.model.YypYpxx;

@Repository
public class YpcxDao extends HibernateBaseDaoImpl<YypYpxx, Integer>{

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
				+ "where 1=1 and b.column_name not in ('YWKSBH','YHXTK','SSBH','JYKSBH','EWMTP','EWMBH','BZ','ID') order by a.COLUMN_ID";
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
				+ "where 1=1 and b.column_name not in ('YWKSBH','EWMTP','EWMBH','BZ','ID','SB','ZH','JYKSBH','SSBH','YWBY','LYSL') union "
				+ "select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='"+tabName1+"') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='"+tabName1+"') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('BGBH','BGMC','EWMBH','EWMTP','BZ','ID','DWMCTP','ZMCTP','JYKS','YWKS','YZMCTP','CYDW','RZFS','JSDW1','JSR','BZR')"
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
		String sql="select zdmc as name,zdz as code from sys_sjzd where zl='bgzd' and jb = 2 order by px";
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
	public List<Map<String, Object>> getYpcxList(Integer start, Integer limit,String cs,String join,String cxtj,String tabName) {
		String str="";
		str=str+this.getBmxx(str);
		if(cxtj!=null&&!"".equals(cxtj)){
			str=str+cxtj;
		}
		String sql="SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM (SELECT distinct a.ypbh as s,"+cs+",to_char(a.WCQX,'yyyy-MM-dd')as wcqx1,a.ypjyzt as ypzt1,to_char(x.shsj,'yyyy-MM-dd')as pzsj1 FROM "+tabName+" a "
				+ " left join y_jy_bgxx z on a.ypbh=z.bgbh left join y_cw_bgsf q on a.ypbh=q.bgbh left join view_pzjd x  "
				+ " on a.id = x.bgbh "+join+" where 1=1 and (q.jyfy is null or q.jyfy>=0) "+str+" order by a.ypbh desc) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
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
	public List<Map<String,Object>> getYpcxCount(Integer start, Integer limit,String cs,String join,String cxtj,String tabName) {
		String str="";
		str=str+this.getBmxx(str);
		if(cxtj!=null&&!"".equals(cxtj)){
			str=str+cxtj;
		}
		String sql="SELECT count(1) as cnt from(select distinct a.ypbh FROM "+tabName+" a left join y_jy_bgxx z on a.ypbh=z.bgbh left join y_cw_bgsf q on a.ypbh=q.bgbh left join view_pzjd x  "
				+ " on a.id = x.bgbh "+join+" where 1=1 and (q.jyfy is null or q.jyfy>=0) "+str+" ) ";
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
		String sql="SELECT distinct a.ypbh,"+cs+" FROM "+tabName+" a left join y_jy_bgxx z on a.ypbh=z.bgbh left join y_cw_bgsf q on a.ypbh=q.bgbh left join view_pzjd x  "
				+ " on a.id = x.bgbh "+join+"  where 1=1 and (q.jyfy is null or q.jyfy>=0) "+str+" order by a.ypbh desc "; 
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
		String sql="SELECT name from (select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='Y_YP_YPXX') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='Y_YP_YPXX') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('YWKSBH','EWMTP','EWMBH','BZ','ID','SB','ZH','JYKSBH','SSBH','YWBY','LYSL') union "
				+ "select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) "
                + "when instr(b.comments ,'（')-1>0 then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name,"
                + "a.COLUMN_ID as COLUMN_ID from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='Y_JY_BGXX') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='Y_JY_BGXX') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('BGBH','BGMC','EWMBH','EWMTP','BZ','ID','DWMCTP','ZMCTP','JYKS','YWKS','YZMCTP','CYDW','RZFS','JSDW1','JSR','BZR')"
				+ "order by COLUMN_ID) where 1 = 1 "+ str;
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
}

