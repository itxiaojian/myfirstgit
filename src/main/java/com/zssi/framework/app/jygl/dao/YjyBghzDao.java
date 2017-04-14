package com.zssi.framework.app.jygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.model.YbgYqjl;
import com.zssi.framework.app.jygl.model.YjyBgfy;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;


/**
 * 报告的汇总
 * @author oufeng
 * @date 2016年5月23日
 */
@Repository
public class YjyBghzDao  extends HibernateBaseDaoImpl<YjyBgfy, Integer>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
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
			str=str+" and a.jyks='"+user.getBmbh()+"' ";
		}else if(jsbm.size()!=0){
			str=str+" and a.jyks in (SELECT z.jyksbh FROM SYS_JGLSGX z where z.jszxbh='"+user.getBmbh()+"') ";
		}
		return str;
	}
	
	/**
	 * 后台：检验信息
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @param canshu  条件查询参数
	 * @return
	 */
	public Pagination<Map<String, Object>> getBgxxList(Integer start, Integer limit,String starttime,String endtime,String jylx,String canshu){
		String str="";
		String abc="";
		//str+=this.getBmxx1(str);
		if(jylx!=null&&!"".equals(jylx)){
			str+=" and b.zdz = '"+jylx+ "'";
		}
		if(starttime!=null&&!"".equals(starttime)){
			str+=" and to_char(a.djsj,'yyyy-MM-dd') >= '"+starttime.substring(0,10)+ "'";
		}
		if(endtime!=null&&!"".equals(endtime)){
			str+=" and to_char(a.djsj,'yyyy-MM-dd') <= '"+endtime.substring(0,10)+ "'";
		}
		if(canshu!=null&&!"".equals(canshu)){
			str+=" and (a.jyyj like  '%"+canshu+ "%') ";
		}
		str=abc+this.getBmxx(str);
		String sql =
				//"SELECT * FROM ("+
			     " SELECT X.id,x.djlx,x.ypbh,X.ypmc,X.djsj,X.wcqx,X.ypjyzt,X.qsr,X.bzr,X.shr,X.pzr,X.pzsj,X.ysfje,X.ggxh,X.jylx,X.wtdw,X.sjdw,X.scdw,X.jyjl,"
			    + " X.jyfy,X.ypyj,X.yjzt,X.bssj,X.jyyj,X.ypzt1,ROWNUM AS RN1 FROM ( SELECT X.*,rownum FROM ( select a.id,a.djlx,a.ypbh,a.ypmc,a.ggxh,a.jylx,"
				+ " to_char(a.djsj,'yyyy-MM-dd HH24:mm:ss')as djsj,to_char(a.wcqx,'yyyy-MM-dd')as wcqx,b.zdmc as ypjyzt,a.wtdw,a.sjdw,a.scdw,bxx.jyjl,a.jyyj,"
				+ " t.ASSIGNEE_ as qsr,d.xgjdry as bzr,e.shr as shr,f.xgjdry as pzr, "
		     	+ " to_char(f.shsj,'yyyy-MM-dd') as pzsj,to_char(bsj.shsj,'yyyy-MM-dd  HH:mm:ss') as bssj,g.ysfje,g.jyfy,a.ypyj,a.yjzt,a.ypjyzt as ypzt1 from y_yp_ypxx a "
				+ " left join y_jy_bgxx bxx on a.bgbh = bxx.bgbh "
			    + " left join (select a.ASSIGNEE_,a.claim_time_,a.id from(select t.ASSIGNEE_,max(t.claim_time_)as claim_time_,"
			    + " a.id from y_yp_ypxx a left join ACT_HI_PROCINST h on h.business_key_=a.id left join act_hi_taskinst t "
			    + " on t.proc_inst_ID_=h.ID_ "
			    + " where t.name_='科室主任任务分配' group by a.id,t.ASSIGNEE_)a "
    		    + " right join(select max(t.claim_time_)as claim_time_,a.id from y_yp_ypxx a left join ACT_HI_PROCINST h "
    		    + " on h.business_key_=a.id "
    		    + " left join act_hi_taskinst t on t.proc_inst_ID_=h.ID_ where t.name_='科室主任任务分配' group by  a.id)b "
    		    + " on a.id = b.id and a.claim_time_= b.claim_time_)t on t.id=a.id " 
			    + " left join(select b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb "
			    + " where shjdmc='科室主任任务分配' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t "
			    + " where t.shjdmc='科室主任任务分配' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)d on a.id = d.bgbh " 
			    + "  left join(select b.shr,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb "
			    + " where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select shr,bgbh,shsj from y_sh_yjb t "
			    + " where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)e on a.id = e.bgbh "
			    + "  left join(select a.shsj,b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb "
			    + " where shjdmc='主检科室审核人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t "
			    + " where t.shjdmc='主检科室审核人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)f on a.id = f.bgbh "
				+ "  left join(select a.shsj,b.xgjdry,b.bgbh from(select max(shsj)as shsj,bgbh from y_sh_yjb "
				+ " where shjdmc='样品主检验人员' and shzt =1 group by bgbh)a left join (select xgjdry,bgbh,shsj from y_sh_yjb t "
				+ " where t.shjdmc='样品主检验人员' and t.shzt =1)b on a.shsj = b.shsj and a.bgbh= b.bgbh)bsj on a.id = bsj.bgbh "
			    + "  left join y_cw_bgsf g on a.ypbh = g.bgbh left join (select zdz,zdmc from sys_sjzd where zl='jylx' and jb=2) b"
			    + " on to_char(a.jylx)=b.zdz "
			    + "  where 1=1 "
			    + " and a.ypjyzt > 3 and a.ypjyzt<7"
			    + "  and (g.jyfy is null or g.jyfy >=0) "+str+" order by a.wcqx ) X ) X";
			   // + "  WHERE ROWNUM <="+limit+" ) XX WHERE RN >"+start;
			return jdbcPager.queryPage(sql, start, limit);
		}
	
	/**
	 * 获取数据字典
	* @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getSx(String tabName,String tabName1) {
		String sql="select zdmc as name,zdz as code from sys_sjzd where zl='bgzd' and jb = 2 order by px ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取数据字典
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getTj() {
		String sql="select zdmc as name,zdz as code from sys_sjzd where zl='bjlb' and jb = 2 order by px ";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取状态数据字典
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getZt() {
		 String sql="select zdz as code,zdmc as name from sys_sjzd where zl='jylx' and jb=2 ";
		 return jdbcTemplate.queryForList(sql);
	}	
	
	/**
	 * 附页表是否有数据
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> hasDtaHf() {
		 String sql="select bgbh from Y_JY_BGFY group by bgbh  ";
		 return jdbcTemplate.queryForList(sql);
	}	
	
	
	/**
	 * 删除附页表信息
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public void delBgfyxx(String [] ids) {
		String str=" and bgbh in (";
		String cx="";
		if(ids.length!=0){
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				cx+="'"+ids[i]+"',";
			}else{
				cx+="'"+ids[i]+"')";
			 }
		  }
	   }else{
		cx=cx+"'')";
	}
		 String sql="delete from Y_JY_BGFY where 1=1   " +str+cx;
		 jdbcTemplate.execute(sql);
	}	
			
	/**
	 * 获取报告信息（Excel的行数）
	 * @author 
	 * @date 2016年1月11日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getBgxx(String[] ids) {
		String str=" and a.ypbh in (";
		String cx="";
		if(ids.length!=0){
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				cx=cx+"'"+ids[i]+"',";
			}else{
				cx=cx+"'"+ids[i]+"')";
			 }
		  }
	   }else{
		cx=cx+"'')";
	}
		String sql="select a.ypbh,to_char(a.djsj,'YYYY-MM-dd') as djsj,a.YPJYZT,a.ypmc||'/'||a.ggxh||'/'||a.sb "
				    + " as cmxs,nvl(a.scdw,'/') as yxqymc,'/',nvl(a.scdw,'/') as "
				    + " scqymc,nvl(SCRQPC,'/')as SCRQPC,'/' as jgjxgg "
				    + " from y_yp_ypxx a where a.ypjyzt >0 "
				    //+ "and ypbh like '%HJ%' "
				    +str+cx;
		System.out.println("sql------------------------"+sql);
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取报告的附页信息
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getBgfyxx(String[] ids) {
		String str=" and bgbh in (";
		String cx="";
		if(ids.length!=0){
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				cx=cx+"'"+ids[i]+"',";
			}else{
				cx=cx+"'"+ids[i]+"')";
			 }
		  }
	   }else{
		cx=cx+"'')";
	}
		String sql="select  xmmc,px  from Y_JY_BGFY where 1=1 "+str+cx
				+ " group by xmmc,px order by px";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取报告的附页信息
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getBgfyxx1(String[] ids) {
		String str=" and bgbh in (";
		String cx="";
		if(ids.length!=0){
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				cx=cx+"'"+ids[i]+"',";
			}else{
				cx=cx+"'"+ids[i]+"')";
			 }
		  }
	   }else{
		cx=cx+"'')";
	}
		String sql="select  xmmc,jsyq,jyjg,dxpd,px,bgbh  from Y_JY_BGFY where 1=1 "+str+cx
				+ " group by xmmc,jsyq,jyjg,dxpd,px,bgbh order by px";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取报告的附页的动态的表格信息
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param tabName
	 * @return
	 */
	public List<Map<String, Object>> getBgxmList(String bgbh, List<Map<String, Object>> list) {
		 Map<String, Object> map= new HashMap<String, Object>();
		String str="";
		String xmmc="";
		if(list.size()!=0){
		    for(int i=0;i<list.size();i++){
		    	map= (Map<String,Object>) list.get(i);	
		    	xmmc=map.get("xmmc")+"";
		    	if(i<list.size()-1){
		    	     str += " nvl(max(case when xmmc ='"+xmmc+"'  then jsyq end),0) as jsyq"+i+","
		    	     		+ "nvl(max(case when xmmc ='"+xmmc+"'  then jyjg end),0) as jyjg"+i+","
		    	     		+ "nvl(max(case when xmmc ='"+xmmc+"'  then dxpd end),0) as dxpd"+i+",";
		    	  }else{
		    		  str += " nvl(max(case when xmmc ='"+xmmc+"'  then jsyq end),0) as jsyq"+i+","
			    	     		+ "nvl(max(case when xmmc ='"+xmmc+"'  then jyjg end),0) as jyjg"+i+","
			    	     		+ "nvl(max(case when xmmc ='"+xmmc+"'  then dxpd end),0) as dxpd"+i+"";
		    	}
		    }
		}
		
		String sql="select bgbh,"+str+" from  Y_JY_BGFY where bgbh = '"+bgbh+"' group by bgbh";
		return jdbcTemplate.queryForList(sql);
	}
}
