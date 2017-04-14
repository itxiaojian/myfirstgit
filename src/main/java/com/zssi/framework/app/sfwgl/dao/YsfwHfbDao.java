package com.zssi.framework.app.sfwgl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sfwgl.model.YsfwHfb;

@Repository 
public class YsfwHfbDao extends HibernateBaseDaoImpl< YsfwHfb, Integer>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	public Pagination<Map<String, Object>> getHfbList(Integer start,
			Integer limit, String code) {

		String str = "";
		
		if (code != null && !"".equals(code)) {
			
			str = str+ " and a.fwid  like '%"+ code+ "%' or a.hfr  like '%"+ code+ "%'";
		}
		String sql = "  select a.id ,a.fwid,a.hfbr,a.hfr,a.fj,to_char(a.hfsj,'yyyy-mm-dd hh:mi:ss') as hfsj from y_sfw_hfb a  where 1=1 "+str;

		return jdbcPager.queryPage(sql, start, limit);
	}
	
}