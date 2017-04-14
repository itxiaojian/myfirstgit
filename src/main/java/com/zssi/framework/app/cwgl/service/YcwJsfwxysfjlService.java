package com.zssi.framework.app.cwgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.likegene.framework.core.Result;
import com.zssi.framework.app.cwgl.dao.YcwJsfwxysfjlDao;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysfjl;

//技术服务协议收费
//liusong 2012-12-24
@Service
public class YcwJsfwxysfjlService extends BaseBO<YcwJsfwxysfjl> {
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwJsfwxysfjlDao xysfjlDao;
	

	/**
	 * 查询出要收费登记的那条报告收费记录内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getxysfjl(String xybh){
		return xysfjlDao.getxysfjl(xybh);
	}
	
	/**
	 * 保存
	 * @author liusong
	 * @version 2015年9月21日下午2:53:43
	 * @param entity
	 * @return 
	 */
	@Transactional
	public Result save(YcwJsfwxysfjl entity1) {
		xysfjlDao.save(entity1);
		return null;
	}

}
