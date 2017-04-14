package com.zssi.framework.app.process.service;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dagl.dao.YdaXxDao;
import com.zssi.framework.app.dagl.model.YdaXx;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.process.dao.BusinessXNDao;
import com.zssi.framework.app.process.dao.TestProcessDao;
import com.zssi.framework.app.process.dao.YshJybDao;
import com.zssi.framework.app.process.model.TestProcess;
import com.zssi.framework.app.process.model.YshJyb;
import com.zssi.framework.app.process.support.file.CpsConstant;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;


@Service
public class TestProcessService {

	@Autowired
	private TestProcessDao testProcessDao;
	
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private YshJybDao yshJybDao;
    
    @Autowired
    private YdaXxDao ydaXxDao;
    
    @Autowired
	private BusinessXNDao businessDao;
    
    @Autowired
    private BusinessXNDao businessXNDao;  
    
    @Autowired
	private YypYpxxService ypxxservice;
    
    @Autowired
    private YjyBgxxService bgxxservice;
    
	@Autowired
	private ManualTaskXNService manualTaskService;
	
	@Autowired
	private RuntimeService runtimeService;
  
/**
 * 技术中心审批
 * @author:zhangyi 
 * @version 创建时间：2015年11月13日 上午10:12:27 
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void dealJSZXSPAct(String taskId, String lineVariable, String value, String businessKey, String optionContent,String tname) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		jyb.setShzt(Integer.parseInt(value));
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	if(value.equals("1")) {
		//获取科室主任
		String ksrwfpUser = businessXNDao.getUserByUserRoleAndorgCode(orgCode,CpsConstant.ROLE_KSZR);
		if(ksrwfpUser!=null){
			variables.put("ksrwfpUser", ksrwfpUser);
		}
	}else {
		System.out.println("-------------------"+var.get("BmjlCODE"));
	}
	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
}

/**
 * 业务前台登记修改环节
 * @author:zhangyi 
 * @version 创建时间：2015年11月13日 上午10:12:27
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public String dealYWQTDJXGAct(Integer ypid){
	List<Map<String, Object>> listTask = businessXNDao.getTaskId(ypid);
	if(listTask.size()>0){
		Map<String, Object> map = listTask.get(0);
		SysYh user = AppUtil.getCurrentUser();
		if(user != null){
			YshJyb jyb = new YshJyb();
			jyb.setBgbh(ypid.toString());
			jyb.setShjdmc( map.get("tname").toString());
			jyb.setShr(user.getXm());
			jyb.setShsj(new Date());
			jyb.setShyj("");
			jyb.setShzt(1);
			yshJybDao.save(jyb);
		}
		//根据页面选择的操作设置连线变量完成任务
		Map<String, Object> variables = new HashMap<String, Object>();
	
		YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
		ypxx.setYpjyzt(0);
		ypxxservice.update(ypxx);
		taskService.complete(map.get("taskId").toString(), variables);
		return "1";
	}
	return "0";
}


/**
 * * 科室主任分配任务环节  （批量分配）
 * @author:段佩君
 * @date 2016年6月1日
 * @param taskIds
 * @param lineVariable
 * @param value
 * @param businessKeys
 * @param optionContent
 * @param tname
 * @param jyry
 */
@Transactional
public void dealPLKSZRFPRWAct(String[] taskIds, String lineVariable,String value, String[] businessKeys, String optionContent,String tname, String jyry) {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		orgCode = user.getBmbh();
		for(int j=0;j<businessKeys.length;j++){
			YshJyb jyb = new YshJyb();
			jyb.setBgbh(businessKeys[j]);
			jyb.setShjdmc(tname);
			jyb.setShr(user.getXm());
			jyb.setShsj(new Date());
			jyb.setShyj(optionContent);
			jyb.setShzt(Integer.parseInt(value));
			jyb.setXgjdry(jyry);
			yshJybDao.save(jyb);
		}
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	if("1".equalsIgnoreCase(value)){
		for(int j=0;j<businessKeys.length;j++){
			variables.put("ypzjUser", jyry);
			//改变样品信息‘样品检验状态’的值为1(待编制)
			YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKeys[j]));
			ypxx.setYpjyzt(1);
			ypxxservice.update(ypxx);
		}
	}
	variables.put(lineVariable, value);
	for(int i=0;i<taskIds.length;i++){
		taskService.complete(taskIds[i], variables);
	}
}

/**
 * 科室主任分配任务环节
 * @author:zhangyi 
 * @version 创建时间：2015年11月17日 下午4:59:30 
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @param tname
 * @param jyry
 */
@Transactional
public void dealKSZRFPRWAct(String taskId, String lineVariable,String value, String businessKey, String optionContent,String tname, String jyry) {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		jyb.setShzt(Integer.parseInt(value));
		jyb.setXgjdry(jyry);
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	if("1".equalsIgnoreCase(value)){
		variables.put("ypzjUser", jyry);
		//改变样品信息‘样品检验状态’的值为1(待编制)
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(1);
		ypxxservice.update(ypxx);
	}else if("0".equalsIgnoreCase(value)){
		System.out.println("------------->"+value);
		variables.put("ypzjUser", jyry);
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(8);
		ypxxservice.update(ypxx);
	}
	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
}

/**
 * 主检科室检验环节
 * @author:zhangyi 
 * @version 创建时间：2015年11月17日 下午4:59:30 
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @param tname
 * @param jyry
 */
@Transactional
public void dealYPZJAct(String taskId, String lineVariable,String value, String businessKey, String optionContent,String tname,String jyshry) {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		jyb.setShzt(Integer.parseInt(value));
		jyb.setXgjdry(jyshry);
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	//改变样品信息‘样品检验状态’的值为2(已审编制)
//	List<Map<String, Object>> getYpByBh = ypxxservice.getYpbgbh(businessKey);
//	if(getYpByBh.size() != 0){
//		int id=Integer.parseInt(getYpByBh.get(0).get("id").toString());
//		YypYpxx ypxx = ypxxservice.getYpxxById(id);
//		ypxx.setYpjyzt(2);
//		ypxxservice.update(ypxx);
//	}
	YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
	ypxx.setYpjyzt(2);
	ypxxservice.update(ypxx);
	variables.put("ypzjshUser", jyshry);
	variables.put("isChehui", 1);
//	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
}

/**
 * 主检科室审核：不通过（批量不通过）
 * duanpeijun
 */
@Transactional
public void dealPLYZZJSHAct(String[] taskIds, String lineVariable, String value, String[] businessKeys, 
		String optionContent,String tname,String pzr){
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		for(int j=0;j<businessKeys.length;j++){
			orgCode = user.getBmbh();
			YshJyb jyb = new YshJyb();
			jyb.setBgbh(businessKeys[j]);
			jyb.setShjdmc(tname);
			jyb.setShr(user.getXm());
			jyb.setShsj(new Date());
			jyb.setShyj(optionContent);
			jyb.setShzt(Integer.parseInt(value));
			jyb.setXgjdry(pzr);
			yshJybDao.save(jyb);
		}
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	if(value.equals("0")) {
		//改变样品信息‘样品检验状态’的值为1(待编制)
		for(int j=0;j<businessKeys.length;j++){
			YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKeys[j]));
			ypxx.setYpjyzt(1);
			ypxxservice.update(ypxx);
		}
	}
	variables.put(lineVariable, value);
	for(int i=0;i<taskIds.length;i++){
		taskService.complete(taskIds[i], variables);	
	}
}

/**
 * 主检科室审核环节
 * @author:zhangyi 
 * @version 创建时间：2015年11月13日 上午10:12:27
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void dealYZZJSHAct(String taskId, String lineVariable, String value, String businessKey, 
		String optionContent,String tname,String pzr) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		jyb.setShzt(Integer.parseInt(value));
		jyb.setXgjdry(pzr);
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	if(value.equals("1")) {
		//获取技术中心批准人员
		String jszxpzUser = businessXNDao.getUserByUserRoleAndorgCode(orgCode,CpsConstant.ROLE_GCJSZXPZR);
		if(jszxpzUser!=null){
			variables.put("jszxpzUser", jszxpzUser);
		}
		//改变样品信息‘样品检验状态’的值为3(已审核)
//		List<Map<String, Object>> getYpByBh = ypxxservice.getYpbgbh(businessKey);
//		if(getYpByBh.size() != 0){
//			int id=Integer.parseInt(getYpByBh.get(0).get("id").toString());
//			YypYpxx ypxx = ypxxservice.getYpxxById(id);
//			ypxx.setYpjyzt(3);
//			ypxxservice.update(ypxx);
//		}
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(3);
		ypxxservice.update(ypxx);
	}else {
		//改变样品信息‘样品检验状态’的值为1(待编制)
//		List<Map<String, Object>> getYpByBh = ypxxservice.getYpbgbh(businessKey);
//		if(getYpByBh.size() != 0){
//			int id=Integer.parseInt(getYpByBh.get(0).get("id").toString());
//			YypYpxx ypxx = ypxxservice.getYpxxById(id);
//			ypxx.setYpjyzt(1);
//			ypxxservice.update(ypxx);
//		}
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(1);
		ypxxservice.update(ypxx);
		System.out.println("-------------------"+var.get("BmjlCODE"));
	}
	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
}

/**
 * 技术中心批准环节
 * @author:zhangyi 
 * @version 创建时间：2015年11月13日 上午10:12:27
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void dealJSZXPZAct(String taskId, String lineVariable, String value, String businessKey, String optionContent,String tname) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		jyb.setShzt(Integer.parseInt(value));
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	if(value.equals("1")) {
		//改变样品信息‘样品检验状态’的值为4(已批准)
//		List<Map<String, Object>> getYpByBh = ypxxservice.getYpbgbh(businessKey);
//		if(getYpByBh.size() != 0){
//			int id=Integer.parseInt(getYpByBh.get(0).get("id").toString());
//			YypYpxx ypxx = ypxxservice.getYpxxById(id);
//			ypxx.setYpjyzt(4);
//			ypxxservice.update(ypxx);
//		}
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(4);
		ypxxservice.update(ypxx);
	}else{
		//改变样品信息‘样品检验状态’的值为1(待编制)
//		List<Map<String, Object>> getYpByBh = ypxxservice.getYpbgbh(businessKey);
//		if(getYpByBh.size() != 0){
//			int id=Integer.parseInt(getYpByBh.get(0).get("id").toString());
//			YypYpxx ypxx = ypxxservice.getYpxxById(id);
//			ypxx.setYpjyzt(1);
//			ypxxservice.update(ypxx);
//		}
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(1);
		ypxxservice.update(ypxx);
	}
	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
}

/**
 * 业务科室接收环节
 * @author:zhangyi 
 * @version 创建时间：2015年11月13日 上午10:12:27
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void dealYWKSJSAct(String taskId, String lineVariable, String value, String businessKey, String optionContent,String tname,String jyksbh) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
//		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		jyb.setShzt(Integer.parseInt(value));
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	if(value.equals("1")) {
		//获取工程技术中心解锁人员
//		if(var.get("orgCode")!=null){
//			orgCode = var.get("orgCode").toString();
//		}
//		String jszxjsUser = businessXNDao.getUserByUserRoleAndorgCode(jyksbh,CpsConstant.ROLE_GCJSZXJSR);
//		if(jszxjsUser!=null){
//			variables.put("jszxjsUser", jszxjsUser);
//		}
		//改变样品信息‘样品检验状态’的值为5(已接收)
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(5);
		ypxxservice.update(ypxx);
	}else {
		System.out.println("-------------------"+var.get("BmjlCODE"));
	}
	//接收通过的连线
	List<Map<String, Object>> listTask = businessXNDao.getTaskId(Integer.parseInt(businessKey));
	if(listTask.size()>0){
		Map<String, Object> map = listTask.get(0);
		variables.put("ywksjsAgree", 1);
		taskService.complete(map.get("taskId").toString(), variables);
	}
//	variables.put(lineVariable, value);
	//taskService.complete(taskId, variables);		
}

/**
 * 业务科室归档（工程技术中心解锁环节）
 * @author:zhangyi 
 * @version 创建时间：2015年11月13日 上午10:12:27
 * @param taskId
 * @param lineVariable
 * @param value
 * @param businessKey
 * @param optionContent
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void dealJSZXJSAct(String taskId, String lineVariable, String value, String businessKey, String optionContent,String tname,String jyksbh) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	String orgCode = "";
	if(user != null){
//		orgCode = user.getBmbh();
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj(optionContent);
		if("0".equalsIgnoreCase(value)) {
			jyb.setShzt(2);
		}else{
			jyb.setShzt(3);
		}
		yshJybDao.save(jyb);
	}
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	if(value.equals("0")) {
		System.out.println("---------检验完成归档的操作----------");
		//改变样品信息‘样品检验状态’的值为6(结束)
//		List<Map<String, Object>> getYpByBh = ypxxservice.getYpbgbh(businessKey);
//		if(getYpByBh.size() != 0){
//			int id=Integer.parseInt(getYpByBh.get(0).get("id").toString());
//			YypYpxx ypxx = ypxxservice.getYpxxById(id);
//			ypxx.setYpjyzt(6);
//			ypxxservice.update(ypxx);
//		}
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(6);
		ypxxservice.update(ypxx);
	}else {
		System.out.println("-------------------"+var.get("BmjlCODE"));
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		ypxx.setYpjyzt(1);
		ypxxservice.update(ypxx);
	}
	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
}

/**
 * 页面手动解锁
 * @author:zhangyi 
 * @version 创建时间：2015年12月28日 下午1:38:56 
 * @param ypid
 * @throws SQLException 
 * @throws SerialException 
 */
@Transactional
public String dealWebJs(Integer ypid) {
	List<Map<String, Object>> listTask = businessXNDao.getTaskId(ypid);
	if(listTask.size()>0){
		Map<String, Object> map = listTask.get(0);
		//this.dealYWKSJSAct(map.get("taskId").toString(), "", 1+"", ypid.toString(), "", map.get("tname").toString(), "");
		SysYh user = AppUtil.getCurrentUser();
		if(user != null){
			YshJyb jyb = new YshJyb();
			jyb.setBgbh(ypid.toString());
			jyb.setShjdmc( map.get("tname").toString());
			jyb.setShr(user.getXm());
			jyb.setShsj(new Date());
			jyb.setShyj("");
			jyb.setShzt(0);
			yshJybDao.save(jyb);
		}
		//根据页面选择的操作设置连线变量完成任务
		Map<String, Object> variables = new HashMap<String, Object>();
		YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
		String ypjyzt = ypxx.getYpjyzt().toString();
		if("4".equals(ypjyzt)){             //批准之后解锁      ywksjsAgree==0
			variables.put("ywksjsAgree", 0);
			taskService.complete(map.get("taskId").toString(), variables);
		}else if("5".equals(ypjyzt)){      	//接收之后解锁      jszxjsAgree==0
			variables.put("jszxjsAgree", 1);
			taskService.complete(map.get("taskId").toString(), variables);
		}
		ypxx.setYpjyzt(1);
		ypxxservice.update(ypxx);
		String bgbh = ypxx.getBgbh();
		List<Map<String, Object>> b = bgxxservice.getbgxxList(bgbh);
		if( b.size() != 0){
			int bgid = Integer.parseInt(b.get(0).get("id").toString());
			YjyBgxx bgxx = bgxxservice.getbgxxById(bgid);
			bgxx.setSfjs(1);
		}
		return "1";
	}
	return "0";
}

/**
 * 页面手动撤回
 * @author:zhangyi 
 * @version 创建时间：2015年12月28日 下午1:38:56 
 * @param ypid
 * @throws SQLException 
 * @throws SerialException 
 */
@Transactional
public String dealWebCh(Integer ypid) {
	List<Map<String, Object>> listTask = businessXNDao.getTaskId(ypid);
	if(listTask.size()>0){
		Map<String, Object> map = listTask.get(0);
		//this.dealYWKSJSAct(map.get("taskId").toString(), "", 1+"", ypid.toString(), "", map.get("tname").toString(), "");
		SysYh user = AppUtil.getCurrentUser();
		if(user != null){
			YshJyb jyb = new YshJyb();
			jyb.setBgbh(ypid.toString());
			jyb.setShjdmc( map.get("tname").toString());
			jyb.setShr(user.getXm());
			jyb.setShsj(new Date());
			jyb.setShyj("");
			jyb.setShzt(0);
			yshJybDao.save(jyb);
		}
		//根据页面选择的操作设置连线变量完成任务
		Map<String, Object> variables = new HashMap<String, Object>();
		YypYpxx ypxx = ypxxservice.getYpxxById(ypid);
		ypxx.setYpjyzt(0);
		ypxxservice.update(ypxx);
		variables.put("isChehui", 0);
		taskService.complete(map.get("taskId").toString(), variables);
//		String bgbh = ypxx.getBgbh();
//		List<Map<String, Object>> b = bgxxservice.getbgxxList(bgbh);
//		if( b.size() != 0){
//			int bgid = Integer.parseInt(b.get(0).get("id").toString());
//			YjyBgxx bgxx = bgxxservice.getbgxxById(bgid);
//			bgxx.setSfjs(1);
//		}
		return "1";
	}
	return "0";
}

/**
 * 自动归档
 * @author:zhangyi 
 * @version 创建时间：2015年12月29日 下午3:19:12 
 * @param start
 * @param limit
 * @param cxtj
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void zdgdTask() throws SerialException, SQLException {
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
				this.dealZdgd(taskId, businessKey, tname);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 自动归档
 * @author:zhangyi 
 * @version 创建时间：2015年12月28日 上午9:24:15 
 * @param taskId
 * @param businessKey
 * @param tname
 * @throws SerialException
 * @throws SQLException
 */
@Transactional
public void dealZdgd(String taskId, String businessKey, String tname) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	if(user != null){
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr(user.getXm());
		jyb.setShsj(new Date());
		jyb.setShyj("");
		jyb.setShzt(1);
		yshJybDao.save(jyb);
		YdaXx daxx = new YdaXx();
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		if (ypxx != null) {
			daxx.setSsjgid(ypxx.getJyks());
			daxx.setDabt(ypxx.getYpmc());
			daxx.setFjid(ypxx.getBgbh() + ".pdf");
			daxx.setDalx("检验报告");
			daxx.setDagjz("自动归档检验报告");
			daxx.setGdnr("自动归档检验报告");
			daxx.setLmmc("自动归档报告");
			daxx.setDamj("1级");
			daxx.setBgqx("10年");
			daxx.setBz("此档案为自动归档");
			daxx.setGdr("admin");
			ydaXxDao.save(daxx);
			}
	}else{
		YshJyb jyb = new YshJyb();
		jyb.setBgbh(businessKey);
		jyb.setShjdmc(tname);
		jyb.setShr("admin");
		jyb.setShsj(new Date());
		jyb.setShyj("自动归档!");
		jyb.setShzt(2);
		YdaXx daxx = new YdaXx();
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
		if (ypxx != null) {
			daxx.setSsjgid(ypxx.getJyks());
			daxx.setDabt(ypxx.getYpmc());
			daxx.setFjid(ypxx.getBgbh() + ".pdf");
			daxx.setDalx("检验报告");
			daxx.setDagjz("自动归档检验报告");
			daxx.setGdnr("自动归档检验报告");
			daxx.setLmmc("自动归档报告");
			daxx.setDamj("1级");
			daxx.setBgqx("10年");
			daxx.setBz("此档案为自动归档");
			daxx.setGdr("admin");
			ydaXxDao.save(daxx);
			}
	}
	YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(businessKey));
	ypxx.setYpjyzt(6);
	ypxxservice.update(ypxx);
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	variables.put("jszxjsAgree", 0);
	taskService.complete(taskId, variables);
}

	/**
	 * 通用环节处理逻辑
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 * @throws SQLException 
	 * @throws SerialException 
	 */
	@Transactional
	public void dealRlbAct(String taskId, String lineVariable, String value, String businessKey, String optionContent) throws SerialException, SQLException {
	SysYh user = AppUtil.getCurrentUser();
	//根据页面选择的操作设置连线变量完成任务
	Map<String, Object> variables = new HashMap<String, Object>();
	Map<String,Object> var =  taskService.getVariables(taskId);
	

	variables.put(lineVariable, value);
	taskService.complete(taskId, variables);		
	}

	/**
 * 获取当前检验人员的openid
 * @author liangkaidi
 * @date 2016-3-11
 * @param jyry
 * @return
 */
	public List<Map<String, Object>> getopenId(String jyry) {
		// TODO Auto-generated method stub
		return testProcessDao.getopenId(jyry);
	}
	
	/**
 * 获取当前审核人员的openid
 * @author liangkaidi
 * @date 2016-3-11
 * @param jyry
 * @return
 */
	public List<Map<String, Object>> getopenIdjyshry(String jyshry) {
		// TODO Auto-generated method stub
		return testProcessDao.getopenIdjyshry(jyshry);
	}

	public List<Map<String, Object>> getopenIdjyks(String jyks) {
		// TODO Auto-generated method stub
		return testProcessDao.getopenIdjyks(jyks);
	}

}
