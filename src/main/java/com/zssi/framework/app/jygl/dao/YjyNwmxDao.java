package com.zssi.framework.app.jygl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.jygl.model.YjyNwmx;

/**
 * 内委管理
 * @author liujiansen
 * @date 2015年12月30日
 */
@Repository
public class YjyNwmxDao extends HibernateBaseDaoImpl<YjyNwmx, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 删除数据
	 * @author liujiansen
	 * @date 2016年1月6日
	 * @param parseInt
	 */
	public void deleteByNwbh(int nwbh) {
		String sql="DELETE FROM Y_JY_NWMX WHERE NWBH = "+nwbh;
		jdbcTemplate.execute(sql);
	}
}
