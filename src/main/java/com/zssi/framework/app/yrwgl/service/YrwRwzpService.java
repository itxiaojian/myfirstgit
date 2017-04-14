package com.zssi.framework.app.yrwgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.yrwgl.dao.YrwRwzpDao;
import com.zssi.framework.app.yrwgl.model.YrwRwzp;
/**
 * 功能--我的任务
 * @author Administrator
 *
 */
@Service
public class YrwRwzpService extends BaseBO<YrwRwzp> {
	
	@Autowired
	private YrwRwzpDao yrwRwzpDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 功能--任务自拍详细信息
	 * @author mabiao
	 * @version 2015年10月12日下午3:33:38
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYrwRwzpList(Integer start, 
			Integer limit, String code1, String code2, String code3){
		return yrwRwzpDao.getYrwRwzpList(start, limit, code1, code2, code3);
	}
	
	/**
	 * 功能--指派人选择
	 * @param start
	 * @param limit
	 * @param code1
	 * @param code2
	 * @return
	 */
	public Pagination<Map<String, Object>> getRwZprList(Integer start,
			Integer limit,String code1,String code2){
		return yrwRwzpDao.getRwZprList(start, limit, code1, code2);
	}
	
	/**
	 * 功能--修改
	* @author mabiao
	* @version 2015年10月12日下午4:29:32
	* @param entity
	* @param id
	*/
	@Transactional
	public void update(YrwRwzp entity,String id){
		entity.setId(Integer.parseInt(id));
		yrwRwzpDao.update(entity);
	}
	
	/**
	 * 功能--删除
	 * @author mabiao
	 * @version 2015年10月12日下午4:29:56
	 * @param ids
	 */
	@Transactional
	public void delete(Integer... ids){
		for (int i = 0; i < ids.length; i++) {
			yrwRwzpDao.delete(ids[i]);
		}
	}
	
	/**
	 * 功能--取得实体类
	 * @param id
	 * @return
	 */
	@Transactional
	public YrwRwzp getYrwRwzpById(Integer id) {
		YrwRwzp entity = yrwRwzpDao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}	
	
	/**
	 * 数据字典--任务类型
	 * @param xxlx
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String rwlx) {
		return yrwRwzpDao.getDicByLx(rwlx);
	}
	
}
