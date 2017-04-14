package com.zssi.framework.app.kygl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.kygl.model.YkyXxgl;

/** 
 * 科研信息管理dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
@Repository
public class YkyXxglDao extends HibernateBaseDaoImpl<YkyXxgl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/** 
	 * 科研信息管理分页查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public Pagination<Map<String, Object>> getKyXxglList(Integer start,
			Integer limit, String code) {
		
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.kybh like '%"+ code+ "%' or a.kymc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.kybh,a.kymc,a.kyxmnr,a.cyry,to_char(a.kssj,'YYYY-MM-dd ') as kssj,"
				+ "to_char(a.jssj,'YYYY-MM-dd ') as jssj,a.bz,b.bmmc as ks_id from y_ky_xxgl a "
				+ "left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/** 
	 * 科研信息管理list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getList(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id like '%"+ id+ "%' ";
		}
		String sql = "  select a.id,a.kybh,a.ks_id,a.kymc,a.kyxmnr,a.cyry,to_char(a.kssj,'YYYY-MM-dd') as kssj,"
				+ "to_char(a.jssj,'YYYY-MM-dd') as jssj,a.bz,b.bmmc as ksmc from y_ky_xxgl a "
				+ "left join sys_zzjg b on a.ks_id = b.id where 1=1 " + str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @version 2015年9月21日下午2:10:45
	 * @param id
	 */
	public void deleteKyXxgl(Integer id){
		String sql = "delete from y_ky_xxgl where id="+id;
				jdbcTemplate.execute(sql);
	}

}
