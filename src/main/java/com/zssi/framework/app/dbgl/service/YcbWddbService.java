package com.zssi.framework.app.dbgl.service; 

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.dao.YcbWddbDao;
import com.zssi.framework.app.dbgl.model.YcbWddb;

/** 
 * 我的督办service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月20日 上午10:40:00 
 * 类说明 
 */
@Service
public class YcbWddbService extends BaseBO<YcbWddb>{
	
	@Autowired
	private YcbWddbDao ydbWddbDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Transactional
	public Pagination<Map<String, Object>> getWddbList(Integer start,
			Integer limit, String code) {
				return ydbWddbDao.getWddbList(start, limit, code);
	}
	
	@Transactional
	public Pagination<Map<String, Object>> getYwdbList(Integer start,
			Integer limit, String code) {
				return ydbWddbDao.getYwdbList(start, limit, code);
	}
	
	
	/** 
	 * 更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:44:37 
	 * 类说明 
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YcbWddb entity,String id){
		entity.setId(Integer.parseInt(id));
		ydbWddbDao.update(entity);
		
	}
	
	
	/**
	 * 删除 
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:44:46 
	 * 类说明 
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ydbWddbDao.delete(ids[i]);
		}
	}
}
