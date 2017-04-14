/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zssi.framework.app.process.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.service.YcwBgsfService;
import com.zssi.framework.app.dagl.service.YdaXxService;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.jygl.service.YjyClyyService;
import com.zssi.framework.app.jygl.service.YjyJyxxService;
import com.zssi.framework.app.jygl.service.YjyYsjlService;
import com.zssi.framework.app.process.dao.BusinessXNDao;
import com.zssi.framework.app.process.dao.YshJybDao;
import com.zssi.framework.app.process.service.ManualTaskXNService;
import com.zssi.framework.app.process.service.TestProcessService;
import com.zssi.framework.app.process.service.YshJybService;
import com.zssi.framework.app.process.support.file.CpsConstant;
import com.zssi.framework.app.sbgl.service.YsbXxService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypSfxmmxService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/**
 * @author zhangyi
 */
@Controller
@RequestMapping(value = "/cps/process/taskXN")
public class ManualTaskXNController extends BaseController {

	@Autowired
	private ManualTaskXNService manualTaskService;
	@Autowired
	private FormService formService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private BusinessXNDao businessDao;
	@Autowired
	private YshJybDao yshJybDao;
	@Autowired
	private YshJybService yshJybService;
	@Autowired
	private YdaXxService yDaXxService;
	@Autowired
	private YjyBgxxService bgxxservice;
	@Autowired
	private YsbXxService ySbXxService;
	@Autowired
	private YypYpxxService ypxxservice;
	@Autowired
	private YjyJyxxService  jyxxservice;
	@Autowired
	private YcwBgsfService bgsfService;//收费标准
	@Autowired
	private TestProcessService testProcessService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private YjyClyyService clyyservice;
	@Autowired
	private YjyYsjlService ysjlService;
	@Autowired
	private YypSfxmmxService sfxmmxService;
	
	@RequestMapping(value = "/pendWorkPoolIndex")
	public ModelAndView openPendWorkOrderPoolPage(String ypcs) {
		
		ModelAndView modelAndView = new ModelAndView("/cps/process/pendWorkOrderPool");
		modelAndView.addObject("ypcs",ypcs);
		
		return modelAndView;
	}

	// 审批技术总监页面
	@RequestMapping(value = "/pendWorkPoolIndexJSZJ")
	public String openPendWorkOrderPoolPageJSZJ() {
		return "/cps/process/pendWorkOrderPoolJSZJ";
	}

	// 审批市场人员页面
	@RequestMapping(value = "/pendWorkPoolIndexSCRY")
	public String openPendWorkOrderPoolPageSCEY() {
		return "/cps/process/pendWorkOrderPoolSCRY";
	}

	// 审批部门经理页面
	@RequestMapping(value = "/pendWorkPoolIndexBMJL")
	public String openPendWorkOrderPoolPageBMJL() {
		return "/cps/process/pendWorkOrderPoolBMJL";
	}

	// 审批项目经理页面
	@RequestMapping(value = "/pendWorkPoolIndexXMJL")
	public String openPendWorkOrderPoolPageXMJL() {
		return "/cps/process/pendWorkOrderPoolXMJL";
	}

	// 审批普通员工页面
	@RequestMapping(value = "/pendWorkPoolIndexPTYG")
	public String openPendWorkOrderPoolPagePTYG() {
		return "/cps/process/pendWorkOrderPoolPTYG";
	}
	
	// 修改自己被退回的绩效
	@RequestMapping(value = "/pendWorkPoolIndexTH")
	public String openPendWorkOrderPoolPageTH() {
		return "/cps/process/pendWorkOrderPoolTH";
	}
	
	/**
	 * 任务分配批量办理
	 * @author duanpeijun
	 * @date 2016年5月31日
	 * @param taskId
	 * @param businessKey
	 * @param  fl(1:科室主任分配处理;2:审核人员退回的处理)
	 * @return
	 */
	@RequestMapping(value = "/PLopenTaskDealPage")
	public ModelAndView PLopenTaskDealPage(String[] taskIds,String[] businessKeys,String fl,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String url = "";
		List<String> taskIdlist = new ArrayList<String>();
		List<String> businessKeylist = new ArrayList<String>();
		String firsttaskId = "";           //用一个taskId作为查询taskFormData的示例
		String firstbusinessKey = "";      //用一个businessKey作为StringUtils.hasText(businessKey)的示例
		for(int i=0;i<taskIds.length;i++){
			taskIdlist.add(taskIds[i]);  //taskId数组
			firsttaskId = taskIds[0];
		}
		for(int j=0;j<businessKeys.length;j++){
			businessKeylist.add(businessKeys[j]);  //businessKeylist数组
			firstbusinessKey = businessKeys[0];
		}
		modelAndView.addObject("taskIds", taskIdlist);            //传出taskIds数组
		modelAndView.addObject("businessKeys", businessKeylist);  //传出businessKeylist数组
		SysYh user = AppUtil.getCurrentUser();
		modelAndView.addObject("userCode", user.getUsername());
		TaskFormData taskFormData = formService.getTaskFormData(firsttaskId);
		String tname = taskFormData.getTask().getName();
		modelAndView.addObject("tname", tname);
		List<FormProperty> listProperty = taskFormData.getFormProperties();
		if (!listProperty.isEmpty()) {
			String lineVar = listProperty.get(0).getId();//获取传入下层的连线值
			modelAndView.addObject("lineVar", lineVar);
		}
		if (StringUtils.hasText(firstbusinessKey)) {
			List<Map<String, Object>> listmap= businessDao.getListProcessByYpbhb(firstbusinessKey,"","");
			String ypjyks="";
			if(listmap.size()>0) {
				Map<String, Object> mapBusi = listmap.get(0);
				ypjyks = mapBusi.get("jyksbh").toString();
			}
			 //根据报告编号获取审批建议信息
			 List<Map<String, Object>> listOption = yshJybDao.getYshJybListByYpbh(firstbusinessKey);
			 if(listOption.size()>0){
				 modelAndView.addObject("listOption",listOption);
			 }
			 String thisOrg = "";
			 String thisName = "";
			 if(user!=null){
				 thisOrg = user.getBmbh();
				 thisName = user.getUsername();
			 }
			 List<Map<String, Object>> listypzjUser = businessDao.getUserListByUserRoleAndorgCode(ypjyks,thisOrg, CpsConstant.ROLE_JYRY);
			 if(listypzjUser.size()>0){
				 modelAndView.addObject("listypzjUser",listypzjUser);//传入样品主检人员
			 }
		}
		if("1".equals(fl)){
			url = "/cps/form/plrwcl";
		}else if("2".equals(fl)){
			url = "/cps/form/plshthcl";
		}
		modelAndView.setViewName(url);
		return modelAndView;
	}


	/**
	 * 根据传入的任务ID找到对应的FormKey并打开此FormKey指向的页面,
	 * 同时取得该任务环节配置的FORM变量(即此环节后面的连线变量),传至前台
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/openTaskDealPage/{taskId}/{businessKey}/{ypcs}")
	public ModelAndView openTaskDealPage(@PathVariable String taskId,@PathVariable String businessKey,@PathVariable String ypcs,HttpServletRequest request) {
		String orgCode = "";//部门编号
		String khgw = "";//岗位编号
		Map<String, Object> var = taskService.getVariables(taskId);
		if (var.get("orgCode") != null) {
			orgCode = var.get("orgCode").toString();
		}
		if (var.get("gwbh") != null) {
			khgw = var.get("gwbh").toString();
		}
		SysYh user = AppUtil.getCurrentUser();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userCode", user.getUsername());
		TaskFormData taskFormData = formService.getTaskFormData(taskId);
		String formKey = taskFormData.getFormKey();
		String tname = taskFormData.getTask().getName();
		modelAndView.addObject("tname", tname);
		List<FormProperty> listProperty = taskFormData.getFormProperties();
		if (!listProperty.isEmpty()) {
			String lineVar = listProperty.get(0).getId();//获取传入下层的连线值
			modelAndView.addObject("lineVar", lineVar);
		}
		String url = formKey;
		
		modelAndView.setViewName(url);
		// 查询对应业务数据传至处理页面
		if (StringUtils.hasText(businessKey)) {
			modelAndView.addObject("businessKey", businessKey);
			 List<Map<String, Object>> listmap= businessDao.getListProcessByYpbhb(businessKey,"","");
			String ypjyks="";
			if(listmap.size()>0) {
				Map<String, Object> mapBusi = listmap.get(0);
				ypjyks = mapBusi.get("jyksbh").toString();
			}
			 //根据报告编号获取审批建议信息
			 List<Map<String, Object>> listOption = yshJybDao.getYshJybListByYpbh(businessKey);
			 if(listOption.size()>0){
				 modelAndView.addObject("listOption",listOption);
			 }
			 String thisOrg = "";
			 String thisName = "";
			 if(user!=null){
				 thisOrg = user.getBmbh();
				 thisName = user.getUsername();
			 }
			 List<Map<String, Object>> listypzjUser = businessDao.getUserListByUserRoleAndorgCode(ypjyks,thisOrg, CpsConstant.ROLE_JYRY);
			 List<Map<String, Object>> listypzjshUser = businessDao.getUserListByUserRoleAndorgCodeQcdq(ypjyks,thisOrg, CpsConstant.ROLE_JYSHRY,thisName);
			 List<Map<String, Object>> jszxList = businessDao.getJszxbh(thisOrg);
			 if(jszxList.size()!=0){
			 		String jszxbh =jszxList.get(0).get("jszxbh").toString();
			 		List<Map<String, Object>> pzone= businessDao.getUserListByUserRoleAndorgCodeQcdq(ypjyks,jszxbh, CpsConstant.ROLE_GCJSZXPZR,thisName);
//			 		List<Map<String, Object>> pztwo = businessDao.getUserListByUserRoleAndorgCodeQcdq(ypjyks,thisOrg, CpsConstant.ROLE_GCJSZXPZR,thisName);
			 		List<Map<String, Object>> listypzjpzUser = new ArrayList<Map<String, Object>>();
			 		listypzjpzUser.addAll(pzone);
//			 		listypzjpzUser.addAll(pztwo);
			 		if(listypzjpzUser.size()>0){
						 modelAndView.addObject("listypzjpzUser",listypzjpzUser);//传入批准人员
					 }
			 }
			 
			 if(listypzjUser.size()>0){
				 modelAndView.addObject("listypzjUser",listypzjUser);//传入样品主检人员
			 }
			 if(listypzjshUser.size()>0){
				 modelAndView.addObject("listypzjshUser",listypzjshUser);//传入样品主检审核人员
			 }
			 
			 if(listmap.size()>0){
				 Map<String, Object> mapBusi = listmap.get(0);
				 if (mapBusi != null) {
					 modelAndView.addObject("mapBusi", mapBusi);
				 }
			 
			 String bgbh=mapBusi.get("bgbh").toString();
			 if("1".equals(ypcs)){        			//报告编制
					//报告编制中样品修改时，获取样品信息
					 String id1 = mapBusi.get("id").toString();
					 List<Map<String, Object>> ypxx1 = ypxxservice.getYpxx(Integer.parseInt(id1));
					 String djlxStr = ypxx1.get(0).get("djlx").toString();
					 String bgbhStr = ypxx1.get(0).get("bgbh").toString();
					 String sfzt = ypxx1.get(0).get("xgje").toString();
					 System.out.println(djlxStr);
					 System.out.println(bgbhStr);
					 System.out.println(sfzt);
					 List<Map<String, Object>> list = ypxxservice.getYpxx(Integer.parseInt(id1),djlxStr);
					 if (list != null) {
						 modelAndView.addObject("list", list);
					 }
					 List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbhStr);
						if (ysfxm != null) {
							modelAndView.addObject("ysfxm", ysfxm);
							int ysfxmLen = ysfxm.size();
							modelAndView.addObject("ysfxmLen", ysfxmLen);
							System.out.println(ysfxm.size());
						}
						List<Map<String, Object>> jylx = ypxxservice.getDicByJylx("jylx");
						List<Map<String, Object>> lyfs = ypxxservice.getDicByJylx("lyfs");
						List<Map<String, Object>> ypzt = ypxxservice.getDicByJylx("ypzt");
						List<Map<String, Object>> bgfsfs = ypxxservice.getDicByJylx("bgfsfs");
						List<Map<String, Object>> yhxtk = ypxxservice.getDicByJylx("yhxtk");
						List<Map<String, Object>> jyfydd = ypxxservice.getDicByJylx("jyfydd");
						List<Map<String, Object>> ypjyzt1 = ypxxservice.getDicByJylx("ypjyzt");
						List<Map<String, Object>> cydw1 = ypxxservice.getDicByJylx("jddw");
						List<Map<String, Object>> rwly = ypxxservice.getDicByJylx("rwly");
						List<Map<String, Object>> jjlx = ypxxservice.getDicByJylx("jjlx");
						List<Map<String, Object>> zslx = ypxxservice.getDicByJylx("zslx");
						List<Map<String, Object>> cydd = ypxxservice.getDicByJylx("cydd");
						modelAndView.addObject("jylx",jylx);
						modelAndView.addObject("lyfs",lyfs);
						modelAndView.addObject("ypzt",ypzt);
						modelAndView.addObject("bgfsfs",bgfsfs);
						modelAndView.addObject("yhxtk",yhxtk);
						modelAndView.addObject("jyfydd",jyfydd);
						modelAndView.addObject("ypjyzt1",ypjyzt1);
						modelAndView.addObject("cydw1",cydw1);
						modelAndView.addObject("rwly",rwly);
						modelAndView.addObject("jjlx",jjlx);
						modelAndView.addObject("zslx",zslx);
						modelAndView.addObject("sfzt",sfzt);
						modelAndView.addObject("cydd",cydd);
						
						//编制 关于报告的数据
						List<Map<String, Object>> yp = ypxxservice.getid(bgbh);
					 	if(yp.size() != 0){
							int ypid=Integer.parseInt(yp.get(0).get("id").toString());
							modelAndView.addObject("ypid", ypid);
							List<Map<String, Object>> shztList = bgxxservice.getShzt(businessKey); //审核状态
							if(shztList.size() != 0){
								String shzt = shztList.get(0).get("shzt").toString();
								modelAndView.addObject("shzt", shzt);
							}
							List<Map<String, Object>> pzztList = bgxxservice.getPzzt(businessKey); //批准状态
							if(pzztList.size() != 0){
								String pzzt = pzztList.get(0).get("shzt").toString();
								modelAndView.addObject("pzzt", pzzt);
							}
							YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
							modelAndView.addObject("ypxx", ypxx);
							List<Map<String, Object>> ypjyzt = bgxxservice.getYpzyzt("ypjyzt");
							modelAndView.addObject("ypjyzt", ypjyzt);
							String jyksbh = ypxx.getJyksbh();
							Integer mbfl = ypxx.getDjlx();
							String zh = ypxx.getZh();
							List<Map<String, Object>> b = bgxxservice.getThreeId(jyksbh, mbfl, zh);
								if(b.size() != 0){
									int fmid=Integer.parseInt(b.get(0).get("fm_id").toString());
									int syid=Integer.parseInt(b.get(0).get("sy_id").toString());
									int fyid=Integer.parseInt(b.get(0).get("fy_id").toString());
									modelAndView.addObject("fmid", fmid);
									modelAndView.addObject("syid", syid);
									modelAndView.addObject("fyid", fyid);
								}
							String djlx = mbfl.toString();
							List<Map<String, Object>> abc = bgxxservice.getBhszList(zh,djlx);
							if(abc.size() != 0){
								String fl = abc.get(0).get("zhfl").toString();
								List<Map<String, Object>> rztb = jyxxservice.getTbList(fl);
								modelAndView.addObject("rztb", rztb);
								List<Map<String, Object>> dwmc = jyxxservice.getDwList(fl);
								if(dwmc.size() != 0){
									String dw = dwmc.get(0).get("sub").toString();
									modelAndView.addObject("dw", dw);
								}
								List<Map<String, Object>> Pzz = jyxxservice.getPzzList(fl);
								if(Pzz.size() != 0){
									String pzz = Pzz.get(0).get("sub").toString();
									modelAndView.addObject("pzz", pzz);
								}
							}
							List<Map<String, Object>> c = bgxxservice.getbgxxList(bgbh);
							if(c.size() != 0){
								int bgid = Integer.parseInt(c.get(0).get("id").toString());
								YjyBgxx bgxx = bgxxservice.getbgxxById(bgid);
								String jyrq = bgxx.getJyrq();
								String cydw = bgxx.getCydw();
								String jyjl = bgxx.getJyjl();
								String rzfs = bgxx.getRzfs();
								String bsdx = bgxx.getBsdx();
								String jyqksm = bgxx.getJyqksm();
								String bztsbg = bgxx.getBz();      //特殊报告   审核和批准用
								modelAndView.addObject("jyrq",jyrq);
								modelAndView.addObject("jyqksm",jyqksm);
								modelAndView.addObject("cydw",cydw);
								modelAndView.addObject("jyjl",jyjl);
								modelAndView.addObject("rzfs",rzfs);
								modelAndView.addObject("bsdx",bsdx);
								modelAndView.addObject("bztsbg",bztsbg);
							}
						}
					 	List<Map<String, Object>> jllb1 = clyyservice.getDicByJylx("jllb1");
						List<Map<String, Object>> jllb2 = clyyservice.getDicByJylx("jllb2");
						modelAndView.addObject("jllb1", jllb1);
						modelAndView.addObject("jllb2", jllb2);
					 	modelAndView.addObject("bgbh",bgbh);
			 }else if("2".equals(ypcs) || "3".equals(ypcs)){             //报告审核   报告批准
				 List<Map<String, Object>> c = bgxxservice.getbgxxList(bgbh);
				 if(c.size() != 0){
					 int bgid = Integer.parseInt(c.get(0).get("id").toString());
					 YjyBgxx bgxx = bgxxservice.getbgxxById(bgid);
					 String bztsbg = bgxx.getBz();      //特殊报告   审核和批准用
					 modelAndView.addObject("bztsbg",bztsbg);
					 modelAndView.addObject("bgbh",bgbh);
				 }
			 }else if("5".equals(ypcs)){                                     //报告归档
//					查询需要归档的样品信息
					String id=mapBusi.get("id").toString();
					List<Map<String, Object>> gdypxx = ypxxservice.getYpxx(Integer.parseInt(id));
					if (gdypxx != null) {
						modelAndView.addObject("ypxx", gdypxx);
						modelAndView.addObject("jyks", gdypxx.get(0).get("jyks"));
					}
					List<Map<String, Object>> dalx = yDaXxService.getDicByJylx("dalx");
					modelAndView.addObject("dalx",dalx);
				 	request.setAttribute("bgbh", bgbh);
				 	List<Map<String, Object>> ysjl = ysjlService.getYsjlbyBgbh(bgbh);
				 	if(ysjl.size()!=0){
				 		String bz =ysjl.get(0).get("bz").toString();
				 		String ywysjl =ysjl.get(0).get("ywysjl").toString();
				 		String ysjlwjm =ysjl.get(0).get("ysjlwjm").toString();
				 		String ysjllj =ysjl.get(0).get("ysjllj").toString();
				 		modelAndView.addObject("bz",bz);
				 		modelAndView.addObject("ywysjl",ywysjl);
				 		modelAndView.addObject("ysjlwjm",ysjlwjm);
				 		modelAndView.addObject("ysjllj",ysjllj);
				 	}
			 	}
			 }
		}
		return modelAndView;
	}

	/**
	 * 根据当前登陆用户取得该用户的待办任务列表
	 * 流程分页
	 */
	@RequestMapping(value = "/getPendPoolList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getPendPoolList(Integer start,Integer limit, String cxtj,String ypcs) {
		return manualTaskService.getPendPoolListToo(start, limit, cxtj,ypcs);
	}
	
	/**
	 * 点击图片类型原始记录
	 * @return
	 */
	@RequestMapping(value = "/getImageList", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getImageList(String id) {
		return ysjlService.getImageList(id);
	}
	
	/**
	 * 在线查看原始记录文档
	 * @return
	 */
	@RequestMapping(value="/WordOnLine")
	public ModelAndView openPage1(String ysjlsjm,String bz){
		String url = null ;
		if(bz.equals("2")){
			url ="/jygl/jsp/WordOnLine";
		}
		if(bz.equals("3")){
			url ="/jygl/jsp/PdfOnLine";
		}
		ModelAndView modelAndView = new ModelAndView(url);
		if (ysjlsjm != null) {
			modelAndView.addObject("ysjlsjm", ysjlsjm);
		}
		return modelAndView;
	}
//	/**
//	 * 根据当前登陆用户取得该用户的缓存待办任务列表
//	 */
//	@RequestMapping(value = "/getPendPoolListCache", method = RequestMethod.POST)
//	@ResponseBody
//	public List<Map<String, Object>> getPendPoolListCache(Integer start,Integer limit, String cxtj) {
//		Cache cache = cacheManager.getCache("resources");
//		Cache.ValueWrapper wrapper = null;
//		wrapper = cache.get("getPendPoolList");
//		List<Map<String, Object>> list = (ArrayList) wrapper.get();
//		return list;
//	}
	/**
	 * 定时任务，自动归档未归档的任务
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月24日 下午4:43:48 
	 * @param start
	 * @param limit
	 * @param cxtj
	 * @throws SQLException 
	 * @throws SerialException 
	 */
	@RequestMapping(value = "/zdgdTask", method = RequestMethod.POST)
	@ResponseBody
	public void zdgdTask(Integer start, Integer limit, String cxtj) throws SerialException, SQLException {
		List<Task> list = manualTaskService.getTask();
		for(Task task : list){
			String taskId = task.getId();
			String processInstanceId = task.getProcessInstanceId();
		    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
		    String businessKey = processInstance.getBusinessKey();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String tname =  task.getName();
		    String taskdate = sdf.format(task.getCreateTime());
		    String now = sdf.format(new Date());
		   
		    try {
				int days = AppUtil.daysBetween(sdf.parse(taskdate), sdf.parse(now));
				if(days>15){
					testProcessService.dealZdgd(taskId, businessKey, tname);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据当前登陆用户取得该用户的待办任务列表数目
	 */
	@RequestMapping(value = "/getPendPoolListSize", method = RequestMethod.POST)
	@ResponseBody
	public String getPendPoolListSize(Integer start, Integer limit, String rolekind) {
		List<Map<String, Object>> list0 = manualTaskService.getPendPoolList(start, limit, rolekind,"0");
		int size0 = list0.size();//任务分配
		List<Map<String, Object>> list1 = manualTaskService.getPendPoolList(start, limit, rolekind,"1");
		int size1 = list1.size();//报告编制
		List<Map<String, Object>> list2 = manualTaskService.getPendPoolList(start, limit, rolekind,"2");
		int size2 = list2.size();//报告审批
		List<Map<String, Object>> list3 = manualTaskService.getPendPoolList(start, limit, rolekind,"3");
		int size3 = list3.size();//报告批准
		List<Map<String, Object>> list4 = manualTaskService.getPendPoolList(start, limit, rolekind,"4");
		int size4 = list4.size();//报告接收
		List<Map<String, Object>> list5 = manualTaskService.getPendPoolList(start, limit, rolekind,"5");
		int size5 = list5.size();//报告归档
		
		List<Map<String, Object>> listdsf = bgsfService.getDsfbgsf();
		int sfsize = listdsf.size();//收费信息条数
		String res = "{\"success\":true,\"size0\":"+size0+",\"size1\":"+size1+",\"size2\":"+size2+",\"size3\":"+size3+",\"size4\":"+size4+",\"size5\":"+size5+",\"sfsize\":"+sfsize+"}";
		return res;
	}
	
	

	/**
	 * 当前登陆用户签收任务
	 * 
	 * @param taskId
	 *            任务ID
	 * @return
	 */
	@RequestMapping(value = "/claimTask", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData claimTask(String taskId) {
		manualTaskService.claimTask(taskId);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 当前登陆用户签收任务（批量）
	 * @param taskId
	 *            任务ID
	 * @return
	 */
	@RequestMapping(value = "/PLclaimTask", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData PLclaimTask(String[] taskIds) {
		manualTaskService.PLclaimTask(taskIds);
		return ResponseData.SUCCESS_NO_DATA;
	}

	/**
	 * 根据流程实例ID和是否已经结束流程标志动态显示流程图及运行轨迹
	 * 
	 * @param processInstanceId
	 *            流程实例ID
	 * @param hisFlag
	 *            是否历史流程 1:是 , 0:否
	 * @return
	 */
	@RequestMapping(value = "/showProcessTrack")
	public ModelAndView showProcessTrack(String processInstanceId,
			Integer hisFlag,String bgbh) {
		String showProcessUrl = "";
		ModelAndView modelAndView = new ModelAndView("/cps/process/showProcessTrack");
		List<Map<String,Object>> optionList = yshJybDao.getYshJybListByYpbh(bgbh);
		modelAndView.addObject("optionList", optionList);
		if (hisFlag == 1) {
			showProcessUrl = "/cps/processXN/showHistoryProcessImage?processInstanceId="
					+ processInstanceId;
		} else if (hisFlag == 0) {
			List<Map<String, Object>> runningAct = new ArrayList<Map<String, Object>>();
			showProcessUrl = "/cps/processXN/showProcessImage?processInstanceId="+ processInstanceId;
			List<HistoricActivityInstance> activityInstances = historyService
					.createHistoricActivityInstanceQuery()
					.processInstanceId(processInstanceId).orderByActivityId()
					.asc().list();
			for (HistoricActivityInstance historicActivityInstance : activityInstances) {
				if (historicActivityInstance.getEndTime() == null) {// 节点正在运行中
					Boolean flag = true;
					Map<String, Object> tempMap = new HashMap<String, Object>();
					tempMap.put("actName",
							historicActivityInstance.getActivityName());
					if (runningAct.size() > 0) {
						for (Map<String, Object> map : runningAct) {
							if (map.get("actName")
									.toString()
									.equalsIgnoreCase(
											historicActivityInstance
													.getActivityName())) {
								flag = false;
							}
						}
					}
					if (flag) {
						runningAct.add(tempMap);
					}
				}
			}
			modelAndView.addObject("runningAct", runningAct);
		}
		modelAndView.addObject("showProcessUrl", showProcessUrl);
		return modelAndView;
	}
	
	/**
	 * 主检人员点击预览报告时，判断附页是否存在。
	 * @author duanpeijun
	 * @date 2016年1月7日
	 * @param request
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/findFile")
	public String findFile(HttpServletRequest request,String bgbh) {
		File file=new File(request.getSession().getServletContext().getRealPath("resources/doc")+"/"+bgbh+"fy.doc");    
		if(!file.exists())    
		{    
			return "0";
		}else{
			return "1";
		}
	}

}
