package com.zssi.framework.app.ypgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.dao.YypLyDao;
import com.zssi.framework.app.ypgl.model.YypLy;

@Service
public class YypLyService extends BaseBO<YypLyDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YypLyDao dao;
	
	/**
	 * 后台：样品领用列表
	 * @author duanpeijun
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getLyList(Integer start,Integer limit,String code){
		return dao.getLyList(start, limit,code);
	}
	
	/**
	 * 保存
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param entity
	 */
	@Transactional
	public void save(YypLy entity) {
		dao.save(entity);
	}
	
	/**
	 * 修改
	 * @author duanpeijun
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YypLy entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
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
	
	/**
	 * 样品归还时查询改样品信息的领用数量，用于做表单校验
	 * @author wangyong
	 * @date 2015年11月29日
	 * @param start
	 * @param limit
	 * @param ypbh
	 * @return
	 */
	public List<Map<String, Object>> getYply(String ypbh){
		return dao.getYply(ypbh);
				
	}
}
