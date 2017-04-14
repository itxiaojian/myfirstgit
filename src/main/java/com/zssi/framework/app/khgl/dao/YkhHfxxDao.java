package com.zssi.framework.app.khgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.model.YkhHfxx;


//客户回访信息dao
//liusong 2016-3-7
@Repository
public class YkhHfxxDao extends HibernateBaseDaoImpl<YkhHfxx, Integer> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getHfxxList(Integer start,Integer limit, String code){
		String str="";
      if (code != null && !"".equals(code)) {
			str = str+ " and a.khbh  = '"+ code+ "' or a.khmc like '%"+ code+ "%'";
		}
		String sql=" select a.id,a.khbh,a.khdz,a.bfry,to_char(a.bfrq,'YYYY-MM-dd')as bfrq,a.ryzw,a.lxdh,a.hzqk,a.khpj,a.bfjl,"
				+ " a.yjyq,a.dcjy,a.ywry,a.bz,a.khmc from y_kh_khhf a where 1=1 "+str+" order by a.bfrq desc ";
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询单条记录
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Map<String, Object>> getHfxx(String id){
		String sql =  " select a.id,a.khbh,a.khdz,a.bfry,to_char(a.bfrq,'YYYY-MM-dd')as bfrq,a.ryzw,a.lxdh,a.hzqk,a.khpj,a.bfjl,"
				+ " a.yjyq,a.dcjy,a.ywry,a.bz,a.khmc from y_kh_khhf a where a.id="+id;
		return jdbcTemplate.queryForList(sql);
	}

}
