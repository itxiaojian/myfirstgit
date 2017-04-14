package com.zssi.framework.app.jygl.model;

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
 * 检验报告信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Entity
@Table(name = "y_jy_bgxx")
public class YjyBgxx implements Serializable{
	
	/**主键*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**报告名称*/
	private String bgmc;
	
	/**检验日期*/
	private String jyrq;
	
	/**编制人*/
	private String bzr;
	
	/**接收单位*/
	private String jsdw1;
	
	/**接收人*/
	private String jsr;
	
	/**发放日期*/
	private Date ffrq;
	
	/**发放状态*/
	private Integer ffzt;
	
	/**退检日期*/
	private Date tjrq;
	
	/**退检原因*/
	private String tjyy;
	
	/**退检人*/
	private String tjr;
	
	/**备注*/
	private String bz;
	
	/**二维码编号*/
	private String ewmbh;
	
	/**二维码图片*/
	private String ewmtp;
	
	/**编制方式*/
	private Integer bzfs;
	
	/**检验结论*/
	private String jyjl;
	
	/**认证方式*/
	private String rzfs;
	
	/**报审对象*/
	private String bsdx;
	
	/**抽样单位*/
	private String cydw;
	
	/**打印次数*/
	private String dycs;
	
	/**打印状态*/
	private Integer dyzt;
	
	/**是否解锁（0：未解锁；1：已解锁）*/
	private Integer sfjs;
	
	/**检验情况说明*/
	private String jyqksm;
	
	/**检验结束时间*/
//	private Date jyjsrq;
	
	/**单位名称图片*/
	private String dwmctp;
	
	/**检验科室*/
	private String jyks;
	
	/**业务科室*/
	private String ywks;
	
	/**章名称图片*/
	private String yzmctp;
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bgbh", length=50, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="bgmc", length=50, nullable=true)
	public String getBgmc() {
		return bgmc;
	}

	public void setBgmc(String bgmc) {
		this.bgmc = bgmc;
	}

	@Column(name="jyrq", length=6, nullable=true)
	public String getJyrq() {
		return jyrq;
	}

	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
	}
//	public Date getJyrq() {
//		return jyrq;
//	}
//
//	public void setJyrq(Date jyrq) {
//		this.jyrq = jyrq;
//	}

	@Column(name="bzr", length=50, nullable=true)
	public String getBzr() {
		return bzr;
	}

	public void setBzr(String bzr) {
		this.bzr = bzr;
	}

	@Column(name="jsdw1", length=100, nullable=true)
	public String getJsdw1() {
		return jsdw1;
	}

	public void setJsdw1(String jsdw1) {
		this.jsdw1 = jsdw1;
	}

	@Column(name="jsr", length=50, nullable=true)
	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	@Column(name="ffrq", length=6, nullable=true)
	public Date getFfrq() {
		return ffrq;
	}

	public void setFfrq(Date ffrq) {
		this.ffrq = ffrq;
	}

	@Column(name="ffzt", length=50, nullable=true)
	public Integer getFfzt() {
		return ffzt;
	}

	public void setFfzt(Integer ffzt) {
		this.ffzt = ffzt;
	}

	@Column(name="tjrq", length=6, nullable=true)
	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}

	@Column(name="tjyy", length=500, nullable=true)
	public String getTjyy() {
		return tjyy;
	}

	public void setTjyy(String tjyy) {
		this.tjyy = tjyy;
	}

	@Column(name="tjr", length=50, nullable=true)
	public String getTjr() {
		return tjr;
	}

	public void setTjr(String tjr) {
		this.tjr = tjr;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="ewmbh", length=4000, nullable=true)
	public String getEwmbh() {
		return ewmbh;
	}

	public void setEwmbh(String ewmbh) {
		this.ewmbh = ewmbh;
	}

	@Column(name="ewmtp", length=4000, nullable=true)
	public String getEwmtp() {
		return ewmtp;
	}

	public void setEwmtp(String ewmtp) {
		this.ewmtp = ewmtp;
	}
	
	@Column(name="bzfs", length=100, nullable=true)
	public Integer getBzfs() {
		return bzfs;
	}

	public void setBzfs(Integer bzfs) {
		this.bzfs = bzfs;
	}

	@Column(name="jyjl", length=1000, nullable=true)
	public String getJyjl() {
		return jyjl;
	}

	public void setJyjl(String jyjl) {
		this.jyjl = jyjl;
	}

	@Column(name="rzfs", length=1000, nullable=true)
	public String getRzfs() {
		return rzfs;
	}

	public void setRzfs(String rzfs) {
		this.rzfs = rzfs;
	}
	
	@Column(name="bsdx", length=1000, nullable=true)
	public String getBsdx() {
		return bsdx;
	}

	public void setBsdx(String bsdx) {
		this.bsdx = bsdx;
	}

	@Column(name="cydw", length=1000, nullable=true)
	public String getCydw() {
		return cydw;
	}

	public void setCydw(String cydw) {
		this.cydw = cydw;
	}

	@Column(name="dycs", length=100, nullable=true)
	public String getDycs() {
		return dycs;
	}

	public void setDycs(String dycs) {
		this.dycs = dycs;
	}

	@Column(name="dyzt", length=22, nullable=true)
	public Integer getDyzt() {
		return dyzt;
	}

	public void setDyzt(Integer dyzt) {
		this.dyzt = dyzt;
	}
	
	@Column(name="sfjs", length=22, nullable=true)
	public Integer getSfjs() {
		return sfjs;
	}

	public void setSfjs(Integer sfjs) {
		this.sfjs = sfjs;
	}
	
	@Column(name="jyqksm", length=1000, nullable=true)
	public String getJyqksm() {
		return jyqksm;
	}

	public void setJyqksm(String jyqksm) {
		this.jyqksm = jyqksm;
	}
	
//	@Column(name="jyjsrq", length=100, nullable=true)
//	public Date getJyjsrq() {
//		return jyjsrq;
//	}
//
//	public void setJyjsrq(Date jyjsrq) {
//		this.jyjsrq = jyjsrq;
//	}
	
	@Column(name="dwmctp", length=1000, nullable=true)
	public String getDwmctp() {
		return dwmctp;
	}

	public void setDwmctp(String dwmctp) {
		this.dwmctp = dwmctp;
	}
	
	@Column(name="jyks", length=1000, nullable=true)
	public String getJyks() {
		return jyks;
	}

	public void setJyks(String jyks) {
		this.jyks = jyks;
	}

	@Column(name="ywks", length=1000, nullable=true)
	public String getYwks() {
		return ywks;
	}

	public void setYwks(String ywks) {
		this.ywks = ywks;
	}
	
	@Column(name="yzmctp", length=1000, nullable=true)
	public String getYzmctp() {
		return yzmctp;
	}

	public void setYzmctp(String yzmctp) {
		this.yzmctp = yzmctp;
	}
}
