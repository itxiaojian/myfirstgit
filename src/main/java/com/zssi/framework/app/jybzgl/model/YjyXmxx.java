package com.zssi.framework.app.jybzgl.model;

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
 * 主页：检验项目
 * 
 * @author mabiao
 *
 */
@Entity
@Table(name = "Y_JY_XMXX")
public class YjyXmxx implements Serializable {

	private Integer id;// ID

	private String bzbh;// 标准编号
	
	private String bgbh;//报告编号

	private String xmbh;// 项目编号

	private String xmmc;// 项目名称

	private String jldw;// 计量单位

	private String xmlx;// 项目类型

	private String xmyq;// 项目要求

	private String bzmax;// 标准最大值

	private String bzmin;// 标准最小值

	private String pdyy;// 评定用语

	private String jyyj;// 检验依据

	private Integer dj;// 单价

	private String pdfs;// 评定定方式

	private String mjyy;// 默认检验员

	private String zdcx;// 最低检出限

	private Integer xmpx;// 排序

	private String zxm_id;// 子项目ID

	private Date kssj;// 开始时间

	private Date jssj;// 结束时间

	private String bz;// 备注

	 @Id
	 //也可以使用sequence生成方式,SEQ_SYS_SJZD_ID代表数据库中的序列
	 @GenericGenerator(name = "idGenerator", strategy = "sequence",parameters= {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	 @GeneratedValue(generator = "idGenerator")
	 @Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "bzbh", length = 50, nullable = true)
	public String getBzbh() {
		return bzbh;
	}

	public void setBzbh(String bzbh) {
		this.bzbh = bzbh;
	}
	
	@Column(name = "bgbh", length = 50, nullable = true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name = "xmbh", length = 50, nullable = true)
	public String getXmbh() {
		return xmbh;
	}

	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}

	@Column(name = "xmmc", length = 100, nullable = true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Column(name = "jldw", length = 50, nullable = true)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	@Column(name = "xmlx", length = 50, nullable = true)
	public String getXmlx() {
		return xmlx;
	}

	public void setXmlx(String xmlx) {
		this.xmlx = xmlx;
	}

	@Column(name = "xmyq", length = 1000, nullable = true)
	public String getXmyq() {
		return xmyq;
	}

	public void setXmyq(String xmyq) {
		this.xmyq = xmyq;
	}

	@Column(name = "bzmax", length = 100, nullable = true)
	public String getBzmax() {
		return bzmax;
	}

	public void setBzmax(String bzmax) {
		this.bzmax = bzmax;
	}

	@Column(name = "bzmin", length = 100, nullable = true)
	public String getBzmin() {
		return bzmin;
	}

	public void setBzmin(String bzmin) {
		this.bzmin = bzmin;
	}

	@Column(name = "pdyy", length = 200, nullable = true)
	public String getPdyy() {
		return pdyy;
	}

	public void setPdyy(String pdyy) {
		this.pdyy = pdyy;
	}

	@Column(name = "jyyj", length = 200, nullable = true)
	public String getJyyj() {
		return jyyj;
	}

	public void setJyyj(String jyyj) {
		this.jyyj = jyyj;
	}

	@Column(name = "dj", nullable = true)
	public Integer getDj() {
		return dj;
	}

	public void setDj(Integer dj) {
		this.dj = dj;
	}

	@Column(name = "pdfs", length = 200, nullable = true)
	public String getPdfs() {
		return pdfs;
	}

	public void setPdfs(String pdfs) {
		this.pdfs = pdfs;
	}

	@Column(name = "mjyy", length = 50, nullable = true)
	public String getMjyy() {
		return mjyy;
	}

	public void setMjyy(String mjyy) {
		this.mjyy = mjyy;
	}

	@Column(name = "zdcx", length = 50, nullable = true)
	public String getZdcx() {
		return zdcx;
	}

	public void setZdcx(String zdcx) {
		this.zdcx = zdcx;
	}

	@Column(name = "xmpx", nullable = true)
	public Integer getXmpx() {
		return xmpx;
	}

	public void setXmpx(Integer xmpx) {
		this.xmpx = xmpx;
	}

	@Column(name = "zxm_id", length = 200, nullable = true)
	public String getZxm_id() {
		return zxm_id;
	}

	public void setZxm_id(String zxm_id) {
		this.zxm_id = zxm_id;
	}

	@Column(name = "kssj", length = 6, nullable = true)
	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	@Column(name = "jssj", length = 6, nullable = true)
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}