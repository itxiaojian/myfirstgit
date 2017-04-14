package com.zssi.framework.app.sfwgl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;

@Repository 
public class YsfwFwxxDao extends HibernateBaseDaoImpl<YsfwFwxx, Integer>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	
	public Pagination<Map<String, Object>> getFwxxList(Integer start,
			Integer limit, String code) {

		String str = "";
		
		if (code != null && !"".equals(code)) {
			
			str = str+ " and a.sjr  like '%"+ code+ "%' or a.cs  like '%"+ code+ "%'";
		}
		String sql = "  select a.id ,a.sjr,a.cs,a.zt,a.zw,a.fj,to_char(a.fssj,'yyyy-mm-dd hh:mm:ss') as fssj,a.fwr,a.bmbh from y_sfw_yfwxx a  where 1=1 "+str;

		return jdbcPager.queryPage(sql, start, limit);
	}
}
