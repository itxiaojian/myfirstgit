package com.zssi.framework.app.yrwgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.yrwgl.dao.YrwWdrwDao;
import com.zssi.framework.app.yrwgl.model.YrwWdrw;
/**
 * 功能--我的任务
 * @author Administrator
 *
 */
@Service
public class YrwWdrwService extends BaseBO<YrwWdrw> {
	
	@Autowired
	private YrwWdrwDao yrwWdrwDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	

	
	/**
	 * 功能--我的任务详细信息
	 * @author mabiao
	 * @version 2015年10月12日下午3:33:38
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYrwWdrwList(Integer start, 
			Integer limit, String code1, String code2, String code3, String code4){
		return yrwWdrwDao.getYrwWdrwList(start, limit, code1, code2, code3, code4);
	}
	
	/**
	 * 功能--修改
	* @author mabiao
	* @version 2015年10月12日下午4:29:32
	* @param entity
	* @param id
	*/
	@Transactional
	public void update(YrwWdrw entity,String id){
		entity.setId(Integer.parseInt(id));
		yrwWdrwDao.update(entity);
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
			yrwWdrwDao.delete(ids[i]);
		}
	}
	
	/**
	 * 数据字典--任务类型
	 * @param xxlx
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String rwlx) {
		return yrwWdrwDao.getDicByLx(rwlx);
	}
	/**
	 * 微信平台我的任务查询
	 * @author panweichi
	 * @date 2015年11月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getWd(){
		return yrwWdrwDao.getYrwWdrwList1(null);
	}
	
	/**
	 * 微信平台样品信息详情查询
	 * @author panweichi
	 * @date 2015年11月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getWd1(String id){
		return yrwWdrwDao.getYrwWdrwList2(id);
	}
	/**
	 * 微管理————我的任务搜索
	 * @author panweichi
	 * @date 2015年11月23日
	 * @param search    设备名称
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getWdrw(String search){
		return yrwWdrwDao.getWdrw(search);
	}

}
