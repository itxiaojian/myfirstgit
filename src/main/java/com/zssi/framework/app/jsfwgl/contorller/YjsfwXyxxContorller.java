package com.zssi.framework.app.jsfwgl.contorller; 

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwJsfwxysf;
import com.zssi.framework.app.cwgl.service.YcwJsfwxysfService;
import com.zssi.framework.app.jsfwgl.model.YjsfwXyxx;
import com.zssi.framework.app.jsfwgl.service.YjsfwXyxxService;
import com.zssi.framework.app.util.ResponseData;

/**
 * 技术服务信息contorller类
 * @author liusong
 * @date 2015年10月9日
 * @return
 */
@Controller
@RequestMapping("/jsfwgl/YjsfwXyxx")
public class YjsfwXyxxContorller extends BaseController{
	protected final transient Logger logger = LoggerFactory.getPersistenceLog(YjsfwXyxxContorller.class);
	@Autowired
	private YjsfwXyxxService yJsfwXyxxService;
	
	@Autowired
	private YcwJsfwxysfService xysfService;
	
	
	/**
	 * 后台：技术服务协议信息
	 * @author liusong
	 * @date 2015年10月9日
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/getJsfwXyxxList")
	@ResponseBody
	public Pagination<Map<String,Object>> getJsfwXyxxList(Integer start,Integer limit,String code){
		return yJsfwXyxxService.getJsfwXyxxList(start, limit,code);
	}
	
	@RequestMapping(value = "/JsfwXyxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/jsfwgl/yJsfwXyxxList");
		return modelAndView;
		}
	
	/**
	 * 反馈方式下拉菜单查询
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return yJsfwXyxxService.getDicByLx("fkfs");
	}
	
	/**
	 * 新增保存
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(ModelMap model,YjsfwXyxx entity,YcwJsfwxysf entity1,
			HttpServletRequest request,HttpServletResponse response){
		entity.setDjrq(Calendar.getInstance().getTime());
		entity.setSyje(entity.getXykh());
		yJsfwXyxxService.save(entity);
//		System.out.println(entity);
		entity1.setXybh(entity.getXybh());
		entity1.setZxbz(entity.getBz_id());
		entity1.setXxqk(entity.getKhjlgm());
		entity1.setQzqk(entity.getKhhz_info());
		entity1.setXyks_id(entity.getKs_id());
		entity1.setJyks_id(entity.getJyks_id());
		entity1.setYwks_id(entity.getYeks_id());
		entity1.setSsks_id(entity.getKs_id());
		if(entity.getXykh()!=null && !"".equals(entity.getXykh())){
			entity1.setXyje(entity.getXykh());
		}else{
			entity1.setXyje(new BigDecimal(0));
		}
		entity1.setYsje(entity.getXykh());
		entity1.setYsfje(new BigDecimal(0));
		entity1.setSfrq(Calendar.getInstance().getTime());
		entity1.setSfr("1");
		xysfService.save(entity1);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 更新
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(YjsfwXyxx entity,YcwJsfwxysf entity1, String id,HttpServletRequest request,HttpServletResponse response) {
		if(request.getParameter("bfxyje") != null && !"".equals(request.getParameter("bfxyje"))){
			BigDecimal bfxyje=new BigDecimal(request.getParameter("bfxyje"));
			entity.setSyje(entity.getXykh().subtract(bfxyje).add(entity.getSyje()));
		}else{
			entity.setSyje(entity.getXykh());
		}
		yJsfwXyxxService.update(entity, id);
		String ids = yJsfwXyxxService.getIdbyXybh(request.getParameter("bfxybh")).get(0).get("id").toString();
		entity1.setXyks_id(entity.getKs_id());
		entity1.setJyks_id(entity.getJyks_id());
		entity1.setYwks_id(entity.getYeks_id());
		entity1.setSsks_id(entity.getKs_id());
		entity1.setXyje(entity.getXykh());
		entity1.setYsje(entity.getXykh());
		entity1.setXybh(entity.getXybh());
		entity1.setZxbz(entity.getBz_id());
		entity1.setXxqk(entity.getKhjlgm());
		entity1.setQzqk(entity.getKhhz_info());
		entity1.setSfrq(entity.getDjrq());
		entity1.setYsfje(new BigDecimal(0));
		entity1.setSfr("1");
		xysfService.update(entity1,ids);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年10月9日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids,String[] xybh){
		yJsfwXyxxService.delete(ids,xybh);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 技术服务信息导出
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yJsfwXyxxService.exportExcel(request,response,code);
	}
	
	/**
	 * 技术服务信息导入
	 * @author liusong
	 * @date 2015年10月9日
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yJsfwXyxxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
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
	

@RequestMapping(value = "/jsfwAddView")
@ResponseBody
	public ModelAndView hyAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/jsfwgl/jsp/Jsfwgl");
		List<Map<String, Object>> fkfs = yJsfwXyxxService.getDicByList("fkfs");
		mav.addObject("fkfs", fkfs);
		return mav;
	}



/**
 * 点击修改按钮跳转到修改窗口的jsp页面
 * @author liusong
 * @date 2015年11月17日
 * @return
 */
@RequestMapping(value = "/jsfwXgView")
public ModelAndView jsfwXgView(HttpServletRequest request,
		HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("/jsfwgl/jsp/JsfwglXg");
	String id = request.getParameter("id");
//	System.out.println("获取到的id是: " + id);
	List<Map<String, Object>> jsfw = yJsfwXyxxService.getXg(id);
	if (jsfw != null) {
		mav.addObject("jsfw", jsfw);
	}
	List<Map<String, Object>> fkfs = yJsfwXyxxService.getDicByLx("fkfs");
	mav.addObject("fkfs",fkfs);
	return mav;
}

	/**
	 * 检验合同号从协议信息获取，获取协议信息方法	
	 * @author wangyong
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getJyhth")
	@ResponseBody
		public List<Map<String, Object>> getJyhth(HttpServletRequest request,
				HttpServletResponse response) {
			String jyhthkhmc = request.getParameter("jyhthkhmc");
			String jyhthkhdz = request.getParameter("jyhthkhdz");
			List<Map<String, Object>> list = yJsfwXyxxService.getJyhth(jyhthkhmc, jyhthkhdz);
			return list;
    }

}
