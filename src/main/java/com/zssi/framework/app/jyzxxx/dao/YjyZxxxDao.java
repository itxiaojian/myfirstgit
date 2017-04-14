package com.zssi.framework.app.jyzxxx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jyzxxx.model.YjyZxxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Repository
public class YjyZxxxDao extends HibernateBaseDaoImpl<YjyZxxx, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 分页查询咨询信息
	 * 
	 * @author wangyong
	 * @date 2015年6月2日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getZxxxList(Integer start, Integer limit, String code,String ksbh,String cpbh,String cpmc,
			String cplx,String jyyj)  {
		String str = "";
		str=str+this.getBmxx(str);
		if(ksbh!=null&&!"".equals(ksbh)){str=str+" and a.ksbh ='"+ ksbh+"'";}
		if(cpbh!=null&&!"".equals(cpbh)){str=str+" and a.cpbh like '%"+ cpbh+"%'";}
		if(cpmc!=null&&!"".equals(cpmc)){str=str+" and a.cpmc like '%"+ cpmc+"%'";}
		if(cplx!=null&&!"".equals(cplx)){str=str+" and a.cplx like '%"+ cplx+"%'";}
		if(jyyj!=null&&!"".equals(jyyj)){str=str+" and a.jyyj like '%"+ jyyj+"%'";}
		String sql = "select a.jyyj,a.cplx,a.cpbh,a.cpmc,c.bmmc as ksbh,a.bz1,xgr,to_char(a.xgsj,'yyyy-MM-dd  HH24:mi:ss') as xgsj from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+" group by a.cpbh,a.jyyj,a.cplx,a.cpmc,c.bmmc,a.bz1,xgr,xgsj order by a.cpbh desc";
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 获取当前最大的项目编号
	 * @author wangyong
	 * @date 2016年6月3日
	 * @return
	 */
	public List<Map<String, Object>> getMaxxmbh() {
		String sql = "select max(jyxmbh) jyxmbh from y_jy_zxxx" ;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取当前最大的产品编号
	 * @author wangyong
	 * @date 2016年6月3日
	 * @return
	 */
	public List<Map<String, Object>> getMaxcpbh() {
		String sql = "select max(cpbh) cpbh from y_jy_zxxx" ;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 通过id获取咨询信息
	 * @author wangyong
	 * @date 2016年6月3日
	 * @return
	 */
	public List<Map<String, Object>> getZxxx(String cpbh, String jyyj){
		String str = "";
		if(cpbh!=null&&!"".equals(cpbh)){
			str += " and a.cpbh='"+cpbh+"'";
		}
		if(jyyj!=null&&!"".equals(jyyj)){
			str += " and a.jyyj='"+jyyj+"'";
		}
		String sql = "select a.id,a.cpmc,a.jyxmbh,a.jcxm,a.jyyj,a.dybztkh,a.ggxh,a.ypsl,a.jcfy,a.jyzq,a.yzz,a.gpzz,a.gjzz,a.cplx,a.cpbh,"
				+ "a.yspzz,a.hjyq,a.sbbh,a.sbmc,a.ry,a.bz,a.bz1,a.yzzrd,a.ksbh,a.jldw from y_jy_zxxx a where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据产品编号和检验依据删除咨询信息
	 * @author wangyong
	 * @date 2016年6月3日
	 * @return
	 */
	public void deleteCp(String cpbh, String jyyj) {
		if(cpbh!=null&&!"".equals(cpbh) && jyyj!=null&&!"".equals(jyyj)){
			String sql = "delete from y_jy_zxxx a where a.cpbh='"+cpbh+"' and a.jyyj='"+jyyj+"'";
			jdbcTemplate.execute(sql);
		}
	}
	
	/**
	 * 获取已有的产品	
	 * @author wangyong
	 * @date 2015年6月12日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> yccpList(String ypbhcx,String ypmccx,String ypjzcs) {
		String str = "";
		int num=1;
		if(ypjzcs!=null&&!"".equals(ypjzcs)){
			num=Integer.parseInt(ypjzcs);
		}
		if ((ypbhcx!=null&&!"".equals(ypbhcx))) {
			str = "and a.cpbh like '%" + ypbhcx +"%' ";
		}
		if ((ypmccx!=null&&!"".equals(ypmccx))) {
			str = "and a.cpmc like '%" + ypmccx +"%' ";
		}
		
		String sql = "SELECT X.cpbh, X.cpmc, X.cplx, ROWNUM AS RN FROM "
				+ "(select a.cpbh,a.cpmc,a.cplx from y_jy_zxxx a "
				+ "where 1=1 "+str+" group by a.cpbh,a.cpmc,a.cplx) X WHERE ROWNUM <="+(num*7);
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 咨询信息list查询
	 * @author wangyong
	 * @date 2015年6月6日
	 * 类说明 
	 */
	public List<Map<String,Object>> getList(String ksbh,String cpbh,String cpmc,String cplx,String jyyj){
		String str = "";
		if (ksbh != null && !"".equals(ksbh)) {
			str=str+" and a.ksbh = '"+ ksbh+ "'";
		}
		if (cpbh != null && !"".equals(cpbh)) {
			str=str+" and a.cpbh = '"+ cpbh+ "'";
		}
		if (cpmc != null && !"".equals(cpmc)) {
			str=str+" and a.cpmc like '%"+ cpmc+ "%'";
		}
		if (cplx != null && !"".equals(cplx)) {
			str=str+" and a.cplx = '"+ cplx+ "'";
		}
		if (jyyj != null && !"".equals(jyyj)) {
			str=str+" and a.jyyj like '%"+ jyyj+ "%'";
		}
		String sql = "select a.id,a.cpmc,a.jyxmbh,a.jcxm,a.jyyj,a.dybztkh,a.ggxh,a.ypsl,a.jcfy,a.jyzq,a.yzz,a.gpzz,a.gjzz,a.cplx,a.cpbh,"
				+ "a.yspzz,a.hjyq,a.sbbh,a.sbmc,a.ry,a.bz,a.bz1,a.yzzrd,c.bmmc as ksbh from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+" order by a.id desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取过滤条件
	 * @author wangyong
	 * @date 2016年1月25日
	 * @param str
	 * @return
	 */
	public String getBmxx(String str){
		SysYh user=AppUtil.getCurrentUser();
//		List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
		List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
//		if(jybm.size()!=0){
//			str=str+" and a.ksbh='"+user.getBmbh()+"' ";
//		}else if(jsbm.size()!=0){
//			str=str+" and a.ksbh in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
//		}
		
		if(jsbm.size()!=0){
			str=str+" and a.ksbh='"+user.getBmbh()+"' ";
		}
		return str;
	}	
	
	/**
	 * 获取部门信息
	 * @author wangyong
	 * @date 2016年1月25日
	 * @param sjbh
	 * @param bmbh
	 * @return
	 */
	public List<Map<String,Object>> getBm(String sjbh,String bmbh){
		String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where sjbh='"+sjbh+"' and bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
	}

	public String getMaxCpbh() {
		String sql="SELECT nvl(max(cpbh),'1000000') as cpbh from y_jy_zxxx ";
		return jdbcTemplate.queryForList(sql).get(0).get("cpbh").toString();
	}

	public String getMaxXmbh() {
		String sql="SELECT nvl(max(jyxmbh),'10000000') as xmbh from y_jy_zxxx ";
		return jdbcTemplate.queryForList(sql).get(0).get("xmbh").toString();
	}


}
