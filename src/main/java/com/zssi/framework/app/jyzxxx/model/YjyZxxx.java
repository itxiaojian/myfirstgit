package com.zssi.framework.app.jyzxxx.model;

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
 * 检验咨询信息实体类
 * @author wangyong
 * @date 2016-6-1
 */

@SuppressWarnings("serial")
@Entity 
@Table(name = "y_jy_zxxx")
public class YjyZxxx implements Serializable {
	private Integer id; // ID

	private String cpmc; // 产品名称

	private String jyyj; // 检验依据

	private String jyxmbh; // 检验项目编号

	private String jcxm; // 检测项目名称

	private String dybztkh; // 对应标准条款号

	private String ggxh; // 规格型号

	private String ypsl; // 样品数量

	private String jcfy; // 检测费用
	
	private String jyzq; //检验周期

	private Integer yzz; // 院CNAS（是否需要：0、是；1、否）

	private Integer gpzz; // 国排中心CMA/CAL（是否需要：0、是；1、否）

	private Integer gjzz; // 国建中心CMA/CAL（是否需要：0、是；1、否）

	private Integer yspzz; // 院食品省级资质认定（是否需要：0、是；1、否）

	private String hjyq; // 环境要求

	private String sbbh; // 设备编号
	
	private String sbmc; // 设备名称

	private String ry; // 人员（是对应设备，为设备操作人员）
	
	private String bz;// 备注
	
	private String bz1;// 备注1
	
	private Integer yzzrd;//院资质认定（是否需要：0、是；1、否）
	
	private String cplx;// 产品类型
	
	private String cpbh;//产品编号
	
	private String ksbh;//产品编号
	
	private String xgr;  //修改人
	
	private Date xgsj; //修改时间
	
	private String jldw; // 计量单位
	
	
	/**
	 * 
	 * @author wangyong
     * @date 2016-6-1
	 * @return
	 */

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_JY_ID") })
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cpmc", length = 400, nullable = true)
	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	@Column(name = "jyyj", length = 1000, nullable = true)
	public String getJyyj() {
		return jyyj;
	}

	public void setJyyj(String jyyj) {
		this.jyyj = jyyj;
	}

	@Column(name = "jyxmbh", length = 200, nullable = true)
	public String getJyxmbh() {
		return jyxmbh;
	}

	public void setJyxmbh(String jyxmbh) {
		this.jyxmbh = jyxmbh;
	}

	@Column(name = "jcxm", length = 500, nullable = true)
	public String getJcxm() {
		return jcxm;
	}

	public void setJcxm(String jcxm) {
		this.jcxm = jcxm;
	}

	@Column(name = "dybztkh", length = 500, nullable = true)
	public String getDybztkh() {
		return dybztkh;
	}

	public void setDybztkh(String dybztkh) {
		this.dybztkh = dybztkh;
	}

	@Column(name = "ggxh", length = 500, nullable = true)
	public String getGgxh() {
		return ggxh;
	}

	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}

	@Column(name = "ypsl", length = 200, nullable = true)
	public String getYpsl() {
		return ypsl;
	}

	public void setYpsl(String ypsl) {
		this.ypsl = ypsl;
	}

	@Column(name = "jcfy", length = 200, nullable = true)
	public String getJcfy() {
		return jcfy;
	}

	public void setJcfy(String jcfy) {
		this.jcfy = jcfy;
	}

	@Column(name = "jyzq", length = 200, nullable = true)
	public String getJyzq() {
		return jyzq;
	}

	public void setJyzq(String jyzq) {
		this.jyzq = jyzq;
	}

	@Column(name = "yzz", length = 200, nullable = true)
	public Integer getYzz() {
		return yzz;
	}

	public void setYzz(Integer yzz) {
		this.yzz = yzz;
	}

	@Column(name = "gpzz", length = 200, nullable = true)
	public Integer getGpzz() {
		return gpzz;
	}

	public void setGpzz(Integer gpzz) {
		this.gpzz = gpzz;
	}

	@Column(name = "gjzz", length = 200, nullable = true)
	public Integer getGjzz() {
		return gjzz;
	}

	public void setGjzz(Integer gjzz) {
		this.gjzz = gjzz;
	}

	@Column(name = "yspzz", length = 200, nullable = true)
	public Integer getYspzz() {
		return yspzz;
	}

	public void setYspzz(Integer yspzz) {
		this.yspzz = yspzz;
	}

	@Column(name = "hjyq", length = 3000, nullable = true)
	public String getHjyq() {
		return hjyq;
	}

	public void setHjyq(String hjyq) {
		this.hjyq = hjyq;
	}

	@Column(name = "sbbh", length = 200, nullable = true)
	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}

	@Column(name = "sbmc", length = 2000, nullable = true)
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	@Column(name = "ry", length = 200, nullable = true)
	public String getRy() {
		return ry;
	}

	public void setRy(String ry) {
		this.ry = ry;
	}

	@Column(name = "bz", length = 3000, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "bz1", length = 2000, nullable = true)
	public String getBz1() {
		return bz1;
	}

	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}

	@Column(name = "yzzrd", length = 200, nullable = true)
	public Integer getYzzrd() {
		return yzzrd;
	}

	public void setYzzrd(Integer yzzrd) {
		this.yzzrd = yzzrd;
	}
	
	@Column(name = "cplx", length = 200, nullable = true)
	public String getCplx() {
		return cplx;
	}

	public void setCplx(String cplx) {
		this.cplx = cplx;
	}

	@Column(name = "cpbh", length = 200, nullable = true)
	public String getCpbh() {
		return cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	@Column(name = "ksbh", length = 200, nullable = true)
	public String getKsbh() {
		return ksbh;
	}

	public void setKsbh(String ksbh) {
		this.ksbh = ksbh;
	}
	
	@Column(name = "xgr", length = 200, nullable = true)
	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}
	
	@Column(name="xgsj", length=100, nullable=true)
	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}
	
	@Column(name = "jldw", length = 100, nullable = true)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}
}
