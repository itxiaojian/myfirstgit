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
 * 档案信息model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午2:11:28 
 * 类说明 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "y_da_xx")
public class YdaXx implements Serializable{
	
	private Integer id;    //id
	
	private String dabt;   //档案标题
	
	private String dagjz;   //档案关键字
	
	private String dalx;    //档案类型
	
	private String sslmid;  //所属类目id
	
	private String lmmc;   //所属类目名称
	
	private String damj;   //档案密级
	
	private String ssjgid;  //所属机构id
	
	private String gdnr;   //归档内容
	
	private String fjid;  //附件id
	
	private String bgqx;  //保管期限
	
	private Integer sfqd;  //是否清档
	
	private String gdr;   //归档人
	
	private String kckrid;  //可查看人id
	
	private String kckrxm;   //可查看人姓名
	
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

	@Column(name = "dabt", nullable = true)
	public String getDabt() {
		return dabt;
	}

	public void setDabt(String dabt) {
		this.dabt = dabt;
	}

	@Column(name = "dagjz", nullable = true)
	public String getDagjz() {
		return dagjz;
	}

	public void setDagjz(String dagjz) {
		this.dagjz = dagjz;
	}

	@Column(name = "dalx", nullable = true)
	public String getDalx() {
		return dalx;
	}

	public void setDalx(String dalx) {
		this.dalx = dalx;
	}

	@Column(name = "sslmid", nullable = true)
	public String getSslmid() {
		return sslmid;
	}

	public void setSslmid(String sslmid) {
		this.sslmid = sslmid;
	}

	@Column(name = "lmmc", nullable = true)
	public String getLmmc() {
		return lmmc;
	}

	public void setLmmc(String lmmc) {
		this.lmmc = lmmc;
	}

	@Column(name = "damj", nullable = true)
	public String getDamj() {
		return damj;
	}

	public void setDamj(String damj) {
		this.damj = damj;
	}

	@Column(name = "ssjgid", nullable = true)
	public String getSsjgid() {
		return ssjgid;
	}

	public void setSsjgid(String ssjgid) {
		this.ssjgid = ssjgid;
	}

	@Column(name = "gdnr", nullable = true)
	public String getGdnr() {
		return gdnr;
	}

	public void setGdnr(String gdnr) {
		this.gdnr = gdnr;
	}

	@Column(name = "fjid", nullable = true)
	public String getFjid() {
		return fjid;
	}

	public void setFjid(String fjid) {
		this.fjid = fjid;
	}

	@Column(name = "bgqx", nullable = true)
	public String getBgqx() {
		return bgqx;
	}

	public void setBgqx(String bgqx) {
		this.bgqx = bgqx;
	}

	@Column(name = "sfqd", nullable = true)
	public Integer getSfqd() {
		return sfqd;
	}

	public void setSfqd(Integer sfqd) {
		this.sfqd = sfqd;
	}

	@Column(name = "gdr", nullable = true)
	public String getGdr() {
		return gdr;
	}

	public void setGdr(String gdr) {
		this.gdr = gdr;
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

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
