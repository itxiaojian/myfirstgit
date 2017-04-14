package com.zssi.framework.app.rsgl.controller;

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
import com.zssi.framework.app.rsgl.dao.YrsXzInfoDao;
import com.zssi.framework.app.rsgl.model.YrsXzInfo;
import com.zssi.framework.app.rsgl.service.YrsXzInfoService;
import com.zssi.framework.app.util.ResponseData;


@Controller
@RequestMapping("/rsgl/YRsXzInfo")
public class YrsXzInfoController extends BaseController{

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YrsXzInfoController.class);
	@Autowired
	private YrsXzInfoService yrsXzInfoService;
	@Autowired
	private YrsXzInfoDao  yrsXzInfoDao;
	/**
	 * 后台：薪资管理信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getXzInfoList")
	@ResponseBody
	public Pagination<Map<String, Object>> getXzInfoList(Integer start,Integer limit,String code){
		return yrsXzInfoService.getXzInfoList(start, limit, code);
	}
	
	@RequestMapping(value = "/XzInfoPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/rsgl/yrsXzInfoList");
		return modelAndView;
	}
	
	/**
	 * 后台:增加薪资管理信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YrsXzInfo entity,
			HttpServletRequest request,HttpServletResponse response){
		yrsXzInfoService.save(entity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:修改薪资管理信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YrsXzInfo entity, String id) {
		yrsXzInfoService.update(entity, id);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 后台:删除薪资管理信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yrsXzInfoService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月24日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yrsXzInfoService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月24日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yrsXzInfoService.exportExcel(request,response,code);
	}
	/**
	 * 点击增加跳转jsp页面
	 * @author liangkaidi
	 * @date 2015-11-25
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/xzglAddView")
	public ModelAndView ygflAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/Xzgl");
		String sdf="RY";
	    String str = sdf;
		List<Map<String, Object>> sfbhList = yrsXzInfoDao.getBgbhList();
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
	@RequestMapping(value = "/xzglXgView")
	public ModelAndView cbxxUpdateView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/rsgl/jsp/XzglXg");
		String id = request.getParameter("id");
		List<Map<String, Object>> xzgl = yrsXzInfoService.getXzgl(Integer.parseInt(id));
		if (xzgl != null) {
			mav.addObject("xzgl", xzgl);
		}
		return mav;
	}
}
