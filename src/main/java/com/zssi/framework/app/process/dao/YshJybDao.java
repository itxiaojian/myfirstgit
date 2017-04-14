package com.zssi.framework.app.process.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.model.YshJyb;

/**
 * 流程建议表dao
 * @author zhangyi
 * 2015-6-3
 */
@Repository
public class YshJybDao extends HibernateBaseDaoImpl<YshJyb, Long>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getYshJybList() {
		String hql = "select new Map(t.groupId as groupId, t.name as name) from YshJyb t";
		return this.findByHQL(hql);
	}
	
	/**
	 * 获取意见列表
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月3日 上午11:09:25 
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Object> getFirstMenu(Integer start,Integer limit) {
		String rowHql = "from YshJyb t where t.dqjb=1 order by t.px asc";
		String countHql = "select count(t.id) from YshJyb t where t.dqjb=1";
		return this.findPageByHQL(rowHql, countHql, start, limit);
	}
	
	@Transactional
	public void saveGroupInfo(YshJyb groupInfo) {
		this.saveOrUpdate(groupInfo);
	}
	
	public void updateYshJyb(Long groupId, String groupName) {
		String hql = "update YshJyb t set t.name = ? where t.groupId = ?";
		this.bulkUpdate(hql, groupName, groupId);
	}

	/**
	 * 根据字典种类找出子字典
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月3日 下午3:38:44 
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 根据id获取审查意见
	 * @author:zhangyi 
	 * @version 创建时间：2015年11月11日 上午11:01:19 
	 * @param businessKey
	 * @return
	 */
	public List<Map<String, Object>> getYshJybListByYpbh(String businessKey) {
		String sql = "select t.id as \"id\",t.bgbh as \"bgbh\",t.shjdmc as \"shjdmc\",t.shyj as \"shyj\",t.shzt as \"shzt\",to_char(t.shsj,'YYYY-MM-dd HH24:mi:ss') as \"shsj\",t.shr as \"shr\",t.xgjdry as \"xgjdry\" from y_sh_yjb t where t.bgbh=? order by t.shsj asc ";
		return jdbcTemplate.queryForList(sql,businessKey);
	}


}
