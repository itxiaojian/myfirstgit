package com.zssi.framework.app.khgl.model;

import java.io.Serializable;

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
 * @date 2015-9-22
 */
@SuppressWarnings("serial")
@Entity 
@Table(name = "y_kh_hyxx")
public class YkhHyxx implements Serializable{
	private Integer id; // ID

	private String hybh; // 行业编号
	
	private String ssfl; // 所属分类
	
	private String jb; // 级别

	private String hymc; // 行业名称

	private String bz; // 备注

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)用于MySQL数据库
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_KH_ID")})  // 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "hybh", length = 50, nullable = true)
	public String getHybh() {
		return hybh;
	}

	public void setHybh(String hybh) {
		this.hybh = hybh;
	}

	@Column(name = "hymc", length = 50, nullable = true)
	public String getHymc() {
		return hymc;
	}

	public void setHymc(String hymc) {
		this.hymc = hymc;
	}

	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "ssfl", length = 500, nullable = true)
	public String getSsfl() {
		return ssfl;
	}

	public void setSsfl(String ssfl) {
		this.ssfl = ssfl;
	}

	@Column(name = "jb", length = 500, nullable = true)
	public String getJb() {
		return jb;
	}

	public void setJb(String jb) {
		this.jb = jb;
	}
	
	

}
