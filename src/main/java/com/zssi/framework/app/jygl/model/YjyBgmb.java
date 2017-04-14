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
 * 检验报告模版
 * @author duanpeijun
 * @date 2015年10月13日
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_jy_bgmb")
public class YjyBgmb implements Serializable{

	/**主键*/
	private Integer id;
	
	/**模版名称*/
	private String mbmc;
	
	/**模板类别（中/英文）*/
	private Integer mblb;
	
	/**模版类型（封面、首页、附页、封底，数据字典）*/
	private String mblx;
	
	/**模板地址*/
	private String mbdz;
	
	/**新增人*/
	private String xzr;
	
	/**新增时间*/
	private Date xzsj;
	
	/**备注*/
	private String bz;
	
	/**上传文件随机名*/
	private String sub;

	
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

	@Column(name="mbmc", length=50, nullable=true)
	public String getMbmc() {
		return mbmc;
	}

	public void setMbmc(String mbmc) {
		this.mbmc = mbmc;
	}

	@Column(name="mblx", length=50, nullable=true)
	public String getMblx() {
		return mblx;
	}

	public void setMblx(String mblx) {
		this.mblx = mblx;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name="mblb", length=50, nullable=true)
	public Integer getMblb() {
		return mblb;
	}

	public void setMblb(Integer mblb) {
		this.mblb = mblb;
	}

	@Column(name="xzr", length=50, nullable=true)
	public String getXzr() {
		return xzr;
	}

	public void setXzr(String xzr) {
		this.xzr = xzr;
	}

	@Column(name="xzsj", length=50, nullable=true)
	public Date getXzsj() {
		return xzsj;
	}

	public void setXzsj(Date xzsj) {
		this.xzsj = xzsj;
	}

	@Column(name="mbdz", length=50, nullable=true)
	public String getMbdz() {
		return mbdz;
	}

	public void setMbdz(String mbdz) {
		this.mbdz = mbdz;
	}

	@Column(name="sub", length=50, nullable=true)
	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}
	
}
