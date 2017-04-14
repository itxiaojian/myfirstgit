var USER_GRID_STORE_URL = 'getHfbList';
var PAGESIZE=20;
var RWZP_URL1 = '/yrwgl/yrwzp/getRwZprList';

var ENTITY_URL_UPLOAD = "/sfwgl/YsfwHfb/save";
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
///**************************RwglZprGrid*******************************************/
//RwglZprGrid = Ext.extend(UxGrid, {
//	RwglZprWindow:null,
//	pageSizeCombo: PAGESIZE,
//	vtbar:null,				//面板顶部的工具条	
//	vbbar:null,				//面板底部的工具条
//    store:null,
//    module_name:null,
//    type_name:null,
//    constructor: function(height, width){
//    	var thiz = this;
//    	this.store = new Ext.data.Store({          //Grid Store
//            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+RWZP_URL1, method: 'POST'}),
//            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
//            [
//             {name:'yhbh'},{name:'dlm'}
//            ])
//        });
//
//    	this.vbbar= this.createPagingToolbar(PAGESIZE);
//    	this.vtbar = new Ext.Toolbar({
//            items:[
//               	 '-',{xtype:'label',text:'人员编号：'},
//                 '-',{xtype:'textfield',id:'code1',width: 100,emptyText:'请输入查询关键字....',},
//                 '-',{xtype:'label',text:'人员名称：'},
//                 '-',{xtype:'textfield',id:'code2',width: 100,emptyText:'请输入查询关键字....',},
//     	  		 '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
//     	  			 var code = document.getElementById('code').value;
//					 constructionGrid.constructionInsertWindow.constructionForm.rwglZprWindow.rwglZprGrid.store.baseParams= {code1:code1,code2:code2};
//					 constructionGrid.constructionInsertWindow.constructionForm.rwglZprWindow.rwglZprGrid.store.load({params:{start:0,limit:PAGESIZE}});
//				     }},
//       		     '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
//       	   				Ext.getCmp('code1').setValue("");
//       	   				Ext.getCmp('code2').setValue("");
//          			 }},
//          		 '-',{xtype:'button',text:'确定',iconCls:'save',handler:this.addClick,scope:this}
//            ]
//        });	
//        var sm = new Ext.grid.CheckboxSelectionModel(); 
//        RwglZprGrid.superclass.constructor.call(this, {
//        	region:'center',
//        	title: '人员列表',
//        	stripeRows: true,
//            frame: true,
//            height: 300,
//            width :width,
//            viewConfig: {
//                forceFit: false
//            },
//            loadMask: {
//                msg : '正在载入数据,请稍候...'
//            },
//            sm: sm,
//            cm: new Ext.grid.ColumnModel([ new Ext.grid.RowNumberer(),
//                                          sm,
//                {header:'人员编号', width: 150, dataIndex: 'yhbh', hidden: true},
//	            {header:'人员账号', width: 100, dataIndex: 'dlm', sortable: true},
//	            {header:'人员名称', width: 100, dataIndex: 'xm', sortable: true},
//            ]),
//            tbar: this.vtbar,
//            bbar: this.vbbar,
//            ds: this.store//,
//        });
//    },
//        addClick: function() {
//	        	var records=this.getSelectionModel().getSelections();
//	    		var sjid = records[0].get('yhbh');
//	    		var str='';
//	    		for(var i=0;i<records.length;i++){
//	    			str=str+records[i].get('dlm')+',';
//	    		}
//	    		var str = Ext.util.Format.substr(str, 0, str.length-1);
//	    		this.rwglZprWindow.constructionForm.fwr.setValue(str);
//	    		this.rwglZprWindow.hide();
//            }
//});
//
///***************************************RwglZprWindow组件**************************************************/
//RwglZprWindow = Ext.extend(Ext.Window,{
//	khxx1Grid : null,
//	constructionForm : null,
//    constructor: function(grid) {
//        this.rwglZprGrid = new RwglZprGrid();
//        RwglZprWindow.superclass.constructor.call(this, {
//            title: "选择人员",
//            width: 600,
//            anchor: '100%',
//            autoHeight:false,
//            constrainHeader:false,
//            resizable : false,
//            plain: true,
//            modal: true,
//            autoScroll: true,
//            closeAction: 'hide',
//            items: [this.rwglZprGrid]
//        });
//    }
//});
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
//    	this.fwid= this.createTextField('发文编号', 'fwid', '90%','',null,100,'长度超过不能50');
//    	this.hfbr = this.createTextField('回复内容', 'hfbr', '90%','',null,100,'长度超过不能50');
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
    	this.hfsj = new Ext.form.DateField({
			fieldLabel : '回复时间',
			name : "hfsj",
			format : "Y-m-d H:i:s",
			anchor : '90%',
			// allowBlank: false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});
//    	this.sjr = this.createTextField('收件人', 'sjr', '90%','',null,100,'长度超过不能50');
    	
    	
//        this.fwid.allowBlank = true;
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
                    items:[  
                        this.hfr
                    ]  
                }), 
//                new Ext.Panel({  
//                    columnWidth:.105,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:50,
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
//        var pnRow2=new Ext.Panel({  
//            layout:'column',  
//            border:false,  
//            items:[  
//                   new Ext.Panel({  
//                       columnWidth:1,  
//                       layout:'form',  
//                       border:false,  
//                       labelWidth:90,  
//                       labelAlign:'right',  
//                       items:[  
//                           this.fwid
//                       ]  
//                   }),      
//            ]  
//        });
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
                        this.hfbr
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
                        this.hfsj
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
                        this.fj
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
//						pnRow2,
						pnRow2,
						pnRow3,
						pnRow4
						
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
//     addFormClick: function() {
//         if(this.getForm().isValid()) {
//         	this.getForm().submit({
//                 waitMsg: '正在提交数据...',
//                 url: 'save', 
//                 method: 'POST',
//                 success: function(form, action) { 
//                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
//                 	constructionGrid.constructionInsertWindow.hide();
//                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
//                 },
//                 failure: function(form, action) {
//                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
//                 }
//         	});
//         }
//     },
     
     addFormClick: function(){
			if(this.getForm().isValid()){

	        	//设置表单enctype属性
	        	$("#ext-gen11").attr("enctype","multipart/form-data");
	        	
				this.getForm().submit({
					waitMsg: '正在提交，请稍后...',
					url: PROJECT_NAME+""+ENTITY_URL_UPLOAD,
					success: function(form, action){
						Ext.MessageBox.alert("系统提示：","上传成功！");
						constructionGrid.constructionInsertWindow.hide();
						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					},
					failure: function(form, action){
						Ext.MessageBox.alert("系统提示：","上传失败！");
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
     onCloseClick: function(){ 			//关闭
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
/*** * ***************************************************************LookForm组件** *****************************************************************************/
LookForm = Ext.extend(Ext.ux.Form, {

    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	
//    	this.fwid= this.createTextField('发文编号', 'fwid', '90%','',null,100,'长度超过不能50',);
//    	this.hfbr = this.createTextField('回复内容', 'hfbr', '90%','',null,100,'长度超过不能50');
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
    	this.fj = this.createTextField('附件', 'fj', '90%','',null,100,'长度超过不能50');
//    	 this.fj = new Ext.ux.form.FileUploadField({
// 			anchor:'90%',
// 			name: 'attachMentFile',
//             emptyText: '请选择...',
//             labelWidth: 67,
//             fieldLabel: '附件',
//             buttonCfg: {
//                 text: '添加附件'
//             }
// 	    });
    	this.hfsj = new Ext.form.DateField({
			fieldLabel : '回复时间',
			name : "hfsj",
			format : "Y-m-d H:i:s",
			anchor : '90%',
			// allowBlank: false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});
//    	this.sjr = this.createTextField('收件人', 'sjr', '90%','',null,100,'长度超过不能50');
    	
    	
//        this.fwid.allowBlank = true;
        this.hfbr.allowBlank = true;
        this.hfsj.allowBlank = false;
        this.hfr.allowBlank = true;
        this.fj.allowBlank = true;
        
//        this.fwid.readOnly = true;
        this.hfbr.readOnly = true;
        this.hfsj.readOnly = true;
        this.hfr.readOnly = true;
        this.fj.readOnly = true;
       
       

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
                        this.hfr
                    ]  
                }), 
//                new Ext.Panel({  
//                    columnWidth:.105,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:50,
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
//        var pnRow2=new Ext.Panel({  
//            layout:'column',  
//            border:false,  
//            items:[  
//                   new Ext.Panel({  
//                       columnWidth:1,  
//                       layout:'form',  
//                       border:false,  
//                       labelWidth:90,  
//                       labelAlign:'right',  
//                       items:[  
//                           this.fwid
//                       ]  
//                   }),      
//            ]  
//        });
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
                        this.hfbr
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
                        this.hfsj
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
                        this.fj
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
//                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
//                      {text:'回复',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },

     onCloseClick: function(){ 			//回复
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
                                                                                   
                            {name:'ID'},{name:'FWID'},{name:'HFBR'},{name:'HFSJ'},
                            {name:'HFR'},{name:'FJ'},
                           
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'回复人...',  
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
                {header:'序号',dataIndex:'ID',width:150,sortable: true, hidden:true},
                {header:'回复内容',dataIndex:'HFBR',width:150,sortable: true},
            	{header:'回复时间',dataIndex:'HFSJ',width:150,sortable: true},
//                {header:"回复时间",dataIndex:"HFSJ",width:120,sortable:true,
//                    renderer:function(value){
//                       return new Date(value).dateFormat('Y-m-d H:i:s');
//                      }},

            	{header:'回复人',dataIndex:'HFR',width:150,sortable: true},
                {header:'附件',dataIndex:'FJ',width:150,sortable: true},
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
    
    onLook: function() {
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
		var url = "hfCkView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("回复信息查看");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
	
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
//    	win.constructionForm.idHidden.setValue(0);
    	win.show();
//    	 var curDate=new Date();
//  	    win.constructionForm.fssj.setValue(curDate);
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
////   		    	win.constructionForm.getForm().loadRecord(vrecord);
//   		    	win.constructionForm.fwid.setValue(vrecord.data.FWID);
   		    	win.constructionForm.hfbr.setValue(vrecord.data.HFBR);
   		    	win.constructionForm.hfsj.setValue(vrecord.data.HFSJ);
   		    	win.constructionForm.hfr.setValue(vrecord.data.HFR);
   		    	win.constructionForm.fj.setValue(vrecord.data.FJ);
   		   
   		    	
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
