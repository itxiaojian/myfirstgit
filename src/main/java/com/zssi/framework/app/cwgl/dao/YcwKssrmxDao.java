package com.zssi.framework.app.cwgl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwKssrmx;

@Repository
public class YcwKssrmxDao extends HibernateBaseDaoImpl<YcwKssrmx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询科室收入明细
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getKssrmxList(Integer start,
			Integer limit, String jybh) {
		String str = "";
		if(jybh!=null&&!"".equals(jybh)){
			str=str+" and a.jybh = '"+ jybh + "'";
		}
		String sql = "select a.id,a.jybh,a.fymc,a.fylx,a.fynr,a.je,"
				+ "a.bz from y_cw_kssrmx a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
}
