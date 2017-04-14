package com.zssi.framework.app.rsgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.model.YrsPxjlInfo;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Repository
public class YrsPxjlInfoDao extends HibernateBaseDaoImpl<YrsPxjlInfo, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询培训记录信息
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getPxjlInfoList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.rybh like '%"+ code+ "%' or a.ryxm like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.rybh,a.ryzh,a.ryxm,b.bmmc as ks_id,a.xb,to_char(a.sr,'YYYY-MM-dd HH:mm:ss') as sr,"
				+ "a.lxdh,a.sjhm,a.jtzz,a.pxmc,a.hdzsmc,to_char(a.pxsj,'YYYY-MM-dd HH:mm:ss') as pxsj,"
				+ "a.pxnr,a.bz from y_rs_pxjl_info a "+
				 "left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询数据
	 * @author wangyong
	 * @date 2015年10月26日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.rybh like '%"+ code+ "%' or a.ryxm like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.rybh,a.ryzh,a.ryxm,b.bmmc as ks_id,a.xb,to_char(a.sr,'YYYY-MM-dd HH:mm:ss') as sr,"
				+ "a.lxdh,a.sjhm,a.jtzz,a.pxmc,a.hdzsmc,to_char(a.pxsj,'YYYY-MM-dd HH:mm:ss') as pxsj,"
				+ "a.pxnr,a.bz from y_rs_pxjl_info a "+
				 "left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	/**
	 * 查询修改数据
	 * @author liangkaidi
	 * @date 2015-11-26
	 * @param id
	 * @return
	 */

	public List<Map<String, Object>> getPxjl(Integer id) {
		String str = "";
		if(id!=null&&!"".equals(id)){
			str= str + " and a.id="+id;
		}
		String sql = "select a.id,a.rybh,a.ryzh,a.ryxm,b.bmmc as ks_id,a.xb,to_char(a.sr,'YYYY-MM-dd HH:mm:ss') as sr,"
				+ "a.lxdh,a.sjhm,a.jtzz,a.pxmc,a.hdzsmc,to_char(a.pxsj,'YYYY-MM-dd HH:mm:ss') as pxsj,"
				+ "a.pxnr,a.bz from y_rs_pxjl_info a "+
				 "left join sys_zzjg b on a.ks_id = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
/**
 * 获取用户信息
 * @author liangkaidi
 * @date 2016-1-8
 * @param code
 * @return
 */
	public List<Map<String, Object>> getYh(String code) {
		String str = "";
	
		
		if (code != null && !"".equals(code)) {
			str=str+" and a.xm like '%"+ code+ "%' or a.dlm like '%"+ code+ "%'";
		}
		SysYh yh=AppUtil.getCurrentUser();
		String sql="select a.yhbh,a.dlm,a.xm from sys_yh a where xm!= '"+yh.getXm()+"'" +str;
		return jdbcTemplate.queryForList(sql);
	}
	
/**
 * 数据字典
 * @author liangkaidi
 * @date 2016-1-8
 * @param zdzl
 * @return
 */
public List<Map<String, Object>> getDicByList(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 人员账号
 * @author liangkaidi
 * @date 2016-1-12
 * @return
 */
public List<Map<String, Object>> getBgbhList() {
	String  sql="select a.rybh from y_rs_pxjl_info a where 1=1";
	return jdbcTemplate.queryForList(sql);
}
	
}
