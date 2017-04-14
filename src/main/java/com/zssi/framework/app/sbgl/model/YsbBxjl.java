package com.zssi.framework.app.sbgl.model;

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
 * 设备保修记录
 * @author liusong
 * @date 2015年9月23日
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_sb_whby")
public class YsbBxjl implements Serializable{
	
	private Integer id;  //id
	
	private String sbbh;  //设备编号
	
	private String sbmc;   //设备名称
	
	private String txmbh; //条形码编号
	
	private Date wbsj;  //维保时间
	
	private String wbnr;  //维保内容
	
	private String wbr;   //维保人
	
	private Integer wbzt;   //维保状态
	
	private String wbfy;    //维保费用
	
	private String bz;    //备注
	
	private String fj;     //附件

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_SB_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "sbbh", nullable = true)
	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}
	
	@Column(name = "sbmc", nullable = true)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	@Column(name = "txmbh", nullable = true)
	public String getTxmbh() {
		return txmbh;
	}

	public void setTxmbh(String txmbh) {
		this.txmbh = txmbh;
	}

	@Column(name = "wbsj", nullable = true)
	public Date getWbsj() {
		return wbsj;
	}

	public void setWbsj(Date wbsj) {
		this.wbsj = wbsj;
	}

	@Column(name = "wbnr", nullable = true)
	public String getWbnr() {
		return wbnr;
	}

	public void setWbnr(String wbnr) {
		this.wbnr = wbnr;
	}

	@Column(name = "wbr", nullable = true)
	public String getWbr() {
		return wbr;
	}

	public void setWbr(String wbr) {
		this.wbr = wbr;
	}

	@Column(name = "wbzt", nullable = true)
	public Integer getWbzt() {
		return wbzt;
	}

	public void setWbzt(Integer wbzt) {
		this.wbzt = wbzt;
	}

	@Column(name = "wbfy", nullable = true)
	public String getWbfy() {
		return wbfy;
	}

	public void setWbfy(String wbfy) {
		this.wbfy = wbfy;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "fj", nullable = true)
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}    
	
}
