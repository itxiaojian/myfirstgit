package com.zssi.framework.app.process.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.model.TestProcess;

@Repository
public class TestProcessDao extends HibernateBaseDaoImpl<TestProcess, String> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Pagination<Object> getAllTestProcess(Integer start, Integer limit) {
		String rowHql = "select new Map(t.id as id,t.name as name,t.processcode as processcode,t.processStatus as processStatus) from TestProcess t";
		String countHql = "select count(t.id) from TestProcess t ";
		return this.findPageByHQL(rowHql, countHql, start, limit );
	}

	/**
	 * 获取检验人openid
	 * @author liangkaidi
	 * @date 2016-3-11
	 * @param jyry
	 * @return
	 */
			public List<Map<String, Object>> getopenId(String jyry) {
				String sql="SELECT a.wxh FROM sys_wxyh a left join sys_yh b on a.yhid=b.yhbh where b.dlm='"+jyry+"'";
				return jdbcTemplate.queryForList(sql);
			}
			
			/**
			 * 获取当前审核人员的openid
			 * @author liangkaidi
			 * @date 2016-3-11
			 * @param jyry
			 * @return
			 */
					public List<Map<String, Object>> getopenIdjyshry(String jyshry) {
						String sql="SELECT a.wxh FROM sys_wxyh a left join sys_yh b on a.yhid=b.yhbh where b.dlm='"+jyshry+"'";
						return jdbcTemplate.queryForList(sql);
					}

	public List<Map<String, Object>> getopenIdjyks(String jyks) {
		String sql = " SELECT a.wxh FROM sys_wxyh a left join sys_yh b on a.yhid=b.yhbh where b.dlm in "+
				" (select a.dlm from SYS_YH a left join SYS_YHJS b on a.yhbh=b.yhbh left join SYS_JS c on b.jsbh=c.jsbh where "+
				" a.bmbh=(select  a.jszxbh from sys_jglsgx a where  a.jyksbh='"+jyks+"') and c.jsmc='ROLE_GCJSZXPZR') ";
		return jdbcTemplate.queryForList(sql);
	}
	
}
