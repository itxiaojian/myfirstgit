package com.zssi.framework.app.tsxx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.tsxx.model.YtsXx;
import com.zssi.framework.app.util.AppUtil;
@Repository
public class YtsXxDao extends HibernateBaseDaoImpl< YtsXx, Integer>{
@Autowired
private JdbcTemplate jdbcTemplate;
@Autowired
private NamedParameterJdbcPager jdbcPager;

	


public Pagination<Map<String, Object>> getTsxxList(Integer start,Integer limit, String cs) {

	String str = "";
	if (cs != null && !"".equals(cs)) {
		
		str = str+ " and a.tsr  like '%"+ cs+ "%' or a.tslx  like '%"+ cs+ "%'";
	}
	String sql = "  select a.id,a.tsr,a.tslx,a.tsnr,a.btsr,to_char(a.tsrq,'yyyy-mm-dd HH:mm:ss') as tsrq," +
			"a.clzt,a.cljg,a.clr,to_char(a.clrq,'yyyy-mm-dd HH:mm:ss') as clrq,a.bz from y_ts_xx a  where 1=1 "+str;

	return jdbcPager.queryPage(sql, start, limit);
}

    public List<Map<String, Object>> getDicByLx(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}
    
    /**
     * 投诉页面————客户信息
     * @author liangkaidi
     * @date 2015-11-12
     * @param bgbh
     * @return
     */
    
		public List<Map<String,Object>> getYp(String khbh){
//		String str = "";
//		if(khbh !=null&&!"".equals(khbh )){
//			str=" and a.khbh='"+khbh+"'";
//		}
		String sql = "  select a.khmc from y_kh_khxx a where 1=1 ";//+str;
		return jdbcTemplate.queryForList(sql);
	}
		
		/**
		 * 数据字典中获取
		 * @author liangkaidi
		 * @date 2015-11-13
		 * @param zdzl
		 * @return
		 */
		
		public List<Map<String, Object>> getDicByList(String zdzl) {
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
				SysYh yh=AppUtil.getCurrentUser();
				if (code != null && !"".equals(code)) {
					str=str+" and a.xm like '%"+ code+ "%'";
				}
				
				String sql = "  select a.yhbh,a.dlm,a.xm,a.bmbh,a.gwbh,a.sjh,a.yx from sys_yh a  where xm!='"+yh.getXm()+"' " + str;
				return jdbcTemplate.queryForList(sql);
				
			}
		
		
}
