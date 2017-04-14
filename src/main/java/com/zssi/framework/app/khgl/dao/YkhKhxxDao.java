package com.zssi.framework.app.khgl.dao;

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
import com.zssi.framework.app.khgl.model.YkhKhxx;

/**
 * 
 * @author liangkaidi
 * @date 2015-9-24
 */

@Repository
public class YkhKhxxDao extends HibernateBaseDaoImpl<YkhKhxx, Integer> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcPager jdbcPager;


	public Pagination<Map<String, Object>> getKhxxList(Integer start,
			Integer limit, String code) {

		String str = "";
		if (code != null && !"".equals(code)) {
			
			str = str+ " and a.zjhm  like '%"+ code+ "%' or a.khmc  like '%"+ code+ "%'";
		}
		String sql = "  select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a  where 1=1 "+str+" order by a.lrsj desc ";

		return jdbcPager.queryPage(sql, start, limit);
	}

	// 从数据字典中取值
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		String sql = " select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"
				+ zdzl + "' and a.jb='2'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	// 从数据字典中取值
	public List<Map<String, Object>> getZjlx(String zdzl) {
		String sql = " select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"
				+ zdzl + "' and a.jb='2'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	// 从数据字典中取值
	public List<Map<String, Object>> getKhlx(String zdzl) {
		String sql = " select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"
				+ zdzl + "' and a.jb='2'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-10-23
	 * @param code
	 * @return
	 */
	public List<Map<String,Object>> getList(String code){
		String str = "";
		if (code != null && !"".equals(code)) {
			str = str+ " and a.zjhm  like '%"+ code+ "%' or a.khmc  like '%"+ code+ "%'";
		}
		String sql ="  select a.id,a.khbh,a.khmc,a.khfl,d.hymc,a.dwxz,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,"
				+ "a.cz,a.frxm,to_char(a.clsj,'yyyy-mm-dd hh24:mi:ss') as clsj,a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh:mm:ss') as lrsj,"
				+ "to_char(a.sr,'YYYY-MM-dd') as sr,a.zjlx,a.zjlx,a.zjhm,a.bz from y_kh_khxx a  "
				+ "left join( select hymc,hybh from y_kh_hyxx ) d on a.khfl = d.hymc where 1=1 " + str;
		
		return jdbcTemplate.queryForList(sql);
	}

	/**
	 *  客户分类（行业信息表）
	 * @author liangkaidi
	 * @date 2015-11-13
	 * @return
	 */
		public List<Map<String, Object>> getHymc() {
			String sql =" select a.hymc,a.hybh from y_kh_hyxx a where a.jb=2 order by a.hymc ";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
//		默认保存注册用户角色为送检人员角色
		public void saveJs(int yhbh) {
			String sql="insert into sys_yhjs(yhbh,jsbh) values ('"+yhbh+"','182')";
			jdbcTemplate.execute(sql);
		}
		
		public int getyhbh(int id) {
			String sql =" select a.yhbh from sys_yh a where a.dlm =(select khbh from y_kh_khxx where id="+id+")";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return Integer.parseInt(list.get(0).get("yhbh").toString());
		}
		
		public List<Map<String, Object>> getyhbh() {
			SimpleDateFormat sim=new SimpleDateFormat("yyyy");
			String sql =" select nvl(max(a.khbh),'"+sim.format(new Date())+"00000') as khbh from y_kh_khxx a ";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		
		/**
		 * 数据字典中获取
		 * @author liangkaidi
		 * @date 2015-11-13
		 * @param zdzl
		 * @return
		 */
		public List<Map<String, Object>> getDicByList(String zdzl) {
			String sql =" select a.zdz,a.zdmc,a.zdbm from sys_sjzd a where a.zl='"+zdzl+"' and a.jb='2'";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}

		public List<Map<String, Object>> getKhxx(String code) {
			String sql =" select a.id,a.khbh,a.khmc from y_kh_khxx a ";
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
		/**
		 * 查出客户编号
		 * @author liangkaidi
		 * @date 2015-11-30
		 * @param khbh
		 * @return
		 */
		public List<Map<String, Object>> getZjhm(String khbh) {
			String sql =" select a.zjhm from y_kh_khxx a where a.zjhm='"+khbh+"'" ;
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}
/**
 * 修改
 * @author liangkaidi
 * @date 2015-12-3
 * @param id
 * @return
 */
		public List<Map<String, Object>> getkhxx(String id) {
			String str = "";
			if (id != null && !"".equals(id)) {
				str=str+" and a.id ='"+ id+ "' ";
			}
			String sql = " select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a  where 1=1 "+str;
			return jdbcTemplate.queryForList(sql);
		}
		
/**
 * 查看
 * @author liangkaidi
 * @date 2015-12-3
 * @param id
 * @return
 */
		public List<Map<String, Object>> getCk(String id) {
			String str = "";
			if (id != null && !"".equals(id)) {
				str=str+" and a.id = '"+ id+ "' ";
			}
			String sql = "select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a where 1=1 "
					+str;
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 样品登记时委托单位从客户信息中查询获取
		 * @author wangyong
		 * @date 2015年12月18日
		 * @param start
		 * @param limit
		 * @param code
		 * @return
		 */
		public List<Map<String, Object>> getWtdwKhxx(String khmccx,String khflcx) {
			String str = "";
			if ((khmccx!=null&&!"".equals(khmccx)) && (khflcx!=null&&!"".equals(khflcx))) {
				str = "and a.khmc like '%" + khmccx +"%' and a.khfl like '%" + khflcx + "%'";
			}else if((khmccx!=null&&!"".equals(khmccx))){
				str = "and a.khmc like '%" + khmccx +"%'";
			}else if((khflcx!=null&&!"".equals(khflcx))){
				str = "and a.khfl like '%" + khflcx + "%'";
			}
			String sql = "select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a where 1=1 " + str + " order by a.khbh desc ";
			return jdbcTemplate.queryForList(sql);
		}
		
		/**
		 * 通过ID获取客户信息的内容
		 * @author wangyong
		 * @date 2015年12月18日
		 * @param id
		 * @return
		 */
		public List<Map<String, Object>> getKhxxById(Integer id) {
			String str = "";
			if (id != null && !"".equals(id)) {
				str=str+" and a.id = "+ id;
			}
			String sql = " select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a where 1=1 " + str+" order by a.lrsj desc ";
			return jdbcTemplate.queryForList(sql);
		}
/**
 * 技术服务管理页面获取客户信息
 * @author liangkaidi
 * @date 2015-12-24
 * @param code
 * @return
 */
		public List<Map<String, Object>> getJsfwgl(String code) {
			String str = "";
			if (code != null && !"".equals(code)) {
				str = str+ " and a.khbh  like '%"+ code+ "%' or a.khmc  like '%"+ code+ "%'";
			}
			String sql = " select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a where 1=1 "+str+" order by a.lrsj desc ";
			return jdbcTemplate.queryForList(sql);
		}
/**
 * 技术服务管理获取客户信息
 * @author liangkaidi
 * @date 2016-1-15
 * @param id
 * @return
 */
public List<Map<String, Object>> getJsfwglById(Integer id) {
	String str = "";
	if (id != null && !"".equals(id)) {
		str=str+" and a.id = "+ id;
	}
	String sql = "select a.id,a.khbh,a.khmc,a.khfl,a.dwxz,a.khdz,a.lxr,a.sjhm,a.gddh,a.cz,a.frxm,a.ds, "
				+ " to_char(a.clsj,'YYYY-MM-dd') as clsj,to_char(a.sr,'YYYY-MM-dd') as sr,a.dwwz,a.ywje,a.dzyx,"
				+ "a.zczj,a.jycpmc,to_char(a.lrsj,'yyyy-mm-dd hh24:mi:ss') as lrsj,a.frqq,a.sjhm1,a.gddh1,a.cz1, "
                +  "a.bz,a.zjlx,a.zjhm,a.dzyx1,a.llqq from y_kh_khxx a  where 1=1 " + str+" order by a.lrsj desc ";
	return jdbcTemplate.queryForList(sql);
}
/**
 * 查询客户编号
 * @author liangkaidi
 * @date 2016-1-18
 * @param sfbzbh
 * @return
 */
public List<Map<String, Object>> getBgbhList(String khbh){
	String str = "";
	if(khbh!=null&&!"".equals(khbh)){
		str=" and a.khbh like '%" + khbh + "%'";
	}
	String sql = "select a.khbh from y_kh_khxx a where 1=1 "+str;
	return jdbcTemplate.queryForList(sql);
}
}
