package com.zssi.framework.app.ypgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.dao.YypWsdjfhDao;
import com.zssi.framework.app.ypgl.model.YypWsdjfh;

@Service
public class YypWsdjfhService extends BaseBO<YypWsdjfh>{
	
	@Autowired
	private YypWsdjfhDao dao;
	
	
	/**
	 * 后台：样品预登记信息
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @param bgbh
	 * @return
	 */
	public Pagination<Map<String, Object>> getYpWsdxxList(Integer start,Integer limit,String canshu,String bgbh){
		
		return dao.getYpWsdxxList(start, limit, canshu,bgbh);
		
	}

	/**
	 * 更新预登记表状态
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param id
	 */
	@Transactional
	public void update(String id) {
		YypWsdjfh wsd=dao.get(Integer.parseInt(id));
		wsd.setYpjyzt(1);
		dao.update(wsd);
	}
	
	/**
	 * 获取实体类
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param id
	 * @return
	 */
	@Transactional
	public YypWsdjfh getEntity(String id){
		return dao.get(Integer.parseInt(id));
	}
	
	/**
	 * 获取字号
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @return
	 */
	public List<Map<String,Object>> getZh(){
		return dao.getZh();
	}
}
