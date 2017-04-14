package com.zssi.framework.app.cwgl.dao; 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwBgsf;
import com.zssi.framework.app.process.support.file.CpsConstant;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/** 
 * 报告收费dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月11日 下午5:09:11 
 * 类说明 
 */
@Repository
public class YcwBgsfDao extends HibernateBaseDaoImpl<YcwBgsf, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
//	报告待收费分页查询
	public Pagination<Map<String, Object>> getBgsfList(Integer start, Integer limit,String code,String jyks,String ywks){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (d.bgbh like '%"+ code+ "%' or d.ypmc like '%"+ code+ "%' or i.wtdw like '%"+ code+ "%' "
					+ " or i.scdw like '%"+ code+ "%' or i.scdwdh like '%"+ code+ "%' or i.sb like '%"+ code+ "%' "
					+ " or i.slr like '%"+ code+ "%'  or i.sjdw like '%"+ code+ "%' or i.dh like '%"+ code+ "%' "
					+ " or i.sjhm like '%"+ code+ "%')";
		}
		if(jyks!=null&&!"".equals(jyks)){
			str=str+" and d.ks_id = '"+ jyks+ "' ";
		}
		if(ywks!=null&&!"".equals(ywks)){
			str=str+" and d.ssywks = '"+ ywks+ "' ";
		}
		String sql = " select d.id,d.sjdw,i.wtdw,to_char(d.jyjsrq,'yyyy-MM-dd HH24:mi:ss') as jyjsrq,d.ysje,d.ysfje,d.sfr,d.xgje,d.sfyq,"
				+ "d.sfzt,d.bz,d.ypmc,d.bcss, d.srfl,d.jyfy,d.bgbh,e.bmmc as ks_id,f.bmmc as ssywks,g.bmmc as wtbm,h.bmmc as cjbm,"
				+ "c.jyfy as cjfy from Y_CW_BGSF d left join (select a.bgbh,b.wtbm,b.cjbm,b.jyfy from (SELECT distinct nwbh, "
				+ "trim(regexp_substr(bgbh, '[^,]+', 1, level)) bgbh FROM (SELECT nwbh, bgbh FROM Y_JY_NWMX) t CONNECT BY "
				+ "instr(bgbh, ',', 1, level - 1) > 0 order by nwbh) a left join y_jy_nwgl b on a.nwbh = b.id ) c on d.bgbh = c.bgbh "
				+ "left join sys_zzjg e on d.ks_id = e.id left join sys_zzjg f on d.ssywks = f.id left join sys_zzjg g on c.wtbm = g.id "
				+ "left join sys_zzjg h on c.cjbm = h.id left join y_yp_ypxx i on i.ypbh = d.bgbh "
				+ "where d.jyfy != d.ysfje and d.ysfje >= 0  " +str
				+ "order by d.sfzt,d.jyjsrq  desc";
		return jdbcPager.queryPage(sql, start, limit);
	}

//	报告已收费分页查询
	public Pagination<Map<String, Object>> getBgysfList(Integer start, Integer limit,String code,String jyks,String ywks){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (d.bgbh like '%"+ code+ "%' or d.ypmc like '%"+ code+ "%' or i.wtdw like '%"+ code+ "%')";
		}
		if(jyks!=null&&!"".equals(jyks)){
			str=str+" and d.ks_id = '"+ jyks+ "' ";
		}
		if(ywks!=null&&!"".equals(ywks)){
			str=str+" and d.ssywks = '"+ ywks+ "' ";
		}
		String sql = " select d.id,d.sjdw,i.wtdw,to_char(d.jyjsrq,'yyyy-MM-dd HH24:mi:ss') as jyjsrq,d.ysje,d.ysfje,d.sfr,d.xgje,d.sfyq,"
				+ "d.sfzt,d.bz,d.ypmc,d.bcss, d.srfl,d.jyfy,d.bgbh,e.bmmc as ks_id,f.bmmc as ssywks,g.bmmc as wtbm,h.bmmc as cjbm,"
				+ "c.jyfy as cjfy from Y_CW_BGSF d left join (select a.bgbh,b.wtbm,b.cjbm,b.jyfy from (SELECT distinct nwbh, "
				+ "trim(regexp_substr(bgbh, '[^,]+', 1, level)) bgbh FROM (SELECT nwbh, bgbh FROM Y_JY_NWMX) t CONNECT BY "
				+ "instr(bgbh, ',', 1, level - 1) > 0 order by nwbh) a left join y_jy_nwgl b on a.nwbh = b.id ) c on d.bgbh = c.bgbh "
				+ "left join sys_zzjg e on d.ks_id = e.id left join sys_zzjg f on d.ssywks = f.id left join sys_zzjg g on c.wtbm = g.id "
				+ "left join sys_zzjg h on c.cjbm = h.id left join y_yp_ypxx i on i.ypbh = d.bgbh  "
				+ "where abs(d.jyfy) = abs(d.ysfje) and d.ysje = 0 and d.jyfy != 0 " +str
				+ "order by d.sfzt,d.jyjsrq  desc";
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/** 
	 * 传参id的list查询要
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getbgsf(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and d.id ="+id;
		}
		String sql = "  select d.id,d.sjdw,to_char(d.jyjsrq,'yyyy-MM-dd HH24:mi:ss') as jyjsrq,d.ysje,d.ysfje,d.sfr,d.xgje,d.sfyq,d.pjhm,"
				+ "d.sfzt,d.bz,d.ypmc,d.bcss, d.srfl,d.jyfy,d.bgbh,d.xgje,e.bmmc as ks_id,f.bmmc as ssywks,g.bmmc as wtbm,h.bmmc as cjbm,"
				+ "c.jyfy as cjfy,d.pjfl from Y_CW_BGSF d left join (select a.bgbh,b.wtbm,b.cjbm,b.jyfy from (SELECT distinct nwbh, "
				+ "trim(regexp_substr(bgbh, '[^,]+', 1, level)) bgbh FROM (SELECT nwbh, bgbh FROM Y_JY_NWMX) t CONNECT BY "
				+ "instr(bgbh, ',', 1, level - 1) > 0 order by nwbh) a left join y_jy_nwgl b on a.nwbh = b.id ) c on d.bgbh = c.bgbh "
				+ "left join sys_zzjg e on d.ks_id = e.id left join sys_zzjg f on d.ssywks = f.id left join sys_zzjg g on c.wtbm = g.id "
				+ "left join sys_zzjg h on c.cjbm = h.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 传参id的list查询要
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getsfxm(String bgbh){
		String str = "";
		if (bgbh != null && !"".equals(bgbh)) {
			str=str+" and a.bgbh like '%"+ bgbh+"%'";
		}
		String sql = "  select a.id,a.bgbh,a.xmbh,a.xmmc,a.jldw,a.je,a.xgje,a.pjhm from y_yp_sfxmmx a  where 1=1 "+str;
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

	/**
	 * 获取待收费信息
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月24日 下午2:02:37 
	 * @return
	 */
	public List<Map<String, Object>> getDsfbgsf() {
		SysYh user = AppUtil.getCurrentUser();
		String sqljs = "select c.JSMC from sys_yh a left join sys_yhjs b on a.yhbh=b.yhbh left join sys_js c on b.JSBH = c.JSBH "
					 + "where a.dlm=? and c.jsmc=?";
		List<Map<String, Object>> listjs = jdbcTemplate.queryForList(sqljs,user.getUsername(),CpsConstant.ROLE_SFJS);
		List<Map<String, Object>> listbgsf = new ArrayList<Map<String,Object>>();
		if(listjs.size()!=0){
			String sql = "select a.id,a.bgbh,a.sjdw,a.ysje from Y_CW_BGSF a where a.SFZT='0' and a.jyfy != a.ysfje";
			listbgsf = jdbcTemplate.queryForList(sql);
		}
		return listbgsf;
	}
	/**
	 * 通过报告编号获收费信息
	 * @author:schell
	 * @version 创建时间：2015年12月26日 下午10:42:37
	 * @return
	 */
	public List<Map<String, Object>> getSfxxbyBgbh(String bgbh) {

		List<Map<String, Object>> listbgsf = new ArrayList<Map<String,Object>>();
			String sql = "select a.id from Y_CW_BGSF a where a.bgbh='"+bgbh+"'";
			listbgsf = jdbcTemplate.queryForList(sql);
		return listbgsf;
	}

}
