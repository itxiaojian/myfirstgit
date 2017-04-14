package com.zssi.framework.app.yrwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.yrwgl.model.YrwWdrw;
/**
 * 主页--我的任务
 * @author Administrator
 *
 */
@Repository
public class YrwWdrwDao extends HibernateBaseDaoImpl<YrwWdrw,Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 功能--我的任务详细信息
	 * @author mabiao
	 * @version 2015年10月12日下午3:27:37
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */

	public Pagination<Map<String, Object>> getYrwWdrwList(Integer start, 
			Integer limit, String code1, String code2, String code3, String code4) {
		String str = "";
		if (code3 != null && !"".equals(code3)) {
			str += " and  to_char(a.sjksrq,'yyyy-mm-dd') >='" + code3 + "'";
		}
		if (code4 != null && !"".equals(code4)) {
			str += "and to_char(a.sjjsrq,'yyyy-mm-dd') <= '" + code4 + "'";
		}
		if(code1!=null && code1!="" &&!"".equals(code1)){
			str="  and a.rwmc='"+code1+"'";
		}
		if(code2!=null && code2!="" &&!"".equals(code2)){
			str="  and a.rwlx='"+code2+"'";
		}
		String sql = " select a.id,a.bgbh,a.rwmc,a.ssxm,a.rwlx,to_char(a.yqksrq,'yyyy-mm-dd') as yqksrq,"
				+ "to_char(a.yqjsrq,'yyyy-mm-dd') as yqjsrq,to_char(a.sjksrq,'yyyy-mm-dd') as sjksrq,"
				+ "to_char(a.sjjsrq,'yyyy-mm-dd') as sjjsrq,a.wcjd as wcjd,a.rwfzr,a.rwly,b.cbzt "
				+ "from y_rw_wdrw a left join y_cb_lbxx b on a.bgbh = b.bgbh where 1 = 1 "+ str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	public List<Map<String, Object>> getYrwWdrwList1(String code) {
		String str = "";
		if(code!=null && code!="" &&!"".equals(code)){
			str="  and a.rwmc='"+code+"'";
		}
		String sql =" select a.id,a.bgbh,a.rwmc,a.ssxm,a.rwlx,to_char(a.yqksrq,'yyyy-mm-dd') as yqksrq,"
				+ "to_char(a.yqjsrq,'yyyy-mm-dd') as yqjsrq,to_char(a.sjksrq,'yyyy-mm-dd') as sjksrq,"
				+ "to_char(a.sjjsrq,'yyyy-mm-dd') as sjjsrq,a.wcjd as wcjd,a.rwfzr,a.rwly "
//				+ "from aaaa a where 1=1 "+ str;
				+ "from y_rw_wdrw a where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getWdrw(String search) {
		String str = "";
		if(search!=null && search!="" &&!"".equals(search)){
			str="  and a.rwmc like '%"+ search+ "%'";
		}
		String sql = " select a.id,a.bgbh,a.rwmc,a.ssxm,a.rwlx,to_char(a.yqksrq,'yyyy-mm-dd') as yqksrq,"
				+ "to_char(a.yqjsrq,'yyyy-mm-dd') as yqjsrq,to_char(a.sjksrq,'yyyy-mm-dd') as sjksrq,"
				+ "to_char(a.sjjsrq,'yyyy-mm-dd') as sjjsrq,a.wcjd as wcjd,a.rwfzr,a.rwly "
				+ "from y_rw_wdrw a where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String,Object>> getYrwWdrwList2(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.id like '%"+ code+ "%'";
		}
		String sql = " select a.id,a.bgbh,a.rwmc,a.ssxm,a.rwlx,to_char(a.yqksrq,'yyyy-mm-dd') as yqksrq,"
				+ "to_char(a.yqjsrq,'yyyy-mm-dd') as yqjsrq,to_char(a.sjksrq,'yyyy-mm-dd') as sjksrq,"
				+ "to_char(a.sjjsrq,'yyyy-mm-dd') as sjjsrq,a.wcjd as wcjd,a.rwfzr,a.rwly "
				+ "from y_rw_wdrw a where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 数据字典--任务类型
	 * @param rwlx
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String rwlx) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+rwlx+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
}
