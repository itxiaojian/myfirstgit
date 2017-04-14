package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysf;

//技术服务协议收费dao
@Repository
public class YcwJsfwxysfDao extends HibernateBaseDaoImpl<YcwJsfwxysf, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
//	技术服务协议待收费查询
	public Pagination<Map<String, Object>> getXysfList(Integer start, Integer limit,String code,String jyks,String ywks){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and ( a.xybh like '%"+ code+ "%' or a.khmc like '%"+ code+ "%')";
		}
		if(jyks!=null&&!"".equals(jyks)){
			str=str+" and a.jyks_id = '"+ jyks+ "' ";
		}
		if(ywks!=null&&!"".equals(ywks)){
			str=str+" and a.ywks_id = '"+ ywks+ "' ";
		}
		String sql = "select a.id,a.xybh,f.khmc,f.khdz,f.xylx,f.frdb,f.lxdh,f.cpmc,f.fwxm,to_char(f.sxrq,'yyyy-MM-dd HH24:mi:ss') as sxrq,a.pjfl, "
				+ " to_char(f.zzrq,'yyyy-MM-dd HH24:mi:ss') as zzrq,f.bz_id as zxbz,f.xyzy,a.xyje,f.fkfs,f.jybh_id as bgbh,f.khhz_info as qzqk,f.khjlgm as xxqk,f.xyfzr, "
				+ " f.bz,a.ysje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd HH24:mi:ss') as sfrq,a.sfr,"
				+ " b.bmmc as xyks_id,c.bmmc as jyks_id,d.bmmc as ywks_id,e.bmmc as ssks_id from y_cw_jsfwxysf a "
				+ " left join sys_zzjg b on a.xyks_id = b.id  left join sys_zzjg c on a.jyks_id = c.id "
				+ " left join sys_zzjg d on a.ywks_id = d.id  left join sys_zzjg e on a.ssks_id = e.id "
				+ " left join y_jsfw_xyxx f on a.xybh = f.xybh  where a.xyje != a.ysfje "+str+" order by a.sfrq  desc ";
		return jdbcPager.queryPage(sql, start, limit);
		
	}
	
//	技术服务协议已收费查询
	public Pagination<Map<String, Object>> getXyysfList(Integer start, Integer limit,String code,String jyks,String ywks){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (a.xybh like '%"+ code+ "%' or a.khmc like '%"+ code+ "%')";
		}
		if(jyks!=null&&!"".equals(jyks)){
			str=str+" and a.jyks_id = '"+ jyks+ "' ";
		}
		if(ywks!=null&&!"".equals(ywks)){
			str=str+" and a.ywks_id = '"+ ywks+ "' ";
		}
		String sql = "select a.id,a.xybh,f.khmc,f.khdz,f.xylx,f.frdb,f.lxdh,f.cpmc,f.fwxm,to_char(f.sxrq,'yyyy-MM-dd HH24:mi:ss') as sxrq,a.pjfl, "
				+ " to_char(f.zzrq,'yyyy-MM-dd HH24:mi:ss') as zzrq,f.bz_id as zxbz,f.xyzy,a.xyje,f.fkfs,f.jybh_id as bgbh,f.khhz_info as qzqk,f.khjlgm as xxqk,f.xyfzr, "
				+ " f.bz,a.ysje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd HH24:mi:ss') as sfrq,a.sfr,"
				+ " b.bmmc as xyks_id,c.bmmc as jyks_id,d.bmmc as ywks_id,e.bmmc as ssks_id from y_cw_jsfwxysf a "
				+ " left join sys_zzjg b on a.xyks_id = b.id  left join sys_zzjg c on a.jyks_id = c.id "
				+ " left join sys_zzjg d on a.ywks_id = d.id  left join sys_zzjg e on a.ssks_id = e.id "
				+ " left join y_jsfw_xyxx f on a.xybh = f.xybh  where a.xyje = a.ysfje "+str+" order by a.sfrq  desc ";
		return jdbcPager.queryPage(sql, start, limit);
		
	}
	
	/** 
	 * 传参id的list查询要
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getxysf(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id ="+id;
		}
		String sql =  "select a.id,a.xybh,f.khmc,f.khdz,f.xylx,f.frdb,f.lxdh,f.cpmc,f.fwxm,to_char(f.sxrq,'yyyy-MM-dd HH24:mi:ss') as sxrq,a.pjfl,a.srfl,  "
				+ " to_char(f.zzrq,'yyyy-MM-dd HH24:mi:ss') as zzrq,f.bz_id as zxbz,f.xyzy,a.xyje,f.fkfs,f.jybh_id as bgbh,f.khhz_info as qzqk,f.khjlgm as xxqk,f.xyfzr, "
				+ " f.bz,a.ysje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd HH24:mi:ss') as sfrq,a.sfr,"
				+ " b.bmmc as xyks_id,c.bmmc as jyks_id,d.bmmc as ywks_id,e.bmmc as ssks_id from y_cw_jsfwxysf a "
				+ " left join sys_zzjg b on a.xyks_id = b.id  left join sys_zzjg c on a.jyks_id = c.id "
				+ " left join sys_zzjg d on a.ywks_id = d.id  left join sys_zzjg e on a.ssks_id = e.id "
				+ " left join y_jsfw_xyxx f on a.xybh = f.xybh  where 1 = 1  "+str;
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
	
	public List<Map<String, Object>> getGlbm() {
		String sql =" select a.bmbh,a.bmmc from sys_zzjg a where a.sjbh = '100210' ";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

	/**
	 * 协议删除时删除此协议编号下的收费信息
	 * @author wangyong
	 * @date 2015年2月22日
	 * @param 
	 * @return
	 */
	public void deletesf(String xybh) {
		String sql = "delete from y_cw_jsfwxysf where xybh = '"+xybh+"'";
		jdbcTemplate.execute(sql);
		
	}

	

}
