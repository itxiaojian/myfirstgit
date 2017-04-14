		var num=1;
		
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
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getSfglList',
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
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getSfglList',
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
			var del1 = $("#Div5");
			del1.remove();
			var html="";
			if(obj==0){
	        	if(size < data[0].count){
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;'>显示第 "+1+" 到 "+size+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;'>";
	        	}else{
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;'>显示第 "+1+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;'>";
	        	}
			}else{
				if(size < data[0].count){
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;'>显示第 "+(obj+1)+" 到 "+size+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;'>";
				}else{
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;'>显示第 "+(obj+1)+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;'>";
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
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getSfglList',
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
		
		function showQj(value){
			var del = $("#Div3");
			del.remove();
			if(value=='between'){
			    var str="";
			    var xzzd=$('#xzzd').val();
			    if(xzzd=='DJRQ'||xzzd=='ZZRQ'||xzzd=='SXRQ'){
				    str="<label>起始：</label><input name='qjq' id='qjq' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput'/>"
				    		+ "<label style='margin-left: 4%;'>截止：</label><input name='qjz' id='qjz' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput'/>";
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
				if(xzzd=='JLDW'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
				for(var i=0;i<idList.length;i++){
					str=str+"<option value='"+idList[i]+"'>"+mcList[i]+"</option>";
				}
				str=str+"</select>";
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
				if(xzzd=='JLDW'){
					alert('该字段请选择等于条件！');
					return false;
				}else{
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
				}
			}else{
				var str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:75%;margin-left: 5px;' class='form-control1 textinput'/>";
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
					if(value=='DJRQ'||value=='ZZRQ'||value=='SXRQ'){
						str="<label>起始：</label><input name='qjq' id='qjq' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput'/>"
							+ "<label style='margin-left: 4%;'>截止：</label><input name='qjz' id='qjz' type='text' style='width:34%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput'/>";
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
					if(value=='JLDW'){
						 $('#xztj').val('=');
							str="<label>关键字：</label>" +
							"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
							"<option value=''>请选择...</option>";
						for(var i=0;i<idList.length;i++){
							str=str+"<option value='"+idList[i]+"'>"+mcList[i]+"</option>";
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
			var xzlb=$('#xzlb').val();
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
						cxtj=cxtj+" "+xzlb+" (to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+qjq+"'and '"+qjz+"')";
					}else{
						cxtj=cxtj+" "+xzlb+" to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+qjq+"' and '"+qjz+"'";
					}
				}
			}else{
				gjz=$('#gjz').val();
				if(gjz==null||gjz==''){
					alert("关键字为必填项！");
					return false;
				}else{
					if(xzzd=='JLDW'){
						xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" "+$("#xztj").find("option:selected").text()+" "+$("#gjz").find("option:selected").text();
					}else{
					xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" "+$("#xztj").find("option:selected").text()+" "+gjz;
					}
					if(xzzd=='DJRQ'||xzzd=='ZZRQ'||xzzd=='SXRQ'){
						if(xzlb=='or'){
							if(xztj=='like'||xztj=='not like'){
								cxtj=" "+xzlb+" (to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '%"+gjz+"%')";
							}else{
								cxtj=" "+xzlb+" (to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"')";
							}
						}else{
							if(xztj=='like'||xztj=='not like'){
								cxtj=" "+xzlb+" to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '%"+gjz+"%'";
							}else{
								cxtj=" "+xzlb+" to_char(a."+xzzd+",'yyyy-mm-dd') "+xztj+" '"+gjz+"'";
							}
						}
					}else{
						if(xzlb=='or'){
							if(xztj=='like'||xztj=='not like'){
								cxtj=" "+xzlb+" (a."+xzzd+" "+xztj+" '%"+gjz+"%')";
							}else{
								cxtj=" "+xzlb+" (a."+xzzd+" "+xztj+" '"+gjz+"')";
							}
						}else{
							if(xztj=='like'||xztj=='not like'){
								cxtj=" "+xzlb+" a."+xzzd+" "+xztj+" '%"+gjz+"%'";
							}else{
								cxtj=" "+xzlb+" a."+xzzd+" "+xztj+" '"+gjz+"'";
							}
						}
					}
				}
			}
			
			var sltObj = document.getElementById("xsmc"); //获取select对象
			var optionObj = document.createElement("option"); //创建option对象
			optionObj.value = cxtj;
			optionObj.innerHTML = xsmc+"<br/>";
			optionObj.selected = true;//默认选中
			sltObj.appendChild(optionObj);
			
//			$('#xsmc').val(xsmc);
//			$('#cxtj').val(cxtj);
		}
		
	
		function isNull(string){
			if(string==null||string=='null'){
				return '';
			}else{
				return string
			}
		}
		
		function creatTable(strs,data,values){
			var del = $("#table");
		    del.remove();
		    
		    var str = "<table cellpadding='0' cellspacing='0' border='0' class='display table table-bordered'><thead><tr>";
		    		
		   	for(var i=0;i<strs.length ;i++){
		   		if(strs[i].indexOf("（") > 0){
		   			str=str+"<th class='hidden-phone'>"+strs[i].substring(0,strs[i].indexOf("（"))+"</th>";
		   		}else{
		   			str=str+"<th class='hidden-phone'>"+strs[i]+"</th>";
		   		}
		   	}
		   	str=str+"</tr></thead><tbody>";
		   	if(data.length==0){
		   		str=str+"<tr class='gradeX'><td colspan='20' style='color:red;'>无符合条件的数据！</td></tr>"
		   	}else{
		   	for(var i = 0; i < data.length; i++){
		   		str=str+"<tr class='gradeX'>";
		   		for(var j=0;j<values.length ;j++){
		   			if(values[j]=='ID'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].ID)+"</td>";
		   			}
		   			if(values[j]=='SFBZBH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SFBZBH)+"</td>";
		   			}
		   			if(values[j]=='GGXH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].GGXH)+"</td>";
		   			}
		   			if(values[j]=='CPMC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CPMC)+"</td>";
		   			}
		   			if(values[j]=='CPLX'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CPLX)+"</td>";
		   			}
		   			if(values[j]=='XMBH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].XMBH)+"</td>";
		   			}
		   			if(values[j]=='XMMC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].XMMC)+"</td>";
		   			}
		   			if(values[j]=='DJ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].DJ)+"</td>";
		   			}
		   			if(values[j]=='JLDW'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].JLDW)+"</td>";
		   			}
		   			if(values[j]=='BZ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].BZ)+"</td>";
		   			}
		   			if(values[j]=='CPLXBH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CPLXBH)+"</td>";
		   			}

		   		}
		   		str=str+"</tr>";
		   	}
		   	}
		   	str=str+"</tbody></table>";
	        var oTest = document.getElementById("Div6");
	//        var oldNode = document.getElementById("Div4");
	        var newNode = document.createElement("table");
	        newNode.setAttribute('class', 'display table table-bordered');
	        newNode.setAttribute('id', 'table');
	        newNode.innerHTML = str;
	        oTest.insertBefore(newNode, null);
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
			
			if(confirm("确定下载查询结果吗?")){
				var fileName = "收费信息";
    	    	var url = "export?fileName="+fileName+"&cs="+vals+"&cxtj="+cxtj+"&bt="+bt;
    	    	url = encodeURI(url);
    	    	url = encodeURI(url);
    	    	window.open(url);
			}
		}