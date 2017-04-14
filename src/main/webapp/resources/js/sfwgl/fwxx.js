var USER_GRID_STORE_URL = 'getFwxxList';
var PAGESIZE=20;
var RWZP_URL1 = '/yrwgl/yrwzp/getRwZprList';
var RWZP_URL2 = '/yrwgl/yrwzp/getRwZprList';

var ENTITY_URL_UPLOAD = "/sfwgl/YsfwFwxx/save";
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/**************************RwglZprGrid*******************************************/
RwglZprGrid = Ext.extend(UxGrid, {
	RwglZprWindow:null,
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
             {name:'yhbh'},{name:'dlm'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
               	 '-',{xtype:'label',text:'人员编号：'},
                 '-',{xtype:'textfield',id:'code1',width: 100,emptyText:'请输入查询关键字....',},
                 '-',{xtype:'label',text:'人员名称：'},
                 '-',{xtype:'textfield',id:'code2',width: 100,emptyText:'请输入查询关键字....',},
     	  		 '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
     	  			 var code = document.getElementById('code').value;
					 constructionGrid.constructionInsertWindow.constructionForm.rwglZprWindow.rwglZprGrid.store.baseParams= {code1:code1,code2:code2};
					 constructionGrid.constructionInsertWindow.constructionForm.rwglZprWindow.rwglZprGrid.store.load({params:{start:0,limit:PAGESIZE}});
				     }},
       		     '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
       	   				Ext.getCmp('code1').setValue("");
       	   				Ext.getCmp('code2').setValue("");
          			 }},
          		 '-',{xtype:'button',text:'确定',iconCls:'save',handler:this.addClick,scope:this}
            ]
        });	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        RwglZprGrid.superclass.constructor.call(this, {
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
                {header:'人员编号', width: 150, dataIndex: 'yhbh', hidden: true},
	            {header:'人员账号', width: 100, dataIndex: 'dlm', sortable: true},
	            {header:'人员名称', width: 100, dataIndex: 'xm', sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store//,
        });
    },
//        addClick: function() {
//	        	var records=this.getSelectionModel().getSelections();
//	    		var sjid = records[0].get('yhbh');
//	    		var str='';
//	    		for(var i=0;i<records.length;i++){
//	    			str=str+records[i].get('dlm')+',';
//	    		}
//	    		var str = Ext.util.Format.substr(str, 0, str.length-1);
//	    		this.rwglZprWindow.constructionForm.sjr.setValue(str);
//	    		this.rwglZprWindow.constructionForm.sjr.setValue(records[0].get('dlm'));
//	    		this.rwglZprWindow.hide();
//            }
//});
    addClick: function() {
    	var records=this.getSelectionModel().getSelections();
		var sjid = records[0].get('yhbh');
		var str='';
		for(var i=0;i<records.length;i++){
			str=str+records[i].get('dlm')+',';
		}
		var str = Ext.util.Format.substr(str, 0, str.length-1);
		this.rwglZprWindow.constructionForm.sjr.setValue(str);
		this.rwglZprWindow.hide();
    }
});
/***************************************RwglZprWindow组件**************************************************/
RwglZprWindow = Ext.extend(Ext.Window,{
	khxx1Grid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.rwglZprGrid = new RwglZprGrid();
        RwglZprWindow.superclass.constructor.call(this, {
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
            items: [this.rwglZprGrid]
        });
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
/**************************CsGrid*******************************************/
CsGrid = Ext.extend(UxGrid, {
	CsWindow:null,
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+RWZP_URL2, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
             {name:'yhbh'},{name:'dlm'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
               	 '-',{xtype:'label',text:'人员编号：'},
                 '-',{xtype:'textfield',id:'code1',width: 100,emptyText:'请输入查询关键字....',},
                 '-',{xtype:'label',text:'人员名称：'},
                 '-',{xtype:'textfield',id:'code2',width: 100,emptyText:'请输入查询关键字....',},
     	  		 '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
     	  			 var code = document.getElementById('code').value;
					 constructionGrid.constructionInsertWindow.constructionForm.csWindow.csGrid.store.baseParams= {code1:code1,code2:code2};
					 constructionGrid.constructionInsertWindow.constructionForm.csWindow.csGrid.store.load({params:{start:0,limit:PAGESIZE}});
				     }},
       		     '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
       	   				Ext.getCmp('code1').setValue("");
       	   				Ext.getCmp('code2').setValue("");
          			 }},
          		 '-',{xtype:'button',text:'确定',iconCls:'save',handler:this.addClick,scope:this}
            ]
        });	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        CsGrid.superclass.constructor.call(this, {
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
                {header:'人员编号', width: 150, dataIndex: 'yhbh', hidden: true},
	            {header:'人员账号', width: 100, dataIndex: 'dlm', sortable: true},
	            {header:'人员名称', width: 100, dataIndex: 'xm', sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store//,
        });
    },
        addClick: function() {
	        	var records=this.getSelectionModel().getSelections();
	    		var sjid = records[0].get('yhbh');
	    		var str='';
	    		for(var i=0;i<records.length;i++){
	    			str=str+records[i].get('dlm')+',';
	    		}
	    		var str = Ext.util.Format.substr(str, 0, str.length-1);
	    		this.csWindow.constructionForm.cs.setValue(str);
//	    		alert(str);
	    		this.csWindow.hide();
            }
});

/***************************************CsWindow组件**************************************************/
CsWindow = Ext.extend(Ext.Window,{
	khxx1Grid : null,
	constructionForm : null,
    constructor: function(grid) {
        this.csGrid = new CsGrid();
        CsWindow.superclass.constructor.call(this, {
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
            items: [this.csGrid]
        });
    }
});
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
    	this.sjr = this.createTextField('收件人', 'sjr', '100%','',null,100,'长度超过不能50');
    	this.cs = this.createTextField('抄送', 'cs', '100%','',null,100,'长度超过不能50');
    	this.zt = this.createTextField('主题', 'zt', '90%','',null,100,'长度超过不能50');
    	 this.zw = new Ext.form.TextArea({
             fieldLabel: '正文',
             name: 'zw',
             readOnly: false,
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
//    	this.fj = this.createTextField('附件', 'fj', '90%','',null,100,'长度超过不能50');
    		this.fj = new Ext.ux.form.FileUploadField({
    			anchor:'90%',
    			name: 'attachMentFile',
                emptyText: '请选择...',
                labelWidth: 67,
                fieldLabel: '附件',
                buttonCfg: {
                    text: '添加附件'
                }
    	    });
//    	this.dsfs = new Ext.form.DateField({
//			fieldLabel : '定时发送时间',
//			name : "dsfs",
//			format : "Y-m-d",
//			anchor : '90%',
//			// allowBlank: false,
//			editable : false,// 不能手动输入
//			blankText : '请选择时间'
//		});
    	this.fssj =  new Ext.form.DateField({
			fieldLabel: ' 发送时间',
			name: "fssj",
			format: "Y-m-d H:i:s",
			anchor: '90%',
			  readOnly: false,
			allowBlank: false,
			editable : false,// 不能手动输入
			blankText: '请选择时间'
		});
    	this.fwr = this.createTextField('发文人', 'fwr', '90%','',null,100,'长度超过不能50');
    	this.bmbh = this.createTextField('发文单位', 'bmbh', '90%','',null,100,'长度超过不能50');
    	
    	
        this.sjr.allowBlank = false;
        this.cs.allowBlank = false;
        this.zt.allowBlank = true;
        this.zw.allowBlank = false;
        this.fj.allowBlank = true;
        this.fssj.allowBlank = true;
        this.fwr.allowBlank = true;
//        this.dsfs.allowBlank = true;
        this.bmbh.allowBlank = true;
       

        var pnRow1=new Ext.Panel({  
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
                        this.sjr
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.1,  
                    layout:'form',  
                    border:false,  
                    labelWidth:10,
                    labelAlign:'right',  
                    items:[  
				              new Ext.Button({
                           text:'查找',
                           constructionForm: this,
                           handler:function(){
                		   var win = new RwglZprWindow();
                		   win.constructionForm = this.constructionForm;
              		       win.show();
              		       win.rwglZprGrid.rwglZprWindow = win;
              		       win.rwglZprGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
                       columnWidth:.9,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.cs
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
                   		   var win = new CsWindow();
                   		   win.constructionForm = this.constructionForm;
                 		       win.show();
                 		       win.csGrid.csWindow = win;
                 		       win.csGrid.store.load({params:{start:0,limit:PAGESIZE}});
                              }
                              }) 
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
                        this.zt
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
                        this.zw
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
                        this.fj
                    ]  
                }), 
            ]  
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
//                new Ext.Panel({  
//                    columnWidth:.475,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:90,  
//                    labelAlign:'right',  
//                    items:[  
//                        this.dsfs
//                    ]  
//                }), 
                new Ext.Panel({  
                    columnWidth:1,  
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
        
        var pnRow7=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
//                new Ext.Panel({  
//                    columnWidth:.475,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:90,  
//                    labelAlign:'right',  
//                    items:[  
//                        this.fwr
//                    ]  
//                }), 
                new Ext.Panel({  
                    columnWidth:1,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bmbh
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
                    hidden:true,
                    items:[  
                        this.fwr
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
                      {text: '发送', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick : function() {
 		if (this.getForm().isValid()) {
 			$("#ext-gen11").attr("enctype","multipart/form-data");
 			this.getForm().submit(
 					{
 						waitMsg : '正在提交数据...',
 						url : 'save',
 						method : 'POST',
 						success : function(form, action) {
 							Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!"
 									+ BLANKSTR);
 							constructionGrid.constructionInsertWindow.hide();
 							constructionGrid.store.reload();
 						},
 						failure : function(form, action) {
 							Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!"
 									+ BLANKSTR);
 						}
 					});
 		}
 	},
     

 	updateFormClick : function() { // 修改
 		if (this.getForm().isValid()) {
 			var record = constructionGrid.getSelectionModel().getSelections();
 			$("#ext-gen13").attr("enctype","multipart/form-data");
 			this.getForm().submit(
 					{
 					
 						waitMsg : '正在提交数据...',
 						url : 'update',
 						method : 'POST',
 						params : {
 							id : record[0].get('ID')
 						},
 						success : function(form, action) {
 							Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!"
 									+ BLANKSTR);
 							constructionGrid.constructionUpdateWindow.hide();
 							constructionGrid.vbbar
 									.doLoad(constructionGrid.vbbar.cursor);
 						},
 						failure : function(form, action) {
 							Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!"
 									+ BLANKSTR);
 						}
 					});
 		}
 	},
 	onCloseClick : function() { // 关闭
 		this.ownerCt.hide();
 	}
 });

/*** * ***************************************************************LookForm组件** *****************************************************************************/
LookForm = Ext.extend(Ext.ux.Form, {

	constructor : function() {
		this.sjr = this.createTextField('收件人', 'sjr', '100%','',null,100,'长度超过不能50');
    	this.cs = this.createTextField('抄送', 'cs', '100%','',null,100,'长度超过不能50');
    	this.zt = this.createTextField('主题', 'zt', '90%','',null,100,'长度超过不能50');
    	 this.zw = new Ext.form.TextArea({
             fieldLabel: '正文',
             name: 'zw',
             readOnly: false,
             anchor: '90%',
             height:100,
             maxLength: 256,
             maxLengthText: '256！'
         });    	
    	this.fj = this.createTextField('附件', 'fj', '90%','',null,100,'长度超过不能50');

    	this.fssj =  new Ext.form.DateField({
			fieldLabel: ' 发送时间',
			name: "fssj",
			format: "Y-m-d H:i:s",
			anchor: '90%',
			  readOnly: false,
			allowBlank: false,
			blankText: '请选择时间'
		});
    	this.fwr = this.createTextField('发文人', 'fwr', '90%','',null,100,'长度超过不能50');
    	this.bmbh = this.createTextField('发文单位', 'bmbh', '90%','',null,100,'长度超过不能50');
    	
    	  this.constructionHfbWindow = new ConstructionHfbWindow();       
    	  
        this.sjr.allowBlank = false;
        this.cs.allowBlank = true;
        this.zt.allowBlank = true;
        this.zw.allowBlank = false;
        this.fj.allowBlank = true;
        this.fssj.allowBlank = false;
        this.fwr.allowBlank = false;
//        this.dsfs.allowBlank = false;
        this.bmbh.allowBlank = false;
        
        this.sjr.readOnly = true;
        this.cs.readOnly = true;
        this.zt.readOnly = true;
        this.zw.readOnly = true;
        this.fj.readOnly = true;
        this.fssj.readOnly = true;
        this.fwr.readOnly = true;
//        this.dsfs.readOnly = true;
        this.bmbh.readOnly = true;
       

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.9,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    hidden:true,
                    items:[  
                        this.sjr
                    ]  
                }), 
//                new Ext.Panel({  
//                    columnWidth:.1,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:10,
//                    labelAlign:'right',  
//                    items:[  
//				              new Ext.Button({
//                           text:'查找',
//                           constructionForm: this,
//                           handler:function(){
//                		   var win = new RwglZprWindow();
//                		   win.constructionForm = this.constructionForm;
//              		       win.show();
//              		       win.rwglZprGrid.rwglZprWindow = win;
//              		       win.rwglZprGrid.store.load({params:{start:0,limit:PAGESIZE}});
//                           }
//                           }) 
//                    ]  
//                 }),
            ]  
        });
        var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                   new Ext.Panel({  
                       columnWidth:.9,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       hidden:true,
                       items:[  
                           this.cs
                       ]  
                   }),      
//                   new Ext.Panel({  
//                       columnWidth:.1,  
//                       layout:'form',  
//                       border:false,  
//                       labelWidth:50,
//                       labelAlign:'right',  
//                       items:[  
//   				              new Ext.Button({
//                              text:'查找',
//                              constructionForm: this,
//                              handler:function(){
//                   		   var win = new RwglZprWindow();
//                   		   win.constructionForm = this.constructionForm;
//                 		       win.show();
//                 		       win.rwglZprGrid.rwglZprWindow = win;
//                 		       win.rwglZprGrid.store.load({params:{start:0,limit:PAGESIZE}});
//                              }
//                              }) 
//                       ]  
//                    }),
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
                        this.zt
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
                        this.zw
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
                        this.fj
                    ]  
                }), 
            ]  
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
//                new Ext.Panel({  
//                    columnWidth:.475,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:90,  
//                    labelAlign:'right',  
//                    items:[  
//                        this.dsfs
//                    ]  
//                }), 
                new Ext.Panel({  
                    columnWidth:1,  
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
        var pnRow7=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.475,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.fwr
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.475,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.bmbh
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
						pnRow7
            ],
            buttonAlign : 'center',
			buttons : [ 
			           {text: '回复', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
			           {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
			            ]
		});
	},
	addFormClick: function() {           //回复
	    	var win = this.constructionHfbWindow;
	    	win.show();
	    	 var curDate=new Date();
	   	    win.hfbForm.hfsj.setValue(curDate);
	
	    },
	    
	    onCloseClick: function(){ 			//关闭
	         this.ownerCt.hide();
	     }
});


/*************************************** HfbForm组件 **************************************************/
HfbForm = Ext.extend(Ext.ux.Form, {
	
	  constructor: function() {
	    	
//	    	this.idHidden = this.createHidden('id','id');
	    	
	    	this.fwid= this.createTextField('发文编号', 'fwid', '90%','',null,100,'长度超过不能50');
//	    	this.hfbr = this.createTextField('回复内容', 'hfbr', '90%','',null,100,'长度超过不能50');
	    	this.hfr = this.createTextField('回复人', 'hfr', '90%','',null,100,'长度超过不能50');
	    	 this.hfbr = new Ext.form.TextArea({
	             fieldLabel: '回复内容',
	             name: 'hfbr',
	             readOnly: false,
	             anchor: '90%',
	             height:100,
	             maxLength: 256,
	             maxLengthText: '256！'
	         });    	
//	    	this.fj = this.createTextField('附件', 'fj', '90%','',null,100,'长度超过不能50');
	    	 this.fj = new Ext.ux.form.FileUploadField({
	 			anchor:'90%',
	 			name: 'attachMentFile',
	             emptyText: '请选择...',
	             labelWidth: 67,
	             fieldLabel: '附件',
	             buttonCfg: {
	                 text: '添加附件'
	             }
	 	    });
	    	this.hfsj = new Ext.form.DateField({
				fieldLabel : '回复时间',
				name : "hfsj",
				format : "Y-m-d H:i:s",
				anchor : '90%',
				// allowBlank: false,
				editable : false,// 不能手动输入
				blankText : '请选择时间'
			});
//	    	this.sjr = this.createTextField('收件人', 'sjr', '90%','',null,100,'长度超过不能50');
	    	
	    	
	        this.fwid.allowBlank = true;
	        this.hfbr.allowBlank = true;
	        this.hfsj.allowBlank = true;
	        this.hfr.allowBlank = true;
	        this.fj.allowBlank = true;
	       
	       

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
	                    hidden:true,
	                    items:[  
	                        this.hfr
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
	                       hidden:true,
	                       items:[  
	                           this.fwid
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
	                        this.hfbr
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
	                    hidden:true,
	                    labelAlign:'right',  
	                    items:[  
	                        this.hfsj
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
	                        this.fj
	                    ]  
	                }), 
	            ]  
	        });
	       
	       
	        HfbForm.superclass.constructor.call(this, {
	        	anchor: '80%',
	        	autoHeight:true,
	        	layoutConfig: {columns: 1},
	        	labelWidth: 90,
	            labelAlign :'right',
	            frame:true,
	            bodyStyle:"padding: 5px 5px 0",
	            width: '100%',
	            items: [
//	                        this.idHidden,
							pnRow1,
							pnRow2,
							pnRow3,
							pnRow4,
							pnRow5
							
	            ],
            buttonAlign :'center',
            buttons: [
                      {text: '提交', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     
     addFormClick : function() {
    	 $("#ext-gen15").attr("enctype","multipart/form-data");
    	 
    	 var hfbr = this.hfbr.getValue();
    	 var hfr = this.hfr.getValue();
    	 
    	 
    	 var attachMentFileValue = this.fj.getValue();
     	if(attachMentFileValue == null || attachMentFileValue == "") {
     		Ext.MessageBox.alert("系统提示:", BLANKSTR + "请选择文件!" + BLANKSTR);
     		return;
     	}
//    	 alert(111);
    	 if(this.getForm().isValid()) {
          	this.getForm().submit({
                  waitMsg: '正在提交数据...',
                  url: 'hfsave',   
                  //method: 'POST',
                  success: function(form, action) {
                  	
                	  Ext.MessageBox.alert("系统提示:", BLANKSTR + "提交成功!" + BLANKSTR);
   	               constructionGrid.constructionLookWindow.lookForm.constructionHfbWindow.hide();
   	               constructionGrid.constructionLookWindow.hide();
   	                window.location.reload(); 
                  },
                  failure: function(form, action) {
                  	
                  	Ext.MessageBox.alert("系统提示:",BLANKSTR + "提交失败!" + BLANKSTR);
                  }
          	});
          }

  	},
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});


/***************************************ConstructionHfbWindow组件**************************************************/
ConstructionHfbWindow = Ext.extend(Ext.Window,{
	hfbForm : null,
    constructor: function(grid) {
        this.hfbForm = new HfbForm();
//        this.constructionForm.buttons[0].show();   //隐藏添加按钮
//    	this.constructionForm.buttons[1].hide();   //显示修改按钮
    	ConstructionHfbWindow.superclass.constructor.call(this, {
            title: "回复信息",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.hfbForm]
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
                                                                                   
                            {name:'ID'},{name:'SJR'},{name:'CS'},{name:'ZT'},
                            {name:'ZW'},{name:'FJ'},{name:'FSSJ'},
                            {name:'FWR'},{name:'BMBH'},
                           
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'新增发文',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'收件人&抄送人...',  
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
            ]
        });
   	
        this.constructionInsertWindow = new ConstructionInsertWindow();       
        this.constructionUpdateWindow = new ConstructionUpdateWindow();
        this.constructionLookWindow = new ConstructionLookWindow();
        
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
                {header:'发文ID',dataIndex:'ID',width:150,sortable: true, hidden:true},
               
                {header:'收件人',dataIndex:'SJR',width:150,sortable: true,hidden:true},
                {header:'抄送',dataIndex:'CS',width:150,sortable: true,hidden:true},
            	{header:'主题',dataIndex:'ZT',width:150,sortable: true},
            	{header:'正文',dataIndex:'ZW',width:150,sortable: true},
                {header:'附件',dataIndex:'FJ',width:150,sortable: true},
//               	{header:'定时发送时间',dataIndex:'DSFS',width:150,sortable: true},
//                {header:'发送时间',dataIndex:'FSSJ',width:150,sortable: true},
             {header:"发送时间",dataIndex:"FSSJ",width:120,sortable:true},
                {header:'发文人',dataIndex:'FWR',width:150,sortable: true},
            	{header:'发文单位',dataIndex:'BMBH',width:150,sortable: true},
            	 {header : '操作',width : 80,dataIndex : 'sbbh',align : "center",sortable : true,hidden : false,renderer : function(value,cellmeta,record)

					{
						return "<a href='javascript:;' onclick='constructionGrid. onLook()' style='text-decoration:none;'>"
								+ "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
								"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
								"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>&nbsp;&nbsp;&nbsp";
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
    	var win = this.constructionInsertWindow;
//    	win.constructionForm.getForm().reset();
    	var url = "fwAddView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("新建发文信息")
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    
    
    onLook: function(){
		var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
		var url = "fwCkView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("查看该发文");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},

//    onModifyClick: function() {
//    	var records=this.getSelectionModel().getSelections();
//   		if(records.length > 0) {
//   			if(records.length == 1){
//   				vrecord = records[0];
//   		    	var win = this.constructionUpdateWindow;
//   		    	win.show();
////   		    	win.constructionForm.getForm().loadRecord(vrecord);
//   		    	win.constructionForm.sjr.setValue(vrecord.data.SJR);
//   		    	win.constructionForm.cs.setValue(vrecord.data.CS);
//   		    	win.constructionForm.zt.setValue(vrecord.data.ZT);
//   		    	win.constructionForm.zw.setValue(vrecord.data.ZW);
//   		    	win.constructionForm.fj.setValue(vrecord.data.FJ);
////   		    	win.constructionForm.dsfs.setValue(vrecord.data.DSFS);
//   		    	win.constructionForm.fssj.setValue(vrecord.data.FSSJ);
//   		    	win.constructionForm.fwr.setValue(vrecord.data.FWR);
//   		    	win.constructionForm.bmbh.setValue(vrecord.data.BMBH);
//   			}else{
//   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
//   			}
//   		}else{
//   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
//   		}    	
//    },
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
