<#-----author:lxt------->
<#-----date:2014-11-19 17:16:17------->
<#assign sec=JspTaglibs["/WEB-INF/security.tld"]>
<@com.page>
<#escape x as x?html>  
<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="账号管理">
	<a href="${base}/sys/SysUser/list" target="content" onfocus="this.blur()"><span>账号管理</span></a>
	</li>
</ul>
</div>
	<form method="post" id="searchForm" action="${base}/sys/SysUser/list">
	<input type="hidden" id="startId" name="start" value="${(pager.start?default(0))!}"/>	
	<input type="hidden" id="limitId" name="limit" value="${(pager.pageSize)?default(0)}"/>
	<table>
		<tr>
		<td>用户名</td><td><input type="text" name="Q_xm_S_LK" value="${params['Q_xm_S_LK']!}" class="textinput"/></td>
		<td>登录名</td><td><input type="text" name="Q_username_S_LK" value="${params['Q_username_S_LK']!}" class="textinput"/></td>
		<td>部门</td><td><input type="text" name="Q_bmmc_S_LK" value="${params['Q_bmmc_S_LK']!}" class="textinput"/></td>
		<td>状态</td>
		<td>
			<select name="Q_yhzt_N_EQ" value="${params['Q_yhzt_N_EQ']!}">
				<option value="">---</option>
				<option value="2" <#if (params['Q_yhzt_N_EQ'])?if_exists =="2">selected</#if>>禁用</option>
				<option value="1" <#if (params['Q_yhzt_N_EQ'])?if_exists =="1">selected</#if>>启用</option>
			</select>
		</td>
		<td><input type="button" class="submitForm button" value="查询"/></td>
		<td><input type="button" class="clearForm button" value="清空"/></td>
		</tr>
	</table>
 	</form>
	<div class="box_tool_min">
	<div class="center">
 <#----- <a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/add'})"><span class="icon_add">新增</span></a>&nbsp;&nbsp;&nbsp; ------->
 <#----- <a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/detail',mutiple:false})"><span class="icon_view">查看</span></a> ------->
 <#----- <a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/edit',mutiple:false})"><span class="icon_edit">编辑</span></a> ------->
        <a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/resetPassword',confirm:true,mutiple:true})"><span class="icon_edit">批量重置密码</span></a> 
        <a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/delete',confirm:true,mutiple:true})"><span class="icon_delete">批量删除</span></a>  
	</div>
	</div> 
	<div id="scrollContent">
		<table class="tableStyle" mode="list" style="width:100%;">
			<thead>
				<tr>
				<th></th>
			  	<th class="hide">id</th>
			  	<th align="center" >用户名</th>
			  	<th align="center" >登录名</th>
			  	<th align="center" class="pk hide">密码</th>
			  	<th align="center" style="width: 150px;" >部门</th>
			  	<th align="center" >手机</th>
			  	<th align="center" >邮箱</th>
			  	<th align="center" >状态</th><#assign statuss={'2':'禁用','1':'启用','0':'已删除'}>
			  	<th align="center" >用户角色</th>
			  	<th style="width: 300px;" align="center" >操作</th>
				</tr>
			</thead>
			<#if (pager.items)?exists && ((pager.items)?size != 0)>
			<#list pager.items as entity>
			<tbody>
			<tr>
			<td><input type="checkbox" id="${(entity.yhbh)!}"/></td>
				<td class="pk hide" id="id" val="${(entity.yhbh)!}">${(entity.yhbh)!}</td>
				<td>${(entity.xm)!}</td>
				<td>${(entity.username)!}</td>
				<td class="hide">${(entity.password)!}</td>
				<td>${(entity.bmmc)!}</td>
				<td>${(entity.sjh)!}</td>
				<td>${(entity.yx)!}</td>
				<td align="center">${statuss[''+entity.yhzt]!}</td>
				<#--<td>${(entity.yhjs)!}</td>-->
				<#assign yhjs>${(entity.yhjs)!}</#assign>
				<td title="${(entity.yhjs)!}">
					<#if yhjs?length gt 6>
						${yhjs?substring(0,6)}...
						<#else>
						${(entity.yhjs)!}
					</#if>
				</td>

				<td align="center">
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/detail',mutiple:false,obj:'${(entity.yhbh)!}'})"><span>查看</span></a>&nbsp;&nbsp;
<#-----				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/edit',mutiple:false,obj:'${(entity.yhbh)!}'})"><span>编辑</span></a>&nbsp;&nbsp;&nbsp; ------->
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/resetPassword',confirm:true,mutiple:true,obj:'${(entity.yhbh)!}'})"><span>重置密码</span></a>&nbsp;&nbsp;
				<a href="javascript:;" onclick="onAction({url:'${base}/sys/SysUser/delete',confirm:true,mutiple:true,obj:'${(entity.yhbh)!}'})"><span>删除</span></a>
				</td>
			</tr>
		 	</#list>
		 	<#else>
		 		<tr><td><input type="checkbox"/></td><td colspan="10" class="nodata">无记录</td></tr>
		 	</#if>
		 	</tbody>
		</table>
	</div>
	<#if pager?exists>
		<@com.pagination pager=pager/>
	</#if>
</#escape>
</@com.page>
