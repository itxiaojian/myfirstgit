var USER_GRID_STORE_URL = 'getCbxxList';
var CBMX_URL = '/cwgl/YCwCbmx/getCbmxList';//成本明细信息
var CBMX_SAVE_URL = '/cwgl/YCwCbmx/save';//成本明细信息保存路径
var CBMX_UPDATE_URL = '/cwgl/YCwCbmx/update';//成本明细信息删除路径
var CBMX_DELETE_URL = '/cwgl/YCwCbmx/delete';//成本明细信息删除路径
var ENTITY_URL_UPLOAD = 'upload';
var PAGESIZE=20;
//var SBXX_URL = '/cbgl/getCbxxList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/**************************QueryForm查询条件*******************************************/
QueryForm = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		//this.ksbh = new zjyw.OrgSingelSelectAll('科室名称','ksbh','ksbh','100%');
		this.ksbh = new Ext.form.ComboBox({
			id:'ksbh',
        	autoLoad: true,
            fieldLabel: '科室名称',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'BMMC',
			valueField:'BMBH',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getKsmc', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.jybh = new Ext.form.TextField({
            fieldLabel: '检验编号',
            xtype: 'textfield',
            id: 'jybh',
            readOnly: false,
            anchor: '100%',
        });
        this.ypmc = new Ext.form.TextField({
            fieldLabel: '项目名称',
            xtype: 'textfield',
            id: 'ypmc',
            readOnly: false,
            anchor: '100%',
        });
        
        this.lrrq = new Ext.form.DateField({
			fieldLabel: '录入日期',
			id: 'lrrq',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		
		this.lrr = new Ext.form.TextField({
            fieldLabel: '录入人',
            xtype: 'textfield',
            id: 'lrr',
            readOnly: false,
            anchor: '100%',
        });
        
        this.xgrq = new Ext.form.DateField({
			fieldLabel: '修改日期',
			id: 'xgrq',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		
		this.xgr = new Ext.form.TextField({
            fieldLabel: '修改人',
            xtype: 'textfield',
            id: 'xgr',
            readOnly: false,
            anchor: '100%',
        });
        
        QueryForm.superclass.constructor.call(this, {
        	region: 'north',
	            anchor: '80%',
	            autoHeight:true,
	            labelWidth: 60,
	            labelAlign :'right',
	            frame: true,
	            bodyStyle:"padding: 2px 2px 0",
	            layout: 'tableform',
	            layoutConfig: {columns: 6},
	            items:[
						this.ksbh,
						this.jybh,
						this.ypmc,
						this.lrrq,
						this.lrr,
						this.xgrq,
						this.xgr
	            ],
	            buttonAlign :'center',
	            buttons: [
	               {text: '查询', width: 20,iconCls: 'query', hidden: false,handler:this.queryFormClick,scope:this},
	               {text: '重置', width: 20, iconCls:'refresh',  handler: this.resetFormClick, scope: this},
	               //{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:this.exportClick,scope:this}
	            ]
	        });
	},
	queryFormClick: function(){
  	   var params = {};
 			if(Ext.getCmp('ksbh').getValue() != ''){
 				params['ksbh'] = Ext.getCmp('ksbh').getValue();
 			}
 			if(Ext.getCmp('jybh').getValue() != ''){
 				params['jybh'] = Ext.getCmp('jybh').getValue();
 			}
 			if(Ext.getCmp('ypmc').getValue() != ''){
 				params['ypmc'] = Ext.getCmp('ypmc').getValue();
 			}
 			if(Ext.getCmp('lrrq').getValue() != ''){
 				params['lrrq'] = Ext.getCmp('lrrq').getValue().format('Y-m-d');;
 			}
 			if(Ext.getCmp('lrr').getValue() != ''){
 				params['lrr'] = Ext.getCmp('lrr').getValue();
 			}
 			if(Ext.getCmp('xgrq').getValue() != ''){
 				params['xgrq'] = Ext.getCmp('xgrq').getValue().format('Y-m-d');;
 			}
 			if(Ext.getCmp('xgr').getValue() != ''){
 				params['xgr'] = Ext.getCmp('xgr').getValue();
 			}
 			constructionGrid.store.baseParams= params;
 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	},
	resetFormClick: function(){
		Ext.getCmp('ksbh').setValue('');
		Ext.getCmp('jybh').setValue('');
		Ext.getCmp('ypmc').setValue('');
		Ext.getCmp('lrrq').setValue('');
		Ext.getCmp('lrr').setValue('');
		Ext.getCmp('xgrq').setValue('');
		Ext.getCmp('xgr').setValue('');
	},
	
	exportClick:function(){
   		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
    	    if(btn=="yes"){ 		        	    	
    	    	var fileName = new Date() + "导出成本信息";
    	    	var code = Ext.getCmp('ypmc').getValue();
    	    	var url = PROJECT_NAME + "/ypgl/YYpYpxx/export?fileName="+fileName+"&code="+code;
    	    	url = encodeURI(url);
    	    	url = encodeURI(url);
    	    	window.open(url);
    	   }
    	 });
	}
});

/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.ksbh = this.createTextField('科室编号', 'ksbh', '90%','',null,50,'长度超过不能50');
    	this.jybh = this.createTextField('检验编号', 'jybh', '90%','',null,50,'长度超过不能50');
    	this.ypmc = this.createTextField('项目名称', 'ypmc', '90%','',null,50,'长度超过不能50');
    	this.xxnr = new Ext.form.TextArea({
            fieldLabel: '项目详细内容',
            name: 'xxnr',
            readOnly: false,
            anchor: '90%',
            height:40,
//            maxLength: 300,
//            maxLengthText: '300'
        });
    	this.cbhj = new Ext.form.NumberField({
            fieldLabel: '成本合计',
            name: 'cbhj',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
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
    	this.lrr = this.createTextField('录入人', 'lrr', '90%','',null,50,'长度超过不能50');
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '90%',
            height:80,
            maxLength: 300,
            maxLengthText: '300!'
        });
    	
    	this.ksbh.allowBlank = false;
    	this.jybh.allowBlank = false;
    	this.ypmc.allowBlank = false;
    	this.xxnr.allowBlank = false;
    	this.cbhj.allowBlank = false;
    	this.lrrq.allowBlank = false;
    	this.lrr.allowBlank = false;
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
                        this.jybh
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
                        this.ypmc
                    ]  
                }), 
               
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.cbhj,
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
                        this.lrrq
                    ]  
                }), 
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
                        this.xxnr
                    ]  
                }), 
            ]  
        });
    	
    	var pnRow5=new Ext.Panel({  
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
						pnRow5
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
    	this.jybh = this.createTextField('检验编号', 'jybh', '90%','',null,50,'长度超过不能50');
    	this.ypmc = this.createTextField('项目名称', 'ypmc', '90%','',null,50,'长度超过不能50');
    	this.xxnr = new Ext.form.TextArea({
            fieldLabel: '项目详细内容',
            name: 'xxnr',
            readOnly: false,
            anchor: '90%',
            height:40,
//            maxLength: 3000,
//            maxLengthText: '3000！'
        });
    	this.cbhj = new Ext.form.NumberField({
            fieldLabel: '成本合计',
            name: 'cbhj',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.lrrq =  new Ext.form.DateField({
			fieldLabel: '录入日期',
			name: "lrrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.lrr = this.createTextField('录入人', 'lrr', '90%','',null,50,'长度超过不能50');
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
    	this.xgyy = new Ext.form.TextArea({
            fieldLabel: '修改原因',
            name: 'xgyy',
            readOnly: false,
            anchor: '90%',
            height:40,
            maxLength: 200,
            maxLengthText: '200！'
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
    	this.jybh.allowBlank = false;
    	this.ypmc.allowBlank = false;
    	this.xxnr.allowBlank = false;
    	this.cbhj.allowBlank = false;
    	this.lrrq.allowBlank = false;
    	this.lrr.allowBlank = false;
    	this.xgr.allowBlank = false;
    	this.xgrq.allowBlank = false;
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
                        this.jybh
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
                        this.ypmc
                    ]  
                }), 
               
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.cbhj,
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
                        this.lrrq
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.lrr
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
                        this.xgr
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
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
                    columnWidth:1.055,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.xgyy
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
                        this.xxnr
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
						pnRow7
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

/*************************************** CbmxForm组件 **************************************************/
CbmxForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.pjbh = this.createTextField('凭证号', 'pjbh', '90%','',null,50,'长度超过不能50');
    	//this.fylx = this.createTextField('费用类型', 'fylx', '90%','',null,50,'长度超过不能50');
    	this.fylx = this.createCombo('费用类型','ZDZ' ,'ZDMC' , 'fylx','90%', PROJECT_NAME+'/cbgl/YCwCbxx/getDicByJylx');
    	this.fylx.store.load();
    	this.xmmc = this.createTextField('费用项目名称', 'xmmc', '90%','',null,50,'长度超过不能50');
    	this.fyxq = new Ext.form.TextArea({
            fieldLabel: '费用详情',
            name: 'fyxq',
            readOnly: false,
            anchor: '90%',
            height:50,
//            maxLength: 500,
//            maxLengthText: '500！'
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
    	
    	this.fssj =  new Ext.form.DateField({
			fieldLabel: '发生时间',
			name: "fssj",
			format: "Y-m",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.fylx.allowBlank = false;
    	this.xmmc.allowBlank = true;
    	this.fyxq.allowBlank = true;
    	this.je.allowBlank = true;
    	
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
				        this.pjbh
				    ]  
				}), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.fssj
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
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.xmmc
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
			                this.je
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
                        this.fyxq
                    ]  
                }), 
            ]  
        });
    	
    	CbmxForm.superclass.constructor.call(this, {
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
        	// var records=constructionGrid.getSelectionModel().getSelections();
         	// var jybh = records[0].get("JYBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'save', 
                 url: PROJECT_NAME+""+CBMX_SAVE_URL,
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.cbmxWindow.cbmxGrid.cbmxInsertWindow.hide();
                 	constructionGrid.cbmxWindow.cbmxGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
        	var record=constructionGrid.cbmxWindow.cbmxGrid.getSelectionModel().getSelections();
        	var jybh = record[0].get("JYBH");
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
                 	constructionGrid.cbmxWindow.cbmxGrid.cbmxUpdateWindow.hide();
                 	constructionGrid.cbmxWindow.cbmxGrid.store.load({params:{start:0,limit:PAGESIZE,jybh:jybh}});
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
            title: "新增成本信息",
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
        	title: "修改成本信息",
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

/*****************************CbmxWindow***********************************/
CbmxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.cbmxGrid = new CbmxGrid();
    	CbmxWindow.superclass.constructor.call(this, {
    		title:'成本明细',
    		width: 1000,
//    		height:300,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.cbmxGrid],
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

/***************************************CbmxInsertWindow组件**************************************************/
CbmxInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.cbmxForm = new CbmxForm();
        this.cbmxForm.buttons[0].show();   //显示添加按钮
    	this.cbmxForm.buttons[1].hide();   //隐藏修改按钮
    	CbmxInsertWindow.superclass.constructor.call(this, {
            title: "新增成本明细",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.cbmxForm]
        });
    }
});

/***************************************CbmxUpdateWindow组件**************************************************/
CbmxUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.cbmxForm = new CbmxForm();
    	this.cbmxForm.buttons[0].hide();   //隐藏添加按钮
    	this.cbmxForm.buttons[1].show();   //显示修改按钮
    	CbmxUpdateWindow.superclass.constructor.call(this, {
        	title: "修改成本明细",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.cbmxForm]
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
/**************************CbmxGrid*******************************************/
CbmxGrid = Ext.extend(UxGrid, {
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
                            {name:'ID'},{name:'JYBH'},{name:'FYLX'},{name:'XMMC'},{name:'FYXQ'},{name:'JE'},
                            {name:'LRRQ'},{name:'FSSJ'},{name:'PJBH'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                /*
                '-',{text:'澧炲姞',iconCls: 'add',handler:this.onAddClick,scope:this},
                                '-',{text:'淇敼',iconCls: 'edit',handler:this.onModifyClick,scope:this},
                                '-',{text:'鍒犻櫎',iconCls: 'delete',handler:this.onDeleteClick,scope:this},*/
                
            ]
        });
   	
        this.cbmxInsertWindow = new CbmxInsertWindow();       
        this.cbmxUpdateWindow = new CbmxUpdateWindow();
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        CbmxGrid.superclass.constructor.call(this, {
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
                {header:'凭证号',dataIndex:'PJBH',width:100,sortable: true},
                {header:'发生时间',dataIndex:'FSSJ',width:80,sortable: true},
                {header:'费用类型',dataIndex:'FYLX',width:120,sortable: true},
                {header:'费用项目名称',dataIndex:'XMMC',width:120,sortable: true},
            	{header:'费用详情',dataIndex:'FYXQ',width:120,sortable: true},
//            	{header:'单价',dataIndex:'DJ',width:120,sortable: true},
//            	{header:'数量',dataIndex:'SL',width:120,sortable: true},
            	{header:'金额',dataIndex:'JE',width:120,sortable: true},
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
    	var win = this.cbmxInsertWindow;
    	win.cbmxForm.getForm().reset();
    	// win.constructionForm.idHidden.setValue(0);
        // win.cbmxForm.jybh.setValue(store.getAt().get('jybh'));
        var records=constructionGrid.getSelectionModel().getSelections();
    	win.show();
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.cbmxUpdateWindow;
   		    	win.show();
   		    	win.cbmxForm.pjbh.setValue(vrecord.data.PJBH);
   		    	win.cbmxForm.fssj.setValue(vrecord.data.FSSJ);
   		    	win.cbmxForm.fylx.setValue(vrecord.data.FYLX);
   		    	win.cbmxForm.xmmc.setValue(vrecord.data.XMMC);
   		    	win.cbmxForm.fyxq.setValue(vrecord.data.FYXQ);
   		    	win.cbmxForm.je.setValue(vrecord.data.JE);
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
				               constructionGrid.cbmxWindow.cbmxGrid.store.reload();
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
                            {name:'ID'},{name:'KSBH'},{name:'JYBH'},{name:'YPMC'},{name:'XXNR'},
                            {name:'CBHJ'},{name:'LRRQ'},{name:'LRR'},{name:'XGR'},{name:'XGRQ'},
                            {name:'XGYY'},{name:'BZ'},{name:'KSBH1'},{name:'FSSJ'},{name:'CBBH'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'登记',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                // '-',{xtype:'textfield',id:'code',width: 150,
                	   // emptyText:'科室编号&检验编号...',  
               	    // },
    	  			// '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						// var code = Ext.getCmp('code').getValue();
      						// constructionGrid.store.baseParams= {code:code};
      						// constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    // }},'-',
      				    // {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				// Ext.getCmp('code').setValue("");
         			  // }
         			  //},
                  '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
     		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
    		        	    if(btn=="yes"){ 
    		        	    	window.open(PROJECT_NAME+"/resources/js/cbgl/cwcbxx.xls");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		        '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                  '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
       		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
    		        	    if(btn=="yes"){ 		        	    	
    		        	    	var fileName = "成本信息";
    		        	    	var code = Ext.getCmp('code').getValue();
    		        	    	var url = PROJECT_NAME + "/cbgl/YCwCbxx/export?fileName="+fileName+"&code="+code;
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
//        this.constructionLookWindow = new ConstructionLookWindow();
        this.cbmxWindow = new CbmxWindow();
        
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
                {header:'成本编号',dataIndex:'CBBH',width:80,sortable: true, hidden:true},
                {header:'科室编号',dataIndex:'KSBH1',width:80,sortable: true, hidden:true},
                {header:'科室名称',dataIndex:'KSBH',width:100,sortable: true},
                {header:'所属月份',dataIndex:'FSSJ',width:80,sortable: true},
                {header:'检验编号',dataIndex:'JYBH',width:100,sortable: true},
                {header:'项目名称',dataIndex:'YPMC',width:100,sortable: true},
            	{header:'项目详细内容',dataIndex:'XXNR',width:150,sortable: true, hidden:true},
            	{header:'成本合计(元)',dataIndex:'CBHJ',width:80,sortable: true},
            	{header:'录入日期',dataIndex:'LRRQ',width:140,sortable: true},
            	{header:'录入人',dataIndex:'LRR',width:60,sortable: true},
            	{header:'修改日期',dataIndex:'XGRQ',width:120,sortable: true},
            	{header:'修改人',dataIndex:'XGR',width:60,sortable: true},
            	{header:'修改原因',dataIndex:'XGYY',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true, hidden:true},
            	{header:'操作', width: 180, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看成本明细</span></a> &nbsp;&nbsp;&nbsp"+
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
//    	var win = this.constructionInsertWindow;
//    	win.constructionForm.getForm().reset();
////    	win.constructionForm.idHidden.setValue(0);
//    	win.show();
//    	var curDate = new Date();
////    	var time = Ext.Date.format(curDate, 'Y-m-d');
//    	win.constructionForm.lrrq.setValue(curDate);
    	var url = "cbxxAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("新增成本信息");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onLook: function(){   //查看成本明细
      	var win = this.cbmxWindow;
        win.show();
        var records=this.getSelectionModel().getSelections();
    	var ksbh = records[0].get("KSBH1");
    	var lrrq = records[0].get("CBBH");
    	win.cbmxGrid.store.baseParams= {ksbh:ksbh,lrrq:lrrq};
       	win.cbmxGrid.store.load({params:{start:0,limit:PAGESIZE,ksbh:ksbh,lrrq:lrrq}});
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
   		    	// win.ConstructionUpdateForm.jybh.setValue(vrecord.data.JYBH);
   		    	// win.ConstructionUpdateForm.ypmc.setValue(vrecord.data.YPMC);
   		    	// win.ConstructionUpdateForm.xxnr.setValue(vrecord.data.XXNR);
   		    	// win.ConstructionUpdateForm.cbhj.setValue(vrecord.data.CBHJ);
   		    	// win.ConstructionUpdateForm.lrrq.setValue(vrecord.data.LRRQ);
   		    	// win.ConstructionUpdateForm.lrr.setValue(vrecord.data.LRR);
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
   		var records=this.getSelectionModel().getSelections();
				   		if(records.length > 0) {
				   			if(records.length == 1){
				   				vrecord = records[0];
				   				var id=records[0].get('ID');
				   				var cbbh=records[0].get('CBBH');
								var url = "cbxxUpdateView?id="+id+"&cbbh="+cbbh;  	
								html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
								ACT_DEAL_WINDOW = new ActDealWindow();
								ACT_DEAL_WINDOW.setTitle("修改成本信息");
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
    	var jybhStr=[];
    	var ksbhStr=[];
    	var lrrqStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
	       		ksbhStr.push(records[i].get('CBBH'));
	       		lrrqStr.push(records[i].get('LRRQ'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		   url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr,ksbhs: ksbhStr,lrrqs: lrrqStr},
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
});


/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';

    constructionGrid = new ConstructionGrid(Ext.getBody().getViewSize().height-160, Ext.getBody().getViewSize().width);
    constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    /*
    new Ext.Viewport({
            layout: 'border',
            items:[
            //conditionForm,
            constructionGrid
            ]
        });*/
    
    
    var queryForm = new QueryForm();
    var leftPanel=new Ext.Panel({
		region: 'center',
        layout:"border",
        items    : [constructionGrid,queryForm]
    })
	
	new Ext.Viewport({
		layout:'border',
		items: [
		        leftPanel
		]
	});
});

