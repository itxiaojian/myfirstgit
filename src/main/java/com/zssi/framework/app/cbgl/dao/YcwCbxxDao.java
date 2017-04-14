package com.zssi.framework.app.cbgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.cbgl.model.YcwCbxx;
import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;

@Repository
public class YcwCbxxDao extends HibernateBaseDaoImpl<YcwCbxx, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 分页查询成本信息
	 * 
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getCbxxList(Integer start, Integer limit, String code,String ksbh,String jybh,String ypmc,
			String lrrq,String lrr,String xgrq,String xgr)  {
		String str = "";
//		if (code != null && !"".equals(code)) {
//			str = str + " and a.ksbh like '%" + code + "%' or a.jybh like '%" + code + "%'";
//		}
		if(ksbh!=null&&!"".equals(ksbh)){str=str+" and a.ksbh ='"+ ksbh+"'";}
		if(jybh!=null&&!"".equals(jybh)){str=str+" and a.jybh like '%"+ jybh+"%'";}
		if(ypmc!=null&&!"".equals(ypmc)){str=str+" and a.ypmc like '%"+ ypmc+"%'";}
		if(lrrq!=null&&!"".equals(lrrq)){str=str+" and to_char(a.lrrq,'yyyy-MM-dd') = '"+ lrrq+ "' ";}
		if(lrr!=null&&!"".equals(lrr)){str=str+" and a.lrr like '%"+ lrr+"%'";}
		if(xgrq!=null&&!"".equals(xgrq)){str=str+" and to_char(a.xgrq,'yyyy-MM-dd') = '"+ xgrq+ "' ";}
		if(xgr!=null&&!"".equals(xgr)){str=str+" and a.xgr like '%"+ xgr+"%'";}
		String sql = "select a.id,b.bmmc as ksbh,a.ksbh as ksbh1,a.jybh,a.ypmc,a.xxnr,a.cbhj," + "to_char(a.lrrq,'YYYY-MM-dd HH24:mm:ss') as lrrq,to_char(a.fssj,'yyyy-MM')as fssj,a.lrr,a.xgr,to_char(a.xgrq,'YYYY-MM-dd') as xgrq,"
				+ "a.xgyy,a.bz,a.cbbh from y_cw_cbxx a left join sys_zzjg b on a.ksbh = b.id where 1=1 "+str+" order by a.id desc";
		return jdbcPager.queryPage(sql, start, limit);
	}

	/**
	 * 查询数据
	 * 
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getList(String code) {
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + " and a.ksbh like '%" + code + "%' or a.jybh like '%" + code + "%'";
		}
		String sql =  "select a.id,b.bmmc as ksbh,a.jybh,a.ypmc,a.xxnr,a.cbhj,a.cbhj," + "to_char(a.lrrq,'YYYY-MM-dd HH24:mm:ss') as lrrq,a.lrr,a.xgr,to_char(a.xgrq,'YYYY-MM-dd') as xgrq,"
				+ "a.xgyy,a.bz from y_cw_cbxx" + 
				" a left join sys_zzjg b on a.ksbh = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 通过id查询选中行的所有信息
	 * @author wangyong
	 * @date 2015年11月24日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getCbxx(Integer id) {
		String str = "";
		if (id != null && !"".equals(id)) {
			str = str + " and a.id="+id;
		}
		String sql =  "select a.id,b.bmmc as ksmc,a.ksbh,a.jybh,a.ypmc,a.xxnr,a.cbhj,a.cbbh,to_char(a.lrrq,'YYYY-MM-dd') as lrrq,"
				+ "a.lrr,a.xgr,to_char(a.xgrq,'YYYY-MM-dd') as xgrq,to_char(a.fssj,'YYYY-MM-dd') as fssj,a.xgyy,a.bz from y_cw_cbxx a "
				+ "left join sys_zzjg b on a.ksbh = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 通过成本编号获取所有成本明细
	 * @author wangyong
	 * @date 2016年4月7日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getCbmx(String cbbh) {
		String str = "";
		if (cbbh != null && !"".equals(cbbh)) {
			str = str + " and a.cbbh='"+cbbh+"'";
		}
		String sql =  "select a.id,to_char(a.fssj,'YYYY-MM') as fssj,"
				+ "a.fylx,a.pjbh,a.xmmc,a.fyxq,a.je from y_cw_cbmx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 修改成本信息的检验编号的同时，修改成本明细的检验编号
	 * @author wangyong
	 * @date 2015年12月8日
	 * @param id
	 */
	public void updateCbmxJybh(String jybh1,String jybh2) {
		String sql = "update y_cw_cbmx a set a.jybh = '" + jybh2 + "' where a.jybh = '" + jybh1 + "'";
		jdbcTemplate.execute(sql);;
	}
	
	/**
	 * 保存新的成本明细之前通过成本编号删除旧的成本明细
	 * @author wangyong
	 * @date 2016年2月16日
	 * @param cbbh 成本编号
	 */
	public void deleteCbmxByCbbh(String cbbh) {
		String sql = "";
		if (cbbh!=null && !"".equals(cbbh)) {
			sql = "delete from Y_CW_CBMX a where a.cbbh = '"+cbbh+"'";
			jdbcTemplate.execute(sql);;
		}
	}
	
	/**
	 * 
	 * @author wangyong
	 * @date 2016年4月8日
	 * @param ksbh
	 * @param lrrq
	 */
	public void deleteCbmxByJybh(String ksbh,String lrrq) {
		String sql = "";
		if (ksbh!=null && !"".equals(ksbh)) {
			sql = "delete from Y_CW_CBMX a where a.ksbh = '"+ksbh+"' and to_char(a,lrrq,'yyyy-MM-dd HH24:mm:ss') = '"+lrrq+"'";
			jdbcTemplate.execute(sql);;
		}
	}
	
	/**
	 * 查询费用类型
	 * @author liusong
	 * @version 2015年9月21日下午2:10:45
	 * @param id
	 */
	public List<Map<String, Object>> getfylx(String fylx) {
		String sql = "  select a.zdz from sys_sjzd a  where a.zl='cblx' and a.zdmc='"+fylx+"'";
		
		return jdbcTemplate.queryForList(sql);
	}

}
