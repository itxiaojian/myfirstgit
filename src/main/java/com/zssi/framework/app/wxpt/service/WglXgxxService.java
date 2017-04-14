package com.zssi.framework.app.wxpt.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.wxpt.dao.WglXgxxDao;
import com.zssi.framework.app.wxpt.dao.WglXgxxHbDao;
import com.zssi.framework.app.wxpt.model.GlHbxx;
import com.zssi.framework.app.wxpt.model.GlSqxx;

/**
*微管理
@Author oufeng	
@Date 2015年12月15日 上午10:55:51
@Version 1.0
*/
@Service
public class WglXgxxService extends BaseBO<GlSqxx>{
	
	@Autowired
	private WglXgxxDao  wglXgxxdao;
	
	@Autowired
	private WglXgxxHbDao  wfwXgxxHbdao;
	
	/**
	 * 保存我的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 * @throws SQLException 
	 * @throws SerialException 
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	@Transactional
	public String saveWdsq(HttpServletRequest request) 
			throws UnsupportedEncodingException, ParseException {
		String str = "";
		int  yhbh =0;
		GlSqxx  glsqxx = new GlSqxx();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //用于存日期
		String openId = request.getParameter("openId");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String sqly = request.getParameter("sqly");
		String sqlx = request.getParameter("sqlx");
		String shr = request.getParameter("shr");
		String csr = request.getParameter("csr");
		if(openId==null || "".equals(openId)){
			yhbh=1;
			glsqxx.setSqr(yhbh+"");
		}else{
			List<Map<String, Object>> user = this.getUser(openId);
			if (user.size() != 0) {
				glsqxx.setSqr(user.get(0).get("yhid") + "");
			}
		}
		 glsqxx.setSqrq(new Date());
		 glsqxx.setSjsj(sdf.parse(starttime));
		 glsqxx.setXjsj(sdf.parse(endtime));
		 glsqxx.setSqlx(sqlx);
		 glsqxx.setSqnr(sqly);
		 glsqxx.setWpzt(1);
		 glsqxx.setShr(shr);
		 glsqxx.setCsr(csr);
		wglXgxxdao.save(glsqxx);
		str = "1";
		return str;
	}
	
	/**
	 * 保存工作汇报
	 * @author panweichi
	 * @date 2015年12月29日
	 * @param request
	 * @return
	 * @throws SQLException 
	 * @throws SerialException 
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
 */
	@Transactional
	public String saveGzhb(HttpServletRequest request) 
			throws UnsupportedEncodingException, ParseException {
	   String str = "";
		int  yhbh =0;
		GlHbxx  glhbxx = new GlHbxx();
	   //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //用于存日期
	    String openId = request.getParameter("openId");
		String starttime = request.getParameter("starttime");
		String hbnr = request.getParameter("hbnr");
	    String hblx = request.getParameter("hblx");
		String jsr= request.getParameter("hbr");
		if(openId==null || "".equals(openId)){
			yhbh=1;
			glhbxx.setHbr(yhbh+"");
		}else{
			List<Map<String, Object>> user = this.getUser(openId);
			if (user.size() != 0) {
				glhbxx.setHbr(user.get(0).get("yhid") + "");
			}
		}
		glhbxx.setHbrq(new Date());
		glhbxx.setHbrq(sdf.parse(starttime));
	   glhbxx.setHblx(hblx);
	   glhbxx.setHbnr(hbnr);
	   glhbxx.setJsr(jsr);
	   wfwXgxxHbdao.save(glhbxx);
	  str = "1";
		return str;
	}
	
	/**
	 * 审核通过
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public String updateSqxxtg(HttpServletRequest request) {
		String str = "";
		String yhbh="";
//		int  yhbh =0;
		String id = request.getParameter("id");
		String shyj = request.getParameter("shyj");
		String openId = request.getParameter("openId");
		if(openId==null || "".equals(openId)){
//			SysYh  yh =AppUtil.getCurrentUser();
//			yhbh = yh.getYhbh()+"";
			yhbh = "1" ;
		}else{
		List<Map<String, Object>> user = this.getUser(openId);
		if (user.size() != 0) {
//		yhbh = user.get(0).get("yhid")+"";
			yhbh = user.get(0).get("yhid")+"";
		}
		}
	wglXgxxdao.updateSqxxtg(id,shyj,yhbh);
		str = "1";
		return str;
	}
	
	/**
	 * 申请驳回
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public String updateSqxxbh(HttpServletRequest request) {
		String str = "";
		String yhbh="";
//		int  yhbh =0;
		String id = request.getParameter("id");
		String shyj = request.getParameter("shyj");
		String openId = request.getParameter("openId");
		if(openId==null || "".equals(openId)){
//			SysYh  yh =AppUtil.getCurrentUser();
//			yhbh = yh.getYhbh()+"";
			yhbh = "1" ;
		}else{
		List<Map<String, Object>> user = this.getUser(openId);
		if (user.size() != 0) {
//		yhbh = user.get(0).get("yhid")+"";
			yhbh =user.get(0).get("yhid")+"";
		}
		}
	wglXgxxdao.updateSqxxbh(id,shyj,yhbh);
		str = "1";
		return str;
	}
	
	/**
	 * 获取审核人
	 * @param mpnewsId
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getShr(){
	       return 	wglXgxxdao.getShr();
	}
	
	/**
	 * 获取用户
	 * @param mpnewsId
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getUser(String openId){
	       return 	wglXgxxdao.getUser(openId);
	}
	
	/**
	 * 我的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getWdsqList(String yhbh,String time){
	       return 	wglXgxxdao.getWdsqList(yhbh,time);
	}
	
	/**
	 * 需要我审批的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getXwdsqList(String yhbh,String time){
	       return 	wglXgxxdao.getXwdsqList(yhbh,time);
	}
	
	/**
	 * 抄送我审批的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getCswdsqList(String yhbh,String time){
	       return 	wglXgxxdao.getCswdsqList(yhbh,time);
	}
	
	/**
	 *获取汇报
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getHb(String openId,String time){
	       return 	wglXgxxdao.getHb(openId,time);
	}
	
	/**
	 *获取工作汇报详情
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param request
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>> getHbXq(String id){
	       return 	wglXgxxdao.getHbXq(id);
	}
	
//	/**
//	 * 我可以查看的工作汇报
//	 * @author panweichi
//	 * @date 2015年12月29日
//	 * @param request
//	 * @return
//	 */
//	@Transactional
//	public  	List<Map<String, Object>> getCsgzhbList(String yhbh){
//	       return 	wglXgxxdao.getCsgzhbList(yhbh);
//	}
	
	/**
	 * 获取我的申请的详情
	 * @param mpnewsId
	 * @return
	 */
	@Transactional
	public  	List<Map<String, Object>>getWdsqDetail(String id){
	       return 	wglXgxxdao.	getWdsqDetail(id);
	}
/**
 * 获取检验科室相关人员的openid
 * @author liangkaidi
 * @date 2016-3-16
 * @param jyks
 * @return
 */
	public List<Map<String, Object>> getopenId(String jyks) {
		// TODO Auto-generated method stub
		 return 	wglXgxxdao.	getopenId(jyks);
	}

public List<Map<String, Object>> getbgbh(String ypbh) {
	// TODO Auto-generated method stub
	return wglXgxxdao.getbgbh(ypbh);
}

}