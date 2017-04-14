package com.zssi.framework.app.process.model;

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
 * @author:zhangyi
 * @version 创建时间：2015年10月28日 上午10:53:42 类说明
 */
@Entity
@Table(name = "y_sh_yjb")
public class YshJyb implements Serializable {
	private Integer id;// 主键ID
	private String bgbh;// 报告编号
	private String shjdmc;// 审批阶段名称
	private String shyj;// 审批意见
	private Integer shzt;// 审批状态（1、通过；0、不通过；2、未审核）
	private Date shsj;// 审批时间
	private String shr;// 审批人
	private String bz;// 备注
	private String xgjdry; //下个节点人员


	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "SEQ_CW_ID") })
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "bgbh", length = 200, nullable = true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name = "shjdmc", length = 400, nullable = true)
	public String getShjdmc() {
		return shjdmc;
	}

	public void setShjdmc(String shjdmc) {
		this.shjdmc = shjdmc;
	}

	@Column(name = "shyj", length = 2000, nullable = true)
	public String getShyj() {
		return shyj;
	}

	public void setShyj(String shyj) {
		this.shyj = shyj;
	}

	@Column(name = "shzt", length = 50, nullable = true)
	public Integer getShzt() {
		return shzt;
	}

	public void setShzt(Integer shzt) {
		this.shzt = shzt;
	}

	@Column(name = "shsj", length = 6, nullable = true)
	public Date getShsj() {
		return shsj;
	}

	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}

	@Column(name = "shr", length = 100, nullable = true)
	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	@Column(name = "bz", length = 50, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name = "xgjdry", length = 100, nullable = true)
	public String getXgjdry() {
		return xgjdry;
	}

	public void setXgjdry(String xgjdry) {
		this.xgjdry = xgjdry;
	}

}
