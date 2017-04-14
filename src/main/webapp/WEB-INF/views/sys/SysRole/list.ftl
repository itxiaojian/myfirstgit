<#-----author:lxt------->
<#-----date:2014-11-19 17:16:17------->
<#assign sec=JspTaglibs["/WEB-INF/security.tld"]>
<@com.page>
<#escape x as x?html>  
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="角色管理">
	<a href="${base}/sys/SysRole/list" target="content" onfocus="this.blur()"><span>角色管理</span></a>
	</li>
</ul>
</div>
	<form method="post" id="searchForm" action="${base}/sys/SysRole/list">
	<input type="hidden" id="startId" name="start" value="${(pager.start?default(0))!}"/>	
	<input type="hidden" id="limitId" name="limit" value="${(pager.pageSize)?default(0)}"/>
	<table>
		<tr>
		<td>角色名称</td><td><input type="text" name="Q_jsmc_S_LK" value="${params['Q_jsmc_S_LK']!}" class="textinput"/></td>
		<td>描述</td><td><input type="text" name="Q_bz_S_LK" value="${params['Q_bz_S_LK']!}" class="textinput"/></td>
		<td>是否生效</td>
		<td>
			<select name="Q_jszt_N_EQ" value="${params['Q_jszt_N_EQ']!}">
				<option value="">---</option>
				<option value="1" <#if (params['Q_jszt_N_EQ'])?if_exists =="1">selected</#if>>有效</option>
				<option value="0" <#if (params['Q_jszt_N_EQ'])?if_exists =="0">selected</#if>>无效</option>
			</select>
		</td>
		<td><input type="button" class="submitForm button" value="查询"/></td>
		<td><input type="button" class="clearForm button" value="清空"/></td>
		</tr>
	</table>
 	</form>
	<div class="box_tool_min">
	<div class="center">
		<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/add'})"><span class="icon_add">新增</span></a>&nbsp;&nbsp;&nbsp;
<#-----		<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/detail',mutiple:false})"><span class="icon_view">查看</span></a> ------>
<#-----		<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/edit',mutiple:false})"><span class="icon_edit">编辑</span></a> ------>
		<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/delete',confirm:true,mutiple:true})"><span class="icon_delete">批量删除</span></a> 
<#-----		<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/authorize',mutiple:false})"><span class="icon_edit">权限配置</span></a> ------>
<#-----		<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/authorizedUser',mutiple:false})"><span class="icon_edit">用户授权</span></a> ------>
	</div>
	</div> 
	<div id="scrollContent">
		<table class="tableStyle" mode="list" style="width:80%;">
			<thead>
				<tr>
				<th></th>
			  	<th class="hide">role_id</th>
			  	<th align="center" >角色名称</th>
			  	<th align="center" >描述</th>
			  	<th align="center" >是否生效</th><#assign enableds={'1':'有效','0':'无效'}>
			  	<th align="center" >角色用户数</th>
				<th style="width: 300px;" align="center" >操作</th>
				</tr>
			</thead>
			<#if (pager.items)?exists && ((pager.items)?size != 0)>
			<#list pager.items as entity>
			<tbody>
			<tr>
			<td><input type="checkbox" id="${(entity.jsbh)!}"/></td>
				<td class="pk hide" id="roleId" val="${(entity.jsbh)!}">${(entity.jsbh)!}</td>
				<td>${(entity.jsmc)!}</td>
				<td>${(entity.bz)!}</td>
				<td align="center">${enableds[''+(entity.jszt)?default(0)]!}</td>
				<td align="center">${(entity.bjsxyhs)!}</td>
			    <td align="center">
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/detail',mutiple:false,obj:'${(entity.jsbh)!}'})"><span>查看</span></a>&nbsp;&nbsp;
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/edit',mutiple:false,obj:'${(entity.jsbh)!}'})"><span>编辑</span></a>&nbsp;&nbsp;
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/delete1',confirm:true,mutiple:false,obj:'${(entity.jsbh)!}'})"><span>删除</span></a>&nbsp;&nbsp;
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/authorize',mutiple:false,obj:'${(entity.jsbh)!}'})"><span>权限配置</span></a>&nbsp;&nbsp;
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysRole/authorizedUser',mutiple:false,obj:'${(entity.jsbh)!}'})"><span>用户授权</span></a>&nbsp;&nbsp;
				</td>
			</tr>
		 	</#list>
		 	<#else>
		 		<tr><td><input type="checkbox"/></td><td colspan="4" class="nodata">无记录</td></tr>
		 	</#if>
		 	</tbody>
		</table>
	</div>
	<#if pager?exists>
		<@com.pagination pager=pager/>
	</#if>
</#escape>
</@com.page>
