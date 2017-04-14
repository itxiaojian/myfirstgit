package com.zssi.framework.app.jygl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 检验报告附页
 * @author oufeng
 * @date 2016年5月23日
 */
@Entity
@Table(name = "y_jy_bgfy")
public class YjyBgfy {
	//报告Id
	private Integer id;
	
	//报告编号
	private String bgbh;
	
	//检验项目名称
	private String xmmc;
	
	//技术要求
	private String jsyq;
	
	//检验结果
	private String jyjg;
	
	//单项排定
	private String dxpd;
	
	//排序
    private Integer px;

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

	@Column(name="bgbh", length=50, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	@Column(name="xmmc", length=2000, nullable=true)
	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	@Column(name="jsyq", length=1000, nullable=true)
	public String getJsyq() {
		return jsyq;
	}

	public void setJsyq(String jsyq) {
		this.jsyq = jsyq;
	}

	@Column(name="jyjg", length=300, nullable=true)
	public String getJyjg() {
		return jyjg;
	}

	public void setJyjg(String jyjg) {
		this.jyjg = jyjg;
	}

	@Column(name="dxpd", length=50, nullable=true)
	public String getDxpd() {
		return dxpd;
	}

	public void setDxpd(String dxpd) {
		this.dxpd = dxpd;
	}


	@Column(name="px", length=30, nullable=true)
	public Integer getPx() {
		return px;
	}

	public void setPx(Integer px) {
		this.px = px;
	}
}
