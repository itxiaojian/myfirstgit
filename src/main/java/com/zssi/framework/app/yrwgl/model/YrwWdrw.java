package com.zssi.framework.app.yrwgl.model;

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
 * 功能--我的任务
 * @author Administrator
 *
 */
@Entity
@Table(name="Y_RW_WDRW")
public class YrwWdrw implements Serializable {
	
	private Integer id;//任务ID
	
	private String bgbh;//报告编号
	
	private String rwmc;//任务名称
	
	private String ssxm;//所属项目
	
	private String rwlx;//任务类型
	
	private Date yqksrq;//要求开始日期
	
	private Date yqjsrq;//要求结束日期
	
	private Date sjksrq;//实际开始日期
	
	private Date sjjsrq;//实际结束日期
	
	private String wcjd;//完成进度
	
	private String rwfzr;//任务负责人
	
	private String rwly;//任务来源

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_YP_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bgbh", length=100, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="rwmc", length=400, nullable=true)
	public String getRwmc() {
		return rwmc;
	}

	public void setRwmc(String rwmc) {
		this.rwmc = rwmc;
	}

	@Column(name="ssxm", length=400, nullable=true)
	public String getSsxm() {
		return ssxm;
	}

	public void setSsxm(String ssxm) {
		this.ssxm = ssxm;
	}

	@Column(name="rwlx", length=200, nullable=true)
	public String getRwlx() {
		return rwlx;
	}

	public void setRwlx(String rwlx) {
		this.rwlx = rwlx;
	}

	@Column(name="yqksrq", length=6, nullable=true)
	public Date getYqksrq() {
		return yqksrq;
	}

	public void setYqksrq(Date yqksrq) {
		this.yqksrq = yqksrq;
	}

	@Column(name="yqjsrq", length=6, nullable=true)
	public Date getYqjsrq() {
		return yqjsrq;
	}

	public void setYqjsrq(Date yqjsrq) {
		this.yqjsrq = yqjsrq;
	}

	@Column(name="sjksrq", length=6, nullable=true)
	public Date getSjksrq() {
		return sjksrq;
	}

	public void setSjksrq(Date sjksrq) {
		this.sjksrq = sjksrq;
	}

	@Column(name="sjjsrq", length=6, nullable=true)
	public Date getSjjsrq() {
		return sjjsrq;
	}

	public void setSjjsrq(Date sjjsrq) {
		this.sjjsrq = sjjsrq;
	}

	@Column(name="wcjd", length=200, nullable=true)
	public String getWcjd() {
		return wcjd;
	}

	public void setWcjd(String wcjd) {
		this.wcjd = wcjd;
	}

	@Column(name="rwfzr", length=100, nullable=true)
	public String getRwfzr() {
		return rwfzr;
	}

	public void setRwfzr(String rwfzr) {
		this.rwfzr = rwfzr;
	}

	@Column(name="rwly", length=100, nullable=true)
	public String getRwly() {
		return rwly;
	}

	public void setRwly(String rwly) {
		this.rwly = rwly;
	}
	
}
