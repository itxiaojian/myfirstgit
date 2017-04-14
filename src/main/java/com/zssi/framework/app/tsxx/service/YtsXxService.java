package com.zssi.framework.app.tsxx.service;

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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jybzgl.model.YjyBzxx;
import com.zssi.framework.app.khgl.dao.YkhKhxxDao;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.tsxx.dao.YtsXxDao;
import com.zssi.framework.app.tsxx.model.YtsXx;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;
import com.zssi.framework.app.yhgl.model.SysYhxx;

@Service
public class YtsXxService extends BaseBO<YtsXxDao> {
	@Autowired
	private YtsXxDao ytsXxDao;
	@Autowired
	private SysYhDao sysYhDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	public Pagination<Map<String, Object>> getTsxxList(Integer start,
			Integer limit, String cs) {

		return ytsXxDao.getTsxxList(start, limit, cs);

	}

	@Transactional
	public void save(YtsXx entity) {
		ytsXxDao.save(entity);
	}

//	@Transactional
//	public void update(YtsXx entity, String ID) {
//		entity.setId(Integer.parseInt(ID));
//		ytsXxDao.update(entity);
//	}
	
	/**
	 * 在检验标页面中点击提交，保存检验标准名称这个字段到样品检验页面的检验依据字段
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @param id
	 * @return
	 */
//	@Transactional
//	public SysYh getyhmc(String yhbh){
//		return sysYhDao.get(Integer.parseInt(yhbh));
//	}
	
//	@Transactional
//	public YkhKhxx getkhmcXg(String id){
//		return ykhKhxxDao.get(Integer.parseInt(id));
//	}

	@Transactional
	public void delete(Integer[] ids) {
		for (int i = 0; i < ids.length; i++) {
			ytsXxDao.delete(ids[i]);
		}
	}
	
	/**
	 * 在检验标页面中点击提交，保存检验标准名称这个字段到样品检验页面的检验依据字段
	 * @author duanpeijun
	 * @date 2015年11月11日
	 * @param id
	 * @return
	 */
//	@Transactional
//	public YkhKhxx getjybzmc(String id){
//		return ykhKhxxDao.get(Integer.parseInt(id));
//	}
/**
 * 投诉页面————客户信息
 * @author liangkaidi
 * @date 2015-11-12
 * @param khbh
 * @return
 */
	
//	@Transactional
//	public List<Map<String, Object>> getKhxx(String code){
//		return ykhKhxxDao.getKhxx(code);
//	}
		/**
		 * 点击修改拉取内容
		 * @author liangkaidi
		 * @date 2015-11-11
		 * @param id
		 * @return
		 */		

		
	@Transactional
	public YtsXx getXg(String id) {
		return ytsXxDao.get(Integer.parseInt(id));
	}	
	/**
	 * 查看
	 * @author liangkaidi
	 * @date 2015-12-3
	 * @param id
	 * @return
	 */
	@Transactional
	public YtsXx getCk(String id) {
		return ytsXxDao.get(Integer.parseInt(id));
	}	
	
	
	/**
	 * 点击处理拉取内容
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param id
	 * @return
	 */		

	
	@Transactional
	public YtsXx getCl(String id) {
		return ytsXxDao.get(Integer.parseInt(id));
	}

	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ytsXxDao.getDicByLx(zdzl);
	}
	/**
	 * 客户信息增加提交
	 * @author liujiansen
	 * @date 2015年9月16日
	 * @param request
	 * @param entity 
	 * @return
	 * @throws  
	 */
	@Transactional
	public String saveTs(HttpServletRequest request, YtsXx entity) {
		
		

		String str="";
		SysYh yh =AppUtil.getCurrentUser();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
              YtsXx tsxx=new YtsXx();
//		request.getParameter("hybh")是获取前台jsp中的input里的name
		String tsr = request.getParameter("tsr");
		String tslx = request.getParameter("tslx");
		String tsnr = request.getParameter("tsnr");
		String btsr = request.getParameter("btsr");
		String clzt = request.getParameter("clzt");
		Integer clztiInteger=null;
		
         if(clzt != null && !("").equals(clzt)){
        	 clztiInteger  =Integer.parseInt(clzt);
        	 tsxx.setClzt(clztiInteger);
        	 
         }
		String cljg = request.getParameter("cljg");
		String clr = request.getParameter("clr");
		String bz = request.getParameter("bz");
		String clrq = request.getParameter("clrq");
		Date qyrq = null;
		 if(clrq != null && !("").equals(clrq)){
			 try {
				qyrq = sdf.parse(clrq);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         	tsxx.setClrq(qyrq);
         }
		 String tsrq = request.getParameter("tsrq");
			Date tsrqDate = null;
			 if(tsrq != null && !("").equals(tsrq)){
				 try {
					 tsrqDate = sdf.parse(tsrq);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         	tsxx.setTsrq(tsrqDate);
	         }
		entity.setTsr(tsr);
		//获取当前用户名
		entity.setClr(yh.getXm());
		entity.setTsr(yh.getXm());
		entity.setTslx(tslx);
		entity.setTsnr(tsnr);
		entity.setBtsr(btsr);
		entity.setTsrq(tsrqDate);
		entity.setClzt(clztiInteger);
		entity.setCljg(cljg );
		entity.setClr(clr);
		entity.setClrq(qyrq);
		entity.setBz(bz);
	
		ytsXxDao.save(entity);
		str="1";
		return str;
	}

	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param entity
	 * @param ID
	 * 修改内容上传
	 * @return 
	 */
@Transactional
	public String update(HttpServletRequest request, String id) {
String str="";
YtsXx entity=ytsXxDao.get(Integer.parseInt(id));
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
YtsXx tsxx=new YtsXx();
String tsr = request.getParameter("tsr");
String tslx = request.getParameter("tslx");
String tsnr = request.getParameter("tsnr");
String btsr = request.getParameter("btsr");
String clzt = request.getParameter("clzt");
Integer clztiInteger=null;

 if(clzt != null && !("").equals(clzt)){
	 clztiInteger  =Integer.parseInt(clzt);
	 tsxx.setClzt(clztiInteger);
	 
 }
 
String cljg = request.getParameter("cljg");
String clr = request.getParameter("clr");
String bz = request.getParameter("bz");
String clrq = request.getParameter("clrq");
Date qyrq = null;
 if(clrq != null && !("").equals(clrq)){
	 try {
		qyrq = sdf.parse(clrq);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	tsxx.setClrq(qyrq);
 }
 String tsrq = request.getParameter("tsrq");
	Date tsrqDate = null;
	 if(tsrq != null && !("").equals(tsrq)){
		 try {
			 tsrqDate = sdf.parse(tsrq);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	tsxx.setTsrq(tsrqDate);
     }
entity.setTsr(tsr);
entity.setTslx(tslx);
entity.setTsnr(tsnr);
entity.setBtsr(btsr);
entity.setTsrq(tsrqDate);
entity.setClzt(clztiInteger);
entity.setCljg(cljg );
entity.setClr(clr);
entity.setClrq(qyrq);
entity.setBz(bz);

ytsXxDao.update(entity);
str="1";
return str;


	}
	

/**
 * 
 * @author liangkaidi
 * @date 2015-9-23
 * @param entity
 * @param ID
 * 处理内容上传
 * @return 
 */
@Transactional
public String deal(HttpServletRequest request, String id) {
String str="";
SysYh yh =AppUtil.getCurrentUser();

YtsXx entity=ytsXxDao.get(Integer.parseInt(id));
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //用于存日期
YtsXx tsxx=new YtsXx();
String tsr = request.getParameter("tsr");
String tslx = request.getParameter("tslx");
String tsnr = request.getParameter("tsnr");
String btsr = request.getParameter("btsr");
String zdz = request.getParameter("zdz");
Integer zdzInteger=null;

if(zdz != null && !("").equals(zdz)){
	 zdzInteger  =Integer.parseInt(zdz);
	 tsxx.setClzt(zdzInteger);
	 
}

String clzt = request.getParameter("clzt");
Integer clztiInteger=null;

 if(clzt != null && !("").equals(clzt)){
	 clztiInteger  =Integer.parseInt(clzt);
	 tsxx.setClzt(clztiInteger);
	 
 }
String cljg = request.getParameter("cljg");
String clr = request.getParameter("clr");
String bz = request.getParameter("bz");
String clrq = request.getParameter("clrq");
Date qyrq = null;
if(clrq != null && !("").equals(clrq)){
 try {
	qyrq = sdf.parse(clrq);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	tsxx.setClrq(qyrq);
}
String tsrq = request.getParameter("tsrq");
Date tsrqDate = null;
 if(tsrq != null && !("").equals(tsrq)){
	 try {
		 tsrqDate = sdf.parse(tsrq);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	tsxx.setTsrq(tsrqDate);
 }

entity.setClzt(clztiInteger);
entity.setCljg(cljg );
entity.setClrq(qyrq);
entity.setBtsr(btsr);
//获取当前用户名
entity.setClr(yh.getXm());
 
ytsXxDao.get(Integer.parseInt(id));
ytsXxDao.update(entity);
str="1";
return str;


}

/**
 * （数据字典）
 * @author liangkaidi
 * @date 2015年9月28日
 * @param str
 * @return
 */
public List<Map<String, Object>>getDicByList(String zdzl) {
	return ytsXxDao.getDicByList(zdzl);
}

/**
	 * 用户信息
	 * @author liangkaidi
	 * @date 2015-11-24
	 * @param code
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getYh(String code){
		return ytsXxDao.getYh(code);
	}
	/**
	 * 获取用户
	 * @author liangkaidi
	 * @date 2015-11-30
	 * @param yhbh
	 * @return
	 */
	@Transactional
	public SysYhxx getyhmc(String yhbh) {
		return sysYhDao.get(Integer.parseInt(yhbh));
	}
/**
 * 查看
 * @author liangkaidi
 * @date 2015-12-3
 * @param id
 * @return
 */
	@Transactional
	public YtsXx getClCk(String id) {
		return ytsXxDao.get(Integer.parseInt(id));
	}




}
