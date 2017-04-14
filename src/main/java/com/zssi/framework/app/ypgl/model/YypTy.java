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
 * 样品退样
 * @author duanpeijun
 * @date 2015年9月24日
 */
@Entity
@Table(name="y_yp_ty")
public class YypTy implements Serializable{

	/**主键*/
	private Integer id;
	
	/**样品编号*/
	private String ypbh;
	
	/**二维码编号*/
	private String ewmbh;
	
	/**样品名称*/
	private String ypmc;
	
	/**退样时间*/
	private Date tysj;
	
	/**退样数量*/
	private String tysl;
	
	/**客方接收人*/
	private String kfjsr;
	
	/**接收时间*/
	private Date jssj;
	
	/**退样人*/
	private String tyr;
	
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

	@Column(name="ewmbh", length=50, nullable=true)
	public String getEwmbh() {
		return ewmbh;
	}

	public void setEwmbh(String ewmbh) {
		this.ewmbh = ewmbh;
	}

	@Column(name="ypmc", length=50, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="tysj", length=50, nullable=true)
	public Date getTysj() {
		return tysj;
	}

	public void setTysj(Date tysj) {
		this.tysj = tysj;
	}

	@Column(name="tysl", length=50, nullable=true)
	public String getTysl() {
		return tysl;
	}

	public void setTysl(String tysl) {
		this.tysl = tysl;
	}

	@Column(name="kfjsr", length=50, nullable=true)
	public String getKfjsr() {
		return kfjsr;
	}

	public void setKfjsr(String kfjsr) {
		this.kfjsr = kfjsr;
	}

	@Column(name="jssj", length=50, nullable=true)
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	@Column(name="tyr", length=50, nullable=true)
	public String getTyr() {
		return tyr;
	}

	public void setTyr(String tyr) {
		this.tyr = tyr;
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
