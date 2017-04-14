package com.zssi.framework.app.wxpt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
*微管理的申请信息
@Author oufeng	
@Date 2015年12月15日 上午9:40:15
@Version 1.0
*/
@Entity
@Table(name = "W_GL_SQXX")
public class GlSqxx  implements Serializable {
	  //申请ID
	private Integer sqid;
	
	//申请名称
	private String sqmc;
	
	//申请类型
	private String sqlx;
	
	//申请内容
	private String sqnr;
	
	//申请人
	private String sqr;
	
	//申请日期
	private Date sqrq;
	
	//审批状态
	private Integer  wpzt;
	
	//开始时间
	private  Date sjsj;
	
	//结束时间
	private Date xjsj;
	
	//附件
	private String fj;
	
	//备注
	private String bz;
	
	//抄送人
	private String csr;
	
	//审核人
	private String shr;
	
	//审核意见
	private String shyj;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_KH_ID") })
	// 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "sqid", nullable = false)
	public Integer getSqid() {
		return sqid;
	}

	public void setSqid(Integer sqid) {
		this.sqid = sqid;
	}

	@Column(name = "sqmc", length = 64, nullable = true)
	public String getSqmc() {
		return sqmc;
	}

	public void setSqmc(String sqmc) {
		this.sqmc = sqmc;
	}

	@Column(name = "sqlx", length = 50, nullable = true)
	public String getSqlx() {
		return sqlx;
	}

	public void setSqlx(String sqlx) {
		this.sqlx = sqlx;
	}

	@Column(name = "sqnr", length = 500, nullable = true)
	public String getSqnr() {
		return sqnr;
	}

	public void setSqnr(String sqnr) {
		this.sqnr = sqnr;
	}

	@Column(name = "sqr", length = 50, nullable = true)
	public String getSqr() {
		return sqr;
	}

	public void setSqr(String sqr) {
		this.sqr = sqr;
	}

	@Column(name = "sqrq", length = 11, nullable = true)
	public Date getSqrq() {
		return sqrq;
	}

	public void setSqrq(Date sqrq) {
		this.sqrq = sqrq;
	}

	@Column(name = "wpzt", length = 3, nullable = true)
	public Integer getWpzt() {
		return wpzt;
	}

	public void setWpzt(Integer wpzt) {
		this.wpzt = wpzt;
	}

	@Column(name = "sjsj", length =11, nullable = true)
	public Date getSjsj() {
		return sjsj;
	}

	public void setSjsj(Date sjsj) {
		this.sjsj = sjsj;
	}

	@Column(name = "xjsj", length =11, nullable = true)
	public Date getXjsj() {
		return xjsj;
	}

	public void setXjsj(Date xjsj) {
		this.xjsj = xjsj;
	}

	@Column(name = "fj", length =2000, nullable = true)
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	@Column(name = "bz", length =256, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "csr", length =500, nullable = true)
	public String getCsr() {
		return csr;
	}

	public void setCsr(String csr) {
		this.csr = csr;
	}

	@Column(name = "shr", length =200, nullable = true)
	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	@Column(name = "shyj", length =500, nullable = true)
	public String getShyj() {
		return shyj;
	}

	public void setShyj(String shyj) {
		this.shyj = shyj;
	}
	
	
}