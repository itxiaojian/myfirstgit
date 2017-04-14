package com.zssi.framework.app.jygl.model;

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
 * 常规结论用语
 * @author duanpeijun
 * @date 2015年11月13日
 */
@Entity
@Table(name = "y_jy_clyy")
public class YjyClyy implements Serializable{

	private Integer id;      //主键
	
	private String cgjlyy;   //常规结论用语
	
	private String bz;       //备注
	
	private String jllb1;   //结论类别1
	
	private String jllb2;   //结论类别2
	
	private String xzr;    //新增人
	
	private Date xzsj;     //新增时间


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

	@Column(name="cgjlyy", length=2000, nullable=true)
	public String getCgjlyy() {
		return cgjlyy;
	}

	public void setCgjlyy(String cgjlyy) {
		this.cgjlyy = cgjlyy;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="jllb1", length=200, nullable=true)
	public String getJllb1() {
		return jllb1;
	}

	public void setJllb1(String jllb1) {
		this.jllb1 = jllb1;
	}

	@Column(name="jllb2", length=200, nullable=true)
	public String getJllb2() {
		return jllb2;
	}

	public void setJllb2(String jllb2) {
		this.jllb2 = jllb2;
	}

	@Column(name="xzr", length=50, nullable=true)
	public String getXzr() {
		return xzr;
	}

	public void setXzr(String xzr) {
		this.xzr = xzr;
	}

	@Column(name="xzsj", length=100, nullable=true)
	public Date getXzsj() {
		return xzsj;
	}

	public void setXzsj(Date xzsj) {
		this.xzsj = xzsj;
	}
}
