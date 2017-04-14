var USER_GRID_STORE_URL = 'getBgjs';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

var ewmWindow;

/***************************************BgyqForm组件**************************************************/
BgyqForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
		this.bgbh = this.createTextField('报告编号','bgbh','95%','',null,100,'长度超过不能100');
        this.bgbh.readOnly = true;
        
        this.bgmc = this.createTextField('报告名称','bgmc','95%','',null,100,'长度超过不能100');
        this.bgmc.allowBlank = true;
        this.bgmc.readOnly = true;
        
        this.bzrxm = this.createTextField('编制人','bzr','95%','',null,100,'长度超过不能100');
        this.bzrxm.allowBlank = true;
        this.bzrxm.readOnly = true;
        
        this.jsdw = this.createTextField('接收单位','jsdw','95%','',null,100,'长度超过不能100');
        this.jsdw.allowBlank = true;
        this.jsdw.readOnly = true;
        
        this.wcqx = this.createDateField('到期日期','wcqx','Y-m-d','95%');
		this.wcqx.value = new Date().format('Y-m-d');
		this.wcqx.allowBlank = true;
		this.wcqx.readOnly = true;
		
		this.zxwcqx = this.createDateField('<font color="red">*</font>延期日期','zxwcqx','Y-m-d','95%');
		this.zxwcqx.value = new Date().format('Y-m-d');
		this.zxwcqx.allowBlank = false;

		BgyqForm.superclass.constructor.call(this, {
        	anchor: '100%',
        	autoHeight:true,
        	layout:"tableform",
        	layoutConfig: {columns: 2},
        	labelWidth: 90,
            labelAlign :'right',
            frame:true,
            bodyStyle:"padding: 5px 5px 0",
            width: '100%',
            items: [
            	this.bgbh,
            	this.bgmc,
            	this.bzrxm,
            	this.jsdw,
            	this.wcqx,
            	this.zxwcqx
            ],
            buttonAlign :'center',
            buttons: [
				{text: '保存', width: 20,iconCls: 'save', hidden: false, handler: this.addFormClick, scope: this},  
				{text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
            ]
        });
     },
     addFormClick: function() {
         if(this.getForm().isValid()) {
        	if(this.zxwcqx.value<=this.wcqx.value){
        		Ext.MessageBox.alert("系统提示:", "延期日期必须大于到期日期！");
        		return false;
        	}
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: 'saveYqjl',   
                 method: 'POST',
                 success: function(form, action) {
           		 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
           		 	constructionGrid.bgyqWindow.hide();
           		 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:",BLANKSTR + "添加失败!" + BLANKSTR);
                 }
         	});
         }
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/***************************************BgyqWindow组件**************************************************/
BgyqWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new BgyqForm();
        
        BgyqWindow.superclass.constructor.call(this, {
            title: "报告延期信息",
            width: 600,
            anchor: '100%',
            autoHeight:true,
            constrainHeader:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionForm]
        });
    }
});

/***************************************YqckGrid组件**************************************************/
YqckGrid = Ext.extend(UxGrid, {
	BgyqWindow:null,
	pageSizeCombo: PAGESIZE,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    module_name:null,
    type_name:null,
    constructor: function(height, width){
    	var thiz = this;
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: "getYqjlList", method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},
            [
            		{name:'ID'}, {name:'BGBH'}, {name:'WCQX'}, {name:'ZXWCQX'}, {name:'XGSJ'},
		            {name:'XGR'}, {name:'XGRXM'}, {name:'BZ'}, {name:'BGMC'}
            ])
        });

    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        YqckGrid.superclass.constructor.call(this, {
        	region:'center',
        	title: '报告延期信息',
        	stripeRows: true,
            frame: true,
            height: 300,
            width :width,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
                {header:'id', width: 150, dataIndex: 'ID', hidden: true},
	            {header:'报告编号', width: 100, dataIndex: 'BGBH', sortable: true,hidden: false},
	            {header:'报告名称',dataIndex:'BGMC',width:100,sortable:true,hidden:false},
	            {header:'完成期限',dataIndex:'WCQX',width:100,sortable:true,hidden:false},
	            {header:'延期期限',dataIndex:'ZXWCQX',width:100,sortable:true,hidden:false},
	            {header:'修改时间',dataIndex:'XGSJ',width:100,sortable:true,hidden:false},
	            {header:'修改人',dataIndex:'XGRXM',width:100,sortable:true,hidden:false},
	            {header:'备注',dataIndex:'BZ',width:100,sortable:true,hidden:false}
            ]),
            bbar: this.vbbar,
            ds: this.store
        });
    }
});

/***************************************YqckWindow组件**************************************************/
YqckWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new YqckGrid();
        
        YqckWindow.superclass.constructor.call(this, {
            title: "报告延期信息",
            width: 600,
            anchor: '100%',
            autoHeight:true,
            constrainHeader:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionForm]
        });
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
                            {name:'ID'},{name:'BGBH'},{name:'BGMC'},{name:'JYRQ'},{name:'BZR'},{name:'YPMC'},
                            {name:'JSDW1'},{name:'JSR'},{name:'FFRQ'},{name:'FFZT'},{name:'TJRQ'},{name:'TJYY'},{name:'TJR'},{name:'EWMBH'},{name:'EWMTP'},
                            {name:'BZ'},{name:'BZFS'},{name:'JYJL'},{name:'RZFS'},{name:'BSDX'},{name:'CYDW'},{name:'WCQX'},{name:'SFJS'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//					{text:'查看二维码',iconCls: 'edit',handler:this.onBqClick,scope:this},
//            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
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
        
        this.bgyqWindow = new BgyqWindow();
        this.yqckWindow = new YqckWindow();
        
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
					   return "<a href='javascript:;' onclick='constructionGrid.onBgjs()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>报告解锁</span></a>";
					}
            	},
                {header:'报告编号',dataIndex:'BGBH',width:100,sortable: true},
//                {header:'是否解锁',dataIndex:'SFJS',width:100,sortable: true},
            	{header:'报告名称',dataIndex:'BGMC',width:100,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:200,sortable: true},
            	{header:'检验日期',dataIndex:'JYRQ',width:100,sortable: true},
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
            	{header:'备注',dataIndex:'BZ',width:100,sortable: true}
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onBgjs: function() {                  //报告解锁
    	var records=this.getSelectionModel().getSelections();
    	vrecord = records[0];
		var id=records[0].get('ID');
		var url = "Bgjs?id="+id;  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("报告解锁");
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
			       		url: PROJECT_NAME + '/jygl/YjyBGxx/delete', 
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