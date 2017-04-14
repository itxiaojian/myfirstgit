package com.zssi.framework.app.sfbzxx.model;

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
 * 
 * @author liangkaidi
 * @date 2015-9-28
 */
@Entity
@Table(name = "y_sf_bzxx")

public class YsfBzxx implements Serializable {
	private Integer id; //ID
	
	private String sfbzbh;//收费标准编号
	
	private String cpmc;//产品名称
	
	private String  cplx;
	
	private String ggxh;//规格型号
	
	
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)用于MySQL数据库
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_KH_ID") })
	// 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "sfbzbh", length = 50, nullable = true)
	public String getSfbzbh() {
		return sfbzbh;
	}

	public void setSfbzbh(String sfbzbh) {
		this.sfbzbh = sfbzbh;
	}
	@Column(name = "cpmc", length = 500, nullable = true)
	public String getCpmc() {
		return cpmc;
	}
	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}
	@Column(name = "ggxh", length = 500, nullable = true)
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	
	@Column(name = "cplx", length = 500, nullable = true)
	public String getCplx() {
		return cplx;
	}

	public void setCplx(String cplx) {
		this.cplx = cplx;
	}
	

}
