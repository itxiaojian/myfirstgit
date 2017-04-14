//需要补充的空格
var BLANKSTR = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';   
var HISTORY_PROCESS_GRID_STORE_URL = 'historyProcess/list';
var PAGESIZE=20;

/**************************HistoryProcessGrid*******************************************/
HistoryProcessGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: HISTORY_PROCESS_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
           		{name:'taskId'},{name:'processDefinitionId'},{name:'processInstanceId'},{name:'name'},
        		{name:'taskDefinitionKey'},{name:'assignee'},{name:'owner'},{name:'priority'},
        		{name:'createTime'},{name:'dueDate'},{name:'description'},{name:'ypbh'},{name:'ypmc'}
        		,{name:'yplx'},{name:'jylx'},{name:'businessKey'},{name:'szcs'},{name:'wtdw'},{name:'lxr'},{name:'priority'}
        		,{name:'jyks'},{name:'ywks'},{name:'jyksbh'},{name:'ywksbh'},{name:'activityId'},{name:'startTime'}
        		,{name:'endTime'},{name:'jyksmc'},{name:'ywksmc'}
            ])
        });

    	this.vtbar = new Ext.Toolbar({
            items:[
					{xtype:'label',text:'样品编号:'},{xtype:'textfield',id:'ypbh_query'},
					'-',{xtype:'label',text:'样品类型:'},{xtype:'textfield',id:'yplx_query'},
					'-',{text:'查询',iconCls: 'query',handler:this.onQueryClick,scope:this}            
				]
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);

        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        HistoryProcessGrid.superclass.constructor.call(this, {
        	renderTo:Ext.getBody(),
        	//title: '历史流程',
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
				{header:'样品编号',dataIndex:'ypbh',width:100,sortable: true},
				{header:'样品名称',dataIndex:'ypmc',width:200,sortable: true,hidden:true},
				{header:'样品类型',dataIndex:'yplx',width:200,sortable: true},
				{header:'检验类型',dataIndex:'jylx',width:100,sortable: true},
				{header:'所在城市',dataIndex:'szcs',width:100,sortable: true},
				{header:'委托单位',dataIndex:'wtdw',width:100,sortable: true},
				{header:'联系人',dataIndex:'lxr',width:100,sortable: true},
				{header:'检验科室',dataIndex:'jyksmc',width:100,sortable: true},
				{header:'业务科室',dataIndex:'ywksmc',width:100,sortable: true},
				{header:'流程实例ID',dataIndex:'processInstanceId',width:100,sortable: true,
            		renderer:function(value, cellmeta, record){
            			return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="historyProcessGrid.lookGraphTrace();">' + value + '</a>';
            		}
                },
                {header:'流程启动时间',dataIndex:'startTime',width:140,sortable: true},
            	{header:'流程定义ID',dataIndex:'processDefinitionId',width:180,sortable: true, hidden:true},
            	{header:'流程结束时间',dataIndex:'endTime',width:140,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    lookGraphTrace : function() {//查看流程图
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	var bgbh = record.data.businessKey;
    	window.open("showProcessTrack?hisFlag=1&processInstanceId=" + processInstanceId+"&bgbh="+bgbh);	
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
    },
    lookApproveTrace: function() {//查看申请信息及审批意见
    	var record = this.selectedRecord();
    	var businessKey = record.data.businessKey;
    	window.open("showProcessOption/" + businessKey);   
    },
    onQueryClick: function() {
		var ypbh = Ext.getCmp("ypbh_query").getValue();
		var yplx = Ext.getCmp("yplx_query").getValue();
		historyProcessGrid.store.baseParams = {ypbh:ypbh, yplx:yplx};
		historyProcessGrid.store.load({params:{start:0,limit:PAGESIZE}});
    },
});


/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';        //提示方式"side"
    
    historyProcessGrid = new HistoryProcessGrid(Ext.getBody().getViewSize().height, Ext.getBody().getViewSize().width);
    historyProcessGrid.store.load({params:{start:0,limit:PAGESIZE}});  
});