package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyJyxx;

/**
 * 检验信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Repository
public class YjyJyxxDao extends HibernateBaseDaoImpl<YjyJyxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：检验信息
	 * @author duanpeijun
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @param canshu  条件查询参数
	 * @return
	 */
	public Pagination<Map<String, Object>> getJyxxList(Integer start, Integer limit,String canshu){
			
			String str = "";
			if(canshu!=null&&!"".equals(canshu)){
				str=str+" and a.bgbh like '%"+ canshu+ "%' or a.ypbh like '%"+ canshu+ "%'";
			}
			String sql = "select a.id,a.bgbh,a.ypbh,a.jylb,a.yplb,a.bmbh,to_char(a.djrq,'YYYY-MM-dd') as djrq,a.jyyj,to_char(a.jyqx,'YYYY-MM-dd') as jyqx,a.bzbh,"
					+ "a.bzmc,a.zjr,to_char(a.ksrq,'YYYY-MM-dd') as ksrq,to_char(a.jsrq,'YYYY-MM-dd') as jsrq,a.hjtj,a.xmms,a.jyff,a.pdyq,a.qtsm,a.jyfy,a.jjfy,"
					+ "a.qtfy,a.fyhj,a.swpd,a.bzpd,a.jyjl,a.rzfs,a.jyzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.tbzt,a.bz from y_jy_jyxx a "
					+ "where 1=1 " + str;
			return jdbcPager.queryPage(sql, start, limit);
		}
	
	/**
	 * 催办状态（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByCbzt(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 从设备信息增加数据到检验设备信息表时，判断检验设备信息表中有无当前数据
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	public List<Map<String, Object>> getjysbxxList(String sbbh){
		String sql = "select id,sbbh from y_jy_sbxx where sbbh='"+sbbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 从设备信息增加数据到设备使用记录表时，判断设备使用记录表中有无当前数据
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	public List<Map<String, Object>> getsbsyjlList(String sbbh){
		String sql = "select id,sbbh from y_sb_syjl where sbbh = '"+sbbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击检验跳转的Jsp页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getJy(String id){
		String str = "";
		if(id!=null&&!"".equals(id)){
			str=" and a.id='"+id+"'";
		}
		String sql = "select a.id,a.bgbh,a.ypbh,b.ypmc,a.jylb,a.yplb,a.bmbh,to_char(a.djrq,'YYYY-MM-dd') as djrq,a.jyyj,to_char(a.jyqx,'YYYY-MM-dd') as jyqx,a.bzbh,"
				+ "a.bzmc,a.zjr,to_char(a.ksrq,'YYYY-MM-dd') as ksrq,to_char(a.jsrq,'YYYY-MM-dd') as jsrq,a.hjtj,a.xmms,a.jyff,a.pdyq,a.qtsm,a.jyfy,a.jjfy,"
				+ "a.qtfy,a.fyhj,a.swpd,a.bzpd,a.jyjl,a.rzfs,a.jyzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.tbzt,a.bz from y_jy_jyxx a "
				+ "left join y_yp_ypxx b on a.bgbh = b.bgbh "
				+ "where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据样品信息的报告编号查询检验信息有无该条数据。（样品信息的报告编号和检验信息的报告编号是相同的）
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	public List<Map<String, Object>> getjyxxList(String bgbh){
		String sql = "select id,bgbh from y_jy_jyxx where bgbh='"+bgbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
}
