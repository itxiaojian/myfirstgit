package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwYgflmx;

@Repository
public class YcwYgflmxDao extends HibernateBaseDaoImpl<YcwYgflmx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询员工福利明细
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYgflmxList(Integer start,
			Integer limit, String flbh) {
		String sql = "select a.id,a.ygxm,a.ssyf,b.zdmc as flmc,a.flxq,a.je"
				+ " from y_cw_ygflmx a left join (select zdz,zdmc from sys_sjzd where zl='fllx' and jb=2) b on a.flmc=b.zdz where a.flbh = '"+flbh+"'";
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 获取当前最大的成本编号
	 * @author wangyong
	 * @date 2016年4月7日
	 * @return
	 */
	public List<Map<String, Object>> getFlbh() {
		String sql = "select max(flbh) flbh from Y_CW_YGFL" ;
		return jdbcTemplate.queryForList(sql);
	}
	
}
