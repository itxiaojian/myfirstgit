package com.zssi.framework.app.cwgl.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 财务管理--员工福利明细
 * @author wangyong
 * @date 2015年10月13日
 */
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_ygflmx")
public class YcwYgflmx implements Serializable{

	private Integer id;         //主键ID
	
	private String ygxm;        //员工编号
	
	private String ssyf;        //所属月份
	
	private String flmc;        //福利名称 
	
	private String flxq;        //福利详情

	private BigDecimal je;      //金额
	
	private String ks_id;    //科室编号
	
	private Date lrrq;    //录入日期
	private String flbh;    //福利编号

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

	@Column(name="ygxm", length=50, nullable=true)
	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
	
	@Column(name="ssyf", length=50, nullable=true)
	public String getSsyf() {
		return ssyf;
	}

	public void setSsyf(String ssyf) {
		this.ssyf = ssyf;
	}

	@Column(name="flmc", length=50, nullable=true)
	public String getFlmc() {
		return flmc;
	}

	public void setFlmc(String flmc) {
		this.flmc = flmc;
	}

	@Column(name="flxq", length=500, nullable=true)
	public String getFlxq() {
		return flxq;
	}

	public void setFlxq(String flxq) {
		this.flxq = flxq;
	}
	
	@Column(name="je", length=50, nullable=true)
	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	@Column(name="ks_id", length=50, nullable=true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}

	@Column(name="lrrq", length=50, nullable=true)
	public Date getLrrq() {
		return lrrq;
	}

	public void setLrrq(Date lrrq) {
		this.lrrq = lrrq;
	}

	@Column(name="flbh", length=50, nullable=true)
	public String getFlbh() {
		return flbh;
	}

	public void setFlbh(String flbh) {
		this.flbh = flbh;
	}
	
}	
