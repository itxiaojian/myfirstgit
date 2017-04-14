package com.zssi.framework.app.dbgl.service; 

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.dao.YcbFkbDao;
import com.zssi.framework.app.dbgl.model.YcbFkb;

/** 
 * 反馈列表service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:36:40 
 * 类说明 
 */
	@Service
	public class YcbFkbService extends BaseBO<YcbFkb>{
		
		@Autowired
		private YcbFkbDao ydbFklbDao;
		
		@Autowired
		private Md5PasswordEncoder md5PasswordEncoder;
		
		@Transactional
		public Pagination<Map<String, Object>> getFklbList(Integer start,
				Integer limit, String code) {
					return ydbFklbDao.getFklbList(start, limit, code);
		}
		
		
		/** 
		 * 更新
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:43:57 
		 * 类说明 
		 * @param entity
		 * @param id
		 */
		@Transactional
		public void update(YcbFkb entity,String id){
			entity.setId(Integer.parseInt(id));
			ydbFklbDao.update(entity);
			
		}
		
		
		/** 
		 * 删除
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:44:19 
		 * 类说明 
		 * @param ids
		 */
		@Transactional
		public void delete(Integer[] ids) {
			for(int i=0;i<ids.length;i++){
				ydbFklbDao.delete(ids[i]);
			}
		}
}
