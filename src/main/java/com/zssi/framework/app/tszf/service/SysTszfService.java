package com.zssi.framework.app.tszf.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.khgl.model.YkhHyxx;
import com.zssi.framework.app.kygl.model.YkyCggl;
import com.zssi.framework.app.tszf.dao.SysTszfDao;
import com.zssi.framework.app.tszf.model.SysTszf;
@Service
public class SysTszfService extends BaseBO<SysTszfDao>{
	@Autowired
	private SysTszfDao sysTszfDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	
	@Transactional
	public Pagination<Map<String, Object>> getTszfList(Integer start,
			Integer limit, String code) {
		return sysTszfDao.getTszfList(start, limit, code);
	}
	
	/**
	 * 保存
	 * @version 2015年9月21日下午2:53:43
	 * @param entity
	 */
	@Transactional
	public void save(SysTszf entity) {
		sysTszfDao.save(entity);
	}
	
	
	
	@Transactional
	public String update(HttpServletRequest request,String id){
		
		SysTszf entity=sysTszfDao.get(Integer.parseInt(id));
		
		String str="";
		entity.setBz(request.getParameter("bz"));
		entity.setTszf(request.getParameter("tszf"));
		sysTszfDao.update(entity);
		
		str="0";
		return str;
	}
	
	
	
	@Transactional
	public String saveRb(HttpServletRequest request, SysTszf entity) {
		String str="";
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		SysTszf tszfxx=new SysTszf();
		
		String tszf = request.getParameter("tszf");
		String bz = request.getParameter("bz");

		entity.setTszf(tszf);
		entity.setBz(bz);
		sysTszfDao.save(entity);
		str="1";
		return str;
	}
	
	/**
	 * 删除
	 * @author liangkaidi
	 * @date 2015-12-21
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			sysTszfDao.delete(ids[i]);
		}
	}

	/**
 * 获取特殊字符
 * @author liangkaidi
 * @date 2015-11-30
 * @param khbh
 * @return
 */
	@Transactional
	public List<Map<String, Object>>getTszf(String tszf) {
		return sysTszfDao.getTszf(tszf);
	}
	

	@Transactional
	public List<Map<String, Object>> getXg(String id){
		return sysTszfDao.getTszfXg(id);
	}

	@Transactional
	public void update(SysTszf entity, String id) {
		entity.setId(Integer.parseInt(id));
		sysTszfDao.update(entity);
	}


	

}
