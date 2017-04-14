package com.zssi.framework.app.ypgl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 预检方案
 * @author wangyong
 * @date 2015年9月24日
 */
@Entity
@Table(name="y_yp_jyfa")
public class YypJyfa implements Serializable{

	/**主键*/
	private Integer id;
	
	/**方案编号*/
	private String fabh;
	
	/**检验类别*/
	private String jylb;
	
	/**样品名称*/
	private String ypmc;
	
	/**标准名称*/
	private String bzmc;
	
	/**标准编号*/
	private String bzbh;
	
	/**项目编号*/
	private String xmbh;
	
	/**项目名称*/
	private String xmmc;
	
	/**子项目编号*/
	private String zxmbh;
	
	/**子项目名称*/
	private String zxmmc;
	
	/**备注*/
	private String bz;

	@Id
	//也可以使用sequence生成方式,SEQ_YP_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="fabh", length=50, nullable=true)
	public String getFabh() {
		return fabh;
	}

	public void setFabh(String fabh) {
		this.fabh = fabh;
	}

	@Column(name="jylb", length=50, nullable=true)
	public String getJylb() {
		return jylb;
	}

	public void setJylb(String jylb) {
		this.jylb = jylb;
	}

	@Column(name="bzbh", length=50, nullable=true)
	public String getBzbh() {
		return bzbh;
	}

	public void setBzbh(String bzbh) {
		this.bzbh = bzbh;
	}

	@Column(name="xmbh", length=50, nullable=true)
	public String getXmbh() {
		return xmbh;
	}

	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}

	@Column(name="zxmbh", length=50, nullable=true)
	public String getZxmbh() {
		return zxmbh;
	}

	public void setZxmbh(String zxmbh) {
		this.zxmbh = zxmbh;
	}
	
	@Column(name="xmmc", length=50, nullable=true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Column(name="zxmmc", length=50, nullable=true)
	public String getZxmmc() {
		return zxmmc;
	}

	public void setZxmmc(String zxmmc) {
		this.zxmmc = zxmmc;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="ypmc", length=50, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="bzmc", length=50, nullable=true)
	public String getBzmc() {
		return bzmc;
	}

	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}
}
