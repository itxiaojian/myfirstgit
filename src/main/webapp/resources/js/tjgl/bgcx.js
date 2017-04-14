		var num=1;
		
		function divld() {
			/*两div联动的关键所在*/
			document.getElementById("Div7").scrollLeft=document.getElementById("Div6").scrollLeft;
		}
		
		function getValueFys(){
			num--;
			var strs=[];
			var values=[];
			var vals="";
			$('#multiselect_to option').each(function(){
				 this.selected=true;
				 strs.push(this.text);
				 vals=vals+this.value+",";
				 values.push(this.value);
			});
			if(vals==null|vals==''){
				alert("请选择需要显示的字段！");
				return false;
			}
			cxtj="";
			$('#xsmc option').each(function(){
				 cxtj=cxtj+this.value;
			});
//			var cxtj=$('#cxtj').val();
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			$("#bh").remove();
			$("#bd").remove();
			$("#Div5").remove();
			var oTest = document.getElementById("Div6");
	        var newNode = document.createElement("div");
	        newNode.setAttribute('id', 'load');
	        newNode.innerHTML = '<img style="text-align: center;margin-left: 30%;" src="'+path+'/system/layout/skin/loading.gif" />';
	        oTest.insertBefore(newNode, null);
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgcxList',
	            data: {start: start, limit: size, cs: vals,cxtj: cxtj,size: count},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	creatTable(strs,data,values);			        
			        if(data.length > 0){
			        	creatDiv(start,data,size);
			        }
	            }
		   });
		}
		
		function getValueFyx(){
			num++;
			var strs=[];
			var values=[];
			var vals="";
			$('#multiselect_to option').each(function(){
				 this.selected=true;
				 strs.push(this.text);
				 vals=vals+this.value+",";
				 values.push(this.value);
			});
			if(vals==null|vals==''){
				alert("请选择需要显示的字段！");
				return false;
			}
			cxtj="";
			$('#xsmc option').each(function(){
				 cxtj=cxtj+this.value;
			});
//			var cxtj=$('#cxtj').val();
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			$("#bh").remove();
			$("#bd").remove();
			$("#Div5").remove();
			var oTest = document.getElementById("Div6");
	        var newNode = document.createElement("div");
	        newNode.setAttribute('id', 'load');
	        newNode.innerHTML = '<img style="text-align: center;margin-left: 30%;" src="'+path+'/system/layout/skin/loading.gif" />';
	        oTest.insertBefore(newNode, null);
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgcxList',
	            data: {start: start, limit: size, cs: vals,cxtj: cxtj,size: count},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	creatTable(strs,data,values);
			        if(data.length > 0){
			        	creatDiv(start,data,size);
			        }
	            }
		   });
		}
		
		function creatDiv(obj,data,size){
			$("#Div5").remove();
			var html="";
			if(obj==0){
	        	if(size < data[0].count){
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>显示第 "+1+" 到 "+size+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>";
	        	}else{
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>显示第 "+1+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>";
	        	}
			}else{
				if(size < data[0].count){
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>显示第 "+(obj+1)+" 到 "+size+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>";
				}else{
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>显示第 "+(obj+1)+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-bottom: 0px; padding-top: 0px;'>";
				}
			}
			if(num > 1){
				html=html+"<a href='javascript:;' onclick='getValueFys()' class='paginate_disabled_previous'>上一页</a>";
			}else{
				html=html+"上一页";
			}
			if(num < data[0].pages){
				html=html+"<a href='javascript:;' onclick='getValueFyx()' class='paginate_enabled_next'>下一页</a>";
			}else{
				html=html+"下一页";
			}
			html=html+"</div>";
			var oTest1 = document.getElementById("Div4");
			var newNode1 = document.createElement("div");
			newNode1.setAttribute('class', 'Div5');
			newNode1.setAttribute('id', 'Div5');
			newNode1.innerHTML = html;
			oTest1.insertBefore(newNode1, null);
		}
		
		function getValue(){
//			if($('#cxtj').val()==null||$('#cxtj').val()==''){
//				alert("请添加查询条件进行查询！");
//				return false;
//			}
			num=1;
			var strs=[];
			var values=[];
			var vals="";
			$('#multiselect_to option').each(function(){
				 this.selected=true;
				 strs.push(this.text);
				 vals=vals+this.value+",";
//				 alert(vals);
				 values.push(this.value);
			});
			if(vals==null|vals==''){
				alert("请选择需要显示的字段！");
				return false;
			}
			cxtj="";
			$('#xsmc option').each(function(){
				 cxtj=cxtj+this.value;
			});
//			var cxtj=$('#cxtj').val();
			var size=$('#size').val();
			var count=parseInt($('#size').val());
//			$('#table').html('<img src="loading.gif" />');//按键后先显示图片
			$("#bh").remove();
			$("#bd").remove();
			$("#Div5").remove();
			var oTest = document.getElementById("Div6");
	        var newNode = document.createElement("div");
	        newNode.setAttribute('id', 'load');
	        newNode.innerHTML = '<img style="text-align: center;margin-left: 30%;" src="'+path+'/system/layout/skin/loading.gif" />';
	        oTest.insertBefore(newNode, null);
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgcxList',
	            data: {start: 0, limit: size, cs: vals,cxtj: cxtj,size: count},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	creatTable(strs,data,values);
			        if(data.length > 0){
			        	creatDiv(0,data,size);
			        }
	            }
		   });
		}
		
		function isNull(string){
			if(string==null||string=='null'){
				return '';
			}else{
				return string
			}
		}
		
		function creatTable(strs,data,values){
			$("#bh").remove();
			$("#bd").remove();
			$("#load").remove();
//		    creatThead(strs);
		    var html = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'><thead><tr>"
         		+ "<td id='a' class='hidden-phone'style='width: 80px;'>查看报告</th><th id='zt' class='hidden-phone'style='width: 53px;'>报告状态</td>";
		   	for(var i=0;i<strs.length ;i++){
		   		if(strs[i].indexOf("（") > 0){
		   			html=html+"<td class='hidden-phone' id='w"+i+"'>"+strs[i].substring(0,strs[i].indexOf("（"))+"</td>";
		   		}else{
		   			if(strs[i]=='报告编号'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='样品名称'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='完成期限'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='分配时间'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='报审时间'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='报批时间'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else  if(strs[i]=='批准时间'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='接收时间'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='归档时间'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='检验类型'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='规格型号'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='样品状态'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='样品数量'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='委托单位'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='受检单位'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='生产单位'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='手机号码'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='检验依据'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='检验项目'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='缴费日期'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='到样日期'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='检验科室'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='业务科室'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='登记类型'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='抽样单位'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='抽样人员'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='抽样基数'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='抽样日期'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='检验结论'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='受检单位地址'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='邮编'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='检验日期'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else if(strs[i]=='生产单位地址'){
		   				html=html+"<td class='hidden-phone' id='w"+i+"' style='width:110px' >"+strs[i]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
		   			}else{
		   				html=html+"<td class='hidden-phone' id='w"+i+"'>"+strs[i]+"</td>";
		   			}
		   		}
		   	}
   	        html=html+"</tr></thead>";
			html=html+"</table>";
			var oTest1 = document.getElementById("Div7");
			var newNode1 = document.createElement("table");
			newNode1.setAttribute('class', 'display table-bordered');
			newNode1.setAttribute('id', 'bh');
			newNode1.innerHTML = html;
			oTest1.insertBefore(newNode1, null);
			
		    var str = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'><tbody>";
		   	if(data.length==0){
		   		str=str+"<tr class='gradeX'><td colspan='20' style='color:red;'>无符合条件的数据！</td></tr>"
		   	}else{
		   	for(var i = 0; i < data.length; i++){
		   	//起始日期，<span style="background-color: rgb(204, 204, 204);"><span style="color:#FF0000;"><strong>/pattern/是正则表达式的界定符，pattern是要匹配的内容，只用于第一个符号的匹配，g为全局匹配标志</strong></span></span>  
		   	if(data[i].YPZT1 < 4 || data[i].YPZT1==8){
		   		var beginDate = new Date($("#dqsj").val().replace(/-/g, "/"));  
		   		//结束日期  
//		   	alert(data[i].WCQX1);
		   		if(data[i].WCQX1!= null){
		   			var endDate = new Date(data[i].WCQX1.replace(/-/g, "/")); 
		   			//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24.  
		   			var workDayVal = (endDate - beginDate)/86400000 + 1;  
		   			//工时的余数  
		   			var remainder = workDayVal % 7; 
		   			//工时向下取整的除数  
		   			var divisor = Math.floor(workDayVal / 7);  
		   			var weekendDay = 2 * divisor;  
		   			
		   			//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
		   			var nextDay = beginDate.getDay();  
		   			//从起始日期的星期开始 遍历remainder天  
		   			for(var tempDay = remainder; tempDay>=1; tempDay--) {  
		   				//第一天不用加1  
		   				if(tempDay == remainder) {  
		   					nextDay = nextDay + 0;  
		   				} else if(tempDay != remainder) {  
		   					nextDay = nextDay + 1;  
		   				}  
		   				//周日，变更为0  
		   				if(nextDay == 7) {  
		   					nextDay = 0;  
		   				}  
		   				//周六日  
		   				if(nextDay == 0 || nextDay == 6) {  
		   					weekendDay = weekendDay + 1;  
		   				}  
		   			}  
		   			//实际工时（天） = 起止日期差 - 周六日数目。  
//		   	workDayVal = workDayVal - weekendDay; 
//              alert(workDayVal - weekendDay);		   	    
		   			if(data[i].WCQX1<$("#dqsj").val()){
		   				str=str+"<tr class='gradeY'>";
		   			}else if (workDayVal-1 <= 3 && workDayVal-1 >= 0){
		   				str=str+"<tr class='gradeZ'>";
		   			}else{
		   				str=str+"<tr class='gradeX'>";
		   			}
		   			str=str+"<td id='b' class='center hidden-phone' style='width: 80px;'><a href='javascript:;' onclick='toView(\""+data[i].WJMC+"\")' class='paginate_disabled_previous'>报告详情</a></td>";
		   			if(data[i].WCQX<$("#dqsj").val()){
		   				str=str+"<td class='gradeY' id='xq' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:red;border: 1px solid red;'>过期</button></td>";
		   			}else if (workDayVal-1 <= 3 && workDayVal-1 >= 0){
		   				str=str+"<td id='xq' class='gradeZ' style='width: 53px;'><button type='button' class='btn3'>即将过期</button></td>";
		   			}else{
		   				str=str+"<td id='xq' class='gradeX' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   			}
		   		}else{
		   			str=str+"<tr id='xq' class='gradeX' style='width: 53px;'>";
		   			str=str+"<td id='b' class='center hidden-phone' style='width: 80px;'><a href='javascript:;' onclick='toView(\""+data[i].WJMC+"\")' class='paginate_disabled_previous'>报告详情</a></td>";
		   			str=str+"<td id='xq' class='gradeX' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}
		   	}else if(data[i].YPZT1 > 3 && data[i].YPZT1 != 8){
		   		//起始日期，<span style="background-color: rgb(204, 204, 204);"><span style="color:#FF0000;"><strong>/pattern/是正则表达式的界定符，pattern是要匹配的内容，只用于第一个符号的匹配，g为全局匹配标志</strong></span></span>  
			   	var beginDate1 = new Date(data[i].PZSJ1.replace(/-/g, "/"));  
			   	 //结束日期  
//			   	alert(data[i].WCQX1);
			   	if(data[i].WCQX1!= null){
			   		var endDate1 = new Date(data[i].WCQX1.replace(/-/g, "/")); 
//			   		alert(beginDate1);
//			   		alert(endDate1);
			   		//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24.  
			   		var workDayVal1 = (endDate1 - beginDate1)/86400000 + 1;  
			   		//工时的余数  
			   		var remainder1 = workDayVal1 % 7; 
			   		//工时向下取整的除数  
			   		var divisor1 = Math.floor(workDayVal1 / 7);  
			   		var weekendDay1 = 2 * divisor1;  
			   		
			   		//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
			   		var nextDay1 = beginDate1.getDay();  
			   		//从起始日期的星期开始 遍历remainder天  
			   		for(var tempDay1 = remainder1; tempDay1>=1; tempDay1--) {  
			   			//第一天不用加1  
			   			if(tempDay1 == remainder1) {  
			   				nextDay1 = nextDay1 + 0;  
			   			} else if(tempDay1 != remainder1) {  
			   				nextDay1 = nextDay1 + 1;  
			   			}  
			   			//周日，变更为0  
			   			if(nextDay1 == 7) {  
			   				nextDay1 = 0;  
			   			}  
			   			//周六日  
			   			if(nextDay1 == 0 || nextDay1 == 6) {  
			   				weekendDay1 = weekendDay1 + 1;  
			   			}  
			   		}  
			   		//实际工时（天） = 起止日期差 - 周六日数目。  
//			         workDayVal1 = workDayVal1 - weekendDay1; 
			         workDayVal1 = workDayVal1 - 1;
//			         alert(workDayVal1);
//			         alert(weekendDay1);
//			         alert(workDayVal1 - weekendDay1);
//	              alert(workDayVal - weekendDay);		   	    
			         if(workDayVal1<0){
			   			str=str+"<tr class='gradeY'>";
			   		}else if (workDayVal1 <= 3 && workDayVal1 >= 0){
			   			str=str+"<tr class='gradeX'>";
			   		}else{
			   			str=str+"<tr class='gradeX'>";
			   		}
			         str=str+"<td id='b' class='center hidden-phone' style='width:80px;'><a href='javascript:;' onclick='toView(\""+data[i].WJMC+"\")' class='paginate_disabled_previous'>报告详情</a></td>";
			   		if(workDayVal1<0){
			   			str=str+"<td id='xq' class='gradeY' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:red;border: 1px solid red;'>过期</button></td>";
			   		}else if (workDayVal1 <= 3 && workDayVal1 >= 0){
			   			str=str+"<td id='xq' class='gradeX' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
			   		}else{
			   			str=str+"<td id='xq' class='gradeX' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
			   		}
			   	}else{
			   		str=str+"<tr class='gradeX' style='width: 53px;'>";
			   		str=str+"<td id='b' class='center hidden-phone' style='width: 80px;'><a href='javascript:;' onclick='toView(\""+data[i].WJMC+"\")' class='paginate_disabled_previous'>报告详情</a></td>";
			   		str=str+"<td id='xq' class='gradeX' style='width: 53px;'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
			   	}
		   	}
		   		for(var j=0;j<values.length ;j++){
		   			if(values[j]=='YPMC'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPMC+"'>"+isNull(data[i].YPMC)+"</td>";
		   			}
		   			if(values[j]=='YPBH'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPBH+"'>"+isNull(data[i].YPBH)+"</td>";
		   			}
		   			if(values[j]=='YPJYZT'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPJYZT+"'>"+isNull(data[i].YPJYZT)+"</td>";
		   			}
		   			if(values[j]=='WCQX'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].WCQX+"'>"+isNull(data[i].WCQX)+"</td>";
		   			}
		   			if(values[j]=='QSR'){
		   				if(data[i].YPZT1 >= 0 && data[i].YPZT1 != 8){
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].QSR+"'>"+isNull(data[i].QSR)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='BZR'){
		   				if(data[i].YPZT1 >= 1 && data[i].YPZT1 != 8){
		   						str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].BZR+"'>"+isNull(data[i].BZR)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='SHR'){
		   				if(data[i].YPZT1 >= 2 && data[i].YPZT1 != 8 && data[i].YPZT1 != 7){
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SHR+"'>"+isNull(data[i].SHR)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='PZR'){
		   				if(data[i].YPZT1 >= 3 && data[i].YPZT1 != 8 && data[i].YPZT1 != 7){
		   						str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].PZR+"'>"+isNull(data[i].PZR)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='JYLX'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYLX+"'>"+isNull(data[i].JYLX)+"</td>";
		   			}
		   			if(values[j]=='FPSJ'){
		   				if(data[i].YPZT1 > 0 && data[i].YPZT1 != 8){
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].FPSJ+"'>"+isNull(data[i].FPSJ)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='BSSJ'){
		   				if(data[i].YPZT1 > 1 && data[i].YPZT1 != 8 && data[i].YPZT1 != 7){
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].BSSJ+"'>"+isNull(data[i].BSSJ)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='BPSJ'){
			   			if(data[i].YPZT1 >= 3 && data[i].YPZT1 != 8 && data[i].YPZT1 != 7){
			   				str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].BPSJ+"'>"+isNull(data[i].BPSJ)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='PZSJ'){
		   				if(data[i].YPZT1 >= 4 && data[i].YPZT1 != 8 && data[i].YPZT1 != 7){
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].PZSJ+"'>"+isNull(data[i].PZSJ)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='JSSJ'){
		   				if(data[i].YPZT1 > 4 && data[i].YPZT1 != 8 && data[i].YPZT1 != 7){
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JSSJ+"'>"+isNull(data[i].JSSJ)+"</td>";
		   				}else{
		   					str=str+"<td id='h"+j+i+"' class='center hidden-phone'></td>";
		   				}
		   			}
		   			if(values[j]=='GDSJ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].GDSJ+"'>"+isNull(data[i].GDSJ)+"</td>";
		   			}
		   			if(values[j]=='GGXH'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].GGXH+"'>"+isNull(data[i].GGXH)+"</td>";
		   			}
		   			if(values[j]=='SCRQPC'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SCRQPC+"'>"+isNull(data[i].SCRQPC)+"</td>";
		   			}
		   			if(values[j]=='YPZT'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPZT+"'>"+isNull(data[i].YPZT)+"</td>";
		   			}
		   			if(values[j]=='YPSL'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPSL+"'>"+isNull(data[i].YPSL)+"</td>";
		   			}
		   			if(values[j]=='WTDW'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].WTDW+"'>"+isNull(data[i].WTDW)+"</td>";
		   			}
		   			if(values[j]=='WTDWDZ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].WTDWDZ+"'>"+isNull(data[i].WTDWDZ)+"</td>";
		   			}
		   			if(values[j]=='JYJL'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYJL+"'>"+isNull(data[i].JYJL)+"</td>";
		   			}
		   			if(values[j]=='SJDW'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SJDW+"'>"+isNull(data[i].SJDW)+"</td>";
		   			}
		   			if(values[j]=='SJDWDZ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SJDWDZ+"'>"+isNull(data[i].SJDWDZ)+"</td>";
		   			}
		   			if(values[j]=='LXR'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].LXR+"'>"+isNull(data[i].LXR)+"</td>";
		   			}
		   			if(values[j]=='DH'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].DH+"'>"+isNull(data[i].DH)+"</td>";
		   			}
		   			if(values[j]=='YB'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YB+"'>"+isNull(data[i].YB)+"</td>";
		   			}
		   			if(values[j]=='SCDW'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SCDW+"'>"+isNull(data[i].SCDW)+"</td>";
		   			}
		   			if(values[j]=='SCDWDZ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SCDWDZ+"'>"+isNull(data[i].SCDWDZ)+"</td>";
		   			}
		   			if(values[j]=='SCDWLXR'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SCDWLXR+"'>"+isNull(data[i].SCDWLXR)+"</td>";
		   			}
		   			if(values[j]=='SCDWDH'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SCDWDH+"'>"+isNull(data[i].SCDWDH)+"</td>";
		   			}
		   			if(values[j]=='WTLXR'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].WTLXR+"'>"+isNull(data[i].WTLXR)+"</td>";
		   			}
		   			if(values[j]=='SJHM'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SJHM+"'>"+isNull(data[i].SJHM)+"</td>";
		   			}
		   			if(values[j]=='JYYJ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYYJ+"'>"+isNull(data[i].JYYJ)+"</td>";
		   			}
		   			if(values[j]=='JYXM'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYXM+"'>"+isNull(data[i].JYXM)+"</td>";
		   			}
		   			if(values[j]=='JYFY'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYFY+"'>"+isNull(data[i].JYFY)+"</td>";
		   			}
		   			if(values[j]=='YSFJE'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YSFJE+"'>"+isNull(data[i].YSFJE)+"</td>";
		   			}
		   			if(values[j]=='JYJSRQ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYJSRQ+"'>"+isNull(data[i].JYJSRQ)+"</td>";
		   			}
		   			if(values[j]=='DYRQ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].DYRQ+"'>"+isNull(data[i].DYRQ)+"</td>";
		   			}
		   			if(values[j]=='JYKS'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYKS+"'>"+isNull(data[i].JYKS)+"</td>";
		   			}
		   			if(values[j]=='YWKS'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YWKS+"'>"+isNull(data[i].YWKS)+"</td>";
		   			}
		   			if(values[j]=='DJRY'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].DJRY+"'>"+isNull(data[i].DJRY)+"</td>";
		   			}
		   			if(values[j]=='DJSJ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].DJSJ+"'>"+isNull(data[i].DJSJ)+"</td>";
		   			}
		   			if(values[j]=='DJLX'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].DJLX+"'>"+isNull(data[i].DJLX)+"</td>";
		   			}
		   			if(values[j]=='CYDW'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].CYDW+"'>"+isNull(data[i].CYDW)+"</td>";
		   			}
		   			if(values[j]=='CYJS'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].CYJS+"'>"+isNull(data[i].CYJS)+"</td>";
		   			}
		   			if(values[j]=='CYRQ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].CYRQ+"'>"+isNull(data[i].CYRQ)+"</td>";
		   			}
		   			if(values[j]=='CYRY'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].CYRY+"' >"+isNull(data[i].CYRY)+"</td>";
		   			}
		   			if(values[j]=='YPLX'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPLX+"'>"+isNull(data[i].YPLX)+"</td>";
		   			}
		   			if(values[j]=='LYFS'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].LYFS+"'>"+isNull(data[i].LYFS)+"</td>";
		   			}
		   			if(values[j]=='FFRQ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].FFRQ+"'>"+isNull(data[i].FFRQ)+"</td>";
		   			}
		   			if(values[j]=='SZCS'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SZCS+"'>"+isNull(data[i].SZCS)+"</td>";
		   			}
		   			if(values[j]=='FFZT'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].FFZT+"'>"+isNull(data[i].FFZT)+"</td>";
		   			}
		   			if(values[j]=='TJRQ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].TJRQ+"'>"+isNull(data[i].TJRQ)+"</td>";
		   			}
		   			if(values[j]=='TJYY'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].TJYY+"'>"+isNull(data[i].TJYY)+"</td>";
		   			}
		   			if(values[j]=='YPDJ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].YPDJ+"'>"+isNull(data[i].YPDJ)+"</td>";
		   			}
		   			if(values[j]=='TJR'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].TJR+"'>"+isNull(data[i].TJR)+"</td>";
		   			}
		   			if(values[j]=='CYDD'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].CYDD+"'>"+isNull(data[i].CYDD)+"</td>";
		   			}
		   			if(values[j]=='BZFS'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].BZFS+"'>"+isNull(data[i].BZFS)+"</td>";
		   			}
		   			if(values[j]=='BZ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].BZ+"'>"+isNull(data[i].BZ)+"</td>";
		   			}
		   			if(values[j]=='SB'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SB+"'>"+isNull(data[i].SB)+"</td>";
		   			}
		   			if(values[j]=='JYRQ'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].JYRQ+"'>"+isNull(data[i].JYRQ)+"</td>";
		   			}
		   			if(values[j]=='SJDWGDDH'){
			   			str=str+"<td id='h"+j+i+"' class='center hidden-phone' title='"+data[i].SJDWGDDH+"'>"+isNull(data[i].SJDWGDDH)+"</td>";
		   			}
		   		}
		   		str=str+"</tr>";
		   	}
		   	}
		   	str=str+"</tbody></table>";
	        var oTest = document.getElementById("Div6");
	        var newNode = document.createElement("table");
	        newNode.setAttribute('class', 'display table-bordered');
	        newNode.setAttribute('id', 'bd');
	        newNode.innerHTML = str;
	        oTest.insertBefore(newNode, null);
	        
	        for(var s=0;s<strs.length ;s++){
	        	$("#b").css("width",$("#a").css("width"));
	        	$("#xq").css("width",$("#zt").css("width"));
	        	$("#h"+s+"0").css("width",$("#w"+s+"").css("width"));
	        	$("#w"+s+"").css("width",$("#h"+s+"0").css("width"));
//	        	console.log("表头宽度是=="+"w"+s+"===="+document.getElementById("w"+s+"").style.width);
//	        	console.log("表体宽度是=="+"h"+s+"0===="+document.getElementById("h"+s+"0").clientWidth+"px");
	        }
	        /*将两表width和max-width属性都按屏幕宽度设置成一样，以确保两表联动时一致*/
			document.getElementById("bh").style.cssText=document.getElementById("bh").style.cssText + "width:" + window.screen.availWidth.toString() + "px";
			document.getElementById("bd").style.cssText=document.getElementById("bd").style.cssText + "width:" + window.screen.availWidth.toString() + "px";
			/*将装表头内容的div宽度设置成装表内容的div宽度-纵向滑动条宽度即div的clientWidth*/
			document.getElementById("Div7").style.width=document.getElementById("Div6").clientWidth+"px";//jsp文件需要减去17px滚动条款度
		}
		
		function showQj(value){
			var del = $("#Div3");
			del.remove();
			var xzzd=$('#xzzd').val();
			if(value=='between'){
			    var str="";
			    if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='JYJSRQ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
				    str="<label>起始：</label><input name='qjq' id='qjq' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>"
				    		+ "<label style='margin-left: 4%;'>截止：</label><input name='qjz' id='qjz' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
					var oTest = document.getElementById("Div2");
			        var newNode = document.createElement("div");
			        newNode.setAttribute('id', 'Div3');
			        newNode.innerHTML = str;
			        oTest.insertBefore(newNode, null);
			    }else{
			    	alert("该字段不支持区间查询！");
			    	return false;
			    }
			}else if(value=='='){
				var str="";
				var xzzd=$('#xzzd').val();
				if(xzzd=='JYKS'){
						str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
					for(var i=0;i<ksidList.length;i++){
						str=str+"<option value='"+ksidList[i]+"'>"+bmmcList[i]+"</option>";
					}
					str=str+"</select>";
				}else if(xzzd=='YWKS'){
					str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
					for(var i=0;i<ywksidList.length;i++){
						str=str+"<option value='"+ywksidList[i]+"'>"+ywbmmcList[i]+"</option>";
					}
					str=str+"</select>";
				}else if(xzzd=='SFJS'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>已解锁</option><option value='0'>未解锁</option></select>";
			    }else if(xzzd=='FFZT'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>已发放</option><option value='0'>未发放</option></select>";
			    }else if(xzzd=='DYZT'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>已打印</option><option value='0'>未打印</option></select>";
			    }else if(xzzd=='JYFYDD'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>不待定</option><option value='0'>待定</option></select>";
			    }else if(xzzd=='DJLX'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='0'>一般样品登记</option><option value='1'>工程类样品登记</option><option value='2'>食药局类样品登记</option></select>";
			    }else if(xzzd=='YPYJ'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>已移交</option><option value='0'>未移交</option></select>";
			    }else if(xzzd=='YJZT'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>已移交</option><option value='0'>未移交</option></select>";
			    }else if(xzzd=='YWBY'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>有</option><option value='0'>无</option></select>";
			    }else if(xzzd=='SFWCKCP'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>是</option><option value='0'>否</option></select>";
			    }else if(xzzd=='LYFS'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>快递</option><option value='0'>直送</option></select>";
			    }else if(xzzd=='BGFSFS'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<bgfsfszdzList.length;i++){
						str=str+"<option value='"+bgfsfszdzList[i]+"'>"+bgfsfszdmcList[i]+"</option>";
					}
					str=str+"</select>";
			    }
//			    else if(xzzd=='BZR'){
//					str="<label>关键字：</label>" +
//					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
//					"<option value=''>请选择...</option>";
//					for(var i=0;i<bzridList.length;i++){
//						str=str+"<option value='"+bzridList[i]+"'>"+bzrxmList[i]+"</option>";
//					}
//					str=str+"</select>";
//			    }
			    else if(xzzd=='YPJYZT'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<ypjyztzdzList.length;i++){
						str=str+"<option value='"+ypjyztzdzList[i]+"'>"+ypjyztzdmcList[i]+"</option>";
					}
					str=str+"</select>";
			    }else if(xzzd=='JYLX'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<jylxList.length;i++){
						str=str+"<option value='"+jylxList[i]+"'>"+jylxList[i]+"</option>";
					}
					str=str+"</select>";
			    }else if(xzzd=='JYJSRQ'||xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='JYJSRQ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'||xzzd=='QSSJ'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||xzzd=='JSSJ'||xzzd=='GDSJ'){
			    	$('#xztj').val('=');
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
				}else{
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
				}
				var oTest = document.getElementById("Div2");
		        var newNode = document.createElement("div");
		        newNode.setAttribute('id', 'Div3');
		        newNode.innerHTML = str;
		        oTest.insertBefore(newNode, null);
			}else if(value=='>'||value=='<'||value=='>='||value=='<='||value=='like'||value=='not like'){
				var str="";
				var xzzd=$('#xzzd').val();
				if(xzzd=='JYKS'||xzzd=='YWKS'||xzzd=='SFJS'||xzzd=='FFZT'||xzzd=='DYZT'||xzzd=='JYFYDD'||xzzd=='DJLX'||xzzd=='YPYJ'||xzzd=='YWBY'||xzzd=='SFWCKCP'||xzzd=='LYFS'||xzzd=='BGFSFS'||xzzd=='YPJYZT'||xzzd=='JYLX'){
					alert("该属性请选择等于条件！");
			    	return false;
				}else if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='JYJSRQ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'||xzzd=='QSSJ'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||xzzd=='JSSJ'||xzzd=='GDSJ'){
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
				}else{
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
				}
				var oTest = document.getElementById("Div2");
		        var newNode = document.createElement("div");
		        newNode.setAttribute('id', 'Div3');
		        newNode.innerHTML = str;
		        oTest.insertBefore(newNode, null);
			}else{
				var str="";
				if(xzzd=='JYJSRQ'||xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='JYJSRQ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'||xzzd=='QSSJ'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||xzzd=='JSSJ'||xzzd=='GDSJ'){
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
				}else{
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
				}
				var oTest = document.getElementById("Div2");
		        var newNode = document.createElement("div");
		        newNode.setAttribute('id', 'Div3');
		        newNode.innerHTML = str;
		        oTest.insertBefore(newNode, null);
			}
		}
		
		function showTj(value){
			var del = $("#Div3");
			del.remove();
			var xztj=$('#xztj').val();
			if(xztj!=null&&xztj!=''){
				if(xztj=='between'){
					var str="";
					if(value=='JYJSRQ'||value=='FFRQ'||value=='TJRQ'||value=='BGBZRQ'||value=='BGDYSJ'||value=='JYJSRQ'||value=='CYRQ'||value=='DJSJ'||value=='DYRQ'||value=='LYRQ'||value=='WCQX'||value=='DJRQ'||value=='XGSJ' ||value=='QSSJ'||value=='FPSJ'||value=='BSSJ'||value=='BPSJ'||value=='PZSJ'||value=='JSSJ'||value=='GDSJ'){
						str="<label>起始：</label><input name='qjq' id='qjq' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>"
							+ "<label style='margin-left: 4%;'>截止：</label><input name='qjz' id='qjz' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
						var oTest = document.getElementById("Div2");
						var newNode = document.createElement("div");
						newNode.setAttribute('id', 'Div3');
						newNode.innerHTML = str;
						oTest.insertBefore(newNode, null);
					}else{
						alert("该字段不支持区间查询！");
						return false;
					}
				}else{
					var str="";
					if(value=='JYJSRQ'||value=='FFRQ'||value=='TJRQ'||value=='BGBZRQ'||value=='BGDYSJ'||value=='JYJSRQ'||value=='CYRQ'||value=='DJSJ'||value=='DYRQ'||value=='LYRQ'||value=='WCQX'||value=='DJRQ'||value=='XGSJ' ||value=='QSSJ'||value=='FPSJ'||value=='BSSJ'||value=='BPSJ'||value=='PZSJ'||value=='JSSJ'||value=='GDSJ'){
						$('#xztj').val('=');
						str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
					}else if(value=='JYKS'){
						    $('#xztj').val('=');
							str="<label>关键字：</label>" +
							"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
							"<option value=''>请选择...</option>";
						for(var i=0;i<ksidList.length;i++){
							str=str+"<option value='"+ksidList[i]+"'>"+bmmcList[i]+"</option>";
						}
						str=str+"</select>";
					}else if(value=='YWKS'){
						    $('#xztj').val('=');
							str="<label>关键字：</label>" +
								"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
								"<option value=''>请选择...</option>";
							for(var i=0;i<ywksidList.length;i++){
								str=str+"<option value='"+ywksidList[i]+"'>"+ywbmmcList[i]+"</option>";
							}
							str=str+"</select>";
					}
//					else if(value=='BZR'){
//					    $('#xztj').val('=');
//						str="<label>关键字：</label>" +
//							"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
//							"<option value=''>请选择...</option>";
//						for(var i=0;i<bzridList.length;i++){
//							str=str+"<option value='"+bzridList[i]+"'>"+bzrxmList[i]+"</option>";
//						}
//						str=str+"</select>";
//				   }
					else if(value=='SFJS'){
						$('#xztj').val('=');
						str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>已解锁</option><option value='0'>未解锁</option></select>";
				    }else if(value=='FFZT'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>已发放</option><option value='0'>未发放</option></select>";
				    }else if(value=='DYZT'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>已打印</option><option value='0'>未打印</option></select>";
				    }else if(value=='JYFYDD'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>不待定</option><option value='0'>待定</option></select>";
				    }else if(value=='DJLX'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='0'>一般样品登记</option><option value='1'>工程类样品登记</option><option value='2'>食药局类样品登记</option></select>";
				    }else if(value=='YPYJ'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>已移交</option><option value='0'>未移交</option></select>";
				    }else if(value=='YJZT'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>已移交</option><option value='0'>未移交</option></select>";
				    }else if(value=='YWBY'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>有</option><option value='0'>无</option></select>";
				    }else if(value=='SFWCKCP'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>是</option><option value='0'>否</option></select>";
				    }else if(value=='LYFS'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>快递</option><option value='0'>直送</option></select>";
				    }else if(value=='BGFSFS'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<bgfsfszdzList.length;i++){
							str=str+"<option value='"+bgfsfszdzList[i]+"'>"+bgfsfszdmcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else if(value=='YPJYZT'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<ypjyztzdzList.length;i++){
							str=str+"<option value='"+ypjyztzdzList[i]+"'>"+ypjyztzdmcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else if(value=='JYLX'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<jylxList.length;i++){
							str=str+"<option value='"+jylxList[i]+"'>"+jylxList[i]+"</option>";
						}
						str=str+"</select>";
				    }else{
				    	$('#xztj').val('like');
						str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
					}
//					var str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
					var oTest = document.getElementById("Div2");
					var newNode = document.createElement("div");
					newNode.setAttribute('id', 'Div3');
					newNode.innerHTML = str;
					oTest.insertBefore(newNode, null);
				}
			}
		}
		
		var xmlHttp= null;
	    //判断浏览器
	    function createXMLHttpRequest() {
	        if (window.XMLHttpRequest) {
	            //Firefox,Netscape,Chrome,Safari等浏览器
	            xmlHttp = new XMLHttpRequest();
	        } else if (window.ActiveXObject) { //IE浏览器
	            try {
	                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //创建xmlHttp对象
	            } catch (e) {
	                try {
	                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //创建xmlHttp对象
	                } catch (e) { }
	            }
	        }
	    }
		
		function toView(wjmc){
			//location.href=path+'/tjgl/bgcx/bgxxView?bgbh='+wjmc;
			var fileUrl = path+"/resources/doc/"+wjmc+".doc";
            createXMLHttpRequest();
            xmlHttp.open("GET",fileUrl,true);
            xmlHttp.send(null);
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                    	window.open(path+'/tjgl/bgcx/bgxxView?bgbh='+wjmc,"报告详情");
                    }else {
                        alert("报告还未编制！");
                    }
                }
            }
		}
		
		function doEmpty(){
//			$('#cxtj').val('');
//			$('#xsmc').val('');
//			$('#xztj').val('');
//			$('#xzzd').val('');
//			$('#qjq').val('');
//			$('#qjz').val('');
//			$('#gjz').val('');
			var objSelect=document.getElementById("xsmc");
			   objSelect.options.length=0;
		}
		
		function deleteOption(type){
			var objSelect=document.getElementById("xsmc");
			    if (type == true)
			       objSelect.options[objSelect.selectedIndex] = null;
			    else
			       objSelect.remove(objSelect.selectedIndex);
			}
		
		function insert_flg(str,flg,sn){
		    var newstr="";
		    var tmp=str.substring(0, sn);
		    var tmps=str.substring(sn, str.length);
		    newstr=tmp+flg+tmps;
		    return newstr;
		}
		
		function addTj(){
			var cxtj=$('#cxtj').val();
			var xsmc=$('#xsmc').val();
			var xztj=$('#xztj').val();
			var xzzd=$('#xzzd').val();
			var xzlb=$("input[name='xzlb']:checked").val();
			if(xzzd==null||xzzd==''){
				alert("字段为必选项！");
				return false;
			}
			if(xztj==null||xztj==''){
				alert("条件为必选项！");
				return false;
			}
			if(cxtj!=null&&cxtj!=''){
				if(xzlb=='or'){
					cxtj=insert_flg(cxtj,"(",4)+") ";
				}
			}
			var qjq="";
			var qjz="";
			var gjz="";
			if(xztj=='between'){
				qjq=$('#qjq').val();
				qjz=$('#qjz').val();
				if(qjq==null||qjq==''||qjz==null||qjz==''){
					alert("起始和截止条件为必填项！");
					return false;
				}else{
					xsmc=xsmc+" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" 在 "+$("#xztj").find("option:selected").text()+" "+qjq+" 到 "+qjz;
					if(xzlb=='or'){
						if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='JYJSRQ'){
							cxtj=cxtj+" "+xzlb+" (to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+qjq+"'and '"+qjz+"')";
						}else if(xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
							cxtj=cxtj+" "+xzlb+" (to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+qjq+"'and '"+qjz+"')";
						}
					}else{
						if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='JYJSRQ'){
						cxtj=cxtj+" "+xzlb+" to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+qjq+"' and '"+qjz+"'";
						}else if(xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
							cxtj=cxtj+" "+xzlb+" (to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+qjq+"'and '"+qjz+"')";
						}
					}
				}
			}else{
				gjz=$('#gjz').val();
				if(gjz==null||gjz==''){
					alert("关键字为必填项！");
					return false;
				}else{
					if(xzzd=='YJZT'||xzzd=='JYLX'||xzzd=='LYFS'||xzzd=='BGFSFS'||xzzd=='YHXTK'||xzzd=='JYFYDD'||xzzd=='YPJYZT'||xzzd=='DJLX'||xzzd=='YPYJ'||xzzd=='YWBY'||xzzd=='ZSLX'||xzzd=='SFWCKCP'||xzzd=='JYKS'||xzzd=='YWKS'||xzzd=='FFZT'||xzzd=='DYZT'||xzzd=='SFJS'){
						xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" "+$("#xztj").find("option:selected").text()+" "+$("#gjz").find("option:selected").text();
					}else{
						xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" "+$("#xztj").find("option:selected").text()+" "+gjz;
					}
							if(xztj=='like'||xztj=='not like'){
								if(xzzd=='JYJSRQ'||xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||
										xzzd=='DJRQ'||xzzd=='XGSJ'||xzzd=='WCQX'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||xzzd=='JSSJ'||xzzd=='GDSJ'||
											xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='QSSJ'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||
											xzzd=='JSSJ'||xzzd=='GDSJ'||xzzd=='JYJSRQ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
									cxtj=" "+xzlb+" (to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '%"+gjz+"%')";
								}else{
								    cxtj=" "+xzlb+" (z."+xzzd+" "+xztj+" '%"+gjz+"%')";
								}
							}else{
								 if(xzzd=='JYJSRQ'||xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||
										xzzd=='DJRQ'||xzzd=='XGSJ'||xzzd=='WCQX'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||xzzd=='JSSJ'||xzzd=='GDSJ'||
											xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='QSSJ'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||
											xzzd=='JSSJ'||xzzd=='GDSJ'||xzzd=='JYJSRQ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
									 cxtj=" "+xzlb+" (to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
								 }else{
									 cxtj=" "+xzlb+" (z."+xzzd+" "+xztj+" '"+gjz+"')";
								 }
							}
					}
				}
//					if(xzzd=='YJZT'||xzzd=='JYLX'||xzzd=='LYFS'||xzzd=='BGFSFS'||xzzd=='YHXTK'||xzzd=='JYFYDD'||xzzd=='YPJYZT'||xzzd=='DJLX'||xzzd=='YPYJ'||xzzd=='YWBY'||xzzd=='ZSLX'||xzzd=='SFWCKCP'||xzzd=='JYKS'||xzzd=='YWKS'||xzzd=='FFZT'||xzzd=='DYZT'||xzzd=='SFJS'){
//						xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
//						+" "+$("#xztj").find("option:selected").text()+" "+$("#gjz").find("option:selected").text();
//					}else{
//						xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
//						+" "+$("#xztj").find("option:selected").text()+" "+gjz;
//					}
//					if(xzzd=='JYJSRQ'||xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'||xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='DJRQ'||xzzd=='XGSJ'||xzzd=='WCQX'||xzzd=='FPSJ'||xzzd=='BSSJ'||xzzd=='BPSJ'||xzzd=='PZSJ'||xzzd=='JSSJ'||xzzd=='GDSJ'){
//						if(xzlb=='or'){
//							if(xztj=='like'||xztj=='not like'){
//								if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'){
//									cxtj=" "+xzlb+" (to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='QSSJ'){
//									cxtj=" "+xzlb+" (to_char(qs.CLAIM_TIME_,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='FPSJ'){
//									cxtj=" "+xzlb+" (to_char(fp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BSSJ'){
//									cxtj=" "+xzlb+" (to_char(bs.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BPSJ'){
//									cxtj=" "+xzlb+" (to_char(bp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='PZSJ'){
//									cxtj=" "+xzlb+" (to_char(x.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JSSJ'){
//									cxtj=" "+xzlb+" (to_char(js.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='GDSJ'){
//									cxtj=" "+xzlb+" (to_char(gd.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JYJSRQ'){
//									cxtj=" "+xzlb+" (to_char(p."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
//									cxtj=" "+xzlb+" (to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}
//							}else{
//								if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'){
//									cxtj=" "+xzlb+" (to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='QSSJ'){
//									cxtj=" "+xzlb+" (to_char(qs.CLAIM_TIME_,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='FPSJ'){
//									cxtj=" "+xzlb+" (to_char(fp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BSSJ'){
//									cxtj=" "+xzlb+" (to_char(bs.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BPSJ'){
//									cxtj=" "+xzlb+" (to_char(bp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='PZSJ'){
//									cxtj=" "+xzlb+" (to_char(x.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JSSJ'){
//									cxtj=" "+xzlb+" (to_char(js.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='GDSJ'){
//									cxtj=" "+xzlb+" (to_char(gd.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JYJSRQ'){
//									cxtj=" "+xzlb+" (to_char(p."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
//									cxtj=" "+xzlb+" (to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}
//							}
//						}else{
//							if(xztj=='like'||xztj=='not like'){
//								if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'){
//								cxtj=" "+xzlb+" to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"'";
//								}else if(xzzd=='QSSJ'){
//									cxtj=" "+xzlb+" (to_char(qs.CLAIM_TIME_,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='FPSJ'){
//									cxtj=" "+xzlb+" (to_char(fp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BSSJ'){
//									cxtj=" "+xzlb+" (to_char(bs.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BPSJ'){
//									cxtj=" "+xzlb+" (to_char(bp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='PZSJ'){
//									cxtj=" "+xzlb+" (to_char(x.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JSSJ'){
//									cxtj=" "+xzlb+" (to_char(js.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='GDSJ'){
//									cxtj=" "+xzlb+" (to_char(gd.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JYJSRQ'){
//									cxtj=" "+xzlb+" (to_char(p."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
//									cxtj=" "+xzlb+" to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"'";
//								}
//							}else{
//								if(xzzd=='FFRQ'||xzzd=='TJRQ'||xzzd=='BGBZRQ'||xzzd=='BGDYSJ'){
//									cxtj=" "+xzlb+" to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"'";
//								}else if(xzzd=='QSSJ'){
//									cxtj=" "+xzlb+" (to_char(qs.CLAIM_TIME_,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='FPSJ'){
//									cxtj=" "+xzlb+" (to_char(fp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BSSJ'){
//									cxtj=" "+xzlb+" (to_char(bs.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='BPSJ'){
//									cxtj=" "+xzlb+" (to_char(bp.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='PZSJ'){
//									cxtj=" "+xzlb+" (to_char(x.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JSSJ'){
//									cxtj=" "+xzlb+" (to_char(js.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='GDSJ'){
//									cxtj=" "+xzlb+" (to_char(gd.shsj,'yyyy-MM-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='JYJSRQ'){
//									cxtj=" "+xzlb+" (to_char(p."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
//								}else if(xzzd=='CYRQ'||xzzd=='DJSJ'||xzzd=='DYRQ'||xzzd=='LYRQ'||xzzd=='WCQX'||xzzd=='DJRQ'||xzzd=='XGSJ'){
//									cxtj=" "+xzlb+" to_char(z."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"'";
//								}
//							}
//						}
//					}else{
//						if(xzlb=='or'){
//							if(xztj=='like'||xztj=='not like'){
//								if(xzzd=='JYRQ'||xzzd=='BGBH'||xzzd=='BGMC'||xzzd=='JSDW'||xzzd=='JSR'||xzzd=='FFZT'||xzzd=='TJYY'||xzzd=='TJR'||xzzd=='BZFS'||xzzd=='JYJL'||xzzd=='RZFS'||xzzd=='BSDX'||xzzd=='DYZT'||xzzd=='DYCS'||xzzd=='SFJS'||xzzd=='JYQKSM'){
//									cxtj=" "+xzlb+" (a."+xzzd+" "+xztj+" '%"+gjz+"%')";
//								}else{
//									if(xzzd=='SHR'){
//										cxtj=" "+xzlb+" (l.XGJDRY "+xztj+" '%"+gjz+"%')";
//									}else if(xzzd=='PZR'){
//										cxtj=" "+xzlb+" ((k.XGJDRY "+xztj+" '%"+gjz+"%') or (x.SHR "+xztj+" '%"+gjz+"%')) ";
//									}else if(xzzd=='QSR'){
//										cxtj=" "+xzlb+" (t.ASSIGNEE_ "+xztj+" '%"+gjz+"%')";
//									}else if(xzzd=='BZR'){
//										cxtj=" "+xzlb+" ((n.XGJDRY "+xztj+" '%"+gjz+"%') or (n1.SHR "+xztj+" '%"+gjz+"%'))";
//									}else if(xzzd=='YSFJE'){
//										cxtj=" "+xzlb+" (q.YSFJE "+xztj+" '%"+gjz+"%')";
//									}else{
//										cxtj=" "+xzlb+" (z."+xzzd+" "+xztj+" '%"+gjz+"%')";
//									}
//								}
//							}else{
//								if(xzzd=='JYRQ'||xzzd=='BGBH'||xzzd=='BGMC'||xzzd=='JSDW'||xzzd=='JSR'||xzzd=='FFZT'||xzzd=='TJYY'||xzzd=='TJR'||xzzd=='BZFS'||xzzd=='JYJL'||xzzd=='RZFS'||xzzd=='BSDX'||xzzd=='DYZT'||xzzd=='DYCS'||xzzd=='SFJS'||xzzd=='JYQKSM'){
//									cxtj=" "+xzlb+" (a."+xzzd+" "+xztj+" '"+gjz+"')";
//								}else{
//									if(xzzd=='SHR'){
//										cxtj=" "+xzlb+" (l.XGJDRY "+xztj+" '"+gjz+"')";
//									}else if(xzzd=='PZR'){
//										cxtj=" "+xzlb+"( (k.XGJDRY "+xztj+" '"+gjz+"') or (x.SHR "+xztj+" '"+gjz+"') )";
//									}else if(xzzd=='QSR'){
//										cxtj=" "+xzlb+" (t.ASSIGNEE_ "+xztj+" '"+gjz+"')";
//									}else if(xzzd=='BZR'){
//										cxtj=" "+xzlb+" ((n.XGJDRY "+xztj+" '"+gjz+"') or (n1.SHR "+xztj+" '"+gjz+"'))";
//									}else if(xzzd=='YSFJE'){
//										cxtj=" "+xzlb+" (q.YSFJE "+xztj+" '"+gjz+"')";
//									}else{
//									    cxtj=" "+xzlb+" (z."+xzzd+" "+xztj+" '"+gjz+"')";
//								}
//							}
//								}
//						}else{
//							if(xztj=='like'||xztj=='not like'){
//								if(xzzd=='JYRQ'||xzzd=='BGBH'||xzzd=='BGMC'||xzzd=='JSDW'||xzzd=='JSR'||xzzd=='FFZT'||xzzd=='TJYY'||xzzd=='TJR'||xzzd=='BZFS'||xzzd=='JYJL'||xzzd=='RZFS'||xzzd=='BSDX'||xzzd=='DYZT'||xzzd=='DYCS'||xzzd=='SFJS'||xzzd=='JYQKSM'){
//									cxtj=" "+xzlb+" a."+xzzd+" "+xztj+" '%"+gjz+"%'";
//								}else{
//									if(xzzd=='SHR'){
//										cxtj=" "+xzlb+" (l.XGJDRY "+xztj+" '%"+gjz+"%')";
//									}else if(xzzd=='PZR'){
//										cxtj=" "+xzlb+"( (k.XGJDRY "+xztj+" '%"+gjz+"%') or (x.SHR "+xztj+" '%"+gjz+"%')) ";
//									}else if(xzzd=='QSR'){
//										cxtj=" "+xzlb+" (t.ASSIGNEE_ "+xztj+" '%"+gjz+"%')";
//									}else if(xzzd=='BZR'){
//										cxtj=" "+xzlb+" ((n.XGJDRY "+xztj+" '%"+gjz+"%') or (n1.SHR "+xztj+" '%"+gjz+"%'))";
//									}else if(xzzd=='YSFJE'){
//										cxtj=" "+xzlb+" (q.YSFJE "+xztj+" '%"+gjz+"%')";
//									}else{
//									cxtj=" "+xzlb+" z."+xzzd+" "+xztj+" '%"+gjz+"%'";
//								}
//									}
//							}else{
//								if(xzzd=='JYRQ'||xzzd=='BGBH'||xzzd=='BGMC'||xzzd=='JSDW'||xzzd=='JSR'||xzzd=='FFZT'||xzzd=='TJYY'||xzzd=='TJR'||xzzd=='BZFS'||xzzd=='JYJL'||xzzd=='RZFS'||xzzd=='BSDX'||xzzd=='DYZT'||xzzd=='DYCS'||xzzd=='SFJS'||xzzd=='JYQKSM'){
//									cxtj=" "+xzlb+" a."+xzzd+" "+xztj+" '"+gjz+"'";
//								}else{
//									if(xzzd=='SHR'){
//										cxtj=" "+xzlb+" (l.XGJDRY "+xztj+" '"+gjz+"')";
//									}else if(xzzd=='PZR'){
//										cxtj=" "+xzlb+"( (k.XGJDRY "+xztj+" '"+gjz+"') or (x.SHR "+xztj+" '"+gjz+"')) ";
//									}else if(xzzd=='QSR'){
//										cxtj=" "+xzlb+" (t.ASSIGNEE_ "+xztj+" '"+gjz+"')";
//									}else if(xzzd=='BZR'){
//										cxtj=" "+xzlb+" ((n.XGJDRY "+xztj+" '"+gjz+"') or (n1.SHR "+xztj+" '"+gjz+"'))";
//									}else if(xzzd=='YSFJE'){
//										cxtj=" "+xzlb+" (q.YSFJE "+xztj+" '"+gjz+"')";
//									}else{
//									cxtj=" "+xzlb+" z."+xzzd+" "+xztj+" '"+gjz+"'";
//								}
//									}
//							}
//						}
//					}
//				}
//			}
			
			var sltObj = document.getElementById("xsmc"); //获取select对象
			var optionObj = document.createElement("option"); //创建option对象
			optionObj.value = cxtj;
			optionObj.innerHTML = xsmc+"<br/>";
			optionObj.selected = true;//默认选中
			sltObj.appendChild(optionObj);
			
			
			
//			$('#xsmc').val(xsmc);
//			$('#cxtj').val(cxtj);
		}
		
		function getExcelValue(){
//			if($('#cxtj').val()==null||$('#cxtj').val()==''){
//				alert("请先进行查询！");
//				return false;
//			}
			var strs=[];
			var values=[];
			var vals="";
			var bt="";
			$('#multiselect_to option').each(function(){
				 this.selected=true;
				 strs.push(this.text);
				 if(this.text.indexOf("（") > 0){
					bt=bt+(this.text.substring(0,this.text.indexOf("（")))+",";
			   	 }else{
			   		bt=bt+this.text+",";
			   	 }
				 vals=vals+this.value+",";
				 values.push(this.value);
			});
			if(vals==null|vals==''){
				alert("请选择需要显示的字段！");
				return false;
			}
			cxtj="";
			$('#xsmc option').each(function(){
				 cxtj=cxtj+this.value;
			});
//			var cxtj=$('#cxtj').val();
			
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getCount',
	            data: {cs: vals,cxtj: cxtj},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	if(data <= 65530){
	            		if(confirm("确定下载查询结果吗?")){
	            			var fileName = "报告信息";
	            			var url = "export?fileName="+fileName+"&cs="+vals+"&cxtj="+cxtj;
	            			url = encodeURI(url);
	            			url = encodeURI(url);
	            			window.open(url);
	            		}
	            	}else{
	            		alert("导出数据过多，请增加查询条件进行过滤。");
	            	}
	            }
		   });
		}
