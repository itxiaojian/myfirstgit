package com.zssi.framework.app.cwgl.service;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.dao.YcwKssrmxDao;
import com.zssi.framework.app.cwgl.model.YcwKssrmx;

@Service
public class YcwKssrmxService extends BaseBO<YcwKssrmxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwKssrmxDao ycwKssrmxDao;
	
	/**
	 * 后台:科室收入明细列表
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getKssrmxList(Integer start,Integer limit,String jybh){
		return ycwKssrmxDao.getKssrmxList(start, limit, jybh);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param entity
	 */
	@Transactional
	public void save(YcwKssrmx entity) {
		ycwKssrmxDao.save(entity);
	}
	
	/**
	 * 增加多条数据
	 * @author wangyong
	 * @date 2015年11月11日
	 * @param request
	 * @param rbbh
	 */
	@Transactional
	public void insert(HttpServletRequest request){
		Integer num=0;
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 0; i < num; i++) {
			String jybh = request.getParameter("jybh"+(i+1));
			String fymc = request.getParameter("fymc"+(i+1));
			String fylx = request.getParameter("fylx"+(i+1));
			String fynr = request.getParameter("fynr"+(i+1));
			String je = request.getParameter("je"+(i+1));
			
			YcwKssrmx ycwKssrmx = new YcwKssrmx();
			
			ycwKssrmx.setJybh(jybh);
			ycwKssrmx.setFymc(fymc);
			ycwKssrmx.setFylx(fylx);
			ycwKssrmx.setFynr(fynr);
			
			if (je != null && !("").equals(je)) {
				BigDecimal jeBigDecimal = new BigDecimal(je);
				jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				ycwKssrmx.setJe(jeBigDecimal);
			}
			ycwKssrmxDao.save(ycwKssrmx);
		}
	}
	
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YcwKssrmx entity,String id){
		entity.setId(Integer.parseInt(id));
		ycwKssrmxDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月14日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ycwKssrmxDao.delete(ids[i]);
		}
	}
}
