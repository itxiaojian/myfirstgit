var USER_GRID_STORE_URL = 'getKhKhxxList';
var PAGESIZE = 20;
var ENTITY_URL_UPLOAD = 'khxxupload';
var yearll = new Ext.form.TextField();
var amtd = new Ext.form.TextField();

// 添加页面
var ACT_DEAL_WINDOW;
/*** * *************************************************************** ConstructionForm组件** *****************************************************************************/
ConstructionForm = Ext.extend(Ext.ux.Form, {

	constructor : function() {
		this.khbh = this.createTextField('客户编号', 'khbh', '90%', '', null, 100,
				'长度超过不能50');
		this.khmc = this.createTextField('客户名称', 'khmc', '90%', '', null, 100,
				'长度超过不能50');
		this.khfl = this.createTextField('客户分类', 'khfl', '90%', '', null, 100,
		'长度超过不能50');
		// 做下拉框
		this.dwxz = this.createTextField('单位性质', 'dwxz', '90%', '', null, 100,
		'长度超过不能50');
		this.khdz = this.createTextField('客户地址', 'khdz', '90%', '', null, 100,
				'长度超过不能50');
		this.lxr = this.createTextField('联系人', 'lxr', '90%', '', null, 100,
				'长度超过不能50');
		this.sjhm = new Ext.form.NumberField({
			fieldLabel : '手机号码',
			name : 'sjhm',
			allowNegative : false,
			maxLength : 11,
			maxLengthText : '长度超过不能11位',
			anchor : '90%',
			cls : 'forbiddenZH',
			blankText : '该选项为必填项,请输入内容...',
			hidden : false
		});
		this.gddh = this.createTextField('固定电话', 'gddh', '90%', '', null, 100,
				'长度超过不能50');
		this.cz = this.createTextField('传真', 'cz', '90%', '', null, 100,
				'长度超过不能50');
		this.frxm = this.createTextField('法人姓名', 'frxm', '90%', '', null, 100,
				'长度超过不能50');
		this.clsj = new Ext.form.DateField({
			fieldLabel : '成立时间',
			name : "clsj",
			format : "Y-m-d",
			anchor : '90%',
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});
		// this.zczj = this.createTextField('注册资金', 'zczj',
		// '90%','',null,100,'长度超过不能50');
		this.zczj = new Ext.form.TextField({
			fieldLabel : '<font color="red">*</font>注册资金',
			name : 'zczj',
			xtype : 'textfield',
			anchor : '90%',
			blankText : '该选项为必填项,请输入内容...',
			// 保留小数点后两位
			regex : /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/

		});
		this.jycpmc = this.createTextField('检验产品名称', 'jycpmc', '90%', '', null,
				100, '长度超过不能50');
		this.lrsj = new Ext.form.DateField({
			fieldLabel : '录入时间',
			name : "lrsj",
			format : "Y-m-d",
			anchor : '90%',
			allowBlank : false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});

		this.sr = new Ext.form.DateField({
			fieldLabel : '客户生日',
			name : "sr",
			format : "Y-m-d",
			anchor : '90%',
			// allowBlank: false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});

		// 从数据字典中取值做下拉框
		// this.zjlx = this.createTextField('证件类型', 'zjlx',
		// '90%','',null,100,'长度超过不能50');
		this.zjlx = this.createTextField('证件类型', 'zjlx', '90%', '', null, 100,
		'长度超过不能50');

		this.zjhm = this.createTextField('证件号码', 'zjhm', '90%', '', null, 100,
				'长度超过不能50');

		// 从数据字典中取值做下拉框
		this.bz = new Ext.form.TextArea({
			fieldLabel : '备注',
			name : 'bz',
			readOnly : false,
			anchor : '95%',
			height : 100,
			maxLength : 256,
			maxLengthText : '256！'

		});
		this.khbh.allowBlank = false;
		this.khmc.allowBlank = false;
		this.khfl.allowBlank = false;
		this.dwxz.allowBlank = false;
		this.khdz.allowBlank = false;
		this.lxr.allowBlank = false;
		this.sjhm.allowBlank = false;
		this.gddh.allowBlank = true;
		this.cz.allowBlank = true;
		this.frxm.allowBlank = false;
		this.clsj.allowBlank = false;
		this.zczj.allowBlank = false;
		this.jycpmc.allowBlank = false;
		this.lrsj.allowBlank = false;
		this.sr.allowBlank = true;
		this.zjlx.allowBlank = false;
		this.zjhm.allowBlank = false;
		this.bz.allowBlank = true;

		var pnRow1 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : 1.05,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.lrsj ]
			}), ]
		});
		var pnRow2 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khbh ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khmc ]
			}),

			]
		});
		var pnRow3 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khfl ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.dwxz ]
			}),

			]
		});
		var pnRow4 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zjlx ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zjhm ]
			}),

			]
		});
		var pnRow5 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.sr ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.clsj ]
			}),

			]
		});
		var pnRow6 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khdz ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.lxr ]
			}),

			]
		});

		var pnRow7 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.sjhm ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.gddh ]
			}),

			]
		});
		var pnRow8 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.cz ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.frxm ]
			}),

			]
		});

		var pnRow9 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zczj ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.jycpmc ]
			}),

			]
		});

		var pnRow10 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : 1,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.bz ]
			}),

			]
		});
		var pnRow11 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : 1,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.lrsj ]
			}),

			]
		});
		ConstructionForm.superclass.constructor.call(this, {
			anchor : '80%',
			autoHeight : true,
			layoutConfig : {
				columns : 1
			},
			labelWidth : 90,
			labelAlign : 'right',
			frame : true,
			bodyStyle : "padding: 5px 5px 0",
			width : '100%',
			items : [
			// this.idHidden,
			pnRow1, pnRow2, pnRow3, pnRow4, pnRow5, pnRow6, pnRow7, pnRow8,
					pnRow9, pnRow10,pnRow11

			],
			buttonAlign : 'center',
			buttons : [ {
				text : '增加',
				width : 20,
				iconCls : 'add',
				hidden : false,
				handler : this.addFormClick,
				scope : this
			}, {
				text : '修改',
				iconCls : 'edit',
				handler : this.updateFormClick,
				scope : this
			}, {
				text : '关闭',
				width : 20,
				iconCls : 'delete',
				handler : this.onCloseClick,
				scope : this
			} ]
		});
	},
	addFormClick : function() {
		if (this.getForm().isValid()) {
			this.getForm().submit(
					{
						waitMsg : '正在提交数据...',
						url : 'save',
						method : 'POST',
						success : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!"
									+ BLANKSTR);
							constructionGrid.constructionInsertWindow.hide();
							constructionGrid.vbbar
									.doLoad(constructionGrid.vbbar.cursor);
						},
						failure : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!"
									+ BLANKSTR);
						}
					});
		}
	},
	updateFormClick : function() { // 修改
		if (this.getForm().isValid()) {
			var record = constructionGrid.getSelectionModel().getSelections();
			this.getForm().submit(
					{
						waitMsg : '正在提交数据...',
						url : 'update',
						method : 'POST',
						params : {
							id : record[0].get('ID')
						},
						success : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!"
									+ BLANKSTR);
							constructionGrid.constructionUpdateWindow.hide();
							constructionGrid.vbbar
									.doLoad(constructionGrid.vbbar.cursor);
						},
						failure : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!"
									+ BLANKSTR);
						}
					});
		}
	},
	onCloseClick : function() { // 关闭
		this.ownerCt.hide();
	}
});

/*** * *************************************************************** ConstructionAddForm组件** *****************************************************************************/
ConstructionAddForm = Ext.extend(Ext.ux.Form, {

	constructor : function() {
		this.khbh = this.createTextField('客户编号', 'khbh', '90%', '', null, 100,
				'长度超过不能50');
		this.khmc = this.createTextField('客户名称', 'khmc', '90%', '', null, 100,
				'长度超过不能50');
		this.khfl = this.createTextField('客户分类', 'khfl', '90%', '', null, 100,
		'长度超过不能50');
		// 做下拉框
		this.dwxz = this.createTextField('单位性质', 'dwxz', '90%', '', null, 100,
		'长度超过不能50');
		this.khdz = this.createTextField('客户地址', 'khdz', '90%', '', null, 100,
				'长度超过不能50');
		this.lxr = this.createTextField('联系人', 'lxr', '90%', '', null, 100,
				'长度超过不能50');
		this.sjhm = new Ext.form.NumberField({
			fieldLabel : '手机号码',
			name : 'sjhm',
			allowNegative : false,
			maxLength : 11,
			maxLengthText : '长度超过不能11位',
			anchor : '90%',
			cls : 'forbiddenZH',
			blankText : '该选项为必填项,请输入内容...',
			hidden : false
		});
		this.gddh = this.createTextField('固定电话', 'gddh', '90%', '', null, 100,
				'长度超过不能50');
		this.cz = this.createTextField('传真', 'cz', '90%', '', null, 100,
				'长度超过不能50');
		this.frxm = this.createTextField('法人姓名', 'frxm', '90%', '', null, 100,
				'长度超过不能50');
		this.clsj = new Ext.form.DateField({
			fieldLabel : '成立时间',
			name : "clsj",
			format : "Y-m-d",
			anchor : '90%',
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});
		this.zczj = new Ext.form.TextField({
			fieldLabel : '<font color="red">*</font>注册资金',
			name : 'zczj',
			xtype : 'textfield',
			anchor : '90%',
			blankText : '该选项为必填项,请输入内容...',
			// 保留小数点后两位
			regex : /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/

		});
		this.jycpmc = this.createTextField('检验产品名称', 'jycpmc', '90%', '', null,
				100, '长度超过不能50');
		this.lrsj = new Ext.form.DateField({
			fieldLabel : '录入时间',
			name : "lrsj",
			format : "Y-m-d",
			anchor : '90%',
			allowBlank : false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});

		this.sr = new Ext.form.DateField({
			fieldLabel : '客户生日',
			name : "sr",
			format : "Y-m-d",
			anchor : '90%',
			// allowBlank: false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});

		// 从数据字典中取值做下拉框
		this.zjlx = this.createTextField('证件类型', 'zjlx', '90%', '', null, 100,
		'长度超过不能50');

		this.zjhm = this.createTextField('证件号码', 'zjhm', '90%', '', null, 100,
				'长度超过不能50');

		// 从数据字典中取值做下拉框
		this.bz = new Ext.form.TextArea({
			fieldLabel : '备注',
			name : 'bz',
			readOnly : false,
			anchor : '95%',
			height : 100,
			maxLength : 256,
			maxLengthText : '256！'

		});
		this.khbh.allowBlank = false;
		this.khmc.allowBlank = false;
		this.khfl.allowBlank = false;
		this.dwxz.allowBlank = false;
		this.khdz.allowBlank = false;
		this.lxr.allowBlank = false;
		this.sjhm.allowBlank = false;
		this.gddh.allowBlank = false;
		this.cz.allowBlank = true;
		this.frxm.allowBlank = false;
		this.clsj.allowBlank = false;
		this.zczj.allowBlank = false;
		this.jycpmc.allowBlank = false;
		this.lrsj.allowBlank = false;
		this.sr.allowBlank = false;
		this.zjlx.allowBlank = false;
		this.zjhm.allowBlank = false;
		this.bz.allowBlank = true;

		var pnRow1= new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khbh ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khmc ]
			}),

			]
		});
		var pnRow2 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khfl ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.dwxz ]
			}),

			]
		});
		var pnRow3= new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zjlx ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zjhm ]
			}),

			]
		});
		var pnRow4 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.sr ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.clsj ]
			}),

			]
		});
		var pnRow5 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khdz ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.lxr ]
			}),

			]
		});

		var pnRow6 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.sjhm ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.gddh ]
			}),

			]
		});
		var pnRow7 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.cz ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.frxm ]
			}),

			]
		});

		var pnRow8 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zczj ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.jycpmc ]
			}),

			]
		});

		var pnRow9 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : 1,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.bz ]
			}),

			]
		});
		
		var pnRow10 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : 1,
				layout : 'form',
				border : false,
				labelWidth : 90,
				hidden:true,
				labelAlign : 'right',
				items : [ this.lrsj ]
			}),

			]
		});
		ConstructionAddForm.superclass.constructor.call(this, {
			anchor : '80%',
			autoHeight : true,
			layoutConfig : {
				columns : 1
			},
			labelWidth : 90,
			labelAlign : 'right',
			frame : true,
			bodyStyle : "padding: 5px 5px 0",
			width : '100%',
			items : [
			// this.idHidden,
			pnRow1, 
			pnRow2, 
			pnRow3, 
			pnRow4,
			pnRow5,
			pnRow6, 
			pnRow7,
			pnRow8,
            pnRow9,
            pnRow10
        

			],
			buttonAlign : 'center',
			buttons : [ {
				text : '增加',
				width : 20,
				iconCls : 'add',
				hidden : false,
				handler : this.addFormClick,
				scope : this
			}, {
				text : '修改',
				iconCls : 'edit',
				handler : this.updateFormClick,
				scope : this
			}, {
				text : '关闭',
				width : 20,
				iconCls : 'delete',
				handler : this.onCloseClick,
				scope : this
			} ]
		});
	},
	addFormClick : function() {
		if (this.getForm().isValid()) {
			this.getForm().submit(
					{
						waitMsg : '正在提交数据...',
						url : 'save',
						method : 'POST',
						success : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加成功!"
									+ BLANKSTR);
							constructionGrid.constructionInsertWindow.hide();
							constructionGrid.vbbar
									.doLoad(constructionGrid.vbbar.cursor);
						},
						failure : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "添加失败!"
									+ BLANKSTR);
						}
					});
		}
	},
	updateFormClick : function() { // 修改
		if (this.getForm().isValid()) {
			var record = constructionGrid.getSelectionModel().getSelections();
			this.getForm().submit(
					{
						waitMsg : '正在提交数据...',
						url : 'update',
						method : 'POST',
						params : {
							id : record[0].get('ID')
						},
						success : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改成功!"
									+ BLANKSTR);
							constructionGrid.constructionUpdateWindow.hide();
							constructionGrid.vbbar
									.doLoad(constructionGrid.vbbar.cursor);
						},
						failure : function(form, action) {
							Ext.MessageBox.alert("系统提示:", BLANKSTR + "修改失败!"
									+ BLANKSTR);
						}
					});
		}
	},
	onCloseClick : function() { // 关闭
		this.ownerCt.hide();
	}
});
/*** ************************************ LookForm组件 * *****************************************************/
LookForm = Ext.extend(Ext.ux.Form, {

	constructor : function() {
		this.khbh = this.createTextField('客户编号', 'khbh', '90%', '', null, 100,
				'长度超过不能50');
		this.khmc = this.createTextField('客户名称', 'khmc', '90%', '', null, 100,
				'长度超过不能50');
		this.khfl = this.createTextField('客户分类', 'khfl', '90%', '', null, 100,
		'长度超过不能50');
		// 做下拉框
		this.dwxz = this.createTextField('单位性质', 'dwxz', '90%', '', null, 100,
		'长度超过不能50');
		this.khdz = this.createTextField('客户地址', 'khdz', '90%', '', null, 100,
				'长度超过不能50');
		this.lxr = this.createTextField('联系人', 'lxr', '90%', '', null, 100,
				'长度超过不能50');
		this.sjhm = new Ext.form.NumberField({
			fieldLabel : '手机号码',
			name : 'sjhm',
			allowNegative : false,
			maxLength : 11,
			maxLengthText : '长度超过不能11位',
			anchor : '90%',
			cls : 'forbiddenZH',
			blankText : '该选项为必填项,请输入内容...',
			hidden : false
		});
		this.gddh = this.createTextField('固定电话', 'gddh', '90%', '', null, 100,
				'长度超过不能50');
		this.cz = this.createTextField('传真', 'cz', '90%', '', null, 100,
				'长度超过不能50');
		this.frxm = this.createTextField('法人姓名', 'frxm', '90%', '', null, 100,
				'长度超过不能50');
		this.clsj = new Ext.form.DateField({
			fieldLabel : '成立时间',
			name : "clsj",
			format : "Y-m-d",
			anchor : '90%',
			// allowBlank: false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});
		// this.zczj = this.createTextField('注册资金', 'zczj',
		// '90%','',null,100,'长度超过不能50');
		this.zczj = new Ext.form.TextField({
			fieldLabel : '<font color="red">*</font>注册资金',
			name : 'zczj',
			xtype : 'textfield',
			anchor : '90%',
			blankText : '该选项为必填项,请输入内容...',
			// 保留小数点后两位
			regex : /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/

		});
		this.jycpmc = this.createTextField('检验产品名称', 'jycpmc', '90%', '', null,
				100, '长度超过不能50');
		this.lrsj = new Ext.form.DateField({
			fieldLabel : '录入时间',
			name : "lrsj",
			format : "Y-m-d",
			anchor : '90%',
			allowBlank : false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});

		this.sr = new Ext.form.DateField({
			fieldLabel : '客户生日',
			name : "sr",
			format : "Y-m-d",
			anchor : '90%',
			// allowBlank: false,
			editable : false,// 不能手动输入
			blankText : '请选择时间'
		});

		// 从数据字典中取值做下拉框
		// this.zjlx = this.createTextField('证件类型', 'zjlx',
		// '90%','',null,100,'长度超过不能50');
		this.zjlx = this.createTextField('证件类型', 'zjlx', '90%', '', null, 100,
		'长度超过不能50');

		this.zjhm = this.createTextField('证件号码', 'zjhm', '90%', '', null, 100,
				'长度超过不能50');

		// 从数据字典中取值做下拉框
		this.bz = new Ext.form.TextArea({
			fieldLabel : '备注',
			name : 'bz',
			readOnly : false,
			anchor : '95%',
			height : 100,
			maxLength : 256,
			maxLengthText : '256！'

		});

		// this.ypbh.allowBlank = false;
		this.khbh.allowBlank = false;
		this.khmc.allowBlank = false;
		this.khfl.allowBlank = false;
		this.dwxz.allowBlank = false;
		this.khdz.allowBlank = false;
		this.lxr.allowBlank = false;
		this.sjhm.allowBlank = false;
		this.gddh.allowBlank = false;
		this.cz.allowBlank = false;
		this.frxm.allowBlank = false;
		this.clsj.allowBlank = false;
		this.zczj.allowBlank = false;
		this.jycpmc.allowBlank = false;
		this.lrsj.allowBlank = false;
		this.sr.allowBlank = false;
		this.zjlx.allowBlank = false;
		this.zjhm.allowBlank = false;
		this.bz.allowBlank = true;

		this.khbh.readOnly = true;
		this.khmc.readOnly = true;
		this.khfl.readOnly = true;
		this.dwxz.readOnly = true;
		this.khdz.readOnly = true;
		this.lxr.readOnly = true;
		this.sjhm.readOnly = true;
		this.gddh.readOnly = true;
		this.cz.readOnly = true;
		this.frxm.readOnly = true;
		this.clsj.readOnly = true;
		this.zczj.readOnly = true;
		this.jycpmc.readOnly = true;
		this.lrsj.readOnly = true;
		this.sr.readOnly = true;
		this.bz.readOnly = true;
		this.zjlx.readOnly = true;
		this.zjhm.readOnly = true;

		
		var pnRow1 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khbh ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khmc ]
			}),

			]
		});
		var pnRow2= new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khfl ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.dwxz ]
			}),

			]
		});
		var pnRow3 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zjlx ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zjhm ]
			}),

			]
		});
		var pnRow4 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.sr ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.clsj ]
			}),

			]
		});
		var pnRow5 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.khdz ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.lxr ]
			}),

			]
		});

		var pnRow6 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.sjhm ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.gddh ]
			}),

			]
		});
		var pnRow7 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.cz ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.frxm ]
			}),

			]
		});

		var pnRow8 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.zczj ]
			}), new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.jycpmc ]
			}),

			]
		});

		var pnRow9 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : 1,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.bz ]
			}),

			]
		});
		var pnRow10 = new Ext.Panel({
			layout : 'column',
			border : false,
			items : [ new Ext.Panel({
				columnWidth : .5,
				layout : 'form',
				border : false,
				labelWidth : 90,
				labelAlign : 'right',
				items : [ this.lrsj ]
			}), ]
		});
		
		ConstructionForm.superclass.constructor.call(this, {
			anchor : '80%',
			autoHeight : true,
			layoutConfig : {
				columns : 1
			},
			labelWidth : 90,
			labelAlign : 'right',
			frame : true,
			bodyStyle : "padding: 5px 5px 0",
			width : '100%',
			items : [
			// this.idHidden,
			pnRow1, 
			pnRow2, 
			pnRow3,
			pnRow4, 
			pnRow5, 
			pnRow6,
			pnRow7, 
			pnRow8,
			pnRow9, 
			pnRow10

			],
			buttonAlign : 'center',
			buttons : [ {
				text : '关闭',
				width : 20,
				iconCls : 'delete',
				handler : this.onCloseClick,
				scope : this
			} ]
		});
	},
	onCloseClick : function() { // 关闭
		this.ownerCt.hide();
	}
});
/** *************************************ActDealWindow组件****************** */
ActDealWindow = Ext
		.extend(
				Ext.Window,
				{
					constructor : function(grid) {
						ActDealWindow.superclass.constructor
								.call(
										this,
										{
											width : 800,
											anchor : '100%',
											maximized : true,
											height : 400,
											resizable : false,
											plain : true,
											modal : true,
											autoScroll : true,
											closeAction : 'close',
											html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src=""></iframe>'
										});
					}
				});

/** *************************************ConstructionInsertWindow组件****************************** */
ConstructionInsertWindow = Ext.extend(Ext.Window, {
	constructionAddForm : null,
	constructor : function(grid) {
		this.constructionAddForm = new ConstructionAddForm();
		this.constructionAddForm.buttons[0].show(); // 隐藏添加按钮
		this.constructionAddForm.buttons[1].hide(); // 显示修改按钮
		ConstructionInsertWindow.superclass.constructor.call(this, {
			title : "增加信息",
			width : 800,
			anchor : '100%',
			autoHeight : true,
			resizable : false,
			plain : true,
			modal : true,
			autoScroll : true,
			closeAction : 'hide',
			items : [ this.constructionAddForm ]
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


/** *************************************ConstructionUpdateWindow组件***************************** */
ConstructionUpdateWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor : function() {
		this.constructionForm = new ConstructionForm();
		this.constructionForm.buttons[0].hide(); // 隐藏添加按钮
		this.constructionForm.buttons[1].show(); // 显示修改按钮
		ConstructionUpdateWindow.superclass.constructor.call(this, {
			title : "修改信息",
			width : 900,
			autoHeight : true,
			resizable : false,
			plain : true,
			modal : true,
			autoScroll : true,
			closeAction : 'hide',
			items : [ this.constructionForm ]
		});
	}
});

/** *************************************ConstructionLookWindow组件******************** */
ConstructionLookWindow = Ext.extend(Ext.Window, {
	constructionForm : null,
	constructor : function() {
		this.lookForm = new LookForm();
		ConstructionLookWindow.superclass.constructor.call(this, {
			title : "查看信息",
			width : 900,
			autoHeight : true,
			resizable : false,
			plain : true,
			modal : true,
			autoScroll : true,
			closeAction : 'hide',
			items : [ this.lookForm ]
		});
	}
});

/** ************************ConstructionGrid****************************************** */
ConstructionGrid = Ext
		.extend(
				UxGrid,
				{
					pageSizeCombo : null,
					vtbar : null, // 面板顶部的工具条
					vbbar : null, // 面板底部的工具条
					store : null,
					constructor : function(height, width) {
				this.store = new Ext.data.Store({ // Grid Store
					proxy : new Ext.data.HttpProxy({
						url : USER_GRID_STORE_URL,
						method : 'POST'
					}),
					reader : new Ext.data.JsonReader({
						totalProperty : 'total',
						root : 'rows'
					}, [

					{name : 'ID'},{name : 'KHBH'},{name : 'KHMC'},{name : 'KHFL'},{name : 'DWXZ'},{name : 'KHDZ'},{name : 'LXR'},
					{name : 'SJHM'},{name : 'GDDH'},{name : 'CZ'},{name : 'FRXM'},{name : 'CLSJ'},{name : 'ZCZJ'},{name : 'JYCPMC'},
					{name : 'LRSJ'},{name : 'SR'},{name : 'BZ'},{name : 'ZJLX'},{name : 'ZJHM'},{name : 'DS'},{name : 'DWWZ'},
					{name : 'YWJE'},{name : 'DZYX'},{name : 'FRQQ'},{name : 'SJHM1'},{name : 'GDDH1'},{name : 'CZ1'},{name : 'ZJHM'}
                     ])
				});
						this.vbbar = this.createPagingToolbar(PAGESIZE);
						this.vtbar = new Ext.Toolbar({
							items : [ '-', {text : '登记',
								iconCls : 'add',
								handler : this.onAddClick,
								scope : this
							}, 
							'-', {
								text : '批量删除',
								iconCls : 'delete',
								handler : this.onDeleteClick,
								scope : this
							}, '-', {xtype : 'textfield',id : 'code',width : 150,emptyText : '客户名称或证件号码...',}, 
							  '-', {xtype : 'button',text : '查询',iconCls : 'query',handler : function() {
									var code = Ext.getCmp('code').getValue();
									constructionGrid.store.baseParams = {code : code};
									constructionGrid.store.load({params : {start : 0,limit : PAGESIZE}});}},
									'-', {
								xtype : 'button',
								text : '清空',
								iconCls : 'redo',
								handler : function() {
									Ext.getCmp('code').setValue("");
								}
							},
							'-',
			            	{xtype:'button',text:'下载EXCEL模板',iconCls:'excel',handler:function(){
			   		    		Ext.Msg.confirm('系统提示','确定要下载该模板吗?',function(btn){
					        	    if(btn=="yes"){ 
					        	    	window.open("/zjyw/resources/js/khgl/khxx.xls");
					        	   }
					        	 });
					    	 },scope:this}, 
					    	 '-',	
					    	 {xtype:'button',text:'导入EXCEL数据',iconCls:'excel',handler:this.onUploadClick,scope:this},
					    	 {xtype:'button',text:'下载查询结果',iconCls:'excel',handler:function(){
				   		    		Ext.Msg.confirm('系统提示','确定下载查询结果吗?',function(btn){
						        	    if(btn=="yes"){ 		        	    	
						        	    	var fileName = "客户档案";
						        	    	var code = Ext.getCmp('code').getValue();
						        	    	var url = PROJECT_NAME + "/khgl/YKhKhxx/khxxexport?fileName="+fileName+"&code="+code;
						        	    	url = encodeURI(url);
						        	    	url = encodeURI(url);
						        	    	window.open(url);
						        	   }
						        	 });
					    		}
				   			}
							]
						});
		this.constructionLookWindow = new ConstructionLookWindow();
		this.constructionInsertWindow = new ConstructionInsertWindow();
		this.constructionUpdateWindow = new ConstructionUpdateWindow();
						
		var sm = new Ext.grid.CheckboxSelectionModel();
		ConstructionGrid.superclass.constructor
				.call(
						this,
						{
							region : 'center',
							stripeRows : true,
							frame : false,
							height : height,
							viewConfig : {
								forceFit : false
							},
							loadMask : {
								msg : '正在载入数据,请稍候...'
							},
							sm : sm,
							cm : new Ext.grid.ColumnModel(
									[
											new Ext.grid.RowNumberer(),
											sm,
											{header : '序号',dataIndex : 'ID',width : 80,sortable : true,hidden : true},
                                            {header : '客户编号',dataIndex : 'KHBH',width : 90,sortable : true},
											{header : '单位名称',dataIndex : 'KHMC',width : 100,sortable : true},
											{header : '客户等级',dataIndex : 'KHFL',width : 100,sortable : true},
											{header : '业务金额（元）',dataIndex : 'YWJE',width : 100,sortable : true},
											{header : '单位性质',dataIndex : 'DWXZ',width : 100,sortable : true},
											{header : '客户地址',dataIndex : 'KHDZ',width : 100,sortable : true,hidden : true},
											{header : '客户生日',dataIndex : 'SR',width : 80,sortable : true,hidden : true},
											{header : '联络人员',dataIndex : 'LXR',width : 80,sortable : true},
											{header : '联络手机',dataIndex : 'SJHM1',width : 90,sortable : true},
											{header : '固定电话',dataIndex : 'GDDH',width : 100,sortable : true,hidden : true},
											{header : '传真',dataIndex : 'CZ',width : 100,sortable : true,hidden : true},
											{header : '法人姓名',dataIndex : 'FRXM',width : 80,sortable : true},
											{header : '法人手机',dataIndex : 'SJHM',width : 90,sortable : true},
											{header : '成立时间',dataIndex : 'CLSJ',width : 100,sortable : true,hidden : true},
											{header : '注册资金',dataIndex : 'ZCZJ',width : 100,sortable : true,hidden : true},
											{header : '主导产品',dataIndex : 'JYCPMC',width : 100,sortable : true},
											{header : '录入时间',dataIndex : 'LRSJ',width : 130,sortable : true},
											{header : '证件类型',dataIndex : 'ZJLX',width : 100,sortable : true,hidden : true},
											{header : '证件号码',dataIndex : 'ZJHM',width : 100,sortable : true,hidden : true},
											{header : '备注',dataIndex : 'BZ',width : 100,sortable : true,hidden : true},
											{header : '操作',width : 130,dataIndex : 'sbbh',align : "center",sortable : true,hidden : false,
											renderer : function(){
											return"<a href='javascript:;' onclick='constructionGrid. onLook()' style='text-decoration:none;'>"
											+ "<span style='width: 25px;cursor: pointer;'>查看</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+
											"<a href='javascript:;' onclick='constructionGrid. onModifyClick()' style='text-decoration:none;'>"
											+ "<span style='width: 25px;cursor: pointer;'>编辑</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+
											"<a href='javascript:;' onclick='constructionGrid.onDeleteClick()'  style='text-decoration:none;'>" +
										    "<span style='width: 25px;color:red;cursor: pointer;'>删除</span></a>";
											}
											},

									]),
							tbar : this.vtbar,
							bbar : this.vbbar,
							ds : this.store,
						});
	},
					
					onUploadClick: function(){             // 导入EXCEL数据
				    	if(!this.ipasAssobjBankmemberUploadWindow)
				    		this.ipasAssobjBankmemberUploadWindow = new IpasAssobjBankmemberUploadWindow();
				    	var win = this.ipasAssobjBankmemberUploadWindow;
				    	win.show();
				    	win.ipasAssobjBankmember.getForm().reset();
				    },
				    
				    
				    
				    onLook: function() {
				    	var records=this.getSelectionModel().getSelections();
				   		if(records.length > 0) {
				   			if(records.length == 1){
				   				vrecord = records[0];
				   			}else{
				   				Ext.Msg.alert('系统提示', '不能查看多条记录..');
				   			}
				   		}else{
				   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
				   		}    
				   		var id=records[0].get('ID');
						var url = "khxxCkView?id="+id;  	
						html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
						ACT_DEAL_WINDOW = new ActDealWindow();
						ACT_DEAL_WINDOW.setTitle("查看客户档案");
						ACT_DEAL_WINDOW.html = html;
						ACT_DEAL_WINDOW.show();
				    },

				    onAddClick: function() {
				    	var win = this.constructionInsertWindow;
				    	var url = "khAddView?id="+id;  	
						html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
						ACT_DEAL_WINDOW = new ActDealWindow();
						ACT_DEAL_WINDOW.setTitle("登记客户档案");
						ACT_DEAL_WINDOW.html = html;
						ACT_DEAL_WINDOW.show();
				    },

				    onModifyClick: function() {
				    	var records=this.getSelectionModel().getSelections();
				   		if(records.length > 0) {
				   			if(records.length == 1){
				   				vrecord = records[0];
				   			}else{
				   				Ext.Msg.alert('系统提示', '不能修改多条记录..');
				   			}
				   		}else{
				   			Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录' + BLANKSTR);
				   		}    
				   		var id=records[0].get('ID');
						var url = "khxxXgView?id="+id;  	
						html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="' + url + '"></iframe>';    		
						ACT_DEAL_WINDOW = new ActDealWindow();
						ACT_DEAL_WINDOW.setTitle("编辑客户档案");
						ACT_DEAL_WINDOW.html = html;
						ACT_DEAL_WINDOW.show();
				    },
					
					
					onDeleteClick : function() {
						var records = this.getSelectionModel().getSelections();
						var valueStr = [];
						if (records.length > 0) {
							for ( var i = 0; i < records.length; i++) {
								valueStr.push(records[i].get('ID'));
							}
							Ext.Msg.confirm("提醒信息", "确定要删除这 " + records.length
									+ " 条信息吗", function(btn) {
								if (btn == 'yes') {
									Ext.Ajax.request({
										url : 'delete',
										method : 'POST',
										params : {
											ids : valueStr
										},
										success : function(form, action) {
											Ext.MessageBox.alert("系统提示:",
													BLANKSTR + "删除成功!"
															+ BLANKSTR);
											constructionGrid.store.reload();
										},
										failure : function(form, action) {
											Ext.MessageBox.alert("系统提示:",
													BLANKSTR + "修改失败!"
															+ BLANKSTR);
										}
									});
								}
							});
						} else {
							Ext.Msg.alert('系统提示', BLANKSTR + '请选择一条记录'
									+ BLANKSTR);
							return;
						}
					},
				});

/**
 * *******************onReady
 * 组件渲染及处理*********************************************
 */
Ext.onReady(function() {
	Ext.QuickTips.init(); // 开启快速提示
	Ext.form.Field.prototype.msgTarget = 'side';

	constructionGrid = new ConstructionGrid(
			Ext.getBody().getViewSize().height - 160, Ext.getBody()
					.getViewSize().width);
	constructionGrid.store.load({
		params : {
			start : 0,
			limit : PAGESIZE
		}
	});
	new Ext.Viewport({
		layout : 'border',
		items : [
		// conditionForm,
		constructionGrid ]
	});
});
