package com.zssi.framework.app.jybzgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jybzgl.model.YjyXmxx;

@Repository
public class YjyXmxxDao extends HibernateBaseDaoImpl<YjyXmxx, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 功能--标准信息详细查询
	 * @param start
	 * @param limit
	 * @param code
	 * @param sjid
	 * @return
	 */
	public Pagination<Map<String,Object>> getYJyXmxxList(Integer start,Integer limit,String code,String sjid){
		String str = "";
		String sql = "";
		if(code!=null&&!"".equals(code)){
			str=str+ " and a.xmbh like '%"+ code+ "%' or a.xmmc like '%"+ code+ "%'";
		}
		if(sjid!=null&&!"".equals(sjid)){
			str=str+ " and a.bzbh = '"+ sjid+ "'";
		
		sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.xmbh as \"xmbh\",a.xmmc as \"xmmc\","
				+ "a.jldw as \"jldw\",a.xmlx as \"xmlx\",a.xmyq as \"xmyq\",a.bzmax as \"bzmax\","
				+ "a.bzmin as \"bzmin\",a.pdyy as \"pdyy\",a.jyyj as \"jyyj\",a.dj as \"dj\","
				+ "a.pdfs as \"pdfs\",a.mjyy as \"mjyy\",a.zdcx as \"zdcx\",a.xmpx as \"xmpx\","
				+ "a.zxm_id as \"zxm_id\",to_char(a.kssj,'yyyy-mm-dd') as \"kssj\",to_char(a.jssj,"
				+ "'yyyy-mm-dd')  as \"jssj\",a.bz as \"bz\"  from Y_JY_XMXX a  where 1=1 "
				+str;
		}else{
			sql =" select a.id as \"id\",a.bzbh as \"bzbh\",a.xmbh as \"xmbh\",a.xmmc as \"xmmc\","
					+ "a.jldw as \"jldw\",a.xmlx as \"xmlx\",a.xmyq as \"xmyq\",a.bzmax as \"bzmax\","
					+ "a.bzmin as \"bzmin\",a.pdyy as \"pdyy\",a.jyyj as \"jyyj\",a.dj as \"dj\","
					+ "a.pdfs as \"pdfs\",a.mjyy as \"mjyy\",a.zdcx as \"zdcx\",a.xmpx as \"xmpx\","
					+ "a.zxm_id as \"zxm_id\",to_char(a.kssj,'yyyy-mm-dd') as \"kssj\",to_char(a.jssj,"
					+ "'yyyy-mm-dd')  as \"jssj\",a.bz as \"bz\"  from Y_JY_XMXX a  where 1=2 ";
		}
		return jdbcPager.queryPage(sql, start, limit);
	}

	/**
	 * 功能--项目类型
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByxlx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	/**
	 * 功能--评定用语
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicBypd(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 查询数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code,String sjid){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.bzbh like '%"+ code + "%' or a.xmmc like '%"+ code + "%'";
		}
		if(sjid!=null&&!"".equals(sjid)){
			str=str+ " and a.bzbh = '"+ sjid+ "'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.xmbh as \"xmbh\",a.xmmc as \"xmmc\","
				+ "a.jldw as \"jldw\",a.xmlx as \"xmlx\",a.xmyq as \"xmyq\",a.bzmax as \"bzmax\","
				+ "a.bzmin as \"bzmin\",a.pdyy as \"pdyy\",a.jyyj as \"jyyj\",a.dj as \"dj\","
				+ "a.pdfs as \"pdfs\",a.mjyy as \"mjyy\",a.zdcx as \"zdcx\",a.xmpx as \"xmpx\","
				+ "a.zxm_id as \"zxm_id\",to_char(a.kssj,'yyyy-mm-dd') as \"kssj\",to_char(a.jssj,"
				+ "'yyyy-mm-dd')  as \"jssj\",a.bz as \"bz\"  from Y_JY_XMXX a  where 1=1 "
				+str;
		return jdbcTemplate.queryForList(sql);
	}
	

/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 检验页面中————检验标准信息
	 * @author duanpeijun
	 * @date 2015年11月5日
	 * @return
	 */
	public List<Map<String, Object>> getJyxm(String bzbh,String code){
		String str = "";
		if(bzbh!=null&&!"".equals(bzbh)){
			str=" and a.bzbh='"+bzbh+"'";
		}
		if (code != null && !"".equals(code)) {
			str=str+" and a.xmmc like '%"+ code+ "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.xmbh as \"xmbh\",a.xmmc as \"xmmc\","
				+ "a.jldw as \"jldw\",a.xmlx as \"xmlx\",a.xmyq as \"xmyq\",a.bzmax as \"bzmax\","
				+ "a.bzmin as \"bzmin\",a.pdyy as \"pdyy\",a.jyyj as \"jyyj\",a.dj as \"dj\","
				+ "a.pdfs as \"pdfs\",a.mjyy as \"mjyy\",a.zdcx as \"zdcx\",a.xmpx as \"xmpx\","
				+ "a.zxm_id as \"zxm_id\",to_char(a.kssj,'yyyy-mm-dd') as \"kssj\",to_char(a.jssj,"
				+ "'yyyy-mm-dd')  as \"jssj\",a.bz as \"bz\"  from Y_JY_XMXX a  where 1=1 "
				+str;
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 检验页面中————检验标准信息
	 * @author duanpeijun
	 * @date 2015年11月5日
	 * @return
	 */
	public List<Map<String, Object>> getJyxm(String code){
		String str = "";
//		if(bzbh!=null&&!"".equals(bzbh)){
//			str=" and a.bzbh='"+bzbh+"'";
//		}
		if (code != null && !"".equals(code)) {
			str=str+" and a.xmmc like '%"+ code+ "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.xmbh as \"xmbh\",a.xmmc as \"xmmc\","
				+ "a.jldw as \"jldw\",a.xmlx as \"xmlx\",a.xmyq as \"xmyq\",a.bzmax as \"bzmax\","
				+ "a.bzmin as \"bzmin\",a.pdyy as \"pdyy\",a.jyyj as \"jyyj\",a.dj as \"dj\","
				+ "a.pdfs as \"pdfs\",a.mjyy as \"mjyy\",a.zdcx as \"zdcx\",a.xmpx as \"xmpx\","
				+ "a.zxm_id as \"zxm_id\",to_char(a.kssj,'yyyy-mm-dd') as \"kssj\",to_char(a.jssj,"
				+ "'yyyy-mm-dd')  as \"jssj\",a.bz as \"bz\"  from Y_JY_XMXX a  where 1=1 "
				+str;
		return jdbcTemplate.queryForList(sql);
	}
}

