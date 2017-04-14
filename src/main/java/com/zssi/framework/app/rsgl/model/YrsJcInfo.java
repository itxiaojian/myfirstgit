package com.zssi.framework.app.rsgl.model;

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
 * 人事管理--奖惩管理
 * @author wangyong
 * @date 2015年10月20日
 */
@Entity
@Table(name="y_rs_jc_info")
public class YrsJcInfo implements Serializable{

	/**主键id*/
	private Integer id;
	
	/**人员编号*/
	private String rybh;
	
	/**人员姓名*/
	private String ryxm;
	
	/**考核月份*/
	private String khyf;
	
	/**奖惩情况*/
	private String jcqk;
	
	/**备注*/
	private String bz;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_RS_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="rybh",length=50,nullable=true)
	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}

	@Column(name="ryxm",length=50,nullable=true)
	public String getRyxm() {
		return ryxm;
	}

	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}

	@Column(name="khyf",length=50,nullable=true)
	public String getKhyf() {
		return khyf;
	}

	public void setKhyf(String khyf) {
		this.khyf = khyf;
	}

	@Column(name="jcqk",length=500,nullable=true)
	public String getJcqk() {
		return jcqk;
	}

	public void setJcqk(String jcqk) {
		this.jcqk = jcqk;
	}

	@Column(name="bz",length=500,nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
