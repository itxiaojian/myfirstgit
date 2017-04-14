package com.zssi.framework.app.ypgl.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypYj;

@Repository
public class YypYjDao extends HibernateBaseDaoImpl<YypYj, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 查询样品移交列表
	 * @author wangyong
	 * @date 2016年3月9日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getYjList(Integer start,Integer limit,String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str + "and a.ypbh like '%"+ code + "%' or a.ewmbh like '%"+ code + "%' or a.ypmc like '%"+ code + "%'";
		}
		String sql = "select a.id,a.ypbh,a.txmbh,a.ypmc,to_char(a.yjsj,'yyyy-mm-dd') as yjsj,a.jsr,to_char(a.jssj,'yyyy-mm-dd') as jssj,"
				+ "a.yjr,a.blr,a.yjsl,a.bz from y_yp_yj a where 1=1 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 查询getYpxxList
	 * @author wangyong
	 * @date 2016年3月10日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String, Object>> getYpxxList(Integer start,Integer limit,String canshu){
		String str = "";
		if (canshu != null && !"".equals(canshu)) {
			str = str + "and a.ypbh like '%"+ canshu + "%' or a.ypmc like '%"+ canshu + "%'";
		}
		String sql = "select a.id,a.ypbh,a.ewmbh,a.ypmc,a.yplx,a.jylx,a.lyfs,a.szcs,a.ggxh,a.scrqpc,to_char(a.wcqx,'YYYY-MM-dd') as wcqx,"
				+ "a.jyksbh,a.ywksbh,a.ypdj,a.ypzt,a.cydd,to_char(a.cyrq,'YYYY-MM-dd') as cyrq,a.cyjs,a.sjdw,a.sb,"
				+ "a.ypsl,a.wtdw,a.wtdwdz,b.bmmc as jyks,a.sjdwdz,a.lxr,a.dh,a.yb,a.scdw,a.scdwdz,a.scdwlxr,a.scdwdh,"
				+ "a.scdwyb,a.jyxm,a.jyyj,a.bgfsfs,a.yhxtk,a.cyry,a.jcfyry,c.bmmc as ywks,a.jyhth,a.ewmtp,a.rwly,a.cydbh,"
				+ "nvl(a.jyfy,0)as jyfy,a.jyfydd,a.bz,a.bgbh,a.ypjyzt,a.djry,to_char(a.dyrq,'YYYY-MM-dd') as dyrq,a.fj,a.ypyj,a.yjzt,"
				+ "to_char(a.djsj,'YYYY-MM-dd') as djsj,a.lysl,a.djlx,nvl(d.xgje,1)as xgje from y_yp_ypxx a left join sys_zzjg b on a.jyks = b.id "
				+ "left join sys_zzjg c on a.ywks = c.id left join y_cw_bgsf d on a.bgbh = d.bgbh where 1=1 and a.ypyj=0 and a.yjzt=0 and d.jyfy >= 0 "+str+" order by a.djsj desc";
		return jdbcPager.queryPage(sql, start, limit);
		
	}
}
