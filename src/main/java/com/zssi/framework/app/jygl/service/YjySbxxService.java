package com.zssi.framework.app.jygl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjySbxxDao;
import com.zssi.framework.app.jygl.model.YjySbxx;

/**
 * 检验设备信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Service
public class YjySbxxService extends BaseBO<YjySbxx>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	@Autowired
	private YjySbxxDao dao;
	
	/**
	 * 后台：检验设备信息
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getJysbxxList(Integer start,Integer limit,String canshu){
		return dao.getJysbxxList(start, limit, canshu);
	}
	
	/**
	 * 增加
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 */
//	@Transactional
//	public void save(YjySbxx entity) {
//		dao.save(entity);
//	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjySbxx entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong 
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
