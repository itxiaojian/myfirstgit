package com.zssi.framework.app.wxpt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.wxpt.model.GlHbxx;

/**
*
*汇报工作
@Author oufeng	
@Date 2016年1月22日 下午3:38:18
@Version 1.0
*/

@Repository
public class WglXgxxHbDao  extends HibernateBaseDaoImpl<GlHbxx, String>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
}

