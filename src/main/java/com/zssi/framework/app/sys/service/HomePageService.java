package com.zssi.framework.app.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zssi.framework.app.sys.dao.HomePageDao;
import com.zssi.framework.app.sys.model.SysYh;

/** 
 * @author:zhangyi 
 * @version 创建时间：2015年12月16日 上午10:34:02 
 * 系统主页service
 */
@Service
public class HomePageService {
	
	@Autowired
	private HomePageDao dao;

	/**
	 * 根据用户找出角色
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月17日 上午9:45:30 
	 * @param yh
	 * @return
	 */
	@Transactional
	public String getRoleByYh(SysYh yh) {
		List<Map<String,Object>> listrole = dao.getRoleByYh(yh);
		if(listrole.size()>0){
			return listrole.get(0).get("jsmc").toString();
		}
		return null;
	}

	/**
	 * 报告费用统计
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getBgsf(){
		return dao.getBgsf();
	}
	
	/**
	 * 业务科室收费统计
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getYwkssf(){
		return dao.getYwkssf();
	}
	
	/**
	 * 业务科室收费排行
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getYwkssfph(){
		return dao.getYwkssfph();
	}
	
	/**
	 * 工程技术中心主任查询标准过期提醒
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getBzgq(){
		return dao.getBzgq();
	}
	
	/**
	 * 科研项目进度查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getKyxm(){
		return dao.getKyxm();
	}
	
	/**
	 * 检测室排行查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
//	@Transactional
//	public List<Map<String,Object>> getJcs(String bm){
//		return dao.getJcs(bm);
//	}
	
	@Transactional
	public List<Map<String,Object>> getJcs(){
		return dao.getJcs();
	}
	
	/**
	 * 报告进度查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getBgjd(){
		return dao.getBgjd();
	}
	
	/**
	 * 设备情况查看
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getSbqk(){
		return dao.getSbqk();
	}
	
	/**
	 * 缴费情况查看
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getJfqk(){
		return dao.getJfqk();
	}
	
	/**
	 * 按月检验费用查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getJyfy(){
		return dao.getJyfy();
	}
	
	/**
	 * 按月其他费用查询
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getQtfy(){
		return dao.getQtfy();
	}
	
	/**
	 * 报告收费合计
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getxysfhj(){
		return dao.getxysfhj();
	}
	/**
	 * 其他收费合计
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	@Transactional
	public List<Map<String,Object>> getqtsfhj(){
		return dao.getqtsfhj();
	}
	
	/**
	 * 业务科室收费饼图
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYwksBt(){
		return dao.getYwksBt();
	}
	
	/**
	 * 当月新增客户量
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYxzkhl(){
		return dao.getYxzkhl();
	}
	
	/**
	 * 当月客户拜访量
	 * @author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getYkhbfl(){
		return dao.getYkhbfl();
	}
	
	/**
	 * 当月客户拜访量现有客户量@author liusong
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getXykhl(){
		return dao.getXykhl();
	}
	
	/**
	 * 年度总收费
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getNdzsf(){
		return dao.getNdzsf();
	}
//	成本费用
	public List<Map<String,Object>> getCbfy(){
		return dao.getCbfy();
	}
	
	/**
	 * 报告收费
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String,Object>> getBgzsf(){
		return dao.getBgzsf();
	}
	
	/**
	 * 报告总数
	 * @author liujiansen
	 * @date 2015年12月18日
	 * @return
	 */
	public int getBgzs(){
		return dao.getBgzs();
	}
	/**
	 * 档案总数
	 * @author liangkaidi
	 * @date 2015-12-25
	 * @return
	 */
	public int getDazs(){
		return dao.getDazs();
	}

	
/**
 * 单位收费
 * @author liangkaidi
 * @date 2015-12-28
 * @return
 */
	public List<Map<String, Object>> getDwsf() {
			return dao.getDwsf();
	}

	/**
	 * 工作量汇总
	 * @author liangkaidi
	 * @date 2015-12-28
	 * @return
	 */
	public int getGzlhz(){
		return dao.getGzlhz();
	}
/**
 * 合同汇总
 * @author liangkaidi
 * @date 2015-12-28
 * @return
 */
	public int getHthz() {
		return dao.getHthz();
	}
/**
 * 采购统计
 * @author liangkaidi
 * @date 2015-12-28
 * @return
 */
public int getCgtj() {
	
	return dao.getCgtj();
}

/**
 * 缴费情况
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getJfqk1() {
	return dao.getJfqk1();
}
/**
 * 月收入
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public  List<Map<String, Object>> getywYsr() {
	return dao.getywYsr();
}
/**
 * 年收入
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
@Transactional
public List<Map<String, Object>> getNsr() {
	return dao.getNsr();
}
/**
 * 当年收入统计
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
public List<Map<String, Object>> getDnsrtj1() {
		return dao.getDnsrtj1();
	}

/**
 * 去年收入统计
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */

public List<Map<String, Object>> getDnsrtj2() {
	return dao.getDnsrtj2();
}

public int  getKhxyl() {
	return dao.getKhxyl();
}
/**
 * 获取收费情况信息
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
@Transactional
public List<Map<String, Object>> getBgsf1() {
		return dao.getBgsf1();
	}
/**
 * 获取月排行
 * @author liangkaidi
 * @date 2015-12-29
 * @return
 */
@Transactional
public List<Map<String, Object>> getYwypx1() {
	return dao.getYwypx1();
}

public List<Map<String, Object>> getDatj() {
	return dao.getDatj();
}
/**
 * 单位收费汇总
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getDwsfhz() {
	return dao.getDwsfhz();
}

/**
 * 检测室收入
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getJcssr() {
	return dao.getJcssr();
}
/**
 * 总收费
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getZsf() {
	return dao.getZsf();
}
/**
 * 业务总收费
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getYwzsf() {
	return dao.getYwzsf();
}
/**
 * 业务科室收入
 * @author liangkaidi
 * @date 2015-12-30
 * @return
 */
public List<Map<String, Object>> getYwkssr() {
	return dao.getYwkssr();
}
/**
 * 任务列表
 * @author liangkaidi
 * @date 2015-12-31
 * @return
 */
public List<Map<String, Object>> getRwlb() {
	return dao.getRwlb();
}

/**
 * 人员工作汇总
 * @author liusong
 * @date 2015-12-31
 * @return
 */
public List<Map<String, Object>> getGzhz() {
	return dao.getGzhz();
}
/**
 * 获取查看任务列表的单条信息
 * @author liangkaidi
 * @date 2015-12-31
 * @return
 */
public List<Map<String, Object>> getRwlblist() {
	return dao.getRwlblist();
}

}
