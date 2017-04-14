package com.zssi.framework.app.kygl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.kygl.model.YkyCggl;

/** 
 * 科研信息管理dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
@Repository
public class YkyCgglDao extends HibernateBaseDaoImpl<YkyCggl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 科研信息分页查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public Pagination<Map<String, Object>> getKyCgglList(Integer start,
			Integer limit, String code) {
		
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.kybh like '%"+ code+ "%' or a.kymc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.kybh,a.kymc,a.kyxmnr,a.cyry,to_char(a.kssj,'YYYY-MM-dd ') as kssj,"
				+ "to_char(a.jssj,'YYYY-MM-dd ') as jssj,a.cglx,a.cgnr,a.bz,b.bmmc as ssks"
				+ " from y_ky_cggl a left join sys_zzjg b on a.ssks = b.id  where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 科研信息list查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public List<Map<String,Object>> getList(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id like '%"+ id+ "%' ";
		}
		String sql = "  select a.id,a.kybh,a.ssks,a.kymc,a.kyxmnr,a.cyry,to_char(a.kssj,'YYYY-MM-dd') as kssj,"
				+ "to_char(a.jssj,'YYYY-MM-dd') as jssj,a.cglx,a.cgnr,a.bz,b.bmmc as ksmc"
				+ " from y_ky_cggl a left join sys_zzjg b on a.ssks = b.id  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
/**
 * 数据字典
 * @author liangkaidi
 * @date 2016-1-20
 * @param zdzl
 * @return
 */
	public List<Map<String, Object>> getDicByList(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
}
