package com.zssi.framework.app.sgzgl.model;

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
 * 
 * @author liangkaidi
 * @date 2015-10-21
 */
@Entity
@Table(name = "y_sgz_xx")
public class YsgzXx implements Serializable {
	private Integer id; // 序号
	private String sgzbh;// 上岗证编号
	private String rybh;// 人员编号
	private String ks_id;// 所属科室ID
	private Integer zcid; // 职称ID
	private String cplx;// 产品类别
	private Date yxq;// 有效期
	private String kczsb;// 可操作设备编号（设备编号之间用英文逗号隔开）
	private Date xgrq;// 修改日期
	private String xgr_id;// 修改人ID
	private String bz;// 备注

	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)用于MySQL数据库
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_SGZ_ID")})  // 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "sgzbh", length = 50, nullable = true)
	public String getSgzbh() {
		return sgzbh;
	}

	public void setSgzbh(String sgzbh) {
		this.sgzbh = sgzbh;
	}
	@Column(name = "rybh", length = 50, nullable = true)
	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	@Column(name = "ks_id", length = 50, nullable = true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}
	@Column(name = "zcid", length = 50, nullable = true)
	public Integer getZcid() {
		return zcid;
	}

	public void setZcid(Integer zcid) {
		this.zcid = zcid;
	}
	@Column(name = "cplx", length = 50, nullable = true)
	public String getCplx() {
		return cplx;
	}

	public void setCplx(String cplx) {
		this.cplx = cplx;
	}
	@Column(name = "yxq", length = 50, nullable = true)
	public Date getYxq() {
		return yxq;
	}

	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}
	@Column(name = "kczsb", length = 300, nullable = true)
	public String getKczsb() {
		return kczsb;
	}

	public void setKczsb(String kczsb) {
		this.kczsb = kczsb;
	}
	@Column(name = "xgrq", length = 50, nullable = true)
	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}
	@Column(name = "xgr_id", length = 50, nullable = true)
	public String getXgr_id() {
		return xgr_id;
	}

	public void setXgr_id(String xgr_id) {
		this.xgr_id = xgr_id;
	}
	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
