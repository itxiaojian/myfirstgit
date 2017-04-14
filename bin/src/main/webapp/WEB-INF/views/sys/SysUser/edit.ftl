<#-----author:lxt------->
<#-----date:2014-11-19 17:16:17------->
<#assign sec=JspTaglibs["/WEB-INF/security.tld"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<@com.page>
<#escape x as x?html>  
<script type="text/javascript" src="${validateJS}/SysUser.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	top.title("编辑");
	$("#myFormId").validate(saveSysYhConfig,${(paramErrors?size)?default(0)});
});
</script>
 <#if sysUser?exists>
		<@form.form id="myFormId" action="${base}/sys/SysUser/update" method="post"   autocomplete="off">
		<@com.warning/>
		<@form.errors path="*" cssClass="errorblock" element="div"/>
		<input type="hidden" name="yhbh" value="${(sysUser.yhbh)!}"/>
		<div class="box1" id="formContent" whiteBg="true">
	     <table class="tableStyle" formMode="view">
	 		<tr>
		    	<td>用户名</td>
		    	<td><input type="text" name="xm" value="${(sysUser.xm)!}" class="textInput"/></td>
		    	<td>登录名</td>
		    	<td><input type="text" name="username" value="${(sysUser.username)!}" class="textInput readonly" keepDefaultStyle="true" readonly/></td>
	 		</tr>
	 		<tr>
		    	<td>部门</td>
		    	<td><input type="text" name="bmbh" value="${(sysUser.bmbh)!}" class="textInput"/></td>
		    	<td>岗位</td>
		    	<td><input type="text" name="gwbh" value="${(sysUser.gwbh)!}" class="textInput"/></td>
	 		</tr>
		    <tr>
		        <td>邮箱</td>
		    	<td><input type="text" name="yx" value="${(sysUser.yx)!}" class="textInput"/></td>
		    	<td>手机号</td>
		    	<td><input type="text" name="sjh" value="${(sysUser.sjh)!}" class="textInput"/></td>
	 		</tr>
		    <tr>
		        <td></td>
		    	<td></td>
		    	<td>状态</td>
		    	<td>					
		    	<select name="yhzt" val="${(sysUser.yhzt)!}">
						<option value="2" <#if sysUser ?? && sysUser.yhzt ?? && sysUser.yhzt ==2>selected</#if>>禁用</option>
						<option value="1" <#if sysUser ?? && sysUser.yhzt ?? && sysUser.yhzt ==1>selected</#if>>启用</option>
			    </select>
                </td>
	 		</tr>
		   
		 <tr>
			<td colspan="4">
				<input type="submit" value="提交"/>
				<input type="button" value="取消" onclick="top.Dialog.close()"/>
			</td>
		</tr>
		</table>
	</div>
	</@form.form>
 <#else>
	<font color="red">记录不存在</font>
</#if>
</#escape>
</@com.page>
