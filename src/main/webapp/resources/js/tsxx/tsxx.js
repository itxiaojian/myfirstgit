var USER_GRID_STORE_URL = 'getTsxxList';
var PAGESIZE=20;
var KHXX_URL = '/khgl/YKhKhxx//getKhKhxxList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();
/**************************ScdwGrid*******************************************/
ScdwGrid = Ext.extend(UxGrid, {
	scdwOpenWindow:null,
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+KHXX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
             {name:'ID'},{name:'KHBH'},{name:'KHMC'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
					{xtype:'textfield',id:'code',
						emptyText:'请输入查询关键字....', 
               	    },'-',
					{xtype:'button',text:'查找',iconCls:'query',handler:function(){
						var code = document.getElementById('code').value;
						constructionGrid.constructionInsertWindow.constructionForm.scdwOpenWindow.scdwGrid.store.baseParams= {code:code};
						constructionGrid.constructionInsertWindow.constructionForm.scdwOpenWindow.scdwGrid.store.load({params:{start:0,limit:PAGESIZE}});
   				    }},'-',
   				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
   				    	document.getElementById('code').value='';
      			  }
               },
            ]
        });	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        ScdwGrid.superclass.constructor.call(this, {
        	region:'center',
        	title: '客户信息列表',
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
                {header:'id', width: 150, dataIndex: 'ID', hidden: true},
	            {header:'客户名称', width: 100, dataIndex: 'KHMC', sortable: true},
	            {header:'客户编号', width: 100, dataIndex: 'KHBH', sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
            	'rowdblclick':function(){
            		var records=this.getSelectionModel().getSelections();
//            		var sjid = records[0].get('ID');
            		this.scdwOpenWindow.constructionForm.tsr.setValue(records[0].get('KHMC'));
            		this.scdwOpenWindow.hide();
            	}
            }
        });
    }
});

/***************************************ScdwOpenWindow组件**************************************************/
ScdwOpenWindow = Ext.extend(Ext.Window,{
	scdwGrid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.scdwGrid = new ScdwGrid();
        ScdwOpenWindow.superclass.constructor.call(this, {
            title: "选择生产单位",
            width: 600,
            anchor: '100%',
            autoHeight:false,
            constrainHeader:false,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.scdwGrid]
        });
    }
});



//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
//    	this.tsr = this.createTextField(' 投诉人', 'tsr', '90%','',null,100,'长度超过不能50');
    	this.tsr = new Ext.form.TextField({
//    		id:'tsr',
            fieldLabel: '投诉人',
            name: 'tsr',
            anchor: '99.5%'
//            editable:false,
        });
    	
    	
//    	 从数据字典中获取下拉框
    	this.tslx = this.createCombo('<span style="color:red">*</span>投诉类型', 'ZDMC', 'ZDMC', 'tslx', '90%', PROJECT_NAME+'/tsxx/YtsXx/getDicByLx');
		this.tslx.store.load();
		this.tslx.allowBlank = false;
		
		
		
    	this.tsnr = new Ext.form.TextArea({
            fieldLabel: '投诉内容',
            name: 'tsnr',
            readOnly: false,
            anchor: '90%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });    	
    	
    	
    	this.btsr = this.createTextField('被投诉人', 'btsr', '90%','',null,100,'长度超过不能50');
    	
    	
    	this.tsrq =  new Ext.form.DateField({
    		
            fieldLabel: '投诉日期',
			name: "tsrq",
			format: "Y-m-d",
			anchor: '90%',
//			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.clzt = this.createTextField('状态', 'clzt', '90%','',null,100,'长度超过不能50');
        this.cljg = this.createTextField('处理结果', 'cljg', '90%','',null,100,'长度超过不能50');
    	this.clr = this.createTextField('处理人', 'clr', '90%','',null,100,'长度超过不能50');
    	this.clrq = this.createTextField('处理日期', 'clrq', '90%','',null,100,'长度超过不能50');
    	 this.bz = new Ext.form.TextArea({
             fieldLabel: '备注',
             name: 'bz',
             readOnly: false,
             anchor: '90%',
             height:50,
             maxLength: 256,
             maxLengthText: '256！'
         });    	

    	
        this.tsr.allowBlank = false;
        this.tslx.allowBlank = false;
        this.tsnr.allowBlank = false;
        this.btsr.allowBlank = false;
        this.tsrq.allowBlank = false;
        this.clzt.allowBlank = false;
        this.cljg.allowBlank = false;
        this.clr.allowBlank = false;
        this.clrq.allowBlank = false;
        this.bz.allowBlank = true;
        
        this.scdwOpenWindow = new ScdwOpenWindow();
       

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth: .844,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.tsr
                    ]  
                
                }), 
                new Ext.Panel({  
                    columnWidth: .056,  
                    layout:'form',  
                    border:false,  
                    labelWidth:20,  
                    labelAlign:'right',  
                    items:[  
                            new Ext.Button({
                               text:'查找',
                               constructionForm: this,
                               handler:function(){
                          var win = new ScdwOpenWindow();
                            	win.constructionForm = this.constructionForm;
                          		win.show();
                          		win.scdwGrid.scdwOpenWindow = win;
                          		win.scdwGrid.store.load({params:{start:0,limit:PAGESIZE}});
                               }
                              })
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
                           this.tslx
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
                           this.tsnr
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
                           this.btsr
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
                           this.tsrq
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
     
     addKhxxClick: function() {       //添加投诉人或单位
//    	 	var constructionForm = new ConstructionForm();
    			var win = this.scdwOpenWindow;
    			win.constructionForm = this;
    			win.show();
    			win.scdwGrid.scdwOpenWindow = win;
    			win.scdwGrid.store.load({params:{start:0,limit:PAGESIZE}});
    			
    	  },
    	
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** LookForm组件**************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.tsr = this.createTextField('投诉人', 'tsr', '90%','',null,100,'长度超过不能50');
    	this.tslx = this.createTextField('投诉类型', 'tslx', '90%','',null,100,'长度超过不能50');
    	this.btsr = this.createTextField('被投诉人', 'btsr', '90%','',null,100,'长度超过不能50');
    	this.clzt = this.createTextField('处理状态', 'clzt', '90%','',null,100,'长度超过不能50');
    	this.cljg = this.createTextField('处理结果', 'cljg', '90%','',null,100,'长度超过不能50');
    	this.clr = this.createTextField('处理人', 'clr', '90%','',null,100,'长度超过不能50');
    	
    	
    	this.tsrq =	new Ext.form.DateField({      
			fieldLabel: ' 投诉日期',
	         format:'Y-m-d',
//	         id : 'end_dt',
	         name : 'tsrq',
	         width:200,
	         anchor: '90%',
//	         minValue : new Date(),
//	                 maxValue : new Date(),  
	         
	         allowBlank : true
	 })

    	this.clrq =  new Ext.form.DateField({
			fieldLabel: ' 处理日期',
			name: "clrq",
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
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
    	 this.tsnr = new Ext.form.TextArea({
             fieldLabel: '投诉内容',
             name: 'tsnr',
             readOnly: false,
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
        this.tsr.allowBlank = false;
        this.tslx.allowBlank = false;
        this.btsr.allowBlank = false;
        this.clr.allowBlank = false;
        this.clzt.allowBlank = false;
        this.cljg.allowBlank = false;
        this.tsnr.allowBlank = false;
        this.clrq.allowBlank = false;
        this.tsrq.allowBlank = false;
        this.bz.allowBlank = true;
        
        
        this.tsr.readOnly = true;
        this.tslx.readOnly = true;
        this.btsr.readOnly = true;
        this.clr.readOnly = true;
        this.clzt.readOnly = true;
        this.cljg.readOnly = false;
        this.tsnr.readOnly = true;
        this.clrq.readOnly = true;
        this.tsrq.readOnly = true;
        this.bz.readOnly = true;
        
        
       

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
                        this.tsr
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
                           this.tslx
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
                           this.tsnr
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
                           this.btsr
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
                           this.tsrq
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
//                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
//                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
    
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/************************************************************************** ChuliLookForm组件*************************************************************************************/
ChuliLookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.tsr = this.createTextField('投诉人', 'tsr', '90%','',null,100,'长度超过不能50');
    	this.tslx = this.createTextField('投诉类型', 'tslx', '90%','',null,100,'长度超过不能50');
    	this.btsr = this.createTextField('被投诉人', 'btsr', '90%','',null,100,'长度超过不能50');
    	this.clzt = this.createTextField('处理状态', 'clzt', '90%','',null,100,'长度超过不能50');
    	this.cljg = this.createTextField('处理结果', 'cljg', '90%','',null,100,'长度超过不能50');
    	this.clr = this.createTextField('处理人', 'clr', '90%','',null,100,'长度超过不能50');
    	
    	
    	this.tsrq =	new Ext.form.DateField({      
			fieldLabel: ' 投诉日期',
	         format:'Y-m-d',
//	         id : 'end_dt',
	         name : 'tsrq',
	         width:200,
	         anchor: '90%',
//	         minValue : new Date(),
//	                 maxValue : new Date(),  
	         
	         allowBlank : true
	 })

    	this.clrq =  new Ext.form.DateField({
			fieldLabel: ' 处理日期',
			name: "clrq",
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
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
    	 this.tsnr = new Ext.form.TextArea({
             fieldLabel: '投诉内容',
             name: 'tsnr',
             readOnly: false,
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
        this.tsr.allowBlank = false;
        this.tslx.allowBlank = false;
        this.btsr.allowBlank = false;
        this.clr.allowBlank = false;
        this.clzt.allowBlank = false;
        this.cljg.allowBlank = false;
        this.tsnr.allowBlank = false;
        this.clrq.allowBlank = false;
        this.tsrq.allowBlank = false;
        this.bz.allowBlank = true;
        
        
        this.tsr.readOnly = true;
        this.tslx.readOnly = true;
        this.btsr.readOnly = true;
        this.clr.readOnly = true;
        this.clzt.readOnly = true;
        this.cljg.readOnly = false;
        this.tsnr.readOnly = true;
        this.clrq.readOnly = true;
        this.tsrq.readOnly = true;
        this.bz.readOnly = true;
        
        
       

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
                        this.tsr
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
                           this.tslx
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
                           this.tsnr
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
                           this.btsr
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
                           this.tsrq
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
                           this.cljg
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
//                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
//                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
    
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});
/*************************************** **************************************ChuLiForm组件************************************************************************************************/
ChuLiForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.tsr = this.createTextField('投诉人', 'tsr', '90%','',null,100,'长度超过不能50');
    	this.tslx = this.createTextField('投诉类型', 'tslx', '90%','',null,100,'长度超过不能50');
    	this.btsr = this.createTextField('被投诉人', 'btsr', '90%','',null,100,'长度超过不能50');
    	this.clzt = this.createTextField('处理状态', 'clzt', '90%','',null,100,'长度超过不能50');
//    	this.cljg = this.createTextField('处理结果', 'cljg', '90%','',null,100,'长度超过不能50');
    	 this.cljg = new Ext.form.TextArea({
             fieldLabel: '处理结果',
             name: 'cljg',
             readOnly: false,
             anchor: '90%',
             height:90,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
    	this.clr = this.createTextField('处理人', 'clr', '90%','',null,100,'长度超过不能50');
    	
    	
    	this.tsrq =	new Ext.form.DateField({      
			fieldLabel: ' 投诉日期',
	         format:'Y-m-d',
//	         id : 'end_dt',
	         name : 'tsrq',
	         width:200,
	         anchor: '90%',
	         minValue : new Date(),
//	                 maxValue : new Date(),  
	         
	         allowBlank : true
	 })

    	this.clrq =  new Ext.form.DateField({
			fieldLabel: ' 处理日期',
			name: "clrq",
			format: "Y-m-d",
			anchor: '90%',
			  readOnly: false,
			allowBlank: false,
			blankText: '请选择时间'
		});
    	
//    	this.clrq = this.createDateField('<font color="red">*</font>处理日期','qsrq','Ymd','95%');
//    	this.clrq.value = new Date().format('Ymd');

    	 this.bz = new Ext.form.TextArea({
             fieldLabel: '备注',
             name: 'bz',
             readOnly: false,
             anchor: '90%',
             height:50,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
    	 this.tsnr = new Ext.form.TextArea({
             fieldLabel: '投诉内容',
             name: 'tsnr',
             readOnly: false,
             allowBlank: false,
             anchor: '90%',
             height:50,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
        this.tsr.allowBlank = true;
        this.tslx.allowBlank = true;
        this.btsr.allowBlank = true;
        this.clr.allowBlank = true;
        this.clzt.allowBlank = true;
        
        this.cljg.allowBlank = true;
        this.tsnr.allowBlank = true;
        this.clrq.allowBlank = false;
        this.tsrq.allowBlank = true;
        this.bz.allowBlank = true;
        
        
        this.tsr.readOnly = true;
        this.tslx.readOnly = true;
        this.btsr.readOnly = true;
        this.clr.readOnly = true;
        this.clzt.readOnly = true;
        
        this.cljg.readOnly = false;
        
        this.tsnr.readOnly = true;
        this.clrq.readOnly = false;
        this.tsrq.readOnly = true;
        this.bz.readOnly = true;
        
        
       

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
                        this.tsr
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
                           this.tslx
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
                           this.tsnr
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
                           this.btsr
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
                           this.tsrq
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
                           this.bz
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
                           this.cljg
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
                           this.clrq
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
//                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text: '处理', width: 20,iconCls: 'edit',handler: this.onChuLiClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     
    
     
     onChuLiClick: function() {       //处理
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
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理成功!" + BLANKSTR);
                 	constructionGrid.constructionChuliWindow.hide();
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

/***************************************ConstructionInsertWindow组件**************************************************************************************************************************/
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

/***************************************ConstructionUpdateWindow组件**************************************************************************************************************************/
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
/***************************************ConstructionLookWindow组件**************************************************************************************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看投诉信息",
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

/***************************************ConstructionChuliLookWindow组件**************************************************************************************************************************/
ConstructionChuliLookWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.chuliLookForm = new ChuliLookForm();
    	ConstructionChuliLookWindow.superclass.constructor.call(this, {
        	title: "查看投诉信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.chuliLookForm]
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

/***************************************ConstructionChuliWindow组件**************************************************************************************************************************/
ConstructionChuliWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.chuliForm = new ChuLiForm();
    	ConstructionChuliWindow.superclass.constructor.call(this, {
        	title: "处理投诉信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.chuliForm]
        });
    }
});
/**************************ConstructionGrid*******************************************************************************************************************************************/
ConstructionGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: USER_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                                                                                   
                            {name:'ID'},{name:'TSR'},{name:'TSLX'},{name:'TSNR'},
                            {name:'BTSR'},{name:'TSRQ'},{name:'CLZT'},{name:'CLJG'},
                            {name:'CLR'},{name:'CLRQ'},{name:'BZ'}
                           
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'cs',width: 150,
                	   emptyText:'投诉人&投诉类型...',  
               	    },
    	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var cs = Ext.getCmp('cs').getValue();
      						constructionGrid.store.baseParams= {cs:cs};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('cs').setValue("");
         			  }
                  },
            ]
        });
   	
        this.constructionInsertWindow = new ConstructionInsertWindow();       
        this.constructionUpdateWindow = new ConstructionUpdateWindow();
        this.constructionLookWindow = new ConstructionLookWindow();
        this.constructionChuliWindow = new ConstructionChuliWindow();
       this.constructionChuliLookWindow=new ConstructionChuliLookWindow();
       
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
                {header:'投诉id',dataIndex:'ID',width:150,sortable: true, hidden:true},
               
				
				 {header: '状态', width: 70, dataIndex: 'zt', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("CLJG") == null){
		                       return "<span style='width: 25px;color:red;'>未处理</span>&nbsp;&nbsp;&nbsp";
						   }else{
		                       return "<span style='width: 25px;color:blue;'>已处理</span>&nbsp;&nbsp;&nbsp";
						}
					}
				},
				  {header:'被投诉人/部门',dataIndex:'BTSR',width:90,sortable: true},
                {header:'投诉人/单位',dataIndex:'TSR',width:90,sortable: true},
                {header:'投诉类型',dataIndex:'TSLX',width:90,sortable: true},
                {header:'处理状态',dataIndex:'CLZT',width:90,sortable: true,hidden:true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>已处理</span>";
	                    }else if(value == '1') {
	                        return "<span>未处理</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	{header:'投诉内容',dataIndex:'TSNR',width:90,sortable: true,hidden:true},
                {header:'投诉日期',dataIndex:'TSRQ',width:90,sortable: true},
//               	{header:'处理状态',dataIndex:'CLZT',width:150,sortable: true},
                {header:'处理结果',dataIndex:'CLJG',width:90,sortable: true,hidden:true},
                {header:'处理人',dataIndex:'CLR',width:90,sortable: true, hidden:true},
                {header:'处理日期',dataIndex:'CLRQ',width:90,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:90,sortable: true,hidden:true},
            	 {header: '操作', width: 150, dataIndex: 'asd', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("CLJG") != null){
		return "<a href='javascript:;' onclick='constructionGrid.onChuliLook()' style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp" +
			   "<a href='javascript:;' onclick=''  style='text-decoration:none;'>" +
			   "<span style='width: 25px;color:grey;cursor: pointer;'>处理</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
			   "<span style='width: 25px;color:grey;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
			   "<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>&nbsp;&nbsp;&nbsp";
		}else{
		return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
			   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='constructionGrid.onChuli()' style='text-decoration:none;'><span style='width: 25px;color:blue;'>处理</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
			   "<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
			   "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
			   "<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>&nbsp;&nbsp;&nbsp";
						}
					}
				}
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
		var url = "tsCkView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("投诉信息查看");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},
	
    
    onChuliLook: function() {                  //查看  2
    	var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
		var url = "tsClCkView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("投诉信息查看");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onChuli: function(){
		var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
		var url = "tsClView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("投诉信息处理");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},
	
//    增加
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	var url = "tsAddView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("投诉信息增加");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
	 onModifyClick: function() {
	    	var records=this.getSelectionModel().getSelections();
	   		if(records.length > 0) {
	   			if(records.length == 1){
	   				vrecord = records[0];
	                if(vrecord.get("CLJG") != null){
	                	Ext.Msg.alert('系统提示', '已处理状态不可修改');
	                } else{
	                	var id=records[0].get('ID');
	        			var url = "tsXgView?id="+id;  	
	        			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
	        			ACT_DEAL_WINDOW = new ActDealWindow();
	        			ACT_DEAL_WINDOW.setTitle("投诉信息修改");
	        			ACT_DEAL_WINDOW.html = html;
	        			ACT_DEAL_WINDOW.show();
	                }
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
