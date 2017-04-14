package com.zssi.framework.app.dbgl.contorller; 

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
import com.zssi.framework.app.dbgl.model.YcbFkb;
import com.zssi.framework.app.dbgl.model.YcbLbxx;
import com.zssi.framework.app.dbgl.model.YcbWddb;
import com.zssi.framework.app.dbgl.service.YcbFkbService;
import com.zssi.framework.app.dbgl.service.YcbLbxxService;
import com.zssi.framework.app.dbgl.service.YcbWddbService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.yrwgl.model.YrwWdrw;
import com.zssi.framework.app.yrwgl.service.YrwWdrwService;

/** 
 * 我的督办contorller层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月20日 上午10:39:18 
 * 类说明 
 */
@Controller
@RequestMapping("/dbgl/YdbWddb")
public class YcbWddbContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YcbWddbContorller.class);
	
	@Autowired
	private YcbWddbService ydbWddbService;
	
	@Autowired
	private YcbLbxxService ycbLbxxService;
	
	@Autowired
	private YrwWdrwService yrwWdrwService;
	
	@Autowired
	private YcbFkbService ycbFkbService;
	
	@RequestMapping(value = "/getWddbList")
	@ResponseBody
	public Pagination<Map<String, Object>> getWddbList(Integer start,Integer limit,String code){
		return ydbWddbService.getWddbList(start, limit,code);
		}
		
	@RequestMapping(value = "/WddbPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/dbgl/yCbWddbList");
		return modelAndView;
		}
	
	
	/**
	 * 保存 
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:42:31 
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
	 * 督办反馈回复保存
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/saveHfu", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData saveHfu(YrwWdrw entity1, YcbFkb entity2,String bgbh,String id,String rwid) {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YcbFkb> rwzps=ycbFkbService.getAll(filter);
		if(rwzps!=null&&rwzps.size()!=0){
			return new ResponseData(false, "记录已经存在");
		}else{
			YcbLbxx entity=ycbLbxxService.get(id);
			entity.setFkzt(0);
			SysYh fkr =AppUtil.getCurrentUser();
			entity2.setFkr(fkr.getXm());
			entity2.setFkrid(fkr.getYhpxh());
			entity2.setFkzt(1);
			entity2.setFksj(Calendar.getInstance().getTime());
			ycbLbxxService.update(entity, id);
			yrwWdrwService.update(entity1, rwid);
			ycbFkbService.save(entity2);
			return ResponseData.SUCCESS_NO_DATA;
		}
	}
	
	
	/**
	 * 更新 
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月23日 下午2:42:42 
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
	 * @version 创建时间：2015年10月23日 下午2:42:51 
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
