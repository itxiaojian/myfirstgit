package com.zssi.framework.app.wxpt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.wxpt.dao.WfwXgxxDao;
import com.zssi.framework.app.wxpt.dao.WglXgxxDao;


/**
*微服务
@Author oufeng	
@Date 2015年12月15日 上午10:55:51
@Version 1.0
*/
@Service
public class WfwXgxxService {

	@Autowired
	private WfwXgxxDao  wfwXgxxdao;
	
	/**
	 * 获取报告信息
	 * @param mpnewsId
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getBgxx(String bgbh,String openId){
	       return 	wfwXgxxdao.getBgxx(bgbh,openId);
	}
	
	/**
	 * 获取报告详情
	 * @param mpnewsId
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getBgxxXq(String id){
	       return 	wfwXgxxdao.getBgxxXq(id);
	}
}

