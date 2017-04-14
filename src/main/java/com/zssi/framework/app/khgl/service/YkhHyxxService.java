package com.zssi.framework.app.khgl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.dao.YkhHyxxDao;
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.util.ResponseData;
/**
 * 
 * @author liangkaidi
 * @date 2015-9-22
 */

@Service
public class YkhHyxxService extends BaseBO<YkhHyxxDao> {
	
	@Autowired
	private YkhHyxxDao yKhHyxxDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	 
	public Pagination<Map<String, Object>> getHyxxList( Integer start, Integer limit,String code) {
		
	return yKhHyxxDao.getHyxxList(start, limit, code);
		
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * 增加
	 */
	@Transactional
	public void save(YkhHyxx entity) {
		yKhHyxxDao.save(entity);
	}
	/**
	 * jsp修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param id
	 * @return 
	 */
	@Transactional
	public ResponseData update(YkhHyxx entity, String id){
		entity.setId(Integer.parseInt(id));
		yKhHyxxDao.update(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * 删除
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yKhHyxxDao.delete(ids[i]);
		}
	}
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-11-9
	 * @return
	 */
	@Transactional
		public List<Map<String, Object>> getAdd(){
		return yKhHyxxDao.getJy();
	}
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面**********************************************/
	/**
	 * 修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param id
	 * @return
	 */

	
	@Transactional
	public YkhHyxx getXg(String id){
		return yKhHyxxDao.get(Integer.parseInt(id));
	}
	
	/**
	 * 行业信息增加提交
	 * @author liujiansen
	 * @date 2015年9月16日
	 * @param request
	 * @param entity 
	 * @return
	 */
	@Transactional
	public String saveRb(HttpServletRequest request, YkhHyxx entity) {
		String str="";
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		String hybh = request.getParameter("hybh");
		String hymc = request.getParameter("hymc");

		entity.setHybh(hybh);
		entity.setHymc(hymc);
		yKhHyxxDao.save(entity);
		str="0";
		return str;
	}
	
	
		@Transactional
	public List<Map<String, Object>>getHybh(String hybh) {
		return yKhHyxxDao.getHybh(hybh);
	}
		
		/**
		 * 获取下拉框查询
		 * @author liusong
		 * @date 2015年9月23日
		 * @return
		 */
		@Transactional
		public List<Map<String, Object>> getDicByLx(String zdzl) {
			return yKhHyxxDao.getDicByLx(zdzl);
		}
		
		@Transactional
		public List<Map<String, Object>> getSsfl() {
			return yKhHyxxDao.getSsfl();
		}

}
