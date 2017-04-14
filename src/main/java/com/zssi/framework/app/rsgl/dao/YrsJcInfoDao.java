package com.zssi.framework.app.rsgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.model.YrsJcInfo;

@Repository
public class YrsJcInfoDao extends HibernateBaseDaoImpl<YrsJcInfo, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询奖惩管理
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getJcInfoList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.rybh like '%"+ code+ "%' or a.ryxm like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.rybh,a.ryxm,a.khyf,"
				+ "a.jcqk,a.bz from y_rs_jc_info a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月23日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.rybh like '%"+ code+ "%' or a.ryxm like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.rybh,a.ryxm,a.khyf,"
				+ "a.jcqk,a.bz from y_rs_jc_info a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
}
