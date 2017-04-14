var USER_GRID_STORE_URL = 'getSbjdjlList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
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



/********************IpasAssobjBankmemberUploadWindow组件*************************/
IpasAssobjBankmemberUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.ipasAssobjBankmember = new IpasAssobjBankmemberUpload();
		IpasAssobjBankmemberUploadWindow.superclass.constructor.call(this, {
			title: '导入EXCEL文件',
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
			this.getForm().submit({
				waitMsg: '正在提交，请稍后...',
				url: ENTITY_URL_UPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
					constructionGrid.ipasAssobjBankmemberUploadWindow.hide();
				},
				failure: function(form, action){
					Ext.MessageBox.alert("系统提示：",action.result.message);
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
                            {name:'ID'},{name:'SBBH'},{name:'SBMC'},{name:'SBTXM'},{name:'SYSJ'},
                            {name:'JDDW'},{name:'JDJG'},{name:'JDJL'},{name:'JDFY'},{name:'JDR'},
                            {name:'JYBH'},{name:'BGBH'},{name:'BZ'},{name:'JDFJ'},{name:'JDZT'},
                            {name:'SBID'}

            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'登记',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'编辑',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'设备名称&设备编号...',  
               	    },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},
      	        '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			    }},
//         	    '-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
//        		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
//       		        	    if(btn=="yes"){ 
//       		        	    	window.open(PROJECT_NAME+"/resources/js/sbgl/Sbbxjl.xls");
//       		        	   }
//       		        	 });
//       		    	 },scope:this},
//       		    '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
//                '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
//   	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
//   			        	    if(btn=="yes"){ 		        	    	
//   			        	    	var fileName = "设备保修记录";
//   			        	    	var code = Ext.getCmp('code').getValue();
//   			        	    	var url = PROJECT_NAME + "/sbgl/YsbBxjl/export?fileName="+fileName+"&code="+code;
//   			        	    	url = encodeURI(url);
//   			        	    	url = encodeURI(url);
//   			        	    	window.open(url);
//   			        	   }
//   			        	 });
//   	   		    		}
//       		      }
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
                {header:'id',dataIndex:'ID',width:70,sortable: true, hidden:true},
                {header:'sbid',dataIndex:'SBID',width:70,sortable: true, hidden:true},
               
                {header:'设备编号',dataIndex:'SBBH',width:100,sortable: true, hidden:true},
                {header:'设备二维码',dataIndex:'SBTXM',width:100,sortable: true, hidden:true},
            	{header:'设备名称',dataIndex:'SBMC',width:100,sortable: true},
            	{header:'检验开始时间',dataIndex:'SYSJ',width:90,sortable: true, hidden:true},
            	{header:'检验编号',dataIndex:'JYBH',width:100,sortable: true, hidden:true},
                {header:'检验报告编号',dataIndex:'BGBH',width:100,sortable: true},
            	{header:'检定单位',dataIndex:'JDDW',width:100,sortable: true, hidden:true},
            	{header:'检定状态',dataIndex:'JDZT',width:90,sortable: true,
            		 renderer:function(value){
                         if(value == '0') {
                             return "<span style=color:red>在检</span>";
                         }else if(value == '1') {
                             return "<span style=color:blue>已检</span>";
                         }else{
                         	return value;
                         }
                 	 }
            	},
            	{header:'检定结果',dataIndex:'JDJG',width:100,sortable: true, hidden:true},
            	{header:'检定结论',dataIndex:'JDJL',width:100,sortable: true, hidden:true},
            	{header:'检定费用',dataIndex:'JDFY',width:90,sortable: true},
            	{header:'检定人',dataIndex:'JDR',width:100,sortable: true},
            	{header:'备注',dataIndex:'BZ',width:80,sortable: true, hidden:true},
            	
            	 {header: '操作', width: 200, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("JDZT") == 0){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
					   		  "&nbsp&nbsp&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.onStop()' style='text-decoration:none;'>"+
					   		  "<span style='width: 26px;cursor: pointer;'>完成</span></a>"+
					   		"&nbsp&nbsp&nbsp"+
					   		"<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;'>编辑</span></a>"+
			                  "&nbsp&nbsp&nbsp"+
			                  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;color:red;'>删除</span></a>";
					   		  
            		}else if(record.get("JDZT") == 1 ){
                  		return  "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
					   		  "&nbsp&nbsp&nbsp"+
					   		  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;color:gray;'>完成</span></a>"+
			                  "&nbsp&nbsp&nbsp"+
			                  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;color:gray;'>编辑</span></a>"+
			                  "&nbsp&nbsp&nbsp"+
			                  "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
			                  "<span style='width: 25px;color:red;'>删除</span></a>";
        		    }
						}
				},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
            listeners: {
                
            }
        });
    },
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onAddClick: function() {                   //新增
    	var url = "sbjdjlAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("检定登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onModifyClick: function() {                     //修改
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbjdjlUpdateView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("编辑记录");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },    	
    	
    onDeleteClick: function() {            //删除
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条记录吗",function(btn){
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
    
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
//   				alert(id);
				var url = "sbjdjlOnlookView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看检定记录");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    onStop: function() {                  //完成检定
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var sbid=records[0].get('SBID');
//   				alert(sbid);
				var url = "sbjdjlOnstopView?id="+id+"&sbid="+sbid;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("完成检定");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show(); 

   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
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