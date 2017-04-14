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
 * 科研信息管理model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 上午9:40:33 
 * 类说明 
 */
@SuppressWarnings( "serial" )
@Entity
@Table(name = "y_ky_xxgl")
public class YkyXxgl implements Serializable{
	
	private Integer id;  //id

	private String kybh;  //科研编号
	
	private String kymc;   //科研名称
	
	private String kyxmnr;  //科研项目内容
	
	private String ks_id;  //所属科室
	
	private String cyry;  //参与人员
	
	private Date kssj;   //开始时间
	
	private Date jssj;   //结束时间
	
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

	@Column(name = "ks_id", nullable = true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
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

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
