var USER_GRID_STORE_URL = 'getXmmlList';
var PAGESIZE=20;
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
            anchor: '100%'
        });
    	this.bzbh = new Ext.form.TextField({
            fieldLabel: '标准编号',
            name: 'bzbh',
            anchor: '100%'
        });
    	this.xmbh = new Ext.form.TextField({
            fieldLabel: '项目编号',
            name: 'xmbh',
            anchor: '100%'
        });
    	this.xmmc = new Ext.form.TextField({
            fieldLabel: '项目名称',
            name: 'xmmc',
            anchor: '100%'
        });
    	this.xmlx = new Ext.form.TextField({
            fieldLabel: '项目类型',
            name: 'xmlx',
            anchor: '100%'
        });
    	this.xmyq = new Ext.form.TextField({
            fieldLabel: '项目要求',
            name: 'xmyq',
            anchor: '100%'
        });
    	this.jldw = new Ext.form.TextField({
            fieldLabel: '计量单位',
            name: 'jldw',
            anchor: '100%'
        });
    	this.jyfy = new Ext.form.NumberField({
    		fieldLabel: '检验费用',
    		name: 'jyfy',
    		allowNegative :false,
    		regex: /^\d+(\.\d+)?$/,
    		anchor: '100%',
    		cls:'forbiddenZH',
    		nanText: "请输入有效的整数",
    		allowDecimals:false,
    		hidden:false
    	});
    	this.bzmax = new Ext.form.TextField({
            fieldLabel: '标准最大值',
            name: 'bzmax',
            anchor: '100%'
        });
    	this.bzmin = new Ext.form.TextField({
            fieldLabel: '标准最小值',
            name: 'bzmin',
            anchor: '100%'
        });
    	this.scz = new Ext.form.TextField({
    		fieldLabel: '实测值',
    		name: 'scz',
    		anchor: '100%'
    	});
    	this.pdyy = new Ext.form.TextField({
    		fieldLabel: '评定结果',
    		name: 'pdyy',
    		anchor: '100%'
    	});
    	this.jyrq =  new Ext.form.DateField({
			fieldLabel: '检验日期',
			name: "jyrq",
			format: "Y-m-d",
			anchor: '100%',
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.bmbh = new Ext.form.TextField({
    		fieldLabel: '检验科室',
    		name: 'bmbh',
    		anchor: '100%'
    	});
    	this.pdfs = new Ext.form.TextField({
    		fieldLabel: '评定方式',
    		name: 'pdfs',
    		anchor: '100%'
    	});
    	this.jyr = new Ext.form.TextField({
    		fieldLabel: '检验人',
    		name: 'jyr',
    		anchor: '100%'
    	});
    	this.zdcx = new Ext.form.TextField({
    		fieldLabel: '最低检出限',
    		name: 'zdcx',
    		anchor: '100%'
    	});
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '90%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.bgbh.allowBlank = false;
    	this.bzbh.allowBlank = false;
    	this.xmbh.allowBlank = false;
    	this.xmmc.allowBlank = false;
    	this.xmlx.allowBlank = false;
    	this.xmyq.allowBlank = false;
    	this.jldw.allowBlank = false;
    	this.jyfy.allowBlank = false;
    	this.bzmax.allowBlank = false;
    	this.bzmin.allowBlank = false;
    	this.scz.allowBlank = false;
    	this.pdyy.allowBlank = false;
    	this.jyrq.allowBlank = false;
    	this.bmbh.allowBlank = false;
    	this.pdfs.allowBlank = false;
    	this.jyr.allowBlank = false;
    	this.zdcx.allowBlank = false;
    	this.bz.allowBlank = false;
    	

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
                           this.xmmc
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
                       labelWidth:80,  
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
                           this.jyfy
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.bzmax
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
                           this.bzmin
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.scz
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.3,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.pdyy
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
                           this.jyrq
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
                           this.pdfs
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
                           this.jyr
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
					  {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
					  {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
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
/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[0].show();   //隐藏添加按钮
    	this.constructionForm.buttons[1].hide();   //显示修改按钮
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "检验项目新增信息",
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

/***************************************ConstructionUpdateWindow组件**************************************************/
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.constructionForm = new ConstructionForm();
        this.constructionForm.buttons[1].show();   //隐藏添加按钮
    	this.constructionForm.buttons[0].hide();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "检验项目修改信息",
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
                            {name:'ID'},{name:'BGBH'},{name:'BZBH'},{name:'XMBH'},{name:'XMMC'},{name:'XMLX'},
                            {name:'XMYQ'},{name:'JLDW'},{name:'JYFY'},{name:'BZMAX'},{name:'BZMIN'},{name:'SCZ'},{name:'PDYY'},{name:'JYRQ'},{name:'BMBH'},
                            {name:'PDFS'},{name:'JYR'},{name:'ZDCX'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'canshu',width: 250,
                	   emptyText:'检验编号&&标准编号...',  
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
//            	{header: '操作', width: 80, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
//					renderer:function(value, cellmeta, record){
//						   return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
//					   		  "<span style='width: 25px;cursor: pointer;'>流转日志</span></a>";
//            		}
//				},
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
            	{header:'最低检出限',dataIndex:'ZDCX',width:100,sortable: true},
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
    
    onModifyClick: function() {         //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
   		    	win.constructionForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.constructionForm.bzbh.setValue(vrecord.data.BZBH);
   		    	win.constructionForm.xmbh.setValue(vrecord.data.XMBH);
   		    	win.constructionForm.xmmc.setValue(vrecord.data.XMMC);
   		    	win.constructionForm.xmlx.setValue(vrecord.data.XMLX);
   		    	win.constructionForm.xmyq.setValue(vrecord.data.XMYQ);
   		    	win.constructionForm.jldw.setValue(vrecord.data.JLDW);
   		    	win.constructionForm.jyfy.setValue(vrecord.data.JYFY);
   		    	win.constructionForm.bzmax.setValue(vrecord.data.BZMAX);
   		    	win.constructionForm.bzmin.setValue(vrecord.data.BZMIN);
   		    	win.constructionForm.scz.setValue(vrecord.data.SCZ);
   		    	win.constructionForm.pdyy.setValue(vrecord.data.PDYY);
   		    	win.constructionForm.jyrq.setValue(vrecord.data.JYRQ);
   		    	win.constructionForm.bmbh.setValue(vrecord.data.BMBH);
   		    	win.constructionForm.pdfs.setValue(vrecord.data.PDFS);
   		    	win.constructionForm.jyr.setValue(vrecord.data.JYR);
   		    	win.constructionForm.zdcx.setValue(vrecord.data.ZDCX);
   		    	win.constructionForm.bz.setValue(vrecord.data.BZ);
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