package com.zssi.framework.app.rsgl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 人事管理--薪资管理
 * @author wangyong
 * @date 2015年10月21日
 */
@Entity
@Table(name="y_rs_xz_info")
public class YrsXzInfo implements Serializable{

	/**主键id*/
	private Integer id;
	
	/**人员编号*/
	private String rybh;
	
	/**人员姓名*/
	private String ryxm;
	
	/**月份*/
	private String yf;
	
	/**基本工资*/
	private Integer jbgz;
	
	/**绩效工资*/
	private Integer jxgz;
	
	/**加班费*/
	private Integer jbf;
	
	/**其他*/
	private Integer qt;
	
	/**午餐补助*/
	private Integer wcbz;
	
	/**应发工资*/
	private Integer yfgz;
	
	/**实发工资*/
	private Integer sfgz;
	
	/**备注*/
	private String bz;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_RS_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="rybh",length=50,nullable=true)
	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}

	@Column(name="ryxm",length=50,nullable=true)
	public String getRyxm() {
		return ryxm;
	}

	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}

	@Column(name="yf",length=50,nullable=true)
	public String getYf() {
		return yf;
	}

	public void setYf(String yf) {
		this.yf = yf;
	}

	@Column(name="jbgz",length=50,nullable=true)
	public Integer getJbgz() {
		return jbgz;
	}

	public void setJbgz(Integer jbgz) {
		this.jbgz = jbgz;
	}

	@Column(name="jxgz",length=50,nullable=true)
	public Integer getJxgz() {
		return jxgz;
	}

	public void setJxgz(Integer jxgz) {
		this.jxgz = jxgz;
	}

	@Column(name="jbf",length=50,nullable=true)
	public Integer getJbf() {
		return jbf;
	}

	public void setJbf(Integer jbf) {
		this.jbf = jbf;
	}

	@Column(name="qt",length=50,nullable=true)
	public Integer getQt() {
		return qt;
	}

	public void setQt(Integer qt) {
		this.qt = qt;
	}

	@Column(name="wcbz",length=50,nullable=true)
	public Integer getWcbz() {
		return wcbz;
	}

	public void setWcbz(Integer wcbz) {
		this.wcbz = wcbz;
	}

	@Column(name="yfgz",length=50,nullable=true)
	public Integer getYfgz() {
		return yfgz;
	}

	public void setYfgz(Integer yfgz) {
		this.yfgz = yfgz;
	}

	@Column(name="sfgz",length=50,nullable=true)
	public Integer getSfgz() {
		return sfgz;
	}

	public void setSfgz(Integer sfgz) {
		this.sfgz = sfgz;
	}

	@Column(name="bz",length=500,nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
