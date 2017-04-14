package com.zssi.framework.app.yxxgl.controller;

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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.controller.YypGhController;
import com.zssi.framework.app.ypgl.controller.YypYpxxController;
import com.zssi.framework.app.ypgl.model.YypGh;
import com.zssi.framework.app.ypgl.model.YypJyfa;
import com.zssi.framework.app.ypgl.model.YypLy;
import com.zssi.framework.app.ypgl.model.YypTy;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypGhService;
import com.zssi.framework.app.ypgl.service.YypLyService;
import com.zssi.framework.app.ypgl.service.YypTyService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;
import com.zssi.framework.app.yxxgl.model.Yxxmb;
import com.zssi.framework.app.yxxgl.service.YxxmbService;
/**
 * 主页--消息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/yxxgl")
public class YxxmbController extends BaseController {
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypGhController.class);
			
	@Autowired
	private YxxmbService yxxmbService;
	
	/**
	 * 功能--项目详细信息分页
	 * @author mabiao
	 * @version 2015年10月10日上午9:56:27
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYxxmbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYxxmbList(Integer start,Integer limit,String code){
		return yxxmbService.getYxxmbList(start, limit, code);
	}
	
	/**
	 * 功能--跳转
	 * @author mabiao
	 * @version 2015年10月10日上午9:55:43
	 * @return
	 */
	@RequestMapping(value = "/xxmbPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/yxxgl/xxmbList");
		return modelAndView;
	}
	
	/**
	 * 功能--保存
	 * @author mabiao
	 * @version 2015年10月10日上午10:28:41
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,Yxxmb entity,
			HttpServletRequest request,HttpServletResponse response){
		yxxmbService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--修改
	 * @author mabiao
	 * @version 2015年10月10日上午10:27:33
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(Yxxmb entity, String id) {
		yxxmbService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--删除
	 * @author mabiao
	 * @version 2015年10月10日上午9:57:29
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yxxmbService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--消息类型（数据字典）
	 * @author mabiao
	 * @date 2015年10月10日上午10:57:29
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx() {
		return yxxmbService.getDicByLx("xxlx");
	}
	
}
