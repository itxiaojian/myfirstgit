package com.zssi.framework.app.khgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.model.YkhHyxx;
/**
 * 
 * @author liangkaidi
 * @date 2015-9-22
 */
@Repository 
public class YkhHyxxDao extends HibernateBaseDaoImpl<YkhHyxx, Integer> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	public Pagination<Map<String, Object>> getHyxxList(Integer start,
			Integer limit, String code) {

		String str = "";
		if (code != null && !"".equals(code)) {
			
			str = str+ " and a.hybh  like '%"+ code+ "%' or a.hymc  like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.hybh,a.hymc,a.bz,a.ssfl,a.jb from y_kh_hyxx a  where 1=1 "+str;

		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击检验跳转的Jsp页面
	 * @author duanpeijun
	 * @date 2015年11月4日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getJy(){
		String str = "";
//		if(id!=null&&!"".equals(id)){
//			str=" and a.id='"+id+"'";
//		}
		String sql =  "  select a.id ,a.hybh,a.hymc,a.bz,a.ssfl,a.jb from y_kh_hyxx a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击检验跳转的Jsp页面
	 * @author duanpeijun
	 * @param id 
	 * @date 2015年11月4日
	 * @param id
	 * @return
	 */
//	public List<Map<String, Object>> getJy(String id){
	public List<Map<String, Object>> getHyXg(String id){
		String str = "";
	
//		if(id!=null&&!"".equals(id)){
//			str=" and a.id='"+id+"'";
//		}
		String sql =  "  select a.id ,a.hybh,a.hymc,a.bz,a.ssfl,a.jb from y_kh_hyxx a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getHybh(String hybh) {
			String sql =" select a.hymc from y_kh_hyxx a where 1=1" ;
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}

	
	/**
	 * 查询客户编号
	 * @author liangkaidi
	 * @date 2016-1-18
	 * @param sfbzbh
	 * @return
	 */
	public List<Map<String, Object>> getBgbhList(String khbh){
		String str = "";
		if(khbh!=null&&!"".equals(khbh)){
			str=" and a.khbh like '%" + khbh + "%'";
		}
		String sql = "select a.hybh from y_kh_hyxx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/** 
	 * 下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public List<Map<String, Object>> getSsfl() {
		String sql =" select a.hymc from y_kh_hyxx a where a.jb='1'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
