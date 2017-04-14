package com.zssi.framework.app.cwgl.model; 

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/** 
 * 报告收费model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年12月11日 下午4:39:54 
 * 类说明 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="y_cw_bgsf")
public class YcwBgsf implements Serializable {
	
	private Integer id;  //id
	
	private String bgbh;   //报告编号
	
	private String sjdw;    //受检单位
	
	private String ks_id;   //所属科室
	
	private String ssywks;  //所属业务科室
	
	private Date jyjsrq;   //收费日期
	
	private BigDecimal ysje;   //应收金额
	
	private BigDecimal ysfje;   //已收金额
	
	private String sfr;    //收费人
	
	private BigDecimal xgje;    //修改收费金额
	
	private Integer sfyq;    //是否延期(0延期；1不延期)
	
	private Integer sfzt;    //收费状态（0待收费；1已收费）
	
	private String bz;     //备注
	
	private String ypmc;   //样品名称
	
	private BigDecimal bcss;  //本次实收
	
	private String srfl;  //收入分类
	
	private BigDecimal jyfy;  //检验费用
	
	private String pjfl;    //票据分类
	
	private String pjhm;    //票据号码
 
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_CW_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bgbh",length=50,  nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="sjdw", length=150, nullable=true)
	public String getSjdw() {
		return sjdw;
	}

	public void setSjdw(String sjdw) {
		this.sjdw = sjdw;
	}

	@Column(name="ks_id", length=100, nullable=true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}

	@Column(name="ssywks", length=50, nullable=true)
	public String getSsywks() {
		return ssywks;
	}

	public void setSsywks(String ssywks) {
		this.ssywks = ssywks;
	}

	@Column(name="jyjsrq", length=50, nullable=true)
	public Date getJyjsrq() {
		return jyjsrq;
	}

	public void setJyjsrq(Date jyjsrq) {
		this.jyjsrq = jyjsrq;
	}

	@Column(name="ysje", length=50, nullable=true)
	public BigDecimal getYsje() {
		return ysje;
	}

	public void setYsje(BigDecimal ysje) {
		this.ysje = ysje;
	}

	@Column(name="ysfje", length=50, nullable=true)
	public BigDecimal getYsfje() {
		return ysfje;
	}

	public void setYsfje(BigDecimal ysfje) {
		this.ysfje = ysfje;
	}

	@Column(name="sfr", length=50, nullable=true)
	public String getSfr() {
		return sfr;
	}

	public void setSfr(String sfr) {
		this.sfr = sfr;
	}

	@Column(name="xgje", length=50, nullable=true)
	public BigDecimal getXgje() {
		return xgje;
	}

	public void setXgje(BigDecimal xgje) {
		this.xgje = xgje;
	}

	@Column(name="sfyq", length=50, nullable=true)
	public Integer getSfyq() {
		return sfyq;
	}

	public void setSfyq(Integer sfyq) {
		this.sfyq = sfyq;
	}

	@Column(name="sfzt", length=50, nullable=true)
	public Integer getSfzt() {
		return sfzt;
	}

	public void setSfzt(Integer sfzt) {
		this.sfzt = sfzt;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name="ypmc", length=200, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="bcss", length=50, nullable=true)
	public BigDecimal getBcss() {
		return bcss;
	}

	public void setBcss(BigDecimal bcss) {
		this.bcss = bcss;
	}

	@Column(name="srfl", length=200, nullable=true)
	public String getSrfl() {
		return srfl;
	}

	public void setSrfl(String srfl) {
		this.srfl = srfl;
	}

	@Column(name="jyfy", length=50, nullable=true)
	public BigDecimal getJyfy() {
		return jyfy;
	}

	public void setJyfy(BigDecimal jyfy) {
		this.jyfy = jyfy;
	}

	@Column(name="pjfl", length=50, nullable=true)
	public String getPjfl() {
		return pjfl;
	}

	public void setPjfl(String pjfl) {
		this.pjfl = pjfl;
	}

	@Column(name="pjhm", length=50, nullable=true)
	public String getPjhm() {
		return pjhm;
	}

	public void setPjhm(String pjhm) {
		this.pjhm = pjhm;
	}
	
}
