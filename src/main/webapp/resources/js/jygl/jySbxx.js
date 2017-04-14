var USER_GRID_STORE_URL = 'getJysbxxList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.bgbh = new Ext.form.TextField({
            fieldLabel: '报告编号',
            name: 'bgbh',
            anchor: '100%'
        });
    	this.sbbh = new Ext.form.TextField({
            fieldLabel: '设备编号',
            name: 'sbbh',
            anchor: '100%'
        });
    	this.dw = new Ext.form.TextField({
            fieldLabel: '单位',
            name: 'dw',
            anchor: '100%'
        });
    	this.sysl = new Ext.form.NumberField({
            fieldLabel: '数量',
            name: 'sysl',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            nanText: "请输入有效的整数",
            allowDecimals:false,
            hidden:false
        });
    	this.syrq =  new Ext.form.DateField({
			fieldLabel: '使用日期',
			name: "syrq",
			format: "Y-m-d",
			anchor: '100%',
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.syqzt = new Ext.form.TextField({
            fieldLabel: '使用前状态',
            name: 'syqzt',
            anchor: '100%'
        });
    	this.syhzt = new Ext.form.TextField({
            fieldLabel: '使用后状态',
            name: 'syhzt',
            anchor: '100%'
        });
    	this.syhj = new Ext.form.TextField({
            fieldLabel: '使用环境',
            name: 'syhj',
            anchor: '100%'
        });
    	this.syr = new Ext.form.TextField({
            fieldLabel: '使用人',
            name: 'syr',
            anchor: '100%'
        });
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '90%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.bgbh.allowBlank = false;
    	this.sbbh.allowBlank = false;
    	this.dw.allowBlank = false;
    	this.sysl.allowBlank = false;
    	this.syrq.allowBlank = false;
    	this.syqzt.allowBlank = false;
    	this.syhzt.allowBlank = false;
    	this.syhj.allowBlank = false;
    	this.syr.allowBlank = false;
    	this.bz.allowBlank = false;
    	

//    	this.ypbh.readOnly = true;
 
        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bgbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.sbbh
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.dw
                    ]  
                }),
            ]  
        });
        
        var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sysl
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.syrq
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.syqzt
                       ]  
                   }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.syhzt
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.syhj
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.syr
                       ]  
                   }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:1,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bz
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
						pnRow1,
						pnRow2,
						pnRow3,
						pnRow4
            ],
            buttonAlign :'center',
            buttons: [
					  {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
					  {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {     //增加
         if(this.getForm().isValid()) {
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'save', 
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.constructionInsertWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
                 }
         	});
         }
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
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	constructionGrid.constructionUpdateWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});
/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionForm.buttons[1].hide();   //显示修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "检验设备新增信息",
            width: 1000,
            anchor: '100%',
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

/***************************************ConstructionUpdateWindow组件**************************************************/
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[1].show();   //隐藏添加按钮
    	this.constructionForm.buttons[0].hide();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "检验设备修改信息",
            width: 1000,
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
                            {name:'ID'},{name:'BGBH'},{name:'SBBH'},{name:'DW'},{name:'SYSL'},{name:'SYRQ'},
                            {name:'SYQZT'},{name:'SYHZT'},{name:'SYHJ'},{name:'SYR'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'canshu',width: 250,
                	   emptyText:'报告编号&&设备编号...',  
               	    },
    	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var canshu = Ext.getCmp('canshu').getValue();
      						constructionGrid.store.baseParams= {canshu:canshu};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('canshu').setValue("");
         			  }
                  },
            ]
        });
    	this.constructionInsertWindow = new ConstructionInsertWindow();
    	this.constructionUpdateWindow = new ConstructionUpdateWindow();
//    	this.constructionLookWindow = new ConstructionLookWindow();
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
            	{header:'序号',dataIndex:'ID',width:100,sortable: true, hidden:true},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
                {header:'设备编号',dataIndex:'SBBH',width:100,sortable: true},
            	{header:'单位',dataIndex:'DW',width:100,sortable: true},
            	{header:'使用数量',dataIndex:'SYSL',width:100,sortable: true},
            	{header:'使用日期',dataIndex:'SYRQ',width:100,sortable: true},
            	{header:'使用前状态',dataIndex:'SYQZT',width:100,sortable: true,
            		renderer:function(value){
                		if(value == '0') {
                			return "<span style='color:blue;'>良好</span>";
                		}else if(value == '1') {
                			return "<span style='color:red;'>损坏</span>";
                		}else{
                			return value;
                		}
                	}
                },
            	{header:'使用后状态',dataIndex:'SYHZT',width:100,sortable: true,
                	renderer:function(value){
                		if(value == '0') {
                			return "<span style='color:blue;'>良好</span>";
                		}else if(value == '1') {
                			return "<span style='color:red;'>损坏</span>";
                		}else{
                			return value;
                		}
                	}
                },
            	{header:'使用环境',dataIndex:'SYHJ',width:100,sortable: true},
            	{header:'使用人',dataIndex:'SYR',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onAddClick: function() {           //增加
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	win.show();
    },
    
    onModifyClick: function() {         //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
   		    	win.constructionForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.constructionForm.sbbh.setValue(vrecord.data.SBBH);
   		    	win.constructionForm.dw.setValue(vrecord.data.DW);
   		    	win.constructionForm.sysl.setValue(vrecord.data.SYSL);
   		    	win.constructionForm.syrq.setValue(vrecord.data.SYRQ);
   		    	win.constructionForm.syqzt.setValue(vrecord.data.SYQZT);
   		    	win.constructionForm.syhzt.setValue(vrecord.data.SYHZT);
   		    	win.constructionForm.syhj.setValue(vrecord.data.SYHJ);
   		    	win.constructionForm.syr.setValue(vrecord.data.SYR);
   		    	win.constructionForm.bz.setValue(vrecord.data.BZ);
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
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
			               }
				       	});					
				}
	    	});	
    	}else{
    		 Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
         	return;
    	}
    },
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