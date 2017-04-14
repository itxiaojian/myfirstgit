package com.zssi.framework.app.zjmh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.ypgl.controller.YypGhController;
/**
 * 主页--消息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/zjmh")
public class ZjmhController extends BaseController {
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypGhController.class);
			
	/**
	 * 门户主页
	 * @author liujiansen
	 * @date 2015年12月7日
	 * @return
	 */
	@RequestMapping(value = "/index")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/zjmh/mh");
		return modelAndView;
	}
}
