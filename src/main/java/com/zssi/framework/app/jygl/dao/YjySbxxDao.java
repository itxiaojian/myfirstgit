package com.zssi.framework.app.jygl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjySbxx;

/**
 * 检验设备信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Repository
public class YjySbxxDao extends HibernateBaseDaoImpl<YjySbxx, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：检验设备信息
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getJysbxxList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str = str + " and a.bgbh like '%"+ canshu+ "%' or a.sbbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.bgbh,a.sbbh,a.dw,a.sysl,to_char(a.syrq,'YYYY-MM-dd') as syrq,a.syqzt,a.syhzt,a.syhj,a.syr,a.bz from y_jy_sbxx a where 1=1 " + str;
		return jdbcPager.queryPage(sql, start, limit);
	}
}
