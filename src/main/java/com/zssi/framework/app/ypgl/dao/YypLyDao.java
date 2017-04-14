package com.zssi.framework.app.ypgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypLy;

@Repository
public class YypLyDao extends HibernateBaseDaoImpl<YypLy, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：样品领用列表
	 * @author duanpeijun
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getLyList(Integer start,Integer limit,String code){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.ypbh like '%"+ code+ "%' or a.bgbh like '%"+ code+ "%' or a.ypmc like '%"+code+"%'";
		}
		String sql ="select a.id,a.ypbh,a.ewmbh,a.ypmc,to_char(a.lysj,'yyyy-mm-dd') as lysj,a.lysl,a.lyr,a.blr,a.lyyt,a.bz,"
				   + "a.bgbh from y_yp_ly a where 1=1 " + str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 样品归还时查询改样品信息的领用数量，用于做表单校验
	 * @author wangyong
	 * @date 2015年11月29日
	 * @param start
	 * @param limit
	 * @param ypbh
	 * @return
	 */
	public List<Map<String, Object>> getYply(String ypbh){
		String str = "";
		if(ypbh!=null&&!"".equals(ypbh)){
			str=str+" and a.ypbh like '%" + ypbh + "%'";
		}
		String sql ="select a.lysl from y_yp_ly a where 1=1 " + str;
		return jdbcTemplate.queryForList(sql);
	}
}
