package com.zssi.framework.app.jyzxxx.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.jyzxxx.dao.YjyXxcxDao;

@Service
public class YjyXxcxService extends BaseBO<YjyBgxx> {
	@Autowired
	private YjyXxcxDao dao;

	/**
	 * 产品类型查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getXxcx(Integer start, Integer limit) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getXxcx(start, limit);
		return bgyj;
	}
	
	public List<Map<String, Object>> getXxcx(Integer start, Integer limit, String cplx) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getXxcx(start, limit, cplx);
		return bgyj;
	}
	
	public List<Map<String, Object>> getList(Integer start, Integer limit, String cplx, String cpmc, String jyyj) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getList(start, limit, cplx, cpmc, jyyj);
		return bgyj;
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月12日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @return
	 */
	public int getBgxxCount(Integer start, Integer limit, String cplx) {
		return Integer.parseInt(dao.getBgxxCount(start, limit, cplx).get(0).get("cnt").toString());
	}
	
	/**
	 * 产品名称查询页面
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getCpcx(Integer start, Integer limit, String cplx) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getCpcx(start, limit, cplx);
		return bgyj;
	}
	
	/**
	 * 获取产品名称List
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getCpList(Integer start, Integer limit, String cplx,String cpmc, String jyyj) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getCpList(start, limit, cplx,cpmc, jyyj);
		return bgyj;
	}
	
	/**
	 * 获取信息条数
	 * @author wangyogn
	 * @date 2016年6月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	public int getCpCount(Integer start, Integer limit, String cplx,String cpmc, String jyyj) {
		return Integer.parseInt(dao.getCpCount(start, limit, cplx, cpmc, jyyj).get(0).get("cnt").toString());
	}
	
	/**
	 * 检验依据查询页面
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 */
	public List<Map<String, Object>> getJyyj(Integer start, Integer limit, String cplx, String cpbh) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getJyyj(start, limit, cplx, cpbh);
		return bgyj;
	}
	
	/**
	 * 获取检验依据List
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getJyyjList(Integer start, Integer limit, String cplx, String cpbh,String cpmc,String jyyj) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getJyyjList(start, limit, cplx, cpbh,cpmc, jyyj);
		return bgyj;
	}
	
	/**
	 * 获取信息条数
	 * @author wangyogn
	 * @date 2016年6月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	public int getJyyjCount(Integer start, Integer limit, String cplx, String cpbh,String jyyj) {
		return Integer.parseInt(dao.getJyyjCount(start, limit, cplx, cpbh, jyyj).get(0).get("cnt").toString());
	}
	
	/**
	 * 检验依据查询页面
	 * @author wangyong
	 * @date 2016年6月17日
	 * @return
	 */
	public List<Map<String, Object>> getJyxm(Integer start, Integer limit, String cplx, String cpbh, String jyyj) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getJyxm(start, limit, cplx, cpbh, jyyj);
		return bgyj;
	}
	
	/**
	 * 获取检验项目List
	 * @author wangyong
	 * @date 2016年6月15日
	 * @return
	 */
	public List<Map<String, Object>> getJyxmList(Integer start, Integer limit, String cplx, String cpbh,String cpmc,String jyyj,String jyxm) throws ParseException {
		List<Map<String,Object>> bgyj=dao.getJyxmList(start, limit, cplx, cpbh, jyyj, jyxm);
		return bgyj;
	}
	
	/**
	 * 获取信息条数
	 * @author wangyogn
	 * @date 2016年6月17日
	 * @param start
	 * @param limit
	 * @return
	 */
	public int getJyxmCount(Integer start, Integer limit, String cplx, String cpbh,String jyyj,String jyxm) {
		return Integer.parseInt(dao.getJyxmCount(start, limit, cplx, cpbh, jyyj, jyxm).get(0).get("cnt").toString());
	}
}

