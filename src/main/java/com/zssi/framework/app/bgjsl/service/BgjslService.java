package com.zssi.framework.app.bgjsl.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.bgjsl.dao.BgjslDao;
import com.zssi.framework.app.bgjsl.model.Bgjsl;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.tjgl.dao.BgcxDao;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class BgjslService extends BaseBO<Bgjsl> {
	
	@Autowired
	private BgjslDao dao;
	
	@Autowired
	private BgcxDao bgcxdao;
	
	@Transactional
	public Pagination<Map<String, Object>> getList(Integer start,
			Integer limit, String code) {
		return dao.getList(start, limit, code);
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i = 0; i<ids.length;i++){
			dao.delete(ids[i]);
			
		}
	}
	
	/**
	 * 后台:报告拖期查询
	 * @author liusong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 * @throws ParseException 
	 */
	public List<Map<String, Object>> getBgyqList(String ypbh,String ksmc,String ksyf,String jsyf,String csjd,Integer start, Integer limit) throws ParseException{
		List<Map<String, Object>> BgyqList = dao.getBgyqList(ypbh,ksmc, ksyf,jsyf,csjd,start, limit);
		for(int i = 0;i < BgyqList.size();i++){
			 Map<String, Object> map = BgyqList.get(i);
			 map.put("COUNT", BgyqList.size());
		}
		return BgyqList;
	}
	
	public List<Map<String, Object>> getCsjd() {
		return dao.getCsjd();
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
	public int getBgxxCount(String ypbh,String ksmccx,String ksyf,String jsyf,String csjd) {
		return Integer.parseInt(dao.getBgyqCont(ypbh,ksmccx, ksyf,jsyf,csjd).get(0).get("cnt").toString());
	}
	
	/**
	 * 成本统计导出Excle
	 * @author wangyong
	 * @date 2016年1月26日
	 * @param ksmccx
	 * @param ssyfcx
	 * @throws Exception 
	 */
	@Transactional
	public void exportBgtq(HttpServletRequest request,HttpServletResponse response,String ypbh,String ksmc,String ksyf,String jsyf,String csjd) throws Exception{
		if (csjd != null && !"".equals(csjd)) {
			csjd=java.net.URLDecoder.decode(csjd,"UTF-8");
			}
		List<Map<String,Object>> list= dao.getBgyqExl(ypbh,ksmc, ksyf,jsyf,csjd);
		String[] header=new String[]{"检验报告编号","主检科室","样品名称","检验类别","完成期限","超期节点","开始时间","结束时间","节点人员","超期时间（小时）"};
		String[] keys=new String[]{"BGBH","BMMC","YPMC","JYLX","WCQX","JDMC","KSSJ","SHSJ","JDRY","SJC"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

}
