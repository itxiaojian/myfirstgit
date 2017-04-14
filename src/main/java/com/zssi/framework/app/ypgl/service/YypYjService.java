package com.zssi.framework.app.ypgl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.dao.YypYjDao;
import com.zssi.framework.app.ypgl.model.YypYj;

@Service
public class YypYjService extends BaseBO<YypYjDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YypYjDao dao;
	
	/**
	 * 查询样品移交列表
	 * @author wangyong
	 * @date 2016年3月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYjList(Integer start,Integer limit,String code){
		return dao.getYjList(start, limit, code);
	}
	
	/**
	 * 查询getYpxxList
	 * @author wangyong
	 * @date 2016年3月10日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getYpxxList(Integer start,Integer limit,String canshu){
		return dao.getYpxxList(start, limit, canshu);
	}
	
	/**
	 * 保存
	 * @author wangyong
	 * @date 2016年3月9日
	 * @param entity
	 */
	@Transactional
	public void save(YypYj entity) {
		dao.save(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2016年3月9日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
}
