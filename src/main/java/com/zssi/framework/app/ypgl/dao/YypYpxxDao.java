package com.zssi.framework.app.ypgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.ypgl.model.YypYpxx;

@Repository
public class YypYpxxDao extends HibernateBaseDaoImpl<YypYpxx, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询样品信息
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYpxxList(Integer start,Integer limit,String canshu,String bgbh,String ypbh,String ypmc,String yplx,
			String ypdj,String ypzt,String ggxh,String szcs,String scrqpc,String jyks,String ywks,String cyry,String cydd,String cyrq,String sb,
			String jyfydd,String yhxtk,String jylx,String jyhth,String jcfyry,String dyrq,String djsj,String wcqx,String wtdw,String wtlxr,
			String sjhm,String sjdw,String lxr,String scdw,String scdwlxr,String gcmc,String gclxr,String sgdw,String gcsjdw,String jsdw,
			String jldw,String jlr,String jzdw,String jzr,String slr){
		String str = "";
		str=str+this.getBmxx1(str);
	if(canshu!=null&&!"".equals(canshu)){str=str+" and a.ypbh like '%"+ canshu+ "%' or a.ypmc like '%"+ canshu+ "%' or a.bgbh like '%"+canshu+"%'";}
	if(bgbh!=null&&!"".equals(bgbh)){str=str+" and a.bgbh like '%"+ bgbh+"%'";}
	if(ypbh!=null&&!"".equals(ypbh)){str=str+" and a.ypbh like '%"+ ypbh+ "%'";}
	if(ypmc!=null&&!"".equals(ypmc)){str=str+" and a.ypmc like '%"+ ypmc+ "%'";}
	if(yplx!=null&&!"".equals(yplx)){str=str+" and a.yplx like '%"+ yplx+ "%'";}
	if(ypdj!=null&&!"".equals(ypdj)){str=str+" and a.ypdj like '%"+ ypdj+ "%'";}
	if(ypzt!=null&&!"".equals(ypzt)){str=str+" and a.ypdj like '%"+ ypzt+ "%'";}
	if(ggxh!=null&&!"".equals(ggxh)){str=str+" and a.ggxh like '%"+ ggxh+ "%'";}
	if(szcs!=null&&!"".equals(szcs)){str=str+" and a.szcs like '%"+ szcs+ "%'";}
	if(scrqpc!=null&&!"".equals(scrqpc)){str=str+" and a.scrqpc like '%"+ scrqpc+ "%'";}
	if(jyks!=null&&!"".equals(jyks)){str=str+" and a.jyks = "+ jyks+ "";}
	if(ywks!=null&&!"".equals(ywks)){str=str+" and a.ywks = "+ ywks+ "";}
	if(cyry!=null&&!"".equals(cyry)){str=str+" and a.cyry like '%"+ cyry+ "%'";}
	if(cydd!=null&&!"".equals(cydd)){str=str+" and a.cydd like '%"+ cydd+ "%'";}
	if(cyrq!=null&&!"".equals(cyrq)){str=str+" and to_char(a.cyrq,'yyyy-MM-dd') = '"+ cyrq+ "' ";}
	if(sb!=null&&!"".equals(sb)){str=str+" and a.sb like '%"+ sb+ "%'";}
	if(jyfydd!=null&&!"".equals(jyfydd)){str=str+" and a.jyfydd = "+ jyfydd+ "";}
	if(yhxtk!=null&&!"".equals(yhxtk)){str=str+" and a.yhxtk = "+ yhxtk+ "";}
	if(jylx!=null&&!"".equals(jylx)){str=str+" and a.jylx like '%"+ jylx+ "%'";}
	if(jyhth!=null&&!"".equals(jyhth)){str=str+" and a.jyhth like '%"+ jyhth+ "%'";}
	if(jcfyry!=null&&!"".equals(jcfyry)){str=str+" and a.jcfyry like '%"+ jcfyry+ "%'";}
	if(dyrq!=null&&!"".equals(dyrq)){str=str+" and to_char(a.dyrq,'yyyy-MM-dd') = '"+ dyrq+ "' ";}
	if(djsj!=null&&!"".equals(djsj)){str=str+" and to_char(a.djsj,'yyyy-MM-dd') = '"+ djsj+ "' ";}
	if(wcqx!=null&&!"".equals(wcqx)){str=str+" and to_char(a.wcqx,'yyyy-MM-dd') = '"+ wcqx+ "' ";}
	if(wtdw!=null&&!"".equals(wtdw)){str=str+" and a.wtdw like '%"+ wtdw+ "%'";}
	if(wtlxr!=null&&!"".equals(wtlxr)){str=str+" and a.wtlxr like '%"+ wtlxr+ "%'";}
	if(sjhm!=null&&!"".equals(sjhm)){str=str+" and a.sjhm like '%"+ sjhm+ "%'";}
	if(sjdw!=null&&!"".equals(sjdw)){str=str+" and a.sjdw like '%"+ sjdw+ "%'";}
	if(lxr!=null&&!"".equals(lxr)){str=str+" and a.lxr like '%"+ lxr+ "%'";}
	if(scdw!=null&&!"".equals(scdw)){str=str+" and a.scdw like '%"+ scdw+ "%'";}
	if(scdwlxr!=null&&!"".equals(scdwlxr)){str=str+" and a.scdwlxr like '%"+ scdwlxr+ "%'";}
	if(gcmc!=null&&!"".equals(gcmc)){str=str+" and a.gcmc like '%"+ gcmc+ "%'";}
	if(gclxr!=null&&!"".equals(gclxr)){str=str+" and a.gclxr like '%"+ gclxr+ "%'";}
	if(sgdw!=null&&!"".equals(sgdw)){str=str+" and a.sgdw like '%"+ sgdw+ "%'";}
	if(gcsjdw!=null&&!"".equals(gcsjdw)){str=str+" and a.gcsjdw like '%"+ gcsjdw+ "%'";}
	if(jsdw!=null&&!"".equals(jsdw)){str=str+" and a.jsdw like '%"+ jsdw+ "%'";}
	if(jldw!=null&&!"".equals(jldw)){str=str+" and a.jldw like '%"+ jldw+ "%'";}
	if(jlr!=null&&!"".equals(jlr)){str=str+" and a.jlr like '%"+ jlr+ "%'";}
	if(jzdw!=null&&!"".equals(jzdw)){str=str+" and a.jzdw like '%"+ jzdw+ "%'";}
	if(jzr!=null&&!"".equals(jzr)){str=str+" and a.jzr like '%"+ jzr+ "%'";}
	if(slr!=null&&!"".equals(slr)){str=str+" and a.slr like '%"+ slr+ "%'";}
	String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,"
			+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.sjdw,a.sb,"
			+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
			+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,a.rwly,a.cydbh,"
			+ "nvl(a.jyfy,0)as jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.fj,a.ypyj,"
			+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl,a.djlx,nvl(d.xgje,1)as xgje from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
			+ "left join sys_zzjg c on a.ywks = c.id left join y_cw_bgsf d on a.bgbh = d.bgbh where 1=1 and d.jyfy >= 0 "+str+" order by a.id desc";
	return jdbcPager.queryPage(sql, start, limit);
}
		
	/**
	 * 获取过滤条件
	 * @author wangyong
	 * @date 2016年1月25日
	 * @param str
	 * @return
	 */
	public String getBmxx(String str){
		SysYh user=AppUtil.getCurrentUser();
		List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
		List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
		if(jybm.size()!=0){
			str=str+" and a.jyks='"+user.getBmbh()+"' ";
		}else if(jsbm.size()!=0){
			str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh='"+user.getBmbh()+"') ";
		}
		return str;
	}	
	
	/**
	 * 获取部门信息
	 * @author wangyong
	 * @date 2016年1月25日
	 * @param sjbh
	 * @param bmbh
	 * @return
	 */
	public List<Map<String,Object>> getBm(String sjbh,String bmbh){
		String sql="SELECT id, bmbh, bmmc, sjbh, jb, px, bz FROM SYS_ZZJG where sjbh='"+sjbh+"' and bmbh='"+bmbh+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String,Object>> getList1(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.sbbh like '%"+ code+ "%' or a.sbmc like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,"
				+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.rwly,a.cydbh,"
				+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
				+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,"
				+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.fj,a.ypyj,"
				+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
				+ "left join sys_zzjg c on a.ywks = c.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	public List<Map<String,Object>> getList2(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str=str+" and a.id like '%"+ code+ "%' or a.id like '%"+ code+ "%'";
		}
		String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,"
				+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.rwly,a.cydbh,"
				+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
				+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,"
				+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.ypyj,"
				+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
				+ "left join sys_zzjg c on a.ywks = c.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	      /**
	       * 样品类别（行业信息表）
	       * @author duanpeijun
	       * @date 2015年9月28日
	       * @param str
	       * @return
	       */
		public List<Map<String, Object>> getHymc() {
			String sql =" select a.hymc,a.hybh from y_kh_hyxx a ";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 检验类型（数据字典）
		 * @author duanpeijun
		 * @date 2015年9月29日
		 * @param zdzl
		 * @return
		 */
		public List<Map<String, Object>> getDicByJylx(String zdzl) {
			String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2' order by a.px asc";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 获取工程类样品的字号
		 * @author wangyong
		 * @date 2016年1月7日
		 * @return
		 */
		public List<Map<String, Object>> getGczh() {
			String sql =" select a.zhmc from y_bg_bhsz a where a.zhfl=4 or a.zhfl=5 or a.zhfl=6";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 获取一般类样品的字号
		 * @author wangyong
		 * @date 2016年1月7日
		 * @return
		 */
		public List<Map<String, Object>> getYbzh() {
			String sql ="select a.zhmc from y_bg_bhsz a where a.zhfl<4 group by a.zhmc";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 查询数据
		 * @author duanpeijun
		 * @date 2015年10月22日
		 * @param start
		 * @param limit
		 * @param code
		 * @return
		 */
		public List<Map<String,Object>> getList(String code){
			String str = "";
			if (code != null && !"".equals(code)) {
				str=str+" and a.ypbh like '%"+ code+ "%' or a.ypmc like '%"+ code+ "%' or a.bgbh like '%"+code+"%'";
			}
			
			String sql =  "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,"
					+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.rwly,a.cydbh,"
					+ "a.ypsl,a.wtdw,a.wtdwdz,a.sjdw,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
					+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,a.jyks,a.ywks,a.jyhth,a.ewmtp,a.jyfy,"
					+ "a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.ypyj,"
					+ "to_char(a.djsj,'YYYY-MM-dd') as djsj from y_yp_ypxx a "
					+ "left join( select zdz,zdmc,zdbm from sys_sjzd where zl='lyfs' and jb = 2) b on a.lyfs = b.zdz "
					+ "left join( select zdz,zdmc,zdbm from sys_sjzd where zl='bgfsfs' and jb = 2) c on a.bgfsfs = c.zdz "
					+ "left join( select zdz,zdmc,zdbm from sys_sjzd where zl='yhxtk' and jb = 2) d on a.yhxtk = d.zdz "
					+ "left join( select zdz,zdmc,zdbm from sys_sjzd where zl='jyfydd' and jb = 2) e on a.jyfydd = e.zdz "
					+ "left join( select zdz,zdmc,zdbm from sys_sjzd where zl='ypjyzt' and jb = 2) f on a.ypjyzt = e.zdz "
					+ "where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 查询数据
		 * @author panweichi
		 * @date 2015年11月24日
		 * @param start
		 * @param limit
		 * @param search
		 * @return
		 */
		public List<Map<String,Object>> getYpxx1(String search){
			String str = "";
			if (search != null && !"".equals(search)) {
				str=str+" and a.ypbh like '%"+ search+ "%' or a.ypmc like '%"+ search+ "%'";
			}
			String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,a.rwly,a.cydbh,"
					+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,"
					+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
					+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,"
					+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.ypyj,"
					+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
					+ "left join sys_zzjg c on a.ywks = c.id where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
/************************************2015-11-4针对“检验”,由Ext转向Jsp页面****************************************************/
		/**
		 * 检验页面————样品信息
		 * @author duanpeijun
		 * @date 2015年11月4日
		 * @param id
		 * @return
		 */
		public List<Map<String,Object>> getYp(String bgbh){
			String str = "";
			if(bgbh!=null&&!"".equals(bgbh)){
				str=" and a.bgbh='"+bgbh+"'";
			}
			String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,a.rwly,a.cydbh,"
					+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,"
					+ "a.sjdwfrdb,a.sjdwgddh,a.scdwfrdb,a.yyzz,a.jgdm,a.rs,a.cz,a.cl,a.zsbh,a.byljfcdd,a.jsydd,to_char(a.jsyjzrq,'YYYY-MM-dd') as jsyjzrq,"
					+ "a.cydwdz,a.cydwlxdh,a.cydwyzbm,a.czemail,a.cysl,a.zslx,a.sfwckcp,a.jjlx,a.cydw,a.lyrq,"
					+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
					+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,"
					+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.ypyj,"
					+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl,a.zh,a.sb,a.ypzt,a.sjdw,a.djry,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,"
					+ "a.gcmc,a.gcdz,a.jsdw,a.sgdw,a.jldw, a.jzdw,a.jlr, a.jzr,a.djlx  from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
					+ "left join sys_zzjg c on a.ywks = c.id where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 根据报告编号查询样品ID
		 * @author duanpeijun
		 * @date 2015年12月23日
		 * @param bgbh
		 * @return
		 */
		public List<Map<String, Object>> getYpbgbh(String bgbh){
			String str = "";
			if(bgbh!=null&&!"".equals(bgbh)){
				str=" and a.id='"+bgbh+"'";
			}
			String sql = " select a.id,a.bgbh from y_yp_ypxx a where 1=1 " + str ;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 点击修改获取所选行的信息
		 * @author wangyong
		 * @date 2015年11月18日
		 * @param id
		 * @return
		 */
		public List<Map<String, Object>> getYpxx(Integer id){
			String str = "";
			if(id!=null&&!"".equals(id)){
				str=" and a.id="+id;
			}
			String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,d.zhmc as zh,a.scdwyb,a.jyxm,a.djlx,"
					+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.sjdw,a.jyyj,a.xgr,a.ypyj,"
					+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,to_char(a.xgsj,'YYYY-MM-dd') as xgsj,"
					+ "a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,a.rwly,a.cydbh,"
					+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.sb,a.sjhm,a.wtyb,"
					+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl,to_char(a.lyrq,'YYYY-MM-dd') as lyrq,a.lyr,a.gcmc,a.gcdz,a.gclxr,a.wtlxr,"
					+ "a.sgdw,a.gcsjdw,a.jsdw,a.jldw,a.jzdw,a.jlr,a.jzr,a.slr,a.jzdw,nvl(e.xgje,1)as xgje from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
					+ "left join sys_zzjg c on a.ywks = c.id left join y_bg_bhsz d on d.zh = a.zh left join y_cw_bgsf e on a.bgbh = e.bgbh where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}

		/**
		 * 
		 * @author wangyong
		 * @date 2016年1月8日
		 * @param id   
		 * @param djlx 登记类型
		 * @return
		 */
		public List<Map<String, Object>> getYpxx(Integer id,String djlx){
			String str = "";
			if(id!=null&&!"".equals(id) && djlx!=null&&!"".equals(djlx)){
				if (djlx.equals("0")) {
					str=" and a.id="+id+" and d.zhfl < 4";
				}else if (djlx.equals("1")) {
					str=" and a.id="+id+" and d.zhfl > 3";
				}else if (djlx.equals("2")) {
					str=" and a.id="+id+" and d.zhfl = 0";
				}else if (djlx.equals("3")) {
					str=" and a.id="+id+" and d.zhfl < 4";
				}
			}
			String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yjzt,a.ypyj,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,d.zhmc as zh,a.scdwyb,a.jyxm,a.djlx,"
					+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.sjdw,a.jyyj,a.xgr,a.rwly,a.cydbh,"
					+ "a.sjdwfrdb,a.sjdwgddh,a.scdwfrdb,a.yyzz,a.jgdm,a.rs,a.cz,a.cl,a.zsbh,a.byljfcdd,a.jsydd,to_char(a.jsyjzrq,'YYYY-MM-dd') as jsyjzrq,"
					+ "a.cydwdz,a.cydwlxdh,a.cydwyzbm,a.czemail,a.cysl,a.zslx,a.sfwckcp,a.jjlx,a.wtdwgddh,a.scdwgddh,"
					+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,to_char(a.xgsj,'YYYY-MM-dd') as xgsj,"
					+ "a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,a.cydw,a.ypyj,"
					+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.sb,a.sjhm,a.wtyb,"
					+ "to_char(a.djsj,'YYYY-MM-dd hh24:mm:ss') as djsj,a.lysl,to_char(a.lyrq,'YYYY-MM-dd') as lyrq,a.lyr,a.gcmc,a.gcdz,a.gclxr,a.wtlxr,"
					+ "a.sgdw,a.gcsjdw,a.jsdw,a.jldw,a.jzdw,a.jlr,a.jzr,a.slr,a.jzdw from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
					+ "left join sys_zzjg c on a.ywks = c.id left join y_bg_bhsz d on d.zh = a.zh where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 查询报告编号
		 * @author wangyong
		 * @date 2015年11月18日
		 * @param id
		 * @return
		 */
		public List<Map<String, Object>> getBgbhList(String bmbh){
			String str = "";
			if(bmbh!=null&&!"".equals(bmbh)){
				str=" and a.bgbh like '%" + bmbh + "%'";
			}
			String sql = "select a.bgbh from y_yp_ypxx a where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 样品信息的二维码
		 * @author duanpeijun
		 * @date 2015年12月01日
		 * @param id
		 * @return
		 */
		public List<Map<String,Object>> getYpewm(String ypbh){
			String str = "";
			if(ypbh!=null&&!"".equals(ypbh)){
				str=" and a.ypbh='"+ypbh+"'";
			}
			String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,d.zhmc as zh,a.scdwyb,a.jyxm,a.djlx,"
					+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.sjdw,a.jyyj,a.xgr,a.rwly,a.cydbh,"
					+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,to_char(a.xgsj,'YYYY-MM-dd') as xgsj,"
					+ "a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,a.ypyj,"
					+ "a.jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.cyjs,a.fj,a.sb,a.sjhm,a.wtyb,"
					+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl,to_char(a.lyrq,'YYYY-MM-dd') as lyrq,a.lyr,a.gcmc,a.gcdz,a.gclxr,a.wtlxr,"
					+ "a.sgdw,a.gcsjdw,a.jsdw,a.jldw,a.jzdw,a.jlr,a.jzr,a.slr,a.jzdw from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
					+ "left join sys_zzjg c on a.ywks = c.id left join y_bg_bhsz d on d.zh = a.zh where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 *  通过前台传来的部门编号获取样品编号中间的字号
		 * @author wangyong
		 * @date 2015年12月2日
		 * @param bmbh
		 * @return
		 */
		public List<Map<String, Object>> findZh(String bmbh,String zhmc){
			String str = "";
			if(bmbh!=null&&!"".equals(bmbh)){
				str=" and a.bmbh = '" + bmbh + "' and a.zhmc = '" + zhmc +"'";
			}
			String sql = "select a.zh from y_bg_bhsz a where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		public List<Map<String, Object>> getSfbzbh() {
			String sql = "select a.sfbzbh from y_sf_bzxx a where 1=1 " ;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 获取当前最大的抽样单编号
		 * @author wangyong
		 * @date 2016年3月17日
		 * @return
		 */
		public List<Map<String, Object>> getCydbh() {
			String sql = "select max(cydbh) cydbh from Y_YP_YPXX" ;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 获取收费项目明细
		 * @author wangyong
		 * @date 2015年12月11日
		 * @return
		 */
//		public List<Map<String, Object>> getSfxmmx(String cppmccx,String xmmccx,String jzcs) {
//			String str = "";
//			int num=1;
//			if(jzcs!=null&&!"".equals(jzcs)){
//				num=Integer.parseInt(jzcs);
//			}
//			if ((cppmccx!=null&&!"".equals(cppmccx)) && (xmmccx!=null&&!"".equals(xmmccx))) {
//				str = "and bz.cpmc like '%" + cppmccx +"%' and xm.xmmc like '%" + xmmccx + "%'";
//			}else if((cppmccx!=null&&!"".equals(cppmccx))) {
//				str = "and bz.cpmc like '%" + cppmccx +"%'";
//			}else if((xmmccx!=null&&!"".equals(xmmccx))){
//				str = "and xm.xmmc like '%" + xmmccx + "%'";
//			}
//			
//			String sql = "SELECT X.id, X.sfbzbh, X.cplx, X.cpmc, X.xmbh, X.xmmc, X.dj, X.jldw,ROWNUM AS RN FROM "
//					+ "(select xm.id,bz.sfbzbh,xm.cplx,bz.cpmc,xm.xmbh,xm.xmmc,xm.dj,xm.jldw from y_sf_bzxx bz,y_sf_xmxx xm "
//					+ "where bz.sfbzbh = xm.sfbzbh " + str+") X WHERE ROWNUM <="+(num*7);
//			return jdbcTemplate.queryForList(sql);
//		}
		
		/**
		 * 获取检验咨询信息
		 * @author duanpeijun
		 * @date 2016年8月2日
		 * @param cppmccx
		 * @param xmmccx
		 * @param jzcs
		 * @return
		 */
		public List<Map<String, Object>> getSfxmmx(String cppmccx,String xmmccx,String jzcs,String zxxjyyj) {
			String str = "";
			int num=1;
			if(jzcs!=null&&!"".equals(jzcs)){
				num=Integer.parseInt(jzcs);
			}
			if ((cppmccx!=null&&!"".equals(cppmccx)) || (xmmccx!=null&&!"".equals(xmmccx)) || (zxxjyyj!=null&&!"".equals(zxxjyyj))) {
				str = " a.cpmc like '%" + cppmccx +"%' and a.jcxm like '%" + xmmccx + "%' and a.jyyj like '%" + zxxjyyj + "%'";
			}else if((cppmccx!=null&&!"".equals(cppmccx))) {
				str = " a.cpmc like '%" + cppmccx +"%'";
			}else if((xmmccx!=null&&!"".equals(xmmccx))){
				str = " a.jcxm like '%" + xmmccx + "%'";
			}else if((zxxjyyj!=null&&!"".equals(zxxjyyj))){
				str = " a.jyyj like '%" + zxxjyyj + "%'";
			}
			
			String sql = "SELECT X.id, X.cpmc, X.xmbh, X.xmmc, X.dj, X.jldw,ROWNUM AS RN FROM "
+ "(select a.id,a.cpmc,a.jyxmbh as xmbh,a.jcxm as xmmc,a.jcfy as dj,a.jldw,a.jyyj from y_jy_zxxx a where " + str+") X WHERE ROWNUM <="+(num*7);
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 根据字号获取字号名称
		 * @author liujiansen
		 * @date 2015年12月14日
		 * @param zh
		 * @return
		 */
		public List<Map<String,Object>> getZhmc(String zh,String djlx){
			String str = "";
			if(zh!=null&&!"".equals(zh)){
				str=str+" and a.zh='"+zh+"'";
			}
			if(djlx!=null&&!"".equals(djlx)){
				if("1".equals(djlx)){
					str=str+" and a.zhfl in (4,5,6)";
				}else{
					str=str+" and a.zhfl in (0,1,2,3)";
				}
			}
			String sql = "SELECT a.zh,substr(a.zhmc,1,length(a.zhmc)-2) as zhmc,a.zhfl FROM Y_BG_BHSZ a where 1=1 "+str+"  group by a.zh,a.zhmc,a.zhfl ";
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 根据认证分类获取认证图标
		 * @author liujiansen
		 * @date 2015年12月14日
		 * @param zh
		 * @return
		 */
		public List<Map<String,Object>> getRztb(String rzfl){
			String str = "";
			if(rzfl!=null&&!"".equals(rzfl)){
				str=" and a.fl='"+rzfl+"'";
			}
			String sql = "SELECT a.id, a.rzmc, a.rzfl, a.fjlj, a.bz, a.sub, a.kssj, a.jssj FROM Y_JY_RZTB a where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 根据报告编号获取检验项目
		 * @author liujiansen
		 * @date 2015年12月14日
		 * @param zh
		 * @return
		 */
		public List<Map<String,Object>> getJyyj(String bgbh){
			String str = "";
			if(bgbh!=null&&!"".equals(bgbh)){
				str=" and a.bgbh='"+bgbh+"'";
			}
			String sql = "SELECT a.id, a.bgbh, a.xmbh, a.xmmc, a.jldw, a.je, a.xgje FROM Y_YP_SFXMMX a where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		public List<Map<String, Object>> getid(String bgbh) {
			String str = "";
			if (bgbh != null && !"".equals(bgbh)) {
				str=str+" and a.bgbh = '"+ bgbh +"'";
			}
			String sql = "select a.id from y_yp_ypxx a  where 1=1  "+ str;
			
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 编制报告页面，展示样品状态
		 * @author duanpeijun
		 * @date 2015年12月21日
		 * @return
		 */
		public List<Map<String, Object>> getYpzyzt(String zdzl){
			String sql = "select t.*, t.rowid from sys_sjzd t where t.zl='"+zdzl+"' and t.jb='2'";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 样品复制时获取样品信息列表	
		 * @author wangyong
		 * @date 2015年12月21日
		 * @param request
		 * @param response
		 * @return
		 */
		public List<Map<String, Object>> ypfzList(String ypbhcx,String ypmccx,String djlx,String ypjzcs) {
			String str = "";
			str=str+this.getBmxx1(str);
			Integer ypdjlx = Integer.parseInt(djlx);
			int num=1;
			if(ypjzcs!=null&&!"".equals(ypjzcs)){
				num=Integer.parseInt(ypjzcs);
			}
			if ((ypbhcx!=null&&!"".equals(ypbhcx)) && (ypmccx!=null&&!"".equals(ypmccx))) {
				str = str+ "and a.ypbh like '%" + ypbhcx +"%' and a.ypmc like '%" + ypmccx + "%'";
			}else if((ypbhcx!=null&&!"".equals(ypbhcx))) {
				str = str+ "and a.ypbh like '%" + ypbhcx +"%'";
			}else if((ypmccx!=null&&!"".equals(ypmccx))){
				str = str+ "and a.ypmc like '%" + ypmccx + "%'";
			}
			
//			String sql = "select a.id,a.ypbh,a.ypmc,a.yplx,a.scdw "
//					+ "from y_yp_ypxx a where a.djlx='"+ypdjlx+"' "+str;
//			return jdbcTemplate.queryForList(sql);
			
			String sql = "SELECT X.id, X.ypbh, X.ypmc, X.yplx, X.scdw,ROWNUM AS RN FROM "
					+ "(select a.id,a.ypbh,a.ypmc,a.yplx,a.scdw from y_yp_ypxx a "
					+ "where a.djlx=" + ypdjlx+" "+str+") X WHERE ROWNUM <="+(num*7);
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 验证样品编号和报告编号是否已存在
		 * @author wangyong
		 * @date 2015年12月28日
		 * @param 
		 * @return
		 */
		public List<Map<String, Object>> yzbgbh(String bgbh) {
			String str = "";
			if(bgbh!=null&&!"".equals(bgbh)){
				str="and a.bgbh='"+bgbh+"'";
			}
			String sql = "select a.bgbh from y_yp_ypxx a where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}

		/**
		 * 样品删除时连带将此报告编号所有的收费信息删除掉
		 * @author wangyong
		 * @date 2015年2月22日
		 * @param 
		 * @return
		 */
		public void deletesf(String bgbh) {
			String sql = "delete from y_cw_bgsf where bgbh = '"+bgbh+"' and ysfje = 0 ";
			jdbcTemplate.execute(sql);
			
		}
		
		/**
		 * 样品删除时连带将此报告编号所有的收费记录信息删除掉
		 * @author liusong
		 * @date 2015年2月22日
		 * @param 
		 * @return
		 */
		public void deletejl(String bgbh) {
			String sql = "delete from y_cw_bgsfjl where bgbh = '"+bgbh+"'";
			jdbcTemplate.execute(sql);
			
		}

		public List<Map<String, Object>> getjyks(String ypbh) {
			String sql="select jyks from y_yp_ypxx where ypbh='"+ypbh+"'";
			return jdbcTemplate.queryForList(sql);
		}

		public List<Map<String, Object>> getypbh(String businessKey) {
			String sql="select ypbh from y_yp_ypxx where bgbh='"+businessKey+"'";
			return jdbcTemplate.queryForList(sql);
		}

		public List<Map<String, Object>> getValue(String bgbh) {
            String sql="select a.id,a.jyfy,a.jyhth,a.djlx,b.id as bid,b.ysfje from y_yp_ypxx a left join y_cw_bgsf b on a.ypbh = b.bgbh where a.ypbh = '"+bgbh+"'";
			return jdbcTemplate.queryForList(sql);
		}
		
//		查看dlm是否重复
		public List<Map<String, Object>> checkhth(String jyhth) {
			String sql="select xybh from Y_JSFW_XYXX where syje > 0 and xybh='"+jyhth+"'";
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 获取过滤条件
		 * @author liujiansen
		 * @date 2016年1月15日
		 * @param str
		 * @return
		 */
		public String getBmxx1(String str){
			String req="";
			String rep="";
		     SysYh user=AppUtil.getCurrentUser();
		     if(("".equals(user.getJbm1())||user.getJbm1()==null)&&("".equals(user.getJbm2())||user.getJbm2()==null)
						&&("".equals(user.getJbm3())||user.getJbm3()==null)&&("".equals(user.getJbm4())||user.getJbm4()==null)){
					List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
					List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
					if(jybm.size()!=0){
						req=req+"'"+user.getBmbh()+"',";
					}else if(jsbm.size()!=0){
						rep=rep+"'"+user.getBmbh()+"',";
					}
					if(!"".equals(req) && "".equals(rep)){
						str=str+" and a.jyks in("+req+" '101') ";
					}else if(!"".equals(rep) && "".equals(req)){
						str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) ";
					}
				}else{
					List<Map<String,Object>> jybm=this.getBm("100250", user.getBmbh());//判断当前登录人是否是科室人员
					List<Map<String,Object>> jsbm=this.getBm("100240", user.getBmbh());//判断当前登录人是否是技术中心人员
					List<Map<String,Object>> jybm1=this.getBm("100250", user.getJbm1());//判断当前登录人是否是科室人员
					List<Map<String,Object>> jsbm1=this.getBm("100240", user.getJbm1());//判断当前登录人是否是技术中心人员
					List<Map<String,Object>> jybm2=this.getBm("100250", user.getJbm2());//判断当前登录人是否是科室人员
					List<Map<String,Object>> jsbm2=this.getBm("100240", user.getJbm2());//判断当前登录人是否是技术中心人员
					List<Map<String,Object>> jybm3=this.getBm("100250", user.getJbm3());//判断当前登录人是否是科室人员
					List<Map<String,Object>> jsbm3=this.getBm("100240", user.getJbm3());//判断当前登录人是否是技术中心人员
					List<Map<String,Object>> jybm4=this.getBm("100250", user.getJbm4());//判断当前登录人是否是科室人员
					List<Map<String,Object>> jsbm4=this.getBm("100240", user.getJbm4());//判断当前登录人是否是技术中心人员
					if(jybm.size()!=0){
						req=req+"'"+user.getBmbh()+"',";
					}else if(jsbm.size()!=0){
						rep=rep+"'"+user.getBmbh()+"',";
					}
					if(jybm1.size()!=0){
						req=req+"'"+user.getJbm1()+"',";
					}else if(jsbm1.size()!=0){
						rep=rep+"'"+user.getJbm1()+"',";
					}
					if(jybm2.size()!=0){
						req=req+"'"+user.getJbm2()+"',";
					}else if(jsbm2.size()!=0){
						rep=rep+"'"+user.getJbm2()+"',";
					}
					if(jybm3.size()!=0){
						req=req+"'"+user.getJbm3()+"',";
					}else if(jsbm3.size()!=0){
						rep=rep+"'"+user.getJbm3()+"',";
					}
					if(jybm4.size()!=0){
						req=req+"'"+user.getJbm4()+"',";
					}else if(jsbm4.size()!=0){
						rep=rep+"'"+user.getJbm4()+"',";
					}
//				if(!"".equals(req) && "".equals(rep)){
//					str=str+" and a.jyks in("+req+" '101') ";
//				}else if(!"".equals(rep) && "".equals(req)){
//					str=str+" and a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) ";
//				}else 
					if(!"".equals(rep) || !"".equals(req)){
						str=str+" and (a.jyks in (SELECT a.jyksbh FROM SYS_JGLSGX a where a.jszxbh in("+rep+" '101')) or a.jyks in("+req+" '101')) ";
					}
					
				}
			return str;
		}
}
