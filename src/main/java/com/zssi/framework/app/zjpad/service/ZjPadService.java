package com.zssi.framework.app.zjpad.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.zjpad.dao.ZjPadDao;

/** 
 * pad端service类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:06:59 
 * 类说明 
 */
@Service
public class ZjPadService extends BaseBO<ZjPadDao>{
	
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private ZjPadDao dao;
	/**
	 * 根据当前登陆用户取得该用户的待办任务列表,包括流程直接分配到个人的和分配到组未签收的
	 * 新的查询方法
	 * liusong 2016-04-20
	 */
	@Transactional
	public List<Map<String, Object>> getPendPoolList(String cxtj,String ypcs){
		
		List<Map<String, Object>> list = dao.getPendPoolList(cxtj,ypcs);
		
		Cache cache = this.cacheManager.getCache("resources");
		cache.put("getPendPoolList", list);
	   return list;
	}
	@Transactional
	public List<Map<String,Object>> getBgsf(){
		return dao.getBgsf();
	}
	@Transactional
	public List<Map<String,Object>> getYwkssf(){
		return dao.getYwkssf();
	}

}
