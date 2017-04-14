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

//管理部门收费model类
//liusong 2015-12-24
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_glbmsf")
public class YcwGlbmsf implements Serializable {
	
	private Integer id;
	
	private String bmbh;
	
	private String fphm;
	
	private String srfl;
	
	private String sfxmmc;
	
	private BigDecimal sfje;
	
	private Date sfrq;
	
	private String sfr;
	
	private String bz;
	
    private String pjfl;    //票据分类
	
	private String pjhm;     //票据号码
	
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

	@Column(name="bmbh",  nullable=true)
	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	@Column(name="fphm",  nullable=true)
	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	@Column(name="srfl",  nullable=true)
	public String getSrfl() {
		return srfl;
	}

	public void setSrfl(String srfl) {
		this.srfl = srfl;
	}

	@Column(name="sfxmmc",  nullable=true)
	public String getSfxmmc() {
		return sfxmmc;
	}

	public void setSfxmmc(String sfxmmc) {
		this.sfxmmc = sfxmmc;
	}

	@Column(name="sfje",  nullable=true)
	public BigDecimal getSfje() {
		return sfje;
	}

	public void setSfje(BigDecimal sfje) {
		this.sfje = sfje;
	}

	@Column(name="sfrq",  nullable=true)
	public Date getSfrq() {
		return sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}
	
	@Column(name="sfr",  nullable=true)
	public String getSfr() {
		return sfr;
	}

	public void setSfr(String sfr) {
		this.sfr = sfr;
	}

	@Column(name="bz",  nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="pjfl", length=50, nullable=true)
	public String getPjfl() {
		return pjfl;
	}

	public void setPjfl(String pjfl) {
		this.pjfl = pjfl;
	}

	@Column(name="pjhm", length=50, nullable=true)
	public String getPjhm() {
		return pjhm;
	}

	public void setPjhm(String pjhm) {
		this.pjhm = pjhm;
	}
	
	

}
