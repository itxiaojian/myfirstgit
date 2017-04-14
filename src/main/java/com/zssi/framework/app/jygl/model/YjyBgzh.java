package com.zssi.framework.app.jygl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 报告整合
 * @author duanpeijun
 * @date 2015年11月24日
 */
@Entity
@Table(name = "y_jy_bgzh")
public class YjyBgzh implements Serializable{

	/**序号*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**封面地址*/
	private String fmdz;
	
	/**封面名称*/
	private String fmmc;
	
	/**首页地址*/
	private String sydz;
	
	/**首页名称*/
	private String symc;
	
	/**附页地址*/
	private String fydz;
	
	/**附页名称*/
	private String fymc;
	
	/**封底地址*/
	private String fddz;
	
	/**封底名称*/
	private String fdmc;
	
	/**备注*/
	private String bz;

	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bgbh", length=50, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="fmdz", length=4000, nullable=true)
	public String getFmdz() {
		return fmdz;
	}

	public void setFmdz(String fmdz) {
		this.fmdz = fmdz;
	}

	@Column(name="sydz", length=4000, nullable=true)
	public String getSydz() {
		return sydz;
	}

	public void setSydz(String sydz) {
		this.sydz = sydz;
	}

	@Column(name="fydz", length=4000, nullable=true)
	public String getFydz() {
		return fydz;
	}

	public void setFydz(String fydz) {
		this.fydz = fydz;
	}

	@Column(name="fddz", length=4000, nullable=true)
	public String getFddz() {
		return fddz;
	}

	public void setFddz(String fddz) {
		this.fddz = fddz;
	}

	@Column(name="bz", length=4000, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="fmmc", length=500, nullable=true)
	public String getFmmc() {
		return fmmc;
	}

	public void setFmmc(String fmmc) {
		this.fmmc = fmmc;
	}

	@Column(name="symc", length=500, nullable=true)
	public String getSymc() {
		return symc;
	}

	public void setSymc(String symc) {
		this.symc = symc;
	}

	@Column(name="fymc", length=500, nullable=true)
	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	@Column(name="fdmc", length=500, nullable=true)
	public String getFdmc() {
		return fdmc;
	}

	public void setFdmc(String fdmc) {
		this.fdmc = fdmc;
	}
}
