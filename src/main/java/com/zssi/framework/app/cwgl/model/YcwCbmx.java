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
 * 财务管理--成本明细
 * @author wangyong
 * @date 2015年10月12日
 */
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_cbmx")
public class YcwCbmx implements Serializable{

	private Integer id;         //主键ID
	
	private String jybh;        //检验编号
	
	private String fylx;        //费用类型
	
	private String xmmc;        //费用项目名称
	
	private String fyxq;        //费用详情
	
	private BigDecimal je;      //金额
	
	private String ksbh;    //科室编号
	
	private Date lrrq;     //录入日期
	
	private Date fssj;     //费用发生日期
	
	private String pjbh;   //票据编号
	
	private String cbbh;   //成本编号

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

	@Column(name="jybh", length=50, nullable=true)
	public String getJybh() {
		return jybh;
	}

	public void setJybh(String jybh) {
		this.jybh = jybh;
	}

	@Column(name="fylx", length=50, nullable=true)
	public String getFylx() {
		return fylx;
	}

	public void setFylx(String fylx) {
		this.fylx = fylx;
	}

	@Column(name="xmmc", length=50, nullable=true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Column(name="fyxq", length=500, nullable=true)
	public String getFyxq() {
		return fyxq;
	}

	public void setFyxq(String fyxq) {
		this.fyxq = fyxq;
	}

	@Column(name="je", length=50, nullable=true)
	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	@Column(name="ksbh", length=50, nullable=true)
	public String getKsbh() {
		return ksbh;
	}

	public void setKsbh(String ksbh) {
		this.ksbh = ksbh;
	}

	@Column(name="lrrq", nullable=true)
	public Date getLrrq() {
		return lrrq;
	}

	public void setLrrq(Date lrrq) {
		this.lrrq = lrrq;
	}

	@Column(name="pjbh", length=200, nullable=true)
	public String getPjbh() {
		return pjbh;
	}

	public void setPjbh(String pjbh) {
		this.pjbh = pjbh;
	}

	@Column(name="fssj", nullable=true)
	public Date getFssj() {
		return fssj;
	}

	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}   
	
	@Column(name="cbbh", length=50, nullable=true)
	public String getCbbh() {
		return cbbh;
	}

	public void setCbbh(String cbbh) {
		this.cbbh = cbbh;
	}
	
}	
