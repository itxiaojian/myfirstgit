package com.zssi.framework.app.sgzgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sgzgl.model.YsgzXx;

/**
 * 
 * @author liangkaidi
 * @date 2015-10-21
 */
@Repository
public class YsgzXxDao extends HibernateBaseDaoImpl<YsgzXx, Integer> {
@Autowired
private JdbcTemplate jdbcTemplate;  
@Autowired
private NamedParameterJdbcPager jdbcPager;


public Pagination<Map<String, Object>> getSgzxxList(Integer start,
		Integer limit, String code) {

	String str = "";
	if (code != null && !"".equals(code)) {
		
		str = str+ " and a.sgzbh  like '%"+ code+ "%' or a.rybh  like '%"+ code+ "%'";
	}
	String sql = "  select a.id,a.sgzbh,a.rybh,b.bmmc as ks_id,a.zcid,a.cplx, a.kczsb,a.xgr_id," 
			+"to_char(a.yxq,'yyyy-mm-dd HH:mm:ss') as yxq,to_char(a.xgrq,'yyyy-mm-dd HH:mm:ss') as xgrq,"
            +  "a.bz from y_sgz_xx a left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;

	return jdbcPager.queryPage(sql, start, limit);
}
/**
 * 查询数据
 * @author duanpeijun
 * @date 2015年10月22日
 * @param start
 * @param limit
 * @param code
 * @return
 */
public List<Map<String,Object>> getList(String code){
	String str = "";
	if (code != null && !"".equals(code)) {
		str = str+ " and a.sgzbh  like '%"+ code+ "%' or a.rybh  like '%"+ code+ "%'";
	}
	String sql =    " select a.id ,a.sgzbh,a.rybh ,a.zcid,a.cplx," +
			"a.kczsb,a.xgr_id,to_char(a.yxq,'yyyy-mm-dd HH:mm:ss') as yxq," +
			"to_char(a.xgrq,'yyyy-mm-dd HH:mm:ss') as xgrq,a.bz,b.bmmc as ks_id " +
			"from y_sgz_xx  a left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/**
 * 查询上岗证信息
 * @author liangkaidi
 * @date 2015-12-4
 * @param id
 * @return
 */
public List<Map<String, Object>> getSgzxx(String id) {
	String str = "";
	if (id != null && !"".equals(id)) {
		str=str+" and a.id like '%"+ id+ "%' ";
	}
	String sql =  " select a.id ,a.ks_id ,a.sgzbh,a.rybh ,a.zcid,a.cplx," +
			"a.kczsb,a.xgr_id,to_char(a.yxq,'yyyy-mm-dd HH:mm:ss') as yxq," +
			"to_char(a.xgrq,'yyyy-mm-dd HH:mm:ss') as xgrq,a.bz,b.bmmc as bmmc " +
			"from y_sgz_xx  " +
			"a left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}
/**
 * 数据字典
 * @author liangkaidi
 * @date 2016-1-5
 * @param zdzl
 * @return
 */
public List<Map<String, Object>> getDicByList(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}


}
