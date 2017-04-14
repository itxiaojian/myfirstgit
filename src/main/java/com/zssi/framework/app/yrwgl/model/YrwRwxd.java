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
@Table(name="Y_YP_YPXX")
public class YrwRwxd implements Serializable {
	
	private Integer id;//ID
	
	private String ypbh;//检验编号
	
	private String ypmc;//样品名称
	
	private String wtdw;//委托单位
	
	private String yplx;//样品类别
	
	private String jylx;//检验类别
	
	private String cyry;//收样人
	
	private String lxr;//联系人
	
	private String dh;//联系电话
	
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

	@Column(name="ypbh", length=50, nullable=true)
	public String getYpbh() {
		return ypbh;
	}

	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}

	@Column(name="ypmc", length=50, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="wtdw", length=150, nullable=true)
	public String getWtdw() {
		return wtdw;
	}

	public void setWtdw(String wtdw) {
		this.wtdw = wtdw;
	}

	@Column(name="yplx", length=50, nullable=true)
	public String getYplx() {
		return yplx;
	}

	public void setYplx(String yplx) {
		this.yplx = yplx;
	}

	@Column(name="jylx", length=50, nullable=true)
	public String getJylx() {
		return jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	@Column(name="cyry", length=50, nullable=true)
	public String getCyry() {
		return cyry;
	}

	public void setCyry(String cyry) {
		this.cyry = cyry;
	}

	@Column(name="lxr", length=50, nullable=true)
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	@Column(name="dh", length=50, nullable=true)
	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

}
