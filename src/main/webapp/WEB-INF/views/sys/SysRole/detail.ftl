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
 <#if sysRole?exists>
 <div class="box1" id="formContent" whiteBg="true">
	<table class="tableStyle" formMode="view">
		<@com.warning/>
		<@form.errors path="*" cssClass="errorblock" element="div"/>
		 	
	 		<tr>
		    	<td>角色名称</td>
		    	<td>${(sysRole.jsmc)!}</td>
		 	
		    	<td>描述</td>
		    	<td>${(sysRole.bz)!}</td>
		 	<#assign enableds={'1':'有效','0':'无效'}>
	 		</tr>
		    <tr>
		    	<td>是否生效</td>
		    	<td>${enableds[''+sysRole.jszt]!}</td>
			<td></td><td></td>
	 		</tr>
		 </table>
	</div>
	<IFRAME id="documentFrame" name="documentFrame" src='${base}/sys/SysUser/jsUserlist?searchRoleId=${(sysRole.jsbh)!}&&start=0&&limit=10'
	 style="float:left;scrolling:auto;allowTransparency:true;border:0px;margin-left:0px;height:380px;width:740px;"frameBorder=0 scrolling="yes">
	</IFRAME>
 <#else>
	<font color="red">记录不存在</font>
</#if>
</#escape>
</@com.page>
