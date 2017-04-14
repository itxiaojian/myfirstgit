package com.zssi.framework.app.rsgl.model;

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
 * 人事管理--培训记录信息
 * @author wangyong
 * @date 2015年10月22日
 */
@Entity
@Table(name="y_rs_pxjl_info")
public class YrsPxjlInfo implements Serializable{

	/**主键id*/
	private Integer id;
	
	/**人员编号*/
	private String rybh;
	
	/**人员帐号*/
	private String ryzh;
	
	/**人员姓名*/
	private String ryxm;
	
	/**所属科室*/
	private String ks_id;
	
	/**性别(0：男；1：女)*/
	private Integer xb;
	
	/**生日*/
	private Date sr;
	
	/**联系电话*/
	private String lxdh;
	
	/**手机号码*/
	private String sjhm;
	
	/**家庭住址*/
	private String jtzz;
	
	/**培训名称*/
	private String pxmc;
	
	/**获得证书名称*/
	private String hdzsmc;
	
	/**培训时间*/
	private Date pxsj;
	
	/**培训内容*/
	private String pxnr;
	
	/**备注*/
	private String bz;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_RS_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="rybh",length=50,nullable=true)
	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}

	@Column(name="ryzh",length=50,nullable=true)
	public String getRyzh() {
		return ryzh;
	}

	public void setRyzh(String ryzh) {
		this.ryzh = ryzh;
	}

	@Column(name="ryxm",length=50,nullable=true)
	public String getRyxm() {
		return ryxm;
	}

	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}

	@Column(name="ks_id",length=50,nullable=true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}

	@Column(name="xb",length=50,nullable=true)
	public Integer getXb() {
		return xb;
	}

	public void setXb(Integer xb) {
		this.xb = xb;
	}

	@Column(name="sr",length=50,nullable=true)
	public Date getSr() {
		return sr;
	}

	public void setSr(Date sr) {
		this.sr = sr;
	}

	@Column(name="lxdh",length=50,nullable=true)
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name="sjhm",length=50,nullable=true)
	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	@Column(name="jtzz",length=100,nullable=true)
	public String getJtzz() {
		return jtzz;
	}

	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}

	@Column(name="pxmc",length=100,nullable=true)
	public String getPxmc() {
		return pxmc;
	}

	public void setPxmc(String pxmc) {
		this.pxmc = pxmc;
	}

	@Column(name="hdzsmc",length=100,nullable=true)
	public String getHdzsmc() {
		return hdzsmc;
	}

	public void setHdzsmc(String hdzsmc) {
		this.hdzsmc = hdzsmc;
	}

	@Column(name="pxsj",length=100,nullable=true)
	public Date getPxsj() {
		return pxsj;
	}

	public void setPxsj(Date pxsj) {
		this.pxsj = pxsj;
	}

	@Column(name="pxnr",length=100,nullable=true)
	public String getPxnr() {
		return pxnr;
	}

	public void setPxnr(String pxnr) {
		this.pxnr = pxnr;
	}

	@Column(name="bz",length=500,nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
