var USER_GRID_STORE_URL = 'getDblbList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	
    	this.rwmc = this.createTextField('任务名称', 'rwmc', '90%','',null,100,'长度超过不能50');
    	    	
    	this.cbsj =  new Ext.form.DateField({
			fieldLabel: '督办时间',
			name: "cbsj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.cbnr = this.createTextField('督办内容', 'cbnr', '90%','',null,100,'长度超过不能11');
    	
    	this.cbr = this.createTextField('督办人', 'cbr', '90%','',null,100,'长度超过不能11');
    	
//    	this.cbzt = this.createTextField('督办状态', 'cbzt', '90%','',null,100,'长度超过不能11');
    	
    	//做下拉框
    	this.cbzt = this.createCombo('督办状态', 'ZDZ', 'ZDMC', 'cbzt', '90%', PROJECT_NAME+'/dbgl/YdbDblb/getDicByLx');
		this.cbzt.store.load();
		this.cbzt.allowBlank = false;
    	
//    	this.fkzt = this.createTextField('反馈状态', 'fkzt', '90%','',null,100,'长度超过不能11');
    	
    	this.fkzt = this.createCombo('反馈状态', 'ZDZ', 'ZDMC', 'fkzt', '90%', PROJECT_NAME+'/dbgl/YdbDblb/getDicByLx1');
		this.fkzt.store.load();
		this.fkzt.allowBlank = false;

    	this.fkts = this.createTextField('反馈条数', 'fkts', '90%','',null,100,'长度超过不能11');

    	this.fj = this.createTextField('附件', 'fj', '90%','',null,100,'长度超过不能11');

    	
    	this.bgbh.allowBlank = false;
    	this.rwmc.allowBlank = false;
        this.cbsj.allowBlank = false;
        this.cbnr.allowBlank = false;
        this.cbr.allowBlank = false;
        this.cbzt.allowBlank = false;
        this.fkzt.allowBlank = false;
        this.fkts.allowBlank = false;
        this.fj.allowBlank = false;

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
                           this.cbsj
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false, 
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.cbnr
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
                         this.cbr
                   ]  
                   }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.cbzt
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
                      this.fkzt
                      ]  
                  }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fkts
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
                      this.fj
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

/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionForm.buttons[1].hide();   //显示修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "督办信息新增",
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
        	title: "修改督办信息",
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
                            {name:'ID'},{name:'BGBH'},{name:'RWMC'},{name:'CBSJ'},{name:'CBNR'},{name:'CBR'},{name:'CBZT'},
                            {name:'FKZT'},{name:'FKTS'},{name:'FJ'},
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'报告编号&任务名称...',  
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
//                {header: '操作', width: 135, align:"center",sortable: true,hidden: false,
//					renderer:function(value, cellmeta, record){
//						if(record.get("SFQD") != 1){
//					return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
//				   	       "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
//					       "<a href='javascript:;' onclick='constructionGrid.onSendClick()' style='text-decoration:none;'>" +
//					   	   "<span style='width: 26px;cursor: pointer;'>发送</span></a>&nbsp&nbsp&nbsp"+
//					   	   "<a href='javascript:;' onclick='constructionGrid.onHfuClick()' style='text-decoration:none;'>"+
//					   	   "<span style='width: 26px;cursor: pointer;'>回复</span></a>";
//            		}else{
//            		return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
//            		       "<span style='width: 25px;color:grey;'>&nbsp;&nbsp;&nbsp;清档</span></a>&nbsp;&nbsp;&nbsp"+
//     			           "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
//     			           "<span style='width: 25px;color:grey;'>延期</span></a>&nbsp;&nbsp;&nbsp";
//         						}
//						}
//				},
                {header:'报告编号',dataIndex:'BGBH',width:80,sortable: true},
                {header:'任务名称',dataIndex:'RWMC',width:80,sortable: true},
            	{header:'督办时间',dataIndex:'CBSJ',width:80,sortable: true},
            	{header:'督办内容',dataIndex:'CBNR',width:120,sortable: true},
            	{header:'督办人',dataIndex:'CBR',width:80,sortable: true},
//            	{header:'督办状态',dataIndex:'CBZT',width:100,sortable: true},
            	{header:'督办状态',dataIndex:'CBZT',width:80,sortable: true,
                 	 renderer:function(value){
                         if(value == '0') {
                             return "<span>已督办</span>";
                         }else if(value == '1') {
                             return "<span>未督办</span>";
                         }else{
                         	return value;
                         }
                 	 }
           	     },
//            	{header:'反馈状态',dataIndex:'FKZT',width:100,sortable: true},
            	{header:'反馈状态',dataIndex:'FKZT',width:80,sortable: true,
                	 renderer:function(value){
                        if(value == '0') {
                            return "<span>已反馈</span>";
                        }else if(value == '1') {
                            return "<span>未反馈</span>";
                        }else{
                        	return value;
                        }
                	 }
          	     },
            	{header:'反馈条数',dataIndex:'FKTS',width:100,sortable: true},
            	{header:'附件',dataIndex:'FJ',width:100,sortable: true},
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
//    	win.constructionForm.idHidden.setValue(0);
    	win.show();
//    	win.constructionForm.sfqd.setValue(0);
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
   		    	win.constructionForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.constructionForm.rwmc.setValue(vrecord.data.RWMC);
   		    	win.constructionForm.cbsj.setValue(vrecord.data.CBSJ);
   		    	win.constructionForm.cbnr.setValue(vrecord.data.CBNR);
   		    	win.constructionForm.cbr.setValue(vrecord.data.CBR);
   		    	win.constructionForm.cbzt.setValue(vrecord.data.CBZT);
   		    	win.constructionForm.fkzt.setValue(vrecord.data.FKZT);
   		    	win.constructionForm.fkts.setValue(vrecord.data.FKTS);
   		    	win.constructionForm.fj.setValue(vrecord.data.FJ);
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
    
    onLookClick: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.show();
   		    	win.lookForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.lookForm.rwmc.setValue(vrecord.data.RWMC);
   		    	win.lookForm.ssxm.setValue(vrecord.data.SSXM);
   		    	win.lookForm.rwlx.setValue(vrecord.data.RWLX);
   		    	win.lookForm.yqksrq.setValue(vrecord.data.YQKSRQ);
   		    	win.lookForm.yqjsrq.setValue(vrecord.data.YQJSRQ);
   		    	win.lookForm.sjksrq.setValue(vrecord.data.SJKSRQ);
   		    	win.lookForm.sjjsrq.setValue(vrecord.data.SJJSRQ);
   		    	win.lookForm.wcjd.setValue(vrecord.data.WCJD);
   		    	win.lookForm.rwfzr.setValue(vrecord.data.RWFZR);
   		    	win.lookForm.rwly.setValue(vrecord.data.RWLY);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    
    onHfuClick: function() {                  //延期
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionHfuWindow;
   		    	win.show();
   		    	win.hfuForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.hfuForm.rwmc.setValue(vrecord.data.RWMC);
   		    	win.hfuForm.ssxm.setValue(vrecord.data.SSXM);
   		    	win.hfuForm.rwlx.setValue(vrecord.data.RWLX);
   		    	win.hfuForm.yqksrq.setValue(vrecord.data.YQKSRQ);
   		    	win.hfuForm.yqjsrq.setValue(vrecord.data.YQJSRQ);
   		    	win.hfuForm.sjksrq.setValue(vrecord.data.SJKSRQ);
   		    	win.hfuForm.sjjsrq.setValue(vrecord.data.SJJSRQ);
   		    	win.hfuForm.wcjd.setValue(vrecord.data.WCJD);
   		    	win.hfuForm.rwfzr.setValue(vrecord.data.RWFZR);
   		    	win.hfuForm.rwly.setValue(vrecord.data.RWLY);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onSendClick: function() {                  //延期
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionSendWindow;
   		    	win.show();
   		    	win.sendForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.sendForm.rwmc.setValue(vrecord.data.RWMC);
   		    	win.sendForm.ssxm.setValue(vrecord.data.SSXM);
   		    	win.sendForm.rwlx.setValue(vrecord.data.RWLX);
   		    	win.sendForm.yqksrq.setValue(vrecord.data.YQKSRQ);
   		    	win.sendForm.yqjsrq.setValue(vrecord.data.YQJSRQ);
   		    	win.sendForm.sjksrq.setValue(vrecord.data.SJKSRQ);
   		    	win.sendForm.sjjsrq.setValue(vrecord.data.SJJSRQ);
   		    	win.sendForm.wcjd.setValue(vrecord.data.WCJD);
   		    	win.sendForm.rwfzr.setValue(vrecord.data.RWFZR);
   		    	win.sendForm.rwly.setValue(vrecord.data.RWLY);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
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