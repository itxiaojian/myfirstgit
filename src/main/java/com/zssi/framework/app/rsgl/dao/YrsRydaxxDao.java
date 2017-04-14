package com.zssi.framework.app.rsgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.model.YrsRydaxx;

@Repository
public class YrsRydaxxDao extends HibernateBaseDaoImpl<YrsRydaxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询人员档案信息
	 * @author wangyong
	 * @date 2015年10月20日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getRydaxxList(Integer start,
			Integer limit, String chaxun) {
		String str = "";
		if (chaxun != null && !"".equals(chaxun)) {
			str=str+" and a.xm like '%"+ chaxun+ "%' or a.dlm like '%"+ chaxun+ "%'";
		}
	
		String sql=" select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh," +
		 		"a.yx,to_char(a.zhdlsj,'YYYY-MM-dd') as zhdlsj,a.yhzt,a.cyzt,a.sgzbh,a.xb,to_char(a.sr,'YYYY-MM-dd') as sr," +
		 		"a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm,a.mz,a.bm," +
		 		"a.yhpxh,a.glfw,a.qq,a.bmmc,a.dzqm,a.yhjs,a.xzsj,a.dzqmlj from sys_yh a left join y_rs_rydaxx b on b.ryzh=a.yhbh"+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String chaxun){
		String str = "";
		if (chaxun != null && !"".equals(chaxun)) {
			str=str+" and a.xm like '%"+ chaxun+ "%' or a.dlm like '%"+ chaxun+ "%'";
		}
		String sql=" select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh," +
		 		"a.yx,to_char(a.zhdlsj,'YYYY-MM-dd') as zhdlsj,a.yhzt,a.cyzt,a.sgzbh,a.xb,to_char(a.sr,'YYYY-MM-dd') as sr," +
		 		"a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm,a.mz,a.bm," +
		 		"a.yhpxh,a.glfw,a.qq,a.bmmc,a.dzqm,a.yhjs,a.xzsj,a.dzqmlj from sys_yh a left join y_rs_rydaxx b on b.ryzh=a.yhbh"+str;
		return jdbcTemplate.queryForList(sql);
	}
/**
 * 
 * @author liangkaidi
 * @date 2015-12-1
 * @param id
 * @return
 */
	public List<Map<String, Object>> getSgzxx(String yhbh) {
		String str = "";
		if (yhbh != null && !"".equals(yhbh)) {
			str=str+" and a.yhbh like '%"+ yhbh+ "%' ";
		}
		String sql=" select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh," +
		 		"a.yx,to_char(a.zhdlsj,'YYYY-MM-dd') as zhdlsj,a.yhzt,a.cyzt,a.sgzbh,a.xb,to_char(a.sr,'YYYY-MM-dd') as sr," +
		 		"a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm,a.mz,a.bm," +
		 		"a.yhpxh,a.glfw,a.qq,a.bmmc,a.dzqm,a.yhjs,a.xzsj,a.dzqmlj,a.dafj from sys_yh a left join y_rs_rydaxx b on b.ryzh=a.yhbh"+str; 
		return jdbcTemplate.queryForList(sql);
	}
	
/**
 * 字典种类
 * @author liangkaidi
 * @date 2016-1-7
 * @param zdzl
 * @return
 */
public List<Map<String, Object>> getDicByList(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}
	
}
