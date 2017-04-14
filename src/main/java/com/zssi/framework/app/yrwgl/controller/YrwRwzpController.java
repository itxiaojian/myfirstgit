package com.zssi.framework.app.yrwgl.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.zssi.framework.app.dbgl.model.YcbLbxx;
import com.zssi.framework.app.dbgl.service.YcbLbxxService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.controller.YypGhController;
import com.zssi.framework.app.yrwgl.model.YrwRwzp;
import com.zssi.framework.app.yrwgl.model.YrwWdrw;
import com.zssi.framework.app.yrwgl.service.YrwRwzpService;
import com.zssi.framework.app.yrwgl.service.YrwWdrwService;
/**
 * 功能--我的任务
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/yrwgl/yrwzp")
public class YrwRwzpController extends BaseController {
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypGhController.class);
	@Autowired
	private YrwRwzpService yrwRwzpService;
	
	@Autowired
	private YrwWdrwService yrwWdrwService;
	
	@Autowired
	private YcbLbxxService ycbLbxxService;
	
	/**
	 * 功能--任务指派详细信息
	 * @author mabiao
	 * @version 2015年10月12日上午9:56:27
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYrwRwzpList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYrwRwzpList(Integer start, 
			Integer limit, String code1, String code2, String code3){
		return yrwRwzpService.getYrwRwzpList(start, limit, code1, code2, code3);
	}
	
	/**
	 * 查询系统用户
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getRwZprList")
	@ResponseBody
	public Pagination<Map<String, Object>> getRwZprList(Integer start,
			Integer limit,String code1,String code2){
		return yrwRwzpService.getRwZprList(start, limit, code1, code2);
	}
	
	/**
	 * 功能--跳转
	 * @author mabiao
	 * @version 2015年10月12日上午9:55:43
	 * @return
	 */
	@RequestMapping(value = "/yrwzpPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/yrwgl/yrwzpList");
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
	public ResponseData save(ModelMap model,YrwRwzp entity,
			HttpServletRequest request,HttpServletResponse response){
		yrwRwzpService.save(entity);
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
	public ResponseData update(YrwRwzp entity, String id) {
		yrwRwzpService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 功能--延期
	 * @author mabiao
	 * @version 2015年10月12日上午10:27:33
	 * @param entity
	 * @param id
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/delay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YrwRwzp entity, String id , 
			String bgbh, String yqwcrq) throws ParseException {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YrwWdrw> wdrws=yrwWdrwService.getAll(filter);
		if(wdrws!=null&&wdrws.size()!=0){
			YrwWdrw wdrwEntity=wdrws.get(0);
			wdrwEntity.setYqjsrq(new SimpleDateFormat("yyyy-MM-dd").parse(yqwcrq));
			yrwWdrwService.update(wdrwEntity);
			entity.setYqwcrq(new SimpleDateFormat("yyyy-MM-dd").parse(yqwcrq));
			yrwRwzpService.update(entity, id);
			return ResponseData.SUCCESS_NO_DATA;
		}else{
			entity.setYqwcrq(new SimpleDateFormat("yyyy-MM-dd").parse(yqwcrq));
			yrwRwzpService.update(entity, id);
			return ResponseData.SUCCESS_NO_DATA;
		}
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
		yrwRwzpService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 指派任务提交
	 * liusong
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData submit(YrwWdrw entity, YrwRwzp entity1, String id, 
			String bgbh, String rwxarq, String yqwcrq, String zxr) {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YrwWdrw> rwzps=yrwWdrwService.getAll(filter);
		if(rwzps!=null&&rwzps.size()!=0){
			return new ResponseData(false, "记录已经存在");
		}else{
			entity.setBgbh(bgbh);
			entity.setYqksrq(Date.valueOf(rwxarq));
			entity.setYqjsrq(Date.valueOf(yqwcrq));
			SysYh zpr =AppUtil.getCurrentUser();
			entity1.setZpr(zpr.getXm());
			entity.setRwfzr(zxr);
			entity.setRwly(zpr.getXm());
			entity.setSjksrq(Calendar.getInstance().getTime());
			entity1.setZprq(Calendar.getInstance().getTime());
			yrwRwzpService.update(entity1, id);
			yrwWdrwService.save(entity);
			return ResponseData.SUCCESS_NO_DATA;
		}
	}
	
	/**
	 * 新建任务指派
	 * liusong
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/savenew", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData savenew(YrwWdrw entity, YrwRwzp entity1, String id, 
			String bgbh, String yqksrq, String yqjsrq, String zxr) {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YrwWdrw> rwzps=yrwWdrwService.getAll(filter);
		if(rwzps!=null&&rwzps.size()!=0){
			return new ResponseData(false, "记录已经存在");
		}else{
			entity1.setRwxarq(Calendar.getInstance().getTime());
			entity1.setZprq(Calendar.getInstance().getTime());
			entity1.setYqwcrq(Date.valueOf(yqjsrq));
			entity.setRwfzr(zxr);
			SysYh zpr =AppUtil.getCurrentUser();
			entity1.setZpr(zpr.getXm());
			entity.setRwly(zpr.getXm());
			entity.setSjksrq(Calendar.getInstance().getTime());
			yrwRwzpService.save(entity1);
			yrwWdrwService.save(entity);
			return ResponseData.SUCCESS_NO_DATA;
		}
	}
	
	/**
	 * 新建任务督办
	 * liusong
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/saveDban", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData saveDban(YcbLbxx entity,String bgbh) {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YcbLbxx> rwzps=ycbLbxxService.getAll(filter);
		if(rwzps!=null&&rwzps.size()!=0){
			return new ResponseData(false, "记录已经存在");
		}else{
		    entity.setCbsj(Calendar.getInstance().getTime());
			entity.setCbzt(0);
			entity.setFkzt(1);
			SysYh cbr =AppUtil.getCurrentUser();
			entity.setCbr(cbr.getXm());
			ycbLbxxService.save(entity);
			return ResponseData.SUCCESS_NO_DATA;
		}
	}
	
	/**
	 * 功能--修改
	 * @param entity
	 * @param id
	 * @param bgbh
	 * @param yqksrq
	 * @param yqjsrq
	 * @param rwfzr
	 * @param rwly
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData modify(YrwRwzp entity, String id, 
			String bgbh, String yqksrq, String yqjsrq, String rwfzr, String rwly) {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_bgbh_S_EQ", bgbh);
		List<YrwWdrw> wdrws=yrwWdrwService.getAll(filter);
		if(wdrws!=null&&wdrws.size()!=0){
			YrwWdrw wdrwEntity=wdrws.get(0);
			wdrwEntity.setRwfzr(rwfzr);
			wdrwEntity.setRwly(rwly);
			wdrwEntity.setYqksrq(Date.valueOf(yqksrq));
			wdrwEntity.setYqjsrq(Date.valueOf(yqjsrq));
			yrwWdrwService.update(wdrwEntity);
			entity.setZprq(Calendar.getInstance().getTime());
			yrwRwzpService.update(entity, id);
			return ResponseData.SUCCESS_NO_DATA;
		}else{
			yrwRwzpService.update(entity, id);
			return ResponseData.SUCCESS_NO_DATA;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx() {
		return yrwRwzpService.getDicByLx("xxlx");
	}
	
}
