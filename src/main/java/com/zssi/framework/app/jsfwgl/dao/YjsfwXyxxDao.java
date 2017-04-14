package com.zssi.framework.app.jsfwgl.dao; 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jsfwgl.model.YjsfwXyxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * 技术服务信息dao层
 * @author liusong
 * @date 2015年10月9日
 * @return
 */
@Repository
public class YjsfwXyxxDao extends HibernateBaseDaoImpl<YjsfwXyxx, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 后台：技术服务协议信息
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getJsfwXyxxList(Integer start,Integer limit, String code) {
		String str = "";
		str=str+this.getBmxx(str);
		if(code!=null&&!"".equals(code)){
			str=str+" and a.xybh like '%"+ code+ "%' or a.cpmc like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.xybh,a.khmc,a.khdz,a.frdb,a.lxdh,a.cpmc,a.fwxm,a.xylx,to_char(a.sxrq,'YYYY-MM-dd') as sxrq,"
				+ "to_char(a.zzrq,'YYYY-MM-dd') as zzrq,a.xyzy,a.xykh,a.fkfs,a.bz_id,a.jybh_id,a.khjlgm,a.khhz_info,a.xyfzr,a.syje, "
				+ "to_char(a.djrq,'YYYY-MM-dd') as djrq,a.bz,a.xmlxr,a.dhhm,b.bmmc as ks_id,c.bmmc as jyks_id,d.bmmc as yeks_id,e.sfr "
				+ " from y_jsfw_xyxx a left join sys_zzjg b on a.ks_id = b.id "
				+ " left join sys_zzjg c on a.jyks_id = c.id "
				+ " left join sys_zzjg d on a.yeks_id = d.id "
				+ "left join y_cw_jsfwxysf e on a.xybh = e.xybh where 1=1 " + str +" order by a.djrq desc ";
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	public List<Map<String,Object>> getList(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=" and a.id="+id;
		}
		String sql = "select a.id,a.ks_id,a.jyks_id,a.yeks_id,a.xybh,a.khmc,a.khdz,a.frdb,a.lxdh,a.cpmc,a.fwxm,a.xylx,to_char(a.sxrq,'YYYY-MM-dd') as sxrq,"
				+ "to_char(a.zzrq,'YYYY-MM-dd') as zzrq,a.xyzy,a.xykh,a.fkfs,a.bz_id,a.jybh_id,a.khjlgm,a.khhz_info,a.xyfzr,a.syje, "
				+ "to_char(a.djrq,'YYYY-MM-dd') as djrq,a.bz,a.bz,a.xmlxr,a.dhhm,b.bmmc as ksmc1,c.bmmc as ksmc2,d.bmmc as ksmc3 "
				+ " from y_jsfw_xyxx a left join sys_zzjg b on a.ks_id = b.id "
				+ " left join sys_zzjg c on a.jyks_id = c.id "
				+ " left join sys_zzjg d on a.yeks_id = d.id where 1 = 1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

	public void deleteJsfwXyxx(Integer id){
		String sql = "delete from y_jsfw_xyxx where id="+id;
				jdbcTemplate.execute(sql);
	}

	/**
	 * 技术服务信息下拉菜单查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}
	
	/**
	 * 根据协议编号查出收费对应id
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public List<Map<String, Object>> getIdbyXybh(String xybh) {
	String sql =" select a.id from y_cw_jsfwxysf a where a.xybh='"+xybh+"'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}

	/**
	 * 检验合同号从协议信息获取，获取协议信息方法	
	 * @author wangyong
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getJyhth(String jyhthkhmc,String jyhthkhdz) {
		String str = "";
		if ((jyhthkhmc!=null&&!"".equals(jyhthkhmc)) && (jyhthkhdz!=null&&!"".equals(jyhthkhdz))) {
			str = "and a.khmc like '%" + jyhthkhmc +"%' and a.khdz like '%" + jyhthkhdz + "%'";
		}else if((jyhthkhmc!=null&&!"".equals(jyhthkhmc))) {
			str = "and a.khmc like '%" + jyhthkhmc +"%'";
		}else if((jyhthkhdz!=null&&!"".equals(jyhthkhdz))){
			str = "and a.khdz like '%" + jyhthkhdz + "%'";
		}
		
		String sql = "select a.id,a.xybh,a.khmc,a.khdz,a.frdb,a.syje from y_jsfw_xyxx a "
				     + "where 1 = 1 " + str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-1-18
	 * @param sjbh
	 * @param bmbh
	 * @return
	 */
		public List<Map<String,Object>> getBm(String sjbh,String bmbh){
			String str = "";
			if("100200".equals(sjbh)){
				str = str+ " and sjbh like '100200%' and bmbh='"+bmbh+"'";
			}else{
				str = str+ " and sjbh ='"+sjbh+"' and bmbh='"+bmbh+"'";
			}
			String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where 1=1 "+str ;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 获取过滤条件
		 * @author liujiansen
		 * @date 2016年1月15日
		 * @param str
		 * @return
		 */
		public String getBmxx(String str){
			SysYh user=AppUtil.getCurrentUser();
			List<Map<String,Object>> jybm=this.getBm("100500", user.getBmbh());//判断当前登录人是否是科室人员
			List<Map<String,Object>> jsbm=this.getBm("100400", user.getBmbh());//判断当前登录人是否是技术中心人员
			List<Map<String,Object>> ywbm=this.getBm("100200", user.getBmbh());//判断当前登录人是否是业务科室人员
			if(jybm.size()!=0){
				str=str+" and a.jyks_id ='"+user.getBmbh()+"' ";
			}else if(jsbm.size()!=0){
				str=str+" and a.jyks_id in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
			}else if(ywbm.size()!=0){
				str=str+" and a.yeks_id ='"+user.getBmbh()+"' ";
			}
			return str;
		}
		
		
		/**
		 * 通过检验合同号获收费信息
		 * @author:liusong
		 * @version 创建时间：2015年12月26日 下午10:42:37
		 * @return
		 */
		public List<Map<String, Object>> getXyxxbyHth(String jyhth) {

			List<Map<String, Object>> listbgsf = new ArrayList<Map<String,Object>>();
				String sql = "select a.id from Y_JSFW_XYXX a where a.xybh='"+jyhth+"'";
				listbgsf = jdbcTemplate.queryForList(sql);
			return listbgsf;
		}
	
}
