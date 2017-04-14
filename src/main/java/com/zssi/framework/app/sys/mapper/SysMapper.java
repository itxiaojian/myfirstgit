package com.zssi.framework.app.sys.mapper;

import java.util.List;
import java.util.Map;

import com.likegene.framework.core.Pager;
import com.likegene.framework.core.query.QueryFilter;

/**
 * 
 * @author lxt
 * @since 2015年4月3日
 */
public interface SysMapper {
	List<Map<String, Object>> listAllRoleResources();
	
	Pager listAllUser(QueryFilter filter);
	
	Pager listJsUser(QueryFilter filter);
	
	List<Map<String, Object>> listUser(QueryFilter filter);

	Pager listAllRoleResources1(QueryFilter filter);
}
