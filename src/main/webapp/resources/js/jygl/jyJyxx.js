var USER_GRID_STORE_URL = 'getJyxxList';
var PAGESIZE=20;
var YPXX_URL = '/ypgl/YYpYpxx/getYpxxList';//样品信息
//var JYSBXX_URL = '/jygl/YjySbxx/getJysbxxList';//检验设备信息
var SCJYSBXX_URL = '/jygl/YjySbxx/delete';//删除检验设备信息
var SBXX_URL = '/sbgl/YSbXx/getSbxxList';//设备信息
var JYXMXX_URL = '/jygl/YjyXmml/getXmmlList';//检验项目信息
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.bgbh = new Ext.form.TextField({
            fieldLabel: '报告编号',
            name: 'bgbh',
            anchor: '90%'
        });
    	this.ypbh = new Ext.form.TextField({
            fieldLabel: '报告编号',
            name: 'ypbh',
            anchor: '90%'
        });
    	this.jylb = new Ext.form.TextField({
            fieldLabel: '检验类别',
            name: 'jylb',
            anchor: '90%'
        });
    	this.yplb = new Ext.form.TextField({
            fieldLabel: '样品类别',
            name: 'yplb',
            anchor: '90%'
        });
    	this.bmbh = new Ext.form.TextField({
            fieldLabel: '部门编号',
            name: 'bmbh',
            anchor: '90%'
        });
    	this.djrq =  new Ext.form.DateField({
			fieldLabel: '登记日期',
			name: "djrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.jyyj = new Ext.form.TextField({
            fieldLabel: '检验依据',
            name: 'jyyj',
            anchor: '90%'
        });
    	this.jyqx =  new Ext.form.DateField({
			fieldLabel: '检验期限',
			name: "jyqx",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bzbh = new Ext.form.TextField({
            fieldLabel: '检验标准编号',
            name: 'bzbh',
            anchor: '90%'
        });
    	this.bzmc = new Ext.form.TextField({
            fieldLabel: '检验标准名称',
            name: 'bzmc',
            anchor: '90%'
        });
    	this.zjr = new Ext.form.TextField({
            fieldLabel: '主检人',
            name: 'zjr',
            anchor: '90%'
        });
    	this.ksrq =  new Ext.form.DateField({
			fieldLabel: '开始日期',
			name: "ksrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.jsrq =  new Ext.form.DateField({
			fieldLabel: '结束日期',
			name: "jsrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.hjtj = new Ext.form.TextField({
            fieldLabel: '环境条件',
            name: 'hjtj',
            anchor: '90%'
        });
    	this.xmms = new Ext.form.TextField({
            fieldLabel: '检验项目描述',
            name: 'xmms',
            anchor: '90%'
        });
    	this.jyff = new Ext.form.TextField({
            fieldLabel: '检验方法',
            name: 'jyff',
            anchor: '90%'
        });
    	this.pdyq = new Ext.form.TextField({
            fieldLabel: '判定要求',
            name: 'pdyq',
            anchor: '90%'
        });
    	this.qtsm = new Ext.form.TextField({
            fieldLabel: '其他说明',
            name: 'qtsm',
            anchor: '90%'
        });
    	this.jyfy = new Ext.form.NumberField({
            fieldLabel: '检验费用',
            name: 'jyfy',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.jjfy = new Ext.form.NumberField({
            fieldLabel: '加急费用',
            name: 'jjfy',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.qtfy = new Ext.form.NumberField({
            fieldLabel: '其他费用',
            name: 'qtfy',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.fyhj = new Ext.form.NumberField({
            fieldLabel: '费用合计',
            name: 'fyhj',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.swpd = new Ext.form.TextField({
            fieldLabel: '实物判定',
            name: 'swpd',
            anchor: '90%'
        });
    	this.bzpd = new Ext.form.TextField({
            fieldLabel: '标识判定',
            name: 'bzpd',
            anchor: '90%'
        });
    	this.jyjl = new Ext.form.TextField({
            fieldLabel: '检验结论',
            name: 'jyjl',
            anchor: '90%'
        });
    	this.rzfs = new Ext.form.TextField({
            fieldLabel: '认证方式',
            name: 'rzfs',
            anchor: '90%'
        });
    	this.jyzt = this.createCombo('催办状态','ZDZ' ,'ZDMC' , 'jyzt','90%', PROJECT_NAME+'/jygl/YjyJyxx/getDicByJyzt');
		this.jyzt.store.load();
    	this.tjrq =  new Ext.form.DateField({
			fieldLabel: '退检日期',
			name: "tjrq",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.tjyy = new Ext.form.TextField({
            fieldLabel: '退检原因',
            name: 'tjyy',
            anchor: '90%'
        });
    	this.tjr = new Ext.form.TextField({
            fieldLabel: '退检人',
            name: 'tjr',
            anchor: '90%'
        });
    	this.tbzt = this.createCombo('催办状态','ZDZ' ,'ZDMC' , 'tbzt','90%', PROJECT_NAME+'/jygl/YjyJyxx/getDicByCbzt');
		this.tbzt.store.load();
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '85%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.bgbh.allowBlank = false;
    	this.ypbh.allowBlank = false;
    	this.jylb.allowBlank = false;
    	this.yplb.allowBlank = false;
    	this.bmbh.allowBlank = false;
    	this.djrq.allowBlank = false;
    	this.jyyj.allowBlank = false;
    	this.jyqx.allowBlank = false;
    	this.bzbh.allowBlank = false;
    	this.bzmc.allowBlank = false;
    	this.zjr.allowBlank = false;
    	this.ksrq.allowBlank = false;
    	this.jsrq.allowBlank = false;
    	this.hjtj.allowBlank = false;
    	this.xmms.allowBlank = false;
    	this.jyff.allowBlank = false;
    	this.pdyq.allowBlank = false;
    	this.qtsm.allowBlank = false;
    	this.jyfy.allowBlank = false;
    	this.jjfy.allowBlank = false;
    	this.qtfy.allowBlank = false;
    	this.fyhj.allowBlank = false;
    	this.swpd.allowBlank = false;
    	this.bzpd.allowBlank = false;
    	this.jyjl.allowBlank = false;
    	this.rzfs.allowBlank = false;
    	this.jyzt.allowBlank = false;
    	this.tjrq.allowBlank = false;
    	this.tjyy.allowBlank = false;
    	this.tjr.allowBlank = false;
    	this.tbzt.allowBlank = false;
    	this.bz.allowBlank = true;
    	

//    	this.ypbh.readOnly = true;
 
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
                        this.bgbh
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ypbh
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.jylb
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
                           this.yplb
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bmbh
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.djrq
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
                           this.jyqx
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bzbh
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
                           this.bzmc
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.zjr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.ksrq
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
                           this.jsrq
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.hjtj
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.xmms
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
                	       this.jyff
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.pdyq
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.qtsm
                	   ]  
                   }),
               ] 
        });
        var pnRow7=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[
                   new Ext.Panel({  
                	   columnWidth:.255,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:90,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.jyfy
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.045,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:10,  
                	   labelAlign:'right',  
                	   items:[  
							new Ext.form.Label({
								text:'元'
							})
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.255,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.jjfy
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.045,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:10,  
                	   labelAlign:'right',  
                	   items:[  
							new Ext.form.Label({
								text:'元'
							})
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.255,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.qtfy
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.045,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:10,  
                	   labelAlign:'right',  
                	   items:[  
							new Ext.form.Label({
								text:'元'
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
                	   columnWidth:.255,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:90,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.fyhj
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.045,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:10,  
                	   labelAlign:'right',  
                	   items:[  
							new Ext.form.Label({
								text:'元'
							})
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.swpd
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.bzpd
                	   ]  
                   }),
               ] 
        });
        var pnRow9=new Ext.Panel({  
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
                	       this.jyjl
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.rzfs
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.jyzt
                	   ]  
                   }),
               ] 
        });
        var pnRow10=new Ext.Panel({  
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
                	       this.tjrq
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.tjyy
                	   ]  
                   }),
                   new Ext.Panel({  
                	   columnWidth:.3,  
                	   layout:'form',  
                	   border:false,  
                	   labelWidth:80,  
                	   labelAlign:'right',  
                	   items:[  
                	       this.tjr
                	   ]  
                   }),
               ] 
        });
        var pnRow11=new Ext.Panel({  
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
                	       this.tbzt
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
                	   labelAlign:'right',  
                	   items:[  
                	       this.bz
                	   ]  
                   }),
               ] 
        });
       
        this.ypxxWindow = new YpxxWindow();
        this.sbxxWindow = new SbxxWindow();
        this.jyxmxxWindow = new JyxmxxWindow();
        
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
						pnRow8,
						pnRow9,
						pnRow10,
						pnRow11,
						pnRow12
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '样品信息', width: 20,iconCls: 'add', hidden: false, handler: this.onYpClick, scope: this},
                      {text: '检验项目信息', width: 20,iconCls: 'add', hidden: false, handler: this.onJyxmClick, scope: this}, 
                      {text: '检验设备信息', width: 20,iconCls: 'add', hidden: false, handler: this.onSbxxClick, scope: this}, 
//					  {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
//					  {text:'提交',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     
     onYpClick: function(){   //样品信息
    	 var win = this.ypxxWindow;
    	 var record=constructionGrid.getSelectionModel().getSelections();
    	 var bgbh = record[0].get('BGBH');
//    	 alert(bgbh);
    	 win.show();
    	 win.ypxxGrid.store.load({params:{start:0,limit:PAGESIZE,bgbh:bgbh}});
 	},
 	
 	onSbxxClick: function(){   //设备信息
   	 var win = this.sbxxWindow;
   	 win.show();
   	 win.sbxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
	},
	
	onJyxmClick: function(){   //检验项目信息
	   	 var win = this.jyxmxxWindow;
	   	 win.show();
	   	 win.jyxmxxGrid.store.load({params:{start:0,limit:PAGESIZE}});
		},
	
     addFormClick: function() {     //增加
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

/*************************************** JysbForm组件 **************************************************/
JysbForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
    	this.sbbh = this.createTextField('设备编号', 'sbbh', '100%','',null,100,'长度超过不能50');
    	this.ewmbh = this.createTextField('设备条形码', 'ewmbh', '100%','',null,100,'长度超过不能50');
    	this.sbmc = this.createTextField('设备名称', 'sbmc', '100%','',null,100,'长度超过不能50');
    	this.sbjb = this.createCombo('设备级别', 'ZDMC', 'ZDMC', 'sbjb', '100%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx');
		this.sbjb.store.load();
    	this.sbxh = this.createTextField('设备型号', 'sbxh', '100%','',null,100,'长度超过不能50');
    	this.syks = new zjyw.OrgSingelSelectAll('使用科室','syks','syks','100%');
    	this.ccbh = this.createTextField('出厂编号', 'ccbh', '100%','',null,200,'长度超过不能200');
    	this.ccrq = this.createTextField('出厂日期', 'ccrq', '100%','',null,200,'长度超过不能200');
    	this.jyzq = this.createTextField('检验周期', 'jyzq', '100%','',null,150,'长度超过不能11');
    	this.syqx = this.createTextField('使用期限', 'syqx', '100%','',null,150,'长度超过不能150');
    	this.scjdrq = this.createTextField('上次检定日期', 'scjdrq', '100%','',null,150,'长度超过不能150');
    	this.xcjdrq = this.createTextField('下次检定日期', 'xcjdrq', '100%','',null,150,'长度超过不能150');
    	this.syzt = this.createCombo('使用状态', 'ZDZ', 'ZDMC', 'syzt', '100%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx1');
		this.syzt.store.load();
    	this.sbwhr = this.createTextField('设备维护人', 'sbwhr', '100%','',null,150,'长度超过不能150');
    	this.kssj = this.createTextField('开始时间', 'kssj', '100%','',null,150,'长度超过不能150');
    	this.jssj = this.createTextField('结束时间', 'jssj', '100%','',null,150,'长度超过不能150');
    	this.sysl = new Ext.form.NumberField({
            fieldLabel: '<font color="red">*</font>使用数量',
            name: 'sysl',
            allowNegative :false,
            maxLength:11,
            maxLengthText:'长度不能超过11位', 
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	this.syhzt = this.createCombo('<font color="red">*</font>使用后状态', 'ZDZ', 'ZDMC', 'syhzt', '100%', PROJECT_NAME+'/sbgl/YSbXx/getDicByLx1');
		this.syhzt.store.load();
		this.syhj = this.createTextField('<font color="red">*</font>使用环境', 'syhj', '100%','',null,150,'长度超过不能150');
		this.syr = this.createTextField('<font color="red">*</font>使用人', 'syr', '100%','',null,150,'长度超过不能150');
    	this.syrq =  new Ext.form.DateField({
			fieldLabel: '<font color="red">*</font>使用日期',
			name: "syrq",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
//    	this.jsrq =  new Ext.form.DateField({
//			fieldLabel: '结束日期',
//			name: "jsrq",
//			format: "Y-m-d",
//			anchor: '90%',
//			allowBlank: false,
//			editable:false,//不能手动输入
//			blankText: '请选择时间'
//		});
    	this.dw = this.createCombo('单位', 'ZDZ', 'ZDMC', 'dw_id', '100%', PROJECT_NAME+'/sbgl/YSbXx/getDw');
		this.dw.store.load();
		this.sl = this.createTextField('数量', 'sl', '100%','',null,150,'长度超过不能150');
    	
    	
        this.sbbh.allowBlank = true;
        this.ewmbh.allowBlank = true;
        this.sbmc.allowBlank = true;
        this.sbxh.allowBlank = true;
        this.syks.allowBlank = true;
        this.ccbh.allowBlank = true;
        this.jyzq.allowBlank = true;
        this.syqx.allowBlank = true;
        this.scjdrq.allowBlank = true;
        this.xcjdrq.allowBlank = true;
        this.sbwhr.allowBlank = true;
        this.kssj.allowBlank = true;
        this.jssj.allowBlank = true;
        this.dw.allowBlank = true;
        this.sl.allowBlank = true;
        this.sysl.allowBlank = false;
        this.syhj.allowBlank = false;
        this.syr.allowBlank = false;
        this.syrq.allowBlank = false;

        this.sbbh.readOnly = true;
        this.ewmbh.readOnly = true;
        this.sbmc.readOnly = true;
        this.sbxh.readOnly = true;
        this.syks.readOnly = true;
        this.ccbh.readOnly = true;
        this.jyzq.readOnly = true;
        this.syqx.readOnly = true;
        this.scjdrq.readOnly = true;
        this.xcjdrq.readOnly = true;
        this.sbwhr.readOnly = true;
        this.kssj.readOnly = true;
        this.jssj.readOnly = true;
        this.syzt.readOnly = true;
        this.sbjb.readOnly = true;
        this.dw.readOnly = true;
        this.sl.readOnly = true;

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
                        this.syzt
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.sbbh
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.3,  
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
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbmc
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbxh
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sbjb
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
					        this.syks
					    ]  
					}), 
					new Ext.Panel({  
					    columnWidth:.3,  
					    layout:'form',  
					    border:false,  
					    labelWidth:90,  
					    labelAlign:'right',  
					    items:[  
					        this.ccbh
					    ]  
					}),
					new Ext.Panel({  
		                  columnWidth:.3,  
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
					          this.syqx
					          ]  
					    }),
					    new Ext.Panel({  
					        columnWidth:.3,  
					        layout:'form',  
					        border:false,  
					        labelWidth:90,  
					        labelAlign:'right',  
					        items:[  
					            this.scjdrq
					        ]  
					    }), 
					    new Ext.Panel({  
					        columnWidth:.3,  
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
					          this.sbwhr
					          ]  
					    }),
					    new Ext.Panel({  
					    columnWidth:.3,  
					    layout:'form',  
					    border:false,  
					    labelWidth:90,  
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
					          this.dw
					          ]  
					    }),
					    new Ext.Panel({  
					    columnWidth:.3,  
					    layout:'form',  
					    border:false,  
					    labelWidth:90,  
					    labelAlign:'right',  
					    items:[  
					          this.sl
					          ]  
					    }), 
					    new Ext.Panel({  
					        columnWidth:.3,  
					        layout:'form',  
					        border:false,  
					        labelWidth:90,  
					        labelAlign:'right',  
					        items:[  
					              this.sysl
					              ]  
					        }),
               ] 
        });
        var pnRow7=new Ext.Panel({  
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
					          this.syhzt
					          ]  
					    }),
					    new Ext.Panel({  
					    columnWidth:.3,  
					    layout:'form',  
					    border:false,  
					    labelWidth:90,  
					    labelAlign:'right',  
					    items:[  
					          this.syhj
					          ]  
					    }), 
					    new Ext.Panel({  
						    columnWidth:.3,  
						    layout:'form',  
						    border:false,  
						    labelWidth:90,  
						    labelAlign:'right',  
						    items:[  
						          this.syr
						          ]  
						    }), 
                 ]  
              });
        var pnRow8=new Ext.Panel({  
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
					          this.syrq
					          ]  
					    }),
                 ]  
              });
        
        JysbForm.superclass.constructor.call(this, {
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
						pnRow8
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     
     addFormClick: function() {
    	 var records=constructionGrid.constructionUpdateWindow.constructionForm.sbxxWindow.sbxxGrid.getSelectionModel().getSelections();
    	 var sysl = this.sysl.getValue();
    	 var syhzt = this.syhzt.getValue();
    	 var syhj = this.syhj.getValue();
    	 var syr = this.syr.getValue();
    	 var syrq = this.syrq.getValue();
    	 var syhj = this.syhj.getValue();
    	 var syr = this.syr.getValue();
    	 var sl = this.sl.getValue();
     	if(parseInt(sysl) > parseInt(sl)){
     		Ext.MessageBox.alert("系统提示:", BLANKSTR + "使用数量大于设备数量，请重新输入!" + BLANKSTR);
     		return false;
     	}
    	 Ext.Ajax.request({
        		url: 'saveSbxx', 
 	       	   method : 'POST', 
 	       	   params: {
 	       		   id:records[0].get('ID'),
 	       		   sysl:sysl,syhzt:syhzt,syhj:syhj,syr:syr,syrq:syrq,syhj:syhj,syr:syr
 	       		   },
                success: function(form, action) {
 	               Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
 	              constructionGrid.constructionUpdateWindow.constructionForm.sbxxWindow.sbxxGrid.jysbWindow.hide();	
 	              constructionGrid.constructionUpdateWindow.constructionForm.sbxxWindow.sbxxGrid.store.reload();
                },
                failure: function(form, action) {
             	  Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
                }
 	    });
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});


/*****************************YpxxWindow***************************************/
YpxxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.ypxxGrid = new YpxxGrid();
    	YpxxWindow.superclass.constructor.call(this, {
    		title:'查看样品信息',
    		width: 900,
    		height:200,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.ypxxGrid],
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

/*****************************SbxxWindow***********************************/
SbxxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.sbxxGrid = new SbxxGrid();
    	SbxxWindow.superclass.constructor.call(this, {
    		title:'设备信息',
    		width: 1200,
    		height:100,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.sbxxGrid],
        	buttonAlign:'center',
	        buttons:[
//	                 {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
//    addFormClick: function() {     //增加
//    	var records=constructionGrid.constructionUpdateWindow.constructionForm.sbxxWindow.sbxxGrid.getSelectionModel().getSelections();
//    	Ext.Ajax.request({
//       		url: 'saveSbxx', 
//	       	   method : 'POST', 
//	       	   params: {id:records[0].get('ID')},
//               success: function(form, action) {
//	               Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
//	               constructionGrid.constructionUpdateWindow.constructionForm.sbxxWindow.hide();
//               },
//               failure: function(form, action) {
//            	  Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
//               }
//	    });
//    },
    closeClick: function() {
    	this.hide();
    }
});

/*****************************JyxmxxWindow***********************************/
JyxmxxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.jyxmxxGrid = new JyxmxxGrid();
    	JyxmxxWindow.superclass.constructor.call(this, {
    		title:'检验项目信息',
    		width: 900,
    		height:200,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.jyxmxxGrid],
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

/***************************************ConstructionUpdateWindow组件**************************************************/
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.constructionForm = new ConstructionForm();
//        this.constructionForm.buttons[2].show();   //隐藏添加按钮
//    	this.constructionForm.buttons[3].hide();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "样品检验",
            width: 1000,
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

/***************************************JysbWindow组件**************************************************/
JysbWindow = Ext.extend(Ext.Window, {
	jysbForm : null,
    constructor: function() {
    	this.jysbForm = new JysbForm();
    	JysbWindow.superclass.constructor.call(this, {
        	title: "检验设备",
            width: 1000,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.jysbForm]
        });
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

/*****************************YpxxGrid*****************/
YpxxGrid = Ext.extend(UxGrid, {
	ypxxWindow:null,
	pageSizeCombo:PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+YPXX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                            {name:'ID'},{name:'YPBH'},{name:'EWMBH'},{name:'YPMC'},{name:'YPLX'},
                            {name:'JYLX'},{name:'LYFS'},{name:'SZCS'},{name:'GGXH'},{name:'SCRQPC'},
                            {name:'YPDJ'},{name:'YPZT'},{name:'CYDD'},{name:'CYRQ'},{name:'CYJS'},
                            {name:'YPSL'},{name:'WTDW'},{name:'WTDWDZ'},{name:'SJDW'},
                            {name:'SJDWDZ'},{name:'LXR'},{name:'DH'},{name:'YB'},{name:'SCDW'},
                            {name:'SCDWDZ'},{name:'SCDWLXR'},{name:'SCDWDH'},{name:'SCDWYB'},
                            {name:'BZBH'},{name:'BZMC'},{name:'XMBH'},{name:'BGFSFS'},{name:'YHXTK'},
                            {name:'CYRY'},{name:'JCFYRY'},{name:'JYKS'},{name:'YWKS'},{name:'JYHTH'},
                            {name:'EWMTP'},{name:'JYFY'},{name:'JYFYDD'},{name:'BZ'},{name:'BGBH'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	var sm = new Ext.grid.CheckboxSelectionModel(); 
        YpxxGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: true,
            height: 400,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
                    {header:'编号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                    {header:'样品编号',dataIndex:'YPBH',width:80,sortable: true},
                    {header:'报告编号',dataIndex:'BGBH',width:80,sortable: true},
                    {header:'二维码编号',dataIndex:'EWMBH',width:80,sortable: true},
                  	{header:'样品名称',dataIndex:'YPMC',width:80,sortable: true},
                  	{header:'样品类型',dataIndex:'YPLX',width:80,sortable: true},
                  	{header:'检验类型',dataIndex:'JYLX',width:80,sortable: true},
                  	{header:'来样方式',dataIndex:'LYFS',width:80,sortable: true,
                  		renderer:function(value){
      	                    if(value == '0') {
      	                        return "<span>直送</span>";
      	                    }else if(value == '1') {
      	                        return "<span>快递</span>";
      	                    }else{
      	                    	return value;
      	                    }
                  		}
                  	},
                  	{header:'所在城市',dataIndex:'SZCS',width:80,sortable: true},
                  	{header:'规格型号',dataIndex:'GGXH',width:80,sortable: true},
                  	{header:'生产日期\批次',dataIndex:'SCRQPC',width:100,sortable: true},
                  	{header:'样品等级\类型',dataIndex:'YPDJ',width:100,sortable: true},
                  	{header:'样品状态',dataIndex:'YPZT',width:80,sortable: true},
                  	{header:'抽样地点',dataIndex:'CYDD',width:80,sortable: true},
                  	{header:'抽样日期',dataIndex:'CYRQ',width:80,sortable: true},
                  	{header:'抽样基数',dataIndex:'CYJS',width:80,sortable: true},
                  	{header:'样品数量',dataIndex:'YPSL',width:80,sortable: true},
                  	{header:'委托单位',dataIndex:'WTDW',width:80,sortable: true},
                  	{header:'委托单位地址',dataIndex:'WTDWDZ',width:100,sortable: true},
                  	{header:'受检单位',dataIndex:'SJDW',width:80,sortable: true},
                  	{header:'受检单位地址',dataIndex:'SJDWDZ',width:100,sortable: true},
                  	{header:'联系人',dataIndex:'LXR',width:80,sortable: true},
                  	{header:'电话',dataIndex:'DH',width:80,sortable: true},
                  	{header:'邮编',dataIndex:'YB',width:80,sortable: true},
                  	{header:'生产单位',dataIndex:'SCDW',width:80,sortable: true},
                  	{header:'生产单位地址',dataIndex:'SCDWDZ',width:100,sortable: true},
                  	{header:'生产单位联系人',dataIndex:'SCDWLXR',width:100,sortable: true},
                  	{header:'生产单位电话',dataIndex:'SCDWDH',width:100,sortable: true},
                  	{header:'生产单位邮编',dataIndex:'SCDWYB',width:100,sortable: true},
                  	{header:'检验标准编号',dataIndex:'BZBH',width:100,sortable: true},
                  	{header:'检验标准名称',dataIndex:'BZMC',width:100,sortable: true},
                  	{header:'检验项目编号',dataIndex:'XMBH',width:100,sortable: true},
                  	{header:'报告发送方式',dataIndex:'BGFSFS',width:100,sortable: true,
                  		renderer:function(value){
      	                    if(value == '0') {
      	                        return "<span>邮寄</span>";
      	                    }else if(value == '1') {
      	                        return "<span>自取（本所）</span>";
      	                    }else if(value == '2'){
      	                    	return "<span>自取（中心）</span>";
      	                    }else{
      	                    	return value;
      	                    }
                  		}
                  	},
                  	{header:'检验后须退库',dataIndex:'YHXTK',width:100,sortable: true,
                  		renderer:function(value){
      	                    if(value == '0') {
      	                        return "<span>退</span>";
      	                    }else if(value == '1') {
      	                        return "<span>不退</span>";
      	                    }else{
      	                    	return value;
      	                    }
                  		}
                  	},
                  	{header:'抽样人员',dataIndex:'CYRY',width:80,sortable: true},
                  	{header:'检查封样人员',dataIndex:'JCFYRY',width:100,sortable: true},
                  	{header:'检验科室',dataIndex:'JYKS',width:200,sortable: true},
                  	{header:'业务科室',dataIndex:'YWKS',width:200,sortable: true},
                  	{header:'检验合同号',dataIndex:'JYHTH',width:80,sortable: true},
                  	{header:'二维码图片',dataIndex:'EWMTP',width:80,sortable: true},
                  	{header:'检验费用',dataIndex:'JYFY',width:80,sortable: true},
                  	{header:'检验费用待定',dataIndex:'JYFYDD',width:100,sortable: true,
                  		renderer:function(value){
      	                    if(value == '0') {
      	                        return "<span>待定</span>";
      	                    }else if(value == '1') {
      	                        return "<span>不待定</span>";
      	                    }else{
      	                    	return value;
      	                    }
                  		}
                  	},
                  	
                  	{header:'备注',dataIndex:'BZ',width:80,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
    }
});

/*****************************SbxxGrid*****************/
SbxxGrid = Ext.extend(UxGrid, {
	ypxxWindow:null,
	pageSizeCombo:PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+SBXX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                    {name:'ID'},{name:'SBBH'},{name:'EWMBH'},{name:'SBMC'},{name:'SBXH'},{name:'DW'},{name:'SL'},
                    {name:'SBJB'},{name:'SYKS'},{name:'SYFW'},{name:'SCCJ'},{name:'CCBH'},
                    {name:'CCRQ'},{name:'GMRQ'},{name:'GMJG'},{name:'JYZQ'},{name:'SYQX'},
                    {name:'SCJDRQ'},{name:'XCJDRQ'},{name:'SYZT'},{name:'SBWHR'},{name:'KSSJ'},
                    {name:'JSSJ'},{name:'BZ'},{name:'SYSL'},{name:'SYHZT'},{name:'SYHJ'},{name:'SYRQ'},{name:'SYR'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加设备信息',iconCls: 'add',handler:this.onSbClick,scope:this},
                '-',{text:'增加',iconCls: 'add',handler:this.onModifyClick,scope:this},
//            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this}
            ]
        });
    	this.jysbWindow = new JysbWindow();
    	var sm = new Ext.grid.CheckboxSelectionModel(); 
    	SbxxGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: true,
            height: 400,
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
              {header:'使用状态',dataIndex:'SYZT',width:70,sortable: true,
              	renderer:function(value){
              		if(value == '0') {
              			return "<span style='color:blue;'>良好</span>";
              		}else if(value == '1') {
              			return "<span style='color:red;'>损坏</span>";
              		}else{
              			return value;
              		}
              	}
              },
              {header:'设备编号',dataIndex:'SBBH',width:70,sortable: true},
              {header:'设备条形码',dataIndex:'EWMBH',width:70,sortable: true},
            	{header:'设备名称',dataIndex:'SBMC',width:70,sortable: true},
            	{header:'设备型号',dataIndex:'SBXH',width:70,sortable: true},
            	{header:'设备级别',dataIndex:'SBJB',width:70,sortable: true},
            	{header:'使用科室',dataIndex:'SYKS',width:70,sortable: true},
            	{header:'出厂编号',dataIndex:'CCBH',width:70,sortable: true},
            	{header:'单位',dataIndex:'DW',width:70,sortable: true},
            	{header:'数量',dataIndex:'SL',width:70,sortable: true},
            	{header:'检验周期',dataIndex:'JYZQ',width:70,sortable: true},
            	{header:'使用期限',dataIndex:'SYQX',width:70,sortable: true},
            	{header:'上次检定日期',dataIndex:'SCJDRQ',width:70,sortable: true},
            	{header:'下次检定日期',dataIndex:'XCJDRQ',width:70,sortable: true},
            	{header:'设备维护人',dataIndex:'SBWHR',width:70,sortable: true},
            	{header:'开始日期',dataIndex:'KSSJ',width:70,sortable: true},
            	{header:'结束日期',dataIndex:'JSSJ',width:70,sortable: true}
//            	{header:'使用数量',dataIndex:'SYSL',width:70,sortable: true},
//            	{header:'使用后状态',dataIndex:'SYHZT',width:70,sortable: true},
//            	{header:'使用环境',dataIndex:'SYHJ',width:70,sortable: true},
//            	{header:'使用人',dataIndex:'SYR',width:70,sortable: true},
//            	{header:'使用日期',dataIndex:'SYRQ',width:70,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    
    onModifyClick: function() {         //增加+
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.jysbWindow;
   		    	win.show();
   		    	win.jysbForm.syzt.setValue(vrecord.data.SYZT);
   		    	win.jysbForm.sbbh.setValue(vrecord.data.SBBH);
   		    	win.jysbForm.ewmbh.setValue(vrecord.data.EWMBH);
   		    	win.jysbForm.sbmc.setValue(vrecord.data.SBMC);
   		    	win.jysbForm.sbxh.setValue(vrecord.data.SBXH);
   		    	win.jysbForm.sbjb.setValue(vrecord.data.SBJB);
   		    	win.jysbForm.syks.setValue(vrecord.data.SYKS);
   		    	win.jysbForm.ccbh.setValue(vrecord.data.CCBH);
   		    	win.jysbForm.jyzq.setValue(vrecord.data.JYZQ);
   		    	win.jysbForm.syqx.setValue(vrecord.data.SYQX);
   		    	win.jysbForm.scjdrq.setValue(vrecord.data.SCJDRQ);
   		    	win.jysbForm.xcjdrq.setValue(vrecord.data.XCJDRQ);
   		    	win.jysbForm.sbwhr.setValue(vrecord.data.SBWHR);
   		    	win.jysbForm.kssj.setValue(vrecord.data.KSSJ);
   		    	win.jysbForm.jssj.setValue(vrecord.data.JSSJ);
   		    	win.jysbForm.sysl.setValue(vrecord.data.SYSL);
   		    	win.jysbForm.syhzt.setValue(vrecord.data.SYHZT);
   		    	win.jysbForm.syhj.setValue(vrecord.data.SYHJ);
   		    	win.jysbForm.syr.setValue(vrecord.data.SYR);
   		    	win.jysbForm.syrq.setValue(vrecord.data.SYRQ);
   		    	win.jysbForm.dw.setValue(vrecord.data.DW);
   		    	win.jysbForm.sl.setValue(vrecord.data.SL);
   			}else{
   				Ext.Msg.alert('系统提示', '不能添加多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
});

/*****************************JyxmxxGrid*****************/
JyxmxxGrid = Ext.extend(UxGrid, {
	ypxxWindow:null,
	pageSizeCombo:PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+JYXMXX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                    {name:'ID'},{name:'BGBH'},{name:'BZBH'},{name:'XMBH'},{name:'XMMC'},{name:'XMLX'},
                    {name:'XMYQ'},{name:'JLDW'},{name:'JYFY'},{name:'BZMAX'},{name:'BZMIN'},{name:'SCZ'},
                    {name:'PDYY'},{name:'JYRQ'},{name:'BMBH'},{name:'PDFS'},{name:'JYR'},{name:'ZDCX'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加设备信息',iconCls: 'add',handler:this.onSbClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this}
            ]
        });
    	var sm = new Ext.grid.CheckboxSelectionModel(); 
    	JyxmxxGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: true,
            height: 400,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
	            {header:'序号',dataIndex:'ID',width:100,sortable: true, hidden:true},
	            {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
	            {header:'标准编号',dataIndex:'BZBH',width:100,sortable: true},
              	{header:'项目编号',dataIndex:'XMBH',width:100,sortable: true},
              	{header:'项目名称',dataIndex:'XMMC',width:100,sortable: true},
              	{header:'项目类型',dataIndex:'XMLX',width:100,sortable: true},
              	{header:'项目要求',dataIndex:'XMYQ',width:100,sortable: true},
              	{header:'计量单位',dataIndex:'JLDW',width:100,sortable: true},
              	{header:'检验费用',dataIndex:'JYFY',width:100,sortable: true},
              	{header:'标准最大值',dataIndex:'BZMAX',width:100,sortable: true},
              	{header:'标准最小值',dataIndex:'BZMIN',width:100,sortable: true},
              	{header:'实测值',dataIndex:'SCZ',width:100,sortable: true},
              	{header:'评定结果',dataIndex:'PDYY',width:100,sortable: true},
              	{header:'检验日期',dataIndex:'JYRQ',width:100,sortable: true},
              	{header:'检验科室',dataIndex:'BMBH',width:100,sortable: true},
              	{header:'评定方式',dataIndex:'PDFS',width:100,sortable: true},
              	{header:'检验人',dataIndex:'JYR',width:100,sortable: true},
              	{header:'最低检出限',dataIndex:'ZDCX',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
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
                            {name:'ID'},{name:'BGBH'},{name:'YPBH'},{name:'JYLB'},{name:'YPLB'},{name:'BMBH'},
                            {name:'DJRQ'},{name:'JYYJ'},{name:'JYQX'},{name:'BZBH'},{name:'BZMC'},{name:'ZJR'},{name:'KSRQ'},{name:'JSRQ'},{name:'HJTJ'},
                            {name:'XMMS'},{name:'JYFF'},{name:'PDYQ'},{name:'QTSM'},{name:'JYFY'},{name:'JJFY'},{name:'QTFY'},{name:'FYHJ'},{name:'SWPD'},
                            {name:'BZPD'},{name:'JYJL'},{name:'RZFS'},{name:'JYZT'},{name:'TJRQ'},{name:'TJYY'},{name:'TJR'},{name:'TBZT'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'canshu',width: 250,
                	   emptyText:'报告编号&&样品编号...',  
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
            ]
        });
//    	this.constructionInsertWindow = new ConstructionInsertWindow();
    	this.constructionUpdateWindow = new ConstructionUpdateWindow();
//    	this.constructionLookWindow = new ConstructionLookWindow();
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
            	{header:'序号',dataIndex:'ID',width:100,sortable: true, hidden:true},
            	{header: '操作', width: 150, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("JYZT") == '待检'){
						   return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>流转日志</span></a>&nbsp;&nbsp;&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>检验</span></a>";
            		}else{
            			 return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
				   		  "<span style='width: 25px;cursor: pointer;'>流转日志</span></a>&nbsp;&nbsp;&nbsp"+
				   		  "<span style='width: 25px;color:gray;'>检验</span>";
            		}
				  }
            	},
            	{header:'检验状态',dataIndex:'JYZT',width:100,sortable: true,
            		renderer:function(value){
	                    if(value == '在检') {
	                        return "<span style='color:green'>在检</span>";
	                    }else if(value == '待检') {
	                        return "<span style='color:blue'>待检</span>";
	                    }else if(value == '已检'){
	                    	return "<span style='color:red'>已检</span>";
	                    	return value;
	                    }
            		}
            	},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
                {header:'样品编号',dataIndex:'YPBH',width:100,sortable: true},
            	{header:'检验类别',dataIndex:'JYLB',width:100,sortable: true},
            	{header:'样品类别',dataIndex:'YPLB',width:100,sortable: true},
            	{header:'检验科室',dataIndex:'BMBH',width:100,sortable: true},
            	{header:'登记日期',dataIndex:'DJRQ',width:100,sortable: true},
            	{header:'检验依据',dataIndex:'JYYJ',width:100,sortable: true},
            	{header:'检验期限',dataIndex:'JYQX',width:100,sortable: true},
            	{header:'检验标准编号',dataIndex:'BZBH',width:100,sortable: true},
            	{header:'检验标准名称',dataIndex:'BZMC',width:100,sortable: true},
            	{header:'主检人',dataIndex:'ZJR',width:100,sortable: true},
            	{header:'开始日期',dataIndex:'KSRQ',width:100,sortable: true},
            	{header:'结束日期',dataIndex:'JSRQ',width:100,sortable: true},
            	{header:'环境条件',dataIndex:'HJTJ',width:100,sortable: true},
            	{header:'检验项目描述',dataIndex:'XMMS',width:100,sortable: true},
            	{header:'检验方法',dataIndex:'JYFF',width:100,sortable: true},
            	{header:'判定要求',dataIndex:'PDYQ',width:100,sortable: true},
            	{header:'其他说明',dataIndex:'QTSM',width:100,sortable: true},
            	{header:'检验费用',dataIndex:'JYFY',width:100,sortable: true},
            	{header:'加急费用',dataIndex:'JJFY',width:100,sortable: true},
            	{header:'其他费用',dataIndex:'QTFY',width:100,sortable: true},
            	{header:'费用合计',dataIndex:'FYHJ',width:100,sortable: true},
            	{header:'实物判定',dataIndex:'SWPD',width:100,sortable: true},
            	{header:'标识判定',dataIndex:'BZPD',width:100,sortable: true},
            	{header:'检验结论',dataIndex:'JYJL',width:100,sortable: true},
            	{header:'认证方式',dataIndex:'RZFS',width:100,sortable: true},
            	{header:'退检日期',dataIndex:'TJRQ',width:100,sortable: true},
            	{header:'退检原因',dataIndex:'TJYY',width:100,sortable: true},
            	{header:'退检人',dataIndex:'TJR',width:100,sortable: true},
            	{header:'催办状态',dataIndex:'TBZT',width:100,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>已催办</span>";
	                    }else if(value == '1') {
	                        return "<span>未催办</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onAddClick: function() {           //增加
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	win.show();
    },
    
    onModifyClick: function(){
		var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
//		var url = "rbpyDetailView?id="+id;   	
		var url = "jyDetailView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("样品检验");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},
    
   /* onModifyClick: function() {         //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
   		    	win.constructionForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.constructionForm.ypbh.setValue(vrecord.data.YPBH);
   		    	win.constructionForm.jylb.setValue(vrecord.data.JYLB);
   		    	win.constructionForm.yplb.setValue(vrecord.data.YPLB);
   		    	win.constructionForm.bmbh.setValue(vrecord.data.BMBH);
   		    	win.constructionForm.djrq.setValue(vrecord.data.DJRQ);
   		    	win.constructionForm.jyyj.setValue(vrecord.data.JYYJ);
   		    	win.constructionForm.jyqx.setValue(vrecord.data.JYQX);
   		    	win.constructionForm.bzbh.setValue(vrecord.data.BZBH);
   		    	win.constructionForm.bzmc.setValue(vrecord.data.BZMC);
   		    	win.constructionForm.zjr.setValue(vrecord.data.ZJR);
   		    	win.constructionForm.ksrq.setValue(vrecord.data.KSRQ);
   		    	win.constructionForm.jsrq.setValue(vrecord.data.JSRQ);
   		    	win.constructionForm.hjtj.setValue(vrecord.data.HJTJ);
   		    	win.constructionForm.xmms.setValue(vrecord.data.XMMS);
   		    	win.constructionForm.jyff.setValue(vrecord.data.JYFF);
   		    	win.constructionForm.pdyq.setValue(vrecord.data.PDYQ);
   		    	win.constructionForm.qtsm.setValue(vrecord.data.QTSM);
   		    	win.constructionForm.jyfy.setValue(vrecord.data.JYFY);
   		    	win.constructionForm.jjfy.setValue(vrecord.data.JJFY);
   		    	win.constructionForm.qtfy.setValue(vrecord.data.QTFY);
   		    	win.constructionForm.fyhj.setValue(vrecord.data.FYHJ);
   		    	win.constructionForm.swpd.setValue(vrecord.data.SWPD);
   		    	win.constructionForm.bzpd.setValue(vrecord.data.BZPD);
   		    	win.constructionForm.jyjl.setValue(vrecord.data.JYJL);
   		    	win.constructionForm.rzfs.setValue(vrecord.data.RZFS);
   		    	win.constructionForm.jyzt.setValue(vrecord.data.JYZT);
   		    	win.constructionForm.tjrq.setValue(vrecord.data.TJRQ);
   		    	win.constructionForm.tjyy.setValue(vrecord.data.TJYY);
   		    	win.constructionForm.tjr.setValue(vrecord.data.TJR);
   		    	win.constructionForm.tbzt.setValue(vrecord.data.TBZT);
   		    	win.constructionForm.bz.setValue(vrecord.data.BZ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },*/
    
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