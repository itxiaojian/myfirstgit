package com.zssi.framework.app.dagl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dagl.model.YdaLmgl;

/** 
 * 档案类目管理dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:34:36 
 * 类说明 
 */
@Repository
public class YdaLmglDao extends HibernateBaseDaoImpl<YdaLmgl, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 档案类目管理分页查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public Pagination<Map<String, Object>> getDaLmglList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.lmmc like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.lmmc,a.lmjb,a.ssjgid,b.bmmc as ssjgmc,a.yjlmid,a.sjlmid,a.flyid,a.glyxm,"
				+ "a.cjrid,a.cjrxm,a.kckrid,a.kckrxm,a.lmpx,a.bz from y_da_lmgl a "
				+ "left join sys_zzjg b on a.ssjgmc = b.id where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	public void deleteJsfwXyLmgl(Integer id){
		String sql = "delete from y_da_lmgl where id="+id;
				jdbcTemplate.execute(sql);
	}

	/**
	 * 归档时档案类目选择查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public List<Map<String, Object>> getDaLm(String lmmc) {
		String str = "";
		if(lmmc!=null&&!"".equals(lmmc)){
			str=str+" and a.lmmc like '%"+ lmmc+ "%'";
		}
		String sql = "  select a.id,a.lmmc,a.damj,a.bgqx,a.lmid,a.bz from y_da_bgqx a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getDalmById(Integer id) {
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id = "+ id;
		}
		String sql = "  select a.id,a.lmmc,a.damj,a.bgqx,a.lmid,a.bz from y_da_bgqx a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getXg(String id) {
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id = "+ id;
		}
		String sql = "  select a.id,a.lmmc,a.damj,a.bgqx,a.lmid,a.bz from y_da_bgqx a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
/**
 * 保管期限获取类目管理的信息
 * @author liangkaidi
 * @date 2015-12-24
 * @param code
 * @return
 */
	public List<Map<String, Object>> getLmmc(String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.lmmc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.lmmc,a.lmjb,a.ssjgid,a.ssjgmc,a.yjlmid,a.sjlmid,a.flyid,a.glyxm,"
				+ "a.cjrid,a.cjrxm,a.kckrid,a.kckrxm,a.lmpx,a.bz from y_da_lmgl a  where 1=1 "+str;
		
		return jdbcTemplate.queryForList(sql);
	}
}
