package com.zssi.framework.app.dagl.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dagl.dao.YdaBgqxDao;
import com.zssi.framework.app.dagl.dao.YdaLmglDao;
import com.zssi.framework.app.dagl.model.YdaBgqx;
import com.zssi.framework.app.dagl.model.YdaLmgl;

/** 
 * 档案保管期限service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午6:51:58 
 * 类说明 
 */
@Service
public class YdaBgqxService extends BaseBO<YdaBgqxDao>{
	
	@Autowired
	private YdaBgqxDao ydaBgqxDao;
	@Autowired
	private YdaLmglDao ydaLmglDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	@Transactional
	public Pagination<Map<String, Object>> getDaBgqxList(Integer start,
			Integer limit, String code) {
		return ydaBgqxDao.getDaBgqxList(start, limit, code);
	}
	
	/**
	 * 档案保管期限下拉菜单
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ydaBgqxDao.getDicByLx(zdzl);
	}
	
	@Transactional
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return ydaBgqxDao.getDicByLx(zdzl);
	}

	/**
	 * 保存
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void save(YdaBgqx entity) {
		ydaBgqxDao.save(entity);
	}

	/**
	 * 更新
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void update(YdaBgqx entity, String id) {
		entity.setId(Integer.parseInt(id));
		ydaBgqxDao.update(entity);
	}

	/**
	 * 删除
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ydaBgqxDao.delete(ids[i]);
		}
	}
/**
 * 
 * @author liangkaidi
 * @date 2015-12-23
 * @param id
 * @return
 */
	@Transactional
	public List<Map<String, Object>> getXg(String id){
		return ydaBgqxDao.getXg(id);
	}

/**
	 * （数据字典）
	 * @author liangkaidi
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>>getDicByList(String zdzl) {
		return ydaBgqxDao.getDicByList(zdzl);
	}

@Transactional
	public List<Map<String, Object>> getLmmc(String code) {
		return ydaLmglDao.getLmmc(code);
	}

}

