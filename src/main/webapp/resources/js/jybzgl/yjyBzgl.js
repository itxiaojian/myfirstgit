var DICT_GRID_STORE_URL = '/jybzgl/getYjyBzxxList';
var DICT_ENTRY_GRID_STORE_URL = '/jybzgl/getYjyXmxxList';
var ENTITY_URL_UPLOAD = 'jybzupload';
var JYXM_URL_UPLOAD = 'jyxmupload';
var PAGESIZE=20;

/***************************************DictStandardForm组件**************************************************/
DictStandardForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
    	this.bzbh = this.createTextField('标准编号', 'bzbh', '100%','',null,100,'长度超过不能50');
    	this.bzmc = this.createTextField('标准名称', 'bzmc', '100%','',null,100,'长度超过不能50');
    	this.bzmc_fz = this.createTextField('标准名称附注', 'bzmc_fz', '100%','',null,100,'长度超过不能50');
//    	this.pyjm = this.createTextField('拼音简码', 'pyjm', '100%','',null,100,'长度超过不能50');
    	
    	//做下拉框
		this.bzjb = this.createCombo('标准级别', 'ZDMC', 'ZDMC', 'bzjb', '100%', PROJECT_NAME+'/jybzgl/getDicByjb');
		this.bzjb.store.load();
		this.bzjb.allowBlank = false;
    	//做下拉框
    	this.bzlb = this.createCombo('标准类型', 'ZDMC', 'ZDMC', 'bzlb', '100%', PROJECT_NAME+'/jybzgl/getDicByLx');
		this.bzlb.store.load();
		this.bzlb.allowBlank = false;
		
		
    	this.ks_id = this.createTextField('使用科室', 'ks_id', '100%','',null,100,'长度超过不能100');
    	this.xmbh_id = this.createTextField('下属项目编号', 'xmbh_id', '100%','',null,200,'长度超过不能200');
    	this.xgr = this.createTextField('修改人', 'xgr', '100%','',null,100,'长度超过不能200');
    	this.fzzt = this.createTextField('废止状态', 'fzzt', '100%','',null,150,'长度超过不能200');
    	this.fzdjr = this.createTextField('废止登记人', 'fzdjr', '100%','',null,100,'长度超过不能200');
    	this.shzt = this.createTextField('审核状态', 'shzt', '100%','',null,100,'长度超过不能200');
    	this.shr = this.createTextField('审核人', 'shr', '100%','',null,100,'长度超过不能200');
//    	this.bz = this.createTextField('备注', 'bz', '81.3%','',null,100,'长度超过不能200');
    	this.bzbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准编号',
            name: 'bzbh',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.bzmc = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准名称',
            name: 'bzmc',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.pyjm = new Ext.form.TextField({
            fieldLabel: '拼音简码',
            name: 'pyjm',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^[A-Za-z]+$/
        });
    	this.qyrq =  new Ext.form.DateField({
			fieldLabel: '标准启用日期',
			name: "qyrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.fzrq =  new Ext.form.DateField({
			fieldLabel: '废止日期',
			name: "fzrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.shrq =  new Ext.form.DateField({
			fieldLabel: '审核日期',
			name: "shrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	
    	this.zhxgrq =  new Ext.form.DateField({
			fieldLabel: '最后修改日期',
			name: "zhxgrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始时间',
			name: "kssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束时间',
			name: "jssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '100%',
            height:100,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.bzbh.allowBlank = false;
    	this.bzmc.allowBlank = false;
    	this.bzmc_fz.allowBlank = true;
    	this.pyjm.allowBlank = true;
    	this.bzlb.allowBlank = true;
    	this.bzjb.allowBlank = true;
    	this.qyrq.allowBlank = true;
    	this.ks_id.allowBlank = true;
    	this.xmbh_id.allowBlank = true;
    	this.zhxgrq.allowBlank = true;
    	this.xgr.allowBlank = true;
    	this.fzzt.allowBlank = true;
    	this.fzrq.allowBlank = true;
    	this.fzdjr.allowBlank = true;
    	this.shzt.allowBlank = true;
    	this.shrq.allowBlank = true;
    	this.shr.allowBlank = true;
    	this.kssj.allowBlank = true;
    	this.jssj.allowBlank = true;
    	this.bz.allowBlank = true;
 
        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.33,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bzbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.33,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.bzmc
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.34,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bzmc_fz
                    ]  
                }),
            ]  
        });
        
        var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.pyjm
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bzlb
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bzjb
                       ]  
                   }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.qyrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.ks_id
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xmbh_id
                       ]  
                   }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fzdjr
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.fzzt
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xgr
                       ]  
                   }),
               ]  
        });
        var pnRow5=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.shr
                       ]  
                   }), 
                   
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.zhxgrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fzrq
                       ]  
                   }), 
               ]
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.shzt
                       ]  
                   }), 
                   
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.shrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
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
                           this.bz
                       ]  
                   }),
               ] 
        });

        DictStandardForm.superclass.constructor.call(this, {
        	anchor: '100%',
        	autoHeight:true,
        	layout:"tableform",
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
                      {text: '保存', width: 20,iconCls: 'save', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {
         if(this.getForm().isValid()) {
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+'/jybzgl/jybzgl/save',   
                 method: 'POST',
                 success: function(form, action) {
                 	
           		 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	dictStandardGrid.constructionInsertWindow.hide();
                 	dictStandardGrid.vbbar.doLoad(dictStandardGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
//                 	Ext.MessageBox.alert("系统提示:", action.result.message);
                 }
         	});
         }
     },
     updateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
         	var record = dictStandardGrid.getSelectionModel().getSelections();
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+'/jybzgl/jybzgl/update', 
                 method: 'POST',
                 params:{
                 	scid:record[0].get('id')
                 },
                 success: function(form, action) { 
                 	
           		 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	dictStandardGrid.constructionUpdateWindow.hide();
                 	dictStandardGrid.vbbar.doLoad(dictStandardGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
//                 	Ext.MessageBox.alert("系统提示:", action.result.message);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** StandardLookForm组件 **************************************************/
StandardLookForm = Ext.extend(Ext.ux.Form, {
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
    	this.bzbh = this.createTextField('标准编号', 'bzbh', '100%','',null,100,'长度超过不能50');
    	this.bzmc = this.createTextField('标准名称', 'bzmc', '100%','',null,100,'长度超过不能50');
    	this.bzmc_fz = this.createTextField('标准名称附注', 'bzmc_fz', '100%','',null,100,'长度超过不能50');
//    	this.pyjm = this.createTextField('拼音简码', 'pyjm', '100%','',null,100,'长度超过不能50');
    	
    	//做下拉框
		this.bzjb = this.createCombo('标准级别', 'ZDMC', 'ZDMC', 'bzjb', '100%', PROJECT_NAME+'/jybzgl/getDicByjb');
		this.bzjb.store.load();
		this.bzjb.allowBlank = false;
    	//做下拉框
    	this.bzlb = this.createCombo('标准类型', 'ZDMC', 'ZDMC', 'bzlb', '100%', PROJECT_NAME+'/jybzgl/getDicByLx');
		this.bzlb.store.load();
		this.bzlb.allowBlank = false;
		
		
    	this.ks_id = this.createTextField('使用科室', 'ks_id', '100%','',null,100,'长度超过不能100');
    	this.xmbh_id = this.createTextField('下属项目编号', 'xmbh_id', '100%','',null,200,'长度超过不能200');
    	this.xgr = this.createTextField('修改人', 'xgr', '100%','',null,100,'长度超过不能200');
    	this.fzzt = this.createTextField('废止状态', 'fzzt', '100%','',null,150,'长度超过不能200');
    	this.fzdjr = this.createTextField('废止登记人', 'fzdjr', '100%','',null,100,'长度超过不能200');
    	this.shzt = this.createTextField('审核状态', 'shzt', '100%','',null,100,'长度超过不能200');
    	this.shr = this.createTextField('审核人', 'shr', '100%','',null,100,'长度超过不能200');
//    	this.bz = this.createTextField('备注', 'bz', '81.3%','',null,100,'长度超过不能200');
    	this.bzbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准编号',
            name: 'bzbh',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.bzmc = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准名称',
            name: 'bzmc',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.pyjm = new Ext.form.TextField({
            fieldLabel: '拼音简码',
            name: 'pyjm',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^[A-Za-z]+$/
        });
    	this.qyrq =  new Ext.form.DateField({
			fieldLabel: '标准启用日期',
			name: "qyrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.fzrq =  new Ext.form.DateField({
			fieldLabel: '废止日期',
			name: "fzrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.shrq =  new Ext.form.DateField({
			fieldLabel: '审核日期',
			name: "shrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	
    	this.zhxgrq =  new Ext.form.DateField({
			fieldLabel: '最后修改日期',
			name: "zhxgrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始时间',
			name: "kssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});

    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束时间',
			name: "jssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '100%',
            height:100,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.bzbh.allowBlank = false;
    	this.bzmc.allowBlank = false;
    	this.bzmc_fz.allowBlank = true;
    	this.pyjm.allowBlank = true;
    	this.bzlb.allowBlank = true;
    	this.bzjb.allowBlank = true;
    	this.qyrq.allowBlank = true;
    	this.ks_id.allowBlank = true;
    	this.xmbh_id.allowBlank = true;
    	this.zhxgrq.allowBlank = true;
    	this.xgr.allowBlank = true;
    	this.fzzt.allowBlank = true;
    	this.fzrq.allowBlank = true;
    	this.fzdjr.allowBlank = true;
    	this.shzt.allowBlank = true;
    	this.shrq.allowBlank = true;
    	this.shr.allowBlank = true;
    	this.kssj.allowBlank = true;
    	this.jssj.allowBlank = true;
    	this.bz.allowBlank = true;
 
        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.33,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bzbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.33,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.bzmc
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.34,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bzmc_fz
                    ]  
                }),
            ]  
        });
        
        var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.pyjm
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bzlb
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bzjb
                       ]  
                   }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.qyrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.ks_id
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xmbh_id
                       ]  
                   }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fzdjr
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.fzzt
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xgr
                       ]  
                   }),
               ]  
        });
        var pnRow5=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.shr
                       ]  
                   }), 
                   
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.zhxgrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.fzrq
                       ]  
                   }), 
               ]
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.shzt
                       ]  
                   }), 
                   
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.shrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
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
                           this.bz
                       ]  
                   }),
               ] 
        });

        
        StandardLookForm.superclass.constructor.call(this, {
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
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/***************************************DictStandardInsertWindow组件**************************************************/
DictStandardInsertWindow = Ext.extend(Ext.Window,{
	constructionStandardForm : null,
    constructor: function(grid) {
        this.constructionStandardForm = new DictStandardForm();
        this.constructionStandardForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionStandardForm.buttons[1].hide();   //显示修改按钮
        DictStandardInsertWindow.superclass.constructor.call(this, {
            title: "添加标准",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            constrainHeader:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionStandardForm]
        });
    }
});

/***************************************DictStandardUpdateWindow组件**************************************************/
DictStandardUpdateWindow = Ext.extend(Ext.Window, {
	constructionStandardForm : null,
    constructor: function() {
    	this.constructionStandardForm = new DictStandardForm();
    	this.constructionStandardForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionStandardForm.buttons[1].show();   //显示修改按钮
    	DictStandardUpdateWindow.superclass.constructor.call(this, {
        	title: "修改标准信息",
            width: 800,
            autoHeight:true,
            constrainHeader:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionStandardForm]
        });
    }
});

/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	constructionStandardForm : null,
    constructor: function() {
    	this.sLookForm = new StandardLookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看检验标准信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.sLookForm]
        });
    }
});

/********************IpasAssobjBankmemberUploadWindow组件*************************/
IpasAssobjBankmemberUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.ipasAssobjBankmember = new IpasAssobjBankmemberUpload();
		IpasAssobjBankmemberUploadWindow.superclass.constructor.call(this, {
			title: '导入检验标准EXCEL数据',
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
					dictStandardGrid.store.load({params:{start:0,limit:PAGESIZE}});
					dictStandardGrid.ipasAssobjBankmemberUploadWindow.hide();
				},
				failure: function(form, action){
					Ext.MessageBox.alert("系统提示：",action.result.message);
				}
			});
		}
	},
	//关闭
	onCloseClick: function(){
		dictStandardGrid.ipasAssobjBankmemberUploadWindow.ipasAssobjBankmember.getForm().reset();
		this.ownerCt.hide();
	}
	
});

/**************************dictStandardGrid*******************************************/
dictStandardGrid = Ext.extend(UxGrid, {
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+DICT_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
            		{name:'id'},{name:'bzbh'},{name:'bzmc'},{name:'bzmc_fz'},{name:'pyjm'},{name:'bzlb'},
                    {name:'bzjb'},{name:'qyrq'},{name:'ks_id'},{name:'xmbh_id'},{name:'zhxgrq'},{name:'xgr'},
                    {name:'fzzt'},{name:'fzrq'},{name:'fzdjr'},{name:'shzt'},{name:'shrq'},{name:'shr'},
                    {name:'kssj'},{name:'jssj'},{name:'bz'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                {text:'添加',iconCls: 'add',handler:this.onAddClick,scope:this},'-',
                {text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},'-',
            	{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},'-',
            	{xtype:'textfield',id:'canshu',width: 150,
             	   emptyText:'标准编号&标准名称...',  
            	    },'-',
 	  			{xtype:'button',text:'查询',iconCls:'query',handler:function(){
   						var code = Ext.getCmp('canshu').getValue();
   						dictStandardGrid.store.baseParams= {code:code};
   						dictStandardGrid.store.load({params:{start:0,limit:PAGESIZE}});
   				    }},'-',
   				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
   	   				Ext.getCmp('canshu').setValue("");
      			  }
               },'-',
            	{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
		        	    if(btn=="yes"){ 
		        	    	window.open("/zjyw/resources/js/jybzgl/yjybz.xls");
		        	   }
		        	 });
		    	 },scope:this}, '-',	
		    	 {xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},'-',
		    	 {xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "检验标准";
			        	    	var code = Ext.getCmp('canshu').getValue();
			        	    	var url = PROJECT_NAME + "/jybzgl/jybzexport?fileName="+fileName+"&code="+code;
			        	    	url = encodeURI(url);
			        	    	url = encodeURI(url);
			        	    	window.open(url);
			        	   }
			        	 });
		    		}
	   			}
            ]
        });	
        this.constructionInsertWindow = new DictStandardInsertWindow();       
        this.constructionUpdateWindow = new DictStandardUpdateWindow();
        this.constructionLookWindow = new ConstructionLookWindow();
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        dictStandardGrid.superclass.constructor.call(this, {
        	region:'center',
        	title: '检验标准',
        	stripeRows: true,
            frame: true,
            height: height,
            width :width,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
	            {header:'编号',dataIndex:'id',width:80,sortable: true, hidden:true},
                {header: '操作', width: 150, dataIndex: 'shzt', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("shzt") == 1){
							return "<a href='javascript:;' onclick='dictStandardGrid.onLook()' style='text-decoration:none;'><span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
		   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>审核</span></a>&nbsp;&nbsp;&nbsp"+
		   "<a href='javascript:;' onclick='dictStandardGrid.onAbolish()' style='text-decoration:none;'><span style='width: 25px;cursor: pointer;'>废止</span></a>&nbsp;&nbsp;&nbsp";
		}else if(record.get("shzt") == 2){
			return "<a href='javascript:;' onclick='dictStandardGrid.onLook()' style='text-decoration:none;'><span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='dictStandardGrid.onCheck()' style='text-decoration:none;'><span style='width: 25px;cursor: pointer;'>审核</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>废止</span></a>&nbsp;&nbsp;&nbsp";
		}else{
			return "<a href='javascript:;' onclick='dictStandardGrid.onLook()' style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp" +
			   "<a href='javascript:;' onclick='dictStandardGrid.onCheck()'  style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;'>审核</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='dictStandardGrid.onAbolish()'  style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;cursor: pointer;'>废止</span></a>&nbsp;&nbsp;&nbsp";			
						}
					}
				},
//				{header:'序号',dataIndex:'id',width:90,sortable: true, hidden:true},
                {header:'标准编号',dataIndex:'bzbh',width:90,sortable: true},
                {header:'检验标准名称',dataIndex:'bzmc',width:90,sortable: true},
            	{header:'标准名称附注',dataIndex:'bzmc_fz',width:90,sortable: true},
            	{header:'拼音简码',dataIndex:'pyjm',width:90,sortable: true},
            	{header:'标准类型',dataIndex:'bzlb',width:90,sortable: true},
            	{header:'标准级别',dataIndex:'bzjb',width:90,sortable: true},
            	{header:'标准启用日期',dataIndex:'qyrq',width:90,sortable: true},
            	{header:'使用科室ID',dataIndex:'ks_id',width:90,sortable: true},
            	{header:'下属项目编号',dataIndex:'xmbh_id',width:90,sortable: true},
            	{header:'最后修改日期',dataIndex:'zhxgrq',width:90,sortable: true},
            	{header:'修改人',dataIndex:'xgr',width:90,sortable: true},
            	{header:'废止状态',dataIndex:'fzzt',width:90,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>正常使用</span>";
	                    }else if(value == '1') {
	                        return "<span>停用</span>";
	                    }else if(value == '2'){
	                    	return "<span>废除</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	{header:'废止日期',dataIndex:'fzrq',width:90,sortable: true},
            	{header:'废止登记人',dataIndex:'fzdjr',width:90,sortable: true},
            	{header:'审核状态',dataIndex:'shzt',width:90,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>未审核</span>";
	                    }else if(value == '1') {
	                        return "<span>通过</span>";
	                    }else if(value == '2'){
	                    	return "<span>未通过</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	{header:'审核日期',dataIndex:'shrq',width:90,sortable: true},
            	{header:'审核人',dataIndex:'shr',width:90,sortable: true},
            	{header:'开始时间',dataIndex:'kssj',width:90,sortable: true},
            	{header:'结束时间',dataIndex:'jssj',width:90,sortable: true},
            	{header:'备注',dataIndex:'bz',width:90,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            	'rowdblclick':function(){
            		var records=this.getSelectionModel().getSelections();
            		alert(sjid);
            		var sjid = records[0].get('bzbh');
            		alert(sjid);
            		var name = records[0].get('bzmc');
            		dictItemGrid.setTitle('<span style="color:red">'+name+'</span>标准对应的项目名称');
            		dictItemGrid.sjid = sjid;
            		dictItemGrid.store.baseParams = {
			    		limit:PAGESIZE,
			    		sjid:sjid
			    	};
			    	dictItemGrid.store.load({params:{start:0}});
            	},
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
    
    onCheck: function() {				//审核
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('id'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要审核" + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
				       	   url:PROJECT_NAME+'/jybzgl/jybzgl/check',   
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) { 
				               	var obj = Ext.util.JSON.decode(form.responseText);
				               	if(obj.success == true){   //true / false
				               		 Ext.MessageBox.alert("系统提示:", BLANKSTR + "审核成功!" + BLANKSTR);
					               	 dictStandardGrid.store.reload();
				               	}else{
				               		 Ext.MessageBox.alert("系统提示:", obj.message);
					               	 dictStandardGrid.store.reload();
				               	}
				              
			               },
			               failure: function(form, action) {
			            	   //Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
			               		Ext.MessageBox.alert("系统提示：",action.result.failure);
			               }
				       	});					
				}
	    	});	
    	}else{
    		 Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
         	return;
    	}
    },
    
    onAbolish: function() {			//废止
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('id'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要废止这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
				       	   url:PROJECT_NAME+'/jybzgl/jybzgl/abolish',   
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) { 
				               	var obj = Ext.util.JSON.decode(form.responseText);
				               	if(obj.success == true){   //true / false
				               		 Ext.MessageBox.alert("系统提示:", BLANKSTR + "废止成功!" + BLANKSTR);
					               	 dictStandardGrid.store.reload();
				               	}else{
				               		 Ext.MessageBox.alert("系统提示:", obj.message);
					               	 dictStandardGrid.store.reload();
				               	}
				              
			               },
			               failure: function(form, action) {
			            	   //Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
			               		Ext.MessageBox.alert("系统提示：",action.result.failure);
			               }
				       	});					
				}
	    	});	
    	}else{
    		 Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
         	return;
    	}
    },
    
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.show();
   		    	win.sLookForm.bzbh.setValue(vrecord.data.bzbh);
   		    	win.sLookForm.bzmc.setValue(vrecord.data.bzmc);
   		    	win.sLookForm.bzmc_fz.setValue(vrecord.data.bzmc_fz);
   		    	win.sLookForm.pyjm.setValue(vrecord.data.pyjm);
   		    	win.sLookForm.bzlb.setValue(vrecord.data.bzlb);
   		    	win.sLookForm.bzjb.setValue(vrecord.data.bzjb);
   		    	win.sLookForm.qyrq.setValue(vrecord.data.qyrq);
   		    	win.sLookForm.ks_id.setValue(vrecord.data.ks_id);
   		    	win.sLookForm.xmbh_id.setValue(vrecord.data.xmbh_id);
   		 	    win.sLookForm.zhxgrq.setValue(vrecord.data.zhxgrq);
   		     win.sLookForm.xgr.setValue(vrecord.data.xgr);
		    	win.sLookForm.shrq.setValue(vrecord.data.shrq);
		        win.sLookForm.shzt.setValue(vrecord.data.shzt);
   		    	win.sLookForm.fzdjr.setValue(vrecord.data.fzdjr);
   		    	win.sLookForm.fzzt.setValue(vrecord.data.fzzt);
   		    	win.sLookForm.xgr.setValue(vrecord.data.xgr);
   		 	win.sLookForm.fzrq.setValue(vrecord.data.fzrq);
   		    	win.sLookForm.shr.setValue(vrecord.data.shr);
   		 	   win.sLookForm.kssj.setValue(vrecord.data.kssj);
   			win.sLookForm.jssj.setValue(vrecord.data.jssj);
   		    	win.sLookForm.bz.setValue(vrecord.data.bz);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
    	win.show();
    	win.constructionStandardForm.getForm().reset();
    },
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
//   		    	var win = new DictStandardUpdateWindow();
   				var win = this.constructionUpdateWindow;
   		    	//win.constructionStandardForm.getForm().reset();
   		    	win.show();
   		    	win.constructionStandardForm.bzbh.setValue(vrecord.data.bzbh);
   		    	win.constructionStandardForm.bzmc.setValue(vrecord.data.bzmc);
   		    	win.constructionStandardForm.bzmc_fz.setValue(vrecord.data.bzmc_fz);
   		    	win.constructionStandardForm.pyjm.setValue(vrecord.data.pyjm);
   		    	win.constructionStandardForm.bzlb.setValue(vrecord.data.bzlb);
   		    	win.constructionStandardForm.bzjb.setValue(vrecord.data.bzjb);
   		    	win.constructionStandardForm.qyrq.setValue(vrecord.data.qyrq);
   		    	win.constructionStandardForm.ks_id.setValue(vrecord.data.ks_id);
   		    	win.constructionStandardForm.xmbh_id.setValue(vrecord.data.xmbh_id);
   		    	win.constructionStandardForm.fzdjr.setValue(vrecord.data.fzdjr);
   		    	win.constructionStandardForm.fzzt.setValue(vrecord.data.fzzt);
   		    	win.constructionStandardForm.zhxgrq.setValue(vrecord.data.zhxgrq);
   		    	win.constructionStandardForm.xgr.setValue(vrecord.data.xgr);
   		    	win.constructionStandardForm.shr.setValue(vrecord.data.shr);
   		    	win.constructionStandardForm.shzt.setValue(vrecord.data.shzt);
   		    	win.constructionStandardForm.bz.setValue(vrecord.data.bz);
   		    	win.constructionStandardForm.fzrq.setValue(vrecord.data.fzrq);
   		    	win.constructionStandardForm.kssj.setValue(vrecord.data.kssj);
   		    	win.constructionStandardForm.jssj.setValue(vrecord.data.jssj);
   		 	win.constructionStandardForm.shrq.setValue(vrecord.data.shrq);
   		    	//win.constructionStandardForm.getForm().loadRecord(vrecord);
   		    	//alert(vrecord.data.scid+';'+vrecord.data.scname+";"+vrecord.data.scpath);

//				winForm.mc.setValue(vrecord.data.mc);

   		    	
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
	       		valueStr.push(records[i].get('id'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
				       	   url:PROJECT_NAME+'/jybzgl/jybzgl/delete',   
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) { 
				               	var obj = Ext.util.JSON.decode(form.responseText);
				               	if(obj.success == true){   //true / false
				               		 Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
					               	 dictStandardGrid.store.reload();
				               	}else{
				               		 Ext.MessageBox.alert("系统提示:", obj.message);
					               	 dictStandardGrid.store.reload();
				               	}
				              
			               },
			               failure: function(form, action) {
			            	   //Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
			               		Ext.MessageBox.alert("系统提示：",action.result.failure);
			               }
				       	});					
				}
	    	});	
    	}else{
    		 Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
         	return;
    	}
    },
//    onQueryClick:function(){
//    	dictStandardGrid.store.baseParams = {
//    		limit:dictStandardGrid.vbbar.pageSize,
//    		//module:this.module_name.getValue(),
//    		scmc:this.type_name.getValue(),
//    		sclx : "4"
//    	};
//    	dictStandardGrid.store.load({params:{start:0}});
//    },
    
});

/***************************************DictItemForm组件**************************************************/

DictItemForm = Ext.extend(Ext.ux.Form, {
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
//    	this.bzbh = this.createTextField('标准编号', 'bzbh', '100%','',null,100,'长度超过不能200');
		this.xmbh = this.createTextField('项目编号', 'xmbh', '100%','',null,100,'长度超过不能200');
		this.xmmc = this.createTextField('项目名称', 'xmmc', '100%','',null,100,'长度超过不能200');
		this.jldw = this.createTextField('计量单位', 'jldw', '100%','',null,100,'长度超过不能200');
		//做下拉框
		this.xmlx = this.createCombo('项目类型', 'ZDMC', 'ZDMC', 'xmlx', '100%', PROJECT_NAME+'/jybzgl/getDicByxlx');
		this.xmlx.store.load();
		this.xmlx.allowBlank = false;
		
		this.xmyq = this.createTextField('项目要求', 'xmyq', '100%','',null,100,'长度超过不能200');
//		this.bzmax = this.createTextField('标准最大值', 'bzmax', '100%','',null,100,'长度超过不能200');
//		this.bzmin = this.createTextField('标准最小值', 'bzmin', '100%','',null,100,'长度超过不能200');
		
		//做下拉框
		this.pdyy = this.createCombo('评定用语', 'ZDMC', 'ZDMC', 'pdyy', '100%', PROJECT_NAME+'/jybzgl/getDicBypd');
		this.pdyy.store.load();
		this.pdyy.allowBlank = false;
		this.jyyj = this.createTextField('检验依据', 'jyyj', '100%','',null,100,'长度超过不能200');
//		this.dj = this.createTextField('单价', 'dj', '100%','',null,100,'长度超过不能200');
		this.pdfs = this.createTextField('评定方式', 'pdfs', '100%','',null,100,'长度超过不能200');
		this.mjyy = this.createTextField('默认检验员', 'mjyy', '100%','',null,100,'长度超过不能200');
		this.zdcx = this.createTextField('最低检出限', 'zdcx', '100%','',null,100,'长度超过不能200');
		this.xmpx = this.createTextField('排序', 'xmpx', '100%','',null,100,'长度超过不能200');
		this.zxm_id = this.createTextField('子项目', 'zxm_id', '100%','',null,100,'长度超过不能200');
//		this.bgbh = this.createTextField('报告编号', 'bgbh', '100%','',null,100,'长度超过不能200');
//		this.jssj = this.createTextField('结束时间', 'jssj', '100%','',null,100,'长度超过不能200');
//		this.bz = this.createTextField('备注', 'bz', '100%','',null,100,'长度超过不能200');

    	this.bzbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准编号',
            name: 'bzbh',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	
    	this.bgbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>报告编号',
            name: 'bgbh',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.xmbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>项目编号',
            name: 'xmbh',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.xmmc = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>项目名称',
            name: 'xmmc',
            xtype: 'textfield',
            anchor: '100%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.bzmax = new Ext.form.NumberField({
            fieldLabel: '<font color="red"></font>标准最大值',
            name: 'bzmax',
            allowBlank: false,
            allowNegative :false,
            maxLength:10,
            maxLengthText:'长度超过不能10', 
            anchor: '100%',
            regex: /^\d+(\.\d+)?$/,
            blankText: '该选项为必填项,请输入内容...'
        });
    	this.bzmin = new Ext.form.NumberField({
            fieldLabel: '<font color="red"></font>标准最小值',
            name: 'bzmin',
            allowBlank: false,
            allowNegative :false,
            maxLength:10,
            maxLengthText:'长度超过不能10', 
            anchor: '100%',
            regex: /^\d+(\.\d+)?$/,
            blankText: '该选项为必填项,请输入内容...'
        });
    	this.dj = new Ext.form.NumberField({
            fieldLabel: '<font color="red"></font>单价',
            name: 'dj',
            allowBlank: false,
            allowNegative :false,
            maxLength:10,
            maxLengthText:'长度超过不能10', 
            anchor: '100%',
            regex: /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/,
            blankText: '该选项为必填项,请输入内容...'
        });
    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始时间',
			name: "kssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束时间',
			name: "jssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	 this.bz = new Ext.form.TextArea({
             fieldLabel: '备注',
             name: 'bz',
             readOnly: false,
             anchor: '100%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });
        
//		this.lx = this.createCombo('<span style="color:red">*</span>菜单类型:', 'zdz', 'zdmc', 'lx', '95%', PROJECT_NAME+'/wxauth/menu/getDicByLx');
////		this.lx.params.zdzl="cdlx";
//		this.lx.store.load();
//		this.lx.allowBlank = false;
    	 
    	this.bzbh.allowBlank = true;
     	this.xmbh.allowBlank = true;
     	this.xmmc.allowBlank = true;
     	this.jldw.allowBlank = true;
     	this.xmlx.allowBlank = true;
     	this.xmyq.allowBlank = true;
     	this.bzmax.allowBlank = true;
     	this.bzmin.allowBlank = true;
     	this.pdyy.allowBlank = true;
     	this.jyyj.allowBlank = true;
     	this.dj.allowBlank = true;
     	this.pdfs.allowBlank = true;
     	this.mjyy.allowBlank = true;
     	this.zdcx.allowBlank = true;
     	this.xmpx.allowBlank = true;
     	this.zxm_id.allowBlank = true;
     	this.kssj.allowBlank = true;
     	this.jssj.allowBlank = true;
     	this.bgbh.allowBlank = true;
     	this.bz.allowBlank = true;
     	
     	this.bzbh.readOnly = true;
     	
    	 var pnRow1=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[  
                 new Ext.Panel({  
                     columnWidth:.3,  
                     layout:'form',  
                     border:false,  
                     labelWidth:90,  
                     labelAlign:'right',  
                     items:[  
                         this.bzbh
                     ]  
                 }), 
                 new Ext.Panel({  
                     columnWidth:.3,  
                     layout:'form',  
                     border:false,  
                     labelWidth:80,  
                     labelAlign:'right',  
                     items:[  
                         this.xmbh
                     ]  
                 }),
                 new Ext.Panel({  
                     columnWidth:.3,  
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
         
         var pnRow2=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[  
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.jldw
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:80,  
                        labelAlign:'right',  
                        items:[  
                            this.xmlx
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.xmyq
                        ]  
                    }),
                ]  
         });
         var pnRow3=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[  
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.bzmax
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:80,  
                        labelAlign:'right',  
                        items:[  
                            this.bzmin
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.pdyy
                        ]  
                    }),
                ]  
         });
         var pnRow4=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[  
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.jyyj
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:80,  
                        labelAlign:'right',  
                        items:[  
                            this.dj
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.pdfs
                        ]  
                    }),
                ]  
         });
         var pnRow5=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[  
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.mjyy
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:80,  
                        labelAlign:'right',  
                        items:[  
                            this.zdcx
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.xmpx
                        ]  
                    }),
                ]
         });
         var pnRow6=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[
                    new Ext.Panel({  
                 	   columnWidth:.3,  
                 	   layout:'form',  
                 	   border:false,  
                 	   labelWidth:90,  
                 	   labelAlign:'right',  
                 	   items:[  
                 	       this.zxm_id
                 	   ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:80,  
                        labelAlign:'right',  
                        items:[  
                            this.kssj
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.3,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.jssj
                        ]  
                    }),
                ] 
         });
         var pnRow7=new Ext.Panel({  
             layout:'column',  
             border:false,  
             items:[  
                    new Ext.Panel({  
                        columnWidth:.45,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.bz
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.45,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                            this.bgbh
                        ]  
                    }), 
                ] 
         });
		
        DictItemForm.superclass.constructor.call(this, {
        	anchor: '100%',
        	autoHeight:true,
        	layout:"tableform",
        	layoutConfig: {columns: 1},
        	labelWidth: 90,
            labelAlign :'right',
            frame:true,
            bodyStyle:"padding: 5px 5px 0",
            width: '100%',
            items: [
//                	this.idHidden,
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
                      {text: '保存', width: 20,iconCls: 'save', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {
         if(this.getForm().isValid()) {
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+'/jybzgl/jyxmgl/save', 
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	dictItemGrid.constructionInsertWindow.hide();
                 	dictItemGrid.store.reload();
                 	dictItemGrid.vbbar.doLoad(dictItemGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
                 }
         	});
         }
     },
     updateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	var record = dictItemGrid.getSelectionModel().getSelections();
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+'/jybzgl/jyxmgl/update', 
                 method: 'POST',
                 params:{
                  	xmid:record[0].get('id')
                  },
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	dictItemGrid.constructionUpdateWindow.hide();
                 	dictItemGrid.store.reload();
                 	dictItemGrid.vbbar.doLoad(dictItemGrid.vbbar.cursor);//显示页数
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

/*************************************** ItemLookForm组件 **************************************************/
ItemLookForm = Ext.extend(Ext.ux.Form, {
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
//    	this.bzbh = this.createTextField('标准编号', 'bzbh', '90%','',null,100,'长度超过不能200');
		this.xmbh = this.createTextField('项目编号', 'xmbh', '90%','',null,100,'长度超过不能200');
//		this.xmmc = this.createTextField('项目名称', 'xmmc', '90%','',null,100,'长度超过不能200');
		this.jldw = this.createTextField('计量单位', 'jldw', '90%','',null,100,'长度超过不能200');
		this.xmlx = this.createTextField('项目类型', 'xmlx', '90%','',null,100,'长度超过不能200');
		this.xmyq = this.createTextField('项目要求', 'xmyq', '90%','',null,100,'长度超过不能200');
//		this.bzmax = this.createTextField('标准最大值', 'bzmax', '90%','',null,100,'长度超过不能200');
//		this.bzmin = this.createTextField('标准最小值', 'bzmin', '90%','',null,100,'长度超过不能200');
		this.pdyy = this.createTextField('评定用语', 'pdyy', '90%','',null,100,'长度超过不能200');
		this.jyyj = this.createTextField('检验依据', 'jyyj', '90%','',null,100,'长度超过不能200');
//		this.dj = this.createTextField('单价', 'dj', '90%','',null,100,'长度超过不能200');
		this.pdfs = this.createTextField('评定定方式', 'pdfs', '90%','',null,100,'长度超过不能200');
		this.mjyy = this.createTextField('默认检验员', 'mjyy', '90%','',null,100,'长度超过不能200');
		this.zdcx = this.createTextField('最低检出限', 'zdcx', '90%','',null,100,'长度超过不能200');
		this.xmpx = this.createTextField('排序', 'xmpx', '90%','',null,100,'长度超过不能200');
		this.zxm_id = this.createTextField('子项目', 'zxm_id', '90%','',null,100,'长度超过不能200');
//		this.kssj = this.createTextField('开始时间', 'kssj', '90%','',null,100,'长度超过不能200');
//		this.jssj = this.createTextField('结束时间', 'jssj', '90%','',null,100,'长度超过不能200');
//		this.bz = this.createTextField('备注', 'bz', '90%','',null,100,'长度超过不能200');

    	this.bzbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准编号',
            name: 'bzbh',
            xtype: 'textfield',
            anchor: '90%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.xmbh = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>项目编号',
            name: 'xmbh',
            xtype: 'textfield',
            anchor: '90%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.xmmc = new Ext.form.TextField({
            fieldLabel: '<font color="red">*</font>标准名称',
            name: 'xmmc',
            xtype: 'textfield',
            anchor: '90%',
            blankText: '该选项为必填项,请输入内容...',
            regex: /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/
        });
    	this.bzmax = new Ext.form.NumberField({
            fieldLabel: '<font color="red"></font>标准最大值',
            name: 'bzmax',
            allowBlank: false,
            allowNegative :false,
            maxLength:10,
            maxLengthText:'长度超过不能10', 
            anchor: '90%',
            regex: /^\d+(\.\d+)?$/,
            blankText: '该选项为必填项,请输入内容...'
        });
    	this.bzmin = new Ext.form.NumberField({
            fieldLabel: '<font color="red"></font>标准最小值',
            name: 'bzmin',
            allowBlank: false,
            allowNegative :false,
            maxLength:10,
            maxLengthText:'长度超过不能10', 
            anchor: '90%',
            regex: /^\d+(\.\d+)?$/,
            blankText: '该选项为必填项,请输入内容...'
        });
    	this.dj = new Ext.form.NumberField({
            fieldLabel: '<font color="red"></font>单价',
            name: 'dj',
            allowBlank: false,
            allowNegative :false,
            maxLength:10,
            maxLengthText:'长度超过不能10', 
            anchor: '90%',
            regex: /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/,
            blankText: '该选项为必填项,请输入内容...'
        });
    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始时间',
			name: "kssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束时间',
			name: "jssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	 this.bz = new Ext.form.TextArea({
             fieldLabel: '备注',
             name: 'bz',
             readOnly: false,
             anchor: '96.7%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         }); 
    	
//      this.ypbh.allowBlank = false;
    	this.bzbh.allowBlank = true;
    	this.xmbh.allowBlank = true;
    	this.xmmc.allowBlank = true;
    	this.jldw.allowBlank = true;
    	this.xmlx.allowBlank = true;
    	this.xmyq.allowBlank = true;
    	this.bzmax.allowBlank = true;
    	this.bzmin.allowBlank = true;
    	this.pdyy.allowBlank = true;
    	this.jyyj.allowBlank = true;
    	this.dj.allowBlank = true;
    	this.pdfs.allowBlank = true;
    	this.mjyy.allowBlank = true;
    	this.zdcx.allowBlank = true;
    	this.xmpx.allowBlank = true;
    	this.zxm_id.allowBlank = true;
    	this.kssj.allowBlank = true;
    	this.jssj.allowBlank = true;
    	this.bz.allowBlank = true;
        
        this.bzbh.readOnly = true;
        this.xmbh.readOnly = true;
        this.xmmc.readOnly = true;
        this.jldw.readOnly = true;
        this.xmlx.readOnly = true;
        this.xmyq.readOnly = true;
        this.bzmax.readOnly = true;
        this.bzmin.readOnly = true;
        this.pdyy.readOnly = true;
        this.jyyj.readOnly = true;
        this.dj.readOnly = true;
        this.pdfs.readOnly = true;
        this.mjyy.readOnly = true;
        this.zdcx.readOnly = true;
        this.xmpx.readOnly = true;
        this.zxm_id.readOnly = true;
        this.kssj.readOnly = true;
        this.jssj.readOnly = true;
        this.bz.readOnly = true;

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.33,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bzbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.33,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.xmbh
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.34,  
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
        
        var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jldw
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.xmlx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xmyq
                       ]  
                   }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.bzmax
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bzmin
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.pdyy
                       ]  
                   }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyyj
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.dj
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.pdfs
                       ]  
                   }),
               ]  
        });
        var pnRow5=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.mjyy
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.zdcx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xmpx
                       ]  
                   }),
               ]
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[
                   new Ext.Panel({  
                	   columnWidth:.33,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:90,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.zxm_id
                	   ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.33,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.kssj
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.34,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jssj
                       ]  
                   }),
               ] 
        });
        var pnRow7=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:1.0,  
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
        
        ItemLookForm.superclass.constructor.call(this, {
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
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/***************************************DictItemInsertWindow组件**************************************************/
DictItemInsertWindow = Ext.extend(Ext.Window,{
	constructionItemForm : null,
    constructor: function(grid) {
        this.constructionItemForm = new DictItemForm();
        this.constructionItemForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionItemForm.buttons[1].hide();   //显示修改按钮
        DictItemInsertWindow.superclass.constructor.call(this, {
            title: "添加项目信息",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            constrainHeader:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionItemForm]
        }); 
    }
});

/***************************************DictItemUpdateWindow组件**************************************************/
DictItemUpdateWindow = Ext.extend(Ext.Window, {
	constructionItemForm : null,
    constructor: function() {
    	this.constructionItemForm = new DictItemForm();
    	this.constructionItemForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionItemForm.buttons[1].show();   //显示修改按钮
    	DictItemUpdateWindow.superclass.constructor.call(this, {
        	title: "修改项目信息",
            width: 800,
            autoHeight:true,
            constrainHeader:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionItemForm]
        });
    }
});

/***************************************ConstructionLookWindow1组件**************************************************/
ConstructionLookWindow1 = Ext.extend(Ext.Window, {
	constructionItemForm : null,
    constructor: function() {
    	this.itemLookForm = new ItemLookForm();
    	ConstructionLookWindow1.superclass.constructor.call(this, {
        	title: "查看样品项目信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.itemLookForm]
        });
    }
});

/********************JyxmUploadWindow组件*************************/
JyxmUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.jyxmUpload = new JyxmUpload();
		JyxmUploadWindow.superclass.constructor.call(this, {
			title: '导入检验项目EXCEL数据',
			width: 600,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
			items: [this.jyxmUpload]
		});
	}
});

/********************JyxmUpload组件*************************/
JyxmUpload = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		this.fibasic = new Ext.ux.form.FileUploadField({
			 name: 'fileData',
			 id: 'form-file',
            emptyText: '例:XXX.xlsx',
            fieldLabel: '导入文件',
	        width: 400
	    });
		JyxmUpload.superclass.constructor.call(this, {
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
				url: JYXM_URL_UPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					dictItemGrid.store.load({params:{start:0,limit:PAGESIZE}});
					dictItemGrid.jyxmUploadWindow.hide();
				},
				failure: function(form, action){
					Ext.MessageBox.alert("系统提示：",action.result.message);
				}
			});
		}
	},
	//关闭
	onCloseClick: function(){
		dictItemGrid.jyxmUploadWindow.jyxmUpload.getForm().reset();
		this.ownerCt.hide();
	}
	
});

/**************************dictItemGrid*******************************************/
dictItemGrid = Ext.extend(UxGrid, {
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    sjid:'',
    cdlx:'',
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+DICT_ENTRY_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
                {name:'id'},{name:'bzbh'},{name:'xmbh'},{name:'xmmc'},{name:'jldw'},{name:'xmlx'},
                {name:'xmyq'},{name:'bzmax'},{name:'bzmin'},{name:'pdyy'},{name:'jyyj'},{name:'dj'},
                {name:'pdfs'},{name:'mjyy'},{name:'zdcx'},{name:'xmpx'},{name:'zxm_id'},{name:'kssj'},
                {name:'jssj'},{name:'bz'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                {text:'添加',iconCls: 'add',handler:this.onAddClick,scope:this},'-',
                {text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},'-',
            	{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},'-',
//            	{xtype:'textfield',id:'jyxm',width: 150,
//              	   emptyText:'项目编号&项目名称...',  
//             	    },'-',
//  	  			{xtype:'button',text:'查询',iconCls:'query',handler:function(){
//    						var code = Ext.getCmp('jyxm').getValue();
//    						dictItemGrid.store.baseParams= {code:code};
//    						dictItemGrid.store.load({params:{start:0,limit:PAGESIZE}});
//    				    }},'-',
//    				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
//    	   				Ext.getCmp('jyxm').setValue("");
//       			  }
//                },'-',
                {xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
		        	    if(btn=="yes"){ 
		        	    	window.open("/zjyw/resources/js/jybzgl/yjyxm.xls");
		        	   }
		        	 });
		    	 },scope:this}, '-',
		    	{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},'-',
		    	{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
		        	    if(btn=="yes"){ 		        	    	
		        	    	var fileName = "检验项目";
		        	    	var records=dictStandardGrid.getSelectionModel().getSelections();
		        	    	var sjid = records[0].get('bzbh');
//		        	    	var code = Ext.getCmp('canshu').getValue();
		        	    	var url = PROJECT_NAME + "/jybzgl/jyxmexport?fileName="+fileName+"&sjid="+sjid;   
		        	    	url = encodeURI(url);
		        	    	url = encodeURI(url);
		        	    	window.open(url);
		        	   }
		        	 });
	    		}
   			}
            ]
        });	
        this.constructionInsertWindow = new DictItemInsertWindow();       
        this.constructionUpdateWindow = new DictItemUpdateWindow();
        this.constructionLookWindow1 = new ConstructionLookWindow1();
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        dictItemGrid.superclass.constructor.call(this, {
        	id : 'id',
        	region:'south',
        	title: '检验项目',
        	collapsible: true,
        	stripeRows: true,
            frame: true,
            width:470,
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
                {header:'编号',dataIndex:'id',width:80,sortable: true, hidden:true},
            	{header:'项目编号',dataIndex:'xmbh',width:90,sortable: true},
                {header:'项目名称',dataIndex:'xmmc',width:90,sortable: true},
                {header:'计量单位',dataIndex:'jldw',width:90,sortable: true},
                {header:'项目类型',dataIndex:'xmlx',width:90,sortable: true},
                {header:'项目要求',dataIndex:'xmyq',width:90,sortable: true},
                {header:'标准最大值',dataIndex:'bzmax',width:90,sortable: true},
                {header:'标准最小值',dataIndex:'bzmin',width:90,sortable: true},
                {header:'评定用语',dataIndex:'pdyy',width:90,sortable: true},
                {header:'检验依据',dataIndex:'jyyj',width:90,sortable: true},
                {header:'单价',dataIndex:'dj',width:90,sortable: true},
                {header:'评定方式',dataIndex:'pdfs',width:90,sortable: true},
                {header:'默认检验员',dataIndex:'mjyy',width:90,sortable: true},
                {header:'最低检出限',dataIndex:'zdcx',width:90,sortable: true},
                {header:'排序',dataIndex:'xmpx',width:90,sortable: true},
                {header:'子项目ID',dataIndex:'zxm_id',width:90,sortable: true},
                {header:'开始时间',dataIndex:'kssj',width:90,sortable: true},
                {header:'结束时间',dataIndex:'jssj',width:90,sortable: true},
                {header:'备注',dataIndex:'bz',width:90,sortable: true},
                {header:'报告编号',dataIndex:'bgbh',width:90,sortable: true},

                {header: '操作', width: 120, dataIndex: 'id', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("id") != 0){
		return "<a href='javascript:;' onclick='dictItemGrid.onLook()' style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp" +
			   "<a href='javascript:;' onclick='dictItemGrid.onAddClick()' style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;'>子项目</span></a>&nbsp;&nbsp;&nbsp";
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
    
    onUploadClick: function(){             // 导入EXCEL数据
    	if(!this.jyxmUploadWindow)
    		this.jyxmUploadWindow = new JyxmUploadWindow();
    	var win = this.jyxmUploadWindow;
    	win.show();
    	win.jyxmUpload.getForm().reset();
    },
    
    onAddClick: function() {
    	if(this.sjid ==null || this.sjid ==''){
    		Ext.MessageBox.alert("提示", "请选择检验标准！");
    		return false;
    	}
	    var win = this.constructionInsertWindow;
	    var winForm = win.constructionItemForm;
	    win.show();
	    	
	    //winForm.thumbMediaId.setValue(mediaid);
	    win.constructionItemForm.getForm().reset();
	    winForm.bzbh.setValue(this.sjid);
    },

    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow1;
   		    	win.show();
   		    	win.itemLookForm.bzbh.setValue(vrecord.data.bzbh);
   		    	win.itemLookForm.xmbh.setValue(vrecord.data.xmbh);
   		    	win.itemLookForm.xmmc.setValue(vrecord.data.xmmc);
   		    	win.itemLookForm.jldw.setValue(vrecord.data.jldw);
   		    	win.itemLookForm.xmlx.setValue(vrecord.data.xmlx);
   		    	win.itemLookForm.xmyq.setValue(vrecord.data.xmyq);
   		    	win.itemLookForm.bzmax.setValue(vrecord.data.bzmax);
   		    	win.itemLookForm.bzmin.setValue(vrecord.data.bzmin);
   		    	win.itemLookForm.pdyy.setValue(vrecord.data.pdyy);
   		    	win.itemLookForm.jyyj.setValue(vrecord.data.jyyj);
   		    	win.itemLookForm.dj.setValue(vrecord.data.dj);
   		    	win.itemLookForm.pdfs.setValue(vrecord.data.pdfs);
   		    	win.itemLookForm.mjyy.setValue(vrecord.data.mjyy);
   		    	win.itemLookForm.zdcx.setValue(vrecord.data.zdcx);
   		    	win.itemLookForm.xmpx.setValue(vrecord.data.xmpx);
   		    	win.itemLookForm.zxm_id.setValue(vrecord.data.zxm_id);
   		    	win.itemLookForm.kssj.setValue(vrecord.data.kssj);
   		    	win.itemLookForm.jssj.setValue(vrecord.data.jssj);
   		    	win.itemLookForm.bz.setValue(vrecord.data.bz);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
//   		    	win.constructionItemForm.getForm().reset();
//   		    	var winForm = win.constructionItemForm;
   		    	win.show();
   		    	//win.constructionItemForm.getForm().loadRecord(vrecord);
   		    	win.constructionItemForm.bzbh.setValue(vrecord.data.bzbh);
   		    	win.constructionItemForm.xmbh.setValue(vrecord.data.xmbh);
   		    	win.constructionItemForm.xmmc.setValue(vrecord.data.xmmc);
   		    	win.constructionItemForm.jldw.setValue(vrecord.data.jldw);
   		    	win.constructionItemForm.xmlx.setValue(vrecord.data.xmlx);
   		    	win.constructionItemForm.xmyq.setValue(vrecord.data.xmyq);
   		    	win.constructionItemForm.bzmax.setValue(vrecord.data.bzmax);
   		    	win.constructionItemForm.bzmin.setValue(vrecord.data.bzmin);
   		    	win.constructionItemForm.pdyy.setValue(vrecord.data.pdyy);
   		    	win.constructionItemForm.jyyj.setValue(vrecord.data.jyyj);
   		    	win.constructionItemForm.dj.setValue(vrecord.data.dj);
   		    	win.constructionItemForm.pdfs.setValue(vrecord.data.pdfs);
   		    	win.constructionItemForm.mjyy.setValue(vrecord.data.mjyy);
   		    	win.constructionItemForm.zdcx.setValue(vrecord.data.zdcx);
   		    	win.constructionItemForm.xmpx.setValue(vrecord.data.xmpx);
   		    	win.constructionItemForm.zxm_id.setValue(vrecord.data.zxm_id);
   		    	win.constructionItemForm.kssj.setValue(vrecord.data.kssj);
   		    	win.constructionItemForm.jssj.setValue(vrecord.data.jssj);
   		    	win.constructionItemForm.bz.setValue(vrecord.data.bz);
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
	       		valueStr.push(records[i].get('id'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
				       	   url:PROJECT_NAME+'/jybzgl/jyxmgl/delete',
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) { 
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
				               dictItemGrid.store.reload();
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
    dictStandardGrid = new dictStandardGrid(Ext.getBody().getViewSize().height-160, Ext.getBody().getViewSize().width);
//    var param={};
//    param['sclx'] = "4";
//    dictStandardGrid.store.baseParams = param;
    dictStandardGrid.store.load({params:{start:0,limit:PAGESIZE}});
    
    dictItemGrid = new dictItemGrid(Ext.getBody().getViewSize().height-300, Ext.getBody().getViewSize());
    //dictItemGrid.store.load({params:{start:0,limit:PAGESIZE}});
    new Ext.Viewport({
    	layout: 'border',
    	items:[
			dictStandardGrid,
			dictItemGrid
    	]
    });
//    dictStandardGrid.constructionInsertWindow.show();
//    dictStandardGrid.constructionInsertWindow.hide();
   
});