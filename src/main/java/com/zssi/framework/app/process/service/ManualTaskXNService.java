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

package com.zssi.framework.app.process.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.process.dao.BusinessXNDao;
import com.zssi.framework.app.process.support.ProcessXNUtils;
import com.zssi.framework.app.process.support.file.CpsConstant;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * @author zhangyi
 */
@Service
public class ManualTaskXNService {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private BusinessXNDao businessDao;
	/**
	 * 根据当前登陆用户取得该用户的待办任务列表,包括流程直接分配到个人的和分配到组未签收的
	 * 新的查询方法
	 * liusong 2016-04-20
	 */
	@Transactional
	public List<Map<String, Object>> getPendPoolList(Integer start,Integer limit,String cxtj,String ypcs){
		
		List<Map<String, Object>> list = businessDao.getPendPoolList(cxtj,ypcs);
		
		Cache cache = this.cacheManager.getCache("resources");
		cache.put("getPendPoolList", list);
	   return list;
	}
	
	/**
	 * 流程分页
	 * @author duanpeijun
	 * @date 2016年7月24日
	 * @param start
	 * @param limit
	 * @param cxtj
	 * @param ypcs
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getPendPoolListToo(Integer start,Integer limit,String cxtj,String ypcs){
		
		Pagination<Map<String, Object>> list = businessDao.getPendPoolListToo(cxtj,ypcs, limit, limit);
		
		Cache cache = this.cacheManager.getCache("resources");
		cache.put("getPendPoolList", list);
	   return businessDao.getPendPoolListToo(cxtj, ypcs, start, limit);
	}
	
	/**
	 * 根据当前登陆用户取得该用户的待办任务列表,包括流程直接分配到个人的和分配到组未签收的
	 * 原来的方法
	 */
	@Transactional
	public List<Map<String, Object>> getPendPoolList1(Integer start, Integer limit,String cxtj,String ypcs) {	
		SysYh user = AppUtil.getCurrentUser();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Task> tasks = new ArrayList<Task>();
		String userCode = user.getUsername();
		// userCode = "kermit";
		//取得直接分配给个人的任务
		List<Task> tasksAssignee = taskService.createTaskQuery().taskAssignee(userCode).active().processDefinitionKey(ProcessXNUtils.bzProcessKey).orderByTaskCreateTime().desc().list();
//		System.out.println("=======1======="+new java.util.Date());
		//取得分配给当前登陆用户所属组的任务
		List<Task> taskCandidateGroup = taskService.createTaskQuery().taskCandidateUser(userCode).active().processDefinitionKey(ProcessXNUtils.bzProcessKey).orderByTaskCreateTime().desc().list();
//		System.out.println("=======2======="+new java.util.Date());
		tasks.addAll(tasksAssignee);
		tasks.addAll(taskCandidateGroup);
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		for(Task task:tasks) {
//			System.out.println("=======3每次进入循环开始时间======="+new java.util.Date());
			Map<String, Object> map = new HashMap<String, Object>();
			String processInstanceId = task.getProcessInstanceId();
		    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
		    String businessKey = processInstance.getBusinessKey();
		    String activityId = processInstance.getActivityId();
			map.put("processFlag", "0");//流程运行中
			map.put("activityId", activityId);//当前环节
		    //流程相关数据
			map.put("taskId", task.getId());
//			map.put("processDefinitionId", task.getProcessDefinitionId());
			map.put("processInstanceId", task.getProcessInstanceId());
			map.put("name", task.getName());
//			map.put("taskDefinitionKey", task.getTaskDefinitionKey());
			map.put("assignee", task.getAssignee());
//			map.put("owner", task.getOwner());
//			map.put("priority", task.getPriority());
			if(task.getCreateTime() != null){
				map.put("createTime", sdf.format(task.getCreateTime()));
			}else{
				map.put("createTime", task.getCreateTime());
			}
//			System.out.println("=======4每次查询流程数据时间（每次开始查询业务数据时间）======="+new java.util.Date());
//			if(task.getDueDate() != null){
//				map.put("dueDate", sdf.format(task.getDueDate()));
//			}else{
//				map.put("dueDate", task.getDueDate());
//			}
//			map.put("description", task.getDescription());
//			Map<String,Object> var = taskService.getVariables(task.getId());
//			String bkhr = "";
//			String bdlcid = "";
//			String orgCode = "";
//			if(var.get("StaffCODE")!= null){
//				bkhr= var.get("StaffCODE").toString();
//			}
//			if(var.get("businessKey")!= null){
//				bdlcid= var.get("businessKey").toString();
//			}
//			if(var.get("orgCode")!= null){
//				orgCode= var.get("orgCode").toString();
//			}
		    //业务数据
		    if(StringUtils.hasText(businessKey)) {
		    	map.put("businessKey", businessKey);
			    List<Map<String, Object>> listBusi = businessDao.getListProcessByYpbhb(businessKey,cxtj,ypcs);
			    if(listBusi.size()>0){
			    	Map<String, Object> mapBusi = listBusi.get(0);
			    	map.put("id", mapBusi.get("id"));
			    	map.put("ypbh", mapBusi.get("ypbh"));
//			    	String bgbh = mapBusi.get("ypbh").toString();
//			    	List<Map<String, Object>> rw = businessDao.getzjr(bgbh);
//			    	if(rw.size() != 0){
//			    		String zjy = rw.get(0).get("bzr").toString();
//			    		map.put("zjy", zjy);
//			    	}
			    	map.put("ypmc", mapBusi.get("ypmc"));
			    	map.put("wcqx", mapBusi.get("wcqx"));
			    	map.put("yplx", mapBusi.get("yplx"));
			    	map.put("jylx", mapBusi.get("jylx"));
			    	map.put("jyfy", mapBusi.get("jyfy"));
			    	map.put("ysfje", mapBusi.get("ysfje"));
			    	map.put("jyjsrq", mapBusi.get("jyjsrq"));
			    	map.put("jyfy", mapBusi.get("jyfy"));
			    	map.put("szcs", mapBusi.get("szcs"));
			    	map.put("wtdw", mapBusi.get("wtdw"));
			    	map.put("lxr", mapBusi.get("lxr"));
			    	map.put("jyks", mapBusi.get("jyks"));
			    	map.put("ywks", mapBusi.get("ywks"));
			    	map.put("jyksbh", mapBusi.get("jyksbh"));
			    	map.put("ywksbh", mapBusi.get("ywksbh"));
			    	map.put("jyksmc", mapBusi.get("jyksmc"));
			    	map.put("ywksmc", mapBusi.get("ywksmc"));
			    	map.put("bz", mapBusi.get("bz"));
			    	map.put("ysjlsjm", mapBusi.get("ysjlsjm"));
			    	map.put("did", mapBusi.get("did"));
			    	list.add(map);
//			    	System.out.println("=======5每次结束查询业务数据时间（每次结束循环时间）======="+new java.util.Date());
			    }		    	
		    }
			Cache cache = this.cacheManager.getCache("resources");
			cache.put("getPendPoolList", list);
		}
		return list;
	}
	
	/**
	 * 当前登陆用户签收任务
	 * @param taskId 任务ID
	 * @return
	 */
	public void claimTask(String taskId) {
		SysYh user = AppUtil.getCurrentUser();
		String userCode = user.getUsername();
		taskService.claim(taskId, userCode);
	}
	
	/**
	 * 当前登陆用户签收任务（批量）
	 * @param taskId 任务ID
	 * @return
	 */
	public void PLclaimTask(String[] taskIds) {
		SysYh user = AppUtil.getCurrentUser();
		String userCode = user.getUsername();
		for(int i=0;i<taskIds.length;i++){
			taskService.claim(taskIds[i], userCode);
		}
	}
	
	/**
	 * 获取自动归档的任务
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月24日 下午4:47:28 
	 * @return
	 */
	public List<Task> getTask() {	
		List<Task> tasks = new ArrayList<Task>();
		String userCode = businessDao.getUserByUserRole(CpsConstant.ROLE_BGGDRY);//获取报告归档角色的人
		List<Task> tasksAssignee = taskService.createTaskQuery().taskAssignee(userCode).active().processDefinitionKey(ProcessXNUtils.bzProcessKey).orderByTaskCreateTime().desc().list();
		//取得分配给当前登陆用户所属组的任务
		List<Task> taskCandidateGroup = taskService.createTaskQuery().taskCandidateUser(userCode).active().processDefinitionKey(ProcessXNUtils.bzProcessKey).orderByTaskCreateTime().desc().list();
		tasks.addAll(tasksAssignee);
		tasks.addAll(taskCandidateGroup);
		return tasks;
	}


}
