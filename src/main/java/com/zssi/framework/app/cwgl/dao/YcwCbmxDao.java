package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwCbmx;

@Repository
public class YcwCbmxDao extends HibernateBaseDaoImpl<YcwCbmx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询成本明细
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getCbmxList(Integer start,
			Integer limit, String jybh, String ksbh, String lrrq) {
		String str = "";
		if(lrrq!=null&&!"".equals(lrrq)){
			str=str+" and a.cbbh = '"+lrrq+"'";
		}
		String sql = "select a.id,a.jybh,b.zdmc as fylx,a.xmmc,a.fyxq,to_char(a.fssj,'yyyy-MM') as fssj, a.pjbh, "
				+ "a.je from y_cw_cbmx a left join (select zdz,zdmc from sys_sjzd where zl='cblx' and jb=2) b on a.fylx=b.zdz where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 获取当前最大的成本编号
	 * @author wangyong
	 * @date 2016年4月7日
	 * @return
	 */
	public List<Map<String, Object>> getCbbh() {
		String sql = "select max(cbbh) cbbh from Y_CW_CBXX" ;
		return jdbcTemplate.queryForList(sql);
	}
	
}
