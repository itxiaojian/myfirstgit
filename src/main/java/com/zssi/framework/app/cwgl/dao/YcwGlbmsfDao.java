package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwGlbmsf;

//管理部门收费da层
//liusong 2015-12-24
@Repository
public class YcwGlbmsfDao extends HibernateBaseDaoImpl<YcwGlbmsf, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	public Pagination<Map<String, Object>> getGlbmsfList(Integer start,Integer limit,String code,String bmbh){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (a.fphm like '%"+ code+ "%' or a.sfxmmc like '%"+ code+ "%')";
		}
		if(bmbh!=null&&!"".equals(bmbh)){
			str=str+" and a.bmbh ='"+ bmbh+ "'";
		}
		String sql = "select a.id,a.fphm,a.srfl,a.sfxmmc,a.sfje,to_char(a.sfrq,'YYYY-MM-dd HH24:mi:ss') as sfrq,a.bz,a.sfr,b.bmmc as bmbh, "
				+ "a.pjfl,a.pjhm from y_cw_glbmsf a  left join sys_zzjg b on a.bmbh = b.id  where 1 = 1 order by a.sfrq  desc"+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	public List<Map<String,Object>> getGlsf(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=" and a.id="+id;
		}
		String sql ="select a.id,a.fphm,a.srfl,a.sfxmmc,a.sfje,to_char(a.sfrq,'YYYY-MM-dd HH24:mi:ss') as sfrq,a.bz,a.sfr,b.bmmc as bmbh, "
				+ "a.pjfl,a.pjhm from y_cw_glbmsf a  left join sys_zzjg b on a.bmbh = b.id  where 1 = 1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

}
