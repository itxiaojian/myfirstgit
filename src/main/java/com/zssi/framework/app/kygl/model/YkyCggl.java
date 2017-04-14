package com.zssi.framework.app.kygl.model; 

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
 * 科研管理成果管理model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 下午4:02:13 
 * 类说明 
 */
@SuppressWarnings( "serial" )
@Entity
@Table(name = "y_ky_cggl")
public class YkyCggl implements Serializable{
	
	private Integer id;  //id

	private String kybh;  //科研编号
	
	private String kymc;   //科研名称
	
	private String kyxmnr;  //科研项目内容
	
	private String ssks;  //所属科室
	
	private String cyry;  //参与人员
	
	private Date kssj;   //开始时间
	
	private Date jssj;   //结束时间
	
	private String cglx;  //成果类型
	
	private String cgnr;   //成果内容
	
	private String  bz;   //备注

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_KY_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "kybh", nullable = true)
	public String getKybh() {
		return kybh;
	}

	public void setKybh(String kybh) {
		this.kybh = kybh;
	}

	@Column(name = "kymc", nullable = true)
	public String getKymc() {
		return kymc;
	}

	public void setKymc(String kymc) {
		this.kymc = kymc;
	}

	@Column(name = "kyxmnr", nullable = true)
	public String getKyxmnr() {
		return kyxmnr;
	}

	public void setKyxmnr(String kyxmnr) {
		this.kyxmnr = kyxmnr;
	}

	@Column(name = "ssks", nullable = true)
	public String getSsks() {
		return ssks;
	}

	public void setSsks(String ssks) {
		this.ssks = ssks;
	}

	@Column(name = "cyry", nullable = true)
	public String getCyry() {
		return cyry;
	}

	public void setCyry(String cyry) {
		this.cyry = cyry;
	}

	@Column(name = "kssj", nullable = true)
	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	@Column(name = "jssj", nullable = true)
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	@Column(name = "cglx", nullable = true)
	public String getCglx() {
		return cglx;
	}

	public void setCglx(String cglx) {
		this.cglx = cglx;
	}

	@Column(name = "cgnr", nullable = true)
	public String getCgnr() {
		return cgnr;
	}

	public void setCgnr(String cgnr) {
		this.cgnr = cgnr;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
