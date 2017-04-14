package com.zssi.framework.app.dagl.model; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/** 
 * 档案类目管理model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午4:34:51 
 * 类说明 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_da_lmgl")
public class YdaLmgl implements Serializable{
	
	private Integer id;  //id
	
	private String lmmc;  //类目名称
	
	private String lmjb;  //类目级别
	
	private String ssjgid;  //所属机构id
	
	private String ssjgmc;  //所属机构名称
	
	private String yjlmid;  //一级类目id
	
	private String sjlmid; //上级类目id
	
	private String flyid;  //管理员id
	
	private String glyxm;  //管理员姓名
	
	private String cjrid;  //创建人id
	
	private String cjrxm;  //创建人姓名
	
	private String kckrid;  //可查看人id
	
	private String kckrxm;  //可查看人姓名
	
	private Integer lmpx;  //类目排序
	
	private String bz;  //备注

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_DA_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "lmmc", nullable = true)
	public String getLmmc() {
		return lmmc;
	}

	public void setLmmc(String lmmc) {
		this.lmmc = lmmc;
	}

	@Column(name = "lmjb", nullable = true)
	public String getLmjb() {
		return lmjb;
	}

	public void setLmjb(String lmjb) {
		this.lmjb = lmjb;
	}

	@Column(name = "ssjgid", nullable = true)
	public String getSsjgid() {
		return ssjgid;
	}

	public void setSsjgid(String ssjgid) {
		this.ssjgid = ssjgid;
	}

	@Column(name = "ssjgmc", nullable = true)
	public String getSsjgmc() {
		return ssjgmc;
	}

	public void setSsjgmc(String ssjgmc) {
		this.ssjgmc = ssjgmc;
	}

	@Column(name = "yjlmid", nullable = true)
	public String getYjlmid() {
		return yjlmid;
	}

	public void setYjlmid(String yjlmid) {
		this.yjlmid = yjlmid;
	}

	@Column(name = "sjlmid", nullable = true)
	public String getSjlmid() {
		return sjlmid;
	}

	public void setSjlmid(String sjlmid) {
		this.sjlmid = sjlmid;
	}

	@Column(name = "flyid", nullable = true)
	public String getFlyid() {
		return flyid;
	}

	public void setFlyid(String flyid) {
		this.flyid = flyid;
	}

	@Column(name = "glyxm", nullable = true)
	public String getGlyxm() {
		return glyxm;
	}

	public void setGlyxm(String glyxm) {
		this.glyxm = glyxm;
	}

	@Column(name = "cjrid", nullable = true)
	public String getCjrid() {
		return cjrid;
	}

	public void setCjrid(String cjrid) {
		this.cjrid = cjrid;
	}

	@Column(name = "cjrxm", nullable = true)
	public String getCjrxm() {
		return cjrxm;
	}

	public void setCjrxm(String cjrxm) {
		this.cjrxm = cjrxm;
	}

	@Column(name = "kckrid", nullable = true)
	public String getKckrid() {
		return kckrid;
	}

	public void setKckrid(String kckrid) {
		this.kckrid = kckrid;
	}

	@Column(name = "kckrxm", nullable = true)
	public String getKckrxm() {
		return kckrxm;
	}

	public void setKckrxm(String kckrxm) {
		this.kckrxm = kckrxm;
	}

	@Column(name = "lmpx", nullable = true)
	public Integer getLmpx() {
		return lmpx;
	}

	public void setLmpx(Integer lmpx) {
		this.lmpx = lmpx;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
