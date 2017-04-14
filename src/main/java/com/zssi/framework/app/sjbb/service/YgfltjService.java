package com.zssi.framework.app.sjbb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.sjbb.dao.YgfltjDao;
import com.zssi.framework.app.util.ExportExcelUtil;

//员工福利统计service类
//liusong 2015-12-30
@Service
public class YgfltjService extends BaseBO<YgfltjDao> {
	
	@Autowired
	private YgfltjDao ygfltjDao;

	/**
	 * 获取下拉框查询福利类型
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return ygfltjDao.getDicByLx(zdzl);
	}
	
	/**
	 * 查询收费人
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getSfr() {
		return ygfltjDao.getSfr();
	}
	
	/**
	 * 获取下拉框查询科室名称
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getKsmc() {
		return ygfltjDao.getKsmc();
	}
	
	/**
	 * 查询员工福利总表
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getFltj() {
		return ygfltjDao.getFltj();
	}
	
	/**
	 * 查询员工福利汇总表
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getFlhz(String ksmc,String ssyf) {
		return ygfltjDao.getFlhz(ksmc,ssyf);
	}
	
	/**
	 * 科室收入统计
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getKssrtj(String srfl,String cxsjstr,String cxsjend) {
		return ygfltjDao.getKssrtj(srfl,cxsjstr,cxsjend);
	}
	
	/**
	 * 报告收费记录查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBgsfjl(String srfl,String sfr,String cxsjstr,String cxsjend,String jyks,String ywks) {
		return ygfltjDao.getBgsfjl(srfl,sfr,cxsjstr,cxsjend,jyks,ywks);
	}
	
	/**
	 * 协议收费记录查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getXysfjl(String sfr,String cxsjstr,String cxsjend,String jyks,String ywks) {
		return ygfltjDao.getXysfjl(sfr,cxsjstr,cxsjend,jyks,ywks);
	}
	
	/**
	 * 协议收费记录查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getGlsfjl(String sfr,String srfl,String cxsjstr,String cxsjend,String glbm) {
		return ygfltjDao.getGlsfjl(sfr,srfl,cxsjstr,cxsjend,glbm);
	}
	
	/**
	 * 查看成本明细页面
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getYgflmx(String ksmccx,String ssyfcx){
		return ygfltjDao.getYgflmx(ksmccx, ssyfcx);
	}
	
	/**
	 * 检验科室报告收费传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jyksbgsfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.jyksbgsfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 检验科室协议收费传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> ywksxysfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.ywksxysfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 业务科室报告收费传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> ywksbgsfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.ywksbgsfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 业务科室协议收费传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jyksxysfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.jyksxysfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 检验科室内委收费明细查看
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> nwglmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.nwglmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 技术中心内委收费明细查看
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jszxnwmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.jszxnwmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 技术中心报告收费传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jszxbgsfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.jszxbgsfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 技术中心协议收费传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jszxxysfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.jszxxysfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	/**
	 * 管理部门收费明细传参查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> glbmsfmx(String ksmccx,String cxsjstr,String cxsjend){
		return ygfltjDao.glbmsfmx(ksmccx,cxsjstr,cxsjend);
	}
	
	
	/**
	 * exl表格导出
	 * @author liusong
	 * @date 2015-11-17
	 * @return
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String srfl,String cxsjstr,String cxsjend) throws Exception {
		if(srfl!=null){
			srfl=java.net.URLDecoder.decode(srfl,"UTF-8");
		}
		List<Map<String,Object>> list=ygfltjDao.getKssrtj(srfl,cxsjstr,cxsjend);
		String[] header=new String[]{"科室名称","主检应收款","内委应收款","主检实到款","内委实到款","技术服务应收款","技术服务实到款","管理服务收入"};
		String[] keys=new String[]{"BMMC","JYSFYSK","NWYSK","JYSFYSF","NWYSF","JSFWYSK","JSFWYSF","GLBMSF"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

	/**
	 * 工资薪金汇总导出Excle
	 * @author wangyong
	 * @date 2016年1月26日
	 * @param ksmccx
	 * @param ssyfcx
	 * @throws Exception 
	 */
	@Transactional
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String ksmc,String ssyf) throws Exception{
		List<Map<String,Object>> list=ygfltjDao.getFlhz(ksmc, ssyf);
		String[] header=new String[]{"科室名称","所属月份","基本工资","岗位绩效工资","积分绩效工资","业务绩效工资","社会保险费","公积金","交通费","通讯费","误餐费","其他","合计"};
		String[] keys=new String[]{"BMMC","SSYF","GZ","GWJXGZ","JFJXGZ","DBJ","SHBYF","GJJ","JTFF","TXF","WCF","QTFL","HJ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 员工福利明细导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportYgflmx(HttpServletRequest request,HttpServletResponse response,String ksmc,String ssyf) throws Exception{
		if(ksmc!=null){
			ksmc=java.net.URLDecoder.decode(ksmc,"UTF-8");
		}
		List<Map<String,Object>> list=ygfltjDao.getYgflmx(ksmc, ssyf);
		String[] header=new String[]{"科目","摘要","金额"};
		String[] keys=new String[]{"FLMC","FLXQ","JE"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 科室收入报告收费明细导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportKssrmx1(HttpServletRequest request,HttpServletResponse response,String ksmc,String cxsjstr,
			String cxsjend,String px) throws Exception{
		if(ksmc!=null){
			ksmc=java.net.URLDecoder.decode(ksmc,"UTF-8");
		}
		List<Map<String,Object>> list = null;
		String[] header=null;
		String[] keys=null;
		if (px.equals("1")) {
			list=ygfltjDao.jyksbgsfmx(ksmc,cxsjstr,cxsjend);
			header=new String[]{"检验报告编号","样品名称","检验费用","收费金额","收费时间","检验类别","委托单位","编制人","审核人"};
			keys=new String[]{"BGBH","YPMC","JYFY","YSFJE","JYJSRQ","JYLX","WTDW","XM","BSDX"};
		}else if (px.equals("3")) {
			list=ygfltjDao.ywksbgsfmx(ksmc, cxsjstr, cxsjend);
			header=new String[]{"检验报告编号","样品名称","检验费用","收费金额","收费时间","检验类别","委托单位","编制人","审核人"};
			keys=new String[]{"BGBH","YPMC","JYFY","YSFJE","JYJSRQ","JYLX","WTDW","XM","BSDX"};
		}else if (px.equals("5")) {
			list=ygfltjDao.jszxbgsfmx(ksmc,cxsjstr,cxsjend);
			header=new String[]{"检验报告编号","样品名称","检验科室","检验费用","收费金额","收费时间","检验类别","委托单位","编制人","审核人"};
			keys=new String[]{"BGBH","YPMC","BMMC","JYFY","YSFJE","JYJSRQ","JYLX","WTDW","XM","BSDX"};
		}
//		String[] header=new String[]{"检验报告编号","样品名称","检验费用","收费金额","收费时间","检验类别","受检单位","编制人","审核人"};
//		String[] keys=new String[]{"BGBH","YPMC","JYFY","YSFJE","JYJSRQ","JYLX","SJDW","XM","BSDX"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 科室收入协议收费明细导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportKssrmx2(HttpServletRequest request,HttpServletResponse response,String ksmc,String cxsjstr,
			String cxsjend,String px) throws Exception{
		if(ksmc!=null){
			ksmc=java.net.URLDecoder.decode(ksmc,"UTF-8");
		}
		List<Map<String,Object>> list = null;
		String[] header=null;
		String[] keys=null;
		if (px.equals("1")) {
			list=ygfltjDao.jyksxysfmx(ksmc, cxsjstr, cxsjend);
			header=new String[]{"协议编号","客户名称","协议金额","收费金额","收费时间"};
			keys=new String[]{"XYBH","KHMC","XYJE","YSFJE","SFRQ"};
		}else if (px.equals("3")) {
			list=ygfltjDao.ywksxysfmx(ksmc, cxsjstr, cxsjend);
			header=new String[]{"协议编号","客户名称","协议金额","收费金额","收费时间"};
			keys=new String[]{"XYBH","KHMC","XYJE","YSFJE","SFRQ"};
		}else if (px.equals("5")) {
			list=ygfltjDao.jszxxysfmx(ksmc, cxsjstr, cxsjend);
			header=new String[]{"协议编号","检验科室","客户名称","协议金额","收费金额","收费时间"};
			keys=new String[]{"XYBH","BMMC","KHMC","XYJE","YSFJE","SFRQ"};
		}
//		String[] header=new String[]{"协议编号","客户名称","协议金额","收费金额","收费时间"};
//		String[] keys=new String[]{"XYBH","KHMC","XYJE","YSFJE","SFRQ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 科室收入协议收费明细导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportKssrmx3(HttpServletRequest request,HttpServletResponse response,String ksmc,String cxsjstr, String cxsjend) throws Exception{
		if(ksmc!=null){
			ksmc=java.net.URLDecoder.decode(ksmc,"UTF-8");
		}
		List<Map<String,Object>> list=ygfltjDao.glbmsfmx(ksmc, cxsjstr, cxsjend);
		String[] header=new String[]{"部门名称","金额","收费时间","发票号","收费项目","备注"};
		String[] keys=new String[]{"BMMC","SFJE","SFRQ","FPHM","SRFL","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 科室收入内委明细导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param px 
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportKssrmx4(HttpServletRequest request,HttpServletResponse response,String ksmccx,String cxsjstr, String cxsjend, String px) throws Exception{
		if(ksmccx!=null){
			ksmccx=java.net.URLDecoder.decode(ksmccx,"UTF-8");
		}
		List<Map<String,Object>> list = null;
		String[] header=null;
		String[] keys=null;
		if(px.equals("1")){
			 list=ygfltjDao.nwglmx(ksmccx, cxsjstr, cxsjend);
			 header=new String[]{"检验报告编号","样品名称","检验项目","检验费用(元)","委托部门","委托时间","经办人","接收人"};
			 keys=new String[]{"BGBH","YPMC","JYXM","JYFY","WTBM","WTRQ","JBR","JSR"};
		}else if(px.equals("5")){
			 list=ygfltjDao.jszxnwmx(ksmccx, cxsjstr, cxsjend);
			 header=new String[]{"检验报告编号","样品名称","检验项目","检验费用(元)","委托部门","委托时间","承检部门","经办人","接收人"};
			 keys=new String[]{"BGBH","YPMC","JYXM","JYFY","WTBM","WTRQ","CJBM","JBR","JSR"};
		}
		 
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 报告收费记录导出Excle
	 * @author wangyong
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportBgsfjl(HttpServletRequest request,HttpServletResponse response,String srfl,String sfr,String cxsjstr,String cxsjend,String jyks,String ywks) throws Exception{
		List<Map<String,Object>> list=ygfltjDao.getBgsfjl(srfl,sfr,cxsjstr,cxsjend,jyks,ywks);
		String[] header=new String[]{"报告编号","样品名称","检验科室","业务科室","检验费用（元）","剩缴金额（元）","已收费金额（元）","本次实收（元）","票据号码","收入分类","收费人","收费时间"};
		String[] keys=new String[]{"BGBH","YPMC","KS_ID","SSYWKS","JYFY","YSJE","YSFJE","BCSS","PJHM","SRFL","SFR","JYJSRQ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
	/**
	 * 协议收费记录导出Excle
	 * @author LIUSONG
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportXysfjl(HttpServletRequest request,HttpServletResponse response,String sfr,String cxsjstr,String cxsjend,String jyks,String ywks) throws Exception{
		List<Map<String,Object>> list=ygfltjDao.getXysfjl(sfr,cxsjstr,cxsjend,jyks,ywks);
		String[] header=new String[]{"协议编号","客户名称","检验科室","业务科室","协议金额（元）","剩缴金额（元）","已收金额（元）","本次实收（元）","票据号码","收费人","收费时间"};
		String[] keys=new String[]{"XYBH","KHMC","JYKS_ID","YWKS_ID","XYJE","YSJE","YSFJE","BCSS","PJHM","SFR","SFRQ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	/**
	 * 管理收费记录导出Excle
	 * @author LIUSONG
	 * @date 2016年1月27日
	 * @param request
	 * @param response
	 * @param ksmc
	 * @param ssyf
	 * @throws Exception
	 */
	@Transactional
	public void exportGlbmjl(HttpServletRequest request,HttpServletResponse response,String sfr,String srfl,String cxsjstr,String cxsjend,String glbm) throws Exception{
		List<Map<String,Object>> list=ygfltjDao.getGlsfjl(sfr,srfl,cxsjstr,cxsjend,glbm);
		String[] header=new String[]{"部门名称","发票号","收入分类","收费金额","票据号码","收费项目名称","收费时间","收费人"};
		String[] keys=new String[]{"BMBH","FPHM","SRFL","SFJE","PJHM","SFXMMC","SFRQ","SFR"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}
	
}
