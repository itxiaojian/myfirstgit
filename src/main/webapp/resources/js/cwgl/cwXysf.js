var USER_GRID_STORE_URL = 'getXysfList';
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
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[{name:'ID'},
                            {name:'XYBH'},{name:'KHMC'},{name:'KHDZ'},{name:'XYLX'},{name:'FRDB'},
                            {name:'LXDH'},{name:'CPMC'},{name:'FWXM'},{name:'SXRQ'},{name:'ZZRQ'},
                            {name:'XYKS_ID'},{name:'ZXBZ'},{name:'XYZY'},{name:'XYJE'},{name:'FKFS'},
                            {name:'BGBH'},{name:'QZQK'},{name:'XXQK'},{name:'XYFZR'},{name:'JYKS_ID'},
                            {name:'YWKS_ID'},{name:'SSKS_ID'},{name:'YSJE'},{name:'YSFJE'},{name:'SFRQ'},
                            {name:'BZ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,emptyText:'协议编号&客户名称...'},
               	'-','检验科室 ：',{xtype:'combo',id:'jyks',width: 170,emptyText:'请选择...',
                 	  mode: 'local',
          			  triggerAction: 'all',
          			  displayField:'BMMC',
          			  valueField:'BMBH',
                      store: new Ext.data.Store({
                      proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getJyks', method: 'POST'}),
                      reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                      autoLoad:true
                      }),
                      editable : false
                	  },
	        	  '-','业务科室 ：',{xtype:'combo',id:'ywks',width: 160,emptyText:'请选择...',
	             	  mode: 'local',
	      			  triggerAction: 'all',
	      			  displayField:'BMMC',
	      			  valueField:'BMBH',
	                  store: new Ext.data.Store({
	                  proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getYwks', method: 'POST'}),
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
		    	 			if(Ext.getCmp('jyks').getValue() != '') {
		    	 				params['jyks'] = Ext.getCmp('jyks').getValue();
		    	 			}
		    	 			if(Ext.getCmp('ywks').getValue() != '') {
		    	 				params['ywks'] = Ext.getCmp('ywks').getValue();
		    	 			}
		    	 			constructionGrid.store.baseParams= params;
		    	 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
      	   			    Ext.getCmp('jyks').setValue("");
      	   			    Ext.getCmp('ywks').setValue("");
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
                {header:'序号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                {header: '操作', width: 150, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
							if(record.get("XYJE") != record.get("YSFJE")){
							   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
							   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
							   		  "&nbsp&nbsp&nbsp"+
								   	  "<a href='javascript:;' onclick='constructionGrid.onSfei()' style='text-decoration:none;'>"+
								   	  "<span style='width: 26px;cursor: pointer;'>收费</span></a>"+
								   	  "&nbsp&nbsp&nbsp"+
								   	  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>"+
								   	  "<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>";
	            		      }else {
               			          return  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
			                              "<span style='width: 25px;color:gray;'>信息有误，请联系管理员</span></a>";
               		            }
					}
				},
                {header:'协议编号',dataIndex:'XYBH',width:100,sortable: true},
                {header:'客户名称',dataIndex:'KHMC',width:100,sortable: true},
                {header:'协议类型',dataIndex:'XYLX',width:100,sortable: true, hidden:true},
            	{header:'涉及产品名称',dataIndex:'CPMC',width:100,sortable: true,hidden:true},
            	{header:'服务项目',dataIndex:'FWXM',width:100,sortable: true,hidden:true},
            	{header:'协议科室',dataIndex:'XYKS_ID',width:100,sortable: true, hidden:true},
            	{header:'执行标准',dataIndex:'ZXBZ',width:100,sortable: true,hidden:true},
            	{header:'协议摘要',dataIndex:'XYZY',width:100,sortable: true,hidden:true},
            	{header:'检验科室',dataIndex:'JYKS_ID',width:150,sortable: true},
            	{header:'业务科室',dataIndex:'YWKS_ID',width:120,sortable: true},
            	{header:'协议金额（元）',dataIndex:'XYJE',width:100,sortable: true},
           	    {header:'付款方式',dataIndex:'FKFS',width:60,sortable: true,
            		renderer:function(value){
           			 if(value == '0') {
                            return "电汇";
                        }else if(value == '1'){
                      	  return "现金";
                        }
           		}
           	    },
           	    {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true, hidden:true},
           	    {header:'协议负责人',dataIndex:'XYFZR',width:100,sortable: true,hidden:true},
         	    {header:'已收金额（元）',dataIndex:'YSFJE',width:100,sortable: true},
         	    {header:'剩缴金额（元）',dataIndex:'YSJE',width:100,sortable: true},
         	    {header:'登记日期',dataIndex:'SFRQ',width:130,sortable: true},
           	    
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
   				var xybh=records[0].get('XYBH');
   				var url = "xysfonLookView?id="+id+"&xybh="+xybh;
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
    
    
    onSfei: function() {                         //收费
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var xybh=records[0].get('XYBH');
//   				alert(id);
				var url = "xysfonSfeiView?id="+id+"&xybh="+xybh;
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("协议缴费");
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
    	var valueStr1=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
	       		valueStr1.push(records[i].get('XYBH'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr,xybh: valueStr1},
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

