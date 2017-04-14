package com.zssi.framework.app.process.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.dao.YshJybDao;
import com.zssi.framework.app.process.model.YshJyb;
import com.zssi.framework.app.ypgl.model.YypYpxx;

/**
 * 流程建议表service
 * @author zhangyi
 * 2015-06-03
 */
@Service
public class YshJybService {

	@Autowired
	private YshJybDao zdycdDao;
	
	@Transactional
	public List<Map<String, Object>> getYshJybList() {
		return zdycdDao.getYshJybList();
	}
	
	/**
	 * 分页查询
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Object> getJyList(Integer start,Integer limit) {
		return zdycdDao.getFirstMenu(start, limit);
	}

	/**
	 * 保存
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月4日 上午9:28:47 
	 * @param yshJyb
	 * @return
	 */
	@Transactional
	public String save(YshJyb yshJyb) {
		Long re = zdycdDao.save(yshJyb);
		return "1";
	}
	
	/**
	 * 修改
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月4日 上午9:29:41 
	 * @param entity
	 * @return
	 */
	@Transactional
	public String update(YshJyb entity) {
		YshJyb yshJyb = zdycdDao.get(Long.parseLong(entity.getId().toString()));
		zdycdDao.update(yshJyb);
		return "1";
	}

	/**
	 * 删除
	 * @author:zhangyi 
	 * @version 创建时间：2015年6月4日 上午10:17:03 
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		zdycdDao.delete(id);
	}
	
	/**
	 * 查询检验任务分配时间
	 * @author duanpeijun
	 * @date 2016年1月16日
	 * @param businessKey
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getshsj(String businessKey){
		return zdycdDao.getYshJybListByYpbh(businessKey);
	}

}
