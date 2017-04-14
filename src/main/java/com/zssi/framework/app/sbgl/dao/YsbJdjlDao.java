package com.zssi.framework.app.sbgl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbJdjl;

/** 
 * 设备检定记录dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月1日 下午8:28:01 
 * 类说明 
 */
@Repository
public class YsbJdjlDao extends HibernateBaseDaoImpl<YsbJdjl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：设备检定记录
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getSbjdjlList(Integer start,Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.sbbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.sbbh,a.sbtxm,a.sbmc,to_char(a.sysj,'YYYY-MM-dd') as sysj,a.jddw,a.jdjg,a.jdjl,a.jdfy, "
				+ " a.jdr,a.jybh,a.bgbh,a.bz,a.jdfj,a.jdzt,b.id as sbid from y_sb_jdjl a left join y_sb_xx b on a.sbbh = b.sbbh  "
				+ "where 1=1 "+str;

		return jdbcPager.queryPage(sql, start, limit);
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
	
	/** 
	 * 检定记录list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getJd(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id="+id;
		}
		String sql = "  select a.id,a.sbbh,a.sbtxm,a.sbmc,to_char(a.sysj,'YYYY-MM-dd') as sysj,a.jddw,a.jdjg,a.jdjl,a.jdfy, "
				+ " a.jdr,a.jybh,a.bgbh,a.bz,a.jdfj,a.jdzt from y_sb_jdjl a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

}
