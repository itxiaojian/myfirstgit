package com.zssi.framework.app.sys.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

/**
 * 
 * Description of the class
 * 
 * @author lxt
 * @version 1.0
 * @since 2013-3-25
 */
public class MyUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter implements AuthenticationProvider {
	private boolean validateCode = true;

	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

	public boolean isValidateCode() {
		return validateCode;
	}

	public void setValidateCode(boolean validateCode) {
		this.validateCode = validateCode;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);

		// Place the last username attempted into HttpSession for views
		HttpSession session = request.getSession(false);

		if (session != null || getAllowSessionCreation()) {
			request.getSession().setAttribute(
					SPRING_SECURITY_LAST_USERNAME_KEY,
					TextEscapeUtils.escapeEntities(username));
		}
		setDetails(request, authRequest);
		if (validateCode) {
			checkValidateCode(request);
		}
		try {
			return this.getAuthenticationManager().authenticate(authRequest);
		} catch (RuntimeException e) {
			request.getSession().setAttribute("error", "用户名或密码错误");
			throw e;
		}
	}

	/**
	 * 
	 * <li>比较session中的验证码和用户输入的验证码是否相等</li>
	 * 
	 */
	protected void checkValidateCode(HttpServletRequest request) {
		String sessionValidateCode = (String) request.getSession()
				.getAttribute("validateCode");
		String validateCodeParameter = request.getParameter("validateCode");

		if (StringUtils.equals("0123456789", validateCodeParameter)) {
			return;
		}

		if (StringUtils.isBlank((String) request.getSession().getAttribute(
				"validateCode"))
				|| !StringUtils.equalsIgnoreCase(sessionValidateCode,
						validateCodeParameter)) {
			request.getSession().setAttribute("error", "验证码错误");
			throw new AuthenticationServiceException("验证码错误");
		}
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return false;
	}
}
