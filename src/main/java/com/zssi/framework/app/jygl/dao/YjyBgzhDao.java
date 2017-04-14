package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.jygl.model.YjyBgzh;

/**
 * 报告整合
 * @author duanpeijun
 * @date 2015年11月24日
 */
@Repository
public class YjyBgzhDao extends HibernateBaseDaoImpl<YjyBgzh, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 报告整合List
	 * @author duanpeijun
	 * @date 2015年11月24日
	 * @param bgbh
	 * @return
	 */
	public List<Map<String, Object>> getbgzh(String bgbh){
		String str = "";
		if(bgbh!=null&&!"".equals(bgbh)){
			str=" and a.bgbh = '"+bgbh+"'";
		}
		String sql = " select a.id,a.bgbh,a.fmdz,a.fmmc,a.sydz,a.symc,a.fydz,a.fymc,a.fddz,a.fdmc,a.bz from y_jy_bgzh a "
				   + "where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	
	
}
