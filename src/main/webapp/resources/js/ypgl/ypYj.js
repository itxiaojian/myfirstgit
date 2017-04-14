var USER_GRID_STORE_URL = 'getYjList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

var ACT_DEAL_WINDOW;

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
                            {name:'ID'},{name:'YPBH'},{name:'YPMC'},{name:'YJSJ'},{name:'JSR'},
                            {name:'JSSJ'},{name:'YJR'},{name:'BLR'},{name:'YJSL'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 250,
                	   emptyText:'样品编号&&样品名称...',  
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
    	//this.constructionLookWindow = new ConstructionLookWindow();
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
            	// {header: '操作', width: 80, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					// renderer:function(value, cellmeta, record){
						   // return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  // "<span style='width: 25px;cursor: pointer;'>查看</span></a>";
            		// }
				// },
                {header:'样品编号',dataIndex:'YPBH',width:100,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
            	{header:'移交时间',dataIndex:'YJSJ',width:100,sortable: true},
            	{header:'移交数量',dataIndex:'YJSL',width:100,sortable: true},
            	{header:'移交人',dataIndex:'YJR',width:100,sortable: true},
            	{header:'接收人',dataIndex:'JSR',width:100,sortable: true},
            	{header:'接收时间',dataIndex:'JSSJ',width:100,sortable: true},
            	{header:'办理人',dataIndex:'BLR',width:100,sortable: true},
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
   		    	win.lookForm.txmbh.setValue(vrecord.data.TXMBH);
   		    	win.lookForm.ypmc.setValue(vrecord.data.YPMC);
   		    	win.lookForm.yjsj.setValue(vrecord.data.YJSJ);
   		    	win.lookForm.jsr.setValue(vrecord.data.JSR);
   		    	win.lookForm.jssj.setValue(vrecord.data.JSSJ);
   		    	win.lookForm.yjr.setValue(vrecord.data.YJR);
   		    	win.lookForm.blr.setValue(vrecord.data.BLR);
   		    	win.lookForm.yjsl.setValue(vrecord.data.YJSL);
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