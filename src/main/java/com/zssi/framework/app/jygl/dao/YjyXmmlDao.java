package com.zssi.framework.app.jygl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyXmml;

/**
 * 检验项目目录
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Repository
public class YjyXmmlDao extends HibernateBaseDaoImpl<YjyXmml, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：检验项目目录
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getJyxmmlList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgbh like '%"+ canshu+ "%' or a.bzbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.bgbh,a.bzbh,a.xmbh,a.xmmc,a.xmlx,a.xmyq,a.jldw,a.jyfy,"
				+ "a.bzmax,a.bzmin,a.scz,a.pdyy,to_char(a.jyrq,'YYYY-MM-dd') as jyrq,a.bmbh,a.pdfs,a.jyr,"
				+ "a.zdcx,a.bz from y_jy_xmml a where 1=1 "
				+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
}
