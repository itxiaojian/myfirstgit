		var num=1;
		
		function getValueFys(){
			num--;
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			var cplx=$("#cplx").val();
			var cpbh=$("#cpbh").val();
			var cpmc=$("#cpmc").val();
			var jyyj=$("#jyyj").val();
			var jyxm=$("#jyxm").val();
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getJyxmlist',
	            data: {start: start, limit: size, size: count, cplx: cplx, cpbh: cpbh, cpmc: cpmc, jyyj: jyyj, jyxm: jyxm},
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
			var jyyj=$("#jyyj").val();
			var jyxm=$("#jyxm").val();
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getJyxmlist',
	            data: {start: start, limit: size, size: count, cplx: cplx, cpbh: cpbh, cpmc: cpmc, jyyj: jyyj, jyxm: jyxm},
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
			var jyyj=$("#jyyj").val();
			var jyxm=$("#jyxm").val();
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getJyxmlist',
	            data: {start: 0, limit: size,size: count, cplx: cplx, cpbh: cpbh, cpmc: cpmc, jyyj: jyyj, jyxm: jyxm},
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
		
		function changeVal(string){
			if(string==null||string=='null'){
				return '';
			}else if(string=="0"){
				return "是"
			}else if(string=="1"){
				return "否"
			}
		}
		
//		function toView(cpbh,cplx,jyyj ){
//			location.href="jyxmView?cpbh="+cpbh+"&cplx="+"&jyyj="+jyyj;
//		}
		
		function creatTable(data){
			var del = $("#table");
		    del.remove();
		    var str = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'>" 
			    		+"<thead><tr>"
		    	        +"<td class='hidden-phone'><b>序号</B></td>" 
		    	        +"<td class='hidden-phone'><b>检验依据</B></td>"
		                +"<td class='hidden-phone'><b>检验项目编号</B></td>"
		                +"<td class='hidden-phone'><b>检验项目</B></td>"
		                +"<td class='hidden-phone'><b>对应标准条款号</B></td>"
		                +"<td class='hidden-phone'><b>规格型号</B></td>"
		                +"<td class='hidden-phone'><b>样品数量</B></td>"
		                +"<td class='hidden-phone'><b>检测费用</B></td>"
		                +"<td class='hidden-phone'><b>计量单位</B></td>"
		                +"<td class='hidden-phone'><b>检验周期</B></td>"
		                +"<td class='hidden-phone'><b>院资质认定</B></td>"
		                +"<td class='hidden-phone'><b>院CNAS</B></td>"
		                +"<td class='hidden-phone'><b>国排中心CMA/CAL</B></td>"
		                +"<td class='hidden-phone'><b>国建中心CMA/CAL</B></td>"
		                +"<td class='hidden-phone'><b>院食品资质认定</B></td>"
		                +"<td class='hidden-phone'><b>环境要求</B></td>"
		                +"<td class='hidden-phone'><b>设备编号</B></td>"
		                +"<td class='hidden-phone'><b>设备名称</B></td>"
		                +"<td class='hidden-phone'><b>人员</B></td>"
		                +"<td class='hidden-phone'><b>备注</B></td>";
		   		str=str+"</tr></thead><tbody>";
		   	for(var i = 0; i < data.length; i++){
		   			str=str+"<td class='center hidden-phone' style='color:red;'>"+(i+1)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].JYYJ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].JYXMBH)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].JCXM)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].DYBZTKH)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].GGXH)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].YPSL)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].JCFY)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].JLDW)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].JYZQ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+changeVal(data[i].YZZRD)+"</td>"
			   			   +"<td class='center hidden-phone'>"+changeVal(data[i].YZZ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+changeVal(data[i].GPZZ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+changeVal(data[i].GJZZ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+changeVal(data[i].YSPZZ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].HJYQ)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].SBBH)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].SBMC)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].RY)+"</td>"
			   			   +"<td class='center hidden-phone'>"+isNull(data[i].BZ)+"</td>";
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
		