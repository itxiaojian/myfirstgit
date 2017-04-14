package com.zssi.framework.app.sfbzxx.dao;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sfbzxx.model.YsfXmxx;

@Repository
public class YsfXmxxDao extends HibernateBaseDaoImpl<YsfXmxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-12-9
	 * @param start
	 * @param limit
	 * @param jybh
	 * @return
	 */
	public Pagination<Map<String, Object>> getxmxxList(Integer start,Integer limit, String sfbzbh) {
		String str = "";
		if(sfbzbh!=null&&!"".equals(sfbzbh)){
			str=str+" and a.sfbzbh = '"+ sfbzbh +"'";
		}
		//将标准信息的产品名称拉入项目信息中
        String sql="select a.id,a.xmbh,a.xmmc,a.sfbzbh,a.jldw,a.dj, a.cplx,a.cplxbh,a.bz,b.cpmc as cpmc from y_sf_xmxx a left join y_sf_bzxx b on a.sfbzbh=b.sfbzbh where 1=1"+str;
		return jdbcPager.queryPage(sql, start, limit);
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
/**
 * 查询
 * @author liangkaidi
 * @date 2015-12-11
 * @param canshu
 * @return
 */
	public List<Map<String, Object>> getList(String canshu) {
		String str = "";
		if (canshu != null && !"".equals(canshu)) {
			str = str+ " and a.xmbh  like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.xmbh,a.xmmc,a.sfbzbh,a.jldw,a.dj, a.cplx,a.cplxbh,a.bz from y_sf_xmxx a where 1=1 "+str;
		
		return jdbcTemplate.queryForList(sql);
	}
/**
 * 从数据字典取值
 * @author liangkaidi
 * @date 2015-12-11
 * @param zdzl
 * @return
 */
	public List<Map<String, Object>> getDicByjb(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
