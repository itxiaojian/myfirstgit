package com.zssi.framework.app.sbgl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbSyjl;

/** 
 * 设备使用记录dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年9月29日 上午9:31:24 
 * 类说明 
 */

@Repository
public class YsbSyjlDao extends HibernateBaseDaoImpl<YsbSyjl, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 后台：设备使用记录
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getSbsyjlList(Integer start,Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.sbbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.sbbh,a.sbtxm,a.sbmc,to_char(a.sysj,'YYYY-MM-dd') as sysj,a.syzt,a.bgbh,a.bz,a.fj"
				+ " from y_sb_syjl a  where 1=1 "+str;

		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/** 
	 * 传参id的设备使用记录修改list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月25日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getXg(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id="+id;
		}
		String sql = "  select a.id,a.sbbh,a.sbtxm,a.sbmc,to_char(a.sysj,'YYYY-MM-dd') as sysj,a.syzt,a.bgbh,a.bz,a.fj"
				+ " from y_sb_syjl a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 设备使用记录list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public void deleteSbsyjl(Integer ID){
		String sql = "delete from y_sb_syjl where id="+ID;
				jdbcTemplate.execute(sql);
	}

}
