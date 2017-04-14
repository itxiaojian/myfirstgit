package com.zssi.framework.app.khgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Repository
public class YkhKhxxcxDao extends HibernateBaseDaoImpl<YkhKhxx, Integer>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-1-15
	 * @param tabName
	 * @return
	 */
//	public List<Map<String, Object>> getZdmc(String tabName) {
//		String sql="select column_name as code,comments as name from user_col_comments where Table_Name='"+tabName+"' and column_name not in ('YWKSBH',"
//				+ "'YHXTK','SSBH','JYKSBH','EWMTP','EWMBH','BZ','ID') ";
//		return jdbcTemplate.queryForList(sql);
//	}
	public List<Map<String, Object>> getZdmc(String tabName) {
		String sql="select b.column_name as code,case when instr(b.comments ,'(')-1>0 then substr(b.comments ,1,instr(b.comments ,'(')-1) when instr(b.comments ,'（')-1>0 "
				+ "then substr(b.comments ,1,instr(b.comments ,'（')-1) else b.comments  end as name from (select TABLE_NAME,COLUMN_NAME,COLUMN_ID from user_tab_columns where table_name='"+tabName+"') a "
				+ "left join (select TABLE_NAME,COLUMN_NAME,COMMENTS from user_col_comments where table_name='"+tabName+"') b on a.COLUMN_NAME=b.COLUMN_NAME "
				+ "where 1=1 and b.column_name not in ('BZ','ID') order by a.COLUMN_ID";
		return jdbcTemplate.queryForList(sql);
	}

	/**
 * 
 * @author liangkaidi
 * @date 2016-1-13
 * @param start
 * @param limit
 * @param strs
 * @param join
 * @param cxtj
 * @param string
 * @return
 */
public List<Map<String, Object>> getKhxxcxList(Integer start, Integer limit,String cs,String join,String cxtj,String tabName) {
	String str="";
	if(cxtj!=null&&!"".equals(cxtj)){
		str=str+cxtj;
	}
	String sql="SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM (SELECT "+cs+" FROM "+tabName+" a "+join+" where 1=1 "+str+" ) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
	
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
	SysYh user=AppUtil.getCurrentUser();
	List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
	List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
	if(jybm.size()!=0){
		str=str+" and a.jyks='"+user.getBmbh()+"' ";
	}else if(jsbm.size()!=0){
		str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
	}
	return str;
}

/**
 * 
 * @author liangkaidi
 * @date 2016-1-13
 * @param start
 * @param limit
 * @param cs
 * @param join
 * @param cxtj
 * @param tabName
 * @return
 */
public List<Map<String,Object>> getKhxxcxcxCount(Integer start, Integer limit,String cs,String join,String cxtj,String tabName) {
	String str="";
	str=str+this.getBmxx(str);
	if(cxtj!=null&&!"".equals(cxtj)){
		str=str+cxtj;
	}
	String sql="SELECT count(1) as cnt FROM "+tabName+" a "+join+" where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/**
	 * excel导出
	 *  @author liangkaidi
	 * @date 2016年1月14日
	 * @param cs 
	 * @param join
	 * @param cxtj
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getExcelList(String cs,String join,String cxtj,String tabName) {
		String str="";
		if(cxtj!=null&&!"".equals(cxtj)){
			str=str+cxtj;
		}
		String sql="SELECT "+cs+" FROM "+tabName+" a "+join+" where 1=1 "+str;
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

}
