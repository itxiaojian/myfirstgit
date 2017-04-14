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
 * 功能--任务下达
 * @author Administrator
 *
 */
@Entity
@Table(name="Y_RW_RWZP")
public class YrwRwzp implements Serializable {
	
	private Integer id;//ID
	
	private String bgbh;//报告编号
	
	private Date rwxarq;//任务下达日期
	
	private Date yqwcrq;//要求完成日期
	
	private String jyzp;//检验指派
	
	private Date zprq;//指派日期
	
	private String zpr;//指派人
	
	private String zxr;//执行人
	
	private String bz;//备注

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

	@Column(name="bgbh", length=50, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="rwxarq", length=6, nullable=true)
	public Date getRwxarq() {
		return rwxarq;
	}

	public void setRwxarq(Date rwxarq) {
		this.rwxarq = rwxarq;
	}

	@Column(name="yqwcrq", length=6, nullable=true)
	public Date getYqwcrq() {
		return yqwcrq;
	}

	public void setYqwcrq(Date yqwcrq) {
		this.yqwcrq = yqwcrq;
	}

	@Column(name="jyzp", length=200, nullable=true)
	public String getJyzp() {
		return jyzp;
	}

	public void setJyzp(String jyzp) {
		this.jyzp = jyzp;
	}

	@Column(name="zprq", length=6, nullable=true)
	public Date getZprq() {
		return zprq;
	}

	public void setZprq(Date zprq) {
		this.zprq = zprq;
	}

	@Column(name="zpr", length=50, nullable=true)
	public String getZpr() {
		return zpr;
	}

	public void setZpr(String zpr) {
		this.zpr = zpr;
	}

	@Column(name="zxr", length=50, nullable=true)
	public String getZxr() {
		return zxr;
	}

	public void setZxr(String zxr) {
		this.zxr = zxr;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
