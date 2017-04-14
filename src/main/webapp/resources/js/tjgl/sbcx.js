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
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getSbcxList',
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
			var start=parseInt($('#size').val())*num-parseInt($('#size').val());
			var size=parseInt($('#size').val())*num;
			var count=parseInt($('#size').val());
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getSbcxList',
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
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>显示第 "+1+" 到 "+size+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>";
	        	}else{
	        		html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>显示第 "+1+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
	        			+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>";
	        	}
			}else{
				if(size < data[0].count){
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>显示第 "+(obj+1)+" 到 "+size+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>";
				}else{
					html=html+"<div id='table_info' class='dataTables_info' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>显示第 "+(obj+1)+" 到 "+data[0].count+"条 共 "+data[0].count+"条</div>"
					+ "<div id='table_paginate' class='dataTables_paginate paging_two_button' style='float:left;margin-top: 6px;padding-top: 6px; padding-bottom: 0px;'>";
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
	            url: 'getSbcxList',
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
			    if(xzzd=='CCRQ'||xzzd=='GMRQ'||xzzd=='SCJDRQ'||xzzd=='XCJDRQ'||xzzd=='TYRQ'||xzzd=='BFRQ'||xzzd=='QYSJ'){
				    str="<label>起始：</label><input name='qjq' id='qjq' type='text' style='width:40%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>"
				    		+ "<label style='margin-left: 4%;'>截止：</label><input name='qjz' id='qjz' type='text' style='width:40%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
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
				if(xzzd=='CCRQ'||xzzd=='GMRQ'||xzzd=='SCJDRQ'||xzzd=='XCJDRQ'||xzzd=='TYRQ'||xzzd=='BFRQ'||xzzd=='QYSJ'){
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:85%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
				}else if(xzzd=='SYKS'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<idList.length;i++){
						str=str+"<option value='"+idList[i]+"'>"+mcList[i]+"</option>";
					}
					str=str+"</select>";
			    }else if(xzzd=='JYZQ'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<jyzqidList.length;i++){
						str=str+"<option value='"+jyzqidList[i]+"'>"+jyzqmcList[i]+"</option>";
					}
					str=str+"</select>";
			    }else if(xzzd=='JDDW'){
					str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<jddwidList.length;i++){
						str=str+"<option value='"+jddwidList[i]+"'>"+jddwmcList[i]+"</option>";
					}
					str=str+"</select>";
			    }else if(xzzd=='DW'){
			    	str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
					"<option value=''>请选择...</option><option value='1'>台</option><option value='0'>套</option></select>";
			    }else if(xzzd=='SBZT'){
			    	str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<sbztidList.length;i++){
						str=str+"<option value='"+sbztidList[i]+"'>"+sbztmcList[i]+"</option>";
					}
					str=str+"</select>";
			    }else if(xzzd=='YQZK'||xzzd=='SYZT'){
			    	str="<label>关键字：</label>" +
					"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
					"<option value=''>请选择...</option>";
					for(var i=0;i<syztidList.length;i++){
						str=str+"<option value='"+syztidList[i]+"'>"+syztmcList[i]+"</option>";
					}
					str=str+"</select>";
			    }else{
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:85%;margin-left: 5px;' class='form-control1 textinput'/>";
				}
					var oTest = document.getElementById("Div2");
			        var newNode = document.createElement("div");
			        newNode.setAttribute('id', 'Div3');
			        newNode.innerHTML = str;
			        oTest.insertBefore(newNode, null);
			}else if(value=='>'||value=='<'||value=='>='||value=='<='||value=='like'||value=='not like'){
				var str="";
				var xzzd=$('#xzzd').val();
				if(xzzd=='CCRQ'||xzzd=='GMRQ'||xzzd=='SCJDRQ'||xzzd=='XCJDRQ'||xzzd=='TYRQ'||xzzd=='BFRQ'||xzzd=='QYSJ'){
					str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:85%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
				}else if(xzzd=='SYKS'||xzzd=='JYZQ'||xzzd=='SYZT'||xzzd=='DW'||xzzd=='YQZK'||xzzd=='SYZT'){
					alert("该字段请选择等于条件！");
			    	return false;
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
				var xzzd=$('#xzzd').val();
				if(xzzd=='CCRQ'||xzzd=='GMRQ'||xzzd=='SCJDRQ'||xzzd=='XCJDRQ'||xzzd=='TYRQ'||xzzd=='BFRQ'||xzzd=='QYSJ'){
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
					if(value=='CCRQ'||value=='GMRQ'||value=='SCJDRQ'||value=='XCJDRQ'||value=='TYRQ'||value=='BFRQ'||value=='QYSJ'){
						str="<label>起始：</label><input name='qjq' id='qjq' type='text' style='width:40%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>"
							+ "<label style='margin-left: 4%;'>截止：</label><input name='qjz' id='qjz' type='text' style='width:40%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
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
					if(value=='CCRQ'||value=='GMRQ'||value=='SCJDRQ'||value=='XCJDRQ'||value=='TYRQ'||value=='BFRQ'||value=='QYSJ'){
						str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:85%;margin-left: 5px;' class='form-control1 Wdate textinput' onclick=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" truetype='textinput' readonly='readonly'/>";
					}else if(value=='SYKS'){
						$('#xztj').val('=');
						str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<idList.length;i++){
							str=str+"<option value='"+idList[i]+"'>"+mcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else if(value=='JDDW'){
						$('#xztj').val('=');
						str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<jddwidList.length;i++){
							str=str+"<option value='"+jddwidList[i]+"'>"+jddwmcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else if(value=='JYZQ'){
				    	$('#xztj').val('=');
						str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<jyzqidList.length;i++){
							str=str+"<option value='"+jyzqidList[i]+"'>"+jyzqmcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else if(value=='DW'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>"+
						"<option value=''>请选择...</option><option value='1'>台</option><option value='0'>套</option></select>";
				    }else if(value=='SBZT'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<sbztidList.length;i++){
							str=str+"<option value='"+sbztidList[i]+"'>"+sbztmcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else if(value=='YQZK'||value=='SYZT'){
				    	$('#xztj').val('=');
				    	str="<label>关键字：</label>" +
						"<select class='form-control1 input-lg1 m-bot15 textinput' name='gjz' id='gjz' style='width:40%;margin-top: 10px;'>" +
						"<option value=''>请选择...</option>";
						for(var i=0;i<syztidList.length;i++){
							str=str+"<option value='"+syztidList[i]+"'>"+syztmcList[i]+"</option>";
						}
						str=str+"</select>";
				    }else{
				    	$('#xztj').val('like');
						str="<label>关键字：</label><input name='gjz' id='gjz' type='text' style='width:85%;margin-left: 5px;' class='form-control1 textinput'/>";
					}
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
					if(xzzd=='JYZQ'||xzzd=='JDDW'||xzzd=='SBZT'||xzzd=='SYZT'||xzzd=='YQZK'||xzzd=='SYKS'){
						xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" "+$("#xztj").find("option:selected").text()+" "+$("#gjz").find("option:selected").text();
					}else{
					xsmc=" "+$("input[name='xzlb']:checked").next("label").text()+" "+$("#xzzd").find("option:selected").text()
						+" "+$("#xztj").find("option:selected").text()+" "+gjz;
					}
					if(xzzd=='CCRQ'||xzzd=='GMRQ'||xzzd=='SCJDRQ'||xzzd=='XCJDRQ'||xzzd=='TYRQ'||xzzd=='BFRQ'||xzzd=='QYSJ'){
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
		
		function sfwk(string){
			if(string==null||string=='null'){
				return '';
			}else{
				return "点击查看";
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
		   			if(values[j]=='SBBH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBBH)+"</td>";
		   			}
		   			if(values[j]=='EWMBH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].EWMBH)+"</td>";
		   			}
		   			if(values[j]=='SBMC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBMC)+"</td>";
		   			}
		   			if(values[j]=='SBXH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBXH)+"</td>";
		   			}
		   			if(values[j]=='SBJB'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBJB)+"</td>";
		   			}
		   			if(values[j]=='SYKS'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SYKS)+"</td>";
		   			}
		   			if(values[j]=='SYFW'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SYFW)+"</td>";
		   			}
		   			if(values[j]=='SCCJ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SCCJ)+"</td>";
		   			}
		   			if(values[j]=='CCBH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CCBH)+"</td>";
		   			}
		   			if(values[j]=='CCRQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CCRQ)+"</td>";
		   			}
		   			if(values[j]=='GMRQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].GMRQ)+"</td>";
		   			}
		   			if(values[j]=='GMJG'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].GMJG)+"</td>";
		   			}
		   			if(values[j]=='JYZQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].JYZQ)+"</td>";
		   			}
		   			if(values[j]=='SCJDRQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SCJDRQ)+"</td>";
		   			}
		   			if(values[j]=='XCJDRQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].XCJDRQ)+"</td>";
		   			}
		   			if(values[j]=='SYZT'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SYZT)+"</td>";
		   			}
		   			if(values[j]=='SBWHR'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBWHR)+"</td>";
		   			}
		   			if(values[j]=='TYRQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].TYRQ)+"</td>";
		   			}
		   			if(values[j]=='TYYY'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].TYYY)+"</td>";
		   			}
		   			if(values[j]=='BFRQ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].BFRQ)+"</td>";
		   			}
		   			if(values[j]=='BFYY'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].BFYY)+"</td>";
		   			}
		   			if(values[j]=='BZ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].BZ)+"</td>";
		   			}
		   			if(values[j]=='EWMTP'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].EWMTP)+"</td>";
		   			}
		   			if(values[j]=='DW'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].DW)+"</td>";
		   			}
		   			if(values[j]=='SBFJ'){
		   				str=str+"<td class='center hidden-phone'><a class='btn btn-xs btn-sucess' onClick='getSbfj("+data[i].ID+");'>"+sfwk(data[i].SBFJ)+"</a></td>";
		   			}
		   			if(values[j]=='FZDD'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].FZDD)+"</td>";
		   			}
		   			if(values[j]=='QYSJ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].QYSJ)+"</td>";
		   			}
		   			if(values[j]=='CJLXR'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CJLXR)+"</td>";
		   			}
		   			if(values[j]=='CJDH'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CJDH)+"</td>";
		   			}
		   			if(values[j]=='CJDZ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CJDZ)+"</td>";
		   			}
		   			if(values[j]=='CLFW'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CLFW)+"</td>";
		   			}
		   			if(values[j]=='PJXX'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].PJXX)+"</td>";
		   			}
		   			if(values[j]=='SBCZR'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBCZR)+"</td>";
		   			}
		   			if(values[j]=='SFYCZGC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SFYCZGC)+"</td>";
		   			}
		   			if(values[j]=='SFYQJHC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SFYQJHC)+"</td>";
		   			}
		   			if(values[j]=='SFYSYJL'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SFYSYJL)+"</td>";
		   			}
		   			if(values[j]=='SFYGNJC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SFYGNJC)+"</td>";
		   			}
		   			if(values[j]=='SBZT'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBZT)+"</td>";
		   			}
		   			if(values[j]=='CZGC'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].CZGC)+"</td>";
		   			}
		   			if(values[j]=='SYSMS'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SYSMS)+"</td>";
		   			}
		   			if(values[j]=='SBZP'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SBZP)+"</td>";
		   			}
		   			if(values[j]=='SYSMFFJ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SYSMFFJ)+"</td>";
		   			}
		   			if(values[j]=='GNJCFF'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].GNJCFF)+"</td>";
		   			}
		   			if(values[j]=='QJHCFF'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].QJHCFF)+"</td>";
		   			}
		   			if(values[j]=='BZDDJ'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].BZDDJ)+"</td>";
		   			}
		   			if(values[j]=='JLQK'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].JLQK)+"</td>";
		   			}
		   			if(values[j]=='JLJG'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].JLJG)+"</td>";
		   			}
		   			if(values[j]=='JDFY'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].JDFY)+"</td>";
		   			}
		   			if(values[j]=='JDDW'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].JDDW)+"</td>";
		   			}
		   			if(values[j]=='YQZK'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].YQZK)+"</td>";
		   			}
		   			if(values[j]=='SYBM'){
		   				str=str+"<td class='center hidden-phone'>"+isNull(data[i].SYBM)+"</td>";
		   			}if(values[j]=='JDZS'){
		   				str=str+"<td class='center hidden-phone'><a class='btn btn-xs btn-sucess' onClick='getJdzs("+data[i].ID+");'>"+sfwk(data[i].JDZS)+"</a></td>";
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
		
		function getJdzs(id){
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getJdzs',
	            data: {id:id},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	if(data.length==1){
	            		for(i=0;i<data.length;i++){
		            		//location.href="/zjyw/sbgl/YSbXx/jdzsck?jdzs="+data[i].JDZS+"&jdzssub="+data[i].JDZSSUB;
		            		window.open("/zjyw/sbgl/YSbXx/jdzsck?jdzs="+data[i].JDZS+"&jdzssub="+data[i].JDZSSUB+"&cs=1",'查看标签','height=650px, width=850px,top=100px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
		            	}
	            	}else{
	            		alert("链接失败,请联系管理员。");
	            	}
	            }
		   });

		}
		
		function getSbfj(id){
			$.ajax({
	            cache: true,
	            type: "POST",
	            url: 'getJdzs',
	            data: {id:id},
	            async: false,
	            error: function (request) {
	                alert("链接失败,请联系管理员。");
	            },
	            success: function (data) {
	            	if(data.length==1){
	            		for(i=0;i<data.length;i++){
		            		//location.href="/zjyw/sbgl/YSbXx/jdzsck?jdzs="+data[i].SBFJ+"&jdzssub="+data[i].SBFJJL+"/"+data[i].SBFJSUB;
	            			window.open("/zjyw/sbgl/YSbXx/jdzsck?jdzs="+data[i].SBFJ+"&jdzssub="+data[i].SBFJJL+"/"+data[i].SBFJSUB+"&cs=1",'查看标签','height=650px, width=850px,top=100px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
		            	}
	            	}else{
	            		alert("链接失败,请联系管理员。");
	            	}
	            }
		   });

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
			
			if(confirm("确定下载查询结果吗?")){
				var fileName = "设备信息";
    	    	var url = "export?fileName="+fileName+"&cs="+vals+"&cxtj="+cxtj+"&bt="+bt;
    	    	url = encodeURI(url);
    	    	url = encodeURI(url);
    	    	window.open(url);
			}
		}