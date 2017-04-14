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
 * 档案保管期限管理model类 
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月12日 下午6:41:47 
 * 类说明 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_da_bgqx")
public class YdaBgqx implements Serializable{
	
	private Integer id;  //id
	
	private String lmmc;  //类目名称
	
	private String damj;  //档案密级
	
	private String bgqx;   //保管期限
	
	private Integer lmid;  //类目id
	
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

	@Column(name = "damj", nullable = true)
	public String getDamj() {
		return damj;
	}

	public void setDamj(String damj) {
		this.damj = damj;
	}

	@Column(name = "bgqx", nullable = true)
	public String getBgqx() {
		return bgqx;
	}

	public void setBgqx(String bgqx) {
		this.bgqx = bgqx;
	}

	@Column(name = "lmid", nullable = true)
	public Integer getLmid() {
		return lmid;
	}

	public void setLmid(Integer lmid) {
		this.lmid = lmid;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}
