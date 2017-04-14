package com.zssi.framework.app.cwgl.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 成本管理--科室收入明细
 * @author wangyong
 * @date 2015年10月14日
 */
@Entity
@Table(name="y_cw_kssrmx")
public class YcwKssrmx implements Serializable{

	private Integer id;         //主键ID
	
	private String jybh;        //检验编号
	
	private String fymc;        //费用名称
	
	private String fylx;        //费用类型
	
	private String fynr;        //费用内容 
	
	private BigDecimal je;      //金额
	
	private String bz;          //备注

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

	@Column(name="jybh", length=50, nullable=true)
	public String getJybh() {
		return jybh;
	}

	public void setJybh(String jybh) {
		this.jybh = jybh;
	}

	@Column(name="fymc", length=50, nullable=true)
	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	@Column(name="fylx", length=50, nullable=true)
	public String getFylx() {
		return fylx;
	}

	public void setFylx(String fylx) {
		this.fylx = fylx;
	}

	@Column(name="fynr", length=500, nullable=true)
	public String getFynr() {
		return fynr;
	}

	public void setFynr(String fynr) {
		this.fynr = fynr;
	}

	@Column(name="je", length=50, nullable=true)
	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}	
