var USER_GRID_STORE_URL = 'getWddbList';
var PAGESIZE=20;
var HFU_URL = '/zjyw/dbgl/YdbFklb/saveall';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	    	
    	this.rwmc = this.createTextField('任务名称', 'rwmc', '90%','',null,100,'长度超过不能50');
    	
    	this.ssxm = this.createTextField('所属项目', 'ssxm', '90%','',null,100,'长度超过不能50');
    	
    	this.rwlx = this.createTextField('任务类型', 'rwlx', '90%','',null,100,'长度超过不能50');
    	
    	this.yqksrq =  new Ext.form.DateField({
			fieldLabel: '要求开始日期',
			name: "yqksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.yqjsrq =  new Ext.form.DateField({
			fieldLabel: '要求结束日期',
			name: "yqjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.sjksrq =  new Ext.form.DateField({
			fieldLabel: '实际开始日期',
			name: "sjksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.sjjsrq =  new Ext.form.DateField({
			fieldLabel: '实际结束日期',
			name: "sjjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.wcjd = this.createTextField('完成进度', 'wcjd', '90%','',null,100,'长度超过不能11');
    	
    	this.rwfzr = this.createTextField('任务负责人', 'rwfzr', '90%','',null,100,'长度超过不能11');
    	
    	this.cbr = this.createTextField('督办人', 'cbr', '95%','',null,100,'长度超过不能11');

    	this.cbnr = this.createTextField('督办内容', 'cbnr', '95%','',null,100,'长度超过不能11');
    	
    	this.fkzt = this.createTextField('反馈状态', 'fkzt', '95%','',null,100,'长度超过不能11');
    	
        this.bgbh.allowBlank = true;
        this.rwmc.allowBlank = true;
        this.ssxm.allowBlank = true;
        this.rwlx.allowBlank = true;
        this.yqksrq.allowBlank = true;
        this.yqjsrq.allowBlank = true;
        this.sjksrq.allowBlank = true;
        this.sjjsrq.allowBlank = true;
        this.wcjd.allowBlank = true;
        this.rwfzr.allowBlank = true;
        this.cbr.allowBlank = true;
        this.cbnr.allowBlank = true;
        this.fkzt.allowBlank = true;
        
        this.bgbh.readOnly = true;
        this.rwmc.readOnly = true;
        this.ssxm.readOnly = true;
        this.rwlx.readOnly = true;
        this.yqksrq.readOnly = true;
        this.yqjsrq.readOnly = true;
        this.sjksrq.readOnly = true;
        this.sjjsrq.readOnly = true;
        this.wcjd.readOnly = true;
        this.rwfzr.readOnly = true;
        this.cbr.readOnly = true;
        this.fkzt.readOnly = true;
        this.cbnr.readOnly = true;
        

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
                           this.fkzt
                       ]  
                   }),
               ] 
        });
        var pnRow7=new Ext.Panel({  
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
                           this.cbnr
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
						pnRow1,
						pnRow2,
						pnRow3,
						pnRow4,
						pnRow5,
						pnRow6,
						pnRow7
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

/*************************************** HfuForm组件 **************************************************/
HfuForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	
    	this.rwmc = this.createTextField('任务名称', 'rwmc', '90%','',null,100,'长度超过不能50');
    	
    	this.ssxm = this.createTextField('所属项目', 'ssxm', '90%','',null,100,'长度超过不能50');
    	
    	this.rwlx = this.createTextField('任务类型', 'rwlx', '90%','',null,100,'长度超过不能50');
    	
    	this.yqksrq =  new Ext.form.DateField({
			fieldLabel: '要求开始日期',
			name: "yqksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.yqjsrq =  new Ext.form.DateField({
			fieldLabel: '要求结束日期',
			name: "yqjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.sjksrq =  new Ext.form.DateField({
			fieldLabel: '实际开始日期',
			name: "sjksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.sjjsrq =  new Ext.form.DateField({
			fieldLabel: '<span style=color:red>*</span>实际结束日期',
			name: "sjjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.wcjd = this.createTextField('<span style=color:red>*</span>完成进度', 'wcjd', '90%','',null,100,'长度超过不能11');
    	
    	this.rwfzr = this.createTextField('任务负责人', 'rwfzr', '90%','',null,100,'长度超过不能11');
    	
    	this.cbr = this.createTextField('督办人', 'cbr', '90%','',null,100,'长度超过不能11');

    	this.cbnr = this.createTextField('督办内容', 'cbnr', '90%','',null,100,'长度超过不能11');
    	
    	this.fknr = this.createTextField('<span style=color:red>*</span>反馈内容', 'fknr', '95%','',null,100,'长度超过不能11');
    	
    	
    	
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
        this.cbr.allowBlank = true;
        this.cbnr.allowBlank = true;
        this.fknr.allowBlank = false;
        
        this.bgbh.readOnly = true;
        this.yqksrq.readOnly = true;
        this.yqjsrq.readOnly = true;
        this.sjksrq.readOnly = true;
        this.rwfzr.readOnly = true;
        this.cbr.readOnly = true;
        this.cbnr.readOnly = true;
        
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
                           this.cbnr
                       ]  
                   }),
               ] 
        });
        var pnRow7=new Ext.Panel({  
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
                           this.fknr
                       ]  
                   }), 
               ] 
        });
        
        HfuForm.superclass.constructor.call(this, {
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
						pnRow7
            ],
            buttonAlign :'center',
            buttons: [
                      {text:'督办反馈',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '取消', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     updateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	 var record=constructionGrid.getSelectionModel().getSelections();
//        	 alert(record[0].get('ID'));
         	this.getForm().submit({
                 waitMsg: '正在反馈...',
                 url: 'saveHfu' , 
                 method: 'POST',
                 params:{
                 	id:record[0].get('DBID'),rwid:record[0].get('ID')
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "反馈成功!" + BLANKSTR);
                 	constructionGrid.constructionHfuWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "反馈失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/***************************************constructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看督办信息",
            width: 800,
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
/***************************************constructionHfuWindow组件**************************************************/
ConstructionHfuWindow = Ext.extend(Ext.Window, {
	hfuForm : null,
    constructor: function() {
    	this.hfuForm = new HfuForm();
    	ConstructionHfuWindow.superclass.constructor.call(this, {
        	title: "反馈督办",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.hfuForm]
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
                            {name:'ID'},{name:'BGBH'},{name:'RWMC'},{name:'SSXM'},{name:'RWLX'},{name:'YQKSRQ'},
                            {name:'YQJSRQ'},{name:'SJKSRQ'},{name:'SJJSRQ'},{name:'WCJD'},{name:'RWFZR'},
                            {name:'CBR'},{name:'CBNR'},{name:'FKZT'},{name:'DBID'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
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
   	
        this.constructionLookWindow = new ConstructionLookWindow();
        this.constructionHfuWindow = new ConstructionHfuWindow();
        
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
                {header: '操作', width: 95, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("FKZT") != 1 || null){
					return"<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
		   	              "<span style='width: 26px;cursor: pointer;'>&nbsp&nbsp&nbsp查看</span></a>&nbsp&nbsp&nbsp"+
			              "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
			              "<span style='width: 25px;color:grey;'>反馈</span></a>&nbsp;&nbsp;&nbsp";
            		}else {
            		return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
			   	           "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
				   	       "<a href='javascript:;' onclick='constructionGrid.onHfuClick()' style='text-decoration:none;'>"+
				   	       "<span style='width: 26px;cursor: pointer;'>反馈</span></a>";
         						}
						}
				},
                {header:'报告编号',dataIndex:'BGBH',width:110,sortable: true},
            	{header:'任务名称',dataIndex:'RWMC',width:80,sortable: true},
            	{header:'所属项目',dataIndex:'SSXM',width:80,sortable: true},
            	{header:'任务类型',dataIndex:'RWLX',width:80,sortable: true},
            	{header:'要求开始日期',dataIndex:'YQKSRQ',width:100,sortable: true},
            	{header:'要求结束日期',dataIndex:'YQJSRQ',width:100,sortable: true},
            	{header:'实际开始日期',dataIndex:'SJKSRQ',width:100,sortable: true},
            	{header:'实际结束日期',dataIndex:'SJJSRQ',width:100,sortable: true},
            	{header:'完成进度',dataIndex:'WCJD',width:80,sortable: true},
            	{header:'任务负责人',dataIndex:'RWFZR',width:80,sortable: true},
            	{header:'督办人',dataIndex:'CBR',width:80,sortable: true},
            	{header:'督办内容',dataIndex:'CBNR',width:80,sortable: true},
            	{header:'反馈状态',dataIndex:'FKZT',width:80,sortable: true,
                  	 renderer:function(value){
                          if(value == '0') {
                              return "<span>已反馈</span>";
                          }else if(value == '1') {
                              return "<span style=color:red>未反馈</span>";
                          }else{
                          	return value;
                          }
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
   		    	win.lookForm.cbr.setValue(vrecord.data.CBR);
   		    	win.lookForm.fkzt.setValue(vrecord.data.FKZT);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    
    onHfuClick: function() {                  //反馈
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
   		    	win.hfuForm.cbr.setValue(vrecord.data.CBR);
   		    	win.hfuForm.cbnr.setValue(vrecord.data.CBNR);
   		    	
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