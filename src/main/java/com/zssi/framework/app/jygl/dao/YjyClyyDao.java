package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyClyy;

/**
 * 常规结论用语
 * @author duanpeijun
 * @date 2015年11月13日
 */
@Repository
public class YjyClyyDao extends HibernateBaseDaoImpl<YjyClyy, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 常用检验结论用语后台
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getClyy(Integer start, Integer limit,String canshu){
		
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
//			str=str+" and a.bgbh like '%"+ canshu+ "%' or a.ypbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.cgjlyy,a.bz,a.jllb1,a.jllb2,a.xzr,to_char(a.xzsj,'YYYY-MM-dd') as xzsj from y_jy_clyy a where 1=1" + str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 常规结论用语
	 * @author duanpeijun
	 * @date 2015年11月13日
	 * @return
	 */
	public List<Map<String, Object>> getClyyList(String type,String num,String xm){
		String str = "";
		if(type!=null&&!"".equals(type)){
			str = str + " and a.jllb1 = '"+type+"'";
		}
		if(num!=null&&!"".equals(num)){
			str = str + " and a.jllb2 = '"+num+"'";
		} 
		if(xm!=null&&!"".equals(xm)){
			str = str + " and (a.xzr = '"+xm+"' or a.xzr = 'admin')";
		}
		String sql = " select a.id,a.cgjlyy,a.bz,a.jllb1,a.jllb2,a.xzr,to_char(a.xzsj,'YYYY-MM-dd') as xzsj from y_jy_clyy a where 1=1 " + str;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		
		return list;
	}
	
	/**
	 * 结论类别1，2（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByJylx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 根据ID查询该条数据
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> clyy(String id){
		String sql = " select a.id,a.cgjlyy,a.bz,a.jllb1,a.jllb2,a.xzr,to_char(a.xzsj,'YYYY-MM-dd') as xzsj from y_jy_clyy a where a.id='"+id+"'";
		return jdbcTemplate.queryForList(sql);
	}
}
