var USER_GRID_STORE_URL = 'getYpxxList';
var PAGESIZE=15;
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

/**************************QueryForm查询条件*******************************************/
QueryForm = Ext.extend(Ext.ux.Form,{
	constructor: function(){
		
		this.ypbh = new Ext.form.TextField({
            fieldLabel: '样品编号',
            xtype: 'textfield',
            id: 'ypbh',
            readOnly: false,
            anchor: '100%',
        });
		this.ypmc = new Ext.form.TextField({
            fieldLabel: '样品名称',
            xtype: 'textfield',
            id: 'ypmc',
            readOnly: false,
            anchor: '100%',
        });
		this.yplx = new Ext.form.ComboBox({
			id:'yplx',
        	autoLoad: true,
            fieldLabel: '样品类型',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDMC',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getYplx', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDMC'}])),
                autoLoad:true
            }),
            editable : false
        });
		
		this.ypdj = new Ext.form.TextField({
            fieldLabel: '样品等级',
            xtype: 'textfield',
            id: 'ypdj',
            readOnly: false,
            anchor: '100%',
        });
		this.ypzt = new Ext.form.TextField({
            fieldLabel: '样品状态',
            xtype: 'textfield',
            id: 'ypzt',
            readOnly: false,
            anchor: '100%',
        });
		this.ggxh = new Ext.form.TextField({
            fieldLabel: '规格型号',
            xtype: 'textfield',
            id: 'ggxh',
            readOnly: false,
            anchor: '100%',
        });
		this.szcs = new Ext.form.TextField({
            fieldLabel: '所在城市',
            xtype: 'textfield',
            id: 'szcs',
            readOnly: false,
            anchor: '100%',
        });
		this.scrqpc = new Ext.form.TextField({
            fieldLabel: '生产批次',
            xtype: 'textfield',
            id: 'scrqpc',
            readOnly: false,
            anchor: '100%',
        });
		this.jyks = new Ext.form.ComboBox({
			id:'jyks',
        	autoLoad: true,
            fieldLabel: '检验科室',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'BMMC',
			valueField:'BMBH',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getJyks', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.ywks = new Ext.form.ComboBox({
			id:'ywks',
        	autoLoad: true,
            fieldLabel: '业务科室',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'BMMC',
			valueField:'BMBH',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getYwks', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'BMMC'},{name:'BMBH'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.cyry = new Ext.form.TextField({
            fieldLabel: '抽样人员',
            xtype: 'textfield',
            id: 'cyry',
            readOnly: false,
            anchor: '100%',
        });
		this.cydd = new Ext.form.TextField({
            fieldLabel: '抽样地点',
            xtype: 'textfield',
            id: 'cydd',
            readOnly: false,
            anchor: '100%',
        });
		this.cyrq = new Ext.form.DateField({
			fieldLabel: '抽样日期',
			id: 'cyrq',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		this.sb = new Ext.form.TextField({
            fieldLabel: '商标',
            xtype: 'textfield',
            id: 'sb',
            readOnly: false,
            anchor: '100%',
        });
		this.jyfydd = new Ext.form.ComboBox({
			id:'jyfydd',
        	autoLoad: true,
            fieldLabel: '检验费用',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDZ',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/ypgl/YYpYpxx/getDicByJyfydd', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDZ'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.yhxtk = new Ext.form.ComboBox({
			id:'yhxtk',
        	autoLoad: true,
            fieldLabel: '验后退库',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDZ',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/ypgl/YYpYpxx/getDicByYhxtk', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDZ'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.jylx = new Ext.form.ComboBox({
			id:'jylx',
        	autoLoad: true,
            fieldLabel: '检验类型',
            emptyText: '请选择...',
			anchor: '100%',
			mode: 'local',
			triggerAction: 'all',
			displayField:'ZDMC',
			valueField:'ZDZ',
            store: new Ext.data.Store({
            	proxy: new Ext.data.HttpProxy({url: PROJECT_NAME+'/jygl/YjyBgxx/getJylx', method: 'POST'}),
                reader: new Ext.data.JsonReader({},new Ext.data.Record.create([{name:'ZDMC'},{name:'ZDZ'}])),
                autoLoad:true
            }),
            editable : false
        });
		this.jyhth = new Ext.form.TextField({
            fieldLabel: '检验合同号',
            xtype: 'textfield',
            id: 'jyhth',
            readOnly: false,
            anchor: '100%',
        });
		this.jcfyry = new Ext.form.TextField({
            fieldLabel: '检查封样人',
            xtype: 'textfield',
            id: 'jcfyry',
            readOnly: false,
            anchor: '100%',
        });
		this.dyrq = new Ext.form.DateField({
			fieldLabel: '到样日期',
			id: 'dyrq',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		this.djsj = new Ext.form.DateField({
			fieldLabel: '登记日期',
			id: 'djsj',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		this.wcqx = new Ext.form.DateField({
			fieldLabel: '完成期限',
			id: 'wcqx',
			format: 'Y-m-d',
			anchor: '100%',
			allowBlank: true,
			editable:false,//不能手动输入
			blankText: '请选择时间'
		});
		this.wtdw = new Ext.form.TextField({
            fieldLabel: '委托单位',
            xtype: 'textfield',
            id: 'wtdw',
            readOnly: false,
            anchor: '100%',
        });
		this.wtlxr = new Ext.form.TextField({
            fieldLabel: '委托联系人',
            xtype: 'textfield',
            id: 'wtlxr',
            readOnly: false,
            anchor: '100%',
        }); 
		this.sjhm = new Ext.form.TextField({
            fieldLabel: '委托人手机',
            xtype: 'textfield',
            id: 'sjhm',
            readOnly: false,
            anchor: '100%',
            regex: /(^-[1-9]\d*$)|(^[1-9]\d*$)/
        }); 
		this.sjdw = new Ext.form.TextField({
            fieldLabel: '受检单位',
            xtype: 'textfield',
            id: 'sjdw',
            readOnly: false,
            anchor: '100%',
        });
		this.lxr = new Ext.form.TextField({
            fieldLabel: '受检联系人',
            xtype: 'textfield',
            id: 'lxr',
            readOnly: false,
            anchor: '100%',
        });
		this.scdw = new Ext.form.TextField({
            fieldLabel: '生产单位',
            xtype: 'textfield',
            id: 'scdw',
            readOnly: false,
            anchor: '100%',
        });
		this.scdwlxr = new Ext.form.TextField({
            fieldLabel: '生产联系人',
            xtype: 'textfield',
            id: 'scdwlxr',
            readOnly: false,
            anchor: '100%',
        });
		this.gcmc = new Ext.form.TextField({
            fieldLabel: '工程名称',
            xtype: 'textfield',
            id: 'gcmc',
            readOnly: false,
            anchor: '100%',
        }); 
		this.gclxr = new Ext.form.TextField({
            fieldLabel: '工程联系人',
            xtype: 'textfield',
            id: 'gclxr',
            readOnly: false,
            anchor: '100%',
        });
		this.sgdw = new Ext.form.TextField({
            fieldLabel: '施工单位',
            xtype: 'textfield',
            id: 'sgdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.gcsjdw = new Ext.form.TextField({
            fieldLabel: '设计单位',
            xtype: 'textfield',
            id: 'gcsjdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.jsdw = new Ext.form.TextField({
            fieldLabel: '建设单位',
            xtype: 'textfield',
            id: 'jsdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.jldw = new Ext.form.TextField({
            fieldLabel: '监理单位',
            xtype: 'textfield',
            id: 'jldw',
            readOnly: false,
            anchor: '100%',
        });
		this.jlr = new Ext.form.TextField({
            fieldLabel: '监理人',
            xtype: 'textfield',
            id: 'jlr',
            readOnly: false,
            anchor: '100%',
        });
		this.jzdw = new Ext.form.TextField({
            fieldLabel: '见证单位',
            xtype: 'textfield',
            id: 'jzdw',
            readOnly: false,
            anchor: '100%',
        }); 
		this.jzr = new Ext.form.TextField({
            fieldLabel: '见证人',
            xtype: 'textfield',
            id: 'jzr',
            readOnly: false,
            anchor: '100%',
        });
		this.slr = new Ext.form.TextField({
            fieldLabel: '受理人',
            xtype: 'textfield',
            id: 'slr',
            readOnly: false,
            anchor: '100%',
        });
		
//		this.djsjStr = new Ext.form.DateField({
//			fieldLabel: '登记日期起',
//			id: 'djsjStr',
//			format: 'Y-m-d',
//			anchor: '100%',
//			allowBlank: true,
//			editable:false,//不能手动输入
//			blankText: '请选择时间'
//		});
////		var firstDayOfMonth = new Date();
////		firstDayOfMonth.setDate(1);
////		this.djsjStr.value = firstDayOfMonth.format('Y-m-d');
//		this.djsjEnd = new Ext.form.DateField({
//				fieldLabel: '登记日期止',
//				id: 'djsjEnd',
//				format: 'Y-m-d',
//				anchor: '100%',
//				allowBlank: true,
//				editable:false,//不能手动输入
//				blankText: '请选择时间'
//			});
////		this.djsjEnd.value = new Date().format('YYYY-MM-dd');
		
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
						this.ypbh,
						this.ypmc,
						this.yplx,
						this.ypdj,
						this.ypzt,
						this.ggxh,
						this.szcs,
						this.scrqpc,
						this.jyks,
	                    this.ywks,
	                    this.cyry,
	                    this.cydd,
	                    this.cyrq,
	                    this.sb,
	                    this.jyfydd,
	                    this.yhxtk,
	                    this.jylx,
	                    this.jyhth,
	                    this.jcfyry,
	                    this.dyrq,
	                    this.djsj,
	                    this.wcqx,
	                    this.wtdw,
	                    this.wtlxr,
	                    this.sjhm,
	                    this.sjdw,
	                    this.lxr,
	                    this.scdw,
	                    this.scdwlxr,
	                    this.gcmc,
	                    this.gclxr,
	                    this.sgdw,
	                    this.gcsjdw,
	                    this.jsdw,
	                    this.jldw,
	                    this.jlr,
	                    this.jzdw,
	                    this.jzr,
	                    this.slr
	            ],
	            buttonAlign :'center',
	            buttons: [
	               {text: '查询', width: 20,iconCls: 'query', hidden: false,handler:this.queryFormClick,scope:this},
	               {text: '重置', width: 20, iconCls:'refresh',  handler: this.resetFormClick, scope: this},
	               {xtype:'button',text:'下载查询结果',iconCls:'excel',handler:this.exportClick,scope:this}
	            ]
	        });
	},
	queryFormClick: function(){
  	   var params = {};
 			if(Ext.getCmp('ypbh').getValue() != ''){
 				params['ypbh'] = Ext.getCmp('ypbh').getValue();
 			}
 			if(Ext.getCmp('ypmc').getValue() != ''){
 				params['ypmc'] = Ext.getCmp('ypmc').getValue();
 			}
 			if(Ext.getCmp('yplx').getValue() != ''){
 				params['yplx'] = Ext.getCmp('yplx').getValue();
 			}
 			if(Ext.getCmp('ypdj').getValue() != ''){
 				params['ypdj'] = Ext.getCmp('ypdj').getValue();
 			}
 			if(Ext.getCmp('ypzt').getValue() != ''){
 				params['ypzt'] = Ext.getCmp('ypzt').getValue();
 			}
 			if(Ext.getCmp('ggxh').getValue() != ''){
 				params['ggxh'] = Ext.getCmp('ggxh').getValue();
 			}
 			if(Ext.getCmp('szcs').getValue() != ''){
 				params['szcs'] = Ext.getCmp('szcs').getValue();
 			}
 			if(Ext.getCmp('scrqpc').getValue() != ''){
 				params['scrqpc'] = Ext.getCmp('scrqpc').getValue();
 			}
 			if(Ext.getCmp('jyks').getValue() != ''){
 				params['jyks'] = Ext.getCmp('jyks').getValue();
 			}
 			if(Ext.getCmp('ywks').getValue() != ''){
 				params['ywks'] = Ext.getCmp('ywks').getValue();
 			}
 			if(Ext.getCmp('cyry').getValue() != ''){
 				params['cyry'] = Ext.getCmp('cyry').getValue();
 			}
 			if(Ext.getCmp('cydd').getValue() != ''){
 				params['cydd'] = Ext.getCmp('cydd').getValue();
 			}
 			if(Ext.getCmp('cyrq').getValue() != '') {
				params['cyrq'] = Ext.getCmp('cyrq').getValue().format('Y-m-d');
			}
 			if(Ext.getCmp('sb').getValue() != ''){
 				params['sb'] = Ext.getCmp('sb').getValue();
 			}
 			if(Ext.getCmp('jyfydd').getValue() != ''){
 				params['jyfydd'] = Ext.getCmp('jyfydd').getValue();
 			}
 			if(Ext.getCmp('yhxtk').getValue() != ''){
 				params['yhxtk'] = Ext.getCmp('yhxtk').getValue();
 			}
 			if(Ext.getCmp('jylx').getValue() != ''){
 				params['jylx'] = Ext.getCmp('jylx').getValue();
 			}
 			if(Ext.getCmp('jyhth').getValue() != ''){
 				params['jyhth'] = Ext.getCmp('jyhth').getValue();
 			}
 			if(Ext.getCmp('jcfyry').getValue() != ''){
 				params['jcfyry'] = Ext.getCmp('jcfyry').getValue();
 			}
 			if(Ext.getCmp('dyrq').getValue() != '') {
				params['dyrq'] = Ext.getCmp('dyrq').getValue().format('Y-m-d');
			}
 			if(Ext.getCmp('djsj').getValue() != '') {
				params['djsj'] = Ext.getCmp('djsj').getValue().format('Y-m-d');
			}
 			if(Ext.getCmp('wcqx').getValue() != '') {
				params['wcqx'] = Ext.getCmp('wcqx').getValue().format('Y-m-d');
			}
 			if(Ext.getCmp('wtdw').getValue() != ''){
 				params['wtdw'] = Ext.getCmp('wtdw').getValue();
 			}
 			if(Ext.getCmp('wtlxr').getValue() != ''){
 				params['wtlxr'] = Ext.getCmp('wtlxr').getValue();
 			}
 			if(Ext.getCmp('sjhm').getValue() != ''){
 				params['sjhm'] = Ext.getCmp('sjhm').getValue();
 			}
 			if(Ext.getCmp('sjdw').getValue() != ''){
 				params['sjdw'] = Ext.getCmp('sjdw').getValue();
 			}
 			if(Ext.getCmp('lxr').getValue() != ''){
 				params['lxr'] = Ext.getCmp('lxr').getValue();
 			}
 			if(Ext.getCmp('scdw').getValue() != ''){
 				params['scdw'] = Ext.getCmp('scdw').getValue();
 			}
 			if(Ext.getCmp('scdwlxr').getValue() != ''){
 				params['scdwlxr'] = Ext.getCmp('scdwlxr').getValue();
 			}
 			if(Ext.getCmp('gcmc').getValue() != ''){
 				params['gcmc'] = Ext.getCmp('gcmc').getValue();
 			}
 			if(Ext.getCmp('gclxr').getValue() != ''){
 				params['gclxr'] = Ext.getCmp('gclxr').getValue();
 			}
 			if(Ext.getCmp('sgdw').getValue() != ''){
 				params['sgdw'] = Ext.getCmp('sgdw').getValue();
 			}
 			if(Ext.getCmp('gcsjdw').getValue() != ''){
 				params['gcsjdw'] = Ext.getCmp('gcsjdw').getValue();
 			}
 			if(Ext.getCmp('jsdw').getValue() != ''){
 				params['jsdw'] = Ext.getCmp('jsdw').getValue();
 			}
 			if(Ext.getCmp('jldw').getValue() != ''){
 				params['jldw'] = Ext.getCmp('jldw').getValue();
 			}
 			if(Ext.getCmp('jlr').getValue() != ''){
 				params['jlr'] = Ext.getCmp('jlr').getValue();
 			}
 			if(Ext.getCmp('jzdw').getValue() != ''){
 				params['jzdw'] = Ext.getCmp('jzdw').getValue();
 			}
 			if(Ext.getCmp('jzr').getValue() != ''){
 				params['jzr'] = Ext.getCmp('jzr').getValue();
 			}
 			if(Ext.getCmp('slr').getValue() != ''){
 				params['slr'] = Ext.getCmp('slr').getValue();
 			}
 			constructionGrid.store.baseParams= params;
 			constructionGrid.store.load({params:{start:0,limit:PAGESIZE}});
	},
	resetFormClick: function(){
		Ext.getCmp('ypbh').setValue('');
		Ext.getCmp('ypmc').setValue('');
		Ext.getCmp('yplx').setValue('');
		Ext.getCmp('ypdj').setValue('');
		Ext.getCmp('ypzt').setValue('');
		Ext.getCmp('ggxh').setValue('');
		Ext.getCmp('szcs').setValue('');
		Ext.getCmp('scrqpc').setValue('');
		Ext.getCmp('jyks').setValue('');
		Ext.getCmp('ywks').setValue('');
		Ext.getCmp('cyry').setValue('');
		Ext.getCmp('cydd').setValue('');
		Ext.getCmp('cyrq').setValue('');
		Ext.getCmp('sb').setValue('');
		Ext.getCmp('jyfydd').setValue('');
		Ext.getCmp('yhxtk').setValue('');
		Ext.getCmp('jylx').setValue('');
		Ext.getCmp('jyhth').setValue('');
		Ext.getCmp('jcfyry').setValue('');
		Ext.getCmp('dyrq').setValue('');
		Ext.getCmp('djsj').setValue('');
		Ext.getCmp('wcqx').setValue('');
		Ext.getCmp('wtdw').setValue('');
		Ext.getCmp('wtlxr').setValue('');
		Ext.getCmp('sjhm').setValue('');
		Ext.getCmp('sjdw').setValue('');
		Ext.getCmp('lxr').setValue('');
		Ext.getCmp('scdw').setValue('');
		Ext.getCmp('scdwlxr').setValue('');
		Ext.getCmp('gcmc').setValue('');
		Ext.getCmp('gclxr').setValue('');
		Ext.getCmp('sgdw').setValue('');
		Ext.getCmp('gcsjdw').setValue('');
		Ext.getCmp('jsdw').setValue('');
		Ext.getCmp('jldw').setValue('');
		Ext.getCmp('jlr').setValue('');
		Ext.getCmp('jzdw').setValue('');
		Ext.getCmp('jzr').setValue('');
		Ext.getCmp('slr').setValue('');
	},
	
	exportClick:function(){
   		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
    	    if(btn=="yes"){ 		        	    	
    	    	var fileName = new Date() + "导出样品信息";
    	    	var code = Ext.getCmp('ypmc').getValue();
    	    	var url = PROJECT_NAME + "/ypgl/YYpYpxx/export?fileName="+fileName+"&code="+code;
    	    	url = encodeURI(url);
    	    	url = encodeURI(url);
    	    	window.open(url);
    	   }
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
                            {name:'DYRQ'}, {name:'LYSL'}, {name:'DJLX'}, {name:'XGJE'}
            ])
        });
    	this.vbbar= this.createPagingToolbar(PAGESIZE);
    	this.vtbar = new Ext.Toolbar({
            items:[
                    {text:'查看二维码',iconCls: 'edit',handler:this.onBqClick,scope:this},
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
                {header:'收费状态',dataIndex:'XGJE',width:80,sortable: true, hidden:true},
                {header: '操作', width: 100, align:"center",sortable: true,hidden: false,
					renderer:function(value, cellmeta, record){
						if(record.get("YPJYZT") == 0){
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp;" +
							  "<a href='javascript:;' onclick='constructionGrid.onModifyClick()'  style='text-decoration:none;'>" +
							  "<span style='width: 25px;cursor: pointer;'>修改</span></a>";
						}else{
							return "<a href='javascript:;' onclick='constructionGrid.onLook()' style='text-decoration:none;'>" +
					   		  "<span style='width: 26px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp;" +
							  "<a href='javascript:;' onclick='' style='text-decoration:none;'>" +
							  "<span style='width: 25px;color:grey;'>修改</span></a>";
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
				{header:'样品检测状态',dataIndex:'YPJYZT',width:90,sortable: true,
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
                {header:'样品编号',dataIndex:'YPBH',width:120,sortable: true},
                //{header:'报告编号',dataIndex:'BGBH',width:120,sortable: true},
                //{header:'二维码编号',dataIndex:'EWMBH',width:80,sortable: true},
            	{header:'样品名称',dataIndex:'YPMC',width:80,sortable: true},
            	//{header:'样品类型',dataIndex:'YPLX',width:80,sortable: true},
            	{header:'检验类型',dataIndex:'JYLX',width:80,sortable: true},
            	{header:'检验科室',dataIndex:'JYKS',width:120,sortable: true},
            	{header:'业务科室',dataIndex:'YWKS',width:120,sortable: true},
            	{header:'登记时间',dataIndex:'DJSJ',width:120,sortable: true},
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
            	{header:'报告发送方式',dataIndex:'BGFSFS',width:60,sortable: true,
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
// 			LODOP.ADD_PRINT_URL(30,20,746,"95%",'YpLzdPage?ypbh=2015DQ00003');
		LODOP.SET_PRINT_STYLEA(0,"HOrient",3);
		LODOP.SET_PRINT_STYLEA(0,"VOrient",3);
		//	LODOP.SET_SHOW_MODE("MESSAGE_GETING_URL",""); //该语句隐藏进度条或修改提示信息
		//	LODOP.SET_SHOW_MODE("MESSAGE_PARSING_URL","");//该语句隐藏进度条或修改提示信息
		LODOP.PREVIEW();			
    },

    onLook: function() {                  //查看
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var djlx=records[0].get('DJLX');
				var url = "ypxxOnLookView?id="+id+"&djlx="+djlx;  	
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
    
    
    onModifyClick: function() {         //修改
   		var records=this.getSelectionModel().getSelections();
   		if(records.length > 0) {
   			if(records.length == 1){
   				vrecord = records[0];
   				var id=records[0].get('ID');
   				var djlx=records[0].get('DJLX');
   				var ypbh=records[0].get('YPBH');
   				var sfzt=records[0].get('XGJE');
				var url = "ypxxUpdateView?id="+id+"&djlx="+djlx+"&ypbh="+ypbh+"&sfzt="+sfzt;  	
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
   		if(records.length>0) {
	       	for(var i=0;i<records.length;i++){
	       		valueStr.push(records[i].get('ID'));
    	 	}
	    	Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length + " 条信息吗",function(btn){
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
    
    onTshiClick: function() {       //  收费中的提示先退费才可删除
		var records=this.getSelectionModel().getSelections();
		    	var valueStr=[];
		   		if(records.length>0) {
			       	for(var i=0;i<records.length;i++){
			       		valueStr.push(records[i].get('ID'));
		    	 	}
			    	Ext.Msg.confirm("提醒信息", "该条检验报告正在收费，请退费后修改！",function(btn){
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
    /*
    new Ext.Viewport({
            layout: 'border',
            items:[
            //conditionForm,
            constructionGrid
            ]
        });*/
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