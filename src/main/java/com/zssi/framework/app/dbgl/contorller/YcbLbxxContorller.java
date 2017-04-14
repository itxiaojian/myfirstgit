package com.zssi.framework.app.dbgl.contorller; 

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
import com.zssi.framework.app.dbgl.model.YcbLbxx;
import com.zssi.framework.app.dbgl.service.YcbLbxxService;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 业务督办督办信息列表contorller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:30:38 
 * 类说明 
 */
@Controller
@RequestMapping("/dbgl/YdbDblb")
public class YcbLbxxContorller extends BaseController {
	
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YcbLbxxContorller.class);
	
	@Autowired
	private YcbLbxxService ydbDblbService;
	
	@RequestMapping(value = "/getDblbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getDblbList(Integer start,Integer limit,String code){
		return ydbDblbService.getDblbList(start, limit,code);
		}
	
	@RequestMapping(value = "/DblbPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/dbgl/yCbLbxxList");
		return modelAndView;
		}
	
	
	/** 
	 * 督办状态下拉框
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:39:24 
	 * 类说明 
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ydbDblbService.getDicByLx("cbzt");
		}
	
	
	/** 
	 * 反馈状态下拉框
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:39:09 
	 * 类说明 
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return ydbDblbService.getDicByLx1("fkzt");
		}
	
	
	/** 
	 * 保存
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:37:59 
	 * 类说明 
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YcbLbxx entity,
			HttpServletRequest request,HttpServletResponse response){
		ydbDblbService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/** 
	 * 更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:37:37 
	 * 类说明 
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update (YcbLbxx entity, String id){
		ydbDblbService.update(entity,id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/** 
	 * 删除
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:38:24 
	 * 类说明 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ydbDblbService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
}
