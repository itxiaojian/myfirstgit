var USER_GRID_STORE_URL = 'getJsfwXyxxList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var SBXX_URL = '/khgl/YKhKhxx/getKhKhxxList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;


/***************************************KhxxOpenWindow组件**************************************************/
KhxxOpenWindow = Ext.extend(Ext.Window,{
	khxxGrid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.khxxGrid = new KhxxGrid();
        KhxxOpenWindow.superclass.constructor.call(this, {
            title: "选择客户信息",
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
             {name:'ID'},{name:'KHMC'},{name:'KHDZ'},{name:'LXR'},{name:'SJHM'}
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
        	title: '客户信息列表',
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
	            {header:'客户名称', width: 100, dataIndex: 'KHMC', sortable: true},
                {header:'客户地址', width: 100, dataIndex: 'KHDZ', sortable: true},
                {header:'法人代表', width: 100, dataIndex: 'LXR', sortable: true},
                {header:'联系电话', width: 100, dataIndex: 'SJHM', sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            	'rowdblclick':function(){
            		var records=this.getSelectionModel().getSelections();
            		var sjid = records[0].get('ID');
            		this.khxxOpenWindow.constructionForm.khmc.setValue(records[0].get('KHMC'));
            		this.khxxOpenWindow.constructionForm.khdz.setValue(records[0].get('KHDZ'));
            		this.khxxOpenWindow.constructionForm.frdb.setValue(records[0].get('LXR'));
            		this.khxxOpenWindow.constructionForm.lxdh.setValue(records[0].get('SJHM'));
            		this.khxxOpenWindow.hide();
            	}
            }
        });
    }
});
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
        this.xybh = this.createTextField('协议编号', 'xybh', '90%','',null,100,'长度超过不能50');
    	
//    	this.khmc = this.createTextField('客户名称', 'khmc', '90%','',null,100,'长度超过不能50');
    	
    	this.khmc = new Ext.form.TextField({
            fieldLabel: '客户名称',
            name: 'khmc',
            anchor: '98%'
        });
    	
    	this.khdz = this.createTextField('客户地址', 'khdz', '90%','',null,100,'长度超过不能50');
    	
    	this.frdb = this.createTextField('法人代表', 'frdb', '90%','',null,100,'长度超过不能50');
    	
    	this.lxdh = new Ext.form.NumberField({
            fieldLabel: '联系电话',
            name: 'lxdh',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            maxLength:11,
            maxLengthText:'数字长度超过不能11位', 
            anchor: '90%',
            cls:'forbiddenZH',
            hidden:false
        });
    	
//    	this.cpmc = this.createTextField('涉及产品名称', 'cpmc', '90%','',null,100,'长度超过不能11');
    	
    	this.cpmc = new Ext.form.TextArea({
            fieldLabel: '涉及产品&nbsp<br>名称',
            name: 'cpmc',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.fwxm = this.createTextField('服务项目', 'fwxm', '90%','',null,100,'长度超过不能500');
    	
    	this.xylx = this.createTextField('协议类型', 'xylx', '90%','',null,100,'长度超过不能100');
    	
    	
    	this.sxrq =  new Ext.form.DateField({
			fieldLabel: '生效日期',
			id:"sxrq_s",
			name: "sxrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.zzrq =  new Ext.form.DateField({
			fieldLabel: '终止日期',
			name: "zzrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	
    	this.ks_id = new zjyw.OrgSingelSelectAll('协议科室','ks_id','ks_id','90%');
    	
//    	this.xyzy = this.createTextField('协议摘要', 'xyzy', '90%','',null,150,'长度超过不能11');
    	
    	this.xyzy = new Ext.form.TextArea({
            fieldLabel: '协议摘要',
            name: 'xyzy',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.xykh = this.createTextField('协议金额', 'xykh', '90%','',null,150,'长度超过不能150');
    	
    	//做下拉框
    	this.fkfs = this.createCombo('付款方式', 'ZDZ', 'ZDMC', 'fkfs', '90%', PROJECT_NAME+'/jsfwgl/YjsfwXyxx/getDicByLx');
		this.fkfs.store.load();
		this.fkfs.allowBlank = false;
    	
    	this.bz_id = new Ext.form.TextArea({
            fieldLabel: '执行标准',
            name: 'bz_id',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.jybh_id = new Ext.form.TextArea({
            fieldLabel: '已出具&nbsp<br>报告编号',
            name: 'jybh_id',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 256,
            maxLengthText: '256！'
        });

    	this.khjlgm = new Ext.form.TextArea({
            fieldLabel: '客户经济&nbsp<br>类型及规模',
            name: 'khjlgm',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.khhz_info = new Ext.form.TextArea({
            fieldLabel: '客户已&nbsp<br>获取证情况',
            name: 'khhz_info',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 256,
            maxLengthText: '256！'
        });

    	this.xyfzr = this.createTextField('协议负责人', 'xyfzr', '90%','',null,150,'长度超过不能50');

    	this.djrq =  new Ext.form.DateField({
			fieldLabel: '登记日期',
			name: "djrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.jyks_id = new zjyw.OrgSingelSelectAll('检验科室','jyks_id','jyks_id','90%');
    	
    	this.yeks_id = new zjyw.OrgSingelSelectAll('业务科室','yeks_id','yeks_id','90%');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.xybh.allowBlank = false;
        this.khmc.allowBlank = false;
        this.khdz.allowBlank = false;
        this.frdb.allowBlank = false;
        this.lxdh.allowBlank = false;
        this.cpmc.allowBlank = false;
        this.fwxm.allowBlank = false;
        this.xylx.allowBlank = false;
        this.sxrq.allowBlank = false;
        this.zzrq.allowBlank = false;
        this.ks_id.allowBlank = false;
        this.xyzy.allowBlank = false;
        this.xykh.allowBlank = false;
        this.fkfs.allowBlank = false;
        this.bz_id.allowBlank = false;
        this.jybh_id.allowBlank = false;
        this.khjlgm.allowBlank = false;
        this.khhz_info.allowBlank = false;
        this.xyfzr.allowBlank = false;
        this.djrq.allowBlank = false;
        this.jyks_id.allowBlank = false;
        this.yeks_id.allowBlank = false;
        this.bz.allowBlank = true;
        
        this.khmc.readOnly = true;
        this.khdz.readOnly = true;
        
        
        this.khxxOpenWindow = new KhxxOpenWindow(); 

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:115,  
                    labelAlign:'right',  
                    items:[  
                        this.xybh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.395,  
                    layout:'form',  
                    border:false,  
                    labelWidth:115,  
                    labelAlign:'right',  
                    items:[  
                        this.khmc
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
                               		var win = new KhxxOpenWindow();
                               		win.constructionForm = this.constructionForm;
                             		win.show();
                             		win.khxxGrid.khxxOpenWindow = win;
                             		win.khxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
                                  }
                                 }) 
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
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.khdz
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.frdb
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
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.lxdh
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.fwxm
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
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.cpmc
                        ]  
                  }), 
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.xyzy
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
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.sxrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.zzrq
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
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.ks_id
                        ]  
                  }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:115,  
                   labelAlign:'right',  
                   items:[  
                         this.xylx
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
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.xykh
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                           this.fkfs
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
                  style:"margin-top:5px;",
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.bz_id
                        ]  
                  }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false, 
                  style:"margin-top:5px;",
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.jybh_id
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
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.khjlgm
                        ]  
                  }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:115,  
                  labelAlign:'right',  
                  items:[  
                        this.khhz_info
                        ]  
                  }), 
                 ]  
              });
        var pnRow10=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:115,  
                   labelAlign:'right',  
                   items:[  
                         this.xyfzr
                         ]  
                    }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:115,  
                    labelAlign:'right',  
                    items:[  
                           this.djrq
                          ]  
                    }),
                 ]  
              });
        
        var pnRow11=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:115,  
                   labelAlign:'right',  
                   items:[  
                         this.jyks_id
                         ]  
                    }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:115,  
                    labelAlign:'right',  
                    items:[  
                           this.yeks_id
                          ]  
                    }),
                 ]  
              });
        
        var pnRow12=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   new Ext.Panel({  
                   columnWidth:1,  
                   layout:'form', 
//                   style:"margin-top:30px;",
                   border:false,  
                   labelWidth:115,  
                   labelAlign:'left',  
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
                    pnRow5,
                    pnRow6,
                    pnRow7,
                    pnRow4,
                    pnRow10,
                    pnRow11,
                    pnRow9,
                    pnRow8,
                    pnRow12,
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
        	 var sxdateValue = this.sxrq.getValue();
        	 var zzdateValue = this.zzrq.getValue();
	        	if(sxdateValue > zzdateValue) {
//	        		alert(attachMentFileValue);
	        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "请重新选择终止日期！<br>终止日期大于生效日期!" + BLANKSTR);
	        		return;
	        	}
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
        	 var sxdateValue = this.sxrq.getValue();
        	 var zzdateValue = this.zzrq.getValue();
	        	if(sxdateValue > zzdateValue) {
//	        		alert(attachMentFileValue);
	        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "请重新选择终止日期！<br>终止日期大于生效日期!" + BLANKSTR);
	        		return;
	        	}
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
        this.constructionForm.buttons[0].show();   //显示添加按钮
    	this.constructionForm.buttons[1].hide();   //隐藏修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "技术服务协议信息",
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
        	title: "修改协议信息",
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

/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
//        this.lookForm.buttons[0].show();   //显示停用按钮
//    	this.lookForm.buttons[1].hide();   //隐藏报废按钮
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看协议信息",
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
                            {name:'ID'},{name:'XYBH'},{name:'KHMC'},{name:'KHDZ'},{name:'FRDB'},
                            {name:'LXDH'},{name:'CPMC'},{name:'FWXM'},{name:'XYLX'},{name:'SXRQ'},
                            {name:'ZZRQ'},{name:'KS_ID'},{name:'XYZY'},{name:'XYKH'},{name:'FKFS'},
                            {name:'BZ_ID'},{name:'JYBH_ID'},{name:'KHJLGM'},{name:'KHHZ_INFO'},{name:'XYFZR'},
                            {name:'DJRQ'},{name:'JYKS_ID'},{name:'YEKS_ID'},{name:'BZ'},{name:'SFR'},{name:'SYJE'},
                            {name:'XMLXR'},{name:'DHHM'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'登记',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'编辑',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'产品名称&协议编号...',  
               	    },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			  }},
                '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
  		        	    if(btn=="yes"){ 
  		        	    	window.open(PROJECT_NAME+"/resources/js/jsfwgl/jsfwxyxx.xls");
  		        	   }
  		        	 });
  		    	 },scope:this},
  		        '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "技术服务协议信息";
			        	    	var code = Ext.getCmp('code').getValue();
			        	    	var url = PROJECT_NAME + "/jsfwgl/YjsfwXyxx/export?fileName="+fileName+"&code="+code;
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
                {header:'id',dataIndex:'ID',width:70,sortable: true, hidden:true},
                {header:'收费状态',dataIndex:'SFR',width:70,sortable: true, hidden:true},
                {header:'协议编号',dataIndex:'XYBH',width:70,sortable: true},
                {header:'客户名称',dataIndex:'KHMC',width:90,sortable: true},
            	{header:'客户地址',dataIndex:'KHDZ',width:80,sortable: true, hidden:true},
            	{header:'法人代表',dataIndex:'FRDB',width:70,sortable: true},
            	{header:'联系电话',dataIndex:'LXDH',width:90,sortable: true, hidden:true},
            	{header:'涉及产品名称',dataIndex:'CPMC',width:110,sortable: true, hidden:true},
            	{header:'服务项目',dataIndex:'FWXM',width:80,sortable: true, hidden:true},
            	{header:'项目联系人',dataIndex:'XMLXR',width:80,sortable: true},
            	{header:'项目电话',dataIndex:'DHHM',width:80,sortable: true},
            	{header:'协议类型',dataIndex:'XYLX',width:80,sortable: true, hidden:true},
            	{header:'生效日期',dataIndex:'SXRQ',width:90,sortable: true, hidden:true},
            	{header:'终止日期',dataIndex:'ZZRQ',width:90,sortable: true, hidden:true},
            	{header:'协议科室',dataIndex:'KS_ID',width:150,sortable: true, hidden:true},
            	{header:'协议摘要',dataIndex:'XYZY',width:100,sortable: true, hidden:true},
            	{header:'协议金额（元）',dataIndex:'XYKH',width:100,sortable: true},
            	{header:'付款方式',dataIndex:'FKFS',width:60,sortable: true,
                 	 renderer:function(value){
                         if(value == '0') {
                             return "<span>电汇</span>";
                         }else if(value == '1') {
                             return "<span>现金</span>";
                         }else{
                         	return value;
	                         }
	                 	 }
	           	},
	           	{header:'剩余金额（元）',dataIndex:'SYJE',width:100,sortable: true},
            	{header:'执行标准',dataIndex:'BZ_ID',width:80,sortable: true, hidden:true},
            	{header:'已出具报告编号',dataIndex:'JYBH_ID',width:100,sortable: true},
            	{header:'客户经济类型及规模',dataIndex:'KHJLGM',width:130,sortable: true, hidden:true},
            	{header:'客户已获取证情况',dataIndex:'KHHZ_INFO',width:130,sortable: true, hidden:true},
            	{header:'检验科室',dataIndex:'JYKS_ID',width:120,sortable: true},
            	{header:'业务科室',dataIndex:'YEKS_ID',width:120,sortable: true},
            	{header:'协议负责人',dataIndex:'XYFZR',width:80,sortable: true},
            	{header:'登记日期',dataIndex:'DJRQ',width:90,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true, hidden:true},
            	{header:'操作', width: 100, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("SFR") == 1){
							return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;'>编辑</span></a>"+
			                  "&nbsp&nbsp&nbsp"+
			                  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;color:red;'>删除</span></a>";
						}else if (record.get("SFR") == -1){
							return "<a href='javascript:;' onclick='constructionGrid.onTshiClick()' style='text-decoration:none;'>" + 
                            "<span style='width: 25px;color:gray;'>编辑</span></a>"+
			                  "&nbsp&nbsp&nbsp"+
			                  "<a href='javascript:;' onclick='constructionGrid.onTshiClick()' style='text-decoration:none;'>" + 
	                            "<span style='width: 25px;color:gray;'>删除</span></a>";
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
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
//    	win.constructionForm.getForm().reset();
    	var url = "jsfwAddView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },

    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
   				var url = "jsfwXgView?id="+id;  	
   				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
   				ACT_DEAL_WINDOW = new ActDealWindow();
   				ACT_DEAL_WINDOW.setTitle("编辑");
   				ACT_DEAL_WINDOW.html = html;
   				ACT_DEAL_WINDOW.show();
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    
   		
    },
	
	
    
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.show();
   		    	win.lookForm.xybh.setValue(vrecord.data.XYBH);
   		    	win.lookForm.khmc.setValue(vrecord.data.KHMC);
   		    	win.lookForm.khdz.setValue(vrecord.data.KHDZ);
   		    	win.lookForm.frdb.setValue(vrecord.data.FRDB);
   		    	win.lookForm.lxdh.setValue(vrecord.data.LXDH);
   		    	win.lookForm.cpmc.setValue(vrecord.data.CPMC);
   		    	win.lookForm.fwxm.setValue(vrecord.data.FWXM);
   		    	win.lookForm.xylx.setValue(vrecord.data.XYLX);
   		    	win.lookForm.sxrq.setValue(vrecord.data.SXRQ);
   		    	win.lookForm.zzrq.setValue(vrecord.data.ZZRQ);
   		    	win.lookForm.ks_id.setValue(vrecord.data.KS_ID);
   		    	win.lookForm.xyzy.setValue(vrecord.data.XYZY);
   		    	win.lookForm.xykh.setValue(vrecord.data.XYKH);
   		    	win.lookForm.fkfs.setValue(vrecord.data.FKFS);
   		    	win.lookForm.bz_id.setValue(vrecord.data.BZ_ID);
   		    	win.lookForm.jybh_id.setValue(vrecord.data.JYBH_ID);
   		    	win.lookForm.khjlgm.setValue(vrecord.data.KHJLGM);
   		    	win.lookForm.khhz_info.setValue(vrecord.data.KHHZ_INFO);
   		    	win.lookForm.xyfzr.setValue(vrecord.data.XYFZR);
   		    	win.lookForm.djrq.setValue(vrecord.data.DJRQ);
   		    	win.lookForm.jyks_id.setValue(vrecord.data.JYKS_ID);
   		    	win.lookForm.yeks_id.setValue(vrecord.data.YEKS_ID);
   		    	win.lookForm.bz.setValue(vrecord.data.BZ);
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
    	var valueStr1=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
	       		valueStr1.push(records[i].get('XYBH'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr,xybh: valueStr1},
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
    
    onTshiClick: function() {       //  收费中的提示县退费才可删除
		var records=this.getSelectionModel().getSelections();
		    	var valueStr=[];
		   		if(records.length>0) {
			       	for(var i=0;i<records.length;i++){
			       		valueStr.push(records[i].get('ID'));
		    	 	}
			    	Ext.Msg.confirm("提醒信息", "该条技术服务协议信息正在收费，请退费后编辑或删除！",function(btn){
			    	});	
		    	}
		    },
});

/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.xybh = this.createTextField('协议编号', 'xybh', '90%','',null,100,'长度超过不能50');
    	
    	this.khmc = this.createTextField('客户名称', 'khmc', '90%','',null,100,'长度超过不能50');
    	
    	this.khdz = this.createTextField('客户地址', 'khdz', '90%','',null,100,'长度超过不能50');
    	
    	this.frdb = this.createTextField('法人代表', 'frdb', '90%','',null,100,'长度超过不能50');
    	
    	this.lxdh = this.createTextField('联系电话', 'lxdh', '90%','',null,100,'长度超过不能50');
    	
    	this.cpmc = this.createTextField('涉及产品名称', 'cpmc', '90%','',null,100,'长度超过不能11');
    	
    	this.fwxm = this.createTextField('服务项目', 'fwxm', '90%','',null,100,'长度超过不能500');
    	
    	this.xylx = this.createTextField('协议类型', 'xylx', '90%','',null,100,'长度超过不能100');
    	
    	this.sxrq = this.createTextField('生效日期', 'sxrq', '90%','',null,100,'长度超过不能50');

    	this.zzrq = this.createTextField('终止日期', 'zzrq', '90%','',null,100,'长度超过不能50');
    	
    	this.ks_id = this.createTextField('协议科室', 'ks_id', '90%','',null,150,'长度超过不能11');
    	
    	this.xyzy = this.createTextField('协议摘要', 'xyzy', '90%','',null,150,'长度超过不能11');
    	
    	this.xykh = this.createTextField('协议金额', 'xykh', '90%','',null,150,'长度超过不能150');
    	
    	this.fkfs = this.createTextField('付款方式', 'fkfs', '90%','',null,100,'长度超过不能50');
    	
    	this.bz_id = this.createTextField('执行标准', 'bz_id', '90%','',null,150,'长度超过不能150');
    	
    	this.jybh_id = this.createTextField('已出具报告编号', 'jybh_id', '90%','',null,150,'长度超过不能200');

    	this.khjlgm = this.createTextField('客户经济类型及规模', 'khjlgm', '90%','',null,150,'长度超过不能50');
    	
    	this.khhz_info = this.createTextField('客户已获取证情况', 'khhz_info', '90%','',null,150,'长度超过不能50');

    	this.xyfzr = this.createTextField('协议负责人', 'xyfzr', '90%','',null,150,'长度超过不能50');

    	this.djrq = this.createTextField('登记日期', 'djrq', '90%','',null,100,'长度超过不能50');
    	
    	this.jyks_id = this.createTextField('检验科室', 'jyks_id', '90%','',null,150,'长度超过不能50');
    	
    	this.yeks_id = this.createTextField('业务科室', 'yeks_id', '90%','',null,150,'长度超过不能50');
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.xybh.allowBlank = true;
        this.khmc.allowBlank = true;
        this.khdz.allowBlank = true;
        this.frdb.allowBlank = true;
        this.lxdh.allowBlank = true;
        this.cpmc.allowBlank = true;
        this.fwxm.allowBlank = true;
        this.xylx.allowBlank = true;
        this.sxrq.allowBlank = true;
        this.zzrq.allowBlank = true;
        this.ks_id.allowBlank = true;
        this.xyzy.allowBlank = true;
        this.xykh.allowBlank = true;
        this.fkfs.allowBlank = true;
        this.bz_id.allowBlank = true;
        this.jybh_id.allowBlank = true;
        this.khjlgm.allowBlank = true;
        this.khhz_info.allowBlank = true;
        this.xyfzr.allowBlank = true;
        this.djrq.allowBlank = true;
        this.jyks_id.allowBlank = true;
        this.yeks_id.allowBlank = true;
        this.bz.allowBlank = true;

        this.xybh.readOnly = true;
        this.khmc.readOnly = true;
        this.khdz.readOnly = true;
        this.frdb.readOnly = true;
        this.lxdh.readOnly = true;
        this.cpmc.readOnly = true;
        this.fwxm.readOnly = true;
        this.xylx.readOnly = true;
        this.sxrq.readOnly = true;
        this.zzrq.readOnly = true;
        this.ks_id.readOnly = true;
        this.xyzy.readOnly = true;
        this.xykh.readOnly = true;
        this.fkfs.readOnly = true;
        this.bz_id.readOnly = true;
        this.jybh_id.readOnly = true;
        this.khjlgm.readOnly = true;
        this.khhz_info.readOnly = true;
        this.xyfzr.readOnly = true;
        this.djrq.readOnly = true;
        this.jyks_id.readOnly = true;
        this.yeks_id.readOnly = true;
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
                        this.xybh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.khmc
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
                           this.khdz
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.frdb
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
                           this.lxdh
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.cpmc
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
                        this.fwxm
                        ]  
                  }), 
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.xylx
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
                           this.sxrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.zzrq
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
                        this.ks_id
                        ]  
                  }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.xyzy
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
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xykh
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fkfs
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
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.bz_id
                        ]  
                  }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.jybh_id
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
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.khjlgm
                        ]  
                  }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.khhz_info
                        ]  
                  }), 
                 ]  
              });
        var pnRow10=new Ext.Panel({  
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
                         this.xyfzr
                         ]  
                    }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                           this.djrq
                          ]  
                    }),
                 ]  
              });
        
        var pnRow11=new Ext.Panel({  
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
                         this.jyks_id
                         ]  
                    }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                           this.yeks_id
                          ]  
                    }),
                 ]  
              });
        
        var pnRow12=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   new Ext.Panel({  
                   columnWidth:1,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'left',  
                   items:[  
                         this.bz
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
                    pnRow7,
                    pnRow8,
                    pnRow9,
                    pnRow10,
                    pnRow11,
                    pnRow12,
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