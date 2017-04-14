package com.zssi.framework.app.bhsz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.bhsz.model.YbgBhsz;
import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;

@Repository
public class YbgBhszDao extends HibernateBaseDaoImpl<YbgBhsz, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 根据样品信息中的字号（例：DQ）去查出对应的字号分类（例：0）
	 * @author duanpeijun
	 * @date 2015年12月19日
	 * @param zh    字号
	 * @return
	 */
	public List<Map<String, Object>> getBhszList(String zh,String djlx){
		String str = "";
		if (zh != null && !"".equals(zh)) {
			str = str + " and a.zh='"+zh+"'";
		}
		if(djlx!=null&&!"".equals(djlx)){
			if("1".equals(djlx)){
				str = str + " and a.zhfl in (4,5,6)";
			}else{
				str = str + " and a.zhfl in (0,1,2,3)";
			}
		}
		String sql = "select a.id,a.bmbh,a.bmmc,a.bh,a.zh,a.bz,a.zhmc,a.zhfl from y_bg_bhsz a where 1=1 " + str;
		return jdbcTemplate.queryForList(sql);
	}
}
