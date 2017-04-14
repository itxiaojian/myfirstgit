var USER_GRID_STORE_URL = 'getKssrList';
var SRMX_URL = '/cwgl/YCwKssrmx/getKssrmxList';  //科室收入明细信息
var SRMX_SAVE_URL = '/cwgl/YCwKssrmx/save';      //科室收入明细信息保存路径
var SRMX_UPDATE_URL = '/cwgl/YCwKssrmx/update';  //科室收入明细信息修改路径
var SRMX_DELETE_URL = '/cwgl/YCwKssrmx/delete';  //科室收入明细信息删除路径
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
    	this.ksbh = this.createTextField('科室编号', 'ksbh', '90%','',null,50,'长度超过不能50');
//    	this.ksmc = this.createTextField('科室名称', 'ksmc', '90%','',null,50,'长度超过不能50');
    	//科室名称从组织架构获取
    	this.ksmc = new zjyw.OrgSingelSelectAll('科室名称','ksmc','ksmc','90%');
    	this.jybh = this.createTextField('检验编号', 'jybh', '90%','',null,50,'长度超过不能50');
    	this.ypmc = this.createTextField('项目名称', 'ypmc', '90%','',null,50,'长度超过不能50');
    	this.ypxq = new Ext.form.TextArea({
            fieldLabel: '样品详情',
            name: 'ypxq',
            readOnly: false,
            anchor: '90%',
            height:40,
//            maxLength: 500,
//            maxLengthText: '500！'
        });
    	this.cbje = new Ext.form.NumberField({
            fieldLabel: '成本金额',
            name: 'cbje',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.skje = new Ext.form.NumberField({
            fieldLabel: '收款金额',
            name: 'skje',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.hssr = new Ext.form.NumberField({
            fieldLabel: '核算收入',
            name: 'hssr',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.lrr = this.createTextField('录入人', 'lrr', '90%','',null,50,'长度超过不能50');
    	this.lrrq =  new Ext.form.DateField({
			fieldLabel: '录入日期',
			name: "lrrq",
			format: "Y-m-d",
			anchor: '90%',
			hidden:true,
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '90%',
            height:80,
            maxLength: 300,
            maxLengthText: '300！'
        });
    	
    	this.ksbh.allowBlank = false;
    	this.ksmc.allowBlank = false;
    	this.jybh.allowBlank = false;
    	this.ypmc.allowBlank = false;
    	this.ypxq.allowBlank = false;
    	this.cbje.allowBlank = false;
    	this.skje.allowBlank = false;
    	
    	this.hssr.allowBlank = false;
    	this.lrr.allowBlank = false;
    	this.lrrq.allowBlank = false;
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
                        this.ksbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ksmc
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
                        this.jybh
                    ]  
                }), 
               
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ypmc
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
                        this.cbje
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.skje
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
                        this.hssr
                    ]  
                }), 
//                new Ext.Panel({  
//                    columnWidth:.5,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:80,  
//                    labelAlign:'right',  
//                    items:[  
//                        this.lrr
//                    ]  
//                }), 
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
                        this.lrrq
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
                        this.ypxq
                    ]  
                }), 
            ]  
        });
    	var pnRow7=new Ext.Panel({  
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
						pnRow6,
						pnRow7
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
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

/*************************************** ConstructionUpdateForm组件 **************************************************/
ConstructionUpdateForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.ksbh = this.createTextField('科室编号', 'ksbh', '90%','',null,50,'长度超过不能50');
//    	this.ksmc = this.createTextField('科室名称', 'ksmc', '90%','',null,50,'长度超过不能50');
    	//科室名称从组织架构获取
    	this.ksmc = new zjyw.OrgSingelSelectAll('科室名称','ksmc','ksmc','90%');
    	this.jybh = this.createTextField('检验编号', 'jybh', '90%','',null,50,'长度超过不能50');
    	this.ypmc = this.createTextField('项目名称', 'ypmc', '90%','',null,50,'长度超过不能50');
    	this.ypxq = this.createTextField('样品详情', 'ypxq', '90%','',null,50,'长度超过不能50');
    	this.cbje = new Ext.form.NumberField({
            fieldLabel: '成本金额',
            name: 'cbje',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.skje = new Ext.form.NumberField({
            fieldLabel: '收款金额',
            name: 'skje',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.hssr = new Ext.form.NumberField({
            fieldLabel: '核算收入',
            name: 'hssr',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.lrr = this.createTextField('录入人', 'lrr', '90%','',null,50,'长度超过不能50');
    	this.lrrq =  new Ext.form.DateField({
			fieldLabel: '录入日期',
			name: "lrrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.xgje = new Ext.form.NumberField({
            fieldLabel: '修改金额',
            name: 'xgje',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.xgr = this.createTextField('修改人', 'xgr', '90%','',null,50,'长度超过不能50');
    	this.xgrq =  new Ext.form.DateField({
			fieldLabel: '修改日期',
			name: "xgrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.xgyy = this.createTextField('修改原因', 'xgyy', '90%','',null,200,'长度超过不能200');
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '90%',
            height:80,
            maxLength: 500,
            maxLengthText: '500！'
        });
    	
    	this.ksbh.allowBlank = false;
    	this.ksmc.allowBlank = false;
    	this.jybh.allowBlank = false;
    	this.ypmc.allowBlank = false;
    	this.ypxq.allowBlank = false;
    	this.cbje.allowBlank = false;
    	this.skje.allowBlank = false;
    	this.hssr.allowBlank = false;
    	this.lrr.allowBlank = false;
    	this.lrrq.allowBlank = false;
    	this.xgje.allowBlank = false;
    	this.xgr.allowBlank = false;
    	this.xgrq.allowBlank = false;
    	this.xgyy.allowBlank = false;
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
                        this.ksbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ksmc
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
                        this.jybh
                    ]  
                }), 
               
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ypmc
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
                        this.ypxq
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.cbje
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
                        this.skje
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.hssr
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
                        this.lrr
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.lrrq
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
                        this.xgje
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.xgr
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
                        this.xgrq
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.xgyy
                    ]  
                }), 
            ]  
        });
    	var pnRow8=new Ext.Panel({  
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
    	ConstructionUpdateForm.superclass.constructor.call(this, {
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
						pnRow8
            ],
            buttonAlign :'center',
            buttons: [
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
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

/*************************************** SrmxForm组件 **************************************************/
SrmxForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.jybh = this.createTextField('检验编号', 'jybh', '90%','',null,50,'长度超过不能50');
    	this.fymc = this.createTextField('费用名称', 'fymc', '90%','',null,50,'长度超过不能50');
    	this.fylx = this.createTextField('费用类型', 'fylx', '90%','',null,50,'长度超过不能50');
    	this.fynr = new Ext.form.TextArea({
            fieldLabel: '费用内容',
            name: 'fynr',
            readOnly: false,
            anchor: '90%',
            height:80,
            maxLength: 500,
            maxLengthText: '500！'
        });
    	this.je = new Ext.form.NumberField({
            fieldLabel: '金额',
            name: 'je',
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
    	
    	this.jybh.allowBlank = false;
    	this.fymc.allowBlank = false;
    	this.fylx.allowBlank = false;
    	this.fynr.allowBlank = false;
    	this.je.allowBlank = false;
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
                        this.jybh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.fymc
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
                        this.fylx
                    ]  
                }), 
               
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.je
                    ]  
                }),
            ]  
        });
    	var pnRow3=new Ext.Panel({  
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
                        this.fynr
                    ]  
                }), 
            ]  
        });
    	var pnRow4=new Ext.Panel({  
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
    	
    	
    	SrmxForm.superclass.constructor.call(this, {
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
						pnRow4
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
        	// var jybh = record[0].get("JYBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'save', 
                 url: PROJECT_NAME+""+SRMX_SAVE_URL,
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.srmxWindow.srmxGrid.srmxInsertWindow.hide();
//                 	constructionGrid.srmxWindow.srmxGrid.vbbar.doLoad(constructionGrid.srmxWindow.srmxGrid.vbbar.cursor);
                 	constructionGrid.srmxWindow.srmxGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
        	var record = constructionGrid.srmxWindow.srmxGrid.getSelectionModel().getSelections();
        	var jybh = record[0].get("JYBH");
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
                 	constructionGrid.srmxWindow.srmxGrid.srmxUpdateWindow.hide();
                 	constructionGrid.srmxWindow.srmxGrid.store.load({params:{start:0,limit:PAGESIZE,jybh:jybh}});
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
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "新增科室收入信息",
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
	ConstructionUpdateForm : null,
    constructor: function() {
    	this.ConstructionUpdateForm = new ConstructionUpdateForm();
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改科室收入信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.ConstructionUpdateForm]
        });
    }
});

/*****************************SrmxWindow***********************************/
SrmxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.srmxGrid = new SrmxGrid();
    	SrmxWindow.superclass.constructor.call(this, {
    		title:'收入明细',
    		width: 1000,
//    		height:300,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.srmxGrid],
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

/***************************************SrmxInsertWindow组件**************************************************/
SrmxInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.srmxForm = new SrmxForm();
        this.srmxForm.buttons[0].show();   //显示添加按钮
    	this.srmxForm.buttons[1].hide();   //隐藏修改按钮
    	SrmxInsertWindow.superclass.constructor.call(this, {
            title: "新增科室收入明细",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.srmxForm]
        });
    }
});

/***************************************SrmxUpdateWindow组件**************************************************/
SrmxUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.srmxForm = new SrmxForm();
    	this.srmxForm.buttons[0].hide();   //隐藏添加按钮
    	this.srmxForm.buttons[1].show();   //显示修改按钮
    	SrmxUpdateWindow.superclass.constructor.call(this, {
        	title: "修改科室收入明细",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.srmxForm]
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
					Ext.MessageBox.alert("系统提示：","上传失败！");
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

/**************************SrmxGrid*******************************************/
SrmxGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+SRMX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                            {name:'ID'},{name:'JYBH'},{name:'FYMC'},{name:'FYLX'},{name:'FYNR'},
					        {name:'JE'}
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
   	
        this.srmxInsertWindow = new SrmxInsertWindow();       
        this.srmxUpdateWindow = new SrmxUpdateWindow();
        
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        SrmxGrid.superclass.constructor.call(this, {
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
                  {header:'检验编号',dataIndex:'JYBH',width:100,sortable: true},
                  {header:'费用名称',dataIndex:'FYMC',width:120,sortable: true},
                  {header:'费用类型',dataIndex:'FYLX',width:100,sortable: true},
                  {header:'费用内容',dataIndex:'FYNR',width:100,sortable: true},
                  {header:'金额',dataIndex:'JE',width:100,sortable: true},
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
    	var win = this.srmxInsertWindow;
    	win.srmxForm.getForm().reset();
//    	win.constructionForm.idHidden.setValue(0);
    	win.show();
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.srmxUpdateWindow;
   		    	//win.constructionForm.getForm().reset();
             	//win.constructionForm.product.setDisabled(true);//不允许修改帐户编码
   		    	win.show();
   		    	win.srmxForm.jybh.setValue(vrecord.data.JYBH);
   		    	win.srmxForm.fymc.setValue(vrecord.data.FYMC);
   		    	win.srmxForm.fylx.setValue(vrecord.data.FYLX);
   		    	win.srmxForm.fynr.setValue(vrecord.data.FYNR);
   		    	win.srmxForm.je.setValue(vrecord.data.JE);
   		    	win.srmxForm.bz.setValue(vrecord.data.BZ);
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
				               constructionGrid.srmxWindow.srmxGrid.store.reload();
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
                            {name:'ID'},{name:'KSBH'},{name:'KSMC'},{name:'JYBH'},{name:'YPMC'},
                            {name:'YPXQ'},{name:'CBJE'},{name:'SKJE'},{name:'HSSR'},{name:'LRR'},
                            {name:'LRRQ'},{name:'XGJE'},{name:'XGR'},{name:'XGRQ'},{name:'XGYY'},
                            {name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'科室编号&科室名称...',  
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
    		        	    	window.open(PROJECT_NAME+"/resources/js/cwgl/cwkssr.xls");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		        '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                  '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
       		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
    		        	    if(btn=="yes"){ 		        	    	
    		        	    	var fileName = "科室收入";
    		        	    	var code = Ext.getCmp('code').getValue();
    		        	    	var url = PROJECT_NAME + "/cwgl/YCwKssr/export?fileName="+fileName+"&code="+code;
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
        this.srmxWindow = new SrmxWindow();
        
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
               
                {header:'科室编号',dataIndex:'KSBH',width:80,sortable: true},
                {header:'科室名称',dataIndex:'KSMC',width:80,sortable: true},
                {header:'检验编号',dataIndex:'JYBH',width:80,sortable: true},
            	{header:'项目名称',dataIndex:'YPMC',width:80,sortable: true},
            	{header:'样品详情',dataIndex:'YPXQ',width:80,sortable: true, hidden:true},
            	{header:'成本金额',dataIndex:'CBJE',width:80,sortable: true, hidden:true},
            	{header:'收款金额',dataIndex:'SKJE',width:80,sortable: true, hidden:true},
            	{header:'核算收入',dataIndex:'HSSR',width:80,sortable: true, hidden:true},
            	{header:'录入人',dataIndex:'LRR',width:80,sortable: true, hidden:true},
            	{header:'录入日期',dataIndex:'LRRQ',width:80,sortable: true, hidden:true},
            	{header:'修改金额',dataIndex:'XGJE',width:80,sortable: true, hidden:true},
            	{header:'修改人',dataIndex:'XGR',width:80,sortable: true},
            	{header:'修改日期',dataIndex:'XGRQ',width:80,sortable: true, hidden:true},
            	{header:'修改原因',dataIndex:'XGYY',width:80,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:80,sortable: true},
            	 {header: '操作', width: 180, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看科室收入明细</span></a>&nbsp;&nbsp;&nbsp"+
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
    	var url = "kssrAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("新增科室收入信息");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onLook: function() {
    	var win = this.srmxWindow;
    	win.show();
    	var records = this.getSelectionModel().getSelections();
    	var jybh = records[0].get("JYBH");
    	win.srmxGrid.store.baseParams= {jybh:jybh};
    	win.srmxGrid.store.load({params:{start:0,limit:PAGESIZE,jybh:jybh}});
    	
    },
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onModifyClick: function() {
    	// var records=this.getSelectionModel().getSelections();
   		// if(records.length > 0) {
   			// if(records.length == 1){
   				// vrecord = records[0];
   		    	// var win = this.constructionUpdateWindow;
   		    	// //win.constructionForm.getForm().reset();
             	// //win.constructionForm.product.setDisabled(true);//不允许修改帐户编码
   		    	// win.show();
   		    	// win.ConstructionUpdateForm.ksbh.setValue(vrecord.data.KSBH);
   		    	// win.ConstructionUpdateForm.ksmc.setValue(vrecord.data.KSMC);
   		    	// win.ConstructionUpdateForm.jybh.setValue(vrecord.data.JYBH);
   		    	// win.ConstructionUpdateForm.ypmc.setValue(vrecord.data.YPMC);
   		    	// win.ConstructionUpdateForm.ypxq.setValue(vrecord.data.YPXQ);
   		    	// win.ConstructionUpdateForm.cbje.setValue(vrecord.data.CBJE);
   		    	// win.ConstructionUpdateForm.skje.setValue(vrecord.data.SKJE);
   		    	// win.ConstructionUpdateForm.hssr.setValue(vrecord.data.HSSR);
   		    	// win.ConstructionUpdateForm.lrr.setValue(vrecord.data.LRR);
   		    	// win.ConstructionUpdateForm.lrrq.setValue(vrecord.data.LRRQ);
   		    	// win.ConstructionUpdateForm.xgje.setValue(vrecord.data.XGJE);
   		    	// win.ConstructionUpdateForm.xgr.setValue(vrecord.data.XGR);
   		    	// win.ConstructionUpdateForm.xgrq.setValue(vrecord.data.XGRQ);
   		    	// win.ConstructionUpdateForm.xgyy.setValue(vrecord.data.XGYY);
   		    	// win.ConstructionUpdateForm.bz.setValue(vrecord.data.BZ);
// //   		    	win.constructionForm.getForm().loadRecord(vrecord);
   			// }else{
   				// Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			// }
   		// }else{
   			// Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		// }    	
    // },
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
				var url = "kssrUpdateView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("修改科室收入信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
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

