package com.zssi.framework.app.khgl.controller;

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
import com.zssi.framework.app.khgl.dao.YkhKhxxDao;
import com.zssi.framework.app.khgl.model.YkhKhxx;
import com.zssi.framework.app.khgl.service.YkhKhxxService;
import com.zssi.framework.app.util.ResponseData;
/**
 * 
 * @author liangkaidi
 * @date 2015-9-23
 */
@Controller 
@RequestMapping("/khgl/YKhKhxx")
public class YkhKhxxController extends BaseController{
protected final transient Logger logger=LoggerFactory.getPresentationLog(YkhKhxx.class);
	
	@Autowired
	private YkhKhxxService yKhKhxxService;
	@Autowired
	private YkhKhxxDao ykhKhxxDao;
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-10-21
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 * 查询
	 */
	
	@RequestMapping(value = "/getKhKhxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getTestList(Integer start,Integer limit,String code){
		return yKhKhxxService.getKhxxList(start, limit, code);
		
	}
	
	/**
	 * 样品登记时委托单位从客户信息中查询获取
	 * @author wangyong
	 * @date 2015年12月18日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getKhxx")
	@ResponseBody
	public List<Map<String, Object>> getKhxx(HttpServletRequest request,
			HttpServletResponse response) {
		String khmccx = request.getParameter("khmccx");
		String khflcx = request.getParameter("khflcx");
		List<Map<String, Object>> wtdw = yKhKhxxService.getWtdwKhxx(khmccx, khflcx);
		return wtdw;
	}
	
	/**
	 * 通过id获取客户信息的内容
	 * @author wangyong
	 * @date 2015年12月18日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getKhxxById")
	@ResponseBody
	public List<Map<String, Object>> getKhxxById(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		List<Map<String, Object>> wtdw = yKhKhxxService.getKhxxById(Integer.parseInt(id));
		return wtdw;
	}
	
	
	/**
	 * 通过id获取客户信息的内容
	 * @author wangyong
	 * @date 2015年12月18日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getJsfwglById")
	@ResponseBody
	public List<Map<String, Object>> getJsfwglById(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		List<Map<String, Object>> wtdw = yKhKhxxService.getJsfwglById(Integer.parseInt(id));
		return wtdw;
	}
	
	@RequestMapping(value = "/KhxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/khgl/ykhKhxxList");
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
	public String save(HttpServletRequest request, YkhKhxx entity) {
		String str="0";
		String zjhm = request.getParameter("zjhm");
		List<Map<String, Object>> zjhmList = yKhKhxxService.getZjhm(zjhm);
//		boolean flag = true;
//		for (int i=0;i<zjhmList.size();i++){
//	        Map<String, Object> map=(Map<String, Object>)zjhmList.get(i);
//	        Iterator<String> iterator = map.keySet().iterator();
//            while (iterator.hasNext())
//            {
//                String key = (String)iterator.next();
//                Object zjhmObj = map.get(key);
//                System.out.println(zjhmObj);
//                System.out.println(zjhmObj.toString());
//                String zjhmitem = zjhmObj.toString();
//                
//                if (zjhmitem.equals(zjhm)) {
//					flag = false;
//					break;
//				}
//            }
//		}
		if (zjhmList.size() <= 0) {
 			str=yKhKhxxService.saveRb(request, entity);
 		}
		return str;
	}	
	
	
	
	@RequestMapping(value = "/save1")
	@ResponseBody
	public String save1(HttpServletRequest request, YkhKhxx entity){
		String  str = yKhKhxxService.saveRb(request, entity);
		return str;
		
	}
	
	
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
	public String update(HttpServletRequest request,HttpServletResponse response, YkhKhxx entity) {
		String str="";
		String zjhm = request.getParameter("zjhm");
		System.out.println(zjhm);
		List<Map<String, Object>> zjhmList = yKhKhxxService.getZjhm(zjhm);
		if (zjhmList.size() <= 1) {
	 			str=yKhKhxxService.update(request, entity);
	 	}
		
		return str;
	}
	
	
	
	@RequestMapping(value = "/update1", method = RequestMethod.POST)
	@ResponseBody
	public String update1(HttpServletRequest request,HttpServletResponse response,YkhKhxx entity){
		String  str="1";
		yKhKhxxService.update(request, entity);
		return str;
		
	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-23
	 * @param ids
	 * @return
	 *  删除
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids){
		yKhKhxxService.delete(ids);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
/**
 * 导入EXCEL数据
 * @author liangkaidi
 * @date 2015-10-23
 * @param fileData
 * @return
 */
	@RequestMapping(value="/khxxupload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yKhKhxxService.importMember(fileData);
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
	 * @param code
	 * @throws Exception
	 */
	@RequestMapping(value = "/khxxexport")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yKhKhxxService.exportExcel(request,response,code);
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 点击增加跳转的Jsp页面
	 * @author liangkaidi
	 * @date 2015-11-23
	 * @param request
	 * @param response
	 * @return
	 */
	

@RequestMapping(value = "/khAddView")
	
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/khgl/jsp/khxx");
		List<Map<String, Object>> khfl = yKhKhxxService.getHymc();
		List<Map<String, Object>> dwxz = yKhKhxxService.getDicByList("dwxz");
		List<Map<String, Object>> zjlx = yKhKhxxService.getDicByList("zjlx");
		
		mav.addObject("khfl", khfl);
		mav.addObject("dwxz", dwxz);
		mav.addObject("zjlx", zjlx);
		
		
	    
	    String str = "";
		List<Map<String, Object>> sfbhList = ykhKhxxDao.getBgbhList(str);
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
					if (sfbhitem.length()==9) {
						String sfbhSubString = sfbhitem.substring(5,9);
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
			mav.addObject("khbh", str);
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


@RequestMapping(value = "/khxxXgView")
public ModelAndView jyDetailView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/khgl/jsp/khxxXg");
	List<Map<String, Object>> khfl = yKhKhxxService.getHymc();
	List<Map<String, Object>> dwxz = yKhKhxxService.getDicByList("dwxz");
	List<Map<String, Object>> zjlx = yKhKhxxService.getDicByList("zjlx");
	
	mav.addObject("khfl", khfl);
	mav.addObject("dwxz", dwxz);
	mav.addObject("zjlx", zjlx);
	String id = request.getParameter("id");
	List<Map<String, Object>> khxx = yKhKhxxService.getXg(id);
	if (khxx != null) {
		mav.addObject("khxx", khxx);
	}
	return mav;
}
/**
 * 
 * @author liangkaidi
 * @date 2015-12-3
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = "/khxxCkView")
public ModelAndView khxxCkView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/khgl/jsp/KhxxCk");
	String id = request.getParameter("id");
	List<Map<String, Object>> khxx = yKhKhxxService.getCk(id);
	if (khxx != null) {
		mav.addObject("khxx", khxx);
	}
	return mav;
}


}
