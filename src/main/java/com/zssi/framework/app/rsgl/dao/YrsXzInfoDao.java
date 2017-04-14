package com.zssi.framework.app.rsgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.model.YrsXzInfo;

@Repository
public class YrsXzInfoDao extends HibernateBaseDaoImpl<YrsXzInfo, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询薪资管理信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getXzInfoList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.rybh like '%"+ code+ "%' or a.ryxm like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.rybh,a.ryxm,a.yf,a.jbgz,a.jxgz,a.jbf,"
				+ "a.qt,a.wcbz,a.yfgz,a.sfgz,a.bz from y_rs_xz_info a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.rybh like '%"+ code+ "%' or a.ryxm like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.rybh,a.ryxm,a.yf,a.jbgz,a.jxgz,a.jbf,"
				+ "a.qt,a.wcbz,a.yfgz,a.sfgz,a.bz from y_rs_xz_info a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	/**
	 * 拉取修改内容
	 * @author liangkaidi
	 * @date 2015-11-26
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getXzgl(Integer id) {
		String str = "";
		if(id!=null&&!"".equals(id)){
			str= str + " and a.id="+id;
		}
		String sql = "select a.id,a.rybh,a.ryxm,a.yf,a.jbgz,a.jxgz,a.jbf,"
				+ "a.qt,a.wcbz,a.yfgz,a.sfgz,a.bz from y_rs_xz_info a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
/**
 * 获取人员编号
 * @author liangkaidi
 * @date 2016-1-8
 * @param str
 * @return
 */
	public List<Map<String, Object>> getBgbhList( ) {
		String sql="select a.rybh from y_rs_xz_info a where 1=1";
		return jdbcTemplate.queryForList(sql);
	}

}
