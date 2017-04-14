var USER_GRID_STORE_URL = 'getYpWsdxxList';
var PAGESIZE=20;


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
                            {name:'ID'},{name:'YPBH'},{name:'YPMC'},{name:'YPLX'},{name:'WTDW'},{name:'WTDWDZ'},
                            {name:'SJDW'},{name:'SJDWDZ'},{name:'YPJYZT'},{name:'DJSJ'},{name:'JYLX'},{name:'ZTMC'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                //'-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                //'-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
                '-',{xtype:'textfield',id:'canshu',width: 200,
                	   emptyText:'样品编号&样品名称...',  
               	    },
    	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var canshu = Ext.getCmp('canshu').getValue();
      						constructionGrid.store.baseParams= {canshu:canshu};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('canshu').setValue("");
         			  }
                  }
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
                {header:'编号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                {header: '操作', width: 100, dataIndex: '', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
						   "<span style='width: 25px;'>处理</span></a>&nbsp;&nbsp;&nbsp";
					}
				},
                {header:'样品编号',dataIndex:'YPBH',width:120,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:80,sortable: true},
            	{header:'样品类型',dataIndex:'YPLX',width:80,sortable: true},
            	{header:'检验类型',dataIndex:'JYLX',width:80,sortable: true},
            	{header:'委托单位',dataIndex:'WTDW',width:80,sortable: true},
            	{header:'委托单位地址',dataIndex:'WTDWDZ',width:100,sortable: true},
            	{header:'受检单位',dataIndex:'SJDW',width:80,sortable: true},
            	{header:'受检单位地址',dataIndex:'SJDWDZ',width:100,sortable: true},
            	{header:'样品检测状态',dataIndex:'ZTMC',width:100,sortable: true},
            	{header:'登记日期',dataIndex:'DJSJ',width:80,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    onModifyClick: function() {         //修改
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
				var url = "ypxxAddView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("样品登记");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能处理多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    
				   			
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