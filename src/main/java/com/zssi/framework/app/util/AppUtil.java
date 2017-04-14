package com.zssi.framework.app.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.likegene.framework.core.Pager;
import com.likegene.framework.core.SettingUtil;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.dto.WeiXinOauth2Token;
import com.zssi.framework.app.support.weixin.WeixinUtils;
import com.zssi.framework.app.sys.model.SysYh;

/**
 * 
 * Description of the class
 * 
 * @author lxt
 * @version 1.0
 * @since 2013-3-27
 */
@Component
public class AppUtil implements ServletContextAware, ApplicationContextAware {

	protected static Logger logger = LoggerFactory.getServiceLog(AppUtil.class);

	private static ApplicationContext appContext;

	private static String appWebappPath;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		appContext = applicationContext;
	}

	public static <T> T getBean(String beanId) {
		return (T) appContext.getBean(beanId);
	}

	public static <T> T getBean(Class clazz) {
		return (T) appContext.getBean(clazz);
	}

	public static boolean containBean(String name) {
		return appContext.containsBean(name);
	}
	
	/**
	 * 微服务每个功能权限
	 * @author duanpeijun
	 * @date 2015年7月15日
	 * @param request
	 * @param response
	 * @return
	 */
	public static ModelAndView runWx(String openId) {
		ModelAndView mav=null;
		if (openId == null || "".equalsIgnoreCase(openId)) {
			mav = new ModelAndView("/error/wxd");
			return mav;
		}
		return mav;
	}

	/*public static SysUser getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext != null) {
			Authentication auth = securityContext.getAuthentication();
			if (auth != null) {
				Object principal = auth.getPrincipal();
				if (principal instanceof SysUser) {
					return (SysUser) principal;
				}
			} else {
				logger.error("getCurrentUser",
						"WARN: securityContext cannot be lookuped using SecurityContextHolder.");
			}
		}
		return null;
	}*/
	
	public static SysYh getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext != null) {
			Authentication auth = securityContext.getAuthentication();
			if (auth != null) {
				Object principal = auth.getPrincipal();
				if (principal instanceof SysYh) {
					return (SysYh) principal;
				}
			} else {
				logger.error("getCurrentUser",
						"WARN: securityContext cannot be lookuped using SecurityContextHolder.");
			}
		}
		return null;
	}

	/**
	 * 只序列化inclusionProps(需要序列化的属性名称)中指定的属性
	 * 
	 * @author Administrator
	 * @since 2012-12-20
	 * @param obj
	 * @param clazz
	 *            防止循环
	 * @param exclusionProps
	 *            防止懒加载异常
	 * @return
	 */
	public static String toJsonInClusion(Object obj, final Class<?> clazz,
			final String... inclusionProps) {
		final List<String> props = new ArrayList<String>();
		if (obj != null && obj.getClass().equals(Pager.class)) {
			props.add("start");
			props.add("pageSize");
			props.add("rowCount");
			props.add("items");
		}
		Gson gson = new GsonBuilder()
				.addSerializationExclusionStrategy(new ExclusionStrategy() {
					@Override
					public boolean shouldSkipField(FieldAttributes arg0) {
						if (clazz != null
								&& clazz.equals(arg0.getDeclaredClass())) {
							return true;
						}

						for (String string : inclusionProps) {
							if (string.equals(arg0.getName())) {
								return false;
							}
						}
						for (String string : props) {
							if (string.equals(arg0.getName())) {
								return false;
							}
						}
						return true;
					}

					@Override
					public boolean shouldSkipClass(Class<?> arg0) {
						return false;
					}
				}).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

		return gson.toJson(obj);
	}

	/**
	 * 除inclusionProps(不需要序列化的属性名称)，其他属性全序列化
	 * 
	 * @author Administrator
	 * @since 2012-12-20
	 * @param obj
	 * @param clazz
	 *            防止循环
	 * @param exclusionProps
	 *            防止懒加载异常
	 * @return
	 */
	public static String toJsonExclusion(Object obj, final Class<?> clazz,
			final String... exclusionProps) {
		if (obj == null) {
			return "";
		}
		Gson gson = new GsonBuilder()
				.addSerializationExclusionStrategy(new ExclusionStrategy() {
					@Override
					public boolean shouldSkipField(FieldAttributes arg0) {
						if (clazz != null
								&& clazz.equals(arg0.getDeclaredClass())) {
							return true;
						}

						for (String string : exclusionProps) {
							if (string.equals(arg0.getName())) {
								return true;
							}
						}
						return false;
					}

					@Override
					public boolean shouldSkipClass(Class<?> arg0) {
						return false;
					}
				}).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

		return gson.toJson(obj);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		appWebappPath = servletContext.getRealPath("");
		servletContext.setAttribute("pagesize",
				SettingUtil.getSetting("pagesize", Integer.class));
	}

	public static String getAppWebappPath() {
		return appWebappPath;
	}

	public static int getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) * 10000 + (1 + cal.get(Calendar.MONTH))
				* 100 + cal.get(Calendar.DATE);
	}

	public static long getCurrentDatetime() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) * 10000000000L
				+ (1 + cal.get(Calendar.MONTH)) * 100000000L
				+ cal.get(Calendar.DATE) * 1000000 + cal.get(Calendar.HOUR)
				* 10000 + cal.get(Calendar.MINUTE) * 100
				+ cal.get(Calendar.SECOND);
	}
	
	public static int getWeekOfYear(Calendar cl){
        if(cl.get(Calendar.MONTH)==Calendar.JANUARY && cl.get(Calendar.WEEK_OF_YEAR)>50){
            return cl.get(Calendar.YEAR)-1;
        }else{
            return cl.get(Calendar.YEAR);
        }
    }
	
    // 获得 周日  的日期
	public static String getPreviousSunday(String time) {
		Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
	    try {
			date=sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		if(1 == dayWeek) {  
		    cal.add(Calendar.DAY_OF_MONTH, -1);  
		}  
		//System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
		int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值   
		//String imptimeBegin = sdf.format(cal.getTime());  
		//System.out.println("所在周星期一的日期："+imptimeBegin);  
		cal.add(Calendar.DATE, 6);  
		String imptimeEnd = sdf.format(cal.getTime());  
		//System.out.println("所在周星期日的日期："+imptimeEnd);
		return imptimeEnd;
    }
	
	// 获得 周一的日期
	public static String getCurrentMonday(String time) { 
		Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
	    try {
			date=sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		if(1 == dayWeek) {  
		    cal.add(Calendar.DAY_OF_MONTH, -1);  
		}  
		//System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期  
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
		int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值   
		String imptimeBegin = sdf.format(cal.getTime());  
		//System.out.println("所在周星期一的日期："+imptimeBegin);  
		//cal.add(Calendar.DATE, 6);  
		//String imptimeEnd = sdf.format(cal.getTime());  
		//System.out.println("所在周星期日的日期："+imptimeEnd); 
		return imptimeBegin;
	}
	
	/**
	 * 获取用户真实IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) { 
	     String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getHeader("Proxy-Client-IP"); 
	     } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	         ip = request.getHeader("WL-Proxy-Client-IP"); 
	     } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	          ip = request.getRemoteAddr(); 
	      } 
	     return ip; 
	  }
	
	/**
	 * 获取微信关注用户的openId的
	 * @author liujiansen
	 * @date 2015年6月17日
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getOpenId(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String code = request.getParameter("code"); //获取code
		String openId ="";
		if(code == null || "".equalsIgnoreCase(code)){
			 
		}else{
	        if (!"authdeny".equals(code)) {
	                WeiXinOauth2Token weiXinOauth2Token = WeixinUtils.getOauth2AccessToken(code);//根据code获取 页面授权信息类
	                openId = weiXinOauth2Token.getOpenId();//获取当前微信用户的openId
	        }
		}
        return openId;
	}
	
	/**
	 * 取得指定时间的前一天
	 * @author liujiansen
	 * @date 2015年6月19日
	 * @return
	 */
	public static Date getBefCurrentDay(Date date) {
    	//Calendar cal = Calendar.getInstance();
    	//return cal.get(Calendar.YEAR) * 10000 + (cal.get(Calendar.MONTH)+1) * 100+cal.get(Calendar.DAY_OF_MONTH)-1;
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.DAY_OF_MONTH, -1);
    	date = calendar.getTime();
    	//return calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH)+1) * 100+calendar.get(Calendar.DAY_OF_MONTH);
    	return date;
    }
	
	/**
	 * 三个时间比较
	 * @author liujiasen
	 * @date 2015年7月7日
	 * @param kssj
	 * @param now
	 * @param jzsj
	 * @return
	 */
	public static int timeComparison(String kssj,String now,String jzsj){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
		Calendar c1=Calendar.getInstance();     
		Calendar c2=Calendar.getInstance();     
		Calendar c3=Calendar.getInstance();     
		try{     
			c1.setTime(df.parse(kssj));     
			c2.setTime(df.parse(now));     
			c3.setTime(df.parse(jzsj));     
		}catch(ParseException e){     
			System.err.println("格式不正确");     
		}     
		int result1=c1.compareTo(c2);     
		int result2=c2.compareTo(c3);
		if(result1<0&&result2>0){
			return 0;
		}else if(result1<=0&&result2<=0){
			return 1;
		}else{
			return 2;
		}
	}
	
	/**
	 * 两个时间比较
	 * @author liujiasen
	 * @date 2015年7月7日
	 * @param kssj
	 * @param now
	 * @param jzsj
	 * @return
	 */
	public static int timeComp(String now,String jzsj){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
		Calendar c2=Calendar.getInstance();     
		Calendar c3=Calendar.getInstance();     
		try{     
			c2.setTime(df.parse(now));     
			c3.setTime(df.parse(jzsj));     
		}catch(ParseException e){     
			System.err.println("格式不正确");     
		}     
		int result2=c2.compareTo(c3);
		if(result2>0){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static void main(String[] args){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int res1=AppUtil.timeComp(sim.format(new Date()), "2015-08-11 00:00:00");
		int res=AppUtil.timeComp(sim.format(new Date()), "2015-09-26 09:00:00");
		System.out.println("res1:"+res1+"-------------------");
		System.out.println("res:"+res+"-------------------");
		
		
	}
	
	/**
	* 计算两个日期之间相差的天数
	* @param smdate 较小的时间
	* @param bdate 较大的时间
	* @return 相差天数
	* @throws ParseException
	*/
	public static int daysBetween(Date smdate,Date bdate) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
	}
}