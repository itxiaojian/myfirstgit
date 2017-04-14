package com.zssi.framework.app.wxuser.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.model.WxGroupInfo;

@Repository
public class WxGroupDao extends HibernateBaseDaoImpl<WxGroupInfo, Long>{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getWxGroupList() {
		String hql = "select new Map(t.groupId as groupId, t.name as name) from WxGroupInfo t";
		return this.findByHQL(hql);
	}
	
	public Pagination<Object> getWxGroupPaging(Integer start,Integer limit) {
		String rowHql = "from WxGroupInfo t ";
		String countHql = "select count(t.groupId) from WxGroupInfo t";
		return this.findPageByHQL(rowHql, countHql, start, limit);
	}
	
	@Transactional
	public void saveGroupInfo(WxGroupInfo groupInfo) {
		this.saveOrUpdate(groupInfo);
	}
	
	public void updateWxGroupInfo(Long groupId, String groupName) {
		String hql = "update WxGroupInfo t set t.name = ? where t.groupId = ?";
		this.bulkUpdate(hql, groupName, groupId);
	}
}
