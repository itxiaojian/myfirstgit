package com.zssi.framework.app.cbgl.model;

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
 * 成本管理--成本信息
 * @author wangyong
 * @date 2015年10月12日
 */
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_cbxx")
public class YcwCbxx implements Serializable{

	private Integer id;         //主键ID
	
	private String ksbh;        //科室编号
	
	private String jybh;        //检验编号
	
	private String ypmc;        //项目名称
	
	private String xxnr;        //项目详细内容
	
	private BigDecimal cbhj;    //成本合计
	
	private Date lrrq;          //录入日期
	
	private String lrr;         //录入人

	private String xgr;         //修改人
	
	private Date xgrq;          //修改日期
	
	private String xgyy;        //修改原因
	
	private String bz;          //备注
	
	private Date fssj;          //费用发生时间
	
	private String cbbh;        //成本编号

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

	@Column(name="xxnr", length=3000, nullable=true)
	public String getXxnr() {
		return xxnr;
	}

	public void setXxnr(String xxnr) {
		this.xxnr = xxnr;
	}

	@Column(name="cbhj", length=50, nullable=true)
	public BigDecimal getCbhj() {
		return cbhj;
	}

	public void setCbhj(BigDecimal cbhj) {
		this.cbhj = cbhj;
	}

	@Column(name="lrrq", length=50, nullable=true)
	public Date getLrrq() {
		return lrrq;
	}

	public void setLrrq(Date lrrq) {
		this.lrrq = lrrq;
	}

	@Column(name="lrr", length=50, nullable=true)
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
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

	@Column(name="fssj",nullable=true)
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
