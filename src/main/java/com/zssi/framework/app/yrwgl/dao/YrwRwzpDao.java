package com.zssi.framework.app.yrwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.yrwgl.model.YrwRwzp;
/**
 * 功能--我的任务
 * @author Administrator
 *
 */
@Repository
public class YrwRwzpDao extends HibernateBaseDaoImpl<YrwRwzp,Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 功能--任务指派详细信息链表查询
	 * @author mabiao
	 * @version 2015年10月12日下午3:27:37
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */

	public Pagination<Map<String, Object>> getYrwRwzpList(Integer start, 
			Integer limit, String code1, String code2, String code3) {
		String str = "";
		if(code1!=null && code1!="" &&!"".equals(code1)){
			str="  and a.bgbh='"+code1+"'";
		}
		if(code2!=null && code2!="" &&!"".equals(code2)){
			str="  and a.zxr='"+code2+"'";
		}
		if (code3 != null && !"".equals(code3)) {
			str += " and a.zxr='" + code3 + "'";
		}
		String sql = " select a.id, a.bgbh, to_char(a.rwxarq,'yyyy-mm-dd') as rwxarq, "
				+ "to_char(a.yqwcrq,'yyyy-mm-dd') as yqwcrq,a.jyzp ,to_char(a.zprq,'yyyy-mm-dd') as zprq,"
				+ "a.zpr,a.zxr,a.bz,b.ypmc,b.wtdw,b.yplx,b.jylx,b.jyks,b.djry,b.lxr,b.dh,c.cbzt from y_rw_rwzp a "
				+ "left join y_yp_ypxx b on a.bgbh = b.bgbh "
				+ "left join y_cb_lbxx c on a.bgbh = c.bgbh "+ str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 功能--用户列表
	 * @param start
	 * @param limit
	 * @param code1
	 * @param code2
	 * @return
	 */
	public Pagination<Map<String, Object>> getRwZprList(Integer start, 
			Integer limit, String code1, String code2) {
		String str = "";
		if(code1!=null && code1!="" &&!"".equals(code1)){
			str="  and a.yhpxh='"+code1+"'";
		}
		if(code2!=null && code2!="" &&!"".equals(code2)){
			str="  and a.xm='"+code2+"'";
		}
		String sql = " select a.yhbh,a.dlm,a.xm,a.bmbh,a.gwbh,a.sjh,a.yx,a.yhpxh, "
				+ "to_char(a.zhdlsj,'yyyy-mm-dd') as zhdlsj from sys_yh a where 1=1 "+ str;
		return jdbcPager.queryPage(sql, start, limit);
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
