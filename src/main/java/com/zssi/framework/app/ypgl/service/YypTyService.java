package com.zssi.framework.app.ypgl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.dao.YypTyDao;
import com.zssi.framework.app.ypgl.model.YypTy;

@Service
public class YypTyService extends BaseBO<YypTyDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YypTyDao dao;
	
	/**
	 * 后台：样品退样列表
	 * @author duanpeijun
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getTyList(Integer start,Integer limit,String code){
		return dao.getTyList(start, limit, code);
	}
	
	/**
	 * 保存
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param entity
	 */
	@Transactional
	public void save(YypTy entity) {
		dao.save(entity);
	}
	
	/**
	 * 删除
	 * @author duanpeijun
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
}
