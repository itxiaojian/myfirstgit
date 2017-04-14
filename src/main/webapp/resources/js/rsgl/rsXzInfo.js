var USER_GRID_STORE_URL = 'getXzInfoList';
var SRMX_URL = '/rsgl/YRsXzinfoKc/getXzinfoKcList';  //薪资扣除信息列表路径
var SRMX_SAVE_URL = '/rsgl/YRsXzinfoKc/save';        //薪资扣除信息保存路径
var SRMX_UPDATE_URL = '/rsgl/YRsXzinfoKc/update';    //薪资扣除信息修改路径
var SRMX_DELETE_URL = '/rsgl/YRsXzinfoKc/delete';    //薪资扣除信息删除路径
var ENTITY_URL_UPLOAD = 'upload';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.rybh = this.createTextField('人员编号', 'rybh', '90%','',null,50,'长度超过不能50');
    	this.ryxm = this.createTextField('人员姓名', 'ryxm', '90%','',null,50,'长度超过不能50');
    	this.yf =  new Ext.form.DateField({
			fieldLabel: '月份',
			name: "yf",
			format: "Y年-m月",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.jbgz = new Ext.form.NumberField({
            fieldLabel: '基本工资',
            name: 'jbgz',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.jxgz = new Ext.form.NumberField({
            fieldLabel: '绩效工资',
            name: 'jxgz',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.jbf = new Ext.form.NumberField({
            fieldLabel: '加班费',
            name: 'jbf',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.qt = new Ext.form.NumberField({
            fieldLabel: '其他',
            name: 'qt',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.wcbz = new Ext.form.NumberField({
            fieldLabel: '午餐补助',
            name: 'wcbz',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.yfgz = new Ext.form.NumberField({
            fieldLabel: '应发工资',
            name: 'yfgz',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.sfgz = new Ext.form.NumberField({
            fieldLabel: '实发工资',
            name: 'sfgz',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '90%',
            height:80,
            maxLength: 500,
            maxLengthText: '500！'
        });
    	this.rybh.allowBlank = false;
    	this.ryxm.allowBlank = false;
    	this.yf.allowBlank = false;
    	this.jbgz.allowBlank = false;
    	this.jxgz.allowBlank = false;
    	this.jbf.allowBlank = false;
    	this.qt.allowBlank = true;
    	this.wcbz.allowBlank = false;
    	this.yfgz.allowBlank = true;
    	this.sfgz.allowBlank = false;
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
                        this.rybh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ryxm
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
                        this.yf
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.jbgz
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
                        this.jxgz
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.jbf
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
                        this.qt
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.wcbz
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
                        this.yfgz
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.sfgz
                    ]  
                }), 
            ]  
        });
    	var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:1.055,  
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
						pnRow6
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
              ]
        });
     },
     addFormClick: function() {
         if(this.getForm().isValid()) {
        	var record = constructionGrid.getSelectionModel().getSelections();
        	var rybh = record[0].get("RYBH");
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
        	var record = constructionGrid.xzkcWindow.srmxGrid.getSelectionModel().getSelections();
        	var rybh = record[0].get("RYBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'update', 
                 url: PROJECT_NAME+""+SRMX_UPDATE_URL,
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

/*************************************** XzkcForm组件 **************************************************/
XzkcForm = Ext.extend(Ext.ux.Form, {
    constructor: function() {
//    	this.idHidden = this.createHidden('id','id');
    	this.rybh = this.createTextField('人员编号', 'rybh', '90%','',null,50,'长度超过不能50');
    	this.yf =  new Ext.form.DateField({
			fieldLabel: '月份',
			name: "yf",
			format: "Y-m",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.qqkc = new Ext.form.NumberField({
            fieldLabel: '缺勤扣除',
            name: 'qqkc',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.ylbx = new Ext.form.NumberField({
            fieldLabel: '养老保险',
            name: 'ylbx',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.yb = new Ext.form.NumberField({
            fieldLabel: '医保',
            name: 'yb',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.sybx = new Ext.form.NumberField({
            fieldLabel: '失业保险',
            name: 'sybx',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.sbxj = new Ext.form.NumberField({
            fieldLabel: '社保小计',
            name: 'sbxj',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.zfgjj = new Ext.form.NumberField({
            fieldLabel: '住房公积金',
            name: 'zfgjj',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.gs = new Ext.form.NumberField({
            fieldLabel: '个税',
            name: 'gs',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.kcxj = new Ext.form.NumberField({
            fieldLabel: '扣除小计',
            name: 'kcxj',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	/*
		this.bz = new Ext.form.TextArea({
					fieldLabel: '澶囨敞',
					name: 'bz',
					readOnly: false,
					anchor: '90%',
					height:80,
					maxLength: 500,
					maxLengthText: '500锛�
				});*/
		
    	this.rybh.allowBlank = false;
    	this.yf.allowBlank = false;
    	this.qqkc.allowBlank = false;
    	this.ylbx.allowBlank = false;
    	this.yb.allowBlank = false;
    	this.sybx.allowBlank = true;
    	this.sbxj.allowBlank = false;
    	this.zfgjj.allowBlank = false;
    	this.gs.allowBlank = false;
    	this.kcxj.allowBlank = false;
    	//this.bz.allowBlank = true;
    	
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
                        this.rybh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.yf
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
                        this.qqkc
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ylbx
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
                        this.yb
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.sybx
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
                        this.sbxj
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.zfgjj
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
                        this.gs
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.kcxj
                    ]  
                }), 
            ]  
        });
    	// var pnRow6=new Ext.Panel({  
            // layout:'column',  
            // border:false,  
            // items:[  
                // new Ext.Panel({  
                    // columnWidth:1.055,  
                    // layout:'form',  
                    // border:false,  
                    // labelWidth:90,  
                    // labelAlign:'right',  
                    // items:[  
                        // this.bz
                    // ]  
                // }), 
            // ]  
        // });
    	
        XzkcForm.superclass.constructor.call(this, {
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
						//pnRow6
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
              ]
        });
     },
     
     addFormClick: function() {
         if(this.getForm().isValid()) {
        	// var record = constructionGrid.getSelectionModel().getSelections();
        	// var rybh = record[0].get("RYBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+""+SRMX_SAVE_URL,
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.xzkcWindow.xzkcGrid.xzkcInsertWindow.hide();
                 	constructionGrid.xzkcWindow.xzkcGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
        	var record = constructionGrid.xzkcWindow.xzkcGrid.getSelectionModel().getSelections();
        	var rybh = record[0].get("RYBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+""+SRMX_UPDATE_URL,
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	constructionGrid.xzkcWindow.xzkcGrid.xzkcUpdateWindow.hide();
                 	constructionGrid.xzkcWindow.xzkcGrid.store.load({params:{start:0,limit:PAGESIZE,rybh:rybh}});
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
            title: "新增薪资管理信息",
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
        	title: "修改薪资管理信息",
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

/*****************************XzkcWindow***********************************/
XzkcWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.xzkcGrid = new XzkcGrid();
    	XzkcWindow.superclass.constructor.call(this, {
    		title:'薪资扣除',
    		width: 1000,
//    		height:300,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.xzkcGrid],
        	buttonAlign:'center',
	        buttons:[
//	                 {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
    closeClick: function() {
    	this.hide();
    }
});

/***************************************XzkcInsertWindow组件**************************************************/
XzkcInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.xzkcForm = new XzkcForm();
        this.xzkcForm.buttons[0].show();   //显示添加按钮
    	this.xzkcForm.buttons[1].hide();   //隐藏修改按钮
    	XzkcInsertWindow.superclass.constructor.call(this, {
            title: "新增薪资扣除",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.xzkcForm]
        });
    }
});

/***************************************XzkcUpdateWindow组件**************************************************/
XzkcUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.xzkcForm = new XzkcForm();
    	this.xzkcForm.buttons[0].hide();   //隐藏添加按钮
    	this.xzkcForm.buttons[1].show();   //显示修改按钮
    	XzkcUpdateWindow.superclass.constructor.call(this, {
        	title: "修改薪资扣除",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.xzkcForm]
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

/**************************XzkcGrid*******************************************/
XzkcGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+SRMX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                            {name:'ID'},{name:'RYBH'},{name:'YF'},{name:'QQKC'},{name:'YLBX'},{name:'YB'},
                            {name:'SYBX'},{name:'SBXJ'},{name:'ZFGJJ'},{name:'GS'},{name:'KCXJ'}//,{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
            ]
        });
   	
        this.xzkcInsertWindow = new XzkcInsertWindow();       
        this.xzkcUpdateWindow = new XzkcUpdateWindow();
        
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        XzkcGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: false,
            height: 350,
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
                {header:'人员编号',dataIndex:'RYBH',width:100,sortable: true},
                {header:'月份',dataIndex:'YF',width:100,sortable: true},
            	{header:'缺勤扣除',dataIndex:'QQKC',width:100,sortable: true},
            	{header:'养老保险',dataIndex:'YLBX',width:100,sortable: true, hidden:true},
                {header:'医保',dataIndex:'YB',width:100,sortable: true, hidden:true},
                {header:'失业保险',dataIndex:'SYBX',width:100,sortable: true},
            	{header:'社保小计',dataIndex:'SBXJ',width:100,sortable: true, hidden:true},
            	{header:'住房公积金',dataIndex:'ZFGJJ',width:100,sortable: true},
            	{header:'个税',dataIndex:'GS',width:100,sortable: true, hidden:true},
            	{header:'扣除小计',dataIndex:'KCXJ',width:100,sortable: true, hidden:true},
            	
            	//{header:'备注',dataIndex:'BZ',width:150,sortable: true},
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
    onAddClick: function() {
    	var win = this.xzkcInsertWindow;
    	win.xzkcForm.getForm().reset();
//    	win.constructionForm.idHidden.setValue(0);
    	win.show();
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.xzkcUpdateWindow;
   		    	//win.constructionForm.getForm().reset();
             	//win.constructionForm.product.setDisabled(true);//不允许修改帐户编码
   		    	win.show();
   		    	win.xzkcForm.rybh.setValue(vrecord.data.RYBH);
   		    	win.xzkcForm.yf.setValue(vrecord.data.YF);
   		    	win.xzkcForm.qqkc.setValue(vrecord.data.QQKC);
   		    	win.xzkcForm.ylbx.setValue(vrecord.data.YLBX);
   		    	win.xzkcForm.yb.setValue(vrecord.data.YB);
   		    	win.xzkcForm.sybx.setValue(vrecord.data.SYBX);
   		    	win.xzkcForm.sbxj.setValue(vrecord.data.SBXJ);
   		    	win.xzkcForm.zfgjj.setValue(vrecord.data.ZFGJJ);
   		    	win.xzkcForm.gs.setValue(vrecord.data.GS);
   		    	win.xzkcForm.kcxj.setValue(vrecord.data.KCXJ);
   		    	win.xzkcForm.bz.setValue(vrecord.data.BZ);
//   		    	win.constructionForm.getForm().loadRecord(vrecord);
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
//			       		url: 'delete', 
			       	       url: PROJECT_NAME+""+SRMX_DELETE_URL,
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
//				               constructionGrid.store.reload();
				               constructionGrid.xzkcWindow.xzkcGrid.store.reload();
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
                            {name:'ID'},{name:'RYBH'},{name:'RYXM'},{name:'YF'},{name:'JBGZ'},
                            {name:'JXGZ'},{name:'JBF'},{name:'QT'},{name:'WCBZ'},{name:'YFGZ'},
                            {name:'SFGZ'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'人员编号&人员姓名...',  
               	    },
    	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			  }
                  },'-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
     		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
    		        	    if(btn=="yes"){ 
    		        	    	window.open(PROJECT_NAME+"/resources/js/rsgl/rsxzinfo.xls");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		        '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                  '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
       		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
    		        	    if(btn=="yes"){ 		        	    	
    		        	    	var fileName = "薪资管理信息";
    		        	    	var code = Ext.getCmp('code').getValue();
    		        	    	var url = PROJECT_NAME + "/rsgl/YRsXzInfo/export?fileName="+fileName+"&code="+code;
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
        this.xzkcWindow = new XzkcWindow();
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
                
                {header:'人员编号',dataIndex:'RYBH',width:100,sortable: true},
                {header:'人员姓名',dataIndex:'RYXM',width:100,sortable: true},
            	{header:'月份',dataIndex:'YF',width:100,sortable: true, hidden:true},
            	{header:'基本工资',dataIndex:'JBGZ',width:100,sortable: true, hidden:true},
                {header:'绩效工资',dataIndex:'JXGZ',width:100,sortable: true},
                {header:'加班费',dataIndex:'JBF',width:100,sortable: true, hidden:true},
            	{header:'其他',dataIndex:'QT',width:100,sortable: true},
            	{header:'午餐补助',dataIndex:'WCBZ',width:100,sortable: true, hidden:true},
            	{header:'应发工资',dataIndex:'YFGZ',width:100,sortable: true},
            	{header:'实发工资',dataIndex:'SFGZ',width:100,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true, hidden:true},
            	{header: '操作', width: 180, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看薪资扣除</span></a>&nbsp;&nbsp;&nbsp"+
					   		"<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
					   		"<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
					   		"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
					   		"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>";
            		}
				},
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
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
//    	win.constructionForm.getForm().reset();
    	var url = "xzglAddView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("增加薪资信息");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onLook: function() {
    	var win = this.xzkcWindow;
    	win.show();
    	var records = this.getSelectionModel().getSelections();
    	var rybh = records[0].get("RYBH");
    	win.xzkcGrid.store.baseParams= {rybh:rybh};
    	win.xzkcGrid.store.load({params:{start:0,limit:PAGESIZE,rybh:rybh}});
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
		var url = "xzglXgView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("薪资管理修改");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
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

