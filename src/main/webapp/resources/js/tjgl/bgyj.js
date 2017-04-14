		var num=1;
		
		function getValueFys(){
			num--;
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxxlist',
	            data: {start: start, limit: size,size: count},
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
		
		function getValueFys1(){
			num--;
			var start1=parseInt($('#size1').val())*num-parseInt($('#size1').val());
			var size1=parseInt($('#size1').val())*num;
			var count1=parseInt($('#size1').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxx1list',
	            data: {start1: start1, limit1: size1,size1: count1},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data1) {
	            	creatTable1(data1);			        
			        if(data1.length > 0){
			        	creatDiv1(start1,data1,size1);
			        }
	            }
		   });
		}
		
		function getValueFyx(){
			num++;
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxxlist',
	            data: {start: start, limit: size,size: count},
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
		
		function getValueFyx1(){
			num++;
			var start1=parseInt($('#size1').val())*num-parseInt($('#size1').val());
			var size1=parseInt($('#size1').val())*num;
			var count1=parseInt($('#size1').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxx1list',
	            data: {start1: start1, limit1: size1,size1: count1},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data1) {
	            	creatTable1(data1);
			        if(data1.length > 0){
			        	creatDiv1(start1,data1,size1);
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
		
		function creatDiv1(obj1,data1,size1){
			var del3 = $("#Div8");
			del3.remove();
			var html1="";
//			alert(data1[0].count);
//			alert(data1[0].count1);
			if(obj1==0){
	        	if(size1 < data1[0].count1){
	        		html1=html1+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+1+" 到 "+size1+"条 共 "+data1[0].count1+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
	        	}else{
	        		html1=html1+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+1+" 到 "+data1[0].count1+"条 共 "+data1[0].count1+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
	        	}
			}else{
				if(size1 < data1[0].count1){
					html1=html1+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+(obj1+1)+" 到 "+size1+"条 共 "+data1[0].count1+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
				}else{
					html1=html1+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>显示第 "+(obj1+1)+" 到 "+data1[0].count1+"条 共 "+data1[0].count1+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 0px; padding-bottom: 0px;'>";
				}
			}
			if(num > 1){
				html1=html1+"<a href='javascript:;' onclick='getValueFys1()' class='paginate_disabled_previous'>上一页</a>";
			}else{
				html1=html1+"上一页";
			}
			if(num < data1[0].pages1){
				html1=html1+"<a href='javascript:;' onclick='getValueFyx1()' class='paginate_enabled_next' style='margin-left: 14px;'>下一页</a>";
			}else{
				html1=html1+"下一页";
			}
			html1=html1+"</div>";
			var oTest3 = document.getElementById("Div7");
			var newNode3 = document.createElement("div");
			newNode3.setAttribute('class', 'Div8');
			newNode3.setAttribute('id', 'Div8');
			newNode3.innerHTML = html1;
			oTest3.insertBefore(newNode3, null);
		}
	
//		页面刚进来时执行的方法，动态分别加载表格
		window.onload = function(){
			num=1;
			var size=$('#size').val();
			var count=parseInt($('#size').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxxlist',
	            data: {start: 0, limit: size,size: count},
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
			
			var size1=$('#size1').val();
			var count1=parseInt($('#size1').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxx1list',
	            data: {start1: 0, limit1: size1,size1: count1},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data1) {
	            	creatTable1(data1);
			        if(data1.length > 0){
			        	creatDiv1(0,data1,size1);
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
		
		function toView(id,djlx,ypbh){
						window.open('<%=path%>/ypgl/YYpYpxx/ypxxOnLookView?id='+id+'&djlx='+djlx+'&ypbh='+ypbh+'&kobe='+8,"查看样品信息","height=600px, width=1000px,top=100px, left=200px, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
					}
		
		function creatTable(data){
			var del = $("#table");
		    del.remove();
		    var str = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'>" 
			    		+"<thead><tr>"
		    		    +"<td class='hidden-phone'>操作</td>" 
		    		    +"<td class='hidden-phone'style='width: 73px;'>状态</td>" 
		    	        +"<td class='hidden-phone'>报告编号</td>" 
		    	        +"<td class='hidden-phone'>样品名称</td>" 
		    	        +"<td class='hidden-phone'>样品登记日期</td>"
		                +"<td class='hidden-phone'>完成期限</td>" 
		                +"<td class='hidden-phone'>签收人</td>" 
		                +"<td class='hidden-phone'>主检人</td>"
		                +"<td class='hidden-phone'>审核人</td>" 
		                +"<td class='hidden-phone'>批准人</td>" 
		                +"<td class='hidden-phone'>报告状态</td>"
		                +"<td class='hidden-phone'>收费情况</td>" 
		                +"<td class='hidden-phone'>移交情况</td>";
		   		str=str+"</tr></thead><tbody>";
		   	for(var i = 0; i < data.length; i++){
		   		if(data[i].workDayVal-1<0){
		   			str=str+"<tr class='gradeY'>";
		   		}else if (data[i].workDayVal-1 <= 3 && data[i].workDayVal-1 >= 0){
		   			str=str+"<tr class='gradeZ'>";
		   		}else{
		   			str=str+"<tr class='gradeX'>";
		   		}
		   		str=str+"<td class='center hidden-phone'><a href='javascript:;' onclick='toView(\""+data[i].ID+"\",\""+data[i].DJLX+"\",\""+data[i].YPBH+"\")' class='paginate_disabled_previous'>查看</a></td>";
		   		if(data[i].workDayVal-1<0){
		   			str=str+"<td class='gradeY'><button type='button' class='btn3' style = 'background-color:red;border: 1px solid red;'>过期</button></td>";
		   		}else if (data[i].workDayVal-1 <= 3 && data[i].workDayVal-1 >= 0){
		   			str=str+"<td class='gradeZ'><button type='button' class='btn3'>即将过期</button></td>";
		   		}else{
		   			str=str+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}
			   			str=str+"<td class='center hidden-phone'>"+isNull(data[i].YPBH)+"</td>"
//			   			+"<td class='center hidden-phone'>"+isNull(data[i].workDayVal)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data[i].YPMC)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data[i].DJSJ)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data[i].WCQX)+"</td>";
			   			if(data[i].YPZT1 == 0 ){
				   			str=str+"<td class='center hidden-phone'>"+isNull(data[i].QSR)+"</td>"
						   			+"<td class='center hidden-phone'></td>"
						   			+"<td class='center hidden-phone'></td>"
						   			+"<td class='center hidden-phone'></td>";
				   		}else if(data[i].YPZT1 == 2 || data[i].YPZT1 == 1){
						   			str=str+"<td class='center hidden-phone'>"+isNull(data[i].QSR)+"</td>"
						   			+"<td class='center hidden-phone'>"+isNull(data[i].BZR)+"</td>"
						   			+"<td class='center hidden-phone'></td>"
						   			+"<td class='center hidden-phone'></td>";
				   		}else if(data[i].YPZT1 == 3){
						   			str=str+"<td class='center hidden-phone'>"+isNull(data[i].QSR)+"</td>"
						   			+"<td class='center hidden-phone'>"+isNull(data[i].BZR)+"</td>"
						   			+"<td class='center hidden-phone'>"+isNull(data[i].SHR)+"</td>"
						   			+"<td class='center hidden-phone'></td>";
				   		}else if(data[i].YPZT1 >= 4 && data[i].YPZT1 <= 7){
						   			str=str+"<td class='center hidden-phone'>"+isNull(data[i].QSR)+"</td>"
						   			+"<td class='center hidden-phone'>"+isNull(data[i].BZR)+"</td>"
						   			+"<td class='center hidden-phone'>"+isNull(data[i].SHR)+"</td>"
						   			+"<td class='center hidden-phone'>"+isNull(data[i].PZR)+"</td>";
					    }else if(data[i].YPZT1 == 8 ){
						   			str=str+"<td class='center hidden-phone'></td>"
						   			+"<td class='center hidden-phone'></td>"
						   			+"<td class='center hidden-phone'></td>"
						   			+"<td class='center hidden-phone'></td>";
					    }
			   			str=str+"<td class='center hidden-phone'>"+isNull(data[i].YPJYZT)+"</td>";
			   		    if(data[i].JYFY ==0){
			   				str=str+"<td class='center hidden-phone'>无费用</td>";
			   			}
			   			if(data[i].YSFJE==0 && data[i].JYFY !=0){
			   				str=str+"<td class='center hidden-phone'>待收费</td>";
			   			}
			   			if(data[i].JYFY >data[i].YSFJE && data[i].YSFJE != 0){
			   				str=str+"<td class='center hidden-phone'>收费中</td>";
			   			}
			   			if(data[i].JYFY ==data[i].YSFJE && data[i].YSFJE != 0){
			   				str=str+"<td class='center hidden-phone'>已收费</td>";
			   			}
			   			if(data[i].YPYJ == 0 || typeof data[i].YPYJ == "null"){
				   		    str=str+"<td class='center hidden-phone'>不移交</td>";
			   			}
			   			if(data[i].YPYJ ==1 && data[i].YJZT == 0){
			   				str=str+"<td class='center hidden-phone'>未移交</td>";
			   			}
			   			if(data[i].YPYJ ==1 && data[i].YJZT == 1){
			   				str=str+"<td class='center hidden-phone'>已移交</td>";
			   			}
			   		str=str+"</tr>";
			   		}
		   	str=str+"</tbody></table>";
	        var oTest = document.getElementById("Div6");
//	        var oldNode = document.getElementById("Div4");
	        var newNode = document.createElement("table");
	        newNode.setAttribute('class', 'display table table-bordered');
	        newNode.setAttribute('id', 'table');
	        newNode.innerHTML = str;
	        oTest.insertBefore(newNode, null);
		}
		
		function creatTable1(data1){
			var del2 = $("#table1");
		    del2.remove();
		    var str1 = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'>" 
			    		+"<thead><tr>"
		    		    +"<td class='hidden-phone'>操作</td>" 
		    		    +"<td class='hidden-phone'style='width: 73px;'>状态</td>" 
		    	        +"<td class='hidden-phone'>报告编号</td>" 
		    	        +"<td class='hidden-phone'>样品名称</td>" 
		    	        +"<td class='hidden-phone'>样品登记日期</td>"
		                +"<td class='hidden-phone'>完成期限</td>" 
		                +"<td class='hidden-phone'>签收人</td>" 
		                +"<td class='hidden-phone'>主检人</td>"
		                +"<td class='hidden-phone'>审核人</td>" 
		                +"<td class='hidden-phone'>批准人</td>" 
		                +"<td class='hidden-phone'>报告状态</td>"
		                +"<td class='hidden-phone'>收费情况</td>" 
		                +"<td class='hidden-phone'>移交情况</td>";
	   		str1=str1+"</tr></thead><tbody>";
		   	for(var i = 0; i < data1.length; i++){
		         if(data1[i].workDayVal<0){
		   			str1=str1+"<tr class='gradeY'>";
		   		}else if (data1[i].workDayVal <= 3 && data1[i].workDayVal >= 0){
		   			str1=str1+"<tr class='gradeX'>";
		   		}else{
		   			str1=str1+"<tr class='gradeX'>";
		   		}
		   		str1=str1+"<td class='center hidden-phone'><a href='javascript:;' onclick='toView(\""+data1[i].ID+"\",\""+data1[i].DJLX+"\",\""+data1[i].YPBH+"\")' class='paginate_disabled_previous'>查看</a></td>";
		   		if(data1[i].workDayVal<0){
		   			str1=str1+"<td class='gradeY'><button type='button' class='btn3' style = 'background-color:red;border: 1px solid red;'>过期</button></td>";
		   		}else if (data1[i].workDayVal <= 3 && data1[i].workDayVal1>= 0){
		   			str1=str1+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}else{
		   			str1=str1+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}
//			   			str1=str1+"<tr>"
		   	    str1=str1+"<td class='center hidden-phone'>"+isNull(data1[i].YPBH)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].YPMC)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].DJSJ)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].WCQX)+"</td>";
	   		if(data1[i].YPZT1 == 0 || data1[i].YPZT1 == 1){
	   			str1=str1+"<td class='center hidden-phone'>"+isNull(data1[i].QSR)+"</td>"
			   			+"<td class='center hidden-phone'></td>"
			   			+"<td class='center hidden-phone'></td>"
			   			+"<td class='center hidden-phone'></td>"
	   		}else if(data1[i].YPZT1 == 2){
			   			str1=str1+"<td class='center hidden-phone'>"+isNull(data1[i].QSR)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].BZR)+"</td>"
			   			+"<td class='center hidden-phone'></td>"
			   			+"<td class='center hidden-phone'></td>"
	   		}else if(data1[i].YPZT1 == 3){
			   			str1=str1+"<td class='center hidden-phone'>"+isNull(data1[i].QSR)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].BZR)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].SHR)+"</td>"
			   			+"<td class='center hidden-phone'></td>"
	   		}else if(data1[i].YPZT1 >= 4 && data1[i].YPZT1 <= 7){
			   			str1=str1+"<td class='center hidden-phone'>"+isNull(data1[i].QSR)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].BZR)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].SHR)+"</td>"
			   			+"<td class='center hidden-phone'>"+isNull(data1[i].PZR)+"</td>"
		    }else if(data1[i].YPZT1 == 8 ){
			   			str1=str1+"<td class='center hidden-phone'></td>"
			   			+"<td class='center hidden-phone'></td>"
			   			+"<td class='center hidden-phone'></td>"
			   			+"<td class='center hidden-phone'></td>"
		    }	
			   			
			   str1=str1+"<td class='center hidden-phone'>"+isNull(data1[i].YPJYZT)+"</td>";
					    if(data1[i].JYFY ==0){
			   				str1=str1+"<td class='center hidden-phone'>无费用</td>";
			   			}
			            if(data1[i].YSFJE==0 && data1[i].JYFY !=0){
			   				str1=str1+"<td class='center hidden-phone'>待收费</td>";
			   			}
			   			if(data1[i].JYFY >data1[i].YSFJE && data1[i].YSFJE != 0){
			   				str1=str1+"<td class='center hidden-phone'>收费中</td>";
			   			}
			   			if(data1[i].JYFY ==data1[i].YSFJE && data1[i].YSFJE != 0){
			   				str1=str1+"<td class='center hidden-phone'>已收费</td>";
			   			}
			   			if(data1[i].YPYJ == 0){
				   		    str1=str1+"<td class='center hidden-phone'>不移交</td>";
			   			}
			   			else if(data1[i].YPYJ ==1 && data1[i].YJZT == 0){
			   				str1=str1+"<td class='center hidden-phone'>未移交</td>";
			   			}
			   			else if(data1[i].YPYJ ==1 && data1[i].YJZT == 1){
			   				str1=str1+"<td class='center hidden-phone'>已移交</td>";
			   			}else{
						str1=str1+"<td class='center hidden-phone'>不移交</td>";
						}
			   		str1=str1+"</tr>";
		   	}
		   	str1=str1+"</tbody></table>";
	        var oTest2 = document.getElementById("Div9");
//	        var oldNode = document.getElementById("Div4");
	        var newNode2 = document.createElement("table");
	        newNode2.setAttribute('class', 'display table table-bordered');
	        newNode2.setAttribute('id', 'table1');
	        newNode2.innerHTML = str1;
	        oTest2.insertBefore(newNode2, null);
	        }
		
		function insert_flg(str,flg,sn){
		    var newstr="";
		    var tmp=str.substring(0, sn);
		    var tmps=str.substring(sn, str.length);
		    newstr=tmp+flg+tmps;
		    return newstr;
		}
		