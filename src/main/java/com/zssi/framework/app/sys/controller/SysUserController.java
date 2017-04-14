//-------------------------------------------------------------------------
// lxtgene@163.com
//-------------------------------------------------------------------------
package com.zssi.framework.app.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.Pager;
import com.likegene.framework.core.Result;
import com.likegene.framework.core.formvalidator.FormValidatorManager;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.likegene.framework.core.query.QueryFilter;
import com.zssi.framework.app.sys.bo.SysYhBO;
import com.zssi.framework.app.sys.bo.SysYhjsBO;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.sys.model.SysYhjs;
import com.zssi.framework.app.yhgl.service.SysYhService;

/**
 * 系统用户 Controller
 * 
 * @author lxt
 * @since 2014-11-04
 */
@Controller
@RequestMapping("/sys/SysUser")
public class SysUserController extends BaseController {

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(SysUserController.class);

	@Autowired
	private SysYhBO sysYhBO;
	@Autowired
	private SysYhjsBO sysYhjsBO;
	@Autowired
	private SysYhService yhService;
	
	
	
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("zzjg", sysYhBO.getBm());
		return "/sys/SysUser/add";
	}
	
	@RequestMapping(value = "/getGw")
	public String getGw(HttpServletRequest request, HttpServletResponse response) {
		String sjbh=request.getParameter("sjbh");
		Object obj = sysYhBO.getGw(sjbh);
		Gson gson = new Gson();
		writeJson(response,gson.toJson(obj));
		return null;
	}

	/*@RequestMapping(value = "/detail")
	public String detail(String id, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysUser", sysUserBO.get(id));
		return "/sys/SysUser/detail";
	}*/
	
	@RequestMapping(value = "/detail")
	public String detail(String id, HttpServletRequest request,
			HttpServletResponse response) {
		QueryFilter filter=new QueryFilter();
		filter.addFilter("Q_yhbh_S_EQ", id);
		request.setAttribute("sysUser", sysYhBO.listUser(filter).get(0));
		return "/sys/SysUser/detail";
	}

	/*@RequestMapping(value = "/list")
	public String list(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		QueryFilter filter = new QueryFilter(request);
		filter.addFilter("Q_id_S_NEQ", "1");
		Pager pager = sysUserBO.getPager(filter);
		model.put("pager", pager);
		return "/sys/SysUser/list";
	}*/
	
	/*@RequestMapping(value = "/list")
	public String list(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		QueryFilter filter = new QueryFilter(request);
		filter.addFilter("Q_yhbh_S_NEQ", "1");
		Pager pager = sysYhBO.getPager(filter);
		model.put("pager", pager);
		return "/sys/SysUser/list";
	}*/
	
	@RequestMapping(value = "/list")
	public String list(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		QueryFilter filter = new QueryFilter(request);
		filter.addFilter("Q_yhbh_N_NEQ", "2");
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		if(start==null){
			start="0";
		}
		if(limit==null){
			limit="10";
		}
		if("0".equals(start)){
			filter.addFilter("Q_start_N_EQ", Integer.parseInt(start));
			filter.addFilter("Q_limit_N_EQ", Integer.parseInt(limit));
		}else{
			filter.addFilter("Q_start_N_EQ", Integer.parseInt(start));
			filter.addFilter("Q_limit_N_EQ", Integer.parseInt(start)+Integer.parseInt(limit));
		}
		Pager pager = sysYhBO.listAllUser(filter);
		model.put("pager", pager);
		return "/sys/SysUser/list";
	}

	/*@RequestMapping(value = "/Userlist")
	public String Userlist(ModelMap model, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("searchRoleId") String searchRoleId) {
		request.setAttribute("searchRoleId", searchRoleId);
		QueryFilter filter = new QueryFilter(request);
		Pager pager = sysUserBO.getPager(filter);
		model.put("pager", pager);
		QueryFilter filter2 = new QueryFilter();
		filter2.addFilter("Q_roleId_S_EQ", searchRoleId);
		List<SysUserRole> sysUserRoles = sysUserRoleBO.getAll(filter2);
		List<String> userIds = new ArrayList<String>();
		if (sysUserRoles.size() > 0) {
			for (SysUserRole sysUserRole : sysUserRoles) {
				userIds.add(sysUserRole.getUserId());
			}
		}
		model.put("userIds", userIds);
		return "/sys/SysUser/user_list";
	}*/
	
	@RequestMapping(value = "/Userlist")
	public String Userlist(ModelMap model, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("searchRoleId") String searchRoleId) {
		request.setAttribute("searchRoleId", searchRoleId);
		QueryFilter filter = new QueryFilter(request);
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		if(start==null){
			start="0";
		}
		if(limit==null){
			limit="10";
		}
		if("0".equals(start)){
			filter.addFilter("Q_start_N_EQ", Integer.parseInt(start));
			filter.addFilter("Q_limit_N_EQ", Integer.parseInt(limit));
		}else{
			filter.addFilter("Q_start_N_EQ", Integer.parseInt(start));
			filter.addFilter("Q_limit_N_EQ", Integer.parseInt(start)+Integer.parseInt(limit));
		}
		Pager pager = sysYhBO.listAllUser(filter);
		model.put("pager", pager);
		QueryFilter filter2 = new QueryFilter();
		filter2.addFilter("Q_jsbh_N_EQ", searchRoleId);
		List<SysYhjs> sysUserRoles = sysYhjsBO.getAll(filter2);
		List<Integer> userIds = new ArrayList<Integer>();
		if (sysUserRoles.size() > 0) {
			for (SysYhjs sysUserRole : sysUserRoles) {
				userIds.add(sysUserRole.getYhbh());
			}
		}
		model.put("userIds", userIds);
		return "/sys/SysUser/user_list";
	}
	
	@RequestMapping(value = "/jsUserlist")
	public String aUserlist(ModelMap model, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("searchRoleId") String searchRoleId) {
		request.setAttribute("searchRoleId", searchRoleId);
		System.out.println(searchRoleId);
		QueryFilter filter = new QueryFilter(request);
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		String searchRoleId1=request.getParameter("searchRoleId");
		if(start==null){
			start="0";
		}
		if(limit==null){
			limit="10";
		}
		if("0".equals(start)){
			filter.addFilter("Q_start_N_EQ", Integer.parseInt(start));
			filter.addFilter("Q_limit_N_EQ", Integer.parseInt(limit));
			filter.addFilter("Q_jsbh_N_EQ", searchRoleId);
		}else{
			filter.addFilter("Q_start_N_EQ", Integer.parseInt(start));
			filter.addFilter("Q_limit_N_EQ", Integer.parseInt(start)+Integer.parseInt(limit));
			filter.addFilter("Q_jsbh_N_EQ", searchRoleId);
		}
		Pager pager = sysYhBO.listJsUser(filter);
		System.out.println(filter);
		model.put("pager", pager);
		QueryFilter filter2 = new QueryFilter();
		filter2.addFilter("Q_jsbh_N_EQ", searchRoleId);
		List<SysYhjs> sysUserRoles = sysYhjsBO.getAll(filter2);
		List<Integer> userIds = new ArrayList<Integer>();
		if (sysUserRoles.size() > 0) {
			for (SysYhjs sysUserRole : sysUserRoles) {
				userIds.add(sysUserRole.getYhbh());
			}
		}
		model.put("userIds", userIds);
		return "/sys/SysUser/user_list1";
	}

	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model,
			@ModelAttribute("sysUser") SysUser entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysUserConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysUser/add";
		}
		Result r = this.sysUserBO.findUserByusername(entity.getUsername());
		if (!"".equals(r.get("MSG"))) {
			model.putAll(r);
			return "/sys/SysUser/add";
		}
		Result result = sysUserBO.save(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysUser/add";
		}
		return "/common/success";
	}*/

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model,
			@ModelAttribute("sysUser") SysYh entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysYhConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysUser/add";
		}
		Result r = this.sysYhBO.findUserByusername(entity.getUsername());
		if (!"".equals(r.get("MSG"))) {
			model.putAll(r);
			return "/sys/SysUser/add";
		}
		entity.setGwbh("null");
		Result result = sysYhBO.save(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysUser/add";
		}
		return "/common/success";
	}
	
	/*@RequestMapping(value = "/delete")
	public String delete(String[] ids) {
		for (String id : ids) {
			sysUserBO.remove(id);
		}
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/delete")
	public String delete(String[] ids) {
		for (String id : ids) {
			sysYhBO.updateWxyh(id);
			sysYhBO.remove(Integer.parseInt(id));
		}
		return "/common/success";
	}

	/*@RequestMapping(value = "/resetPassword")
	public String resetPassword(String[] ids) {
		for (String id : ids) {
			sysUserBO.updateDefaultPassword(id);
		}
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/resetPassword")
	public String resetPassword(String[] ids) {
		for (String id : ids) {
			sysYhBO.updateDefaultPassword(id);
		}
		return "/common/success";
	}

	/*@RequestMapping(value = "/edit")
	public String edit(String id, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysUser", sysUserBO.get(id));
		return "/sys/SysUser/edit";
	}*/
	
	@RequestMapping(value = "/edit")
	public String edit(Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("zzjg", sysYhBO.getBm());
		request.setAttribute("sysUser", sysYhBO.get(id));
		return "/sys/SysUser/edit";
	}

	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model,
			@ModelAttribute("sysUser") SysUser entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysUserConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysUser/edit";
		}
		SysUser s = sysUserBO.get(entity.getId());
		entity.setUsername(s.getUsername());
		entity.setSysRoles(s.getSysRoles());
		Result result = sysUserBO.update(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysUser/edit";
		}
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model,
			@ModelAttribute("sysUser") SysYh entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysYhConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysUser/edit";
		}
		SysYh s = sysYhBO.get(entity.getYhbh());
		entity.setUsername(s.getUsername());
		entity.setSysJs(s.getSysJs());
		Result result = sysYhBO.update(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysUser/edit";
		}
		return "/common/success";
	}

	@RequestMapping(value = "/changePwd")
	public String changePwd(HttpServletRequest request,
			HttpServletResponse response) {
		return "/sys/SysUser/changePwd";
	}

	/*@RequestMapping(value = "/passwordChange")
	public String passwordChange(ModelMap model,
			@ModelAttribute("oldPwd") String oldPwd,
			@ModelAttribute("newPwd") String newPwd,
			@ModelAttribute("newPwd2") String newPwd2,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = sysUserBO.changePassword(oldPwd, newPwd, newPwd2);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysUser/changePwd";
		}
		request.setAttribute("errormsgs", "密码修改成功");
		return "/sys/SysUser/changePwd";
	}*/
	
	@RequestMapping(value = "/passwordChange")
	public String passwordChange(ModelMap model,
			@ModelAttribute("oldPwd") String oldPwd,
			@ModelAttribute("newPwd") String newPwd,
			@ModelAttribute("newPwd2") String newPwd2,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = sysYhBO.changePassword(oldPwd, newPwd, newPwd2);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysUser/changePwd";
		}
		request.setAttribute("errormsgs", "密码修改成功");
		return "/sys/SysUser/changePwd";
	}

}
