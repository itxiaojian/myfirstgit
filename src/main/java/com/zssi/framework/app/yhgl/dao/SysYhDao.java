package com.zssi.framework.app.yhgl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.yhgl.model.SysYhxx;

/** 
 * 用户管理dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:07:19 
 * 类说明 
 */
@Repository
public class SysYhDao extends HibernateBaseDaoImpl<SysYhxx, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
// 可以查询最后登录时间的sql
//	public Pagination<Map<String, Object>> getSysyhList(Integer start, Integer limit,String code){
//		
//		String str = "";
//		if(code!=null&&!"".equals(code)){
//			str=str+" and a.dlm like '%"+ code+ "%' or a.xm like '%"+ code+ "%'";
//		}
//		String sql = "  select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh,a.yx,a.yhzt,a.cyzt,a.sgzbh,a.xb,"
//				+ "to_char(a.zhdlsj,'YYYY-MM-dd') as zhdlsj,to_char(a.sr,'YYYY-MM-dd') as sr,"
//				+ "a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm,a.mz,a.bm,a.yhpxh,a.glfw,a.qq,a.bmmc,to_char(b.oper_date,'yyyy-mm-dd hh24:mi:ss') as oper_date from sys_yh a "
//				+ "left join sys_log b on a.dlm = b.user_id  where b.oper_date in (select max(oper_date) from sys_log group by user_id)  "+str;
//		
//		return jdbcPager.queryPage(sql, start, limit);
//	}

	/** 
	 * 系统用户信息分页查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
public Pagination<Map<String, Object>> getSysyhList(Integer start, Integer limit,String code){
	
	String str = "";
	if(code!=null&&!"".equals(code)&&!"admin".equals(code)){
		str=str+" and (a.dlm like '%"+ code+ "%' or a.xm like '%"+ code+ "%' )";
	}
	String sql = " select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh,a.yx,a.yhzt,a.cyzt,a.sgzbh,a.xb,a.mz,a.bm,a.yhpxh,a.glfw,c.bmmc as jbm1,d.bmmc as jbm2,"
			+ " to_char(a.sr,'YYYY-MM-dd') as sr,a.qq,a.dzqm,a.dzqmlj,a.yhjs,a.bmmc,e.bmmc as jbm3,f.bmmc as jbm4,"
			+ " a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm from sys_yh a left join sys_zzjg c on a.jbm1 = c.bmbh left join sys_zzjg d on a.jbm2 = d.bmbh"
			+ " left join sys_zzjg e on a.jbm3 = e.bmbh left join sys_zzjg f on a.jbm4 = f.bmbh where a.dlm <>'admin' and a.khfl is null "+str+" order by a.yhpxh ";
	
	return jdbcPager.queryPage(sql, start, limit);
}

public Pagination<Map<String, Object>> getYdjyhList(Integer start, Integer limit,String code){
	
	String str = "";
	if(code!=null&&!"".equals(code)&&!"admin".equals(code)){
		str=str+" and (a.dlm like '%"+ code+ "%' or a.xm like '%"+ code+ "%') ";
	}
	String sql = " select a.yhbh,a.dlm,a.xm,a.mm,a.khfl,a.bmbh,a.gwbh,a.sjh,a.yx,a.yhzt,a.cyzt,a.sgzbh,a.xb,a.mz,a.bm,a.yhpxh,a.glfw,c.bmmc as jbm1,d.bmmc as jbm2,"
			+ " to_char(a.sr,'YYYY-MM-dd') as sr,a.qq,a.dzqm,a.dzqmlj,a.yhjs,a.bmmc,e.bmmc as jbm3,f.bmmc as jbm4,"
			+ " a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm from sys_yh a left join sys_zzjg c on a.jbm1 = c.bmbh left join sys_zzjg d on a.jbm2 = d.bmbh"
			+ " left join sys_zzjg e on a.jbm3 = e.bmbh left join sys_zzjg f on a.jbm4 = f.bmbh where a.dlm <>'admin' and a.khfl is not null "+str+" order by a.dlm ";
	
	return jdbcPager.queryPage(sql, start, limit);
}

/** 
 * 系统用户信息list查询
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
public List<Map<String,Object>> getList(String code){
	String str = "";
	if(code!=null&&!"".equals(code)&&!"admin".equals(code)){
		str=str+" and (a.dlm like '%"+ code+ "%' or a.xm like '%"+ code+ "%') ";
	}
	String sql = "  select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh,a.yx,a.yhzt,a.cyzt,a.sgzbh,a.xb,"
			+ "to_char(a.zhdlsj,'YYYY-MM-dd') as zhdlsj,to_char(a.sr,'YYYY-MM-dd') as sr,"
			+ "a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm,a.mz,a.bm,a.yhpxh,a.glfw,a.qq,a.bmmc,a.dzqm from sys_yh a where a.khfl is null "+str;
	return jdbcTemplate.queryForList(sql);
}

public List<Map<String,Object>> getydjList(String code){
	String str = "";
	if(code!=null&&!"".equals(code)&&!"admin".equals(code)){
		str=str+" and (a.dlm like '%"+ code+ "%' or a.xm like '%"+ code+ "%') ";
	}
	String sql = "  select a.dlm,a.xm,a.sjh,a.yx,a.khfl,a.yhzt,to_char(a.sr,'YYYY-MM-dd') as sr,a.qq from sys_yh a where a.khfl is not null "+str;
	return jdbcTemplate.queryForList(sql);
}


/**
 * 
 * 查询人员信息
 * @author liusong
 * @date 2015年10月9日
 * @return
 */
public List<Map<String, Object>> getKckr(String xm,String bmmc) {
	String str = "";
	if ((xm!=null&&!"".equals(xm)) && (bmmc!=null&&!"".equals(bmmc))) {
		str = "and a.xm like '%" + xm +"%' and a.bmmc like '%" + bmmc + "%'";
	}else if((xm!=null&&!"".equals(xm))) {
		str = "and a.xm like '%" + xm +"%'";
	}else if((bmmc!=null&&!"".equals(bmmc))){
		str = "and a.bmmc like '%" + bmmc + "%'";
	}
	String sql = "  select a.yhbh,a.xm,a.bmmc from sys_yh a  where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

//报告归档查询人员姓名
public List<Map<String, Object>> getKckrById(Integer yhbh) {
	String str = "";
	if (yhbh != null && !"".equals(yhbh)) {
		str=str+" and a.yhbh = "+ yhbh;
	}
	String sql = "  select a.xm from sys_yh a  where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/** 
 * 下拉框数据字典查询
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
public List<Map<String, Object>> getDicByLx(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}
/**
 * 查询用户资料
 * @author liangkaidi
 * @date 2015-11-30
 * @param code
 * @return
 */
public List<Map<String, Object>> getYh(String code) {
	
	String str = "";
	if (code != null && !"".equals(code)) {
		str=str+" and a.xm like '%"+ code+ "%'";
	}
	 SysYh yh =AppUtil.getCurrentUser();
	
	String sql="select a.yhbh,a.dlm,a.xm,a.bmbh,a.gwbh,a.sjh,a.yx from sys_yh a where xm!= '"+yh.getXm()+"'" +str;
	
	return jdbcTemplate.queryForList(sql);
	
}

public List<Map<String, Object>> getYhCs(String code) {
	String str = "";
	if (code != null && !"".equals(code)) {
		str=str+" and a.xm like '%"+ code+ "%'";
	}
	String sql = "  select a.yhbh,a.dlm,a.xm,a.bmbh,a.gwbh,a.sjh,a.yx from sys_yh a  where 1=1  "+ str;
	
	return jdbcTemplate.queryForList(sql);
}

public List<Map<String, Object>> getYhb(String code) {
	String str = "";
	if (code != null && !"".equals(code)) {
		str=str+" and a.xm like '%"+ code+ "%'";
	}
	String sql = "  select a.yhbh,a.dlm,a.xm,a.bmbh,a.gwbh,a.sjh,a.yx from sys_yh a  where 1=1  "+ str;
	
	return jdbcTemplate.queryForList(sql);
}

/**
 * 查询部门编号
 * @author liusong
 * @version 2015年9月21日下午2:10:45
 * @param id
 */
public List<Map<String, Object>> getbmbh(String bmmc) {
	String sql = "";
	if (bmmc != null && !"".equals(bmmc)) {
		sql = "select a.bmbh from sys_zzjg a where a.bmmc like '%"+ bmmc+ "%'";
		return jdbcTemplate.queryForList(sql);
	}
	return null;
}

/**
 * 查看图片
 * @author liusong
 * @date 2015年12月20日
 * @return
 */
public List<Map<String, Object>> getImageList(String yhbh) {
	String sql = "select a.dzqm,a.dzqmlj,a.yhjs from sys_yh a where 1=1 and a.yhbh = '"+yhbh+"'";
	return jdbcTemplate.queryForList(sql);
}

/**
 * 删除
 * @author liusong
 * @version 2015年9月21日下午2:10:45
 * @param id
 */
	public void delete(String yhbh){
		String sql = "delete from sys_yh where yhbh = '"+yhbh+"'";
				jdbcTemplate.execute(sql);
	}

	/**
	 * 已存在用户进行修改时查询电子签名有关的三个字段
	 * @author liusong
	 * @version 2015年9月21日下午2:10:45
	 * @param id
	 */
public List<Map<String, Object>> getDzqm(String yhbh) {
	String sql = "select a.dzqm from sys_yh a where 1=1 and a.yhbh ='"+yhbh+"'";
	return jdbcTemplate.queryForList(sql);
	
}

public List<Map<String, Object>> getDzqmlj(String yhbh) {
	String sql = "select a.dzqmlj from sys_yh a where 1=1 and a.yhbh ='"+yhbh+"'";
	return jdbcTemplate.queryForList(sql);
	}

public List<Map<String, Object>> getYhjs(String yhbh) {
	String sql = "select a.yhjs from sys_yh a where 1=1 and a.yhbh ='"+yhbh+"'";
	return jdbcTemplate.queryForList(sql);
}

/**
 * 档案信息查询用户
 * @author liangkaidi
 * @date 2016-1-8
 * @param id
 * @return
 */
public List<Map<String, Object>> getrydaxx(String yhbh) {
	String str = "";
	
	if (yhbh != null && !"".equals(yhbh)) {
		
		str=str+" and a.yhbh like '%"+ yhbh+ "%' ";
	}
	 String sql=" select a.yhbh,a.dlm,a.xm,a.mm,a.bmbh,a.gwbh,a.sjh," +
	 		"a.yx,to_char(a.zhdlsj,'YYYY-MM-dd') as zhdlsj,a.yhzt,a.cyzt,a.sgzbh,a.xb,to_char(a.sr,'YYYY-MM-dd') as sr," +
	 		"a.lxdh,a.zw,a.jtdz,a.xl,a.byyx,a.zzmm,a.mz,a.bm," +
	 		"a.yhpxh,a.glfw,a.qq,a.bmmc,a.dzqm,a.yhjs,a.xzsj,a.dzqmlj,a.dafj from sys_yh a where 1=1"+str;
	 return jdbcTemplate.queryForList(sql);
}


}
