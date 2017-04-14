package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwKssr;

@Repository
public class YcwKssrDao extends HibernateBaseDaoImpl<YcwKssr, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询科室收入
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getKssrList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (a.ksbh like '%"+ code+ "%' or a.ksmc like '%"+ code+ "%')";
		}
		String sql = "select a.id,a.ksbh,a.ksmc,a.jybh,a.ypmc,a.ypxq,a.cbje,"
				+ "a.skje,a.hssr,a.lrr,to_char(a.lrrq,'YYYY-MM-dd') as lrrq,a.xgje,a.xgr,"
				+ "to_char(a.xgrq,'YYYY-MM-dd') as xgrq,a.xgyy,a.bz from y_cw_kssr a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月28日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (a.ksbh like '%"+ code+ "%' or a.ksmc like '%"+ code+ "%')";
		}
		String sql = "select a.id,a.ksbh,a.ksmc,a.jybh,a.ypmc,a.ypxq,a.cbje,"
				+ "a.skje,a.hssr,a.lrr,to_char(a.lrrq,'YYYY-MM-dd') as lrrq,a.xgje,a.xgr,"
				+ "to_char(a.xgrq,'YYYY-MM-dd') as xgrq,a.xgyy,a.bz from y_cw_kssr a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String,Object>> getKssr(Integer id){
		String str = "";
		if(id!=null&&!"".equals(id)){
			str=str+" and a.id=" + id;
		}
		String sql = "select a.id,a.ksbh,a.ksmc,a.jybh,a.ypmc,a.ypxq,a.cbje,"
				+ "a.skje,a.hssr,a.lrr,to_char(a.lrrq,'YYYY-MM-dd') as lrrq,a.xgje,a.xgr,"
				+ "to_char(a.xgrq,'YYYY-MM-dd') as xgrq,a.xgyy,a.bz from y_cw_kssr a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
}
