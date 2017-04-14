package com.zssi.framework.app.jygl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.bhsz.dao.YbgBhszDao;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YbgYqjlDao;
import com.zssi.framework.app.jygl.dao.YjyBgmbDao;
import com.zssi.framework.app.jygl.dao.YjyBgxxDao;
import com.zssi.framework.app.jygl.dao.YjyBgzhDao;
import com.zssi.framework.app.jygl.dao.YjyClyyDao;
import com.zssi.framework.app.jygl.dao.YjyRztbDao;
import com.zssi.framework.app.jygl.dao.YjyYdmbDao;
import com.zssi.framework.app.jygl.model.YbgYqjl;
import com.zssi.framework.app.jygl.model.YjyBgmb;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.jygl.model.YjyBgzh;
import com.zssi.framework.app.jygl.model.YjyRztb;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.ypgl.dao.YypYpxxDao;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypYpxxService;
/**
 * 检验报告信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Service
public class YjyBgxxService extends BaseBO<YjyBgxx>{
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	@Autowired
	private YjyBgxxDao dao;
	@Autowired
	private YjyBgmbDao bgmbdao;
	@Autowired
	private YjyBgzhDao bgzhdao;
	@Autowired
	private YjyBgzhService bgzhservice;
	@Autowired
	private YjyRztbDao rztbdao;
	@Autowired
	private YypYpxxService ypxxservice;
	@Autowired
	private YjyYdmbDao ydmbdao;
	@Autowired
	private YbgYqjlDao yqDao;
	@Autowired
	private YypYpxxDao ypDao;
	@Autowired
	private YbgBhszDao bhszDao;
	@Autowired
	private YjyJyxxService  jyxxservice;
	@Autowired
	private YjyClyyDao clyydao;
	
	/**
	 * 后台：编制报告
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getBgbzList(Integer start,Integer limit,String canshu){
		return dao.getBgbzList(start, limit, canshu);
	}
	
	/**
	 * 报告信息
	 * @author duanpeijun
	 * @date 2015年12月3日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
    @Transactional
	public Pagination<Map<String, Object>> getBgxxList(Integer start,Integer limit,String ypbh,String ypmc,String yplx,
			String ypdj,String jylx,String szcs,String wtdw,String sjdw,String scdw,String jyks,String ywks,String djsj,String djsjStr,
			String djsjEnd,String gcmc,String sgdw,String gcsjdw,String jsdw1,String jldw,String jzdw,String wtlxr){
		return dao.getBgxxList(start, limit,ypbh,ypmc,yplx,ypdj,jylx,szcs,wtdw,sjdw,scdw,jyks,ywks,djsj,djsjStr,djsjEnd,gcmc,sgdw,gcsjdw,jsdw1,jldw,jzdw,wtlxr);
	}
	
	/**
	 * 报告解锁List
	 * @author duanpeijun
	 * @date 2015年12月22日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getBgjs(Integer start,Integer limit,String canshu){
		return dao.getBgjs(start, limit, canshu);
	}
	
	/**
	 * 报告延期
	 * @author duanpeijun
	 * @date 2016年1月5日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getBgyq(Integer start,Integer limit,String canshu){
		return dao.getBgyqList(start, limit, canshu);
	}
	
	/**
	 * 报告多次打印
	 * @author duanpeijun
	 * @date 2016年1月5日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getBgdy(Integer start,Integer limit,String canshu){
		return dao.getBgdyList(start, limit, canshu);
	}
	
	/**
	 * 报告打印
	 * @author duanpeijun
	 * @date 2016年2月19日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getBgdydan(Integer start,Integer limit,String canshu){
		return dao.getBgdydanList(start, limit, canshu);
	}
	
	/**
	 * 发放状态（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByFfzt(String zdzl) {
		return dao.getDicByFfzt(zdzl);
	}
	
	/**
	 * 常用检验结论
	 * @author duanpeijun
	 * @date 2016年1月25日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getClyy(String type,String num,String xm){
		return clyydao.getClyyList(type,num,xm);
	}
	
	/**
	 * 编制报告页面，展示样品状态
	 * @author duanpeijun
	 * @date 2015年12月21日
	 * @return
	 */
	public List<Map<String, Object>> getYpzyzt(String zdzl) {
		return ypDao.getYpzyzt(zdzl);
	}
	
	/**
	 * 根据ID查询报告信息的数据
	 * @author duanpeijun
	 * @date 2015年12月24日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getBgxx(Integer id){
		return dao.getBgxx(id);
	}
	
	/**
	 * 查询所有的报告信息
	 * @author duanpeijun
	 * @date 2016年1月13日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBgList(String fenye,String bgbh,String bzr,String wtdw,String sjdw,
					String ypmc,String jyrq,String jylx,String jyyj){
		return dao.getBg(fenye,bgbh,bzr, wtdw,sjdw,ypmc,jyrq,jylx,jyyj);
	}
	
	/**
	 * 根据ID获取该条报告信息的实体类
	 * @author duanpeijun
	 * @date 2015年12月3日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyBgxx getbgxxById(Integer id) {
		YjyBgxx entity = dao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YjyBgxx entity,String id){
		entity.setId(Integer.parseInt(id));
		dao.update(entity);
	}
	
	/**
	 * 删除
	 * @author wangyong 
	 * @date 2015年9月23日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			dao.delete(ids[i]);
		}
	}
	/**
	 * 微信平台报告信息查询
	 * @author panweichi
	 * @date 2015年12月21日
	 */
	@Transactional
	public List<Map<String, Object>> getBg(){
		return dao.getList(null);
	}
	
	/**
	 * 获取下拉框查询
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return dao.getDicByLx(zdzl);
	}
	/**
	 * 查询检验科室下拉框
	 * @author liusong
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getJyks(String bmbh) {
		return dao.getJyks(bmbh);
	}
	
	public List<Map<String, Object>> getKsmc() {
		return dao.getKsmc();
	}
	
	public List<Map<String, Object>> getCplx() {
		return dao.getCplx();
	}
	
	/**
	 * 查询检验科室下拉框
	 * @author liusong
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBm() {
		return dao.getBm();
	}
	
	/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 报告模版List
	 * @author duanpeijun
	 * @date 2015年11月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBgmb(String code){
		return bgmbdao.getBgmb(code);
	}
	
	/**
	 * 在选择报告模版时，查询该条模版的具体数据（根据ID获取）
	 * @author duanpeijun
	 * @date 2015年11月23日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyBgmb getbgmbList(String id){
		return bgmbdao.get(Integer.parseInt(id));
	}
	
	/**
	 * 点击编制报告进入报告模版页面，显示报告整合表的内容（根据ID获取）
	 * @author duanpeijun
	 * @date 2015年11月23日
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBgzh(String bgbh){
		return bgzhdao.getbgzh(bgbh);
	}
	
	/**
	 * 获取报告整合的所有数据（根据ID获取）
	 * @author duanpeijun
	 * @date 2015年11月23日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyBgzh getbgzhById(Integer id) {
		YjyBgzh entity = bgzhdao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
	/**
	 * 获取认证图标的所有数据（根据ID获取）
	 * @author duanpeijun
	 * @date 2015年11月23日
	 * @param id
	 * @return
	 */
	@Transactional
	public YjyRztb getrztbById(Integer id) {
		YjyRztb entity = rztbdao.get(id);
		if(entity!=null){
			return entity;
		}
		return null;
	}
	
	/**
	 * 根据样品信息的报告编号查询检验信息有无该条数据。（样品信息的报告编号和报告信息的报告编号是相同的）
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getbgxxList(String bgbh){
		return dao.getbgxxList(bgbh);
	}
	
	/**
	 * 二维码报告信息
	 * @author duanpeijun
	 * @date 2015年12月3日
	 * @param bgbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getewmbgxx(String bgbh){
		return dao.getbgxxewm(bgbh);
	}
	
	/**
	 * 查询报审对象字段的人员列表（根据"报告审核角色和本部门的人员列表"）
	 * @author duanpeijun
	 * @date 2015年12月3日
	 * @param bgbh
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getbsdx(String bmbh){
		return dao.getbsdx(bmbh);
	}
	
	/**
	 * 根据样品信息中的字号（例：DQ）去查出对应的字号分类（例：0）
	 * @author duanpeijun
	 * @date 2015年12月19日
	 * @param zh    字号
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getBhszList(String zh,String djlx){
		return bhszDao.getBhszList(zh,djlx);
	}
	
	/**
	 * 根据登记类型，字号，检验科室编号去查出模版。
	 * @author duanpeijun
	 * @date 2015年12月14日
	 * @param jyksbh    检验科室编号
	 * @param djlx      登记类型
	 * @param zh        字号
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getThreeId(String jyksbh,Integer mbfl,String zh){
		return ydmbdao.getThreeId(jyksbh, mbfl, zh);
	}
	
	/**
	 * 保存到报告信息表
	 * @author duanpeijun
	 * @date 2015年12月13日
	 * @param request
	 * @param rztbid
	 * @return
	 */
	@Transactional
	public String tijiao(HttpServletRequest request) {
		String str="";
		YjyBgxx bgxx = new YjyBgxx();
		String jyrq1 = request.getParameter("jyrq");
		bgxx.setJyrq(jyrq1);         //检验日期
//		if(!"".equals(jyrq1)){
//			try {
//					Date jyrq = sdf.parse(jyrq1);
//					bgxx.setJyrq(jyrq);            
//			} catch (ParseException e) {
//					e.printStackTrace();
//			}
//		}
		String bsdx = request.getParameter("bsdxtwo");    //报审对象
		bgxx.setBsdx(bsdx);
		String jyjl = request.getParameter("jyjl");    //检验结论
		bgxx.setJyjl(jyjl);
		String jyqksm = request.getParameter("jyqksm");  //检验情况说明
		if(!"".equals(jyqksm)){
			bgxx.setJyqksm(jyqksm);
		}
//		String jyjsrq1 = request.getParameter("jyjsrq");
//		try {
//			Date jyjsrq = sdf.parse(jyjsrq1);
//			bgxx.setJyjsrq(jyjsrq);            //检验结束日期
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		String[] rztbid = request.getParameterValues("rztbids");   //认证图标
		String rztbidStr = "";
		if(rztbid != null && !"".equals(rztbid)){
			for(int i=0;i<rztbid.length;i++){
				if(i<rztbid.length-1){
					rztbidStr=rztbidStr+rztbid[i]+",";
				}else{
					rztbidStr=rztbidStr+rztbid[i];
				}
			}
		}
		bgxx.setRzfs(rztbidStr);
		String dwmctp = request.getParameter("dw");    
		bgxx.setDwmctp(dwmctp);
		String pzz = request.getParameter("pzz");
		bgxx.setYzmctp(pzz);
		bgxx.setBz("0");        //备注(是否为特殊报告:0:否;1:是)
		String ypid = request.getParameter("ypid");
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(ypid));
		bgxx.setBgbh(ypxx.getBgbh());                  //报告编号
		bgxx.setBgmc(ypxx.getBgbh());                  //报告名称
		bgxx.setCydw(ypxx.getCydw());				   //抽样单位
		bgxx.setJyks(ypxx.getJyksbh());				   //检验科室编号
		bgxx.setYwks(ypxx.getYwksbh());                //业务科室编号
		String bgbh = ypxx.getBgbh();
		SysYh yh = AppUtil.getCurrentUser();
		bgxx.setBzr(String.valueOf(yh.getYhbh()));     //编制人
		bgxx.setDycs("0");
		bgxx.setBzfs(ypxx.getDjlx());		   //编制方式
		List<Map<String, Object>> a = dao.getbgxxList(bgbh);
		if(a.size() != 0){
			bgxx.setId(Integer.parseInt(a.get(0).get("id").toString()));
			bgxx.setSfjs(Integer.parseInt(a.get(0).get("sfjs").toString()));
			this.update(bgxx);
		}else{
			bgxx.setSfjs(0);
			this.save(bgxx);
		}
		/**************提交时，将FMID,SYID,FYID保存到报告整合表中*****************************/
		String fmid = request.getParameter("fmid");
		String syid = request.getParameter("syid");
		String fyid = request.getParameter("fyid");
		YjyBgzh bgzh = new YjyBgzh();
		bgzh.setBgbh(ypxx.getBgbh());   //报告编号
		YjyBgmb ab = this.getbgmbList(fmid);
		bgzh.setFmdz(ab.getSub());      //封面地址
		bgzh.setFmmc(ab.getMbmc());     //封面名称
		YjyBgmb b = this.getbgmbList(syid);
		bgzh.setSydz(b.getSub());       //首页地址
		bgzh.setSymc(b.getMbmc());      //首页名称
		YjyBgmb c = this.getbgmbList(fyid);
		bgzh.setFydz(c.getSub());       //附页地址
		bgzh.setFymc(c.getMbmc());      //附页名称
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if(d.size() != 0){
			bgzh.setId(Integer.parseInt(d.get(0).get("id").toString()));
			bgzhservice.update(bgzh);
		}else{
			bgzhservice.save(bgzh);
		}
		str="1";
		return str;
	}

	/**
	 * 报告延期
	 * @author liujiansen
	 * @date 2015年12月19日
	 * @param entity
	 */
	@Transactional
	public void saveYqjl(YbgYqjl entity) {
		List<Map<String,Object>> list=ypDao.getYp(entity.getBgbh());
		if(list.size()!=0){
			YypYpxx ypxx=ypDao.get(Integer.parseInt(list.get(0).get("id").toString()));
			ypxx.setWcqx(entity.getZxwcqx());
			ypDao.update(ypxx);
		}
		yqDao.save(entity);
	}

	/**
	 * 获取延期记录列表
	 * @author liujiansen
	 * @date 2015年12月19日
	 * @param start
	 * @param limit
	 * @param bgbh
	 * @return
	 */
	@Transactional
	public Pagination<Map<String, Object>> getYqjlList(Integer start,Integer limit, String bgbh) {
		return dao.getYqjlList(start, limit, bgbh);
	}

	/**
	 * 修改打印状态和次数
	 * @author liujiansen
	 * @date 2015年12月19日
	 * @param bgbh
	 */
	@Transactional
	public void updateDycs(String bgbh) {
		List<Map<String,Object>> list=dao.getbgxxewm(bgbh);
		if(list.size()!=0){
			YjyBgxx bgxx=dao.get(Integer.parseInt(list.get(0).get("id").toString()));
			int dycs=0;
			if(list.get(0).get("dycs")!=null&&!"".equals(list.get(0).get("dycs"))){
				dycs=Integer.parseInt(list.get(0).get("dycs").toString())+1;
			}else{
				dycs=1;
			}
			bgxx.setDyzt(1);
			bgxx.setDycs(dycs+"");
			dao.update(bgxx);
		}
	}
	
	/**
	 * 查出主检人的姓名
	 * @author duanpeijun
	 * @date 2016年4月7日
	 * @param key
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getZjr(String key){
		return dao.getZjr(key);
	}
	
	/**
	 * 批准或者接收时，查出审核人姓名。
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param key
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getShr(String key){
		return dao.getShr(key);
	}
	
	/**
	 * 接收时，查出批准人姓名。
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param key
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getPzr(String key){
		return dao.getPzr(key);
	}
	
	/**
	 * 批准时:根据审核人的姓名去查出其电子签名图片
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param shrxm
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getShrtp(String shrxm){
		return dao.getShrtp(shrxm);
	}
	
	/**
	 * 报告编制时，查询历史记录有无审核不通过
	 * @author duanpeijun
	 * @date 2016年5月3日
	 * @param key  样品ID
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getShzt(String key){
		return dao.getShzt(key);
	}
	
	/**
	 * 报告编制时，查询历史记录有无批准不通过
	 * @author duanpeijun
	 * @date 2016年5月3日
	 * @param key  样品ID
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getPzzt(String key){
		return dao.getPzzt(key);
	}
	
	/**
	 * 查询有无样品修改时间
	 * @author duanpeijun
	 * @date 2016年5月4日
	 * @param ypid
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> xgsjList(String bgbh){
		return dao.xgsjList(bgbh);
	}
	
	/**
	 * 特殊报告提交
	 * @author duanpeijun
	 * @date 2016年5月26日
	 * @param request
	 * @return
	 */
	@Transactional
	public String tsbgtijiao(HttpServletRequest request) {
		String str="";
		YjyBgxx bgxx = new YjyBgxx();
		String jyrq1 = request.getParameter("jyrq");
		bgxx.setJyrq(jyrq1);         //检验日期
		String bsdx = request.getParameter("bsdxtwo");    //报审对象
		bgxx.setBsdx(bsdx);
		String jyjl = request.getParameter("jyjl");    //检验结论
		bgxx.setJyjl(jyjl);
		String jyqksm = request.getParameter("jyqksm");  //检验情况说明
		if(!"".equals(jyqksm)){
			bgxx.setJyqksm(jyqksm);
		}
		String[] rztbid = request.getParameterValues("rztbids");   //认证图标
		String rztbidStr = "";
		if(rztbid != null && !"".equals(rztbid)){
			for(int i=0;i<rztbid.length;i++){
				if(i<rztbid.length-1){
					rztbidStr=rztbidStr+rztbid[i]+",";
				}else{
					rztbidStr=rztbidStr+rztbid[i];
				}
			}
		}
		bgxx.setRzfs(rztbidStr);
		String dwmctp = request.getParameter("dw");    
		bgxx.setDwmctp(dwmctp);
		String pzz = request.getParameter("pzz");
		bgxx.setYzmctp(pzz);
		bgxx.setBz("1");        //备注(是否为特殊报告:0:否;1:是)
		String ypid = request.getParameter("ypid");
		YypYpxx ypxx = ypxxservice.getYpxxById(Integer.parseInt(ypid));
		bgxx.setBgbh(ypxx.getBgbh());                  //报告编号
		bgxx.setBgmc(ypxx.getBgbh());                  //报告名称
		bgxx.setCydw(ypxx.getCydw());				   //抽样单位
		bgxx.setJyks(ypxx.getJyksbh());				   //检验科室编号
		bgxx.setYwks(ypxx.getYwksbh());                //业务科室编号
		String bgbh = bgxx.getBgbh();
		SysYh yh = AppUtil.getCurrentUser();
		bgxx.setBzr(String.valueOf(yh.getYhbh()));     //编制人
		bgxx.setDycs("0");
		bgxx.setBzfs(ypxx.getDjlx());		   //编制方式
		List<Map<String, Object>> a = dao.getbgxxList(bgbh);
		if(a.size() != 0){
			bgxx.setId(Integer.parseInt(a.get(0).get("id").toString()));
			bgxx.setSfjs(Integer.parseInt(a.get(0).get("sfjs").toString()));
			this.update(bgxx);
		}else{
			bgxx.setSfjs(0);
			this.save(bgxx);
		}
		/**************提交时，将FMID,SYID,FYID保存到报告整合表中*****************************/
		String fmid = request.getParameter("fmid");
		String syid = request.getParameter("syid");
		String fyid = request.getParameter("fyid");
		YjyBgzh bgzh = new YjyBgzh();
		bgzh.setBgbh(ypxx.getBgbh());   //报告编号
		YjyBgmb ab = this.getbgmbList(fmid);
		bgzh.setFmdz(ab.getSub());      //封面地址
		bgzh.setFmmc(ab.getMbmc());     //封面名称
		YjyBgmb b = this.getbgmbList(syid);
		bgzh.setSydz(b.getSub());       //首页地址
		bgzh.setSymc(b.getMbmc());      //首页名称
		YjyBgmb c = this.getbgmbList(fyid);
		bgzh.setFydz(c.getSub());       //附页地址
		bgzh.setFymc(c.getMbmc());      //附页名称
		List<Map<String, Object>> d = bgzhdao.getbgzh(bgbh);
		if(d.size() != 0){
			bgzh.setId(Integer.parseInt(d.get(0).get("id").toString()));
			bgzhservice.update(bgzh);
		}else{
			bgzhservice.save(bgzh);
		}
		str="1";
		return str;
	}

	/**
	 * 保存首页(一般)
	 * @author duanpeijun
	 * @date 2016年6月7日
	 * @param request
	 * @return
	 */
	@Transactional
	public String bcsy(HttpServletRequest request) {
		String str="";
		String bgbh = request.getParameter("bgbh");	//检验日期
		YjyBgxx bgxx = new YjyBgxx();
		bgxx.setBgbh(bgbh);
		bgxx.setBgmc(bgbh);
		String jyrq1 = request.getParameter("jyrq");	//检验日期
		bgxx.setJyrq(jyrq1);
		String jyjl = request.getParameter("jyjl");    //检验结论
		bgxx.setJyjl(jyjl);
		String jyqksm = request.getParameter("jyqksm");  //检验情况说明
		if(!"".equals(jyqksm)){
			bgxx.setJyqksm(jyqksm);
		}
		String[] rztbid = request.getParameterValues("rztbids");   //认证图标
		String rztbidStr = "";
		if(rztbid != null && !"".equals(rztbid)){
			for(int i=0;i<rztbid.length;i++){
				if(i<rztbid.length-1){
					rztbidStr=rztbidStr+rztbid[i]+",";
				}else{
					rztbidStr=rztbidStr+rztbid[i];
				}
			}
		}
		bgxx.setRzfs(rztbidStr);
		bgxx.setBz("0");            //备注(是否为特殊报告:0:否;1:是)
		List<Map<String, Object>> a = dao.getbgxxList(bgbh);
		if(a.size() != 0){
			bgxx.setId(Integer.parseInt(a.get(0).get("id").toString()));
			bgxx.setSfjs(Integer.parseInt(a.get(0).get("sfjs").toString()));
			this.update(bgxx);
		}else{
			bgxx.setSfjs(0);
			this.save(bgxx);
		}
		return str;
	}
	
	/**
	 * 保存首页(特殊)
	 * @author duanpeijun
	 * @date 2016年6月7日
	 * @param request
	 * @return
	 */
	@Transactional
	public String TSbcsy(HttpServletRequest request) {
		String str="";
		String bgbh = request.getParameter("bgbh");	//检验日期
		YjyBgxx bgxx = new YjyBgxx();
		bgxx.setBgbh(bgbh);
		bgxx.setBgmc(bgbh);
		String jyrq1 = request.getParameter("jyrq");	//检验日期
		bgxx.setJyrq(jyrq1);
		String jyjl = request.getParameter("jyjl");    //检验结论
		bgxx.setJyjl(jyjl);
		String jyqksm = request.getParameter("jyqksm");  //检验情况说明
		if(!"".equals(jyqksm)){
			bgxx.setJyqksm(jyqksm);
		}
		String[] rztbid = request.getParameterValues("rztbids");   //认证图标
		String rztbidStr = "";
		if(rztbid != null && !"".equals(rztbid)){
			for(int i=0;i<rztbid.length;i++){
				if(i<rztbid.length-1){
					rztbidStr=rztbidStr+rztbid[i]+",";
				}else{
					rztbidStr=rztbidStr+rztbid[i];
				}
			}
		}
		bgxx.setRzfs(rztbidStr);
		bgxx.setBz("1");            //备注(是否为特殊报告:0:否;1:是)
		List<Map<String, Object>> a = dao.getbgxxList(bgbh);
		if(a.size() != 0){
			bgxx.setId(Integer.parseInt(a.get(0).get("id").toString()));
			bgxx.setSfjs(Integer.parseInt(a.get(0).get("sfjs").toString()));
			this.update(bgxx);
		}else{
			bgxx.setSfjs(0);
			this.save(bgxx);
		}
		return str;
	}
}
