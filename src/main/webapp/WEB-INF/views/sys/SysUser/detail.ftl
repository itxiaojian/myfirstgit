<#-----author:lxt------->
<#-----date:2014-11-19 17:16:17------->
<#assign sec=JspTaglibs["/WEB-INF/security.tld"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<@com.page>
<#escape x as x?html>  
<script type="text/javascript">
$(document).ready(function(){
	top.title("详细");
});
</script>
 <#if sysUser?exists>
 <div class="box1" id="formContent" whiteBg="true">
	<table class="tableStyle" formMode="view">
		<@com.warning/>
		<@form.errors path="*" cssClass="errorblock" element="div"/>
		 	
	 		<tr>
		    	<td>用户名</td>
		    	<td>${(sysUser.xm)!}</td>
		    	<td>登录名</td>
		    	<td>${(sysUser.username)!}</td>
	 		</tr>
		    <tr>
		    	<td>邮箱</td>
		    	<td>${(sysUser.yx)!}</td>
		 		<td>手机号</td>
		    	<td>${(sysUser.sjh)!}</td>
	 		</tr>
	 		<tr>
		    	<td>部门</td>
		    	<td>${(sysUser.bmmc)!}</td>
		 	
		    	<#assign statuss={'2':'禁用','1':'启用','0':'已删除'}>
		    	<td>状态</td>
		    	<td>${statuss[''+sysUser.yhzt]!}</td>
	 		</tr>
	 		<tr>
	 		    <td>用户角色</td>
	 		    <td colspan="3">${(sysUser.yhjs)!}</td>
	 		</tr>
		 </table>
	</div>
 <#else>
	<font color="red">记录不存在</font>
</#if>
</#escape>
</@com.page>
