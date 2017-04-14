var USER_GRID_STORE_URL = 'getSgzxxList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var yearll=new Ext.form.TextField();  
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能50');
    	this.rybh = this.createTextField('人员编号', 'rybh', '90%','',null,100,'长度超过不能50');
    	this.ks_id = this.createTextField('所属科室名称', 'ks_id', '90%','',null,100,'长度超过不能50');
    	this.zcid = this.createTextField('职称名称', 'zcid', '90%','',null,100,'长度超过不能50');
    	this.cplx = this.createTextField('产品类别', 'cplx', '90%','',null,100,'长度超过不能50');
    	this.yxq = new Ext.form.DateField({
    		fieldLabel : '有效期',
    		name : "yxq",
    		format : "Y-m-d",
    		anchor : '90%',
    		editable : false,// 不能手动输入
    		blankText : '请选择时间'
    	});
    	this.kczsb = this.createTextField('可操作设备', 'kczsb', '90%','',null,100,'长度超过不能50');
    	this.xgrq = new Ext.form.DateField({
    		fieldLabel : '修改日期',
    		name : "xgrq",
    		format : "Y-m-d",
    		anchor : '90%',
    		editable : false,// 不能手动输入
    		blankText : '请选择时间'
    	});
    	this.xgr_id = this.createTextField('修改人名称', 'xgr_id', '90%','',null,100,'长度超过不能50');
    	this.bz = new Ext.form.TextArea({
    	             fieldLabel: '备注',
    	             name: 'bz',
    	             readOnly: false,
    	             anchor: '90%',
    	             height:100,
    	             maxLength: 256,
    	             maxLengthText: '256！'
    	         });    	

    	
    	 this.sgzbh.allowBlank = false;
         this.rybh.allowBlank = false;
         this.ks_id.allowBlank = false;
         this.zcid.allowBlank = false;
         this.cplx.allowBlank = false;
         this.yxq.allowBlank = false;
         this.kczsb.allowBlank = false;
         this.xgrq.allowBlank = true;
         this.xgr_id.allowBlank = true;
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
                         this.sgzbh
                     ]  
                 }), 
                 
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
                            this.zcid
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
                            this.cplx
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.yxq
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
                            this.kczsb
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
                            this.xgrq
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
                        hidden:true,
                        labelAlign:'right',  
                        items:[  
                            this.xgr_id
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
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
pnRow5

						
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

/*************************************** ConstructionXgForm组件 **************************************************/
ConstructionXgForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能50');
    	this.rybh = this.createTextField('人员编号', 'rybh', '90%','',null,100,'长度超过不能50');
    	this.ks_id = this.createTextField('所属科室名称', 'ks_id', '90%','',null,100,'长度超过不能50');
    	this.zcid = this.createTextField('职称名称', 'zcid', '90%','',null,100,'长度超过不能50');
    	this.cplx = this.createTextField('产品类别', 'cplx', '90%','',null,100,'长度超过不能50');
    	this.yxq = new Ext.form.DateField({
    		fieldLabel : '有效期',
    		name : "yxq",
    		format : "Y-m-d",
    		anchor : '90%',
    		editable : false,// 不能手动输入
    		blankText : '请选择时间'
    	});
    	this.kczsb = this.createTextField('可操作设备', 'kczsb', '90%','',null,100,'长度超过不能50');
    	this.xgrq = new Ext.form.DateField({
    		fieldLabel : '修改日期',
    		name : "xgrq",
    		format : "Y-m-d",
    		anchor : '90%',
    		editable : false,// 不能手动输入
    		blankText : '请选择时间'
    	});
    	this.xgr_id = this.createTextField('修改人名称', 'xgr_id', '90%','',null,100,'长度超过不能50');
    	this.bz = new Ext.form.TextArea({
    	             fieldLabel: '备注',
    	             name: 'bz',
    	             readOnly: false,
    	             anchor: '90%',
    	             height:100,
    	             maxLength: 256,
    	             maxLengthText: '256！'
    	         });    	

    	
    	 this.sgzbh.allowBlank = false;
         this.rybh.allowBlank = false;
         this.ks_id.allowBlank = false;
         this.zcid.allowBlank = false;
         this.cplx.allowBlank = false;
         this.yxq.allowBlank = false;
         this.kczsb.allowBlank = false;
         this.xgrq.allowBlank = true;
         this.xgr_id.allowBlank = true;
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
                         this.sgzbh
                     ]  
                 }), 
                 
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
                            this.zcid
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
                            this.cplx
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.yxq
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
                            this.kczsb
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
//                        hidden:true,
                        labelAlign:'right',  
                        items:[  
                            this.xgrq
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
                        hidden:true,
                        labelAlign:'right',  
                        items:[  
                            this.xgr_id
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
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
pnRow5

						
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
/*** ************************************************************************ LookForm组件 * *****************************************************************************************************/
LookForm = Ext.extend(Ext.ux.Form, {

	constructor : function() {
		this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能50');
    	this.rybh = this.createTextField('人员编号', 'rybh', '90%','',null,100,'长度超过不能50');
    	this.ks_id = this.createTextField('所属科室名称', 'ks_id', '90%','',null,100,'长度超过不能50');
    	this.zcid = this.createTextField('职称名称', 'zcid', '90%','',null,100,'长度超过不能50');
    	this.cplx = this.createTextField('产品类别', 'cplx', '90%','',null,100,'长度超过不能50');
    	this.yxq = new Ext.form.DateField({
    		fieldLabel : '有效期',
    		name : "yxq",
    		format : "Y-m-d",
    		anchor : '90%',
    		editable : false,// 不能手动输入
    		blankText : '请选择时间'
    	});
    	this.kczsb = this.createTextField('可操作设备', 'kczsb', '90%','',null,100,'长度超过不能50');
    	this.xgrq = new Ext.form.DateField({
    		fieldLabel : '修改日期',
    		name : "xgrq",
    		format : "Y-m-d",
    		anchor : '90%',
    		editable : false,// 不能手动输入
    		blankText : '请选择时间'
    	});
    	this.xgr_id = this.createTextField('修改人名称', 'xgr_id', '90%','',null,100,'长度超过不能50');
    	this.bz = new Ext.form.TextArea({
    	             fieldLabel: '备注',
    	             name: 'bz',
    	             readOnly: false,
    	             anchor: '90%',
    	             height:100,
    	             maxLength: 256,
    	             maxLengthText: '256！'
    	         });    	
    	
		// this.ypbh.allowBlank = false;
    	 this.sgzbh.allowBlank = false;
         this.rybh.allowBlank = false;
         this.ks_id.allowBlank = false;
         this.zcid.allowBlank = false;
         this.cplx.allowBlank = false;
         this.yxq.allowBlank = false;
         this.kczsb.allowBlank = false;
         this.xgrq.allowBlank = false;
         this.xgr_id.allowBlank = false;
         this.bz.allowBlank = true;

         this.sgzbh.readOnly = true;
         this.rybh.readOnly = true;
         this.ks_id.readOnly = true;
         this.zcid.readOnly = true;
         this.cplx.readOnly = true;
         this.yxq.readOnly = true;
         this.kczsb.readOnly = true;
         this.xgrq.readOnly = true;
         this.xgr_id.readOnly = true;
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
                         this.sgzbh
                     ]  
                 }), 
                 
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
                            this.zcid
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
                            this.cplx
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.yxq
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
                            this.kczsb
                        ]  
                    }), 
                    
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
                            this.xgr_id
                        ]  
                    }), 
                    
                    new Ext.Panel({  
                        columnWidth:.5,  
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
			anchor : '80%',
			autoHeight : true,
			layoutConfig : {
				columns : 1
			},
			labelWidth : 90,
			labelAlign : 'right',
			frame : true,
			bodyStyle : "padding: 5px 5px 0",
			width : '100%',
			items : [
			// this.idHidden,
			pnRow1, 
			pnRow2, 
			pnRow3,
			pnRow4, 
			pnRow5
			
			],
			buttonAlign : 'center',
			buttons : [ {
				text : '关闭',
				width : 20,
				iconCls : 'delete',
				handler : this.onCloseClick,
				scope : this
			} ]
		});
	},
	onCloseClick : function() { // 关闭
		this.ownerCt.hide();
	}
});
/** *************************************ConstructionLookWindow组件************************************************* */
ConstructionLookWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor : function() {
		this.lookForm = new LookForm();
		ConstructionLookWindow.superclass.constructor.call(this, {
			title : "查看信息",
			width : 900,
			autoHeight : true,
			resizable : false,
			plain : true,
			modal : true,
			autoScroll : true,
			closeAction : 'hide',
			items : [ this.lookForm ]
		});
	}
});

/********************IpasAssobjBankmemberUploadWindow组件***********************************************************************************/
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
/********************IpasAssobjBankmemberUpload组件*************************************************************************************/
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
/** *************************************ActDealWindow组件************************************************* */
ActDealWindow = Ext
		.extend(
				Ext.Window,
				{
					constructor : function(grid) {
						ActDealWindow.superclass.constructor
								.call(
										this,
										{
											width : 800,
											anchor : '100%',
											maximized : true,
											height : 400,
											resizable : false,
											plain : true,
											modal : true,
											autoScroll : true,
											closeAction : 'close',
											html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src=""></iframe>'
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
            title: "增加信息",
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
    	this.constructionXgForm = new ConstructionXgForm();
    	this.constructionXgForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionXgForm.buttons[1].show();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionXgForm]
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
                                                                                   
{name:'ID'},{name:'SGZBH'},{name:'RYBH'},{name:'KS_ID'},
{name:'ZCID'},{name:'CPLX'},{name:'YXQ'},{name:'KCZSB'},
{name:'XGRQ'},{name:'XGR_ID'},{name:'BZ'},
                           
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'上岗证编号&人员编号...',  
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
                  '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
  		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
  		    			if(btn=="yes"){ 
		        	    	window.open("/zjyw/resources/js/sgzgl/sgzgl.xls");
		        	   }
		        	 });
		    	 },scope:this},
	 		    	   '-',	
				    	 {xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
				    	 {xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
			   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
					        	    if(btn=="yes"){ 		        	    	
					        	    	var fileName = "上岗证管理";
					        	    	var code = Ext.getCmp('code').getValue();
					        	    	var url = PROJECT_NAME + "/sgzgl/YsgzXx/sgzexport?fileName="+fileName+"&code="+code;
					        	    	url = encodeURI(url);
					        	    	url = encodeURI(url);
					        	    	window.open(url);
					        	   }
					        	 });
				    		}
			   			}
            ]
        });
    	
    	this.constructionLookWindow = new ConstructionLookWindow();
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
                                          {header:'id',dataIndex:'ID',width:150,sortable: true,hidden:true},
                                          
                                         
                                          {header:'上岗证编号',dataIndex:'SGZBH',width:100,sortable: true},
                                          {header:'人员编号',dataIndex:'RYBH',width:100,sortable: true,hidden:true},
                                      	{header:'所属科室名称',dataIndex:'KS_ID',width:100,sortable: true},
                                      	{header:'职称名称',dataIndex:'ZCID',width:100,sortable: true,hidden:true},
                                          {header:'产品类别',dataIndex:'CPLX',width:100,sortable: true},
                                      	{header:'有效期',dataIndex:'YXQ',width:100,sortable: true },
                                      	{header:'可操作设备',dataIndex:'KCZSB',width:100,sortable: true},
                                          {header:'修改日期',dataIndex:'XGRQ',width:100,sortable: true,hidden:true},
                                      	{header:'修改人名称',dataIndex:'XGR_ID',width:100,sortable: true,hidden:true},
                                      	{header:'备注',dataIndex:'BZ',width:100,sortable: true,hidden:true},
                                      	 {header : '操作',width : 180,dataIndex : 'sbbh',align : "center",sortable : true,hidden : false,renderer : function(value,cellmeta,record)

											{
                                      		return "<a href='javascript:;' onclick='constructionGrid. onLook()' style='text-decoration:none;'>"
											+ "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
							"<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
							"<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
							"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
							"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>";
								}
					}
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
    onLook: function(){
		var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
		var url = "sgzxxCkView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("上岗证信息查看");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},

//	点击增加按钮弹出jsp页面
	  onAddClick: function() {
	    	var win = this.constructionInsertWindow;
//	    	win.constructionForm.getForm().reset();
	    	var url = "sgzAddView?id="+id;  	
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("上岗证信息增加");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
	    },


    onUploadClick: function(){    // 导入EXCEL数据
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
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
			var url = "sgzxxXgView?id="+id;  	
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("上岗证信息修改");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
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
    		var valStr = val.constructor == Date ? Ext.util.Format.date(val, 'Y-m-d H:i:s') : formatDate(new Date(val["time"]),"yyyy-MM-dd");    		
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
