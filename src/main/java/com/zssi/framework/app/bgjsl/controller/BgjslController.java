package com.zssi.framework.app.bgjsl.controller;

import java.text.ParseException;
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
import com.zssi.framework.app.bgjsl.model.Bgjsl;
import com.zssi.framework.app.bgjsl.service.BgjslService;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.tjgl.service.BgcxService;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

@Controller
@RequestMapping("/bgjsl")
public class BgjslController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(BaseController.class);
	
	@Autowired
	private BgjslService service;
	
	@Autowired
	private BgcxService bgcxservice;
	@Autowired
	private YypYpxxService ypxxService;
	
	
	@RequestMapping(value = "/ListPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/bgjsl/CsList");
		return modelAndView;
		}
	/**
	 * 报告及时率参数列表查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getList")
	@ResponseBody
	public Pagination<Map<String, Object>> getList(Integer start,Integer limit,String code){
		return service.getList(start, limit,code);
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
	public ResponseData save(ModelMap model,Bgjsl entity,
			HttpServletRequest request,HttpServletResponse response){
		service.save(entity);
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
	public ResponseData update(Bgjsl entity){
		service.update(entity);
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
		service.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 及时率查询
	 * @author liusong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/JslListPage")
	public ModelAndView JslListPage(){
		ModelAndView mav = new ModelAndView("/bgjsl/JslList");
		List<Map<String,Object>> ksmc=bgcxservice.getJyksList();
		List<Map<String,Object>> csjd=service.getCsjd();
		mav.addObject("ksmc", ksmc);
		mav.addObject("csjd", csjd);
		return mav;
	}
	
	
	/**
	 * 报告查询
	 * @author liusong
	 * @date 2016年1月13日
	 * @param start
	 * @param limit
	 * @param cs
	 * @param cxtj
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/getBgcxList")
	@ResponseBody
	public List<Map<String,Object>> getBgyq(HttpServletRequest request, HttpServletResponse response,Integer start,Integer limit,Integer size) throws ParseException {
		String ypbh = request.getParameter("ypbh");
		String ksmccx = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		String csjd = request.getParameter("csjd");
		List<Map<String,Object>> sjbbCbtj=service.getBgyqList(ypbh,ksmccx, ksyf,jsyf,csjd,start, limit);
		int count=service.getBgxxCount(ypbh,ksmccx, ksyf,jsyf,csjd);
		for(int i=0;i<sjbbCbtj.size();i++){
			Map<String,Object> map=sjbbCbtj.get(i);
			map.put("count", count);
			if(count%size==0){
				map.put("pages", count/size);
			}else{
				map.put("pages", count/size+1);
			}
		}
		return sjbbCbtj;
	}
	
	/**
	 * 报告拖期统计导出Excle
	 * @author liusong
	 * @date 2016年1月26日
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportBgtq")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ypbh = request.getParameter("ypbh");
		String ksmc = request.getParameter("ksmc");
		String ksyf = request.getParameter("ksyf");
		String jsyf = request.getParameter("jsyf");
		String csjd = request.getParameter("csjd");
		service.exportBgtq(request,response,ypbh,ksmc,ksyf,jsyf,csjd);
	}

}
