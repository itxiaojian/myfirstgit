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
 * 设备检定记录model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月1日 下午8:13:45 
 * 类说明 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_sb_jdjl")
public class YsbJdjl implements Serializable {
	private Integer id;
	
	private String sbbh;     //设备编号
	
	private String sbtxm;    //设备二维码
	
	private String sbmc;     //设备名称
	
	private Date sysj;       //使用时间
	
	private String jddw;     //检定单位
	
	private String jdjg;     //检定/校准结果
	
	private String jdjl;     //检定/校准结论
	
	private Integer jdfy;    //检定费用
	
	private String jdr;      //检定人/校准人
	
	private String jybh;     //检验编号
	
	private String bgbh;   //检验报告编号
	
	private Integer jdzt;    //检定状态
	
	private String  jdfj;    //检定附件
	
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

	@Column(name = "jddw", nullable = true)
	public String getJddw() {
		return jddw;
	}

	public void setJddw(String jddw) {
		this.jddw = jddw;
	}

	@Column(name = "jdjg", nullable = true)
	public String getJdjg() {
		return jdjg;
	}

	public void setJdjg(String jdjg) {
		this.jdjg = jdjg;
	}

	@Column(name = "jdjl", nullable = true)
	public String getJdjl() {
		return jdjl;
	}

	public void setJdjl(String jdjl) {
		this.jdjl = jdjl;
	}

	@Column(name = "jdfy", nullable = true)
	public Integer getJdfy() {
		return jdfy;
	}

	public void setJdfy(Integer jdfy) {
		this.jdfy = jdfy;
	}

	@Column(name = "jdr", nullable = true)
	public String getJdr() {
		return jdr;
	}

	public void setJdr(String jdr) {
		this.jdr = jdr;
	}

	@Column(name = "jybh", nullable = true)
	public String getJybh() {
		return jybh;
	}

	public void setJybh(String jybh) {
		this.jybh = jybh;
	}

	@Column(name = "bgbh", nullable = true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name = "jdzt", nullable = true)
	public Integer getJdzt() {
		return jdzt;
	}

	public void setJdzt(Integer jdzt) {
		this.jdzt = jdzt;
	}

	@Column(name = "jdfj", nullable = true)
	public String getJdfj() {
		return jdfj;
	}

	public void setJdfj(String jdfj) {
		this.jdfj = jdfj;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
