package com.zssi.framework.app.dagl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dagl.model.YdaXx;

/** 
 * 档案信息dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:34:36 
 * 类说明 
 */
@Repository
public class YdaXxDao extends HibernateBaseDaoImpl<YdaXx, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 档案信息分页查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public Pagination<Map<String, Object>> getDaXxList(Integer start,
			Integer limit, String code) {
		String str = "";
		if(code!=null&&!"".equals(code)){
			str=str+" and a.dabt like '%"+ code+ "%' or a.dagjz like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.dabt,a.dagjz,a.dalx,a.sslmid,a.lmmc,a.damj,a.ssjgid,a.gdnr,"
				+ "a.fjid,a.bgqx,a.gdr,a.kckrid,a.kckrxm,a.sfqd,a.bz,b.ysjlsjm,b.bz as bbz from y_da_xx a "
				+ "left join y_jy_ysjlgl b on a.sslmid = b.bgbh  where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/** 
	 * 传参id的list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getDa(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id ="+id;
		}
		String sql = "  select a.id,a.dabt,a.dagjz,a.dalx,a.sslmid,a.lmmc,a.damj,a.ssjgid,a.gdnr,"
				  + "a.fjid,a.bgqx,a.gdr,a.kckrid,a.kckrxm,a.sfqd,a.bz from y_da_xx a  where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 档案类型（数据字典）
	 * @author liusong
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByJylx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 档案信息用于jsp查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String sql = "  select a.id,a.dabt,a.dagjz,a.dalx,a.sslmid,a.lmmc,a.damj,a.ssjgid,a.gdnr,"
				+ "a.fjid,a.bgqx,a.gdr,a.kckrid,a.kckrxm,a.sfqd,a.bz from y_da_xx a  where 1=1 ";
		return jdbcTemplate.queryForList(sql);
	}
	
	public void deleteJsfwXyxx(Integer id){
		String sql = "delete from y_da_xx where id="+id;
				jdbcTemplate.execute(sql);
	}

}
