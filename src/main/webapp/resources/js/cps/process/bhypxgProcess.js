var INVOLVED_PROCESS_GRID_STORE_URL = 'bhypxgProcess/list';
var PAGESIZE=20;
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

/**************************InvolvedProcessGrid*******************************************/
InvolvedProcessGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({url: INVOLVED_PROCESS_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
            		{name:'taskId'},{name:'processDefinitionId'},{name:'processInstanceId'},{name:'name'},
            		{name:'taskDefinitionKey'},{name:'assignee'},{name:'owner'},{name:'priority'},{name:'ypid'},
            		{name:'createTime'},{name:'dueDate'},{name:'description'},{name:'ypbh'},{name:'ypmc'},{name:'djlx'}
            		,{name:'wcqx'},{name:'jylx'},{name:'businessKey'},{name:'szcs'},{name:'wtdw'},{name:'lxr'}
            		,{name:'jyks'},{name:'ywks'},{name:'jyksbh'},{name:'ywksbh'},{name:'activityId'},{name:'startTime'},{name:'endTime'}
            ])
        });
//    	this.vtbar = new Ext.Toolbar({
//            items:[
//            	{xtype:'label',text:'样品编号:'},{xtype:'textfield',id:'ypbh_query'},
//            	'-',{xtype:'label',text:'样品名称:'},{xtype:'textfield',id:'ymmc_query'},
//            	'-',{text:'查询',iconCls: 'query',handler:this.onQueryClick,scope:this}
//            ]
//        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);

        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        InvolvedProcessGrid.superclass.constructor.call(this, {
        	renderTo:Ext.getBody(),
        //	title: '已处理流程',
        	stripeRows: true,
            frame: false,
            height: height,
            width:width,
            viewConfig: {
                forceFit: false,  
                getRowClass : function(record,rowIndex,rowParams,store){  
                    //禁用数据显示红色  
                    if(record.data.processFlag == "0"){  
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
              {header:'processInstanceId',dataIndex:'processInstanceId',width:200,sortable: true,hidden:true},
              {header:'操作',dataIndex:'asd',width:100,sortable: true,
            	  renderer:function(value, cellmeta, record){
            		  return "<a class='redlink' title='驳回样品修改' href='javascript:void(0)' onclick='involvedProcessGrid.rwch();'>处理</a>";
            	  }
              },
              {header:'样品ID',dataIndex:'ypid',width:100,sortable: true,hidden:true},
			  {header:'样品编号',dataIndex:'ypbh',width:100,sortable: true},
			  {header:'登记类型',dataIndex:'djlx',width:100,sortable: true,hidden:true},
			  {header:'taskId',dataIndex:'taskId',width:100,sortable: true,hidden:true},
			  {header:'样品名称',dataIndex:'ypmc',width:200,sortable: true},
			  {header:'完成期限',dataIndex:'wcqx',width:100,sortable: true},
			  {header:'检验类型',dataIndex:'jylx',width:100,sortable: true},
			  {header:'所在城市',dataIndex:'szcs',width:100,sortable: true},
			  {header:'委托单位',dataIndex:'wtdw',width:100,sortable: true},
			  {header:'联系人',dataIndex:'lxr',width:100,sortable: true},
			  {header:'检验科室',dataIndex:'jyks',width:150,sortable: true},
			  {header:'业务科室',dataIndex:'ywks',width:150,sortable: true},
			  {header:'开始时间',dataIndex:'startTime',width:140,sortable: true},
	          {header:'结束时间',dataIndex:'endTime',width:140,sortable: true},
              {header:'当前节点',dataIndex:'name',width:140,sortable: true,
            		renderer:function(value, cellmeta, record){
            			var activityId = record.data.activityId;
            			var flag = record.data.processFlag;
            			if(activityId == null || activityId == "") {
            				if(flag == 0){
                				return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="involvedProcessGrid.lookGraphTrace();">查看会签流程</a>';
            				}else{
            					return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="involvedProcessGrid.lookHisGraphTrace();">流程已结束</a>';
            				}
            			}else {
            				return '<a class="redlink" title="点击查看流程图" href="javascript:void(0)" onclick="involvedProcessGrid.lookGraphTrace();">' + value + '</a>';
            			}
            		}
            	}           	
            ]),
//            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store
        });
    },
    rwch: function() {
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ypid'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要处理这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: PROJECT_NAME + '/cps/deal/dealYWQTDJXGAct', 
				       	   method : 'POST', 
				       	   params: { id: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理成功!" + BLANKSTR);
				               involvedProcessGrid.store.reload();
			               },
			               failure: function(form, action) {
			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "处理失败!" + BLANKSTR);
			               }
				       	});					
				}
	    	});	
    	}
    },
    bgxx : function(){//预览报告信息
    	var record = this.selectedRecord();
    	var bgbh = record.data.ypbh;
    	window.open("ylbg?bgbh="+bgbh);
    },
    lookGraphTrace : function() {//查看流程图
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	var bgbh = record.data.businessKey;
    	window.open("showProcessTrack?hisFlag=0&processInstanceId=" + processInstanceId+"&bgbh="+bgbh);
    },
    lookHisGraphTrace : function() {//查看历史流程图
    	var record = this.selectedRecord();
    	var processInstanceId = record.data.processInstanceId;
    	var bgbh = record.data.businessKey;
    	window.open("showProcessTrack?hisFlag=1&processInstanceId=" + processInstanceId+"&bgbh="+bgbh);
    },
    onQueryClick: function() {
		var bkhr = Ext.getCmp("ypbh_query").getValue();
		var khqh = Ext.getCmp("ypmc_query").getValue();
		involvedProcessGrid.store.baseParams = {bkhr:bkhr, khqh:khqh};
		involvedProcessGrid.store.load({params:{start:0,limit:PAGESIZE}});
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
    showModelDialog: function(page,width,height){//用A4纸大小打开窗口
        var re= window.showModalDialog(page,null,'dialogWidth:'+width+'mm;dialogHeight:'+height+'mm;edge:Raised;center:yes;help:no;resizable:no;status:no;scroll:yes')
        if(re==1){
            window.location.reload();
        }
    }
});


/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';        //提示方式"side"
    
    involvedProcessGrid = new InvolvedProcessGrid(Ext.getBody().getViewSize().height, Ext.getBody().getViewSize().width);
    involvedProcessGrid.store.load({params:{start:0,limit:PAGESIZE}});  
});