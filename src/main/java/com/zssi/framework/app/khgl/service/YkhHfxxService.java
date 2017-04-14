package com.zssi.framework.app.khgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.dao.YkhHfxxDao;
import com.zssi.framework.app.khgl.model.YkhHfxx;
import com.zssi.framework.app.util.ResponseData;

//客户回访信息service
//liusong 2016-3-7

@Service
public class YkhHfxxService extends BaseBO<YkhHfxx>{
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YkhHfxxDao hfxxDao;
	
	/**
	 * 分页查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getHfzzList( Integer start, Integer limit,String code){
		return hfxxDao.getHfxxList(start, limit, code);
	}
	
	/**
	 * 查询客户信息进行选择
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getHfxx(String id){
		return hfxxDao.getHfxx(id);
	}
	
	/**
	 * 修改
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public ResponseData update(YkhHfxx entity, String id){
		entity.setId(Integer.parseInt(id));
		hfxxDao.update(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			hfxxDao.delete(ids[i]);
		}
	}

}
