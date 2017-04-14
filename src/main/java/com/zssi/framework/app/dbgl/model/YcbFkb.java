package com.zssi.framework.app.dbgl.model; 

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
 * 督办反馈列表model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:08:44 
 * 类说明 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Y_CB_FKB")
public class YcbFkb implements Serializable{
	
	private Integer id;  //反馈id
	
	private String bgbh;  //报告编号
	
	private String cbid;  //催办id
	
	private String rwmc;  //任务id
	
	private String fknr;  //反馈内容
	
	private Date fksj;   //反馈时间
	
	private Integer fkzt;  //反馈状态
	
	private String fkr;  //反馈人
	
	private Integer fkrid;  //反馈人编号

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_CB_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="bgbh", length=100, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="cbid", length=100, nullable=true)
	public String getCbid() {
		return cbid;
	}

	public void setCbid(String cbid) {
		this.cbid = cbid;
	}

	@Column(name="rwmc", length=100, nullable=true)
	public String getRwmc() {
		return rwmc;
	}

	public void setRwmc(String rwmc) {
		this.rwmc = rwmc;
	}

	@Column(name="fknr", length=100, nullable=true)
	public String getFknr() {
		return fknr;
	}

	public void setFknr(String fknr) {
		this.fknr = fknr;
	}

	@Column(name="fksj", length=100, nullable=true)
	public Date getFksj() {
		return fksj;
	}

	public void setFksj(Date fksj) {
		this.fksj = fksj;
	}

	@Column(name="fkzt", length=100, nullable=true)
	public Integer getFkzt() {
		return fkzt;
	}

	public void setFkzt(Integer fkzt) {
		this.fkzt = fkzt;
	}
	
	@Column(name="fkr", length=100, nullable=true)
	public String getFkr() {
		return fkr;
	}

	public void setFkr(String fkr) {
		this.fkr = fkr;
	}

	@Column(name="fkrid", length=100, nullable=true)
	public Integer getFkrid() {
		return fkrid;
	}

	public void setFkrid(Integer fkrid) {
		this.fkrid = fkrid;
	}
}
