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
import com.zssi.framework.app.jybzgl.service.YjyBzxxService;
import com.zssi.framework.app.sbgl.service.YsbXxService;

/** 
 * 质检相关信息controller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 下午2:31:08 
 * 类说明 
 */
@Controller
@RequestMapping("/wxpt/ZyZjxgxx")
public class ZyZjxgxxController extends BaseController {
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(ZyZjxgxxController.class);
	
	@Autowired
	private YjyBzxxService yjyBzxxService;
	
	@Autowired
	private YsbXxService ysbXxService;

	/** 
	 * menu页面跳转，后期布置微信后有待改进
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
@RequestMapping(value = "/zhuye")
public ModelAndView zhuyeHt(HttpServletRequest request,
		HttpServletResponse response, String openId)
		throws UnsupportedEncodingException {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	if (openId == null || "".equalsIgnoreCase(openId)) {
		openId = "";
	}
	url = "/wxpt/zhuye";
	modelAndView.addObject("openId", openId);
	modelAndView.setViewName(url);
	return modelAndView;
} 

/** 
 * 微主页质检简介跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyZjjj")
@ResponseBody
public ModelAndView zyZjjj(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZjjj";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页新闻1跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews1")
@ResponseBody
public ModelAndView zyNews1(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews1";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻2跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews2")
@ResponseBody
public ModelAndView zyNews2(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews2";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻3跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews3")
@ResponseBody
public ModelAndView zyNews3(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews3";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻4跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews4")
@ResponseBody
public ModelAndView zyNews4(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews4";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻5跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews5")
@ResponseBody
public ModelAndView zyNews5(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews5";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻6跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews6")
@ResponseBody
public ModelAndView zyNews6(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews6";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻7跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews7")
@ResponseBody
public ModelAndView zyNews7(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews7";
	modelAndView.setViewName(url);
	return modelAndView;
}
/** 
 * 微主页新闻8跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews8")
@ResponseBody
public ModelAndView zyNews8(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews8";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页新闻9跳转
 * @author panweichi
 * @version 创建时间：2015年11月30日 
 * 方法说明 
 */
@RequestMapping(value = "/zyNews9")
@ResponseBody
public ModelAndView zyNews9(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyNews9";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 *微主页组织机构跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyZzjg")
@ResponseBody
public ModelAndView zyZzjg(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZzjg";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页发展历程跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyfzlc")
@ResponseBody
public ModelAndView zyfzlc(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZjfzlc";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页质检新闻列表跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyZjxwlb")
@ResponseBody
public ModelAndView zyZjxwlb(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZjxwlb";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页办事流程跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyBslc")
@ResponseBody
public ModelAndView zyBslc(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyBslc";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页检验标准跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyJybz")
@ResponseBody
public ModelAndView zyJybz(HttpServletRequest request,
		HttpServletResponse response,String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/zyJybz");
	String id = request.getParameter("id");
	List<Map<String, Object>> bzxx = yjyBzxxService.getBz(id);
	if (bzxx != null) {
		modelAndView.addObject("getbzxx", bzxx);
	}
	return modelAndView;
}

/** 
 * 微主页检验标准详情查看
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyZjJybzXq")
@ResponseBody
public ModelAndView zyZjJybzXq(HttpServletRequest request,
		HttpServletResponse response,String openId) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/zyZjJybzXq");
	String id = request.getParameter("id");
	List<Map<String, Object>> bzxx = yjyBzxxService.getBz1(id);
	if (bzxx != null) {
		modelAndView.addObject("getbzxx", bzxx);
	}
	return modelAndView;
}

/** 
 * 微主页设备信息详情查看方法
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyZjSbxxXq")
@ResponseBody
public ModelAndView zyZjSbxxXq(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView modelAndView = new ModelAndView("/wxpt/wfwSbxxXq");
	String id = request.getParameter("id");
	List<Map<String, Object>> sbxx = ysbXxService.getSb(id);
	if (sbxx != null) {
		modelAndView.addObject("getSbxx", sbxx);
	}
	return modelAndView;
}

/** 
 * 微主页质量馆跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyzlg")
@ResponseBody
public ModelAndView zyzlg(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZjzlg";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页品牌馆跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zyppg")
@ResponseBody
public ModelAndView zyppg(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZjppg";
	modelAndView.setViewName(url);
	return modelAndView;
}

/** 
 * 微主页联系我们跳转
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年11月11日 上午10:19:22 
 * 方法说明 
 */
@RequestMapping(value = "/zylxwm")
@ResponseBody
public ModelAndView zylxwm(String openId) {

	ModelAndView modelAndView = new ModelAndView();
	String url = "";
	url = "/wxpt/zyZjlxwm";
	modelAndView.setViewName(url);
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
