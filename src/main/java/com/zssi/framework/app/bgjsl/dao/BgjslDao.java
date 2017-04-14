package com.zssi.framework.app.bgjsl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.bgjsl.model.Bgjsl;
import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;

@Repository
public class BgjslDao extends HibernateBaseDaoImpl<Bgjsl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 档案信息分页查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public Pagination<Map<String, Object>> getList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (a.bz like '%"+ code+ "%' or a.csxq like '%"+ code+ "%')";
		}
		String sql = "  select a.id,a.gjz,a.csxq,a.sjsz,a.bz from y_bg_jslkh a where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}

	public List<Map<String, Object>> getCsList() {
		String sql = " select a.id,a.gjz,a.csxq,a.sjsz,a.bz from y_bg_jslkh a where 1=1 order by a.id ";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getBgyqList(String ypbh,String ksmc,String ksyf,String jsyf,String csjd,Integer start, Integer limit) {
		String str = "";
//		str=str+this.getBmxx(str);
		if (csjd != null && !"".equals(csjd)) {
			str = str + " and a.jdmc = '"+csjd+"'";
		}
		if (ksmc != null && !"".equals(ksmc)) {
			str = str + " and a.jyks = '"+ksmc+"'";
		}
		if (ypbh != null && !"".equals(ypbh)) {
			str = str + " and a.bgbh like '%"+ypbh+"%'";
		}
		if(ksyf !=null&&!"".equals(ksyf)){
			str = str + " and a.kssj between '"+ksyf+"' and '"+jsyf+"' ";
		}
			String sql ="SELECT * FROM (SELECT X.*,ROWNUM AS RN FROM ( SELECT X.*,rownum FROM ( select  x.bgbh,x.bmmc,x.ypmc,x.jylx,x.wcqx,x.jdmc,x.kssj,x.shsj,x.jdry,(x.sjc-x.sjsz)as sjc,x.sjsz "
					+ " from (select a.bgbh,b.bmmc,a.ypmc,a.jylx,to_char(a.wcqx,'yyyy-MM-dd')as wcqx,a.jdmc,a.kssj,a.shsj,a.jdry,a.sjc,c.sjsz "
					+ " from VIEW_JSL a left join sys_zzjg b on a.jyks = b.bmbh left join Y_BG_JSLKH c on a.jdmc = c.bz "
					+ " where a.bgbh is not null "+str+") x where sjc > sjsz order by bgbh desc ) X ) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
			return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getBgyqExl(String ypbh,String ksmc,String ksyf,String jsyf,String csjd) {
		String str = "";
//		str=str+this.getBmxx(str);
		if (csjd != null && !"".equals(csjd)) {
			str = str + " and a.jdmc = '"+csjd+"'";
		}
		if (ksmc != null && !"".equals(ksmc)) {
			str = str + " and a.jyks = '"+ksmc+"'";
		}
		if (ypbh != null && !"".equals(ypbh)) {
			str = str + " and a.bgbh like '%"+ypbh+"%'";
		}
		if(ksyf !=null&&!"".equals(ksyf)){
			str = str + " and a.kssj between '"+ksyf+"' and '"+jsyf+"' ";
		}
			String sql =" select  x.bgbh,x.bmmc,x.ypmc,x.jylx,x.wcqx,x.jdmc,x.kssj,x.shsj,x.jdry,(x.sjc-x.sjsz)as sjc,x.sjsz "
					+ " from (select a.bgbh,b.bmmc,a.ypmc,a.jylx,to_char(a.wcqx,'yyyy-MM-dd')as wcqx,a.jdmc,a.kssj,a.shsj,a.jdry,a.sjc,c.sjsz "
					+ " from VIEW_JSL a left join sys_zzjg b on a.jyks = b.bmbh left join Y_BG_JSLKH c on a.jdmc = c.bz "
					+ " where a.bgbh is not null "+str+") x where sjc > sjsz order by bgbh desc ";
			return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getBgyqCont(String ypbh,String ksmc,String ksyf,String jsyf,String csjd) {
		String str = "";
//		str=str+this.getBmxx(str);
		if (csjd != null && !"".equals(csjd)) {
			str = str + " and a.jdmc = '"+csjd+"'";
		}
		if (ksmc != null && !"".equals(ksmc)) {
			str = str + " and a.jyks = '"+ksmc+"'";
		}
		if (ypbh != null && !"".equals(ypbh)) {
			str = str + " and a.bgbh like '%"+ypbh+"%'";
		}
		if(ksyf !=null&&!"".equals(ksyf)){
			str = str + " and a.kssj between '"+ksyf+"' and '"+jsyf+"' ";
		}
			String sql ="SELECT count(1) as cnt from( select  x.bgbh,x.bmmc,x.ypmc,x.jylx,x.wcqx,x.jdmc,x.kssj,x.shsj,x.jdry,(x.sjc-x.sjsz)as sjc,x.sjsz "
					+ " from (select a.bgbh,b.bmmc,a.ypmc,a.jylx,to_char(a.wcqx,'yyyy-MM-dd')as wcqx,a.jdmc,a.kssj,a.shsj,a.jdry,a.sjc,c.sjsz "
					+ " from VIEW_JSL a left join sys_zzjg b on a.jyks = b.bmbh left join Y_BG_JSLKH c on a.jdmc = c.bz "
					+ " where a.bgbh is not null "+str+") x where sjc > sjsz order by bgbh desc) ";
			return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getCsjd() {
		String sql =" select a.id,a.bz from y_bg_jslkh a where 1=1 order by a.id";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
}
