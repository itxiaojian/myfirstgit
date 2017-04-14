var USER_GRID_STORE_URL = 'getYsjlList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var ENTITY_URL_UPLOAD1 = "/jygl/YjyYsjl/uploadImage";
var IMAGE_GRID_STORE_URL = '/jygl/YjyYsjl/getImageList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;
/*************************************** UpdateForm组件 **************************************************/
UpdateForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
    	this.bgbh = this.createTextField('报告编号', 'bgbh', '90%','',null,100,'长度超过不能50');
    	
    	//做下拉框
    	this.ypjyzt = this.createCombo('报告状态', 'ZDZ', 'ZDMC', 'ypjyzt', '90%', PROJECT_NAME+'/jygl/YjyYsjl/getDicByLx1');
		this.ypjyzt.store.load();
    	
    	this.bzr = this.createTextField('编制人', 'bzr', '90%','',null,100,'长度超过不能50');
    	
    	this.ysjlsjm = this.createTextField('原始记录随机名', 'ysjlsjm', '80%','',null,100,'长度超过不能50');
    	this.ysjllj = this.createTextField('原始记录路径', 'ysjllj', '80%','',null,100,'长度超过不能50');
    	
    	this.bsdx = this.createTextField('报审对象', 'bsdx', '90%','',null,100,'长度超过不能500');
    	
    	this.jyrq =  new Ext.form.DateField({
			fieldLabel: '检验开始时间',
			name: "jyrq",
			format: "Y-m-d ",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.jyjsrq =  new Ext.form.DateField({
			fieldLabel: '检验结束时间',
			name: "jyjsrq",
			format: "Y-m-d ",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	//做下拉框
    	this.ywysjl = this.createCombo('有无原始记录', 'ZDZ', 'ZDMC', 'ywysjl', '90%', PROJECT_NAME+'/jygl/YjyYsjl/getDicByLx');
		this.ywysjl.store.load();
    	
    	this.scsj =  new Ext.form.DateField({
			fieldLabel: '上传时间',
			name: "scsj",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.scry = this.createTextField('上传人员', 'scry', '90%','',null,150,'长度超过不能11');
    	
    	this.bz = this.createTextField('备注', 'bz', '90%','',null,150,'长度超过不能11');
    	
    	this.ysjlwjm = new Ext.ux.form.FileUploadField({
			anchor:'90%',
			name: 'attachMentFile',
            emptyText: '请选择...',
            labelWidth: 67,
            fieldLabel: '原始记录',
            buttonCfg: {
                text: '浏览'
            }
	    });
    	
        this.bgbh.allowBlank = true;
        this.ypjyzt.allowBlank = true;
        this.bzr.allowBlank = true;
        this.bsdx.allowBlank = true;
        this.jyrq.allowBlank = true;
        this.jyjsrq.allowBlank = true;
        this.ywysjl.allowBlank = true;
        this.scry.allowBlank = true;
        this.scsj.allowBlank = true;
        this.ysjlsjm.allowBlank = true;
        this.ysjllj.allowBlank = true;
        this.bz.allowBlank = true;
        
        this.bgbh.readOnly = true;
        this.ypjyzt.readOnly = true;
        this.bzr.readOnly = true;
        this.bsdx.readOnly = true;
        this.jyrq.readOnly = true;
        this.jyjsrq.readOnly = true;
        this.ywysjl.readOnly = true;
        this.ysjlsjm.readOnly = true;
        this.scry.readOnly = true;
        this.scsj.readOnly = true;
        this.ysjllj.readOnly = true;
        this.bz.readOnly = true;
        
        
        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.3,  
                    layout:'form',  
                    border:false,  
                    labelWidth:50,
                    hidden:true,
                    labelAlign:'right',  
                    items:[  
                        this.ysjllj
                    ]  
                }),
                new Ext.Panel({  
                           columnWidth:.3,  
                           layout:'form',  
                           border:false,  
                           labelWidth:50,
                           hidden:true,
                           labelAlign:'right',  
                           items:[  
                               this.ysjlsjm
                           ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.3,  
                           layout:'form',  
                           border:false,  
                           labelWidth:50,
                           hidden:true,
                           labelAlign:'right',  
                           items:[  
                               this.bz
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
                           this.bgbh
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ypjyzt
                       ]  
                   }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
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
                           this.bzr
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.bsdx
                             ]  
                       }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
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
                        this.jyrq
                        ]  
                  }), 
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.jyjsrq
                        ]  
                  }), 

               ]  
        });
        var pnRow5=new Ext.Panel({  
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
                           this.ywysjl
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.ysjlwjm
                       ]  
                   }),
               ]
        });
        var pnRow6=new Ext.Panel({  
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
                        this.scry
                        ]  
                  }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'right',  
                   items:[  
                         this.scsj
                         ]  
                   }),
               ] 
        });
        
        UpdateForm.superclass.constructor.call(this, {
        	anchor: '80%',
        	autoHeight:true,
        	layoutConfig: {columns: 1},
        	labelWidth: 90,
            labelAlign :'right',
            frame:true,
            bodyStyle:"padding: 5px 5px 0",
            width: '100%',
            items: [
						pnRow1,
						pnRow2,
						pnRow3,
						pnRow4,
						pnRow6,
						pnRow5
            ],
            buttonAlign :'center',
            buttons: [
                      {text:'编辑',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text:'关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this},
//                      {text:'使用高影仪采集原始记录',iconCls: 'edit',handler:this.onGyyClick,scope:this}
              ]
        });
     },
     updateFormClick: function() {       //修改
    	 var record=constructionGrid.getSelectionModel().getSelections();
//    	 var className = portal.menu.EditPanel;
//         // 清空原有的信息
//         className.fromPanel.getForm().reset();
         if(this.getForm().isValid()) {
      	   var attachMentFileValue = this.ysjlwjm.getValue();
    	   var attachmentType = attachMentFileValue.substring(attachMentFileValue.lastIndexOf(".")+1).toLowerCase();
        	if(attachMentFileValue != null && attachMentFileValue != "") {
        	    if( attachmentType != "png"&& attachmentType != "jpg"&& attachmentType != "pdf"&& attachmentType != "doc"&& attachmentType != "docx"){
        	    	Ext.MessageBox.alert("系统提示:", BLANKSTR + "原始记录文件为png、jpg、pdf、doc或docx格式" + BLANKSTR);
        		    return;
        		    }
        	    
        	  //设置表单enctype属性
    	        $("#ext-gen13").attr("enctype","multipart/form-data");
     	        
             	this.getForm().submit({
                     waitMsg: '正在提交数据...',
//                     url: 'update', 
                     url:PROJECT_NAME+""+ENTITY_URL_UPLOAD1,
                     method: 'POST',
                     params:{
                     	id:record[0].get('ID'),
                     },
                     success: function(form, action) {
                     	Ext.MessageBox.alert("系统提示:", BLANKSTR + "编辑成功!" + BLANKSTR);
                     	constructionGrid.constructionUpdateWindow.hide();
                     	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                     },
                     failure: function(form, action) {
                     	Ext.MessageBox.alert("系统提示:", BLANKSTR + "编辑失败!" + BLANKSTR);
                     }
             	});
        	    
        	    }
        	}
       	
        
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     },
     
     onGyyClick: function() {    //点击弹出高影仪页面
 				var url = "gyyOnUse";  	
 				html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
 				ACT_DEAL_WINDOW = new ActDealWindow();
 				ACT_DEAL_WINDOW.setTitle("高影仪采集原始记录");
 				ACT_DEAL_WINDOW.html = html;
 				ACT_DEAL_WINDOW.show(); 
     }
     
});

/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
    	this.dlm = this.createTextField('<span style="color:red">*</span>登录名', 'dlm', '90%','',null,100,'长度超过不能50');
    	
    	this.xm = this.createTextField('<span style="color:red">*</span>姓名', 'xm', '90%','',null,100,'长度超过不能50');
    	
    	this.mm = this.createTextField('密码', 'mm', '90%','',null,100,'长度超过不能50');
    	
    	this.gwbh = this.createTextField('岗位编号', 'gwbh', '90%','',null,100,'长度超过不能50');
    	
    	this.bmmc = new zjyw.OrgSingelSelectAll('<span style="color:red">*</span>部门','bmmc','bmmc','90%');
    	
    	this.sjh = this.createTextField('手机号', 'sjh', '90%','',null,100,'长度超过不能500');
    	
    	this.yx = this.createTextField('邮箱', 'yx', '90%','',null,100,'长度超过不能100');
    	
    	this.oper_date =  new Ext.form.DateField({
			fieldLabel: '上次登录时间',
			name: "oper_date",
			format: "yyyy-mm-dd hh24:mi:ss",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	//做下拉框
    	this.yhzt = this.createCombo('状态', 'ZDZ', 'ZDMC', 'yhzt', '90%', PROJECT_NAME+'');
		this.yhzt.store.load();
    	
    	//做下拉框
    	this.cyzt = this.createCombo('是否有上岗证', 'ZDZ', 'ZDMC', 'cyzt', '90%', PROJECT_NAME+'');
		this.cyzt.store.load();
    	
    	this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能100');
    	
    	//做下拉框
    	this.xb = this.createCombo('性别', 'ZDZ', 'ZDMC', 'xb', '90%', PROJECT_NAME+'');
		this.xb.store.load();
    	
    	this.sr =  new Ext.form.DateField({
			fieldLabel: '生日',
			name: "sr",
			format: "Y-m-d",
			anchor: '90%',
			allowBlank: false,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
    	
    	this.lxdh = this.createTextField('联系电话', 'lxdh', '90%','',null,150,'长度超过不能11');
    	
    	//做下拉框
    	this.zw = this.createCombo('职务', 'ZDMC', 'ZDMC', 'zw', '90%', PROJECT_NAME+'');
		this.zw.store.load();
		this.zw.allowBlank = false;
    	
    	this.jtdz = this.createTextField('家庭地址', 'jtdz', '90%','',null,150,'长度超过不能150');
    	
    	//做下拉框
    	this.xl = this.createCombo('学历', 'ZDMC', 'ZDMC', 'xl', '90%', PROJECT_NAME+'');
		this.xl.store.load();
		this.xl.allowBlank = false;
    	
    	this.byyx = this.createTextField('毕业院校', 'byyx', '90%','',null,150,'长度超过不能50');
    	
    	//做下拉框
    	this.zzmm = this.createCombo('政治面貌', 'ZDMC', 'ZDMC', 'zzmm', '90%', PROJECT_NAME+'');
		this.zzmm.store.load();
		this.zzmm.allowBlank = false;
    	
    	this.mz = this.createTextField('民族', 'mz', '90%','',null,150,'长度超过不能50');

    	this.bm = this.createTextField('别名', 'bm', '90%','',null,150,'长度超过不能50');

    	this.yhpxh = this.createTextField('用户排序号', 'yhpxh', '90%','',null,150,'长度超过不能50');

    	this.glfw = this.createTextField('管理范围', 'glfw', '90%','',null,150,'长度超过不能50');

    	this.qq = this.createTextField('QQ', 'qq', '90%','',null,150,'长度超过不能50');

    	this.dzqm = new Ext.ux.form.FileUploadField({
			anchor:'90%',
			name: 'attachMentFile',
            emptyText: '请选择...',
            labelWidth: 67,
            fieldLabel: '电子签名',
            buttonCfg: {
                text: '浏览'
            }
	    });
    	
        this.dlm.allowBlank = false;
        this.xm.allowBlank = false;
        this.mm.allowBlank = true;
        this.bmmc.allowBlank = false;
        this.gwbh.allowBlank = true;
        this.sjh.allowBlank = true;
        this.yx.allowBlank = true;
        this.oper_date.allowBlank = true;
        this.yhzt.allowBlank = true;
        this.cyzt.allowBlank = true;
        this.sgzbh.allowBlank = true;
        this.xb.allowBlank = true;
        this.sr.allowBlank = true;
        this.lxdh.allowBlank = true;
        this.zw.allowBlank = true;
        this.jtdz.allowBlank = true;
        this.xl.allowBlank = true;
        this.byyx.allowBlank = true;
        this.zzmm.allowBlank = true;
        this.mz.allowBlank = true;
        this.bm.allowBlank = true;
        this.yhpxh.allowBlank = true;
        this.glfw.allowBlank = true;
        this.qq.allowBlank = true;
        

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
                new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,
                    hidden:true,
                    labelAlign:'right',  
                    items:[  
                        this.mm
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
                           this.dlm
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.xm
                       ]  
                   }),
               ]  
        });
        var pnRow3=new Ext.Panel({  
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
                           this.bmmc
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.zw
                             ]  
                       }),
               ]  
        });
        var pnRow4=new Ext.Panel({  
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
                        this.glfw
                        ]  
                  }), 
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.yhpxh
                        ]  
                  }), 

               ]  
        });
        var pnRow5=new Ext.Panel({  
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
                           this.cyzt
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sgzbh
                       ]  
                   }),
               ]
        });
        var pnRow6=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90, 
                  hidden: true,
                  labelAlign:'right',  
                  items:[  
                        this.yhzt
                        ]  
                  }),
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90, 
                   hidden: true,
                   labelAlign:'right',  
                   items:[  
                         this.oper_date
                         ]  
                   }),
               ] 
        });
        var pnRow7=new Ext.Panel({  
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
                           this.xb
                       ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.sr
                       ]  
                   }),
                   
               ] 
        });
        var pnRow8=new Ext.Panel({  
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
                        this.mz
                        ]  
                  }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.zzmm
                        ]  
                  }), 
                 ]  
              });
        var pnRow9=new Ext.Panel({  
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
                        this.sjh
                        ]  
                  }),
                  new Ext.Panel({  
                  columnWidth:.5,  
                  layout:'form',  
                  border:false,  
                  labelWidth:90,  
                  labelAlign:'right',  
                  items:[  
                        this.lxdh
                        ]  
                  }), 
                 ]  
              });
        var pnRow10=new Ext.Panel({  
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
                         this.yx
                         ]  
                    }),
                    new Ext.Panel({  
                    columnWidth:.5,  
                    layout:'form',  
                    border:false,  
                    labelWidth:90,  
                    labelAlign:'right',  
                    items:[  
                           this.qq
                          ]  
                    }),
                 ]  
              });
        var pnRow11=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                   new Ext.Panel({  
                   columnWidth:.5,  
                   layout:'form',  
                   border:false,  
                   labelWidth:90,  
                   labelAlign:'left',  
                   items:[  
                         this.xl
                         ]  
                   }), 
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.byyx
                             ]  
                       }),
                 ]  
              });
        var pnRow12=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[ 
                    
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.bm
                             ]  
                       }),
                       new Ext.Panel({  
                           columnWidth:.5,  
                           layout:'form',  
                           border:false,  
                           labelWidth:90,  
                           labelAlign:'left',  
                           items:[  
                                 this.jtdz
                                 ]  
                           }),
                 ]  
              });
        var pnRow13=new Ext.Panel({  
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
                           this.dzqm
                       ]  
                   }),
                 ]  
              });
        
        ConstructionForm.superclass.constructor.call(this, {
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
						pnRow3,
						pnRow4,
						pnRow5,
						pnRow6,
						pnRow7,
						pnRow8,
						pnRow9,
						pnRow10,
						pnRow11,
						pnRow12,
						pnRow13
            ],
            buttonAlign :'center',
            buttons: [
                      {text: '增加', width: 20,iconCls: 'add', hidden: false, handler: this.addFormClick, scope: this},  
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
       addFormClick: function() {
           if(this.getForm().isValid()) {
        	   var attachMentFileValue = this.dzqm.getValue();
        	   var attachmentType = attachMentFileValue.substring(attachMentFileValue.lastIndexOf(".")+1).toLowerCase();
	        	if(attachMentFileValue != null && attachMentFileValue != "") {
////	        		alert(attachMentFileValue);
//	        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "请选择电子签名!" + BLANKSTR);
//	        		return;
	        	
	        	
	        	if( attachmentType != "png" ){
	        		Ext.MessageBox.alert("系统提示:", BLANKSTR + "电子签名图片类型为png" + BLANKSTR);
	        		return;
	        	}
	        	}
	        	}
	        	
	        	//设置表单enctype属性
	        	$("#ext-gen11").attr("enctype","multipart/form-data");
	        	
        	   this.getForm().submit({
                   waitMsg: '正在提交数据...',
                   url:  PROJECT_NAME+""+ENTITY_URL_UPLOAD1,
                   method: 'POST',
                   params:{
                	  bmbh:this.bmmc.getOrgId(),
                   },
                   success: function(form, action) { 
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!" + BLANKSTR);
                 	constructionGrid.constructionInsertWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!" + BLANKSTR);
                 }
         	});
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


/***************************************ConstructionInsertWindow组件**************************************************/
ConstructionInsertWindow = Ext.extend(Ext.Window,{
	constructionForm : null,
    constructor: function(grid) {
        this.constructionForm = new ConstructionForm();
        ConstructionInsertWindow.superclass.constructor.call(this, {
            title: "人员登记",
            width: 800,
            anchor: '100%',
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.constructionForm]
        });
    }
});

/***************************************ConstructionUpdateWindow组件**************************************************/
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	updateForm : null,
    constructor: function() {
    	this.updateForm = new UpdateForm();
    	ConstructionUpdateWindow.superclass.constructor.call(this, {
        	title: "上传报告原始信息",
            width: 900,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.updateForm]
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


/*****************************ImageSelectWindow***************
 *description   : 查看电子签名window
*************************************************************/
ImageSelectWindow = Ext.extend(Ext.Window, {
    constructor: function() {
    	this.imageSelectGrid = new ImageSelectGrid(); 	
    	ImageSelectWindow.superclass.constructor.call(this, {
    		title:'查看原始记录图片',
    		width: '100%',
    		height:'200%',
			anchor: '100%',
			autoHeight: true,
			resizable: false,
			plain: true,
			modal: true,
			closeAction: 'hide',
            items: [this.imageSelectGrid],
        	buttonAlign:'center',
	        buttons:[
			         {text:'关闭',width: 20,iconCls: 'delete', handler:this.closeClick, scope:this}
	        ]	
    	});
    },
    closeClick: function() {
    	this.hide();
    }
    
});

/*****************************ImageSelectGrid*****************
 *description   : 查看电子签名grid
*************************************************************/
ImageSelectGrid = Ext.extend(UxGrid, {
    store:null,
    constructor: function(height, width){

    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+IMAGE_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({fields:[
                   {name:'YSJLWJM'},{name:'YSJLSJM'},{name:'YSJLLJ'}
            ]})
        });
    	
        var sm = new Ext.grid.CheckboxSelectionModel({singleSelect:true}); 
        ImageSelectGrid.superclass.constructor.call(this, {
        	region:'center',
        	stripeRows: true,
            frame: true,
            height: 515,
            viewConfig: {
                forceFit: false
            },
            loadMask: {
                msg : '正在载入数据,请稍候...'
            },
            sm: sm,
            cm: new Ext.grid.ColumnModel([
                {header:'',dataIndex:'YSJLWJM',width:1200,sortable: true,
            		renderer:function(data, metadata, record){
            			var srcurl = PROJECT_NAME+"/"+record.data.YSJLLJ + "/" + record.data.YSJLWJM ;
            			return "<img height=100% width=100% src = '" + srcurl + "'></img>";
            		}
                },
            ]),
            ds: this.store
        });
    },
    selectedRecord: function() {
        var record = this.getSelectionModel().getSelected();
        return record;
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
                            {name:'ID'},{name:'BID'},{name:'BGBH'},{name:'YWYSJL'},{name:'YSJLWJM'},{name:'YSJLLJ'},
                            {name:'YSJLSJM'},{name:'SCRY'},{name:'SCSJ'},{name:'BZ'},{name:'BZR'},
                            {name:'YPJYZT'},{name:'BZFS'},{name:'BSDX'},{name:'JYJSRQ'},{name:'JYRQ'},
                            
            ])
        });
    	this.vtbar = new Ext.Toolbar({
            items:[
//                '-',{text:'新增',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
            	'-',{text:'批量删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'报告编号...',  
               	    },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				}},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			}},
//         		'-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
//     		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
//    		        	    if(btn=="yes"){ 
//    		        	    	window.open(PROJECT_NAME+"/resources/js/yhgl/OAyhxx.xls");
//    		        	   }
//    		        	 });
//    		    	 },scope:this},
//    		      '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
//                  '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
//	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
//			        	    if(btn=="yes"){ 		        	    	
//			        	    	var fileName = "OA用户信息";
//			        	    	var code = Ext.getCmp('code').getValue();
//			        	    	var url = PROJECT_NAME + "/yhgl/SysYh/export?fileName="+fileName+"&code="+code;
//			        	    	url = encodeURI(url);
//			        	    	url = encodeURI(url);
//			        	    	window.open(url);
//			        	   }
//			        	 });
//	   		    		}
//    		      }
            ]
        });
    	
    	this.vbbar= new Ext.PagingToolbar({ 
            pageSize: PAGESIZE, 
            store: this.store, 
            displayInfo: true, 
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条', 
            emptyMsg: "没有记录" 
    	});
   	
        this.constructionInsertWindow = new ConstructionInsertWindow();       
        this.constructionUpdateWindow = new ConstructionUpdateWindow();
        
        imageSelectWindow = new ImageSelectWindow();
		this.vsm = new Ext.grid.CheckboxSelectionModel();
		this.vcm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		             this.vsm,
//		                         原始记录管理的id     
                {header:'ID',dataIndex:'ID',width:70,sortable: true,hidden:true},
                {header:'BID',dataIndex:'BID',width:70,sortable: true,hidden:true},
                {header:'BZ',dataIndex:'BZ',width:70,sortable: true,hidden:true},
                {header:'原始记录随机名',dataIndex:'YSJLSJM',width:90,sortable: true,hidden:true},
                {header:'报告编号',dataIndex:'BGBH',width:90,sortable: true},
                {header:'报告状态',dataIndex:'YPJYZT',width:70,sortable: true,
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
            	{header:'编制人',dataIndex:'BZR',width:70,sortable: true},
            	{header:'报审对象',dataIndex:'BSDX',width:70,sortable: true},
            	{header:'检验时间',dataIndex:'JYRQ',width:90,sortable: true},
                {header:'是否有原始记录',dataIndex:'YWYSJL',width:100,sortable: true,
             		 renderer:function(value){
                          if(value == '0'||value == null) {
                              return "<span>是</span>";
                          }else if(value == '1') {
                              return "<span>否</span>";
                          }else{
                          	return value;
                          }
                  	 }
             		},
         		{header:'原始记录',dataIndex:'YWYSJL',width:100,sortable: true,
          			renderer:function(value, cellmeta, record){
                    	var id = record.data.id;
                    	if(record.get("BZ") == 1){
                    		return "<a href='javascript:;' onclick='constructionGrid.onTpClick()' style='text-decoration:none;'>点击查看</a>";
                    	}else if(record.get("BZ") == 2 || record.get("BZ") == 3){
                    		return "<a href='javascript:;' onclick='constructionGrid.onBjiClick()' style='text-decoration:none;'>点击查看</a>";
                    	}else{
                    		return "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
 		                    "<span style='width: 25px;color:gray;'>请上传原始记录</span></a>";
                    	}
                    }
          			},
            	{header:'上传人员',dataIndex:'SCRY',width:70,sortable: true},
            	{header:'上传时间',dataIndex:'SCSJ',width:90,sortable: true},
            	{header:'备注',dataIndex:'ZW',width:70,sortable: true,hidden:true},
              	{header:'操作', width: 180, align:"center",sortable: true,hidden: false,
              			renderer:function(){
						return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
				   		"<span style='width: 26px;cursor: pointer;'>编辑</span></a>"+
				   		"&nbsp&nbsp&nbsp&nbsp"+
				   		"<a href='javascript:;' onclick='constructionGrid.onGyyClick()' style='text-decoration:none;'>" +
				   		"<span style='width: 26px;cursor: pointer;'>高拍仪采集</span></a>"+
				   		"&nbsp&nbsp&nbsp&nbsp"+
				   		"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
				   		"<span style='width: 26px;cursor: pointer;color:red;'>删除</span></a>";
						}
            	}
         ]);
		ConstructionGrid.superclass.constructor.call(this,{
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
	            ds: this.store,
        });
    },
    
    onUploadClick: function(){
    	if(!this.ipasAssobjBankmemberUploadWindow)
    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
    	var win = this.ipasAssobjBankmemberUploadWindow;
    	win.show();
    	win.ipasAssobjBankmember.getForm().reset();
    },
    
    onAddClick: function() {
    	var win = this.constructionInsertWindow;
    	win.constructionForm.getForm().reset();
    	win.show();
    },
    
    onTpClick: function(){        //点击查看图片类型的原始记录
		var records=this.getSelectionModel().getSelections();
    	var id = records[0].get('ID')
		imageSelectWindow.show();
    	imageSelectWindow.imageSelectGrid.store.baseParams = {id:id};
    	imageSelectWindow.imageSelectGrid.store.load();
	},
	onBjiClick: function(){   //点击查看文档类型的原始记录
		var records = this.getSelectionModel().getSelections();
		var ysjlsjm=records[0].get('YSJLSJM');
		var bz=records[0].get('BZ');
		var url = "WordOnLine?ysjlsjm="+ysjlsjm+"&bz="+bz;
		html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
		ACT_DEAL_WINDOW = new ActDealWindow();
		ACT_DEAL_WINDOW.setTitle("查看原始记录文档");
		ACT_DEAL_WINDOW.html = html;
		ACT_DEAL_WINDOW.show();
	},
    
//	 onModifyClick: function() {    //修改
//	    	var records=this.getSelectionModel().getSelections();
//	   		if(records.length > 0) {
//	   			if(records.length == 1){
//	   				vrecord = records[0];
//	   				var id=records[0].get('ID');
//	   				var bid=records[0].get('BID');
////	   				alert(id);
////	   				alert(bid);
//					var url = "ysjlUpdateView?id="+id+"&bid="+bid;  	
//					html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+url+'"></iframe>';    		
//					ACT_DEAL_WINDOW = new ActDealWindow();
//					ACT_DEAL_WINDOW.setTitle("编辑原始记录");
//					ACT_DEAL_WINDOW.html = html;
//					ACT_DEAL_WINDOW.show(); 
//
//	   			}else{
//	   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
//	   			}
//	   		}else{
//	   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
//	   		}    	
//	    },
	    
	    onGyyClick: function(){   //点击使用高影仪
			var records = this.getSelectionModel().getSelections();
			var bgbh=records[0].get('BGBH');
			var url = "gyyOnUse?bgbh="+bgbh;
			html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
			ACT_DEAL_WINDOW = new ActDealWindow();
			ACT_DEAL_WINDOW.setTitle("高拍仪采集");
			ACT_DEAL_WINDOW.html = html;
			ACT_DEAL_WINDOW.show();
		},
    
    onModifyClick: function() {     //编辑
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.updateForm.getForm().reset();
   		    	win.show();
   		    	win.updateForm.bgbh.setValue(vrecord.data.BGBH);
   		    	win.updateForm.ypjyzt.setValue(vrecord.data.YPJYZT);
   		    	win.updateForm.bzr.setValue(vrecord.data.BZR);
   		    	win.updateForm.bsdx.setValue(vrecord.data.BSDX);
   		    	win.updateForm.jyrq.setValue(vrecord.data.JYRQ);
   		    	win.updateForm.ywysjl.setValue(vrecord.data.YWYSJL);
   		    	win.updateForm.ysjllj.setValue(vrecord.data.YSJLLJ);
   		    	win.updateForm.ysjlwjm.setValue(vrecord.data.YSJLWJM);
   		    	win.updateForm.ysjlsjm.setValue(vrecord.data.YSJLSJM);
   		    	win.updateForm.scry.setValue(vrecord.data.SCRY);
   		    	win.updateForm.scsj.setValue(vrecord.data.SCSJ);
   		    	win.updateForm.bz.setValue(vrecord.data.BZ);
   			}else{
   				Ext.Msg.alert('系统提示', '不能编辑多条记录..');
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
//	       	alert(valueStr);
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条报告的原始记录吗",function(btn){
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
