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

var ewmWindow;

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
            html:'<iframe scrolling="auto" frameborder="0" width="100px;" height="100px;" src=""></iframe>'
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
                            {name:'DYRQ'}, {name:'LYSL'}, {name:'DJLX'}, {name:'XGJE'}, {name:'YPYJ'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                    {text:'查看二维码',iconCls: 'edit',handler:this.onBqClick,scope:this},
                    {text:'批量打印流转单',iconCls: 'printer',handler:this.onPrintMoneClick,scope:this},
                    {text:'批量打印协议书',iconCls: 'printer',handler:this.onPrintXysMoneClick,scope:this},
                //'-',{text:'增加',iconCls: 'add',handler:this.onAddClick,scope:this},
                //'-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
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
                  },/*
                  '-',
                                    {xtype:'button',text:'涓嬭浇EXCEL妯℃澘',iconCls:'excel',handler:function(){
                                           Ext.Msg.confirm('绯荤粺鎻愮ず','纭畾瑕佷笅杞借妯℃澘鍚�',function(btn){
                                            if(btn=="yes"){ 
                                                window.open("/zjyw/resources/js/ypgl/ypypxx.xls");
                                           }
                                         });
                                     },scope:this}, '-',
                                    {xtype:'button',text:'瀵煎叆EXCEL鏁版嵁',iconCls:'excel',handler:this.onUploadClick,scope:this},'-',*/
                  
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
                {header: '操作', width: 400, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("YPSL") != 0 && record.get("LYSL") != 0 ){
							if(record.get("XGJE") < 0){
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
								   "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp" +
								   "<a href='javascript:;' onclick='constructionGrid.onLyong()'  style='text-decoration:none;'>" +
								   "<span style='width: 25px;cursor: pointer;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onGhuan()'  style='text-decoration:none;'>" +
								   "<span style='width: 25px;cursor: pointer;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onTyang()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
							       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
							   	   "<a href='javascript:;' onclick='constructionGrid.onTshiClick()' style='text-decoration:none;'>"+ 
		                           "<span style='width: 25px;color:gray;'>删除</span></a>";
								}else{
									return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
									   "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp" +
									   "<a href='javascript:;' onclick='constructionGrid.onLyong()'  style='text-decoration:none;'>" +
									   "<span style='width: 25px;cursor: pointer;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onGhuan()'  style='text-decoration:none;'>" +
									   "<span style='width: 25px;cursor: pointer;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onTyang()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
								       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
								   	   "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>"+ 
			                           "<span style='width: 25px;color:red;'>删除</span></a>";
								}	
							}		   
					else if(record.get("YPSL") != 0 && record.get("LYSL") == 0){
						if(record.get("XGJE") < 0){
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
								   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onLyong()'  style='text-decoration:none;'>" +
								   "<span style='width: 25px;cursor: pointer;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onTyang()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
							       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onTshiClick()' style='text-decoration:none;'>"+ 
		                           "<span style='width: 25px;color:gray;'>删除</span></a>";
							}else{
									return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
									   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onLyong()'  style='text-decoration:none;'>" +
									   "<span style='width: 25px;cursor: pointer;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onTyang()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
									   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
								       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
								       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
								       "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
			                           "<span style='width: 25px;color:red;'>删除</span></a>";
								}
						}
					else if(record.get("YPSL") == 0 && record.get("LYSL") != 0){
						if(record.get("XGJE") < 0){
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
								   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onGhuan()'  style='text-decoration:none;'>" +
								   "<span style='width: 25px;cursor: pointer;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
							       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onTshiClick()' style='text-decoration:none;'>" + 
		                           "<span style='width: 25px;color:gray;'>删除</span></a>";
						}else {
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
							   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
							   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
							   "<a href='javascript:;' onclick='constructionGrid.onGhuan()'  style='text-decoration:none;'>" +
							   "<span style='width: 25px;cursor: pointer;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
							   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
							   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
						       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
							   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
						       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
						       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
						       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
							   "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
	                           "<span style='width: 25px;color:red;'>删除</span></a>";
							
						}
								}
					else if(record.get("YPSL") == 0 && record.get("LYSL") == 0){
						if(record.get("XGJE") < 0){
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
								   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
							       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onTshiClick()' style='text-decoration:none;'>" + 
		                           "<span style='width: 25px;color:gray;'>删除</span></a>";
							}else {
								return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
								   "<span style='width: 25px;'>查看</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>领用</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>归还</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='' style='text-decoration:none;'><span style='width: 25px;color:grey;'>退样</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印流转单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onPrintXysClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印协议书</span></a>&nbsp;&nbsp;&nbsp"+
							       "<a href='javascript:;' onclick='constructionGrid.onPrintCydClick()'  style='text-decoration:none;'>" +
							       "<span style='width: 25px;cursor: pointer;'>打印抽样单</span></a>&nbsp;&nbsp;&nbsp"+
								   "<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" + 
		                           "<span style='width: 25px;color:red;'>删除</span></a>";
								
							}
								}	
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
            	// {header:'来样方式',dataIndex:'LYFS',width:80,sortable: true,
            		// renderer:function(value){
	                    // if(value == '0') {
	                        // return "<span>直送</span>";
	                    // }else if(value == '1') {
	                        // return "<span>快递</span>";
	                    // }else{
	                    	// return value;
	                    // }
            		// }
            	// },
            	//{header:'所在城市',dataIndex:'SZCS',width:80,sortable: true},
            	//{header:'规格型号',dataIndex:'GGXH',width:80,sortable: true},
            	//{header:'生产日期\批次',dataIndex:'SCRQPC',width:100,sortable: true},
            	//{header:'样品等级\类型',dataIndex:'YPDJ',width:100,sortable: true},
            	//{header:'样品状态',dataIndex:'YPZT',width:80,sortable: true},
            	//{header:'抽样地点',dataIndex:'CYDD',width:80,sortable: true},
            	//{header:'抽样日期',dataIndex:'CYRQ',width:80,sortable: true},
            	//{header:'抽样基数',dataIndex:'CYJS',width:80,sortable: true},
            	{header:'样品数量',dataIndex:'YPSL',width:80,sortable: true},
            	//{header:'委托单位',dataIndex:'WTDW',width:80,sortable: true},
            	//{header:'委托单位地址',dataIndex:'WTDWDZ',width:100,sortable: true},
            	//{header:'受检单位',dataIndex:'SJDW',width:80,sortable: true},
            	//{header:'受检单位地址',dataIndex:'SJDWDZ',width:100,sortable: true},
            	//{header:'联系人',dataIndex:'LXR',width:80,sortable: true},
            	//{header:'电话',dataIndex:'DH',width:80,sortable: true},
            	//{header:'邮编',dataIndex:'YB',width:80,sortable: true},
            	//{header:'生产单位',dataIndex:'SCDW',width:80,sortable: true},
            	//{header:'生产单位地址',dataIndex:'SCDWDZ',width:100,sortable: true},
            	//{header:'生产单位联系人',dataIndex:'SCDWLXR',width:100,sortable: true},
            	//{header:'生产单位电话',dataIndex:'SCDWDH',width:100,sortable: true},
            	//{header:'生产单位邮编',dataIndex:'SCDWYB',width:100,sortable: true},
            	//{header:'检验科室编号',dataIndex:'JYKSBH',width:100,sortable: true},
            	//{header:'检验项目',dataIndex:'JYXM',width:100,sortable: true},
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
            	{header:'样品移交',dataIndex:'YPYJ',width:100,sortable: true,
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
            	// {header:'检验后须退库',dataIndex:'YHXTK',width:100,sortable: true,
            		// renderer:function(value){
	                    // if(value == '0') {
	                        // return "<span>退</span>";
	                    // }else if(value == '1') {
	                        // return "<span>不退</span>";
	                    // }else{
	                    	// return value;
	                    // }
            		// }
            	// },
            	//{header:'抽样人员',dataIndex:'CYRY',width:80,sortable: true},
            	//{header:'检查封样人员',dataIndex:'JCFYRY',width:100,sortable: true},
            	
            	//{header:'业务科室编号',dataIndex:'YWKSBH',width:120,sortable: true},
            	//{header:'检验合同号',dataIndex:'JYHTH',width:80,sortable: true},
            	//{header:'二维码图片',dataIndex:'EWMTP',width:80,sortable: true},
            	{header:'检验费用',dataIndex:'JYFY',width:80,sortable: true},
            	// {header:'检验费用待定',dataIndex:'JYFYDD',width:100,sortable: true,
            		// renderer:function(value){
	                    // if(value == '0') {
	                        // return "<span>待定</span>";
	                    // }else if(value == '1') {
	                        // return "<span>不待定</span>";
	                    // }else{
	                    	// return value;
	                    // }
            		// }
            	// },
            	
            	//{header:'样品登记人员',dataIndex:'DJRY',width:120,sortable: true,hidden:true},
            	//{header:'样品登记时间',dataIndex:'DJSJ',width:120,sortable: true,hidden:true},
            	//{header:'样品附件',dataIndex:'FJ',width:80,sortable: true},
            	//{header:'到样日期',dataIndex:'DYRQ',width:80,sortable: true},
            	//{header:'检验依据',dataIndex:'JYYJ',width:100,sortable: true},
            	//{header:'备注',dataIndex:'BZ',width:80,sortable: true},
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
    
    onBqClick: function() {       
    	var records=this.getSelectionModel().getSelections();
    	if(records.length > 0) {
    		if(records.length == 1){
    			vrecord = records[0];
    			var ypbh=vrecord.get('YPBH');
//    			var url = 'ypewmPage?ypbh = '+ypbh;  	
//    			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
//    			ewmWindow = new EwmWindow();
//    			ewmWindow.setTitle("生成设备二维码");
//    			ewmWindow.html = html;
//    			ewmWindow.show();
    			window.open('ypewmPage?ypbh='+ypbh,'样品标签','height=500px, width=600px,top=200px, left=300px, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
    		}else{
    			Ext.Msg.alert('系统提示', '不能选择多条记录..');
    		}
    	}else{
    		Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
    	}
    	
    	// var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
	    // var strBodyStyle="<style>"+document.getElementById("printStyle").innerHTML+"</style>";
	    // var tableHtml;
	    // var tableObj=$('<table class="tablePrint"></table>');
	    // var tableCon=$('<div></div>');
// //  		    LODOP.SET_PRINT_STYLEA(2,"FontName","隶书");
	    // tableCon.append(tableObj);
	    // tableObj.append($("#myTable").html());
	    // tableHtml=tableCon.html();
		// var strBodyHtml=strBodyStyle+"<body style='font-size: 5pt;'>"+tableHtml+"</body>";
	    // LODOP.PRINT_INIT("打印本页");
		// LODOP.SET_PRINT_STYLE("FontSize",1);
		// LODOP.ADD_PRINT_TABLE(5,0,"18.5%","96%",strBodyHtml);
		// LODOP.ADD_PRINT_BARCODE(50,14,75,75,"QRCode",str);
		// LODOP.SET_PRINT_PAGESIZE(0,400,300,"TMZ");
		// LODOP.SET_PREVIEW_WINDOW(2,2,1,760,540,"");
		// LODOP.PREVIEW(); 
    },
    
    onAddClick: function() {           //增加
    	// czfs=1;
    	// var win = this.constructionInsertWindow;
    	// win.constructionForm.getForm().reset();
    	// win.constructionForm.inwin = win;
    	// win.show();
	

    	var url = "ypxxAddView";  	
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("样品登记");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
    },
    
    onPrintClick: function() {           //增加
		var records=this.getSelectionModel().getSelections();
		var ypbh=records[0].get('YPBH');
		LODOP=getLodop();  
		LODOP.PRINT_INIT("流转单");
		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpLzdPage?ypbh='+ypbh);
// 		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh=2015DQ00003');
		LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
		LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
		//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
		//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
		LODOP.PREVIEW();		
		
//		 window.open("YpLzdPage?ypbh="+ypbh, "样品流转单", "height=750, width=800, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
    },
    
    onPrintXysClick: function() {           //打印协议书
		var records=this.getSelectionModel().getSelections();
		var ypbh=records[0].get('YPBH');
		LODOP=getLodop();  
		LODOP.PRINT_INIT("委托协议书");
		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh='+ypbh);
// 		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh=2015DQ00003');
		LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
		LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
		//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
		//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
		LODOP.PREVIEW();
		
//		window.open("YpJyxysPage?ypbh="+ypbh, "样品协议书", "height=750, width=800, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
    },
    
    onPrintCydClick: function() {           //打印抽样单
		var records=this.getSelectionModel().getSelections();
		var ypbh=records[0].get('YPBH');
//		LODOP=getLodop();  
//		LODOP.PRINT_INIT("抽样单");
//		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpCydPage?ypbh='+ypbh);
//// 		LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh=2015DQ00003');
//		LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
//		LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
//		//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
//		//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
//		LODOP.PREVIEW();
		
		window.open("YpCydPage?ypbh="+ypbh, "样品协议书", "height=750, width=800, toolbar =no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
    },
    
    onPrintXysMoneClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
    	if(records.length > 0) {
	    	for(var i=0;i<records.length;i++){
		    	var ypbh=records[i].get('YPBH');
		    	LODOP=getLodop();  
		    	LODOP.PRINT_INIT("协议书");
		    	LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpJyxysPage?ypbh='+ypbh);
		    	LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
		    	LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
		    	//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
		    	//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
	//	    	LODOP.PREVIEW();//打印预览
		    	LODOP.PRINT();//直接打印
	    	}
    	}else{
    		Ext.Msg.alert('系统提示', '请选择一条记录');
    	}
    },
    
    onPrintMoneClick: function() {           //增加
    	var records=this.getSelectionModel().getSelections();
    	if(records.length > 0) {
	    	for(var i=0;i<records.length;i++){
		    	var ypbh=records[i].get('YPBH');
		    	LODOP=getLodop();  
		    	LODOP.PRINT_INIT("流转单");
		    	LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpLzdPage?ypbh='+ypbh);
		    	LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
		    	LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
		    	//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
		    	//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
	//	    	LODOP.PREVIEW();//打印预览
		    	LODOP.PRINT();//直接打印
	    	}
    	}else{
    		Ext.Msg.alert('系统提示', '请选择一条记录');
    	}
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
    
    onLyong: function() {                  //领用
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var ypbh=records[0].get('YPBH');
   				var djlx=records[0].get('DJLX');
				var url = "ypxxLyongView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("样品领用");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}       	
    },
    
    onGhuan: function() {                  //归还
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id = records[0].get('ID');
   				var ypbh = records[0].get('YPBH');
   				var djlx=records[0].get('DJLX');
				var url = "ypxxGhuanView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("样品归还");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}  
   		
    },
    
    onTyang: function() {                  //退样
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var ypbh=records[0].get('YPBH');
   				var djlx=records[0].get('DJLX');
				var url = "ypxxTyangView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("样品退样");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}      	    	
    },
    
    onModifyClick: function() {         //修改
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
				var url = "ypxxUpdateView?id="+id;  	
				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
				ACT_DEAL_WINDOW = new ActDealWindow();
				ACT_DEAL_WINDOW.setTitle("修改样品信息");
				ACT_DEAL_WINDOW.html = html;
				ACT_DEAL_WINDOW.show();   
   			}else{
   				Ext.Msg.alert('系统提示', BLANKSTR + '不能修改多条记录' + BLANKSTR);
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    
				   			
    },
    onDeleteClick: function() {           //删除
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
    	var valueStr1=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
	       		valueStr1.push(records[i].get('BGBH'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		   url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr,bgbhs: valueStr1},
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

    onTshiClick: function() {       //  收费中的提示县退费才可删除
		var records=this.getSelectionModel().getSelections();
		    	var valueStr=[];
		   		if(records.length>0) {
			       	for(var i=0;i<records.length;i++){
			       		valueStr.push(records[i].get('ID'));
		    	 	}
			    	Ext.Msg.confirm("提醒信息", "该条检验报告正在收费，请退费后删除！",function(btn){
			    	});	
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