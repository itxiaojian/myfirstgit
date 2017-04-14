package com.zssi.framework.app.cwgl.service;

import java.math.BigDecimal;
import java.text.ParseException;
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
import com.zssi.framework.app.cbgl.dao.YcwCbxxDao;
import com.zssi.framework.app.cbgl.model.YcwCbxx;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.dao.YcwCbmxDao;
import com.zssi.framework.app.cwgl.model.YcwCbmx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Service
public class YcwCbmxService extends BaseBO<YcwCbmxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwCbmxDao ycwCbxmDao;
	
	@Autowired
	private YcwCbxxDao ycwCbxxDao;
	
	/**
	 * 后台:成本明细列表
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getCbmxList(Integer start,Integer limit,String jybh,String ksbh,String lrrq){
		return ycwCbxmDao.getCbmxList(start, limit, jybh,ksbh,lrrq);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 */
	@Transactional
	public void save(YcwCbmx entity) {
		ycwCbxmDao.save(entity);
	}
	
	/**
	 * 增加多条数据
	 * @author wangyong
	 * @date 2015年11月11日
	 * @param request
	 * @param rbbh
	 * @throws ParseException 
	 */
	@Transactional
	public void insert(YcwCbxx entity,HttpServletRequest request) throws ParseException{
		Integer num=0;
		Date date = new Date();
		SysYh yh =AppUtil.getCurrentUser();
		String cbbh = getCbbh();
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 0; i < num; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String jybh=request.getParameter("jybh"+(i+1));
			String fylx=request.getParameter("fylx"+(i+1));
			String pjbh=request.getParameter("pjbh"+(i+1));
			String xmmc=request.getParameter("xmmc"+(i+1));
			String fyxq=request.getParameter("fyxq"+(i+1));
			String je=request.getParameter("je"+(i+1));
			String fssj1=request.getParameter("fssj"+(i+1));
			YcwCbmx ycwCbmx=new YcwCbmx();
			ycwCbmx.setJybh(jybh);
			ycwCbmx.setKsbh(entity.getKsbh());
			ycwCbmx.setFylx(fylx);
			ycwCbmx.setPjbh(pjbh);
			ycwCbmx.setXmmc(xmmc);
			ycwCbmx.setFyxq(fyxq);
			ycwCbmx.setLrrq(date);
			ycwCbmx.setCbbh(cbbh);
			if (fssj1 != null && !("").equals(fssj1)) {
				Date fssj = sdf.parse(fssj1); 
				ycwCbmx.setFssj(fssj);
			}
			if (je != null && !("").equals(je)) {
				BigDecimal jeBigDecimal = new BigDecimal(je);
				jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				ycwCbmx.setJe(jeBigDecimal);
			}
			ycwCbxmDao.save(ycwCbmx);
			entity.setLrr(yh.getXm());
			entity.setLrrq(date);
			entity.setFssj(sdf.parse(fssj1));
			entity.setCbbh(cbbh);
			ycwCbxxDao.save(entity);
		}
		
		
	}
	
	public String getCbbh(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	    Date date = new Date();
	    String str = sdf.format(date);
	    str = str.substring(2,4);
		List<Map<String, Object>> cydbhList = ycwCbxmDao.getCbbh();
		String cbbhStr = (String) cydbhList.get(0).get("cbbh");
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
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YcwCbmx entity,String id){
		entity.setId(Integer.parseInt(id));
		ycwCbxmDao.update(entity);
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
			ycwCbxmDao.delete(ids[i]);
		}
	}
}
