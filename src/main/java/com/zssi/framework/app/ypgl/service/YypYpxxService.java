package com.zssi.framework.app.ypgl.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zssi.framework.app.cwgl.dao.YcwBgsfDao;
import com.zssi.framework.app.cwgl.model.YcwBgsf;
import com.zssi.framework.app.cwgl.service.YcwBgsfService;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jsfwgl.dao.YjsfwXyxxDao;
import com.zssi.framework.app.jsfwgl.model.YjsfwXyxx;
import com.zssi.framework.app.process.support.ProcessXNUtils;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.ypgl.dao.YypSfxmmxDao;
import com.zssi.framework.app.ypgl.dao.YypYpxxDao;
import com.zssi.framework.app.ypgl.model.YypYpxx;

@Service
public class YypYpxxService extends BaseBO<YypYpxx>{
	@Autowired
	private YypYpxxDao yypYpxxDao;
	@Autowired
	private YypSfxmmxDao sfxmmxDao;
	@Autowired
	private YcwBgsfDao bgsfDao;
	@Autowired
	private YcwBgsfService bgsfService;
	@Autowired
	private YjsfwXyxxDao xyxxDao;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	

	/**
	 * 查询getYpxxList
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getYpxxList(Integer start,Integer limit,String canshu,String bgbh,String ypbh,String ypmc,String yplx,
			String ypdj,String ypzt,String ggxh,String szcs,String scrqpc,String jyks,String ywks,String cyry,String cydd,String cyrq,String sb,
			String jyfydd,String yhxtk,String jylx,String jyhth,String jcfyry,String dyrq,String djsj,String wcqx,String wtdw,String wtlxr,
			String sjhm,String sjdw,String lxr,String scdw,String scdwlxr,String gcmc,String gclxr,String sgdw,String gcsjdw,String jsdw,
			String jldw,String jlr,String jzdw,String jzr,String slr){
		return yypYpxxDao.getYpxxList(start, limit,canshu,bgbh,ypbh,ypmc,yplx,ypdj,ypzt,ggxh,szcs,scrqpc,jyks,ywks,cyry,cydd,cyrq,sb,jyfydd,
				yhxtk,jylx,jyhth,jcfyry,dyrq,djsj,wcqx,wtdw,wtlxr,sjhm,sjdw,lxr,scdw,scdwlxr,gcmc,gclxr,sgdw,gcsjdw,jsdw,jldw,jlr,jzdw,jzr,slr);
	}
	
//	@Transactional
//	public Pagination<Map<String, Object>> getYpxgList(Integer start,Integer limit,String canshu,String bgbh,String ypbh,String ypmc,String yplx,
//			String ypdj,String ypzt,String ggxh,String szcs,String scrqpc,String jyks,String ywks,String cyry,String cydd,String cyrq,String sb,
//			String jyfydd,String yhxtk,String jylx,String jyhth,String jcfyry,String dyrq,String djsj,String wcqx,String wtdw,String wtlxr,
//			String sjhm,String sjdw,String lxr,String scdw,String scdwlxr,String gcmc,String gclxr,String sgdw,String gcsjdw,String jsdw,
//			String jldw,String jlr,String jzdw,String jzr,String slr){
//		return yypYpxxDao.getYpxxList(start, limit,canshu,bgbh,ypbh,ypmc,yplx,ypdj,ypzt,ggxh,szcs,scrqpc,jyks,ywks,cyry,cydd,cyrq,sb,jyfydd,
//				yhxtk,jylx,jyhth,jcfyry,dyrq,djsj,wcqx,wtdw,wtlxr,sjhm,sjdw,lxr,scdw,scdwlxr,gcmc,gclxr,sgdw,gcsjdw,jsdw,jldw,jlr,jzdw,jzr,slr);
//		
//	}
	/**
	 * 微信平台样品信息查询
	 * @author panweichi
	 * @date 2015年11月16日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYp(){
		return yypYpxxDao.getList1(null);
	}
	
	/**
	 * 微信平台样品信息详情查询
	 * @author liusong
	 * @date 2015年11月16日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYp1(String id){
		return yypYpxxDao.getList2(id);
	}
	
	@Transactional
	public List<Map<String, Object>> getid(String bgbh){
		return yypYpxxDao.getid(bgbh);
	}
	
	/**                                                                                
	 * 保存
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param entity
	 */
	@Transactional
	public String saveYpxx(HttpServletRequest request,YypYpxx entity,YcwBgsf entity1) {
		String str="0";
		String djlxStr = request.getParameter("djlx");
		if (djlxStr.equals("3")) {
			String cydbh = getCydbh();
			entity.setCydbh(cydbh);
		}
		
		String jyks = entity.getJyksbh();
		entity.setJyks(jyks);
		String ywks = entity.getYwksbh();
		entity.setYwks(ywks);
		
		//登记人员和登记时间从系统获取
		SysYh yh =AppUtil.getCurrentUser();
	    entity.setDjry(yh.getXm());
	    Date date = new Date();
	    entity.setDjsj(date);
	    entity.setYpjyzt(0);
	    entity.setYjzt(0);
	    
//	    对页面检验费用进行判断进行保存
	    if(entity.getJyfy()==null||"".equals(entity.getJyfy())){
	    	entity.setJyfy(new BigDecimal(0));
	    }
	    
	    //验证编号唯一性
	    String zhmc = request.getParameter("zh");
	    String ypbh = findZh(jyks, zhmc);
	    entity.setYpbh(ypbh);
	    entity.setBgbh(ypbh);
	    
	    //后台保存字号（英文字母）
		if (ypbh.length()==11) {
			String zh = ypbh.substring(4,6);
			entity.setZh(zh);
		}else if (ypbh.length()==12){
			String zh = ypbh.substring(4,7);
			entity.setZh(zh);
		}
		

		String xMurl=request.getRequestURL().toString();
		String ewmStr=xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url=ewmStr+"/toSbDetail?ypbh="+ypbh;
		entity.setEwmbh(url);
		int ypid = yypYpxxDao.save(entity);
		
//		//保存检验项目明细（收费明细）
//		Integer num=0;
//		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
//			num=Integer.parseInt(request.getParameter("num"));
//			//System.out.println(num);
//		}
//		for (int i = 1; i <= num; i++) {
//			//String bgbh = request.getParameter("bgbh"+(i));
//			String xmbh = request.getParameter("xmbh"+(i));
//			String cpmc = request.getParameter("cpmc"+(i));
//			String xmmc = request.getParameter("xmmc"+(i));
//			String jldw = request.getParameter("jldw"+(i));
//			String dj = request.getParameter("dj"+(i));
//			String xgje = request.getParameter("xgje"+(i));
//			String sl = request.getParameter("sl"+(i));
//			
//			if(xmmc!=null&&!"".equals(xmmc)){
//				YypSfxmmx sfxmmx = new YypSfxmmx();
//				sfxmmx.setBgbh(ypbh);
//				sfxmmx.setXmbh(xmbh);
//				sfxmmx.setCpmc(cpmc);
//				sfxmmx.setXmmc(xmmc);
//				sfxmmx.setJldw(jldw);
//				
//				
//				if (dj != null && !("").equals(dj)) {
//					BigDecimal jeBigDecimal = new BigDecimal(dj);
//					jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//					sfxmmx.setJe(jeBigDecimal);
//				}
//				if (sl != null && !("").equals(sl)) {
//					sfxmmx.setSl(Integer.parseInt(sl));
//				}
//				if (xgje != null && !("").equals(xgje)) {
//					BigDecimal xgjeBigDecimal = new BigDecimal(xgje);
//					xgjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//					sfxmmx.setXgje(xgjeBigDecimal);
//				}
//				
//				sfxmmxDao.save(sfxmmx);
//			}
//			
//		}
		
		String jyhth = request.getParameter("jyhth");
		//		对样品信息进行相关判断，进行报告收费
		String jyfydd = request.getParameter("jyfydd");
		Integer fydd = Integer.parseInt(jyfydd);
//		首先判断有没有选择检验合同号
		if(jyhth==null||"".equals(jyhth) ){
//		如果检验费用不待定（默认）即选了检验项目产生费用
			if (fydd == 1) {
				entity1.setBgbh(entity.getBgbh());
				entity1.setYpmc(entity.getYpmc());
				entity1.setSjdw(entity.getSjdw());
				entity1.setKs_id(entity.getJyks());
				entity1.setSsywks(entity.getYwks());
				entity1.setJyfy(entity.getJyfy());
				entity1.setYsje(entity.getJyfy());
				entity1.setJyjsrq(new Date());
				entity1.setBz(entity.getBz());
				entity1.setYsfje(new BigDecimal(0));
				entity1.setXgje(new BigDecimal(1));
				entity1.setSfzt(0);
				bgsfDao.save(entity1);
	//            如果检验费用选择了待定，肯定也是选择了检验项目，只是收费这块应收项目存为0并收费前台给予显示
			} else if (fydd == 0) {
				entity1.setBgbh(entity.getBgbh());
				entity1.setYpmc(entity.getYpmc());
				entity1.setSjdw(entity.getSjdw());
				entity1.setKs_id(entity.getJyks());
				entity1.setSsywks(entity.getYwks());
				entity1.setJyfy(entity.getJyfy());
				entity1.setJyjsrq(new Date());
				entity1.setYsje(new BigDecimal(0));
				entity1.setBz(entity.getBz());
				entity1.setYsfje(new BigDecimal(0));
				entity1.setXgje(new BigDecimal(1));
				entity1.setSfzt(0);
				bgsfDao.save(entity1);
				}
		}else if(jyhth!=null&&!"".equals(jyhth)){
			//获取检验合同号进行查询协议信息所对应的id
			List<Map<String,Object>> id = xyxxDao.getXyxxbyHth(jyhth);
//			有很多情况样品的检验合同号是手输的，导致查不到id
			if(id.size() != 0){
				for (int i=0;i<id.size();i++){
					Map<String, Object> map=(Map<String, Object>)id.get(i);
					Iterator<String> iterator = map.keySet().iterator();
					while (iterator.hasNext())
					{
						String key = (String)iterator.next();
						Object bgbhObj = map.get(key);
						String ids = bgbhObj.toString();
						YjsfwXyxx xyxx = xyxxDao.get(Integer.parseInt(ids));
						if(xyxx.getJybh_id()!=null&&!"".equals(xyxx.getJybh_id())){
							xyxx.setSyje(xyxx.getSyje().subtract(entity.getJyfy()));
							xyxx.setJybh_id(entity.getBgbh()+","+xyxx.getJybh_id());
						}else if(xyxx.getJybh_id()==null||"".equals(xyxx.getJybh_id())){
							xyxx.setSyje(xyxx.getSyje().subtract(entity.getJyfy()));
							xyxx.setJybh_id(entity.getBgbh());
						}
					}
				}
			}
					entity1.setBgbh(entity.getBgbh());
					entity1.setJyfy(new BigDecimal(0));
					entity1.setYsje(new BigDecimal(0));
					entity1.setJyjsrq(new Date());
					entity1.setYsfje(new BigDecimal(0));
					entity1.setXgje(new BigDecimal(1));
					bgsfDao.save(entity1);
		}
		//保存样品时启动流程
////		String result = ProcessXNUtils.startZJYFlow("", entity.getYpbh()+"",entity.getJyksbh());
////		if("success".equalsIgnoreCase(result)){
////			return "1";
////		}else{
////			return "0";
////		}
//		return "1";
		String result = ProcessXNUtils.startZJYFlow("", ypid+"",entity.getJyksbh());//启动流程，根据样品id来，避免重复
		str=ypbh;
		if("success".equalsIgnoreCase(result)){
			return str;
		}else{
			return "0";
		}
		
	}
	
	/**
	 * 样品复制的保存方法
	 * @author wangyong
	 * @date 2016年1月22日
	 * @param model
	 * @param entity
	 * @param entity1
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	public String ypfzSave(HttpServletRequest request,YypYpxx entity,YcwBgsf entity1) {
		String str="0";
		
		String jyks = entity.getJyksbh();
		entity.setJyks(jyks);
		String ywks = entity.getYwksbh();
		entity.setYwks(ywks);
		
		//登记人员和登记时间从系统获取
		SysYh yh =AppUtil.getCurrentUser();
	    entity.setDjry(yh.getXm());
	    Date date = new Date();
	    entity.setDjsj(date);
	    entity.setYpjyzt(0);
	    entity.setYjzt(0);
	    
	    //验证编号唯一性
	    String zhmc = request.getParameter("zh");
	    String ypbh = findZh(jyks, zhmc);
	    entity.setYpbh(ypbh);
	    entity.setBgbh(ypbh);
	    
	    //后台保存字号（英文字母）
		if (ypbh.length()==11) {
			String zh = ypbh.substring(4,6);
			entity.setZh(zh);
		}else if (ypbh.length()==12){
			String zh = ypbh.substring(4,7);
			entity.setZh(zh);
		}
		
//	    对页面检验费用进行判断进行保存
	    if(entity.getJyfy()==null||"".equals(entity.getJyfy())){
	    	entity.setJyfy(new BigDecimal(0));
	    }
		

		String xMurl=request.getRequestURL().toString();
		String ewmStr=xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url=ewmStr+"/toSbDetail?ypbh="+ypbh;
		entity.setEwmbh(url);
		int ypid = yypYpxxDao.save(entity);
		
//		Integer num=0;
//		//判断检验项目是否有改变，有改变则存入新的检验项目，无改变则存储复制样品的检验项目。
//		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))&&Integer.parseInt(request.getParameter("num"))>1){
//			num=Integer.parseInt(request.getParameter("num"));
//			for (int i = 1; i < num; i++) {
//				String bgbh = request.getParameter("bgbh"+(i));
//				String xmbh = request.getParameter("xmbh"+(i));
//				String xmmc = request.getParameter("xmmc"+(i));
//				String jldw = request.getParameter("jldw"+(i));
//				String je = request.getParameter("je"+(i));
//				String xgje = request.getParameter("xgje"+(i));
//				
//				YypSfxmmx sfxmmx = new YypSfxmmx();
//				sfxmmx.setBgbh(bgbh);
//				sfxmmx.setXmbh(xmbh);
//				sfxmmx.setXmmc(xmmc);
//				sfxmmx.setJldw(jldw);
//				
//				if (je != null && !("").equals(je)) {
//					BigDecimal jeBigDecimal = new BigDecimal(je);
//					jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//					sfxmmx.setJe(jeBigDecimal);
//				}
//				if (xgje != null && !("").equals(xgje)) {
//					BigDecimal xgjeBigDecimal = new BigDecimal(xgje);
//					xgjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//					sfxmmx.setXgje(xgjeBigDecimal);
//				}
//				
//				sfxmmxDao.save(sfxmmx);
//			}
//		} else if (Integer.parseInt(request.getParameter("num"))==1) {
//			String bgbhOld = request.getParameter("bgbhOld");
//			List<Map<String, Object>> list = sfxmmxDao.getSfxmmx(bgbhOld);
//			if (list.size() > 0) {
//				for (int i=0;i<list.size();i++){
//					Map<String, Object> map=(Map<String, Object>)list.get(i);
//					Iterator<String> iterator = map.keySet().iterator();
//					String bgbhNew = entity.getBgbh();
//					String xmbh = "";
//					String xmmc = "";
//					String jldw = "";
//					String je = "";
//					String xgje = "";
//					YypSfxmmx sfxmmx = new YypSfxmmx();
//					int j = 1;
//					while (iterator.hasNext()) {
//						String key = (String)iterator.next();
//						Object bgbhObj = map.get(key);
//						//获取键值对的值并转换成String
//						String bgbhitem = bgbhObj.toString();
//						System.out.println(bgbhitem);
//						if (j==1) {
//							xmbh = bgbhitem;
//						} else if (j==2) {
//							xmmc = bgbhitem;
//						} else if (j==3) {
//							jldw = bgbhitem;
//						} else if (j==4) {
//							je = bgbhitem;
//						} else if (j==5) {
//							xgje = bgbhitem;
//						}
//						j++;
//						//System.out.println(j);
//					}
//					sfxmmx.setBgbh(bgbhNew);
//					sfxmmx.setXmbh(xmbh);
//					sfxmmx.setXmmc(xmmc);
//					sfxmmx.setJldw(jldw);
//					if (je != null && !("").equals(je)) {
//						BigDecimal jeBigDecimal = new BigDecimal(je);
//						jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//						sfxmmx.setJe(jeBigDecimal);
//					}
//					if (xgje != null && !("").equals(xgje)) {
//						BigDecimal xgjeBigDecimal = new BigDecimal(xgje);
//						xgjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
//						sfxmmx.setXgje(xgjeBigDecimal);
//					}
//					sfxmmxDao.save(sfxmmx);
//				}
//			}	
//		}
//		if(Integer.parseInt(request.getParameter("num"))==0){
//			String bgbh = request.getParameter("bgbh");
//			List<Map<String, Object>> list = sfxmmxDao.getSfxmmx(bgbh);
//			num=Integer.parseInt(request.getParameter("num"));
//		}
		
		String jyhth = request.getParameter("jyhth");
		//		对样品信息进行相关判断，进行报告收费
		String jyfydd = request.getParameter("jyfydd");
		Integer fydd = Integer.parseInt(jyfydd);
//		首先判断有没有选择检验合同号
		if(jyhth==null||"".equals(jyhth) ){
//		如果检验费用不待定（默认）即选了检验项目产生费用
		if (fydd == 1) {
			entity1.setBgbh(entity.getBgbh());
			entity1.setYpmc(entity.getYpmc());
			entity1.setSjdw(entity.getSjdw());
			entity1.setKs_id(entity.getJyks());
			entity1.setSsywks(entity.getYwks());
			entity1.setJyfy(entity.getJyfy());
			entity1.setYsje(entity.getJyfy());
			entity1.setJyjsrq(new Date());
			entity1.setBz(entity.getBz());
			entity1.setYsfje(new BigDecimal(0));
			entity1.setSfzt(0);
			bgsfDao.save(entity1);
//            如果检验费用选择了待定，肯定也是选择了检验项目，只是收费这块应收项目存为0并收费前台给予显示
		} else if (fydd == 0) {
			entity1.setBgbh(entity.getBgbh());
			entity1.setYpmc(entity.getYpmc());
			entity1.setSjdw(entity.getSjdw());
			entity1.setKs_id(entity.getJyks());
			entity1.setSsywks(entity.getYwks());
			entity1.setJyfy(entity.getJyfy());
			entity1.setJyjsrq(new Date());
			entity1.setYsje(new BigDecimal(0));
			entity1.setBz(entity.getBz());
			entity1.setYsfje(new BigDecimal(0));
			entity1.setSfzt(0);
			bgsfDao.save(entity1);
		}
		}else if(jyhth!=null&&!"".equals(jyhth)){
			//获取检验合同号进行查询协议信息所对应的id
			List<Map<String,Object>> id = xyxxDao.getXyxxbyHth(jyhth);
//			有很多情况样品的检验合同号是手输的，导致查不到id
			if(id.size() != 0){
				for (int i=0;i<id.size();i++){
					Map<String, Object> map=(Map<String, Object>)id.get(i);
					Iterator<String> iterator = map.keySet().iterator();
					while (iterator.hasNext())
					{
						String key = (String)iterator.next();
						Object bgbhObj = map.get(key);
						String ids = bgbhObj.toString();
						YjsfwXyxx xyxx = xyxxDao.get(Integer.parseInt(ids));
						if(xyxx.getJybh_id()!=null&&!"".equals(xyxx.getJybh_id())){
							xyxx.setSyje(xyxx.getSyje().subtract(entity.getJyfy()));
							xyxx.setJybh_id(entity.getBgbh()+","+xyxx.getJybh_id());
						}else if(xyxx.getJybh_id()==null||"".equals(xyxx.getJybh_id())){
							xyxx.setSyje(xyxx.getSyje().subtract(entity.getJyfy()));
							xyxx.setJybh_id(entity.getBgbh());
						}
					}
				}
			}
					entity1.setBgbh(entity.getBgbh());
					entity1.setJyfy(new BigDecimal(0));
					entity1.setYsje(new BigDecimal(0));
					entity1.setJyjsrq(new Date());
					entity1.setYsfje(new BigDecimal(0));
					entity1.setXgje(new BigDecimal(1));
					bgsfDao.save(entity1);
		}
		//保存样品时启动流程
////		String result = ProcessXNUtils.startZJYFlow("", entity.getYpbh()+"",entity.getJyksbh());
////		if("success".equalsIgnoreCase(result)){
////			return "1";
////		}else{
////			return "0";
////		}
//		return "1";
		String result = ProcessXNUtils.startZJYFlow("", ypid+"",entity.getJyksbh());//启动流程，根据样品id来，避免重复
		str=ypbh;
		if("success".equalsIgnoreCase(result)){
			return str;
		}else{
			return "0";
		}
		
	}
	
	/**
	 *
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public YypYpxx getYpxxById(Integer id) {
		YypYpxx entity = yypYpxxDao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}	
	
	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYpxx(Integer id){
		return yypYpxxDao.getYpxx(id);
	}
	
	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYpxx(Integer id,String djlx){
		return yypYpxxDao.getYpxx(id,djlx);
	}
	
	public List<Map<String, Object>> getSfbzbh(){
		return yypYpxxDao.getSfbzbh();
	}
	
	
	/**
	 * 获取收费项目明细
	 * @author wangyong
	 * @date 2015年12月11日
	 * @return
	 */
	public List<Map<String, Object>> getSfxmmx(String cpmccx,String xmmccx,String jzcs,String zxxjyyj){
		return yypYpxxDao.getSfxmmx(cpmccx,xmmccx,jzcs,zxxjyyj);
	}
	
	/**
	 * 通过前台传来的部门编号和字号生成样品和报告编号
	 * @author wangyong
	 * @date 2015年12月2日
	 * @param id
	 * @return
	 */
	public String findZh(String jyksbh,String zhmc){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	    Date date = new Date();
	    String str = sdf.format(date);
		//System.out.println(str);
		if (jyksbh != null && zhmc != null) {
			List<Map<String, Object>> bz = yypYpxxDao.findZh(jyksbh,zhmc);
			if (bz.size() > 0) {
				for (int i = 0; i < bz.size(); i++) {
					Map<String, Object> map=(Map<String, Object>)bz.get(i);
			        Iterator<String> iterator = map.keySet().iterator();
			        while (iterator.hasNext()){
			        	 String key = (String)iterator.next();
			        	 Object obj = map.get(key);
			        	 String strKey = obj.toString();
			        	 str += strKey;
//			        	 if (zh.equals("Y")) {
//							str += strKey;
//						}else {
//							str += zh+strKey;
//						}
			        }
				}
				//System.out.println(str);
				//查询获取符合当前条件的报告编号
				List<Map<String, Object>> bgbhList = yypYpxxDao.getBgbhList(str);
				System.out.println(bgbhList);
				
				List<Integer> list = new ArrayList<Integer>();
				if (bgbhList.size() > 0) {
					for (int i=0;i<bgbhList.size();i++){
						Map<String, Object> map=(Map<String, Object>)bgbhList.get(i);
						Iterator<String> iterator = map.keySet().iterator();
						while (iterator.hasNext()) {
							String key = (String)iterator.next();
							Object bgbhObj = map.get(key);
							//获取键值对的值并转换成String
							String bgbhitem = bgbhObj.toString();
							if (bgbhitem.length()==11) {
								String bgbhSubString = bgbhitem.substring(6,11);
								Integer bgbhInt = Integer.parseInt(bgbhSubString);
								list.add(bgbhInt);
							}else if (bgbhitem.length()==12){
								String bgbhSubString = bgbhitem.substring(7,12);
								Integer bgbhInt = Integer.parseInt(bgbhSubString);
								list.add(bgbhInt);
							}
						}
					}
					int tempMax = 0;
//					for (int i = 0; i < list.size(); i++) {
//						if (list.get(i) >= tempMax) {
//							tempMax = list.get(i);
//						}
//					}
					
					//将查询出的报告编号List转化为数组进行排序
					Integer[] a = list.toArray(new Integer[list.size()]);
					for (int i = 0; i < list.size()-1; i++) {
						for (int j = 0; j < list.size()-1-i; j++) {
							if (a[j]>a[j+1]) {
								int temp;
								temp = a[j];
								a[j] = a[j+1];
								a[j+1] = temp;
							}
						}
					}
					//对重新排序的数据进行比较
					boolean flag = true;
					for (int i = 0; i < a.length-1; i++) {
						if (a[i]+1!=a[i+1]) {
							tempMax = a[i];
							flag = false;
							break;
						}
					}
					//如果数组里的数据是依次递增的，则在最末的数据是最大值
					if (flag) {
						tempMax = a[list.size()-1];
					}
					int bgbhCur = tempMax + 1;
					String tempBgbh = "" + bgbhCur;
					int bgbhlength = tempBgbh.length();
					
					if (bgbhlength==1) {
						str += "0000"+tempBgbh; 
					}else if (bgbhlength==2) {
						str += "000"+tempBgbh; 
					}else if (bgbhlength==3) {
						str += "00"+tempBgbh; 
					}else if (bgbhlength==4) {
						str += "0"+tempBgbh; 
					}else {
						str += tempBgbh; 
					}
				}else {
					str += "00001";
				}
			}
			
		}
		return str;
	}
	
	/**
	 * 获取抽样单编号
	 * @author wangyong
	 * @date 2016年3月17日
	 * @return
	 */
	public String getCydbh(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//	    Date date = new Date();
//	    String str = sdf.format(date);
//	    str = str.substring(2,4);
		String str ="";
		List<Map<String, Object>> cydbhList = yypYpxxDao.getCydbh();
		String cydStr = (String) cydbhList.get(0).get("cydbh");
		//System.out.println(cydStr);
		if (cydStr!=null) {
			Integer maxCydbh = Integer.parseInt(cydStr);
			Integer newBh = maxCydbh + 1;
			String tempBh = "" + newBh;
			int bgbhlength = tempBh.length();
			if (bgbhlength==1) {
				str += "0000"+tempBh; 
			}else if (bgbhlength==2) {
				str += "000"+tempBh; 
			}else if (bgbhlength==3) {
				str += "00"+tempBh; 
			}else if (bgbhlength==4) {
				str += "0"+tempBh; 
			}else {
				str += tempBh; 
			}
		}else {
		    str += "00001";
		}
		
		return str;
	}
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public String up(HttpServletRequest request,YypYpxx entity,String id, YcwBgsf entity1){
		/*Integer num=0;
		//判断检验项目是否有改变，有改变则先把以前的存入的收费信息删除在存入新的检验项目，无改变则不做处理。
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))&&Integer.parseInt(request.getParameter("num"))>1){
			String bgbh = request.getParameter("bgbh");
			List<Map<String, Object>> list = sfxmmxDao.getSfxmmx(bgbh);
			if (list.size()>0) {
				sfxmmxDao.deleteSfxmmx(bgbh);
			}
			num=Integer.parseInt(request.getParameter("num"));
			
		}
		if(Integer.parseInt(request.getParameter("num"))==0){
			String bgbh = request.getParameter("bgbh");
			List<Map<String, Object>> list = sfxmmxDao.getSfxmmx(bgbh);
			if (list.size()>0) {
				sfxmmxDao.deleteSfxmmx(bgbh);
			}
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 1; i < num; i++) {
			String bgbh = request.getParameter("bgbh"+(i));
			String xmbh = request.getParameter("xmbh"+(i));
			String xmmc = request.getParameter("xmmc"+(i));
			String jldw = request.getParameter("jldw"+(i));
			String je = request.getParameter("je"+(i));
			String xgje = request.getParameter("xgje"+(i));
			
			YypSfxmmx sfxmmx = new YypSfxmmx();
			sfxmmx.setBgbh(bgbh);
			sfxmmx.setXmbh(xmbh);
			sfxmmx.setXmmc(xmmc);
			sfxmmx.setJldw(jldw);
			
			if (je != null && !("").equals(je)) {
				BigDecimal jeBigDecimal = new BigDecimal(je);
				jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				sfxmmx.setJe(jeBigDecimal);
			}
			if (xgje != null && !("").equals(xgje)) {
				BigDecimal xgjeBigDecimal = new BigDecimal(xgje);
				xgjeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				sfxmmx.setXgje(xgjeBigDecimal);
			}
			
			sfxmmxDao.save(sfxmmx);
		}*/
		
		
		String str="0";
		entity.setId(Integer.parseInt(id));
		String jyks = entity.getJyksbh();
		entity.setJyks(jyks);
		String ywks = entity.getYwksbh();
		entity.setYwks(ywks);
		SysYh yh =AppUtil.getCurrentUser();
	    entity.setXgr(yh.getXm());
	    Date date = new Date();
	    entity.setXgsj(date);
	    String zh = entity.getBgbh();
	    if (zh.length() == 11) {
			entity.setZh(zh.substring(4, 6));
		}else {
			entity.setZh(zh.substring(4, 7));
		}
	    String yj = request.getParameter("ypyj");
	   
	    if(yj!=null&&!"".equals(yj)){
	    Integer ypyj = Integer.parseInt(yj);
	    	entity.setYpyj(ypyj);
	    }
	    if(request.getParameter("yjzt")!=null&&!"".equals(request.getParameter("yjzt"))){
	    	entity.setYjzt(Integer.parseInt(request.getParameter("yjzt")));
	    }
		dao.update(entity);
		//样品更新完后要更新对应报告编号的报告收费信息
		String  jyfydd = request.getParameter("jyfydd");
		Integer fydd = Integer.parseInt(jyfydd);
		String  bgbh = request.getParameter("bgbh");
		//获取报告编号进行查询报告收费所对应的id
		List<Map<String,Object>> ids = bgsfDao.getSfxxbyBgbh(bgbh);
		for (int i=0;i<ids.size();i++){
			Map<String, Object> map=(Map<String, Object>)ids.get(i);
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext())
			{
				String key = (String)iterator.next();
				Object bgbhObj = map.get(key);
				String idss = bgbhObj.toString();
			    YcwBgsf sfxx = bgsfDao.get(Integer.parseInt(idss));
//			    当检验费用已收费金额不为空的时候才进行下面的代码，排除掉无检验费用及通过技术协议扣费的样品
			    if(sfxx.getYsfje()!= null&&!"".equals(sfxx.getYsfje())){
//		如果检验费用不待定（默认）即选了检验项目产生费用
			    	if ( fydd  == 1 && sfxx.getYsfje().compareTo(new BigDecimal(0)) >= 0){
			    		sfxx.setBgbh(entity.getBgbh());
			    		sfxx.setYpmc(entity.getYpmc());
			    		sfxx.setSjdw(entity.getSjdw());
			    		sfxx.setKs_id(entity.getJyks());
			    		sfxx.setSsywks(entity.getYwks());
			    		if(entity.getJyfy() == null ||"".equals(entity.getJyfy())){
			    			sfxx.setJyfy(new BigDecimal(0));
			    			sfxx.setYsje(new BigDecimal(0));
			    		}else{
			    			sfxx.setJyfy(entity.getJyfy());
			    			sfxx.setYsje(entity.getJyfy().subtract(sfxx.getYsfje()));
			    		}
			    		sfxx.setJyjsrq(sfxx.getJyjsrq());
			    		sfxx.setBz(entity.getBz());
			    		sfxx.setYsfje(sfxx.getYsfje());
			    		sfxx.setSfzt(0);
			    		bgsfDao.update(sfxx);
//            如果检验费用选择了待定，肯定也是选择了检验项目，只是收费这块应收项目存为0并收费前台给予显示
			    	}else if( fydd == 0 && sfxx.getYsfje().compareTo(new BigDecimal(0)) >= 0) {
			    		sfxx.setBgbh(entity.getBgbh());
			    		sfxx.setYpmc(entity.getYpmc());
			    		sfxx.setSjdw(entity.getSjdw());
			    		sfxx.setKs_id(entity.getJyks());
			    		sfxx.setSsywks(entity.getYwks());
			    		if(entity.getJyfy() == null ||"".equals(entity.getJyfy())){
			    			sfxx.setJyfy(new BigDecimal(0));
			    		}else{
			    			sfxx.setJyfy(entity.getJyfy());
			    		}
			    		sfxx.setJyjsrq(sfxx.getJyjsrq());
			    		sfxx.setYsje(new BigDecimal(0));
			    		sfxx.setBz(entity.getBz());
			    		sfxx.setYsfje(sfxx.getYsfje());
			    		sfxx.setSfzt(0);
			    		bgsfDao.update(sfxx);
			    	}
			    }
			}
		}
		str = "1";
		return str;
	}
	
	@Transactional
	public void delete(Integer[] ids,String[] bgbh) {
		for(int i=0;i<ids.length;i++){
			yypYpxxDao.delete(ids[i]);
			yypYpxxDao.deletesf(bgbh[i]);
//			yypYpxxDao.deletejl(bgbh[i]);
		}
	}
	
	/**
	 * 样品类别（行业信息表）
	 * @author duanpeijun
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	public List<Map<String, Object>>getHymc() {
		return yypYpxxDao.getHymc();
	}
	
	/**
	 * 检验类型（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getDicByJylx(String zdzl) {
		return yypYpxxDao.getDicByJylx(zdzl);
	}
	
	/**
	 * 获取字号名称（下拉框）
	 * @author wangyong
	 * @date 2016年1月5日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getGczh() {
		return yypYpxxDao.getGczh();
	}
	
	/**
	 * 获取字号名称（下拉框）
	 * @author wangyong
	 * @date 2016年1月5日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>>getYbzh() {
		return yypYpxxDao.getYbzh();
	}
	
	/**
	 * 样品信息的二维码
	 * @author duanpeijun
	 * @date 2015年12月1日
	 * @param ypbh
	 * @return
	 */
	public List<Map<String, Object>> getYpewm(String ypbh) {
		return yypYpxxDao.getYpewm(ypbh);
	}
	
	/**
	 * 验证表格中的数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param row
	 * @return
	 */
	private String validate(Row row) {
        String v = getSV(row.getCell(0));
        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
        }
        return null;
    }
	
	/**
	 * 获取单元格
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param cell
	 * @return
	 */
	private String getSV(Cell cell)
    {
        if (cell == null)
            return null;
        switch (cell.getCellType())
        {
        case Cell.CELL_TYPE_NUMERIC:
            return "" + cell.getNumericCellValue();
        case Cell.CELL_TYPE_STRING:
            return StringUtils.trim(cell.getStringCellValue());
        default:
            break;
        }

        return null;
    }
	
	/**
	 * 微服务————样品信息搜索
	 * @author panweichi
	 * @date 2015年11月24日
	 * @param search    样品名称
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYpxx1(String search){
		return yypYpxxDao.getYpxx1(search);
	}
	
	/**
	 * 导入EXCEL数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param file
	 * @return
	 */
	@Transactional
	public String importMember(MultipartFile file) {
		if (file.getSize() == 0)
        {
            return "上传文件为空";
        }
		try
        {
			 Workbook hssfWorkbook = null;
		        try {
		        	hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		        } catch (Exception ex) {
		        	hssfWorkbook = new XSSFWorkbook(file.getInputStream());
		        }
            //HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		    Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if (hssfSheet != null)
            {
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++)
                {
                    //HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null)
                    {
                        String result = validate(hssfRow);
                        if (result != null) {
                            return result;
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YypYpxx ypxx = new YypYpxx();
                        String ypbh=getSV(hssfRow.getCell(0));
                        String bgbh=getSV(hssfRow.getCell(1));
                        String ewmbh=getSV(hssfRow.getCell(2));
                        String ypmc=getSV(hssfRow.getCell(3));
                        String yplx=getSV(hssfRow.getCell(4));
                        String jylx=getSV(hssfRow.getCell(5));
                        String lyfs=getSV(hssfRow.getCell(6));
                        if(lyfs != null && !("").equals(lyfs)){
                        	Double lyfss = Double.parseDouble(lyfs);    //String 转 Integer
                        	int fsly = lyfss.intValue();
                        	ypxx.setLyfs(fsly);
                        }
                        String szcs=getSV(hssfRow.getCell(7));
                        String ggxh=getSV(hssfRow.getCell(8));
                        String scrqpc = getSV(hssfRow.getCell(9));
                        String ypdjlx=getSV(hssfRow.getCell(10));
                        String ypzt=getSV(hssfRow.getCell(11));
                        String cydd =getSV(hssfRow.getCell(12));
                        String cyrq=getSV(hssfRow.getCell(13));
                        if(cyrq != null && !("").equals(cyrq)){
                        	Date rqcy = sdf.parse(cyrq);   // String 转 Date
                        	ypxx.setCyrq(rqcy);
                        }
                        String cyjs = getSV(hssfRow.getCell(14));
//                        if(cyjs != null && !("").equals(cyjs)){
//                        	Double slyp = Double.parseDouble(cyjs);    //String 转 Integer
//                        	int cyjss = slyp.intValue();
//                        	ypxx.setCyjs(cyjss);;
//                        }
                        ypxx.setCyjs(cyjs);
                        String ypsl  = getSV(hssfRow.getCell(15));
//                        if(ypsl != null && !("").equals(ypsl)){
//                        	Double slyp = Double.parseDouble(ypsl);    //String 转 Integer
//                        	int ypsls = slyp.intValue();
//                        	ypxx.setYpsl(ypsls);
//                        }
                        ypxx.setYpsl(ypsl);
                        String wtdw=getSV(hssfRow.getCell(16));
                        String wtdwdz = getSV(hssfRow.getCell(17));
                        String sjdw = getSV(hssfRow.getCell(18));
                        String sjdwdz=getSV(hssfRow.getCell(19));
                        String lxr = getSV(hssfRow.getCell(20));
                        String dh = getSV(hssfRow.getCell(21));
                        String yb = getSV(hssfRow.getCell(22));
                        String scdw = getSV(hssfRow.getCell(23));
                        String scdwdz = getSV(hssfRow.getCell(24));
                        String scdwlxr = getSV(hssfRow.getCell(25));
                        String scdwdh = getSV(hssfRow.getCell(26));
                        String scdwyb = getSV(hssfRow.getCell(27));
                        String bgfsfs = getSV(hssfRow.getCell(31));
                        if(bgfsfs != null && !("").equals(bgfsfs)){
                        	Double fsfs = Double.parseDouble(bgfsfs);    //String 转 Integer
                        	int bgfsfss = fsfs.intValue();
                        	ypxx.setBgfsfs(bgfsfss);
                        }
                        String jyhxtk = getSV(hssfRow.getCell(32));
                        if(jyhxtk != null && !("").equals(jyhxtk)){
                        	Double hxtk = Double.parseDouble(jyhxtk);
                        	int yhxtk = hxtk.intValue();
                        	ypxx.setYhxtk(yhxtk);
                        }
                        String cyry = getSV(hssfRow.getCell(33));
                        String jyfyry = getSV(hssfRow.getCell(34));
                        String jyks = getSV(hssfRow.getCell(35));
                        String ywks = getSV(hssfRow.getCell(36));
                        String jyhth = getSV(hssfRow.getCell(37));
                        String ewmtp = getSV(hssfRow.getCell(38));
                        String jyfy = getSV(hssfRow.getCell(39));
                        String fydd = getSV(hssfRow.getCell(40));
                        if(fydd != null && !("".equals(fydd))){
                        	Double ddfy = Double.parseDouble(fydd);
                        	int jyfydd = ddfy.intValue();
                        	ypxx.setJyfydd(jyfydd);
                        }
                        String bz = getSV(hssfRow.getCell(41));
                        
                        ypxx.setYpbh(ypbh);
                        ypxx.setBgbh(bgbh);
                        ypxx.setEwmbh(ewmbh);
                        ypxx.setYpmc(ypmc);
                        ypxx.setYplx(yplx);
                        ypxx.setJylx(jylx);
                        ypxx.setSzcs(szcs);
                        ypxx.setGgxh(ggxh);
                        ypxx.setScrqpc(scrqpc);
                        ypxx.setYpdj(ypdjlx);
                        ypxx.setYpzt(ypzt);
                        ypxx.setCydd(cydd);
                        ypxx.setWtdw(wtdw);
                        ypxx.setWtdwdz(wtdwdz);
                        ypxx.setSjdw(sjdw);
                        ypxx.setSjdwdz(sjdwdz);
                        ypxx.setLxr(lxr);
                        ypxx.setDh(dh);
                        ypxx.setYb(yb);
                        ypxx.setScdw(scdw);
                        ypxx.setScdwdh(scdwdz);
                        ypxx.setScdwlxr(scdwlxr);
                        ypxx.setScdwdh(scdwdh);
                        ypxx.setScdwyb(scdwyb);
                        ypxx.setCyry(cyry);
                        ypxx.setJcfyry(jyfyry);
                        ypxx.setJyks(jyks);
                        ypxx.setYwks(ywks);
                        ypxx.setJyhth(jyhth);
                        ypxx.setEwmtp(ewmtp);
                        //ypxx.setJyfy(jyfy);
                        ypxx.setBz(bz);
                        yypYpxxDao.save(ypxx);
                    }
                }
            }
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
        	return e.getMessage();
        }               
		return null;
	}
	
	
	/**
	 * 导出Excel
	 * @author duanpeijun
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		if(code!=null){
			code=java.net.URLDecoder.decode(code,"UTF-8");
		}
		List<Map<String,Object>> list=yypYpxxDao.getList(code);
		String[] header=new String[]{"样品编号","报告编号","二维码编号","样品名称","样品类型","检验类型","来样方式（0:直送;1:快递）","所在城市","规格型号","生产日期批次","样品等级类型","样品状态",
				"抽样地点","抽样日期（yyyy-mm-dd）","抽样基数","样品数量","委托单位","委托单位地址","受检单位","受检单位地址","联系人","电话","邮编","生产单位","生产单位地址","生产单位联系人","生产单位电话",
				"生产单位邮编","检验科室编号","检验依据","检验项目","报告发送方式（0:邮寄;1:自取[本所];2:自取[中心]）","检验后须退库（0:退;1:不退;）","抽样人员","检查封样人员","检验科室","业务科室","业务科室编号",
				"检验合同号","二维码图片","检验费用","检验费用待定（0:待定;1:不待定;）","样品检测状态","样品登记人员","样品登记时间","样品附件","到样日期","备注"};
				
		String[] keys=new String[]{"YPBH","BGBH","EWMBH","YPMC","YPLX","JYLX","LYFS","SZCS","GGXH","SCRQPC","YPDJ","YPZT","CYDD","CYRQ","CYJS","YPSL","WTDW",
				"WTDWDZ","SJDW","SJDWDZ","LXR","DH","YB","SCDW","SCDWDZ","SCDWLXR","SCDWDH","SCDWYB","JYKSBH","JYYJ","JYXM","BGFSFS","YHXTK","CYRY","JCFYRY",
				"JYKS","YWKS","YWKSBH","JYHTH","EWMTP","JYFY","JYFYDD","JYZT","DJRY","DJSJ","FJ","DYRQ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 根据样品编号获取样品信息
	 * @author liujiansen
	 * @date 2015年12月14日
	 * @param bgbh
	 * @return
	 */
	public List<Map<String,Object>> getYpByBh(String bgbh){
		return yypYpxxDao.getYp(bgbh);
	}
	
	/**
	 * 根据报告编号查询样品ID
	 * @author duanpeijun
	 * @date 2015年12月23日
	 * @param bgbh
	 * @return
	 */
	public List<Map<String, Object>> getYpbgbh(String bgbh){
		return yypYpxxDao.getYpbgbh(bgbh);
	}
	
	/**
	 * 根据字号获取字号名称
	 * @author liujiansen
	 * @date 2015年12月14日
	 * @param zh
	 * @return
	 */
	public List<Map<String,Object>> getZhmc(String zh,String djlx){
		return yypYpxxDao.getZhmc(zh,djlx);
	}
	
	/**
	 * 根据字号获取字号名称
	 * @author liujiansen
	 * @date 2015年12月14日
	 * @param zh
	 * @return
	 */
	public List<Map<String,Object>> getRztb(String rzfl){
		return yypYpxxDao.getRztb(rzfl);
	}
	
	/**
	 * 根据报告编号获取检验项目
	 * @author liujiansen
	 * @date 2015年12月14日
	 * @param zh
	 * @return
	 */
	public List<Map<String,Object>> getJyyj(String bgbh){
		return yypYpxxDao.getJyyj(bgbh);
	}
	
	/**
	 * 样品复制时获取样品信息列表	
	 * @author wangyong
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> ypfzList(String ypbhcx,String ypmccx,String djlx,String ypjzcs){
		return yypYpxxDao.ypfzList(ypbhcx, ypmccx,djlx,ypjzcs);
	}
	
	/**
	 * 验证样品编号和报告编号是否已存在
	 * @author wangyong
	 * @date 2015年12月28日
	 * @param 
	 * @return
	 */
	public String yzbgbh(String bgbh) {
		String str = "0";
		List<Map<String, Object>> list = yypYpxxDao.yzbgbh(bgbh);
		if (list.size() > 0) {
			str = "1";
		}
		return str;
	}
/**
 * 通过ybbh获取检验科室
 * @author liangkaidi
 * @date 2016-3-17
 * @param ypbh
 * @return
 */
@Transactional	
public List<Map<String, Object>> getjyks(String ypbh) {
		return yypYpxxDao.getjyks(ypbh);
	}

@Transactional
public List<Map<String, Object>> getypbh(String businessKey) {
	return yypYpxxDao.getypbh(businessKey);
}
/**
 * 通过ybbh获取检验费用及所需数据
 * @author liangkaidi
 * @date 2016-3-17
 * @param ypbh
 * @return
 */
@Transactional
public List<Map<String, Object>> getValue(String bgbh) {
	return yypYpxxDao.getValue(bgbh);
}

/**
 * 保存检验费用修改
 * @author liangkaidi
 * @date 2016-3-17
 * @param ypbh
 * @return
 */
@Transactional
public String saveValue(HttpServletRequest request) {
    String str="";
	String id = request.getParameter("id");
	String bid = request.getParameter("bid");
	String jyfy = request.getParameter("jyfy");
	String jyhth = request.getParameter("jyhth");
	if(jyhth==null || "".equals(jyhth)){
	YcwBgsf bgsf = bgsfDao.get(Integer.parseInt(bid));
	bgsf.setJyfy(new BigDecimal(jyfy));
	bgsf.setYsje(new BigDecimal(jyfy).subtract(bgsf.getYsfje()));
	YypYpxx ypxx = yypYpxxDao.get(Integer.parseInt(id));
	ypxx.setJyfy(new BigDecimal(jyfy));
	str ="1";
	}else{
		BigDecimal kobe = null ;
		String ids = xyxxDao.getXyxxbyHth(jyhth).get(0).get("id").toString();
		YjsfwXyxx xyxx = xyxxDao.get(Integer.parseInt(ids));
		YypYpxx ypxx = yypYpxxDao.get(Integer.parseInt(id));
		if(ypxx.getJyfy().compareTo(BigDecimal.ZERO)==0){
			kobe = xyxx.getSyje();
		}else{
			kobe = xyxx.getSyje().add(ypxx.getJyfy());
		}
		if(kobe.compareTo(new BigDecimal(jyfy))== 1){
			xyxx.setSyje(kobe.subtract(new BigDecimal(jyfy)));
			ypxx.setJyfy(new BigDecimal(jyfy));
			str="1";
		}else{
			str="3";
		}
	}
	return str;
}

@Transactional
public List<Map<String, Object>> checkhth(String jyhth) {
	List<Map<String,Object>> dlmList = yypYpxxDao.checkhth(jyhth);
	return dlmList;
	
}
}
