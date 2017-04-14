package com.zssi.framework.app.process.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.likegene.framework.core.BaseController;
import com.zssi.framework.app.mass.service.MassInfoService;
import com.zssi.framework.app.process.service.TestProcessService;
import com.zssi.framework.app.test.service.TestProcessBO;
import com.zssi.framework.app.tjgl.service.YpcxService;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.wxpt.service.WglXgxxService;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;


@Controller
@RequestMapping(value="/cps/deal")
public class TestProcessController extends BaseController {
	@Autowired
	private TestProcessService testProcessService;
	
	@Autowired
	private TestProcessBO testProcessBO;
	@Autowired
	WglXgxxService wglXgxxService;
	@Autowired
	private MassInfoService massInfoService;
	@Autowired
	private YypYpxxService yypYpxxService;
	
	
	/**
	 * 技术中心审批环节逻辑
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealJSZXSPAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealJSZJAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname) {
		try {
			testProcessService.dealJSZXSPAct(taskId, lineVariable, value, businessKey, optionContent,tname);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 业务前台登记修改处理阶段
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月7日 上午10:46:47 
	 * @param taskId
	 * @param lineVariable
	 * @param value
	 * @param businessKey
	 * @param otherOption
	 * @param optionContent
	 * @param creditSumW
	 * @param creditRate
	 * @param creditYear
	 * @param signData
	 * @param writeData
	 * @param tname
	 * @param jyksbh
	 * @return
	 */
	 
	@RequestMapping(value = "/dealYWQTDJXGAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealYWQTDJXGAct(Integer id) {
		String result = testProcessService.dealYWQTDJXGAct(id);
		if("1".equalsIgnoreCase(result)){
			return ResponseData.SUCCESS_NO_DATA;
		}else{
			return ResponseData.FAILED_NO_TASK;
		}
	}
	
	/**
	 * 检验科室主任任务分配（批量分配）
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealPLKSZRFPRWAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealPLKSZRFPRWAct(String[] taskIds, String lineVariable, String value, String[] businessKeys,
			HttpServletRequest request,HttpServletResponse response,
			String optionContent,String tname,String jyry) {
		testProcessService.dealPLKSZRFPRWAct(taskIds, lineVariable, value, businessKeys, optionContent,tname,jyry);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 检验科室主任任务分配
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealKSZRFPRWAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealKSZRFPRWAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,HttpServletRequest request,HttpServletResponse response,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname,String jyry) {
		testProcessService.dealKSZRFPRWAct(taskId, lineVariable, value, businessKey, optionContent,tname,jyry);	
		List<Map<String, Object>> toUserlist=testProcessService.getopenId(jyry);
		String ypbh=request.getParameter("ypbh");
		String ypmc=request.getParameter("ypmc");
		List<Map<String, Object>> bgbhlist=wglXgxxService.getbgbh(ypbh);
		String bgbh= bgbhlist.get(0).get("bgbh").toString();
		String content= "["+bgbh+"]"+"["+ypmc+"]"+"检验任务需要编制，请注意查看！";
		String msgtype="text";
		if (toUserlist.size()!=0) {
			for (int i = 0; i < toUserlist.size(); i++) {
				if(toUserlist.get(i).get("wxh") != null){
					String toUser= toUserlist.get(i).get("wxh").toString();
					ResponseData  res = massInfoService.massPreviewrwfp(msgtype,toUser,content);
//					System.out.println("@@@@@@@@@@@+"+toUser);
				}
		}
		}
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 主检验科室检验人员操作
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealYPZJAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealYPZJAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,HttpServletRequest request,HttpServletResponse response,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname,String jyshry) {
		testProcessService.dealYPZJAct(taskId, lineVariable, value, businessKey, optionContent,tname,jyshry);	
		List<Map<String, Object>> toUserlist=testProcessService.getopenIdjyshry(jyshry);
		String ypbh=request.getParameter("ypbh");
		String ypmc=request.getParameter("ypmc");
		List<Map<String, Object>> bgbhlist=wglXgxxService.getbgbh(ypbh);
		String bgbh= bgbhlist.get(0).get("bgbh").toString();
		String content= "["+bgbh+"]"+"["+ypmc+"]"+"检验任务需要审核，请注意查看！";
		String msgtype="text";
		if (toUserlist.size()!=0) {
			for (int i = 0; i < toUserlist.size(); i++) {
				if(toUserlist.get(i).get("wxh") != null){
					String toUser= toUserlist.get(i).get("wxh").toString();
					ResponseData  res = massInfoService.massPreviewrwfp(msgtype,toUser,content);
//					System.out.println("@@@@@@@@@@@@@"+toUser);
				}
		}
		}
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 主检科室审核：不通过（批量不通过）
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (0:不通过)
	 * @return
	 */
	@RequestMapping(value = "/dealPLYZZJSHAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealPLYZZJSHAct(String[] taskIds, String lineVariable, String value, String[] businessKeys,
			HttpServletRequest request,HttpServletResponse response,
			String optionContent,String tname,String pzr) {
		testProcessService.dealPLYZZJSHAct(taskIds, lineVariable, value, businessKeys, optionContent,tname,pzr);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 主检科室审核环节逻辑
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealYZZJSHAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealYZZJSHAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,HttpServletRequest request,HttpServletResponse response,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname,String ypbh,String pzr) {
		try {
			testProcessService.dealYZZJSHAct(taskId, lineVariable, value, businessKey, optionContent,tname,pzr);
			String ypmc=request.getParameter("ypmc");
			List<Map<String, Object>> bgbhlist=wglXgxxService.getbgbh(ypbh);
			String bgbh= bgbhlist.get(0).get("bgbh").toString();
			List<Map<String, Object>>  jyksList= yypYpxxService.getjyks(ypbh);
			String jyks= jyksList.get(0).get("jyks").toString();
			List<Map<String, Object>> toUserlist = testProcessService
					.getopenIdjyks(jyks);
			String content= "["+bgbh+"]"+"["+ypmc+"]"+"检验任务需要批准，请注意查看！";
			String msgtype = "text";
			if (toUserlist.size() != 0) {
				for (int i = 0; i < toUserlist.size(); i++) {
					if(toUserlist.get(i).get("wxh") != null){
						String toUser = toUserlist.get(i).get("wxh").toString();
						ResponseData res = massInfoService.massPreviewrwfp(msgtype,toUser, content);
					}
				}
			}
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 技术中心批准环节逻辑
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealJSZXPZAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealJSZXPZAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname) {
		try {
			testProcessService.dealJSZXPZAct(taskId, lineVariable, value, businessKey, optionContent,tname);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 业务科室接收环节逻辑
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealYWKSJSAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealYWKSJSAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname,String jyksbh) {
		try {
			testProcessService.dealYWKSJSAct(taskId, lineVariable, value, businessKey, optionContent,tname,jyksbh);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 技术中心解锁环节
	 * @param taskId 工作项任务ID
	 * @param lineVariable 当前环节下一连线设置变量
	 * @param value 连线变量值 (1:同意  0:不同意)
	 * @return
	 */
	@RequestMapping(value = "/dealJSZXJSAct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealJSZXJSAct(String taskId, String lineVariable, String value, String businessKey, String otherOption,
			String optionContent, BigDecimal creditSumW, String creditRate, Integer creditYear, String signData,String writeData,String tname,String jyksbh) {
		try {
			testProcessService.dealJSZXJSAct(taskId, lineVariable, value, businessKey, optionContent,tname,jyksbh);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 页面解锁功能
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月28日 下午2:08:56 
	 * @param id 样品id
	 * @return
	 */
	@RequestMapping(value = "/dealWebJs", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealWebJs(Integer id) {
		String result = testProcessService.dealWebJs(id);
		if("1".equalsIgnoreCase(result)){
			return ResponseData.SUCCESS_NO_DATA;
		}else{
			return ResponseData.FAILED_NO_TASK;
		}
	}
	
	/**
	 * 页面撤回功能
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月28日 下午2:08:56 
	 * @param id 样品id
	 * @return
	 */
	@RequestMapping(value = "/dealWebCh", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData dealWebCh(Integer id) {
		String result = testProcessService.dealWebCh(id);
		if("1".equalsIgnoreCase(result)){
			return ResponseData.SUCCESS_NO_DATA;
		}else{
			return ResponseData.FAILED_NO_TASK;
		}
	}
	
}
