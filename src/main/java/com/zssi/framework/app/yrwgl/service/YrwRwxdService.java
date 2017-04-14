package com.zssi.framework.app.yrwgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.yrwgl.dao.YrwRwxdDao;
/**
 * 功能--任务下达
 * @author Administrator
 *
 */
@Service
public class YrwRwxdService extends BaseBO<YrwRwxdDao> {
	
	@Autowired
	private YrwRwxdDao yrwxdDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 功能--消息管理详细信息
	 * @author mabiao
	 * @version 2015年10月12日下午3:33:38
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYrwxdList(Integer start, 
			Integer limit, String code1, String code2, String code3){
		return yrwxdDao.getYrwxdList(start, limit, code1, code2, code3);
	}
	
	/**
	 * 功能--添加
	 * @author mabiao
	 * @version 2015年10月12日下午4:29:02
	 * @param entity
 	*/
	@Transactional
	public void save(YypYpxx entity){
		yrwxdDao.save(entity);
	}
	
	/**
	 * 功能--修改
	* @author mabiao
	* @version 2015年10月12日下午4:29:32
	* @param entity
	* @param id
	*/
	@Transactional
	public void update(YypYpxx entity,String id){
		entity.setId(Integer.parseInt(id));
		yrwxdDao.update(entity);
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
			yrwxdDao.delete(ids[i]);
		}
	}
	
	/**
	 * 数据字典--任务类型
	 * @param xxlx
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String rwlx) {
		return yrwxdDao.getDicByLx(rwlx);
	}
}
