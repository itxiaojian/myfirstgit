package com.zssi.framework.app.jygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyBgxx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * 检验报告信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Repository
public class YjyBgxxDao extends HibernateBaseDaoImpl<YjyBgxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：编制报告
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getBgbzList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgmc like '%"+ canshu+ "%' or a.bgbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.bgbh,a.ypbh,a.jylb,a.yplb,a.bmbh,to_char(a.djrq,'YYYY-MM-dd') as djrq,a.jyyj,to_char(a.jyqx,'YYYY-MM-dd') as jyqx,a.bzbh,"
				+ "a.bzmc,a.zjr,to_char(a.ksrq,'YYYY-MM-dd') as ksrq,to_char(a.jsrq,'YYYY-MM-dd') as jsrq,a.hjtj,a.xmms,a.jyff,a.pdyq,a.qtsm,a.jyfy,a.jjfy,"
				+ "a.qtfy,a.fyhj,a.swpd,a.bzpd,a.jyjl,a.rzfs,a.jyzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.tbzt,a.bz from y_jy_jyxx a "
				+ "where 1=1 " + str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 后台：报告信息（更改报告信息）
	 * @author duanpeijun
	 * @date 2015年12月10日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getBgxxList(Integer start,Integer limit,String ypbh,String ypmc,String yplx,
			String ypdj,String jylx,String szcs,String wtdw,String sjdw,String scdw,String jyks,String ywks,String djsj,String djsjStr,
			String djsjEnd,String gcmc,String sgdw,String gcsjdw,String jsdw1,String jldw,String jzdw,String wtlxr){
		String str = "";
		if(ypbh!=null&&!"".equals(ypbh)){str=str+" and c.ypbh like '%"+ ypbh+ "%'";}
		if(ypmc!=null&&!"".equals(ypmc)){str=str+" and c.ypmc like '%"+ ypmc+ "%'";}
		if(yplx!=null&&!"".equals(yplx)){str=str+" and c.yplx like '%"+ yplx+ "%'";}
		if(ypdj!=null&&!"".equals(ypdj)){str=str+" and c.ypdj like '%"+ ypdj+ "%'";}
		if(jylx!=null&&!"".equals(jylx)){str=str+" and c.jylx like '%"+ jylx+ "%'";}
		if(szcs!=null&&!"".equals(szcs)){str=str+" and c.szcs like '%"+ szcs+ "%'";}
		if(wtdw!=null&&!"".equals(wtdw)){str=str+" and c.wtdw like '%"+ wtdw+ "%'";}
		if(sjdw!=null&&!"".equals(sjdw)){str=str+" and c.sjdw like '%"+ sjdw+ "%'";}
		if(scdw!=null&&!"".equals(scdw)){str=str+" and c.scdw like '%"+ scdw+ "%'";}
		if(jyks!=null&&!"".equals(jyks)){str=str+" and c.jyks = "+ jyks+ "";}
		if(ywks!=null&&!"".equals(ywks)){str=str+" and c.ywks = "+ ywks+ "";}
		if(djsjStr!=null&&!"".equals(djsjStr)&&djsjEnd!=null&&!"".equals(djsjEnd)){
	    str=str+" and to_char(c.djsj,'yyyy-MM-dd') between '"+ djsjStr+"' and '"+ djsjEnd+ "' ";}
		if(gcmc!=null&&!"".equals(gcmc)){str=str+" and c.gcmc like '%"+ gcmc+ "%'";}
		if(djsj!=null&&!"".equals(djsj)){str=str+" and to_char(c.djsj,'yyyy-MM-dd') = '"+ djsj+ "' ";}
		if(sgdw!=null&&!"".equals(sgdw)){str=str+" and c.sgdw like '%"+ sgdw+ "%'";}
		if(gcsjdw!=null&&!"".equals(gcsjdw)){str=str+" and c.gcsjdw like '%"+ gcsjdw+ "%'";}
		if(jsdw1!=null&&!"".equals(jsdw1)){str=str+" and c.jsdw1 like '%"+ jsdw1+ "%'";}
		if(jldw!=null&&!"".equals(jldw)){str=str+" and c.jldw like '%"+ jldw+ "%'";}
		if(jzdw!=null&&!"".equals(jzdw)){str=str+" and c.jzdw like '%"+ jzdw+ "%'";}
		if(wtlxr!=null&&!"".equals(wtlxr)){str=str+" and c.wtlxr like '%"+ wtlxr+ "%'";}
		String sql = "select a.id,a.bgbh,a.bgmc,b.xm as bzr,a.jyrq,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,c.ypmc,"
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,a.rzfs,a.bsdx,a.cydw,a.dyzt,a.dycs,d.jyfy,"
				+ "to_char(a.bgbzrq,'YYYY-MM-dd') as bgbzrq,to_char(a.bgdysj,'YYYY-MM-dd') as bgdysj,a.sfjs,to_char(c.wcqx,'YYYY-MM-dd') as wcqx,d.ysfje "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh left join y_cw_bgsf d on a.bgbh =d.bgbh  "
				+ "where 1=1 " + str+" order by c.djrq desc ";
		return jdbcPager.queryPage(sql, start, limit);
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
	public Pagination<Map<String, Object>> getBgjs(Integer start,Integer limit,String canshu){
		String str = "";
		String abc = "";
		str=abc+this.getBmxx(str);
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgmc like '%"+ canshu+ "%' ";
		}
		String sql = "select a.id,a.bgbh,a.bgmc,b.xm as bzr,a.jyrq,c.ypmc,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,c.ypjyzt, "
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,a.rzfs,a.bsdx,a.cydw,a.sfjs, "
				+ "to_char(c.wcqx,'YYYY-MM-dd') as wcqx "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh "
				+ "where 1=1 " + abc + " and c.ypjyzt in (4,5) " + str;
		return jdbcPager.queryPage(sql, start, limit);
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
	public Pagination<Map<String, Object>> getBgyqList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgmc like '%"+ canshu+ "%' or a.bgbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.bgbh,a.bgmc,b.xm as bzr,a.jyrq,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,"
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,a.rzfs,a.bsdx,a.cydw,to_char(c.wcqx,'YYYY-MM-dd') as wcqx "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh "
				+ "where c.ypjyzt < 5 " + str;
		return jdbcPager.queryPage(sql, start, limit);
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
	public Pagination<Map<String, Object>> getBgdyList(Integer start,Integer limit,String canshu){
		String str = "";
		String abc = "";
		str=abc+this.getBmxxtwo(str);
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and z.bgbh like '%"+ canshu+ "%'";
		}
		String sql = "select z.*, to_char(b.shsj, 'YYYY-MM-dd') as shsj from (select a.id, c.jyks,a.bgbh,a.bgmc,c.ypmc,c.id as yjbid,b.xm as bzr,a.jsdw1,to_char(a.ffrq, 'YYYY-MM-dd') as ffrq,"
				   + "a.jsr,nvl(a.dycs, '0') as dycs,a.ffzt, to_char(a.tjrq, 'YYYY-MM-dd') as tjrq, a.tjyy, a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,"
				   + "a.rzfs,a.bsdx,a.cydw,to_char(c.wcqx, 'YYYY-MM-dd') as wcqx from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh "
				   + "left join y_yp_ypxx c on a.bgbh = c.ypbh where c.ypjyzt >= 4 and c.ypjyzt < 8) z "
				   + "left join (select max(id),bgbh,shjdmc,shyj,shzt,max(shsj) as shsj,shr,bz,xgjdry from y_sh_yjb "
				   +"  group by bgbh,shjdmc,shyj,shzt,shr,bz,xgjdry ) b on z.yjbid = b.bgbh  where b.shjdmc = '技术中心批准人员' and b.shzt = '1' "+ str+" order by b.shsj desc" ;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 获取过滤条件(报告多次打印需要的部门过滤条件)
	 * @author liujiansen
	 * @date 2016年1月15日
	 * @param str
	 * @return
	 */
	public String getBmxxtwo(String str){
		SysYh user=AppUtil.getCurrentUser();
		List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
		List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
		if(jybm.size()!=0){
			str=str+" and z.jyks='"+user.getBmbh()+"' ";
		}else if(jsbm.size()!=0){
			str=str+" and z.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
		}
		return str;
	}
	
	/**
	 * 获取过滤条件(其他的需要的部门过滤条件)
	 * @author liujiansen
	 * @date 2016年1月15日
	 * @param str
	 * @return
	 */
	public String getBmxx(String str){
		SysYh user=AppUtil.getCurrentUser();
		List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
		List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
		if(jybm.size()!=0){
			str=str+" and c.jyks='"+user.getBmbh()+"' ";
		}else if(jsbm.size()!=0){
			str=str+" and c.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
		}
		return str;
	}
	
	/**
	 * 获取部门信息
	 * @author liujiansen
	 * @date 2016年1月15日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String,Object>> getBm(String sjbh,String bmbh){
		String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where sjbh='"+sjbh+"' and bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
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
	public Pagination<Map<String, Object>> getBgdydanList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.bgbh,c.ypmc,b.xm as bzr,a.jyrq,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,a.dycs,"
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,a.rzfs,a.bsdx,a.cydw,to_char(c.wcqx,'YYYY-MM-dd') as wcqx "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh "
				+ "where c.ypjyzt >= 4 and a.dycs = 0 " + str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 微信平台获取报告信息
	 * @author panweichi
	 * @date 2015年12月21日
	 * @param canshu
	 */
	public List<Map<String, Object>> getList(String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgmc like '%"+ canshu+ "%' or a.bgbh like '%"+ canshu+ "%'";
		}
		String sql = "select a.id,a.bgbh,a.bgmc,b.xm as bzr,a.jyrq,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,"
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,a.rzfs,a.bsdx,a.cydw,to_char(c.wcqx,'YYYY-MM-dd') as wcqx "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh "
				+ "where 1=1 " + str;
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
	 * 根据部门编号获取所属部门
	 * @author lusong
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getJyks(String bmbh) {
		String sql="select bmbh,bmmc from sys_zzjg where bmbh in("+bmbh+") or sjbh in("+bmbh+")";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getKsmc() {
		String sql="select bmbh,bmmc from sys_zzjg where bmbh not in('100','101')";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String, Object>> getCplx() {
		String sql="select a.zdz,a.zdmc from sys_sjzd a where a.zl='cplx' and a.jb=2";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询部门名称下拉框
	 * @author liusong
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBm() {
		String sql="select bmbh,bmmc from sys_zzjg where sjbh in('100210','100220','100260','100270') "
				+ " or bmbh in('100210','100220','100260','100270','100280' )";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 发放状态（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	public List<Map<String, Object>> getDicByFfzt(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	
	/**
	 * 根据样品信息的报告编号查询检验信息有无该条数据。（样品信息的报告编号和报告信息的报告编号是相同的）
	 * @author duanpeijun
	 * @date 2015年10月30日
	 * @param sbbh
	 * @return
	 */
	public List<Map<String, Object>> getbgxxList(String bgbh){
		String sql = "select id,bgbh,sfjs from y_jy_bgxx where bgbh='"+bgbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 二维码报告信息
	 * @author duanpeijun
	 * @date 2015年12月3日
	 * @param bgbh
	 * @return
	 */
	public List<Map<String, Object>> getbgxxewm(String bgbh){
		String str="";
		if(bgbh!=null&&!"".equals(bgbh)){
			str=str+" and a.bgbh='"+bgbh+"'";
		}
		String sql = "select a.id,a.bgbh,a.bgmc,b.xm as bzr,to_char(a.bgbzrq,'YYYY-MM-dd') as bzrq,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,"
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.dycs from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh "
				+ "where 1=1 " + str;
		return jdbcTemplate.queryForList(sql);
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
	public Pagination<Map<String, Object>> getYqjlList(Integer start,Integer limit, String bgbh) {
		String str = "";
		if(bgbh!=null&&!"".equals(bgbh)){
			str=str+" and a.bgbh = '"+ bgbh+ "'";
		}
		String sql = "SELECT a.id, a.bgbh,c.bgmc, to_char(a.wcqx,'YYYY-MM-dd') as wcqx, to_char(a.zxwcqx,'YYYY-MM-dd') as zxwcqx, "
				+ "to_char(a.xgsj,'YYYY-MM-dd') as xgsj, a.xgr, b.xm as xgrxm,a.bz FROM Y_BG_YQJL a left join SYS_YH b on a.xgr=b.yhbh "
				+ "left join Y_JY_BGXX c on a.bgbh=c.bgbh where 1=1 " + str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询报审对象字段的人员列表（根据"报告审核角色和本部门的人员列表"）
	 * @author duanpeijun
	 * @date 2015年12月18日
	 * @return
	 */
	public List<Map<String, Object>> getbsdx(String bmbh){
		String str = "";
		if(bmbh!=null&&!"".equals(bmbh)){
			str=str+" and C.Bmbh ='"+bmbh+"'";
		}
		String sql = "SELECT C.YHBH,C.USERNAME,C.SJH,C.YX,C.YHZT,C.Bmbh, C.BMMC,C.XM,C.JSBH FROM (select this_.yhbh as yhbh,this_.bmbh as bmbh,"
				   + "this_.gwbh as gwbh,this_.mm as mm,this_.sjh as sjh,this_.dlm as username,this_.xm as xm,this_.yhzt as yhzt,this_.yx as yx,"
				   + "this_.zhdlsj as zhdlsj,bm.BMMC as bmmc,yhjs.jsbh,gw.BMMC as gwmc from sys_yh this_ LEFT JOIN sys_zzjg bm on this_.BMBH = bm.BMBH "
				   + "LEFT JOIN sys_zzjg gw on this_.GWBH = gw.BMBH "
				   + "LEFT JOIN sys_yhjs yhjs on this_.yhbh = yhjs.YHBH where 1 = 1) C "
				   + "WHERE 1 = 1 AND C.jsbh = (select a.jsbh from sys_js a where a.jsmc = 'ROLE_JYSHRY') " + str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据ID查询报告信息数据
	 * @author duanpeijun
	 * @date 2015年12月24日
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getBgxx(Integer id){
		String str = "";
		if(id!=null&&!"".equals(id)){
			str=str+" and a.id ='"+id+"'";
		}
		String sql = "select a.id,a.bgbh,a.bgmc,b.xm as bzr,a.jyrq,a.jsdw1,to_char(a.ffrq,'YYYY-MM-dd') as ffrq,a.jsr,c.ypjyzt, "
				+ "a.ffzt,to_char(a.tjrq,'YYYY-MM-dd') as tjrq,a.tjyy,a.tjr,a.bz,a.ewmbh,a.ewmtp,a.bzfs,a.jyjl,a.rzfs,a.bsdx,a.cydw,a.sfjs, "
				+ "to_char(c.wcqx,'YYYY-MM-dd') as wcqx,a.dyzt,a.dycs,a.bgbzrq,a.bgdysj  "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh "
				+ "where 1=1 " + str ;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询所有的报告信息
	 * @author duanpeijun
	 * @date 2016年1月13日
	 * @return
	 */
	public List<Map<String, Object>> getBg(String fenye,String bgbh,String bzr,String wtdw,
				String sjdw,String ypmc,String jyrq,String jylx,String jyyj){
		String str = "";
		String abc = "";
		int num=1;
		if(fenye!=null&&!"".equals(fenye)){
			num=Integer.parseInt(fenye);
		}
		if(bgbh!=null&&!"".equals(bgbh)){
			str=str+" and a.bgbh like '%"+ bgbh+ "%'";
		}
		if(bzr!=null&&!"".equals(bzr)){
			str=str+" and b.xm like '%"+ bzr+ "%'";
		}
		if(wtdw!=null&&!"".equals(wtdw)){
			str=str+" and c.wtdw like '%"+ wtdw+ "%'";
		}
		if(sjdw!=null&&!"".equals(sjdw)){
			str=str+" and c.sjdw like '%"+ sjdw+ "%'";
		}
		if(ypmc!=null&&!"".equals(ypmc)){
			str=str+" and c.ypmc like '%"+ ypmc+ "%'";
		}
		if(jyrq!=null&&!"".equals(jyrq)){
			str=str+" and a.jyrq like '%"+ jyrq+ "%'";
		}
		if(jylx!=null&&!"".equals(jylx)){
			str=str+" and c.jylx like '%"+ jylx+ "%'";
		}
		if(jyyj!=null&&!"".equals(jyyj)){
			str=str+" and c.jyyj like '%"+ jyyj+ "%'";
		}
		str=abc+this.getBmxx(str);
		String sql = "SELECT X.id, X.bgbh, X.bgmc, X.bzr,X.wtdw,X.sjdw,X.ypmc,X.jyrq,X.jylx,X.jyyj, ROWNUM AS RN FROM "
				+"(select a.id,a.bgbh,a.bgmc,b.xm as bzr,a.jyrq, "
				+ "c.wtdw,c.sjdw,c.ypmc,c.jylx,c.jyyj "
				+ "from y_jy_bgxx a left join sys_yh b on a.bzr = b.yhbh left join y_yp_ypxx c on a.bgbh=c.ypbh "
				+ "where 1=1 and c.ypjyzt >= 1 " + str +")X WHERE ROWNUM <="+(num*7);
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查出主检人的姓名
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param key
	 * @return
	 */
	public List<Map<String, Object>> getZjr(String key){
		String sql = "select t.id,t.bgbh,t.shjdmc,t.shzt,t.shsj,t.shr from y_sh_yjb t where t.bgbh = "+key+" "
					+ "and t.shjdmc = '样品主检验人员' and t.shzt = '1' order by t.shsj desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 批准或者接收时，查出审核人姓名。
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param key
	 * @return
	 */
	public List<Map<String, Object>> getShr(String key){
		String sql = "select t.id,t.bgbh,t.shjdmc,t.shzt,t.shsj,t.shr from y_sh_yjb t where t.bgbh = "+key+" "
					+ "and t.shjdmc = '主检科室审核人员' and t.shzt = '1' order by t.shsj desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 接收时，查出批准人姓名。
	 * @author duanpeijun
	 * @date 2016年3月24日
	 * @param key
	 * @return
	 */
	public List<Map<String, Object>> getPzr(String key){
		String sql = "select t.id,t.bgbh,t.shjdmc,t.shzt,t.shsj,t.shr from y_sh_yjb t where t.bgbh = "+key+" "
					+ "and t.shjdmc = '技术中心批准人员' and t.shzt = '1' order by t.shsj desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 批准时:根据审核人的姓名去查出其电子签名图片
	 * @author duanpeijun
	 * @date 2016年3月31日
	 * @param shrxm
	 * @return
	 */
	public List<Map<String, Object>> getShrtp(String shrxm){
		String sql = "select t.yhbh,t.dlm,t.xm,t.yhjs from sys_yh t where t.dlm = "+" '"+shrxm+"' ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 报告编制时，查询历史记录有无审核不通过
	 * @author duanpeijun
	 * @date 2016年5月3日
	 * @param key  样品ID
	 * @return
	 */
	public List<Map<String, Object>> getShzt(String key){
		String sql = "select t.id,t.bgbh,t.shjdmc,t.shzt,t.shsj,t.shr from y_sh_yjb t where t.bgbh = "+key+" "
					+ "and t.shjdmc = '主检科室审核人员' order by t.shsj desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 报告编制时，查询历史记录有无批准不通过
	 * @author duanpeijun
	 * @date 2016年5月3日
	 * @param key  样品ID
	 * @return
	 */
	public List<Map<String, Object>> getPzzt(String key){
		String sql = "select t.id,t.bgbh,t.shjdmc,t.shzt,t.shsj,t.shr from y_sh_yjb t where t.bgbh = "+key+" "
					+ "and t.shjdmc = '技术中心批准人员' order by t.shsj desc";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询样品有无修改时间
	 * @author duanpeijun
	 * @date 2016年5月4日
	 * @param ypid
	 * @return
	 */
	public List<Map<String, Object>> xgsjList(String bgbh){
		String sql = "select a.xgsj from y_yp_ypxx a where a.bgbh = '"+bgbh+"' ";
		return jdbcTemplate.queryForList(sql);
	}
	
}
