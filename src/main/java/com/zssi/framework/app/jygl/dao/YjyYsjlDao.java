package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyYsjl;

//原始记录管理dao
//liusong 2016-03-09
@Repository
public class YjyYsjlDao extends HibernateBaseDaoImpl<YjyYsjl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	public Pagination<Map<String, Object>> getYsjlList(Integer start,Integer limit,String code){
		String str="";
		if(code != null && !"".equals(code)){
		   str= str + " and b.bgbh = '"+code+"'";
		}
		String sql = " select b.id as bid,b.bgbh,a.ypjyzt,d.xm as bzr,b.bzfs,b.bsdx,b.jyrq, "
				+ "c.id,nvl(c.ywysjl,1)as ywysjl,c.ysjlsjm,c.ysjlwjm,c.ysjllj,c.scry,"
				+ "to_char(c.scsj,'yyyy-MM-dd')as scsj,c.bz from y_yp_ypxx a left join y_jy_bgxx b "
				+ "on a.ypbh = b.bgbh left join y_jy_ysjlgl c on a.ypbh = c.bgbh left join sys_yh d "
				+ "on b.bzr = d.yhbh where a.ypjyzt in(4,5,6,7) "+str+" order by id desc ";
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	public List<Map<String,Object>> getYsjl(String bid){
		String sql = "  select a.bgbh,b.id,b.ywysjl,b.ysjlsjm,b.ysjlwjm,b.ysjllj,b.scry,to_char(b.scsj,'yyyy-MM-dd')as scsj,b.bz, "
					+ "c.xm as bzr,a.bzfs,a.bsdx,to_char(a.jyrq,'yyyy-MM-dd')as jyrq,d.ypjyzt "
					+ "from y_jy_bgxx a left join y_jy_ysjlgl b on a.bgbh = b.bgbh left join sys_yh c on a.bzr = c.yhbh left join y_yp_ypxx d "
					+ "on a.bgbh = d.ypbh where a.id ="+bid;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String,Object>> getYsjlbyBgbh(String bgbh){
		String sql = "  select a.bz,nvl(a.ywysjl,1) as ywysjl,a.ysjlwjm,a.ysjllj,a.id,a.ysjllj from y_jy_ysjlgl a where a.bgbh ='"+bgbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String,Object>> getYpjyzt(String zdzl){
		String sql = "  select a.zdz,a.zdmc from sys_sjzd a where a.zl ='"+zdzl+"' and a.jb="+2;
		return jdbcTemplate.queryForList(sql);
	}

	/** 
	 * 下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String, Object>> getImageList(String id) {
		String sql = "select a.ysjlwjm,a.ysjlsjm,a.ysjllj from y_jy_ysjlgl a where 1=1 and a.id = '"+id+"'";
		return jdbcTemplate.queryForList(sql);
	}
}
