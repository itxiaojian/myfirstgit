package com.zssi.framework.app.bhsz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="y_bg_bgsz")
public class YbgBhsz implements Serializable{

	/**序号*/
	private Integer id;
	
	/**部门编号*/
	private String bmbh;
	
	/**部门名称*/
	private String bmmc;
	
	/**编号*/
	private String bh;
	
	/**字号*/
	private String zh;
	
	/**备注*/
	private String bz;
	
	/**字号名称*/
	private String zhmc;
	
	/**字号分类*/
	private String zhfl;

	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_CW_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bmbh", length=50, nullable=true)
	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	@Column(name="bmmc", length=50, nullable=true)
	public String getBmmc() {
		return bmmc;
	}

	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}

	@Column(name="bh", length=50, nullable=true)
	public String getBh() {
		return bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	@Column(name="zh", length=50, nullable=true)
	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name="zhmc", length=50, nullable=true)
	public String getZhmc() {
		return zhmc;
	}

	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}

	@Column(name="zhfl", length=50, nullable=true)
	public String getZhfl() {
		return zhfl;
	}

	public void setZhfl(String zhfl) {
		this.zhfl = zhfl;
	}
}
