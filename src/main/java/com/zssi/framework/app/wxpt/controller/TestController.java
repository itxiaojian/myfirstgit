package com.zssi.framework.app.wxpt.controller;

import java.io.UnsupportedEncodingException;

import com.zssi.framework.app.support.PropertiesInfo;

/** 
 * 装换路径code
 * @author:zhangyi 
 * @version 创建时间：2015年6月11日 上午10:42:31 
 * 类说明 
 */
public class TestController {
   
	public static void main(String args[]){

		   String result1 = "http://wx.zs-si.com:9080/zjyw/wxpt/ZyZjxgxx/zhuye";//进入微主页
		   String result2 = "http://wx.zs-si.com:9080/zjyw/wxpt/WfwXgxx/wfwZy";//进入微服务
		   String result3 = "http://wx.zs-si.com:9080/zjyw/wxpt/WglXgxx/wglZy";//进入微生活
		   
//		   String result1 = "http://wx.zs-si.com:9080/wxpt/wzy/ZyXyxw/zhuye";//进入微主页
//		   String result2 = "http://wx.zs-si.com:9080/wxpt/wfw/zy/zhuye";//进入微服务
//		   String result3 = "http://wx.zs-si.com:9080/wxpt/wsh/zy/zhuye";//进入微生活

           try {
                   result1 = java.net.URLEncoder.encode(result1,"utf-8"); 
                   result2 = java.net.URLEncoder.encode(result2,"utf-8");
                   result3 = java.net.URLEncoder.encode(result3,"utf-8");
           } catch (UnsupportedEncodingException e) {
                   e.printStackTrace();
           }
           
           System.out.println("-------result1-------->"+result1);
           System.out.println("-------result2-------->"+result2);
           System.out.println("-------result3-------->"+result3);
           String url1 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+PropertiesInfo.appId+"&redirect_uri="+result1+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
           String url2 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+PropertiesInfo.appId+"&redirect_uri="+result2+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
           String url3 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+PropertiesInfo.appId+"&redirect_uri="+result3+"&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
           
           System.out.println("----url1---->"+url1);
           System.out.println("----url2---->"+url2);
           System.out.println("----url3---->"+url3);
           
           //----url1---->https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc574bb39b0568c6b&redirect_uri=http%3A%2F%2Fwx.zs-si.com%3A9080%2Fzjyw%2Fwxpt%2FZyZjxgxx%2Fzhuye&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
           //   ----url2---->https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc574bb39b0568c6b&redirect_uri=http%3A%2F%2Fwx.zs-si.com%3A9080%2Fzjyw%2Fwxpt%2FWfwXgxx%2FwfwZy&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
           //   ----url3---->https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc574bb39b0568c6b&redirect_uri=http%3A%2F%2Fwx.zs-si.com%3A9080%2Fzjyw%2Fwxpt%2FWglXgxx%2FwglZy&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect

           
	}
	
}
