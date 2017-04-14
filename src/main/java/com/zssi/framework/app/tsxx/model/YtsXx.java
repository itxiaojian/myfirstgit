package com.zssi.framework.app.tsxx.model;

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
 * @date 2015-10-9
 */

@Entity 
@Table(name = "y_ts_xx")
public class YtsXx implements Serializable{
	private  Integer id;  //id
	private String  tsr;//投诉人
	private String  tslx;//投诉类型
	private String tsnr;//投诉内容
	private String btsr;//被投诉人
	private Date tsrq;//投诉日期
	private Integer clzt;//处理状态（0：未处理，1：已处理）
	private String  cljg;//处理结果
	private String clr;//处理人
	private Date clrq;//处理日期
	private String bz;//备注
	
	
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_TS_ID") })
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="tsr",length=50,nullable=true)
	public String getTsr() {
		return tsr;
	}
	public void setTsr(String tsr) {
		this.tsr = tsr;
	}
	@Column(name="tslx",length=50,nullable=true)
	public String getTslx() {
		return tslx;
	}
	public void setTslx(String tslx) {
		this.tslx = tslx;
	}
	@Column(name="tsnr",length=50,nullable=true)
	
	public String getTsnr() {
		return tsnr;
	}
	public void setTsnr(String tsnr) {
		this.tsnr = tsnr;
	}
	@Column(name="btsr",length=50,nullable=true)
	public String getBtsr() {
		return btsr;
	}
	public void setBtsr(String btsr) {
		this.btsr = btsr;
	}
	@Column(name="tsrq",length=50,nullable=true)
	public Date getTsrq() {
		return tsrq;
	}
	public void setTsrq(Date tsrq) {
		this.tsrq = tsrq;
	}
	@Column(name="clzt",length=50,nullable=true)
	public Integer getClzt() {
		return clzt;
	}
	public void setClzt(Integer clzt) {
		this.clzt = clzt;
	}
	@Column(name="cljg",length=50,nullable=true)
	public String getCljg() {
		return cljg;
	}
	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	@Column(name="clr",length=50,nullable=true)
	public String getClr() {
		return clr;
	}
	public void setClr(String clr) {
		this.clr = clr;
	}
	@Column(name="clrq",length=50,nullable=true)
	public Date getClrq() {
		return clrq;
	}
	public void setClrq(Date clrq) {
		this.clrq = clrq;
	}
	@Column(name="bz",length=50,nullable=true)
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
}
