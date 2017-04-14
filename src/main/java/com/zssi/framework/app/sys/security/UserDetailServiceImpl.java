// -------------------------------------------------------------------------
// lxtgene@163.com
// -------------------------------------------------------------------------

package com.zssi.framework.app.sys.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.likegene.framework.core.query.QueryFilter;
import com.zssi.framework.app.sys.bo.SysYhBO;
import com.zssi.framework.app.sys.model.SysJs;
import com.zssi.framework.app.sys.model.SysYh;

/**
 * 
 * @author lxt
 */

public class UserDetailServiceImpl implements UserDetailsService {
	private Logger log = Logger.getLogger(UserDetailServiceImpl.class);

	@Autowired
	private SysYhBO sysYhBO;

	@Autowired
	private DefaultInvocationSecurityMetadataSource metadataSource;

	/*public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		QueryFilter filter = new QueryFilter();
		filter.addFilter("Q_username_S_EQ", username);
		SysUser sysUser = sysUserBO.getUnique(filter);
		if (sysUser == null) {
			log.warn(username + " can not be found in users of system");
			throw new AuthenticationServiceException("用户名不正确!");
		}
		SysRole role = new SysRole();
		role.setRoleName("NONE");
		sysUser.getAuthorities().add(role);

		return sysUser;
	}*/
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		QueryFilter filter = new QueryFilter();
		filter.addFilter("Q_username_S_EQ", username);
		SysYh sysYh = sysYhBO.getUnique(filter);
		if (sysYh == null) {
			log.warn(username + " can not be found in users of system");
			throw new AuthenticationServiceException("用户名不正确!");
		}
		SysJs role = new SysJs();
		role.setJsmc("NONE");
		sysYh.getAuthorities().add(role);

		return sysYh;
	}
}
