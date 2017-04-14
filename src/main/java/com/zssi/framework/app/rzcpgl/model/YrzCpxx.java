package com.zssi.framework.app.rzcpgl.model;

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
 * 认证产品信息
 * @author wangyong
 * @date 2015年10月9日
 */
@Entity
@Table(name="y_rz_cpxx")
public class YrzCpxx implements Serializable{

	private Integer id;         //主键ID
	
	private String cpbh;        //产品编号
	
	private String cpmc;        //产品名称
	
	private String cpxh;        //产品型号
	
	private String cpcs;        //产品参数
	
	private String zzs;         //制造商
	
	private String scgc;        //生产工厂
	
	private Date rzrq;          //认证日期

	private String rzlx;        //认证类型
	
	private String bgbh_id;     //报告编号ID
	
	private Date yxq;           //有效期
	
	private Date xgsj;          //修改时间
	
	private String xgr;         //修改人
	
	private String bz;          //备注

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_RZ_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="cpbh", length=50, nullable=true)
	public String getCpbh() {
		return cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	@Column(name="cpmc", length=50, nullable=true)
	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	@Column(name="cpxh", length=100, nullable=true)
	public String getCpxh() {
		return cpxh;
	}

	public void setCpxh(String cpxh) {
		this.cpxh = cpxh;
	}

	@Column(name="cpcs", length=100, nullable=true)
	public String getCpcs() {
		return cpcs;
	}

	public void setCpcs(String cpcs) {
		this.cpcs = cpcs;
	}

	@Column(name="zzs", length=100, nullable=true)
	public String getZzs() {
		return zzs;
	}

	public void setZzs(String zzs) {
		this.zzs = zzs;
	}

	@Column(name="scgc", length=100, nullable=true)
	public String getScgc() {
		return scgc;
	}

	public void setScgc(String scgc) {
		this.scgc = scgc;
	}

	@Column(name="rzrq", length=50, nullable=true)
	public Date getRzrq() {
		return rzrq;
	}

	public void setRzrq(Date rzrq) {
		this.rzrq = rzrq;
	}

	@Column(name="rzlx", length=100, nullable=true)
	public String getRzlx() {
		return rzlx;
	}

	public void setRzlx(String rzlx) {
		this.rzlx = rzlx;
	}

	@Column(name="bgbh_id", length=50, nullable=true)
	public String getBgbh_id() {
		return bgbh_id;
	}

	public void setBgbh_id(String bgbh_id) {
		this.bgbh_id = bgbh_id;
	}

	@Column(name="yxq", length=50, nullable=true)
	public Date getYxq() {
		return yxq;
	}

	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}

	@Column(name="xgsj", length=50, nullable=true)
	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	@Column(name="xgr", length=50, nullable=true)
	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
