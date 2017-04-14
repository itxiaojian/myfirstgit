package com.zssi.framework.app.sfwgl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "y_sfw_hfb")
public class YsfwHfb {
	private Integer id;// 收文ID
	private Integer fwid;// 发文id
	private String hfbr;// 回复内容
	private Date hfsj;// 回复时间
	private String hfr;// 回复人
	private String fj;//附件

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)用于MySQL数据库
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_SFW_ID") })
	// 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "fwid", length = 50, nullable = true)
	public Integer getFwid() {
		return fwid;
	}

	public void setFwid(Integer fwid) {
		this.fwid = fwid;
	}

	@Column(name = "hfbr", length = 50, nullable = true)
	public String getHfbr() {
		return hfbr;
	}

	public void setHfbr(String hfbr) {
		this.hfbr = hfbr;
	}

	@Column(name = "hfsj", length = 50, nullable = true)
	public Date getHfsj() {
		return hfsj;
	}

	public void setHfsj(Date hfsj) {
		this.hfsj = hfsj;
	}

	@Column(name = "hfr", length = 50, nullable = true)
	public String getHfr() {
		return hfr;
	}

	public void setHfr(String hfr) {
		this.hfr = hfr;
	}

	@Column(name = "fj", length = 50, nullable = true)
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}// 附件

}
