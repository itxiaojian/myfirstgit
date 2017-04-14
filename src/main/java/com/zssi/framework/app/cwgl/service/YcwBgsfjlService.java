package com.zssi.framework.app.cwgl.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.likegene.framework.core.Result;
import com.zssi.framework.app.cwgl.dao.YcwBgsfjlDao;
import com.zssi.framework.app.cwgl.model.YcwBgsfjl;

/** 
 * 报告收费Service类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月11日 下午5:08:09 
 * 类说明 
 */
@Service
public class YcwBgsfjlService extends BaseBO<YcwBgsfjl> {
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwBgsfjlDao bgsfjlDao;
	
	/**
	 * 查询出要收费登记的那条报告收费内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getbgsfjl(String bgbh){
		return bgsfjlDao.getbgsfjl(bgbh);
	}
	
	/**
	 * 保存
	 * @author liusong
	 * @version 2015年9月21日下午2:53:43
	 * @param entity
	 * @return 
	 */
	@Transactional
	public Result save(YcwBgsfjl entity1) {
		bgsfjlDao.save(entity1);
		return null;
	}
	
	

}
