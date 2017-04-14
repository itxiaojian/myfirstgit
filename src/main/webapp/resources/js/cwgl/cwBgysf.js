var USER_GRID_STORE_URL = 'getBgysfList';
var PAGESIZE=20;
var SBXX_URL = '/jybzgl/getYjyBzxxList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

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
        this.constructionForm.buttons[0].show();   //显示添加按钮
    	this.constructionForm.buttons[1].hide();   //隐藏修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "新增成本明细",
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
        	title: "修改成本明细",
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
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[{name:'SFR'},
                            {name:'ID'},{name:'BGBH'},{name:'YPMC'},{name:'SJDW'},{name:'KS_ID'},
                            {name:'JYFY'},{name:'YSJE'},{name:'YSFJE'},{name:'SFZT'},{name:'JYJSRQ'},
                            {name:'XGJE'},{name:'BZ'},{name:'SSYWKS'},{name:'JYJSRQ'},{name:'WTBM'},
                            {name:'CJBM'},{name:'CJFY'},{name:'WTDW'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//            	'-',{text:'批量删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,emptyText:'编号&名称&委托单位...'},
                '-','检验科室 ：',{xtype:'combo',id:'jyks',width: 170,emptyText:'请选择...',
                 	  mode: 'local',
          			  triggerAction: 'all',
          			  displayField:'BMMC',
          			  valueField:'BMBH',
                      store: new Ext.data.Store({
                      proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getJyks', method: 'POST'}),
                      reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                      autoLoad:true
                      }),
                      editable : false
                	  },
  	        	  '-','业务科室 ：',{xtype:'combo',id:'ywks',width: 160,emptyText:'请选择...',
  	             	  mode: 'local',
  	      			  triggerAction: 'all',
  	      			  displayField:'BMMC',
  	      			  valueField:'BMBH',
  	                  store: new Ext.data.Store({
  	                  proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getYwks', method: 'POST'}),
  	                  reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
  	                  autoLoad:true}),
  	                  editable : false
  	            	  },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
    	  			 var params = {};
  		    	 			if(Ext.getCmp('code').getValue() != '') {
  		    	 				params['code'] = Ext.getCmp('code').getValue();
  		    	 			}
  		    	 			if(Ext.getCmp('jyks').getValue() != '') {
  		    	 				params['jyks'] = Ext.getCmp('jyks').getValue();
  		    	 			}
  		    	 			if(Ext.getCmp('ywks').getValue() != '') {
  		    	 				params['ywks'] = Ext.getCmp('ywks').getValue();
  		    	 			}
  		    	 			constructionGrid.store.baseParams= params;
  		    	 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
      	   			    Ext.getCmp('jyks').setValue("");
      	   			    Ext.getCmp('ywks').setValue("");
         			  }},
            ]
        });
   	
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
                {header:'序号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                {header: '操作', width: 160, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("YSFJE") > 0 && record.get("XGJE") == 1){
							   return "<a href='javascript:;' onclick='constructionGrid.onLookjl()' style='text-decoration:none;'>" +
							   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
							   		  "&nbsp;&nbsp;&nbsp"+
							   		  "<a href='javascript:;' onclick='constructionGrid.onTfei()' style='text-decoration:none;'>" +
							   		  "<span style='width: 26px;cursor: pointer;'>退费</span></a>"+
							   		  "&nbsp;&nbsp;&nbsp"+
							   		  "<a href='javascript:;' onclick='constructionGrid.onUpdatejl()' style='text-decoration:none;'>" +
							   		  "<span style='width: 26px;cursor: pointer;'>修改</span></a>"+
							   		  "&nbsp;&nbsp;&nbsp"
//							   		  +
//							   		  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
//							   		  "<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>"
							   		  ;
	            		      }else if(record.get("YSFJE") < 0 ||record.get("XGJE") == 2){
	            		    	  return "<a href='javascript:;'onclick='constructionGrid.onLookjl()' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
						   		  "&nbsp;&nbsp;&nbsp"+
						   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
	                              "<span style='width: 25px;color:gray;'>退费</span></a>"+
						   		  "&nbsp;&nbsp;&nbsp"+
						   		  "<a href='javascript:;' onclick='constructionGrid.onUpdatejl()' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;'>修改</span></a>"+
						   		  "&nbsp;&nbsp;&nbsp"
//						   		  +
//						   		  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
//						   		  "<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>"
						   		  ; 
	            		      }else if(record.get("YSFJE") > 0 && record.get("XGJE") < 0){
	            		    	  return "<a href='javascript:;' onclick='constructionGrid.onLookjl()' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
						   		  "&nbsp;&nbsp;&nbsp"+
						   		  "<a href='javascript:;' onclick='constructionGrid.onTfei()' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;'>退费</span></a>"+
						   		  "&nbsp;&nbsp;&nbsp"+
						   		  "<a href='javascript:;' onclick='constructionGrid.onUpdatejl()' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;'>修改</span></a>"+
						   		  "&nbsp;&nbsp;&nbsp"
//						   		  +
//						   		  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
//						   		  "<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>"
						   		  ;
	            		      }else{
               			          return  "<a href='javascript:;' onclick='constructionGrid.onLookjl()' style='text-decoration:none;'>" +
								   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
								   		  "&nbsp;&nbsp;&nbsp"+
								   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
			                              "<span style='width: 25px;color:gray;'>信息有误，请联系管理员</span></a>";
               		          }
					}
				},
				{header:'收费状态',dataIndex:'SFZT',width:60,sortable: true,
            		renderer:function(value, cellmeta, record){
            				if(record.get("YSFJE") > 0 && record.get("XGJE") == 1) {
            					return "<span style=color:blue>已收费</span>";
            						}else if(record.get("YSFJE") < 0){
            					return "<span style=color:gray>退费记录</span>";
            				}else if(record.get("YSFJE") > 0 && record.get("XGJE") == 2){
            					return "<span style=color:red>已退费</span>";
            				}else if(record.get("YSFJE") > 0 && record.get("XGJE") < 0){
            					return "<span style=color:blue>已收费</span>";
            				}
            			}
           	    },
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
                {header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
                {header:'受检单位',dataIndex:'SJDW',width:130,sortable: true},
                {header:'委托单位',dataIndex:'WTDW',width:100,sortable: true},
            	{header:'检验科室',dataIndex:'KS_ID',width:130,sortable: true},
            	{header:'业务科室',dataIndex:'SSYWKS',width:100,sortable: true},
            	{header:'登记时间',dataIndex:'JYJSRQ',width:120,sortable: true, hidden:true},
            	{header:'检验费用（元）',dataIndex:'JYFY',width:100,sortable: true,
            		renderer:function(value){
              			 if(value < 0) {
                               return 0-value;
                           }else 
                         	  return value;
              			 }
               	},
            	{header:'修改收费金额（元）',dataIndex:'XGJE',width:100,sortable: true,hidden:true,
            		renderer:function(value){
           			 if(value != null) {
                            return value;
                        }else 
                      	  return "无";
           			 }
            	},
            	{header:'已收金额（元）',dataIndex:'YSFJE',width:100,sortable: true},
            	{header:'剩缴金额（元）',dataIndex:'YSJE',width:100,sortable: true},
            	{header:'委托部门',dataIndex:'WTBM',width:100,sortable: true,
            		renderer:function(value){
              			 if(value != null) {
                               return value;
                           }else 
                         	  return "无";
              			 }
               	},
            	{header:'承检科室',dataIndex:'CJBM',width:100,sortable: true,
               		renderer:function(value){
              			 if(value != null) {
                               return value;
                           }else 
                         	  return "无";
              			 }
               	},
               	{header:'承检金额（元）',dataIndex:'CJFY',width:100,sortable: true,
            		renderer:function(value){
           			 if(value != null) {
                            return value;
                        }else 
                      	  return "0";
           			 }
            	},
           	 {header:'收费人',dataIndex:'SFR',width:90,sortable: true,hidden:true},
           	 {header:'收费日期',dataIndex:'JYJSRQ',width:100,sortable: true,hidden:true},
           	 {header:'备注',dataIndex:'BZ',width:130,sortable: true,hidden:true},
           	 
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    onLook: function() {                     //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var bgbh=records[0].get('BGBH');
   				var url = "bgsfonLookView?id="+id+"&bgbh="+bgbh;
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();
   			}else{
	   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
	   			}
	   		}else{
	   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
	   		}    
    },
    
    onLookjl: function() {                     //查看缴费记录
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var bgbh=records[0].get('BGBH');
   				var url = "bgsfonLookjlView?id="+id+"&bgbh="+bgbh;
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();
   			}else{
	   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
	   			}
	   		}else{
	   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
	   		}    
    },
    
    onUpdatejl: function() {                     //修改缴费记录
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var bgbh=records[0].get('BGBH');
   				var url = "updatejlView?id="+id+"&bgbh="+bgbh;
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("修改收费记录");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();
   			}else{
	   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
	   			}
	   		}else{
	   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
	   		}    
    },
    
    onTfei: function() {                     //退费管理
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var bgbh=records[0].get('BGBH');
   				var url = "bgsfonTfeiView?id="+id+"&bgbh="+bgbh;
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("退费");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();
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

