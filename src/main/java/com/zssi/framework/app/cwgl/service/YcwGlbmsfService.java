package com.zssi.framework.app.cwgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.dao.YcwGlbmsfDao;
import com.zssi.framework.app.cwgl.model.YcwGlbmsf;

//管理部门收费service
//liusong 2015-12-24
@Service
public class YcwGlbmsfService extends BaseBO<YcwGlbmsf> {
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwGlbmsfDao glbmsfDao;
	

//	EXT分页查询
	@Transactional
	public Pagination<Map<String, Object>> getGlbmsfList(Integer start,Integer limit,String code,String bmbh){
		return glbmsfDao.getGlbmsfList(start, limit, code,bmbh);
		
	}
	/**
	 * jsp中点击修改拉取内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getGlsf(String id){
//		System.out.println("service层获取到的id是: " + id);
//		System.out.println(glbmsfDao.getGlsf(id));
		return glbmsfDao.getGlsf(id);
	}
	
	/**
	 * 修改
	 * @author liusong
	 * @version 2015年9月21日下午2:54:11
	 * @param entity
	 * @param id 主键ID
	 */
	@Transactional
	public void update(YcwGlbmsf entity,String id){
		entity.setId(Integer.parseInt(id));
		glbmsfDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			glbmsfDao.delete(ids[i]);
		}
	}
}
