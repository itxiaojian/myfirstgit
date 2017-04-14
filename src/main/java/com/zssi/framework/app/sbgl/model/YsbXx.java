package com.zssi.framework.app.sbgl.model;

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
 * 设备信息model类
 * @author liusong
 * @since  2015-09-22
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_sb_xx")
public class YsbXx implements Serializable {
	/**主键*/
	private Integer id;      //id
	
	private String sbbh;   //设备编号
	
	private String ewmbh;   //二维码编号
	
	private String ewmtp;   //二维码图片
	
	private String sbmc;   //设备名称
	
	private String sbxh;   //规格型号
	
	private String sbjb;  //设备精度
	
	private String syks;// 使用科室
	
	private String syfw;//使用参数
	
	private String sccj; //生产厂家
	
	private String ccbh; //出厂编号
	
	private Date ccrq; //出厂日期
	
	private Date gmrq; //登记日期
	
	private BigDecimal gmjg;  //购买价格
	
	private Integer jyzq;  //检定周期
	
	private Date scjdrq; //上次检定日期
	
	private Date xcjdrq; //下次检定日期
	
	private Integer syzt;   //使用状态
	
	private Integer yqzk;   //仪器状况
	
	private String sbwhr;   //保管人
	
	private Date tyrq; //停用日期
	
	private String tyyy;  //停用原因
	
	private Date bfrq; //报废日期
	
	private String bfyy;  //报废原因
	
	private String bz;    //备注
	
	private Integer dw;    //计量单位（0套；1台）
	
	private String sbfj;   //其他附件
	
	private String fzdd;   //防止地点
	
	private Date qysj;     //启用时间
	
	private String cjlxr;   //厂家联系人
	
	private String cjdh;    //厂家电话
	
	private String cjdz;    //厂家地址
	
	private String clfw;     //测量范围
	
	private String pjxx;     //配件信息
	
	private String sbczr;     //操作人
	
	private Integer sfyczgc;   //是否有操作规程
	
	private Integer sfyqjhc;   //是否有期间核查
	
	private Integer sfysyjl;   //是否有使用记录
	
	private Integer sfygnjc;   //是否有功能检查
	
	private Integer sbzt;      //设备状态
	
	private String czgc;     //操作规程
	
	private String sysms;    //使用说明书
	
	private String sbzp;    //设备照片
	
	private String sysmffj;  //使用说明书附件
	
	private String gnjcff;   //功能检查方法
	
	private String qjhcff;   //期间核查方法
	
	private String bzddj;    //标准度等级/不确定度
	
	private String jlqk;     //计量情况
	
	private String jljg;     //计量结果
	
	private BigDecimal jdfy;       //检定费用
	
	private String jddw;     //检定单位
	
	private String czgclj;   //操作规程路径
	
	private String czgcsub;  //操作规程随机名
	
	private String smslj;    //说明书路径
	
	private String smssub;   //说明书随机名
	
	private String sbzplj;   //设备照片路径
	
	private String sbzpsub;   //设备照片随机名
	
	private String smsfjjl;   //说明书附件路径
	
	private String smsfjsub;  //说明书附件随机名
	
	private String gnjcjl;   //功能检查路径
	
	private String gnjcsub;  //功能检查随机名
	
	private String qjhcjl;   //期间核查路径
	
	private String qjhcsub;   //期间核查随机名
	
	private String sbfjjl;   //设备其他附件路径
	
	private String sbfjsub;  //设备其他附件随机名
	
	private String jdzs;  //检定证书
	
	private String jdzssub;  //检定证书随机名
	
	private String sybm;    //使用部门
 
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_SB_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "sbbh", nullable = false)
	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	@Column(name = "ewmbh", nullable = true)
	public String getEwmbh() {
		return ewmbh;
	}

	public void setEwmbh(String ewmbh) {
		this.ewmbh = ewmbh;
	}

	@Column(name = "sbmc", nullable = false)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	@Column(name = "sbxh", nullable = true)
	public String getSbxh() {
		return sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	@Column(name = "sbjb", nullable = true)
	public String getSbjb() {
		return sbjb;
	}

	public void setSbjb(String sbjb) {
		this.sbjb = sbjb;
	}

	@Column(name = "syks", nullable = true)
	public String getSyks() {
		return syks;
	}

	public void setSyks(String syks) {
		this.syks = syks;
	}

	@Column(name = "syfw", nullable = true)
	public String getSyfw() {
		return syfw;
	}

	public void setSyfw(String syfw) {
		this.syfw = syfw;
	}

	@Column(name = "sccj", nullable = true)
	public String getSccj() {
		return sccj;
	}

	public void setSccj(String sccj) {
		this.sccj = sccj;
	}

	@Column(name = "ccbh", nullable = true)
	public String getCcbh() {
		return ccbh;
	}

	public void setCcbh(String ccbh) {
		this.ccbh = ccbh;
	}

	@Column(name = "ccrq", nullable = true)
	public java.util.Date getCcrq() {
		return ccrq;
	}

	public void setCcrq(java.util.Date ccrq) {
		this.ccrq = ccrq;
	}

	@Column(name = "gmrq", nullable = true)
	public java.util.Date getGmrq() {
		return gmrq;
	}

	public void setGmrq(java.util.Date gmrq) {
		this.gmrq = gmrq;
	}

	@Column(name = "gmjg", nullable = true)
	public BigDecimal getGmjg() {
		return gmjg;
	}

	public void setGmjg(BigDecimal gmjg) {
		this.gmjg = gmjg;
	}

	@Column(name = "jyzq", nullable = true)
	public Integer getJyzq() {
		return jyzq;
	}

	public void setJyzq(Integer jyzq) {
		this.jyzq = jyzq;
	}

	@Column(name = "scjdrq", nullable = true)
	public java.util.Date getScjdrq() {
		return scjdrq;
	}

	public void setScjdrq(java.util.Date scjdrq) {
		this.scjdrq = scjdrq;
	}

	@Column(name = "xcjdrq", nullable = true)
	public java.util.Date getXcjdrq() {
		return xcjdrq;
	}

	public void setXcjdrq(java.util.Date xcjdrq) {
		this.xcjdrq = xcjdrq;
	}

	@Column(name = "syzt", nullable = true)
	public Integer getSyzt() {
		return syzt;
	}

	public void setSyzt(Integer syzt) {
		this.syzt = syzt;
	}

	@Column(name = "sbwhr", nullable = true)
	public String getSbwhr() {
		return sbwhr;
	}

	public void setSbwhr(String sbwhr) {
		this.sbwhr = sbwhr;
	}

	@Column(name = "tyrq", nullable = true)
	public java.util.Date getTyrq() {
		return tyrq;
	}

	public void setTyrq(java.util.Date tyrq) {
		this.tyrq = tyrq;
	}

	@Column(name = "tyyy", nullable = true)
	public String getTyyy() {
		return tyyy;
	}

	public void setTyyy(String tyyy) {
		this.tyyy = tyyy;
	}

	@Column(name = "bfrq", nullable = true)
	public java.util.Date getBfrq() {
		return bfrq;
	}

	public void setBfrq(java.util.Date bfrq) {
		this.bfrq = bfrq;
	}

	@Column(name = "bfyy", nullable = true)
	public String getBfyy() {
		return bfyy;
	}

	public void setBfyy(String bfyy) {
		this.bfyy = bfyy;
	}

	@Column(name = "bz", nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name = "dw", nullable = true)
	public Integer getDw() {
		return dw;
	}

	public void setDw(Integer dw) {
		this.dw = dw;
	}

	@Column(name = "sbfj", nullable = true)
	public String getSbfj() {
		return sbfj;
	}

	public void setSbfj(String sbfj) {
		this.sbfj = sbfj;
	}

	@Column(name = "ewmtp", nullable = true)
	public String getEwmtp() {
		return ewmtp;
	}

	public void setEwmtp(String ewmtp) {
		this.ewmtp = ewmtp;
	}

	@Column(name = "fzdd", nullable = true)
	public String getFzdd() {
		return fzdd;
	}

	public void setFzdd(String fzdd) {
		this.fzdd = fzdd;
	}

	@Column(name = "qysj", nullable = true)
	public Date getQysj() {
		return qysj;
	}

	public void setQysj(Date qysj) {
		this.qysj = qysj;
	}

	@Column(name = "cjlxr", nullable = true)
	public String getCjlxr() {
		return cjlxr;
	}

	public void setCjlxr(String cjlxr) {
		this.cjlxr = cjlxr;
	}

	@Column(name = "cjdh", nullable = true)
	public String getCjdh() {
		return cjdh;
	}

	public void setCjdh(String cjdh) {
		this.cjdh = cjdh;
	}

	@Column(name = "cjdz", nullable = true)
	public String getCjdz() {
		return cjdz;
	}

	public void setCjdz(String cjdz) {
		this.cjdz = cjdz;
	}

	@Column(name = "clfw", nullable = true)
	public String getClfw() {
		return clfw;
	}

	public void setClfw(String clfw) {
		this.clfw = clfw;
	}

	@Column(name = "pjxx", nullable = true)
	public String getPjxx() {
		return pjxx;
	}

	public void setPjxx(String pjxx) {
		this.pjxx = pjxx;
	}

	@Column(name = "sbczr", nullable = true)
	public String getSbczr() {
		return sbczr;
	}

	public void setSbczr(String sbczr) {
		this.sbczr = sbczr;
	}

	@Column(name = "sfyczgc", nullable = true)
	public Integer getSfyczgc() {
		return sfyczgc;
	}

	public void setSfyczgc(Integer sfyczgc) {
		this.sfyczgc = sfyczgc;
	}

	@Column(name = "sfyqjhc", nullable = true)
	public Integer getSfyqjhc() {
		return sfyqjhc;
	}

	public void setSfyqjhc(Integer sfyqjhc) {
		this.sfyqjhc = sfyqjhc;
	}

	@Column(name = "sfysyjl", nullable = true)
	public Integer getSfysyjl() {
		return sfysyjl;
	}

	public void setSfysyjl(Integer sfysyjl) {
		this.sfysyjl = sfysyjl;
	}

	@Column(name = "sfygnjc", nullable = true)
	public Integer getSfygnjc() {
		return sfygnjc;
	}

	public void setSfygnjc(Integer sfygnjc) {
		this.sfygnjc = sfygnjc;
	}

	@Column(name = "sbzt", nullable = true)
	public Integer getSbzt() {
		return sbzt;
	}

	public void setSbzt(Integer sbzt) {
		this.sbzt = sbzt;
	}

	@Column(name = "czgc", nullable = true)
	public String getCzgc() {
		return czgc;
	}

	public void setCzgc(String czgc) {
		this.czgc = czgc;
	}

	@Column(name = "sysms", nullable = true)
	public String getSysms() {
		return sysms;
	}

	public void setSysms(String sysms) {
		this.sysms = sysms;
	}

	@Column(name = "sbzp", nullable = true)
	public String getSbzp() {
		return sbzp;
	}

	public void setSbzp(String sbzp) {
		this.sbzp = sbzp;
	}

	@Column(name = "sysmffj", nullable = true)
	public String getSysmffj() {
		return sysmffj;
	}

	public void setSysmffj(String sysmffj) {
		this.sysmffj = sysmffj;
	}

	@Column(name = "gnjcff", nullable = true)
	public String getGnjcff() {
		return gnjcff;
	}

	public void setGnjcff(String gnjcff) {
		this.gnjcff = gnjcff;
	}

	@Column(name = "qjhcff", nullable = true)
	public String getQjhcff() {
		return qjhcff;
	}

	public void setQjhcff(String qjhcff) {
		this.qjhcff = qjhcff;
	}

	@Column(name = "bzddj", nullable = true)
	public String getBzddj() {
		return bzddj;
	}

	public void setBzddj(String bzddj) {
		this.bzddj = bzddj;
	}

	@Column(name = "jlqk", nullable = true)
	public String getJlqk() {
		return jlqk;
	}

	public void setJlqk(String jlqk) {
		this.jlqk = jlqk;
	}
	
	@Column(name = "yqzk", nullable = true)
	public Integer getYqzk() {
		return yqzk;
	}

	public void setYqzk(Integer yqzk) {
		this.yqzk = yqzk;
	}

	@Column(name = "jljg", nullable = true)
	public String getJljg() {
		return jljg;
	}

	public void setJljg(String jljg) {
		this.jljg = jljg;
	}

	@Column(name = "jdfy", nullable = true)
	public BigDecimal getJdfy() {
		return jdfy;
	}

	public void setJdfy(BigDecimal jdfy) {
		this.jdfy = jdfy;
	}

	@Column(name = "jddw", nullable = true)
	public String getJddw() {
		return jddw;
	}

	public void setJddw(String jddw) {
		this.jddw = jddw;
	}

	@Column(name = "czgclj", nullable = true)
	public String getCzgclj() {
		return czgclj;
	}

	public void setCzgclj(String czgclj) {
		this.czgclj = czgclj;
	}

	@Column(name = "czgcsub", nullable = true)
	public String getCzgcsub() {
		return czgcsub;
	}

	public void setCzgcsub(String czgcsub) {
		this.czgcsub = czgcsub;
	}

	@Column(name = "smslj", nullable = true)
	public String getSmslj() {
		return smslj;
	}

	public void setSmslj(String smslj) {
		this.smslj = smslj;
	}

	@Column(name = "smssub", nullable = true)
	public String getSmssub() {
		return smssub;
	}

	public void setSmssub(String smssub) {
		this.smssub = smssub;
	}

	@Column(name = "sbzplj", nullable = true)
	public String getSbzplj() {
		return sbzplj;
	}

	public void setSbzplj(String sbzplj) {
		this.sbzplj = sbzplj;
	}

	@Column(name = "sbzpsub", nullable = true)
	public String getSbzpsub() {
		return sbzpsub;
	}

	public void setSbzpsub(String sbzpsub) {
		this.sbzpsub = sbzpsub;
	}

	@Column(name = "smsfjjl", nullable = true)
	public String getSmsfjjl() {
		return smsfjjl;
	}

	public void setSmsfjjl(String smsfjjl) {
		this.smsfjjl = smsfjjl;
	}

	@Column(name = "smsfjsub", nullable = true)
	public String getSmsfjsub() {
		return smsfjsub;
	}

	public void setSmsfjsub(String smsfjsub) {
		this.smsfjsub = smsfjsub;
	}

	@Column(name = "gnjcjl", nullable = true)
	public String getGnjcjl() {
		return gnjcjl;
	}

	public void setGnjcjl(String gnjcjl) {
		this.gnjcjl = gnjcjl;
	}

	@Column(name = "gnjcsub", nullable = true)
	public String getGnjcsub() {
		return gnjcsub;
	}

	public void setGnjcsub(String gnjcsub) {
		this.gnjcsub = gnjcsub;
	}

	@Column(name = "qjhcjl", nullable = true)
	public String getQjhcjl() {
		return qjhcjl;
	}

	public void setQjhcjl(String qjhcjl) {
		this.qjhcjl = qjhcjl;
	}

	@Column(name = "qjhcsub", nullable = true)
	public String getQjhcsub() {
		return qjhcsub;
	}

	public void setQjhcsub(String qjhcsub) {
		this.qjhcsub = qjhcsub;
	}

	@Column(name = "sbfjjl", nullable = true)
	public String getSbfjjl() {
		return sbfjjl;
	}

	public void setSbfjjl(String sbfjjl) {
		this.sbfjjl = sbfjjl;
	}

	@Column(name = "sbfjsub", nullable = true)
	public String getSbfjsub() {
		return sbfjsub;
	}

	public void setSbfjsub(String sbfjsub) {
		this.sbfjsub = sbfjsub;
	}

	@Column(name = "jdzs", nullable = true)
	public String getJdzs() {
		return jdzs;
	}

	public void setJdzs(String jdzs) {
		this.jdzs = jdzs;
	}

	@Column(name = "jdzssub", nullable = true)
	public String getJdzssub() {
		return jdzssub;
	}

	public void setJdzssub(String jdzssub) {
		this.jdzssub = jdzssub;
	}

	@Column(name = "sybm", nullable = true)
	public String getSybm() {
		return sybm;
	}

	public void setSybm(String sybm) {
		this.sybm = sybm;
	}
	
} 
