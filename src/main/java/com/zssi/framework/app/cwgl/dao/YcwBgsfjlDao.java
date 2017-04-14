package com.zssi.framework.app.cwgl.dao; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.cwgl.model.YcwBgsfjl;

/** 
 * 报告收费dao层
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月11日 下午5:09:11 
 * 类说明 
 */
@Repository
public class YcwBgsfjlDao extends HibernateBaseDaoImpl<YcwBgsfjl, Integer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/** 
	 * 传参id的list查询要
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年10月15日 上午10:19:22 
	 * 类说明 
	 */
	public List<Map<String,Object>> getbgsfjl(String bgbh){
		String str = "";
		if (bgbh != null && !"".equals(bgbh)) {
			str=str+" and a.bgbh like '"+ bgbh+"'  order by a.jyjsrq ";
		}
		String sql = "  select a.id,a.bgbh,a.sjdw,to_char(a.jyjsrq,'yyyy-MM-dd HH24:mi:ss') as jyjsrq,a.ysje,a.ysfje,a.pjhm,"
				+ "a.sfr,a.xgje,a.sfyq,a.sfzt,a.bz,a.ypmc,a.bcss,a.srfl,a.jyfy,c.bmmc as ssywks,b.bmmc as ks_id from y_cw_bgsfjl a "
				+ "left join sys_zzjg b on a.ks_id = b.id "
				+ "left join sys_zzjg c on a.ssywks = c.id where 1=1 "+str;
		return jdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 删除收费记录
	 * @author liusong
	 * @version 2015年9月21日下午2:10:45
	 * @param id
	 */
		public void deletejl(String bgbh){
			String sql = "delete from y_cw_bgsfjl where bgbh = '"+bgbh+"'";
					jdbcTemplate.execute(sql);
		}
}
