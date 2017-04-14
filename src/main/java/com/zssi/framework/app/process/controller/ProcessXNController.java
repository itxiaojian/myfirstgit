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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bpm.engine.extend.diagram.ProcessDiagramGeneratorExtend;
import com.likegene.framework.core.BaseController;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyBgzh;
import com.zssi.framework.app.jygl.service.YjyBgxxService;
import com.zssi.framework.app.process.dao.BusinessXNDao;
import com.zssi.framework.app.process.dao.YshJybDao;
import com.zssi.framework.app.process.service.ManualTaskXNService;
import com.zssi.framework.app.process.service.ProcessXNService;
import com.zssi.framework.app.process.service.TestProcessService;
import com.zssi.framework.app.process.support.file.FileCommonOperate;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;

/**
 * @author zhangyi
 */
@Controller
@RequestMapping("cps/processXN")
public class ProcessXNController extends BaseController{

	@Value(value = "${file.store.path}")
	private  String deployFilePath;
	
	@Autowired
	private ManualTaskXNService manualTaskService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TestProcessService testProcessService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private ProcessXNService processService;
	
	@Autowired
	private ProcessDiagramGeneratorExtend generatorExtend;

	@Autowired
	private BusinessXNDao businessDao;
	
	@Autowired
	private YshJybDao yshJybDao;
	
	@Autowired
	private YjyBgxxService bgxxService;
	
	@RequestMapping(value = "/deployProcessPage") 
	public String openDeployPage() {
//		return "/sys/SysUser/deployprocess";
		return "/cps/process/deployProcess";
	}

	/**
	 * 打开所有运行中流程页面
	 * @return
	 */
	@RequestMapping(value = "/runningProcess")
	public String openRunningProcessPage() {
		return "/cps/process/runningProcess";
	}
	
	/**
	 * 打开历史流程页面
	 * @return
	 */
	@RequestMapping(value = "/historyProcess")
	public String openHistoryProcessPage() {
		return "/cps/process/historyProcess";
	}
	
	/**
	 * 打开当前用户参与的任务页面(已办任务)
	 * @return
	 */
	@RequestMapping(value = "/involvedProcess")
	public String openInvolvedProcessProcessPage() {
		return "/cps/process/involvedProcess";
	}
	
	/**
	 * 任务撤回
	 * @author duanpeijun
	 * @date 2016年2月1日
	 * @return
	 */
	@RequestMapping(value = "/rwchProcess")
	public String openRwchProcessProcessPage() {
		return "/cps/process/rwchProcess";
	}
	
	/**
	 * 驳回样品修改
	 * @author duanpeijun
	 * @date 2016年4月13日
	 * @return
	 */
	@RequestMapping(value = "/bhypxgProcess")
	public String openBhypxgProcessProcessPage() {
		return "/cps/process/bhypxgProcess";
	}
	
	/**
	 * 生成Word文档
	 * @author duanpeijundyView
	 * @date 2015年12月15日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ylbg")
	public ModelAndView hbWord(HttpServletRequest request,HttpServletResponse response,String bgbh){
		ModelAndView mav = new ModelAndView("/bggl/ylbg");
		List<Map<String, Object>> a = bgxxService.getBgzh(bgbh);
		if(a != null){
			int zhid=Integer.parseInt(a.get(0).get("id").toString());
			YjyBgzh bgzh = bgxxService.getbgzhById(zhid);
			String fm = bgzh.getFmdz();
			String sy = bgzh.getSydz();
			String fy = bgzh.getFydz();
			request.setAttribute("fm", fm);
			request.setAttribute("sy", sy);
			request.setAttribute("fy", fy);
		}
		return mav;
	}
	
	/**
	 * 打印页面
	 * @author duanpeijun
	 * @date 2015年12月15日
	 * @param request
	 * @param response
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value = "/dyView")
	public ModelAndView dyView(HttpServletRequest request,HttpServletResponse response,String bgbh){
		ModelAndView mav = new ModelAndView("/bggl/bzbg/dyView");
		mav.addObject("bgbh", bgbh);
		return mav;
	}
	
	/**
	 * 打开我的流程页面
	 * @return
	 */
	@RequestMapping(value = "/myProcess")
	public String openMyProcessPage() {
		return "/cps/process/myProcess";
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
	
	@RequestMapping(value = "/showProcessOption/{businessKey}")
	public ModelAndView showProcessInfo(@PathVariable String businessKey) {
		ModelAndView modelAndView = new ModelAndView("/cps/process/showProcessOption");
		//查询对应业务数据传至处理页面
		if(StringUtils.hasText(businessKey)) {
			modelAndView.addObject("businessKey", businessKey);
			Map<String, Object> mapBusi = businessDao.getTestProcess(businessKey);
			modelAndView.addObject("mapBusi", mapBusi);
		}		
		return modelAndView;
	}
	
	
	
	/**
	 * 部署流程定义文件,根据后缀名自动调用不同的API部署
	 */
	@RequestMapping(value = "/deployProcess", method = RequestMethod.POST)
	@ResponseBody
	public String deployProcess(@RequestParam("attachMentFile") MultipartFile multipartFile) throws FileNotFoundException {
		
		if (multipartFile != null && multipartFile.getSize() != 0) {
			//开始上传附件,并保存上传成功后完整的路径
			FileCommonOperate fileCommonOperate = new FileCommonOperate();
			try {
				String fileName = fileCommonOperate.uploadFile(multipartFile.getInputStream(), deployFilePath, multipartFile.getOriginalFilename());
				InputStream fileInputStream = multipartFile.getInputStream();
				String extension = FilenameUtils.getExtension(fileName);
			    if (extension.equals("zip") || extension.equals("bar")) {
			          ZipInputStream zip = new ZipInputStream(fileInputStream); 
			          repositoryService.createDeployment().addZipInputStream(zip).deploy();
			    } else {
			          repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
			     }			
			} catch (IOException e) {
				e.printStackTrace();
				
			}			
		}
		return "{success:true}";
	}
	
	/**
	 * 取得系统中已经部署过的流程,与ACT_RE_PROCDEF中数据一致
	 */
	@RequestMapping(value = "/getDeployProcessList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getDeployProcessList(Integer start, Integer limit) {
		
		return processService.getDeployProcessList(start, limit);
	}
	
	  /**
	   * 通过流程定义ID读取资源
	   *
	   * @param processDefinitionId 流程定义
	   * @param resourceType 资源类型(xml|image)
	   * @throws Exception
	   */
	  @RequestMapping(value = "/resource/read")
	  public void loadByDeployment(@RequestParam("processDefinitionId") String processDefinitionId, @RequestParam("resourceType") String resourceType,
	                               HttpServletResponse response) throws Exception {
	    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
	    String resourceName = "";
	    if (resourceType.equals("image")) {
	      resourceName = processDefinition.getDiagramResourceName();
	    } else if (resourceType.equals("xml")) {
	      resourceName = processDefinition.getResourceName();
	    }
	    InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
	    byte[] b = new byte[1024];
	    int len = -1;
	    while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
	      response.getOutputStream().write(b, 0, len);
	    }
	  }
	  
	/**
	 * 取得运行中流程列表
	 */
	@RequestMapping(value = "/runningProcess/list", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getRunningProcessList(Integer start, Integer limit, String ypbh, String ypmc) {
		return processService.getRunningProcessList(start, limit, ypbh, ypmc);
	}


	/**
	 * 根据流程实例ID挂起一个流程实例
	 */
	@RequestMapping(value = "/suspendProcessInst", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData suspendProcessInst(String processInstanceId) {
		processService.suspendProcessInst(processInstanceId);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 根据流程实例ID激活一个流程实例
	 */
	@RequestMapping(value = "/activateProcessInst", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData activateProcessInst(String processInstanceId) {
		processService.activateProcessInst(processInstanceId);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 根据流程定义ID激活流程,激活的同时把该流程下已经启动的流程实例也全部激活
	 */
	@RequestMapping(value = "/activateProcessDefinition", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData activateProcessDefinition(String processDefinitionId) {
		processService.activateProcessDefinition(processDefinitionId);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 根据流程定义ID挂起流程,挂起的同时把该流程下已经启动的流程实例也全部挂起
	 */
	@RequestMapping(value = "/suspendProcessDefinition", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData suspendProcessDefinition(String processDefinitionId) {
		processService.suspendProcessDefinition(processDefinitionId);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 查询当前用户已经处理过的流程
	 */
	@RequestMapping(value = "/involvedProcess/list", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getInvolvedProcess(Integer start, Integer limit, String ypbh, String ypmc,String rolekind) {
		return processService.getInvolvedProcess(start, limit, ypbh, ypmc,rolekind);
	}
	
	/**
	 * 任务撤回
	 * @author duanpeijun
	 * @date 2016年2月1日
	 */
	@RequestMapping(value = "/rwchProcess/list", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getRwch(Integer start, Integer limit, String ypbh, String ypmc,String rolekind) {
		return processService.getRwch(start, limit, ypbh, ypmc,rolekind);
	}
	
	/**
	 * 驳回样品修改
	 * @author duanpeijun
	 * @date 2016年4月13日
	 */
	@RequestMapping(value = "/bhypxgProcess/list", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getBhypxg(Integer start, Integer limit, String ypbh, String ypmc,String rolekind) {
		return processService.getBhypxg(start, limit, ypbh, ypmc,rolekind);
	}
	
	/**
	 * 删除一个正在运行的流程实例
	 * @param processInstanceId 流程实例ID
	 * @param deleteReason 删除原因
	 * @return
	 */
	@RequestMapping(value = "/forceOverProcess", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData forceOverProcess(String processInstanceId, String deleteReason,String ypbh) {
		processService.forceOverProcess(processInstanceId, deleteReason,ypbh);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	
	/**
	 * 取得已经运行结束的流程
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/historyProcess/list", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getHistoryProcessList(Integer start, Integer limit, String ypbh, String yplx) {
		return processService.getHistoryProcessList(start, limit, ypbh, yplx);
	}
	
	/**
	 * 显示运行中流程图,正在运行的环节高亮显示
	 * @param processDefinitionId
	 * @param processInstanceId
	 */
	@RequestMapping(value = "/showProcessImage")
	public void showProcessImage(String processInstanceId, HttpServletResponse resp) {
        try {
//			InputStream inputStream = processService.showProcessImage(processInstanceId);
        	InputStream inputStream = generatorExtend.generateDiagram(processInstanceId);
			 if (inputStream != null) {
		            resp.setContentType("image/png");  
		            OutputStream out = resp.getOutputStream();  
		            try {  
		                byte[] bs = new byte[1024];  
		                int n = 0;  
		                while ((n = inputStream.read(bs)) != -1) {
		                    out.write(bs, 0, n);  
		                }  
		                out.flush();  
		            } catch (Exception ex) {  
		                ex.printStackTrace();  
		            } finally {  
		            	inputStream.close();  
		                out.close();  
		            }  
		        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	/**
	 * 显示历史流程图
	 * @param processInstanceId
	 * @param resp
	 */
	@RequestMapping(value = "/showHistoryProcessImage")
	public void showHistoryProcessImage(String processInstanceId, HttpServletResponse resp) {
        try {
//			InputStream inputStream =processService.showHistoryProcessImage(processInstanceId);
        	InputStream inputStream = generatorExtend.generateHistoryDiagram(processInstanceId);
			 if (inputStream != null) {  
		            resp.setContentType("image/png");  
		            OutputStream out = resp.getOutputStream();  
		            try {  
		                byte[] bs = new byte[1024];  
		                int n = 0;  
		                while ((n = inputStream.read(bs)) != -1) {  
		                    out.write(bs, 0, n);  
		                }  
		                out.flush();  
		            } catch (Exception ex) {  
		                ex.printStackTrace();  
		            } finally {  
		            	inputStream.close();  
		                out.close();  
		            }  
		        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	/**
	 * 分页查询当前用户发起的流程信息
	 * @param start
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/myProcess/list", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Map<String, Object>> getMyProcess(Integer start, Integer limit, String ypbh, String ypmc) {
		return processService.getMyProcess(start, limit, ypbh, ypmc);
	}
	
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
	
}
