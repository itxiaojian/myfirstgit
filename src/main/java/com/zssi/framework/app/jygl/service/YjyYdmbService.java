package com.zssi.framework.app.jygl.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyBgmbDao;
import com.zssi.framework.app.jygl.dao.YjyYdmbDao;
import com.zssi.framework.app.jygl.model.YjyBgmb;
import com.zssi.framework.app.jygl.model.YjyYdmb;

@Service
public class YjyYdmbService extends BaseBO<YjyYdmb>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YjyYdmbDao dao;
	@Autowired
	private YjyBgmbDao yjyBgmbDao;
	
	/**
	 * 获取模板设置列表
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getYdmbList(Integer start,Integer limit,String code){
		return dao.getYdmbList(start, limit, code);
	}
	
	/**
	 * 根据ID获取该条YDMB的实体类
	 * @author duanpeijun
	 * @date 2015年12月14日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyYdmb getydmbById(Integer id) {
		YjyYdmb entity = dao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
//	/**
//	 * 增加
//	 * @author wangyong 
//	 * @date 2015年9月23日
//	 * @param entity
//	 */
//	@Transactional
//	public void save(YjyYdmb entity) {
//		dao.save(entity);
//	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjyYdmb entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}

	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015年12月9日
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYdmb(Integer id){
		return dao.getYdmb(id);
	}

		/**
	 * 查询模板List
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getmbList(){
		return dao.getmbList();
	}
	/**
   	 * 在模板名称页面上点击提交获取该条信息的数据（根据ID获取）
   	 * @author liangkaidi
   	 * @date 2015-12-17
   	 * @param string
   	 * @return
   	 */
	@Transactional
	   	public YjyBgmb getmb(String id) {
		 return yjyBgmbDao.get(Integer.parseInt(id));
		 
	}
	  
	@Transactional
	public String getBh(String zh){
		List<Map<String, Object>> list =  dao.findBh(zh);
		String bh = "";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map=(Map<String, Object>)list.get(i);
		        Iterator<String> iterator = map.keySet().iterator();
		        while (iterator.hasNext()){
		        	 String key = (String)iterator.next();
		        	 Object obj = map.get(key);
		        	 String strKey = obj.toString();
		        	 bh = strKey;
		        }
			}
		}
		System.out.println(bh);
		return bh;
	}
/**
 * 
 * @author liangkaidi
 * @date 2015-12-20
 * @param zdzl
 * @return
 */
	public List<Map<String, Object>> getDicByList(String zdzl) {
		return dao.getDicByList(zdzl);
	}
}
