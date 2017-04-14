package com.zssi.framework.app.jygl.model;

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

/**
 * 检验信息
 * @author duanpeijun
 * @date 2015年10月9日
 */
@Entity
@Table(name = "y_jy_jyxx")
public class YjyJyxx implements Serializable{

	/**id*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**样品编号*/
	private String ypbh;
	
	/**检验类别*/
	private String jylb;
	
	/**样品类别*/
	private String yplb;
	
	/**检验科室*/
	private String bmbh;
	
	/**登记日期*/
	private Date djrq;
	
	/**检验依据*/
	private String jyyj;
	
	/**检验期限*/
	private Date jyqx;
	
	/**标准编号*/
	private String bzbh;
	
	/**检验标准名称*/
	private String bzmc;
	
	/**主检人*/
	private String zjr;
	
	/**开始日期*/
	private Date ksrq;
	
	/**结束日期*/
	private Date jsrq;
	
	/**环境条件*/
	private String hjtj;
	
	/**检验项目描述*/
	private String xmms;
	
	/**检验方法*/
	private String jyff;
	
	/**判定要求*/
	private String pdyq;
	
	/**其他说明*/
	private String qtsm;
	
	/**检验费用*/
	private BigDecimal jyfy;
	
	/**加急费用*/
	private BigDecimal jjfy;
	
	/**其他费用*/
	private BigDecimal qtfy;
	
	/**费用合计*/
	private BigDecimal fyhj;
	
	/**实物判定*/
	private String swpd;
	
	/**标识判定*/
	private String bzpd;
	
	/**检验结论*/
	private String jyjl;
	
	/**认证方式*/
	private String rzfs;
	
	/**检验状态*/
	private String jyzt;
	
	/**退检日期*/
	private Date tjrq;
	
	/**退检原因*/
	private String tjyy;
	
	/**退检人*/
	private String tjr;
	
	/**催办状态*/
	private Integer tbzt;
	
	/**备注*/
	private String bz;

	
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

	@Column(name="ypbh", length=50, nullable=true)
	public String getYpbh() {
		return ypbh;
	}

	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}

	@Column(name="jylb", length=50, nullable=true)
	public String getJylb() {
		return jylb;
	}

	public void setJylb(String jylb) {
		this.jylb = jylb;
	}

	@Column(name="yplb", length=50, nullable=true)
	public String getYplb() {
		return yplb;
	}

	public void setYplb(String yplb) {
		this.yplb = yplb;
	}

	@Column(name="bmbh", length=50, nullable=true)
	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	@Column(name="djrq", length=6, nullable=true)
	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	@Column(name="jyyj", length=500, nullable=true)
	public String getJyyj() {
		return jyyj;
	}

	public void setJyyj(String jyyj) {
		this.jyyj = jyyj;
	}

	@Column(name="jyqx", length=6, nullable=true)
	public Date getJyqx() {
		return jyqx;
	}

	public void setJyqx(Date jyqx) {
		this.jyqx = jyqx;
	}

	@Column(name="bzbh", length=50, nullable=true)
	public String getBzbh() {
		return bzbh;
	}

	public void setBzbh(String bzbh) {
		this.bzbh = bzbh;
	}

	@Column(name="bzmc", length=50, nullable=true)
	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}

	@Column(name="zjr", length=50, nullable=true)
	public String getZjr() {
		return zjr;
	}

	public void setZjr(String zjr) {
		this.zjr = zjr;
	}

	@Column(name="ksrq", length=6, nullable=true)
	public Date getKsrq() {
		return ksrq;
	}

	public void setKsrq(Date ksrq) {
		this.ksrq = ksrq;
	}

	@Column(name="jsrq", length=6, nullable=true)
	public Date getJsrq() {
		return jsrq;
	}

	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}

	@Column(name="hjtj", length=300, nullable=true)
	public String getHjtj() {
		return hjtj;
	}

	public void setHjtj(String hjtj) {
		this.hjtj = hjtj;
	}

	@Column(name="xmms", length=300, nullable=true)
	public String getXmms() {
		return xmms;
	}

	public void setXmms(String xmms) {
		this.xmms = xmms;
	}

	@Column(name="jyff", length=100, nullable=true)
	public String getJyff() {
		return jyff;
	}

	public void setJyff(String jyff) {
		this.jyff = jyff;
	}

	@Column(name="pdyq", length=50, nullable=true)
	public String getPdyq() {
		return pdyq;
	}

	public void setPdyq(String pdyq) {
		this.pdyq = pdyq;
	}

	@Column(name="qtsm", length=300, nullable=true)
	public String getQtsm() {
		return qtsm;
	}

	public void setQtsm(String qtsm) {
		this.qtsm = qtsm;
	}

	@Column(name="jyfy", length=50, nullable=true)
	public BigDecimal getJyfy() {
		return jyfy;
	}

	public void setJyfy(BigDecimal jyfy) {
		this.jyfy = jyfy;
	}

	@Column(name="jjfy", length=50, nullable=true)
	public BigDecimal getJjfy() {
		return jjfy;
	}

	public void setJjfy(BigDecimal jjfy) {
		this.jjfy = jjfy;
	}

	@Column(name="qtfy", length=50, nullable=true)
	public BigDecimal getQtfy() {
		return qtfy;
	}

	public void setQtfy(BigDecimal qtfy) {
		this.qtfy = qtfy;
	}

	@Column(name="fyhj", length=50, nullable=true)
	public BigDecimal getFyhj() {
		return fyhj;
	}

	public void setFyhj(BigDecimal fyhj) {
		this.fyhj = fyhj;
	}

	@Column(name="swpd", length=50, nullable=true)
	public String getSwpd() {
		return swpd;
	}

	public void setSwpd(String swpd) {
		this.swpd = swpd;
	}

	@Column(name="bzpd", length=50, nullable=true)
	public String getBzpd() {
		return bzpd;
	}

	public void setBzpd(String bzpd) {
		this.bzpd = bzpd;
	}

	@Column(name="jyjl", length=50, nullable=true)
	public String getJyjl() {
		return jyjl;
	}

	public void setJyjl(String jyjl) {
		this.jyjl = jyjl;
	}

	@Column(name="rzfs", length=50, nullable=true)
	public String getRzfs() {
		return rzfs;
	}

	public void setRzfs(String rzfs) {
		this.rzfs = rzfs;
	}

	@Column(name="jyzt", length=50, nullable=true)
	public String getJyzt() {
		return jyzt;
	}

	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
	}

	@Column(name="tjrq", length=50, nullable=true)
	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}

	@Column(name="tjyy", length=50, nullable=true)
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

	@Column(name="tbzt", length=50, nullable=true)
	public Integer getTbzt() {
		return tbzt;
	}

	public void setTbzt(Integer tbzt) {
		this.tbzt = tbzt;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
