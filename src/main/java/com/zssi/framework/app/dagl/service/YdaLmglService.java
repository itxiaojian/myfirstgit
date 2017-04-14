package com.zssi.framework.app.dagl.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dagl.dao.YdaLmglDao;
import com.zssi.framework.app.dagl.model.YdaLmgl;
import com.zssi.framework.app.khgl.model.YkhHyxx;

/** 
 * 档案类目管理service层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:34:08 
 * 类说明 
 */
@Service
public class YdaLmglService extends BaseBO<YdaLmglDao>{
	
	@Autowired
	private YdaLmglDao ydaLmglDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	@Transactional
	public Pagination<Map<String, Object>> getDaLmglList(Integer start,
			Integer limit, String code) {
		return ydaLmglDao.getDaLmglList(start, limit, code);
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
	public void save(YdaLmgl entity) {
		ydaLmglDao.save(entity);
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
	public void update(YdaLmgl entity, String id) {
		entity.setId(Integer.parseInt(id));
		ydaLmglDao.update(entity);
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
			ydaLmglDao.delete(ids[i]);
		}
	}

//	报告归档时查询档案类目
	@Transactional
	public List<Map<String, Object>> getDaLm(String lmmc) {
		return ydaLmglDao.getDaLm(lmmc);
	}

//	点击选择后查出改id下类目信息并返回页面
	@Transactional
	public List<Map<String, Object>> getDalmById(Integer id) {
		return ydaLmglDao.getDalmById(id);
	}

	/**
	 * 点击修改拉取内容
	 * 
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param id
	 * @return
	 */

	@Transactional
	public YdaLmgl getXg(String id){
		return ydaLmglDao.get(Integer.parseInt(id));
	}

}
