package com.zssi.framework.app.tszf.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.tszf.model.SysTszf;

/**
 * 
 * @author liangkaidi
 * @date 2015-12-21
 */

@Repository 
public class SysTszfDao extends HibernateBaseDaoImpl<SysTszf, Integer>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;	
	
	
	
	public Pagination<Map<String, Object>> getTszfList(Integer start,
			Integer limit, String code) {

		String str = "";
		if (code != null && !"".equals(code)) {
			
			str = str+ " and a.tszf  like '%"+ code+ "%'";
		}
		String sql = "  select a.id ,a.tszf,a.bz from sys_tszf a  where 1=1 "+str;

		return jdbcPager.queryPage(sql, start, limit);
	}



		/**
		 * 查出特殊字符
		 * @author liangkaidi
		 * @date 2015-11-30
		 * @param khbh
		 * @return
		 */
		public List<Map<String, Object>> getTszf(String tszf) {

			String sql =" select a.tszf from sys_tszf a where 1=1" ;
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 修改
		 * @author liangkaidi
		 * @date 2015-12-3
		 * @param id
		 * @return
		 */
				public List<Map<String, Object>> getTszfXg(String id) {
					String str = "";
					if (id != null && !"".equals(id)) {
						str=str+" and a.id like '%"+ id+ "%' ";
					}
					String sql ="  select a.id ,a.tszf,a.bz from sys_tszf a  where 1=1 "+str;
					return jdbcTemplate.queryForList(sql);
				}



		
				
}
