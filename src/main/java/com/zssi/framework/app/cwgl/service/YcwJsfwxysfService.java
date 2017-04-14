package com.zssi.framework.app.cwgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.dao.YcwJsfwxysfDao;
import com.zssi.framework.app.cwgl.dao.YcwJsfwxysfjlDao;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysf;

//技术服务协议收费
//liusong 2012-12-24
@Service
public class YcwJsfwxysfService extends BaseBO<YcwJsfwxysf> {
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwJsfwxysfDao xysfDao;
	@Autowired
	private YcwJsfwxysfjlDao xysfjlDao;
	

//	ext分页查询
	@Transactional
	public Pagination<Map<String, Object>> getXysfList (Integer start,Integer limit,String code,String jyks,String ywks){
		return xysfDao.getXysfList(start, limit, code,jyks,ywks);
	}

//	技术服务协议已收费查询
	@Transactional
	public Pagination<Map<String, Object>> getXyysfList (Integer start,Integer limit,String code,String jyks,String ywks){
		System.out.println("service层"+code);
		return xysfDao.getXyysfList(start, limit, code,jyks,ywks);
	}

	/**
	 * 获取未结算的收费信息
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月24日 下午2:00:17 
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getxysf(String id){
		return xysfDao.getxysf(id);
	}
	
	/**
	 * 获取收入分类下拉框
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return xysfDao.getDicByLx(zdzl);
	}
	
	@Transactional
	public List<Map<String, Object>> getGlbm() {
		return xysfDao.getGlbm();
	}
	
	/** 
	 * 更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年12月13日 下午2:37:37 
	 * 类说明 
	 * @param entity
	 * @param id
	 * @return
	 */
	@Transactional
	public void update(YcwJsfwxysf entity,String id){
		entity.setId(Integer.parseInt(id));
		xysfDao.update(entity);
		
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
	public void delete(Integer[] ids,String[] xybh) {
		for(int i=0;i<ids.length;i++){
			xysfDao.delete(ids[i]);
			xysfjlDao.deletejl(xybh[i]);
		}
	}
	
}
