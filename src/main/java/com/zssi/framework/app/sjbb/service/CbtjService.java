package com.zssi.framework.app.sjbb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.cbgl.dao.YcwCbxxDao;
import com.zssi.framework.app.sjbb.dao.CbtjDao;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class CbtjService extends BaseBO<YcwCbxxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private CbtjDao dao;
	/**
	 * 后台:成本信息列表
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getCbtjList(String ksmc,String ksyf,String jsyf){
		return dao.getCbtjList(ksmc, ksyf,jsyf);
	}
	
	/**
	 * 查看成本明细页面
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getCbmx(String ksmccx,String ksyf,String jsyf){
		return dao.getCbmx(ksmccx,ksyf,jsyf);
	}
	
	/**
	 * 查询成本明细页面部门名称
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getBmmc(String ksmccx){
		return dao.getBmmc(ksmccx);
	}
	
	/**
	 * 成本统计导出Excle
	 * @author wangyong
	 * @date 2016年1月26日
	 * @param ksmccx
	 * @param ssyfcx
	 * @throws Exception 
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String ksmc,String ksyf,String jsyf) throws Exception{
		List<Map<String,Object>> CbtjList=dao.getCbtjExcel(ksmc, ksyf,jsyf);
		List<Map<String,Object>> CbtjBfbList=dao.getCbtjBfbExcel(ksmc, ksyf,jsyf);
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>>();
		for(int i=0;i<CbtjList.size();i++){
			Map<String,Object> CbtjMap = CbtjList.get(i);
			Map<String,Object> CbtjBfbMap = CbtjBfbList.get(i);
			list.add(CbtjMap);
			list.add(CbtjBfbMap);
		}
		String[] header=new String[]{"科室名称","工资薪金（占比）","差旅费（占比）","材料工器具（占比）","办公费（占比）","交通费（占比）","招待费（占比）","修缮检定（占比）","培训费（占比）","会议费（占比）","邮电费（占比）","文印费（占比）","水电费（占比）","物管费（占比）","租赁费（占比）","技术服务费（占比）","业务协作费（占比）","咨询费（占比）","劳务费（占比）","外委检验费（占比）","折旧费（占比）","公务用车费（占比）","其他（占比）","合计"};
		String[] keys=new String[]{"BMMC","GZXJ","CLF","CLGQJ","BGF","JTF","ZDF","XSJD","PXF","HYF","YD","WYF","SDF","WGF","ZLF","JF","YWXZF","ZXF","LWF","JYF","ZJF","GWYCF","QTFY","HJ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 成本统计明细导出Excle
	 * @author wangyong
	 * @date 2016年1月26日
	 * @param ksmccx
	 * @param ssyfcx
	 * @throws Exception 
	 */
	@Transactional
	public void exportCbtjmx(HttpServletRequest request,HttpServletResponse response,String ksmc,String ksyf,String jsyf) throws Exception{
		if(ksmc!=null){
			ksmc=java.net.URLDecoder.decode(ksmc,"UTF-8");
		}
		List<Map<String,Object>> list=dao.getCbmx(ksmc, ksyf,jsyf);
		String[] header=new String[]{"科目","凭证代码","摘要","金额"};
		String[] keys=new String[]{"FYLX","","FYXQ","JE"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
}
