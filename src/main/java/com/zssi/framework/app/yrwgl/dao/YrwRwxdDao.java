package com.zssi.framework.app.yrwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypYpxx;
/**
 * 功能--任务下达
 * @author Administrator
 *
 */
@Repository
public class YrwRwxdDao extends HibernateBaseDaoImpl<YypYpxx, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 功能--任务下达详细信息
	 * @author mabiao
	 * @version 2015年10月12日下午3:27:37
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */

	public Pagination<Map<String, Object>> getYrwxdList(Integer start, 
			Integer limit, String code1, String code2, String code3) {
		String str = "";
		if(code1!=null && code1!="" &&!"".equals(code1)){
			str="  and a.ypbh='"+code1+"'";
		}
		if(code2!=null && code2!="" &&!"".equals(code2)){
			str="  and a.cyry='"+code2+"'";
		}
		if (code3 != null && !"".equals(code3)) {
			str="  and a.wtdw='"+code3+"'";
		}
		String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,"
				+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,"
				+ "a.ypsl,a.wtdw,a.wtdwdz,a.sjdw,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
				+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as jyks,a.ywks,a.jyhth,a.ewmtp,a.jyfy,"
				+ "a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,"
				+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,to_char(b.rwxarq,'YYYY-MM-dd') as rwxarq,"
				+ "to_char(b.yqwcrq,'YYYY-MM-dd') as yqwcrq from y_yp_ypxx a "
				+ "left join y_rw_rwzp b on a.bgbh = b.bgbh "
				+ "left join sys_zzjg c on a.jyks = c.id where 1=1 " +str;
		
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
