package com.zssi.framework.app.yhgl.model;

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
 * 用户管理model类
 * 
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月30日 上午10:05:25 类说明
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "sys_yh")
public class SysYhxx implements Serializable {

	/** 用户编号 */
	private Integer yhbh;

	/** 登录名 */
	private String dlm;

	/** 姓名 */
	private String xm;

	/** 密码 */
	private String mm;

	/** 部门编号 */
	private String bmbh;

	/** 岗位编号 */
	private String gwbh;

	/** 手机号 */
	private String sjh;

	/** 邮箱 */
	private String yx;

	/** 最后登录时间 */
	private Date zhdlsj;

	/** 状态(0:已删除,1:启用,2:禁用) */
	private Integer yhzt;

	/** 是否持有上岗证（0：持有；1：未持有） */
	private Integer cyzt;

	/** 上岗证编号 */
	private String sgzbh;

	/** 性别（0：男；1：女） */
	private Integer xb;

	/** 生日 */
	private Date sr;

	/** 联系电话 */
	private String lxdh;

	/** 职务 */
	private String zw;

	/** 家庭地址 */
	private String jtdz;

	/** 学历 */
	private String xl;

	/** 毕业院校 */
	private String byyx;

	/** 政治面貌 */
	private String zzmm;

	/** 民族 */
	private String mz;

	/** 别名 */
	private String bm;

	/** 用户排序号 */
	private Integer yhpxh;

	/** 管理范围 */
	private String glfw;

	/** QQ */
	private String qq;

	private String bmmc;

	private String dzqm;

	private String dzqmlj;

	private String yhjs;

	private String jbm1;

	private String jbm2;

	private String jbm3;

	private String jbm4;

	private Integer khfl;
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_SYS_YH_YHBH") })
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "yhbh", length = 36, nullable = false)
	public Integer getYhbh() {
		return yhbh;
	}

	public void setYhbh(Integer yhbh) {
		this.yhbh = yhbh;
	}

	@Column(name = "xm", length = 255, nullable = true)
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Column(name = "mm", length = 255, nullable = true)
	public String getMm() {
		return mm;
	}

	public String setMm(String mm) {
		return this.mm = mm;
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

	@Column(name = "bmbh", length = 20, nullable = true)
	public String getBmbh() {
		return bmbh;
	}

	@Column(name = "dlm", length = 20, nullable = true)
	public String getDlm() {
		return dlm;
	}

	public void setDlm(String dlm) {
		this.dlm = dlm;
	}

	@Column(name = "cyzt", length = 20, nullable = true)
	public Integer getCyzt() {
		return cyzt;
	}

	public void setCyzt(Integer cyzt) {
		this.cyzt = cyzt;
	}

	@Column(name = "sgzbh", length = 200, nullable = true)
	public String getSgzbh() {
		return sgzbh;
	}

	public void setSgzbh(String sgzbh) {
		this.sgzbh = sgzbh;
	}

	@Column(name = "xb", length = 20, nullable = true)
	public Integer getXb() {
		return xb;
	}

	public void setXb(Integer xb) {
		this.xb = xb;
	}

	@Column(name = "sr", length = 6, nullable = true)
	public Date getSr() {
		return sr;
	}

	public void setSr(Date sr) {
		this.sr = sr;
	}

	@Column(name = "lxdh", length = 300, nullable = true)
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name = "zw", length = 100, nullable = true)
	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	@Column(name = "jtdz", length = 500, nullable = true)
	public String getJtdz() {
		return jtdz;
	}

	public void setJtdz(String jtdz) {
		this.jtdz = jtdz;
	}

	@Column(name = "xl", length = 200, nullable = true)
	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	@Column(name = "byyx", length = 200, nullable = true)
	public String getByyx() {
		return byyx;
	}

	public void setByyx(String byyx) {
		this.byyx = byyx;
	}

	@Column(name = "zzmm", length = 200, nullable = true)
	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	@Column(name = "mz", length = 150, nullable = true)
	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	@Column(name = "bm", length = 100, nullable = true)
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	@Column(name = "yhpxh", length = 20, nullable = true)
	public Integer getYhpxh() {
		return yhpxh;
	}

	public void setYhpxh(Integer yhpxh) {
		this.yhpxh = yhpxh;
	}

	@Column(name = "glfw", length = 300, nullable = true)
	public String getGlfw() {
		return glfw;
	}

	public void setGlfw(String glfw) {
		this.glfw = glfw;
	}

	@Column(name = "qq", length = 200, nullable = true)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
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

	@Column(name = "bmmc", length = 200, nullable = true)
	public String getBmmc() {
		return bmmc;
	}

	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}

	@Column(name = "dzqm", length = 200, nullable = true)
	public String getDzqm() {
		return dzqm;
	}

	public void setDzqm(String dzqm) {
		this.dzqm = dzqm;
	}

	@Column(name = "dzqmlj", length = 200, nullable = true)
	public String getDzqmlj() {
		return dzqmlj;
	}

	public void setDzqmlj(String dzqmlj) {
		this.dzqmlj = dzqmlj;
	}

	@Column(name = "yhjs", length = 200, nullable = true)
	public String getYhjs() {
		return yhjs;
	}

	public void setYhjs(String yhjs) {
		this.yhjs = yhjs;
	}

	@Column(name = "jbm1", length = 200, nullable = true)
	public String getJbm1() {
		return jbm1;
	}

	public void setJbm1(String jbm1) {
		this.jbm1 = jbm1;
	}

	@Column(name = "jbm2", length = 200, nullable = true)
	public String getJbm2() {
		return jbm2;
	}

	public void setJbm2(String jbm2) {
		this.jbm2 = jbm2;
	}

	@Column(name = "jbm3", length = 200, nullable = true)
	public String getJbm3() {
		return jbm3;
	}

	public void setJbm3(String jbm3) {
		this.jbm3 = jbm3;
	}

	@Column(name = "jbm4", length = 200, nullable = true)
	public String getJbm4() {
		return jbm4;
	}

	public void setJbm4(String jbm4) {
		this.jbm4 = jbm4;
	}

	@Column(name = "khfl", length = 200, nullable = true)
	public Integer getKhfl() {
		return khfl;
	}

	public void setKhfl(Integer khfl) {
		this.khfl = khfl;
	}
	
	

}
