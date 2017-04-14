package com.zssi.framework.app.dbgl.dao; 

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.model.YcbFkb;

/** 
 * 督办反馈列表dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:37:13 
 * 类说明 
 */
	@Repository
	public class YcbFkbDao extends HibernateBaseDaoImpl<YcbFkb, Integer>{
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		@Autowired
		private NamedParameterJdbcPager jdbcPager;
		
		
		/**
		 * 后台sql 
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:46:04 
		 * 类说明 
		 * @param start
		 * @param limit
		 * @param code
		 * @return
		 */
		public Pagination<Map<String, Object>> getFklbList(Integer start,
				Integer limit, String code) {
			String str = "";
			if(code!=null&&!"".equals(code)){
				str=str+" and a.cbid like '%"+ code+ "%' or a.rwmc like '%"+ code+ "%'";
			}
			String sql = "  select a.id,a.bgbh,a.cbid,a.rwmc,a.fknr,to_char(a.fksj,'YYYY-MM-dd') as fksj,a.fkr,"
					+ "a.fkzt,a.fkrid from y_cb_fkb a  where 1=1 "+str;
			
			return jdbcPager.queryPage(sql, start, limit);
		}
}
