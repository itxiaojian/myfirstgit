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
 * 内委管理mx
 * @author liujiansen
 * @date 2015年12月31日
 */
@Entity
@Table(name = "y_jy_nwmx")
public class YjyNwmx implements Serializable{

	/**序号*/
	private Integer id;
	
	/**报告编号*/
	private String bgbh;

	/**内委编号*/
	private Integer nwbh;
	
	/**样品名称*/
	private String ypmc;
	
	/**规格型号*/
	private String ggxh;
	
	/**检验依据*/
	private String jyyj;
	
	/**检验项目*/
	private String jyxm;
	
	/**检验费用*/
	private Integer jyfy;
	
	/**是否退样（0：是；1：否）*/
	private Integer sfty;
	
	/**样品保管期限*/
	private String ypbgqx;
	
	/**委托单位*/
	private String wtdw;
	
	/**登记时间*/
	private Date djsj;
	
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

	@Column(name="bgbh", length=500, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="ypmc", length=102, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="ggxh", length=102, nullable=true)
	public String getGgxh() {
		return ggxh;
	}

	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}

	@Column(name="jyxm", length=200, nullable=true)
	public String getJyxm() {
		return jyxm;
	}

	public void setJyxm(String jyxm) {
		this.jyxm = jyxm;
	}

	@Column(name="jyfy", length=22, nullable=true)
	public Integer getJyfy() {
		return jyfy;
	}

	public void setJyfy(Integer jyfy) {
		this.jyfy = jyfy;
	}

	@Column(name="sfty", length=22, nullable=true)
	public Integer getSfty() {
		return sfty;
	}

	public void setSfty(Integer sfty) {
		this.sfty = sfty;
	}

	@Column(name="ypbgqx", length=30, nullable=true)
	public String getYpbgqx() {
		return ypbgqx;
	}

	public void setYpbgqx(String ypbgqx) {
		this.ypbgqx = ypbgqx;
	}

	@Column(name="nwbh", length=22, nullable=true)
	public Integer getNwbh() {
		return nwbh;
	}

	public void setNwbh(Integer nwbh) {
		this.nwbh = nwbh;
	}

	@Column(name="wtdw", length=200, nullable=true)
	public String getWtdw() {
		return wtdw;
	}

	public void setWtdw(String wtdw) {
		this.wtdw = wtdw;
	}

	@Column(name="djsj", length=11, nullable=true)
	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}

	@Column(name="jyyj", length=500, nullable=true)
	public String getJyyj() {
		return jyyj;
	}

	public void setJyyj(String jyyj) {
		this.jyyj = jyyj;
	}
}
