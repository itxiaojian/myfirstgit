package com.zssi.framework.app.jygl.model;

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
 * 报告原始记录
 * @author liusong
 * @date 2015年12月19日
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_jy_ysjlgl")
public class YjyYsjl implements Serializable{
	
	private Integer id;
	
	private String bgbh; //报告编号
	
	private Integer ywysjl;  //有无原始记录
	
	private String ysjlwjm; //原始记录文件名
	
	private String ysjlsjm; //原始记录随机名
	
	private String ysjllj;//原始记录路径
	
	private String scry;  //上传人员
	
	private Date scsj;  //上传时间
	
	private String bz;

	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_JY_ID")})
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="bgbh", length=500, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="ywysjl", length=500, nullable=true)
	public Integer getYwysjl() {
		return ywysjl;
	}

	public void setYwysjl(Integer ywysjl) {
		this.ywysjl = ywysjl;
	}

	@Column(name="ysjlwjm", length=500, nullable=true)
	public String getYsjlwjm() {
		return ysjlwjm;
	}

	public void setYsjlwjm(String ysjlwjm) {
		this.ysjlwjm = ysjlwjm;
	}

	@Column(name="ysjlsjm", length=500, nullable=true)
	public String getYsjlsjm() {
		return ysjlsjm;
	}

	public void setYsjlsjm(String ysjlsjm) {
		this.ysjlsjm = ysjlsjm;
	}

	@Column(name="ysjllj", length=500, nullable=true)
	public String getYsjllj() {
		return ysjllj;
	}

	public void setYsjllj(String ysjllj) {
		this.ysjllj = ysjllj;
	}

	@Column(name="scry", length=500, nullable=true)
	public String getScry() {
		return scry;
	}

	public void setScry(String scry) {
		this.scry = scry;
	}

	@Column(name="scsj", length=500, nullable=true)
	public Date getScsj() {
		return scsj;
	}

	public void setScsj(Date scsj) {
		this.scsj = scsj;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}//备注

}
