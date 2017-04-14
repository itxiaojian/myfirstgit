package com.zssi.framework.app.dbgl.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.dao.YcbLbxxDao;
import com.zssi.framework.app.dbgl.model.YcbLbxx;

/** 
 * 催办列表service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:36:14 
 * 类说明 
 */
	@Service
	public class YcbLbxxService extends BaseBO<YcbLbxx>{
		
		@Autowired
		private YcbLbxxDao ydbDblbDao;
		
		@Autowired
		private Md5PasswordEncoder md5PasswordEncoder;
		
		/**
		 * 分页查询催办列表
		 * @author liusong
		 * @date 2015年10月9日
		 * @return
		 */
		@Transactional
		public Pagination<Map<String, Object>> getDblbList(Integer start,
				Integer limit, String code) {
					return ydbDblbDao.getDblbList(start, limit, code);
		}
		
		/**
		 * 下拉菜单查询
		 * @author liusong
		 * @date 2015年10月9日
		 * @return
		 */
		@Transactional
		public List<Map<String, Object>> getDicByLx(String zdzl) {
			return ydbDblbDao.getDicByLx(zdzl);
			}
		
		@Transactional
		public List<Map<String, Object>> getDicByLx1(String zdzl) {
			return ydbDblbDao.getDicByLx1(zdzl);
			}
		
		@Transactional
		public YcbLbxx getDblbById(Integer id) {
			YcbLbxx entity = ydbDblbDao.get(id);
			if(entity!=null){
				return entity;
			}
			return null;
		}
		
		/** 
		 * 更新
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:37:37 
		 * 类说明 
		 * @param entity
		 * @param id
		 * @return
		 */
		@Transactional
		public void update(YcbLbxx entity,String id){
			entity.setId(Integer.parseInt(id));
			ydbDblbDao.update(entity);
			
		}
		
		/** 
		 * 删除
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:38:24 
		 * 类说明 
		 * @param ids
		 * @return
		 */
		@Transactional
		public void delete(Integer[] ids) {
			for(int i=0;i<ids.length;i++){
				ydbDblbDao.delete(ids[i]);
			}
		}
		
		@Transactional
		public YcbLbxx get(String id){
			return ydbDblbDao.get(Integer.parseInt(id));
		}
}
