package com.zssi.framework.app.kygl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.kygl.model.YkyJfgl;

/** 
 * 经费管理dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 下午1:14:10 
 * 类说明 
 */
@Repository
public class YkyJfglDao extends HibernateBaseDaoImpl<YkyJfgl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/** 
	 * 经费管理分页查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public Pagination<Map<String, Object>> getKyJfglList(Integer start,
			Integer limit, String code) {
		
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.kybh like '%"+ code+ "%' or a.kymc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.kybh,a.kymc,a.kyxmnr,a.cyry,to_char(a.lxsj,'YYYY-MM-dd ') as lxsj,"
				+ "to_char(a.htsj,'YYYY-MM-dd') as htsj,a.jfje,to_char(a.bksj,'YYYY-MM-dd') as bksj,a.bz,b.bmmc as ks_id"
				+ " from y_ky_jfgl a left join sys_zzjg b on a.ks_id = b.id  where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/** 
	 * 经费管理信息list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getList(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id like '%"+ id+ "%' ";
		}
		String sql = "  select a.id,a.kybh,a.kymc,a.ks_id,a.kyxmnr,a.cyry,to_char(a.lxsj,'YYYY-MM-dd HH:mi:ss') as lxsj,"
				+ "to_char(a.htsj,'YYYY-MM-dd') as htsj,a.jfje,to_char(a.bksj,'YYYY-MM-dd') as bksj,a.bz,b.bmmc as ksmc"
				+ " from y_ky_jfgl a left join sys_zzjg b on a.ks_id = b.id  where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}
	
}
