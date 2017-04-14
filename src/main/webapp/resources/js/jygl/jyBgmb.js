var USER_GRID_STORE_URL = 'getBgmbList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = "/jygl/YjyBgmb/uploadImage";
var WORD_ONLINE = "/test/testWordOnLine";
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.mblb = this.createCombo('模板类别', 'ZDZ', 'ZDMC', 'mblb', '77%', PROJECT_NAME+'/jygl/YjyBgmb/getDicByLx');
		this.mblb.store.load();
    	
    	this.mblx = this.createCombo('模板类型', 'ZDZ', 'ZDMC', 'mblx', '77%', PROJECT_NAME+'/jygl/YjyBgmb/getDicByLx1');
		this.mblx.store.load();
		
    	this.mbdz = new Ext.ux.form.FileUploadField({
			anchor:'88.5%',
			name: 'attachMentFile',
            emptyText: '请选择...',
            labelWidth: 67,
            fieldLabel: '选择模板',
            buttonCfg: {
                text: '浏览'
            }
	    });
    	this.xzr = new Ext.form.TextField({
            fieldLabel: '新增人',
            name: 'xzr',
            anchor: '100%'
        });
    	this.xzsj =  new Ext.form.DateField({
			fieldLabel: '新增时间',
			name: "xzsj",
			format: "Y-m-d",
			anchor: '90%',
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '88.5%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	this.sub = new Ext.form.TextField({
            fieldLabel: '文件随机名',
            name: 'sub',
            anchor: '100%'
        });
        
        
    	this.mblb.allowBlank = false;
    	this.mblx.allowBlank = false;
    	this.mbdz.allowBlank = false;
    	this.xzr.allowBlank = false;
    	this.xzsj.allowBlank = false;
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
                        this.mblb
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.mblx
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
                      this.mbdz
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
						pnRow3
            ],
            buttonAlign :'center',
            buttons: [
					  {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
					  {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     addFormClick: function(){
			if(this.getForm().isValid()){
				var attachMentFileValue = this.mbdz.getValue();
	        	if(attachMentFileValue == null || attachMentFileValue == "") {
	        		alert(attachMentFileValue);
	        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "请选择文件!" + BLANKSTR);
	        		return;
	        	}
	        	
	        	var attachmentType = attachMentFileValue.substring(attachMentFileValue.lastIndexOf(".")+1).toLowerCase();
	        	if(attachmentType != "doc" && attachmentType != "docx"){
	        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "模板文件类型为doc或docx" + BLANKSTR);
	        		return;
	        	}
	        	
//	        	设置表单enctype属性
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
             onCloseClick: function(){ 			//关闭
                        this.ownerCt.hide();
                         }
                     });

/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.mbmc = new Ext.form.TextField({
            fieldLabel: '模版名称',
            name: 'mbmc',
            anchor: '90%'
        });
    	
    	this.mblb = this.createCombo('模板类别', 'ZDZ', 'ZDMC', 'mblb', '90%', PROJECT_NAME+'/jygl/YjyBgmb/getDicByLx');
		this.mblb.store.load();
    	this.mblx = this.createCombo('模板类型', 'ZDZ', 'ZDMC', 'mblx', '90%', PROJECT_NAME+'/jygl/YjyBgmb/getDicByLx1');
		this.mblx.store.load();
    	this.mbdz = new Ext.form.TextField({
            fieldLabel: '模板地址',
            name: 'mbdz',
            anchor: '90%'
        });
    	this.xzr = new Ext.form.TextField({
            fieldLabel: '新&nbsp;&nbsp;增&nbsp;人',
            name: 'xzr',
            anchor: '90%'
        });
    	this.xzsj =  new Ext.form.DateField({
			fieldLabel: '新增时间',
			name: "xzsj",
			format: "Y-m-d",
			anchor: '90%',
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注',
            name: 'bz',
            readOnly: false,
            anchor: '95%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	this.sub = new Ext.form.TextField({
            fieldLabel: '文件随机名',
            name: 'sub',
            anchor: '100%'
        });
        
        
    	this.mbmc.allowBlank = false;
    	this.mblb.allowBlank = false;
    	this.mblx.allowBlank = false;
    	this.mbdz.allowBlank = false;
    	this.xzr.allowBlank = false;
    	this.xzsj.allowBlank = false;
    	this.bz.allowBlank = true;
    	
    	this.mbmc.readOnly = true;
    	this.mblb.readOnly = true;
    	this.mblx.readOnly = true;
    	this.mbdz.readOnly = true;
    	this.xzr.readOnly = true;
    	this.xzsj.readOnly = true;
    	this.bz.readOnly = true;
    	

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.mbmc
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.mblb
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
                labelWidth:80,  
                labelAlign:'right',  
                items:[  
                      this.mbdz
                      ]  
                }),
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.mblx
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
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bz
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
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.xzr
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.xzsj
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
						pnRow4,
						pnRow3
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

/*************************************** XgaiForm组件 **************************************************/
XgaiForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.mbmc = new Ext.form.TextField({
            fieldLabel: '模版名称',
            name: 'mbmc',
            anchor: '100%'
        });
    	
    	this.mblb = this.createCombo('模板类别', 'ZDZ', 'ZDMC', 'mblb', '100%', PROJECT_NAME+'/jygl/YjyBgmb/getDicByLx');
		this.mblb.store.load();
    	this.mblx = this.createCombo('模板类型', 'ZDZ', 'ZDMC', 'mblx', '100%', PROJECT_NAME+'/jygl/YjyBgmb/getDicByLx1');
		this.mblx.store.load();
    	this.mbdz = new Ext.form.TextField({
            fieldLabel: '模板地址',
            name: 'mbdz',
            anchor: '90%'
        });
    	this.xzr = new Ext.form.TextField({
            fieldLabel: '新&nbsp;&nbsp;增&nbsp;人',
            name: 'xzr',
            anchor: '90%'
        });
    	this.xzsj =  new Ext.form.DateField({
			fieldLabel: '新增时间',
			name: "xzsj",
			format: "Y-m-d",
			anchor: '90%',
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注',
            name: 'bz',
            readOnly: false,
            anchor: '93%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
    	this.sub = new Ext.form.TextField({
            fieldLabel: '文件随机名',
            name: 'sub',
            anchor: '100%'
        });
        
        
    	this.mbmc.allowBlank = false;
    	this.mblb.allowBlank = false;
    	this.mblx.allowBlank = false;
    	this.bz.allowBlank = true;
    	
        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.mbmc
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.mblb
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.mblx
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
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bz
                       ]  
                   }), 
               ]  
        });
        var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.25,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80, 
                    hidden:true,
                    labelAlign:'right',  
                    items:[  
                        this.xzr
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.25,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,
                    hidden:true,
                    labelAlign:'right',  
                    items:[  
                        this.xzsj
                    ]  
                }),
                new Ext.Panel({  
                    columnWidth:.25,  
                    layout:'form',  
                    border:false, 
                    labelWidth:80,
                    hidden:true,
                    labelAlign:'right',  
                    items:[  
                          this.mbdz
                          ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.25,  
                        layout:'form',  
                        border:false, 
                        labelWidth:80, 
                        hidden:true,
                        labelAlign:'right',  
                        items:[  
                              this.sub
                              ]  
                        }),
            ]  
        });
       
        XgaiForm.superclass.constructor.call(this, {
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
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
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
	                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
	                 	constructionGrid.constructionXgaiWindow.hide();
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

/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionForm.buttons[1].hide();   //显示修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "检验报告模版新增信息",
            width: 1000,
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

/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
//        this.lookForm.buttons[0].show();   //显示停用按钮
//    	this.lookForm.buttons[1].hide();   //隐藏报废按钮
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看模板信息",
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

/***************************************ConstructionXgaiWindow组件**************************************************/
ConstructionXgaiWindow = Ext.extend(Ext.Window, {
	xgaiForm : null,
    constructor: function() {
    	this.xgaiForm = new XgaiForm();
//        this.lookForm.buttons[0].show();   //显示停用按钮
//    	this.lookForm.buttons[1].hide();   //隐藏报废按钮
    	ConstructionXgaiWindow.superclass.constructor.call(this, {
        	title: "修改模板信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.xgaiForm]
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
                            {name:'ID'},{name:'MBMC'},{name:'MBLB'},{name:'MBLX'},{name:'BZ'},
                            {name:'MBDZ'},{name:'XZR'},{name:'XZSJ'},{name:'SUB'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'批量删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'canshu',width: 250,
                	   emptyText:'模板名称...',  
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
    	this.constructionInsertWindow = new ConstructionInsertWindow();
    	this.constructionLookWindow = new ConstructionLookWindow();
    	this.constructionXgaiWindow = new ConstructionXgaiWindow();
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
            	{header:'文件随机名',dataIndex:'SUB',width:100,sortable: true, hidden:true},
            	{header: '操作', width: 150, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						 return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='constructionGrid.onXgai()' style='text-decoration:none;'>" +
				   		  "<span style='width: 26px;cursor: pointer;'>修改</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='constructionGrid.onBji()' style='text-decoration:none;'>"+
				   		  "<span style='width: 26px;cursor: pointer;'>编辑</span></a>"+
				   		  "&nbsp&nbsp&nbsp"+
				   		  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>"+
				   		  "<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>";
            		}
				},
                {header:'模版名称',dataIndex:'MBMC',width:350,sortable: true},
                {header:'模板类别',dataIndex:'MBLB',width:100,sortable: true,
                	 renderer:function(value){
                         if(value == '0') {
                             return "<span>中文模板</span>";
                         }else if(value == '1') {
                             return "<span>英文模板</span>";
                         }else{
                         	return value;
                         }
                 	 }
                	},
            	{header:'模版类型',dataIndex:'MBLX',width:100,sortable: true},
            	{header:'模版地址',dataIndex:'MBDZ',width:200,sortable: true},
                {header:'新增人',dataIndex:'XZR',width:100,sortable: true},
            	{header:'新增时间',dataIndex:'XZSJ',width:120,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:200,sortable: true}
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
    
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.show();
   		    	win.lookForm.mbmc.setValue(vrecord.data.MBMC);
   		    	win.lookForm.mblx.setValue(vrecord.data.MBLX);
   		    	win.lookForm.mbdz.setValue(vrecord.data.MBDZ);
   		    	win.lookForm.xzr.setValue(vrecord.data.XZR);
   		    	win.lookForm.xzsj.setValue(vrecord.data.XZSJ);
   		    	win.lookForm.mblb.setValue(vrecord.data.MBLB);
   		    	win.lookForm.bz.setValue(vrecord.data.BZ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onXgai: function() {                  //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionXgaiWindow;
   		    	win.show();
   		    	win.xgaiForm.mbmc.setValue(vrecord.data.MBMC);
   		    	win.xgaiForm.mblx.setValue(vrecord.data.MBLX);
   		    	win.xgaiForm.mbdz.setValue(vrecord.data.MBDZ);
   		    	win.xgaiForm.xzr.setValue(vrecord.data.XZR);
   		    	win.xgaiForm.xzsj.setValue(vrecord.data.XZSJ);
   		    	win.xgaiForm.mblb.setValue(vrecord.data.MBLB);
   		    	win.xgaiForm.bz.setValue(vrecord.data.BZ);
   		    	win.xgaiForm.sub.setValue(vrecord.data.SUB);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onBji: function(){
    		var records = this.getSelectionModel().getSelections();
    		var sub=records[0].get('SUB');
    		var url = "testWordOnLine?sub="+sub ;
    		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
    		ACT_DEAL_WINDOW = new ActDealWindow();
    		ACT_DEAL_WINDOW.setTitle("在线编辑模板");
    		ACT_DEAL_WINDOW.html = html;
    		ACT_DEAL_WINDOW.show();
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