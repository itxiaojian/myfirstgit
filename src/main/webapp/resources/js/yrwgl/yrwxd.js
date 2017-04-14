var USER_GRID_STORE_URL = 'getYrwxdList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '90%','',null,100,'长度超过不能50');
    	this.wtdw = this.createTextField('委托单位', 'wtdw', '90%','',null,100,'长度超过不能50');
    	this.yplx = this.createTextField('样品类型', 'yplx', '90%','',null,100,'长度超过不能50');
    	this.jylx = this.createTextField('检验类型', 'jylx', '90%','',null,100,'长度超过不能50');
    	this.jyks = this.createTextField('检验科室', 'jyks', '90%','',null,100,'长度超过不能50');
    	this.djry = this.createTextField('收样人', 'djry', '90%','',null,100,'长度超过不能50');
    	this.lxr = this.createTextField('联系人', 'lxr', '90%','',null,100,'长度超过不能50');
    	this.dh = this.createTextField('联系电话', 'dh', '90%','',null,100,'长度超过不能50');
    	this.rwxarq =  new Ext.form.DateField({
			fieldLabel: '任务下达日期',
			name: "rwxarq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.yqwcrq =  new Ext.form.DateField({
			fieldLabel: '要求完成日期',
			name: "yqwcrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	this.bgbh.allowBlank = true;
        this.ypmc.allowBlank = true;
        this.wtdw.allowBlank = true;
        this.yplx.allowBlank = true;
        this.jylx.allowBlank = true;
        this.jyks.allowBlank = true;
        this.djry.allowBlank = true;
        this.lxr.allowBlank = true;
        this.dh.allowBlank = true;
        this.rwxarq.allowBlank = true;
        this.yqwcrq.allowBlank = true;
        
        this.bgbh.readOnly = true;
        this.ypmc.readOnly = true;
        this.wtdw.readOnly = true;
        this.yplx.readOnly = true;
        this.jylx.readOnly = true;
        this.jyks.allowBlank = true;
        this.djry.readOnly = true;
        this.lxr.readOnly = true;
        this.dh.readOnly = true;
        this.rwxarq.readOnly = true;
        this.yqwcrq.readOnly = true;

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
                        this.ypmc
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
                           this.wtdw
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yplx
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
                           this.jylx
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyks
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
                           this.lxr
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dh
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
					        this.djry
					    ]  
					}),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.rwxarq
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
                           this.yqwcrq
                       ]  
                   }),
               ]  
        });
        
        LookForm.superclass.constructor.call(this, {
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
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** AssignForm组件 **************************************************/
AssignForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '90%','',null,100,'长度超过不能50');
    	this.wtdw = this.createTextField('委托单位', 'wtdw', '90%','',null,100,'长度超过不能50');
    	this.yplx = this.createTextField('样品类型', 'yplx', '90%','',null,100,'长度超过不能50');
    	this.jylx = this.createTextField('检验类型', 'jylx', '90%','',null,100,'长度超过不能50');
    	this.jyks = this.createTextField('检验科室', 'jyks', '90%','',null,100,'长度超过不能50');
    	this.djry = this.createTextField('收样人', 'djry', '90%','',null,100,'长度超过不能50');
    	this.lxr = this.createTextField('联系人', 'lxr', '90%','',null,100,'长度超过不能50');
    	this.dh = this.createTextField('联系电话', 'dh', '90%','',null,100,'长度超过不能50');
    	this.yqwcrq =  new Ext.form.DateField({
			fieldLabel: '<span style=color:red>*</span>要求完成日期',
			name: "yqwcrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	this.bgbh.allowBlank = true;
        this.ypmc.allowBlank = true;
        this.wtdw.allowBlank = true;
        this.yplx.allowBlank = true;
        this.jylx.allowBlank = true;
        this.jyks.allowBlank = true;
        this.djry.allowBlank = true;
        this.lxr.allowBlank = true;
        this.dh.allowBlank = true;
        this.yqwcrq.allowBlank = false;
        
        this.bgbh.readOnly = true;
        this.ypmc.readOnly = true;
        this.wtdw.readOnly = true;
        this.yplx.readOnly = true;
        this.jylx.readOnly = true;
        this.jyks.readOnly = true;
        this.djry.readOnly = true;
        this.lxr.readOnly = true;
        this.dh.readOnly = true;
        


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
                        this.ypmc
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
                           this.wtdw
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yplx
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
                           this.jylx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyks
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
                           this.lxr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dh
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
					        this.djry
					    ]  
					}),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yqwcrq
                       ]  
                   }),
               ]  
        });
        
        AssignForm.superclass.constructor.call(this, {
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
						pnRow5
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '分配', width: 20,iconCls:'submit', hidden: false, handler: this.addFormClick, scope: this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {       //分配
         if(this.getForm().isValid()) {
        	var record=constructionGrid.getSelectionModel().getSelections();
        	vrecord = record[0];
//        	var bgbh = this.bgbh.getValue();
//        	alert(bgbh);
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'submit', 
                 method: 'POST',
                 params:{
//                	 rwbh:record[0].get('bgbh'),
                   },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "分配成功!" + BLANKSTR);
                 	constructionGrid.constructionAssignWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "分配失败!" + BLANKSTR);
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

/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "任务指派信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.lookForm]
        });
    }
});

/***************************************ConstructionAssignWindow组件**************************************************/
ConstructionAssignWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.assignForm = new AssignForm();
    	ConstructionAssignWindow.superclass.constructor.call(this, {
        	title: "任务指派",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.assignForm]
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
            {name:'ID'}, {name:'BGBH'}, {name:'YPMC'}, {name:'WTDW'}, {name:'YPLX'},
            {name:'JYLX'},{name:'JYKS'},{name:'DJRY'}, {name:'LXR'}, {name:'DH'}, {name:'RWXARQ'}, 
            {name:'YQWCRQ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                   '-',{xtype:'label',text:'检验编号：'},
                   '-',{xtype:'textfield',id:'code1',width: 120,emptyText:'检验编号...',},
                   '-',{xtype:'label',text:'保管人：'},
                   '-',{xtype:'textfield',id:'code2',width: 120,emptyText:'保管人...',},
                   '-',{xtype:'label',text:'委托单位：'},
                   '-',{xtype:'datefield',id:'code3',width: 100,emptyText:'委托单位...',},
                   '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
                   				var code1 = Ext.getCmp('code1').getValue();
                   				var code2 = Ext.getCmp('code2').getValue();
                   				var code3 = Ext.getCmp('code3').getValue();
                   				constructionGrid.store.baseParams= {code1:code1,code2:code2,code3:code3};
                   				constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
                   		 }},
                   '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
                   				Ext.getCmp('code1').setValue("");
                   				Ext.getCmp('code2').setValue("");
                   				Ext.getCmp('code3').setValue("");
                   		 }},
            ]
        });
   	
        this.constructionAssignWindow = new ConstructionAssignWindow();
        this.constructionLookWindow = new ConstructionLookWindow();
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
                {header:'序号',dataIndex:'ID',width:50,sortable: true,hidden:true},
                {header: '操作', width: 95, align:"center",sortable: true,hidden: false,
 					renderer:function(value, cellmeta, record){
 						if(record.get("YQWCRQ") == null && record.get("RWXARQ") == null){
 					return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
 					   	   "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
 					   	   "<a href='javascript:;' onclick='constructionGrid.onAssignClick()' style='text-decoration:none;'>"+
 					   	   "<span style='width: 26px;cursor: pointer;'>分配</span></a>";
             		}else{
             		return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
				   	       "&nbsp&nbsp&nbsp<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
      			           "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
      			           "<span style='width: 25px;color:grey;'>分配</span></a>&nbsp;&nbsp;&nbsp";
          						}
 						}
 				},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
                {header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
                {header:'委托单位',dataIndex:'WTDW',width:120,sortable: true},
                {header:'样品类型',dataIndex:'YPLX',width:80,sortable: true},
                {header:'检验类型',dataIndex:'JYLX',width:120,sortable: true},
                {header:'检验科室',dataIndex:'JYKS',width:120,sortable: true},
                {header:'收样人',dataIndex:'DJRY',width:80,sortable: true},
                {header:'联系人',dataIndex:'LXR',width:80,sortable: true},
                {header:'联系电话',dataIndex:'DH',width:100,sortable: true},
                {header:'任务下达时间',dataIndex:'RWXARQ',width:120,sortable: true},
                {header:'要求完成日期',dataIndex:'YQWCRQ',width:120,sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
                //"dblclick": { fn: this.onModifyClick, scope: this}, 		//响应双击事件
                //"rowcontextmenu": {fn: this.onRightMenuClick, scope: this}  //响应右击事件
            }
        });
    },
    onAssignClick: function() {                  //分配
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionAssignWindow;
   		    	win.show();
   		    	win.assignForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.assignForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.assignForm.wtdw.setValue(vrecord.data.WTDW);
   		    	win.assignForm.yplx.setValue(vrecord.data.YPLX);
   		    	win.assignForm.jylx.setValue(vrecord.data.JYLX);
   		    	win.assignForm.jyks.setValue(vrecord.data.JYKS);
   		    	win.assignForm.djry.setValue(vrecord.data.DJRY);
   		    	win.assignForm.lxr.setValue(vrecord.data.LXR);
   		    	win.assignForm.dh.setValue(vrecord.data.DH);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    onLookClick: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.show();
   		    	win.lookForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.lookForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.lookForm.wtdw.setValue(vrecord.data.WTDW);
   		    	win.lookForm.yplx.setValue(vrecord.data.YPLX);
   		    	win.lookForm.jylx.setValue(vrecord.data.JYLX);
   		    	win.lookForm.jyks.setValue(vrecord.data.JYKS);
   		    	win.lookForm.djry.setValue(vrecord.data.DJRY);
   		    	win.lookForm.lxr.setValue(vrecord.data.LXR);
   		    	win.lookForm.dh.setValue(vrecord.data.DH);
   		    	win.lookForm.rwxarq.setValue(vrecord.data.RWXARQ);
   		    	win.lookForm.yqwcrq.setValue(vrecord.data.YQWCRQ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
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