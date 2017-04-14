package com.zssi.framework.app.rsgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.model.YrsXzinfoKc;

@Repository
public class YrsXzinfoKcDao extends HibernateBaseDaoImpl<YrsXzinfoKc, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询薪资扣除信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getXzinfoKcList(Integer start,
			Integer limit, String rybh) {
		String str = "";
		if(rybh!=null&&!"".equals(rybh)){
			str=str+" and a.rybh = '"+ rybh+ "'";
		}
//		String sql = "select a.id,a.rybh,a.yf,a.qqkc,a.ylbx,a.yb,a.sybx,a.sbxj,a.zfgjj,a.gs,a.kcxj,a.bz from y_rs_xzinfo_kc a where 1=1 "+str;
		
	String sql="select a.id,a.rybh,a.qqkc,a.ylbx,a.yb,a.sybx,a.sbxj,a.zfgjj,a.gs,a.kcxj,a.bz,b.yf as yf from y_rs_xzinfo_kc a left join y_rs_xz_info b on a.rybh=b.rybh where 1=1"+str;
	
		return jdbcPager.queryPage(sql, start, limit);
	}

	public List<Map<String, Object>> getList(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getxzkc(Integer id) {
		String str = "";
		if(id!=null&&!"".equals(id)){
			str= str + " and a.id="+id;
		}
		String sql="select a.id,a.rybh,a.qqkc,a.ylbx,a.yb,a.sybx,a.sbxj,a.zfgjj,a.gs,a.kcxj,a.bz,b.yf as yf from y_rs_xzinfo_kc a left join y_rs_xz_info b on a.rybh=b.rybh where 1=1"+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	
}
