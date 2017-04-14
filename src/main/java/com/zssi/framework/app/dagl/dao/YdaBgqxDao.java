package com.zssi.framework.app.dagl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dagl.model.YdaBgqx;

/** 
 * 档案保管期限dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午6:52:28 
 * 类说明 
 */
@Repository
public class YdaBgqxDao extends HibernateBaseDaoImpl<YdaBgqx, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	public Pagination<Map<String, Object>> getDaBgqxList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.lmmc like '%"+ code+ "%' ";
		}
		String sql = "  select a.id,a.lmmc,a.damj,a.bgqx,a.lmid,a.bz from y_da_bgqx a  where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	public void deleteJsfwXyBgqx(Integer id){
		String sql = "delete from y_da_bgqx where id="+id;
				jdbcTemplate.execute(sql);
	}
	
	/**
	 * 下拉菜单查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	public List<Map<String, Object>> getXg(String id) {
	String str = "";
	if (id != null && !"".equals(id)) {
		str=str+" and a.id like '%"+ id+ "%' ";
	}
	String sql = "  select a.id,a.lmmc,a.damj,a.bgqx,a.lmid,a.bz from y_da_bgqx a  where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}
	/**
	 * 数据字典中获取
	 * @author liangkaidi
	 * @date 2015-11-13
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByList(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	
	
	
}