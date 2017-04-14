package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysfjl;

//技术服务协议收费dao
@Repository
public class YcwJsfwxysfjlDao extends HibernateBaseDaoImpl<YcwJsfwxysfjl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	public List<Map<String,Object>> getxysfjl(String xybh){
		String str = "";
		if (xybh != null && !"".equals(xybh)) {
			str=str+" and a.xybh = '"+ xybh+"'  order by a.sfrq ";
		}
		String sql = "select a.id,a.xybh,f.khmc,f.khdz,f.xylx,f.frdb,f.lxdh,f.cpmc,f.fwxm,to_char(f.sxrq,'yyyy-MM-dd HH24:mi:ss') as sxrq,a.pjhm, "
				+ " to_char(f.zzrq,'yyyy-MM-dd HH24:mi:ss') as zzrq,f.bz_id as zxbz,f.xyzy,a.xyje,f.fkfs,f.jybh_id as bgbh,f.khhz_info as qzqk,f.khjlgm as xxqk,f.xyfzr, "
				+ " f.bz,a.ysje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd HH24:mi:ss') as sfrq,a.sfr,a.bz,"
				+ " b.bmmc as xyks_id,c.bmmc as jyks_id,d.bmmc as ywks_id,e.bmmc as ssks_id from y_cw_fwxysfjl a "
				+ " left join sys_zzjg b on a.xyks_id = b.id  left join sys_zzjg c on a.jyks_id = c.id "
				+ " left join sys_zzjg d on a.ywks_id = d.id  left join sys_zzjg e on a.ssks_id = e.id "
				+ " left join y_jsfw_xyxx f on a.xybh = f.xybh  where 1 = 1  "+str;
		return jdbcTemplate.queryForList(sql);
		}

	/**
	 * 协议及收费信息删除时连带删除此协议编号下的收费记录
	 * @author liusong
	 * @date 2015年2月22日
	 * @param 
	 * @return
	 */
	public void deletejl(String xybh) {
		String sql = "delete from y_cw_fwxysfjl where xybh = '"+xybh+"'";
		jdbcTemplate.execute(sql);
		
	}

}
