package com.zssi.framework.app.sjbb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.cbgl.model.YcwCbxx;
import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;

@Repository
public class CbtjDao extends HibernateBaseDaoImpl<YcwCbxx, Integer> {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 分页查询成本信息
	 * 
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getCbtjList(String ksmc,String ksyf,String jsyf) {
		String str = "";
		String str1="";
		String str2="";
		String str3="";
		String str4="";
		String str5="";
		String str6="";
		String str7="";
		String str8="";
		String str9="";
		String str10="";
		String str11="";
		String str12="";
		String str13="";
		String str14="";
		String str15="";
		String str16="";
		String str17="";
		String strz = "";
		String sql ="";
		if (ksmc != null && !"".equals(ksmc)) {
			strz = strz + " and a.id =" + ksmc;
		}
		if (ksyf != null && !"".equals(ksyf)) {
			str1 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100130' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh='100130' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100130'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100130' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str2 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100210' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100210'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh like '100210%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100210'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str3 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like '100210___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str4 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100220' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100220'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100220'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str5 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100220___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str6 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100230' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100230'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100230' as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str7 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100230___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str8 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100240' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100240'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100240'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str9 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100240___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str10 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100250' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100250'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250%' group by a.fssj,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100250'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str11 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100250___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str12 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100260' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100260'as ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260%' group by a.fssj,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100260'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str13 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100260___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str14 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100270' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100270'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100270'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str15 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100270___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str16 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100280' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100280'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100280' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100280'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and  a.ksbh = '100280' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str17 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100110' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh='100110' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100110'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100110' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			 sql =" select * from( select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str17+")c group by c.ksbh,c.bmmc union  "
			 		+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str1+")c group by c.ksbh,c.bmmc union "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str2+")c group by c.ksbh,c.bmmc union "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str3+")c group by c.ksbh,c.bmmc union "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str4+")c group by c.ksbh,c.bmmc union "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str5+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str6+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str7+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str8+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str9+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str10+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str11+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str12+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str13+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str14+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str15+")c group by c.ksbh,c.bmmc union  "
	                + " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str16+")c group by c.ksbh,c.bmmc ) order by ksbh ";
		}else if(ksyf == null || "".equals(ksyf)){
			str = str+"select b.ksbh,b.bmmc,b.fylx,b.lrrq,nvl(b.je,0)as je from (select nvl(sum(c.je),0)as je,to_char(c.fssj,'yyyy-MM')as lrrq,c.fylx,c.ksbh,"
                    +" a.bmmc from y_cw_cbmx c,sys_zzjg a where  c.ksbh = a.id "+strz+" group by c.fssj,c.ksbh,c.fylx,a.bmmc)b group by "
                    +" b.ksbh,b.bmmc,b.fylx,b.je";
			     sql= " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0)) as gzxj,(100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gzxjbfb, sum(decode(c.fylx,'clf',je,0)) as clf,(100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clfbfb, "
			     	+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj,(100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as clgqjbfb, sum(decode(c.fylx,'bgf',je,0)) as bgf,(100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as bgfbfb, "
			     	+ " sum(decode(c.fylx,'jtf',je,0)) as jtf, (100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jtfbfb,sum(decode(c.fylx,'zdf',je,0)) as zdf, (100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zdfbfb, "
					+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,(100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as xsjdbfb, sum(decode(c.fylx,'px',je,0)) as pxf,(100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as pxfbfb, "
					+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,(100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as hyfbfb,sum(decode(c.fylx,'yd',je,0)) as yd,(100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ydbfb,  "
					+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,(100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wyfbfb, sum(decode(c.fylx,'sdf',je,0)) as sdf,(100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as sdfbfb, "
					+ " sum(decode(c.fylx,'wgf',je,0)) as wgf, (100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as wgfbfb,sum(decode(c.fylx,'zlf',je,0)) as zlf,(100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zlfbfb, "
					+ " sum(decode(c.fylx,'jf',je,0)) as jf,(100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jfbfb, sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf,(100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as ywxzfbfb, "
					+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,(100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zxfbfb,sum(decode(c.fylx,'lwf',je,0)) as lwf,(100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as lwfbfb, "
					+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,(100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as jyfbfb,sum(decode(c.fylx,'zjf',je,0)) as zjf, (100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as zjfbfb, "
					+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,(100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as gwycfbfb,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, (100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')) as qtfybfb, "
					+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str+")c group by c.ksbh,c.bmmc order by c.ksbh ";
		}
		
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 导出成本信息
	 * 
	 * @author liusong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getCbtjExcel(String ksmc,String ksyf,String jsyf) {
		String str1="";
		String str2="";
		String str3="";
		String str4="";
		String str5="";
		String str6="";
		String str7="";
		String str8="";
		String str9="";
		String str10="";
		String str11="";
		String str12="";
		String str13="";
		String str14="";
		String str15="";
		String str16="";
		String str17="";
		String strz = "";
		String sql ="";
		if (ksmc != null && !"".equals(ksmc)) {
			strz = strz + " and a.id =" + ksmc;
		}
			str1 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100130' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh='100130' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100130'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100130' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str2 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100210' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100210'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh like '100210%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100210'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str3 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like '100210___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str4 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100220' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100220'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100220'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str5 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100220___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str6 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100230' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100230'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100230' as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str7 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100230___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str8 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100240' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100240'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100240'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str9 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100240___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str10 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100250' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100250'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250%' group by a.fssj,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100250'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str11 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100250___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str12 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100260' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100260'as ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260%' group by a.fssj,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100260'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str13 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100260___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str14 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100270' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100270'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100270'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str15 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100270___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str16 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100280' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100280'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100280' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100280'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and  a.ksbh = '100280' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str17 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100110' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh='100110' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100110'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100110' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
		sql =" select * from( select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str17+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str1+")c group by c.ksbh,c.bmmc union "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str2+")c group by c.ksbh,c.bmmc union "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str3+")c group by c.ksbh,c.bmmc union "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str4+")c group by c.ksbh,c.bmmc union "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str5+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str6+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str7+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str8+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str9+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str10+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str11+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str12+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str13+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str14+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str15+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,sum(decode(c.fylx,'gzxj',je,0))as gzxj, sum(decode(c.fylx,'clf',je,0))as clf, "
				+ " sum(decode(c.fylx,'clgqj',je,0)) as clgqj, sum(decode(c.fylx,'bgf',je,0)) as bgf,  "
				+ " sum(decode(c.fylx,'jtf',je,0))as jtf,sum(decode(c.fylx,'zdf',je,0))as zdf,  "
				+ " sum(decode(c.fylx,'xsjd',je,0)) as xsjd,sum(decode(c.fylx,'px',je,0)) as pxf, "
				+ " sum(decode(c.fylx,'hyf',je,0)) as hyf,sum(decode(c.fylx,'yd',je,0)) as yd, "
				+ " sum(decode(c.fylx,'wyf',je,0)) as wyf,sum(decode(c.fylx,'sdf',je,0)) as sdf, "
				+ " sum(decode(c.fylx,'wgf',je,0)) as wgf,sum(decode(c.fylx,'zlf',je,0)) as zlf, "
				+ " sum(decode(c.fylx,'jf',je,0)) as jf,sum(decode(c.fylx,'ywxzf',je,0)) as ywxzf, "
				+ " sum(decode(c.fylx,'zxf',je,0)) as zxf,sum(decode(c.fylx,'lwf',je,0)) as lwf, "
				+ " sum(decode(c.fylx,'jyf',je,0)) as jyf,sum(decode(c.fylx,'zjf',je,0)) as zjf,  "
				+ " sum(decode(c.fylx,'gwycf',je,0)) as gwycf,sum(decode(c.fylx,'qtfy',je,0)) as qtfy, "
				+ " sum(decode(c.fylx,'hj',je,0)) as hj from ("+str16+")c group by c.ksbh,c.bmmc ) order by ksbh ";


		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 导出成本信息
	 * 
	 * @author liusong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> getCbtjBfbExcel(String ksmc,String ksyf,String jsyf) {
		String str1="";
		String str2="";
		String str3="";
		String str4="";
		String str5="";
		String str6="";
		String str7="";
		String str8="";
		String str9="";
		String str10="";
		String str11="";
		String str12="";
		String str13="";
		String str14="";
		String str15="";
		String str16="";
		String str17="";
		String strz = "";
		String sql ="";
		if (ksmc != null && !"".equals(ksmc)) {
			strz = strz + " and a.id =" + ksmc;
		}
			str1 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100130' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh='100130' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100130'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100130' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str2 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100210' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100210'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh like '100210%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100210'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str3 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like '100210___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100210___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str4 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100220' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100220'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100220'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str5 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100220___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100220___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str6 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100230' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100230'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100230' as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str7 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100230___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100230___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str8 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100240' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100240'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100240'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str9 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100240___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100240___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str10 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100250' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100250'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250%' group by a.fssj,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100250'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str11 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100250___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100250___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str12 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100260' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100260'as ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260%' group by a.fssj,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100260'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str13 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100260___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100260___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str14 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100270' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100270'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270%' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100270'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270%' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str15 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id like'100270___' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270___' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh like '100270___' group by a.fssj,a.ksbh)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str16 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100280' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,'100280'as ksbh  from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100280' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100280'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and  a.ksbh = '100280' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
			str17 = " select a.ksbh,a.bmmc,a.fylx,sum(nvl(b.je,0))as je from "
				+ " (select a.id as ksbh,a.bmmc,b.zdz as fylx  from sys_zzjg a,sys_sjzd b where a.id ='100110' and b.zl = 'cblx' and b.jb in(2,3) "+strz+" "
				+ " order by a.id)a left join (select nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,a.fylx,a.ksbh from y_cw_cbmx a "
				+ " where to_char(a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"' and a.ksbh='100110' group by a.fssj,a.ksbh,a.fylx union select  "
				+ " nvl(sum(a.je),0)as je,to_char(a.fssj,'yyyy-MM')as lrrq,'hj' as fylx,'100110'as ksbh from y_cw_cbmx a "
				+ " where to_char (a.fssj,'yyyy-MM') between '"+ksyf+"' and '"+jsyf+"'  and a.ksbh = '100110' group by a.fssj)b on a.ksbh = b.ksbh and a.fylx =b.fylx "
				+ " group by a.ksbh,a.bmmc,a.fylx ";
		sql =" select * from( select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str17+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str1+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str2+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str3+")c group by c.ksbh,c.bmmc union "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str4+")c group by c.ksbh,c.bmmc union "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str5+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str6+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str7+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str8+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str9+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str10+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str11+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str12+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str13+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str14+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str15+")c group by c.ksbh,c.bmmc union  "
				+ " select c.ksbh,c.bmmc,(to_char((100*sum(decode(c.fylx,'gzxj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gzxj, (to_char((100*sum(decode(c.fylx,'clf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clf, "
				+ " (to_char((100*sum(decode(c.fylx,'clgqj',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as clgqj, (to_char((100*sum(decode(c.fylx,'bgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as bgf,  "
				+ " (to_char((100*sum(decode(c.fylx,'jtf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%')as jtf,(to_char((100*sum(decode(c.fylx,'zdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zdf,  "
				+ " (to_char((100*sum(decode(c.fylx,'xsjd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as xsjd,(to_char((100*sum(decode(c.fylx,'px',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as pxf, "
				+ " (to_char((100*sum(decode(c.fylx,'hyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as hyf,(to_char((100*sum(decode(c.fylx,'yd',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as yd, "
				+ " (to_char((100*sum(decode(c.fylx,'wyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wyf,(to_char((100*sum(decode(c.fylx,'sdf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as sdf, "
				+ " (to_char((100*sum(decode(c.fylx,'wgf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as wgf,(to_char((100*sum(decode(c.fylx,'zlf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zlf, "
				+ " (to_char((100*sum(decode(c.fylx,'jf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jf,(to_char((100*sum(decode(c.fylx,'ywxzf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as ywxzf, "
				+ " (to_char((100*sum(decode(c.fylx,'zxf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zxf,(to_char((100*sum(decode(c.fylx,'lwf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as lwf, "
				+ " (to_char((100*sum(decode(c.fylx,'jyf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as jyf,(to_char((100*sum(decode(c.fylx,'zjf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as zjf,  "
				+ " (to_char((100*sum(decode(c.fylx,'gwycf',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as gwycf,(to_char((100*sum(decode(c.fylx,'qtfy',je,0))/replace(sum(decode(c.fylx,'hj',je,0)),'0','1')),'FM9999990.00')||'%') as qtfy, "
				+ " '100%' as hj from ("+str16+")c group by c.ksbh,c.bmmc ) order by ksbh ";


		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查看成本明细页面
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getCbmx(String ksmc,String ksyf,String jsyf) {
		String str = "";
		if (ksmc != null && !"".equals(ksmc)) {
			if(ksmc.equals("100210")||ksmc.equals("100220")||ksmc.equals("100230")||ksmc.equals("100240")||ksmc.equals("100250")||ksmc.equals("100260")||ksmc.equals("100270")){
				str = str + " and d.sjbh =" + ksmc;
			}else{
				str = str + " and a.ksbh =" + ksmc;
			}
		}
		if (ksyf != null && !"".equals(ksyf)) {
			str = str + " and to_char(a.fssj,'yyyy-MM')  between '" + ksyf +"' and '" +jsyf+ "'";
		}
		String sql ="select to_char(a.fssj,'yyyy-MM')as fssj,a.ksbh,a.pjbh,c.zdmc as fylx,a.xmmc,a.fyxq,a.je,d.bmmc from  Y_CW_CBMX a  "
				+ "left join sys_zzjg d on a.ksbh =d.id "
				+ "left join (select zdz,zdmc from sys_sjzd where zl='cblx' and jb=2) c on a.fylx=c.zdz where 1=1"+str;
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查看成本明细页面
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getBmmc(String ksmccx) {
		String sql ="select a.bmmc from sys_zzjg a where a.id=" + ksmccx;
			return jdbcTemplate.queryForList(sql);
	}

}
