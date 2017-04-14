package com.zssi.framework.app.ypgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zssi.framework.app.common.dao.hibernate4.HibernateBaseDaoImpl;
import com.zssi.framework.app.common.dao.jdbc.NamedParameterJdbcPager;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.ypgl.model.YypWsdjfh;

@Repository
public class YypWsdjfhDao extends HibernateBaseDaoImpl<YypWsdjfh, Integer>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;
	
	/**
	 * 分页查询样品预登记信息
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @param bgbh
	 * @return
	 */
	public Pagination<Map<String, Object>> getYpWsdxxList(Integer start, Integer limit,String canshu,String bgbh){
		
		String str = "";
		if(canshu!=null&&!"".equals(canshu)){
			str=str+" and a.ypbh like '%"+ canshu+ "%' or a.ypmc like '%"+ canshu+ "%'";
		}
		String sql = "SELECT a.id,a.ypbh,a.ypmc,a.yplx,a.jylx,a.wtdw,a.wtdwdz,a.sjdw,a.sjdwdz,a.ypjyzt,b.zdmc as ztmc,"
				+ "to_char(a.djsj,'YYYY-MM-dd') as djsj FROM Y_YP_WSDJFH a left join "
				+ "(select zdz,zdmc from SYS_SJZD where ZL='ypydjzt' and JB='2') b on a.ypjyzt||''=b.zdz where a.ypjyzt=0 "+str;
		return jdbcPager.queryPage(sql, start, limit);
	}
	
	/**
	 * 获取字号
	 * @author liujiansen
	 * @date 2015年12月24日
	 * @return
	 */
	public List<Map<String,Object>> getZh(){
		String sql="SELECT zh,zhmc FROM Y_BG_BHSZ group by zh,zhmc";
		return jdbcTemplate.queryForList(sql);
	}
}
