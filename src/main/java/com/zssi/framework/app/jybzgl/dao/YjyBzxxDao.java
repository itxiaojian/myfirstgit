package com.zssi.framework.app.jybzgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jybzgl.model.YjyBzxx;

@Repository
public class YjyBzxxDao extends HibernateBaseDaoImpl<YjyBzxx, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 分页查询
	 * 
	 * @author mabiao
	 * @version 2015-9-22上午1:47:08
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYJyBzxxList(Integer start,
			Integer limit, String code) {
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str+ " and a.bzbh like '%"+ code+ "%' or a.bzmc like '%"+ code+ "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.bzmc as \"bzmc\","
				+ "a.bzmc_fz as \"bzmc_fz\",a.pyjm as \"pyjm\",a.bzlb as \"bzlb\",a.bzjb as \"bzjb\","
				+ "to_char(a.qyrq,'yyyy-mm-dd') as \"qyrq\",a.ks_ID as \"ks_id\",a.xmbh_ID as \"xmbh_id\","
				+ "to_char(a.zhxgrq,'yyyy-mm-dd') as \"zhxgrq\",a.xgr as \"xgr\",a.fzzt as \"fzzt\","
				+ "to_char(a.fzrq,'yyyy-mm-dd') as \"fzrq\",a.fzdjr as \"fzdjr\",a.shzt as \"shzt\","
				+ "to_char(a.shrq,'yyyy-mm-dd') as \"shrq\",a.shr as \"shr\",to_char(a.kssj,'yyyy-mm-dd') "
				+ "as \"kssj\",to_char(a.jssj,'yyyy-mm-dd') as \"jssj\",a.bz as \"bz\" from Y_JY_BZXX a "
				+ "where 1=1 "+ str;

		return jdbcPager.queryPage(sql, start, limit);
	}

	/**
	 * 功能--标准级别
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	/**
	 * 功能--标准类型
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByjb(String zdzl) {
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
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.bzbh like '%"+ code + "%' or a.bzmc like '%"+ code + "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.bzmc as \"bzmc\","
				+ "a.bzmc_fz as \"bzmc_fz\",a.pyjm as \"pyjm\",a.bzlb as \"bzlb\",a.bzjb as \"bzjb\","
				+ "to_char(a.qyrq,'yyyy-mm-dd') as \"qyrq\",a.ks_ID as \"ks_id\",a.xmbh_ID as \"xmbh_id\","
				+ "to_char(a.zhxgrq,'yyyy-mm-dd') as \"zhxgrq\",a.xgr as \"xgr\",a.fzzt as \"fzzt\",b.zdmc as \"bzdmc\","
				+ "to_char(a.fzrq,'yyyy-mm-dd') as \"fzrq\",a.fzdjr as \"fzdjr\",a.shzt as \"shzt\",c.zdmc as \"czdmc\","
				+ "to_char(a.shrq,'yyyy-mm-dd') as \"shrq\",a.shr as \"shr\",to_char(a.kssj,'yyyy-mm-dd') "
				+ "as \"kssj\",to_char(a.jssj,'yyyy-mm-dd') as \"jssj\",a.bz as \"bz\" from Y_JY_BZXX a "
				+ "left join( select zdz,zdmc,zdbm from sys_sjzd  where zl='fzzt' and jb = 2) b on a.fzzt = b.zdz "
				+ "left join (select zdz,zdmc,zdbm from sys_sjzd  where zl='shzt' and jb = 2) c on a.shzt = c.zdz "
				+ "where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	public List<Map<String,Object>> getList1(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.id like '%"+ code + "%' or a.id like '%"+ code + "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.bzmc as \"bzmc\","
				+ "a.bzmc_fz as \"bzmc_fz\",a.pyjm as \"pyjm\",a.bzlb as \"bzlb\",a.bzjb as \"bzjb\","
				+ "to_char(a.qyrq,'yyyy-mm-dd') as \"qyrq\",a.ks_ID as \"ks_id\",a.xmbh_ID as \"xmbh_id\","
				+ "to_char(a.zhxgrq,'yyyy-mm-dd') as \"zhxgrq\",a.xgr as \"xgr\",a.fzzt as \"fzzt\",b.zdmc as \"bzdmc\","
				+ "to_char(a.fzrq,'yyyy-mm-dd') as \"fzrq\",a.fzdjr as \"fzdjr\",a.shzt as \"shzt\",c.zdmc as \"czdmc\","
				+ "to_char(a.shrq,'yyyy-mm-dd') as \"shrq\",a.shr as \"shr\",to_char(a.kssj,'yyyy-mm-dd') "
				+ "as \"kssj\",to_char(a.jssj,'yyyy-mm-dd') as \"jssj\",a.bz as \"bz\" from Y_JY_BZXX a "
				+ "left join( select zdz,zdmc,zdbm from sys_sjzd  where zl='fzzt' and jb = 2) b on a.fzzt = b.zdz "
				+ "left join (select zdz,zdmc,zdbm from sys_sjzd  where zl='shzt' and jb = 2) c on a.shzt = c.zdz "
				+ "where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}

/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 检验页面中————检验标准信息
	 * @author duanpeijun
	 * @date 2015年11月5日
	 * @return
	 */
	public List<Map<String, Object>> getJybzxx(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.bzmc like '%"+ code+ "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.bzmc as \"bzmc\","
				+ "a.bzmc_fz as \"bzmc_fz\",a.pyjm as \"pyjm\",a.bzlb as \"bzlb\",a.bzjb as \"bzjb\","
				+ "to_char(a.qyrq,'yyyy-mm-dd') as \"qyrq\",a.ks_ID as \"ks_id\",a.xmbh_ID as \"xmbh_id\","
				+ "to_char(a.zhxgrq,'yyyy-mm-dd') as \"zhxgrq\",a.xgr as \"xgr\",a.fzzt as \"fzzt\","
				+ "to_char(a.fzrq,'yyyy-mm-dd') as \"fzrq\",a.fzdjr as \"fzdjr\",a.shzt as \"shzt\","
				+ "to_char(a.shrq,'yyyy-mm-dd') as \"shrq\",a.shr as \"shr\",to_char(a.kssj,'yyyy-mm-dd') "
				+ "as \"kssj\",to_char(a.jssj,'yyyy-mm-dd') as \"jssj\",a.bz as \"bz\" from Y_JY_BZXX a "
				+ "where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getJybz(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.bzmc like '%"+ code+ "%'";
		}
		String sql = " select a.id as \"id\",a.bzbh as \"bzbh\",a.bzmc as \"bzmc\","
				+ "a.bzmc_fz as \"bzmc_fz\",a.pyjm as \"pyjm\",a.bzlb as \"bzlb\",a.bzjb as \"bzjb\","
				+ "to_char(a.qyrq,'yyyy-mm-dd') as \"qyrq\",a.ks_ID as \"ks_id\",a.xmbh_ID as \"xmbh_id\","
				+ "to_char(a.zhxgrq,'yyyy-mm-dd') as \"zhxgrq\",a.xgr as \"xgr\",a.fzzt as \"fzzt\","
				+ "to_char(a.fzrq,'yyyy-mm-dd') as \"fzrq\",a.fzdjr as \"fzdjr\",a.shzt as \"shzt\","
				+ "to_char(a.shrq,'yyyy-mm-dd') as \"shrq\",a.shr as \"shr\",to_char(a.kssj,'yyyy-mm-dd') "
				+ "as \"kssj\",to_char(a.jssj,'yyyy-mm-dd') as \"jssj\",a.bz as \"bz\" from Y_JY_BZXX a "
				+ "where 1=1 "+ str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	
}
