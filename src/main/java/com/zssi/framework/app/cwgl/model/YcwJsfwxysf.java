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


//技术服务协议收费
//liusong 2015-12-24
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_jsfwxysf")
public class YcwJsfwxysf implements Serializable {
	
	private Integer id;
	
	private String xybh;
	
	private String khmc;
	
	private String khdz;
	
	private String xylx;
	
	private String frdb;
	
	private String lxdh;
	
	private String cpmc;
	
	private String fwxm;
	
	private Date sxrq;
	
	private Date zzrq;
	
	private String xyks_id;
	
	private String zxbz;
	
	private String xyzy;
	
	private BigDecimal xyje;
	
	private Integer fkfs;
	
	private String bgbh;
	
	private String qzqk;
	
	private String xxqk;
	
	private String xyfzr;
	
	private String jyks_id;
	
	private String ywks_id;
	
	private String ssks_id;
	
	private BigDecimal ysje;
	
	private BigDecimal ysfje;
	
	private BigDecimal bcss;
	
	private Date sfrq;
	
	private String sfr;
	
	private String bz;
	
    private String pjfl;    //票据分类
	
	private String pjhm;     //票据号码
	
	private String srfl;     //收入分类
	

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

	@Column(name="xybh",  nullable=true)
	public String getXybh() {
		return xybh;
	}

	public void setXybh(String xybh) {
		this.xybh = xybh;
	}

	@Column(name="khmc",  nullable=true)
	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	@Column(name="khdz",  nullable=true)
	public String getKhdz() {
		return khdz;
	}

	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}

	@Column(name="xylx",  nullable=true)
	public String getXylx() {
		return xylx;
	}

	public void setXylx(String xylx) {
		this.xylx = xylx;
	}

	@Column(name="frdb",  nullable=true)
	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	@Column(name="lxdh",  nullable=true)
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name="cpmc",  nullable=true)
	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	@Column(name="fwxm",  nullable=true)
	public String getFwxm() {
		return fwxm;
	}

	public void setFwxm(String fwxm) {
		this.fwxm = fwxm;
	}

	@Column(name="sxrq",  nullable=true)
	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	@Column(name="zzrq",  nullable=true)
	public Date getZzrq() {
		return zzrq;
	}

	public void setZzrq(Date zzrq) {
		this.zzrq = zzrq;
	}

	@Column(name="xyks_id",  nullable=true)
	public String getXyks_id() {
		return xyks_id;
	}

	public void setXyks_id(String xyks_id) {
		this.xyks_id = xyks_id;
	}

	@Column(name="zxbz",  nullable=true)
	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	@Column(name="xyzy",  nullable=true)
	public String getXyzy() {
		return xyzy;
	}

	public void setXyzy(String xyzy) {
		this.xyzy = xyzy;
	}

	@Column(name="xyje",  nullable=true)
	public BigDecimal getXyje() {
		return xyje;
	}

	public void setXyje(BigDecimal xyje) {
		this.xyje = xyje;
	}

	@Column(name="fkfs",  nullable=true)
	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	@Column(name="bgbh",  nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="qzqk",  nullable=true)
	public String getQzqk() {
		return qzqk;
	}

	public void setQzqk(String qzqk) {
		this.qzqk = qzqk;
	}

	@Column(name="xxqk",  nullable=true)
	public String getXxqk() {
		return xxqk;
	}

	public void setXxqk(String xxqk) {
		this.xxqk = xxqk;
	}

	@Column(name="xyfzr",  nullable=true)
	public String getXyfzr() {
		return xyfzr;
	}

	public void setXyfzr(String xyfzr) {
		this.xyfzr = xyfzr;
	}

	@Column(name="jyks_id",  nullable=true)
	public String getJyks_id() {
		return jyks_id;
	}

	public void setJyks_id(String jyks_id) {
		this.jyks_id = jyks_id;
	}

	@Column(name="ywks_id",  nullable=true)
	public String getYwks_id() {
		return ywks_id;
	}

	public void setYwks_id(String ywks_id) {
		this.ywks_id = ywks_id;
	}

	@Column(name="ssks_id",  nullable=true)
	public String getSsks_id() {
		return ssks_id;
	}

	public void setSsks_id(String ssks_id) {
		this.ssks_id = ssks_id;
	}

	@Column(name="ysje",  nullable=true)
	public BigDecimal getYsje() {
		return ysje;
	}

	public void setYsje(BigDecimal ysje) {
		this.ysje = ysje;
	}

	@Column(name="ysfje",  nullable=true)
	public BigDecimal getYsfje() {
		return ysfje;
	}

	public void setYsfje(BigDecimal ysfje) {
		this.ysfje = ysfje;
	}

	@Column(name="bcss",  nullable=true)
	public BigDecimal getBcss() {
		return bcss;
	}

	public void setBcss(BigDecimal bcss) {
		this.bcss = bcss;
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
	
	@Column(name="srfl", length=200, nullable=true)
	public String getSrfl() {
		return srfl;
	}

	public void setSrfl(String srfl) {
		this.srfl = srfl;
	}

}
