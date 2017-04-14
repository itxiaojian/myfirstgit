package com.zssi.framework.app.wxpt.controller; 

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

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
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.support.PropertiesInfo;
import com.zssi.framework.app.support.weixin.WeixinUtils;
import com.zssi.framework.app.sys.dao.SysWxyhDao;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.wxpt.service.WglXgxxService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;
import com.zssi.framework.app.yrwgl.service.YrwWdrwService;

/** 
 * 质检相关信息controller类
 * @author panweichi
 * @version 创建时间：2015年11月17日 9:30am
 * 类说明 
 */
@Controller
@RequestMapping("/wxpt/WglXgxx")
public class WglXgxxController extends BaseController {
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(WglXgxxController.class);
	 
	@Autowired
	private YsbXxService ysbXxService ;
	
	@Autowired
	private YypYpxxService yypXxService ;
	
	@Autowired
	private YrwWdrwService yrwWwdrwService;
	
	@Autowired
	private WglXgxxService wglXgxxService;
	
	@Autowired
	private SysWxyhDao sysWxyhDao;
	
/** 
 * 质检相关信息controller类 跳转微服务
 * @author panweichi
 * @version 创建时间：2015年11月17日 
 * @throws UnsupportedEncodingException 
 */	
@RequestMapping(value = "/wglZy")
public ModelAndView zhuyeHt(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws UnsupportedEncodingException {
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	if (openId == null || "".equalsIgnoreCase(openId)) {
		openId = "";
	}
	url = "/wxpt/wglZy";
	modelAndView.addObject("openId", openId);
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 质检相关信息controller类 跳转微服务
 * @author panweichi
 * @version 创建时间：2015年11月17日 
 * @throws UnsupportedEncodingException 
 */
/*@RequestMapping(value = "/wglZy")
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
          		     String result3 = "http://wx.zs-si.com:9080/zjyw/wxpt/WglXgxx/wglZy";//进入微管理

	                 try {
                          result3 = java.net.URLEncoder.encode(result3,"utf-8");
	                 } catch (UnsupportedEncodingException e) {
                          e.printStackTrace();
	                 }
                  
	                 String url3 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+PropertiesInfo.appId+"&redirect_uri="+result3+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

                	 url = "/wxpt/wglZytz";
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
				url = "/wxpt/wglZy";
			}else{
				url="/sys/SysWxyh/wxbd";
				modelAndView.addObject("url","/wxpt/WglXgxx/wglZy");
			}
		}
	}else{
		List<Map<String,Object>> user = sysWxyhDao.getWxyh(openId);
	//	List<Map<String,Object>> user = sysWxyhDao.getWxyh("admin");
		if(user.size()!=0){
			url = "/wxpt/wglZy";
		}else{
			url="/sys/SysWxyh/wxbd";
			modelAndView.addObject("url","/wxpt/WglXgxx/wglZy");
		}
	}
    List<Map<String,Object>> user = sysWxyhDao.getWxyh(openId);
	//List<Map<String,Object>> user = sysWxyhDao.getWxyh("admin");
	if(user.size()!=0){
		url = "/wxpt/wglZy";
	}else{
		url="/sys/SysWxyh/wxbd";
		modelAndView.addObject("url","/wxpt/WglXgxx/wglZy");
	}
	modelAndView.addObject("openId", openId);
	modelAndView.setViewName(url);
	return modelAndView;

}*/


/** 
 * 保存我的申请
 * @author oufeng
 * @version 创建时间：2015年12月15日 
 * @throws ParseException 
 * @throws UnsupportedEncodingException 
 */
@RequestMapping(value = "/saveWdsq")
@ResponseBody
public String saveWdsq(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws  ParseException, UnsupportedEncodingException {
	String str="";
	str=wglXgxxService.saveWdsq(request);
	return str;
}

/** 
 * 保存工作汇报
 * @author oufeng
 * @version 创建时间：2015年12月15日 
 * @throws ParseException 
 * @throws UnsupportedEncodingException 
 */
@RequestMapping(value = "/saveGzhb")
@ResponseBody
public String saveGzhb(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws  ParseException, UnsupportedEncodingException {
	String str="";
	str=wglXgxxService.saveGzhb(request);
	return str;
}

/** 
 * 审核通过
 * @author oufeng
 * @version 创建时间：2015年12月15日 
 * @throws ParseException 
 * @throws UnsupportedEncodingException 
 */
@RequestMapping(value = "/shtg")
@ResponseBody
public String shtg(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws  ParseException, UnsupportedEncodingException {
	
	String str="";
	str=wglXgxxService.updateSqxxtg(request);
	return str;
}

/** 
 * 驳回
 * @author oufeng
 * @version 创建时间：2015年12月15日 
 * @throws ParseException 
 * @throws UnsupportedEncodingException 
 */
@RequestMapping(value = "/bh")
@ResponseBody
public String bh(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws  ParseException, UnsupportedEncodingException {
	
	String str="";
	str=wglXgxxService.updateSqxxbh(request);
	return str;
}

/** 
 * 我已发送的工作汇报跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 类说明 
 */
@RequestMapping(value = "/wglGzhbList")
@ResponseBody
public ModelAndView wglGzhbList(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String openId= request.getParameter("openId");
	String time= request.getParameter("time");
	List<Map<String, Object>> hblist= wglXgxxService.getHb(openId,time);
	String url = "";
	url = "/wxpt/wglGzhbList";
	modelAndView.setViewName(url);
	modelAndView.addObject("hblist", hblist);
	return modelAndView;
}

/** 
 * 我可查看的工作汇报跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 类说明 
 */
@RequestMapping(value = "/wglGzhbList1")
@ResponseBody
public ModelAndView wglGzhbList1(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String openId= request.getParameter("openId");
	String time= request.getParameter("time");
	List<Map<String, Object>> hblist1= wglXgxxService.getHb(openId,time);
	String url = "";
	url = "/wxpt/wglGzhbList1";
	modelAndView.setViewName(url);
	modelAndView.addObject("hblist1", hblist1);
	return modelAndView;
}



/** 
 * 我已发送的工作汇报详情
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 类说明 
 */
@RequestMapping(value = "/wglGzhbXq")
@ResponseBody
public ModelAndView wglGzhbXq(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String openId= request.getParameter("openId");
	String id= request.getParameter("id");
	List<Map<String, Object>> hblistxq= wglXgxxService.getHbXq(id);
	String url = "";
	url = "/wxpt/wglGzhbXq";
	modelAndView.setViewName(url);
	modelAndView.addObject("hblistxq", hblistxq);
	modelAndView.addObject("openId", openId);
	return modelAndView;
}

/** 
 * 我可查看的工作汇报详情
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 类说明 
 */
@RequestMapping(value = "/wglGzhbXq1")
@ResponseBody
public ModelAndView wglGzhbXq1(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String openId= request.getParameter("openId");
	String id= request.getParameter("id");
	List<Map<String, Object>> hblistxq1= wglXgxxService.getHbXq(id);
	String url = "";
	url = "/wxpt/wglGzhbXq1";
	modelAndView.setViewName(url);
	modelAndView.addObject("hblistxq1", hblistxq1);
	modelAndView.addObject("openId", openId);
	return modelAndView;
}

/** 
 * 跳转请假页面
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 */
@RequestMapping(value = "/sqxx")
@ResponseBody
public ModelAndView sqxx(String openId,String sqlx) {
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/sqxx";
	List<Map<String, Object>> shrlist= wglXgxxService.getShr();
	modelAndView.setViewName(url);
	modelAndView.addObject("sqlx", sqlx);
	modelAndView.addObject("shrlist", shrlist);
	modelAndView.addObject("openId", openId);
	return modelAndView;
}

/** 
 * 跳转填写汇报信息页面
 * @author panweichi
 * @version 创建时间：2015年12月29日 
 */
@RequestMapping(value = "/hbxx")
@ResponseBody
public ModelAndView hbxx(String openId,String hblx) {
	
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/hbxx";
	List<Map<String, Object>> hbrlist= wglXgxxService.getShr();
	modelAndView.setViewName(url);
	modelAndView.addObject("hblx", hblx);
	modelAndView.addObject("hbrlist", hbrlist);
	modelAndView.addObject("openId", openId);
	return modelAndView;
}



/** 
 * 跳转我的申请里面的页面
 * @author panweichi
 * @version 创建时间：2015年12月1日 
 */
@RequestMapping(value = "/wglWdsq")
@ResponseBody
public ModelAndView wglWdsq(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wglWdsq");
	String openId = request.getParameter("openId");
     	modelAndView.addObject("openId",openId);
	return modelAndView;
}

/** 
 * 跳转我的申请里面的页面
 * @author panweichi
 * @version 创建时间：2015年12月1日 
 */
@RequestMapping(value = "/wglWdsqList")
@ResponseBody
public ModelAndView wglWdsqList(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	String openId = request.getParameter("openId");
	String time = request.getParameter("time");
	if(openId == null || "".equalsIgnoreCase(openId)){
			/*url="/sys/SysWxyh/wxbd";
			modelAndView.addObject("url","/wxpt/WglXgxx/wglWdsqList");*/
		 url = "/wxpt/wglWdsqList";
		  int yhbh=1;
         List<Map<String, Object>> wdsqlist= wglXgxxService.getWdsqList( yhbh+"",time);
  		if(wdsqlist!=null){
   			modelAndView.addObject("wdsqlist",wdsqlist);
   		}
	}else{
		url = "/wxpt/wglWdsqList";
		List<Map<String,Object>> wxyh = wglXgxxService.getUser(openId);
		if(wxyh.size()!=0){
			modelAndView.addObject("yhbh",wxyh.get(0).get("yhid"));
		}
		List<Map<String, Object>> wdsqlist= wglXgxxService.getWdsqList( wxyh.get(0).get("yhid")+"",time);
   		if(wdsqlist!=null){
   			modelAndView.addObject("wdsqlist",wdsqlist);
   		}
   		}
     	modelAndView.addObject("openId",openId);
		modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 跳转需要我审批的申请里面的页面
 * @author oufeng
 * @version 创建时间：2015年12月1日 
 */
@RequestMapping(value = "/wglWdsqList1")
@ResponseBody
public ModelAndView wglWdsqList1(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	String openId = request.getParameter("openId");
	String time = request.getParameter("time");
	if(openId == null || "".equalsIgnoreCase(openId)){
		/*url="/sys/SysWxyh/wxbd";
		modelAndView.addObject("url","/wxpt/WglXgxx/wglWdsqList1");*/
		url = "/wxpt/wglWdsqList1";
		 int yhbh=1;
         List<Map<String, Object>> xwdsqlist= wglXgxxService.getXwdsqList( yhbh+"",time);
  		if(xwdsqlist!=null){
  			modelAndView.addObject("xwdsqlist",xwdsqlist);
   		}
	}else{
		url = "/wxpt/wglWdsqList1";
		List<Map<String,Object>> wxyh = wglXgxxService.getUser(openId);
		if(wxyh.size()!=0){
			modelAndView.addObject("yhbh",wxyh.get(0).get("yhid"));
		}
		List<Map<String, Object>> xwdsqlist= wglXgxxService.getXwdsqList( wxyh.get(0).get("yhid")+"",time);
   		if(xwdsqlist!=null){
   			modelAndView.addObject("xwdsqlist",xwdsqlist);
   		}
	}
     	modelAndView.addObject("openId",openId);
		modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 跳转抄送给我的申请里面的页面
 * @author oufeng
 * @version 创建时间：2015年12月15日 
 */
@RequestMapping(value = "/wglWdsqList2")
@ResponseBody
public ModelAndView wglWdsqList2(HttpServletRequest request) {
	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	String openId = request.getParameter("openId");
	String time = request.getParameter("time");
	if(openId == null || "".equalsIgnoreCase(openId)){
		/*url="/sys/SysWxyh/wxbd";
		modelAndView.addObject("url","/wxpt/WglXgxx/wglWdsqList2");*/
		url = "/wxpt/wglWdsqList2";
		 int yhbh=1;
		 List<Map<String, Object>> cswdsqlist= wglXgxxService.getCswdsqList(yhbh+"",time);
  		if(cswdsqlist!=null){
  			modelAndView.addObject("cswdsqlist",cswdsqlist);
   		}
	}else{
		url = "/wxpt/wglWdsqList2";
		List<Map<String,Object>> wxyh = wglXgxxService.getUser(openId);
		if(wxyh.size()!=0){
			modelAndView.addObject("yhbh",wxyh.get(0).get("yhid"));
		}
		List<Map<String, Object>> cswdsqlist= wglXgxxService.getCswdsqList( wxyh.get(0).get("yhid")+"",time);
   		if(cswdsqlist!=null){
   			modelAndView.addObject("cswdsqlist",cswdsqlist);
   		}
	}
	modelAndView.setViewName(url);
	modelAndView.addObject("openId",openId);
	return modelAndView;
}

/** 
 * 我的申请的列表页面
 * @author oufeng
 * @date 创建时间：2015年12月1日 
 */
@RequestMapping(value = "/wglWdsqXq")
@ResponseBody
public ModelAndView wglWdsqXq(HttpServletRequest request) {

	ModelAndView modelAndView = new ModelAndView();
	String id = request.getParameter("id");
	String openId = request.getParameter("openId");
	List<Map<String, Object>> wdsqdetail= wglXgxxService.getWdsqDetail(id);
	String url = "";
	url = "/wxpt/wglWdsqXq";
	modelAndView.setViewName(url);
	modelAndView.addObject("openId", openId);
	modelAndView.addObject("wdsqdetail", wdsqdetail);
	return modelAndView;
}

/** 
 * 需我审批的申请的列表页面
 * @author oufeng
 * @date 创建时间：2015年12月1日 
 */
@RequestMapping(value = "/wglWdsqXq1")
@ResponseBody
public ModelAndView wglWdsqXq1(HttpServletRequest request) {

	ModelAndView modelAndView = new ModelAndView();
	String id = request.getParameter("id");
	String openId = request.getParameter("openId");
	List<Map<String, Object>> xwdsqdetail= wglXgxxService.getWdsqDetail(id);
	String url = "";
	url = "/wxpt/wglWdsqXq1";
	modelAndView.setViewName(url);
	modelAndView.addObject("openId", openId);
	modelAndView.addObject("xwdsqdetail",xwdsqdetail);
	return modelAndView;
}

/** 
 * 抄送给我的审批的申请的列表页面
 * @author oufeng
 * @date 创建时间：2015年12月1日 
 */
@RequestMapping(value = "/wglWdsqXq2")
@ResponseBody
public ModelAndView wglWdsqXq2(HttpServletRequest request) {

	ModelAndView modelAndView = new ModelAndView();
	String id = request.getParameter("id");
	String openId = request.getParameter("openId");
	List<Map<String, Object>> cswdsqdetail= wglXgxxService.getWdsqDetail(id);
	String url = "";
	url = "/wxpt/wglWdsqXq2";
	modelAndView.setViewName(url);
	modelAndView.addObject("openId", openId);
	modelAndView.addObject("cswdsqdetail",cswdsqdetail);
	return modelAndView;
}

///** 
// * 我可以查看的工作汇报的页面
// * @author panweichi
// * @date 创建时间：2015年12月29日 
// */
/*@RequestMapping(value = "/wglGzhbList1")
@ResponseBody
public ModelAndView wglGzhbList1(HttpServletRequest request) {
ModelAndView modelAndView = new ModelAndView();
String id = request.getParameter("id");
String openId = request.getParameter("openId");
List<Map<String, Object>> csgzhbdetail= wglXgxxService.getWdsqDetail(id);
	String url = "";
	url = "/wxpt/wglGzhbList1";
	modelAndView.setViewName(url);
	modelAndView.addObject("openId", openId);
	modelAndView.addObject("csgzhbdetail",csgzhbdetail);
return modelAndView;
}*/

//跳转到选择申请类型的页面

@RequestMapping(value = "/wglSqsx")
@ResponseBody
public ModelAndView wglSqsx(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/wglSqsx";
	modelAndView.setViewName(url);
	return modelAndView;
}

//跳转到选择汇报类型的页面

@RequestMapping(value = "/wglHbsx")
@ResponseBody
public ModelAndView wglHbsx(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/wglHbsx";
	modelAndView.setViewName(url);
	modelAndView.addObject("openId", openId);
	return modelAndView;
}

//跳转到选择工作汇报的页面

@RequestMapping(value = "/wglGzhb")
@ResponseBody
public ModelAndView wglGzhb(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/wglGzhb";
	modelAndView.setViewName(url);
	return modelAndView;
}

//跳转到我的任务的页面

@RequestMapping(value = "/wglWdrw")
@ResponseBody
public ModelAndView wfwSbxx(String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wglWdrw");
	List<Map<String, Object>> wdrw = yrwWwdrwService.getWd();
	if (wdrw != null) {
		modelAndView.addObject("getwdrw", wdrw);
	}
	return modelAndView;
}

/*@RequestMapping(value = "/wglWdsq")
@ResponseBody
public ModelAndView wglWdsq(String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wglWdsq");
	List<Map<String, Object>> wdsq = yrwWwdrwService.getWd();
	if (wdsq != null) {
		modelAndView.addObject("getwdrw", wdsq);
	}
	return modelAndView;
}*/

/**
 * 微管理————我的任务搜索
 * 
 * @author panweichi
 * @date 2015年11月23日
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = "/wxptWdrw")
public ModelAndView ypsbxx(HttpServletRequest request,
		HttpServletResponse response, String id) {
	ModelAndView mav = new ModelAndView("/wxpt/wglWdrw");
	String search = request.getParameter("search");
//	if (search != null) {
//		mav.addObject("search", search);
//	}
	List<Map<String, Object>> wdrw = yrwWwdrwService.getWdrw(search);
	if (wdrw != null) {
		mav.addObject("getwdrw", wdrw);
	}
	return mav;
}


//微管理-我的任务-详情
@RequestMapping(value = "/wglWdrwXq")
@ResponseBody
public ModelAndView wglWdrwXq(HttpServletRequest request,
		HttpServletResponse response,String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wglWdrwXq");
	String id = request.getParameter("id");
	List<Map<String, Object>> wdrw = yrwWwdrwService.getWd1(id);
	if (wdrw != null) {
		modelAndView.addObject("getWdrw", wdrw);
	}
	return modelAndView;
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
