package com.zssi.framework.app.yxxgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.yxxgl.model.Yxxmb;

@Repository
public class YxxmbDao extends HibernateBaseDaoImpl<Yxxmb, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

/**
 * 功能--消息管理详细信息
 * @author mabiao
 * @version 2015年10月9日下午3:27:37
 * @param start
 * @param limit
 * @param code
 * @return
 */
	public Pagination<Map<String, Object>> getYxxmbList(Integer start,
			Integer limit, String code) {
		String str = "";
		if (code != null && !"".equals(code)) {
//			str = str+ " and a.bzbh like '%"+ code+ "%' or a.bzmc like '%"+ code+ "%'";
		}
		String sql = " select a.id as \"id\",a.xxlx as \"xxlx\",a.mbnr as \"mbnr\","
				+ "to_char(a.szrq,'yyyy-mm-dd') as \"szrq\",a.bz as \"bz\" from Y_XXMB a "
				+ "where 1=1 "+ str;
		return jdbcPager.queryPage(sql, start, limit);
	}

	/**
	 * 数据字典--消息类型
	 * @param xxlx
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String xxlx) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+xxlx+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

}