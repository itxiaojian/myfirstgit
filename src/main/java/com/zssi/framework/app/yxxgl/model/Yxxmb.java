package com.zssi.framework.app.yxxgl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * --主页消息管理
 * @author mabiao
 *
 */
@Entity
@Table(name="Y_XXMB")
public class Yxxmb implements Serializable {
	private Integer id;//ID
	
	private String xxlx;//消息类型
	
	private String mbnr;//消息内容
	
	private Date szrq;//添加日期
	
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

	@Column(name="xxlx", length=200, nullable=true)
	public String getXxlx() {
		return xxlx;
	}

	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}

	@Column(name="mbnr", length=2000, nullable=true)
	public String getMbnr() {
		return mbnr;
	}

	public void setMbnr(String mbnr) {
		this.mbnr = mbnr;
	}

	@Column(name="szrq", nullable=true)
	public Date getSzrq() {
		return szrq;
	}

	public void setSzrq(Date szrq) {
		this.szrq = szrq;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
