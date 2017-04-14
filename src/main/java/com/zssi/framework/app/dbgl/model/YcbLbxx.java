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
 * 督办列表信息model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:07:40 
 * 类说明 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Y_CB_LBXX")
public class YcbLbxx implements Serializable {
	
	private Integer id;//督办ID
	
	private String bgbh;  //报告编号
	
	private Integer rwmc;  //任务名称
	
	private Date cbsj;  //督办时间
	
	private String cbnr;  //督办内容
	
	private String cbr;  //督办人
	
	private Integer cbzt;  //督办状态
	
	private Integer fkzt;  //反馈状态
	
	private Integer fkts;   //反馈条数
	
	private String fj;   //附件

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

	@Column(name="rwmc", length=100, nullable=true)
	public Integer getRwmc() {
		return rwmc;
	}

	public void setRwmc(Integer rwmc) {
		this.rwmc = rwmc;
	}

	@Column(name="cbsj", length=100, nullable=true)
	public Date getCbsj() {
		return cbsj;
	}

	public void setCbsj(Date cbsj) {
		this.cbsj = cbsj;
	}

	@Column(name="cbnr", length=100, nullable=true)
	public String getCbnr() {
		return cbnr;
	}

	public void setCbnr(String cbnr) {
		this.cbnr = cbnr;
	}

	@Column(name="cbr", length=100, nullable=true)
	public String getCbr() {
		return cbr;
	}

	public void setCbr(String cbr) {
		this.cbr = cbr;
	}

	@Column(name="cbzt", length=100, nullable=true)
	public Integer getCbzt() {
		return cbzt;
	}

	public void setCbzt(Integer cbzt) {
		this.cbzt = cbzt;
	}

	@Column(name="fkzt", length=100, nullable=true)
	public Integer getFkzt() {
		return fkzt;
	}

	public void setFkzt(Integer fkzt) {
		this.fkzt = fkzt;
	}

	@Column(name="fkts", length=100, nullable=true)
	public Integer getFkts() {
		return fkts;
	}

	public void setFkts(Integer fkts) {
		this.fkts = fkts;
	}

	@Column(name="fj", length=100, nullable=true)
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}
}
