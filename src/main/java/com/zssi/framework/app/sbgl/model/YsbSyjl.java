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
 * 设备使用记录
 * @author liusong
 * @date 2015年9月23日
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "y_sb_syjl")
public class YsbSyjl implements Serializable{
	
	
	private Integer id;  //id
	
	private String sbbh; //设备编号
	
	private String sbtxm;  //设备条形码
	
	private String sbmc;  //设备名称
	
	private Date sysj;  //使用时间
	
	private Integer syzt;  //使用状态
	
	private String bgbh;  //检验报告编号
	
	private String bz;  //备注
	
	private String fj;    //附件

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

	@Column(name = "sbtxm", nullable = true)
	public String getSbtxm() {
		return sbtxm;
	}

	public void setSbtxm(String sbtxm) {
		this.sbtxm = sbtxm;
	}

	@Column(name = "sbmc", nullable = true)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	@Column(name = "sysj", nullable = true)
	public Date getSysj() {
		return sysj;
	}

	public void setSysj(Date sysj) {
		this.sysj = sysj;
	}

	
	@Column(name = "syzt", nullable = true)
	public Integer getSyzt() {
		return syzt;
	}

	public void setSyzt(Integer syzt) {
		this.syzt = syzt;
	}

	@Column(name = "bgbh", nullable = true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
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
