package com.zssi.framework.app.sjbb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.cwgl.model.YcwYgfl;

//员工福利统计dao层
//liusong 2015-12-30
@Repository
public class YgfltjDao extends HibernateBaseDaoImpl<YcwYgfl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/** 
	 * 下拉框查询福利类型
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 下拉框查询福利类型
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getSfr() {
		String sql =" select a.yhbh,a.xm from sys_yh a where a.yhbh in (select b.yhbh from sys_yhjs b where b.jsbh in(402,243)) ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 下拉框查询科室名称
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getKsmc() {
		String sql =" select a.id,a.bmmc from sys_zzjg a where a.bmbh not in('100130','100','101') order by a.id";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 查询福利类型
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getFltj() {
		String sql =" select a.bmmc,h.ks_id,h.ssyf,h.flmc,nvl(l.je,0)as je from(select a.id as ks_id,"
				+ " nvl(b.ssyf,to_char(sysdate,'yyyy-MM'))as ssyf,c.zdmc as flmc from sys_zzjg a,y_cw_ygfl b,"
				+ " sys_sjzd c where a.id = b.ks_id(+)and a.id not in(100,101,100130)and c.zl = 'fllx' and c.jb=2)h,"
				+ " (select nvl(sum(a.je),0)as je,nvl(a.ssyf,to_char(sysdate,'yyyy-MM'))as ssyf,a.flmc,b.ks_id "
				+ " from y_cw_ygflmx a,y_cw_ygfl b where a.ygxm = b.ygxm group by a.ssyf,b.ks_id,a.flmc)l,"
				+ " sys_zzjg a where h.flmc =l.flmc(+) and h.ks_id = l.ks_id(+) and h.ssyf = l.ssyf(+)"
				+ " and h.ks_id = a.id order by h.ks_id ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 查询福利汇总
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getFlhz(String ksmc,String ssyf) {
		String str = "";
		String str1= "";
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
		if (ssyf != null && !"".equals(ssyf)) {
		str1 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100130'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id = '100130' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100130'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id = '100130' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		
		str2 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100210'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100210' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100210%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100210'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100210%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str3 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100210___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100210___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100210___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		
		str4 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100220'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100220' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100220%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100220'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100220%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str5 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100220___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100220___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100220___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		
		str6 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100230'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100230' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100230%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100230'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100230%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str7 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100230___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100230___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100230___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		
		str8 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100240'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100240' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100240%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100240'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100240%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str9 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100240___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100240___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100240___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		
		str10 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100250'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100250' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100250%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100250'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100250%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str11 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100250___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100250___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100250___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
			
		str12 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100260'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100260' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100260%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100260'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100260%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str13 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100260___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100260___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100260___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
			
		str14 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100270'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100270' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100270%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100270'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100270%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str15 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id like '100270___'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,a.ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100270___' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "a.ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100270___' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		
		str16 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100280'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100280' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100280%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100280'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100280%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		str17 =  "  select a.ks_id,a.flmc,nvl(b.ssyf,'"+ ssyf +"')as ssyf,nvl(b.je,0)as je from (select a.id as ks_id,b.zdz as flmc from sys_zzjg a,sys_sjzd b "
		    + " where a.id ='100110'and b.zl = 'fllx' and b.jb in(2,3) "+ strz +" order by a.id)a left join (select nvl(sum(a.flhj),0)as je,a.ssyf,a.gzxjmc as flmc,'100110' as ks_id from y_cw_ygfl a "
		    + " where 1=1 and a.ssyf  ='" + ssyf + "'and a.ks_id like '100110%' group by a.ks_id,a.gzxjmc,a.ssyf union select nvl(sum(a.flhj),0)as je,a.ssyf,'hj' as flmc,"
		    + "'100110'as ks_id from y_cw_ygfl a where a.ssyf='" + ssyf + "' and a.ks_id like '100110%' group by a.ssyf,a.ks_id )b on a.ks_id = b.ks_id and a.flmc = b.flmc";
		sql =" select * from(SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str17+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str1+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str2+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str3+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str4+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str5+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str6+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str7+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str8+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str9+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str10+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str11+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str12+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str13+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str14+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str15+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc union "
			+ " SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
			+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
			+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
			+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str16+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc) order by ks_id  ";
		}else if(ssyf == null || "".equals(ssyf)){
	    str = str +" select a.ks_id,b.flmc,b.ssyf,nvl(b.je,0)as je from(select nvl(sum(a.je),0)as je,a.ssyf,a.flmc,a.ks_id from y_cw_ygflmx a "
	    		+ " group by a.ks_id,a.flmc,a.ssyf)b";
		 sql =" SELECT d.bmmc,c.ks_id,c.ssyf,SUM(DECODE(c.flmc,'gz',je,0)) AS gz,SUM(DECODE(c.flmc,'gwjxgz',je,0)) AS gwjxgz,SUM(DECODE(c.flmc,'jfjxgz',je,0)) AS "
				+ " jfjxgz,SUM(DECODE(c.flmc,'dbj',je,0)) AS dbj, SUM(DECODE(c.flmc,'shbyf',je,0)) AS shbyf,SUM(DECODE(c.flmc,'gjj',je,0)) AS gjj, "
				+ " SUM(DECODE(c.flmc,'jtff',je,0)) AS jtff,SUM(DECODE(c.flmc,'txf',je,0)) AS txf, SUM(DECODE(c.flmc,'wcf',je,0)) AS wcf,SUM(DECODE(c.flmc,'qtfl',je,0)) "
				+ " AS qtfl,SUM(DECODE(c.flmc,'hj',je,0)) AS hj FROM ("+str+")c left join sys_zzjg d on c.ks_id = d.id GROUP by c.ks_id,c.ssyf,d.bmmc ORDER by c.ks_id ";
		}
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/** 
	 *查询科室收入统计
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getKssrtj(String srfl,String cxsjstr,String cxsjend) {
		String str = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		if(srfl!=null&&!"".equals(srfl)){
			str=str+" and b.srfl = '"+ srfl+"'";
			str1 = str1+" and b.srfl = '"+ srfl+"'";
			str3 = str3+" and b.srfl = '"+ srfl+"'";
			}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(b.jyjsrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
				str1=str1+" and to_char(b.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
				str2=str2+" and to_char(b.jsrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
				str3=str3+" and to_char(b.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(b.jyjsrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				str1=str1+" and to_char(b.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				str2=str2+" and to_char(b.jsrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				str3=str3+" and to_char(b.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(b.jyjsrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				str1=str1+" and to_char(b.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				str2=str2+" and to_char(b.jsrq,'yyyy-MM-dd') = '"+cxsjend+"' ";
				str3=str3+" and to_char(b.sfrq,'yyyy-MM-dd') = '"+cxsjend+"' ";
				}
			}
		String sql ="   select a.px,bmlx,a.bmbh,b.bmmc,nvl(bgysk,0)as jysfysk,nvl(nwysk,0)as nwysk,nvl(bgysf,0)as jysfysf,nwysf,nvl(xyysk,0)as jsfwysk,nvl(xyysf,0)as jsfwysf,nvl(glbmsf,0)as glbmsf " 
				 + "from(select 1 as px,'100500'as bmlx,a.id as bmbh,bgysk,bgysf,xyysk,xyysf,nwysk,0 as nwysf,0 as glbmsf  "
		         + "from sys_zzjg a left join (select b.ks_id,sum(b.jyfy)as bgysk from y_cw_bgsf b where b.jyfy >=0 "+str+" group by b.ks_id )b on a.id = b.ks_id "
		         + "left join (select b.ks_id,sum(b.bcss)as bgysf from y_cw_bgsfjl b where 1=1 "+str+" group by b.ks_id )e on a.id = e.ks_id  "
		         + "left join (select b.jyks_id,sum(b.xyje)as xyysk from y_cw_jsfwxysf b where 1=1 "+str1+" group by b.jyks_id )c on a.id = c.jyks_id "
		         + "left join (select b.jyks_id,sum(b.bcss)as xyysf from y_cw_fwxysfjl b where 1=1 "+str1+" group by b.jyks_id )f on a.id = f.jyks_id "
		         + "left join (select b.cjbm,sum(b.jyfy)as nwysk from Y_JY_NWGL b where 1=1 "+str2+" group by b.cjbm  )d on a.id = d.cjbm where a.sjbh='100250' "
		         + "union select 2 as px,'100500'as bmlx,a.bmbh,bgysk,bgysf,xyysk,xyysf,c.nwysk,0 as nwysf,0 as glbmsf  "
		         + "from(select '100250'as bmbh,sum(b.jyfy)as bgysk from y_cw_bgsf b where b.jyfy >=0 "+str+" )a "
		         + "left join (select '100250'as bmbh,sum(b.bcss)as bgysf from y_cw_bgsfjl b where 1=1 "+str+" )e on a.bmbh = e.bmbh "
		         + "left join(select'100250'as bmbh,sum(b.xyje)as xyysk from y_cw_jsfwxysf b where 1=1 "+str1+" )b  on a.bmbh =b.bmbh "
         		 + "left join(select'100250'as bmbh,sum(b.bcss)as xyysf from y_cw_fwxysfjl b where 1=1 "+str1+" )f on a.bmbh = b.bmbh "
		         + "left join(select'100250'as bmbh,sum(b.jyfy) as nwysk from Y_JY_NWGL b where 1=1 "+str2+" )c  on a.bmbh = c.bmbh "
		         + "union select 3 as px,'100200'as bmlx,a.id as bmbh,bgysk,bgysf,xyysk,xyysf,0 as nwysk,0 as nwysf,0 as glbmsf " 
		         + "from sys_zzjg a left join (select b.ssywks,sum(b.jyfy)as bgysk from y_cw_bgsf b where b.jyfy >=0 "+str+" group by b.ssywks )b on a.id = b.ssywks "
		         + "left join (select b.ssywks,sum(b.bcss)as bgysf from y_cw_bgsfjl b where 1=1 "+str+" group by b.ssywks )e on a.id = e.ssywks  "
		         + " left join (select b.ywks_id,sum(b.xyje)as xyysk from y_cw_jsfwxysf b where 1=1 "+str1+" group by b.ywks_id  )c on a.id = c.ywks_id "
         		 + " left join (select b.ywks_id,sum(b.bcss)as xyysf from y_cw_fwxysfjl b where 1=1 "+str1+" group by b.ywks_id  )f on a.id = f.ywks_id where a.sjbh = '100230' "
		         + "union select 4 as px,'100200'as bmlx,a.bmbh,bgysk,bgysf,xyysk,xyysf,0 as nwysk,0 as nwysf,0 as glbmsf "
		         + "from(select '100230'as bmbh,sum(b.jyfy)as bgysk from y_cw_bgsf b where b.jyfy >=0 "+str+" )a  "
		         + "left join (select '100230'as bmbh,sum(b.bcss)as bgysf from y_cw_bgsfjl b where 1=1 "+str+" )e on a.bmbh = e.bmbh "
		         + "left join(select'100230'as bmbh,sum(b.xyje)as xyysk from y_cw_jsfwxysf b where 1=1 "+str1+" )b  on a.bmbh =b.bmbh  "
         		 + "left join(select'100230'as bmbh,sum(b.bcss)as xyysf from y_cw_fwxysfjl b where 1=1 "+str1+" )f  on a.bmbh =f.bmbh "
		         + "union select 5 as px,'100400'as bmlx,f.bmbh,sum(f.bgysk)as bgysk,sum(f.bgysf)as bgysf,sum(f.xyysk)as xyysk,sum(f.xyysf)as xyysf,sum(f.nwysk)as nwysk,0 as nwysf,0 as glbmsf from "
		         + "(select a.jszxbh as bmbh,bgysk,bgysf,xyysk,xyysf,nwysk,0 as nwysf,0 as glbmsf  "
		         + "from SYS_JGLSGX a left join(select b.ks_id,sum(b.jyfy)as bgysk from y_cw_bgsf b where b.jyfy >=0 "+str+" group by b.ks_id)b on a.jyksbh = b.ks_id "
		         + "left join (select b.ks_id,sum(b.bcss)as bgysf from y_cw_bgsfjl b where 1=1 "+str+" group by b.ks_id )e on a.jyksbh = e.ks_id  "
		         + "left join(select b.jyks_id,sum(b.xyje)as xyysk from y_cw_jsfwxysf b where 1=1 "+str1+" group by b.jyks_id )c on a.jyksbh = c.jyks_id "
         		 + "left join(select b.jyks_id,sum(b.bcss)as xyysf from y_cw_fwxysfjl b where 1=1 "+str1+" group by b.jyks_id )f on a.jyksbh = f.jyks_id "
		         + "left join(select b.cjbm,sum(b.jyfy)as nwysk from Y_JY_NWGL b where 1=1 "+str2+" group by b.cjbm)d on a.jyksbh=d.cjbm)f group by f.bmbh "
		         + "union select 6 as px,'100400'as bmlx,a.bmbh,bgysk,bgysf,xyysk,xyysf,nwysk,0 as nwysf,0 as glbmsf  "
		         + "from(select'100240'as bmbh,sum(b.jyfy)as bgysk from y_cw_bgsf b where b.jyfy >=0 "+str+" )a  "
		         + "left join (select '100240'as bmbh,sum(b.bcss)as bgysf from y_cw_bgsfjl b where 1=1 "+str+" )e  on a.bmbh = e.bmbh "
		         + "left join(select '100240'as bmbh,sum(b.xyje)as xyysk from y_cw_jsfwxysf b where 1=1 "+str1+" )b  on a.bmbh =b.bmbh  "
		         + "left join(select '100240'as bmbh,sum(b.bcss)as xyysf from y_cw_fwxysfjl b where 1=1 "+str1+" )f  on a.bmbh =f.bmbh "
		         + "left join(select '100240'as bmbh,sum(b.jyfy) as nwysk from Y_JY_NWGL b where 1=1 "+str2+" )c  on a.bmbh = c.bmbh "
		         + "union select 7 as px,'100700'as bmlx,a.id as bmbh,0 as bgysk,0 as bgysf,0 as xyysk,0 as xyysf,0 as nwysk,0 as nwysf,glbmsf  "
		         + "from sys_zzjg a left join (select b.bmbh,sum(b.sfje)as glbmsf from y_cw_glbmsf b where 1=1 "+str3+" group by b.bmbh)b on a.id =b.bmbh where a.sjbh in"
		         + "('100210','100220','100260','100270') or a.bmbh in('100210','100220','100260','100270','100280' ) "
		         + "union select 8 as px,'100700'as bmlx,'100210'as ksmc,0 as bgysk,0 as bgysf,0 as xyysk,0 as xyysf,0 as nwysk,0 as nwysf,sum(b.sfje) as glbmsf  "
		         + "from y_cw_glbmsf b where 1=1 "+str3+" )a left join sys_zzjg b  on a.bmbh = b.id order by a.px,b.id ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 查询报告收费记录
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getBgsfjl(String srfl,String sfr,String cxsjstr,String cxsjend,String jyks,String ywks) {
		String str = "";
		if(srfl!=null&&!"".equals(srfl)){
			str=str+" and a.srfl = '"+ srfl+"'";
			}
		if(sfr!=null&&!"".equals(sfr)){
			str=str+" and d.yhbh = '"+sfr+"'";
			}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		if(jyks!=null&&!"".equals(jyks)){
			str=str+" and a.ks_id = '"+jyks+"'";
			}
		if(ywks!=null&&!"".equals(ywks)){
			str=str+" and a.ssywks = '"+ywks+"'";
			}
		String sql =" select * from(select a.bgbh,e.sjdw,e.scdw,e.wtdw,a.ypmc,b.bmmc as ks_id,c.bmmc as ssywks,a.jyfy,a.ysje,a.ysfje,a.bcss,a.pjhm,a.srfl,d.xm as sfr,to_char(a.jyjsrq,'yyyy-MM-dd hh24:mi:ss') as jyjsrq "
				+ "from y_cw_bgsfjl a left join sys_zzjg b on a.ks_id =b.id "
				+ "left join sys_zzjg c  on a.ssywks=c.id left join y_yp_ypxx e on a.bgbh =e.ypbh "
				+ "left join sys_yh d on a.sfr = d.xm where 1=1 "+str+" union select  '查询结果合计'as bgbh,'/' as sjdw,'/' as scdw,'/' as wtdw,'/'as ypmc,'/' as ks_id,'/' as ssywks,nvl(sum(a.jyfy),0)as jyfy,nvl(sum(a.ysje),0)as ysje,nvl(sum(a.ysfje),0)as ysfje,"
			    + "nvl(sum(a.bcss),0)as bcss,'/'as pjhm,'/'as srfl,'/' as sfr,'/' as jyjsrq  "
				+ "from y_cw_bgsfjl a left join sys_zzjg b on a.ks_id =b.id "
				+ "left join sys_zzjg c  on a.ssywks=c.id "
				+ "left join sys_yh d on a.sfr = d.xm where 1=1 "+str+" )a order by a.jyjsrq desc ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 查询协议收费记录
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getXysfjl(String sfr,String cxsjstr,String cxsjend,String jyks,String ywks) {
		String str = "";
		if(sfr!=null&&!"".equals(sfr)){
			str=str+" and d.yhbh = '"+sfr+"'";
			}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		if(jyks!=null&&!"".equals(jyks)){
			str=str+" and a.jyks_id = '"+jyks+"'";
			}
		if(ywks!=null&&!"".equals(ywks)){
			str=str+" and a.ywks_id = '"+ywks+"'";
			}
		String sql =" select * from(select a.xybh,e.khmc,b.bmmc as jyks_id,c.bmmc as ywks_id,a.xyje,a.ysje,a.ysfje,a.bcss,a.pjhm,d.xm as sfr,to_char(a.sfrq,'yyyy-MM-dd hh24:mi:ss') as sfrq from y_cw_fwxysfjl a "
				+ " left join sys_zzjg b on a.jyks_id = b.id left join sys_zzjg c on a.ywks_id = c.id left join sys_yh d on a.sfr = d.xm left join y_cw_jsfwxysf e on a.xybh = e.xybh where 1=1 "+str+" union  "
			    + " select '查询结果合计' as xybh,'/' as khmc,'/' as jyks_id,'/' as ywks_id,nvl(sum(a.xyje),0)as xyje,nvl(sum(a.ysje),0)as ysje,nvl(sum(a.ysfje),0)as ysfje,nvl(sum(a.bcss),0)as bcss,'/'as pjhm, "
			    + " '/' as sfr,'/' as sfrq from y_cw_fwxysfjl a left join sys_yh d on a.sfr = d.xm where 1=1 "+str+" )a order by a.sfrq desc ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/** 
	 * 查询管理收费记录
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String, Object>> getGlsfjl(String sfr,String srfl,String cxsjstr,String cxsjend,String glbm) {
		String str = "";
		if(srfl!=null&&!"".equals(srfl)){
			str=str+" and a.srfl = '"+ srfl+"'";
			}
		if(sfr!=null&&!"".equals(sfr)){
			str=str+" and c.yhbh = '"+sfr+"'";
			}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		if(glbm!=null&&!"".equals(glbm)){
			str=str+" and a.glbm = '"+glbm+"'";
			}
		String sql =" select * from(select b.bmmc as bmbh,a.fphm,a.srfl,a.sfxmmc,a.sfje,a.pjhm,c.xm as sfr,to_char(a.sfrq,'yyyy-MM-dd hh24:mi:ss') as sfrq from y_cw_glbmsf a "
				+ " left join sys_zzjg b on a.bmbh = b.id left join sys_yh c on a.sfr = c.xm where 1=1 "+str+" union select '查询结果合计' as bmbh,'/'as fphm,'/'as srfl,'/'as sfxmmc, "
			    + "nvl(sum(a.sfje),0)as sfje,'/'as pjhm,'/' as sfr,'/' as sfrq from y_cw_glbmsf a "
				+ " left join sys_yh c on a.sfr = c.xm where 1=1 "+str+" )a order by a.sfrq desc ";
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 查看员工福利明细页面
	 * @author wangyong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> getYgflmx(String ksmc,String ssyf) {
		String str = "";
		if (ksmc != null && !"".equals(ksmc)) {
			if(ksmc.equals("100210")||ksmc.equals("100220")||ksmc.equals("100230")||ksmc.equals("100240")||ksmc.equals("100250")||ksmc.equals("100260")||ksmc.equals("100270")){
				str = str + " and d.sjbh =" + ksmc;
			}else{
				str = str + " and a.ks_id =" + ksmc;
			}
		}
		if (ssyf != null && !"".equals(ssyf)) {
			str = str + " and a.ssyf ='" + ssyf + "'";
		}
		String sql ="select a.ssyf,c.zdmc as flmc,a.flxq,a.je,a.ks_id from Y_CW_YGFLMX a  "
				+ "left join (select zdz,zdmc from sys_sjzd where zl='fllx' and jb=2) c on a.flmc=c.zdz "
				+ "left join sys_zzjg d on a.ks_id = d.bmbh where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检验科室报告收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jyksbgsfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.ks_id = '" + ksmccx+"'";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql =" select a.bgbh,a.ypmc,a.jyfy,nvl(a.bcss,0)as ysfje,to_char(a.jyjsrq,'yyyy-MM-dd hh24:mi:ss') as jyjsrq,b.wtdw,b.jylx,c.bsdx,d.xm from Y_CW_BGSFJL a left join "
				+ " y_yp_ypxx b on a.bgbh = b.ypbh left join y_jy_bgxx c on a.bgbh = c.bgbh left join sys_yh d on c.bzr = d.yhbh where 1=1 and a.jyfy!=0 "+str+" order by a.bgbh";
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检验科室协议收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jyksxysfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.jyks_id ='" + ksmccx+"'";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.xybh,b.khmc,a.xyje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd hh24:mi:ss')as sfrq from Y_CW_FWXYSFJL a left join Y_CW_JSFWXYSF b "
				+ " on a.xybh = b.xybh where 1=1 "+str+" order by a.xybh";
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 检验科室内委管理收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> nwglmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and b.cjbm ='" + ksmccx+"'";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(b.wtrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(b.wtrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(b.wtrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.bgbh, a.ypmc,a.jyxm,a.jyfy,c.bmmc as wtbm,to_char(b.wtrq,'yyyy-MM-dd hh24:mi:ss')as wtrq,b.jbr,b.jsr from y_jy_nwmx a left join "
				+ " y_jy_nwgl b on a.nwbh = b.id left join sys_zzjg c on b.wtbm = c.id where b.jyfy !=0 "+str+" order by a.bgbh ";
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 技术中心内委管理收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jszxnwmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and b.cjbm in(select a.jyksbh from sys_jglsgx a where 1=1 and a.jszxbh ='"+ksmccx+"') ";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(b.wtrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(b.wtrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(b.wtrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.bgbh, a.ypmc,a.jyxm,a.jyfy,c.bmmc as wtbm,b.wtrq,d.bmmc as cjbm,b.jbr,b.jsr from y_jy_nwmx a left join y_jy_nwgl b on "
			+" a.nwbh = b.id left join sys_zzjg c on b.wtbm = c.id left join sys_zzjg d on b.cjbm = d.id where b.jyfy !=0 "+str+" order by a.bgbh ";
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 业务科室报告收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> ywksbgsfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.ssywks ='" + ksmccx+"'";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.bgbh,a.ypmc,a.jyfy,nvl(a.bcss,0)as ysfje,to_char(a.jyjsrq,'yyyy-MM-dd hh24:mi:ss') as jyjsrq,b.wtdw,b.jylx,c.bsdx,d.xm from Y_CW_BGSFJL a left join "
				+ " y_yp_ypxx b on a.bgbh = b.ypbh left join y_jy_bgxx c on a.bgbh = c.bgbh left join sys_yh d on c.bzr = d.yhbh where 1=1 and a.jyfy!=0 "+str+" order by a.bgbh";
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 业务科室协议收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> ywksxysfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.ywks_id = '"+ ksmccx+"'";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.xybh,b.khmc,a.xyje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd hh24:mi:ss')as sfrq from Y_CW_FWXYSFJL a left join Y_CW_JSFWXYSF b "
				+ " on a.xybh = b.xybh where 1=1 "+str+" order by a.xybh";	
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 技术中心报告收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jszxbgsfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.ks_id in (select b.jyksbh from sys_jglsgx b where b.jszxbh='"+ksmccx+"')";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.jyjsrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.bgbh,a.ypmc,a.jyfy,nvl(a.bcss,0)as ysfje,to_char(a.jyjsrq,'yyyy-MM-dd hh24:mi:ss')as jyjsrq,b.wtdw,b.jylx,c.bsdx,d.xm,e.bmmc from Y_CW_BGSFJL a "
				+ " left join y_yp_ypxx b on a.bgbh = b.bgbh left join y_jy_bgxx c on a.bgbh = c.bgbh left join sys_yh d on c.bzr = d.yhbh left join sys_zzjg e on "
				+ " a.ks_id = e.id where 1=1 and a.jyfy != 0 "+str+" order by a.bgbh ";
			return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 技术中心协议收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> jszxxysfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.jyks_id in (select b.jyksbh from sys_jglsgx b where b.jszxbh='"+ksmccx+"')";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql ="select a.xybh,b.khmc,a.xyje,a.ysfje,a.bcss,to_char(a.sfrq,'yyyy-MM-dd hh24:mi:ss')as sfrq,c.bmmc from Y_CW_FWXYSFJL a left join Y_CW_JSFWXYSF b "
				+ " on a.xybh = b.xybh left join sys_zzjg c on a.jyks_id = c.id where 1=1 "+str+" order by a.xybh";	
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 技术中心协议收费详细查询
	 * @author liusong
	 * @date 2016年1月20日
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Map<String, Object>> glbmsfmx(String ksmccx,String cxsjstr,String cxsjend) {
		String str = "";
		if (ksmccx != null && !"".equals(ksmccx)) {
			str = str + " and a.bmbh ='" + ksmccx+"'";
		}
		if(cxsjstr!=null&&!"".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') between '"+cxsjstr+ "'and'"+cxsjend+ "' ";
			}else if(cxsjend == null||"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjstr+"' ";
				}
			}
		if(cxsjstr == null || "".equals(cxsjstr)){
			if(cxsjend!=null&&!"".equals(cxsjend)){
				str=str+" and to_char(a.sfrq,'yyyy-MM-dd') = '"+cxsjend+ "' ";
				}
			}
		String sql =" select b.bmmc,a.sfje,to_char(a.sfrq,'yyyy-MM-dd hh24:mi:ss')as sfrq,a.fphm,a.srfl,a.bz from Y_CW_GLBMSF a left join sys_zzjg b on a.bmbh=b.id where 1=1 "+str+" order by a.sfrq desc ";
			return jdbcTemplate.queryForList(sql);
	}
	
}
