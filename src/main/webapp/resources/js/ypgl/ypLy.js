var USER_GRID_STORE_URL = 'getLyList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

/*************************************** LookForm 组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.ypbh = new Ext.form.TextField({
            fieldLabel: '样品编号',
            name: 'ypbh',
            anchor: '100%'
        });
    	// this.ewmbh = new Ext.form.TextField({
            // fieldLabel: '二维码编号',
            // name: 'ewmbh',
            // anchor: '100%'
        // });
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '100%','',null,100,'长度超过不能11');
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '100%','',null,100,'长度超过不能11');
    	this.lyyt = this.createTextField('领用用途', 'lyyt', '100%','',null,100,'长度超过不能100');
    	this.lyr = this.createTextField('领用人', 'lyr', '100%','',null,200,'长度超过不能200');
    	this.blr = this.createTextField('办理人', 'blr', '100%','',null,100,'长度超过不能200');
    	
    	this.lysj =  new Ext.form.DateField({
			fieldLabel: '领用时间',
			name: "lysj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.lysl = new Ext.form.TextArea({
            fieldLabel: '领用数量',
            name: 'lysl',
            readOnly: false,
            anchor: '100%',
            height:50,
            blankText: '请输入数量',
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '100%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.ypbh.allowBlank = true;
    	//this.ewmbh.allowBlank = true;
    	this.ypmc.allowBlank = true;
    	this.lysj.allowBlank = true;
    	this.lyyt.allowBlank = true;
    	this.lyr.allowBlank = true;
    	this.blr.allowBlank = true;
    	this.lysl.allowBlank = true;
    	this.bz.allowBlank = true;
    	this.bgbh.allowBlank = true;
    	
    	this.ypbh.readOnly = true;
    	//this.ewmbh.readOnly = true;
    	this.ypmc.readOnly = true;
    	this.lysj.readOnly = true;
    	this.lyyt.readOnly = true;
    	this.lyr.readOnly = true;
    	this.blr.readOnly = true;
    	this.lysl.readOnly = true;
    	this.bz.readOnly = true;
    	this.bgbh.readOnly = true;
 
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
                        this.ypbh
                     ]  
                   }),
               new Ext.Panel({  
                columnWidth:.5,  
                layout:'form',  
                border:false,  
                labelWidth:80,  
                labelAlign:'right',  
                items:[  
                    this.bgbh
                 ]  
               })
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
                           this.ypmc
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.lysj
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
                           this.lyyt
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.lyr
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
                           this.lysl
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.blr
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
						pnRow5
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
    	
    	this.ypbh = this.createTextField('<font color="red">*</font>样品编号', 'ypbh', '100%','',null,100,'长度超过不能50');
    	this.ypmc = this.createTextField('<font color="red">*</font>样品名称', 'ypmc', '100%','',null,100,'长度超过不能11');
    	this.bgbh = this.createTextField('<font color="red">*</font>报告编号', 'bgbh', '100%','',null,100,'长度超过不能11');
    	this.lyyt = this.createTextField('<font color="red">*</font>领用用途', 'lyyt', '100%','',null,100,'长度超过不能100');
    	this.lyr = this.createTextField('<font color="red">*</font>领用人', 'lyr', '100%','',null,200,'长度超过不能200');
    	this.blr = this.createTextField('<font color="red">*</font>办理人', 'blr', '100%','',null,100,'长度超过不能200');
    	
    	this.lysj =  new Ext.form.DateField({
			fieldLabel: '<font color="red">*</font>领用时间',
			name: "lysj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.lysl = new Ext.form.TextArea({
            fieldLabel: '<font color="red">*</font>领用数量',
            name: 'lysl',
            readOnly: false,
            anchor: '100%',
            height:50,
            blankText: '请输入数量',
            maxLength: 256,
            maxLengthText: '256！'
        });
    	
    	
    	this.bz = new Ext.form.TextArea({
            fieldLabel: '备注',
            name: 'bz',
            readOnly: false,
            anchor: '100%',
            height:50,
            maxLength: 256,
            maxLengthText: '256！'
        });
        
        
    	this.ypbh.allowBlank = false;
    	this.ypmc.allowBlank = false;
    	this.lysj.allowBlank = false;
    	this.lyyt.allowBlank = false;
    	this.lyr.allowBlank = false;
    	this.blr.allowBlank = false;
    	this.lysl.allowBlank = false;
    	this.bz.allowBlank = true;
    	this.bgbh.allowBlank = false;
 
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
                        this.ypbh
                     ]  
                   }),
               new Ext.Panel({  
                columnWidth:.5,  
                layout:'form',  
                border:false,  
                labelWidth:80,  
                labelAlign:'right',  
                items:[  
                    this.bgbh
                 ]  
               })
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
                           this.ypmc
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.lysj
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
                           this.lyyt
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.lyr
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
                           this.lysl
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.blr
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
						pnRow5
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
/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看样品领用信息",
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

/***************************************ConstructionUpdateWindow组件**************************************************/
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.constructionForm = new ConstructionForm();
    	this.constructionForm.buttons[0].hide();   //隐藏添加按钮
    	this.constructionForm.buttons[1].show();   //显示修改按钮
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "修改样品领用信息",
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
                            {name:'ID'},{name:'YPBH'},{name:'EWMBH'},{name:'YPMC'},{name:'LYSJ'},{name:'LYSL'},
                            {name:'LYR'},{name:'BLR'},{name:'LYYT'},{name:'BZ'},{name:'BGBH'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 250,
                	   emptyText:'样品编号&&报告编号&&样品名称...',  
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
    	this.constructionLookWindow = new ConstructionLookWindow();
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
            	{header:'序号',dataIndex:'ID',width:100,sortable: true, hidden:true},
            	{header: '操作', width: 80, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>查看</span></a>";
            		}
				},
                {header:'样品编号',dataIndex:'YPBH',width:100,sortable: true},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
                /*{header:'浜岀淮鐮佺紪鍙�,dataIndex:'EWMBH',width:100,sortable: true},*/
            	{header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
            	{header:'领用时间',dataIndex:'LYSJ',width:100,sortable: true},
            	{header:'领用数量',dataIndex:'LYSL',width:100,sortable: true},
            	{header:'领用人',dataIndex:'LYR',width:100,sortable: true},
            	{header:'办理人',dataIndex:'BLR',width:100,sortable: true},
            	{header:'领用用途',dataIndex:'LYYT',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },

    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.show();
   		    	win.lookForm.ypbh.setValue(vrecord.data.YPBH);
   		    	//win.lookForm.ewmbh.setValue(vrecord.data.EWMBH);
   		    	win.lookForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.lookForm.lysj.setValue(vrecord.data.LYSJ);
   		    	win.lookForm.lyyt.setValue(vrecord.data.LYYT);
   		    	win.lookForm.lysl.setValue(vrecord.data.LYSL);
   		    	win.lookForm.lyr.setValue(vrecord.data.LYR);
   		    	win.lookForm.blr.setValue(vrecord.data.BLR);
   		    	win.lookForm.bz.setValue(vrecord.data.BZ);
   		    	win.lookForm.bgbh.setValue(vrecord.data.BGBH);
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
     onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.show();
   		    	win.constructionForm.ypbh.setValue(vrecord.data.YPBH);
   		    	//win.constructionForm.ewmbh.setValue(vrecord.data.EWMBH);
   		    	win.constructionForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.constructionForm.lysj.setValue(vrecord.data.LYSJ);
   		    	win.constructionForm.lyyt.setValue(vrecord.data.LYYT);
   		    	win.constructionForm.lysl.setValue(vrecord.data.LYSL);
   		    	win.constructionForm.lyr.setValue(vrecord.data.LYR);
   		    	win.constructionForm.blr.setValue(vrecord.data.BLR);
   		    	win.constructionForm.bz.setValue(vrecord.data.BZ);
   		    	win.constructionForm.bgbh.setValue(vrecord.data.BGBH);
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