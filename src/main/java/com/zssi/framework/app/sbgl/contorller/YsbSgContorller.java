package com.zssi.framework.app.sbgl.contorller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.service.YjyNwglService;
import com.zssi.framework.app.sbgl.model.YsbSg;
import com.zssi.framework.app.sbgl.service.YsbSgService;
import com.zssi.framework.app.util.ResponseData;



@Controller
@RequestMapping("/sbgl/YSbSg")
public class YsbSgContorller extends BaseController {
	protected final transient Logger logger = com.likegene.framework.core.logger.LoggerFactory.getPersistenceLog(YsbSgContorller.class);
	
	@Autowired
	private YsbSgService ySbSgService;
	
	@Autowired
	private YjyNwglService nwglservice;
	
	
	/**
	 * 后台：设备申购
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getSbsgList")
	@ResponseBody
	public Pagination<Map<String, Object>> getSbsgList(Integer start,Integer limit,String code){
		return ySbSgService.getSbsgList(start, limit,code);
	}
	
	/** 
	 * 设备级别下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ySbSgService.getDicByLx("sbjb");
	}
	
	@RequestMapping(value = "/SbsgPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sbgl/ySbsgList");
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YsbSg entity,
			HttpServletRequest request,HttpServletResponse response){
		ySbSgService.save(entity);
				return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 修改
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YsbSg entity,String id){
		ySbSgService.update(entity,id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ySbSgService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 设备申购信息新增
	 * @author liusong
	 * @date 2015年11月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sbsgAddView")
	public ModelAndView sbxxAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbsgAdd");
		List<Map<String, Object>> sbjb = ySbSgService.getDicByLx("sbjb");
		List<Map<String, Object>> sblx = ySbSgService.getDicByLx("sblx");
		List<Map<String,Object>> syks=nwglservice.getBm("100500");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("sbjb",sbjb);
		mav.addObject("sblx",sblx);
		return mav;
	}
	
	/**
	 * 设备申购信息修改
	 * @author liusong
	 * @date 2015年11月17日
	 * @return
	 */
	@RequestMapping(value = "/sbsgUpdateView")
	public ModelAndView sbxxUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sbgl/jsp/sbsgUpdate");
		String id = request.getParameter("id");
//		System.out.println("获取到的id是: " + id);
		List<Map<String, Object>> sbsg = ySbSgService.getXg(id);
		if (sbsg != null) {
			mav.addObject("sbsg", sbsg);
		}
		List<Map<String, Object>> sbjb = ySbSgService.getDicByLx("sbjb");
		List<Map<String, Object>> sblx = ySbSgService.getDicByLx("sblx");
		List<Map<String,Object>> syks=nwglservice.getBm("100500");
		if(syks.size()!=0){
			mav.addObject("syks", syks);
		}
		mav.addObject("sbjb",sbjb);
		mav.addObject("sblx",sblx);
		return mav;
	}
	
}
