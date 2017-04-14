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

/***
 * 检验项目
 * @author duanpeijun
 * @date 2015年10月12日
 */
@Entity
@Table(name = "y_jy_xmml")
public class YjyXmml implements Serializable{

	/**主键*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**标准编号*/
	private String bzbh;
	
	/**项目编号*/
	private String xmbh;
	
	/**项目名称*/
	private String xmmc;
	
	/**项目类型*/
	private String xmlx;
	
	/**项目要求*/
	private String xmyq;
	
	/**计量单位*/
	private String jldw;
	
	/**检验费用*/
	private Integer jyfy;
	
	/**标准最大值*/
	private String bzmax;
	
	/**标准最小值*/
	private String bzmin;
	
	/**实测值*/
	private String scz;
	
	/**评定用语*/
	private String pdyy;
	
	/**检定日期*/
	private Date jyrq;
	
	/**检验科室*/
	private String bmbh;
	
	/**评定方式*/
	private String pdfs;
	
	/**检验人*/
	private String jyr;
	
	/**最低检出限*/
	private String zdcx;
	
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

	@Column(name="xmmc", length=100, nullable=true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Column(name="xmlx", length=50, nullable=true)
	public String getXmlx() {
		return xmlx;
	}

	public void setXmlx(String xmlx) {
		this.xmlx = xmlx;
	}

	@Column(name="xmyq", length=1000, nullable=true)
	public String getXmyq() {
		return xmyq;
	}

	public void setXmyq(String xmyq) {
		this.xmyq = xmyq;
	}

	@Column(name="jldw", length=50, nullable=true)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	@Column(name="jyfy", length=50, nullable=true)
	public Integer getJyfy() {
		return jyfy;
	}

	public void setJyfy(Integer jyfy) {
		this.jyfy = jyfy;
	}

	@Column(name="bzmax", length=100, nullable=true)
	public String getBzmax() {
		return bzmax;
	}

	public void setBzmax(String bzmax) {
		this.bzmax = bzmax;
	}

	@Column(name="bzmin", length=100, nullable=true)
	public String getBzmin() {
		return bzmin;
	}

	public void setBzmin(String bzmin) {
		this.bzmin = bzmin;
	}

	@Column(name="scz", length=100, nullable=true)
	public String getScz() {
		return scz;
	}

	public void setScz(String scz) {
		this.scz = scz;
	}

	@Column(name="pdyy", length=200, nullable=true)
	public String getPdyy() {
		return pdyy;
	}

	public void setPdyy(String pdyy) {
		this.pdyy = pdyy;
	}

	@Column(name="jyrq", length=6, nullable=true)
	public Date getJyrq() {
		return jyrq;
	}

	public void setJyrq(Date jyrq) {
		this.jyrq = jyrq;
	}

	@Column(name="bmbh", length=50, nullable=true)
	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	@Column(name="pdfs", length=200, nullable=true)
	public String getPdfs() {
		return pdfs;
	}

	public void setPdfs(String pdfs) {
		this.pdfs = pdfs;
	}

	@Column(name="jyr", length=50, nullable=true)
	public String getJyr() {
		return jyr;
	}

	public void setJyr(String jyr) {
		this.jyr = jyr;
	}

	@Column(name="zdcx", length=50, nullable=true)
	public String getZdcx() {
		return zdcx;
	}

	public void setZdcx(String zdcx) {
		this.zdcx = zdcx;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
