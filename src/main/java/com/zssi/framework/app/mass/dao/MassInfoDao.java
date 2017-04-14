package com.zssi.framework.app.mass.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.model.WxGroupInfo;

@Repository
public class MassInfoDao extends HibernateBaseDaoImpl<WxGroupInfo, Long>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getGroupInfo() {
		//and t.CREATE_TIME >= date_sub(now() ,interval 3 day)
		String hql = "select new Map(t.groupId as groupId, t.name as groupName) from WxGroupInfo t";
		return this.findByHQL(hql);
	}
	
	public List<Map<String, Object>> getImageList() {
		String sql = "select t.SC_NAME as \"scName\",t.MEDIA_ID as \"mediaId\",b.FILE_CODE as \"fileCode\", t.CREATE_TIME as \"createTime\" from WX_SUCAI_INFO t,UNTECK_ATTACHMENT b" +
				" where t.ATTACHMENT_ID = b.id and t.SC_TYPE = 1 order by t.CREATE_TIME desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getVoiceList() {
		String sql = "select t.SC_NAME as \"scName\",t.MEDIA_ID as \"mediaId\",b.FILE_CODE as \"fileCode\", t.CREATE_TIME as \"createTime\" from WX_SUCAI_INFO t,UNTECK_ATTACHMENT b" +
				" where t.ATTACHMENT_ID = b.id and t.SC_TYPE = 2 order by t.CREATE_TIME desc";
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getVideoList() {
		String sql = "select t.SC_NAME as \"scName\",t.MEDIA_ID as \"mediaId\",b.FILE_CODE as \"fileCode\", t.CREATE_TIME as \"createTime\" from WX_SUCAI_INFO t,UNTECK_ATTACHMENT b" +
				" where t.ATTACHMENT_ID = b.id and t.SC_TYPE = 3 order by t.CREATE_TIME desc";
		return jdbcTemplate.queryForList(sql);	
	}
	
	public List<Map<String, Object>> getMpnewsList() {
		String sql = "select t.SC_NAME as \"scName\",t.MEDIA_ID as \"mediaId\", t.CREATE_TIME as \"createTime\"" +
				" from WX_SUCAI_INFO t  where t.SC_TYPE = 4 order by t.CREATE_TIME desc";
		return jdbcTemplate.queryForList(sql);	
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getUserByGroup(Long groupId) {
		String hql = "select new Map(t.openid as openid, t.nickname as nickname) from WxUserInfo t where t.groupId=?";
		return this.findByHQL(hql,groupId);
	}

}
