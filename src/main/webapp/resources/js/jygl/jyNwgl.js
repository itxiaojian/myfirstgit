var USER_GRID_STORE_URL = 'getNwglList';
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
                            {name:'ID'},{name:'WTBM'},{name:'WTBMMC'},{name:'CJBM'},{name:'CJBMMC'},{name:'YPBH'},
                            {name:'WTRQ'},{name:'YQWCRQ'},{name:'WTPYS'},{name:'JYFY'},{name:'JBR'},{name:'YPMC'},
                            {name:'JBRXM'},{name:'JBRQ'},{name:'BMLD'},{name:'BMLDXM'},{name:'QZRQ'},{name:'JSR'},{name:'JSRXM'},{name:'JSRQ'},{name:'LZDZT'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
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
            	{header:'操作',dataIndex:'',width:130,sortable: true,
            		renderer:function(value, cellmeta, record){
            			if(record.get('JSR')==userName&&record.get('CJBM')==bmbh&&record.get('LZDZT')=='0'){
            				return "<a href='javascript:;' onclick='constructionGrid.onClClick()' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;'>接收</span></a>&nbsp;&nbsp;"+
						   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;color: gray;'>批阅</span></a>&nbsp;&nbsp;"+
						   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;color: gray;'>修改</span></a>" +
						   		  "&nbsp;&nbsp;"+
						   		  "<a href='javascript:;' onclick='constructionGrid.onCkClick()' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;'>查看</span></a>";
            			}else if(str=='1'&&record.get('CJBM')==bmbh&&record.get('LZDZT')=='1'){
            				return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
            					"<span style='width: 26px;cursor: pointer;color: gray;'>接收</span></a>&nbsp;&nbsp;"+
            					"<a href='javascript:;' onclick='constructionGrid.onShClick()' style='text-decoration:none;'>" +
  					   		    "<span style='width: 26px;cursor: pointer;'>批阅</span></a>&nbsp;&nbsp;"+
					   		    "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;color: gray;'>修改</span></a>" +
  					   		    "&nbsp;&nbsp;"+
					   		    "<a href='javascript:;' onclick='constructionGrid.onCkClick()' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;'>查看</span></a>";
            			}else if(record.get('JBR')==userName&&record.get('LZDZT')=='0'){
            				return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;color: gray;'>接收</span></a>&nbsp;&nbsp;"+
						   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
						   		  "<span style='width: 26px;cursor: pointer;color: gray;'>批阅</span></a>&nbsp;&nbsp;"+
						   		  "<a href='javascript:;' onclick='constructionGrid.onXgClick()' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;'>修改</span></a>" +
						   		  "&nbsp;&nbsp;"+
						   		  "<a href='javascript:;' onclick='constructionGrid.onCkClick()' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;'>查看</span></a>";
            			}else{
            				return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;color: gray;'>接收</span></a>&nbsp;&nbsp;"+
					   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;color: gray;'>批阅</span></a>&nbsp;&nbsp;"+
					   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;color: gray;'>修改</span></a>" +
					   		  "&nbsp;&nbsp;"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onCkClick()' style='text-decoration:none;'><span style='width: 26px;cursor: pointer;'>查看</span></a>";
            			}
            		}	
            	},
            	{header:'流转单状态',dataIndex:'LZDZT',width:80,sortable: true,
            		renderer:function(value, cellmeta, record){
            			if(value=='0'){
            				return "接收";
            			}else if(value=='1'){
            				return "审核";
            			}else{
            				return "结束";
            			}
            		}	
            	},
            	{header:'样品编号',dataIndex:'YPBH',width:130,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:130,sortable: true},
                {header:'委托部门',dataIndex:'WTBMMC',width:130,sortable: true},
            	{header:'承检部门',dataIndex:'CJBMMC',width:130,sortable: true},
            	{header:'委托日期',dataIndex:'WTRQ',width:100,sortable: true},
            	{header:'要求完成日期',dataIndex:'YQWCRQ',width:100,sortable: true},
            	{header:'委托样品数',dataIndex:'WTPYS',width:100,sortable: true},
            	{header:'检验费用',dataIndex:'JYFY',width:100,sortable: true},
//            	{header:'是否退样',dataIndex:'SFTY',width:100,sortable: true,
//            		renderer:function(value, cellmeta, record){
//            			if(value=='0'){
//            				return "是";
//            			}else{
//            				return "否";
//            			}
//            		}
//            	},
            	{header:'经办人',dataIndex:'JBRXM',width:100,sortable: true},
            	{header:'经办日期',dataIndex:'JBRQ',width:100,sortable: true},
            	{header:'部门领导',dataIndex:'BMLDXM',width:100,sortable: true},
            	{header:'领导签字日期',dataIndex:'QZRQ',width:100,sortable: true},
            	{header:'接收人',dataIndex:'JSRXM',width:100,sortable: true},
            	{header:'接收日期',dataIndex:'JSRQ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onAddClick: function() {           //增加
    	var url = "nwglAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("委托检验流转单");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    onClClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
    	var url = "nwglJsView?id="+records[0].get('ID');  	
    	html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
    	ACT_DEAL_WINDOW = new ActDealWindow();
    	ACT_DEAL_WINDOW.setTitle("委托检验流转单接收");
    	ACT_DEAL_WINDOW.html = html;
    	ACT_DEAL_WINDOW.show();
    },
    onShClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
    	var url = "nwglShView?id="+records[0].get('ID');  	
    	html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
    	ACT_DEAL_WINDOW = new ActDealWindow();
    	ACT_DEAL_WINDOW.setTitle("委托检验流转单批阅");
    	ACT_DEAL_WINDOW.html = html;
    	ACT_DEAL_WINDOW.show();
    },
    onCkClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
    	var url = "nwglCkView?id="+records[0].get('ID');  	
    	html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
    	ACT_DEAL_WINDOW = new ActDealWindow();
    	ACT_DEAL_WINDOW.setTitle("委托检验流转单查看");
    	ACT_DEAL_WINDOW.html = html;
    	ACT_DEAL_WINDOW.show();
    },
    onXgClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
    	var url = "nwglXgView?id="+records[0].get('ID');  	
    	html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
    	ACT_DEAL_WINDOW = new ActDealWindow();
    	ACT_DEAL_WINDOW.setTitle("委托检验流转单修改");
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