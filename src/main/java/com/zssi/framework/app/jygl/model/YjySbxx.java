package com.zssi.framework.app.jygl.model;

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
 * 检验设备信息
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Entity
@Table(name = "y_jy_sbxx")
public class YjySbxx implements Serializable{

	/**主键*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**设备编号*/
	private String sbbh;
	
	/**单位*/
	private String dw;
	
	/**数量*/
	private Integer sysl;
	
	/**使用日期*/
	private Date syrq;
	
	/**使用前状态*/
	private String syqzt;
	
	/**使用后状态*/
	private String syhzt;
	
	/**使用环境*/
	private String syhj;
	
	/**使用人*/
	private String syr;
	
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

	@Column(name="sbbh", length=50, nullable=true)
	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	@Column(name="dw", length=50, nullable=true)
	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	@Column(name="sysl", length=50, nullable=true)
	public Integer getSysl() {
		return sysl;
	}

	public void setSysl(Integer sysl) {
		this.sysl = sysl;
	}

	@Column(name="syrq", length=50, nullable=true)
	public Date getSyrq() {
		return syrq;
	}

	public void setSyrq(Date syrq) {
		this.syrq = syrq;
	}

	@Column(name="syqzt", length=50, nullable=true)
	public String getSyqzt() {
		return syqzt;
	}

	public void setSyqzt(String syqzt) {
		this.syqzt = syqzt;
	}

	@Column(name="syhzt", length=50, nullable=true)
	public String getSyhzt() {
		return syhzt;
	}

	public void setSyhzt(String syhzt) {
		this.syhzt = syhzt;
	}

	@Column(name="syhj", length=50, nullable=true)
	public String getSyhj() {
		return syhj;
	}

	public void setSyhj(String syhj) {
		this.syhj = syhj;
	}

	@Column(name="syr", length=50, nullable=true)
	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
