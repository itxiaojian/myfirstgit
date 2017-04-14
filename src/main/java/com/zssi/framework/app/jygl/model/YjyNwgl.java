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
 * 内委管理
 * @author liujiansen
 * @date 2015年12月30日
 */
@Entity
@Table(name = "y_jy_nwgl")
public class YjyNwgl implements Serializable{

	/**序号*/
	private Integer id;
	
	/**委托部门*/
	private String wtbm;
	
	/**承检部门*/
	private String cjbm;
	
	/**委托日期*/
	private Date wtrq;
	
	/**要求完成日期*/
	private Date yqwcrq;
	
	/**经办人*/
	private String jbr;
	
	/**经办日期*/
	private Date jbrq;
	
	/**部门领导*/
	private String bmld;
	
	/**领导签字日期*/
	private Date qzrq;
	
	/**接收人*/
	private String jsr;
	
	/**接收日期*/
	private Date jsrq;
	
	/**流转单状态（0：流转单接收；1：流转单审核；2审核结束）*/
	private Integer lzdzt;
	
	/**委托样品数*/
	private Integer wtyps;
	
	/**检验费用*/
	private Integer jyfy;

	
	
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

	@Column(name="wtbm", length=50, nullable=true)
	public String getWtbm() {
		return wtbm;
	}

	public void setWtbm(String wtbm) {
		this.wtbm = wtbm;
	}

	@Column(name="cjbm", length=50, nullable=true)
	public String getCjbm() {
		return cjbm;
	}

	public void setCjbm(String cjbm) {
		this.cjbm = cjbm;
	}

	@Column(name="wtrq", length=11, nullable=true)
	public Date getWtrq() {
		return wtrq;
	}

	public void setWtrq(Date wtrq) {
		this.wtrq = wtrq;
	}

	@Column(name="yqwcrq", length=11, nullable=true)
	public Date getYqwcrq() {
		return yqwcrq;
	}

	public void setYqwcrq(Date yqwcrq) {
		this.yqwcrq = yqwcrq;
	}

	@Column(name="jyfy", length=22, nullable=true)
	public Integer getJyfy() {
		return jyfy;
	}

	public void setJyfy(Integer jyfy) {
		this.jyfy = jyfy;
	}

	@Column(name="jbr", length=30, nullable=true)
	public String getJbr() {
		return jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	@Column(name="jbrq", length=11, nullable=true)
	public Date getJbrq() {
		return jbrq;
	}

	public void setJbrq(Date jbrq) {
		this.jbrq = jbrq;
	}

	@Column(name="bmld", length=30, nullable=true)
	public String getBmld() {
		return bmld;
	}

	public void setBmld(String bmld) {
		this.bmld = bmld;
	}

	@Column(name="qzrq", length=11, nullable=true)
	public Date getQzrq() {
		return qzrq;
	}

	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
	}

	@Column(name="jsr", length=30, nullable=true)
	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	@Column(name="jsrq", length=11, nullable=true)
	public Date getJsrq() {
		return jsrq;
	}

	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}

	@Column(name="lzdzt", length=22, nullable=true)
	public Integer getLzdzt() {
		return lzdzt;
	}

	public void setLzdzt(Integer lzdzt) {
		this.lzdzt = lzdzt;
	}

	@Column(name="wtyps", length=22, nullable=true)
	public Integer getWtyps() {
		return wtyps;
	}

	public void setWtyps(Integer wtyps) {
		this.wtyps = wtyps;
	}
}
