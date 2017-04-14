package com.zssi.framework.app.dbgl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.model.YcbLbxx;

/** 
 * 催办列表dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:36:59 
 * 类说明 
 */
	@Repository
	public class YcbLbxxDao extends HibernateBaseDaoImpl<YcbLbxx, Integer>{
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		@Autowired
		private NamedParameterJdbcPager jdbcPager;
		
		
		/** 
		 * 后台sql
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:45:36 
		 * 类说明 
		 * @param start
		 * @param limit
		 * @param code
		 * @return
		 */
		public Pagination<Map<String, Object>> getDblbList(Integer start,
				Integer limit, String code) {
			String str = "";
			if(code!=null&&!"".equals(code)){
				str=str+" and a.rwmc like '%"+ code+ "%' or a.cbr like '%"+ code+ "%'";
			}
			String sql = "  select a.id,a.bgbh,a.rwmc,to_char(a.cbsj,'YYYY-MM-dd') as cbsj,a.cbnr,"
					+ "a.cbr,a.cbzt,a.fkzt,a.fkts,a.fj from y_cb_lbxx a  where 1=1 "+str;
			
			return jdbcPager.queryPage(sql, start, limit);
		}
		
		/**
		 * 下拉框字段查询
		 * @author liusong
		 * @date 2015年10月9日
		 * @return
		 */
		public List<Map<String, Object>> getDicByLx(String zdzl) {
			String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		public List<Map<String, Object>> getDicByLx1(String zdzl) {
			String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
}
