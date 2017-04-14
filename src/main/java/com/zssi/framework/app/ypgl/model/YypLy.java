package com.zssi.framework.app.ypgl.model;

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
 * 样品领用
 * @author duanpeijun
 * @date 2015年9月24日
 */
@Entity
@Table(name="y_yp_ly")
public class YypLy implements Serializable{

	/**主键*/
	private Integer id;
	
	/**样品编号*/
	private String ypbh;
	
	/**二维码编号*/
	private String ewmbh;
	
	/**样品名称*/
	private String ypmc;
	
	/**领用时间*/
	private Date lysj;
	
	/**领用数量*/
	private String lysl;
	
	/**领用人*/
	private String lyr;
	
	/**办理人*/
	private String blr;
	
	/**领用用途*/
	private String lyyt;
	
	/**备注*/
	private String bz;
	
	/**报告编号*/
	private String bgbh;


	@Id
	//也可以使用sequence生成方式,SEQ_YP_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_YP_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="ypbh", length=50, nullable=true)
	public String getYpbh() {
		return ypbh;
	}

	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}

	@Column(name="ewmbh", length=50, nullable=true)
	public String getEwmbh() {
		return ewmbh;
	}

	public void setEwmbh(String ewmbh) {
		this.ewmbh = ewmbh;
	}

	@Column(name="ypmc", length=50, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="lysj", length=50, nullable=true)
	public Date getLysj() {
		return lysj;
	}

	public void setLysj(Date lysj) {
		this.lysj = lysj;
	}

	@Column(name="lysl", length=50, nullable=true)
	public String getLysl() {
		return lysl;
	}

	public void setLysl(String lysl) {
		this.lysl = lysl;
	}

	@Column(name="lyr", length=50, nullable=true)
	public String getLyr() {
		return lyr;
	}

	public void setLyr(String lyr) {
		this.lyr = lyr;
	}

	@Column(name="blr", length=50, nullable=true)
	public String getBlr() {
		return blr;
	}

	public void setBlr(String blr) {
		this.blr = blr;
	}

	@Column(name="lyyt", length=50, nullable=true)
	public String getLyyt() {
		return lyyt;
	}

	public void setLyyt(String lyyt) {
		this.lyyt = lyyt;
	}

	@Column(name="bz", length=50, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="bgbh", length=50, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}
	
}
