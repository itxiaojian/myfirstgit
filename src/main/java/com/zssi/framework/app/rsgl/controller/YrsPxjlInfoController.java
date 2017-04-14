package com.zssi.framework.app.rsgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.zssi.framework.app.cwgl.model.YcwYgfl;
import com.zssi.framework.app.kygl.model.YkyXxgl;
import com.zssi.framework.app.rsgl.dao.YrsPxjlInfoDao;
import com.zssi.framework.app.rsgl.model.YrsPxjlInfo;
import com.zssi.framework.app.rsgl.service.YrsPxjlInfoService;
import com.zssi.framework.app.sfwgl.model.YsfwFwxx;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/rsgl/YRsPxjlInfo")
public class YrsPxjlInfoController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YrsPxjlInfoController.class);
	@Autowired
	private YrsPxjlInfoService yrsPxjlInfoService;
	@Autowired
	private YrsPxjlInfoDao yrsPxjlInfoDao;
	/**
	 * 后台：培训记录信息
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getPxjlInfoList")
	@ResponseBody
	public Pagination<Map<String, Object>> getPxjlInfoList(Integer start,Integer limit,String code){
		return yrsPxjlInfoService.getPxjlInfoList(start, limit, code);
	}
	
	@RequestMapping(value = "/PxjlInfoPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/rsgl/yrsPxjlInfoList");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/Yh")
	public ModelAndView ypjybz(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/Yh");
		String code = request.getParameter("code");
		if (id != null) {
			mav.addObject("id", id);
		}
		List<Map<String, Object>> Yh = yrsPxjlInfoService.getYh(code);
		if (Yh != null) {
			mav.addObject("Yh", Yh);
		}
		return mav;
	}
	
	/**
	 * 后台:培训记录信息
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	/**
	 * 增加提交save
	 * @author liangkaidi
	 * @date 2015-11-10
	 * @param request
	 * @param entity
	 * @return
	 */
//	@RequestMapping(value = "/save")
//	@ResponseBody
//	public String save(HttpServletRequest request, YrsPxjlInfo entity) {
//		String str = "";
//		str=yrsPxjlInfoService.saveRb(request, entity);
//		return str;
//	}	
	
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YrsPxjlInfo entity,
			HttpServletRequest request,HttpServletResponse response){
		yrsPxjlInfoService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * jsp页面的修改
	 * @author liangkaidi
	 * @date 2015-11-28
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YrsPxjlInfo entity, String id) {
		yrsPxjlInfoService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除培训记录信息
	 * @author wangyong
	 * @date 2015年10月22日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrsPxjlInfoService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月26日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yrsPxjlInfoService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月26日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yrsPxjlInfoService.exportExcel(request,response,code);
	}
	/**
	 * 点击增加跳转jsp页面
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pxjlAddView")
	public ModelAndView ygflAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/Pxjl");
		List<Map<String, Object>> xb = yrsPxjlInfoService.getDicByList("xb");
		mav.addObject("xb", xb);
//		String sdf="RY";
	    String str = "";
		List<Map<String, Object>> sfbhList = yrsPxjlInfoDao.getBgbhList();
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
		System.out.println("&&&&&&&&&&&&&&&"+str);
		if (str != null) {
			mav.addObject("ryzh", str);
		}
		if (str != null) {
			mav.addObject("rybh", str);
		}
		return mav;
	}
	
	/**
	 * 点击修改跳转到修改窗口的JSP页面
	 * 
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pxjlXgView")
	public ModelAndView jyDetailView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/PxjlXg");
		String id = request.getParameter("id");
		YrsPxjlInfo pxjl = yrsPxjlInfoService.getXg(id);
		List<Map<String, Object>> xb = yrsPxjlInfoService.getDicByList("xb");
		mav.addObject("xb", xb);
		if (pxjl != null) {
			if (pxjl != null) {
				if(pxjl.getPxsj()!=null){
					SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					mav.addObject("pxsj", sim.format(pxjl.getPxsj()));
				}
				mav.addObject("pxjl", pxjl);
			}
			mav.addObject("pxjl", pxjl);
		}
		return mav;
	}
}
