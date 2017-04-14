var USER_GRID_STORE_URL = 'getBghzxx';
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
                            {name:'ID'},{name:'YPBH'},{name:'YPMC'},{name:'YPJYZT'},{name:'WCQX'},{name:'QSR'},
                            {name:'FPSJ'},{name:'BZR'},{name:'BZR1'},{name:'BSSJ'},{name:'SHR'},{name:'BPSJ'},
                            {name:'PZR'},{name:'PZR1'},{name:'PZSJ'},{name:'JSSJ'},{name:'GDSJ'},{name:'JYLX'},
                            {name:'GGXH'},{name:'SCRQPC'},{name:'YPZT'},{name:'YPSL'},{name:'WTDW'},{name:'SJDW'},
                            {name:'SCDW'},{name:'WTLXR'},{name:'SJHM'},{name:'JYYJ'},{name:'JYXM'},{name:'JYFY'},
                            {name:'YSFJE'},{name:'JYJSRQ'},{name:'DYRQ'},{name:'JYKS'},{name:'YWKS'},{name:'DJFY'},
                            {name:'DJLX'},{name:'DJSJ'},{name:'CYDW'},{name:'CYRY'},{name:'CYJS'},{name:'CYRQ'},
                            {name:'JYJL'},{name:'SB'},{name:'BZ'},  {name:'WJMC'},{name:'WCQX1'},{name:'PZSJ1'},
                            {name:'YPZT1'},{name:'RN'}
            ])
        });
    	var CurrentDate = new Date();
		CurrentDate.setDate(1);
		var lastDate = new Date();
		lastDate.setDate(lastDate.getDate());
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{xtype:'textfield',id:'canshu',width: 150, emptyText:'请输入检验依据',  },
				'-',{xtype:'label',text:'检验类型'},{xtype:'combo',id:'jylx',
			    	   editable: false,
			    	   store: new Ext.data.Store({
			                proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBghz/getZt', method: 'POST'}),
			                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'NAME'},{name:'CODE'}])),
			                autoLoad:true,
			            }),
                    displayField: 'NAME', //显示文本字段
                    valueField: 'CODE',//value值字段id
                    mode: 'local',
                    blankText:'请选择....',  
                    emptyText:'请选择....', 
                    triggerAction: 'all',
                    selectOnFocus: true,
                    typeAhead: true
		       		},
			       		'-',{xtype:'label',text:'登记开始日期'},{xtype:'datefield',format:'Y-m-d',id:'tjrqStr',editable : false,value:CurrentDate.format('Y-m-d')},
						'-',{xtype:'label',text:'登记结束日期'},{xtype:'datefield',format:'Y-m-d',id:'tjrqEnd',editable : false,value:lastDate.format('Y-m-d')},
    	  	            '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var jylx = Ext.getCmp('jylx').getValue();
      						var starttime = Ext.getCmp('tjrqStr').getValue();
      						var endtime = Ext.getCmp('tjrqEnd').getValue();
      						var canshu = Ext.getCmp('canshu').getValue();
      						var params = {};
    		       			params['jylx']=Ext.getCmp('jylx').getValue();
      						constructionGrid.store.baseParams= {starttime:starttime,endtime:endtime,jylx,canshu:canshu};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
          	   				Ext.getCmp('canshu').setValue("");
          	   			    Ext.getCmp('jylx').setValue("");
          	   			    Ext.getCmp('tjrqStr').setValue(CurrentDate.format('Y-m-d'));
          	   		        Ext.getCmp('tjrqEnd').setValue(lastDate.format('Y-m-d'));
             			  }
                      },
      				       '-',{xtype:'button',text:'汇总导出',iconCls:'add',handler:this.onHzClick,scope:this},
//      				       '-',{xtype:'button',text:'导出Excel',iconCls:'excel',handler:this.toExClick,scope:this}
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
            	{header:'样品编号',dataIndex:'YPBH',width:100,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:150,sortable: true},
            	{header:'规格型号',dataIndex:'GGXH',width:100,sortable: true},
            	{header:'检验类型',dataIndex:'JYLX',width:130,sortable: true},
            	{header:'编制人',dataIndex:'BZR',width:70,sortable: true},
            	{header:'检验依据',dataIndex:'JYYJ',width:220,sortable: true},
            	{header:'检验结论',dataIndex:'JYJL',width:250,sortable: true},
            	{header:'样品登记时间',dataIndex:'DJSJ',width:140,sortable: true},
            	{header:'委托单位',dataIndex:'WTDW',width:200,sortable: true},
            	{header:'受检单位',dataIndex:'SJDW',width:200,sortable: true},
            	{header:'生产单位',dataIndex:'SCDW',width:200,sortable: true},
            	{header:'报审时间',dataIndex:'BSSJ',width:150,sortable: true, hidden:true},
            	{header:'完成期限',dataIndex:'WCQX',width:130,sortable: true, hidden:true},
                {header:'检验状态',dataIndex:'YPJYZT',width:80,sortable: true, hidden:true},
                {header:'检验状态',dataIndex:'YPZT1',width:80,sortable: true,hidden:true},
            	{header:'签收人',dataIndex:'QSR',width:100,sortable: true, hidden:true},
            	{header:'分配时间',dataIndex:'FPSJ',width:100,sortable: true, hidden:true},
            	{header:'审核人',dataIndex:'SHR',width:100,sortable: true, hidden:true},
            	{header:'报批时间',dataIndex:'BPSJ',width:100,sortable: true, hidden:true},
            	{header:'批准人',dataIndex:'PZR',width:100,sortable: true, hidden:true},
            	{header:'批准时间',dataIndex:'PZSJ',width:100,sortable: true, hidden:true},
            	{header:'接收时间',dataIndex:'JSSJ',width:100,sortable: true, hidden:true},
            	{header:'归档时间',dataIndex:'GDSJ',width:100,sortable: true, hidden:true},
            	{header:'生产日期/批次',dataIndex:'SCRQPC',width:100,sortable: true, hidden:true},
            	{header:'样品状态',dataIndex:'YPZT',width:100,sortable: true, hidden:true},
            	{header:'样品数量',dataIndex:'YPSL',width:100,sortable: true, hidden:true},
            	{header:'委托联系人',dataIndex:'WTLXR',width:100,sortable: true, hidden:true},
            	{header:'手机号码',dataIndex:'SJHM',width:100,sortable: true, hidden:true},
            	{header:'检验项目',dataIndex:'JYXM',width:100,sortable: true, hidden:true},
            	{header:'检验费用',dataIndex:'JYFY',width:100,sortable: true, hidden:true},
            	{header:'已缴金额',dataIndex:'YSFJE',width:100,sortable: true, hidden:true},
            	{header:'缴费日期',dataIndex:'JYJSRQ',width:100,sortable: true, hidden:true},
            	{header:'到样日期',dataIndex:'DYRQ',width:100,sortable: true, hidden:true},
            	{header:'检验科室',dataIndex:'JYKS',width:100,sortable: true, hidden:true},
            	{header:'业务科室',dataIndex:'YWKS',width:100,sortable: true, hidden:true},
            	{header:'样品登记人员',dataIndex:'DJFY',width:100,sortable: true, hidden:true},
            	{header:'登记类型',dataIndex:'DJLX',width:100,sortable: true, hidden:true},
            	{header:'抽样单位',dataIndex:'CYDW',width:100,sortable: true, hidden:true},
            	{header:'抽样人员',dataIndex:'CYRY',width:100,sortable: true, hidden:true},
            	{header:'抽样基数',dataIndex:'CYJS',width:100,sortable: true, hidden:true},
            	{header:'抽样日期',dataIndex:'CYRQ',width:100,sortable: true, hidden:true},
            	{header:'商标',dataIndex:'SB',width:100,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true, hidden:true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onHzClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			var valueStr=[];
   		       	for(var i=0;i<records.length;i++){
   		       		valueStr.push(records[i].get('YPBH'));
   	    	 	}/*else{
   				Ext.Msg.alert('系统提示', '不能查看多条记录..');
   			}*/
   		     var valueStr1=[];
		       	for(var i=0;i<records.length;i++){
		       		valueStr1.push(records[i].get('YPZT1'));
	    	 	}
   		     Ext.Msg.confirm("提醒信息", "确定要汇总导出这 " + records.length + " 条信息吗",function(btn){
 				if (btn == 'yes') {
 			       	Ext.Ajax.request({
 			       		url: PROJECT_NAME + '/jygl/YjyBghz/getBgfyxx', 
 				       	   method : 'POST', 
 				       	   params: { ids:valueStr,ypzt:valueStr1},
 			               success: function(form, action) {
 			            	   if(form.responseText=='2'){
 			            		   alert("存在未生成的报告附页!");
 			            		   return false;
 			            	   }else{
 			            	      	Ext.Ajax.request({
 			    			       		url: PROJECT_NAME + '/jygl/YjyBghz/tobghz', 
 			    				       	   method : 'POST', 
 			    				       	   params: { ids:valueStr,ypzt:valueStr1},
 			    			               success: function(form, action) {
 			    			            	  console.log(form);
 			    			            	// window.open(PROJECT_NAME+"/resources/jyhz/"+form.responseText);
	 			    			            	Ext.Ajax.request({
	 		 			            	      		url: PROJECT_NAME + '/jygl/YjyBghz/toexcelBgfyxx', 
	 		 			            	      		method : 'POST', 
	 		 			            	      		params: {},
	 		 			            	      		success: function(form, action) {
	 		 			            	      			console.log(form);
	 		 			            	      			if(form.responseText!='0'){
	 		 			            	      				window.open(PROJECT_NAME+"/resources/jyhz/"+form.responseText);
	 		 			            	      			}else{alert("无Excel信息!")}
	 		 			            	      		},
	 		 			            	      		failure: function(form, action) {
	 		 			            	      			Ext.MessageBox.alert("系统提示:", BLANKSTR + "汇总失败!" + BLANKSTR);
	 		 			            	      		}
	 		 			            	      	});
	 			    			            	Ext.MessageBox.alert("系统提示:", BLANKSTR + "汇总导出成功!" + BLANKSTR);
 			    			               },
 			    			               failure: function(form, action) {
 			    			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "汇总导出失败!" + BLANKSTR);
 			    			               }
 			    				       	});	
 			            	// Ext.MessageBox.alert("系统提示:", BLANKSTR + "汇总成功!" + BLANKSTR);
 			            	// window.open(PROJECT_NAME+"/resources/jyhz/"+form.responseText);
 			            	   }
 			               },
 			               failure: function(form, action) {
 			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "汇总导出失败!" + BLANKSTR);
 			               }
 				       	});					
 				    }
 	    	});	
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	   	
    },
    toExClick: function() {//导出
		     Ext.Msg.confirm("提醒信息", "确定导出Excel吗",function(btn){
	 				if (btn == 'yes') {
	 			       	Ext.Ajax.request({
	 			       		url: PROJECT_NAME + '/jygl/YjyBghz/toexcelBgfyxx', 
	 				       	   method : 'POST', 
	 				       	   params: {},
	 			               success: function(form, action) {
	 			            	 console.log(form);
	 			            	 if(form.responseText!='0'){
	 			            		 window.open(PROJECT_NAME+"/resources/jyhz/"+form.responseText);
	 			            	 }else{alert("无Excel信息!")}
	 			               },
	 			               failure: function(form, action) {
	 			            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "导出失败!" + BLANKSTR);
	 			               }
	 				       	});					
	 				    }
	 	    	});	
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