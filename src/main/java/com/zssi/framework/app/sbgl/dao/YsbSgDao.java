package com.zssi.framework.app.sbgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbSg;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Repository
public class YsbSgDao extends HibernateBaseDaoImpl<YsbSg, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private  NamedParameterJdbcPager jdbcPager;

	/**
	 * 后台：设备申购
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
	public Pagination<Map<String, Object>> getSbsgList(Integer start,Integer limit, String code) {
		
		String str = "";
		str=str+this.getBmxx(str);
		if(code!=null&&!"".equals(code)){
			str=str+" and a.sgbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
		}
		String sql = " select a.id,a.sgbh,a.sbmc,a.sblx,a.sbxh,a.sbjb,a.syfw,a.sccj,to_char(a.sgrq,'YYYY-MM-dd') as sgrq,"
				+ "a.sgjg,a.sbsgr,to_char(a.dhyqsj,'YYYY-MM-dd') as dhyqsj,a.bz,b.bmmc as syks from y_sb_sg a left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/** 
	 * 传参id的设备申购修改list查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getXg(String id){
		String str = "";
		if (id != null && !"".equals(id)) {
			str=str+" and a.id="+id;
		}
		String sql = " select a.id,a.sgbh,a.sbmc,a.sblx,a.sbxh,a.sbjb,a.syfw,a.sccj,to_char(a.sgrq,'YYYY-MM-dd') as sgrq,"
				+ "a.sgjg,a.sbsgr,to_char(a.dhyqsj,'YYYY-MM-dd') as dhyqsj,a.bz,b.bmmc as syks from y_sb_sg a left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 设备申购信息下拉框查询
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public void deleteSbsg(Integer id){
		String sql = "delete from y_sb_sg where id="+id;
				jdbcTemplate.execute(sql);
	}
	
	/**
	 * 获取当前登录人部门信息
	 * @author liusong
	 * @date 2016年1月15日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String,Object>> getBm(String sjbh,String bmbh){
		String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where sjbh='"+sjbh+"' and bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取过滤条件
	 * @author liusong
	 * @date 2016年1月15日
	 * @param str
	 * @return
	 */
	public String getBmxx(String str){
		SysYh user=AppUtil.getCurrentUser();
		List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
		List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
		if(jybm.size()!=0){
			str=str+" and a.syks='"+user.getBmbh()+"' ";
		}else if(jsbm.size()!=0){
			str=str+" and a.syks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
		}
		return str;
	}

}
