package com.zssi.framework.app.sfwgl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity 
@Table(name = "y_sfw_yfwxx")
public class YsfwFwxx implements Serializable{
	private Integer id;//发文ID
	private String sjr;//收件人（以英文分号隔开）
	private String cs;//抄送（以英文分号隔开）
	private String zt;//主题
	private String zw;//正文
	private String fj;//附件
//	private Date dsfs;//定时发送时间
	private Date fssj;//发送时间
	private String fwr;//发文人
	private String bmbh;//发文单位
	
	
	
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
	@Column(name = "sjr", length = 50, nullable = true)
	public String getSjr() {
		return sjr;
	}
	public void setSjr(String sjr) {
		this.sjr = sjr;
	}
	@Column(name = "cs", length = 50, nullable = true)
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	@Column(name = "zt", length = 50, nullable = true)
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	@Column(name = "zw", length = 50, nullable = true)
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	@Column(name = "fj", length = 50, nullable = true)
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
	}

	@Column(name = "fssj", length = 50, nullable = true)
	public Date getFssj() {
		return fssj;
	}
	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}
	@Column(name = "fwr", length = 50, nullable = true)
	public String getFwr() {
		return fwr;
	}
	public void setFwr(String fwr) {
		this.fwr = fwr;
	}
	@Column(name = "bmbh", length = 50, nullable = true)
	public String getBmbh() {
		return bmbh;
	}
	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}
	

}
