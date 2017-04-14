package com.zssi.framework.app.stat.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likegene.framework.core.BaseBO;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.stat.dao.DsGctsTjDao;
import com.zssi.framework.app.stat.model.DsTsfl;

@Service
public class DsGctsTjService extends BaseBO<DsTsfl>{
protected Logger logger = LoggerFactory.getServiceLog(DsTsfl.class);
	
	@Autowired
	private DsGctsTjDao dao;
	/**
	*
	@throws UnsupportedEncodingException 
	 * @Author oufeng	
	@Date 2015年7月22日 下午3:10:50
	@Version 1.0
	*/
	public List<Map<String,Object>> getData(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String id= request.getParameter("id");
		return dao.getData(id);
       }
	
	
	/**
	 * 获得部分名称
	 * */
	public List<Map<String,Object>> getTszl(HttpServletRequest request,HttpServletResponse response) {
		return dao.getTszl();
	}
}

