package com.zssi.framework.app.wxpt.model;

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
*微管理的申请信息
@Author oufeng	
@Date 2015年12月15日 上午9:40:15
@Version 1.0
*/
@Entity
@Table(name = "W_GL_GZHB")
public class GlHbxx  implements Serializable {
	//汇报ID
	private Integer hbid;
	
	//汇报类型
	private String hblx;
	
	//汇报内容
	private String hbnr;
	
	//附件
	private String fj;
	
	//汇报人
	private String hbr;
	
	//接收人
	private String jsr;
	
	//汇报日期
	private Date hbrq;
	
	//备注
	private String bz;
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_KH_ID") })
	// 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "hbid", nullable = false)
	public Integer getHbid() {
		return hbid;
	}

	public void setHbid(Integer hbid) {
		this.hbid = hbid;
	}

	@Column(name = "hblx", length = 50, nullable = true)
	public String getHblx() {
		return hblx;
	}

	public void setHblx(String hblx) {
		this.hblx = hblx;
	}

	@Column(name = "hbnr", length = 1000, nullable = true)
	public String getHbnr() {
		return hbnr;
	}

	
	public void setHbnr(String hbnr) {
		this.hbnr = hbnr;
	}

	@Column(name = "fj", length = 1000, nullable = true)
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	@Column(name = "hbr", length = 50, nullable = true)
	public String getHbr() {
		return hbr;
	}

	
	public void setHbr(String hbr) {
		this.hbr = hbr;
	}
	
	@Column(name = "jsr", length = 50, nullable = true)
	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	@Column(name = "hbrq", length = 11, nullable = true)
	public Date getHbrq() {
		return hbrq;
	}

	public void setHbrq(Date hbrq) {
		this.hbrq = hbrq;
	}
	
	@Column(name = "bz", length = 256, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
}