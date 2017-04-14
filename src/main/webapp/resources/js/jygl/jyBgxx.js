var USER_GRID_STORE_URL = 'getBgxxList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

var ewmWindow;

/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	 this.bgbh = this.createTextField('报告编号','bgbh','95%','',null,100);
         this.bgbh.readOnly = true;
         
         this.ypmc = this.createTextField('样品名称','ypmc','95%','',null,100);
         this.ypmc.allowBlank = true;
         this.ypmc.readOnly = true;
         
         this.jyrq = this.createDateField('检验日期','jyrq','Y-m-d','95%');
 		this.jyrq.value = new Date().format('Y-m-d');
 		this.jyrq.allowBlank = true;
 		this.jyrq.readOnly = true;
         
         this.bzrxm = this.createTextField('编制人','bzr','95%','',null,100);
         this.bzrxm.allowBlank = true;
         this.bzrxm.readOnly = true;
         
         this.jsdw = this.createTextField('接收单位','jsdw','95%','',null,100);
         this.jsdw.allowBlank = true;
         this.jsdw.readOnly = true;
         
         this.jsr = this.createTextField('接收人','jsr','95%','',null,100);
         this.jsr.allowBlank = true;
         this.jsr.readOnly = true;
         
         this.ffrq = this.createDateField('发放日期','ffrq','Y-m-d','95%');
 		this.ffrq.value = new Date().format('Y-m-d');
 		this.ffrq.allowBlank = true;
 		this.ffrq.readOnly = true;
 		
 		this.ffzt = this.createTextField('发放状态','ffzt','95%','',null,100);
         this.ffzt.allowBlank = true;
         this.ffzt.readOnly = true;
 		
 		this.tjrq = this.createDateField('退检日期','tjrq','Y-m-d','95%');
 		this.tjrq.value = new Date().format('Y-m-d');
 		this.tjrq.allowBlank = true;
 		
 		this.tjyy = this.createTextField('退检原因','tjyy','95%','',null,100);
         this.tjyy.allowBlank = true;
         this.tjyy.readOnly = true;
         
         this.tjr = this.createTextField('退检原因','tjr','95%','',null,100);
         this.tjr.allowBlank = true;
         this.tjr.readOnly = true;
         
         this.bz = this.createTextField('备注','bz','95%','',null,100);
         this.bz.allowBlank = true;
         this.bz.readOnly = true;
         
         this.bzfs = this.createTextField('编制方式','bzfs','95%','',null,100);
         this.bzfs.allowBlank = true;
         this.bzfs.readOnly = true;
         
         this.jyjl = this.createTextField('检验结论','jyjl','95%','',null,100);
         this.jyjl.allowBlank = true;
         this.jyjl.readOnly = true;
         
         this.rzfs = this.createTextField('认证方式','rzfs','95%','',null,100);
         this.rzfs.allowBlank = true;
         this.rzfs.readOnly = true;
         
         this.bsdx = this.createTextField('报审对象','bsdx','95%','',null,100);
         this.bsdx.allowBlank = true;
         this.bsdx.readOnly = true;
         
         this.jyfy = this.createTextField('检验费用（元）','jyfy','95%','',null,100);
         this.jyfy.allowBlank = true;
         this.jyfy.readOnly = true;
         
         this.ysfje = this.createTextField('已收费用（元）','ysfje','95%','',null,100);
         this.ysfje.allowBlank = true;
         this.ysfje.readOnly = true;
         
         this.cydw = this.createTextField('抽样单位','cydw','95%','',null,100);
         this.cydw.allowBlank = true;
         this.cydw.readOnly = true;
         
         this.dyzt = this.createTextField('打印状态','dyzt','95%','',null,100);
         this.dyzt.allowBlank = true;
         this.dyzt.readOnly = true;
         
         this.dycs = this.createTextField('打印次数','dycs','95%','',null,100);
         this.dycs.allowBlank = true;
         this.dycs.readOnly = true;
         
         this.bgbzrq = this.createDateField('报告编制日期','bgbzrq','Y-m-d','95%');
 		this.bgbzrq.value = new Date().format('Y-m-d');
 		this.bgbzrq.allowBlank = true;
 		
 		this.bgdysj = this.createDateField('报告打印时间','bgdysj','Y-m-d','95%');
 		this.bgdysj.value = new Date().format('Y-m-d');
 		this.bgdysj.allowBlank = true;
 		
 		this.sfjs = this.createTextField('是否解锁','sfjs','95%','',null,100);
         this.sfjs.allowBlank = true;
         this.sfjs.readOnly = true;
         
         
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
                               this.jyrq
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'left',  
                        items:[  
                               this.bzrxm
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
                          this.jsdw
                         ]  
                   }), 
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                          this.jsr
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
                               this.ffrq
                        ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'right',  
                        items:[  
                               this.ffzt
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
                          this.tjrq
                         ]  
                   }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                           this.tjyy
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
                          this.jyfy
                         ]  
                   }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                           this.ysfje
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
                               this.tjr
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
                          this.bzfs
                         ]  
                   }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                          this.jyjl
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
                          this.rzfs
                         ]  
                   }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                          this.bsdx
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
                           this.cydw
                          ]  
                     }),
                     new Ext.Panel({  
                     columnWidth:.5,  
                     layout:'form',  
                     border:false,  
                     labelWidth:90,  
                     labelAlign:'right',  
                     items:[  
                            this.dyzt
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
                    labelAlign:'left',  
                    items:[  
                           this.dycs
                          ]  
                    }), 
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'left',  
                        items:[  
                               this.bgbzrq
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
                        labelAlign:'left',  
                        items:[  
                               this.bgdysj
                              ]  
                        }),
                        new Ext.Panel({  
                            columnWidth:.5,  
                            layout:'form',  
                            border:false,  
                            labelWidth:90,  
                            labelAlign:'left',  
                            items:[  
                                   this.sfjs
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
//                         this.idHidden,
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

/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看报告信息",
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
            html:'<iframe scrolling="auto" frameborder="0" width="100%;" height="100%;" src=""></iframe>'
        });
    }
});

/**************************ConstructionGrid*******************************************/
ConstructionGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,             //面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: USER_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                            {name:'ID'},{name:'BGBH'},{name:'BGMC'},{name:'JYRQ'},{name:'BZR'},
                            {name:'JSDW'},{name:'JSR'},{name:'FFRQ'},{name:'FFZT'},{name:'TJRQ'},
                            {name:'TJYY'},{name:'TJR'},{name:'EWMBH'},{name:'EWMTP'},{name:'BZ'},
                            {name:'BZFS'},{name:'JYJL'},{name:'RZFS'},{name:'BSDX'},{name:'CYDW'},
                            {name:'DYZT'},{name:'DYCS'},{name:'BGBZRQ'},{name:'BGDYSJ'},{name:'SFJS'},
                            {name:'WCQX'},{name:'JYFY'},{name:'YSFJE'},{name:'YPMC'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
					{text:'查看二维码',iconCls: 'edit',handler:this.onBqClick,scope:this},
//            	'-',{text:'批量删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
            ]
        });
    	
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
            	{header:'操作',dataIndex:'',width:50, align:"center",sortable: true,
            		renderer:function(value, cellmeta, record){
					   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>";
					}
            	},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
            	{header:'检验日期',dataIndex:'JYRQ',width:100,sortable: true},
            	{header:'到期日期',dataIndex:'WCQX',width:100,sortable: true},
            	{header:'报审对象',dataIndex:'BSDX',width:100,sortable: true},
            	{header:'检验费用（元）',dataIndex:'JYFY',width:100,sortable: true},
            	{header:'已收费用（元）',dataIndex:'YSFJE',width:100,sortable: true},
            	{header:'抽样单位',dataIndex:'CYDW',width:100,sortable: true},
            	{header:'编制方式',dataIndex:'BZFS',width:100,sortable: true,
            		renderer:function(value){
  	                    if(value == '0') {
  	                        return "<span>一般样品登记 </span>";
  	                    }else if(value == '1') {
  	                        return "<span>工程类样品登记</span>";
  	                    }else if(value == '2') {
  	                        return "<span>食药类样品登记</span>";
  	                    }else{
  	                    	return value;
  	                    }
              		}
              	},
            	{header:'检验结论',dataIndex:'JYJL',width:100,sortable: true},
            	{header:'认证方式',dataIndex:'RZFS',width:100,sortable: true},
            	{header:'编制人',dataIndex:'BZR',width:100,sortable: true},
            	{header:'接收单位',dataIndex:'JSDW',width:100,sortable: true},
            	{header:'接收人',dataIndex:'JSR',width:100,sortable: true},
            	{header:'发放日期',dataIndex:'FFRQ',width:100,sortable: true},
            	{header:'发放状态',dataIndex:'FFZT',width:100,sortable: true},
            	{header:'退检日期',dataIndex:'TJRQ',width:100,sortable: true},
            	{header:'退检原因',dataIndex:'TJYY',width:100,sortable: true},
            	{header:'退检人',dataIndex:'TJR',width:100,sortable: true},
            	{header:'二维码编号',dataIndex:'EWMBH',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onBqClick: function() {       
    	var records=this.getSelectionModel().getSelections();
    	if(records.length > 0) {
    		if(records.length == 1){
    			vrecord = records[0];
    			var bgbh=vrecord.get('BGBH');
    			window.open('bgxxewm?bgbh='+bgbh,'报告二维码','height=500px, width=600px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
    		}else{
    			Ext.Msg.alert('系统提示', '不能选择多条报告..');
    		}
    	}else{
    		Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条报告' + BLANKSTR);
    	}
    },
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				this.constructionLookWindow = new ConstructionLookWindow();
   		    	var win = this.constructionLookWindow;
   		    	win.lookForm.getForm().reset();
   		    	win.show();
   		    	win.lookForm.ypmc.setValue(vrecord.get('YPMC'));
    			win.lookForm.bgbh.setValue(vrecord.get('BGBH'));
    			win.lookForm.bzrxm.setValue(vrecord.get('BZR'));
    			win.lookForm.jyrq.setValue(vrecord.get('JYRQ'));
    			win.lookForm.jsdw.setValue(vrecord.get('JSDW'));
    			win.lookForm.jsr.setValue(vrecord.get('JSR'));
    			win.lookForm.ffrq.setValue(vrecord.get('FFRQ'));
    			win.lookForm.ffzt.setValue(vrecord.get('FFZT'));
    			win.lookForm.tjrq.setValue(vrecord.get('TJRQ'));
    			win.lookForm.tjyy.setValue(vrecord.get('TJYY'));
    			win.lookForm.tjr.setValue(vrecord.get('TJR'));
    			win.lookForm.bz.setValue(vrecord.get('BZ'));
    			win.lookForm.bzfs.setValue(vrecord.get('BZFS'));
    			win.lookForm.jyjl.setValue(vrecord.get('JYJL'));
    			win.lookForm.rzfs.setValue(vrecord.get('RZFS'));
    			win.lookForm.bsdx.setValue(vrecord.get('BSDX'));
    			win.lookForm.cydw.setValue(vrecord.get('CYDW'));
    			win.lookForm.dyzt.setValue(vrecord.get('DYZT'));
    			win.lookForm.dycs.setValue(vrecord.get('DYCS'));
    			win.lookForm.bgbzrq.setValue(vrecord.get('BGBZRQ'));
    			win.lookForm.bgdysj.setValue(vrecord.get('BGDYSJ'));
    			win.lookForm.sfjs.setValue(vrecord.get('SFJS'));
    			win.lookForm.jyfy.setValue(vrecord.get('JYFY'));
    			win.lookForm.ysfje.setValue(vrecord.get('YSFJE'));
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
});

/**************************QueryForm查询条件*******************************************/
QueryForm = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		
		this.ypbh = new Ext.form.TextField({
            fieldLabel: '报告编号',
            xtype: 'textfield',
            id: 'ypbh',
            readOnly: false,
            anchor: '100%',
        });
		this.ypmc = new Ext.form.TextField({
            fieldLabel: '样品名称',
            xtype: 'textfield',
            id: 'ypmc',
            readOnly: false,
            anchor: '100%',
        });
		this.yplx = new Ext.form.ComboBox({
			id:'yplx',
        	autoLoad: true,
            fieldLabel: '样品类型',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDMC',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getYplx', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDMC'}])),
                autoLoad:true
            }),
            editable : false
        });
		
		this.ypdj = new Ext.form.TextField({
            fieldLabel: '样品等级',
            xtype: 'textfield',
            id: 'ypdj',
            readOnly: false,
            anchor: '100%',
        });
		this.jylx = new Ext.form.ComboBox({
			id:'jylx',
        	autoLoad: true,
            fieldLabel: '检验类型',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDZ',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getJylx', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDZ'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.szcs = new Ext.form.TextField({
            fieldLabel: '所在城市',
            xtype: 'textfield',
            id: 'szcs',
            readOnly: false,
            anchor: '100%',
        });
		this.wtdw = new Ext.form.TextField({
            fieldLabel: '委托单位',
            xtype: 'textfield',
            id: 'wtdw',
            readOnly: false,
            anchor: '100%',
        });
		this.sjdw = new Ext.form.TextField({
            fieldLabel: '受检单位',
            xtype: 'textfield',
            id: 'sjdw',
            readOnly: false,
            anchor: '100%',
        });
		this.scdw = new Ext.form.TextField({
            fieldLabel: '生产单位',
            xtype: 'textfield',
            id: 'scdw',
            readOnly: false,
            anchor: '100%',
        });
		this.jyks = new Ext.form.ComboBox({
			id:'jyks',
        	autoLoad: true,
            fieldLabel: '检验科室',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'BMMC',
			valueField:'BMBH',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getJyks', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.ywks = new Ext.form.ComboBox({
			id:'ywks',
        	autoLoad: true,
            fieldLabel: '业务科室',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'BMMC',
			valueField:'BMBH',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getYwks', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.djsj = new Ext.form.DateField({
			fieldLabel: '登记日期',
			id: 'djsj',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		this.djsjStr = new Ext.form.DateField({
			fieldLabel: '登记日期起',
			id: 'djsjStr',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
//		var firstDayOfMonth = new Date();
//		firstDayOfMonth.setDate(1);
//		this.djsjStr.value = firstDayOfMonth.format('Y-m-d');
		
		this.djsjEnd = new Ext.form.DateField({
				fieldLabel: '登记日期止',
				id: 'djsjEnd',
				format: 'Y-m-d',
				anchor: '100%',
				allowBlank: true,
				editable:false,//不能手动输入
				blankText: '请选择时间'
			});
//		this.djsjEnd.value = new Date().format('YYYY-MM-dd');
		
		this.gcmc = new Ext.form.TextField({
            fieldLabel: '工程名称',
            xtype: 'textfield',
            id: 'gcmc',
            readOnly: false,
            anchor: '100%',
        }); 
		this.sgdw = new Ext.form.TextField({
            fieldLabel: '施工单位',
            xtype: 'textfield',
            id: 'sgdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.gcsjdw = new Ext.form.TextField({
            fieldLabel: '设计单位',
            xtype: 'textfield',
            id: 'gcsjdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.jsdw = new Ext.form.TextField({
            fieldLabel: '建设单位',
            xtype: 'textfield',
            id: 'jsdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.jldw = new Ext.form.TextField({
            fieldLabel: '监理单位',
            xtype: 'textfield',
            id: 'jldw',
            readOnly: false,
            anchor: '100%',
        });
		this.jzdw = new Ext.form.TextField({
            fieldLabel: '见证单位',
            xtype: 'textfield',
            id: 'jzdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.wtlxr = new Ext.form.TextField({
            fieldLabel: '委托联系人',
            xtype: 'textfield',
            id: 'wtlxr',
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
	            layoutConfig: {columns: 7},
	            items:[
						this.ypbh,
						this.ypmc,
						this.yplx,
						this.ypdj,
						this.jylx,
						this.szcs,
						this.wtdw,
						this.sjdw,
						this.scdw,
						this.scdw,
						this.jyks,
						this.ywks,
						this.djsj,
						this.gcmc,
						this.sgdw,
						this.gcsjdw,
						this.jsdw,
						this.jldw,
						this.jzdw,
						this.wtlxr,
						this.djsjStr,
						this.djsjEnd
	            ],
	            buttonAlign :'center',
	            buttons: [
	               {text: '查询', width: 20,iconCls: 'query', hidden: false,handler:this.queryFormClick,scope:this},
	               {text: '重置', width: 20, iconCls:'refresh',  handler: this.resetFormClick, scope: this}
	            ]
	        });
	},
	queryFormClick: function(){
 		   var djsjStr =  Ext.getCmp('djsjStr').getValue();
		   var djsjEnd =  Ext.getCmp('djsjEnd').getValue();
		   if(djsjStr > djsjEnd){
			  Ext.Msg.alert('系统提示','截止日期应大于等于开始日期。');
			  return false;
		   }
  	   var params = {};
			if(Ext.getCmp('djsjStr').getValue() != '') {
				params['djsjStr'] = Ext.getCmp('djsjStr').getValue().format('Y-m-d');
			}
			if(Ext.getCmp('djsjEnd').getValue() != '') {
				params['djsjEnd'] = Ext.getCmp('djsjEnd').getValue().format('Y-m-d');
			}
			if(Ext.getCmp('djsj').getValue() != '') {
				params['djsj'] = Ext.getCmp('djsj').getValue().format('Y-m-d');
			}
 			if(Ext.getCmp('ypbh').getValue() != ''){
 				params['ypbh'] = Ext.getCmp('ypbh').getValue();
 			}
 			if(Ext.getCmp('ypmc').getValue() != ''){
 				params['ypmc'] = Ext.getCmp('ypmc').getValue();
 			}
 			if(Ext.getCmp('yplx').getValue() != ''){
 				params['yplx'] = Ext.getCmp('yplx').getValue();
 			}
 			if(Ext.getCmp('ypdj').getValue() != ''){
 				params['ypdj'] = Ext.getCmp('ypdj').getValue();
 			}
 			if(Ext.getCmp('jylx').getValue() != ''){
 				params['jylx'] = Ext.getCmp('jylx').getValue();
 			}
 			if(Ext.getCmp('szcs').getValue() != ''){
 				params['szcs'] = Ext.getCmp('szcs').getValue();
 			}
 			if(Ext.getCmp('wtdw').getValue() != ''){
 				params['wtdw'] = Ext.getCmp('wtdw').getValue();
 			}
 			if(Ext.getCmp('sjdw').getValue() != ''){
 				params['sjdw'] = Ext.getCmp('sjdw').getValue();
 			}
 			if(Ext.getCmp('scdw').getValue() != ''){
 				params['scdw'] = Ext.getCmp('scdw').getValue();
 			}
 			if(Ext.getCmp('jyks').getValue() != ''){
 				params['jyks'] = Ext.getCmp('jyks').getValue();
 			}
 			if(Ext.getCmp('ywks').getValue() != ''){
 				params['ywks'] = Ext.getCmp('ywks').getValue();
 			}
 			if(Ext.getCmp('gcmc').getValue() != ''){
 				params['gcmc'] = Ext.getCmp('gcmc').getValue();
 			}
 			if(Ext.getCmp('sgdw').getValue() != ''){
 				params['sgdw'] = Ext.getCmp('sgdw').getValue();
 			}
 			if(Ext.getCmp('gcsjdw').getValue() != ''){
 				params['gcsjdw'] = Ext.getCmp('gcsjdw').getValue();
 			}
 			if(Ext.getCmp('jsdw').getValue() != ''){
 				params['jsdw'] = Ext.getCmp('jsdw').getValue();
 			}
 			if(Ext.getCmp('jldw').getValue() != ''){
 				params['jldw'] = Ext.getCmp('jldw').getValue();
 			}
 			if(Ext.getCmp('jzdw').getValue() != ''){
 				params['jzdw'] = Ext.getCmp('jzdw').getValue();
 			}
 			if(Ext.getCmp('wtlxr').getValue() != ''){
 				params['wtlxr'] = Ext.getCmp('wtlxr').getValue();
 			}
 			constructionGrid.store.baseParams= params;
 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	},
	resetFormClick: function(){
		Ext.getCmp('ypbh').setValue('');
		Ext.getCmp('ypmc').setValue('');
		Ext.getCmp('yplx').setValue('');
		Ext.getCmp('ypdj').setValue('');
		Ext.getCmp('jylx').setValue('');
		Ext.getCmp('szcs').setValue('');
		Ext.getCmp('wtdw').setValue('');
		Ext.getCmp('sjdw').setValue('');
		Ext.getCmp('scdw').setValue('');
		Ext.getCmp('jyks').setValue('');
		Ext.getCmp('ywks').setValue('');
		Ext.getCmp('djsj').setValue('');
		Ext.getCmp('djsjStr').setValue('');
		Ext.getCmp('djsjEnd').setValue('');
		Ext.getCmp('gcmc').setValue('');
		Ext.getCmp('sgdw').setValue('');
		Ext.getCmp('gcsjdw').setValue('');
		Ext.getCmp('jsdw').setValue('');
		Ext.getCmp('jldw').setValue('');
		Ext.getCmp('jzdw').setValue('');
		Ext.getCmp('wtlxr').setValue('');
	}
});

/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';

    constructionGrid = new ConstructionGrid(Ext.getBody().getViewSize().height);
    constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
    
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