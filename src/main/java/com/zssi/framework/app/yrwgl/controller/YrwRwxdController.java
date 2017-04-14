package com.zssi.framework.app.yrwgl.controller;

import java.util.Calendar;
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
import com.likegene.framework.core.logger.LoggerFactory;
import com.likegene.framework.core.query.QueryFilter;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.controller.YypGhController;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.yrwgl.model.YrwRwzp;
import com.zssi.framework.app.yrwgl.service.YrwRwxdService;
import com.zssi.framework.app.yrwgl.service.YrwRwzpService;
/**
 * 主页--任务下达
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/yrwgl/yrwxd")
public class YrwRwxdController extends BaseController {
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypGhController.class);
			
	@Autowired
	private YrwRwxdService yrwxdService;
	
	@Autowired
	private YrwRwzpService yrwRwzpService;
	
	/**
	 * 功能--分页
	 * @author mabiao
	 * @version 2015年10月12日上午9:56:27
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYrwxdList")
	@ResponseBody

	public Pagination<Map<String, Object>> getYrwxdList(Integer start, 
			Integer limit, String code1, String code2, String code3){
		return yrwxdService.getYrwxdList(start, limit, code1, code2, code3);
	}
	
	/**
	 * 功能--跳转
	 * @author mabiao
	 * @version 2015年10月12日上午9:55:43
	 * @return
	 */
	@RequestMapping(value = "/yrwxdPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/yrwgl/yrwxdList");
		return modelAndView;
	}
	
	/**
	 * 功能--保存
	 * @author mabiao
	 * @version 2015年10月12日上午10:28:41
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YypYpxx entity,
			HttpServletRequest request,HttpServletResponse response){
		yrwxdService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--修改
	 * @author mabiao
	 * @version 2015年10月12日上午10:27:33
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YypYpxx entity, String id) {
		yrwxdService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--删除
	 * @author mabiao
	 * @version 2015年10月12日上午9:57:29
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrwxdService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 任务下达
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData appoint(YrwRwzp entity, String bgbh) {
		//YrwRwzp rwzpEntity = yrwRwzpService.getYrwRwzpByBh(bgbh);
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YrwRwzp> rwzps=yrwRwzpService.getAll(filter);
		if(rwzps!=null&&rwzps.size()!=0){
			return new ResponseData(false, "记录已经存在");
		}else{
			entity.setBgbh(bgbh);
			entity.setRwxarq(Calendar.getInstance().getTime());
			yrwRwzpService.save(entity);
			return ResponseData.SUCCESS_NO_DATA;
		}
	}
	
	/**
	 * 功能--任务类型（数据字典）
	 * @author mabiao
	 * @date 2015年10月12日上午10:57:29
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx() {
		return yrwxdService.getDicByLx("xxlx");
	}
	
}
