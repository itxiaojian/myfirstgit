package com.zssi.framework.app.bgjsl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@SuppressWarnings("serial")
@Entity
@Table(name = "y_bg_jslkh")
public class Bgjsl implements Serializable {
	
	private Integer id;
	
	private String gjz;
	
	private String csxq;
	
	private String sjsz;
	
	private String bz;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_BG_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "gjz", nullable = true)
	public String getGjz() {
		return gjz;
	}

	public void setGjz(String gjz) {
		this.gjz = gjz;
	}

	@Column(name = "csxq", nullable = true)
	public String getCsxq() {
		return csxq;
	}

	public void setCsxq(String csxq) {
		this.csxq = csxq;
	}

	@Column(name = "sjsz", nullable = true)
	public String getSjsz() {
		return sjsz;
	}

	public void setSjsz(String sjsz) {
		this.sjsz = sjsz;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	

}
