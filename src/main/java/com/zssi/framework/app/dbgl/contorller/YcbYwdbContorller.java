package com.zssi.framework.app.dbgl.contorller; 

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
import com.zssi.framework.app.dbgl.model.YcbWddb;
import com.zssi.framework.app.dbgl.service.YcbWddbService;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 业务督办contorller层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月20日 上午10:39:18 
 * 类说明 
 */
@Controller
@RequestMapping("/dbgl/YdbYwdb")
public class YcbYwdbContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YcbYwdbContorller.class);
	
	@Autowired
	private YcbWddbService ydbWddbService;
	
	@RequestMapping(value = "/getYwdbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYwdbList(Integer start,Integer limit,String code){
		return ydbWddbService.getYwdbList(start, limit,code);
		}
		
	@RequestMapping(value = "/YwdbPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/dbgl/yCbYwdbList");
		return modelAndView;
		}
	
	
	/** 
	 * 保存
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:43:06 
	 * 类说明 
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcbWddb entity,
			HttpServletRequest request,HttpServletResponse response){
		ydbWddbService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/** 
	 * 更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:43:24 
	 * 类说明 
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update (YcbWddb entity, String id){
		ydbWddbService.update(entity,id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/** 
	 * 删除
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:43:36 
	 * 类说明 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ydbWddbService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}

}
