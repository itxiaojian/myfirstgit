var USER_GRID_STORE_URL = 'getSysyhList';
var PAGESIZE=20;
var ENTITY_URL_UPLOAD = 'upload';
var ENTITY_URL_UPLOAD1 = "/yhgl/SysYh/uploadImage";
var IMAGE_GRID_STORE_URL = '/yhgl/SysYh/getImageList';
var yearll=new Ext.form.TextField();
var amtd = new Ext.form.TextField();

//添加页面
var ACT_DEAL_WINDOW;

/*************************************** LookForm组件 **************************************************/
LookForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() {
    	
    	this.dlm = this.createTextField('登录名', 'dlm', '90%','',null,100,'长度超过不能50');
    	
    	this.xm = this.createTextField('姓名', 'xm', '90%','',null,100,'长度超过不能50');
    	
    	this.mm = this.createTextField('密码', 'mm', '90%','',null,100,'长度超过不能50');
    	
    	this.gwbh = this.createTextField('岗位编号', 'gwbh', '90%','',null,100,'长度超过不能50');
    	
    	this.bmmc = this.createTextField('部门', 'bmmc', '90%','',null,100,'长度超过不能500');
    	
    	this.jbm1 = this.createTextField('兼部门1', 'jbm1', '90%','',null,100,'长度超过不能500');
    	
    	this.jbm2 = this.createTextField('兼部门2', 'jbm2', '90%','',null,100,'长度超过不能500');
    	
    	this.jbm3 = this.createTextField('兼部门3', 'jbm3', '90%','',null,100,'长度超过不能500');
    	
    	this.jbm4 = this.createTextField('兼部门4', 'jbm4', '90%','',null,100,'长度超过不能500');
    	
    	this.sjh = this.createTextField('手机号', 'sjh', '90%','',null,100,'长度超过不能500');
    	
    	this.yx = this.createTextField('邮箱', 'yx', '90%','',null,100,'长度超过不能100');
    	
    	this.oper_date = this.createTextField('上次登录时间', 'oper_date', '90%','',null,100,'长度超过不能100');
    	
    	this.yhzt = this.createCombo('状态', 'ZDZ', 'ZDMC', 'yhzt', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx1');
		this.yhzt.store.load();
    	
    	this.cyzt = this.createCombo('是否有上岗证', 'ZDZ', 'ZDMC', 'cyzt', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx');
		this.cyzt.store.load();
    	
    	this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能100');
    	
    	this.xb = this.createCombo('性别', 'ZDZ', 'ZDMC', 'xb', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx2');
		this.xb.store.load();
    	
    	this.sr = this.createTextField('生日', 'sr', '90%','',null,100,'长度超过不能100');
    	
    	this.lxdh = this.createTextField('联系电话', 'lxdh', '90%','',null,150,'长度超过不能11');
    	
    	this.zw = this.createTextField('职务', 'zw', '90%','',null,150,'长度超过不能11');
    	
    	this.jtdz = this.createTextField('家庭地址', 'jtdz', '90%','',null,150,'长度超过不能150');
    	
    	this.xl = this.createTextField('学历', 'xl', '90%','',null,150,'长度超过不能150');
    	
    	this.byyx = this.createTextField('毕业院校', 'byyx', '90%','',null,150,'长度超过不能50');
    	
    	this.zzmm = this.createTextField('政治面貌', 'zzmm', '90%','',null,150,'长度超过不能50');
    	
    	this.mz = this.createTextField('民族', 'mz', '90%','',null,150,'长度超过不能50');

    	this.bm = this.createTextField('别名', 'bm', '90%','',null,150,'长度超过不能50');

    	this.yhpxh = this.createTextField('用户排序号', 'yhpxh', '90%','',null,150,'长度超过不能50');

    	this.glfw = this.createTextField('管理范围', 'glfw', '90%','',null,150,'长度超过不能50');

    	this.qq = this.createTextField('QQ', 'qq', '90%','',null,150,'长度超过不能50');
    	
    	this.dzqm = this.createTextField('电子签名', 'dzqm', '90%','',null,150,'长度超过不能50');
    	
         this.dlm.allowBlank = true;
         this.xm.allowBlank = true;
         this.mm.allowBlank = true;
         this.bmmc.allowBlank = true;
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
         this.dzqm.allowBlank = true;
         this.jbm1.allowBlank = true;
         this.jbm2.allowBlank = true;
         this.jbm3.allowBlank = true;
         this.jbm4.allowBlank = true;
         

         this.dlm.readOnly = true;
         this.xm.readOnly = true;
         this.mm.readOnly = true;
         this.bmmc.readOnly = true;
         this.gwbh.readOnly = true;
         this.sjh.readOnly = true;
         this.yx.readOnly = true;
         this.oper_date.readOnly = true;
         this.yhzt.readOnly = true;
         this.cyzt.readOnly = true;
         this.sgzbh.readOnly = true;
         this.xb.readOnly = true;
         this.sr.readOnly = true;
         this.lxdh.readOnly = true;
         this.zw.readOnly = true;
         this.jtdz.readOnly = true;
         this.xl.readOnly = true;
         this.byyx.readOnly = true;
         this.zzmm.readOnly = true;
         this.mz.readOnly = true;
         this.bm.readOnly = true;
         this.yhpxh.readOnly = true;
         this.glfw.readOnly = true;
         this.qq.readOnly = true;
         this.dzqm.readOnly = true;
         this.jbm1.readOnly = true;
         this.jbm2.readOnly = true;
         this.jbm3.readOnly = true;
         this.jbm4.readOnly = true;
         
 
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
         var pnRow24=new Ext.Panel({  
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
                            this.jbm1
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'left',  
                        items:[  
                              this.jbm2
                              ]  
                        }),
                ]  
         });
         var pnRow99=new Ext.Panel({  
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
                            this.jbm3
                        ]  
                    }),
                    new Ext.Panel({  
                        columnWidth:.5,  
                        layout:'form',  
                        border:false,  
                        labelWidth:90,  
                        labelAlign:'left',  
                        items:[  
                              this.jbm4
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
         
         LookForm.superclass.constructor.call(this, {
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
 						pnRow24,
 						pnRow99,
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
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** UpdateForm组件 **************************************************/
UpdateForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
    	this.yhbh = this.createTextField('用户编号', 'yhbh', '90%','',null,100,'长度超过不能50');
    	
    	this.dlm = this.createTextField('<span style="color:red">*</span>登录名', 'dlm', '90%','',null,100,'长度超过不能50');
    	
    	this.xm = this.createTextField('<span style="color:red">*</span>姓名', 'xm', '90%','',null,100,'长度超过不能50');
    	
    	this.mm = this.createTextField('密码', 'mm', '80%','',null,100,'长度超过不能50');
    	this.dzqmlj = this.createTextField('电子签名路径', 'dzqmlj', '80%','',null,100,'长度超过不能50');
    	this.yhjs = this.createTextField('用户角色', 'yhjs', '80%','',null,100,'长度超过不能50');
    	
    	this.gwbh = this.createTextField('岗位编号', 'gwbh', '90%','',null,100,'长度超过不能50');
    	
    	this.bmmc = new zjyw.OrgSingelSelectAll('<span style="color:red">*</span>部门','bmmc','bmmc','90%');
    	
        this.jbm1 = new zjyw.OrgSingelSelectAll('兼部门1','jbm1','jbm1','90%');
    	
    	this.jbm2 = new zjyw.OrgSingelSelectAll('兼部门2','jbm2','jbm2','90%');
    	
    	this.jbm3 = new zjyw.OrgSingelSelectAll('兼部门3','jbm3','jbm3','90%');
    	
    	this.jbm4 = new zjyw.OrgSingelSelectAll('兼部门4','jbm4','jbm4','90%');
    	
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
    	this.yhzt = this.createCombo('状态', 'ZDZ', 'ZDMC', 'yhzt', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx1');
		this.yhzt.store.load();
    	
    	//做下拉框
    	this.cyzt = this.createCombo('是否有上岗证', 'ZDZ', 'ZDMC', 'cyzt', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx');
		this.cyzt.store.load();
    	
    	this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能100');
    	
    	//做下拉框
    	this.xb = this.createCombo('性别', 'ZDZ', 'ZDMC', 'xb', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx2');
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
    	this.zw = this.createCombo('职务', 'ZDMC', 'ZDMC', 'zw', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx5');
		this.zw.store.load();
    	
    	this.jtdz = this.createTextField('家庭地址', 'jtdz', '90%','',null,150,'长度超过不能150');
    	
    	//做下拉框
    	this.xl = this.createCombo('学历', 'ZDMC', 'ZDMC', 'xl', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx3');
		this.xl.store.load();
    	
    	this.byyx = this.createTextField('毕业院校', 'byyx', '90%','',null,150,'长度超过不能50');
    	
    	//做下拉框
    	this.zzmm = this.createCombo('政治面貌', 'ZDMC', 'ZDMC', 'zzmm', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx4');
		this.zzmm.store.load();
    	
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
            regex:/(png)$/i,
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
        this.dzqm.allowBlank = true;
        this.dzqmlj.allowBlank = true;
        this.yhjs.allowBlank = true;
        this.jbm1.allowBlank = true;
        this.jbm2.allowBlank = true;
        this.jbm3.allowBlank = true;
        this.jbm4.allowBlank = true;
        
        this.dlm.readOnly = true;
        this.oper_date.readOnly = true;
        this.yhpxh.readOnly = true;
        this.dzqm.readOnly = true;
        
        
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
                        this.mm
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
                               this.dzqmlj
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
		                              this.yhjs
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
        var pnRow24=new Ext.Panel({  
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
                           this.jbm1
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.jbm2
                             ]  
                       }),
               ]  
        });
        var pnRow99=new Ext.Panel({  
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
                           this.jbm3
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.jbm4
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
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,
                       hidden:true,
                       labelWidth:90,  
                       labelAlign:'right',  
                       items:[  
                           this.yhbh
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
						pnRow24,
						pnRow99,
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
                      {text:'修改',iconCls: 'edit',handler:this.updateFormClick,scope:this},
                      {text: '关闭', width: 20,iconCls:'delete', handler: this.onCloseClick, scope: this}
              ]
        });
     },
     updateFormClick: function() {       //修改
    	 var record=constructionGrid.getSelectionModel().getSelections();
//    	 var className = portal.menu.EditPanel;
//         // 清空原有的信息
//         className.fromPanel.getForm().reset();
         if(this.getForm().isValid()) {
      	   var attachMentFileValue = this.dzqm.getValue();
    	   var attachmentType = attachMentFileValue.substring(attachMentFileValue.lastIndexOf(".")+1).toLowerCase();
        	if(attachMentFileValue != null && attachMentFileValue != "") {
        	    if( attachmentType != "png"){
        		    Ext.MessageBox.alert("系统提示:", BLANKSTR + "电子签名图片类型为png" + BLANKSTR);
        		    return;
        		    }
        	    }
        	}
       	
        //设置表单enctype属性
	        $("#ext-gen13").attr("enctype","multipart/form-data");
 	        
         	this.getForm().submit({
                 waitMsg: '正在提交数据...',
//                 url: 'update', 
                 url:PROJECT_NAME+""+ENTITY_URL_UPLOAD1,
                 method: 'POST',
                 params:{
                 	id:record[0].get('YHBH'),
//                 	bmbh:this.bmmc.getOrgId(),
//              	    jbm1:this.jbm1.getOrgId(),
//              	    jbm2:this.jbm2.getOrgId(),
//              	    jbm3:this.jbm3.getOrgId(),
//              	    jbm4:this.jbm4.getOrgId(),
                 },
                 success: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!" + BLANKSTR);
                 	constructionGrid.constructionUpdateWindow.hide();
                 	constructionGrid.vbbar.doLoad(constructionGrid.vbbar.cursor);
                 },
                 failure: function(form, action) {
                 	Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!" + BLANKSTR);
                 }
         	});
     },
     onCloseClick: function(){ 			//关闭
         this.ownerCt.hide();
     }
});

/*************************************** ConstructionForm组件 **************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {
	
    constructor: function() { 
    	    	
//    	this.yhbh = this.createTextField('用户编号', 'yhbh', '90%','',null,100,'长度超过不能50');
    	
    	this.dlm = this.createTextField('<span style="color:red">*</span>登录名', 'dlm', '90%','',null,100,'长度超过不能50');
    	
    	this.xm = this.createTextField('<span style="color:red">*</span>姓名', 'xm', '90%','',null,100,'长度超过不能50');
    	
    	this.mm = this.createTextField('密码', 'mm', '90%','',null,100,'长度超过不能50');
    	
    	this.gwbh = this.createTextField('岗位编号', 'gwbh', '90%','',null,100,'长度超过不能50');
    	
//    	this.bmmc = this.createTextField('部门名称', 'bmmc', '90%','',null,100,'长度超过不能50');
    	
    	this.bmmc = new zjyw.OrgSingelSelectAll('<span style="color:red">*</span>部门','bmmc','bmmc','90%');
    	
    	this.jbm1 = new zjyw.OrgSingelSelectAll('兼部门1','jbm1','jbm1','90%');
    	
    	this.jbm2 = new zjyw.OrgSingelSelectAll('兼部门2','jbm2','jbm2','90%');
    	
    	this.jbm3 = new zjyw.OrgSingelSelectAll('兼部门3','jbm3','jbm3','90%');
    	
    	this.jbm4 = new zjyw.OrgSingelSelectAll('兼部门4','jbm4','jbm4','90%');
    	
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
    	
//    	this.yhzt = this.createTextField('状态', 'yhzt', '90%','',null,100,'长度超过不能100');
    	
    	//做下拉框
    	this.yhzt = this.createCombo('状态', 'ZDZ', 'ZDMC', 'yhzt', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx1');
		this.yhzt.store.load();
//		this.yhzt.allowBlank = false;
    	
//    	this.cyzt = this.createTextField('是否持有上岗证', 'cyzt', '90%','',null,100,'长度超过不能100');
    	
    	//做下拉框
    	this.cyzt = this.createCombo('是否有上岗证', 'ZDZ', 'ZDMC', 'cyzt', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx');
		this.cyzt.store.load();
//		this.cyzt.allowBlank = false;
    	
    	this.sgzbh = this.createTextField('上岗证编号', 'sgzbh', '90%','',null,100,'长度超过不能100');
    	
//    	this.xb = this.createTextField('性别', 'xb', '90%','',null,100,'长度超过不能100');
    	
    	//做下拉框
    	this.xb = this.createCombo('性别', 'ZDZ', 'ZDMC', 'xb', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx2');
		this.xb.store.load();
//		this.xb.allowBlank = false;
    	
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
    	
//    	this.zw = this.createTextField('职务', 'zw', '90%','',null,150,'长度超过不能11');
    	
    	//做下拉框
    	this.zw = this.createCombo('职务', 'ZDMC', 'ZDMC', 'zw', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx5');
		this.zw.store.load();
		this.zw.allowBlank = false;
    	
    	this.jtdz = this.createTextField('家庭地址', 'jtdz', '90%','',null,150,'长度超过不能150');
    	
//    	this.xl = this.createTextField('学历', 'xl', '90%','',null,150,'长度超过不能150');
    	
    	//做下拉框
    	this.xl = this.createCombo('学历', 'ZDMC', 'ZDMC', 'xl', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx3');
		this.xl.store.load();
		this.xl.allowBlank = false;
    	
    	this.byyx = this.createTextField('毕业院校', 'byyx', '90%','',null,150,'长度超过不能50');
    	
//    	this.zzmm = this.createTextField('政治面貌', 'zzmm', '90%','',null,150,'长度超过不能50');
    	
    	//做下拉框
    	this.zzmm = this.createCombo('政治面貌', 'ZDMC', 'ZDMC', 'zzmm', '90%', PROJECT_NAME+'/yhgl/SysYh/getDicByLx4');
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
    	
//        this.yhbh.allowBlank = true;
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
        this.jbm1.allowBlank = true;
        this.jbm2.allowBlank = true;
        this.jbm3.allowBlank = true;
        this.jbm4.allowBlank = true;
        

        var pnRow1=new Ext.Panel({  
            layout:'column',  
            border:false,  
            items:[  
//                new Ext.Panel({  
//                    columnWidth:.5,  
//                    layout:'form',  
//                    border:false,  
//                    labelWidth:90,
//                    hidden:true,
//                    labelAlign:'right',  
//                    items:[  
//                        this.yhbh
//                    ]  
//                }), 
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
                           this.jbm1
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.jbm2
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
                           this.jbm3
                       ]  
                   }),
                   new Ext.Panel({  
                       columnWidth:.5,  
                       layout:'form',  
                       border:false,  
                       labelWidth:90,  
                       labelAlign:'left',  
                       items:[  
                             this.jbm4
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
        var pnRow8=new Ext.Panel({  
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
        var pnRow11=new Ext.Panel({  
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
        var pnRow12=new Ext.Panel({  
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
        var pnRow13=new Ext.Panel({  
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
        var pnRow14=new Ext.Panel({  
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
        var pnRow15=new Ext.Panel({  
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
						pnRow13,
						pnRow14,
						pnRow15
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
//                	  bmbh:this.bmmc.getOrgId(),
//                	  jbm1:this.jbm1.getOrgId(),
//                	  jbm2:this.jbm2.getOrgId(),
//                	  jbm3:this.jbm3.getOrgId(),
//                	  jbm4:this.jbm4.getOrgId(),
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
        	title: "修改系统用户信息",
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

/***************************************ConstructionLookWindow组件**************************************************/
ConstructionLookWindow = Ext.extend(Ext.Window, {
	lookForm : null,
    constructor: function() {
    	this.lookForm = new LookForm();
    	ConstructionLookWindow.superclass.constructor.call(this, {
        	title: "查看系统用户信息",
            width: 800,
            autoHeight:true,
            resizable : false,
            plain: true,
            modal: true,
            autoScroll: true,
            closeAction: 'hide',
            items: [this.lookForm]
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
    		title:'查看电子签名',
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
 *description   : 查看电子签名grid
*************************************************************/
ImageSelectGrid = Ext.extend(UxGrid, {
    store:null,
    constructor: function(height, width){

    	this.store = new Ext.data.Store({          //Grid Store
            proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+""+IMAGE_GRID_STORE_URL, method: 'POST'}),
            reader: new Ext.data.JsonReader({fields:[
                   {name:'DZQM'},{name:'YHJS'},{name:'DZQMLJ'}
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
                {header:'',dataIndex:'DZQM',width:450,sortable: true,
            		renderer:function(data, metadata, record){
            			var srcurl = PROJECT_NAME+"/"+record.data.DZQMLJ + "/" + record.data.YHJS ;
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
                            {name:'YHBH'},{name:'DLM'},{name:'XM'},{name:'MM'},{name:'BMMC'},
                            {name:'GWBH'},{name:'SJH'},{name:'YX'},{name:'YHZT'},{name:'OPER_DATE'},
                            {name:'CYZT'},{name:'SGZBH'},{name:'XB'},{name:'SR'},{name:'LXDH'},
                            {name:'ZW'},{name:'JTDZ'},{name:'XL'},{name:'BYYX'},{name:'ZZMM'},
                            {name:'MZ'},{name:'BM'},{name:'YHPXH'},{name:'GLFW'},{name:'QQ'},
                            {name:'DZQMLJ'},{name:'DZQM'},{name:'YHJS'},{name:'JBM1'},{name:'JBM2'},
                            {name:'JBM3'},{name:'JBM4'}
                            
            ])
        });
    	this.vtbar = new Ext.Toolbar({
            items:[
                '-',{text:'新增',iconCls: 'add',handler:this.onAddClick,scope:this},
//                '-',{text:'修改',iconCls: 'edit',handler:this.onModifyClick,scope:this},
//            	'-',{text:'删除',iconCls: 'delete',handler:this.onDeleteClick,scope:this},
                '-',{xtype:'textfield',id:'code',width: 150,
                	   emptyText:'登录名&姓名...',  
               	    },
    	  		'-',{xtype:'button',text:'查询',iconCls:'query',handler:function(){
      						var code = Ext.getCmp('code').getValue();
      						constructionGrid.store.baseParams= {code:code};
      						constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
      				}},
      		    '-',{xtype:'button',text:'清空',iconCls:'redo',handler:function(){
      	   				Ext.getCmp('code').setValue("");
         			}},
         		'-',{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
     		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
    		        	    if(btn=="yes"){ 
    		        	    	window.open(PROJECT_NAME+"/resources/js/yhgl/OAyhxx.xls");
    		        	   }
    		        	 });
    		    	 },scope:this},
    		      '-',{xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
                  '-',{xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
	   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
			        	    if(btn=="yes"){ 		        	    	
			        	    	var fileName = "OA用户信息";
			        	    	var code = Ext.getCmp('code').getValue();
			        	    	var url = PROJECT_NAME + "/yhgl/SysYh/export?fileName="+fileName+"&code="+code;
			        	    	url = encodeURI(url);
			        	    	url = encodeURI(url);
			        	    	window.open(url);
			        	   }
			        	 });
	   		    		}
    		      }
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
        this.constructionLookWindow = new ConstructionLookWindow();
        
        imageSelectWindow = new ImageSelectWindow();
		this.vsm = new Ext.grid.CheckboxSelectionModel();
		this.vcm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		             this.vsm,
                {header:'用户编号',dataIndex:'YHBH',width:70,sortable: true, hidden:true},
                {header:'登录名',dataIndex:'DLM',width:70,sortable: true},
            	{header:'姓名',dataIndex:'XM',width:70,sortable: true},
            	{header:'密码',dataIndex:'MM',width:90,sortable: true,hidden:true},
            	{header:'部门',dataIndex:'BMMC',width:100,sortable: true},
            	{header:'职务',dataIndex:'ZW',width:70,sortable: true},
            	{header:'管理范围',dataIndex:'GLFW',width:70,sortable: true},
            	{header:'性别',dataIndex:'XB',width:60,sortable: true,hidden:true,
              		 renderer:function(value){
                           if(value == '0') {
                               return "<span>男</span>";
                           }else if(value == '1') {
                               return "<span>女</span>";
                           }else{
                           	return value;
                           }
                   	 }
              		},
            	{header:'用户排序号',dataIndex:'YHPXH',width:90,sortable: true,hidden:true},
            	{header:'岗位编号',dataIndex:'GWBH',width:90,sortable: true,hidden:true,hidden:true},
            	{header:'是否持有上岗证',dataIndex:'CYZT',width:90,sortable: true,hidden:true,
           			renderer:function(value){
                        if(value == '0') {
                            return "<span>持有</span>";
                        }else if(value == '1') {
                            return "<span>未持有</span>";
                        }else{
                        	return value;
                        }
                	 }
            	},
            	{header:'上岗证编号',dataIndex:'SGZBH',width:90,sortable: true,hidden:true},
            	{header:'状态',dataIndex:'YHZT',width:60,sortable: true,
              		 renderer:function(value){
                           if(value == '2') {
                               return "<span>禁用</span>";
                           }else if(value == '1') {
                               return "<span>启用</span>";
                           }else{
                           	return value;
                           }
                   	 }
              		},
//          		{header:'上次登录时间',dataIndex:'OPER_DATE',width:140,sortable: true},
              	{header:'电子签名',dataIndex:'DZQM',width:100,sortable: true,
              			renderer:function(value, cellmeta, record){
	                    	var id = record.data.id;
	                    	if(record.get("DZQM") != null){
	                    		return "<a href='javascript:;' onclick='constructionGrid.onTpClick()' style='text-decoration:none;'>点击查看</a>";
	                    	}else {
	                    		return "<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" + 
	 		                    "<span style='width: 25px;color:gray;'>请上传电子签名</span></a>";
	                    	}
	                    }
              			},
              	{header: '操作', width: 150, align:"center",sortable: true,hidden: false,
              			renderer:function(value, cellmeta, record){
    						if(record.get("DLM") != 'admin'){
    						   return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
   					   		"<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
					   		"&nbsp&nbsp&nbsp&nbsp"+
					   		"<a href='javascript:;' onclick='constructionGrid.onModifyClick()' style='text-decoration:none;'>" +
					   		"<span style='width: 26px;cursor: pointer;'>编辑</span></a>"+
					   		"&nbsp&nbsp&nbsp&nbsp"+
					   		"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()' style='text-decoration:none;'>" +
					   		"<span style='width: 26px;cursor: pointer;'>删除</span></a>";
                		}else {return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
   					   		"<span style='width: 26px;cursor: pointer;'>查看</span></a>"+
					   		"&nbsp&nbsp&nbsp&nbsp"+
                		    "<a href='javascript:;' onclick='' style='text-decoration:none;'>" + 
		                    "<span style='width: 25px;color:gray;'>不可修改</span></a>";
                	}
    						}
    			},
           		{header:'生日',dataIndex:'SR',width:90,sortable: true,hidden:true},
           		{header:'民族',dataIndex:'MZ',width:60,sortable: true,hidden:true},
           		{header:'政治面貌',dataIndex:'ZZMM',width:60,sortable: true,hidden:true},
            	{header:'手机号',dataIndex:'SJH',width:90,sortable: true,hidden:true},
            	{header:'联系电话',dataIndex:'LXDH',width:90,sortable: true,hidden:true},
            	{header:'邮箱',dataIndex:'YX',width:100,sortable: true,hidden:true},
            	{header:'QQ',dataIndex:'QQ',width:90,sortable: true,hidden:true},
            	{header:'学历',dataIndex:'XL',width:60,sortable: true,hidden:true},
            	{header:'毕业院校',dataIndex:'BYYX',width:100,sortable: true,hidden:true},
            	{header:'别名',dataIndex:'BM',width:70,sortable: true,hidden:true},
            	{header:'家庭地址',dataIndex:'JTDZ',width:110,sortable: true,hidden:true}
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
//    	win.constructionForm.idHidden.setValue(0);
//    	win.constructionForm.mm.setValue(111111);
    	win.show();
    },
    
    onTpClick: function(){        //点击查看电子签名
		var records=this.getSelectionModel().getSelections();
    	var yhbh = records[0].get('YHBH')
		imageSelectWindow.show();
    	imageSelectWindow.imageSelectGrid.store.baseParams = {yhbh:yhbh};
    	imageSelectWindow.imageSelectGrid.store.load();
//		imageSelectWindow.imageSelectGrid.store.load();
//		this.msgType.setValue("image");
//		Ext.getCmp("toolbarDisplay222ID").setValue('<span  style="color:green;font-weight:bold;">未选择</span>');
	},
    
    onLook: function() {                  //查看
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionLookWindow;
   		    	win.lookForm.getForm().reset();
   		    	win.show();
//   		    	win.lookForm.yhbh.setValue(vrecord.data.YHBH);
   		    	win.lookForm.dlm.setValue(vrecord.data.DLM);
   		    	win.lookForm.xm.setValue(vrecord.data.XM);
   		    	win.lookForm.mm.setValue(vrecord.data.MM);
   		    	win.lookForm.bmmc.setValue(vrecord.data.BMMC);
   		    	win.lookForm.gwbh.setValue(vrecord.data.GWBH);
   		    	win.lookForm.sjh.setValue(vrecord.data.SJH);
   		    	win.lookForm.yx.setValue(vrecord.data.YX);
   		    	win.lookForm.oper_date.setValue(vrecord.data.OPER_DATE);
   		    	win.lookForm.yhzt.setValue(vrecord.data.YHZT);
   		    	win.lookForm.cyzt.setValue(vrecord.data.CYZT);
   		    	win.lookForm.sgzbh.setValue(vrecord.data.SGZBH);
   		    	win.lookForm.xb.setValue(vrecord.data.XB);
   		    	win.lookForm.sr.setValue(vrecord.data.SR);
   		    	win.lookForm.lxdh.setValue(vrecord.data.LXDH);
   		    	win.lookForm.zw.setValue(vrecord.data.ZW);
   		    	win.lookForm.jtdz.setValue(vrecord.data.JTDZ);
   		    	win.lookForm.xl.setValue(vrecord.data.XL);
   		    	win.lookForm.byyx.setValue(vrecord.data.BYYX);
   		    	win.lookForm.zzmm.setValue(vrecord.data.ZZMM);
   		    	win.lookForm.mz.setValue(vrecord.data.MZ);
   		    	win.lookForm.bm.setValue(vrecord.data.BM);
   		    	win.lookForm.yhpxh.setValue(vrecord.data.YHPXH);
   		    	win.lookForm.glfw.setValue(vrecord.data.GLFW);
   		    	win.lookForm.qq.setValue(vrecord.data.QQ);
   		    	win.lookForm.dzqm.setValue(vrecord.data.DZQM);
   		    	win.lookForm.jbm1.setValue(vrecord.data.JBM1);
   		    	win.lookForm.jbm2.setValue(vrecord.data.JBM2);
   		    	win.lookForm.jbm3.setValue(vrecord.data.JBM3);
   		    	win.lookForm.jbm4.setValue(vrecord.data.JBM4);
   		    	
   			}else{
   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
   			}
   		}else{
   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
   		}    	
    },
    
    
    onModifyClick: function() {     //编辑
    	var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   		    	var win = this.constructionUpdateWindow;
   		    	win.updateForm.getForm().reset();
   		    	win.show();
   		    	win.updateForm.dzqmlj.setValue(vrecord.data.DZQMLJ);
   		    	win.updateForm.yhjs.setValue(vrecord.data.YHJS);
   		    	win.updateForm.yhbh.setValue(vrecord.data.YHBH);
   		    	win.updateForm.dlm.setValue(vrecord.data.DLM);
   		    	win.updateForm.xm.setValue(vrecord.data.XM);
   		    	win.updateForm.mm.setValue(vrecord.data.MM);
   		    	win.updateForm.bmmc.setValue(vrecord.data.BMMC);
   		    	win.updateForm.gwbh.setValue(vrecord.data.GWBH);
   		    	win.updateForm.sjh.setValue(vrecord.data.SJH);
   		    	win.updateForm.yx.setValue(vrecord.data.YX);
   		    	win.updateForm.oper_date.setValue(vrecord.data.OPER_DATE);
   		    	win.updateForm.yhzt.setValue(vrecord.data.YHZT);
   		    	win.updateForm.cyzt.setValue(vrecord.data.CYZT);
   		    	win.updateForm.sgzbh.setValue(vrecord.data.SGZBH);
   		    	win.updateForm.xb.setValue(vrecord.data.XB);
   		    	win.updateForm.sr.setValue(vrecord.data.SR);
   		    	win.updateForm.lxdh.setValue(vrecord.data.LXDH);
   		    	win.updateForm.zw.setValue(vrecord.data.ZW);
   		    	win.updateForm.jtdz.setValue(vrecord.data.JTDZ);
   		    	win.updateForm.xl.setValue(vrecord.data.XL);
   		    	win.updateForm.byyx.setValue(vrecord.data.BYYX);
   		    	win.updateForm.zzmm.setValue(vrecord.data.ZZMM);
   		    	win.updateForm.mz.setValue(vrecord.data.MZ);
   		    	win.updateForm.bm.setValue(vrecord.data.BM);
   		    	win.updateForm.yhpxh.setValue(vrecord.data.YHPXH);
   		    	win.updateForm.glfw.setValue(vrecord.data.GLFW);
   		    	win.updateForm.qq.setValue(vrecord.data.QQ);
   		    	win.updateForm.dzqm.setValue("");
   		    	win.updateForm.dzqm.setValue(vrecord.data.DZQM);
   		    	win.updateForm.jbm1.setValue(vrecord.data.JBM1);
   		    	win.updateForm.jbm2.setValue(vrecord.data.JBM2);
   		    	win.updateForm.jbm3.setValue(vrecord.data.JBM3);
   		    	win.updateForm.jbm4.setValue(vrecord.data.JBM4);
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
	       		valueStr.push(records[i].get('YHBH'));
    	 	}
//	       	alert(valueStr);
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
				if (btn == 'yes') {
			       	Ext.Ajax.request({
			       		url: 'delete', 
				       	   method : 'POST', 
				       	   params: { yhbh: valueStr},
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