var USER_GRID_STORE_URL = 'getYwdbList';
var PAGESIZE=20;
var SEND_URL = '/zjyw/dbgl/YdbDblb/save';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/***************************************Khxx1OpenWindow组件**************************************************/
Khxx1OpenWindow = Ext.extend(Ext.Window,{
	khxx1Grid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.khxx1Grid = new Khxx1Grid();
        Khxx1OpenWindow.superclass.constructor.call(this, {
            title: "选择保管期限",
            width: 600,
            anchor: '100%',
            autoHeight:false,
            constrainHeader:false,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.khxx1Grid]
        });
    }
});

/**************************khxx1Grid*******************************************/
Khxx1Grid = Ext.extend(UxGrid, {
	khxx1OpenWindow:null,
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+SBXX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
             {name:'ID'},{name:'LMMC'},{name:'DAMJ'},{name:'BGQX'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
					{xtype:'textfield',id:'code',
						emptyText:'请输入查询关键字....', 
               	    },'-',
					{xtype:'button',text:'查询',iconCls:'query',handler:function(){
						var code = document.getElementById('code').value;
						constructionGrid.constructionInsertWindow.constructionForm.khxx1OpenWindow.khxx1Grid.store.baseParams= {code:code};
						constructionGrid.constructionInsertWindow.constructionForm.khxx1OpenWindow.khxx1Grid.store.load({params:{start:0,limit:PAGESIZE}});
   				    }},'-',
   				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
   				    	document.getElementById('code').value='';
      			  }
               },
            ]
        });	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        Khxx1Grid.superclass.constructor.call(this, {
        	region:'center',
        	title: '档案类目列表',
        	stripeRows: true,
            frame: true,
            height: 300,
            width :width,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([ new Ext.grid.RowNumberer(),
                                          sm,
                {header:'id', width: 150, dataIndex: 'ID', hidden: true},
	            {header:'类目名称', width: 100, dataIndex: 'LMMC', sortable: true},
	            {header:'档案密级', width: 100, dataIndex: 'DAMJ', sortable: true},
	            {header:'保管期限', width: 100, dataIndex: 'BGQX', sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            	'rowdblclick':function(){
            		var records=this.getSelectionModel().getSelections();
            		var sjid = records[0].get('ID');
            		this.khxx1OpenWindow.constructionForm.sslmmc.setValue(records[0].get('LMMC'));
            		this.khxx1OpenWindow.constructionForm.damj.setValue(records[0].get('DAMJ'));
            		this.khxx1OpenWindow.constructionForm.bgqx.setValue(records[0].get('BGQX'));
            		this.khxx1OpenWindow.hide();
            	}
            }
        });
    }
});
/***************************************KhxxOpenWindow组件**************************************************/
KhxxOpenWindow = Ext.extend(Ext.Window,{
	khxxGrid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.khxxGrid = new KhxxGrid();
        KhxxOpenWindow.superclass.constructor.call(this, {
            title: "选择保管期限",
            width: 600,
            anchor: '100%',
            autoHeight:false,
            constrainHeader:false,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.khxxGrid]
        });
    }
});

/**************************khxxGrid*******************************************/
KhxxGrid = Ext.extend(UxGrid, {
	khxxOpenWindow:null,
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+SBXX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
             {name:'ID'},{name:'BGQX'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
					{xtype:'textfield',id:'code',
						emptyText:'请输入查询关键字....', 
               	    },'-',
					{xtype:'button',text:'查询',iconCls:'query',handler:function(){
						var code = document.getElementById('code').value;
						constructionGrid.constructionInsertWindow.constructionForm.khxxOpenWindow.khxxGrid.store.baseParams= {code:code};
						constructionGrid.constructionInsertWindow.constructionForm.khxxOpenWindow.khxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
   				    }},'-',
   				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
   				    	document.getElementById('code').value='';
      			  }
               },
            ]
        });	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        KhxxGrid.superclass.constructor.call(this, {
        	region:'center',
        	title: '保管期限列表',
        	stripeRows: true,
            frame: true,
            height: 300,
            width :width,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([ new Ext.grid.RowNumberer(),
                                          sm,
                {header:'id', width: 150, dataIndex: 'ID', hidden: true},
	            {header:'保管期限', width: 100, dataIndex: 'BGQX', sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            	'rowdblclick':function(){
            		var records=this.getSelectionModel().getSelections();
            		var sjid = records[0].get('ID');
            		this.khxxOpenWindow.constructionForm.bgqx.setValue(records[0].get('BGQX'));
            		this.khxxOpenWindow.hide();
            	}
            }
        });
    }
});
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
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
    	
    	this.rwly = this.createTextField('任务来源', 'rwly', '95%','',null,100,'长度超过不能11');
    	
    	
        this.bgbh.allowBlank = false;
        this.rwmc.allowBlank = false;
        this.ssxm.allowBlank = false;
        this.rwlx.allowBlank = false;
        this.yqksrq.allowBlank = false;
        this.yqjsrq.allowBlank = false;
        this.sjksrq.allowBlank = false;
        this.sjjsrq.allowBlank = false;
        this.wcjd.allowBlank = false;
        this.rwfzr.allowBlank = false;
        this.rwly.allowBlank = false;
        

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
                       columnWidth:1,  
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
    	
    	this.rwly = this.createTextField('任务来源', 'rwly', '95%','',null,100,'长度超过不能11');
    	
    	
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
        this.rwly.allowBlank = true;
        
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
                       columnWidth:1,  
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


/*************************************** SendForm组件 **************************************************/
SendForm = Ext.extend(Ext.ux.Form, {
	
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
    	
    	this.rwly = this.createTextField('任务来源', 'rwly', '90%','',null,100,'长度超过不能11');
    	
    	this.cbnr = this.createTextField('<span style="color:red">*</span>督办内容', 'cbnr', '90%','',null,100,'长度超过不能11');
    	
    	this.cbsj =  new Ext.form.DateField({
			fieldLabel: '催办时间',
			name: "cbsj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.cbr = this.createTextField('督办人', 'cbr', '90%','',null,100,'长度超过不能11');
    	
    	this.cbzt = this.createTextField('督办状态', 'cbzt', '90%','',null,100,'长度超过不能11');
    	
    	this.fkzt = this.createTextField('反馈状态', 'fkzt', '90%','',null,100,'长度超过不能11');
    	
    	this.fkts = this.createTextField('反馈条数', 'fkts', '90%','',null,100,'长度超过不能11');
    	
    	this.fj = this.createTextField('附件', 'fj', '90%','',null,100,'长度超过不能11');
    	
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
        this.rwly.allowBlank = true;
        this.cbnr.allowBlank = false;
        this.cbsj.allowBlank = false;
        this.cbr.allowBlank = false;
        this.cbzt.allowBlank = false;
        this.fkzt.allowBlank = false;
        this.fkts.allowBlank = false;
        this.fj.allowBlank = true;
        
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
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,
                       hidden:true,
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
                       hidden:true,
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.cbr
                       ]  
                   }),
               ] 
        });
        var pnRow8=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,
                       hidden:true,
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.cbzt
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false, 
                       hidden:true,
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fkzt
                       ]  
                   }),
               ] 
        });
        var pnRow9=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,
                       hidden:true,
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fkts
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,
                       hidden:true,
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fj
                       ]  
                   }),
               ] 
        });
        
        SendForm.superclass.constructor.call(this, {
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
						pnRow7,
						pnRow8,
						pnRow9,
            ],
            buttonAlign :'center',
            buttons: [
                      {text:'发送督办',iconCls: 'edit',handler:this.sendFormClick,scope:this},
                      {text: '取消', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     sendFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	 var record=constructionGrid.getSelectionModel().getSelections();
         	this.getForm().submit({
                 waitMsg: '正在发送...',
                 url: SEND_URL , 
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "回复成功!" + BLANKSTR);
                 	constructionGrid.constructionSendWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "回复失败!" + BLANKSTR);
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
        	title: "修改我的督办信息",
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

/***************************************constructionSendWindow组件**************************************************/
ConstructionSendWindow = Ext.extend(Ext.Window, {
	sendForm : null,
    constructor: function() {
    	this.sendForm = new SendForm();
    	ConstructionSendWindow.superclass.constructor.call(this, {
        	title: "发送督办信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.sendForm]
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
                            {name:'CBR'}, {name:'CBNR'},{name:'FKZT'}
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
        this.constructionLookWindow = new ConstructionLookWindow();
        this.constructionSendWindow = new ConstructionSendWindow();
        
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
						if(record.get("CBZT") != 0){
							return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
					   	           "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
						           "<a href='javascript:;' onclick='constructionGrid.onSendClick()' style='text-decoration:none;'>" +
						   	       "<span style='width: 26px;cursor: pointer;'>督办</span></a>&nbsp&nbsp&nbsp";
            		}else{
            		return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
			   	           "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
     			           "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
     			           "<span style='width: 25px;color:grey;'>督办</span></a>&nbsp;&nbsp;&nbsp";
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
                                return "<span>未反馈</span>";
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
    
    onSendClick: function() {                  //发送督办
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
   		    	var curDate = new Date();
   		    	win.sendForm.cbsj.setValue(curDate);
   		    	win.sendForm.cbr.setValue('admin');
   		    	win.sendForm.cbzt.setValue('0');
   		    	win.sendForm.fkzt.setValue('1');
   		    	win.sendForm.fkts.setValue('1');
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