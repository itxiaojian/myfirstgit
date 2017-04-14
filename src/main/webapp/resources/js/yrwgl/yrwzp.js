var USER_GRID_STORE_URL = 'getYrwRwzpList';
var PAGESIZE=20;
var RWZP_URL1 = '/yrwgl/yrwzp/getRwZprList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/*************************************** SendForm组件 **************************************************/
SendForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	    	
    	this.rwxarq =  new Ext.form.DateField({
			fieldLabel: '任务下达日期',
			name: "rwxarq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.yqwcrq =  new Ext.form.DateField({
			fieldLabel: '要求完成日期',
			name: "yqwcrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.zprq =  new Ext.form.DateField({
			fieldLabel: '指派日期',
			name: "zprq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.zxr = this.createTextField('执行人', 'zxr', '90%','',null,100,'长度超过不能11');
    	
    	this.cbnr = this.createTextField('<span style="color:red">*</span>督办内容', 'cbnr', '90%','',null,100,'长度超过不能11');
    	
        this.bgbh.allowBlank = true;
        this.rwxarq.allowBlank = true;
        this.yqwcrq.allowBlank = true;
        this.zprq.allowBlank = true;
        this.zxr.allowBlank = true;
        this.cbnr.allowBlank = false;
        
        this.bgbh.readOnly = true;
        this.rwxarq.readOnly = true;
        this.yqwcrq.readOnly = true;
        this.zprq.readOnly = true;
        this.zxr.readOnly = true;
        

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
                        this.rwxarq
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
                           this.yqwcrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false, 
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.zprq
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
                         this.zxr
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
						pnRow3
            ],
            buttonAlign :'center',
            buttons: [
                      {text:'发送督办',iconCls: 'edit',handler:this.sendFormClick,scope:this},
                      {text: '取消', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     sendFormClick: function() {       //督办
         if(this.getForm().isValid()) {
        	 var record=constructionGrid.getSelectionModel().getSelections();
         	this.getForm().submit({
                 waitMsg: '正在发送...',
                 url:'saveDban', 
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "督办成功!" + BLANKSTR);
                 	constructionGrid.constructionSendWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "督办失败!" + BLANKSTR);
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
//    	this.idHidden = this.createHidden('ID','id');
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.rwmc = this.createTextField('任务名称', 'rwmc', '90%','',null,100,'长度超过不能50');
    	this.ssxm = this.createTextField('所属项目', 'ssxm', '90%','',null,100,'长度超过不能50');
    	this.rwlx = this.createTextField('任务类型', 'rwlx', '90%','',null,100,'长度超过不能50');
    	this.yqksrq =  new Ext.form.DateField({
			fieldLabel: '要求开始时间',
			name: "yqksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.yqjsrq =  new Ext.form.DateField({
			fieldLabel: '要求结束时间',
			name: "yqjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.sjksrq =  new Ext.form.DateField({
			fieldLabel: '实际开始时间',
			name: "sjksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.sjjsrq =  new Ext.form.DateField({
			fieldLabel: '实际结束时间',
			name: "sjjsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.wcjd = this.createTextField('完成进度', 'wcjd', '90%','',null,100,'长度超过不能50');
    	this.zxr = this.createTextField('<span style=color:red>*</span>执行人', 'zxr', '90%','',null,100,'长度超过不能50');
    	
        this.bgbh.allowBlank = true;
        this.rwmc.allowBlank = true;
        this.ssxm.allowBlank = true;
        this.rwlx.allowBlank = true;
        this.yqksrq.allowBlank = true;
        this.yqjsrq.allowBlank = true;
        this.sjksrq.allowBlank = true;
        this.sjjsrq.allowBlank = true;
        this.wcjd.allowBlank = true;
        this.zxr.allowBlank = false;
        
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
                       columnWidth:.9,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.zxr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.1,  
                       layout:'form',  
                       border:false,  
                       labelWidth:50,
                       labelAlign:'right',  
                       items:[  
   							 new Ext.Button({
                                     text:'查找',
                                     constructionForm: this,
                                     handler:function(){
                                  		var win = new RwglZxrWindow();
                                  		win.constructionForm = this.constructionForm;
                                		win.show();
                                		win.rwglZxrGrid.rwglZxrWindow = win;
                                		win.rwglZxrGrid.store.load({params:{start:0,limit:PAGESIZE}});
                                     }
                                    }) 
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
						pnRow4
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '提交', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {
         if(this.getForm().isValid()) {
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'savenew', 
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理成功!" + BLANKSTR);
                 	constructionGrid.constructionInsertWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理失败!" + BLANKSTR);
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
//    	this.idHidden = this.createHidden('ID','id');
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '90%','',null,100,'长度超过不能50');
    	this.wtdw = this.createTextField('委托单位', 'wtdw', '90%','',null,100,'长度超过不能50');
    	this.yplx = this.createTextField('样品类型', 'yplx', '90%','',null,100,'长度超过不能50');
    	this.jylx = this.createTextField('检验类型', 'jylx', '90%','',null,100,'长度超过不能50');
    	this.jyks = this.createTextField('检验科室', 'jyks', '90%','',null,100,'长度超过不能50');
    	this.djry = this.createTextField('收样人', 'djry', '90%','',null,100,'长度超过不能50');
    	this.lxr = this.createTextField('联系人', 'lxr', '90%','',null,100,'长度超过不能50');
    	this.dh = this.createTextField('联系电话', 'dh', '90%','',null,100,'长度超过不能50');
    	this.jyzp = this.createTextField('检验指派', 'jyzp', '90%','',null,100,'长度超过不能50');
    	this.zxr = this.createTextField('执行人', 'zxr', '95%','',null,100,'长度超过不能50');
    	this.rwxarq =  new Ext.form.DateField({
			fieldLabel: '任务下达时间',
			name: "rwxarq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.yqwcrq =  new Ext.form.DateField({
			fieldLabel: '要求完成时间',
			name: "yqwcrq",
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
            anchor: '95%',
            height:100,
            maxLength: 256,
            maxLengthText: '256！'
        });

    	this.bgbh.allowBlank = true;
        this.ypmc.allowBlank = true;
        this.wtdw.allowBlank = true;
        this.yplx.allowBlank = true;
        this.jylx.allowBlank = true;
        this.jyks.allowBlank = true;
        this.djry.allowBlank = true;
        this.lxr.allowBlank = true;
        this.dh.allowBlank = true;
        this.rwxarq.allowBlank = true;
        this.yqwcrq.allowBlank = true;
        this.jyzp.allowBlank = true;
        this.zxr.allowBlank = true;
        this.bz.allowBlank = true;
    	
    	this.bgbh.readOnly = true;
        this.ypmc.readOnly = true;
        this.wtdw.readOnly = true;
        this.yplx.readOnly = true;
        this.jylx.readOnly = true;
        this.jyks.readOnly = true;
        this.djry.readOnly = true;
        this.lxr.readOnly = true;
        this.dh.readOnly = true;
        this.rwxarq.readOnly = true;
        this.yqwcrq.readOnly = true;
        this.jyzp.readOnly = false;
        this.zxr.readOnly = false;
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
                        this.ypmc
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
                           this.wtdw
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yplx
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
                           this.jylx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyks
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
                           this.lxr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dh
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
                           this.rwxarq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yqwcrq
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
					        this.djry
					    ]  
					}),
					new Ext.Panel({  
	                    columnWidth:.5,  
	                    layout:'form',  
	                    border:false,  
	                    labelWidth:90,  
	                    labelAlign:'right',  
	                    items:[  
	                        this.jyzp
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
                           this.zxr
                       ]  
                   }),
               ]  
        });
        var pnRow8=new Ext.Panel({  
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
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** DelayForm组件 **************************************************/
DelayForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '90%','',null,100,'长度超过不能50');
    	this.wtdw = this.createTextField('委托单位', 'wtdw', '90%','',null,100,'长度超过不能50');
    	this.yplx = this.createTextField('样品类型', 'yplx', '90%','',null,100,'长度超过不能50');
    	this.jylx = this.createTextField('检验类型', 'jylx', '90%','',null,100,'长度超过不能50');
    	this.jyks = this.createTextField('检验科室', 'jyks', '90%','',null,100,'长度超过不能50');
    	this.djry = this.createTextField('收样人', 'djry', '90%','',null,100,'长度超过不能50');
    	this.lxr = this.createTextField('联系人', 'lxr', '90%','',null,100,'长度超过不能50');
    	this.dh = this.createTextField('联系电话', 'dh', '90%','',null,100,'长度超过不能50');
    	this.jyzp = this.createTextField('检验指派', 'jyzp', '90%','',null,100,'长度超过不能50');
    	this.zxr = this.createTextField('执行人', 'zxr', '95%','',null,100,'长度超过不能50');
    	this.rwxarq =  new Ext.form.DateField({
			fieldLabel: '任务下达时间',
			name: "rwxarq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.yqwcrq =  new Ext.form.DateField({
			fieldLabel: '<span style=color:red>*</span>要求完成时间',
			name: "yqwcrq",
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
            anchor: '95%',
            height:100,
            maxLength: 256,
            maxLengthText: '256！'
        });


    	this.bgbh.allowBlank = true;
        this.ypmc.allowBlank = true;
        this.wtdw.allowBlank = true;
        this.yplx.allowBlank = true;
        this.jylx.allowBlank = true;
        this.jyks.allowBlank = true;
        this.djry.allowBlank = true;
        this.lxr.allowBlank = true;
        this.dh.allowBlank = true;
        this.rwxarq.allowBlank = true;
        this.yqwcrq.allowBlank = true;
        this.jyzp.allowBlank = true;
        this.zxr.allowBlank = true;
        this.bz.allowBlank = true;
        
        this.bgbh.readOnly = true;
        this.ypmc.readOnly = true;
        this.wtdw.readOnly = true;
        this.yplx.readOnly = true;
        this.jylx.readOnly = true;
        this.jyks.readOnly = true;
        this.djry.readOnly = true;
        this.lxr.readOnly = true;
        this.dh.readOnly = true;
        this.rwxarq.readOnly = true;
        this.yqwcrq.readOnly = false;
        this.jyzp.readOnly = true;
        this.zxr.readOnly = true;
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
                        this.ypmc
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
                           this.wtdw
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yplx
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
                           this.jylx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyks
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
                           this.lxr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dh
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
                           this.rwxarq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yqwcrq
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
					        this.djry
					    ]  
					}),
					new Ext.Panel({  
	                    columnWidth:.5,  
	                    layout:'form',  
	                    border:false,  
	                    labelWidth:90,  
	                    labelAlign:'right',  
	                    items:[  
	                        this.jyzp
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
                           this.zxr
                       ]  
                   }),
               ]  
        });
        var pnRow8=new Ext.Panel({  
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
        
        AppointForm.superclass.constructor.call(this, {
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
                      {text: '确定', width: 20,iconCls:'delay', hidden: false, handler: this.updateFormClick, scope: this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     updateFormClick: function() {       //延期
         if(this.getForm().isValid()) {
        	 var record=constructionGrid.getSelectionModel().getSelections();
         	 this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'delay', 
                 method: 'POST',
                 params:{
                   	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "延期成功!" + BLANKSTR);
                 	constructionGrid.constructionDelayWindow.hide();
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

/*************************************** AppointForm组件 **************************************************/
AppointForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
//    	this.idHidden = this.createHidden('ID','id');
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '90%','',null,100,'长度超过不能50');
    	this.wtdw = this.createTextField('委托单位', 'wtdw', '90%','',null,100,'长度超过不能50');
    	this.yplx = this.createTextField('样品类型', 'yplx', '90%','',null,100,'长度超过不能50');
    	this.jylx = this.createTextField('检验类型', 'jylx', '90%','',null,100,'长度超过不能50');
    	this.jyks = this.createTextField('检验科室', 'jyks', '90%','',null,100,'长度超过不能50');
    	this.djry = this.createTextField('收样人', 'djry', '90%','',null,100,'长度超过不能50');
    	this.lxr = this.createTextField('联系人', 'lxr', '90%','',null,100,'长度超过不能50');
    	this.dh = this.createTextField('联系电话', 'dh', '90%','',null,100,'长度超过不能50');
    	this.jyzp = this.createTextField('检验指派', 'jyzp', '90%','',null,100,'长度超过不能50');
    	this.zxr = this.createTextField('<span style=color:red>*</span>执行人', 'zxr', '99%','',null,100,'长度超过不能50');
    	this.rwxarq =  new Ext.form.DateField({
			fieldLabel: '任务下达时间',
			name: "rwxarq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.yqwcrq =  new Ext.form.DateField({
			fieldLabel: '要求完成时间',
			name: "yqwcrq",
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
            anchor: '95%',
            height:100,
            maxLength: 256,
            maxLengthText: '256！'
        });

        this.bgbh.allowBlank = true;
        this.ypmc.allowBlank = true;
        this.wtdw.allowBlank = true;
        this.yplx.allowBlank = true;
        this.jylx.allowBlank = true;
        this.jyks.allowBlank = true;
        this.djry.allowBlank = true;
        this.lxr.allowBlank = true;
        this.dh.allowBlank = true;
        this.rwxarq.allowBlank = true;
        this.yqwcrq.allowBlank = true;
        this.jyzp.allowBlank = true;
        this.zxr.allowBlank = false;
        this.bz.allowBlank = true;
        
        this.bgbh.readOnly = true;
        this.ypmc.readOnly = true;
        this.wtdw.readOnly = true;
        this.yplx.readOnly = true;
        this.jylx.readOnly = true;
        this.jyks.readOnly = true;
        this.djry.readOnly = true;
        this.lxr.readOnly = true;
        this.dh.readOnly = true;
        this.rwxarq.readOnly = true;
        this.yqwcrq.readOnly = true;
        
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
                        this.ypmc
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
                           this.wtdw
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yplx
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
                           this.jylx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyks
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
                           this.lxr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dh
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
                           this.rwxarq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yqwcrq
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
					        this.djry
					    ]  
					}),
					new Ext.Panel({  
	                    columnWidth:.5,  
	                    layout:'form',  
	                    border:false,  
	                    labelWidth:90,  
	                    labelAlign:'right',  
	                    items:[  
	                        this.jyzp
	                    ]  
	                }),
	                ]  
        });
        
        var pnRow7=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.9,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.zxr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.1,  
                       layout:'form',  
                       border:false,  
                       labelWidth:50,
                       labelAlign:'right',  
                       items:[  
   							 new Ext.Button({
                                     text:'查找',
                                     constructionForm: this,
                                     handler:function(){
                                  		var win = new RwglZxrWindow();
                                  		win.constructionForm = this.constructionForm;
                                		win.show();
                                		win.rwglZxrGrid.rwglZxrWindow = win;
                                		win.rwglZxrGrid.store.load({params:{start:0,limit:PAGESIZE}});
                                     }
                                    }) 
                       ]  
                   }),
               ]  
        });
        var pnRow8=new Ext.Panel({  
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
        
        AppointForm.superclass.constructor.call(this, {
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
                      {text: '提交', width: 20,iconCls:'submit', hidden: false, handler: this.addFormClick, scope: this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function() {       //指派
         if(this.getForm().isValid()) {
        	var record=constructionGrid.getSelectionModel().getSelections();
        	vrecord = record[0];
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'submit', 
                 method: 'POST',
                 params:{
                	 id:record[0].get('ID'),
                   },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "分配成功!" + BLANKSTR);
                 	constructionGrid.constructionAppointWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "分配失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});



/***************************************RwglZxrWindow组件**************************************************/
RwglZxrWindow = Ext.extend(Ext.Window,{
	khxx1Grid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.rwglZxrGrid = new RwglZxrGrid();
        RwglZxrWindow.superclass.constructor.call(this, {
            title: "选择人员",
            width: 600,
            anchor: '100%',
            autoHeight:false,
            constrainHeader:false,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.rwglZxrGrid]
        });
    }
});

/**************************RwglZxrGrid*******************************************/
RwglZxrGrid = Ext.extend(UxGrid, {
	RwglZxrWindow:null,
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+RWZP_URL1, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
             {name:'YHPXH'},{name:'DLM'},{name:'XM'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
               	 '-',{xtype:'label',text:'人员编号：'},
                 '-',{xtype:'textfield',id:'code1',width: 100,emptyText:'请输入查询关键字....',},
                 '-',{xtype:'label',text:'人员姓名：'},
                 '-',{xtype:'textfield',id:'code2',width: 100,emptyText:'请输入查询关键字....',},
     	  		 '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
     	  			 var code = document.getElementById('code').value;
					 constructionGrid.constructionInsertWindow.constructionForm.rwglZxrWindow.rwglZxrGrid.store.baseParams= {code1:code1,code2:code2};
					 constructionGrid.constructionInsertWindow.constructionForm.rwglZxrWindow.rwglZxrGrid.store.load({params:{start:0,limit:PAGESIZE}});
				     }},
       		     '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
       	   				Ext.getCmp('code1').setValue("");
       	   				Ext.getCmp('code2').setValue("");
          			 }},
          		 '-',{xtype:'button',text:'确定',iconCls:'save',handler:this.addClick,scope:this}
            ]
        });	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        RwglZxrGrid.superclass.constructor.call(this, {
        	region:'center',
        	title: '人员列表',
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
                {header:'人员编号', width: 150, dataIndex: 'YHPXH', sortable: true},
//	            {header:'登录账号', width: 100, dataIndex: 'DLM', sortable: true},
	            {header:'人员姓名', width: 100, dataIndex: 'XM', sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            	'rowdblclick':function(){
            		var records=this.getSelectionModel().getSelections();
            		var sjid = records[0].get('YHPXH');
            		this.rwglZxrWindow.constructionForm.zxr.setValue(records[0].get('XM'));
            		this.rwglZxrWindow.hide();
            	}
            }
        });
    },
	addClick: function() {
		var records=this.getSelectionModel().getSelections();
		var sjid = records[0].get('YHPXH');
		var str='';
		for(var i=0;i<records.length;i++){
			str=str+records[i].get('XM')+',';
		}
		var str = Ext.util.Format.substr(str, 0, str.length-1);
		this.rwglZxrWindow.constructionForm.zxr.setValue(str);
//    		this.rwglZxrWindow.constructionForm.zxr.setValue(records[0].get('dlm'));
		this.rwglZxrWindow.hide();
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
            title: "任务新增",
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
        	title: "修改任务信息",
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
/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看任务指派信息",
            width: 900,
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

/***************************************ConstructionDelayWindow组件**************************************************/
ConstructionDelayWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.delayForm = new DelayForm();
    	ConstructionDelayWindow.superclass.constructor.call(this, {
        	title: "任务延期",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.delayForm]
        });
    }
});

/***************************************ConstructionAppointWindow组件**************************************************/
ConstructionAppointWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.appointForm = new AppointForm();
    	ConstructionAppointWindow.superclass.constructor.call(this, {
        	title: "任务指派",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.appointForm]
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
            {name:'ID'},{name:'BGBH'},{name:'YPMC'}, {name:'WTDW'}, {name:'YPLX'},
            {name:'JYLX'},{name:'JYKS'},{name:'DJRY'}, {name:'LXR'}, {name:'DH'},
            {name:'RWXARQ'}, {name:'YQWCRQ'}, {name:'JYZP'}, {name:'ZPRQ'}, 
            {name:'ZPR'}, {name:'ZXR'}, {name:'BZ'}, {name:'CBZT'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'label',text:'检验编号'},
                '-',{xtype:'textfield',id:'code1',width: 120,emptyText:'检验编号...',},
                '-',{xtype:'label',text:'保管人'},
                '-',{xtype:'textfield',id:'code2',width: 120,emptyText:'保管人...',},
                '-',{xtype:'label',text:'委托单位'},
                '-',{xtype:'datefield',id:'code3',width: 100,emptyText:'委托单位...',},
    	  		'-',{xtype:'label',text:'查询',iconCls:'query',handler:function(){
      						var code1 = Ext.getCmp('code1').getValue();
      						var code2 = Ext.getCmp('code2').getValue();
      						var code3 = Ext.getCmp('code3').getValue();
      						constructionGrid.store.baseParams= {code1:code1,code2:code2,code3:code3};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				 }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code1').setValue("");
      	   				Ext.getCmp('code2').setValue("");
      	   				Ext.getCmp('code3').setValue("");
         			 }},
            ]
        });
   	
    	this.constructionSendWindow = new ConstructionSendWindow();
    	this.constructionInsertWindow = new ConstructionInsertWindow();       
        this.constructionUpdateWindow = new ConstructionUpdateWindow();
        this.constructionAppointWindow = new ConstructionAppointWindow();
        this.constructionLookWindow = new ConstructionLookWindow();
        this.constructionDelayWindow = new ConstructionDelayWindow();
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
                {header:'任务ID',dataIndex:'ID',width:60,sortable: true,hidden:true},
                {header: '操作', width: 150, dataIndex: 'id', align:"center",sortable: true,hidden: false,
                renderer:function(value, cellmeta, record){
                	if(record.get("ZXR") == null && record.get("CBZT") == null){
                        return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
                        "&nbsp&nbsp&nbsp<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
                        "<a href='javascript:;' onclick='constructionGrid.onAppointClick()' style='text-decoration:none;'>" +
                        "<span style='width: 25px;'>指派</span></a>&nbsp;&nbsp;&nbsp" +
                        "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                "<span style='width: 25px;color:grey;'>督办</span></a>&nbsp;&nbsp;&nbsp" +
		                "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                "<span style='width: 25px;color:grey;'>延期</span></a>";
                    }else if(record.get("ZXR") != null && record.get("CBZT") == null ){
              		return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
			   	           "&nbsp&nbsp&nbsp<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
		                   "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                   "<span style='width: 25px;color:grey;'>指派</span></a>&nbsp;&nbsp;&nbsp" +
		                   "<a href='javascript:;' onclick='constructionGrid.onSendClick()' style='text-decoration:none;'>" +
	                        "<span style='width: 25px;'>督办</span></a>&nbsp;&nbsp;&nbsp"+
	                        "<a href='javascript:;' onclick='constructionGrid.onDelayClick()' style='text-decoration:none;'>" +
	                        "<span style='width: 25px;'>延期</span></a>";
              		}else if(record.get("ZXR") != null && record.get("CBZT") == 0 ){
                  		return "<a href='javascript:;' onclick='constructionGrid.onLookClick()' style='text-decoration:none;'>" +
    			   	           "&nbsp&nbsp&nbsp<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp&nbsp&nbsp"+
    		                   "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
    		                   "<span style='width: 25px;color:grey;'>指派</span></a>&nbsp;&nbsp;&nbsp" +
    		                   "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
    		                   "<span style='width: 25px;color:grey;'>督办</span></a>&nbsp;&nbsp;&nbsp" +
    	                        "<a href='javascript:;' onclick='constructionGrid.onDelayClick()' style='text-decoration:none;'>" +
    	                        "<span style='width: 25px;'>延期</span></a>";
                  		}
                }
             },
             {header:'报告编号',dataIndex:'BGBH',width:90,sortable: true},
             {header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
             {header:'委托单位',dataIndex:'WTDW',width:120,sortable: true},
             {header:'样品类型',dataIndex:'YPLX',width:80,sortable: true},
             {header:'检验类型',dataIndex:'JYLX',width:80,sortable: true},
             {header:'检验科室',dataIndex:'JYKS',width:100,sortable: true},
             {header:'收样人',dataIndex:'DJRY',width:60,sortable: true},
             {header:'联系人',dataIndex:'LXR',width:60,sortable: true},
             {header:'联系电话',dataIndex:'DH',width:100,sortable: true},
             {header:'任务下达日期',dataIndex:'RWXARQ',width:100,sortable: true},
             {header:'要求完成日期',dataIndex:'YQWCRQ',width:100,sortable: true},
             {header:'指派日期',dataIndex:'ZPRQ',width:80,sortable: true},
             {header:'指派人',dataIndex:'ZPR',width:60,sortable: true},
             {header:'检验指派',dataIndex:'JYZP',width:100,sortable: true},
             {header:'执行人',dataIndex:'ZXR',width:100,sortable: true},
             {header:'备注',dataIndex:'BZ',width:200,sortable: true},
             {header:'是否督办',dataIndex:'CBZT',width:80,sortable: true,
            	 renderer:function(value){
                     if(value == '0') {
                         return "<span style=color:red>是</span>";
                     }else if(value == '1') {
                         return "<span>否</span>";
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
                //"dblclick": { fn: this.onModifyClick, scope: this}, 		//响应双击事件
                //"rowcontextmenu": {fn: this.onRightMenuClick, scope: this}  //响应右击事件
            }
        });
    },
    onAppointClick: function() {                  //指派
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionAppointWindow;
   		    	win.show();
   		    	win.appointForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.appointForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.appointForm.wtdw.setValue(vrecord.data.WTDW);
   		    	win.appointForm.yplx.setValue(vrecord.data.YPLX);
   		    	win.appointForm.jylx.setValue(vrecord.data.JYLX);
   		    	win.appointForm.jyks.setValue(vrecord.data.JYKS);
   		    	win.appointForm.djry.setValue(vrecord.data.DJRY);
   		    	win.appointForm.lxr.setValue(vrecord.data.LXR);
   		    	win.appointForm.dh.setValue(vrecord.data.DH);
   		    	win.appointForm.rwxarq.setValue(vrecord.data.RWXARQ);
   		    	win.appointForm.yqwcrq.setValue(vrecord.data.YQWCRQ);
   		    	win.appointForm.jyzp.setValue(vrecord.data.JYZP);
   		    	win.appointForm.zxr.setValue(vrecord.data.ZXR);
   		    	win.appointForm.bz.setValue(vrecord.data.BZ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
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
   		    	win.lookForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.lookForm.wtdw.setValue(vrecord.data.WTDW);
   		    	win.lookForm.yplx.setValue(vrecord.data.YPLX);
   		    	win.lookForm.jylx.setValue(vrecord.data.JYLX);
   		    	win.lookForm.jyks.setValue(vrecord.data.JYKS);
   		    	win.lookForm.djry.setValue(vrecord.data.DJRY);
   		    	win.lookForm.lxr.setValue(vrecord.data.LXR);
   		    	win.lookForm.dh.setValue(vrecord.data.DH);
   		    	win.lookForm.rwxarq.setValue(vrecord.data.RWXARQ);
   		    	win.lookForm.yqwcrq.setValue(vrecord.data.YQWCRQ);
   		    	win.lookForm.jyzp.setValue(vrecord.data.JYZP);
   		    	win.lookForm.zxr.setValue(vrecord.data.ZXR);
   		    	win.lookForm.bz.setValue(vrecord.data.BZ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    onDelayClick: function() {                  //延期
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionDelayWindow;
   		    	win.show();
   		    	win.delayForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.delayForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.delayForm.wtdw.setValue(vrecord.data.WTDW);
   		    	win.delayForm.yplx.setValue(vrecord.data.YPLX);
   		    	win.delayForm.jylx.setValue(vrecord.data.JYLX);
   		    	win.delayForm.jyks.setValue(vrecord.data.JYKS);
   		    	win.delayForm.djry.setValue(vrecord.data.DJRY);
   		    	win.delayForm.lxr.setValue(vrecord.data.LXR);
   		    	win.delayForm.dh.setValue(vrecord.data.DH);
   		    	win.delayForm.rwxarq.setValue(vrecord.data.RWXARQ);
   		    	win.delayForm.yqwcrq.setValue(vrecord.data.YQWCRQ);
   		    	win.delayForm.jyzp.setValue(vrecord.data.JYZP);
   		    	win.delayForm.zxr.setValue(vrecord.data.ZXR);
   		    	win.delayForm.bz.setValue(vrecord.data.BZ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    onAddClick: function() {             //新增任务
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	win.show();
    },
    
    onModifyClick: function() {             //修改
    	var records=this.getSelectionModel().getSelections();
		if(records.length > 0) {
			if(records.length == 1){
				vrecord = records[0];
		    	var win = this.constructionUpdateWindow;
//   		    	win.constructionForm.getForm().loadRecord(vrecord);
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
    
    onSendClick: function() {                  //发送督办
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionSendWindow;
   		    	win.show();
   		    	win.sendForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.sendForm.rwxarq.setValue(vrecord.data.RWXARQ);
   		    	win.sendForm.yqwcrq.setValue(vrecord.data.YQWCRQ);
   		    	win.sendForm.zprq.setValue(vrecord.data.ZPRQ);
   		    	win.sendForm.zxr.setValue(vrecord.data.ZXR);
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

