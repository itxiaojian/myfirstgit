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
@Table(name = "y_sb_sg")
public class YsbSg implements Serializable{
	
	private Integer id;  //id
	
	private String sgbh;  //申购编号
	
	private String sbmc; //设备名称
	
	private String sblx;  //设备类型
	
	private String sbxh;  //设备型号
	
	private String sbjb;   //设备级别
	
	private String syks;   //使用科室
	
	private String syfw;    //使用范围
	
	private String sccj;   //生产厂家
	
	private Date sgrq;    //申购日期
	
	private Integer sgjg;   //申购价格
	
	private String sbsgr;   //设备申购人
	
	private Date dhyqsj;   //到货要求时间
	
//	private String spyj;   //审批意见
//	
//	private String spr;   //审批人
//	
//	private Date spsj;    //审批时间
	
	private String bz;    //备注

	
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

	@Column(name = "sgbh", nullable = true)
	public String getSgbh() {
		return sgbh;
	}

	public void setSgbh(String sgbh) {
		this.sgbh = sgbh;
	}

	@Column(name = "sbmc", nullable = true)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	@Column(name = "sblx", nullable = true)
	public String getSblx() {
		return sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	@Column(name = "sbxh", nullable = true)
	public String getSbxh() {
		return sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	@Column(name = "sbjb", nullable = true)
	public String getSbjb() {
		return sbjb;
	}

	public void setSbjb(String sbjb) {
		this.sbjb = sbjb;
	}

	@Column(name = "syks", nullable = true)
	public String getSyks() {
		return syks;
	}

	public void setSyks(String syks) {
		this.syks = syks;
	}

	@Column(name = "syfw", nullable = true)
	public String getSyfw() {
		return syfw;
	}

	public void setSyfw(String syfw) {
		this.syfw = syfw;
	}

	@Column(name = "sccj", nullable = true)
	public String getSccj() {
		return sccj;
	}

	public void setSccj(String sccj) {
		this.sccj = sccj;
	}

	@Column(name = "sgrq", nullable = true)
	public Date getSgrq() {
		return sgrq;
	}

	public void setSgrq(Date sgrq) {
		this.sgrq = sgrq;
	}

	@Column(name = "sgjg", nullable = true)
	public Integer getSgjg() {
		return sgjg;
	}

	public void setSgjg(Integer sgjg) {
		this.sgjg = sgjg;
	}

	@Column(name = "sbsgr", nullable = true)
	public String getSbsgr() {
		return sbsgr;
	}

	public void setSbsgr(String sbsgr) {
		this.sbsgr = sbsgr;
	}

	@Column(name = "dhyqsj", nullable = true)
	public Date getDhyqsj() {
		return dhyqsj;
	}

	public void setDhyqsj(Date dhyqsj) {
		this.dhyqsj = dhyqsj;
	}

//	@Column(name = "spyj", nullable = false)
//	public String getSpyj() {
//		return spyj;
//	}
//
//	public void setSpyj(String spyj) {
//		this.spyj = spyj;
//	}
//
//	@Column(name = "spr", nullable = false)
//	public String getSpr() {
//		return spr;
//	}
//
//	public void setSpr(String spr) {
//		this.spr = spr;
//	}
//
//	@Column(name = "spsj", nullable = false)
//	public Date getSpsj() {
//		return spsj;
//	}
//
//	public void setSpsj(Date spsj) {
//		this.spsj = spsj;
//	}

	@Column(name = "bz", nullable = false)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
