package com.zssi.framework.app.ypgl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypTy;

@Repository
public class YypTyDao extends HibernateBaseDaoImpl<YypTy, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：样品退样列表
	 * @author duanpeijun
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getTyList(Integer start,Integer limit,String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.ypbh like '%"+ code + "%' or a.ewmbh like '%"+ code + "%' or a.ypmc like '%"+ code + "%'";
		}
		String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,to_char(a.tysj,'yyyy-mm-dd') as tysj,a.kfjsr,to_char(a.jssj,'yyyy-mm-dd') as jssj,a.tyr,a.blr,a.tysl,"
				   + "a.bz from y_yp_ty a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
}
