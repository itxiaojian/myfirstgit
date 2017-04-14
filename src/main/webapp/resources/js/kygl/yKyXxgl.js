var USER_GRID_STORE_URL = 'getKyXxglList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var RWZP_URL1 = '/yrwgl/yrwzp/getRwZprList';
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
        addClick: function() {
	        	var records=this.getSelectionModel().getSelections();
	    		var sjid = records[0].get('yhbh');
	    		var str='';
	    		for(var i=0;i<records.length;i++){
	    			str=str+records[i].get('dlm')+',';
	    		}
	    		var str = Ext.util.Format.substr(str, 0, str.length-1);
	    		this.rwglZprWindow.constructionForm.cyry.setValue(str);
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
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
        this.kybh = this.createTextField('科研编号', 'kybh', '89%','',null,100,'长度超过不能50');
    	
    	this.kymc = new Ext.form.TextField({
            fieldLabel: '科研名称',
            name: 'kymc',
            anchor: '90%'
        });
    	
    	this.kyxmnr = this.createTextField('科研项目内容', 'kyxmnr', '89%','',null,100,'长度超过不能50');
    	
//    	this.ks_id = this.createTextField('所属科室', 'ks_id', '90%','',null,100,'长度超过不能50');
    	
    	this.ks_id = new zjyw.OrgSingelSelectAll('所属科室','ks_id','ks_id','90%');
    	
    	this.cyry = this.createTextField('参与人员', 'cyry', '98%','',null,100,'长度超过不能11');
    	
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
			anchor: '89.5%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注',
            name: 'bz',
            readOnly: false,
            anchor: '94.5%',
            height:80,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.kybh.allowBlank = false;
        this.kymc.allowBlank = false;
        this.kyxmnr.allowBlank = false;
        this.ks_id.allowBlank = false;
        this.cyry.allowBlank = false;
        this.kssj.allowBlank = false;
        this.jssj.allowBlank = false;
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
                        this.kybh
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:115,  
                    labelAlign:'right',  
                    items:[  
                        this.kymc
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
                           this.kyxmnr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:115,  
                       labelAlign:'right',  
                       items:[  
                             this.ks_id
                             ]  
                    }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   new Ext.Panel({  
                       columnWidth:.395,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                              this.cyry
                             ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.105,  
                       layout:'form',  
                       border:false,  
                       labelWidth:50,
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
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:115,  
                        labelAlign:'right',  
                        items:[  
                            this.kssj
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
                           this.jssj
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
                  style:"margin-top:5px;",
                  labelWidth:115,  
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
                    pnRow1,
                    pnRow2,
                    pnRow3,
                    pnRow4,
                    pnRow5,
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


/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[0].show();   //显示添加按钮
    	this.constructionForm.buttons[1].hide();   //隐藏修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "科研信息",
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
        	title: "修改科研信息",
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
                            {name:'ID'},{name:'KYBH'},{name:'KYMC'},{name:'KYXMNR'},{name:'KS_ID'},
                            {name:'CYRY'},{name:'KSSJ'},{name:'JSSJ'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'科研名称&科研编号...',  
               	    },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			  }
                  },
                '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
     		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
    		        	    if(btn=="yes"){ 
    		        	    	window.open(PROJECT_NAME+"/resources/js/kygl/Kyxx.xls");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		     '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                 '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
  	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
  			        	    if(btn=="yes"){ 		        	    	
  			        	    	var fileName = "科研信息";
  			        	    	var code = Ext.getCmp('code').getValue();
  			        	    	var url = PROJECT_NAME + "/kygl/YkyXxgl/export?fileName="+fileName+"&code="+code;
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
                {header:'id',dataIndex:'ID',width:70,sortable: true, hidden:true},
                {header:'科研编号',dataIndex:'KYBH',width:80,sortable: true},
                {header:'科研名称',dataIndex:'KYMC',width:120,sortable: true},
            	{header:'科研项目内容',dataIndex:'KYXMNR',width:110,sortable: true, hidden:true},
            	{header:'所属科室',dataIndex:'KS_ID',width:150,sortable: true},
            	{header:'参与人员',dataIndex:'CYRY',width:120,sortable: true},
            	{header:'开始时间',dataIndex:'KSSJ',width:80,sortable: true, hidden:true},
            	{header:'结束时间',dataIndex:'JSSJ',width:80,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:120,sortable: true},
            	 {header : '操作',width : 80,dataIndex : 'sbbh',align : "center",sortable : true,hidden : false,renderer : function(value,cellmeta,record)

					{
						return "<a href='javascript:;' onclick='constructionGrid. onModifyClick()' style='text-decoration:none;'>"
								+ "<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
								"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
								"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>&nbsp;&nbsp;&nbsp";
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
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	var url = "KyxxAddView?";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("信息管理增加");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
	 onModifyClick: function() {
	    	var records=this.getSelectionModel().getSelections();
	    	var id=records[0].get('ID');
			var url = "KyxxXgView?id="+id;  	
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("修改科研信息");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
	   		if(records.length > 0) {
	   			if(records.length == 1){
	   				vrecord = records[0];
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