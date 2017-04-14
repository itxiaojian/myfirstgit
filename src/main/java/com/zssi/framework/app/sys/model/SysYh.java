package com.zssi.framework.app.sys.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 系统用户
 * 
 * @author 
 * @since 2015-04-09
 */
@Entity
@Table(name = "sys_yh")
public class SysYh implements Serializable, UserDetails {

	/** yhbh */
	private Integer yhbh;

	/** 用户名 */
	private String xm;

	/** 登录名 */
	private String username;

	/** 密码 */
	private String password;

	/** 邮箱 */
	private String yx;

	/** 最后登录时间 */
	private Date zhdlsj;

	/** 状态(0:已删除,1:启用,2:禁用) */
	private Integer yhzt;
	
	/** 部门编号*/
	private String bmbh;
	
	/** 岗位编号*/
	private String gwbh;
	
	/** 手机号*/
	private String sjh;
	
	/** 手机号*/
	private Integer yhpxh;
	
	private String yhjs;
	
	private String jbm1;
	
	private String jbm2;
	
	private String jbm3;
	
	private String jbm4;


	private Set<SysJs> sysJs = new HashSet<SysJs>();

	@Id
//	@GenericGenerator(name = "idGenerator", strategy = "uuid")
//	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_SYS_YH_YHBH")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "yhbh", length = 36, nullable = false)
	public Integer getYhbh() {
		return yhbh;
	}

	public void setYhbh(Integer yhbh) {
		this.yhbh = yhbh;
	}

	@ManyToMany(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "sys_yhjs", joinColumns = { @JoinColumn(name = "yhbh") }, inverseJoinColumns = { @JoinColumn(name = "jsbh") })
	public Set<SysJs> getSysJs() {
		return sysJs;
	}

	public void setSysJs(Set<SysJs> sysJs) {
		this.sysJs = sysJs;
	}

	@Column(name = "xm", length = 255, nullable = false)
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Column(name = "dlm", length = 255, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "mm", length = 255, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "yx", length = 50, nullable = true)
	public String getYx() {
		return yx;
	}

	public void setYx(String yx) {
		this.yx = yx;
	}

	@Column(name = "zhdlsj", length = 19, nullable = true)
	public Date getZhdlsj() {
		return zhdlsj;
	}

	public void setZhdlsj(Date zhdlsj) {
		this.zhdlsj = zhdlsj;
	}

	@Column(name = "yhzt", length = 10, nullable = true)
	public Integer getYhzt() {
		return yhzt;
	}

	public void setYhzt(Integer yhzt) {
		this.yhzt = yhzt;
	}
	
//	@Column(name = "user_code", length = 12, nullable = true)
//	public String getUserCode() {
//		return userCode;
//	}
//
//	public void setUserCode(String userCode) {
//		this.userCode = userCode;
//	}

	@Column(name = "bmbh", length = 20, nullable = true)
	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}
	
	@Column(name = "jbm1", length = 20, nullable = true)
	public String getJbm1() {
		return jbm1;
	}

	public void setJbm1(String jbm1) {
		this.jbm1 = jbm1;
	}

	@Column(name = "jbm2", length = 20, nullable = true)
	public String getJbm2() {
		return jbm2;
	}

	public void setJbm2(String jbm2) {
		this.jbm2 = jbm2;
	}

	@Column(name = "jbm3", length = 20, nullable = true)
	public String getJbm3() {
		return jbm3;
	}

	public void setJbm3(String jbm3) {
		this.jbm3 = jbm3;
	}

	@Column(name = "jbm4", length = 20, nullable = true)
	public String getJbm4() {
		return jbm4;
	}

	public void setJbm4(String jbm4) {
		this.jbm4 = jbm4;
	}

	@Column(name = "gwbh", length = 20, nullable = true)
	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	@Column(name = "sjh", length = 20, nullable = true)
	public String getSjh() {
		return sjh;
	}

	public void setSjh(String sjh) {
		this.sjh = sjh;
	}

	
	@Column(name = "yhpxh", length = 20, nullable = true)
	public Integer getYhpxh() {
		return yhpxh;
	}

	public void setYhpxh(Integer yhpxh) {
		this.yhpxh = yhpxh;
	}

	@Transient
	public boolean isEnabled() {
		return this.yhzt == 1 ? true : false;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		return (Collection) sysJs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof SysYh))
			return false;

		return username.equals(((SysYh) obj).getUsername());
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}
	
	@Column(name = "yhjs", length = 4000, nullable = true)
	public String getYhjs() {
		return yhjs;
	}

	public void setYhjs(String yhjs) {
		this.yhjs = yhjs;
	}

}
