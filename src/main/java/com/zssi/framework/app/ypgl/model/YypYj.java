package com.zssi.framework.app.ypgl.model;

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
 * 样品移交
 * @author wangyong
 * @date 2016年3月9日
 */
@Entity
@Table(name="y_yp_yj")
public class YypYj implements Serializable{

	/**主键*/
	private Integer id;
	
	/**样品编号*/
	private String ypbh;
	
	/**条形码编号*/
	private String txmbh;
	
	/**样品名称*/
	private String ypmc;
	
	/**移交时间*/
	private Date yjsj;
	
	/**移交数量*/
	private String yjsl;
	
	/**接收人*/
	private String jsr;
	
	/**接收时间*/
	private Date jssj;
	
	/**移交人*/
	private String yjr;
	
	/**办理人*/
	private String blr;
	
	/**备注*/
	private String bz;

	 @Id
	//也可以使用sequence生成方式,SEQ_YP_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_YP_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="ypbh", length=50, nullable=true)
	public String getYpbh() {
		return ypbh;
	}

	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}

	@Column(name="txmbh", length=200, nullable=true)
	public String getTxmbh() {
		return txmbh;
	}

	public void setTxmbh(String txmbh) {
		this.txmbh = txmbh;
	}

	@Column(name="ypmc", length=50, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="yjsj", length=50, nullable=true)
	public Date getYjsj() {
		return yjsj;
	}

	public void setYjsj(Date yjsj) {
		this.yjsj = yjsj;
	}

	@Column(name="yjsl", length=50, nullable=true)
	public String getYjsl() {
		return yjsl;
	}

	public void setYjsl(String yjsl) {
		this.yjsl = yjsl;
	}

	@Column(name="jsr", length=50, nullable=true)
	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	@Column(name="jssj", length=50, nullable=true)
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	@Column(name="yjr", length=50, nullable=true)
	public String getYjr() {
		return yjr;
	}

	public void setYjr(String yjr) {
		this.yjr = yjr;
	}

	@Column(name="blr", length=50, nullable=true)
	public String getBlr() {
		return blr;
	}

	public void setBlr(String blr) {
		this.blr = blr;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
