package com.zssi.framework.app.jygl.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YjyNwgl;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

/**
 * 内委管理
 * @author liujiansen
 * @date 2015年12月30日
 */
@Repository
public class YjyNwglDao extends HibernateBaseDaoImpl<YjyNwgl, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 后台：检验项目目录
	 * @author duanpeijun
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getNwglList(Integer start,Integer limit,String canshu){
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.bgbh like '%"+ canshu+ "%' or a.ypmc like '%"+ canshu+ "%'";
		}
		String sql = "SELECT a.id,a.wtbm,a.wtbmmc,a.cjbm,a.cjbmmc,a.wtrq,a.yqwcrq,a.jbr,a.jbrxm,a.jbrq,a.bmld,a.bmldxm,a.qzrq,a.jsr,a.jsrxm,a.jsrq,a.lzdzt,a.wtyps,a.jyfy,"
				+ "WMSYS.WM_CONCAT(a.bgbh) as ypbh,WMSYS.WM_CONCAT(a.ypmc) as ypmc from (SELECT a.id,a.wtbm,e.bmmc AS wtbmmc,a.cjbm,f.bmmc AS cjbmmc,to_char(a.wtrq,'yyyy-MM-dd') AS wtrq,"
				+ "to_char(a.yqwcrq,'yyyy-MM-dd') AS yqwcrq,"
				+ "a.jbr,b.xm AS jbrxm,to_char(a.jbrq,'yyyy-MM-dd') AS jbrq,a.bmld,d.xm AS bmldxm,to_char(a.qzrq,'yyyy-MM-dd') AS qzrq,a.jsr,c.xm AS jsrxm,to_char(a.jsrq,'yyyy-MM-dd') AS jsrq,"
				+ "a.lzdzt,a.wtyps,a.jyfy,g.bgbh,g.ypmc FROM Y_JY_NWGL a LEFT JOIN SYS_YH b ON a.jbr = b.dlm LEFT JOIN SYS_YH c ON a.jsr = c.dlm LEFT JOIN SYS_YH d ON a.bmld = d.dlm  "
				+ "LEFT JOIN SYS_ZZJG e ON a.wtbm = e.bmbh LEFT JOIN SYS_ZZJG f ON a.cjbm = f.bmbh LEFT JOIN Y_JY_NWMX g on a.id=g.nwbh ) a where 1=1 " + str +" GROUP BY "
				+ "a.id,a.wtbm,a.wtbmmc,a.cjbm,a.cjbmmc,a.wtrq,a.yqwcrq,a.jbr,a.jbrxm,a.jbrq,a.bmld,a.bmldxm,a.qzrq,a.jsr,a.jsrxm,a.jsrq,a.lzdzt,a.wtyps,a.jyfy";
		return jdbcPager.queryPage(sql, start, limit);
	}

	/**
	 * 获取样品信息
	 * @author liujiansen
	 * @date 2015年12月31日
	 * @param cpmccx
	 * @param xmmccx
	 * @param jzcs
	 * @return
	 */
	public List<Map<String, Object>> getYpxx(String cpbhcx,String cpmccx, String start,String end,String jzcs) {
		String str = "";
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		SysYh user=AppUtil.getCurrentUser();
		String bmbh="";
		List<Map<String, Object>> bm=this.getBm(user.getBmbh());
		if(bm.size()!=0){
			for(int i=0;i<bm.size();i++){
				if(i<bm.size()-1){
					bmbh=bmbh+"'"+bm.get(i).get("bmbh")+"',";
				}else{
					bmbh=bmbh+"'"+bm.get(i).get("bmbh")+"'";
				}
			}
			bm=this.getBm(bmbh);
			if(bm.size()!=0){
				bmbh="";
				for(int i=0;i<bm.size();i++){
					if(i<bm.size()-1){
						bmbh=bmbh+"'"+bm.get(i).get("bmbh")+"',";
					}else{
						bmbh=bmbh+"'"+bm.get(i).get("bmbh")+"'";
					}
				}
			}
		}
		if(!"".equals(bmbh)){
			str = "and jyks in (" + bmbh +")";
		}
		int num=1;
		if(jzcs!=null&&!"".equals(jzcs)){
			num=Integer.parseInt(jzcs);
		}
//		if ((cpmccx!=null&&!"".equals(cpmccx)) && (xmmccx!=null&&!"".equals(xmmccx))) {
//			str = "and ypmc like '%" + cpmccx +"%' and to_char(djsj,'yyyy-MM-dd') between '" + xmmccx + "' and '"+sim.format(new Date())+"'";
//		}else if((cpmccx!=null&&!"".equals(cpmccx))) {
//			str = "and ypmc like '%" + cpmccx +"%'";
//		}else if((xmmccx!=null&&!"".equals(xmmccx))){
//			str = "and to_char(djsj,'yyyy-MM-dd') between '" + xmmccx + "' and '"+sim.format(new Date())+"'";
//		}
		if ((cpbhcx!=null&&!"".equals(cpbhcx))){
			str=str+" and ypbh like '%" + cpbhcx +"%'"; 
		}
		if ((cpmccx!=null&&!"".equals(cpmccx))){
			str=str+" and ypmc like '%" + cpmccx +"%'"; 
		}
		if(start!=null&&!"".equals(start)){
			if(end!=null&&!"".equals(end)){
				str=str+" and to_char(djsj,'yyyy-MM-dd') between '"+start+ "'and'"+end+ "' ";
			}else if(end == null||"".equals(end)){
				str=str+" and to_char(djsj,'yyyy-MM-dd') = '"+start+"' ";
				}
			}
		if(start == null || "".equals(start)){
			if(end!=null&&!"".equals(end)){
				str=str+" and to_char(djsj,'yyyy-MM-dd') = '"+end+ "' ";
				}
			}
		
		String sql = "SELECT X.ypmc,X.ypbh, X.ggxh, X.jyyj, X.wtdw,ROWNUM AS RN FROM "
				+ "(SELECT ypmc, ypbh, ggxh, jyyj,wtdw FROM "
				+ "Y_YP_YPXX where YPJYZT in (0,1) " + str+" group by ypmc, ypbh, ggxh, jyyj,wtdw "
				+ ") X WHERE ROWNUM <="+(num*5);
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 根据部门编号获取部门名称
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBmmc(String bmbh) {
		String sql="select bmmc,bmbh from sys_zzjg where bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据部门编号获取所属部门
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBm(String bmbh) {
		String sql="select bmbh from sys_zzjg where bmbh in("+bmbh+") or sjbh in("+bmbh+")";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 样品信息
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param ypmc
	 * @param wtdw
	 * @param djsj
	 * @return
	 */
	public List<Map<String, Object>> getYpxxList(String ypmc,String wtdw,String djsj) {
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String sql="select ypbh,ypmc,ggxh,wtdw,jyyj from Y_YP_YPXX where ypmc in('"+ypmc+"') and wtdw in('"+wtdw+"') and "
				+ "to_char(djsj,'yyyy-MM-dd') between '"+djsj+"' and '"+sim.format(new Date())+"'";
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 获取检验项目
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getJyxm(String ypbhs) {
		String sql="SELECT bgbh, xmbh, xmmc,xgje FROM Y_YP_SFXMMX where bgbh in ("+ypbhs+")";
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 获取人员
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getYhbyBm(String bmbh) {
		String sql="SELECT yhbh, dlm, xm FROM SYS_YH  where bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 根据部门编号获取所属部门
	 * @author liujiansen
	 * @date 2015年12月30日
	 * @param bmbh
	 * @return
	 */
	public List<Map<String, Object>> getBmmcList(String bmbh) {
		String sql="select bmbh,bmmc from sys_zzjg where bmbh in("+bmbh+") or sjbh in("+bmbh+")";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getNwgl(String id){
		String sql="SELECT a.id,a.wtbm,e.bmmc AS wtbmmc,a.cjbm,f.bmmc AS cjbmmc,to_char(a.wtrq,'yyyy-MM-dd') AS wtrq,"
				+ "to_char(a.yqwcrq,'yyyy-MM-dd') AS yqwcrq,"
				+ "a.jbr,b.xm AS jbrxm,to_char(a.jbrq,'yyyy-MM-dd') AS jbrq,a.bmld,d.xm AS bmldxm,to_char(a.qzrq,'yyyy-MM-dd') AS qzrq,a.jsr,c.xm AS jsrxm,to_char(a.jsrq,'yyyy-MM-dd') AS jsrq,"
				+ "a.lzdzt,a.wtyps,a.jyfy,g.bgbh,g.ypmc FROM Y_JY_NWGL a LEFT JOIN SYS_YH b ON a.jbr = b.dlm LEFT JOIN SYS_YH c ON a.jsr = c.dlm LEFT JOIN SYS_YH d ON a.bmld = d.dlm  "
				+ "LEFT JOIN SYS_ZZJG e ON a.wtbm = e.bmbh LEFT JOIN SYS_ZZJG f ON a.cjbm = f.bmbh LEFT JOIN Y_JY_NWMX g on a.id=g.nwbh where a.id="+id;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getNwmx(String id){
		String sql="SELECT a.id,a.bgbh,a.nwbh,a.ypmc,a.ggxh,a.jyyj,a.jyxm,a.jyfy,case a.sfty when 0 then '是' else '否' end as sfty,a.ypbgqx,a.wtdw,a.djsj from Y_JY_NWMX a where a.nwbh="+id;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 
	 * @author liujiansen
	 * @date 2016年1月2日
	 * @param id
	 * @return
	 */
	public List<Map<String,Object>> getNwmxList(String id){
		String sql="SELECT a.id,a.bgbh,a.nwbh,a.ypmc,a.ggxh,a.jyyj,a.jyxm,a.jyfy,a.sfty,a.ypbgqx,a.wtdw,a.djsj from Y_JY_NWMX a where a.nwbh="+id;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取角色信息
	 * @author liujiansen
	 * @date 2016年1月4日
	 * @param userName
	 * @return
	 */
	public List<Map<String,Object>> getYhJs(String userName){
		String sql="SELECT a.dlm,a.xm,c.jsmc,c.bz FROM SYS_YH a left join SYS_YHJS b on a.yhbh=b.yhbh left join SYS_JS c on b.jsbh=c.jsbh where a.dlm='"+userName+"'";
		return jdbcTemplate.queryForList(sql);
	}
}
