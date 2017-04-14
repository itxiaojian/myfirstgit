package com.zssi.framework.app.jygl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.jygl.model.YbgYqjl;

/**
 * 报告延期记录
 * @author liujiansen
 * @date 2015年12月19日
 */
@Repository
public class YbgYqjlDao extends HibernateBaseDaoImpl<YbgYqjl, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
}
