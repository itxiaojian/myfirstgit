package com.zssi.framework.app.sbgl.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.dao.YsbJdjlDao;
import com.zssi.framework.app.sbgl.model.YsbJdjl;

/** 
 * 设备检定记录service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月1日 下午8:32:37 
 * 类说明 
 */
@Service
public class YsbJdjlService extends BaseBO<YsbJdjl> {
	
	@Autowired
	private YsbJdjlDao ysbJdjlDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 后台：设备检定记录
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getSbjdjlList(Integer start,Integer limit, String code) {
		return ysbJdjlDao.getSbjdjlList(start, limit, code);
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
	public void update(YsbJdjl entity, String id) {
		entity.setId(Integer.parseInt(id));
		ysbJdjlDao.update(entity);
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
			ysbJdjlDao.delete(ids[i]);
			
		}
	}
	
	/** 
	 * 检定状态下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ysbJdjlDao.getDicByLx(zdzl);
	}
	
	/**
	 * 设备维保记录修改查询
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getJd(String id){
		return ysbJdjlDao.getJd(id);
	}
	
}
