var USER_GRID_STORE_URL = 'getDaXxList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var SBXX_URL = '/dagl/YdaBgqx/getDaBgqxList';
//var SBXX_URL1 = '/dagl/YdaLmgl/getDaLmglList';
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
            		this.khxx1OpenWindow.constructionForm.lmmc.setValue(records[0].get('LMMC'));
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
    	
    	this.dabt = this.createTextField('档案标题', 'dabt', '90%','',null,100,'长度超过不能50');
    	    	
    	this.dagjz = this.createTextField('档案关键字', 'dagjz', '90%','',null,100,'长度超过不能50');
    	
    	this.dalx = this.createTextField('档案类型', 'dalx', '90%','',null,100,'长度超过不能50');
    	
//    	this.sslmid = this.createTextField('所属类目id', 'sslmid', '90%','',null,100,'长度超过不能50');
    	
//    	this.sslmmc = this.createTextField('所属类目', 'sslmmc', '90%','',null,100,'长度超过不能50');
    	
    	this.lmmc = new Ext.form.TextField({
            fieldLabel: '所属类目',
            name: 'lmmc',
            anchor: '99%'
        });
    	
    	this.damj = this.createTextField('档案密级', 'damj', '90%','',null,100,'长度超过不能11');
    	
//    	this.ssjgid = this.createTextField('所属机构', 'ssjgid', '90%','',null,100,'长度超过不能11');
    	
    	this.ssjgid = new zjyw.OrgSingelSelectAll('所属机构','ssjgid','ssjgid','90%');
    	
    	this.gdnr = this.createTextField('归档内容', 'gdnr', '90%','',null,100,'长度超过不能11');
    	
    	this.fjid = this.createTextField('附&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp件', 'fjid', '90%','',null,100,'长度超过不能100');
    	
    	this.bgqx = this.createTextField('保管期限', 'bgqx', '90%','',null,200,'长度超过不能200');
    	
    	this.gdr = this.createTextField('归&nbsp档&nbsp&nbsp人', 'gdr', '90%','',null,150,'长度超过不能11');
    	
    	this.sfqd = this.createTextField('是否清档', 'sfqd', '90%','',null,160,'长度超过不能50');
    	
//    	this.kckrid = this.createTextField('可查看人id', 'kckrid', '90%','',null,150,'长度超过不能11');

    	this.kckrxm = this.createTextField('可查看人', 'kckrxm', '90%','',null,160,'长度超过不能50');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
        this.dabt.allowBlank = false;
        this.dagjz.allowBlank = false;
        this.dalx.allowBlank = false;
        this.lmmc.allowBlank = false;
        this.damj.allowBlank = false;
        this.ssjgid.allowBlank = false;
        this.gdnr.allowBlank = false;
        this.fjid.allowBlank = false;
        this.bgqx.allowBlank = false;
        this.gdr.allowBlank = false;
        this.kckrxm.allowBlank = false;
        this.bz.allowBlank = true;
        
        this.bgqx.readOnly = true;
        this.lmmc.readOnly = true;
        this.damj.readOnly = true;
        this.bgqx.readOnly = true;
        this.sfqd.readOnly = true;
        
        
        this.khxxOpenWindow = new KhxxOpenWindow();
        this.khxx1OpenWindow = new Khxx1OpenWindow();
        

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
                        this.dabt
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.dagjz
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
                           this.dalx
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false, 
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ssjgid
                       ]  
                   }),
                   ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   
                   new Ext.Panel({  
                   columnWidth:.395,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.lmmc
                   ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.105,  
                       layout:'form',  
                       border:false,  
                       labelWidth:50,
                       labelAlign:'right',  
                       items:[  
   							 new Ext.Button({
                                     text:'查找',
                                     constructionForm: this,
                                     handler:function(){
                                  		var win = new Khxx1OpenWindow();
                                  		win.constructionForm = this.constructionForm;
                                		win.show();
                                		win.khxx1Grid.khxx1OpenWindow = win;
                                		win.khxx1Grid.store.load({params:{start:0,limit:PAGESIZE}});
                                     }
                                    }) 
                       ]  
                   }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.damj
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
                      this.gdnr
                      ]  
                  }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.gdr
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
                           this.fjid
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bgqx
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
                           this.kckrxm
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,
                       hidden:true,
                       labelAlign:'right',  
                       items:[  
                           this.sfqd
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

/*************************************** QdangForm组件 **************************************************/
QdangForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	this.dabt = this.createTextField('档案标题', 'dabt', '90%','',null,100,'长度超过不能50');
    	    	
    	this.dagjz = this.createTextField('档案关键字', 'dagjz', '90%','',null,100,'长度超过不能50');
    	
    	this.dalx = this.createTextField('档案类型', 'dalx', '90%','',null,100,'长度超过不能50');
    	
//    	this.sslmid = this.createTextField('所属类目id', 'sslmid', '90%','',null,100,'长度超过不能50');
    	
    	this.lmmc = this.createTextField('所属类目', 'lmmc', '90%','',null,100,'长度超过不能50');
    	
    	this.damj = this.createTextField('档案密级', 'damj', '90%','',null,100,'长度超过不能11');
    	
//    	this.ssjgid = this.createTextField('所属机构', 'ssjgid', '90%','',null,100,'长度超过不能11');
    	
    	this.ssjgid = new zjyw.OrgSingelSelectAll('所属机构','ssjgid','ssjgid','90%');
    	
    	this.gdnr = this.createTextField('归档内容', 'gdnr', '90%','',null,100,'长度超过不能11');
    	
    	this.fjid = this.createTextField('附&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp件', 'fjid', '90%','',null,100,'长度超过不能100');
    	
    	this.bgqx = this.createTextField('保管期限', 'bgqx', '90%','',null,200,'长度超过不能200');
    	
    	this.gdr = this.createTextField('归&nbsp档&nbsp&nbsp人', 'gdr', '90%','',null,150,'长度超过不能11');
    	
    	this.sfqd = this.createTextField('是否清档', 'sfqd', '90%','',null,160,'长度超过不能50');
    	
//    	this.kckrid = this.createTextField('可查看人id', 'kckrid', '90%','',null,150,'长度超过不能11');

    	this.kckrxm = this.createTextField('可查看人', 'kckrxm', '90%','',null,160,'长度超过不能50');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
        this.dabt.allowBlank = false;
        this.dagjz.allowBlank = false;
        this.dalx.allowBlank = false;
        this.lmmc.allowBlank = false;
        this.damj.allowBlank = false;
        this.ssjgid.allowBlank = false;
        this.gdnr.allowBlank = false;
        this.fjid.allowBlank = false;
        this.bgqx.allowBlank = false;
        this.gdr.allowBlank = false;
        this.kckrxm.allowBlank = false;
        this.bz.allowBlank = true;
        
        this.dabt.readOnly = true;
        this.dagjz.readOnly = true;
        this.dalx.readOnly = true;
        this.lmmc.readOnly = true;
        this.damj.readOnly = true;
        this.ssjgid.readOnly = true;
        this.gdnr.readOnly = true;
        this.fjid.readOnly = true;
        this.bgqx.readOnly = true;
        this.gdr.readOnly = true;
        this.kckrxm.readOnly = true;
        this.bz.readOnly = true;
        this.sfqd.readOnly = true;
        
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
                        this.dabt
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.dagjz
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
                           this.dalx
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false, 
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ssjgid
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
                         this.damj
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
                      this.gdnr
                      ]  
                  }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.gdr
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
                           this.fjid
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bgqx
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
                           this.kckrxm
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,
                       hidden:true,
                       labelAlign:'right',  
                       items:[  
                           this.sfqd
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
                           this.bz
                       ]  
                   }), 
                   
               ] 
        });
        
        
        QdangForm.superclass.constructor.call(this, {
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
            ],
            buttonAlign :'center',
            buttons: [
                      {text:'确定清档',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '取消', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     updateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	 var record=constructionGrid.getSelectionModel().getSelections();
         	this.getForm().submit({
                 waitMsg: '正在清档...',
                 url: 'update', 
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "清档成功!" + BLANKSTR);
                 	constructionGrid.constructionQdangWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "清档失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** YqiForm组件 **************************************************/
YqiForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	this.dabt = this.createTextField('档案标题', 'dabt', '90%','',null,100,'长度超过不能50');
    	    	
    	this.dagjz = this.createTextField('档案关键字', 'dagjz', '90%','',null,100,'长度超过不能50');
    	
    	this.dalx = this.createTextField('档案类型', 'dalx', '90%','',null,100,'长度超过不能50');
    	
    	this.lmmc = this.createTextField('所属类目', 'lmmc', '90%','',null,100,'长度超过不能50');
    	
    	this.damj = this.createTextField('档案密级', 'damj', '90%','',null,100,'长度超过不能11');
    	
    	this.ssjgid = this.createTextField('所属机构', 'ssjgid', '90%','',null,100,'长度超过不能11');
    	
    	this.gdnr = this.createTextField('归档内容', 'gdnr', '90%','',null,100,'长度超过不能11');
    	
    	this.fjid = this.createTextField('附&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp件', 'fjid', '90%','',null,100,'长度超过不能100');
    	
//    	this.bgqx = this.createTextField('保管期限', 'bgqx', '90%','',null,200,'长度超过不能200');
    	
    	//做下拉框
    	this.bgqx = this.createCombo('<span style="color:red">*</span>保管期限', 'ZDMC', 'ZDMC', 'bgqx', '90%', PROJECT_NAME+'/dagl/YdaBgqx/getDicByLx');
		this.bgqx.store.load();
		this.bgqx.allowBlank = false;
    	
    	this.gdr = this.createTextField('归&nbsp档&nbsp&nbsp人', 'gdr', '90%','',null,150,'长度超过不能11');
    	
    	this.sfqd = this.createTextField('是否清档', 'sfqd', '90%','',null,160,'长度超过不能50');
    	
    	this.kckrxm = this.createTextField('可查看人', 'kckrxm', '90%','',null,160,'长度超过不能50');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
        this.dabt.allowBlank = false;
        this.dagjz.allowBlank = false;
        this.dalx.allowBlank = false;
        this.lmmc.allowBlank = false;
        this.damj.allowBlank = false;
        this.ssjgid.allowBlank = false;
        this.gdnr.allowBlank = false;
        this.fjid.allowBlank = false;
        this.bgqx.allowBlank = false;
        this.gdr.allowBlank = false;
        this.kckrxm.allowBlank = false;
        this.bz.allowBlank = true;
        
        this.dabt.readOnly = true;
        this.dagjz.readOnly = true;
        this.dalx.readOnly = true;
        this.lmmc.readOnly = true;
        this.damj.readOnly = true;
        this.ssjgid.readOnly = true;
        this.gdnr.readOnly = true;
        this.fjid.readOnly = true;
        this.gdr.readOnly = true;
        this.kckrxm.readOnly = true;
        this.bz.readOnly = true;
        
        
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
                        this.dabt
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.dagjz
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
                           this.dalx
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ssjgid
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
                         this.damj
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
                      this.gdnr
                      ]  
                  }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.gdr
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
                           this.fjid
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bgqx
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
                           this.kckrxm
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
                      {text:'确定延期',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     updateFormClick: function() {       //延期
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
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "延期成功!" + BLANKSTR);
                 	constructionGrid.constructionYqiWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "延期失败!" + BLANKSTR);
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
/***************************************constructionYqiWindow组件**************************************************/
ConstructionYqiWindow = Ext.extend(Ext.Window, {
	yqiForm : null,
    constructor: function() {
    	this.yqiForm = new YqiForm();
    	ConstructionYqiWindow.superclass.constructor.call(this, {
        	title: "档案延期信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.yqiForm]
        });
    }
});

/***************************************constructionQdangWindow组件**************************************************/
ConstructionQdangWindow = Ext.extend(Ext.Window, {
	qdangForm : null,
    constructor: function() {
    	this.qdangForm = new QdangForm();
    	ConstructionQdangWindow.superclass.constructor.call(this, {
        	title: "确定档案清档信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.qdangForm]
        });
    }
});

/********************IpasAssobjBankmemberUploadWindow组件*************************/
IpasAssobjBankmemberUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.ipasAssobjBankmember = new IpasAssobjBankmemberUpload();
		IpasAssobjBankmemberUploadWindow.superclass.constructor.call(this, {
			title: '导入EXCEL文件',
			width: 600,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
			items: [this.ipasAssobjBankmember]
		});
	}
});
/********************IpasAssobjBankmemberUpload组件*************************/
IpasAssobjBankmemberUpload = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		this.fibasic = new Ext.ux.form.FileUploadField({
			 name: 'fileData',
			 id: 'form-file',
            emptyText: '例:XXX.xlsx',
            fieldLabel: '导入文件',
	        width: 400
	    });
		IpasAssobjBankmemberUpload.superclass.constructor.call(this, {
			anchor: '100%',
			fileUpload: true,
			autoHeight:true,
			labelWidth: 90,
			labelAlign :'right',
			frame: true,
			bodyStyle:"padding: 5px 5px 0",
			layout: 'tableform',
			layoutConfig: {columns: 2},
			items:[
			       this.fibasic
			       ],
			       buttonAlign :'center',
			       buttons: [
			                 {text: '上传', width: 20,iconCls:'save', handler: this.onUploadClick, scope: this},
			                 {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
			                 ]
		});
	},
	onUploadClick: function(){
		if(this.getForm().isValid()){
			this.getForm().submit({
				waitMsg: '正在提交，请稍后...',
				url: ENTITY_URL_UPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					constructionGrid.ipasAssobjBankmemberUploadWindow.hide();
				},
				failure: function(form, action){
					Ext.MessageBox.alert("系统提示：",action.result.message);
				}
			});
		}
	},
	//关闭
	onCloseClick: function(){
		constructionGrid.ipasAssobjBankmemberUploadWindow.ipasAssobjBankmember.getForm().reset();
		this.ownerCt.hide();
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
                            {name:'ID'},{name:'DABT'},{name:'DAGJZ'},{name:'DALX'},{name:'LMMC'},
                            {name:'DAMJ'},{name:'SSJGID'},{name:'GDNR'},{name:'FJID'},{name:'BGQX'},{name:'GDR'},
                            {name:'KCKRXM'},{name:'SFQD'},{name:'BZ'},{name:'SSLMID'},{name:'YSJLSJM'},{name:'BBZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'档案标题&档案关键字...',  
               	    },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      			'-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			  }
                  },
                '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
  		        	    if(btn=="yes"){ 
  		        	    	window.open(PROJECT_NAME+"/resources/js/dagl/Daxx.xls");
  		        	   }
  		        	 });
  		    	 },scope:this},
  		        '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "档案信息";
			        	    	var code = Ext.getCmp('code').getValue();
			        	    	var url = PROJECT_NAME + "/dagl/YdaXx/export?fileName="+fileName+"&code="+code;
			        	    	url = encodeURI(url);
			        	    	url = encodeURI(url);
			        	    	window.open(url);
			        	   }
			        	 });
	   		    		}
  		      }
            ]
        });
   	
        this.constructionInsertWindow = new ConstructionInsertWindow();       
        this.constructionUpdateWindow = new ConstructionUpdateWindow();
        this.constructionYqiWindow = new ConstructionYqiWindow();
        this.constructionQdangWindow = new ConstructionQdangWindow();
        
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
                {header:'档案标题',dataIndex:'DABT',width:120,sortable: true},
            	{header:'档案关键字',dataIndex:'DAGJZ',width:100,sortable: true, hidden:true},
            	{header:'档案类型',dataIndex:'DALX',width:80,sortable: true},
            	{header:'报告编号',dataIndex:'SSLMID',width:100,sortable: true},
            	{header:'原始记录',dataIndex:'YSJLSJM',width:80,sortable: true,hidden:true},
            	{header:'文档类型',dataIndex:'BBZ',width:80,sortable: true,hidden:true},
            	{header:'所属类目',dataIndex:'LMMC',width:80,sortable: true,hidden:true},
            	{header:'档案密级',dataIndex:'DAMJ',width:60,sortable: true},
            	{header:'所属机构',dataIndex:'SSJGID',width:120,sortable: true},
            	{header:'归档内容',dataIndex:'GDNR',width:80,sortable: true, hidden:true},
            	{header:'附件',dataIndex:'FJID',width:100,sortable: true, hidden:true},
            	{header:'保管期限',dataIndex:'BGQX',width:80,sortable: true},
            	{header:'归档人',dataIndex:'GDR',width:80,sortable: true, hidden:true},
//            	{header:'可查看人ID',dataIndex:'KCKRID',width:90,sortable: true},
            	{header:'可查看人',dataIndex:'KCKRXM',width:80,sortable: true, hidden:true},
            	{header:'是否清档',dataIndex:'SFQD',width:60,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>否</span>";
	                    }else if(value == '1') {
	                        return "<span style=color:red>是</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	{header:'备注',dataIndex:'BZ',width:80,sortable: true, hidden:true},
            	{header: '操作', width: 290, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("SFQD") != 1){
					return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
				   	       "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
					       "<a href='javascript:;' onclick='constructionGrid.onQdangClick()' style='text-decoration:none;'>" +
					   	   "<span style='width: 26px;cursor: pointer;'>清档</span></a>&nbsp&nbsp&nbsp"+
					   	   "<a href='javascript:;' onclick='constructionGrid.onYqiClick()' style='text-decoration:none;'>"+
					   	   "<span style='width: 26px;cursor: pointer;'>延期</span></a>&nbsp&nbsp&nbsp"+
					   	   "<a href='javascript:;' onclick='constructionGrid.onBjiClick()' style='text-decoration:none;'>查看原始记录</a>&nbsp&nbsp&nbsp"+
					   	   "<a href='javascript:;' onclick='constructionGrid.onBgClick()' style='text-decoration:none;'>查看报告</a>";
            		}else{
            		return "&nbsp&nbsp&nbsp<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
				   	       "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp"+
            		       "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
            		       "<span style='width: 25px;color:grey;'>&nbsp;&nbsp;&nbsp;清档</span></a>&nbsp;&nbsp;&nbsp"+
     			           "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
     			           "<span style='width: 25px;color:grey;'>延期</span></a>&nbsp;&nbsp;&nbsp"+
     			           "<a href='javascript:;' onclick='constructionGrid.onBjiClick()' style='text-decoration:none;'>查看原始记录</a>&nbsp&nbsp&nbsp"+
					   	   "<a href='javascript:;' onclick='constructionGrid.onBgClick()' style='text-decoration:none;'>查看报告</a>";
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
    
    onLookClick: function() {            //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		var id=records[0].get('ID');
    	var url = "daxxOnlookView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("档案查看");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
   			}
   			}
    },
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onAddClick: function() {            //新增
    	var url = "daxxAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("档案登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
   		    	win.constructionForm.dabt.setValue(vrecord.data.DABT);
   		    	win.constructionForm.dagjz.setValue(vrecord.data.DAGJZ);
   		    	win.constructionForm.dalx.setValue(vrecord.data.DALX);
//   		    	win.constructionForm.sslmid.setValue(vrecord.data.SSLMID);
   		    	win.constructionForm.lmmc.setValue(vrecord.data.LMMC);
   		    	win.constructionForm.damj.setValue(vrecord.data.DAMJ);
   		    	win.constructionForm.ssjgid.setValue(vrecord.data.SSJGID);
   		    	win.constructionForm.gdnr.setValue(vrecord.data.GDNR);
   		    	win.constructionForm.fjid.setValue(vrecord.data.FJID);
   		    	win.constructionForm.bgqx.setValue(vrecord.data.BGQX);
   		    	win.constructionForm.gdr.setValue(vrecord.data.GDR);
//   		    	win.constructionForm.kckrid.setValue(vrecord.data.KCKRID);
   		    	win.constructionForm.kckrxm.setValue(vrecord.data.KCKRXM);
   		    	win.constructionForm.sfqd.setValue(vrecord.data.SFQD);
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
    
    
//    onYqiClick: function() {                  //延期
//    	var records=this.getSelectionModel().getSelections();
//   		if(records.length > 0) {
//   			if(records.length == 1){
//   				vrecord = records[0];
//   		    	var win = this.constructionYqiWindow;
//   		    	win.show();
//   		    	win.yqiForm.dabt.setValue(vrecord.data.DABT);
//   		    	win.yqiForm.dagjz.setValue(vrecord.data.DAGJZ);
//   		    	win.yqiForm.dalx.setValue(vrecord.data.DALX);
//   		    	win.yqiForm.lmmc.setValue(vrecord.data.LMMC);
//   		    	win.yqiForm.damj.setValue(vrecord.data.DAMJ);
//   		    	win.yqiForm.ssjgid.setValue(vrecord.data.SSJGID);
//   		    	win.yqiForm.gdnr.setValue(vrecord.data.GDNR);
//   		    	win.yqiForm.fjid.setValue(vrecord.data.FJID);
//   		    	win.yqiForm.bgqx.setValue(vrecord.data.BGQX);
//   		    	win.yqiForm.gdr.setValue(vrecord.data.GDR);
//   		    	win.yqiForm.kckrxm.setValue(vrecord.data.KCKRXM);
//   		    	win.yqiForm.sfqd.setValue(vrecord.data.SFQD);
//   		    	win.yqiForm.bz.setValue(vrecord.data.BZ);
//   			}else{
//   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
//   			}
//   		}else{
//   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
//   		}    	
//    },
    
    onYqiClick: function() {            //延期
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		var id=records[0].get('ID');
    	var url = "daxxOnYqiView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("档案延期");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
   			}
   			}
    },
    
//    onQdangClick: function() {                  //清档
//    	var records=this.getSelectionModel().getSelections();
//   		if(records.length > 0) {
//   			if(records.length == 1){
//   				vrecord = records[0];
//   		    	var win = this.constructionQdangWindow;
//   		    	win.show();
//   		    	win.qdangForm.dabt.setValue(vrecord.data.DABT);
//   		    	win.qdangForm.dagjz.setValue(vrecord.data.DAGJZ);
//   		    	win.qdangForm.dalx.setValue(vrecord.data.DALX);
//   		    	win.qdangForm.lmmc.setValue(vrecord.data.LMMC);
//   		    	win.qdangForm.damj.setValue(vrecord.data.DAMJ);
//   		    	win.qdangForm.ssjgid.setValue(vrecord.data.SSJGID);
//   		    	win.qdangForm.gdnr.setValue(vrecord.data.GDNR);
//   		    	win.qdangForm.fjid.setValue(vrecord.data.FJID);
//   		    	win.qdangForm.bgqx.setValue(vrecord.data.BGQX);
//   		    	win.qdangForm.gdr.setValue(vrecord.data.GDR);
//   		    	win.qdangForm.kckrxm.setValue(vrecord.data.KCKRXM);
//   		    	win.qdangForm.sfqd.setValue(1);
//   		    	win.qdangForm.bz.setValue(vrecord.data.BZ);
//   			}else{
//   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
//   			}
//   		}else{
//   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
//   		}    	
//    },
    
    onQdangClick: function() {
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要清档吗？",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'onQdang', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "清档成功!" + BLANKSTR);
				               constructionGrid.store.reload();
			               },
			               failure: function(form, action) {
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "清档失败!" + BLANKSTR);
			               }
				       	});					
				}
	    	});	
    	}else{
    		 Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
         	return;
    	}
    },
    
    onBjiClick: function(){   //点击查看文档类型的原始记录
		var records = this.getSelectionModel().getSelections();
		var ysjlsjm=records[0].get('YSJLSJM');
		var bz=records[0].get('BBZ');
		var url = "WordOnLine?ysjlsjm="+ysjlsjm+"&bz="+bz;
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("查看原始记录文档");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},
	
	 onBgClick: function(){   //点击查看文档类型的原始记录
			var records = this.getSelectionModel().getSelections();
			var bgbh=records[0].get('SSLMID');
			var url = "bgOnLine?bgbh="+bgbh;
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("查看报告");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
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