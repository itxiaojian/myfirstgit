package com.zssi.framework.app.sys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.security.core.GrantedAuthority;

/**
 * 系统角色
 * 
 * @author 
 * @since 2015-04-09
 */
@Entity
@Table(name = "sys_js")
public class SysJs implements Serializable, GrantedAuthority {

	/** jsbh */
	private Integer jsbh;

	/** jsmc */
	private String jsmc;

	/** bz */
	private String bz;

	/** 是否生效(0:无效,1:有效) */
	private Integer jszt;

	@Id
	//主键生成策略可以使用UUID方式
//	@GenericGenerator(name = "idGenerator", strategy = "uuid")
//	@GeneratedValue(generator = "idGenerator")
	//也可以使用sequence生成方式,SEQ_SYS_SJZD_ID代表数据库中的序列
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_SYS_SJZD_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "jsbh", length = 36, nullable = false)
	public Integer getJsbh() {
		return jsbh;
	}

	public void setJsbh(Integer jsbh) {
		this.jsbh = jsbh;
	}

	@Column(name = "jsmc", length = 200, nullable = false)
	public String getJsmc() {
		return jsmc;
	}

	public void setJsmc(String jsmc) {
		this.jsmc = jsmc;
	}

	@Column(name = "bz", length = 200, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "jszt", length = 10, nullable = true)
	public Integer getJszt() {
		return jszt;
	}

	public void setJszt(Integer jszt) {
		this.jszt = jszt;
	}

	@Transient
	public String getAuthority() {
		return this.jsmc;
	}

}
