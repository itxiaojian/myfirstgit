//-------------------------------------------------------------------------
// lxtgene@163.com
//-------------------------------------------------------------------------
package com.zssi.framework.app.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.Pager;
import com.likegene.framework.core.Result;
import com.likegene.framework.core.formvalidator.FormValidatorManager;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.likegene.framework.core.query.QueryFilter;
import com.zssi.framework.app.sys.bo.SysJsBO;
import com.zssi.framework.app.sys.bo.SysJscdBO;
import com.zssi.framework.app.sys.bo.SysYhjsBO;
import com.zssi.framework.app.sys.model.SysJs;

/**
 * 系统角色 Controller
 * 
 * @author lxt
 * @since 2014-11-04
 */
@Controller
@RequestMapping("/sys/SysRole")
public class SysRoleController extends BaseController {

	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(SysRoleController.class);

	@Autowired
	private SysJsBO sysJsBO;
	@Autowired
	private SysJscdBO sysJscdBO;
	@Autowired
	private SysYhjsBO sysYhjsBo;

	@Autowired
	private CacheManager cacheManager;

	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "/sys/SysRole/add";
	}

	/*@RequestMapping(value = "/detail")
	public String detail(String roleId, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysRole", sysRoleBO.get(roleId));
		return "/sys/SysRole/detail";
	}*/
	
	@RequestMapping(value = "/detail")
	public String detail(Integer roleId,String initUserIds,HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysRole", sysJsBO.get(roleId));
		request.setAttribute("initUserIds",
				sysYhjsBo.findUserRoleIds(roleId));
		return "/sys/SysRole/detail";
	}

	/*@RequestMapping(value = "/list")
	public String list(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		QueryFilter filter = new QueryFilter(request);
		Pager pager = sysRoleBO.getPager(filter);
		model.put("pager", pager);
		return "/sys/SysRole/list";
	}*/
	
	@RequestMapping(value = "/list")
	public String list(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
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
		Pager pager = sysJsBO.getPager1(filter);
		model.put("pager", pager);
		return "/sys/SysRole/list";
	}

	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model,
			@ModelAttribute("sysRole") SysRole entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysRoleConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysRole/add";
		}
		Result result = sysRoleBO.save(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysRole/add";
		}
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model,
			@ModelAttribute("sysRole") SysJs entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysJsConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysRole/add";
		}
		Result result = sysJsBO.save(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysRole/add";
		}
		return "/common/success";
	}

	/*@RequestMapping(value = "/delete")
	public String delete(String[] ids) {
		for (String id : ids) {
			sysRoleBO.remove(id);
			sysRoleResourceBO.removeRoleResource(id);
			sysUserRoleBo.removeAllUserRole(id);
		}
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/delete")
	public String delete(String[] ids) {
		for (String id : ids) {
			sysJsBO.remove(Integer.parseInt(id));
			sysJscdBO.removeRoleResource(id);
			sysYhjsBo.removeAllUserRole(id);
		}
		return "/common/success";
	}
	
	@RequestMapping(value = "/delete1")
	public String delete1(String roleId) {
			sysJsBO.remove(Integer.parseInt(roleId));
			sysJscdBO.removeRoleResource(roleId);
			sysYhjsBo.removeAllUserRole(roleId);
		return "/common/success";
	}

	/*@RequestMapping(value = "/edit")
	public String edit(String roleId, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysRole", sysRoleBO.get(roleId));
		return "/sys/SysRole/edit";
	}*/
	
	@RequestMapping(value = "/edit")
	public String edit(Integer roleId, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysRole", sysJsBO.get(roleId));
		return "/sys/SysRole/edit";
	}

	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model,
			@ModelAttribute("sysRole") SysRole entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysRoleConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysRole/edit";
		}
		Result result = sysRoleBO.update(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysRole/edit";
		}

		return "/common/success";
	}*/
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model,
			@ModelAttribute("sysRole") SysJs entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysJsConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysRole/edit";
		}
		Result result = sysJsBO.update(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysRole/edit";
		}

		return "/common/success";
	}

	/*@RequestMapping(value = "/authorize")
	public String ConfigurePermissions(String roleId, String roleResourceIds,
			HttpServletRequest request, HttpServletResponse response) {
		roleResourceIds = this.sysRoleResourceBO.findRoleResourceIds(roleId);
		request.setAttribute("roleResourceIds", roleResourceIds);
		return "/sys/SysRole/authorize";
	}*/
	
	@RequestMapping(value = "/authorize")
	public String ConfigurePermissions(String roleId, String roleResourceIds,
			HttpServletRequest request, HttpServletResponse response) {
		roleResourceIds = this.sysJscdBO.findRoleResourceIds(roleId);
		request.setAttribute("roleResourceIds", roleResourceIds);
		return "/sys/SysRole/authorize";
	}

	/*@RequestMapping(value = "/submitResource", method = RequestMethod.POST)
	public String submitResource(ModelMap model, String roleId,
			String resourceIds, HttpServletRequest request,
			HttpServletResponse response) {
		Result result = this.sysRoleResourceBO.doSubmitResource(resourceIds,
				roleId);
		if ("" != result.getErrormsg()) {
			model.putAll(result);
			return "/sys/SysRole/authorize";
		}
		cacheManager.getCache("resources").evict("FilterInvoSecMetaKey");
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/submitResource", method = RequestMethod.POST)
	public String submitResource(ModelMap model, String roleId,
			String resourceIds, HttpServletRequest request,
			HttpServletResponse response) {
		Result result = this.sysJscdBO.doSubmitResource(resourceIds,
				roleId);
		if ("" != result.getErrormsg()) {
			model.putAll(result);
			return "/sys/SysRole/authorize";
		}
		cacheManager.getCache("resources").evict("FilterInvoSecMetaKey");
		return "/common/success";
	}

	/*@RequestMapping(value = "/authorizedUser")
	public String authorizedUser(String roleId, String initUserIds,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("sysRole", sysRoleBO.get(roleId));
		request.setAttribute("initUserIds",
				sysUserRoleBo.findUserRoleIds(roleId));
		return "/sys/SysRole/authorize_user";
	}*/
	
	@RequestMapping(value = "/authorizedUser")
	public String authorizedUser(Integer roleId, String initUserIds,
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("sysRole", sysJsBO.get(roleId));
		request.setAttribute("initUserIds",
				sysYhjsBo.findUserRoleIds(roleId));
		return "/sys/SysRole/authorize_user";
	}

	/*@RequestMapping(value = "/doAnthorize", method = RequestMethod.POST)
	public String doAnthorize(ModelMap model, String roleId, String userIds,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = this.sysUserRoleBo.doAnthorize(userIds, roleId);
		if ("" != result.getErrormsg()) {
			model.putAll(result);
			return "/sys/SysRole/authorize_user";
		}
		return "/common/success";
	}
	*/
	@RequestMapping(value = "/doAnthorize", method = RequestMethod.POST)
	public String doAnthorize(ModelMap model, String roleId, String userIds,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = this.sysYhjsBo.doAnthorize(userIds, roleId);
		if ("" != result.getErrormsg()) {
			model.putAll(result);
			return "/sys/SysRole/authorize_user";
		}
		return "/common/success";
	}

	/*@RequestMapping(value = "/closeAnthorize", method = RequestMethod.POST)
	public String closeAnthorize(ModelMap model, String roleId, String userIds,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = this.sysUserRoleBo.removeSysRoleResource(userIds,
				roleId);
		if ("" != result.getErrormsg()) {
			model.putAll(result);
			return "/sys/SysRole/authorize_user";
		}
		return "/common/success";
	}*/
	
	@RequestMapping(value = "/closeAnthorize", method = RequestMethod.POST)
	public String closeAnthorize(ModelMap model, String roleId, String userIds,
			HttpServletRequest request, HttpServletResponse response) {
		Result result = this.sysYhjsBo.removeSysRoleResource(userIds,
				roleId);
		if ("" != result.getErrormsg()) {
			model.putAll(result);
			return "/sys/SysRole/authorize_user";
		}
		return "/common/success";
	}

}
