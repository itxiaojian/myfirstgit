var ENTITY_URL_LIST = "/select/jxdx_IpasJxdxCkzhXk";
var PAGESIZE=50;
/*******
 * 绩效对象_存款业绩分配
 * @author liujiansen
 * @date 2014-07-14
 *
 */

/****************IpasParamAreabizdiffGrid***********************/
IpasPerfobjDepositaccountGrid = Ext.extend(UxGrid,{
	constructor: function(height,width){
		this.store = new Ext.data.Store({
			proxy: new Ext.data.HttpProxy({url:ENTITY_URL_LIST,timeout:300000,method:'POST'}),
			reader: new Ext.data.JsonReader({totalProperty:'total',root:'rows'},[
		            {name:'assobjcode'},
		            {name:'customercode'},
		            {name:'statisticsdate'},
		            {name:'accountcode'},
		            {name:'accountname'},
		            {name:'accountbalance'},
		            {name:'orgname'},
		            {name:'nbzh'},
		            {name:'zhsxh'},
		            {name:'coursename'},
		            {name:'yearratecode'},
		            {name:'customername'},
		            {name:'openaccountdate'},
		            {name:'rela'},
		            {name:'zhbs'},
		            {name:'logoffdate'}
					 ])
		});
		this.vtbar = new Ext.Toolbar({
			items: [
			       '-',{xtype:'button',text:'分配明细',iconCls:'ipasms',handler:this.onAccountRelaDataClick,scope:this}
			       /*'-',{xtype:'label',text:'开户开始日期'},{xtype:'datefield',format:'Ymd',id:'khrqStr',editable : false,value:CurrentDate.format('Ymd'),width:80},
			       '-',{xtype:'label',text:'开户截止日期'},{xtype:'datefield',format:'Ymd',id:'khrqEnd',editable : false,value:new Date().format('Ymd'),width:80},
			       '-',{xtype:'label',text:'余额'},{xtype:'textfield',id:'zhye',width:80},
			       '-',{xtype:'label',text:'关系'},{xtype:'combo',id:'type',
			    	   editable: false,
			    	   store: new Ext.data.Store({
			                proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries?dictTypeCode=CXGX', method: 'POST'}),
			                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
			                autoLoad:true
			            }),
                       displayField: 'name', //显示文本字段
                       valueField: 'code',//value值字段id
                       mode: 'local',
                       blankText:'请选择...',  
                       emptyText:'请选择...', 
                       triggerAction: 'all',
                       selectOnFocus: true,
                       typeAhead: true,
                       width:80
		       		},
			       '-',{xtype:'combo',id:'rela',value:'未分配',
			    	   editable: false,
			    	   store: new Ext.data.Store({
			                proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries?dictTypeCode=YJFPZT', method: 'POST'}),
			                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
			                autoLoad:true
			            }),
                       displayField: 'name', //显示文本字段
                       valueField: 'code',//value值字段id
                       mode: 'local',
                       blankText:'请选择...',  
                       emptyText:'请选择...', 
                       triggerAction: 'all',
                       selectOnFocus: true,
                       typeAhead: true,
                       width:80
		       		},
		       		'-',{xtype:'combo',id:'zhlx',value:'对公',
			    	   editable: false,
			    	   store: new Ext.data.Store({
			                proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries?dictTypeCode=ZHLX', method: 'POST'}),
			                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
			                autoLoad:true
			            }),
                       displayField: 'name', //显示文本字段
                       valueField: 'code',//value值字段id
                       mode: 'local',
                       blankText:'请选择...',  
                       emptyText:'请选择...', 
                       triggerAction: 'all',
                       selectOnFocus: true,
                       typeAhead: true,
                       width:80
		       		},
			       '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
			       		   if(Ext.getCmp('zhye').getValue()!=''&&Ext.getCmp('type').getValue()==''){
			       		   	  Ext.Msg.alert('系统提示','请选择查询关系');
			       		   	  return false;
			       		   }
			       		   
			       		   if(Ext.getCmp('zhye').getValue()==''&&Ext.getCmp('type').getValue()!=''){
			       		   	  Ext.Msg.alert('系统提示','请输入账户余额');
			       		   	  return false;
			       		   }
				    	   var params = {};
				    	   ipasPerfobjDepositaccountGrid.vtbar.items.each(function(item,index,length){ 
		       					if((""+item.getXType()).indexOf("field") != -1 && item.getValue() != '') {
		       						if (item.getXType() == 'datefield') {
		       							params[item.getId()] = item.getValue().format(item.format);
		       						} else {
		       							params[item.getId()] = item.getValue();
		       						}
		       					}
							});
							params['type']=Ext.getCmp('type').getValue();
							if(Ext.getCmp('rela').getValue()!=''&&Ext.getCmp('rela').getValue()!='未分配'){
			       				params['rela'] = Ext.getCmp('rela').getValue();
			       			}else{
			       				params['rela'] ='is null';
			       			}
			       			if(Ext.getCmp('zhlx').getValue()!=''&&Ext.getCmp('zhlx').getValue()!='对公'){
			       				params['zhlx'] = Ext.getCmp('zhlx').getValue();
			       			}else{
			       				params['zhlx'] = 2;
			       			}
	    	   				ipasPerfobjDepositaccountGrid.store.baseParams= params;
	    	   				ipasPerfobjDepositaccountGrid.store.load({params:{start:0,limit:PAGESIZE}});
	    	   			}
					,scope:this},
		'-',{xtype:'button',text:'重置',iconCls:'refresh',handler:function(){
			ipasPerfobjDepositaccountGrid.vtbar.items.each(function(item,index,length){   
				if((""+item.getXType()).indexOf("field") != -1 && item.getXType() != 'datefield') {
					item.setValue('');
				}
		  });
		}
		}*/
			]
		});
		this.vbbar = this.createPagingToolbar(PAGESIZE);

		this.vsm = new Ext.grid.CheckboxSelectionModel();
		this.vcm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		             this.vsm,
		                {header:'开户日期',dataIndex:'openaccountdate',width:100,sortable:true,hidden:false},
		                {header:'经办人代号',dataIndex:'assobjcode',width:100,sortable:true},
		                {header:'内部账号',dataIndex:'nbzh',width:100,sortable:true,hidden:true},
			            {header:'统计日期',dataIndex:'statisticsdate',width:100,sortable:true,hidden:true},
			            {header:'客户号',dataIndex:'customercode',width:100,sortable:true,hidden:true},
			            {header:'客户名称',dataIndex:'accountname',width:200,sortable:true,hidden:false},
			            {header:'账户代号',dataIndex:'accountcode',width:180,sortable:true,hidden:false},
			            {header:'内部账号',dataIndex:'nbzh',width:180,sortable:true,hidden:false},
			            {header:'账户顺序号',dataIndex:'zhsxh',width:100,sortable:true,hidden:false},
			            {header:'科目名称',dataIndex:'coursename',width:150,sortable:true,hidden:false},
			            {header:'账户余额',dataIndex:'accountbalance',width:100,sortable:true,hidden:false,align: 'right',
			            
			            renderer: function(value){
			            		return ''+Ext.util.Format.number(value,'0,000.00')+'';
							}
						},
			            {header:'当前分配关系',dataIndex:'rela',width:150,sortable:true,hidden:false},
			            {header:'账户类型',dataIndex:'zhbs',width:100,sortable:true,hidden:false,
		            	renderer: function(value){
		            		if(value=='1'){
		            			return '对私';
		            		}else{
		            			return '对公';
		            		}
 						}
 						},
			            {header:'开户机构',dataIndex:'orgname',width:100,sortable:true,hidden:false},
			            {header:'客户名称',dataIndex:'customername',width:100,sortable:true,hidden:true},
			            {header:'销户日期',dataIndex:'logoffdate',width:100,sortable:true,hidden:false}
		           ]);
		IpasPerfobjDepositaccountGrid.superclass.constructor.call(this,{
			region: 'center',
			frame: true,
			height: height,
            viewConfig: {
                forceFit: false
            },
            loadMask: new Ext.LoadMask(document.body,{ 
				msg: '正在载入数据，请稍后...',
				store   : this.store
			}),
			sm: this.vsm,
			cm: this.vcm,
			tbar: this.vtbar,
			bbar: this.vbbar,
			ds: this.store,
            listeners: {
                "click": { fn: this.onClick, scope: this}//, 		//响应单击事件
                //"rowcontextmenu": {fn: this.onRightMenuClick, scope: this}  //响应右击事件
            }
		});
	},
	onClick: function(){
		//alert(123);
		var zhdh1 = ipasPerfobjDepositaccountGrid.getSelectionModel().getSelections()[0].data['accountcode'];
		var nbzh1 = ipasPerfobjDepositaccountGrid.getSelectionModel().getSelections()[0].data['nbzh'];
		areaOrgTree.store.baseParams={perfobjcode:zhdh1,nbzh:nbzh1,jsrq:'29991231'};
    	areaOrgTree.store.load({params:{start:0,limit:PAGESIZE}});
	},
	onAccountRelaDataClick: function(){
		var records = this.getSelectionModel().getSelections();
		if(records.length == 0) {
			Ext.Msg.alert('系统提示','请选择一条记录！');
		}else if(records.length == 1){
			if (!this.ipasSysBmaccountreladataWindow)
				this.ipasSysBmaccountreladataWindow = new IpasSysBmaccountreladataWindow();
			var perobjcode = ipasPerfobjDepositaccountGrid.getSelectionModel().getSelections()[0].data['accountcode'];
			var nbzh = ipasPerfobjDepositaccountGrid.getSelectionModel().getSelections()[0].data['nbzh'];
			ipasPerfobjDepositaccountGrid.ipasSysBmaccountreladataWindow.show();
			ipasPerfobjDepositaccountGrid.ipasSysBmaccountreladataWindow.ipasSysBmaccountreladataGrid.store.baseParams= {'perfobjcode':perobjcode,'nbzh':nbzh};
			ipasPerfobjDepositaccountGrid.ipasSysBmaccountreladataWindow.ipasSysBmaccountreladataGrid.store.load({params:{start:0,limit:PAGESIZE}});
		}else{
			Ext.Msg.alert('系统提示','不能查看多条记录！');
		}    	
    }
});

/**************IpasAssobjObjtypeWindow*********************/
IpasSysBmaccountreladataWindow = Ext.extend(Ext.Window,{
	constructor: function(grid){
		this.ipasSysBmaccountreladataGrid = new IpasSysBmaccountreladataGrid(400,900);
		IpasSysBmaccountreladataWindow.superclass.constructor.call(this,{
			title: '百分比明细',
			 width: 900,
			 anchor: '100%',
			autoHeight:true,
			resizable : false, //可变尺寸的；可调整大小的
			 plain: true,
			 modal: true,
			closeAction: 'hide',
			items:[this.ipasSysBmaccountreladataGrid]
		});
	}
});

/****************IpasAssobjObjtypeGrid***********************/
IpasSysBmaccountreladataGrid = Ext.extend(UxGrid,{
	constructor: function(height,width){
		
		var relafunctypeDictStore = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries', method: 'POST'}),
            reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}]))
        });
		relafunctypeDictStore.load({params: {dictTypeCode: 'RELAFUNCTYPE'}});
		
		this.store = new Ext.data.Store({
			proxy: new Ext.data.HttpProxy({url:'/dxgx/IpasDxgxHyyjgxCk/fetchPager',method:'POST'}),
			reader: new Ext.data.JsonReader({totalProperty:'total',root:'rows'},[
		            {name:'jgdh'},
		            {name:'name'},
		            {name:'hydh'},
		            {name:'userName'},
		            {name:'qsrq'},
		            {name:'jsrq'},
		            {name:'relafunctype'},
		            {name:'fpbl'},
		            {name:'zhdh'},
		            {name:'nbzh'}
					 ])
		});
		
		this.vtbar = new Ext.Toolbar({
			items: [
			       '-',{xtype:'button',text:'删除',iconCls:'delete',handler:this.onDeleteClick,scope:this}
			]
		});
		
		this.vbbar = this.createPagingToolbar(PAGESIZE);
		this.vsm = new Ext.grid.CheckboxSelectionModel();
		this.vcm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		             this.vsm,
		             {header:'机构代号',dataIndex:'zhdh',width:100,sortable:true,hidden:true},
		            {header:'机构代号',dataIndex:'jgdh',width:100,sortable:true,hidden:false},
		            {header:'所属机构',dataIndex:'name',width:100,sortable:true,hidden:false},
		            {header:'行员代号',dataIndex:'hydh',width:100,sortable:true,hidden:false},
		            {header:'客户经理',dataIndex:'userName',width:100,sortable:true,hidden:false},
		            {header:'起始日期',dataIndex:'qsrq',width:100,sortable:true,hidden:false},
		            {header:'结束日期',dataIndex:'jsrq',width:100,sortable:true,hidden:false},
		            {header:'分配关系',dataIndex:'relafunctype',width:100,sortable:true,hidden:false,
		            	renderer: 
		            		function(value) {
		            		var index = relafunctypeDictStore.findBy(function (record, id) {
		            			if (record.get('code') == value)
		            				return record.get('name');
		            	    });
		            		if (index == -1)
		            			return "百分比分配";
		            		return relafunctypeDictStore.getAt(index).get('name');
		            	}		
		            
		            },
		            {header:'分配比例',dataIndex:'fpbl',width:100,sortable:true,hidden:false}
		           ]);
		IpasSysBmaccountreladataGrid.superclass.constructor.call(this,{
			region: 'center',
			frame: true,
			height: height,
			width:width,
            viewConfig: {
                forceFit: false
            },
            loadMask: new Ext.LoadMask(document.body,{ 
				msg: '正在载入数据，请稍后...',
				store   : this.store
			}),
			sm: this.vsm,
			cm: this.vcm,
			tbar: this.vtbar,
			bbar: this.vbbar,
			ds: this.store
		});
	},
	onDeleteClick: function(){
    	var records = this.getSelectionModel().getSelections();
    	if(records.length>0){
    		if(records.length==1){
    			var endtime = parseInt(records[0].get('jsrq'));
    			if (endtime != 29991231) {
    				Ext.MessageBox.alert("系统提示：","只能删除结束时间为29991231的记录");
    				return;
    			}
    			
    			/*var stime = parseInt(records[0].get('qsrq'));
    			if (stime <= rq) {
    				Ext.MessageBox.alert("系统提示：","只能删除开始时间为今天的记录");
    				return;
    			}*/
    			
    			var params = {};
    			
    	    	params['perfobjcode'] = records[0].get('zhdh');
    	    	params['nbzh'] = records[0].get('nbzh');
    	    	params['begtime'] = records[0].get('qsrq');
    			Ext.Msg.confirm('系统提示：',"确定删除这次分配吗？",function(btn){
    			if(btn == 'yes'){
    				Ext.Ajax.request({
    					url: '/dxgx/IpasDxgxHyyjgxCk/deleteRela',
    					method: 'POST',
    					params: params,
    					success: function(response){
    						var obj=Ext.decode(response.responseText);
            				if(obj.success=='false' || obj.success==false){
            					Ext.Msg.alert('系统提示','只能删除当天分配的明细！');
            				}else{
	    						Ext.Msg.alert('系统提示','删除成功！');
	    						ipasPerfobjDepositaccountGrid.store.load({params:{start:0,limit:PAGESIZE}});
	    						ipasPerfobjDepositaccountGrid.ipasSysBmaccountreladataWindow.ipasSysBmaccountreladataGrid.store.load({params:{start:0,limit:PAGESIZE}});
	            		    }
            		    },
    					failure: function(response){
							Ext.MessageBox.alert("系统提示：","删除失败");
						}
    				});
    			}
    		});
    		} else {
    			Ext.Msg.alert('系统提示','一次只能删除一条记录！');
    		}
    	}else{
    		Ext.Msg.alert('系统提示','请选择一条记录！');
    	}
    }
});

/****************IpasAssobjObjtypeGrid***********************/
DistributeGrid = Ext.extend(Ext.grid.EditorGridPanel, {
	constructor: function(height,width){
		
	    this.forceFit=true;
		this.store = new Ext.data.Store({
			proxy: new Ext.data.HttpProxy({url:'/dxgx/IpasDxgxHyyjgxCk/fetchPager',method:'POST'}),
			reader: new Ext.data.JsonReader({totalProperty:'total',root:'rows'},[
			            {name:'jgdh'},
			            {name:'name'},
			            {name:'hydh'},
			            {name:'userName'},
			            {name:'qsrq'},
			            {name:'jsrq'},
			            {name:'relafunctype'},
			            {name:'fpbl'},
			            {name:'zhdh'},
			            {name:'nbzh'}
					 ])
		});
		this.vtbar = new Ext.Toolbar({
			items: [
			       '-',{xtype:'button',text:'选择行员',iconCls:'add',handler:function(){
			       	   areaOrgTree.store.removeAll();
			    	   var win = new OrgMemberWindow(function(org,member){
			    	   	for(var i=0;i<org.length;i++){
			    	   	   var str = org[i].split("-");
			    		   var u = new areaOrgTree.store.recordType({
			    			   jgdh : str[0],
			    			   name : str[1].trim(),
			    			   //assobjcode : member.id,
			    			   hydh : str[2],
			    			   userName: str[3],
			    			   fpbl : '100'
			    		   });
			    		   areaOrgTree.stopEditing();
			    		   var index = areaOrgTree.store.getCount();
			    		   areaOrgTree.store.insert(index, u);
			    		   areaOrgTree.startEditing(index, 4);
			    	   	}
			    	   });
			    	   win.show();
			       }}, 
			       '-',{xtype:'button',text:'删除',iconCls:'delete',handler:function(){
			    	   var records = areaOrgTree.getSelectionModel().getSelections();
				       	if(records.length>0){
				       		for(var i=0;i<records.length;i++){
				       			areaOrgTree.store.remove(records[i]);
					       	}
				       	}else{
				       		Ext.Msg.alert('系统提示','请选择一条记录！');
				       	}
			       }}, 
			       {xtype:'textfield',id:'perobjcodeId',hidden:true},
					'-',{xtype:'label',text:'分配日期'},{xtype:'datefield',format:'Ymd',id:'statisticsdate',editable : false},
//					'-',{xtype:'label',id:'latesttimelabel',text:'',cls:	'red'},
//					{xtype:'textfield',id:'latesttime',hidden:true},
			       '-',{xtype:'button',text:'确定分配',iconCls:'save',handler:function(){
			    	   var record1 = ipasPerfobjDepositaccountGrid.getSelectionModel().getSelections();
			    	   if(record1.length<=0){
			    		   Ext.Msg.alert('系统提示','请选择分配账户');
			    		   return false;
			    	   }
			    	   
			    	   var str="";
			    	   for(var i=0;i<record1.length;i++){
			    		   str=record1[i].get('accountcode')+"-"+record1[i].get('nbzh')+"-"+record1[i].get('customercode')+","+str;  
			    	   }
			    	 
			    	   var total = 0;
			    	   var params = {};
			    	   var begtime = 0;
			    	   
			    	   
			    	   if (Ext.getCmp('statisticsdate').getValue()!=""){
			    		   begtime = parseInt(Ext.getCmp('statisticsdate').getValue().format('Ymd'));
			    	   }else{
			    		   Ext.Msg.alert('系统提示','请选择分配日期。');
			    		   return false;
			    	   }
			    	   var index = 0;
			    	   areaOrgTree.store.each(function (record, id) {
			    		   		total += parseInt(record.get('fpbl'));
			    		   		params['params['+index+'][str]'] = str;
//			    		   		params['params['+index+'][perobjcode]'] = Ext.getCmp('perobjcodeId').getValue();
			    		   		params['params['+index+'][assobjcode]'] = record.get('hydh');
			    		   		params['params['+index+'][incrementsc]'] = record.get('fpbl');
			    		   		params['params['+index+'][begtime]'] = begtime;
			    		   		
			    		   		index++;
				    	    });
//			    	   if(parseInt(""+Ext.getCmp('latesttime').getValue()) >= begtime) {
//			    		   Ext.Msg.alert('系统提示','分配日期必须大于'+Ext.getCmp('latesttime').getValue());
//			    		   return;
//			    	   }
			    	   
			    	   if (total  == 100) {
			    	    		Ext.Msg.confirm('系统提示：',"确定分配吗？",function(btn){
			    	    			if(btn == 'yes'){
			    	    				var mask = new Ext.LoadMask(document.body,{msg : '正在加载,请稍后...' }); 
									    mask.show();
			    	    				Ext.Ajax.request({
			    	    					url: '/dxgx/IpasDxgxHyyjgxCk/saveDistribution',
			    	    					method: 'POST',
			    	    					timeout:120000,
			    	    					params: params,
			    	    					success: function(response){
			    	    						mask.hide(); 
			    	    						var obj=Ext.decode(response.responseText);
			    	            				if(obj.success=='false' || obj.success==false){
			    	            					//Ext.Msg.alert('系统提示','删除失败，请先删除最底层指标！');
			    	            					var msg = obj.message;
			    	            					 
			    	            					if(msg == '1'){
			    	            						Ext.Msg.alert('系统提示','系统还未设置当月工资结算时间，请联系管理员！');
			    	            					}else{
			    	            						var str = msg.split("|");
			    	            						if(str.length == 2){
			    	            							Ext.Msg.alert('系统提示','当月工资结算时间为'+str[0]+'到'+str[1]+',不能进行分配！');
			    	            						}else{
			    	            							Ext.Msg.alert('系统提示','分配时间必须大于等于当天！');
			    	            						}
			    	            						
			    	            					}
			    	            				}else{
				    	    						Ext.Msg.alert('系统提示','分配成功！');
				    	    						ipasPerfobjDepositaccountGrid.store.load({params:{start:0,limit:PAGESIZE}});
				    	    						areaOrgTree.store.removeAll();
			    	            				}
			    	    					},
			    	    					failure: function(){
			    	    						mask.hide(); 
			    	    						Ext.Msg.alert('系统提示','分配失败！');
			    	    					}
			    	    				});
			    	    			}
			    	    		});
			    	   } else {
			    		   Ext.Msg.alert('系统提示','分配比例之和必需等于100');
			    	   }
    	   			}
       			}
			]
		});
		this.vsm = new Ext.grid.CheckboxSelectionModel();
		this.vcm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		             this.vsm,
//		             {header:'机构',dataIndex:'assobjcode',width:100,sortable:true,hidden:true},
		             {header:'机构代号',dataIndex:'jgdh',width:100,sortable:true,hidden:true},
		            {header:'机构名称',dataIndex:'name',width:100,sortable:true,hidden:false},
		            {header:'行员号',dataIndex:'hydh',width:100,sortable:true,hidden:false},
		            {header:'行员',dataIndex:'userName',width:100,sortable:true,hidden:false},
		            {header:'分配比例',dataIndex:'fpbl',width:100,sortable:true,hidden:false,
		            	editor:new Ext.form.ComboBox({
       		            	editable: false,
       		            	displayField:'name',
					            valueField:'code',
					            store: new Ext.data.Store({
					         	   baseParams: {dictTypeCode:'FCBL'},
					               proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries', method: 'POST'}),
					               reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
					               autoLoad:true
					            }),
                            mode: 'local',
                            blankText:'全部',  
                            emptyText:'全部', 
                            triggerAction: 'all',
                            selectOnFocus: true,
                            allowBlank: false,
                            typeAhead: true
       		            })		
		            }
		           ]);
		DistributeGrid.superclass.constructor.call(this,{
			region: 'east',
			frame: true,
			height: height,
			width:width,
            viewConfig: {
                forceFit: false
            },
            loadMask: new Ext.LoadMask(document.body,{ 
				msg: '正在载入数据，请稍后...',
				store   : this.store
			}),
			tbar:this.vtbar,
			sm: this.vsm,
			cm: this.vcm,
			ds: this.store
		});
	}
});

QueryForm = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		
		this.khrqStr = new Ext.form.DateField({
			fieldLabel: '开户开始日期',
			id: 'khrqStr',
			format: 'Ymd',
			anchor: '95%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		var firstDayOfMonth = new Date();
		firstDayOfMonth.setDate(1);
		this.khrqStr.value = firstDayOfMonth.format('Ymd');
		this.khrqEnd = new Ext.form.DateField({
				fieldLabel: '开户截止日期',
				id: 'khrqEnd',
				format: 'Ymd',
				anchor: '95%',
				allowBlank: false,
				editable:false,//不能手动输入
				blankText: '请选择时间'
			});
		this.khrqEnd.value = new Date().format('Ymd');
		
		this.zhye = new Ext.form.TextField({
            fieldLabel: '余额',
            xtype: 'textfield',
            id: 'zhye',
            readOnly: false,
            anchor: '95%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /(^-[1-9]\d*$)|(^[1-9]\d*$)/
        }); 
		
		this.type = new Ext.form.ComboBox({
			id:'type',
        	autoLoad: true,
            fieldLabel: '余额关系',
            emptyText: '请选择...',
			anchor: '95%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'name',
			valueField:'code',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries?dictTypeCode=CXGX', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
                autoLoad:true
            }),
            editable : false
        });
		
        
		this.zhdh = new Ext.form.TextField({
            fieldLabel: '账号',
            id: 'zhdh1',
            xtype: 'textfield',
            readOnly: false,
            anchor: '95%'
        }); 
		this.zhmc = new Ext.form.TextField({
            fieldLabel: '账户名称',
            id: 'zhmc',
            xtype: 'textfield',
            readOnly: false,
            anchor: '95%'
        });
        
		this.rela = new Ext.form.ComboBox({
			id:'rela',
			autoLoad: true,
			fieldLabel: '分配状态',
			emptyText: '请选择...',
			anchor: '95%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'name',
			valueField:'code',
			store: new Ext.data.Store({
				proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries?dictTypeCode=YJFPZT', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
				autoLoad:true
			}),
			editable : false
		});
		
		this.zhlx = new Ext.form.ComboBox({
			id:'zhlx',
			autoLoad: true,
			fieldLabel: '账户类型',
			emptyText: '请选择...',
			anchor: '95%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'name',
			valueField:'code',
			store: new Ext.data.Store({
				proxy: new Ext.data.HttpProxy({url: '/dict/queryDictEntries?dictTypeCode=ZHLX', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'code'},{name:'name'}])),
				autoLoad:true
			}),
			editable : false
		});
		
        QueryForm.superclass.constructor.call(this, {
        	region: 'north',
	            anchor: '100%',
	            autoHeight:true,
	            labelWidth: 75,
	            labelAlign :'right',
	            frame: true,
	            bodyStyle:"padding: 2px 2px 0",
	            layout: 'tableform',
	            layoutConfig: {columns: 3},
	            items:[
					this.khrqStr,
					this.khrqEnd,
					this.rela,
					this.type,
					this.zhye,
					this.zhlx,
					this.zhdh,
					this.zhmc
	            ],
	            buttonAlign :'center',
	            buttons: [
	               {text: '查询', width: 20,iconCls: 'query', hidden: false,handler:this.queryFormClick,scope:this},
	               {text: '重置', width: 20, iconCls:'refresh',  handler: this.resetFormClick, scope: this}
	            ]
	        });
	},
	queryFormClick: function(){
		if(Ext.getCmp('zhye').getValue()!=''&&Ext.getCmp('type').getValue()==''){
 		   	  Ext.Msg.alert('系统提示','请选择查询关系');
 		   	  return false;
 		   }
 		   
 		   if(Ext.getCmp('zhye').getValue()==''&&Ext.getCmp('type').getValue()!=''){
 		   	  Ext.Msg.alert('系统提示','请输入账户余额');
 		   	  return false;
 		   }
 		   var khrqStr =  Ext.getCmp('khrqStr').getValue();
		   var khrqEnd =  Ext.getCmp('khrqEnd').getValue();
		   if(khrqStr == null || khrqStr == ''||khrqEnd == null || khrqEnd == ''){
		      Ext.Msg.alert('系统提示','请选择查询时间。');
			  return false;
		   }
		   if(khrqStr > khrqEnd){
			  Ext.Msg.alert('系统提示','截止日期应大于等于开始日期。');
			  return false;
		   }
  	   var params = {};
			if(Ext.getCmp('khrqStr').getValue() != '') {
				params['khrqStr'] = Ext.getCmp('khrqStr').getValue().format('Ymd');
			}
			if(Ext.getCmp('khrqEnd').getValue() != '') {
				params['khrqEnd'] = Ext.getCmp('khrqEnd').getValue().format('Ymd');
			}
			params['type']=Ext.getCmp('type').getValue();
			if(Ext.getCmp('rela').getValue()!=''&&Ext.getCmp('rela').getValue()!='未分配'){
 				params['rela'] = Ext.getCmp('rela').getValue();
 			}else{
 				params['rela'] ='is null';
 			}
 			if(Ext.getCmp('zhlx').getValue()!=''&&Ext.getCmp('zhlx').getValue()!='对公'){
 				params['zhlx'] = Ext.getCmp('zhlx').getValue();
 			}else{
 				params['zhlx'] = 2;
 			}
 			if(Ext.getCmp('zhye').getValue() != ''){
 				params['zhye'] = Ext.getCmp('zhye').getValue();
 			}
 			if(Ext.getCmp('zhdh1').getValue() != ''){
 				params['zhdh1'] = Ext.getCmp('zhdh1').getValue();
 			}
 			if(Ext.getCmp('zhmc').getValue() != ''){
 				params['zhmc'] = Ext.getCmp('zhmc').getValue();
 			}
			ipasPerfobjDepositaccountGrid.store.baseParams= params;
			ipasPerfobjDepositaccountGrid.store.load({params:{start:0,limit:PAGESIZE}});
	},
	resetFormClick: function(){
		Ext.getCmp('zhmc').setValue('');
		Ext.getCmp('zhye').setValue('');
		Ext.getCmp('type').setValue('');
		Ext.getCmp('zhlx').setValue('对公');
		Ext.getCmp('rela').setValue('未分配');
	}
});

/*************onReady组件渲染处理***********************/
Ext.onReady(function(){
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';        //提示方式"side"
    
    areaOrgTree = new DistributeGrid(400,420);
//    var zhdh1 =  document.getElementById("zhdh1").value;
    var zhdh1 =  '123';
    
    
    ipasPerfobjDepositaccountGrid = new IpasPerfobjDepositaccountGrid(Ext.getBody().getViewSize().height);
    ipasPerfobjDepositaccountGrid.store.baseParams= {zhdh:zhdh1};
    ipasPerfobjDepositaccountGrid.store.load({params:{start:0,limit:PAGESIZE}});
    
    var queryForm = new QueryForm();
    Ext.getCmp('zhlx').setValue('对公');
	Ext.getCmp('rela').setValue('未分配');
	
	var leftPanel=new Ext.Panel({
		region: 'center',
        layout:"border",
        items    : [ipasPerfobjDepositaccountGrid,queryForm]
    })
    
    
	new Ext.Viewport({
		layout:'border',
		items: [leftPanel
		        ,
		        areaOrgTree
		]
	});
});

