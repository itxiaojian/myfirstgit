package com.zssi.framework.app.jygl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 模板设置
 * @author wangyong
 * @date 2015年12月9日
 */
@Entity
@Table(name="y_jy_ydmb")
public class YjyYdmb implements Serializable{

	/**主键*/
	private Integer id;
	
	/**部门编号*/
	private String bmbh;
	
	/**部门名称*/
	private String bmmc;
	
	/**字号*/
	private String zh;
	
	/**所属编号*/
	private String ssbh;
	
	/**封面ID*/
	private Integer fm_id;
	
	/**首页ID*/
	private Integer sy_id;
	
	/**附页ID*/
	private Integer fy_id;
	
	/**模板分类*/
	private Integer mbfl;
	
	private Integer fy;
	private Integer fm;
	private Integer sy;
	
	
	@Id
	//也可以使用sequence生成方式,SEQ_YP_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="bmbh", length=200, nullable=true)
	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	@Column(name="bmmc", length=200, nullable=true)
	public String getBmmc() {
		return bmmc;
	}

	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}

	@Column(name="zh", length=200, nullable=true)
	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	@Column(name="ssbh", length=200, nullable=true)
	public String getSsbh() {
		return ssbh;
	}

	public void setSsbh(String ssbh) {
		this.ssbh = ssbh;
	}

	@Column(name="fm_id", length=200, nullable=true)
	public Integer getFm_id() {
		return fm_id;
	}

	public void setFm_id(Integer fm_id) {
		this.fm_id = fm_id;
	}

	@Column(name="sy_id", length=200, nullable=true)
	public Integer getSy_id() {
		return sy_id;
	}

	public void setSy_id(Integer sy_id) {
		this.sy_id = sy_id;
	}

	@Column(name="fy_id", length=200, nullable=true)
	public Integer getFy_id() {
		return fy_id;
	}

	public void setFy_id(Integer fy_id) {
		this.fy_id = fy_id;
	}

	@Column(name="mbfl", length=200, nullable=true)
	public Integer getMbfl() {
		return mbfl;
	}

	public void setMbfl(Integer mbfl) {
		this.mbfl = mbfl;
	}
	@Column(name="fy", length=200, nullable=true)
	public Integer getFy() {
		return fy;
	}

	public void setFy(Integer fy) {
		this.fy = fy;
	}
	@Column(name="fm", length=200, nullable=true)
	public Integer getFm() {
		return fm;
	}

	public void setFm(Integer fm) {
		this.fm = fm;
	}
	@Column(name="sy", length=200, nullable=true)
	public Integer getSy() {
		return sy;
	}

	public void setSy(Integer sy) {
		this.sy = sy;
	}

	

}
