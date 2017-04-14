package com.zssi.framework.app.jygl.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyClyyDao;
import com.zssi.framework.app.jygl.model.YjyClyy;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * 常规结论用语
 * @author duanpeijun
 * @date 2016年1月26日
 */
@Service
public class YjyClyyService extends BaseBO<YjyClyy>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	@Autowired
	private YjyClyyDao dao;
	
	/**
	 * 常用检验结论用语后台
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getClyyList(Integer start, Integer limit,String canshu){
		return dao.getClyy(start, limit, canshu);
	}
	
	@Transactional
	public YjyClyy getclyyById(Integer id) {
		YjyClyy entity = dao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
	/**
	 * 结论类别1，2（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getDicByJylx(String zdzl) {
		return dao.getDicByJylx(zdzl);
	}
	
	/**
	 * 提交
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param request
	 * @return
	 */
	@Transactional
	public String tijiao(HttpServletRequest request) {
		String str="";
		SysYh yh = AppUtil.getCurrentUser();
		String xzr = yh.getXm();
		String jllb1 = request.getParameter("jllb1");
		String jllb2 = request.getParameter("jllb2");
		String cgjlyy = request.getParameter("cgjlyy");
		String bz = request.getParameter("bz");
		Date date = new Date();
		YjyClyy clyy = new YjyClyy();
		clyy.setCgjlyy(cgjlyy);
		clyy.setBz(bz);
		clyy.setJllb1(jllb1);
		clyy.setJllb2(jllb2);
		clyy.setXzr(xzr);
		clyy.setXzsj(date);
		this.save(clyy);
		str="1";
		return str;
	}
	
	/**
	 * 修改
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param request
	 * @return
	 */
	@Transactional
	public String update(HttpServletRequest request) {
		String str="";
		SysYh yh = AppUtil.getCurrentUser();
		String xzr = yh.getXm();
		String jllb1 = request.getParameter("jllb1");
		String jllb2 = request.getParameter("jllb2");
		String cgjlyy = request.getParameter("cgjlyy");
		String bz = request.getParameter("bz");
		String id = request.getParameter("id");
		Date date = new Date();
		YjyClyy clyy = this.getclyyById(Integer.parseInt(id));
		clyy.setCgjlyy(cgjlyy);
		clyy.setBz(bz);
		clyy.setJllb1(jllb1);
		clyy.setJllb2(jllb2);
		clyy.setXzr(xzr);
		clyy.setXzsj(date);
		this.update(clyy);
		str="1";
		return str;
	}
	
	/**
	 * 删除
	 * @author duanpeijun
	 * @date 2016年1月26日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
}
