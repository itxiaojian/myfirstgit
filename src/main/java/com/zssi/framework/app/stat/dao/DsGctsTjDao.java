package com.zssi.framework.app.stat.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.stat.model.DsTsfl;

@Repository
public class DsGctsTjDao extends HibernateBaseDaoImpl<DsTsfl, String> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 @Author oufeng
	 * @Date 2015年7月22日 下午3:09:56
	 * @Version 1.0
	 */
	public List<Map<String, Object>> getData(String str) {
		String str1="";
			if(  str!=null && str!=""){
				str1="  and id="+str;
		}else{
			str1="";
		}
		String sql = "select id,zl,sum(sl) as sl  from zs_tsfl    where 1=1 "
				+str1
				+ " group by id,zl  "
				+ " order  by  id";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获得部门名称
	 * */
	public List<Map<String, Object>> getTszl() {
		String sql ="select  id,zl  from zs_tsfl	group by id,zl  order by id";
		return jdbcTemplate.queryForList(sql);
	}
}