package com.zssi.framework.app.yhgl.controller; 

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.SettingUtil;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sys.model.SysZzjg;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.yhgl.model.SysYhxx;
import com.zssi.framework.app.yhgl.service.SysYhService;

/** 
 * 用户管理controller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:06:00 
 * 类说明 
 */
@Controller
@RequestMapping("/yhgl/SysYh")
public class SysYhController extends BaseController {
	protected final transient Logger logger = LoggerFactory.getPresentationLog(SysYhController.class);
	@Autowired
	private SysYhService sysYhService;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	@RequestMapping(value = "/getSysyhList")
	@ResponseBody
	public Pagination<Map<String, Object>> getSysyhList(Integer start,Integer limit,String code){
		return sysYhService.getSysyhList(start, limit,code);
	}
	
	@RequestMapping(value = "/getYdjyhList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYdjyhList(Integer start,Integer limit,String code){
		return sysYhService.getYdjyhList(start, limit,code);
	}
	
	@RequestMapping(value = "/YdjYhPage")
	public ModelAndView YdjYhPage(){
		ModelAndView modelAndView= new ModelAndView("/yhgl/YdjYhPage");
		return modelAndView;
		}
	
	@RequestMapping(value = "/SysYhPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView= new ModelAndView("/yhgl/yyhScDzqm");
		return modelAndView;
		}
	
	/** 
	 * 依次是用户状态、从业状态、性别、职务、政治面貌下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@RequestMapping(value = "/getDicByLx1", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx1(String zdzl) {
		return sysYhService.getDicByLx("yhzt");
	}
	
	@RequestMapping(value = "/getDicByLx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return sysYhService.getDicByLx("cyzt");
	}
	
	@RequestMapping(value = "/getDicByLx2", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx2(String zdzl) {
		return sysYhService.getDicByLx("xb");
	}
	
	@RequestMapping(value = "/getDicByLx3", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx3(String zdzl) {
		return sysYhService.getDicByLx("xl");
	}
	
	@RequestMapping(value = "/getDicByLx4", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx4(String zdzl) {
		return sysYhService.getDicByLx("zzmm");
	}
	
	@RequestMapping(value = "/getDicByLx5", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLx5(String zdzl) {
		return sysYhService.getDicByLx("zw");
	}
	
	@RequestMapping(value = "/getKhfl", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getKhfl(String zdzl) {
		return sysYhService.getDicByLx("khfl");
	}
	
//	@RequestMapping(value="/save")
//	@ResponseBody
//	public ResponseData save(ModelMap model,SysYhxx entity,
//			HttpServletRequest request,HttpServletResponse response){
//		sysYhService.save(entity);
//		return ResponseData.SUCCESS_NO_DATA;
//	}
	
	/**
	 * 上传电子签名
	 */
	@RequestMapping(value="/uploadImage")
	@ResponseBody
	public String UploadImageMaterial(@RequestParam("attachMentFile") MultipartFile attachMentFile,SysYhxx yhxx,
			SysZzjg zzjg,HttpServletResponse actioncontext,HttpServletRequest request){ 
//		    alert("程序跑到这里");
		try{
			sysYhService.UploadImageMaterial(attachMentFile, yhxx,zzjg,actioncontext, request);
//			File file=null;
//			sysYhService.scale(file);
			return "{\"success\":\"上传成功\"}";	
		}catch(Exception e) {
			return "{\"failure\":\""+e.getMessage()+"\"}";
		}
	}

	/**
	 * 点击查看电子签名
	 * @return
	 */
	@RequestMapping(value = "/getImageList", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getImageList(String yhbh) {
		return sysYhService.getImageList(yhbh);
	}
	
//	选择档案类目list查询
	@RequestMapping(value = "/getKckr")
	@ResponseBody
	public List<Map<String,Object>> getKckr(HttpServletRequest request,
			HttpServletResponse response){
		String xm = request.getParameter("xm");
		String bmmc = request.getParameter("bmmc");
		List<Map<String,Object>> dalm = sysYhService.getKckr(xm,bmmc);
		return dalm;
	}
	
//	选择档案类目list查询
	@RequestMapping(value = "/getKckrById")
	@ResponseBody
	public List<Map<String,Object>> getKckrById(HttpServletRequest request,
			HttpServletResponse response){
		String yhbh = request.getParameter("yhbh");
		List<Map<String,Object>> dalm = sysYhService.getKckrById(Integer.parseInt(yhbh));
		return dalm;
	}
	
	/**
	 * 打开电子签名 页面
	 * @return
	 */
	@RequestMapping(value = "/scDzqmView")
	public ModelAndView openImageMaterialView(){
		ModelAndView view = new ModelAndView("/yhgl/yyhScDzqm");
		return view;
	}
	
	/** 
	 * 保存
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public ResponseData save(SysYhxx entity) {
		entity.setMm(md5PasswordEncoder.encodePassword(
				(String) SettingUtil.getSetting("default.password", null),
				entity.getDlm()));
		entity.setYhzt(1);
		 sysYhService.save(entity);
		 return ResponseData.SUCCESS_NO_DATA;
		 
	}
	
	@RequestMapping(value="/saveydj")
	@ResponseBody
	public ResponseData saveydj(SysYhxx entity) {
		entity.setMm(md5PasswordEncoder.encodePassword(
				(String) SettingUtil.getSetting("ydjuser.password", null),
				entity.getDlm()));
		entity.setYhzt(1);
		 sysYhService.save(entity);
		 return ResponseData.SUCCESS_NO_DATA;
		 
	}
	
	/** 
	 * 修改更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(SysYhxx entity, String yhbh) {
		sysYhService.update(entity, yhbh);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/** 
	 * 删除
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(String yhbh){
		sysYhService.delete(yhbh);
	return ResponseData.SUCCESS_NO_DATA;
	}
	
	/** 
	 * 系统用户信息导出
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		sysYhService.exportExcel(request,response,code);
	}
	
	@RequestMapping(value = "/exportydj")
	public void exportydj(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		sysYhService.exportydj(request,response,code);
	}
	
	/** 
	 * 系统用户信息导入
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年11月11日 上午10:19:22 
	 * 方法说明 
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String upload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = sysYhService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
 
}
