package com.zssi.framework.app.jygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyRztb;

/**
 * 检验认证图标
 * @author duanpeijun
 * @date 2015年10月15日
 */
@Repository
public class YjyRztbDao extends HibernateBaseDaoImpl<YjyRztb, Integer>{

	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 后台：检验认证图标
	 * @author duanpeijun
	 * @date 2015年10月15日
	 * @param start
	 * @param limit
	 * @param rzmc   认证名称
	 * @return
	 */
	public Pagination<Map<String,Object>> getRztbList(Integer start,Integer limit, String rzmc) {
		
		StringBuilder sql = new StringBuilder(" SELECT t.ID AS \"id\",t.RZMC AS \"rzmc\",t.RZFL AS \"rzfl\", "
				+ "t.FJLJ AS \"fjlj\"  , t.BZ AS \"bz\",t.SUB AS \"sub\" FROM Y_JY_RZTB t WHERE  1 = 1 ");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(rzmc != null && !rzmc.equals("")  ){
			sql.append(" and t.RZMC like " +"'%"+rzmc+"%'");
		}
		
		/*if(sclx != null && !sclx.equals("")){
			if(sclx.equals("0") ){//查询全部
				
			}else{
				sql.append(" and t.SC_TYPE = " +sclx);
			}
			
		}*/
		
		sql.append(" order by t.ID ");
		return jdbcPager.queryPageDb2(sql.toString(), start, limit, paramMap);
	}
	
	/**
	 * 查看图片
	 * @author duanpeijun
	 * @date 2015年10月16日
	 * @return
	 */
	public List<Map<String, Object>> getImageList(String id) {
		String sql = "select t.RZMC as \"rzmc\",t.FJLJ as \"fjlj\",t.RZFL as \"rzfl\",t.SUB as \"fileCode\" from Y_JY_RZTB t where 1=1 and t.ID = "+id;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 认证分类（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByRzfl(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	
	/**
	 * 检验页面上显示的图标名称
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @return
	 */
	public List<Map<String, Object>> getTbList(String fl){
		String str = "";
		if(fl!=null&&!"".equals(fl)){
			str=" and a.fl='"+fl+"'";
		}
		str = str + " order by a.px ";
		String sql = " select a.id,a.rzmc,a.rzfl,a.fjlj,a.sub,a.fl from y_jy_rztb a where 1=1 " +str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检验页面上的单位名称（隐藏）
	 * @author duanpeijun
	 * @date 2016年3月9日
	 * @param fl
	 * @return
	 */
	public List<Map<String, Object>> getDwList(String fl){
		String str = "";
		if(fl!=null&&!"".equals(fl)){
			str=" and a.fl='"+fl+"'";
		}
		String sql = " select a.id,a.dwmc,a.dwfl,a.dwlj,a.sub,a.fl from y_jy_dwmc a where 1=1 " +str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检验页面上的 批准章（隐藏）
	 * @author duanpeijun
	 * @date 2016年3月18日
	 * @param fl
	 * @return
	 */
	public List<Map<String, Object>> getPzzList(String fl){
		String str = "";
		if(fl!=null&&!"".equals(fl)){
			str=" and a.fl='"+fl+"'";
		}
		String sql = " select a.id,a.yzmc,a.yzfl,a.yzlj,a.sub,a.fl from y_jy_yzmc a where 1=1 " +str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 流程中----- 点击编制报告，查询出该条检验信息的认证图标
	 * @author duanpeijun
	 * @date 2015年12月1日
	 * @return
	 */
	public List<Map<String, Object>> getlctb(String rztb){
		String str = "";
		if(rztb!=null&&!"".equals(rztb)){
			str=" and to_char(t.id) in ("+rztb+") ";
		}
		String sql = "select t.*, t.rowid from y_jy_rztb t where 1 = 1 " + str;
		return jdbcTemplate.queryForList(sql);
	}
}
