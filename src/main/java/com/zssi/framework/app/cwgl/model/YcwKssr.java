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

/**
 * 成本管理--科室收入
 * @author wangyong
 * @date 2015年10月13日
 */
@Entity
@Table(name="y_cw_kssr")
public class YcwKssr implements Serializable{

	private Integer id;         //主键ID
	
	private String ksbh;        //科室编号
	
	private String ksmc;        //科室名称
	
	private String jybh;        //检验编号
	
	private String ypmc;        //项目名称 
	
	private String ypxq;        //样品详情

	private BigDecimal cbje;    //成本金额
	
	private BigDecimal skje;    //收款金额
	
    private BigDecimal hssr;    //核算收入 
	
	private String lrr;         //录入人

	private Date lrrq;          //录入日期
	
	private BigDecimal xgje;    //修改金额
	
	private String xgr;         //修改人
	
    private Date xgrq;          //修改日期
	
	private String xgyy;        //修改原因
	
	private String bz;          //备注

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

	@Column(name="ksbh", length=50, nullable=true)
	public String getKsbh() {
		return ksbh;
	}

	public void setKsbh(String ksbh) {
		this.ksbh = ksbh;
	}
	
	@Column(name="ksmc", length=50, nullable=true)
	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	@Column(name="jybh", length=50, nullable=true)
	public String getJybh() {
		return jybh;
	}

	public void setJybh(String jybh) {
		this.jybh = jybh;
	}

	@Column(name="ypmc", length=50, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="ypxq", length=300, nullable=true)
	public String getYpxq() {
		return ypxq;
	}

	public void setYpxq(String ypxq) {
		this.ypxq = ypxq;
	}

	@Column(name="cbje", length=50, nullable=true)
	public BigDecimal getCbje() {
		return cbje;
	}

	public void setCbje(BigDecimal cbje) {
		this.cbje = cbje;
	}

	@Column(name="skje", length=50, nullable=true)
	public BigDecimal getSkje() {
		return skje;
	}

	public void setSkje(BigDecimal skje) {
		this.skje = skje;
	}

	@Column(name="hssr", length=50, nullable=true)
	public BigDecimal getHssr() {
		return hssr;
	}

	public void setHssr(BigDecimal hssr) {
		this.hssr = hssr;
	}

	@Column(name="lrr", length=50, nullable=true)
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	@Column(name="lrrq", length=50, nullable=true)
	public Date getLrrq() {
		return lrrq;
	}

	public void setLrrq(Date lrrq) {
		this.lrrq = lrrq;
	}

	@Column(name="xgje", length=50, nullable=true)
	public BigDecimal getXgje() {
		return xgje;
	}

	public void setXgje(BigDecimal xgje) {
		this.xgje = xgje;
	}

	@Column(name="xgr", length=50, nullable=true)
	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	@Column(name="xgrq", length=50, nullable=true)
	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}

	@Column(name="xgyy", length=200, nullable=true)
	public String getXgyy() {
		return xgyy;
	}

	public void setXgyy(String xgyy) {
		this.xgyy = xgyy;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	
}	
