package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyBgmb;

/**
 * 检验报告模版
 * @author duanpeijun
 * @date 2015年10月13日
 */
@Repository
public class YjyBgmbDao extends HibernateBaseDaoImpl<YjyBgmb, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：检验报告模版
	 * @author duanpeijun
	 * @date 2015年10月13日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getBgmbList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.mbmc like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.mbmc,a.mblb,a.mblx,a.bz,a.mbdz,a.xzr,to_char(a.xzsj,'YYYY-MM-dd') as xzsj,a.sub from y_jy_bgmb a where 1=1 "
				+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 下拉框查询
	 * @author liusong
	 * @date 2015年11月17日
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 报告模版List
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getBgmb(String code){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=" and a.mbmc like '%"+code+"%'";
		}
		String sql = "select a.id,a.mbmc,a.mblb,a.mblx,a.bz,a.mbdz,a.xzr,to_char(a.xzsj,'YYYY-MM-dd') as xzsj,a.sub from y_jy_bgmb a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
}
