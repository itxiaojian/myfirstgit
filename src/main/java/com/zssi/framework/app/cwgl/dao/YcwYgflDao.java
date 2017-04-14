package com.zssi.framework.app.cwgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwYgfl;

@Repository
public class YcwYgflDao extends HibernateBaseDaoImpl<YcwYgfl, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询员工福利
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYgflList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (b.bmmc like '%"+ code+ "%' or a.ygxm like '%"+ code+ "%')";
		}
		String sql = "select a.id,a.flbh,a.ygxm,b.bmmc as ks_id,a.ssyf,a.ks_id as ksbh,a.flhj,to_char(a.lrrq,'YYYY-MM-dd HH24:mi:ss') as lrrq,"
				+ "a.lrr,a.xgr,to_char(a.xgrq,'YYYY-MM-dd') as xgrq,a.xgyy,c.zdmc as gzxjmc,gzxjxq,"
				+ "a.bz from y_cw_ygfl a left join sys_zzjg b on a.ks_id = b.id "
				+ "left join sys_sjzd c on a.gzxjmc=c.zdz where 1=1 "+str+" order by a.id desc";
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月28日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and (a.flbh like '%"+ code+ "%' or a.ygxm like '%"+ code+ "%')";
		}
		String sql = "select a.id,a.flbh,a.ygxm,b.bmmc as ks_id,a.ks_id as ksbh,a.ssyf,a.flhj,to_char(a.lrrq,'YYYY-MM-dd HH24:mi:ss') as lrrq,"
				+ "a.lrr,a.xgr,to_char(a.xgrq,'YYYY-MM-dd') as xgrq,a.xgyy,a.gzxjmc,a.gzxjxq,"
				+ "a.bz from y_cw_ygfl a left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 通过id查询选中行的所有信息
	 * @author wangyong
	 * @date 2015年11月24日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getYgfl(Integer id){
		String str = "";
		if(id!=null&&!"".equals(id)){
			str=" and a.id="+id;
		}
		String sql = "select a.id,a.flbh,a.ygxm,a.ks_id,b.bmmc as ksmc,a.ssyf,a.flhj,to_char(a.lrrq,'YYYY-MM-dd HH24:mi:ss') as lrrq,"
				+ "a.lrr,a.xgr,to_char(a.xgrq,'YYYY-MM-dd') as xgrq,a.xgyy,a.bz,a.gzxjmc,a.gzxjxq from y_cw_ygfl a left join sys_zzjg b on "
				+ "a.ks_id = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getYgflmx(String flbh){
		String sql = "select a.id,a.ygxm,a.ssyf,b.zdmc as flmc,a.flxq,a.je"
				+ " from y_cw_ygflmx a left join (select zdz,zdmc from sys_sjzd where zl='fllx' and jb=2) b on a.flmc=b.zdz where a.flbh = '"+flbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 修改员工福利信息的员工编号的同时，修改福利明细明细的员工编号
	 * @author wangyong
	 * @date 2015年12月8日
	 * @param id
	 */
	public void updateFlmxYgbh(String ygxm1,String ygxm2) {
		String sql = "update y_cw_ygflmx a set a.ygxm = '" + ygxm2 + "' where a.ygxm = '" + ygxm1 + "'";
		jdbcTemplate.execute(sql);;
	}
	
	/**
	 * 删除员工福利后删除相应的福利明细
	 * @author wangyong
	 * @date 2016年2月17日
	 * @param ygxm 员工姓名
	 */
	public void deleteFlmxByYgxm(String ygxm) {
		String sql = "";
		if (ygxm!=null && !"".equals(ygxm)) {
			sql = "delete from y_cw_ygflmx a where a.ygxm = '"+ygxm+"'";
			jdbcTemplate.execute(sql);;
		}
	}
	
	/**
	 * 保存新的员工福利明细之前通过福利编号删除旧的员工福利明细
	 * @author wangyong
	 * @date 2016年4月12日
	 * @param flbh
	 */
	public void deleteFlmxByFlbh(String flbh) {
		String sql = "";
		if (flbh!=null && !"".equals(flbh)) {
			sql = "delete from Y_CW_YGFLMX a where a.flbh = '"+flbh+"'";
			jdbcTemplate.execute(sql);;
		}
	}
	
	/**
	 * 根据工资薪金名称获取对应的字典值
	 * @author wangyong
	 * @date 2016年6月22日
	 * @param gzxjmc
	 * @return
	 */
	public List<Map<String, Object>> getGzxjmc(String gzxjmc){
		String str = "";
		if(gzxjmc!=null && !("").equals(gzxjmc)){
			str = " and a.zdmc='"+gzxjmc+"'" ;
		}
		String sql = "select a.zdz from sys_sjzd a where a.zl='fllx' and a.jb=2 "+str;
		return jdbcTemplate.queryForList(sql);
	}
}
