package com.zssi.framework.app.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.zssi.framework.app.sys.bo.SysLogBO;
import com.zssi.framework.app.sys.model.SysLog;

/**
 * 系统日志 Controller
 * 
 * @author lxt
 * @since 2014-11-20 09:40:56
 */
@Controller
@RequestMapping("/sys/SysLog")
public class SysLogController extends BaseController {

	protected final transient static Logger logger = LoggerFactory
			.getPresentationLog(SysLogController.class);

	@Autowired
	private SysLogBO sysLogBO;

	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "/sys/SysLog/add";
	}

	@RequestMapping(value = "/detail")
	public String detail(String id, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysLog", sysLogBO.get(id));
		return "/sys/SysLog/detail";
	}

	@RequestMapping(value = "/list")
	public String list(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		QueryFilter filter = new QueryFilter(request);
		filter.addSorted("operDate", "desc");
		Pager pager = sysLogBO.getPager(filter);
		model.put("pager", pager);
		return "/sys/SysLog/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model, @ModelAttribute("sysLog") SysLog entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysLogConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysLog/add";
		}
		Result result = sysLogBO.save(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysLog/add";
		}
		return "/common/success";
	}

	@RequestMapping(value = "/delete")
	public String delete(String[] ids) {
		for (String id : ids) {
			sysLogBO.remove(Integer.parseInt(id));
		}
		return "/common/success";
	}

	@RequestMapping(value = "/edit")
	public String edit(String id, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("sysLog", sysLogBO.get(id));
		return "/sys/SysLog/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model,
			@ModelAttribute("sysLog") SysLog entity,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> errors = FormValidatorManager.validate(
				"saveSysLogConfig", request);
		if (errors.size() != 0) {
			return "/sys/SysLog/edit";
		}
		Result result = sysLogBO.update(entity);
		if (!result.isSuccess()) {
			model.putAll(result);
			return "/sys/SysLog/edit";
		}
		return "/common/success";
	}
}
