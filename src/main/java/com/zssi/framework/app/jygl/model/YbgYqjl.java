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
 * 报告延期记录
 * @author liujiansen
 * @date 2015年12月19日
 */
@Entity
@Table(name = "y_bg_yqjl")
public class YbgYqjl implements Serializable{
	
	/**主键*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;
	
	/**完成期限*/
	private Date wcqx;
	
	/**最新完成期限*/
	private Date zxwcqx;
	
	/**修改时间*/
	private Date xgsj;
	
	/**修改人*/
	private String xgr;
	
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

	@Column(name="wcqx", length=20, nullable=true)
	public Date getWcqx() {
		return wcqx;
	}

	public void setWcqx(Date wcqx) {
		this.wcqx = wcqx;
	}

	@Column(name="zxwcqx", length=20, nullable=true)
	public Date getZxwcqx() {
		return zxwcqx;
	}

	public void setZxwcqx(Date zxwcqx) {
		this.zxwcqx = zxwcqx;
	}

	@Column(name="xgsj", length=20, nullable=true)
	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	@Column(name="xgr", length=200, nullable=true)
	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
