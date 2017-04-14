var USER_GRID_STORE_URL = 'getSbsgList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.sgbh = this.createTextField('申购编号', 'sgbh', '90%','',null,100,'长度超过不能50');
    	    	
    	this.sbmc = this.createTextField('设备名称', 'sbmc', '90%','',null,100,'长度超过不能50');
    	
    	this.sblx = this.createTextField('设备类型', 'sblx', '90%','',null,100,'长度超过不能50');
    	
    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
    	
//    	this.sbjb = this.createTextField('设备级别', 'sbjb', '90%','',null,100,'长度超过不能50');
    	
    	//做下拉框
    	this.sbjb = this.createCombo('设备级别', 'ZDMC', 'ZDMC', 'sbjb', '90%', PROJECT_NAME+'/sbgl/YSbSg/getDicByLx');
		this.sbjb.store.load();
		this.sbjb.allowBlank = false;
    	
//    	this.syks = this.createTextField('使用科室', 'syks', '90%','',null,100,'长度超过不能11');
		
		this.syks = new zjyw.OrgSingelSelectAll('使用科室','syks','syks','90%');
    	
    	this.syfw = this.createTextField('使用范围', 'syfw', '90%','',null,100,'长度超过不能11');
    	
    	this.sccj = this.createTextField('生产厂家', 'sccj', '90%','',null,100,'长度超过不能11');
    	
    	this.sgrq =  new Ext.form.DateField({
			fieldLabel: '申购日期',
			name: "sgrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.sgjg = this.createTextField('申购价格', 'sgjg', '90%','',null,100,'长度超过不能100');
    	
    	this.sbsgr = this.createTextField('设备申购人', 'sbsgr', '90%','',null,200,'长度超过不能200');
    	
    	this.dhyqsj =  new Ext.form.DateField({
			fieldLabel: '到货要求时间',
			name: "dhyqsj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
//    	this.spyj = this.createTextField('审批意见', 'spyj', '90%','',null,150,'长度超过不能11');
//    	
//    	this.spr = this.createTextField('审批人', 'spr', '90%','',null,150,'长度超过不能11');
//    	
//    	this.spsj =  new Ext.form.DateField({
//			fieldLabel: '审批时间',
//			name: "spsj",
//			format: "Y-m-d",
//			anchor: '90%',
//			allowBlank: false,
//			editable:false,//不能手动输入
//			blankText: '请选择时间'
//		});
   
//    	this.bz = this.createTextField('备注', 'bz', '95%','',null,160,'长度超过不能50');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
        this.sgbh.allowBlank = false;
        this.sbmc.allowBlank = false;
        this.sblx.allowBlank = false;
        this.sbxh.allowBlank = false;
        this.sbjb.allowBlank = false;
        this.syks.allowBlank = false;
        this.syfw.allowBlank = false;
        this.sccj.allowBlank = false;
        this.sgrq.allowBlank = false;
        this.sgjg.allowBlank = false;
        this.sbsgr.allowBlank = false;
        this.dhyqsj.allowBlank = false;
//        this.spyj.allowBlank = false;
//        this.spr.allowBlank = false;
//        this.spsj.allowBlank = false;
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
                        this.sgbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.sbmc
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
                           this.sblx
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbxh
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
                         this.sbjb
                   ]  
                   }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.syks
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
                      this.syfw
                      ]  
                  }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sccj
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
                           this.sgrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sgjg
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
                           this.sbsgr
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dhyqsj
                       ]  
                   }),
               ] 
        });
//        var pnRow7=new Ext.Panel({  
//            layout:'column',  
//            border:false,  
//            items:[  
//                   new Ext.Panel({  
//                       columnWidth:.5,  
//                       layout:'form',  
//                       border:false,  
//                       labelWidth:90,  
//                       labelAlign:'right',  
//                       items:[  
//                           this.spyj
//                       ]  
//                   }), 
//                   new Ext.Panel({  
//                       columnWidth:.5,  
//                       layout:'form',  
//                       border:false,  
//                       labelWidth:90,  
//                       labelAlign:'right',  
//                       items:[  
//                           this.spr
//                       ]  
//                   }),
//               ] 
//        });
        var pnRow7=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
//                  new Ext.Panel({  
//                  columnWidth:.5,  
//                  layout:'form',  
//                  border:false,  
//                  labelWidth:90,  
//                  labelAlign:'right',  
//                  items:[  
//                  this.spsj
//                        ]  
//                  }),
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
//                        this.idHidden,
						pnRow1,
						pnRow2,
						pnRow3,
						pnRow4,
						pnRow5,
						pnRow6,
						pnRow7,
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
            title: "设备申购新增",
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
        	title: "修改设备申购信息",
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
                            {name:'ID'},{name:'SGBH'},{name:'SBMC'},{name:'SBLX'},{name:'SBXH'},{name:'SBJB'},
                            {name:'SYKS'},{name:'SYFW'},{name:'SCCJ'},{name:'SGRQ'},{name:'SGJG'},{name:'SBSGR'},
                            {name:'DHYQSJ'},{name:'BZ'}
//                            {name:'SPYJ'},{name:'SPR'},{name:'SPSJ'},

            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'登记',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'编辑',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'设备名称&设备编号...',  
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
                {header:'申购编号',dataIndex:'SGBH',width:100,sortable: true, hidden:true},
            	{header:'设备名称',dataIndex:'SBMC',width:100,sortable: true},
            	{header:'设备类型',dataIndex:'SBLX',width:100,sortable: true},
            	{header:'设备型号',dataIndex:'SBXH',width:80,sortable: true, hidden:true},
            	{header:'设备级别',dataIndex:'SBJB',width:80,sortable: true, hidden:true},
            	{header:'使用科室',dataIndex:'SYKS',width:150,sortable: true},
            	{header:'使用范围',dataIndex:'SYFW',width:100,sortable: true, hidden:true},
            	{header:'生产厂家',dataIndex:'SCCJ',width:120,sortable: true, hidden:true},
            	{header:'申购日期',dataIndex:'SGRQ',width:80,sortable: true, hidden:true},
            	{header:'申购价格',dataIndex:'SGJG',width:80,sortable: true, hidden:true},
            	{header:'设备申购人',dataIndex:'SBSGR',width:80,sortable: true},
            	{header:'到货要求时间',dataIndex:'DHYQSJ',width:100,sortable: true},
//            	{header:'审批意见',dataIndex:'SPYJ',width:80,sortable: true},
//            	{header:'审批人',dataIndex:'SPR',width:80,sortable: true},
//            	{header:'审批时间',dataIndex:'SPSJ',width:80,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true, hidden:true},
            	
            	{header: '操作', width: 100, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;'>编辑</span></a>"+
			                  "&nbsp&nbsp&nbsp"+
			                  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;color:red;'>删除</span></a>";
					   		  
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
    onAddClick: function() {           //新增
//    	var win = this.constructionInsertWindow;
//    	win.constructionForm.getForm().reset();
////    	win.constructionForm.idHidden.setValue(0);
//    	win.show();
    	var url = "sbsgAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("申购登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onModifyClick: function() {           //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbsgUpdateView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("申购编辑");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    	
    onDeleteClick: function() {                          //删除
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