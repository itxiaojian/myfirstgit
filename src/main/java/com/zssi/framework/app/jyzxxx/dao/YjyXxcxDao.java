package com.zssi.framework.app.jyzxxx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.jygl.model.YjyBgxx;

@Repository
public class YjyXxcxDao extends HibernateBaseDaoImpl<YjyBgxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 产品类型查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getXxcx(Integer start, Integer limit) {
		String sql = "SELECT XX.ZDMC,XX.ZDZ FROM ( SELECT X.zdmc, X.zdz,ROWNUM AS RN FROM (select a.zdmc,a.zdz from sys_sjzd a "
				+ "where a.zl='cplx' and a.jb=2 ) X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String, Object>> getXxcx(Integer start, Integer limit, String cplx) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.zdmc like '%"+cplx+"%'";
		}
		String sql = "SELECT XX.ZDMC,XX.ZDZ FROM ( SELECT X.zdmc, X.zdz,ROWNUM AS RN FROM (select a.zdmc,a.zdz from sys_sjzd a "
				+ "where a.zl='cplx' and a.jb=2 "+str+") X WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Map<String, Object>> getList(Integer start, Integer limit, String cplx, String cpmc, String jyyj) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpmc!=null && !("").equals(cpmc)){
			str+=" and a.cpmc like '%"+cpmc+"%'";
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'";
		}
		
		String sql ="SELECT XX.cplx,XX.cpmc,XX.jyyj,XX.jcxm,XX.dybztkh,XX.ggxh,XX.ypsl,XX.jcfy,XX.jyzq,XX.yzzrd,XX.yzz,XX.gpzz,XX.gjzz,XX.yspzz,XX.hjyq,XX.sbbh,XX.sbmc,XX.ry FROM "
				+ "( SELECT X.cplx,X.cpmc,X.jyyj,X.jcxm,X.dybztkh,X.ggxh,X.ypsl,X.jcfy,X.jyzq,X.yzzrd,X.yzz,X.gpzz,X.gjzz,X.yspzz,X.hjyq,X.sbbh,X.sbmc,X.ry,ROWNUM AS RN FROM "
				+ "( select a.cplx,a.cpmc,a.jyyj,a.jcxm,a.dybztkh,a.ggxh,a.ypsl,a.jcfy,a.jyzq,a.yzzrd,a.yzz,a.gpzz,a.gjzz,a.yspzz,a.hjyq,a.sbbh,a.sbmc,a.ry "
				+ "from y_jy_zxxx a left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+") X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param join
	 * @param cxtj
	 * @param tabName
	 * @return
	 */
	public List<Map<String,Object>> getBgxxCount(Integer start, Integer limit, String cplx) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.zdmc like '%"+cplx+"%'";
		}
		String sql="SELECT count(*) as cnt from sys_sjzd a where a.zl='cplx' and a.jb=2 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 产品名称类型查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getCpcx(Integer start, Integer limit, String cplx) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx='"+cplx+"'";
		}
		String sql ="SELECT XX.KSBH,XX.CPBH,XX.CPMC,XX.CPLX FROM "
				+ "( SELECT X.KSBH,X.CPBH,X.CPMC,X.CPLX,ROWNUM AS RN FROM "
				+ "(select a.cplx,a.cpbh,a.cpmc,c.bmmc as ksbh from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+" group by a.cpbh,a.cplx,a.cpmc,c.bmmc order by a.cpbh desc) X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 获取产品名称List
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getCpList(Integer start, Integer limit, String cplx,String cpmc,String jyyj) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpmc!=null && !("").equals(cpmc)){
			str+=" and a.cpmc like '%"+cpmc+"%'" ;
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'" ;
		}
		String sql ="SELECT XX.KSBH,XX.CPBH,XX.CPMC,XX.CPLX FROM "
				+ "( SELECT X.KSBH,X.CPBH,X.CPMC,X.CPLX,ROWNUM AS RN FROM "
				+ "(select a.cplx,a.cpbh,a.cpmc,c.bmmc as ksbh from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+" group by a.cpbh,a.cplx,a.cpmc,c.bmmc order by a.cpbh desc) X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 获取信息条数
	 * @author wangyogn
	 * @date 2016年6月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Map<String,Object>> getCpCount(Integer start, Integer limit, String cplx, String cpmc, String jyyj) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpmc!=null && !("").equals(cpmc)){
			str+=" and a.cpmc like '%"+cpmc+"%'" ;
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'" ;
		}
		String sql="select count(*) as cnt from (select a.cpbh from y_jy_zxxx a left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+" group by a.cpbh)";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 产品名称类型查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getJyyj(Integer start, Integer limit, String cplx, String cpbh) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpbh!=null && !("").equals(cpbh)){
			str+=" and a.cpbh='"+cpbh+"'";
		}
		String sql ="SELECT XX.KSBH,XX.CPBH,XX.CPMC,XX.CPLX,XX.JYYJ FROM ( SELECT X.KSBH,X.CPBH,X.CPMC,X.CPLX,X.JYYJ,ROWNUM AS RN FROM "
				+ "(select a.cplx,a.cpbh,a.cpmc,c.bmmc as ksbh,a.jyyj from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+"group by a.cpbh,a.cplx,a.cpmc,c.bmmc,a.jyyj order by a.cpbh desc) X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 产品名称类型查询页面
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 */
	public List<Map<String, Object>> getJyyjList(Integer start, Integer limit, String cplx, String cpbh,String cpmc,String jyyj) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpbh!=null && !("").equals(cpbh)){
			str+=" and a.cpbh='"+cpbh+"'";
		}
		if(cpmc!=null && !("").equals(cpmc)){
			str+=" and a.cpmc like '%"+cpmc+"%'";
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'";
		}
		String sql ="SELECT XX.KSBH,XX.CPBH,XX.CPMC,XX.CPLX,XX.JYYJ FROM ( SELECT X.KSBH,X.CPBH,X.CPMC,X.CPLX,X.JYYJ,ROWNUM AS RN FROM "
				+ "(select a.cplx,a.cpbh,a.cpmc,c.bmmc as ksbh,a.jyyj from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+"group by a.cpbh,a.cplx,a.cpmc,c.bmmc,a.jyyj order by a.cpbh desc) X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 获取信息条数
	 * @author wangyogn
	 * @date 2016年6月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Map<String,Object>> getJyyjCount(Integer start, Integer limit, String cplx, String cpbh,String jyyj) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpbh!=null && !("").equals(cpbh)){
			str+=" and a.cpbh='"+cpbh+"'";
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'";
		}
		String sql="select count(*) as cnt from (select a.jyyj from y_jy_zxxx a left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+" group by a.jyyj)";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检验项目查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getJyxm(Integer start, Integer limit, String cplx, String cpbh, String jyyj) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpbh!=null && !("").equals(cpbh)){
			str+=" and a.cpbh='"+cpbh+"'";
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'";
		}
		
		String sql ="SELECT XX.jyyj,XX.jcxm,XX.dybztkh,XX.ggxh,XX.ypsl,XX.jcfy,XX.jyzq,XX.yzzrd,XX.yzz,XX.gpzz,XX.gjzz,XX.yspzz,XX.hjyq,XX.sbbh,XX.sbmc,XX.ry FROM "
				+ "( SELECT X.jyyj,X.jcxm,X.dybztkh,X.ggxh,X.ypsl,X.jcfy,X.jyzq,X.yzzrd,X.yzz,X.gpzz,X.gjzz,X.yspzz,X.hjyq,X.sbbh,X.sbmc,X.ry,ROWNUM AS RN FROM "
				+ "( select a.jyyj,a.jcxm,a.dybztkh,a.ggxh,a.ypsl,a.jcfy,a.jyzq,a.yzzrd,a.yzz,a.gpzz,a.gjzz,a.yspzz,a.hjyq,a.sbbh,a.sbmc,a.ry "
				+ "from y_jy_zxxx a left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+") X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 获取检验项目List
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 */
	public List<Map<String, Object>> getJyxmList(Integer start, Integer limit, String cplx, String cpbh,String jyyj,String jyxm) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpbh!=null && !("").equals(cpbh)){
			str+=" and a.cpbh='"+cpbh+"'";
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'";
		}
		if(jyxm!=null && !("").equals(jyxm)){
			str+=" and a.jcxm like '%"+jyxm+"%'";
		}
		String sql ="SELECT XX.jyyj,XX.jyxmbh,XX.jcxm,XX.dybztkh,XX.ggxh,XX.ypsl,XX.jcfy,XX.jldw,XX.jyzq,XX.yzzrd,XX.yzz,XX.gpzz,XX.gjzz,XX.yspzz,XX.hjyq,XX.sbbh,XX.sbmc,XX.ry,XX.bz FROM "
				+ "( SELECT X.jyyj,X.jyxmbh,X.jcxm,X.dybztkh,X.ggxh,X.ypsl,X.jcfy,X.jldw,X.jyzq,X.yzzrd,X.yzz,X.gpzz,X.gjzz,X.yspzz,X.hjyq,X.sbbh,X.sbmc,X.ry,X.bz,ROWNUM AS RN FROM "
				+ "( select a.jyyj,a.jyxmbh,a.jcxm,a.dybztkh,a.ggxh,a.ypsl,a.jcfy,a.jldw,a.jyzq,a.yzzrd,a.yzz,a.gpzz,a.gjzz,a.yspzz,a.hjyq,a.sbbh,a.sbmc,a.ry,a.bz "
				+ "from y_jy_zxxx a left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+") X "
				+ "WHERE ROWNUM <="+limit+") XX WHERE RN >"+start;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 获取信息条数
	 * @author wangyogn
	 * @date 2016年6月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Map<String,Object>> getJyxmCount(Integer start, Integer limit, String cplx, String cpbh,String jyyj,String jyxm) {
		String str="";
		if(cplx!=null && !("").equals(cplx)){
			str+=" and a.cplx like '%"+cplx+"%'";
		}
		if(cpbh!=null && !("").equals(cpbh)){
			str+=" and a.cpbh='"+cpbh+"'";
		}
		if(jyyj!=null && !("").equals(jyyj)){
			str+=" and a.jyyj like '%"+jyyj+"%'";
		}
		if(jyxm!=null && !("").equals(jyxm)){
			str+=" and a.jcxm like '%"+jyxm+"%'";
		}
		String sql="select count(*) as cnt from ( select a.jyyj,a.jcxm,a.dybztkh,a.ggxh,a.ypsl,a.jcfy,"
				+ "a.jyzq,a.yzzrd,a.yzz,a.gpzz,a.gjzz,a.yspzz,a.hjyq,a.sbbh,a.sbmc,a.ry,a.bz from y_jy_zxxx a "
				+ "left join sys_zzjg c on c.bmbh=a.ksbh where 1=1 "+str+")";
		return jdbcTemplate.queryForList(sql);
	}
	
}
