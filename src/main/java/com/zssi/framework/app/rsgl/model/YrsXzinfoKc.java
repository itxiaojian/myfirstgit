package com.zssi.framework.app.rsgl.model;

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
 * 人事管理--薪资扣除
 * @author wangyong
 * @date 2015年10月21日
 */
@Entity
@Table(name="y_rs_xzinfo_kc")
public class YrsXzinfoKc implements Serializable{

	/**主键id*/
	private Integer id;
	
	/**人员编号*/
	private String rybh;
	
	/**月份*/
	private String yf;
	
	/**缺勤扣除*/
	private BigDecimal qqkc;
	
	/**养老保险*/
	private BigDecimal ylbx;
	
	/**医保*/
	private BigDecimal yb;
	
	/**失业保险*/
	private BigDecimal sybx;
	
	/**社保小计*/
	private BigDecimal sbxj;
	
	/**住房公积金*/
	private BigDecimal zfgjj;
	
	/**个税*/
	private BigDecimal gs;
	
	/**扣除小计*/
	private BigDecimal kcxj;
	
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

	@Column(name="yf",length=50,nullable=true)
	public String getYf() {
		return yf;
	}

	public void setYf(String yf) {
		this.yf = yf;
	}

	@Column(name="rybh",length=50,nullable=true)
	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}

	@Column(name="qqkc",length=50,nullable=true)
	public BigDecimal getQqkc() {
		return qqkc;
	}

	public void setQqkc(BigDecimal qqkc) {
		this.qqkc = qqkc;
	}

	@Column(name="ylbx",length=50,nullable=true)
	public BigDecimal getYlbx() {
		return ylbx;
	}

	public void setYlbx(BigDecimal ylbx) {
		this.ylbx = ylbx;
	}

	@Column(name="yb",length=50,nullable=true)
	public BigDecimal getYb() {
		return yb;
	}

	public void setYb(BigDecimal yb) {
		this.yb = yb;
	}

	@Column(name="sybx",length=50,nullable=true)
	public BigDecimal getSybx() {
		return sybx;
	}

	public void setSybx(BigDecimal sybx) {
		this.sybx = sybx;
	}

	@Column(name="sbxj",length=50,nullable=true)
	public BigDecimal getSbxj() {
		return sbxj;
	}

	public void setSbxj(BigDecimal sbxj) {
		this.sbxj = sbxj;
	}

	@Column(name="zfgjj",length=50,nullable=true)
	public BigDecimal getZfgjj() {
		return zfgjj;
	}

	public void setZfgjj(BigDecimal zfgjj) {
		this.zfgjj = zfgjj;
	}

	@Column(name="gs",length=50,nullable=true)
	public BigDecimal getGs() {
		return gs;
	}

	public void setGs(BigDecimal gs) {
		this.gs = gs;
	}

	@Column(name="kcxj",length=50,nullable=true)
	public BigDecimal getKcxj() {
		return kcxj;
	}

	public void setKcxj(BigDecimal kcxj) {
		this.kcxj = kcxj;
	}

	@Column(name="bz",length=500,nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
