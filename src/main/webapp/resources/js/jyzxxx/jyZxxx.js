var USER_GRID_STORE_URL = 'getZxxxList';
var ENTITY_URL_UPLOAD = 'upload';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/**************************QueryForm查询条件*******************************************/
QueryForm = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		this.ksbh = new Ext.form.ComboBox({
			id:'ksbh',
        	autoLoad: true,
            fieldLabel: '科室名称',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'BMMC',
			valueField:'BMBH',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getKsmc', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.cpbh = new Ext.form.TextField({
            fieldLabel: '产品编号',
            xtype: 'textfield',
            id: 'cpbh',
            readOnly: false,
            anchor: '100%',
        });
        this.cpmc = new Ext.form.TextField({
            fieldLabel: '产品名称',
            xtype: 'textfield',
            id: 'cpmc',
            readOnly: false,
            anchor: '100%',
        });
        
        this.cplx = new Ext.form.ComboBox({
			id:'cplx',
        	autoLoad: true,
            fieldLabel: '产品类型',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDMC',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getCplx', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDMC'}])),
                autoLoad:true
            }),
            editable : false
        });
        
		this.jyyj = new Ext.form.TextField({
            fieldLabel: '检验依据',
            xtype: 'textfield',
            id: 'jyyj',
            readOnly: false,
            anchor: '100%',
        });
        
        QueryForm.superclass.constructor.call(this, {
        	region: 'north',
	            anchor: '80%',
	            autoHeight:true,
	            labelWidth: 60,
	            labelAlign :'right',
	            frame: true,
	            bodyStyle:"padding: 2px 2px 0",
	            layout: 'tableform',
	            layoutConfig: {columns: 6},
	            items:[
						this.ksbh,
						this.cpbh,
						this.cpmc,
						this.cplx,
						this.jyyj
	            ],
	            buttonAlign :'center',
	            buttons: [
	               {text: '查询', width: 20,iconCls: 'query', hidden: false,handler:this.queryFormClick,scope:this},
	               {text: '重置', width: 20, iconCls:'refresh',  handler: this.resetFormClick, scope: this},
	               //{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:this.exportClick,scope:this}
	            ]
	        });
	},
	queryFormClick: function(){
  	   var params = {};
 			if(Ext.getCmp('ksbh').getValue() != ''){
 				params['ksbh'] = Ext.getCmp('ksbh').getValue();
 			}
 			if(Ext.getCmp('cpbh').getValue() != ''){
 				params['cpbh'] = Ext.getCmp('cpbh').getValue();
 			}
 			if(Ext.getCmp('cpmc').getValue() != ''){
 				params['cpmc'] = Ext.getCmp('cpmc').getValue();
 			}
 			if(Ext.getCmp('cplx').getValue() != ''){
 				params['cplx'] = Ext.getCmp('cplx').getValue();
 			}
 			if(Ext.getCmp('jyyj').getValue() != ''){
 				params['jyyj'] = Ext.getCmp('jyyj').getValue();
 			}
 			constructionGrid.store.baseParams= params;
 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	},
	resetFormClick: function(){
		Ext.getCmp('ksbh').setValue('');
		Ext.getCmp('cpbh').setValue('');
		Ext.getCmp('cpmc').setValue('');
		Ext.getCmp('cplx').setValue('');
		Ext.getCmp('jyyj').setValue('');
	},
	
	exportClick:function(){
   		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
    	    if(btn=="yes"){ 		        	    	
    	    	var fileName = new Date() + "导出成本信息";
    	    	var code = Ext.getCmp('ypmc').getValue();
    	    	var url = PROJECT_NAME + "/ypgl/YYpYpxx/export?fileName="+fileName+"&code="+code;
    	    	url = encodeURI(url);
    	    	url = encodeURI(url);
    	    	window.open(url);
    	   }
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

/********************IpasAssobjBankmemberUploadWindow组件*************************/
IpasAssobjBankmemberUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.ipasAssobjBankmember = new IpasAssobjBankmemberUpload();
		IpasAssobjBankmemberUploadWindow.superclass.constructor.call(this, {
			title: '导入检验咨询信息EXCEL数据',
			width: 600,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
			items: [this.ipasAssobjBankmember]
		});
	}
});

/********************IpasAssobjBankmemberUpload组件*************************/
IpasAssobjBankmemberUpload = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		this.fibasic = new Ext.ux.form.FileUploadField({
			 name: 'fileData',
			 id: 'form-file',
            emptyText: '例:XXX.xlsx',
            fieldLabel: '导入文件',
	        width: 400
	    });
		IpasAssobjBankmemberUpload.superclass.constructor.call(this, {
			anchor: '100%',
			fileUpload: true,
			autoHeight:true,
			labelWidth: 90,
			labelAlign :'right',
			frame: true,
			bodyStyle:"padding: 5px 5px 0",
			layout: 'tableform',
			layoutConfig: {columns: 2},
			items:[
			       this.fibasic
			       ],
			       buttonAlign :'center',
			       buttons: [
			                 {text: '上传', width: 20,iconCls:'save', handler: this.onUploadClick, scope: this},
			                 {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
			                ]
		});
	},
	onUploadClick: function(){
		if(this.getForm().isValid()){
			if(this.fibasic.getValue()==null || this.fibasic.getValue()==''){
				Ext.MessageBox.alert("系统提示：","请选择文件！");
				return false;
			}
			this.getForm().submit({
				waitMsg: '正在提交，请稍后...',
				url: ENTITY_URL_UPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					constructionGrid.ipasAssobjBankmemberUploadWindow.hide();
				},
				failure: function(form, action){
					escape="false",
					alert(encodeURI(encodeURI(action.result.message)));
					Ext.MessageBox.alert("系统提示：",encodeURI(encodeURI(action.result.message)) );
				}
			});
		}
	},
	//关闭
	onCloseClick: function(){
		constructionGrid.ipasAssobjBankmemberUploadWindow.ipasAssobjBankmember.getForm().reset();
		this.ownerCt.hide();
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
                            {name:'ID'},{name:'CPMC'},{name:'JYYJ'},{name:'JYXMBH'},{name:'JCXM'},{name:'CPBH'},
                            {name:'DYBZTKH'},{name:'GGXH'},{name:'YPSL'},{name:'JCFY'},{name:'JYZQ'},{name:'KSBH'},
                            {name:'YZZ'},{name:'GPZZ'},{name:'GJZZ'},{name:'YSPZZ'},{name:'HJYQ'},{name:'CPLX'},
                            {name:'SBBH'},{name:'SBMC'},{name:'RY'},{name:'BZ'},{name:'BZ1'},{name:'YZZRD'},{name:'XGR'},
                            {name:'XGSJ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'新增',iconCls: 'add',handler:this.onAddClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
//                '-',{xtype:'textfield',id:'code',width: 150,
//                	   emptyText:'产品编号&产品名称...',  
//               	    },
//    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
//      						var code = Ext.getCmp('code').getValue();
//      						constructionGrid.store.baseParams= {code:code};
//      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
//      				    }
//               	    },
//               	'-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
//      	   				Ext.getCmp('code').setValue("");
//         			  }
//                    },
                '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
     		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
    		        	    if(btn=="yes"){ 
    		        	    	window.open(PROJECT_NAME+"/resources/js/jyzxxx/Zxxx.xlsx");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		    '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                '-',{xtype:'button',text:'导出数据',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定导出数据吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "检验咨询信息";
			        	    	var ksbh = Ext.getCmp('ksbh').getValue();
			        	    	var cpbh = Ext.getCmp('cpbh').getValue();
			        	    	var cpmc = Ext.getCmp('cpmc').getValue();
			        	    	var cplx = Ext.getCmp('cplx').getValue();
			        	    	var jyyj = Ext.getCmp('jyyj').getValue();
			        	    	var url = PROJECT_NAME + "/jyzxxx/YJyZxxx/export?fileName="+fileName+"&ksbh="+ksbh+"&cpbh="+cpbh+"&cpmc="+cpmc+"&cplx="+cplx+"&jyyj="+jyyj;
			        	    	url = encodeURI(url);
			        	    	url = encodeURI(url);
			        	    	window.open(url);
			        	   }
			        	 });
	   		    		}
    		        }
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
//                {header:'序号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                {header: '操作', width: 220, align:"center",sortable: true,hidden: false,
  					renderer:function(value, cellmeta, record){
  						return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
  				   		  "<span style='width: 26px;cursor: pointer;'>项目查看</span></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
  						  "<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
  						  "<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp;&nbsp;"+
  						  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
  						  "<span style='width: 25px;color:red;'>删除</span></a>";
              		}
  				},
                {header:'科室名称',dataIndex:'KSBH',width:150,sortable: true},
                {header:'产品编号',dataIndex:'CPBH',width:100,sortable: true},
                {header:'产品名称',dataIndex:'CPMC',width:120,sortable: true},
                {header:'产品类型',dataIndex:'CPLX',width:120,sortable: true},
//                {header:'规格型号',dataIndex:'GGXH',width:100,sortable: true, hidden:true},
//            	{header:'样品数量',dataIndex:'YPSL',width:100,sortable: true, hidden:true},
                {header:'检验依据',dataIndex:'JYYJ',width:120,sortable: true},
                {header:'是否批准',dataIndex:'BZ1',width:80,sortable: true,
                	renderer:function(value){
                		if(value == '0') {
                			return "<span>是</span>";
                		}else if(value == '1') {
                			return "<span>否</span>";
                		}else{
                			return value;
                		}
                	}
                },
                {header:'修改人',dataIndex:'XGR',width:80,sortable: true},
                {header:'修改时间',dataIndex:'XGSJ',width:180,sortable: true}
//                {header:'检验项目编号',dataIndex:'JYXMBH',width:100,sortable: true},
//                {header:'检验项目名称',dataIndex:'JCXM',width:100,sortable: true},
//                {header:'对应标准条款号',dataIndex:'DYBZTKH',width:100,sortable: true},
//            	{header:'检测费用',dataIndex:'JCFY',width:100,sortable: true},
//            	{header:'检验周期',dataIndex:'JYZQ',width:100,sortable: true},
//                {header:'院CANS',dataIndex:'YZZ',width:100,sortable: true,hidden:true},
//                {header:'国排中心CMA/CAL',dataIndex:'GPZZ',width:100,sortable: true,hidden:true},
//            	{header:'国建中心CMA/CAL',dataIndex:'GJZZ',width:100,sortable: true,hidden:true},
//            	{header:'院食品省级资质认定',dataIndex:'YSPZZ',width:100,sortable: true,hidden:true},
//            	{header:'环境要求',dataIndex:'HJYQ',width:100,sortable: true,hidden:true},
//            	{header:'设备编号',dataIndex:'SBBH',width:100,sortable: true},
//                {header:'设备名称',dataIndex:'SBMC',width:100,sortable: true},
//                {header:'人员',dataIndex:'RY',width:100,sortable: true},
//            	{header:'备注',dataIndex:'BZ',width:100,sortable: true,hidden:true},
//            	{header:'备注1',dataIndex:'BZ1',width:100,sortable: true,hidden:true},
//            	{header:'院资质认定',dataIndex:'YZZRD',width:100,sortable: true,hidden:true},
            	
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
                //"dblclick": { fn: this.onModifyClick, scope: this}, 		//响应双击事件
                //"rowcontextmenu": {fn: this.onRightMenuClick, scope: this}  //响应右击事件
            }
        });
    },
    onAddClick: function() {
    	var url = "zxxxAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("新增咨询信息");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var cpbh=records[0].get('CPBH');
   				var jyyj=records[0].get('JYYJ');
				var url = "zxxxOnLookView?cpbh="+cpbh+"&jyyj="+jyyj;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看咨询信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}  	
    },
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var cpbh=records[0].get('CPBH');
   				var jyyj=records[0].get('JYYJ');
				var url = "zxxxUpdateView?cpbh="+cpbh+"&jyyj="+jyyj;	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("修改咨询信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}        	
    },
    onDeleteClick: function() {
    	var records=this.getSelectionModel().getSelections();
    	var cpbhStr=[];
    	var jyyjStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		cpbhStr.push(records[i].get('CPBH'));
	       		jyyjStr.push(records[i].get('JYYJ'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { cpbhs: cpbhStr,jyyjs: jyyjStr},
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
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onOpenClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				var valueStr = records[0].get('ID');
   				var valueStatue = records[0].get('processStatus');
   				if(valueStatue == '2'){
   					Ext.Msg.alert('系统提示', '流程已经启动！');
   				}else if(valueStatue == '3'){
   					Ext.Msg.alert('系统提示', '流程已经结束！');
   				}else{
	   				Ext.Msg.confirm("提醒信息", "确定要启动此流程吗?",function(btn){
	   					if (btn == 'yes') {
	   				       	Ext.Ajax.request({
	   				       		url: 'openTestProcess', 
	   					       	   method : 'POST', 
	   					       	   params: { id: valueStr},
	   				               success: function(form, action) {
	   					               Ext.MessageBox.alert("系统提示:", BLANKSTR + "启动成功!" + BLANKSTR);
	   					               constructionGrid.store.reload();
	   				               },
	   				               failure: function(form, action) {
	   				            	   Ext.MessageBox.alert("系统提示:", BLANKSTR + "启动失败!" + BLANKSTR);
	   				               }
	   					       	});					
	   					}
	   		    	});
   				}
   			}else{
   				Ext.Msg.alert('系统提示', '不能开启多条流程..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		} 
    },
    sheetNoChange: function(value) {
    	return '<a href="javascript:void(0)" onclick=javascript:clickSheetNo('+value+')><b><font color=red>'+ value + '</font></b></a>';
    },
    clickSheetNo: function() {
    	alert(11);
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
    formatTime : function(val) {
    		var valStr = val.constructor == Date ? Ext.util.Format.date(val, 'Y-m-d H:i:s') : formatDate(new Date(val["time"]),"yyyy-MM-dd HH:mm:ss");    		
    		var valArr = valStr.split('-');
    		var valDate = new Date(valArr[0], valArr[1] - 1, valArr[2]);
    		return valStr;
    }
});


/*********************onReady 组件渲染及处理**********************************************/
Ext.onReady(function() {
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';

    constructionGrid = new ConstructionGrid(Ext.getBody().getViewSize().height-160, Ext.getBody().getViewSize().width);
    constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
//    new Ext.Viewport({
//    	layout: 'border',
//    	items:[
//		//conditionForm,
//		constructionGrid
//    	]
//    });
    
    var queryForm = new QueryForm();
    var leftPanel=new Ext.Panel({
		region: 'center',
        layout:"border",
        items    : [constructionGrid,queryForm]
    })
	
	new Ext.Viewport({
		layout:'border',
		items: [
		        leftPanel
		]
	});
});

