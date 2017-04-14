package com.zssi.framework.app.cwgl.service; 

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.dao.YcwBgsfDao;
import com.zssi.framework.app.cwgl.dao.YcwBgsfjlDao;
import com.zssi.framework.app.cwgl.model.YcwBgsf;

/** 
 * 报告收费Service类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月11日 下午5:08:09 
 * 类说明 
 */
@Service
public class YcwBgsfService extends BaseBO<YcwBgsf> {
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwBgsfDao bgsfDao;
	
	@Autowired
	private YcwBgsfjlDao bgsfjlDao;
	
//  报告待收费分页查询
	@Transactional
	public Pagination<Map<String, Object>> getBgsfList (Integer start,Integer limit,String code,String jyks,String ywks){
		return bgsfDao.getBgsfList(start, limit, code,jyks,ywks);
	}

	//报告已收费分页查询	
	@Transactional
	public Pagination<Map<String, Object>> getBgysfList (Integer start,Integer limit,String code,String jyks,String ywks){
		return bgsfDao.getBgysfList(start, limit, code,jyks,ywks);
	}
	
	/**
	 * 获取未结算的收费信息
	 * @author:zhangyi 
	 * @version 创建时间：2015年12月24日 下午2:00:17 
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDsfbgsf(){
		return bgsfDao.getDsfbgsf();
	}
	
	/**
	 * 查询出要收费登记的那条报告收费内容
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getbgsf(String id){
		return bgsfDao.getbgsf(id);
	}
	
	/**
	 * 查询出要收费登记的那条报告收费内容明细————收费项目明细
	 * @author liusong
	 * @date 2015-11-17
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getsfxm(String bgbh){
		return bgsfDao.getsfxm(bgbh);
	}
	
	/**
	 * 获取收入分类下拉框
	 * @author liusong
	 * @date 2015年9月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getDicByLx(String zdzl) {
		return bgsfDao.getDicByLx(zdzl);
	}
	
	/** 
	 * 更新
	 * @author liusong E-mail: 2629690209@qq.com
	 * @version 创建时间：2015年12月13日 下午2:37:37 
	 * 类说明 
	 * @param entity
	 * @param id
	 * @return
	 */
	@Transactional
	public void update(YcwBgsf entity,String id){
		entity.setId(Integer.parseInt(id));
		bgsfDao.update(entity);
		
	}
	
	/**
	 * 删除
	 * @author liusong
	 * @date 2015年9月23日
	 * @param start
	 * @param limit
	 * @return
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			YcwBgsf entity = bgsfDao.get(ids[i]);
			entity.setJyfy(new BigDecimal(0));
			entity.setYsje(new BigDecimal(0));
			entity.setYsfje(new BigDecimal(0));
			bgsfDao.update(entity);
//			YcwBgsf bgsf = bgsfDao.get(ids[i]);
//			String bgbh = bgsf.getBgbh();
//			bgsfjlDao.deletejl(bgbh);
		}
	}
	
	

}
