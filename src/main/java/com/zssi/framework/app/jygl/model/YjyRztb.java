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
 * 检验认证图标
 * @author duanpeijun
 * @date 2015年10月14日
 */
@Entity
@Table(name = "y_jy_rztb")
public class YjyRztb implements Serializable{

	/**主键*/
	private Integer id;
	
	/**认证名称*/
	private String rzmc;
	
	/**认证分类*/
	private String rzfl;
	
	/**认证图片附件路径*/
	private String fjlj;
	
	/**备注*/
	private String bz;
	
	/**文件随机名称*/
	private String sub;
	
	
	public YjyRztb() {
    }

    public YjyRztb(Integer id) {
        this.id = id;
    }
    public YjyRztb(Integer id, String rzmc, String rzfl, String fjlj, String bz,String sub) {
       this.id = id;
       this.rzmc = rzmc;
       this.rzfl = rzfl;
       this.fjlj = fjlj;
       this.bz = bz;
       this.sub = sub;
    }

	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_YP_ID")})
	@GeneratedValue(generator = "idGenerator")	
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="rzmc", length=50, nullable=true)
	public String getRzmc() {
		return rzmc;
	}

	public void setRzmc(String rzmc) {
		this.rzmc = rzmc;
	}

	@Column(name="rzfl", length=50, nullable=true)
	public String getRzfl() {
		return rzfl;
	}

	public void setRzfl(String rzfl) {
		this.rzfl = rzfl;
	}

	@Column(name="fjlj", length=50, nullable=true)
	public String getFjlj() {
		return fjlj;
	}

	public void setFjlj(String fjlj) {
		this.fjlj = fjlj;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="sub", length=500, nullable=true)
	 public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}
}
