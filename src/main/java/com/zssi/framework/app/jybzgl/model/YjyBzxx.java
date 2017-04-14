package com.zssi.framework.app.jybzgl.model;

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
 * 检验标准管理开发-检验标准
 * @author mabiao
 *
 */

@Entity
@Table(name="y_jy_bzxx")
public class YjyBzxx implements Serializable{
	
	private Integer id;//序号
	
	private String bzbh;//标准编号
	
	private String bzmc;//检验标准名称
	
	private String bzmc_fz;//标准名称附注
	
	private String pyjm;//拼音简码
	
	private String bzlb;//标准类别
	
	private String bzjb;//标准级别
	
	private Date qyrq;//标准启用日期
	
	private String ks_id;//使用科室ID
	
	private String xmbh_id;//下属项目编号
	
	private Date zhxgrq;//最后修改日期
	
	private String xgr;//修改人
	
	private Integer fzzt;//废止状态
	
	private Date fzrq;//废止日期
	
	private String fzdjr;//废止登记人
	
	private Integer shzt;//审核状态
	
	private Date shrq;//审核日期
	
	private String shr;//审核人
	
	private Date kssj;//开始时间
	
	private Date jssj;//结束时间
	
	private String bz;//备注

	
	@Id
	//也可以使用sequence生成方式,SEQ_SYS_SJZD_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bzbh",length=50,nullable=true)
	public String getBzbh() {
		return bzbh;
	}

	public void setBzbh(String bzbh) {
		this.bzbh = bzbh;
	}

	@Column(name="bzmc",length=50,nullable=true)
	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	@Column(name="bzmc_fz",length=100,nullable=true)
	public String getBzmc_fz() {
		return bzmc_fz;
	}

	public void setBzmc_fz(String bzmc_fz) {
		this.bzmc_fz = bzmc_fz;
	}

	@Column(name="pyjm",length=50,nullable=true)
	public String getPyjm() {
		return pyjm;
	}

	public void setPyjm(String pyjm) {
		this.pyjm = pyjm;
	}

	@Column(name="bzlb",length=50,nullable=true)
	public String getBzlb() {
		return bzlb;
	}

	public void setBzlb(String bzlb) {
		this.bzlb = bzlb;
	}

	@Column(name="bzjb",length=50,nullable=true)
	public String getBzjb() {
		return bzjb;
	}

	public void setBzjb(String bzjb) {
		this.bzjb = bzjb;
	}

	@Column(name="qyrq",length=6,nullable=true)
	public Date getQyrq() {
		return qyrq;
	}

	public void setQyrq(Date qyrq) {
		this.qyrq = qyrq;
	}

	@Column(name="ks_id",length=300,nullable=true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}

	@Column(name="xmbh_id",length=300,nullable=true)
	public String getXmbh_id() {
		return xmbh_id;
	}

	public void setXmbh_id(String xmbh_id) {
		this.xmbh_id = xmbh_id;
	}

	@Column(name="zhxgrq",length=6,nullable=true)
	public Date getZhxgrq() {
		return zhxgrq;
	}

	public void setZhxgrq(Date zhxgrq) {
		this.zhxgrq = zhxgrq;
	}

	@Column(name="xgr",length=50,nullable=true)
	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	@Column(name="fzzt",nullable=true)
	public Integer getFzzt() {
		return fzzt;
	}

	public void setFzzt(Integer fzzt) {
		this.fzzt = fzzt;
	}

	@Column(name="fzrq",length=6,nullable=true)
	public Date getFzrq() {
		return fzrq;
	}

	public void setFzrq(Date fzrq) {
		this.fzrq = fzrq;
	}

	@Column(name="fzdjr",length=50,nullable=true)
	public String getFzdjr() {
		return fzdjr;
	}

	public void setFzdjr(String fzdjr) {
		this.fzdjr = fzdjr;
	}

	@Column(name="shzt",nullable=true)
	public Integer getShzt() {
		return shzt;
	}

	public void setShzt(Integer shzt) {
		this.shzt = shzt;
	}

	@Column(name="shrq",length=6,nullable=true)
	public Date getShrq() {
		return shrq;
	}

	public void setShrq(Date shrq) {
		this.shrq = shrq;
	}

	@Column(name="shr",length=50,nullable=true)
	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	@Column(name="kssj",length=6,nullable=true)
	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	@Column(name="jssj",length=6,nullable=true)
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	@Column(name="bz",length=500,nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
