package com.zssi.framework.app.sfbzxx.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jybzgl.model.YjyXmxx;
import com.zssi.framework.app.sfbzxx.dao.YsfBzxxDao;
import com.zssi.framework.app.sfbzxx.model.YsfBzxx;
import com.zssi.framework.app.sfbzxx.service.YsfBzxxService;
import com.zssi.framework.app.sfbzxx.service.YsfXmxxService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 
 * @author liangkaidi
 * @date 2015-9-29
 */
@Controller 
@RequestMapping("/bzxx/YsfBzxx")
public class YsfBzxxController extends BaseController {
	protected final transient Logger logger=LoggerFactory.getPresentationLog(YsfBzxx.class);
	
	@Autowired
	private YsfBzxxService ysfBzxxService;
	@Autowired
	private YsfXmxxService ysfXmxxService;
	@Autowired
	private YsfBzxxDao ysfBzxxDao;
	
	@RequestMapping(value = "/getBzxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTestList(Integer start,Integer limit,String canshu){
		return ysfBzxxService.getBzxxList(start, limit, canshu);
		
	}
	@RequestMapping(value = "/BzxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/sfbzxx/YsfBzxxfList");
		return modelAndView;
	}
	/**
	 * 增加提交save
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, YsfBzxx entity) {
		String str = "1";
		str=ysfBzxxService.saveRb(request, entity);
		return str;
	}	
	
//	@RequestMapping(value = "/sfbh")
//	@ResponseBody
//	public String openwinbz(HttpServletRequest request, YsfBzxx entity) {
//		String str = "1";
//		str=ysfBzxxService.sfbh(request, entity, str);
//		return str;
//	}
	
	/**
	 * jsp页面的修改
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(HttpServletRequest request,HttpServletResponse response, String id) {
		String str = "1";
		ysfBzxxService.update(request, id);
		return str;
	}
	/**
	 * 删除
	 * @author liangkaidi
	 * @date 2015-9-28
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		ysfBzxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	
	}
	
	

	
	/**
	 * 导入EXCEL数据
	 * @author liangkaidi
	 * @date 2015-10-24
	 * @param fileData
	 * @return
	 */
		@RequestMapping(value="/bzxxupload")
	    @ResponseBody
	    public String upload(@RequestParam("fileData") MultipartFile fileData)
	    {
	        String message = ysfBzxxService.importMember(fileData);
	        if (message == null)
	            return "{\"success\":true}";
	        else
	            return "{\"success\":false,\"message\":\""+message+"\"}";
	    }
		
		
		/**
		 * 导入EXCEL数据
		 * @author liangkaidi
		 * @date 2015-10-24
		 * @param fileData
		 * @return
		 */
			@RequestMapping(value="/xmxxupload")
		    @ResponseBody
		    public String xmxxupload(@RequestParam("fileData") MultipartFile fileData)
		    {
		        String message = ysfXmxxService.importMember(fileData);
		        if (message == null)
		            return "{\"success\":true}";
		        else
		            return "{\"success\":false,\"message\":\""+message+"\"}";
		    }
			
		/**
		 * 导出Excel
		 * @author liangkaidi
		 * @date 2015-10-23
		 * @param request
		 * @param response
		 * @param canshu
		 * @throws Exception
		 */
		@RequestMapping(value = "/bzxxexport")
		public void exportExcel(HttpServletRequest request, HttpServletResponse response,String canshu) throws Exception{
			ysfBzxxService.exportExcel(request, response, canshu);
		}
		
		/**
		 * 点击增加跳转的Jsp页面
		 * @author duanpeijun
		 * @date 2015年11月4日
		 * @param request
		 * @param response
		 * @return
		 */

	@RequestMapping(value = "/sfAddView")
		
	public ModelAndView sfAddView(HttpServletRequest request,
			HttpServletResponse response, String ids) {
		ModelAndView mav = new ModelAndView("/sfbzxx/jsp/BzxxAdd");
//		List<Map<String, Object>> cplx = ysfBzxxService.getHymc();
		List<Map<String, Object>> jldw = ysfXmxxService.getDicByList("jldw");
//		mav.addObject("cplx", cplx);
		mav.addObject("jldw", jldw);
		String sdf="SF";
	    String str = sdf;
		List<Map<String, Object>> sfbhList = ysfBzxxDao.getBgbhList(str);
		System.out.println(sfbhList);
		List<Integer> list = new ArrayList<Integer>();
		if (sfbhList.size() > 0) {
			for (int i=0;i<sfbhList.size();i++){
				Map<String, Object> map=(Map<String, Object>)sfbhList.get(i);
				Iterator<String> iterator = map.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String)iterator.next();
					Object bgbhObj = map.get(key);
					//获取键值对的值并转换成String
					String sfbhitem = bgbhObj.toString();
					if (sfbhitem.length()==7) {
						String sfbhSubString = sfbhitem.substring(3,7);
						Integer sfbhInt = Integer.parseInt(sfbhSubString);
						list.add(sfbhInt);
					}else if (sfbhitem.length()==8){
						String sfbhSubString = sfbhitem.substring(4,8);
						Integer sfbhInt = Integer.parseInt(sfbhSubString);
						list.add(sfbhInt);
					}
				}
			}
			int tempMax = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) >= tempMax) {
					tempMax = list.get(i);
				}
			}
			int sfbhCur = tempMax + 1;
			String tempsfbh = "" + sfbhCur;
			int sfbhlength = tempsfbh.length();
			
			if (sfbhlength==1) {
				str += "0000"+tempsfbh; 
			}else if (sfbhlength==2) {
				str += "000"+tempsfbh; 
			}else if (sfbhlength==3) {
				str += "00"+tempsfbh; 
			}else if (sfbhlength==4) {
				str += "0"+tempsfbh; 
			}else {
				str += tempsfbh; 
			}
		}else {
			str += "00001";
		}
		
		if (str != null) {
			mav.addObject("sfbzbh", str);
		}
		if (str != null) {
			mav.addObject("xmbh", str);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/sfxmView")
	
	public ModelAndView sfxmView(HttpServletRequest request,
			HttpServletResponse response, String ids) {
		ModelAndView mav = new ModelAndView("/sfbzxx/jsp/Bzxx");
		List<Map<String, Object>> cplx = ysfBzxxService.getHymc();
		List<Map<String, Object>> dw_id = ysfBzxxService.getDicByList("dw_id");
		mav.addObject("cplx", cplx);
		mav.addObject("dw_id", dw_id);
		
		if (ids != null && !"".equals(ids)) {
			YjyXmxx getjyxm = ysfBzxxService.getjyxmmc(ids);
			String xmbh = getjyxm.getXmbh();
			if (getjyxm != null) {
				mav.addObject("getjyxmmc", getjyxm.getXmmc());
				mav.addObject("getjyxmbh", getjyxm.getXmbh());
			}
		}
		return mav;
	}
	
	/**
	 * 检验页面中————检验标准信息
	 * 
	 * @author liangkaidi
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/jybz")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/sfbzxx/jsp/jybz");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> jybz = ysfBzxxService.getJybzxx(code);
		if (jybz != null) {
			mav.addObject("jybz", jybz);
		}
		return mav;
	}
	
	
	/**
	 * 检验页面中————检验项目信息
	 * 
	 * @author liangkaidi
	 * @date 2015年11月4日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/jyxm")
	public ModelAndView ypjyxm(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/sfbzxx/jsp/jyxm");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> jyxm = ysfBzxxService.getJyxmxx(code);
		if (jyxm != null) {
			mav.addObject("jyxm", jyxm);
		}
		return mav;
	}
	
	
	/**
	 * 点击修改跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-11
	 * @param request
	 * @param response
	 * @return
	 */


	@RequestMapping(value = "/sfbzxxXgView")
	public ModelAndView jyDetailView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sfbzxx/jsp/BzxxXg");
		String id = request.getParameter("id");
		List<Map<String, Object>> bzxx = ysfBzxxService.getXg(id);
//		YsfBzxx bzxx = ysfBzxxService.getXg(id);
		if (bzxx != null) {
			mav.addObject("bzxx", bzxx);
		}
		return mav;
	}
	/**
	 * 点击查看跳转到查看jsp
	 * @author liangkaidi
	 * @date 2015-12-16
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sfbzCkView")
	public ModelAndView sfbzCkView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/sfbzxx/jsp/BzxxCk");
		String id = request.getParameter("id");
		List<Map<String, Object>> bzxx = ysfBzxxService.getCk(id);
//		YsfBzxx bzxx = ysfBzxxService.getCk(id);
		if (bzxx != null) {
			mav.addObject("bzxx", bzxx);
		}
		return mav;
	}
	
	

	
}
