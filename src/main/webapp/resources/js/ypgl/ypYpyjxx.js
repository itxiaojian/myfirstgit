var USER_GRID_STORE_URL = 'getYpxxList';
var PAGESIZE=20;
var SBXX_URL = '/khgl/YKhKhxx/getKhKhxxList';
var BZXX_URL = '/jybzgl/getYjyBzxxList';
var JSFWXYXX_URL = '/jsfwgl/YjsfwXyxx/getJsfwXyxxList';
var DICT_ENTRY_GRID_STORE_URL = '/jybzgl/getYjyXmxxList';
var ENTITY_URL_UPLOAD = 'upload';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();
var czfs=0;
var LODOP; //声明为全局变量      

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
			title: '导入样品信息EXCEL数据',
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
                            {name:'ID'},{name:'YPBH'},{name:'EWMBH'},{name:'YPMC'},{name:'YPLX'},
                            {name:'JYLX'},{name:'LYFS'},{name:'SZCS'},{name:'GGXH'},{name:'SCRQPC'},
                            {name:'YPDJ'},{name:'YPZT'},{name:'CYDD'},{name:'CYRQ'},{name:'CYJS'},
                            {name:'YPSL'},{name:'WTDW'},{name:'WTDWDZ'},{name:'SJDW'},{name:'JYKSBH'},
                            {name:'SJDWDZ'},{name:'LXR'},{name:'DH'},{name:'YB'},{name:'SCDW'},
                            {name:'SCDWDZ'},{name:'SCDWLXR'},{name:'SCDWDH'},{name:'SCDWYB'},
                            {name:'JYYJ'},{name:'JYXM'},{name:'BGFSFS'},{name:'YHXTK'},
                            {name:'CYRY'},{name:'JCFYRY'},{name:'JYKS'},{name:'YWKS'},{name:'JYHTH'},
                            {name:'EWMTP'},{name:'JYFY'},{name:'JYFYDD'},{name:'BZ'},{name:'BGBH'},
                            {name:'YWKSBH'},{name:'YPJYZT'},{name:'DJRY'},{name:'DJSJ'},{name:'FJ'},
                            {name:'DYRQ'}, {name:'LYSL'}, {name:'DJLX'}, {name:'XGJE'}, {name:'YPYJ'}, {name:'YJZT'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{xtype:'textfield',id:'canshu',width: 200,
                	   emptyText:'样品编号&样品名称&报告编号...',  
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
  		    	{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
		        	    if(btn=="yes"){ 		        	    	
		        	    	var fileName = "样品信息";
		        	    	var code = Ext.getCmp('canshu').getValue();
		        	    	var url = PROJECT_NAME + "/ypgl/YYpYpxx/export?fileName="+fileName+"&code="+code;
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
                {header:'编号',dataIndex:'ID',width:80,sortable: true, hidden:true},
                {header:'领用数量',dataIndex:'LYSL',width:80,sortable: true, hidden:true},
                {header:'已收费金额',dataIndex:'XGJE',width:80,sortable: true, hidden:true},
                {header: '操作', width: 80, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
					   		  "<a href='javascript:;' onclick='constructionGrid.ypxxYjiao()' style='text-decoration:none;'>" +
					   		  "<span style='width: 25px;cursor: pointer;'>移交</span></a>";
            		}
				},
				{header:'登记类型',dataIndex:'DJLX',width:100,sortable: true,
					renderer:function(value){
	                    if(value == '0') {
	                        return "<span>一般样品登记 </span>";
	                    }else if(value == '1') {
	                        return "<span>工程类样品登记</span>";
	                    }else if(value == '2') {
	                        return "<span>食药类样品登记</span>";
	                    }else if(value == '3') {
	                        return "<span>抽样登记</span>";
	                    }else{
	                    	return value;
	                    }
	        		}
				},
				{header:'样品检测状态',dataIndex:'YPJYZT',width:80,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>待检</span>";
	                    }else if(value == '1') {
	                        return "<span>编制中</span>";
	                    }else if(value == '2') {
	                        return "<span>已编制</span>";
	                    }else if(value == '3') {
	                        return "<span>已审核</span>";
	                    }else if(value == '4') {
	                        return "<span>已批准</span>";
	                    }else if(value == '5') {
	                        return "<span>已接收</span>";
	                    }else if(value == '6') {
	                        return "<span>结束</span>";
	                    }else if(value == '7') {
	                        return "<span>已解锁</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
                {header:'样品编号',dataIndex:'YPBH',width:100,sortable: true},
                //{header:'报告编号',dataIndex:'BGBH',width:120,sortable: true},
                //{header:'二维码编号',dataIndex:'EWMBH',width:80,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:120,sortable: true},
            	//{header:'样品类型',dataIndex:'YPLX',width:80,sortable: true},
            	{header:'检验类型',dataIndex:'JYLX',width:80,sortable: true},
            	{header:'检验科室',dataIndex:'JYKS',width:120,sortable: true},
            	{header:'业务科室',dataIndex:'YWKS',width:120,sortable: true},
            	{header:'登记时间',dataIndex:'DJSJ',width:90,sortable: true},
            	{header:'样品数量',dataIndex:'YPSL',width:80,sortable: true},
            	{header:'报告发送方式',dataIndex:'BGFSFS',width:100,sortable: true,
            		renderer:function(value){
	                    if(value == '0') {
	                        return "<span>邮寄</span>";
	                    }else if(value == '1') {
	                        return "<span>自取（本院）</span>";
	                    }else if(value == '2'){
	                    	return "<span>自取（中心）</span>";
	                    }else{
	                    	return value;
	                    }
            		}
            	},
            	// {header:'样品移交',dataIndex:'YPYJ',width:100,sortable: true,
            		// renderer:function(value){
	                    // if(value == '0') {
	                        // return "<span>是</span>";
	                    // }else if(value == '1') {
	                        // return "<span>否</span>";
	                    // }else{
	                    	// return value;
	                    // }
            		// }
            	// },
            	{header:'检验费用',dataIndex:'JYFY',width:80,sortable: true},
            ]),
            tbar: this.vtbar,
            bbar: this.vbbar,
            ds: this.store,
        });
    },
    
    onUploadClick: function(){             // 导入EXCEL数据
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onLook: function() {                  //查看
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var ypbh=records[0].get('YPBH');
   				var djlx=records[0].get('DJLX');
				var url = "ypxxOnLookView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("查看样品信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}        	
    },
    
    ypxxYjiao: function() {                  //移交
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var ypbh=records[0].get('YPBH');
   				var djlx=records[0].get('DJLX');
				var url = "ypxxYjiaoView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				//ACT_DEAL_WINDOW.setTitle("样品信息移交");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}        	
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