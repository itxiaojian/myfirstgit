package com.zssi.framework.app.jygl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.jygl.dao.YjyBgzhDao;
import com.zssi.framework.app.jygl.model.YjyBgzh;

/**
 * 报告整合
 * @author duanpeijun
 * @date 2015年11月24日
 */
@Service
public class YjyBgzhService extends BaseBO<YjyBgzh>{

	@Autowired
	private YjyBgzhDao dao;
	/**
	 * 根据检验信息ID查询该表所有数据
	 * @author duanpeijun
	 * @date 2015年11月30日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyBgzh getBgzhById(Integer id) {
		YjyBgzh entity = dao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
}
