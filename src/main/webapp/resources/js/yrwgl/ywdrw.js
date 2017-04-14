var USER_GRID_STORE_URL = 'getYrwWdrwList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.rwmc = this.createTextField('任务名称', 'rwmc', '90%','',null,100,'长度超过不能50');
    	this.ssxm = this.createTextField('所属项目', 'ssxm', '90%','',null,100,'长度超过不能50');
    	this.rwlx = this.createTextField('任务类型', 'rwlx', '90%','',null,100,'长度超过不能50');
    	this.yqksrq =  new Ext.form.DateField({
			fieldLabel: '要求开始时间',
			name: "yqksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.yqjsrq =  new Ext.form.DateField({
			fieldLabel: '要求结束时间',
			name: "yqjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.sjksrq =  new Ext.form.DateField({
			fieldLabel: '实际开始时间',
			name: "sjksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.sjjsrq =  new Ext.form.DateField({
			fieldLabel: '<span style="color:red">*</span>实际结束时间',
			name: "sjjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.wcjd = this.createTextField('<span style="color:red">*</span>完成进度', 'wcjd', '90%','',null,100,'长度超过不能50');
    	this.rwfzr = this.createTextField('任务负责人', 'rwfzr', '90%','',null,100,'长度超过不能50');
    	this.rwly = this.createTextField('任务来源', 'rwly', '90%','',null,100,'长度超过不能50');
    	
        this.bgbh.allowBlank = true;
        this.rwmc.allowBlank = true;
        this.ssxm.allowBlank = true;
        this.rwlx.allowBlank = true;
        this.yqksrq.allowBlank = true;
        this.yqjsrq.allowBlank = true;
        this.sjksrq.allowBlank = true;
        this.sjjsrq.allowBlank = false;
        this.wcjd.allowBlank = false;
        this.rwfzr.allowBlank = true;
        this.rwly.allowBlank = true;
        
        this.bgbh.readOnly = true;
        this.yqksrq.readOnly = true;
        this.yqjsrq.readOnly = true;
        this.rwfzr.readOnly = true;
        this.rwly.readOnly = true;
        
        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bgbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.rwmc
                    ]  
                }),
            ]  
        });
        var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ssxm
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.rwlx
                       ]  
                   }), 
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yqksrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yqjsrq
                       ]  
                   }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sjksrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sjjsrq
                       ]  
                   }),
               ]  
        });
        var pnRow5=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.wcjd
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.rwfzr
                       ]  
                   }),
               ]  
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.rwly
                       ]  
                   }), 
               ]  
        });
        
        ConstructionForm.superclass.constructor.call(this, {
        	anchor: '80%',
        	autoHeight:true,
        	layoutConfig: {columns: 1},
        	labelWidth: 90,
            labelAlign :'right',
            frame:true,
            bodyStyle:"padding: 5px 5px 0",
            width: '100%',
            items: [
//                        this.idHidden,
						pnRow1,
						pnRow2,
						pnRow3,
						pnRow4,
						pnRow5,
						pnRow6
            ],
            buttonAlign :'center',
            buttons: [
//                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},
                      {text:'处理',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     updateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	 var record=constructionGrid.getSelectionModel().getSelections();
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'update', 
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理成功!" + BLANKSTR);
                 	constructionGrid.constructionUpdateWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});


/***************************************ActDealWindow组件**************************************************/
ActDealWindow = Ext.extend(Ext.Window,{
    constructor: function(grid) {
    	ActDealWindow.superclass.constructor.call(this, {
            width: 800,
            anchor: '100%',
            maximized :true,
            height: 400,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'close',
            html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src=""></iframe>'
        });
    }
});


/***************************************ConstructionUpdateWindow组件**************************************************/
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.constructionForm = new ConstructionForm();
//    	this.constructionForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionForm.buttons[1].show();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改任务信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionForm]
        });
    }
});
/**************************ConstructionGrid*******************************************/
ConstructionGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: USER_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
            {name:'ID'}, {name:'BGBH'}, {name:'RWMC'}, {name:'SSXM'}, {name:'RWLX'},
            {name:'YQKSRQ'}, {name:'YQJSRQ'}, {name:'SJKSRQ'}, {name:'SJJSRQ'}, {name:'WCJD'},
            {name:'RWFZR'}, {name:'RWLY'},{name:'CBZT'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{xtype:'label',text:'任务名称：'},
                '-',{xtype:'textfield',id:'code1',width: 120,emptyText:'任务名称...',},
                '-',{xtype:'label',text:'任务类型：'},
                '-',{xtype:'textfield',id:'code2',width: 120,emptyText:'任务类型...',},
                '-',{xtype:'label',text:'开始时间：'},
                '-',{xtype:'datefield',id:'code3',format: "Y-m-d",width: 100,emptyText:'开始时间...',},
                '-',{xtype:'label',text:'结束时间：'},
                '-',{xtype:'datefield',id:'code4',format: "Y-m-d",width: 100,emptyText:'结束时间...',},
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code1 = Ext.getCmp('code1').getValue();
      						var code2 = Ext.getCmp('code2').getValue();
      						var code3 = Ext.getCmp('code3').getValue();
      						var code4 = Ext.getCmp('code4').getValue();
      						constructionGrid.store.baseParams= {code1:code1,code2:code2,code3:code3,code4:code4};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				 }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code1').setValue("");
      	   				Ext.getCmp('code2').setValue("");
      	   				Ext.getCmp('code3').setValue("");
      	   				Ext.getCmp('code4').setValue("");
         			 }},
            ]
        });
   	
        this.constructionUpdateWindow = new ConstructionUpdateWindow();
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        ConstructionGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: false,
            height: height,
            viewConfig: {
                forceFit: false
            },
            loadMask: { 
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
                {header:'id',dataIndex:'ID',width:50,sortable: true,hidden:true},
                {header: '操作', width: 95, align:"center",sortable: true,hidden: false,
  					renderer:function(value, cellmeta, record){
  						if(record.get("SJJSRQ") != null || record.get("CBZT") == 0 ){
  					return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                   "<span style='width: 25px;color:grey;'>处理</span></a>&nbsp;&nbsp;&nbsp"+
                           "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
                           "<span style='width: 25px;cursor: pointer;'>删除</span></a>";
              		}else{
              		return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
                           "<span style='width: 25px;'>处理</span></a>&nbsp;&nbsp;&nbsp"+
			               "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
                           "<span style='width: 25px;cursor: pointer;'>删除</span></a>";
           						}
  						}
  				},
            	{header:'报告编号',dataIndex:'BGBH',width:120,sortable: true},
                {header:'任务名称',dataIndex:'RWMC',width:100,sortable: true},
                {header:'所属项目',dataIndex:'SSXM',width:120,sortable: true},
                {header:'任务类型',dataIndex:'RWLX',width:100,sortable: true},
                {header:'要求开始日期',dataIndex:'YQKSRQ',width:100,sortable: true},
                {header:'要求结束日期',dataIndex:'YQJSRQ',width:100,sortable: true},
                {header:'实际开始日期',dataIndex:'SJKSRQ',width:100,sortable: true},
                {header:'实际结束日期',dataIndex:'SJJSRQ',width:100,sortable: true},
                {header:'完成进度',dataIndex:'WCJD',width:80,sortable: true},
                {header:'任务负责人',dataIndex:'RWFZR',width:150,sortable: true},
                {header:'任务来源',dataIndex:'RWLY',width:80,sortable: true},
                {header:'是否督办',dataIndex:'CBZT',width:80,sortable: true,hidden:true,
                	renderer:function(value){
                        if(value == '0') {
                            return "<span style=color:red>是</span>";
                        }else if(value == '1') {
                            return "<span>否</span>";
                        }else{
                        	return value;
                        }
                	 }
                }
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            }
        });
    },
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	win.show();
    },
    
    onModifyClick: function() {         //处理
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
//   		    	win.constructionForm.getForm().loadRecord(vrecord);
   		    	win.show();
   		    	win.constructionForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.constructionForm.rwmc.setValue(vrecord.data.RWMC);
   		    	win.constructionForm.ssxm.setValue(vrecord.data.SSXM);
   		    	win.constructionForm.rwlx.setValue(vrecord.data.RWLX);
   		    	win.constructionForm.yqksrq.setValue(vrecord.data.YQKSRQ);
   		    	win.constructionForm.yqjsrq.setValue(vrecord.data.YQJSRQ);
   		    	win.constructionForm.sjksrq.setValue(vrecord.data.SJKSRQ);
   		    	win.constructionForm.sjjsrq.setValue(vrecord.data.SJJSRQ);
   		    	win.constructionForm.wcjd.setValue(vrecord.data.WCJD);
   		    	win.constructionForm.rwfzr.setValue(vrecord.data.RWFZR);
   		    	win.constructionForm.rwly.setValue(vrecord.data.RWLY);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    onDeleteClick: function() {
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
				               constructionGrid.store.reload();
			               },
			               failure: function(form, action) {
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除失败!" + BLANKSTR);
			               }
				       	});					
				}
	    	});	
    	}else{
    		 Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
         	return;
    	}
    },
    
    sheetNoChange: function(value) {
    	return '<a href="javascript:void(0)" onclick=javascript:clickSheetNo('+value+')><b><font color=red>'+ value + '</font></b></a>';
    },
    clickSheetNo: function() {
    	alert(11);
    },
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
    },
    refresh: function(){
        this.getView().refresh();
    },
    remove:function(record){
        this.getStore().remove(record);
    },
    formatTime : function(val) {
    		var valStr = val.constructor == Date ? Ext.util.Format.date(val, 'Y-m-d H:i:s') : formatDate(new Date(val["time"]),"yyyy-MM-dd HH:mm:ss");    		
    		var valArr = valStr.split('-');
    		var valDate = new Date(valArr[0], valArr[1] - 1, valArr[2]);
    		return valStr;
    }
});


/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';

    constructionGrid = new ConstructionGrid(Ext.getBody().getViewSize().height-160, Ext.getBody().getViewSize().width);
    constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    new Ext.Viewport({
    	layout: 'border',
    	items:[
		//conditionForm,
		constructionGrid
    	]
    });
});

