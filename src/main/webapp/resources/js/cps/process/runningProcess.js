//需要补充的空格
var BLANKSTR = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';   
var RUNNING_PROCESS_GRID_STORE_URL = 'runningProcess/list';
var PAGESIZE=20;

/**************************RunningProcessGrid*******************************************/
RunningProcessGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: RUNNING_PROCESS_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
            		{name:'taskId'},{name:'processDefinitionId'},{name:'processInstanceId'},{name:'name'},{name:'processStatus'},{name:'processFlag'},
            		{name:'taskDefinitionKey'},{name:'assignee'},{name:'owner'},{name:'priority'},{name:'processCode'},
            		{name:'createTime'},{name:'dueDate'},{name:'description'},{name:'ypbh'},{name:'ypmc'}
            		,{name:'wcqx'},{name:'jylx'},{name:'businessKey'},{name:'szcs'},{name:'wtdw'},{name:'lxr'}
            		,{name:'jyks'},{name:'ywks'},{name:'jyksbh'},{name:'ywksbh'},{name:'activityId'},{name:'startTime'},{name:'endTime'}
            ])
        });

    	this.vtbar = new Ext.Toolbar({
            items:[
            	{xtype:'label',text:'样品编号:'},{xtype:'textfield',id:'ypbh_query'},
            	'-',{xtype:'label',text:'样品名称:'},{xtype:'textfield',id:'ypmc_query'},
            	'-',{text:'查询',iconCls: 'query',handler:this.onQueryClick,scope:this},
            	'-',{text:'一键归档',iconCls: 'edit',handler:this.onModifyClick,scope:this}
            ]
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);

        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        RunningProcessGrid.superclass.constructor.call(this, {
        	renderTo:Ext.getBody(),
     //   	title: '运行中流程',
        	stripeRows: true,
            frame: false,
            height: height,
            width:width,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
      				{header:'processInstanceId',dataIndex:'processInstanceId',width:200,sortable: true,hidden:true},
    				{header:'样品编号',dataIndex:'ypbh',width:100,sortable: true},
    				{header:'样品名称',dataIndex:'ypmc',width:200,sortable: true},
    				{header:'完成期限',dataIndex:'wcqx',width:100,sortable: true},
    				{header:'检验类型',dataIndex:'jylx',width:100,sortable: true},
    				{header:'所在城市',dataIndex:'szcs',width:100,sortable: true},
    				{header:'委托单位',dataIndex:'wtdw',width:100,sortable: true},
    				{header:'联系人',dataIndex:'lxr',width:100,sortable: true},
    				{header:'检验科室',dataIndex:'jyks',width:100,sortable: true},
    				{header:'业务科室',dataIndex:'ywks',width:100,sortable: true},
    				{header:'开始时间',dataIndex:'startTime',width:140,sortable: true},
    				{header:'当前节点',dataIndex:'name',width:140,sortable: true,
	            		renderer:function(value, cellmeta, record){
	            			var activityId = record.data.activityId;
	            			if(activityId == null || activityId == "") {
	            				return "";
	            			}else if(value == null || value == "") {
	            				return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="runningProcessGrid.lookGraphTrace();">' + activityId + '</a>';
	            			}else {
	            				return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="runningProcessGrid.lookGraphTrace();">' + value + '</a>';
	            			}
	            		}
            	},
            	{header:'是否挂起',dataIndex:'suspensionState',width:80,sortable: true,hidden:true,
            		renderer:function(value, cellmeta, record){
            			if(value == false) {
                			return "<span style='color:green;font-weight:bold;'>正常</span>";
            			}else if(value == true) {
                			return "<span style='color:red;font-weight:bold;'>挂起</span>";
            			}else {
                			return value;
            			}
            		}
            	},
            	{header:'操作',dataIndex:'opt',width:60,sortable: true,hidden:true,
            		renderer:function(value, cellmeta, record){
            			var suspensionState = record.data.suspensionState;
            			if(suspensionState == true) {
            				return '<a class="redlink" href="javascript:void(0)" onclick="runningProcessGrid.activate();">激活</a>';
            			}else {
            				return '<a class="zlink" href="javascript:void(0)" onclick="runningProcessGrid.hangUp();">挂起</a>';
            			}
            		}
            	},
            	{header:'强制结束',dataIndex:'forceOver',width:60,sortable: true,
            		renderer:function(value, cellmeta, record){
            			return '<a class="zlink" href="javascript:void(0)" onclick="runningProcessGrid.forceOver();">强制结束</a>';
            		}
            	}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    activate: function() {//激活流程
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	Ext.Msg.confirm("提醒信息", "确定要激活流程实例【" + processInstanceId + "】吗？",function(btn){
			if (btn == 'yes') {
		       	Ext.Ajax.request({
			       	   url:'/cps/processXN/activateProcessInst',
			       	   method : 'POST', 
			       	   params: { processInstanceId: processInstanceId},
		               success: function(form, action) { 
			               Ext.MessageBox.alert("系统提示:", BLANKSTR + "激活成功!" + BLANKSTR);
			               runningProcessGrid.vbbar.doLoad(runningProcessGrid.vbbar.cursor);		               },
		               failure: function(form, action) {
		            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "激活失败!" + BLANKSTR);
		               }
			       	});					
			}
    	});	
    },
    hangUp: function() {//挂起流程
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	Ext.Msg.confirm("提醒信息", "确定要挂起流程实例【" + processInstanceId + "】吗？",function(btn){
			if (btn == 'yes') {
		       	Ext.Ajax.request({
			       	   url:'/cps/processXN/suspendProcessInst',
			       	   method : 'POST', 
			       	   params: { processInstanceId: processInstanceId},
		               success: function(form, action) { 
			               Ext.MessageBox.alert("系统提示:", BLANKSTR + "挂起成功!" + BLANKSTR);
			               runningProcessGrid.vbbar.doLoad(runningProcessGrid.vbbar.cursor);		               },
		               failure: function(form, action) {
		            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "挂起失败!" + BLANKSTR);
		               }
			       	});					
			}
    	});	
    },
    forceOver: function() {//强制结束流程
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	var ypbh = record.data.businessKey;
    	Ext.Msg.confirm("提醒信息", "确定要强制结束流程实例【" + processInstanceId + "】吗？",function(btn){
			if (btn == 'yes') {
		       	Ext.Ajax.request({
			       	   url:'forceOverProcess',
			       	   method : 'POST', 
			       	   params: { processInstanceId: processInstanceId,ypbh:ypbh},
		               success: function(form, action) { 
			               Ext.MessageBox.alert("系统提示:", BLANKSTR + "强制结束成功!" + BLANKSTR);
			               runningProcessGrid.vbbar.doLoad(runningProcessGrid.vbbar.cursor);		               
			           },
		               failure: function(form, action) {
		            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "强制结束失败!" + BLANKSTR);
		               }
			       	});					
			}
    	});	
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
    onQueryClick: function() {
		var ypbh = Ext.getCmp("ypbh_query").getValue();
		var ypmc = Ext.getCmp("ypmc_query").getValue();
		runningProcessGrid.store.baseParams = {ypbh:ypbh, ypmc:ypmc};
		runningProcessGrid.store.load({params:{start:0,limit:PAGESIZE}});
    },
    onModifyClick: function() {
		Ext.Msg.confirm('系统提示：',"确定要一键归档？",function(btn){
			if(btn == 'yes'){
				Ext.Ajax.request({
					url: 'zdgdTask',
					method: 'POST',
					success: function(){
						Ext.Msg.alert('系统提示','归档成功！');
						tlrDgStModelGrid.store.load({params:{start:0,limit:PAGESIZE}});
					},
					failure: function(){
						Ext.Msg.alert('系统提示','归档失败！');
					}
				});
			}
		});  	
    },
    
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
    },
    refresh: function(){
        this.getView().refresh();
    },
    remove:function(record){
        this.getStore().remove(record);
    }
});


/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';        //提示方式"side"
    
    runningProcessGrid = new RunningProcessGrid(Ext.getBody().getViewSize().height, Ext.getBody().getViewSize().width);
    runningProcessGrid.store.load({params:{start:0,limit:PAGESIZE}});  
});