var USER_GRID_STORE_URL = 'getSbxxList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

var ewmWindow;

/*************************************** StopForm组件 **************************************************/
StopForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
        //做下拉框
    	this.dw = this.createCombo('单位', 'ZDZ', 'ZDMC', 'dw', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx2');
		this.dw.store.load();
    	
    	this.sl = this.createTextField('数量', 'sl', '90%','',null,200,'长度超过不能200');
    	
        this.sbbh = this.createTextField('设备编号', 'sbbh', '90%','',null,100,'长度超过不能50');
    	
    	this.ewmbh = this.createTextField('设备条形码', 'ewmbh', '90%','',null,100,'长度超过不能50');
    	
    	this.sbmc = this.createTextField('设备名称', 'sbmc', '90%','',null,100,'长度超过不能50');
    	
//    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
    	
    	//做下拉框
    	this.sbjb = this.createCombo('设备级别', 'ZDZ', 'ZDMC', 'sbjb', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx');
		this.sbjb.store.load();
		this.sbjb.allowBlank = false;
    	
    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
    	
    	this.syks = this.createTextField('使用科室', 'syks', '90%','',null,100,'长度超过不能11');
    	
    	this.syfw = this.createTextField('使用范围', 'syfw', '90%','',null,100,'长度超过不能500');
    	
    	this.sccj = this.createTextField('生产厂家', 'sccj', '90%','',null,100,'长度超过不能100');
    	
    	this.ccbh = this.createTextField('出厂编号', 'ccbh', '90%','',null,200,'长度超过不能200');
    	
    	this.ccrq =  new Ext.form.DateField({
			fieldLabel: '出厂日期',
			name: "ccrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.gmrq =  new Ext.form.DateField({
			fieldLabel: '购买日期',
			name: "gmrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.gmjg = this.createTextField('购买价格', 'gmjg', '90%','',null,150,'长度超过不能11');
    	
    	this.jyzq = this.createTextField('检验周期', 'jyzq', '90%','',null,150,'长度超过不能11');
    	
    	this.syqx = this.createTextField('使用期限', 'syqx', '90%','',null,150,'长度超过不能150');
    	
    	this.scjdrq =  new Ext.form.DateField({
			fieldLabel: '上次检定日期',
			name: "scjdrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.xcjdrq =  new Ext.form.DateField({
			fieldLabel: '下次检定日期',
			name: "xcjdrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	
    	
    	this.syzt = new Ext.form.NumberField({
            fieldLabel: '使用状态',
            name: 'syzt',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            maxLength:10,
            maxLengthText:'数字长度超过不能10位', 
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	
    	this.sbwhr = this.createTextField('设备维护人', 'sbwhr', '90%','',null,150,'长度超过不能150');
    	
    	
    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始日期',
			name: "kssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束日期',
			name: "jssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.tyrq =  new Ext.form.DateField({
			fieldLabel: '停用日期',
			name: "tyrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.tyyy = this.createTextField('停用原因', 'tyyy', '90%','',null,150,'长度超过不能200');
        
        
    	this.sbbh.allowBlank = true;
        this.ewmbh.allowBlank = true;
        this.sbmc.allowBlank = true;
        this.sbxh.allowBlank = true;
        this.sbjb.allowBlank = true;
        this.syks.allowBlank = true;
        this.syfw.allowBlank = true;
        this.sccj.allowBlank = true;
        this.ccbh.allowBlank = true;
        this.ccrq.allowBlank = true;
        this.gmrq.allowBlank = true;
        this.gmjg.allowBlank = true;
        this.jyzq.allowBlank = true;
        this.syqx.allowBlank = true;
        this.scjdrq.allowBlank = true;
        this.xcjdrq.allowBlank = true;
        this.syzt.allowBlank = true;
        this.sbwhr.allowBlank = true;
        this.tyyy.allowBlank = false;
        this.tyrq.allowBlank = false;
        this.kssj.allowBlank = true;
        this.jssj.allowBlank = true;
        this.bz.allowBlank = true;
        this.dw.allowBlank = true;
        this.sl.allowBlank = true;

    	this.sbbh.readOnly = true;
        this.ewmbh.readOnly = true;
        this.sbmc.readOnly = true;
        this.sbxh.readOnly = true;
        this.sbjb.readOnly = true;
        this.syks.readOnly = true;
        this.syfw.readOnly = true;
        this.sccj.readOnly = true;
        this.ccbh.readOnly = true;
        this.ccrq.readOnly = true;
        this.gmrq.readOnly = true;
        this.gmjg.readOnly = true;
        this.jyzq.readOnly = true;
        this.syqx.readOnly = true;
        this.scjdrq.readOnly = true;
        this.xcjdrq.readOnly = true;
        this.syzt.readOnly = true;
        this.sbwhr.readOnly = true;
        this.kssj.readOnly = true;
        this.jssj.readOnly = true;
        this.bz.readOnly = true;
        this.dw.readOnly = true;
        this.sl.readOnly = true;
        
 
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
                        this.sbbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.ewmbh
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
                           this.sbmc
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbxh
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
                           this.sbjb
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dw
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
                           this.syks
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.syfw
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
                             this.sccj
                             ]  
                       }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyzq
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
                           this.syqx
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.scjdrq
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
                             this.ccbh
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ccrq
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
                           this.gmrq
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.gmjg
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
                             this.xcjdrq
                             ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.5,  
                           layout:'form',  
                           border:false,  
                           labelWidth:90,  
                           labelAlign:'right',  
                           items:[  
                                 this.sl
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
                             this.syzt
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                             this.sbwhr
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
                             this.kssj
                             ]  
                        }),
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
       
        var pnRow13=new Ext.Panel({  
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
                           this.tyyy
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.tyrq
                       ]  
                   }),
                  
               ] 
        });
       
       
        StopForm.superclass.constructor.call(this, {
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
                    pnRow13
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '停用', width: 20,iconCls:'add', handler: this.updateFormClick, scope: this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
                     ]
        });
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
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "停用成功!" + BLANKSTR);
                 	constructionGrid.constructionStopWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "停用失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** BfeiForm组件 **************************************************/
BfeiForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	//做下拉框
    	this.dw = this.createCombo('单位', 'ZDZ', 'ZDMC', 'dw', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx2');
		this.dw.store.load();
    	
    	this.sl = this.createTextField('数量', 'sl', '90%','',null,200,'长度超过不能200');
    	
    	this.sbbh = this.createTextField('设备编号', 'sbbh', '90%','',null,100,'长度超过不能50');
     	
     	this.ewmbh = this.createTextField('设备条形码', 'ewmbh', '90%','',null,100,'长度超过不能50');
     	
     	this.sbmc = this.createTextField('设备名称', 'sbmc', '90%','',null,100,'长度超过不能50');
     	
     	//做下拉框
     	this.sbjb = this.createCombo('设备级别', 'ZDMC', 'ZDMC', 'sbjb', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx');
		this.sbjb.store.load();
		this.sbjb.allowBlank = false;
    	
    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
     	
     	this.syks = this.createTextField('使用科室', 'syks', '90%','',null,100,'长度超过不能11');
     	
     	this.syfw = this.createTextField('使用范围', 'syfw', '90%','',null,100,'长度超过不能500');
     	
     	this.sccj = this.createTextField('生产厂家', 'sccj', '90%','',null,100,'长度超过不能100');
     	
     	this.ccbh = this.createTextField('出厂编号', 'ccbh', '90%','',null,200,'长度超过不能200');
     	
     	this.ccrq =  new Ext.form.DateField({
 			fieldLabel: '出厂日期',
 			name: "ccrq",
 			format: "Y-m-d",
 			anchor: '90%',
 			allowBlank: false,
 			editable:false,//不能手动输入
 			blankText: '请选择时间'
 		});
     	
     	this.gmrq =  new Ext.form.DateField({
 			fieldLabel: '购买日期',
 			name: "gmrq",
 			format: "Y-m-d",
 			anchor: '90%',
 			allowBlank: false,
 			editable:false,//不能手动输入
 			blankText: '请选择时间'
 		});
     	
     	this.gmjg = this.createTextField('购买价格', 'gmjg', '90%','',null,150,'长度超过不能11');
     	
     	this.jyzq = this.createTextField('检验周期', 'jyzq', '90%','',null,150,'长度超过不能11');
     	
     	this.syqx = this.createTextField('使用期限', 'syqx', '90%','',null,150,'长度超过不能150');
     	
     	this.scjdrq =  new Ext.form.DateField({
 			fieldLabel: '上次检定日期',
 			name: "scjdrq",
 			format: "Y-m-d",
 			anchor: '90%',
 			allowBlank: false,
 			editable:false,//不能手动输入
 			blankText: '请选择时间'
 		});
     	
     	this.xcjdrq =  new Ext.form.DateField({
 			fieldLabel: '下次检定日期',
 			name: "xcjdrq",
 			format: "Y-m-d",
 			anchor: '90%',
 			allowBlank: false,
 			editable:false,//不能手动输入
 			blankText: '请选择时间'
 		});
     	
     	
     	this.syzt = new Ext.form.NumberField({
             fieldLabel: '使用状态',
             name: 'syzt',
             allowNegative :false,
             regex: /^\d+(\.\d+)?$/,
             maxLength:10,
             maxLengthText:'数字长度超过不能10位', 
             anchor: '90%',
             cls:'forbiddenZH',
             blankText: '该选项为必填项,请输入内容...',
             hidden:false
         });
     	
     	this.sbwhr = this.createTextField('设备维护人', 'sbwhr', '90%','',null,150,'长度超过不能150');
     	
     	
     	this.kssj =  new Ext.form.DateField({
 			fieldLabel: '开始日期',
 			name: "kssj",
 			format: "Y-m-d",
 			anchor: '90%',
 			allowBlank: false,
 			editable:false,//不能手动输入
 			blankText: '请选择时间'
 		});
     	
     	this.jssj =  new Ext.form.DateField({
 			fieldLabel: '结束日期',
 			name: "jssj",
 			format: "Y-m-d",
 			anchor: '90%',
 			allowBlank: false,
 			editable:false,//不能手动输入
 			blankText: '请选择时间'
 		});
     	
     	
//     	this.bz = this.createTextField('备注', 'bz', '95%','',null,150,'长度超过不能50');
     	
     	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.bfrq =  new Ext.form.DateField({
			fieldLabel: '报废日期',
			name: "bfrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.bfyy = this.createTextField('报废原因', 'bfyy', '90%','',null,150,'长度超过不能200');
        
        
    	this.sbbh.allowBlank = true;
        this.ewmbh.allowBlank = true;
        this.sbmc.allowBlank = true;
        this.sbxh.allowBlank = true;
        this.sbjb.allowBlank = true;
        this.syks.allowBlank = true;
        this.syfw.allowBlank = true;
        this.sccj.allowBlank = true;
        this.ccbh.allowBlank = true;
        this.ccrq.allowBlank = true;
        this.gmrq.allowBlank = true;
        this.gmjg.allowBlank = true;
        this.jyzq.allowBlank = true;
        this.syqx.allowBlank = true;
        this.scjdrq.allowBlank = true;
        this.xcjdrq.allowBlank = true;
        this.syzt.allowBlank = true;
        this.sbwhr.allowBlank = true;
        this.bfyy.allowBlank = false;
        this.bfrq.allowBlank = false;
        this.kssj.allowBlank = true;
        this.jssj.allowBlank = true;
        this.bz.allowBlank = true;
        this.dw.allowBlank = true;
        this.sl.allowBlank = true;

    	this.sbbh.readOnly = true;
        this.ewmbh.readOnly = true;
        this.sbmc.readOnly = true;
        this.sbxh.readOnly = true;
        this.sbjb.readOnly = true;
        this.syks.readOnly = true;
        this.syfw.readOnly = true;
        this.sccj.readOnly = true;
        this.ccbh.readOnly = true;
        this.ccrq.readOnly = true;
        this.gmrq.readOnly = true;
        this.gmjg.readOnly = true;
        this.jyzq.readOnly = true;
        this.syqx.readOnly = true;
        this.scjdrq.readOnly = true;
        this.xcjdrq.readOnly = true;
        this.syzt.readOnly = true;
        this.sbwhr.readOnly = true;
        this.kssj.readOnly = true;
        this.jssj.readOnly = true;
        this.bz.readOnly = true;
        this.dw.readOnly = true;
        this.sl.readOnly = true;
        
 
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
                        this.sbbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.ewmbh
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
                           this.sbmc
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbxh
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
                           this.sbjb
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dw
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
                           this.syks
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.syfw
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
                             this.sccj
                             ]  
                       }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyzq
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
                           this.syqx
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.scjdrq
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
                             this.ccbh
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ccrq
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
                           this.gmrq
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.gmjg
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
                             this.xcjdrq
                             ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.5,  
                           layout:'form',  
                           border:false,  
                           labelWidth:90,  
                           labelAlign:'right',  
                           items:[  
                                 this.sl
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
                             this.syzt
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                             this.sbwhr
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
                             this.kssj
                             ]  
                        }),
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
        var pnRow13=new Ext.Panel({  
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
                           this.bfyy
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bfrq
                       ]  
                   }),
                  
               ] 
        });
       
       
        BfeiForm.superclass.constructor.call(this, {
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
                    pnRow13
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '报废', width: 20,iconCls:'add', handler: this.updateFormClick, scope: this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
                     ]
        });
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
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "报废成功!" + BLANKSTR);
                 	constructionGrid.constructionBfeiWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "报废失败!" + BLANKSTR);
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
    	
    	//做下拉框
    	this.dw = this.createCombo('单位', 'ZDZ', 'ZDMC', 'dw', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx2');
		this.dw.store.load();
    	
    	this.sl = this.createTextField('数量', 'sl', '90%','',null,200,'长度超过不能200');
    	
    	this.sbbh = this.createTextField('设备编号', 'sbbh', '90%','',null,100,'长度超过不能50');
    	
    	this.ewmbh = this.createTextField('设备条形码', 'ewmbh', '90%','',null,100,'长度超过不能50');
    	
    	this.sbmc = this.createTextField('设备名称', 'sbmc', '90%','',null,100,'长度超过不能50');
    	
//    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
    	
    	//做下拉框
    	this.sbjb = this.createCombo('设备级别', 'ZDMC', 'ZDMC', 'sbjb', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx');
		this.sbjb.store.load();
		this.sbjb.allowBlank = false;
    	
    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
    	
    	this.syks = this.createTextField('使用科室', 'syks', '90%','',null,100,'长度超过不能11');
    	
    	this.syfw = this.createTextField('使用范围', 'syfw', '90%','',null,100,'长度超过不能500');
    	
    	this.sccj = this.createTextField('生产厂家', 'sccj', '90%','',null,100,'长度超过不能100');
    	
    	this.ccbh = this.createTextField('出厂编号', 'ccbh', '90%','',null,200,'长度超过不能200');
    	
    	this.ccrq =  new Ext.form.DateField({
			fieldLabel: '出厂日期',
			name: "ccrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.gmrq =  new Ext.form.DateField({
			fieldLabel: '购买日期',
			name: "gmrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.gmjg = this.createTextField('购买价格', 'gmjg', '90%','',null,150,'长度超过不能11');
    	
    	this.jyzq = this.createTextField('检验周期', 'jyzq', '90%','',null,150,'长度超过不能11');
    	
    	this.syqx = this.createTextField('使用期限', 'syqx', '90%','',null,150,'长度超过不能150');
    	
    	this.scjdrq =  new Ext.form.DateField({
			fieldLabel: '上次检定日期',
			name: "scjdrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.xcjdrq =  new Ext.form.DateField({
			fieldLabel: '下次检定日期',
			name: "xcjdrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	
    	this.syzt = new Ext.form.NumberField({
            fieldLabel: '使用状态',
            name: 'syzt',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            maxLength:10,
            maxLengthText:'数字长度超过不能10位', 
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	
    	this.sbwhr = this.createTextField('设备维护人', 'sbwhr', '90%','',null,150,'长度超过不能150');
    	
    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始日期',
			name: "kssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束日期',
			name: "jssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.sbbh.allowBlank = true;
        this.ewmbh.allowBlank = true;
        this.sbmc.allowBlank = true;
        this.sbxh.allowBlank = true;
        this.sbjb.allowBlank = true;
        this.syks.allowBlank = true;
        this.syfw.allowBlank = true;
        this.sccj.allowBlank = true;
        this.ccbh.allowBlank = true;
        this.ccrq.allowBlank = true;
        this.gmrq.allowBlank = true;
        this.gmjg.allowBlank = true;
        this.jyzq.allowBlank = true;
        this.syqx.allowBlank = true;
        this.scjdrq.allowBlank = true;
        this.xcjdrq.allowBlank = true;
        this.syzt.allowBlank = true;
        this.sbwhr.allowBlank = true;
        this.kssj.allowBlank = true;
        this.jssj.allowBlank = true;
        this.bz.allowBlank = true;
        this.dw.allowBlank = true;
        this.sl.allowBlank = true;

    	this.sbbh.readOnly = true;
        this.ewmbh.readOnly = true;
        this.sbmc.readOnly = true;
        this.sbxh.readOnly = true;
        this.sbjb.readOnly = true;
        this.syks.readOnly = true;
        this.syfw.readOnly = true;
        this.sccj.readOnly = true;
        this.ccbh.readOnly = true;
        this.ccrq.readOnly = true;
        this.gmrq.readOnly = true;
        this.gmjg.readOnly = true;
        this.jyzq.readOnly = true;
        this.syqx.readOnly = true;
        this.scjdrq.readOnly = true;
        this.xcjdrq.readOnly = true;
        this.syzt.readOnly = true;
        this.sbwhr.readOnly = true;
        this.kssj.readOnly = true;
        this.jssj.readOnly = true;
        this.bz.readOnly = true;
        this.dw.readOnly = true;
        this.sl.readOnly = true;
 
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
                        this.sbbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.ewmbh
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
                           this.sbmc
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbxh
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
                           this.sbjb
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.dw
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
                           this.syks
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.syfw
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
                             this.sccj
                             ]  
                       }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.jyzq
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
                           this.syqx
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.scjdrq
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
                             this.ccbh
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ccrq
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
                           this.gmrq
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.gmjg
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
                             this.xcjdrq
                             ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.5,  
                           layout:'form',  
                           border:false,  
                           labelWidth:90,  
                           labelAlign:'right',  
                           items:[  
                                 this.sl
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
                             this.syzt
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                             this.sbwhr
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
                             this.kssj
                             ]  
                        }),
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
                    pnRow12
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
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	
    	//做下拉框
    	this.dw = this.createCombo('单位', 'ZDZ', 'ZDMC', 'dw', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx2');
		this.dw.store.load();
    	
    	this.sl = this.createTextField('数量', 'sl', '90%','',null,200,'长度超过不能200');
    	    	
    	this.sbbh = this.createTextField('<span style="color:red">*</span>设备编号', 'sbbh', '90%','',null,100,'长度超过不能50');
    	
    	this.ewmbh = this.createTextField('二维码编号', 'ewmbh', '90%','',null,100,'长度超过不能50');
    	
    	this.ewmtp = this.createTextField('二维码图片', 'ewmtp', '90%','',null,100,'长度超过不能50');

    	this.sbmc = this.createTextField('<span style="color:red">*</span>设备名称', 'sbmc', '90%','',null,100,'长度超过不能50');
    	
    	this.sblx = this.createTextField('设备类型', 'sblx', '90%','',null,100,'长度超过不能50');
    	
    	//做下拉框
    	this.sbjb = this.createCombo('设备级别', 'ZDMC', 'ZDMC', 'sbjb', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx');
		this.sbjb.store.load();
		this.sbjb.allowBlank = false;
    	
    	this.sbxh = this.createTextField('设备型号', 'sbxh', '90%','',null,100,'长度超过不能50');
    	
//    	this.syks = this.createTextField('使用科室', 'syks', '90%','',null,100,'长度超过不能11');
    	
    	this.syks = new zjyw.OrgSingelSelectAll('使用科室','syks','syks','90%');
    	
    	this.syfw = this.createTextField('使用范围', 'syfw', '90%','',null,100,'长度超过不能500');
    	
    	this.sccj = this.createTextField('生产厂家', 'sccj', '90%','',null,100,'长度超过不能100');
    	
    	this.ccbh = this.createTextField('出厂编号', 'ccbh', '90%','',null,200,'长度超过不能200');
    	
    	this.ccrq =  new Ext.form.DateField({
			fieldLabel: '出厂日期',
			name: "ccrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.gmrq =  new Ext.form.DateField({
			fieldLabel: '购买日期',
			name: "gmrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.gmjg = this.createTextField('购买价格', 'gmjg', '90%','',null,150,'长度超过不能11');
    	
    	this.jyzq = this.createTextField('检验周期', 'jyzq', '90%','',null,150,'长度超过不能11');
    	
    	this.syqx = this.createTextField('使用期限', 'syqx', '90%','',null,150,'长度超过不能150');
    	
    	this.scjdrq =  new Ext.form.DateField({
			fieldLabel: '<span style="color:red">*</span>上次检定日期',
			name: "scjdrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.xcjdrq =  new Ext.form.DateField({
			fieldLabel: '<span style="color:red">*</span>下次检定日期',
			name: "xcjdrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	//做下拉框
    	this.syzt = this.createCombo('使用状态', 'ZDZ', 'ZDMC', 'syzt', '90%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx1');
		this.syzt.store.load();
		this.syzt.allowBlank = false;
    	
    	this.sbwhr = this.createTextField('<span style="color:red">*</span>设备维护人', 'sbwhr', '90%','',null,150,'长度超过不能150');
    	
    	this.kssj =  new Ext.form.DateField({
			fieldLabel: '开始日期',
			name: "kssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '结束日期',
			name: "jssj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	this.sbfj = new Ext.form.TextArea({
            fieldLabel: '设备附件',
            name: 'sbfj',
            readOnly: false,
            anchor: '95%',
        });
    	
    	
        this.sbbh.allowBlank = false;
        this.ewmbh.allowBlank = true;
        this.sbmc.allowBlank = false;
        this.sbxh.allowBlank = true;
        this.sbjb.allowBlank = true;
        this.syks.allowBlank = true;
        this.syfw.allowBlank = true;
        this.sccj.allowBlank = true;
        this.ccbh.allowBlank = true;
        this.ccrq.allowBlank = true;
        this.gmrq.allowBlank = true;
        this.gmjg.allowBlank = true;
        this.jyzq.allowBlank = true;
        this.syqx.allowBlank = true;
        this.scjdrq.allowBlank = false;
        this.xcjdrq.allowBlank = false;
        this.syzt.allowBlank = true;
        this.sbwhr.allowBlank = false;
        this.kssj.allowBlank = true;
        this.jssj.allowBlank = true;
        this.bz.allowBlank = true;
        this.sl.allowBlank = true;
        this.dw.allowBlank = true;
        

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
                        this.sbbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.ewmbh
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
                           this.sbmc
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ewmtp
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
                           this.sbxh
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sblx
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
                           this.sbjb
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.syks
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
                             this.syfw
                             ]  
                       }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sccj
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
                           this.ccbh
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.ccrq
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
                             this.gmrq
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.gmjg
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
                           this.jyzq
                       ]  
                   }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.syqx
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
                             this.scjdrq
                             ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.5,  
                           layout:'form',  
                           border:false,  
                           labelWidth:90,  
                           labelAlign:'right',  
                           items:[  
                                 this.xcjdrq
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
                             this.dw
                             ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.5,  
                           layout:'form',  
                           border:false,  
                           labelWidth:90,  
                           labelAlign:'right',  
                           items:[  
                                 this.sl
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
                             this.syzt
                             ]  
                       }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                             this.sbwhr
                             ]  
                       }),
                 ]  
              });
        var pnRow12=new Ext.Panel({  
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
                             this.kssj
                             ]  
                        }),
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
                 ]  
              });
        var pnRow13=new Ext.Panel({  
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
        var pnRow14=new Ext.Panel({  
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
                         this.sbfj
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
						pnRow8,
						pnRow9,
						pnRow10,
						pnRow11,
						pnRow12,
						pnRow14,
						pnRow13
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

/***************************************EwmWindow组件**************************************************/
EwmWindow = Ext.extend(Ext.Window,{
    constructor: function(grid) {
    	EwmWindow.superclass.constructor.call(this, {
            width: 800,
            anchor: '100%',
            maximized :true,
            height: 400,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'close',
            html:'<iframe scrolling="auto" frameborder="0" width="100px;" height="100px;" src=""></iframe>'
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
            title: "设备新增",
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
        	title: "修改设备信息",
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
        	title: "查看设备信息",
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

/***************************************ConstructionStopWindow组件**************************************************/
ConstructionStopWindow = Ext.extend(Ext.Window, {
	stopForm : null,
    constructor: function() {
    	this.stopForm = new StopForm();
    	ConstructionStopWindow.superclass.constructor.call(this, {
        	title: "设备停用信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.stopForm]
        });
    }
});

/***************************************ConstructionBfeiWindow组件**************************************************/
ConstructionBfeiWindow = Ext.extend(Ext.Window, {
	bfeiForm : null,
    constructor: function() {
    	this.bfeiForm = new BfeiForm();
    	ConstructionBfeiWindow.superclass.constructor.call(this, {
        	title: "设备报废信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.bfeiForm]
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
			if(this.fibasic.getValue()==null || this.fibasic.getValue()==''){
				Ext.MessageBox.alert("系统提示：","请选择文件！");
				return false;
			}
			this.getForm().submit({
				waitMsg: '正在提交，请稍后...',
				url: ENTITY_URL_UPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					constructionGrid.ipasAssobjBankmemberUploadWindow.hide();
				},
				failure: function(form, action){
					escape="false",
					alert(encodeURI(encodeURI(action.result.message)));
					Ext.MessageBox.alert("系统提示：",encodeURI(encodeURI(action.result.message)) );
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
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            		[{name:'ID'},{name:'SBBH'},{name:'EWMBH'},{name:'SBMC'},{name:'SBXH'},{name:'SBJB'},
                     {name:'SYKS'},{name:'SYFW'},{name:'SCCJ'},{name:'CCBH'},{name:'CCRQ'},{name:'GMRQ'},
                     {name:'GMJG'},{name:'JYZQ'},{name:'SCJDRQ'},{name:'XCJDRQ'},{name:'SYZT'},{name:'SBWHR'},
                     {name:'TYRQ'},{name:'TYYY'},{name:'BFRQ'},{name:'BFYY'},{name:'BZ'},{name:'EWMTP'},
                     {name:'DW'},{name:'SBFJ'},{name:'FZDD'},{name:'QYSJ'},{name:'CJLXR'},{name:'CJDH'},
                     {name:'CJDZ'},{name:'CLFW'},{name:'PJXX'},{name:'SBCZR'},{name:'SFYCZGC'},{name:'SFYQJHC'},
                     {name:'SFYSYJL'},{name:'SFYGNJC'},{name:'SBZT'},{name:'CZGC'},{name:'SYSMS'},{name:'SBZP'},
                     {name:'SYSMFFJ'},{name:'GNJCFF'},{name:'QJHCFF'},{name:'BZDDJ'},{name:'JLQK'},{name:'JLJG'},
                     {name:'JDFY'},{name:'JDDW'},{name:'YQZK'},{name:'SYBM'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                    {text:'查看二维码',iconCls: 'edit',handler:this.onBqClick,scope:this},
                '-',{text:'登记',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'编辑',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'设备名称&设备编号...',  
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
    		        	    	window.open(PROJECT_NAME+"/resources/js/sbgl/Sbxx.xls");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		      '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                  '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "设备信息";
			        	    	var code = Ext.getCmp('code').getValue();
//			        	    	var records=dictStandardGrid.getSelectionModel().getSelections();
//			        	    	var code = records[0].get('code');
			        	    	var url = PROJECT_NAME + "/sbgl/YSbXx/export?fileName="+fileName+"&code="+code;
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
        this.constructionStopWindow = new ConstructionStopWindow();
        this.constructionBfeiWindow = new ConstructionBfeiWindow();
        
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
                {header:'id',dataIndex:'ID',width:70,sortable: true,hidden:true},
				{header:'使用状态',dataIndex:'SYZT',width:60,sortable: true,
                 	 renderer:function(value){
                         if(value == '0') {
                             return "<span style=color:blue>&nbsp;&nbsp;&nbsp;&nbsp;在用</span>";
                         }else if(value == '1') {
                             return "<span style=color:red>&nbsp;&nbsp;&nbsp;&nbsp;报废</span>";
                         }else if(value == '2'){
                       	  return "<span style=color:blue>&nbsp;&nbsp;&nbsp;&nbsp;检定</span>";
                         }else if(value == '3'){
                       	  return "<span style=color:blue>&nbsp;&nbsp;&nbsp;&nbsp;维修</span>";
                         }else if(value == '4'){
                       	  return "<span style=color:red>&nbsp;&nbsp;&nbsp;&nbsp;停用</span>";
                         }else if(value == '9'){
                       	  return "<span style=color:red>&nbsp;&nbsp;&nbsp;&nbsp;未知</span>";
                         }else{
                         	return value;
                         }
                 	 }
           	     },
                {header:'设备编号',dataIndex:'SBBH',width:60,sortable: true},
                {header:'二维码编号',dataIndex:'EWMBH',width:70,sortable: true,hidden:true},
                {header:'二维码图片',dataIndex:'EWMTP',width:70,sortable: true,
                	renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onBqClick()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>点击查看</span></a>";
						}
                },
            	{header:'设备名称',dataIndex:'SBMC',width:120,sortable: true},
            	{header:'规格型号',dataIndex:'SBXH',width:70,sortable: true,hidden:true},
            	{header:'设备精度',dataIndex:'SBJB',width:70,sortable: true,hidden:true},
            	{header:'测量范围（准确度/不确定度）',dataIndex:'CLFW',width:170,sortable: true,hidden:true},
            	{header:'计量单位',dataIndex:'DW',width:70,sortable: true,hidden:true,
            		renderer:function(value){
            			 if(value == '0') {
                             return "套";
                         }else if(value == '1'){
                       	  return "台";
                         }
            		}
            	},
            	{header:'使用科室',dataIndex:'SYKS',width:120,sortable: true},
            	{header:'使用参数',dataIndex:'SYFW',width:80,sortable: true,hidden:true},
            	{header:'放置地点',dataIndex:'FZDD',width:80,sortable: true,hidden:true},
            	{header:'启用时间',dataIndex:'QYSJ',width:80,sortable: true,hidden:true},
            	{header:'生产厂家',dataIndex:'SCCJ',width:80,sortable: true},
            	{header:'厂家联系人',dataIndex:'CJLXR',width:80,sortable: true,hidden:true},
            	{header:'厂家电话',dataIndex:'CJDH',width:80,sortable: true,hidden:true},
            	{header:'厂家地址',dataIndex:'CJDZ',width:80,sortable: true,hidden:true},
            	{header:'出厂编号',dataIndex:'CCBH',width:80,sortable: true,hidden:true},
            	{header:'购买价格（元）',dataIndex:'GMJG',width:100,sortable: true,hidden:true},
            	{header:'购买日期',dataIndex:'GMRQ',width:90,sortable: true,hidden:true},
            	{header:'操作人',dataIndex:'SBCZR',width:90,sortable: true,hidden:true},
            	{header:'登记日期',dataIndex:'CCRQ',width:80,sortable: true,hidden:true},
            	{header:'检定周期',dataIndex:'JYZQ',width:60,sortable: true,
            		 renderer:function(value){
                         if(value == '0') {
                             return "半年";
                         }else if(value == '1') {
                             return "一年";
                         }else if(value == '2'){
                       	  return "两年";
                         }else if(value == '3'){
                       	  return "三年";
                         }else if(value == '4'){
                       	  return "四年";
                         }else if(value == '5'){
                       	  return "五年";
                         }else if(value == '6'){
                       	  return "六年";
                         }else if(value == '9'){
                       	  return "未知";
                         }else{
                         	return value;
                         }
                 	 }	
            	},
            	{header:'上次检定日期',dataIndex:'SCJDRQ',width:90,sortable: true,hidden:true},
            	{header:'下次检定日期',dataIndex:'XCJDRQ',width:90,sortable: true},
            	{header:'设备状态',dataIndex:'SBZT',width:60,sortable: true,
            		renderer:function(value){
            			 if(value == '0') {
                             return "合格";
                         }else if(value == '1'){
                       	  return "限用";
                         }else if(value == '2'){
                       	  return "不合格";
                         }
            		}
            	},
            	{header:'保管人',dataIndex:'SBWHR',width:60,sortable: true,hidden:true},
            	{header:'配件信息',dataIndex:'PJXX',width:70,sortable: true,hidden:true},
            	{header:'标准度等级/不确定度',dataIndex:'BZDDJ',width:130,sortable: true,hidden:true},
            	{header:'计量情况',dataIndex:'JLQK',width:70,sortable: true,hidden:true},
            	{header:'计量结果',dataIndex:'JLJG',width:70,sortable: true,hidden:true},
            	{header:'检定费用（元）',dataIndex:'JDFY',width:100,sortable: true,hidden:true},
            	{header:'检定单位',dataIndex:'JDDW',width:90,sortable: true},
            	{header:'仪器状况',dataIndex:'YQZK',width:60,sortable: true,
                	 renderer:function(value){
                        if(value == '0') {
                            return "<span style=color:blue>&nbsp;&nbsp;&nbsp;&nbsp;在用</span>";
                        }else if(value == '1') {
                            return "<span style=color:red>&nbsp;&nbsp;&nbsp;&nbsp;报废</span>";
                        }else if(value == '2'){
                      	  return "<span style=color:blue>&nbsp;&nbsp;&nbsp;&nbsp;检定</span>";
                        }else if(value == '3'){
                      	  return "<span style=color:blue>&nbsp;&nbsp;&nbsp;&nbsp;维修</span>";
                        }else if(value == '4'){
                      	  return "<span style=color:red>&nbsp;&nbsp;&nbsp;&nbsp;停用</span>";
                        }else if(value == '9'){
                      	  return "<span style=color:red>&nbsp;&nbsp;&nbsp;&nbsp;未知</span>";
                        }else{
                        	return value;
                        }
                	 }
          	     },
          	    {header:'使用部门',dataIndex:'SYBM',width:120,sortable: true},
            	{header:'是否有操作规程',dataIndex:'SFYCZGC',width:120,sortable: true,hidden:true,
            		renderer:function(value){
            			 if(value == '0') {
                             return "有";
                         }else if(value == '1'){
                       	  return "无";
                         }
            		}
            	},
            	{header:'是否有期间核查',dataIndex:'SFYQJHC',width:120,sortable: true,hidden:true,
            		renderer:function(value){
            			 if(value == '0') {
                             return "有";
                         }else if(value == '1'){
                       	  return "无";
                         }
            		}
            	},
            	{header:'是否有使用记录',dataIndex:'SFYSYJL',width:120,sortable: true,hidden:true,
            		renderer:function(value){
            			 if(value == '0') {
                             return "有";
                         }else if(value == '1'){
                       	  return "无";
                         }
            		}
            	},
            	{header:'是否有功能检查',dataIndex:'SFYGNJC',width:120,sortable: true,hidden:true,
            		renderer:function(value){
            			 if(value == '0') {
                             return "有";
                         }else if(value == '1'){
                       	  return "无";
                         }
            		}
            	},
            	{header:'操作规程',dataIndex:'CZGC',width:70,sortable: true,hidden:true},
            	{header:'期间核查方法',dataIndex:'QJHCFF',width:120,sortable: true,hidden:true},
            	{header:'使用说明书',dataIndex:'SYSMS',width:70,sortable: true,hidden:true},
            	{header:'使用说明书附件',dataIndex:'SYSMFFJ',width:120,sortable: true,hidden:true},
            	{header:'功能检查方法',dataIndex:'GNJCFF',width:100,sortable: true,hidden:true},
            	{header:'设备照片',dataIndex:'SBZP',width:70,sortable: true,hidden:true},
            	{header:'其他附件',dataIndex:'SBFJ',width:70,sortable: true,hidden:true},
            	{header:'备注',dataIndex:'BZ',width:80,sortable: true,hidden:true},
            	{header:'停用原因',dataIndex:'TYYY',width:70,sortable: true,hidden:true},
            	{header:'停用日期',dataIndex:'TYRQ',width:80,sortable: true},
            	{header:'报废原因',dataIndex:'BFYY',width:70,sortable: true,hidden:true},
            	{header:'报废日期',dataIndex:'BFRQ',width:90,sortable: true,hidden:true},
            	 {header: '操作', width: 190, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("SYZT") == 0){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
					   		  "&nbsp&nbsp&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onStop()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>停用</span></a>"+
					   		  "&nbsp&nbsp&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onJding()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>检定</span></a>"+
					   		  "&nbsp&nbsp&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onWxiu()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>维修</span></a>"+
					   		  "&nbsp&nbsp&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onBfei()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>报废</span></a>";
            		}else if(record.get("SYZT") == 1 ){
                  		return  "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>停用</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>检定</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>维修</span></a>"+
		                  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:red;'>报废</span></a>";
        		    }else if(record.get("SYZT") == 2 ){
                  		return  "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>停用</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:red;'>检定</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>维修</span></a>"+
		                  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>报废</span></a>";
		      		}else if(record.get("SYZT") == 3 ){
		          		return  "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>停用</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>检定</span></a>"+
		                  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:red;'>维修</span></a>"+
		                  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>报废</span></a>";
		      		}else if(record.get("SYZT") == 4 ){
		          		return  "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='constructionGrid.onQyong()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>启用</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>检定</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>维修</span></a>"+
		                  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>报废</span></a>";
		      		}else if(record.get("SYZT") == 9 ){
		          		return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+ 
				   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>状态未知，请修改数据</span></a>";
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
    
    onBqClick: function() {       
    	var records=this.getSelectionModel().getSelections();
    	if(records.length > 0) {
    		if(records.length == 1){
    			vrecord = records[0];
    			var sbbh=vrecord.get('SBBH');
//    			var url = 'sbbqPage?sbbh='+sbbh;  	
//    			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
//    			ewmWindow = new EwmWindow();
//    			ewmWindow.setTitle("生成设备二维码");
//    			ewmWindow.html = html;
//    			ewmWindow.show();
    			window.open('sbbqPage?sbbh='+sbbh,'设备标签','height=500px, width=600px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
    		}else{
    			Ext.Msg.alert('系统提示', '不能选择多条记录..');
    		}
    	}else{
    		Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
    	}
    },
    
    onAddClick: function() {            //新增
    	var url = "sbxxAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("设备登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbxxOnlookView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onStop: function() {                  //停用
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbxxOnstopView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("设备停用");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onBfei: function() {                  //报废
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbxxOnbfeiView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("设备报废");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onJding: function() {                     //检定
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbxxOnjdingView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("设备检定");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onWxiu: function() {                     //维修
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbxxOnwxiuView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("设备维修");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onModifyClick: function() {    //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbxxUpdateView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("编辑信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

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
    
    onQyong: function() {                 //启用
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要启用此设备吗？",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'onQyong', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "启用成功!" + BLANKSTR);
				               constructionGrid.store.reload();
			               },
			               failure: function(form, action) {
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "启用失败!" + BLANKSTR);
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