var ENTITY_URL_LIST = "/jygl/YjyRztb/getRztbList";
var ENTITY_URL_SAVE = "";
var ENTITY_URL_UPDATE = "";
var ENTITY_URL_DELETE = "";
var IMAGE_GRID_STORE_URL = '/jygl/YjyRztb/getImageList';//图片素材

var ENTITY_URL_UPLOAD = "/jygl/YjyRztb/uploadImage";

var PAGESIZE=50;

/**
 * 上传图片素材
 * @author zhangyi
 * @date 2015-6-09
 */
MyUploadForm = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		this.tishi = new Ext.form.DisplayField({
			value:'<span  style="color:red;font-weight:bold;">图片大小1M，支持JPG格式</span>'
		});
		this.fibasic = new Ext.ux.form.FileUploadField({
			anchor:'90%',
			name: 'attachMentFile',
            emptyText: '请选择...',
            labelWidth: 67,
            fieldLabel: '<font color="red">*</font>图片地址:',
            buttonCfg: {
                text: '浏览'
            }
	    });
		this.rzfl = this.createCombo('<font color="red">*</font>认证分类','ZDZ' ,'ZDMC' , 'rzfl','90%', PROJECT_NAME+'/jygl/YjyRztb/getDicByRzfl');
		this.rzfl.store.load();
		this.bz = new Ext.form.TextField({
            fieldLabel: '备注:',
            name: 'bz',
            anchor: '90%'
        });
		
		this.fibasic.allowBlank = false;
		this.rzfl.allowBlank = false;
		this.bz.allowBlank = true;
		
		MyUploadForm.superclass.constructor.call(this, {
			anchor: '100%',
			fileUpload: true,
			autoHeight:true,
			labelWidth: 80,
			labelAlign :'right',
			frame: true,
			bodyStyle:"padding: 5px 5px 0",
			layout: 'tableform',
			layoutConfig: {columns: 1},
			items:[
			 	   this.tishi,
			       this.fibasic,
			       this.rzfl,
			       this.bz
			      
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
			var attachMentFileValue = this.fibasic.getValue();
        	if(attachMentFileValue == null || attachMentFileValue == "") {
        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "请选择文件!" + BLANKSTR);
        		return;
        	}
        	
        	var attachmentType = attachMentFileValue.substring(attachMentFileValue.lastIndexOf(".")+1).toLowerCase();
        	if(attachmentType != "jpg" && attachmentType != "png"){
        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "图片类型为jpg或png" + BLANKSTR);
        		return;
        	}
			this.getForm().submit({
				waitMsg: '正在提交，请稍后...',
				url: PROJECT_NAME+""+ENTITY_URL_UPLOAD,
				success: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传成功！");
					unteckAttachmentGrid.myUploadWindow.hide();
					unteckAttachmentGrid.store.load({params:{start:0,limit:PAGESIZE}});
				},
				failure: function(form, action){
					Ext.MessageBox.alert("系统提示：","上传失败！");
				}
			});
		}
	},
	//关闭
	onCloseClick: function(){
		unteckAttachmentGrid.myUploadWindow.myUploadForm.getForm().reset();
		this.ownerCt.hide();
	}
	
});

/********************UploadWindow组件*************************/
MyUploadWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor: function() {
		this.myUploadForm = new MyUploadForm();
		MyUploadWindow.superclass.constructor.call(this, {
			title: '上传图片',
			width: 500,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
			items: [this.myUploadForm]
		});
	}
});

/*****************************ImageSelectWindow***************
 *description   : 群发时选择图片素材窗口
*************************************************************/
ImageSelectWindow = Ext.extend(Ext.Window, {
    constructor: function() {
    	this.imageSelectGrid = new ImageSelectGrid(); 	
    	ImageSelectWindow.superclass.constructor.call(this, {
    		title:'查看图片',
    		width: 550,
    		height:400,
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.imageSelectGrid],
        	buttonAlign:'center',
	        buttons:[
//			         {text:'确定', width: 20,iconCls: 'save', handler:this.addFormClick,scope:this},
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
//    addFormClick: function() {
//    	var record = this.imageSelectGrid.selectedRecord();
//    	massInfoForm.content.setValue(record.data.mediaId);
//    	imageSelectWindow.hide();
//    	Ext.getCmp("toolbarDisplay222ID").setValue(record.data.scName);
//    },
    closeClick: function() {
    	this.hide();
    }
    
});

/*****************************ImageSelectGrid*****************
 *description   : 群发时选择图片素材列表
*************************************************************/
ImageSelectGrid = Ext.extend(UxGrid, {
    store:null,
    constructor: function(height, width){

    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+IMAGE_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({fields:[
                   {name:'rzmc'},{name:'fileCode'},{name:'fjlj'}
            ]})
        });
    	
        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        ImageSelectGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: true,
            height: 400,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
                                          sm,
                {header:'',dataIndex:'rzmc',width:450,sortable: true,
            		renderer:function(data, metadata, record){
            			var srcurl = PROJECT_NAME+"/"+record.data.fjlj + "/" + record.data.fileCode ;
            			return "<img height=100% width=95% src = '" + srcurl + "'></img>";
            		}
                },
//                {header:'查看大图',dataIndex:'scName',width:100,sortable: true,
//            		renderer:function(data, metadata, record){
//            			var srcurl = PROJECT_NAME+'/jygl/YjyRztb/' + record.data.fileCode +'/show';
//            			return "<a href='" +srcurl + "'>查看大图</a>";
//            		}
//                }
            ]),
            ds: this.store
        });
    },
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
    }
});


/****************UnteckAttachmentGrid***********************/
UnteckAttachmentGrid = Ext.extend(UxGrid,{
	constructor: function(height,width){
		this.store = new Ext.data.Store({
			
			proxy: new Ext.data.HttpProxy({url:PROJECT_NAME+""+ENTITY_URL_LIST,method:'POST'}),
			reader: new Ext.data.JsonReader({totalProperty:'total',root:'rows'},[
		            {name:'id'},
		            {name:'rzmc'},
		            {name:'rzfl'},
		            {name:'fjlj'},
		            {name:'sub'},
		            {name:'bz'}])
		});
		
		//var query_filetype = this.createMemoryCombo('素材类型', 'code', 'name', '100', QUERY_FILETYPE);
    	//query_filetype.store.load();
    	//query_filetype.setValue(0);
		
		this.vtbar = new Ext.Toolbar({
			items: [
					'-',{xtype:'button',text:'上传图片',iconCls:'db-icn-upload',handler:this.onUploadClick,scope:this},
					'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
					'-',{xtype:'label',text:'认证名称：'},{xtype:'textfield',id:'fileName'},
			        '-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
	    	   				var params = {};
			       			unteckAttachmentGrid.vtbar.items.each(function(item,index,length){ 
		       					if((""+item.getXType()).indexOf("field") != -1 && item.getValue() != '') {
		       						if (item.getXType() == 'datefield') {
		       							params[item.getId()] = item.getValue().format(item.format);
		       						} else {
		       							params[item.getId()] = item.getValue();
		       						}
		       					}
							});
							
							var rzmc = Ext.getCmp('fileName').getValue();
			       			unteckAttachmentGrid.store.baseParams = {rzmc:rzmc};
	    	   				unteckAttachmentGrid.store.load({params:{start:0,limit:PAGESIZE}});
	    	   			}
	       			},
					'-',{xtype:'button',text:'重置',iconCls:'refresh',handler:function(){
						unteckAttachmentGrid.vtbar.items.each(function(item,index,length){   
							if((""+item.getXType()).indexOf("field") != -1) {
								item.setValue('');
							}
						  });  
    	   			}}
			]
		});
		this.vbbar= new Ext.PagingToolbar({ 
            pageSize: PAGESIZE, 
            store: this.store, 
            displayInfo: true, 
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条', 
            emptyMsg: "没有记录" 
    	});
		imageSelectWindow = new ImageSelectWindow();
		this.vsm = new Ext.grid.CheckboxSelectionModel();
		this.vcm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		             this.vsm,
		            {header:'ID',dataIndex:'id',width:100,sortable:true,hidden:true},
		            {header: '操作', width: 100, dataIndex: 'sbbh', align:"center",sortable: true,hidden: false,
		            	renderer:function(value, cellmeta, record){
	                    	var id = record.data.id;
	                    	return "<a href='javascript:;' onclick='unteckAttachmentGrid.onTpClick()' style='text-decoration:none;'>查看</a>";
	                    }
	            	},
		            {header:'认证名称',dataIndex:'rzmc',width:200,sortable:true},
		            {header:'认证分类',dataIndex:'rzfl',width:200,sortable:true},
//		            	renderer:function(value){
//	  	                    if(value == '0') {
//	  	                        return "<span>院 </span>";
//	  	                    }else if(value == '1') {
//	  	                        return "<span>国排中心</span>";
//	  	                    }else if(value == '2'){
//	  	                    	return "<span>国建中心</span>";
//	  	                    }else if(value == '3'){
//	  	                    	return "<span>公共安全中心认证</span>";
//	  	                    }else if(value == '4'){
//	  	                    	return "<span>消防中心认证</span>";
//	  	                    }
//	              		}
	              	
		            {header:'认证图片附件路径',dataIndex:'fjlj',width:200,sortable:true},
//		            {header:'文件随机名称',dataIndex:'sub',width:350,sortable:true},
		            {header:'备注',dataIndex:'bz',width:250,sortable:true},
		           ]);
		UnteckAttachmentGrid.superclass.constructor.call(this,{
			region: 'center',
			frame: true,
			height: height,
            viewConfig: {
                forceFit: false
            },
            loadMask: new Ext.LoadMask(document.body,{ 
				msg: '正在载入数据，请稍后...',
				store   : this.store
			}),
			sm: this.vsm,
			cm: this.vcm,
			tbar: this.vtbar,
			bbar: this.vbbar,
			ds: this.store
		});
	},
	onUploadClick: function(){
    	if(!this.myUploadWindow)
    		this.myUploadWindow = new MyUploadWindow();
    	var win = this.myUploadWindow;
    	win.show();
    	win.myUploadForm.getForm().reset();
    },
    onDeleteClick: function() {           //删除
    	var records=this.getSelectionModel().getSelections();
    	var valueStr=[];
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('id'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		   url: 'delete', 
				       	   method : 'POST', 
				       	   params: { ids: valueStr},
			               success: function(form, action) {
				               Ext.MessageBox.alert("系统提示:", BLANKSTR + "删除成功!" + BLANKSTR);
				               unteckAttachmentGrid.store.reload();
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
    
    onTpClick: function(){//点击图片
		var records=this.getSelectionModel().getSelections();
    	var id = records[0].get('id')
		imageSelectWindow.show();
    	imageSelectWindow.imageSelectGrid.store.baseParams = {id:id};
    	imageSelectWindow.imageSelectGrid.store.load();
//		imageSelectWindow.imageSelectGrid.store.load();
//		this.msgType.setValue("image");
//		Ext.getCmp("toolbarDisplay222ID").setValue('<span  style="color:green;font-weight:bold;">未选择</span>');
	}
});


/*************onReady组件渲染处理***********************/
Ext.onReady(function(){
    Ext.QuickTips.init();                               //开启快速提示
    Ext.form.Field.prototype.msgTarget = 'side';        //提示方式"side"
    
    unteckAttachmentGrid = new UnteckAttachmentGrid(Ext.getBody().getViewSize().height);
    
    var param={};
    param['sclx'] = "1";
    unteckAttachmentGrid.store.baseParams = param;
    
    unteckAttachmentGrid.store.load({params:{start:0,limit:PAGESIZE}});
	new Ext.Viewport({
		layout: 'border',
		items: [
		        unteckAttachmentGrid   
		]
	});
});

