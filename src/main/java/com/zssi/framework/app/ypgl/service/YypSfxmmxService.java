package com.zssi.framework.app.ypgl.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.dao.YypSfxmmxDao;
import com.zssi.framework.app.ypgl.model.YypSfxmmx;

@Service
public class YypSfxmmxService extends BaseBO<YypSfxmmxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YypSfxmmxDao dao;
	
	/**
	 * 获取收费醒目明细列表
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getSfxmmxList(Integer start,Integer limit,String code){
		return dao.getSfxmmxList(start, limit, code);
	}
	
	/**
	 * 增加
	 * @author wangyong 
	 * @date 2015年12月10日
	 * @param entity
	 */
	@Transactional
	public String save(HttpServletRequest request,HttpServletResponse response) {
		Integer num=0;
		Integer jyfy = 0;
		String bgbh = request.getParameter("bgbh1");
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 1; i <= num; i++) {
			String xmbh = request.getParameter("xmbh"+(i));
			String cpmc = request.getParameter("cpmc"+(i));
			String xmmc = request.getParameter("xmmc"+(i));
			String jldw = request.getParameter("jldw"+(i));
			String dj = request.getParameter("dj"+(i));
			String xgje = request.getParameter("xgje"+(i));
			String sl = request.getParameter("sl"+(i));
			
			if(xmmc!=null&&!"".equals(xmmc)){
				YypSfxmmx sfxmmx = new YypSfxmmx();
				sfxmmx.setBgbh(bgbh);
				sfxmmx.setXmbh(xmbh);
				sfxmmx.setCpmc(cpmc);
				sfxmmx.setXmmc(xmmc);
				sfxmmx.setJldw(jldw);
				
				
				if (dj != null && !("").equals(dj)) {
					BigDecimal jeBigDecimal = new BigDecimal(dj);
					jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
					sfxmmx.setJe(jeBigDecimal);
				}
				if (sl != null && !("").equals(sl)) {
					sfxmmx.setSl(Integer.parseInt(sl));
				}
				if (xgje != null && !("").equals(xgje)) {
					BigDecimal xgjeBigDecimal = new BigDecimal(xgje);
					xgjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
					sfxmmx.setXgje(xgjeBigDecimal);
				}
				
				dao.save(sfxmmx);
			}
		}
		String jyfyStr = jyfy.toString();
//		System.out.println(jyfyStr);
		return jyfyStr;
	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年12月10日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YypSfxmmx entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
//	/**
//	 * 删除
//	 * @author wangyong 
//	 * @date  2015年12月10日
//	 * @param ids
//	 */
//	@Transactional
//	public void delete(Integer[] ids) {
//		for(int i=0;i<ids.length;i++){
//			dao.delete(ids[i]);
//		}
//	}
	
	/**
	 * 删除收费项目明细
	 * @author wangyong
	 * @date 2015年12月20日
	 * @param bgbh
	 */
	@Transactional
	public void deleteSfxmmx(String bgbh){
		dao.deleteSfxmmx(bgbh);
	}

	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015年12月10日
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getSfxmmx(Integer id){
		return dao.getSfxmmx(id);
	}
	
	/**
	 * 通过报告编号查询已收费的项目
	 * @author wangyong
	 * @date 2016年3月24日
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYsfxm(String bgbh){
		return dao.getSfxmmx(bgbh);
	}
}
