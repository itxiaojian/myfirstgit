package com.zssi.framework.app.khgl.model;

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
 * 
 * @author liangkaidi
 * @date 2015-9-23
 */

@SuppressWarnings("serial")
@Entity 
@Table(name = "y_kh_khhf")
public class YkhHfxx implements Serializable {
	private Integer id; // ID

	private String khbh; // 客户编号
	
	private String khmc; //客户名称

	private String khdz; // 客户地址

	private String bfry; // 拜访人员

	private Date bfrq; // 拜访日期

	private String ryzw; // 人员职务

	private String lxdh; // 联系电话

	private String hzqk; // 合作情况

	private String khpj; //客户评价

	private String bfjl; // 拜访记录

	private String yjyq; // 意见要求

	private String ywry; // 业务人员
	
	private String dcjy;  //对策建议
	
	private String bz; // 备注
	
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-24
	 * @return
	 */

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_KH_ID") })
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "khbh", length = 50, nullable = true)
	public String getKhbh() {
		return khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}
	
	@Column(name = "khmc", length = 150, nullable = true)
	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	@Column(name = "khdz", length = 150, nullable = true)
	public String getKhdz() {
		return khdz;
	}

	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}

	@Column(name = "bfry", length = 500, nullable = true)
	public String getBfry() {
		return bfry;
	}

	public void setBfry(String bfry) {
		this.bfry = bfry;
	}

	@Column(name = "bfrq", length = 500, nullable = true)
	public Date getBfrq() {
		return bfrq;
	}

	public void setBfrq(Date bfrq) {
		this.bfrq = bfrq;
	}

	@Column(name = "ryzw", length = 500, nullable = true)
	public String getRyzw() {
		return ryzw;
	}

	public void setRyzw(String ryzw) {
		this.ryzw = ryzw;
	}

	@Column(name = "lxdh", length = 500, nullable = true)
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name = "hzqk", length = 500, nullable = true)
	public String getHzqk() {
		return hzqk;
	}

	public void setHzqk(String hzqk) {
		this.hzqk = hzqk;
	}

	@Column(name = "khpj", length = 500, nullable = true)
	public String getKhpj() {
		return khpj;
	}

	public void setKhpj(String khpj) {
		this.khpj = khpj;
	}

	@Column(name = "bfjl", length = 500, nullable = true)
	public String getBfjl() {
		return bfjl;
	}

	public void setBfjl(String bfjl) {
		this.bfjl = bfjl;
	}

	@Column(name = "yjyq", length = 500, nullable = true)
	public String getYjyq() {
		return yjyq;
	}

	public void setYjyq(String yjyq) {
		this.yjyq = yjyq;
	}

	@Column(name = "ywry", length = 500, nullable = true)
	public String getYwry() {
		return ywry;
	}
	
	@Column(name = "dcjy", length = 500, nullable = true)
	public String getDcjy() {
		return dcjy;
	}

	public void setDcjy(String dcjy) {
		this.dcjy = dcjy;
	}

	public void setYwry(String ywry) {
		this.ywry = ywry;
	}

	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
