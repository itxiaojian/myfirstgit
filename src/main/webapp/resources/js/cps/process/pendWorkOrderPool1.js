//需要补充的空格
var BLANKSTR = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';   
var PENDPOOL_GRID_STORE_URL = 'getPendPoolList';
//var PENDPOOL_GRID_STORE_URL = 'getPendPoolListCache';
var PAGESIZE=20;
//环节处理窗口全局变量
var ACT_DEAL_WINDOW;

/*****************************ImageSelectWindow***************
 *description   : 查看电子签名window
*************************************************************/
ImageSelectWindow = Ext.extend(Ext.Window, {
    constructor: function() {
    	this.imageSelectGrid = new ImageSelectGrid(); 	
    	ImageSelectWindow.superclass.constructor.call(this, {
    		title:'查看原始记录图片',
    		width: '100%',
    		height:'200%',
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.imageSelectGrid],
        	buttonAlign:'center',
	        buttons:[
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
    closeClick: function() {
    	this.hide();
    }
    
});

/*****************************ImageSelectGrid*****************
 *description   : 查看电子签名grid
*************************************************************/
ImageSelectGrid = Ext.extend(UxGrid, {
    store:null,
    constructor: function(height, width){

    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: "getImageList", method: 'POST'}),
            reader: new Ext.data.JsonReader({fields:[
                   {name:'YSJLWJM'},{name:'YSJLSJM'},{name:'YSJLLJ'}
            ]})
        });
    	
        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        ImageSelectGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: true,
            height: 515,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([
                {header:'',dataIndex:'YSJLSJM',width:1200,sortable: true,
            		renderer:function(data, metadata, record){
            			var srcurl = "/zjyw/"+record.data.YSJLLJ + "/" + record.data.YSJLSJM ;
            			return "<img height=100% width=100% src = '" + srcurl + "'></img>";
            		}
                },
            ]),
            ds: this.store
        });
    },
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
    }
});

/**************************PendPoolGrid*******************************************/
PendPoolGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({
//    		baseParams: {rolekind: ROLE_KIND},//Grid Store
            proxy: new Ext.data.HttpProxy({url: PENDPOOL_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
            		{name:'taskId'},{name:'ypcs'},{name:'processDefinitionId'},{name:'processInstanceId'},{name:'name'},
            		{name:'taskDefinitionKey'},{name:'assignee'},{name:'owner'},{name:'priority'},
            		{name:'createTime'},{name:'dueDate'},{name:'description'},{name:'id'},{name:'ypbh'},{name:'ypmc'}
            		,{name:'wcqx'},{name:'jylx'},{name:'businessKey'},{name:'szcs'},{name:'wtdw'},{name:'lxr'},{name:'zjy'}
            		,{name:'jyks'},{name:'ywks'},{name:'jyksbh'},{name:'ywksbh'},{name:'jyksmc'},{name:'ywksmc'},{name:'activityId'}
            		,{name:'bz'},{name:'ysjlsjm'},{name:'did'},{name:'jyfy'},{name:'ysfje'},{name:'jyjsrq'},{name:"qsr"},{name:"bzr"},
            		{name:"shr"},{name:"pzr"}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
				'-',{xtype:'textfield',id:'cxtj_query'},
				'-',{text:'查询',iconCls: 'query',handler:this.onQueryClick,scope:this},
				'-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
 						Ext.getCmp('cxtj_query').setValue("");
			  			}
					},
            ]
        });
    	imageSelectWindow = new ImageSelectWindow();
        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        PendPoolGrid.superclass.constructor.call(this, {
        	region:'center',
        	renderTo:Ext.getBody(),
        //	title: '待办任务列表',
        	stripeRows: true,
            frame: false,
            height: height,
            width:width,
            viewConfig: {
                forceFit: false,  
                getRowClass : function(record,rowIndex,rowParams,store){  
                    //禁用数据显示红色  
                    if(record.data.assignee == null || record.data.assignee == "" ){  
                        return 'x-grid-record-red';  
                    }else{  
                        return '';  
                    }                       
                } 
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
               {header:'操作',dataIndex:'assignee',width:150,sortable: true,
                    renderer:function(value, cellmeta, record){
                    	var str =null
                    	if(record.get("bz") == 1){
	                   		str= "<a href='javascript:;' onclick='pendPoolGrid.onTpClick()' style='text-decoration:none;'>点击查看原始记录</a>";
	                   	}else if(record.get("bz") == 2 || record.get("bz") == 3){
	                   		str= "<a href='javascript:;' onclick='pendPoolGrid.onBjiClick()' style='text-decoration:none;'>点击查看原始记录</a>";
	                   	}else{
	                   		str= "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
			                    "<span style='width: 25px;color:gray;'>暂未上传原始记录</span></a>";
	                   	}
                       if(value == null || value == "" ) {
                           return '<a class="zlink" href="javascript:void(0)" onclick="pendPoolGrid.signFor();">签收</a>&nbsp&nbsp&nbsp&nbsp'+str;
                       }else {
                           return '<a class="redlink" href="javascript:void(0)" onclick="pendPoolGrid.dealTask();">办理</a>&nbsp&nbsp&nbsp&nbsp'+str;
                       }
                    }
                },  
                {header:'原始记录文件名',dataIndex:'ysjlsjm',width:200,sortable: true,hidden:true},
                {header:'原始记录类型',dataIndex:'bz',width:200,sortable: true,hidden:true},
                {header:'原始记录id',dataIndex:'did',width:200,sortable: true,hidden:true},
                {header:'样品编号',dataIndex:'ypbh',width:100,sortable: true},
                {header:'样品名称',dataIndex:'ypmc',width:200,sortable: true},
                {header:'id',dataIndex:'id',width:200,sortable: true,hidden:true},
                {header:'完成期限',dataIndex:'wcqx',width:100,sortable: true},
                {header:'签收人',dataIndex:'qsr',width:100,sortable: true,
                	renderer:function(value, cellmeta, record){
            			if(record.get("ypcs") >=0){
            			      return value;
            				}else{
            				return "<span></span>";
            				}
            			}
                },
                {header:'编制人',dataIndex:'bzr',width:100,sortable: true,
                	renderer:function(value, cellmeta, record){
            			if(record.get("ypcs") >=2){
            			      return value;
            				}else{
            				return "<span></span>";
            				}
            			}	
                },
                {header:'审核人',dataIndex:'shr',width:100,sortable: true,
                	renderer:function(value, cellmeta, record){
            			if(record.get("ypcs") >=3){
            			      return value;
            				}else{
            				return "<span></span>";
            				}
            			}	
                },
                {header:'批准人',dataIndex:'pzr',width:100,sortable: true,
                	renderer:function(value, cellmeta, record){
            			if(record.get("ypcs") >=4){
            			      return value;
            				}else{
            				return "<span></span>";
            				}
            			}	
                },
                {header:'检验类型',dataIndex:'jylx',width:100,sortable: true},
                {header:'检验费用',dataIndex:'jyfy',width:80,sortable: true},
                {header:'已收费用',dataIndex:'ysfje',width:80,sortable: true},
                {header:'缴费日期',dataIndex:'jyjsrq',width:90,sortable: true},
                {header:'委托单位',dataIndex:'wtdw',width:100,sortable: true},
                {header:'联系人',dataIndex:'lxr',width:100,sortable: true},
                {header:'检验科室',dataIndex:'jyksmc',width:100,sortable: true},
                {header:'业务科室',dataIndex:'ywksmc',width:100,sortable: true},
/*            	{header:'流程实例ID',dataIndex:'processInstanceId',width:100,sortable: true},
            	{header:'优先级',dataIndex:'priority',width:60,sortable: true},*/
            	{header:'任务创建时间',dataIndex:'createTime',width:140,sortable: true},
            	{header:'当前节点',dataIndex:'name',width:140,sortable: true,
            		renderer:function(value, cellmeta, record){
            			var activityId = record.data.activityId;
            			var flag = record.data.processFlag;
            			return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="pendPoolGrid.lookGraphTrace();">' + value + '</a>';
            		}
            	}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    signFor: function() {//签收任务
    	var record = this.selectedRecord();
    	var taskId = record.data.taskId;
       	Ext.Ajax.request({
	       	url:'claimTask',
	       	method : 'POST', 
	       	params: { taskId: taskId},
            success: function(form, action) {
	             pendPoolGrid.store.load({params:{start:0,limit:PAGESIZE}});             
	        },
            failure: function(form, action) {
         	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "签收失败!" + BLANKSTR);
            }
	       	});	    	
    },
    onRefreshClick: function() {
    	pendPoolGrid.store.load({params:{start:0,limit:PAGESIZE}});  
    },
    onQueryClick: function() {
		var cxtj = Ext.getCmp("cxtj_query").getValue();
		var ypcs = YPCS;
		pendPoolGrid.store.baseParams = {cxtj:cxtj,ypcs:ypcs};
		pendPoolGrid.store.load({params:{start:0,limit:PAGESIZE}}); 
    },
    dealTask: function() {//处理任务
    	var record = this.selectedRecord();
    	var taskId = record.data.taskId;
    	var id = record.data.id;
    	var khqh = record.data.khqh;
    	var bkhr = record.data.bkhr;
    	var businessKey = record.data.businessKey;
    	var ypcs = record.data.ypcs;
    	var url = "openTaskDealPage/" + taskId + "/" + businessKey + "/" + ypcs;   	
    	html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
    	ACT_DEAL_WINDOW = new ActDealWindow();
    	ACT_DEAL_WINDOW.setTitle("");
    	ACT_DEAL_WINDOW.html = html;
    	ACT_DEAL_WINDOW.show();
    },
    lookGraphTrace : function() {//查看流程图
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	var bgbh = record.data.businessKey;
    	window.open("showProcessTrack?hisFlag=0&processInstanceId=" + processInstanceId+"&bgbh="+bgbh);
    },
    lookApproveTrace: function() {//查看申请信息及审批意见
    	var record = this.selectedRecord();
    	var businessKey = record.data.businessKey;
    	window.open("/cps/processXN/showProcessOption/" + businessKey);   
    },
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
    },
    onTpClick: function(){        //点击查看图片类型的原始记录
		var records=this.getSelectionModel().getSelections();
    	var id = records[0].get('did')
//    	alert(id);
		imageSelectWindow.show();
    	imageSelectWindow.imageSelectGrid.store.baseParams = {id:id};
    	imageSelectWindow.imageSelectGrid.store.load();
	},
	onBjiClick: function(){   //点击查看文档类型的原始记录
		var records = this.getSelectionModel().getSelections();
		var ysjlsjm=records[0].get('ysjlsjm');
		var bz=records[0].get('bz');
//		alert(ysjlsjm,bz);
		var url = "WordOnLine?ysjlsjm="+ysjlsjm+"&bz="+bz;
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("查看原始记录文档");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},
	
    
    refresh: function(){
        this.getView().refresh();
    },
    remove:function(record){
        this.getStore().remove(record);
    }
    
});

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

/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';        //提示方式"side"
    Ext.Ajax.timeout = 180000; //3分钟超时  
    
    pendPoolGrid = new PendPoolGrid(Ext.getBody().getViewSize().height, Ext.getBody().getViewSize().width);
    pendPoolGrid.store.baseParams = {ypcs:YPCS};
    pendPoolGrid.store.load({params:{start:0,limit:PAGESIZE}});  
});