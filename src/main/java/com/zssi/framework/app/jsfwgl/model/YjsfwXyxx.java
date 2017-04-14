package com.zssi.framework.app.jsfwgl.model; 

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * 技术服务协议信息
 * @author liusong
 * @date 2015年9月23日
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_jsfw_xyxx")
public class YjsfwXyxx implements Serializable {
	
	private Integer id;   //id
	
	private String xybh;  //协议编号
	
	private String khmc;   //客户名称
	
	private String khdz;  //客户地址
	
	private String frdb;   //法人代表
	
	private String lxdh;   //联系电话
	
	private String cpmc;   //涉及产品名称
	
	private String fwxm;   //服务项目
	
	private String xylx;   //协议类型
	
	private Date sxrq;   //生效日期
	
	private Date zzrq;   //终止日期
	
	private String ks_id;  //协议科室
	
	private String xyzy;   //协议摘要
	
	private BigDecimal xykh;  //协议金额
	
	private BigDecimal syje;  //剩余金额
	
	private Integer fkfs;   //付款方式
	
	private String bz_id;   //执行标准
	
	private String jybh_id;  //已出具检验批次报告编号
	
	private String khjlgm;   //客户经济类型及规模
	
	private String khhz_info;  //客户已获取证情况
	
	private String xyfzr;  //协议负责人
	
	private Date djrq;   //登记日期
	
	private String jyks_id; //检验科室
	
	private String yeks_id; //业务科室
	
	private String bz;  //备注
	
	private String xmlxr; //项目联系人
	
	private String dhhm;  //项目电话

	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JSFW_XYXX_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "xybh", nullable = true)
	public String getXybh() {
		return xybh;
	}

	public void setXybh(String xybh) {
		this.xybh = xybh;
	}

	@Column(name = "khmc", nullable = true)
	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	@Column(name = "khdz", nullable = true)
	public String getKhdz() {
		return khdz;
	}

	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}

	@Column(name = "frdb", nullable = true)
	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	@Column(name = "lxdh", nullable = true)
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	@Column(name = "cpmc", nullable = true)
	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	@Column(name = "fwxm", nullable = true)
	public String getFwxm() {
		return fwxm;
	}

	public void setFwxm(String fwxm) {
		this.fwxm = fwxm;
	}

	@Column(name = "xylx", nullable = true)
	public String getXylx() {
		return xylx;
	}

	public void setXylx(String xylx) {
		this.xylx = xylx;
	}

	@Column(name = "sxrq", nullable = true)
	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	@Column(name = "zzrq", nullable = true)
	public Date getZzrq() {
		return zzrq;
	}

	public void setZzrq(Date zzrq) {
		this.zzrq = zzrq;
	}

	@Column(name = "ks_id", nullable = true)
	public String getKs_id() {
		return ks_id;
	}

	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}

	@Column(name = "xyzy", nullable = true)
	public String getXyzy() {
		return xyzy;
	}

	public void setXyzy(String xyzy) {
		this.xyzy = xyzy;
	}

	@Column(name = "xykh", nullable = true)
	public BigDecimal getXykh() {
		return xykh;
	}

	public void setXykh(BigDecimal xykh) {
		this.xykh = xykh;
	}
	
	@Column(name = "syje", nullable = true)
	public BigDecimal getSyje() {
		return syje;
	}

	public void setSyje(BigDecimal syje) {
		this.syje = syje;
	}

	@Column(name = "fkfs", nullable = true)
	public Integer getFkfs() {
		return fkfs;
	}

	public void setFkfs(Integer fkfs) {
		this.fkfs = fkfs;
	}

	@Column(name = "bz_id", nullable = true)
	public String getBz_id() {
		return bz_id;
	}

	public void setBz_id(String bz_id) {
		this.bz_id = bz_id;
	}

	@Column(name = "jybh_id", nullable = true)
	public String getJybh_id() {
		return jybh_id;
	}

	public void setJybh_id(String jybh_id) {
		this.jybh_id = jybh_id;
	}

	@Column(name = "khjlgm", nullable = true)
	public String getKhjlgm() {
		return khjlgm;
	}

	public void setKhjlgm(String khjlgm) {
		this.khjlgm = khjlgm;
	}

	@Column(name = "khhz_info", nullable = true)
	public String getKhhz_info() {
		return khhz_info;
	}

	public void setKhhz_info(String khhz_info) {
		this.khhz_info = khhz_info;
	}

	@Column(name = "xyfzr", nullable = true)
	public String getXyfzr() {
		return xyfzr;
	}

	public void setXyfzr(String xyfzr) {
		this.xyfzr = xyfzr;
	}

	@Column(name = "djrq", nullable = true)
	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	@Column(name = "jyks_id", nullable = true)
	public String getJyks_id() {
		return jyks_id;
	}

	public void setJyks_id(String jyks_id) {
		this.jyks_id = jyks_id;
	}

	@Column(name = "yeks_id", nullable = true)
	public String getYeks_id() {
		return yeks_id;
	}

	public void setYeks_id(String yeks_id) {
		this.yeks_id = yeks_id;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "xmlxr", nullable = true)
	public String getXmlxr() {
		return xmlxr;
	}

	public void setXmlxr(String xmlxr) {
		this.xmlxr = xmlxr;
	}

	@Column(name = "dhhm", nullable = true)
	public String getDhhm() {
		return dhhm;
	}

	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}
	
}
