package com.zssi.framework.app.ypgl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.dao.YypGhDao;
import com.zssi.framework.app.ypgl.model.YypGh;

@Service
public class YypGhService extends BaseBO<YypGhDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YypGhDao dao;
	
	/**
	 * 后台：样品归还
	 * @author duanpeijun
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getGhList(Integer start,Integer limit,String code){
		return dao.getGhList(start, limit,code);
	}
	
	/**
	 * 保存
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param entity
	 */
	@Transactional
	public void save(YypGh entity) {
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
