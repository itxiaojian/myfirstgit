package com.zssi.framework.app.rzcpgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rzcpgl.model.YrzCpxx;

@Repository
public class YrzCpxxDao extends HibernateBaseDaoImpl<YrzCpxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询产品信息
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getCpxxList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.cpbh like '%"+ code+ "%' or a.cpmc like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.cpbh,a.cpmc,a.cpxh,a.cpcs,a.zzs,a.scgc,"
				+ "to_char(a.rzrq,'YYYY-MM-dd') as rzrq,a.rzlx,a.bgbh_id,to_char(a.yxq,'YYYY-MM-dd HH:mm:ss') as yxq,"
				+ "to_char(a.xgsj,'YYYY-MM-dd HH:mm:ss') as xgsj,a.xgr,a.bz from y_rz_cpxx a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 认证类型  数据字典
	 * @author wangyong
	 * @date 2015年10月9日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql ="select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.cpbh like '%"+ code+ "%' or a.cpmc like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.cpbh,a.cpmc,a.cpxh,a.cpcs,a.zzs,a.scgc,"
				+ "to_char(a.rzrq,'YYYY-MM-dd') as rzrq,a.rzlx,a.bgbh_id,to_char(a.yxq,'YYYY-MM-dd HH:mm:ss') as yxq,"
				+ "to_char(a.xgsj,'YYYY-MM-dd HH:mm:ss') as xgsj,a.xgr,a.bz from y_rz_cpxx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 数据字典中获取
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param zdzl
	 * @return
	 */
		public List<Map<String, Object>> getRzlx(String zdzl) {
			String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
/**
 * 查取认证产品信息
 * @author liangkaidi
 * @date 2015-12-1
 * @param id
 * @return
 */
	public List<Map<String, Object>> gerzcpxx(String id) {
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id like '%"+ id+ "%' ";
		}
		String sql = "select a.id,a.cpbh,a.cpmc,a.cpxh,a.cpcs,a.zzs,a.scgc,"
				+ "to_char(a.rzrq,'YYYY-MM-dd') as rzrq,a.rzlx,a.bgbh_id,to_char(a.yxq,'YYYY-MM-dd HH:mm:ss') as yxq,"
				+ "to_char(a.xgsj,'YYYY-MM-dd HH:mm:ss') as xgsj,a.xgr,a.bz from y_rz_cpxx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
}
