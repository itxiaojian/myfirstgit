var USER_GRID_STORE_URL = 'getBzxxList';
var PAGESIZE=20;
var CBMX_URL = '/sfgl/Ysfxmxx/getXmxxList';//成本明细信息
var CBMX_SAVE_URL = '/sfgl/Ysfxmxx/save';//成本明细信息保存路径
var CBMX_UPDATE_URL = '/sfgl/Ysfxmxx/update';//成本明细信息删除路径
var CBMX_DELETE_URL = '/sfgl/Ysfxmxx/delete';//成本明细信息删除路径
var ENTITY_URL_UPLOAD = 'bzxxupload';
var ENTITY_URL_XMXXUPLOAD='xmxxupload'
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

/*************************************** XmxxConstructionForm组件 **************************************************/
XmxxConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.sfbzbh = this.createTextField('收费标准编号', 'sfbzbh', '90%','',null,50,'长度超过不能50');
    	this.xmbh = this.createTextField('项目编号', 'xmbh', '90%','',null,50,'长度超过不能50');
    	this.xmmc = this.createTextField('项目名称', 'xmmc', '90%','',null,50,'长度超过不能50');
    	this.cplx = this.createTextField('产品类型', 'cplx', '90%','',null,50,'长度超过不能50');
    	this.cplxbh = this.createTextField('产品类型编号', 'cplxbh', '90%','',null,50,'长度超过不能50');
    	this.jldw = this.createCombo('计量单位', 'ZDMC', 'ZDMC', 'jldw', '90%', PROJECT_NAME+'/sfgl/Ysfxmxx/getDicByjb');
		this.jldw.store.load();
		this.jldw.allowBlank = false;
		
    	this.dj = new Ext.form.NumberField({
            fieldLabel: '单价',
            name: 'dj',
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
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         }); 
    	
    	this.sfbzbh.allowBlank = false;
    	this.xmbh.allowBlank = false;
    	this.xmmc.allowBlank = false;
    	this.cplx.allowBlank = true;
    	this.cplxbh.allowBlank = true;
    	this.dj.allowBlank = true;
    	this.jldw.allowBlank = false;
    	this.bz.allowBlank = true;
    	
    	
    	var pnRow1=new Ext.Panel({  
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
                        this.sfbzbh
                    ]  
                }), 
                
            ]  
        });
    	
    	var pnRow2=new Ext.Panel({  
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
                        this.xmbh
                    ]  
                }), 
               
               
            ]  
        });
    	
    	var pnRow3=new Ext.Panel({  
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
                           this.xmmc
                       ]  
                   }),
            ]  
        });
    	
    	var pnRow4=new Ext.Panel({  
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
                        this.cplx
                    ]  
                }), 
               
               
            ]  
        });
    	
    	var pnRow5=new Ext.Panel({  
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
                           this.cplxbh
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
                        this.jldw
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
                        this.dj
                    ]  
                }), 
            ]  
        });
    	
    	var pnRow8=new Ext.Panel({  
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
    	
    	XmxxConstructionForm.superclass.constructor.call(this, {
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
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.xmxxaddFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.xmxxupdateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
              ]
        });
     },
     xmxxaddFormClick: function() {
         if(this.getForm().isValid()) {
        	// var records=constructionGrid.getSelectionModel().getSelections();
         	// var jybh = records[0].get("JYBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'save', 
                 url: PROJECT_NAME+""+CBMX_SAVE_URL,
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.xmxxWindow.xmxxGrid.xmxxConstructionInsertWindow.hide();
                 	constructionGrid.xmxxWindow.xmxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
					constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
                 }
         	});
         }
     },
     xmxxupdateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	var record=constructionGrid.xmxxWindow.xmxxGrid.getSelectionModel().getSelections();
        	var sfbzbh = record[0].get("SFBZBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'update', 
                 url: PROJECT_NAME+""+CBMX_UPDATE_URL,
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	constructionGrid.xmxxWindow.xmxxGrid.xmxxConstructionUpdateWindow.hide();
                 	constructionGrid.xmxxWindow.xmxxGrid.store.load({params:{start:0,limit:PAGESIZE,sfbzbh:sfbzbh}});
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



/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.sfbzbh = this.createTextField('收费标准编号', 'sfbzbh', '90%','',null,100,'长度超过不能50');
    	this.sfbzmc = this.createTextField('收费标准名称', 'sfbzmc', '90%','',null,100,'长度超过不能50');
    	this.cpmc = this.createTextField('产品名称', 'cpmc', '90%','',null,100,'长度超过不能50');
    	this.cplx = this.createTextField('产品类型', 'cplx', '90%','',null,100,'长度超过不能50');
    	this.ggxh = this.createTextField('规格型号', 'ggxh', '90%','',null,100,'长度超过不能50');
    	this.jybz_id = this.createTextField('检验标准编号', 'jybz_id', '90%','',null,100,'长度超过不能50');
    	this.dw_id = this.createTextField('单位名称', 'dw_id', '90%','',null,100,'长度超过不能50');
//    	this.jybz_id = new Ext.form.TextField({
//    		id:'jybz_id',
//            fieldLabel: '检验标准编号',
//            name: 'jybz_id',
//            anchor: '150%'
//            	
//        });
    	this.jyxm_id = this.createTextField('检验项目编号', 'jyxm_id', '90%','',null,100,'长度超过不能50');
//    	this.bzmc = this.createTextField('检验标准名称', 'bzmc', '90%','',null,100,'长度超过不能50');
    	this.bzmc = new Ext.form.TextField({
//    		id:'bzmc', 如果加这个id会导致弹出的form中有多行相同字段文本框和内容不显示
            fieldLabel: '检验标准名称',
            name: 'bzmc',
            anchor: '90%'
        });
    	this.xmmc = this.createTextField('检验项目名称', 'xmmc', '90%','',null,100,'长度超过不能50');
//    	this.jyxm_id = new wxpt.OrgSingelSelectAll('检验项目名称','sybm','jyxm_id','90%');
    	//做下拉框
    	
		
		
		this.je = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>金额',
            name: 'je',
            xtype: 'textfield',
            anchor: '90%',
            blankText: '该选项为必填项,请输入内容...',
            //保留小数点后两位
            regex:/^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/

        });
		
		
		
		this.zczj = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>注册资金',
            name: 'zczj',
            xtype: 'textfield',
            anchor: '90%',
            blankText: '该选项为必填项,请输入内容...',
            //保留小数点后两位
            regex:/^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/

        });
		this.kssj =  new Ext.form.DateField({
			fieldLabel: ' 开始时间',
			name: "kssj",
			 minValue : new Date(),
//			 maxValue : new Date(),    
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间',
		});
	
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: ' 结束时间',
			name: "jssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			 minValue : new Date(),
			editable:false,//不能手动输入
			blankText: '请选择时间',
		});
		
		//点击弹出form
     	this.ks_id = new zjyw.OrgSingelSelectAll('检验科室名称','ks_id','ks_id','90%');
    	
    	 this.bz = new Ext.form.TextArea({
             fieldLabel: '备注',
             name: 'bz',
             readOnly: false,
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
        this.sfbzbh.allowBlank = false;
        this.sfbzmc.allowBlank = false;
        this.cpmc.allowBlank = false;
        this.cplx.allowBlank = false;
        this.ggxh.allowBlank = true;
        this.jybz_id.allowBlank = false;
        this.jyxm_id.allowBlank = true;
        this.bzmc.allowBlank = true;
        this.xmmc.allowBlank = true;
        this.dw_id.allowBlank = true;
        this.je.allowBlank = false;
        this.kssj.allowBlank = true;
        this.jssj.allowBlank = true;
        this.ks_id.allowBlank = true;
        this.bz.allowBlank = true;
      
//        this.jyBzxxOpenWindow = new JyBzxxOpenWindow();  
//        this.jyXmxxOpenWindow = new JyXmxxOpenWindow();  

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
                        this.sfbzbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.sfbzmc
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
                        this.ggxh
                    ]  
                }), 
            
                
            ]  
        });
        
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.4,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jybz_id
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.1,  
                       layout:'form',  
                       border:false,  
                       labelWidth:20,  
                       labelAlign:'right',  
                       items:[  
                               new Ext.Button({
                                  text:'查找',
                                  constructionForm: this,
                                  handler:function(){
                               		var win = new JyBzxxOpenWindow();
                               		win.constructionForm = this.constructionForm;
                             		win.show();
                             		win.jyBzxxGrid.jyBzxxOpenWindow = win;
                             		win.jyBzxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
                           this.cpmc
                       ]  
                   }), 
//                new Ext.Panel({  
//                    columnWidth:.5,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:90,  
//                    labelAlign:'right',  
//                    items:[  
//                        this.jybz_id
//                    ]  
//                }), 
                   
                   
            
                
            ]  
        });
        
        var pnRow4=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.4,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',                         items:[  
                           this.jyxm_id
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.1,  
                       layout:'form',  
                       border:false,  
                       labelWidth:20,  
                       labelAlign:'right',  
                       items:[  
                               new Ext.Button({
                                  text:'查找',
                                  constructionForm: this,
                                  handler:function(){
                               		var win = new JyXmxxOpenWindow();
                               		win.constructionForm = this.constructionForm;
                             		win.show();
                             		win.jyXmxxGrid.jyXmxxOpenWindow = win;
                             		win.jyXmxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
                        this.dw_id
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
                        this.bzmc
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.xmmc
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
                        this.je
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.kssj
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
                        this.jssj
                    ]  
                }), 
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
            
                
            ]  
        });
       
        
        var pnRow8=new Ext.Panel({  
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
						pnRow8
						
						
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
//                      {text: '增加检验标准信息', width: 20,iconCls: 'add', hidden: false, handler: this.addWtdwClick, scope: this},
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
     addWtdwClick: function() {       //添加委托单位
//     	var constructionForm = new ConstructionForm();
  		var win = this.sbSbxxOpenWindow;
  		win.constructionForm = this;
  		win.show();
  		win.sbSbxxGrid.sbSbxxOpenWindow = win;
  		win.sbSbxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
  		
      },
//     onCloseClick: function(){ 			//关闭
//         this.ownerCt.hide();
//     }
//});

addXmxxClick: function() {       //添加委托单位
// 	var constructionForm = new ConstructionForm();
		var win = this.jyXmxxOpenWindow;
		win.constructionForm = this;
		win.show();
		win.jyXmxxGrid.jyXmxxOpenWindow = win;
		win.jyXmxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
		
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
    	this.constructionForm = new ConstructionForm();
    	this.constructionForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionForm.buttons[1].show();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改信息",
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

/***************************************XmxxConstructionInsertWindow组件**************************************************/
XmxxConstructionInsertWindow = Ext.extend(Ext.Window,{
	xmxxconstructionForm : null,
    constructor: function(grid) {
        this.xmxxconstructionForm = new XmxxConstructionForm();
        this.xmxxconstructionForm.buttons[0].show();   //显示添加按钮
    	this.xmxxconstructionForm.buttons[1].hide();   //隐藏修改按钮
    	XmxxConstructionInsertWindow.superclass.constructor.call(this, {
            title: "新增收费项目明细",
            width:500,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.xmxxconstructionForm]
        });
    }
});

/***************************************XmxxConstructionUpdateWindow组件**************************************************/
XmxxConstructionUpdateWindow = Ext.extend(Ext.Window, {
	xmxxconstructionForm : null,
    constructor: function() {
    	this.xmxxconstructionForm = new XmxxConstructionForm();
    	this.xmxxconstructionForm.buttons[0].hide();   //隐藏添加按钮
    	this.xmxxconstructionForm.buttons[1].show();   //显示修改按钮
    	XmxxConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改收费项目明细",
            width:500,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.xmxxconstructionForm]
        });
    }
});
/*****************************XmxxWindow***********************************/
XmxxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.xmxxGrid = new XmxxGrid();
    	XmxxWindow.superclass.constructor.call(this, {
    		title:'项目收费明细',
    		width: 700,
//    		height:300,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.xmxxGrid],
        	buttonAlign:'center',
	        buttons:[
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
    closeClick: function() {
    	this.hide();
    }
});

/********************XmxxIpasAssobjBankmemberUploadWindow组件*************************/
XmxxIpasAssobjBankmemberUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.xmxxipasAssobjBankmember = new XmxxIpasAssobjBankmemberUpload();
		XmxxIpasAssobjBankmemberUploadWindow.superclass.constructor.call(this, {
			title: '导入EXCEL文件',
			width: 600,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
			items: [this.xmxxipasAssobjBankmember]
		});
	}
});

/********************XmxxIpasAssobjBankmemberUpload组件*************************/
XmxxIpasAssobjBankmemberUpload = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		this.fibasic = new Ext.ux.form.FileUploadField({
			 name: 'fileData',
			 id: 'form-file',
            emptyText: '例:XXX.xlsx',
            fieldLabel: '导入文件',
	        width: 400
	    });
		XmxxIpasAssobjBankmemberUpload.superclass.constructor.call(this, {
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
			                 {text: '上传', width: 20,iconCls:'save', handler: this.XmxxonUploadClick, scope: this},
			                 {text: '关闭', width: 20,iconCls:'delete', handler: this.XmxxonCloseClick, scope: this}
			                 ]
		});
	},
	XmxxonUploadClick: function(){
		if(this.getForm().isValid()){
			this.getForm().submit({
				waitMsg: '正在提交，请稍后...',
				url: ENTITY_URL_XMXXUPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					xmxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
					xmxxGrid.xmxxipasAssobjBankmemberUploadWindow.hide();
				},
				failure: function(form, action){
					Ext.MessageBox.alert("系统提示：",action.result.message);
				}
			});
		}
	},
	//关闭
	XmxxonCloseClick: function(){
		xmxxGrid.xmxxipasAssobjBankmemberUploadWindow.xmxxipasAssobjBankmember.getForm().reset();
		this.ownerCt.hide();
	}
	
});

/**************************XmxxGrid*******************************************/
 XmxxGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
//    	var records=this.getSelectionModel().getSelections();
//      	var jybh = records[0].get("JYBH");
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+CBMX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                 {name:'ID'},{name:'SFBZBH'},{name:'CPMC'},{name:'XMBH'},{name:'XMMC'},
                 {name:'CPLX'}, {name:'CPLXBH'},{name:'JLDW'}, {name:'DJ'},
                  {name:'BZ'},
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
            	 '-',
                	{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
       		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
     		        	    if(btn=="yes"){ 
     		        	    	window.open("/zjyw/resources/js/sfbzxx/sfxmxx.xls");
     		        	   }
     		        	 });
     		    	 },scope:this}, 
     		    	 '-',	
     		    	 {xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.xmxxonUploadClick,scope:this},
     		    	 {xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
     	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
     			        	    if(btn=="yes"){ 		        	    	
     			        	    	var fileName = "收费标准信息";
     			        	    	var canshu = Ext.getCmp('canshu').getValue();
     			        	    	var url = PROJECT_NAME + "/sfgl/Ysfxmxx/xmxxexport?fileName="+fileName+"&canshu="+canshu;
     			        	    	url = encodeURI(url);
     			        	    	url = encodeURI(url);
     			        	    	window.open(url);
     			        	   }
     			        	 });
     		    		}
     	   			}
            ]
        });
   	
        this.xmxxConstructionInsertWindow = new XmxxConstructionInsertWindow();       
        this.xmxxConstructionUpdateWindow = new XmxxConstructionUpdateWindow();
        
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        XmxxGrid.superclass.constructor.call(this, {
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
             {header:'收费标准编号',dataIndex:'SFBZBH',width:80,sortable: true,hidden:true},
             {header:'产品名称',dataIndex:'CPMC',width:80,sortable: true},
              {header:'项目编号',dataIndex:'XMBH',width:80,sortable: true},
              {header:'项目名称',dataIndex:'XMMC',width:80,sortable: true},
              {header:'产品类型',dataIndex:'CPLX',width:80,sortable: true},
              {header:'产品类型编号',dataIndex:'CPLXBH',width:80,sortable: true},
             {header:'计量单位',dataIndex:'JLDW',width:60,sortable: true},
             {header:'单价',dataIndex:'DJ',width:60,sortable: true},
            {header:'备注',dataIndex:'BZ',width:90,sortable: true},
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
    
    xmxxonUploadClick: function(){             // 导入EXCEL数据
    	if(!this.xmxxipasAssobjBankmemberUploadWindow)
    		this.xmxxipasAssobjBankmemberUploadWindow = new XmxxIpasAssobjBankmemberUploadWindow();
    	var win = this.xmxxipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.xmxxipasAssobjBankmember.getForm().reset();
    },
    
    
    onAddClick: function() {
    	var win = this.xmxxConstructionInsertWindow;
    	win.xmxxconstructionForm.getForm().reset();
    	// win.constructionForm.idHidden.setValue(0);
        // win.cbmxForm.jybh.setValue(store.getAt().get('jybh'));
        var records=constructionGrid.getSelectionModel().getSelections();
    	var sfbzbh = records[0].get("SFBZBH");
        win.xmxxconstructionForm.sfbzbh.setValue(sfbzbh);
    	win.show();
    },
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.xmxxConstructionUpdateWindow;
   		    	//win.constructionForm.getForm().reset();
             	//win.constructionForm.product.setDisabled(true);//不允许修改帐户编码
   		    	win.show();
   		    	win.xmxxconstructionForm.sfbzbh.setValue(vrecord.data.SFBZBH);
   		    	win.xmxxconstructionForm.xmbh.setValue(vrecord.data.XMBH);
   		    	win.xmxxconstructionForm.xmmc.setValue(vrecord.data.XMMC);
   		    	win.xmxxconstructionForm.cplx.setValue(vrecord.data.CPLX);
   		    	win.xmxxconstructionForm.cplxbh.setValue(vrecord.data.CPLXBH);
   		    	win.xmxxconstructionForm.jldw.setValue(vrecord.data.JLDW);
   		    	win.xmxxconstructionForm.dj.setValue(vrecord.data.DJ);
   		    	win.xmxxconstructionForm.bz.setValue(vrecord.data.BZ);
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
			       	       url: PROJECT_NAME+""+CBMX_DELETE_URL,
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
//				               constructionGrid.store.reload();
				               constructionGrid.xmxxWindow.xmxxGrid.store.reload();
				               constructionGrid.store.reload();
			               },
			               failure: function(form, action) {
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除失败!" + BLANKSTR);
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
                                                                                   
               {name:'ID'},{name:'SFBZBH'},{name:'CPMC'},{name:'CPLX'},{name:'GGXH'},
                           
                           
                           
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
            	'-',{xtype:'textfield',id:'canshu',width: 150,
             	   emptyText:'产品名称...',  
            	    },
 	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
   						var canshu = Ext.getCmp('canshu').getValue();
   						constructionGrid.store.baseParams= {canshu:canshu};
   						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
   				    }},'-',
   				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
   	   				Ext.getCmp('canshu').setValue("");
      			  }
               },
               
            '-',
           	{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
  		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
		        	    if(btn=="yes"){ 
		        	    	window.open("/zjyw/resources/js/sfbzxx/bzxx.xls");
		        	   }
		        	 });
		    	 },scope:this}, 
		    	 '-',	
		    	 {xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
		    	 {xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "收费标准信息";
			        	    	var canshu = Ext.getCmp('canshu').getValue();
			        	    	var url = PROJECT_NAME + "/bzxx/YsfBzxx/bzxxexport?fileName="+fileName+"&canshu="+canshu;
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
        this.xmxxWindow = new XmxxWindow();
        
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
                                          
                {header:'序号',dataIndex:'ID',width:150,sortable: true, hidden:true},
                
                {header:'收费标准编号',dataIndex:'SFBZBH',width:80,sortable: true},
            	{header:'产品名称',dataIndex:'CPMC',width:150,sortable: true},
            	{header:'产品类型',dataIndex:'CPLX',width:100,sortable: true, hidden:true},
                {header:'规格型号',dataIndex:'GGXH',width:250,sortable: true},
//            	{header:'是否退回',dataIndex:'yhxtk',width:80,sortable: true,
//            		renderer:function(value){
//	                    if(value == '0') {
//	                        return "<span>退</span>";
//	                    }else if(value == '1') {
//	                        return "<span>不退</span>";
//	                    }else{
//	                    	return value;
//	                    }
//            		}
//            	},
            
            	
//            	{header:'流程名称',dataIndex:'lcmc',width:200,sortable: true, 
//                    renderer:function(value, cellmeta, record){
//                    	var id = record.data.id;
//                    	return '<a target="_blank" href="viewLcxx?id=' + id + '">' + value + '</a>';
//                    }
//            	},
//                {header:'姓名',dataIndex:'xm',width:200,sortable: true},
//            	{header:'性别',dataIndex:'xb',width:200,sortable: true,
//                	renderer:function(value){
//	                    if(value == '1') {
//	                        return "<span>男</span>";
//	                    }else if(value == '2') {
//	                        return "<span>女</span>";
//	                    }else{
//	                    	return value;
//	                    }
//            		}
//            	},

//            	{header:'年龄',dataIndex:'nl',width:260,sortable: true, }
                {header: '操作', width: 240, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,renderer:function(value, cellmeta, record)
                	
                    {return "<a href='javascript:;' onclick='constructionGrid. onLook()' style='text-decoration:none;'>" +"<span style='width: 25px;cursor: pointer;'>查看产品项目收费</span></a>&nbsp;&nbsp;&nbsp"+
                            "<a href='javascript:;' onclick='constructionGrid.onBzLook()' style='text-decoration:none;'>" +"<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
                            "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +"<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
                            "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>";
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
    
    onUploadClick: function(){             // 导入EXCEL数据
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    
    onLook: function(){   //查看项目收费明细
      	var win = this.xmxxWindow;
        win.show();
        var records=this.getSelectionModel().getSelections();
    	var sfbzbh = records[0].get("SFBZBH");
    	win.xmxxGrid.store.baseParams= {sfbzbh:sfbzbh};
       	win.xmxxGrid.store.load({params:{start:0,limit:PAGESIZE,sfbzbh:sfbzbh}});
    },
    
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
//    	win.constructionForm.getForm().reset();
    	var url = "sfAddView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("收费标准信息增加");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    
    onBzLook: function(){
		var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
		var url = "sfbzCkView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("收费标准信息");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
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
		var url = "sfbzxxXgView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("收费标准信息修改");
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

