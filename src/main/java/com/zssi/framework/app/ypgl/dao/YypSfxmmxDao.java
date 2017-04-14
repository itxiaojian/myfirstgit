package com.zssi.framework.app.ypgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypSfxmmx;

@Repository
public class YypSfxmmxDao extends HibernateBaseDaoImpl<YypSfxmmx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 收费项目明细列表
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getSfxmmxList(Integer start,Integer limit,String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.bmbh bgbh '%"+ code + "%' or a.xmbh like '%"+ code + "%'";
		}
		String sql = "select a.id,a.bgbh,a.xmbh,a.xmmc,a.jldw,a.je,a.xgje "
				+ "from y_yp_sfxmmx a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 点击修改获取所选行的信息
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getSfxmmx(Integer id){
		String str = "";
		if(id!=null&&!"".equals(id)){
			str=" and a.id="+id;
		}
		String sql = "select a.id,a.bgbh,a.xmbh,a.xmmc,a.jldw,a.je,a.xgje "
				+ "from y_yp_sfxmmx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 查询是否有检验项目信息
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getSfxmmx(String bgbh){
		String str = "";
		if(bgbh!=null&&!"".equals(bgbh)){
			str=" and a.bgbh='"+bgbh+"'";
		}
		String sql = "select a.id,a.cpmc,a.xmbh,a.bgbh,a.xmmc,a.jldw,a.je,a.sl,a.xgje "
				+ "from y_yp_sfxmmx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 删除收费项目明细
	 * @author wangyonga
	 * @date 2015年12月20日
	 * @param bgbh
	 */
	public void deleteSfxmmx(String bgbh){
		String str = "";
		if(bgbh!=null&&!"".equals(bgbh)){
			str=" and a.bgbh='"+bgbh+"'";
			String sql = "delete from y_yp_sfxmmx a where 1=1 "+str;
			jdbcTemplate.execute(sql);
		}
		
	}
}
