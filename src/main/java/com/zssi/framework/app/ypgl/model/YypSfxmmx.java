package com.zssi.framework.app.ypgl.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 收费项目明细
 * @author wangyong
 * @date 2015年12月10日
 */
@Entity
@Table(name="y_yp_sfxmmx")
public class YypSfxmmx implements Serializable{

	/**主键*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**收费项目编号*/
	private String xmbh;
	
	/**产品名称*/
	private String cpmc;

	/**收费项目名称*/
	private String xmmc;
	
	/**计量单位*/
	private String jldw;
	
	/**金额*/
	private BigDecimal je;
	
	/**修改金额*/
	private BigDecimal xgje;
	
	/**数量*/
	private Integer sl;


	
	@Id
	//也可以使用sequence生成方式,SEQ_YP_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_YP_SFXMMX_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bgbh", length=200, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="xmbh", length=100, nullable=true)
	public String getXmbh() {
		return xmbh;
	}

	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}

	@Column(name="xmmc", length=200, nullable=true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Column(name="jldw", length=200, nullable=true)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	@Column(name="je", length=200, nullable=true)
	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	@Column(name="xgje", length=200, nullable=true)
	public BigDecimal getXgje() {
		return xgje;
	}

	public void setXgje(BigDecimal xgje) {
		this.xgje = xgje;
	}
	
	@Column(name="sl", length=100, nullable=true)
	public Integer getSl() {
		return sl;
	}

	public void setSl(Integer sl) {
		this.sl = sl;
	}

	@Column(name="cpmc", length=100, nullable=true)
	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

}
