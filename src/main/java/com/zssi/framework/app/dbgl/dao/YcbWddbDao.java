package com.zssi.framework.app.dbgl.dao; 

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.model.YcbWddb;

/** 
 * 督办管理我的督办dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月20日 上午10:40:49 
 * 类说明 
 */
@Repository
public class YcbWddbDao extends HibernateBaseDaoImpl<YcbWddb, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	
	/**
	 * 链表查询显示前台 
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:46:26 
	 * 类说明 
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getWddbList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.bgbh like '%"+ code+ "%' or a.rwmc like '%"+ code+ "%'";
		}
		String sql = " select a.id,a.bgbh,a.rwmc,a.ssxm,a.rwlx,to_char(a.yqksrq, 'YYYY-MM-dd') as yqksrq,to_char(a.yqjsrq, 'YYYY-MM-dd') as yqjsrq,to_char(a.sjksrq, 'YYYY-MM-dd') as sjksrq,to_char(a.sjjsrq, 'YYYY-MM-dd') as sjjsrq,"
          +"a.wcjd,a.rwfzr,b.cbr,b.cbnr,b.fkzt,b.id as dbid from y_rw_wdrw a left join y_cb_lbxx b on a.bgbh = b.bgbh where b.fkzt in(1,0) "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	
	/**
	 * 供业务督办进行前台链表查询sql 
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:46:50 
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYwdbList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.bgbh like '%"+ code+ "%' or a.rwmc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.bgbh,a.rwmc,a.ssxm,a.rwlx,to_char(a.yqksrq,'YYYY-MM-dd') as yqksrq,to_char(a.yqjsrq,'YYYY-MM-dd') as yqjsrq,"
				+ "to_char(a.sjksrq,'YYYY-MM-dd') as sjksrq,to_char(a.sjjsrq,'YYYY-MM-dd') as sjjsrq,a.wcjd,a.rwfzr,a.rwly,b.cbzt from y_rw_wdrw a left join y_cb_lbxx b on a.bgbh = b.bgbh where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}

}
