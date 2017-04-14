package com.zssi.framework.app.wxpt.controller; 

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.dto.WeiXinOauth2Token;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.support.PropertiesInfo;
import com.zssi.framework.app.support.SignUtil;
import com.zssi.framework.app.support.weixin.WeixinCacheUtils;
import com.zssi.framework.app.support.weixin.WeixinUtils;
import com.zssi.framework.app.sys.dao.SysWxyhDao;
import com.zssi.framework.app.wxpt.service.WfwXgxxService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/** 
 * 质检相关信息controller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 下午2:31:08 
 * 类说明 
 */
@Controller
@RequestMapping("/wxpt/WfwXgxx")
public class WfwXgxxController extends BaseController {
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(WfwXgxxController.class);
	@Autowired
	private YjyBgxxService service;
	
	@Autowired
	private YsbXxService ysbXxService ;
	
	@Autowired
	private YypYpxxService yypXxService ;
	
	@Autowired
	private SysWxyhDao sysWxyhDao;
	
	@Autowired
	private WfwXgxxService wfwXgxxService ;
	

	/** 
	 * menu页面跳转，后期布置微信后有待改进
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
@RequestMapping(value = "/wfwZy")
public ModelAndView zhuyeHt(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws UnsupportedEncodingException {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	if (openId == null || "".equalsIgnoreCase(openId)) {
		openId = "";
	}
	url = "/wxpt/wfwZy";
	//String openId = request.getParameter("openId");
		String jsapi_ticket = WeixinCacheUtils.getJsapiTicket();

	    // 注意 URL 一定要动态获取，不能 hardcode
	    //String url1 = "http://wx.zs-si.com:8080/wxpt/wsh/ShWsq/toDemo";
	    HttpServletRequest httpRequest=(HttpServletRequest)request; 
	    String url1 = request.getScheme() + "://" + request.getServerName() //服务器地址  
	            + ":"   
	            + request.getServerPort()           //端口号  
	            + httpRequest.getContextPath()      //项目名称  
	            + httpRequest.getServletPath() ; //请求页面或其他地址  
	      //      + "?" + (httpRequest.getQueryString()); //参数 
	    Map<String, String> ret = SignUtil.sign(jsapi_ticket, url1);
	    for (Map.Entry entry : ret.entrySet()) {
	        System.out.println(entry.getKey() + "," +entry.getValue());
	    }
	 modelAndView.addObject("map", ret);
	modelAndView.addObject("openId", openId);
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 扫一扫页面建设中
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/wfwSys")
@ResponseBody
public ModelAndView wfwSys(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/wfwSys";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 数据统计页面建设中
 * @author panweichi
 * @version 创建时间：2015年12月3日 
 * 方法说明 
 */
@RequestMapping(value = "/sjtjBuilding")
@ResponseBody
public ModelAndView sjtjBuilding(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/sjtjBuilding";
	modelAndView.setViewName(url);
	return modelAndView;
}


/** 
 * 质检相关信息controller类 跳转微服务
 * @author panweichi
 * @version 创建时间：2015年11月12日 
 * 类说明 
 */
	
/*@RequestMapping(value = "/wfwZy")
public ModelAndView wglZy(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws UnsupportedEncodingException {
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	
	if (openId == null || "".equalsIgnoreCase(openId)) {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String code = request.getParameter("code"); // 获取code
		if (openId == null || "".equalsIgnoreCase(openId)) {
		openId = "";
		}

		if (code == null || "".equalsIgnoreCase(code)) {
			url = "/error/wxd";
		} else {
			if (!"authdeny".equals(code)) {
				WeiXinOauth2Token weiXinOauth2Token = WeixinUtils
						.getOauth2AccessToken(code);// 根据code获取 页面授权信息类
				if(weiXinOauth2Token != null){
					openId = weiXinOauth2Token.getOpenId();// 获取当前微信用户的openId
                 }else{
          		     String result3 = "http://wx.zs-si.com:9080/zjyw/wxpt/WfwXgxx/wfwZy";//进入微管理

	                 try {
                          result3 = java.net.URLEncoder.encode(result3,"utf-8");
	                 } catch (UnsupportedEncodingException e) {
                          e.printStackTrace();
	                 }
                  
	                 String url3 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+PropertiesInfo.appId+"&redirect_uri="+result3+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

                	 url = "/wxpt/wfwZytz";
                	 modelAndView.addObject("newurl", url3);
                	 modelAndView.setViewName(url);
                	 return modelAndView;
                 }
			}
			String accessToken = WeixinCacheUtils.getAccessToken();// 获取微信公众号的accessToken
			WxUserInfo wxUserInfo = WeixinUtils.getUserInfo(accessToken,
					openId);// 根据openId和公众号Token获取关注用户的基本信息
			modelAndView.addObject("openId", openId);
        	List<Map<String,Object>> user = sysWxyhDao.getWxyh(openId);
			//List<Map<String,Object>> user = sysWxyhDao.getWxyh("admin");
			if(user.size()!=0){
				url = "/wxpt/wfwZy";
			}else{
				url="/sys/SysWxyh/wxbd";
				modelAndView.addObject("url","/wxpt/WfwXgxx/wfwZy");
			}
		}
	}else{
		List<Map<String,Object>> user = sysWxyhDao.getWxyh(openId);
	//	List<Map<String,Object>> user = sysWxyhDao.getWxyh("admin");
		if(user.size()!=0){
			url = "/wxpt/wfwZy";
		}else{
			url="/sys/SysWxyh/wxbd";
			modelAndView.addObject("url","/wxpt/WfwXgxx/wfwZy");
		}
	}
    List<Map<String,Object>> user = sysWxyhDao.getWxyh(openId);
	//List<Map<String,Object>> user = sysWxyhDao.getWxyh("admin");
	if(user.size()!=0){
		url = "/wxpt/wfwZy";
	}else{
		url="/sys/SysWxyh/wxbd";
		modelAndView.addObject("url","/wxpt/WfwXgxx/wfwZy");
	}

	//String openId = request.getParameter("openId");
	String jsapi_ticket = WeixinCacheUtils.getJsapiTicket();

    // 注意 URL 一定要动态获取，不能 hardcode
    //String url1 = "http://wx.zs-si.com:8080/wxpt/wsh/ShWsq/toDemo";
    HttpServletRequest httpRequest=(HttpServletRequest)request; 
    String url1 = request.getScheme() + "://" + request.getServerName() //服务器地址  
            + ":"   
            + request.getServerPort()           //端口号  
            + httpRequest.getContextPath()      //项目名称  
            + httpRequest.getServletPath();     //请求页面或其他地址  
        //+ "?" + (httpRequest.getQueryString()); //参数 
    Map<String, String> ret = SignUtil.sign(jsapi_ticket, url1);
    for (Map.Entry entry : ret.entrySet()) {
        System.out.println(entry.getKey() + "," +entry.getValue());
    }
    modelAndView.addObject("map", ret);
	modelAndView.addObject("openId", openId);
	modelAndView.setViewName(url);
	return modelAndView;
}
*/
/** 
 * 微服务样品信息列表
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwYpxx")
@ResponseBody
public ModelAndView wfwYpxx(String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wfwYpxx");
	List<Map<String, Object>> ypxx = yypXxService.getYp();
	if (ypxx != null) {
		modelAndView.addObject("getypxx", ypxx);
	}
	return modelAndView;
}

/** 
 * 微服务设备信息列表
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwSbxx")
@ResponseBody
public ModelAndView wfwSbxx(String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wfwSbxx");
	List<Map<String, Object>> sbxx = ysbXxService.getSb();
	if (sbxx != null) {
		modelAndView.addObject("getsbxx", sbxx);
	}
	return modelAndView;
}

/** 
 * 微服务报告信息列表
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwBgxx")
@ResponseBody
public ModelAndView wfwBgxx(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String openId = request.getParameter("openId");
	String  bgbh= request.getParameter("bgbh");
	String url = "";
	url = "/wxpt/wfwBgxx";
	List<Map<String, Object>> bgxx = wfwXgxxService.getBgxx(bgbh,openId);
	modelAndView.addObject("bgxx", bgxx);
	modelAndView.addObject("openId", openId);
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微服务设备信息列表
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwBgxx1")
@ResponseBody
public ModelAndView wfwBgxx1(String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wfwBgxx1");
	List<Map<String, Object>>bgxx1 = service.getBg();
	if (bgxx1 != null) {
		modelAndView.addObject("getbgxx1", bgxx1);
	}
	return modelAndView;
}

/** 
 * 微服务样品信息详情
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwYpxxXq")
@ResponseBody
public ModelAndView wfwYpxxXq(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wfwYpxxXq");
	String id = request.getParameter("id");
	String openId = request.getParameter("openId");
	List<Map<String, Object>> ypxx = yypXxService.getYp1(id);
	if (ypxx != null) {
		modelAndView.addObject("getypxx", ypxx);
	}
	modelAndView.addObject("openId", openId);
	return modelAndView;
}

/** 
 * 微服务设备信息详情
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwSbxxXq")
@ResponseBody
public ModelAndView wfwSbxxXq(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/wfwSbxxXq";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微服务报告信息详情
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/wfwBgxxXq")
@ResponseBody
public ModelAndView wfwBgxxXq(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String id = request.getParameter("id");
	String openId = request.getParameter("openId");
	List<Map<String, Object>> bgxq = wfwXgxxService.getBgxxXq(id);
	String url = "";
	url = "/wxpt/wfwBgxxXq";
	modelAndView.setViewName(url);
	modelAndView.addObject("openId", openId);
	modelAndView.addObject("bgxq", bgxq);
	return modelAndView;
}
/**
 * 微服务————样品信息搜索
 * 
 * @author panweichi
 * @date 2015年11月24日
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = "/wxptYpxx")
public ModelAndView ypsbxx1(HttpServletRequest request,
		HttpServletResponse response, String id) {
	ModelAndView mav = new ModelAndView("/wxpt/wfwYpxx");
	String search = request.getParameter("search");
//	if (search != null) {
//		mav.addObject("search", search);
//	}
	List<Map<String, Object>> ypxx = yypXxService.getYpxx1(search);
	if (ypxx != null) {
		mav.addObject("getypxx", ypxx);
	}
	return mav;
}
/**
 * 微服务————设备信息搜索
 * 
 * @author panweichi
 * @date 2015年11月24日
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = "/wxptSbxx")
public ModelAndView ypsbxx(HttpServletRequest request,
		HttpServletResponse response, String id) {
	ModelAndView mav = new ModelAndView("/wxpt/wfwSbxx");
	String search = request.getParameter("search");
//	if (search != null) {
//		mav.addObject("search", search);
//	}
	List<Map<String, Object>> sbxx = ysbXxService.getSbxx1(search);
	if (sbxx != null) {
		mav.addObject("getsbxx", sbxx);
	}
	return mav;
}

public static Map<String, Object> beanToMap(Object obj) {
	Map<String, Object> params = new HashMap<String, Object>(0);
	try {
		PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
		PropertyDescriptor[] descriptors = propertyUtilsBean
				.getPropertyDescriptors(obj);
		for (int i = 0; i < descriptors.length; i++) {
			String name = descriptors[i].getName();
			if (!StringUtils.pathEquals(name, "class")) {
				params.put(name,
						propertyUtilsBean.getNestedProperty(obj, name));
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return params;
}

}
