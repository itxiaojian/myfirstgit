<#-----author:lxt------->
<#-----date:2014-11-19 17:16:17------->
<#assign sec=JspTaglibs["/WEB-INF/security.tld"]>
<@com.page>
<#escape x as x?html>  
<script type="text/javascript">
$(document).ready(function(){

});

function getSelectId() {
    var ids = "";
    $("td input:checkbox:checked").each(function(){
       ids =ids +","+ $(this).parent().next().attr("val");
    })
    if(ids){
    	ids = ids.substring(1);
    }
    return ids;
}

function validateAnthorize(flag){
	 var names = "";
    $("td input:checkbox:checked").each(function(){
       var name =  $(this).parent().next().next().attr("val");
       var v = $(this).parent().parent().children().last().attr("val");
       if(flag=="1"){
       	 if(v=="已授权"){
       		names = names+","+name;
      	 }
       }else if(flag=="2"){
       	 if(v=="未授权"){
       		names = names+","+name;
      	 }
       }
       
    })
    if(names){
    	names = names.substring(1);
    }
    return names;
}


<!--初始化加载table选择勾选项-->

function anthorize(){
		if(validateAnthorize(1)){
			top.Dialog.alert("用户名为"+validateAnthorize(1)+"的用户已经拥有该权限，请取消勾选");
	    	return;
		}
		if(!getSelectId()){
		  top.Dialog.alert("请至少选择一条记录");
		  return;
		}
		$("#user_id").val(getSelectId());
		$("#role_id").val($("#search_role_id").val());
		$("#submitForm").submit();	
}

function closeAnthorize(){
		if(validateAnthorize(2)){
			top.Dialog.alert("用户名为"+validateAnthorize(2)+"的用户还没有该权限，请取消勾选");
	    	return;
		}
		
		if(!getSelectId()){
		  top.Dialog.alert("请至少选择一条记录");
		  return;
		}
		$("#qx_user_id").val(getSelectId());
		$("#qx_role_id").val($("#search_role_id").val());
		$("#closeAnthorizeForm").submit();	
}
</script>

<div style="display:none;">
<ul class="tab-menu tab" id="tabMenuID_">
	<li class="tab-selected" title="用户">
	<a href="${base}/sys/SysUser/list" target="content" onfocus="this.blur()"><span>用户</span></a>
	</li>
</ul>
</div style="height:380px;width:740px;">
	<form method="post" id="submitForm" action="${base}/sys/SysRole/doAnthorize">
		<input type="hidden" id="role_id" name="roleId" value=""/>
		<input type="hidden" id="user_id" name="userIds" value=""/>
	</form>
	<form method="post" id="closeAnthorizeForm" action="${base}/sys/SysRole/closeAnthorize">
		<input type="hidden" id="qx_role_id" name="roleId" value=""/>
		<input type="hidden" id="qx_user_id" name="userIds" value=""/>
	</form>
	<form method="post" id="searchForm" action="${base}/sys/SysUser/jsUserlist">
	<input type="hidden" id="startId" name="start" value="${(pager.start?default(0))!}"/>	
	<input type="hidden" id="limitId" name="limit" value="${(pager.pageSize)?default(0)}"/>
	<input type="hidden" id="search_role_id" name="searchRoleId" value="${(searchRoleId)!}"/>
 	</form>
	<div id="scrollContent">
		<table id="userListTable" class="tableStyle" mode="list" style="width:90%;">
			<thead>
				<tr>
				<th></th>
			  	<th class="hide">id</th>
			  	<th>用户名</th>
			  	<th>登录名</th>
			  	<th>部门</th>
			  	<th>手机</th>
			  	<th>邮箱</th>
			  	<th>状态</th><#assign statuss={'2':'禁用','1':'启用','0':'已删除'}>
			  	<th>是否授权</th>
				</tr>
			</thead>
			<#if (pager.items)?exists && ((pager.items)?size != 0)>
			<#list pager.items as entity>
			<tbody>
			<tr>
			<td><input type="checkbox"/></td>
				<td class="pk hide" id="id" val="${(entity.yhbh)!}">${(entity.yhbh)!}</td>
				<td val="${(entity.xm)!}">${(entity.xm)!}</td>
				<td>${(entity.username)!}</td>
				<td>${(entity.bmmc)!}</td>
				<td>${(entity.sjh)!}</td>
				<td>${(entity.yx)!}</td>
				<td>${statuss[''+entity.yhzt]!}</td>
				<td val="${userIds?seq_contains(entity.yhbh)?string("已授权", "未授权")}">${userIds?seq_contains(entity.yhbh)?string("已授权", "未授权")}</td> 
			</tr>
		 	</#list>
		 	<#else>
		 		<tr><td><input type="checkbox"/></td><td colspan="7" class="nodata">无记录</td></tr>
		 	</#if>
		 	</tbody>
		</table>
	</div>
	<div style="width:700px">
	<#if pager?exists>
		<@com.pagination pager=pager/>
	</#if>
	</div>
</#escape>
</@com.page>

