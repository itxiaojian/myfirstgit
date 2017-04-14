package com.zssi.framework.app.ypgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypJyfa;

@Repository
public class YypJyfaDao extends HibernateBaseDaoImpl<YypJyfa, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：预检方案列表
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getJyfaList(Integer start,Integer limit,String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.fabh like '%"+ code + "%' or a.jylb like '%"+ code + "%'";
		}
		String sql = "select a.id,a.fabh,a.jylb,a.ypmc,a.bzmc,a.xmbh,a.xmmc,a.zxmbh,a.zxmmc,a.bz from y_yp_jyfa a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author liujiansen
	 * @date 2015年10月22日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.fabh like '%"+ code + "%' or a.jylb like '%"+ code + "%'";
		}
		String sql="SELECT a.id, a.fabh, a.jylb, a.ypmc, a.bzmc, a.xmbh, a.xmmc, a.zxmbh, a.zxmmc, a.bz FROM y_yp_jyfa a WHERE 1 = 1"+str;
		return jdbcTemplate.queryForList(sql);
	}
}
