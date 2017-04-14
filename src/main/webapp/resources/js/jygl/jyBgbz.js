var USER_GRID_STORE_URL = 'getBgbzList';
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
                            {name:'ID'},{name:'BGBH'},{name:'YPBH'},{name:'JYLB'},{name:'YPLB'},{name:'BMBH'},
                            {name:'DJRQ'},{name:'JYYJ'},{name:'JYQX'},{name:'BZBH'},{name:'BZMC'},{name:'ZJR'},{name:'KSRQ'},{name:'JSRQ'},{name:'HJTJ'},
                            {name:'XMMS'},{name:'JYFF'},{name:'PDYQ'},{name:'QTSM'},{name:'JYFY'},{name:'JJFY'},{name:'QTFY'},{name:'FYHJ'},{name:'SWPD'},
                            {name:'BZPD'},{name:'JYJL'},{name:'RZFS'},{name:'JYZT'},{name:'TJRQ'},{name:'TJYY'},{name:'TJR'},{name:'TBZT'},{name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
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
            	{header: '操作', width: 150, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("JYZT") == '待检'){
						   return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>流转日志</span></a>&nbsp;&nbsp;&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>编制</span></a>";
            		}else{
            			 return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
				   		  "<span style='width: 25px;cursor: pointer;'>流转日志</span></a>&nbsp;&nbsp;&nbsp"+
				   		  "<span style='width: 25px;color:gray;'>编制</span>";
            		}
				  }
            	},
            	{header:'检验状态',dataIndex:'JYZT',width:100,sortable: true,
            		renderer:function(value){
	                    if(value == '在检') {
	                        return "<span style='color:green'>在检</span>";
	                    }else if(value == '待检') {
	                        return "<span style='color:blue'>待检</span>";
	                    }else if(value == '已检'){
	                    	return "<span style='color:red'>已检</span>";
	                    	return value;
	                    }
            		}
            	},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
                {header:'样品编号',dataIndex:'YPBH',width:100,sortable: true},
            	{header:'检验类别',dataIndex:'JYLB',width:100,sortable: true},
            	{header:'样品类别',dataIndex:'YPLB',width:100,sortable: true},
            	{header:'检验科室',dataIndex:'BMBH',width:100,sortable: true},
            	{header:'登记日期',dataIndex:'DJRQ',width:100,sortable: true},
            	{header:'检验依据',dataIndex:'JYYJ',width:100,sortable: true},
            	{header:'检验期限',dataIndex:'JYQX',width:100,sortable: true},
            	{header:'检验标准编号',dataIndex:'BZBH',width:100,sortable: true},
            	{header:'检验标准名称',dataIndex:'BZMC',width:100,sortable: true},
            	{header:'主检人',dataIndex:'ZJR',width:100,sortable: true},
            	{header:'开始日期',dataIndex:'KSRQ',width:100,sortable: true},
            	{header:'结束日期',dataIndex:'JSRQ',width:100,sortable: true},
            	{header:'环境条件',dataIndex:'HJTJ',width:100,sortable: true},
            	{header:'检验项目描述',dataIndex:'XMMS',width:100,sortable: true},
            	{header:'检验方法',dataIndex:'JYFF',width:100,sortable: true},
            	{header:'判定要求',dataIndex:'PDYQ',width:100,sortable: true},
            	{header:'其他说明',dataIndex:'QTSM',width:100,sortable: true},
            	{header:'检验费用',dataIndex:'JYFY',width:100,sortable: true},
            	{header:'加急费用',dataIndex:'JJFY',width:100,sortable: true},
            	{header:'其他费用',dataIndex:'QTFY',width:100,sortable: true},
            	{header:'费用合计',dataIndex:'FYHJ',width:100,sortable: true},
            	{header:'实物判定',dataIndex:'SWPD',width:100,sortable: true},
            	{header:'标识判定',dataIndex:'BZPD',width:100,sortable: true},
            	{header:'检验结论',dataIndex:'JYJL',width:100,sortable: true},
            	{header:'认证方式',dataIndex:'RZFS',width:100,sortable: true},
            	{header:'退检日期',dataIndex:'TJRQ',width:100,sortable: true},
            	{header:'退检原因',dataIndex:'TJYY',width:100,sortable: true},
            	{header:'退检人',dataIndex:'TJR',width:100,sortable: true},
            	{header:'催办状态',dataIndex:'TBZT',width:100,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>已催办</span>";
	                    }else if(value == '1') {
	                        return "<span>未催办</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onModifyClick: function(){
		var records = this.getSelectionModel().getSelections();
		var id=records[0].get('ID');
//		var url = "rbpyDetailView?id="+id;   	
		var url = "jyDetailView?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("报告编制");
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
			       		url: PROJECT_NAME + '/jygl/YjyJyxx/delete', 
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