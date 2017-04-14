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
 * 财务管理--员工福利
 * @author wangyong
 * @date 2015年10月13日
 */
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_ygfl")
public class YcwYgfl implements Serializable{

	private Integer id;         //主键ID
	
	private String flbh;        //员工编号
	
	private String ygxm;        //员工姓名
	
	private String ks_id;       //所属科室
	
	private String ssyf;        //所属月份
	
	private BigDecimal flhj;    //金额
	
	private Date lrrq;          //录入日期

	private String lrr;         //录入人
	
    private String xgr;         //修改人
	
	private Date xgrq;          //修改日期
	
	private String xgyy;        //修改原因

	private String bz;          //备注
	
	private String gzxjmc;      //工资薪金名称
	
	private String gzxjxq;      //工资薪金详情


	
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

	@Column(name="flbh", length=50, nullable=true)
	public String getFlbh() {
		return flbh;
	}

	public void setFlbh(String flbh) {
		this.flbh = flbh;
	}

	@Column(name="ygxm", length=50, nullable=true)
	public String getYgxm() {
		return ygxm;
	}

	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}

	@Column(name="ks_id", length=50, nullable=true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}

	@Column(name="ssyf", length=50, nullable=true)
	public String getSsyf() {
		return ssyf;
	}

	public void setSsyf(String ssyf) {
		this.ssyf = ssyf;
	}

	@Column(name="flhj", length=500, nullable=true)
	public BigDecimal getFlhj() {
		return flhj;
	}

	public void setFlhj(BigDecimal flhj) {
		this.flhj = flhj;
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

	@Column(name="xgyy", length=50, nullable=true)
	public String getXgyy() {
		return xgyy;
	}

	public void setXgyy(String xgyy) {
		this.xgyy = xgyy;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name="gzxjmc", length=100, nullable=true)
	public String getGzxjmc() {
		return gzxjmc;
	}

	public void setGzxjmc(String gzxjmc) {
		this.gzxjmc = gzxjmc;
	}

	@Column(name="gzxjxq", length=500, nullable=true)
	public String getGzxjxq() {
		return gzxjxq;
	}

	public void setGzxjxq(String gzxjxq) {
		this.gzxjxq = gzxjxq;
	}
}	
