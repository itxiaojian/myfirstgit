package com.zssi.framework.app.sbgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sbgl.model.YsbXx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

@Repository
public class YsbXxDao extends HibernateBaseDaoImpl<YsbXx, Integer> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 后台：设备信息,用于前台grid的分页查询
	 * @author liusong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @return
	 */
public Pagination<Map<String, Object>> getSbxxList(Integer start, Integer limit,String code){
		
		String str = "";
//		str=str+this.getBmxx(str);
		if(code!=null&&!"".equals(code)){
			str=str+" and a.sbbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
				+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
				+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
				+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
				+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
				+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.jdzs,a.jdzssub,b.bmmc as syks from y_sb_xx a "
				+ "left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
		
		return jdbcPager.queryPage(sql, start, limit);
	}

/** 
 * 设备信息list查询
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
public List<Map<String,Object>> getList(String code){
	String str = "";
//	str=str+this.getBmxx(str);
	if (code != null && !"".equals(code)) {
		str=str+" and a.sbbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
	}
	String sql = " select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
			+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
			+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
			+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
			+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
			+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,b.bmmc as syks,a.jdzs,a.jdzssub  from y_sb_xx a left join "
			+ "sys_zzjg b on a.syks = b.bmbh where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/** 
 * 微信平台设备信息list查询
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
public List<Map<String,Object>> getList2(String code){
	String str = "";
	if (code != null && !"".equals(code)) {
		str=str+" and a.sbbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
	}
	String sql = " select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
			+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
			+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
			+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
			+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
			+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.syks,a.jdzs,a.jdzssub  from y_sb_xx a where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}
/**
 * 检验页面中————设备信息
 * @author panweichi
 * @date 2015年11月24日
 * @return
 */
public List<Map<String,Object>> getSbxx1(String search){
	String str = "";
//	str=str+this.getBmxx(str);
	if (search != null && !"".equals(search)) {
		str=str+" and a.sbbh like '%"+ search+ "%' or a.sbmc like '%"+ search+ "%'";
	}
	String sql = " select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
				+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
				+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
				+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
				+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
				+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.jdzs,a.jdzssub,b.bmmc as syks from y_sb_xx a "
				+ "left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/** 
 * 传参id的list查询
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
public List<Map<String,Object>> getSb(String id){
	String str = "";
	if (id != null && !"".equals(id)) {
		str=str+" and a.id ="+id;
	}
	String sql = "  select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
				+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
				+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
				+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
				+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
				+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.syks,a.jdzs,a.jdzssub from y_sb_xx a where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/** 
 * 传参id的list查询上次检定时间
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
public List<Map<String, Object>> getXcrq(String id){
	String str = "";
	if (id != null && !"".equals(id)) {
		str=str+" and a.id="+id;
	}
	String sql = "  select to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq from y_sb_xx a  where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

//微服务-设备信息-点击详情
public List<Map<String,Object>> getList1(String code){
	String str = "";
	if (code != null && !"".equals(code)) {
		str=str+" and a.id ="+ code;
	}
	String sql = "   select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
				+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
				+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
				+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
				+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
				+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.jdzs,a.jdzssub,b.bmmc as syks from y_sb_xx a "
				+ "left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}

/** 
 * 下拉框查询
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午10:19:22 
 * 类说明 
 */
public List<Map<String, Object>> getDicByLx(String zdzl) {
	String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
	List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
	return list;
}

/**
 * 删除
 * @author liusong
 * @version 2015年9月21日下午2:10:45
 * @param id
 */
	public void deleteSbxx(Integer id){
		String sql = "delete from y_sb_xx where id="+id;
				jdbcTemplate.execute(sql);
	}

/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
	/**
	 * 检验页面中————设备信息
	 * @author duanpeijun
	 * @date 2015年11月5日
	 * @return
	 */
	public List<Map<String, Object>> getSbxx(String code){
		String str = "";
//		str=str+this.getBmxx(str);
		if (code != null && !"".equals(code)) {
			str=str+" and a.sbmc like '%"+ code+ "%'";
		}
		String sql = " select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
				+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
				+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
				+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
				+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
				+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.jdzs,a.jdzssub,b.bmmc as syks from y_sb_xx a "
				+ "left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据设备编号获取设备生成二维码
	 * @author duanpeijun
	 * @date 2015年12月01日
	 * @param sbbh
	 * @return
	 */
	public List<Map<String, Object>> getSbewm(String sbbh) {
		String str="";
		if(sbbh!=null&&!"".equals(sbbh)){
			str=str+" and a.sbbh='"+sbbh+"'";
		}
		String sql="  select a.id,a.sbbh,a.ewmbh,a.sbmc,a.sbxh,a.sbjb,a.syfw,a.sccj,a.ccbh,to_char(a.ccrq,'YYYY-MM-dd') as ccrq,"
				+ "to_char(a.gmrq,'YYYY-MM-dd') as gmrq,a.gmjg,a.jyzq,to_char(a.scjdrq,'YYYY-MM-dd') as scjdrq,a.yqzk,"
				+ "to_char(a.xcjdrq,'YYYY-MM-dd') as xcjdrq,a.syzt,a.sbwhr,a.tyyy,to_char(a.tyrq,'YYYY-MM-dd') as tyrq,a.bfyy,"
				+ "to_char(a.bfrq,'YYYY-MM-dd') as bfrq,a.bz,a.ewmtp,a.dw,a.sbfj,a.fzdd,to_char(a.qysj,'YYYY-MM-dd') as qysj,a.cjlxr,"
				+ "a.cjdh,a.cjdz,a.clfw,a.pjxx,a.sbczr,a.sfyczgc,a.sfyqjhc,a.sfysyjl,a.sfygnjc,a.sbzt,a.czgc,a.sysms,a.sbzp,a.sysmffj,"
				+ "a.gnjcff,a.qjhcff,a.bzddj,a.jlqk,a.jljg,a.jdfy,a.jddw,a.sybm,a.jdzs,a.jdzssub,b.bmmc as syks from y_sb_xx a "
				+ "left join sys_zzjg b on a.syks = b.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
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
