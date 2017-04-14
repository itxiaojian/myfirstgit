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
 * 经费管理model类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月15日 下午1:04:54 
 * 类说明 
 */
@SuppressWarnings( "serial" )
@Entity
@Table(name = "y_ky_jfgl")
public class YkyJfgl implements Serializable {
	
	private Integer id;  //id
	
    private String kybh;  //科研编号
	
	private String kymc;   //科研名称
	
	private String kyxmnr;  //科研项目内容
	
	private String ks_id;  //所属科室
	
	private String cyry;  //参与人员 
	
	private Date lxsj;  //立项时间
	
	private Date htsj;  //合同时间
	
	private String jfje;  //经费金额
	
	private Date bksj;   //拨款时间
	
	private String bz;   //备注

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

	@Column(name = "lxsj", nullable = true)
	public Date getLxsj() {
		return lxsj;
	}

	public void setLxsj(Date lxsj) {
		this.lxsj = lxsj;
	}

	@Column(name = "htsj", nullable = true)
	public Date getHtsj() {
		return htsj;
	}

	public void setHtsj(Date htsj) {
		this.htsj = htsj;
	}

	@Column(name = "jfje", nullable = true)
	public String getJfje() {
		return jfje;
	}

	public void setJfje(String jfje) {
		this.jfje = jfje;
	}

	@Column(name = "bksj", nullable = true)
	public Date getBksj() {
		return bksj;
	}

	public void setBksj(Date bksj) {
		this.bksj = bksj;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
