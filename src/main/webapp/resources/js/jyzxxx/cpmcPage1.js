		var num=1;
		
		function getValueFys(){
			num--;
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			var cplx=$("#cplx").val();
			var cpbh=$("#cpbh").val();
			var cpmc=$("#cpmc").val();
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getCpmclist',
	            data: {start: start, limit: size, size: count, cplx: cplx, cpbh: cpbh, cpmc: cpmc},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	creatTable(data);			        
			        if(data.length > 0){
			        	creatDiv(start,data,size);
			        }
	            }
		   });
		}
		
		function getValueFyx(){
			num++;
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			var cplx=$("#cplx").val();
			var cpbh=$("#cpbh").val();
			var cpmc=$("#cpmc").val();
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getCpmclist',
	            data: {start: start, limit: size, size: count, cplx: cplx, cpbh: cpbh, cpmc: cpmc},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	creatTable(data);
			        if(data.length > 0){
			        	creatDiv(start,data,size);
			        }
	            }
		   });
		}
		
		function creatDiv(obj,data,size){
			var del1 = $("#Div5");
			del1.remove();
			var html="";
			if(obj==0){
	        	if(size < data[0].count){
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+1+" 到 "+size+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
	        	}else{
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+1+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
	        	}
			}else{
				if(size < data[0].count){
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+(obj+1)+" 到 "+size+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
				}else{
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+(obj+1)+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
				}
			}
			if(num > 1){
				html=html+"<a href='javascript:;' onclick='getValueFys()' class='paginate_disabled_previous'>上一页</a>";
			}else{
				html=html+"上一页";
			}
			if(num < data[0].pages){
				html=html+"<a href='javascript:;' onclick='getValueFyx()' class='paginate_enabled_next' style='margin-left: 14px;'>下一页</a>";
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
		
//		页面刚进来时执行的方法，动态分别加载表格
		window.onload = function(){
			num=1;
			var size=$('#size').val();
			var count=parseInt($('#size').val());
			var cplx=$("#cplx").val();
			var cpbh=$("#cpbh").val();
			var cpmc=$("#cpmc").val();
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getCpmclist',
	            data: {start: 0, limit: size,size: count, cplx: cplx, cpbh: cpbh, cpmc: cpmc},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	creatTable(data);
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
		
		function toView(cpbh,cplx){
			location.href="jyyjView?cplx="+cplx+"&cpbh="+cpbh;
		}
		
		function creatTable(data){
			var del = $("#table");
		    del.remove();
		    var str = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'>" 
			    		+"<thead><tr>"
		    	        +"<td class='hidden-phone' bgcolor='#32a9eb'><b>序号</B></td>" 
		                +"<td class='hidden-phone' bgcolor='#63c3f5'><b>科室名称</B></td>"
		                +"<td class='hidden-phone' bgcolor='#3ab6f6'><b>产品编号</B></td>"
		                +"<td class='hidden-phone' bgcolor='#119ee6'><b>产品名称</B></td>"
		                +"<td class='hidden-phone' bgcolor='#32a9eb'><b>产品类型</B></td>"
		                +"<td class='hidden-phone' bgcolor='#63c3f5'><b>操作</td></B>";
		   		str=str+"</tr></thead><tbody>";
		   	for(var i = 0; i < data.length; i++){
		   			str=str+"<td class='center hidden-phone' style='color:red;'>"+(i+1)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].KSBH)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].CPBH)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].CPMC)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].CPLX)+"</td>"
			   			   +"<td class='center hidden-phone'><a href='javascript:;' onclick='toView(\""+data[i].CPBH+"\",\""+data[i].CPLX+"\")' class='paginate_disabled_previous'>查询检验依据</a></td>";;
			   		str=str+"</tr>";
			}
		   	str=str+"</tbody></table>";
	        var oTest = document.getElementById("Div6");
	        var newNode = document.createElement("table");
	        newNode.setAttribute('class', 'display table table-bordered');
	        newNode.setAttribute('id', 'table');
	        newNode.innerHTML = str;
	        oTest.insertBefore(newNode, null);
		}
		
		function insert_flg(str,flg,sn){
		    var newstr="";
		    var tmp=str.substring(0, sn);
		    var tmps=str.substring(sn, str.length);
		    newstr=tmp+flg+tmps;
		    return newstr;
		}
		