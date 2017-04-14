var USER_GRID_STORE_URL = 'getTyList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.ypbh = this.createTextField('样品编号', 'ypbh', '100%','',null,100,'长度超过不能50');
//    	this.txmbh = this.createTextField('条形码编号', 'txmbh', '100%','',null,100,'长度超过不能50');
    	this.ewmbh = new Ext.form.NumberField({
            fieldLabel: '二维码编号',
            name: 'ewmbh',
            allowNegative :false,
//            maxLength:6,
//            maxLengthText:'长度不能超过6位', 
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
//            disabled:true,
            hidden:false
        });
    	
    	this.ypmc = this.createTextField('样品名称', 'ypmc', '100%','',null,100,'长度超过不能11');
    	
    	this.kfjsr = this.createTextField('客方接受人', 'kfjsr', '100%','',null,100,'长度超过不能100');
    	this.tyr = this.createTextField('归还人', 'tyr', '100%','',null,200,'长度超过不能200');
    	this.blr = this.createTextField('办理人', 'blr', '100%','',null,100,'长度超过不能200');
    	
    	this.tysj =  new Ext.form.DateField({
			fieldLabel: '归还时间',
			name: "tysj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	this.jssj =  new Ext.form.DateField({
			fieldLabel: '接收时间',
			name: "jssj",
			format: "Y-m-d",
			anchor: '100%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.tysl = new Ext.form.NumberField({
            fieldLabel: '归还数量',
            name: 'tysl',
            allowNegative :false,
            maxLength:6,
            maxLengthText:'长度不能超过6位', 
            regex: /^\d+(\.\d+)?$/,
            anchor: '100%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
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
    	this.ewmbh.allowBlank = true;
    	this.ypmc.allowBlank = true;
    	this.tysj.allowBlank = true;
    	this.kfjsr.allowBlank = true;
    	this.jssj.allowBlank = true;
    	this.tyr.allowBlank = true;
    	this.blr.allowBlank = true;
    	this.tysl.allowBlank = true;
    	this.bz.allowBlank = true;

    	this.ypbh.readOnly = true;
    	this.ewmbh.readOnly = true;
    	this.ypmc.readOnly = true;
    	this.tysj.readOnly = true;
    	this.kfjsr.readOnly = true;
    	this.jssj.readOnly = true;
    	this.tyr.readOnly = true;
    	this.blr.readOnly = true;
    	this.tysl.readOnly = true;
    	this.bz.readOnly = true;
 
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
                           this.tysj
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
                           this.kfjsr
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:80,  
                       labelAlign:'right',  
                       items:[  
                           this.jssj
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
                           this.tyr
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
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.tysl
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
						pnRow6
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
        	title: "查看样品退样信息",
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
                            {name:'ID'},{name:'YPBH'},{name:'EWMBH'},{name:'YPMC'},{name:'TYSJ'},{name:'KFJSR'},
                            {name:'JSSJ'},{name:'TYR'},{name:'BLR'},{name:'TYSL'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 250,
                	   emptyText:'样品编号&&条形码编号&&样品名称...',  
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
                {header:'条形码编号',dataIndex:'EWMBH',width:100,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
            	{header:'退样时间',dataIndex:'TYSJ',width:100,sortable: true},
            	{header:'客方接收人',dataIndex:'KFJSR',width:100,sortable: true},
            	{header:'接收时间',dataIndex:'JSSJ',width:100,sortable: true},
            	{header:'退样人',dataIndex:'TYR',width:100,sortable: true},
            	{header:'办理人',dataIndex:'BLR',width:100,sortable: true},
            	{header:'退样数量',dataIndex:'TYSL',width:100,sortable: true},
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
   		    	win.lookForm.ewmbh.setValue(vrecord.data.EWMBH);
   		    	win.lookForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.lookForm.tysj.setValue(vrecord.data.TYSJ);
   		    	win.lookForm.kfjsr.setValue(vrecord.data.KFJSR);
   		    	win.lookForm.jssj.setValue(vrecord.data.JSSJ);
   		    	win.lookForm.tyr.setValue(vrecord.data.TYR);
   		    	win.lookForm.blr.setValue(vrecord.data.BLR);
   		    	win.lookForm.tysl.setValue(vrecord.data.TYSL);
   		    	win.lookForm.bz.setValue(vrecord.data.BZ);
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