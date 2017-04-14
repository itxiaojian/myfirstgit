var USER_GRID_STORE_URL = 'getDaLmglList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	this.lmmc = this.createTextField('类目名称', 'lmmc', '90%','',null,100,'长度超过不能50');
    	    	
    	this.lmjb = this.createTextField('类目级别', 'lmjb', '90%','',null,100,'长度超过不能50');
    	
//    	this.ssjgid = this.createTextField('所属机构id', 'ssjgid', '90%','',null,100,'长度超过不能50');
    	
//    	this.ssjgmc = this.createTextField('所属机构', 'ssjgmc', '90%','',null,100,'长度超过不能50');
    	
    	this.ssjgmc = new zjyw.OrgSingelSelectAll('所属机构','ssjgmc','ssjgmc','90%');
    	
//    	//做下拉框
//    	this.sbjb = this.createCombo('设备级别', 'ZDMC', 'ZDMC', 'sbjb', '90%', PROJECT_NAME+'/sbgl/YSbSg/getDicByLx');
//		this.sbjb.store.load();
//		this.sbjb.allowBlank = false;
    	
    	this.yjlmid = this.createTextField('一级类目', 'yjlmid', '90%','',null,100,'长度超过不能11');
		
    	this.sjlmid = this.createTextField('上级类目', 'sjlmid', '90%','',null,100,'长度超过不能11');
    	
//    	this.flyid = this.createTextField('管理员id', 'flyid', '90%','',null,100,'长度超过不能11');
    	
    	this.glyxm = this.createTextField('管理员', 'glyxm', '90%','',null,100,'长度超过不能100');
    	
//    	this.cjrid = this.createTextField('创建人id', 'cjrid', '90%','',null,200,'长度超过不能200');
    	
    	this.cjrxm = this.createTextField('创建人', 'cjrxm', '90%','',null,150,'长度超过不能11');
    	
    	this.lmpx = this.createTextField('类目排序', 'lmpx', '90%','',null,180,'长度超过不能50');
//    	
//    	this.kckrid = this.createTextField('可查看人id', 'kckrid', '90%','',null,150,'长度超过不能11');
   
    	this.kckrxm = this.createTextField('可查看人', 'kckrxm', '90%','',null,160,'长度超过不能50');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
        this.lmmc.allowBlank = false;
        this.lmjb.allowBlank = false;
        this.ssjgmc.allowBlank = false;
        this.yjlmid.allowBlank = false;
        this.sjlmid.allowBlank = false;
//        this.flyid.allowBlank = false;
        this.glyxm.allowBlank = false;
//        this.cjrid.allowBlank = false;
        this.cjrxm.allowBlank = false;
//        this.kckrid.allowBlank = false;
        this.kckrxm.allowBlank = false;
        this.lmpx.allowBlank = false;
        this.bz.allowBlank = true;
        

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
                        this.lmmc
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.lmjb
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
                           this.lmpx
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ssjgmc
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
                         this.yjlmid
                   ]  
                   }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.sjlmid
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
                      this.cjrxm
                      ]  
                  }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.glyxm
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
                           this.kckrxm
                       ]  
                   }),
               ] 
        });
        var pnRow6=new Ext.Panel({  
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
						pnRow4,
						pnRow5,
						pnRow6,
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {
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


/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionForm.buttons[1].hide();   //显示修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "档案信息新增",
            width: 800,
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
	constructionForm : null,
    constructor: function() {
    	this.constructionForm = new ConstructionForm();
    	this.constructionForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionForm.buttons[1].show();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改档案信息",
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
                            {name:'ID'},{name:'LMMC'},{name:'LMJB'},{name:'SSJGMC'},{name:'SSKGID'},{name:'YJLMID'},
                            {name:'SJLMID'},{name:'GLYXM'},{name:'FLYID'},{name:'CJRXM'},{name:'CJRID'},{name:'KCKRID'},
                            {name:'KCKRXM'},{name:'LMPX'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'类目名称...',  
               	    },
    	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			  }
                  },
            ]
        });
   	
        this.constructionInsertWindow = new ConstructionInsertWindow();       
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
                {header:'id',dataIndex:'ID',width:70,sortable: true, hidden:true},
                {header:'类目名称',dataIndex:'LMMC',width:100,sortable: true},
            	{header:'类目级别',dataIndex:'LMJB',width:80,sortable: true},
            	{header:'所属机构id',dataIndex:'SSJGID',width:80,sortable: true, hidden:true},
            	{header:'所属机构',dataIndex:'SSJGMC',width:100,sortable: true},
            	{header:'类目排序',dataIndex:'LMPX',width:80,sortable: true, hidden:true},
            	{header:'一级类目',dataIndex:'YJLMID',width:80,sortable: true},
            	{header:'上级类目',dataIndex:'SJLMID',width:80,sortable: true},
            	{header:'管理员id',dataIndex:'FLYID',width:80,sortable: true, hidden:true},
            	{header:'管理员姓名',dataIndex:'GLYXM',width:80,sortable: true},
            	{header:'创建人id',dataIndex:'CJRID',width:80,sortable: true, hidden:true},
            	{header:'创建人姓名',dataIndex:'CJRXM',width:80,sortable: true, hidden:true},
            	{header:'可查看人ID',dataIndex:'KCKRID',width:90,sortable: true, hidden:true},
            	{header:'可查看人',dataIndex:'KCKRXM',width:100,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:80,sortable: true},
            	{header : '操作',width : 120,dataIndex : 'sbbh',align : "center",sortable : true,hidden : false,renderer : function(value,cellmeta,record)

					{
						return ""
								+ ""+
								"<a href='javascript:;' onclick='constructionGrid. onModifyClick()' style='text-decoration:none;'>"
								+ "<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
				"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
				"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>";
					}

				},
            	
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
                
            }
        });
    },
//	点击增加按钮弹出jsp页面
	  onAddClick: function() {
	    	var win = this.constructionInsertWindow;
//	    	win.constructionForm.getForm().reset();
	    	var url = "dalmAddView?id="+id;  	
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("类目管理信息增加");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
	    },
	    
	    onLook: function() {
			var records = this.getSelectionModel().getSelections();
			var id=records[0].get('ID');
			var url = "dalmLookView?id="+id;  	
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("类目管理信息");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
		},
    
		 onModifyClick: function() {
		    	var records=this.getSelectionModel().getSelections();
		   		if(records.length > 0) {
		   			if(records.length == 1){
		   				vrecord = records[0];
		   			}else{
		   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
		   			}
		   		}else{
		   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
		   		}    
		   		var id=records[0].get('ID');
				var url = "dalmXgView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("类目管理信息修改");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();
		    },
		    
//		    onModifyClick: function() {
//		    	var records=this.getSelectionModel().getSelections();
//		   		if(records.length > 0) {
//		   			if(records.length == 1){
//		   				vrecord = records[0];
//		   		    	var win = this.constructionUpdateWindow;
//		   		    	win.show();
//		   		    	win.constructionForm.lmmc.setValue(vrecord.data.LMMC);
//		   		    	win.constructionForm.lmjb.setValue(vrecord.data.LMJB);
//		   		    	win.constructionForm.ssjgid.setValue(vrecord.data.SSJGID);
//		   		    	win.constructionForm.ssjgmc.setValue(vrecord.data.SSJGMC);
//		   		    	win.constructionForm.yjlmid.setValue(vrecord.data.YJLMID);
//		   		    	win.constructionForm.sjlmid.setValue(vrecord.data.SJLMID);
//		   		    	win.constructionForm.flyid.setValue(vrecord.data.FLYID);
//		   		    	win.constructionForm.glyxm.setValue(vrecord.data.GLYXM);
//		   		    	win.constructionForm.cjrid.setValue(vrecord.data.CJRID);
//		   		    	win.constructionForm.cjrxm.setValue(vrecord.data.CJRXM);
//		   		    	win.constructionForm.kckrid.setValue(vrecord.data.KCKRID);
//		   		    	win.constructionForm.kckrxm.setValue(vrecord.data.KCKRXM);
//		   		    	win.constructionForm.lmpx.setValue(vrecord.data.LMPX);
//		   		    	win.constructionForm.bz.setValue(vrecord.data.BZ);
//
//		   			}else{
//		   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
//		   			}
//		   		}else{
//		   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
//		   		}    	
//		    },
	    
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
    onOpenClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				var valueStr = records[0].get('ID');
   				var valueStatue = records[0].get('processStatus');
   				if(valueStatue == '2'){
   					Ext.Msg.alert('系统提示', '流程已经启动！');
   				}else if(valueStatue == '3'){
   					Ext.Msg.alert('系统提示', '流程已经结束！');
   				}else{
	   				Ext.Msg.confirm("提醒信息", "确定要启动此流程吗?",function(btn){
	   					if (btn == 'yes') {
	   				       	Ext.Ajax.request({
	   				       		url: 'openTestProcess', 
	   					       	   method : 'POST', 
	   					       	   params: { id: valueStr},
	   				               success: function(form, action) {
	   					               Ext.MessageBox.alert("系统提示:", BLANKSTR + "启动成功!" + BLANKSTR);
	   					               constructionGrid.store.reload();
	   				               },
	   				               failure: function(form, action) {
	   				            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "启动失败!" + BLANKSTR);
	   				               }
	   					       	});					
	   					}
	   		    	});
   				}
   			}else{
   				Ext.Msg.alert('系统提示', '不能开启多条流程..');
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
    		var valStr = val.constructor == Date ? Ext.util.Format.date(val, 'Y-m-d') : formatDate(new Date(val["time"]),"yyyy-MM-dd HH:mm:ss");    		
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