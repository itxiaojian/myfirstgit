package com.zssi.framework.app.khgl.model;

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
 * 
 * @author liangkaidi
 * @date 2015-9-23
 */

@SuppressWarnings("serial")
@Entity 
@Table(name = "y_kh_khxx")
public class YkhKhxx implements Serializable {
	private Integer id; // ID

	private String khbh; // 客户编号

	private String khmc; // 客户名称

	private String khfl; // 客户分类

	private String dwxz; // 单位性质

	private String khdz; // 详细地址

	private String lxr; // 联络人员

	private String sjhm; // 法人手机

	private String gddh; // 法人电话

	private String cz; // 法人传真

	private String frxm; // 法人姓名

	private Date clsj; // 成立时间

	private String zczj; // 注册资金

	private String jycpmc; // 主导产品

	private Date lrsj; // 录入时间
	
	private Date sr; //生日

	private String bz; // 备注
	
	private String zjlx;//证件类型
	
	private String zjhm;//证件号码
	
	private String ds;  //地市级
	
	private String dwwz;  //单位 网址
	
	private BigDecimal ywje;  //业务金额
	
	private String dzyx;   //法人电子邮箱
	
	private String dzyx1;   //法人电子邮箱
	
	private String frqq;   //法人QQ
	
	private String  sjhm1;   //联络人手机号码
	
	private String gddh1;   //联络人固定电话
	
	private String cz1;   //联络人传真
	
	private String llqq;   //联络人QQ
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-9-24
	 * @return
	 */

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_KH_ID") })
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "khbh", length = 50, nullable = true)
	public String getKhbh() {
		return khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	@Column(name = "khmc", length = 50, nullable = true)
	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	@Column(name = "khfl", length = 50, nullable = true)
	public String getKhfl() {
		return khfl;
	}

	public void setKhfl(String khfl) {
		this.khfl = khfl;
	}

	@Column(name = "dwxz", length = 50, nullable = true)
	public String getDwxz() {
		return dwxz;
	}

	public void setDwxz(String dwxz) {
		this.dwxz = dwxz;
	}

	@Column(name = "khdz", length = 150, nullable = true)
	public String getKhdz() {
		return khdz;
	}

	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}

	@Column(name = "lxr", length = 50, nullable = true)
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	@Column(name = "sjhm", length = 50, nullable = true)
	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	@Column(name = "gddh", length = 50, nullable = true)
	public String getGddh() {
		return gddh;
	}

	public void setGddh(String gddh) {
		this.gddh = gddh;
	}

	@Column(name = "cz", length = 50, nullable = true)
	public String getCz() {
		return cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	@Column(name = "frxm", length = 50, nullable = true)
	public String getFrxm() {
		return frxm;
	}

	public void setFrxm(String frxm) {
		this.frxm = frxm;
	}

	@Column(name = "clsj", length = 6, nullable = true)
	public Date getClsj() {
		return clsj;
	}

	public void setClsj(Date clsj) {
		this.clsj = clsj;
	}

	@Column(name = "zczj", length = 50, nullable = true)
	public String getZczj() {
		return zczj;
	}

	public void setZczj(String zczj) {
		this.zczj = zczj;
	}

	@Column(name = "jycpmc", length = 500, nullable = true)
	public String getJycpmc() {
		return jycpmc;
	}

	public void setJycpmc(String jycpmc) {
		this.jycpmc = jycpmc;
	}

	@Column(name = "lrsj", length = 6, nullable = true)
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name = "sr", length = 6, nullable = true)
	public Date getSr() {
		return sr;
	}

	public void setSr(Date sr) {
		this.sr = sr;
	}

	@Column(name = "zjlx", length = 100, nullable = true)
	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	
	@Column(name = "zjhm", length = 100, nullable = true)
	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	
	@Column(name = "ds", nullable = true)
	public String getDs() {
		return ds;
	}

	public void setDs(String ds) {
		this.ds = ds;
	}

	@Column(name = "dwwz", nullable = true)
	public String getDwwz() {
		return dwwz;
	}

	public void setDwwz(String dwwz) {
		this.dwwz = dwwz;
	}

	@Column(name = "ywje", nullable = true)
	public BigDecimal getYwje() {
		return ywje;
	}

	public void setYwje(BigDecimal ywje) {
		this.ywje = ywje;
	}

	@Column(name = "dzyx", nullable = true)
	public String getDzyx() {
		return dzyx;
	}

	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	
	@Column(name = "dzyx1", nullable = true)
	public String getDzyx1() {
		return dzyx1;
	}

	public void setDzyx1(String dzyx1) {
		this.dzyx1 = dzyx1;
	}

	@Column(name = "frqq", nullable = true)
	public String getFrqq() {
		return frqq;
	}

	public void setFrqq(String frqq) {
		this.frqq = frqq;
	}

	@Column(name = "sjhm1", nullable = true)
	public String getSjhm1() {
		return sjhm1;
	}

	public void setSjhm1(String sjhm1) {
		this.sjhm1 = sjhm1;
	}

	@Column(name = "gddh1", nullable = true)
	public String getGddh1() {
		return gddh1;
	}

	public void setGddh1(String gddh1) {
		this.gddh1 = gddh1;
	}

	@Column(name = "cz1", nullable = true)
	public String getCz1() {
		return cz1;
	}

	public void setCz1(String cz1) {
		this.cz1 = cz1;
	}

	@Column(name = "llqq", nullable = true)
	public String getLlqq() {
		return llqq;
	}

	public void setLlqq(String llqq) {
		this.llqq = llqq;
	}

	@Override
	public String toString() {
		return "YkhKhxx [id=" + id + ", khbh=" + khbh + ", khmc=" + khmc
				+ ", khfl=" + khfl + ", dwxz=" + dwxz + ", khdz=" + khdz
				+ ", lxr=" + lxr + ", sjhm=" + sjhm + ", gddh=" + gddh
				+ ", cz=" + cz + ", frxm=" + frxm + ", clsj=" + clsj
				+ ", zczj=" + zczj + ", jycpmc=" + jycpmc + ", lrsj=" + lrsj
				+ ", sr=" + sr + ", bz=" + bz + ", zjlx=" + zjlx + ", zjhm="
				+ zjhm + "]";
	}


}
