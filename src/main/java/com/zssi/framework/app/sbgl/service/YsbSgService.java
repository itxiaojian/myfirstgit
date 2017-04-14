package com.zssi.framework.app.sbgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.dao.YsbSgDao;
import com.zssi.framework.app.sbgl.model.YsbSg;


@Service
public class YsbSgService extends BaseBO<YsbSgDao>{
	@Autowired
	private YsbSgDao ySbSgDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 后台：设备申购
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getSbsgList(Integer start,Integer limit, String code) {
		return ySbSgDao.getSbsgList(start, limit, code);
	}

	/**
	 * 保存
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void save(YsbSg entity) {
        ySbSgDao.save(entity);		
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
	public void update(YsbSg entity, String ID) {
		entity.setId(Integer.parseInt(ID));
        ySbSgDao.update(entity);		
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
		for(int i = 0; i<ids.length;i++){
			ySbSgDao.delete(ids[i]);
		}
	}
	
	/** 
	 * 下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ySbSgDao.getDicByLx(zdzl);
	}
	
	/**
	 * 设备申购修改查询
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getXg(String id){
		return ySbSgDao.getXg(id);
	}

}
