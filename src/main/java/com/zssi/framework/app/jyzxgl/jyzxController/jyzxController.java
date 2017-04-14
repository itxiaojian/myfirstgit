package com.zssi.framework.app.jyzxgl.jyzxController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
/**
 * 
 * @author liangkaidi
 * @date 2016-2-18
 */
@Controller
@RequestMapping("/jyzxgl/jyzx")
public class jyzxController extends BaseController{
	/**
	 * 
	 * @author liangkaidi
	 * @date 2016-2-18
	 * @return
	 */
@RequestMapping(value="/jyzxpage")
	public ModelAndView openPage(){
		ModelAndView mav = new ModelAndView("/jyzxgl/zhuye");
		return mav;
	}
}
