package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyYdmb;

@Repository
public class YjyYdmbDao extends HibernateBaseDaoImpl<YjyYdmb, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 模板设置列表
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYdmbList(Integer start,Integer limit,String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.bmbh like '%"+ code + "%' or a.bmmc like '%"+ code + "%'";
		}
		
		String sql = "select a.id,a.bmbh,a.fy,a.sy,a.fm,e.bmmc as bmmc,a.zh,a.ssbh,b.mbmc as sy_id,c.mbmc as fy_id,d.mbmc as fm_id,a.mbfl "
				+ "from y_jy_ydmb a " +
				"left join y_jy_bgmb b on a.sy_id=b.id " +
				"left join y_jy_bgmb c on a.fy_id=c.id " +
				"left join y_jy_bgmb d on a.fm_id=d.id " +
				"left join sys_zzjg e on a.bmmc = e.id " +
				"where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 点击修改获取所选行的信息
	 * @author wangyong
	 * @date 2015年11月18日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getYdmb(Integer id){
		String str = "";
		if(id!=null&&!"".equals(id)){
			str=" and a.id="+id;
		}
		String sql = "select a.id,a.bmbh,a.fy,a.fm,a.sy,e.bmmc as bmmc,a.zh,a.ssbh,b.mbmc as sy_id,c.mbmc as fy_id,d.mbmc as fm_id,a.mbfl "
				+ "from y_jy_ydmb a " +
				"left join y_jy_bgmb b on a.sy_id=b.id " +
				"left join y_jy_bgmb c on a.fy_id=c.id " +
				"left join y_jy_bgmb d on a.fm_id=d.id " +
				"left join sys_zzjg e on a.bmmc = e.id " +
				"where 1=1 "+str;
		
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据登记类型，字号，检验科室编号去查出模版。
	 * @author duanpeijun
	 * @date 2015年12月14日
	 * @param jyksbh    检验科室编号
	 * @param djlx      登记类型
	 * @param zh        字号
	 * @return
	 */
	public List<Map<String, Object>> getThreeId(String jyksbh,Integer mbfl,String zh){
		String str = "";
		if (jyksbh != null && !"".equals(jyksbh) && mbfl != null && !"".equals(mbfl) && zh != null && !"".equals(zh)) {
			str = str + " and a.bmbh = '"+ jyksbh + "' and a.mbfl = '"+ mbfl + "' and a.zh = '"+ zh + "'";
		}
		String sql = "select a.id,a.fm_id,a.sy_id,a.fy_id from y_jy_ydmb a where 1=1 " + str;
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 模板
	 * @author liangkaidi
	 * @date 2015-12-17
	 * @return
	 */
	public List<Map<String, Object>> getmbList(){
		String str = "";
		String sql = " select a.id,a.mbmc from y_jy_bgmb a where 1=1 " + str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 *  通过前台传来的字号获取编号
	 * @author wangyong
	 * @date 2015年12月18日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> findBh(String zh){
		String str = "";
		if(zh!=null&&!"".equals(zh)){
			str=" and a.zh = '" + zh +"'";
		}
		String sql = "select a.bh from y_bg_bhsz a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

		/**
		 * 数据字典中获取
		 * @author liangkaidi
		 * @date 2015-11-13
		 * @param zdzl
		 * @return
		 */
		public List<Map<String, Object>> getDicByList(String zdzl) {
			String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
	
}
