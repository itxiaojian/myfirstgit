		var num=1;
//		页面刚进来时执行的方法，动态分别加载表格
		window.onload = function(){
			num=1;
			var size=10;
			var count=10;
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
	            }
		   });
			
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getBgxx1list',
	            data: {start1: 0, limit1: 10,size1: 10},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data1) {
	            	creatTable1(data1);
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
		    		    +"<td style='width: 73px;'>状态</td>" 
		    	        +"<td >报告编号</td>" 
		    	        +"<td >样品名称</td>" 
		    	        +"<td >样品登记日期</td>"
		                +"<td >完成期限</td>" 
		                +"<td >签收人</td>" 
		                +"<td >主检人</td>"
		                +"<td >审核人</td>" 
		                +"<td >批准人</td>" 
		                +"<td >报告状态</td>"
		                +"<td >收费情况</td>" 
		                +"<td >移交情况</td>";
		   		str=str+"</tr></thead><tbody>";
		   	for(var i = 0; i < data.length; i++){
//		   	//起始日期，<span style="background-color: rgb(204, 204, 204);"><span style="color:#FF0000;"><strong>/pattern/是正则表达式的界定符，pattern是要匹配的内容，只用于第一个符号的匹配，g为全局匹配标志</strong></span></span>  
		   	var beginDate = new Date($("#dqsj").val().replace(/-/g, "/"));   
//		   	 //结束日期  
////		   	alert(data[i].WCQX1);
		   	if(data[i].WCQX!= null){
		   		var endDate = new Date(data[i].WCQX.replace(/-/g, "/")); 
//		   		//日期差值,即包含周六日、以天为单位的工时，86400000=1000*60*60*24.  
		   		var workDayVal = (endDate - beginDate)/86400000 + 1;  
//		   		//工时的余数  
		   		var remainder = workDayVal % 7; 
//		   		//工时向下取整的除数  
		   		var divisor = Math.floor(workDayVal / 7);  
		   		var weekendDay = 2 * divisor;  
//		   		
//		   		//起始日期的星期，星期取值有（1,2,3,4,5,6,0）  
		   		var nextDay = beginDate.getDay();  
//		   		//从起始日期的星期开始 遍历remainder天  
		   		for(var tempDay = remainder; tempDay>=1; tempDay--) {  
//		   			//第一天不用加1  
		   			if(tempDay == remainder) {  
		   				nextDay = nextDay + 0;  
		   			} else if(tempDay != remainder) {  
		   				nextDay = nextDay + 1;  
		   			}  
//		   			//周日，变更为0  
		   			if(nextDay == 7) {  
		   				nextDay = 0;  
		   			}  
//		   			//周六日  
		   			if(nextDay == 0 || nextDay == 6) {  
		   				weekendDay = weekendDay + 1;  
		   			}  
		   		}  
//		   		//实际工时（天） = 起止日期差 - 周六日数目。  
		   	     workDayVal = workDayVal - weekendDay; 
////              alert(workDayVal - weekendDay);		   	    
		   		if(workDayVal<0){
		   			str=str+"<tr class='gradeY'>";
		   		}else if (workDayVal <= 3 && workDayVal >= 0){
		   			str=str+"<tr class='gradeZ'>";
		   		}else{
		   			str=str+"<tr class='gradeX'>";
		   		}
		   		if(workDayVal<0){
		   			str=str+"<td class='gradeY'><button type='button' class='btn3' style = 'background-color:red;border: 1px solid red;'>过期</button></td>";
		   		}else if (workDayVal <= 3 && workDayVal >= 0){
		   			str=str+"<td class='gradeZ'><button type='button' class='btn3'>即将过期</button></td>";
		   		}else{
		   			str=str+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}
		   	}else{
		   		str=str+"<tr class='gradeX'>";
		   		str=str+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   	}
			   			str=str+"<td >"+isNull(data[i].YPBH)+"</td>"
			   			+"<td >"+isNull(data[i].YPMC)+"</td>"
			   			+"<td >"+isNull(data[i].DJSJ)+"</td>"
			   			+"<td >"+isNull(data[i].WCQX)+"</td>";
			   			if(data[i].YPZT1 == 0 || data[i].YPZT1 == 1){
				   			str=str+"<td >"+isNull(data[i].QSR)+"</td>"
						   			+"<td ></td>"
						   			+"<td ></td>"
						   			+"<td ></td>";
				   		}else if(data[i].YPZT1 == 2){
						   			str=str+"<td >"+isNull(data[i].QSR)+"</td>"
						   			+"<td >"+isNull(data[i].BZR)+"</td>"
						   			+"<td ></td>"
						   			+"<td ></td>";
				   		}else if(data[i].YPZT1 == 3){
						   			str=str+"<td >"+isNull(data[i].QSR)+"</td>"
						   			+"<td >"+isNull(data[i].BZR)+"</td>"
						   			+"<td >"+isNull(data[i].SHR)+"</td>"
						   			+"<td ></td>";
				   		}else if(data[i].YPZT1 >= 4 && data[i].YPZT1 <= 7){
						   			str=str+"<td >"+isNull(data[i].QSR)+"</td>"
						   			+"<td >"+isNull(data[i].BZR)+"</td>"
						   			+"<td >"+isNull(data[i].SHR)+"</td>"
						   			+"<td >"+isNull(data[i].PZR)+"</td>";
					    }else if(data[i].YPZT1 == 8 ){
						   			str=str+"<td ></td>"
						   			+"<td ></td>"
						   			+"<td ></td>"
						   			+"<td ></td>";
					    }
			   			str=str+"<td >"+isNull(data[i].YPJYZT)+"</td>";
			   			if(data[i].YSFJE==0){
			   				str=str+"<td >待收费</td>";
			   			}
			   			if(data[i].JYFY >data[i].YSFJE && data[i].YSFJE != 0){
			   				str=str+"<td >收费中</td>";
			   			}
			   			if(data[i].JYFY ==data[i].YSFJE && data[i].YSFJE != 0){
			   				str=str+"<td >已收费</td>";
			   			}
			   			if(data[i].YPYJ == 0){
				   		    str=str+"<td >不移交</td>";
			   			}
			   			if(data[i].YPYJ ==1 && data[i].YJZT == 0){
			   				str=str+"<td >未移交</td>";
			   			}
			   			if(data[i].YPYJ ==1 && data[i].YJZT == 1){
			   				str=str+"<td >已移交</td>";
			   			}
			   		str=str+"</tr>";
		   	}
		   	str=str+"</tbody></table>";
	        var oTest = document.getElementById("Div6");
//	        var oldNode = document.getElementById("Div4");
	        var newNode = document.createElement("table");
	        newNode.setAttribute('class', 'display table table-bordered table-hover personal-task');
	        newNode.setAttribute('id', 'table');
	        newNode.innerHTML = str;
	        oTest.insertBefore(newNode, null);
		}
		
		function creatTable1(data1){
			var del2 = $("#table1");
		    del2.remove();
		    var str1 = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'>" 
			    		+"<thead><tr>"
		    		    +"<td style='width: 73px;'>状态</td>" 
		    	        +"<td >报告编号</td>" 
		    	        +"<td >样品名称</td>" 
		    	        +"<td >样品登记日期</td>"
		                +"<td >完成期限</td>" 
		                +"<td >签收人</td>" 
		                +"<td >主检人</td>"
		                +"<td >审核人</td>" 
		                +"<td >批准人</td>" 
		                +"<td >报告状态</td>"
		                +"<td >收费情况</td>" 
		                +"<td >移交情况</td>";
	   		str1=str1+"</tr></thead><tbody>";
		   	for(var i = 0; i < data1.length; i++){
//		   	//起始日期，<span style="background-color: rgb(204, 204, 204);"><span style="color:#FF0000;"><strong>/pattern/是正则表达式的界定符，pattern是要匹配的内容，只用于第一个符号的匹配，g为全局匹配标志</strong></span></span>  
		   	var beginDate1 = new Date(data1[i].PZSJ.replace(/-/g, "/"));  
		   	 //结束日期  
//		   	alert(data[i].WCQX1);
		   	if(data1[i].WCQX!= null){
		   		var endDate1 = new Date(data1[i].WCQX.replace(/-/g, "/")); 
//		   		alert(beginDate1);
//		   		alert(endDate1);
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
		         workDayVal1 = workDayVal1 - weekendDay1; 
//		         alert(workDayVal1);
//		         alert(weekendDay1);
//		         alert(workDayVal1 - weekendDay1);
//              alert(workDayVal - weekendDay);		   	    
		         if(workDayVal1<0){
		   			str1=str1+"<tr class='gradeY'>";
		   		}else if (workDayVal1 <= 3 && workDayVal1 >= 0){
		   			str1=str1+"<tr class='gradeX'>";
		   		}else{
		   			str1=str1+"<tr class='gradeX'>";
		   		}
		   		if(workDayVal1<0){
		   			str1=str1+"<td class='gradeY'><button type='button' class='btn3' style = 'background-color:red;border: 1px solid red;'>过期</button></td>";
		   		}else if (workDayVal1 <= 3 && workDayVal1 >= 0){
		   			str1=str1+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}else{
		   			str1=str1+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   		}
		   	}else{
		   		str1=str1+"<tr class='gradeX'>";
		   		str1=str1+"<td class='gradeX'><button type='button' class='btn3' style = 'background-color:green;border: 1px solid #797979;'>正常</button></td>";
		   	}
//			   			str1=str1+"<tr>"
		   	    str1=str1+"<td >"+isNull(data1[i].YPBH)+"</td>"
			   			+"<td >"+isNull(data1[i].YPMC)+"</td>"
			   			+"<td >"+isNull(data1[i].DJSJ)+"</td>"
			   			+"<td >"+isNull(data1[i].WCQX)+"</td>";
	   		if(data1[i].YPZT1 == 0 || data1[i].YPZT1 == 1){
	   			str1=str1+"<td >"+isNull(data1[i].QSR)+"</td>"
			   			+"<td ></td>"
			   			+"<td ></td>"
			   			+"<td ></td>"
	   		}else if(data1[i].YPZT1 == 2){
			   			str1=str1+"<td >"+isNull(data1[i].QSR)+"</td>"
			   			+"<td >"+isNull(data1[i].BZR)+"</td>"
			   			+"<td ></td>"
			   			+"<td ></td>"
	   		}else if(data1[i].YPZT1 == 3){
			   			str1=str1+"<td >"+isNull(data1[i].QSR)+"</td>"
			   			+"<td >"+isNull(data1[i].BZR)+"</td>"
			   			+"<td >"+isNull(data1[i].SHR)+"</td>"
			   			+"<td ></td>"
	   		}else if(data1[i].YPZT1 >= 4 && data1[i].YPZT1 <= 7){
			   			str1=str1+"<td >"+isNull(data1[i].QSR)+"</td>"
			   			+"<td >"+isNull(data1[i].BZR)+"</td>"
			   			+"<td >"+isNull(data1[i].SHR)+"</td>"
			   			+"<td >"+isNull(data1[i].PZR)+"</td>"
		    }else if(data1[i].YPZT1 == 8 ){
			   			str1=str1+"<td ></td>"
			   			+"<td ></td>"
			   			+"<td ></td>"
			   			+"<td ></td>"
		    }	
			   			
			   str1=str1+"<td >"+isNull(data1[i].YPJYZT)+"</td>";
			   			if(data1[i].YSFJE==0){
			   				str1=str1+"<td >待收费</td>";
			   			}
			   			if(data1[i].JYFY >data1[i].YSFJE && data1[i].YSFJE != 0){
			   				str1=str1+"<td >收费中</td>";
			   			}
			   			if(data1[i].JYFY ==data1[i].YSFJE && data1[i].YSFJE != 0){
			   				str1=str1+"<td >已收费</td>";
			   			}
			   			if(data1[i].YPYJ == 0){
				   		    str1=str1+"<td >不移交</td>";
			   			}
			   			if(data1[i].YPYJ ==1 && data1[i].YJZT == 0){
			   				str1=str1+"<td >未移交</td>";
			   			}
			   			if(data1[i].YPYJ ==1 && data1[i].YJZT == 1){
			   				str1=str1+"<td >已移交</td>";
			   			}
			   		str1=str1+"</tr>";
		   	}
		   	str1=str1+"</tbody></table>";
	        var oTest2 = document.getElementById("Div9");
//	        var oldNode = document.getElementById("Div4");
	        var newNode2 = document.createElement("table1");
	        newNode2.setAttribute('class', 'display table table-bordered table-hover personal-task');
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
		