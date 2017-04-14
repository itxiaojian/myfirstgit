package com.zssi.framework.app.tszf.model;

import java.io.Serializable;

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
 * @date 2015-12-21
 */

@Entity 
@Table(name = "sys_tszf")
public class SysTszf implements Serializable{
	private Integer id; //编号
	
	private String tszf;  //特殊字符
	
	private String bz;  //备注
	
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)用于MySQL数据库
	@GenericGenerator(name = "idGenerator", strategy = "sequence",parameters = {@Parameter(name = "sequence",value="SEQ_SYS_ID")})  // 用于oracle的数据库
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "tszf", length = 200, nullable = true)
	public String getTszf() {
		return tszf;
	}

	public void setTszf(String tszf) {
		this.tszf = tszf;
	}
	@Column(name = "bz", length = 500, nullable = true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	

}
