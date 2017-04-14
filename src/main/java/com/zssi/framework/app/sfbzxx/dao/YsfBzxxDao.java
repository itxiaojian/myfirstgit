package com.zssi.framework.app.sfbzxx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sfbzxx.model.YsfBzxx;


/**
 * 
 * @author liangkaidi
 * @date 2015-9-28
 */
@Repository
public class YsfBzxxDao   extends HibernateBaseDaoImpl<YsfBzxx, Integer>{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
/**
 * 查询数据
 * @author liangkaidi
 * @date 2015-12-16
 * @param start
 * @param limit
 * @param canshu
 * @return
 */
	public Pagination<Map<String, Object>> getBzxxList(Integer start,
			Integer limit, String canshu ) {

		String str = "";
		
		if (canshu  != null && !"".equals(canshu)) {
			
//			str = str+ " and a.cpmc like '%"+ canshu+ "%' or b.cplx like '%"+ canshu+ "%'";
			str=str+" and a.cpmc like '%"+ canshu+ "%' or a.cplx like '%"+ canshu+ "%'";
		}
		
		String sql =  " select a.id,a.sfbzbh,a.cpmc,a.ggxh,a.cplx from (select distinct a.id ,a.sfbzbh,a.cpmc,a.ggxh, b.cplx from y_sf_bzxx a  left join y_sf_xmxx b on a.sfbzbh = b.sfbzbh where  1 = 1 "+str+")a";
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	
	//取得产品类型
		public List<Map<String, Object>> getHymc() {
			String sql =" select a.hymc,a.hybh from y_kh_hyxx a ";
			
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
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
		 * 
		 * @author liangkaidi
		 * @date 2015-10-23
		 * @param canshu
		 * @return
		 */
		public List<Map<String,Object>> getList(String canshu){
			String str = "";
			if (canshu != null && !"".equals(canshu)) {
			}
			
//			String sql =  " select a.id ,a.sfbzbh,a.cpmc,a.ggxh,b.cplx as cplx from y_sf_bzxx a  "+ 
//					"left join y_sf_xmxx b on a.sfbzbh = b.sfbzbh where 1=1 "+str;
			String sql =  " select a.id ,a.sfbzbh,a.cpmc,a.ggxh,a.cplx from y_sf_bzxx a  where 1=1 "+str;
			
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 查询收费标准信息
		 * @author liangkaidi
		 * @date 2015-12-1
		 * @param id
		 * @return
		 */
		public List<Map<String,Object>> getbzxx(String id){
			String str = "";
			if (id != null && !"".equals(id)) {
				str=str+" and a.id ="+id;
			}
			
//			String sql =  " select a.id ,a.sfbzbh,a.cpmc,a.ggxh,b.cplx as cplx from y_sf_bzxx a  "+ 
//					"left join y_sf_xmxx b on a.sfbzbh = b.sfbzbh where 1=1 "+str;
			String sql =  " select a.id ,a.sfbzbh,a.cpmc,a.ggxh,a.cplx from y_sf_bzxx a  where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}

		
		

		/**
		 * 查询收费标准编号
		 * @author liangkaidi
		 * @date 2015-12-9
		 * @param sfbzbh
		 * @return
		 */
		public List<Map<String, Object>> getBgbhList(String sfbzbh){
			String str = "";
			if(sfbzbh!=null&&!"".equals(sfbzbh)){
				str=" and a.sfbzbh like '%" + sfbzbh + "%'";
			}
			String sql = "select a.sfbzbh from y_sf_bzxx a where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}


}
