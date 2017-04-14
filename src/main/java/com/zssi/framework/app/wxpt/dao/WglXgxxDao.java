package com.zssi.framework.app.wxpt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.wxpt.model.GlSqxx;

/**
*微管理
@Author oufeng	
@Date 2015年12月15日 上午10:56:30
@Version 1.0
*/
@Repository
public class WglXgxxDao  extends HibernateBaseDaoImpl<GlSqxx, String>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;

	/**
	 * 根据openId获取绑定用户的信息
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param openId 
	 * @return
	 */
	public List<Map<String,Object>> getUser(String openId){
		String sql="SELECT a.wxnc, a.wxh,b.xm,b.dlm,a.yhid FROM sys_wxyh a "
				+ "left join sys_yh b on a.yhid=b.yhbh where a.zt='1' and a.wxh='"+openId+"'";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取审核人
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param openId 
	 * @return
	 */
	public List<Map<String,Object>> getShr(){
		String sql="select yhbh,xm from sys_yh group by yhbh,xm";
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 需要我审批的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @return
	 */
	public List<Map<String,Object>> getXwdsqList(String yhbh,String time){
		String str="";
		String str1="";
		String sql="";
		//List<Map<String,Object>> yh=this.getYh(yhbh);
		if(yhbh!=null && !"".equals(yhbh)){
			str+=" and shr='"+yhbh+"'";
		}
		if(time!=null && !"".equals(time)){
			str1+=" and to_char(sjsj,'yyyy-mm-dd')='"+time+"'";
		}
		String dlm = this.getYh(yhbh).get(0).get("dlm").toString();
		if(dlm!=null && !"".equals(dlm)&& "admin".equals(dlm)){
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
		    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
			+ "  left join sys_yh  c on a.shr = c.yhbh"
			+ "  left join sys_yh d on a.csr = d.yhbh"
			+ "  where 1=1 and a.wpzt=1 "+str1;
		}else{
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
				    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
		            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
		            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
		 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
					+ "  left join sys_yh  c on a.shr = c.yhbh"
					+ "  left join sys_yh d on a.csr = d.yhbh"
					+ "  where 1=1 and a.wpzt=1 "+str+str1;
		}
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 我的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @return
	 */
	public List<Map<String,Object>> getWdsqList(String yhbh,String time){
		String str="";
		String str1="";
		String sql="";
		//List<Map<String,Object>> yh=this.getYh(yhbh);
		if(yhbh!=null && !"".equals(yhbh)){
			str+=" and sqr='"+yhbh+"'";
		}
		if(time!=null && !"".equals(time)){
			str1+=" and to_char(sjsj,'yyyy-mm-dd')='"+time+"'";
		}
		String dlm = this.getYh(yhbh).get(0).get("dlm").toString();
		if(dlm!=null && !"".equals(dlm)&& "admin".equals(dlm)){
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
		    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
			+ "  left join sys_yh  c on a.shr = c.yhbh"
			+ "  left join sys_yh d on a.csr = d.yhbh"
			+ "  where 1=1 "+str1;
		}else{
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
				    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
		            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
		            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
		 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
					+ "  left join sys_yh  c on a.shr = c.yhbh"
					+ "  left join sys_yh d on a.csr = d.yhbh"
					+ "  where 1=1 "	+str+str1;
				
		}
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 抄送给我的申请
	 * @author oufeng
	 * @date 2015年12月15日
	 * @return
	 */
	public List<Map<String,Object>> getCswdsqList(String yhbh,String time){
		String str="";
		String str1="";
		String sql="";
		//List<Map<String,Object>> yh=this.getYh(yhbh);
		if(yhbh!=null && !"".equals(yhbh)){
			str+=" and csr='"+yhbh+"'";
		}
		if(time!=null && !"".equals(time)){
			str1+=" and to_char(sjsj,'yyyy-mm-dd')='"+time+"'";
		}
		String dlm = this.getYh(yhbh).get(0).get("dlm").toString();
		if(dlm!=null && !"".equals(dlm)&& "admin".equals(dlm)){
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
		    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
			+ "  left join sys_yh  c on a.shr = c.yhbh"
			+ "  left join sys_yh d on a.csr = d.yhbh"
			+ "  where 1=1 and a.wpzt=1 "+str1;
		}else{
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
				    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
		            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
		            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
		 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
					+ "  left join sys_yh  c on a.shr = c.yhbh"
					+ "  left join sys_yh d on a.csr = d.yhbh"
					+ "  where 1=1 and a.wpzt=1 "+str+str1;
		}
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 我可以查看的工作汇报
	 * @author panweichi
	 * @date 2015年12月29日
	 * @return
	 */
	public List<Map<String,Object>> getCsgzhbList(String yhbh){
		String str="";
		String sql="";
		//List<Map<String,Object>> yh=this.getYh(yhbh);
		if(yhbh!=null && !"".equals(yhbh)){
			str+=" and hbr='"+yhbh+"'";
		}
		String dlm = this.getYh(yhbh).get(0).get("dlm").toString();
		if(dlm!=null && !"".equals(dlm)&& "admin".equals(yhbh)){
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
		    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
			+ "  left join sys_yh  c on a.shr = c.yhbh"
			+ "  left join sys_yh d on a.csr = d.yhbh"
			+ "  where 1=1 and a.wpzt=1 ";
		}else{
			sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
				    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
		            + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
		            + "  when a.wpzt=3 then '不通过' end as ztmc,to_char(sqrq,'yyyy-mm-dd')as sqrq "
		 			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
					+ "  left join sys_yh  c on a.shr = c.yhbh"
					+ "  left join sys_yh d on a.csr = d.yhbh"
					+ "  where 1=1 and a.wpzt=1 "+str;
		}
		return jdbcTemplate.queryForList(sql);
	}
	
	
	/**
	 * 获取用户信息
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param id 用户Id
	 * @return
	 */
	public List<Map<String,Object>> getYh(String id){
		String str="";
		if(id!=null&&!"".equals(id)){
			str=str+" and yhbh='"+id+"'";
		}
		String sql="select dlm from sys_yh where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 * 我的申请的详情
	 * @author oufeng
	 * @date 2015年12月15日
	 * @return
	 */
	public List<Map<String,Object>> getWdsqDetail(String id){
	String str="";
	//List<Map<String,Object>> yh=this.getYh(yhbh);
	if(id!=null && !"".equals(id)){
		str+=" and sqid='"+id+"'";
	}
	String sql=" select   sqid,sqmc,sqlx,sqnr,sqr, b.xm as sqrxm ,to_char(sqrq,'yyyy-mm-dd')as sqrq,"
	    + " wpzt,to_char(sjsj,'yyyy-mm-dd')as sjsj,"
	    + "  to_char(xjsj,'yyyy-mm-dd')as xjsj, bz,csr,shr,c.xm as shrxm ,shyj ,d.xm as csrxm,"
        + "  case when a.wpzt=1 then '待审批'  when a.wpzt=2 then  '通过'  "
        + "  when a.wpzt=3 then '不通过' end as ztmc"
			+ " FROM W_GL_SQXX a left join sys_yh b  on  a.sqr = b.yhbh "
		+ "  left join sys_yh  c on a.shr = c.yhbh"
		+ "  left join sys_yh d on a.csr = d.yhbh"
		+ "  where 1=1 "+str;
	 return jdbcTemplate.queryForList(sql);
}
	
	/**
	 * 申请的通过
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param id 用户Id
	 * @return
	 */
	public void updateSqxxtg(String id,String shyj,String shr){
		String sql="update W_GL_SQXX set shyj ='"+shyj+"',shr='"+shr+"', wpzt = 2  where sqid='"+id+"'";
		jdbcTemplate.execute(sql);
	}
	
	/**
	 * 驳回
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param id 用户Id
	 * @return
	 */
	public void updateSqxxbh(String id,String shyj,String shr){
		String sql="update W_GL_SQXX set shyj ='"+shyj+"',shr='"+shr+"', wpzt = 3  where sqid='"+id+"'";
		jdbcTemplate.execute(sql);
	}
	
	/**
	 * 获取工作汇报
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param id 用户Id
	 * @return
	 */
	public List<Map<String,Object>> getHb(String openId,String time){
		String str="";
		if(time!=null&&!"".equals(time)){
			str+=" and to_char(hbrq,'yyyy-mm-dd')='"+time+"'";
		}
		String sql="select hbid,hblx,hbr,bz,b.xm as hbrxm,"
				+ " to_char(hbrq,'yyyy-mm-dd') as hbrq,c.zdmc as hblxmc "
				+ " from W_GL_GZHB a ,sys_yh b,sys_sjzd c    where"
				+ " a.hbr = b.yhbh "
				+" and a.hblx = c.zdz "
				+" and c.zl='hblx'"
				+" and c.jb=2"
				+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取工作汇报详情
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param id 用户Id
	 * @return
	 */
	public List<Map<String,Object>> getHbXq(String id){
		String str="";
		if(id!=null&&!"".equals(id)){
			str+=" and hbid ='"+id+"'";
		}
		String sql="select hbid,hblx,hbr,bz,b.xm as hbrxm,hbnr,c.zdmc as hblxmc,d.xm as jsrxm,"
				+ "  to_char(hbrq,'yyyy-mm-dd HH:mm:dd') as hbrq"
				+ "  from W_GL_GZHB a ,sys_yh b,sys_sjzd c,sys_yh d  where"
				+ " a.hbr = b.yhbh "
				+ " and a.jsr = d.yhbh "
				+" and a.hblx = c.zdz "
				+" and c.zl='hblx'"
				+" and c.jb=2"
				+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	
/**
 * 获取当前检验科室的分配人员信息的openid
 * @author liangkaidi
 * @date 2016-3-16
 * @param jyks
 * @return
 */
	public List<Map<String, Object>> getopenId(String jyks) {
		String sql = "SELECT a.wxh FROM sys_wxyh a " +
				"left join sys_yh b on a.yhid=b.yhbh " +
				"where b.dlm=" +
				"(select this_.dlm as username from sys_yh this_ " +
				"LEFT JOIN sys_zzjg bm on this_.BMBH=bm.BMBH   " +
				"LEFT JOIN sys_yhjs yhjs on this_.yhbh=yhjs.YHBH " +
				" where  yhjs.jsbh =142 and this_.bmbh='"+jyks+"')";
		return jdbcTemplate.queryForList(sql);
	}

public List<Map<String, Object>> getbgbh(String ypbh) {
	String  sql ="select bgbh from y_yp_ypxx where ypbh='"+ypbh+"'";
	return jdbcTemplate.queryForList(sql);
}

}  