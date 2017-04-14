var USER_GRID_STORE_URL = 'getBgdydan';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

var ewmWindow;


/***************************************ActDealWindow组件**************************************************/
ActDealWindow = Ext.extend(Ext.Window,{
    constructor: function(grid) {
    	ActDealWindow.superclass.constructor.call(this, {
            width: 500,
            anchor: '100%',
            maximized :false,
            height:300,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'close',
            html:'<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src=""></iframe>'
        });
    }
});

/***************************************EwmWindow组件**************************************************/
EwmWindow = Ext.extend(Ext.Window,{
    constructor: function(grid) {
    	EwmWindow.superclass.constructor.call(this, {
            width: 800,
            anchor: '100%',
            maximized :true,
            height: 400,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'close',
            html:'<iframe scrolling="auto" frameborder="0" width="100%;" height="100%;" src=""></iframe>'
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
                            {name:'ID'},{name:'BGBH'},{name:'YPMC'},{name:'JYRQ'},{name:'BZR'},{name:'DYCS'},
                            {name:'JSDW1'},{name:'JSR'},{name:'FFRQ'},{name:'FFZT'},{name:'TJRQ'},{name:'TJYY'},{name:'TJR'},{name:'EWMBH'},{name:'EWMTP'},
                            {name:'BZ'},{name:'BZFS'},{name:'JYJL'},{name:'RZFS'},{name:'BSDX'},{name:'CYDW'},{name:'WCQX'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//					{text:'查看二维码',iconCls: 'edit',handler:this.onBqClick,scope:this},
//					{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
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
            	{header:'操作',dataIndex:'',width:100,sortable: true,
            		renderer:function(value, cellmeta, record){
					   return "<a href='javascript:;' onclick='constructionGrid.onBgdy()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>报告打印</span></a>";
					}
            	},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:100,sortable: true},
            	{header:'打印次数',dataIndex:'DYCS',width:100,sortable: true},
            	{header:'检验日期',dataIndex:'JYRQ',width:200,sortable: true},
            	{header:'到期日期',dataIndex:'WCQX',width:100,sortable: true},
            	{header:'报审对象',dataIndex:'BSDX',width:100,sortable: true},
            	{header:'抽样单位',dataIndex:'CYDW',width:100,sortable: true},
            	{header:'编制方式',dataIndex:'BZFS',width:100,sortable: true,
            		renderer:function(value){
  	                    if(value == '0') {
  	                        return "<span>一般样品登记 </span>";
  	                    }else if(value == '1') {
  	                        return "<span>工程类样品登记</span>";
  	                    }else if(value == '2') {
  	                        return "<span>食药类样品登记</span>";
  	                    }else{
  	                    	return value;
  	                    }
              		}
              	},
            	{header:'检验结论',dataIndex:'JYJL',width:100,sortable: true},
//            	{header:'认证方式',dataIndex:'RZFS',width:100,sortable: true},
            	{header:'编制人',dataIndex:'BZR',width:100,sortable: true},
            	{header:'接收单位',dataIndex:'JSDW1',width:100,sortable: true},
            	{header:'接收人',dataIndex:'JSR',width:100,sortable: true},
            	{header:'发放日期',dataIndex:'FFRQ',width:100,sortable: true},
            	{header:'发放状态',dataIndex:'FFZT',width:100,sortable: true},
            	{header:'退检日期',dataIndex:'TJRQ',width:100,sortable: true},
            	{header:'退检原因',dataIndex:'TJYY',width:100,sortable: true},
            	{header:'退检人',dataIndex:'TJR',width:100,sortable: true},
            	{header:'二维码编号',dataIndex:'EWMBH',width:100,sortable: true},
//            	{header:'二维码图片',dataIndex:'EWMTP',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onBqClick: function() {       
    	var records=this.getSelectionModel().getSelections();
    	if(records.length > 0) {
    		if(records.length == 1){
    			vrecord = records[0];
    			var bgbh=vrecord.get('BGBH');
////    			var url = 'sbbqPage?bgbh='+bgbh;  	
//    			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
//    			ewmWindow = new EwmWindow();
//    			ewmWindow.setTitle("生成报告二维码");
//    			ewmWindow.html = html;
//    			ewmWindow.show();
    			window.open('bgxxewm?bgbh='+bgbh,'报告二维码','height=500px, width=600px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
    		}else{
    			Ext.Msg.alert('系统提示', '不能选择多条记录..');
    		}
    	}else{
    		Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
    	}
    },
    onBgdy: function() {                  //报告打印
    	var records=this.getSelectionModel().getSelections();
    	var bgbh=records[0].get('BGBH');
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
//   				Ext.Msg.confirm("提醒信息", "是否进行报告打印？该条报告只可打印一次。",function(btn){
//   					if (btn == 'yes') {
//   							window.open(PROJECT_NAME + '/jygl/YjyBgxx/wordOnLine?bgbh='+vrecord.get('BGBH'));
//   					}
//   				});	
   				var url = "dcdyym?bgbh="+bgbh;  	
   				html = '<iframe scrolling="no" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
   				ACT_DEAL_WINDOW = new ActDealWindow();
   				ACT_DEAL_WINDOW.setTitle("提醒信息：");
   				ACT_DEAL_WINDOW.html = html;
   				ACT_DEAL_WINDOW.show();
   			}else{
   				Ext.Msg.alert('系统提示', '不能查看多条记录..');
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
			       		url: PROJECT_NAME + '/jygl/YjyBgxx/delete', 
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