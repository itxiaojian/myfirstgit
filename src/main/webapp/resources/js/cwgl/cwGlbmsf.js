var USER_GRID_STORE_URL = 'getGlbmsfList';
var PAGESIZE=20;
var SBXX_URL = '/jybzgl/getYjyBzxxList';
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
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[{name:'BMBH'},
                            {name:'ID'},{name:'FPHM'},{name:'SRFL'},{name:'SFXMMC'},{name:'SFJE'},
                            {name:'SFRQ'},{name:'SFR'},{name:'BZ'},{name:'PJFL'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'缴费登记',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'编辑',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,emptyText:'协议编号&涉及产品名称...'},
                '-','管理部门 ：',{xtype:'combo',id:'glbm',width: 170,emptyText:'请选择...',
                 	  mode: 'local',
          			  triggerAction: 'all',
          			  displayField:'BMMC',
          			  valueField:'BMBH',
                      store: new Ext.data.Store({
                      proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getGlbm', method: 'POST'}),
                      reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                      autoLoad:true
                      }),
                      editable : false
                	  },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
    	  			 var params = {};
  		    	 			if(Ext.getCmp('code').getValue() != '') {
  		    	 				params['code'] = Ext.getCmp('code').getValue();
  		    	 			}
  		    	 			if(Ext.getCmp('glbm').getValue() != '') {
  		    	 				params['glbm'] = Ext.getCmp('glbm').getValue();
  		    	 			}
  		    	 			constructionGrid.store.baseParams= params;
  		    	 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
      	   			    Ext.getCmp('glbm').setValue("");
         			  }},
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
                {header:'序号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                {header:'部门名称',dataIndex:'BMBH',width:100,sortable: true},
                {header:'发票号码',dataIndex:'FPHM',width:120,sortable: true},
                {header:'收入分类',dataIndex:'SRFL',width:120,sortable: true},
                {header:'票据分类',dataIndex:'PJFL',width:100,sortable: true},
            	{header:'收费项目名称',dataIndex:'SFXMMC',width:120,sortable: true},
            	{header:'收费金额（元）',dataIndex:'SFJE',width:100,sortable: true},
            	{header:'收费时间',dataIndex:'SFRQ',width:150,sortable: true},
            	{header:'收费人',dataIndex:'SFR',width:80,sortable: true},
           	    {header:'备注',dataIndex:'BZ',width:120,sortable: true, hidden:true},
           	    {header: '操作', width: 150, align:"center",sortable: true,hidden: false,
           	    	renderer:function(value){
           			 if(1 == 1) {
                  return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
           			     "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
           			     "&nbsp;&nbsp;&nbsp;"+
           			     "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
        			     "<span style='width: 26px;cursor: pointer;'>编辑</span></a>"+
        			     "&nbsp;&nbsp;&nbsp;"+
        			     "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
           			     "<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>";
                        }else if(1 != 1){
                      	  return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                  "<span style='width: 25px;color:gray;'>本条信息有误，请联系管理员</span></a>";
                        }
           		}
           	},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    onLook: function() {                     //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var url = "glsfonLookView?id="+id;
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();
   			}else{
	   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
	   			}
	   		}else{
	   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
	   		}    
    },
    
    onAddClick: function() {            //缴费
    	var url = "glsfAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("管理部门收费登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onModifyClick: function() {    //编辑
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "glsfUpdateView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("编辑收费信息");
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
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
				               constructionGrid.store.reload();
			               },
			               failure: function(form, action) {
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除失败!" + BLANKSTR);
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

