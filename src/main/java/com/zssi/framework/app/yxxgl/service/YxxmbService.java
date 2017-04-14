package com.zssi.framework.app.yxxgl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.likegene.framework.core.Result;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.yxxgl.dao.YxxmbDao;
import com.zssi.framework.app.yxxgl.model.Yxxmb;
/**
 * 主页--嘻嘻管理
 * @author Administrator
 *
 */
@Service
public class YxxmbService extends BaseBO<YxxmbDao> {
	
	@Autowired
	private YxxmbDao yxxmbDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	/**
	 * 功能--消息详细信息
	 * @author mabiao
	 * @version 2015年10月9日下午3:33:38
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYxxmbList(Integer start, Integer limit,String code){
		return yxxmbDao.getYxxmbList(start, limit, code);
	}
	
	/**
	 * 功能--添加
	 * @author mabiao
	 * @version 2015年10月9日下午4:29:02
	 * @param entity
 	*/
	@Transactional
	public void save(Yxxmb entity){
		yxxmbDao.save(entity);
	}
	
	/**
	 * 功能--修改
	* @author mabiao
	* @version 2015年10月9日下午4:29:32
	* @param entity
	* @param id
	*/
	@Transactional
	public void update(Yxxmb entity,String id){
		entity.setId(Integer.parseInt(id));
		yxxmbDao.update(entity);
	}
	
	/**
	 * 功能--删除
	 * @author mabiao
	 * @version 2015年10月9日下午4:29:56
	 * @param ids
	 */
	@Transactional
	public void delete(Integer... ids){
		for (int i = 0; i < ids.length; i++) {
			yxxmbDao.delete(ids[i]);
		}
	}
	
	/**
	 * 功能--消息类型（数据字典）
	 * @author mabiao
	 * @date 2015年10月10日上午10:57:29
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByLx(String xxlx) {
		return yxxmbDao.getDicByLx(xxlx);
	}
}
