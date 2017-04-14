package com.zssi.framework.app.sys.bo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likegene.framework.core.BaseBO;
import com.likegene.framework.core.Result;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.likegene.framework.core.query.QueryFilter;
import com.zssi.framework.app.sys.dao.SysAreaDao;
import com.zssi.framework.app.sys.model.SysZzjg;

/**
 * 区域 Business
 * 
 * @author lxt
 * @since 2014-11-19 17:16:17
 * 
 */
@Service
public class SysZzjgBO extends BaseBO<SysZzjg> {

	protected static Logger logger = LoggerFactory
			.getServiceLog(SysZzjgBO.class);
	@Autowired
	private SysAreaDao orgDao;
	
	@Override
	public <K extends Serializable> Result remove(K ids) {
		QueryFilter filter = new QueryFilter();
		filter.addFilter("Q_sjbh_S_EQ", ids);
		SysZzjg file = dao.getUnique(filter, SysZzjg.class);
		if (file != null) {
			Result result = new Result();
			result.addErrormsg("本区域下有区域名称");
			return result;
		}
		return super.remove(ids);
	}

	public String getAreaToString(List<SysZzjg> sysAreas) {
		StringBuffer sysAreaJson = new StringBuffer();
		sysAreaJson.append("{\"treeNodes\":[");
		if (sysAreas.size() > 0) {
			for (int i = 0; i < sysAreas.size(); i++) {
				if (i < sysAreas.size() - 1) {
					sysAreaJson.append("{\"id\":\"" + sysAreas.get(i).getId()
							+ "\",\"value\":\"" + sysAreas.get(i).getBmbh()
							+ "\",\"name\":\"" + sysAreas.get(i).getBmmc()
							+ "\",\"parentId\":\""
							+ sysAreas.get(i).getSjbh()
							+ "\",\"open\":\"true\"},");
				} else {
					sysAreaJson.append("{\"id\":\"" + sysAreas.get(i).getId()
							+ "\",\"value\":\"" + sysAreas.get(i).getBmbh()
							+ "\",\"name\":\"" + sysAreas.get(i).getBmmc()
							+ "\",\"parentId\":\""
							+ sysAreas.get(i).getSjbh()
							+ "\",\"open\":\"true\"}");
				}
			}
		}
		sysAreaJson.append("]}");
		return sysAreaJson.toString();
	}

	public List<Map<String, Object>> findAttacheArea(String id,boolean isparentId){
		return orgDao.findAttacheArea(id,isparentId);
	}
	
	public List<Map<String, Object>> findBz(String id){
		return orgDao.findBz(id);
	}
	
	public List<Map<String,Object>> findOrgArchive(Integer start,Integer limit,String OrgId){
		return orgDao.findOrgArchive(start, limit, OrgId);
	}

	public List<Map<String,Object>> getOrgTree(String node){
		return orgDao.getOrgTree(node);
	}
	
	public List<Map<String,Object>> getYhByjg(String bmbh){
		return orgDao.getYhByjg(bmbh);
	}
	
	public List<Map<String,Object>> getOrgTree1(String node){
		return orgDao.getOrgTree1(node);
	}
	
  //2.2 action中涉及的两个处理函数getjson_getchildtree()和getjson_gettext()
  	/**
  	* 2.2.1 生成combotree的子节点列表异步树jason字符串,并out.write(s);
  	*/
  	public String getjson_getchildtree(HttpServletRequest pRequest, HttpServletResponse pResponse) {
  			
  			String parentid = pRequest.getParameter("id");
  			
  			if(parentid == null){
  				//初次进入是没有值的，此时设置为总父节点（根据数据库中表结构设置总父节点值即可）
  				parentid = "0";
  			}

  	    //1.根据父节点从后台数据库获取子节点列表LIST   
  			List<Map<String,Object>> list = orgDao.getchildtree(parentid); 
  			/*
  			  各人后台数据库中表字段名称可能都不相同，但是combotree的节点属性值名称必须指定为id,text,state...
  	      因此数据库中获取出来的列表字段名称也必须为id,text,state...
  	      所以，List<Tbl_tree> list = myService.getchildtree(parentid); 中的SQL语句应该为:
  	      
  	      SELECT col_id AS id,col_name AS text,col_pid AS pid,
  	             (SELECT COUNT(1) FROM tbl B WHERE B.col_pid=A.col_id ) AS cnt --此处通过count(1)该节点是否还有子节点来判断树节点的state:closed/open，用于异步树
  	        FROM tbl A
  	        WHERE col_pid = parentid --传进来的参数parentid
  	        ORDER BY col_id;
  	        
  			*/
  			
  			
  			//2.获取到List<Tbl_tree>后，就剩下如何拼成jason字符串，然后返回
  			StringBuffer buffer = new StringBuffer();

  		  buffer.append("[");

  			for(int i=0; i<list.size(); i++){
  				Map<String,Object> node = list.get(i);
  				buffer.append("{\"id\":\"")
  				      .append(node.get("id"))
  					    .append("\",\"text\":\"")
  					    .append(node.get("text"));
  					
  					//如果有子节点，就设置该节点的state属性为closed 
  					if(Integer.parseInt(node.get("cnt").toString())> 0){     
  						 buffer.append("\",\"state\":\"") //加了这个closed状态就会自动变成异步树
  					         .append("closed");
  					}
  					
  					buffer.append("\"},");
  		
  			}

  		  buffer.append("]");

  		  //将,\n]替换成\n]
  	    String treestr = buffer.toString();
  	    treestr = treestr.replaceAll(",]", "]");
  	    return treestr;
  	}
  	/**
  	 * 
  	 * @author liangkaidi
  	 * @date 2015-12-25
  	 * @param pRequest
  	 * @param pResponse
  	 * @return
  	 */
  	public String getjson_getchildtreessks(HttpServletRequest pRequest, HttpServletResponse pResponse) {
			
			String parentid = pRequest.getParameter("id");
			
			if(parentid == null){
				//初次进入是没有值的，此时设置为总父节点（根据数据库中表结构设置总父节点值即可）
				parentid = "101";
			}

	    //1.根据父节点从后台数据库获取子节点列表LIST   
			List<Map<String,Object>> list = orgDao.getchildtree(parentid); 
			/*
			  各人后台数据库中表字段名称可能都不相同，但是combotree的节点属性值名称必须指定为id,text,state...
	      因此数据库中获取出来的列表字段名称也必须为id,text,state...
	      所以，List<Tbl_tree> list = myService.getchildtree(parentid); 中的SQL语句应该为:
	      
	      SELECT col_id AS id,col_name AS text,col_pid AS pid,
	             (SELECT COUNT(1) FROM tbl B WHERE B.col_pid=A.col_id ) AS cnt --此处通过count(1)该节点是否还有子节点来判断树节点的state:closed/open，用于异步树
	        FROM tbl A
	        WHERE col_pid = parentid --传进来的参数parentid
	        ORDER BY col_id;
	        
			*/
			
			
			//2.获取到List<Tbl_tree>后，就剩下如何拼成jason字符串，然后返回
			StringBuffer buffer = new StringBuffer();

		  buffer.append("[");

			for(int i=0; i<list.size(); i++){
				Map<String,Object> node = list.get(i);
				buffer.append("{\"id\":\"")
				      .append(node.get("id"))
					    .append("\",\"text\":\"")
					    .append(node.get("text"));
					
					//如果有子节点，就设置该节点的state属性为closed 
					if(Integer.parseInt(node.get("cnt").toString())> 0){     
						 buffer.append("\",\"state\":\"") //加了这个closed状态就会自动变成异步树
					         .append("closed");
					}
					
					buffer.append("\"},");
		
			}

		  buffer.append("]");

		  //将,\n]替换成\n]
	    String treestr = buffer.toString();
	    treestr = treestr.replaceAll(",]", "]");
	    return treestr;
	}
  	
  	public String getjson_getchildtree1(HttpServletRequest pRequest, HttpServletResponse pResponse) {
			
			String parentid = pRequest.getParameter("id");
			
			if(parentid == null){
				parentid = "100230";
			}

			List<Map<String,Object>> list = orgDao.getchildtree(parentid); 
			StringBuffer buffer = new StringBuffer();

		  buffer.append("[");

			for(int i=0; i<list.size(); i++){
				Map<String,Object> node = list.get(i);
				buffer.append("{\"id\":\"")
				      .append(node.get("id"))
					    .append("\",\"text\":\"")
					    .append(node.get("text"));
					
					//如果有子节点，就设置该节点的state属性为closed 
					if(Integer.parseInt(node.get("cnt").toString())> 0){     
						 buffer.append("\",\"state\":\"") //加了这个closed状态就会自动变成异步树
					         .append("closed");
					}
					
					buffer.append("\"},");
		
			}

		  buffer.append("]");

		  //将,\n]替换成\n]
	    String treestr = buffer.toString();
	    treestr = treestr.replaceAll(",]", "]");
	    return treestr;
	}

  	/**
  	* 2.2.2 根据id值获取对应的名称,并out.write(s); (用于返回给异步树的当前显示值)
  	*/
  	public String getjson_gettext(HttpServletRequest pRequest, HttpServletResponse pResponse) {
  			
  	    String id = pRequest.getParameter("id");
  			
  			//1.通过id获取对应的名称
  			String txt = orgDao.gettext(id).get(0).get("text").toString();
  			/*
  			  String txt = myService.gettext(id);中的SQL语句应该为:
  			  
  			  SELECT col_name AS text
  			    FROM tbl 
  	        WHERE col_id = id; --传进来的参数id
  			*/
  		return txt;	
  	}
}
