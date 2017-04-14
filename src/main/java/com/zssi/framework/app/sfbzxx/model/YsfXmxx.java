package com.zssi.framework.app.sfbzxx.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "y_sf_xmxx")
public class YsfXmxx implements Serializable{
	private Integer id; //id序号
	
	private String xmbh;//项目编号
	
	private String xmmc;//项目名称
	
	private String jldw;//计量单位
	
	private String sfbzbh;//收费标准编号
	
	private BigDecimal dj;//单价
	
	private String cplx;  //产品类型
	
	private String cplxbh;//产品类型编号
	
	private String bz;//总金额

	
	
	
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)用于MySQL数据库
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_SF_ID") })
	// 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "xmbh", length = 50, nullable = true)
	public String getXmbh() {
		return xmbh;
	}

	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}
	@Column(name = "xmmc", length = 50, nullable = true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	@Column(name = "sfbzbh", length = 50, nullable = true)
	public String getSfbzbh() {
		return sfbzbh;
	}

	public void setSfbzbh(String sfbzbh) {
		this.sfbzbh = sfbzbh;
	}

	@Column(name = "jldw", length = 50, nullable = true)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}
	@Column(name = "dj", nullable = true)
	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	
	@Column(name = "cplx", nullable = true)
	public String getCplx() {
		return cplx;
	}

	public void setCplx(String cplx) {
		this.cplx = cplx;
	}
	@Column(name = "cplxbh", nullable = true)
	public String getCplxbh() {
		return cplxbh;
	}

	public void setCplxbh(String cplxbh) {
		this.cplxbh = cplxbh;
	}

	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	

}
