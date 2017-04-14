package com.zssi.framework.app.wxpt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;


/**
*微服务
@Author oufeng	
@Date 2015年12月15日 上午10:56:30
@Version 1.0
*/
@Repository
public class WfwXgxxDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 获取报告信息
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param openId 
	 * @return
	 */
	public List<Map<String,Object>> getBgxx(String bgbh,String openId){
		String str ="";
		if(bgbh!=null && !"".equals(bgbh) ){
			str+= " and (bgbh like '%"+bgbh+"%' or bgmc like '%"+bgbh+"%')";
		}
		String sql="select id,bgbh,bgmc,bzr,jsr,tjr,cydw,bsdx from  y_jy_bgxx where 1=1"+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 获取报告详情
	 * @author oufeng
	 * @date 2015年12月15日
	 * @param openId 
	 * @return
	 */
	public List<Map<String,Object>> getBgxxXq(String id){
		String str ="";
		if(id!=null && !"".equals(id) ){
			str+= " and  a.id = '"+id+"'";
		}
		String sql="select a.id,a.bgbh,a.bgmc,a.jyrq,a.bzr,b.xm as bzrxm,a.jsdw,a.jsr,c.xm as jsrxm,"
				+ " a.ffrq,a.ffzt,a.tjyy,a.tjr,d.xm as tjrxm,a.bz,a.bzfs,a.jyjl,a.bsdx,a.cydw,a.dyzt,a.dycs,"
				+ " a.bgbzrq,a.bgdysj,a.jyqksm,a.jyjsrq "
                +"  from y_jy_bgxx a left join sys_yh b on  a.bzr = b.yhbh "
                +" left join  sys_yh c on a.jsr = c.yhbh"
                +" left join sys_yh d on a.tjr = d.yhbh where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
}

