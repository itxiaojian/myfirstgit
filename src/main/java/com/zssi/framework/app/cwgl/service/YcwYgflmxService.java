package com.zssi.framework.app.cwgl.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.zssi.framework.app.cwgl.dao.YcwYgflDao;
import com.zssi.framework.app.cwgl.dao.YcwYgflmxDao;
import com.zssi.framework.app.cwgl.model.YcwYgfl;
import com.zssi.framework.app.cwgl.model.YcwYgflmx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Service
public class YcwYgflmxService extends BaseBO<YcwYgflmxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwYgflmxDao ycwYgflmxDao;
	
	@Autowired
	private YcwYgflDao ycwYgflDao;
	
	/**
	 * 后台:员工福利明细列表
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYgflmxList(Integer start,Integer limit,String flbh){
		return ycwYgflmxDao.getYgflmxList(start, limit, flbh);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param entity
	 */
	@Transactional
	public void save(YcwYgflmx entity) {
		ycwYgflmxDao.save(entity);
	}
	
	/**
	 * 增加多条数据
	 * @author wangyong
	 * @date 2015年11月11日
	 * @param request
	 * @param rbbh
	 */
	@Transactional
	public void insert(YcwYgfl entity,HttpServletRequest request){
		Integer num=0;
		SysYh yh = AppUtil.getCurrentUser();
		String flbh = getFlbh();
		entity.setLrr(yh.getXm());
		Date date = new Date();
		entity.setLrrq(date);
		entity.setFlbh(flbh);
		ycwYgflDao.save(entity);
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 0; i < num; i++) {
			String ygxm = request.getParameter("ygxm"+(i+1));
			String ssyf = request.getParameter("ssyf"+(i+1));
			String flmc = request.getParameter("flmc"+(i+1));
			String flxq = request.getParameter("flxq"+(i+1));
			String je = request.getParameter("je"+(i+1));
			
			YcwYgflmx ycwYgflmx = new YcwYgflmx();
			ycwYgflmx.setFlbh(flbh);
			ycwYgflmx.setYgxm(ygxm);
			ycwYgflmx.setSsyf(ssyf);
			ycwYgflmx.setFlmc(flmc);
			ycwYgflmx.setFlxq(flxq);
			ycwYgflmx.setKs_id(entity.getKs_id());
			ycwYgflmx.setLrrq(date);
			if (je != null && !("").equals(je)) {
				BigDecimal jeBigDecimal = new BigDecimal(je);
				jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				ycwYgflmx.setJe(jeBigDecimal);
			}
			ycwYgflmxDao.save(ycwYgflmx);
		}
	}
	
	
	public String getFlbh(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	    Date date = new Date();
	    String str = sdf.format(date);
	    str = str.substring(2,4);
		List<Map<String, Object>> cydbhList = ycwYgflmxDao.getFlbh();
		String cbbhStr = (String) cydbhList.get(0).get("flbh");
		if (cbbhStr!=null) {
			String cbbhSub = cbbhStr.substring(2, 8);
			Integer maxCydbh = Integer.parseInt(cbbhSub);
			Integer newBh = maxCydbh + 1;
			String tempBh = "" + newBh;
			int bgbhlength = tempBh.length();
			if (bgbhlength==1) {
				str += "00000"+tempBh; 
			}else if (bgbhlength==2) {
				str += "0000"+tempBh; 
			}else if (bgbhlength==3) {
				str += "000"+tempBh; 
			}else if (bgbhlength==4) {
				str += "00"+tempBh; 
			}else if (bgbhlength==5) {
				str += "0"+tempBh; 
			}else {
				str += tempBh; 
			}
		}else {
		    str += "000001";
		}
		
		return str;
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月13日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YcwYgflmx entity,String id){
		entity.setId(Integer.parseInt(id));
		ycwYgflmxDao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			ycwYgflmxDao.delete(ids[i]);
		}
	}
}
