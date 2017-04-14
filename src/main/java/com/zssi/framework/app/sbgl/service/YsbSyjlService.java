package com.zssi.framework.app.sbgl.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.dao.YsbSyjlDao;
import com.zssi.framework.app.sbgl.model.YsbSyjl;


@Service
public class YsbSyjlService extends BaseBO<YsbSyjl> {
	@Autowired
	private YsbSyjlDao ySbSyjlDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	

	/**
	 * 后台：设备使用记录
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getSbsyjlList(Integer start,Integer limit, String code) {
		return ySbSyjlDao.getSbsyjlList(start, limit, code);
	}
	
//	/**
//	 * 保存
//	 * @author liusong
//	 * @date 2015年9月23日
//	 * @param start
//	 * @param limit
//	 * @return
//	 */
//	@Transactional
//	public void save(YsbSyjl entity){
//		ySbSyjlDao.save(entity);
//	}
	
	/**
	 * 修改
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void update(YsbSyjl entity,String ID){
		entity.setId(Integer.parseInt(ID));
		ySbSyjlDao.update(entity);
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
	public void delete(Integer[] ids){
		for(int i =0;i<ids.length;i++){
			ySbSyjlDao.delete(ids[i]);
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
		return ySbSyjlDao.getDicByLx(zdzl);
	}
	
	/**
	 * 设备使用记录修改查询
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getXg(String id){
		return ySbSyjlDao.getXg(id);
	}
}
