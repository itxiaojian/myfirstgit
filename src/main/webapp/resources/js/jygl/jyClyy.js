var USER_GRID_STORE_URL = 'getClyyList';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

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
                            {name:'ID'},{name:'CGJLYY'},{name:'BZ'},{name:'JLLB1'},{name:'JLLB2'},{name:'XZR'},{name:'XZSJ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'canshu',width: 250,
                	   emptyText:'报告编号&&样品编号...',  
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
                {header:'常规结论用语',dataIndex:'CGJLYY',width:300,sortable: true},
            	{header:'结论类别1',dataIndex:'JLLB1',width:100,sortable: true,
                	renderer:function(value){
  	                    if(value == '0') {
  	                        return "<span>产品 </span>";
  	                    }else if(value == '1') {
  	                        return "<span>样品</span>";
  	                    }else if(value == '2') {
  	                        return "<span>综合判定</span>";
  	                    }else{
  	                    	return value;
  	                    }
              		}
            	},
            	{header:'结论类别2',dataIndex:'JLLB2',width:100,sortable: true,
            		renderer:function(value){
  	                    if(value == '0') {
  	                        return "<span>合格 </span>";
  	                    }else if(value == '1') {
  	                        return "<span>不合格</span>";
  	                    }else if(value == '2') {
  	                        return "<span>见附页</span>";
  	                    }else{
  	                    	return value;
  	                    }
              		}
            	},
            	{header:'新增人',dataIndex:'XZR',width:100,sortable: true},
            	{header:'新增时间',dataIndex:'XZSJ',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onAddClick: function() {                  //新增
		var url = "add";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("新增常用检验用语");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();  	   	
    },
    
    onModifyClick: function() {                  //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var url = "edit?id="+id;  	
   				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
   				ACT_DEAL_WINDOW = new ActDealWindow();
   				ACT_DEAL_WINDOW.setTitle("修改常用检验用语");
   				ACT_DEAL_WINDOW.html = html;
   				ACT_DEAL_WINDOW.show();  	 
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
			       		url: PROJECT_NAME + '/jygl/YjyClyy/delete', 
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