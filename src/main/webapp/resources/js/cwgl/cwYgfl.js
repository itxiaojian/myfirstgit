var USER_GRID_STORE_URL = 'getYgflList';
var FLMX_URL = '/cwgl/YCwYgflmx/getYgflmxList';  //工资薪金明细信息
var FLMX_SAVE_URL = '/cwgl/YCwYgflmx/save';      //工资薪金明细信息保存路径
var FLMX_UPDATE_URL = '/cwgl/YCwYgflmx/update';  //工资薪金明细信息修改路径
var FLMX_DELETE_URL = '/cwgl/YCwYgflmx/delete';  //工资薪金明细信息删除路径
var ENTITY_URL_UPLOAD = 'upload';
var PAGESIZE=20;
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/*************************************** FlmxForm组件 **************************************************/
FlmxForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
//    	this.idHidden = this.createHidden('id','id');
    	this.ygxm = this.createTextField('员工姓名', 'ygxm', '90%','',null,50,'长度超过不能50');
    	this.ssyf =  new Ext.form.DateField({
			fieldLabel: '所属月份',
			name: "ssyf",
			format: "Y-m",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		//this.flmc = this.createCombo('工资薪金名称','ZDZ' ,'ZDMC' , 'flmc','90%', PROJECT_NAME+'/cbgl/YCwCbxx/getDicByFllx');
		this.flmc = this.createCombo('费用类型','ZDZ' ,'ZDMC' , 'flmc','90%', PROJECT_NAME+'/cwgl/YCwYgfl/getDicByFllx');
    	this.flmc.store.load();
    	this.flxq = new Ext.form.TextArea({
            fieldLabel: '工资薪金详情',
            name: 'flxq',
            readOnly: false,
            anchor: '90%',
            height:40,
//            maxLength: 500,
//            maxLengthText: '500！'
        });
    	
    	this.je = new Ext.form.NumberField({
            fieldLabel: '金额',
            name: 'je',
            allowNegative :false,
            regex: /^\d+(\.\d+)?$/,
            anchor: '90%',
            cls:'forbiddenZH',
            blankText: '该选项为必填项,请输入内容...',
            hidden:false
        });
    	
    	this.ygxm.allowBlank = true;
    	this.ssyf.allowBlank = false;
    	this.flmc.allowBlank = false;
    	this.flxq.allowBlank = false;
    	this.je.allowBlank = false;
    	
    	var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.ygxm
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.ssyf
                    ]  
                }),
            ]  
        });
    	
    	var pnRow2=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.flmc
                    ]  
                }), 
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:80,  
                    labelAlign:'right',  
                    items:[  
                        this.je
                    ]  
                }), 
            ]  
        });
    	
    	var pnRow3=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
               
                new Ext.Panel({  
                    columnWidth:1.055,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                        this.flxq
                    ]  
                }),
            ]  
        });
    	
    	FlmxForm.superclass.constructor.call(this, {
        	anchor: '80%',
        	autoHeight:true,
        	layoutConfig: {columns: 1},
        	labelWidth: 90,
            labelAlign :'right',
            frame:true,
            bodyStyle:"padding: 5px 5px 0",
            width: '100%',
            items: [
//                        this.idHidden,
						pnRow1,
						pnRow2,
						pnRow3
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
              ]
        });
     },
     addFormClick: function() {
         if(this.getForm().isValid()) {
        	// var records=constructionGrid.getSelectionModel().getSelections();
          	// var ygbh = records[0].get("YGBH");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
                 url: PROJECT_NAME+""+FLMX_SAVE_URL,
                 method: 'POST',
                 success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.flmxWindow.flmxGrid.flmxInsertWindow.hide();
                 	constructionGrid.flmxWindow.flmxGrid.store.load({params:{start:0,limit:PAGESIZE}});
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
                 }
         	});
         }
     },
     updateFormClick: function() {       //修改
         if(this.getForm().isValid()) {
        	var record = constructionGrid.flmxWindow.flmxGrid.getSelectionModel().getSelections();
        	var ygxm = record[0].get("YGXM");
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'update', 
                 url: PROJECT_NAME+""+FLMX_UPDATE_URL,
                 method: 'POST',
                 params:{
                 	id:record[0].get('ID'),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	constructionGrid.flmxWindow.flmxGrid.flmxUpdateWindow.hide();
                 	constructionGrid.flmxWindow.flmxGrid.store.load({params:{start:0,limit:PAGESIZE,ygxm:ygxm}});
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
                 }
         	});
         }
     },
     
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
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

/*****************************FlmxWindow***********************************/
FlmxWindow = Ext.extend(Ext.Window, {
	ypxxGrid : null,
    constructor: function() {
    	this.flmxGrid = new FlmxGrid();
    	FlmxWindow.superclass.constructor.call(this, {
    		title:'工资薪金明细',
    		width: 1000,
//    		height:300,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.flmxGrid],
        	buttonAlign:'center',
	        buttons:[
//	                 {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
    closeClick: function() {
    	this.hide();
    }
});

/***************************************FlmxInsertWindow组件**************************************************/
FlmxInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.flmxForm = new FlmxForm();
        this.flmxForm.buttons[0].show();   //显示添加按钮
    	this.flmxForm.buttons[1].hide();   //隐藏修改按钮
    	FlmxInsertWindow.superclass.constructor.call(this, {
            title: "新增成本明细",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.flmxForm]
        });
    }
});

/***************************************FlmxUpdateWindow组件**************************************************/
FlmxUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
    constructor: function() {
    	this.flmxForm = new FlmxForm();
    	this.flmxForm.buttons[0].hide();   //隐藏添加按钮
    	this.flmxForm.buttons[1].show();   //显示修改按钮
    	FlmxUpdateWindow.superclass.constructor.call(this, {
        	title: "修改成本明细",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.flmxForm]
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

/**************************FlmxGrid*******************************************/
FlmxGrid = Ext.extend(UxGrid, {
	pageSizeCombo: null,
	vtbar:null,				//面板顶部的工具条	
	vbbar:null,				//面板底部的工具条
    store:null,
    constructor: function(height, width){
    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+FLMX_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({totalProperty: 'total', root:'rows'},[
                            {name:'ID'},{name:'YGXM'},{name:'SSYF'},{name:'FLMC'},{name:'FLXQ'},
                            {name:'JE'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
            ]
        });
   	
        this.flmxInsertWindow = new FlmxInsertWindow();       
        this.flmxUpdateWindow = new FlmxUpdateWindow();
        var sm = new Ext.grid.CheckboxSelectionModel(); 
        FlmxGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: false,
            height: 350,
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
                  {header:'员工姓名',dataIndex:'YGXM',width:150,sortable: true},
                  {header:'所属月份',dataIndex:'SSYF',width:150,sortable: true},
                  {header:'工资薪金名称',dataIndex:'FLMC',width:150,sortable: true},
              	  {header:'金额',dataIndex:'JE',width:150,sortable: true},
              	  {header:'工资薪金详情',dataIndex:'FLXQ',width:200,sortable: true},
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
    	var win = this.flmxInsertWindow;
    	win.flmxForm.getForm().reset();
//    	win.constructionForm.idHidden.setValue(0);
		var records=constructionGrid.getSelectionModel().getSelections();
    	var ygxm = records[0].get("YGXM");
        win.flmxForm.ygxm.setValue(ygxm);
    	win.show();
    },
    
    onModifyClick: function() {
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.flmxUpdateWindow;
   		    	//win.constructionForm.getForm().reset();
             	//win.constructionForm.product.setDisabled(true);//不允许修改帐户编码
   		    	win.show();
   		    	win.flmxForm.ygxm.setValue(vrecord.data.YGXM);
   		    	win.flmxForm.ssyf.setValue(vrecord.data.SSYF);
   		    	win.flmxForm.flmc.setValue(vrecord.data.FLMC);
   		    	win.flmxForm.flxq.setValue(vrecord.data.FLXQ);
   		    	win.flmxForm.je.setValue(vrecord.data.JE);
//   		    	win.constructionForm.getForm().loadRecord(vrecord);
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
//			       		url: 'delete', 
			       	       url: PROJECT_NAME+""+FLMX_DELETE_URL,
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
//				               constructionGrid.store.reload();
				               constructionGrid.flmxWindow.flmxGrid.store.reload();
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
                            {name:'ID'},{name:'FLBH'},{name:'YGXM'},{name:'KS_ID'},{name:'SSYF'},
                            {name:'FLHJ'},{name:'LRRQ'},{name:'LRR'},{name:'XGR'},{name:'XGRQ'},
                            {name:'XGYY'},{name:'BZ'},{name:'KSBH'},{name:'GZXJMC'},{name:'GZXJXQ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'登记',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'所属科室&员工姓名...',  
               	    },
    	  			'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				    }},'-',
      				    {xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			  }
                  },'-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
		        	    if(btn=="yes"){ 
		        	    	window.open(PROJECT_NAME+"/resources/js/cwgl/cwygfl.xls");
		        	   }
		        	 });
		    	 },scope:this},
		        '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
              '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
		        	    if(btn=="yes"){ 		        	    	
		        	    	var fileName = "员工工资薪金";
		        	    	var code = Ext.getCmp('code').getValue();
		        	    	var url = PROJECT_NAME + "/cwgl/YCwYgfl/export?fileName="+fileName+"&code="+code;
		        	    	url = encodeURI(url);
		        	    	url = encodeURI(url);
		        	    	window.open(url);
		        	   }
		        	 });
		    		}
   			   }
            ]
        });
   	
        this.flmxWindow = new FlmxWindow();
        
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
                {header:'序号',dataIndex:'ID',width:80,sortable: true,hidden:true},
                {header:'福利编号',dataIndex:'FLBH',width:120,sortable: true,hidden:true},
                {header:'所属科室',dataIndex:'KS_ID',width:135,sortable: true},
                {header:'科室编号',dataIndex:'KSBH',width:80,sortable: true, hidden:true},
                {header:'员工姓名',dataIndex:'YGXM',width:80,sortable: true},
            	{header:'所属月份',dataIndex:'SSYF',width:80,sortable: true},
            	{header:'工资薪金名称',dataIndex:'GZXJMC',width:100,sortable: true},
            	{header:'工资薪金详情',dataIndex:'GZXJXQ',width:100,sortable: true},
            	{header:'金额',dataIndex:'FLHJ',width:100,sortable: true},
            	{header:'录入人',dataIndex:'LRR',width:80,sortable: true},
            	{header:'录入日期',dataIndex:'LRRQ',width:140,sortable: true},
            	{header:'修改人',dataIndex:'XGR',width:80,sortable: true},
            	{header:'修改日期',dataIndex:'XGRQ',width:90,sortable: true},
            	{header:'修改原因',dataIndex:'XGYY',width:150,sortable: true, hidden:true},
            	{header:'备注',dataIndex:'BZ',width:150,sortable: true, hidden:true},
            	{header:'操作', width: 130, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
					   		"<span style='width: 25px;cursor: pointer;'>修改</span></a>&nbsp;&nbsp;&nbsp"+
					   		"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
					   		"<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>";
            		}
				},
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
		var url = "ygflAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("登记信息");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onLook: function(){   //查看工资薪金明细
      	var win = this.flmxWindow;
        win.show();
        var records=this.getSelectionModel().getSelections();
    	var flbh = records[0].get("FLBH");
//    	alert(ksbh);
    	win.flmxGrid.store.baseParams= {flbh:flbh};
       	win.flmxGrid.store.load({params:{start:0,limit:PAGESIZE,flbh:flbh}});
    },
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onModifyClick: function() {
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var flbh=records[0].get('FLBH');
				var url = "ygflUpdateView?id="+id+"&flbh="+flbh;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("编辑信息");
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
    	var valueStr=[];
    	var ygxmStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
	       		ygxmStr.push(records[i].get('YGXM'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr,ygxms: ygxmStr},
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
    new Ext.Viewport({
    	layout: 'border',
    	items:[
		//conditionForm,
		constructionGrid
    	]
    });
});

