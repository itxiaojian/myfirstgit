package com.zssi.framework.app.ypgl.model;

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
 * 样品信息
 * @author wangyong
 * @date 2015年9月24日
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "y_yp_ypxx")
public class YypYpxx implements Serializable{

	private Integer id; //id

    private String ypbh;  //样品编号
	
	private String ewmbh;  // 二维码编号
	
	private String ypmc;  //样品名称
	
	private String yplx;  //样品类型
	
	private String jylx;  //检验类型
	
	private Integer  lyfs;  //来样方式
	
	private String szcs; //所在城市
	
	private String ggxh; //规格型号
	
	private String scrqpc; //生产日期/批次
	
	private String ypdj; //样品等级/类型
	
	private String ypzt; //样品状态
	
	private String cydd; //抽样地点
	
	private Date cyrq; //抽样日期
	
	private String cyjs; //抽样基数
	
	private String ypsl; //样品数量
	
	private String wtdw; //委托单位
	
	private String wtdwdz; //委托单位地址
	
	private String sjdw; //受检单位
	
	private String sjdwdz; //受检单位地址
	
	private String lxr; //联系人
	
	private String dh; //电话
	
	private String yb; //邮编
	
	private String scdw; //生产单位
	
	private String scdwdz; //生产单位地址
	
	private String scdwlxr; //生产单位联系人
	
	private String scdwdh; //生产单位电话
	
	private String scdwyb; //生产单位邮编
	
	private String jyxm; //检验项目
	
	private String jyyj; //检验依据
	
	private Integer bgfsfs; //发送方式
	
	private Integer yhxtk; //验后需退库（0，退；1，不退）
	
	private String cyry; //抽样人员
	
	private String jcfyry; //检查封样人员
	
	private String jyks; //检查科室
	
	private String ywks; //业务科室
	
	private String jyhth; //检验合同号
	
	private String ewmtp; //二维码图片
	
	private BigDecimal jyfy; //检验费用
	
	private Integer jyfydd; //检验费用待定（0：待定；1：不待定）
	
	private String bz; //备注
	
	private String bgbh;  //报告编号
	
	private String jyksbh;  //检验科室编号
	
	private String ywksbh;  //业务科室编号
	
    private Integer ypjyzt;  //样品检测状态（1：待检；2：检验中；3：检验完；4：编制中；5：已发放）
	
	private String djry;  //样品登记人员
	
	private Date djsj;  //样品登记时间
	
	private String fj;  //样品附件

	private Date dyrq;  //到样日期
	
	private String lysl; //领用数量
	
	private Integer djlx; //登记类型
	
	private String zh;  //字号
	
	private String ssbh;  //所属编号
	
	private String sb;    //商标
	
	private Date wcqx;    //完成期限
	
	private String xgr;   //修改人
	
	private Date xgsj;    //修改时间
	
	private String sgdw;   //施工单位
	
	private String gcsjdw;   //工程设计单位
	
	private String jsdw;   //建设单位
	
	private String jldw;   //监理单位
	
	private String jlr;    //监理人
	
	private String jzdw;   //见证单位
	
	private Date lyrq;     //领样日期
	
	private String jzr;    //见证人
	
	private String slr;    //见证人
	
	private String gcmc;   //工程名称
	
	private String gcdz;   //工程地址
	
	private String cpmc;   //产品名称
	
	private String gclxdh;   //工程联系电话
	
	private String gclxr;   //工程联系人
	
	private String lyr;     //领用人
	
	private String wtlxr; //委托单位联系人
	
	private String sjhm;    //手机号码
	
	private String wtyb;    //委托单位邮编
	
	private String cydw;    //抽样单位
	
	private String rwly;    //任务来源
	
	private String cydbh;   //抽样单编号
	
	private Integer ypyj;   //是否移交（0：否；1：是）
	
	private String sjdwfrdb; //受检单位法人代表
	
	private String sjdwgddh; //受检单位固定电话
	
	private String jjlx;     //经济类型	
	
	private String scdwfrdb; //受检单位法人代表
	
	private String yyzz;     //营业执照
	
	private String jgdm;     //机构代码
	
	private String rs;       //人数
	
	private String cz;       //产值
	
	private String cl;       //产量
	
	private Integer zslx;    //证书类型（1：工业产品生产许可证；2：QS；3：CCC；4：其他）
	
	private String zsbh;     //证书编号
	
	private String byljfcdd; //备样量及封存地点
	
	private String jsydd;    //寄送样地点
	
	private Integer sfwckcp; //是否为出口产品（1：是；2：否）
	
	private Date jsyjzrq;    //寄送样截止日期
	
	private String cydwdz;   //抽样单位地址
	
	private String cydwlxdh; //抽样单位联系电话
	
	private String cydwyzbm; //抽样单位邮政编码
	
	private String czemail;  //传真/Email
	
	private String cysl;     //抽样数量
	
	private String wtdwgddh; //委托单位固定电话
	
	private String scdwgddh; //生产单位固定电话
	
	private Integer yjzt;    //移交状态（0：未移交；1：已移交）



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

	@Column(name="ypbh", length=50, nullable=true)
	public String getYpbh() {
		return ypbh;
	}

	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}

	@Column(name="ewmbh", length=4000, nullable=true)
	public String getEwmbh() {
		return ewmbh;
	}

	public void setEwmbh(String ewmbh) {
		this.ewmbh = ewmbh;
	}

	@Column(name="ypmc", length=200, nullable=true)
	public String getYpmc() {
		return ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	@Column(name="yplx", length=50, nullable=true)
	public String getYplx() {
		return yplx;
	}

	public void setYplx(String yplx) {
		this.yplx = yplx;
	}

	@Column(name="jylx", length=50, nullable=true)
	public String getJylx() {
		return jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	@Column(name="lyfs", length=50, nullable=true)
	public Integer getLyfs() {
		return lyfs;
	}

	public void setLyfs(Integer lyfs) {
		this.lyfs = lyfs;
	}

	@Column(name="szcs", length=500, nullable=true)
	public String getSzcs() {
		return szcs;
	}

	public void setSzcs(String szcs) {
		this.szcs = szcs;
	}

	@Column(name="ggxh", length=100, nullable=true)
	public String getGgxh() {
		return ggxh;
	}

	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}

	@Column(name="scrqpc", length=200, nullable=true)
	public String getScrqpc() {
		return scrqpc;
	}

	public void setScrqpc(String scrqpc) {
		this.scrqpc = scrqpc;
	}

	@Column(name="ypdj", length=200, nullable=true)
	public String getYpdj() {
		return ypdj;
	}

	public void setYpdj(String ypdj) {
		this.ypdj = ypdj;
	}

	@Column(name="ypzt", length=100, nullable=true)
	public String getYpzt() {
		return ypzt;
	}

	public void setYpzt(String ypzt) {
		this.ypzt = ypzt;
	}

	@Column(name="cydd", length=150, nullable=true)
	public String getCydd() {
		return cydd;
	}

	public void setCydd(String cydd) {
		this.cydd = cydd;
	}

	@Column(name="cyrq", length=50, nullable=true)
	public Date getCyrq() {
		return cyrq;
	}

	public void setCyrq(Date cyrq) {
		this.cyrq = cyrq;
	}

	@Column(name="ypsl", length=50, nullable=true)
	public String getYpsl() {
		return ypsl;
	}
	
	public void setYpsl(String ypsl) {
		this.ypsl = ypsl;
	}

	@Column(name="cyjs", length=50, nullable=true)
	public String getCyjs() {
		return cyjs;
	}

	public void setCyjs(String cyjs) {
		this.cyjs = cyjs;
	}

	@Column(name="wtdw", length=150, nullable=true)
	public String getWtdw() {
		return wtdw;
	}

	public void setWtdw(String wtdw) {
		this.wtdw = wtdw;
	}

	@Column(name="wtdwdz", length=200, nullable=true)
	public String getWtdwdz() {
		return wtdwdz;
	}

	public void setWtdwdz(String wtdwdz) {
		this.wtdwdz = wtdwdz;
	}

	@Column(name="sjdw", length=150, nullable=true)
	public String getSjdw() {
		return sjdw;
	}

	public void setSjdw(String sjdw) {
		this.sjdw = sjdw;
	}

	@Column(name="sjdwdz", length=200, nullable=true)
	public String getSjdwdz() {
		return sjdwdz;
	}

	public void setSjdwdz(String sjdwdz) {
		this.sjdwdz = sjdwdz;
	}

	@Column(name="lxr", length=50, nullable=true)
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	@Column(name="dh", length=50, nullable=true)
	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name="yb", length=50, nullable=true)
	public String getYb() {
		return yb;
	}

	public void setYb(String yb) {
		this.yb = yb;
	}

	@Column(name="scdw", length=150, nullable=true)
	public String getScdw() {
		return scdw;
	}

	public void setScdw(String scdw) {
		this.scdw = scdw;
	}

	@Column(name="scdwdz", length=200, nullable=true)
	public String getScdwdz() {
		return scdwdz;
	}

	public void setScdwdz(String scdwdz) {
		this.scdwdz = scdwdz;
	}

	@Column(name="scdwlxr", length=50, nullable=true)
	public String getScdwlxr() {
		return scdwlxr;
	}

	public void setScdwlxr(String scdwlxr) {
		this.scdwlxr = scdwlxr;
	}

	@Column(name="scdwdh", length=50, nullable=true)
	public String getScdwdh() {
		return scdwdh;
	}

	public void setScdwdh(String scdwdh) {
		this.scdwdh = scdwdh;
	}

	@Column(name="scdwyb", length=50, nullable=true)
	public String getScdwyb() {
		return scdwyb;
	}

	public void setScdwyb(String scdwyb) {
		this.scdwyb = scdwyb;
	}

	@Column(name="jyxm", length=2000, nullable=true)
	public String getJyxm() {
		return jyxm;
	}

	public void setJyxm(String jyxm) {
		this.jyxm = jyxm;
	}

	@Column(name="jyyj", length=2000, nullable=true)
	public String getJyyj() {
		return jyyj;
	}

	public void setJyyj(String jyyj) {
		this.jyyj = jyyj;
	}

	@Column(name="ypjyzt", length=50, nullable=true)
	public Integer getYpjyzt() {
		return ypjyzt;
	}

	public void setYpjyzt(Integer ypjyzt) {
		this.ypjyzt = ypjyzt;
	}

	@Column(name="djry", length=100, nullable=true)
	public String getDjry() {
		return djry;
	}

	public void setDjry(String djry) {
		this.djry = djry;
	}

	@Column(name="djsj", length=100, nullable=true)
	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}
	
	@Column(name="fj", length=100, nullable=true)
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}

	@Column(name="dyrq", length=100, nullable=true)
	public Date getDyrq() {
		return dyrq;
	}

	public void setDyrq(Date dyrq) {
		this.dyrq = dyrq;
	}

	@Column(name="bgfsfs", length=50, nullable=true)
	public Integer getBgfsfs() {
		return bgfsfs;
	}

	public void setBgfsfs(Integer bgfsfs) {
		this.bgfsfs = bgfsfs;
	}

	@Column(name="yhxtk", length=50, nullable=true)
	public Integer getYhxtk() {
		return yhxtk;
	}

	public void setYhxtk(Integer yhxtk) {
		this.yhxtk = yhxtk;
	}

	@Column(name="cyry", length=50, nullable=true)
	public String getCyry() {
		return cyry;
	}

	public void setCyry(String cyry) {
		this.cyry = cyry;
	}

	@Column(name="jcfyry", length=50, nullable=true)
	public String getJcfyry() {
		return jcfyry;
	}

	public void setJcfyry(String jcfyry) {
		this.jcfyry = jcfyry;
	}

	@Column(name="jyks", length=100, nullable=true)
	public String getJyks() {
		return jyks;
	}

	public void setJyks(String jyks) {
		this.jyks = jyks;
	}

	@Column(name="ywks", length=100, nullable=true)
	public String getYwks() {
		return ywks;
	}

	public void setYwks(String ywks) {
		this.ywks = ywks;
	}

	@Column(name="jyhth", length=100, nullable=true)
	public String getJyhth() {
		return jyhth;
	}

	public void setJyhth(String jyhth) {
		this.jyhth = jyhth;
	}

	@Column(name="ewmtp", length=4000, nullable=true)
	public String getEwmtp() {
		return ewmtp;
	}

	public void setEwmtp(String ewmtp) {
		this.ewmtp = ewmtp;
	}

	@Column(name="jyfy", length=500, nullable=true)
	public BigDecimal getJyfy() {
		return jyfy;
	}

	public void setJyfy(BigDecimal jyfy) {
		this.jyfy = jyfy;
	}

	@Column(name="jyfydd", length=50, nullable=true)
	public Integer getJyfydd() {
		return jyfydd;
	}

	public void setJyfydd(Integer jyfydd) {
		this.jyfydd = jyfydd;
	}

	@Column(name="bz", length=500, nullable=true)
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Column(name="bgbh", length=50, nullable=true)
	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}
	
	@Column(name="jyksbh", length=50, nullable=true)
	public String getJyksbh() {
		return jyksbh;
	}

	public void setJyksbh(String jyksbh) {
		this.jyksbh = jyksbh;
	}

	@Column(name="ywksbh", length=50, nullable=true)
	public String getYwksbh() {
		return ywksbh;
	}

	public void setYwksbh(String ywksbh) {
		this.ywksbh = ywksbh;
	}
	
	@Column(name="lysl", length=50, nullable=true)
	public String getLysl() {
		return lysl;
	}

	public void setLysl(String lysl) {
		this.lysl = lysl;
	}
	
	@Column(name="djlx", length=50, nullable=true)
	public Integer getDjlx() {
		return djlx;
	}

	public void setDjlx(Integer djlx) {
		this.djlx = djlx;
	}
	
	@Column(name="zh", length=50, nullable=true)
	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	@Column(name="ssbh", length=500, nullable=true)
	public String getSsbh() {
		return ssbh;
	}

	public void setSsbh(String ssbh) {
		this.ssbh = ssbh;
	}

	@Column(name="sb", length=200, nullable=true)
	public String getSb() {
		return sb;
	}

	public void setSb(String sb) {
		this.sb = sb;
	}

	@Column(name="wcqx", length=200, nullable=true)
	public Date getWcqx() {
		return wcqx;
	}

	public void setWcqx(Date wcqx) {
		this.wcqx = wcqx;
	}
	
	@Column(name="xgr", length=100, nullable=true)
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

	@Column(name="sgdw", length=500, nullable=true)
	public String getSgdw() {
		return sgdw;
	}

	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}

	@Column(name="gcsjdw", length=500, nullable=true)
	public String getGcsjdw() {
		return gcsjdw;
	}

	public void setGcsjdw(String gcsjdw) {
		this.gcsjdw = gcsjdw;
	}

	@Column(name="jsdw", length=500, nullable=true)
	public String getJsdw() {
		return jsdw;
	}

	public void setJsdw(String jsdw) {
		this.jsdw = jsdw;
	}

	@Column(name="jldw", length=500, nullable=true)
	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	@Column(name="jzdw", length=500, nullable=true)
	public String getJzdw() {
		return jzdw;
	}

	public void setJzdw(String jzdw) {
		this.jzdw = jzdw;
	}

	@Column(name="lyrq", length=500, nullable=true)
	public Date getLyrq() {
		return lyrq;
	}

	public void setLyrq(Date lyrq) {
		this.lyrq = lyrq;
	}

	@Column(name="jzr", length=200, nullable=true)
	public String getJzr() {
		return jzr;
	}

	public void setJzr(String jzr) {
		this.jzr = jzr;
	}

	@Column(name="slr", length=100, nullable=true)
	public String getSlr() {
		return slr;
	}

	public void setSlr(String slr) {
		this.slr = slr;
	}

	@Column(name="gcmc", length=500, nullable=true)
	public String getGcmc() {
		return gcmc;
	}

	public void setGcmc(String gcmc) {
		this.gcmc = gcmc;
	}

	@Column(name="gcdz", length=2000, nullable=true)
	public String getGcdz() {
		return gcdz;
	}

	public void setGcdz(String gcdz) {
		this.gcdz = gcdz;
	}
	
	@Column(name="jlr", length=200, nullable=true)
	public String getJlr() {
		return jlr;
	}

	public void setJlr(String jlr) {
		this.jlr = jlr;
	}

	@Column(name="cpmc", length=200, nullable=true)
	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}
	
	@Column(name="gclxdh", length=200, nullable=true)
	public String getGclxdh() {
		return gclxdh;
	}

	public void setGclxdh(String gclxdh) {
		this.gclxdh = gclxdh;
	}
	
	@Column(name="gclxr", length=200, nullable=true)
	public String getGclxr() {
		return gclxr;
	}

	public void setGclxr(String gclxr) {
		this.gclxr = gclxr;
	}


	@Column(name="lyr", length=50, nullable=true)
	public String getLyr() {
		return lyr;
	}

	public void setLyr(String lyr) {
		this.lyr = lyr;
	}
	
	@Column(name="wtlxr", length=50, nullable=true)
	public String getWtlxr() {
		return wtlxr;
	}

	public void setWtlxr(String wtlxr) {
		this.wtlxr = wtlxr;
	}

	@Column(name="sjhm", length=22, nullable=true)
	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	@Column(name="wtyb", length=50, nullable=true)
	public String getWtyb() {
		return wtyb;
	}

	public void setWtyb(String wtyb) {
		this.wtyb = wtyb;
	}
	
	@Column(name="cydw", length=100, nullable=true)
	public String getCydw() {
		return cydw;
	}

	public void setCydw(String cydw) {
		this.cydw = cydw;
	}
	
	@Column(name="rwly", length=100, nullable=true)
	public String getRwly() {
		return rwly;
	}

	public void setRwly(String rwly) {
		this.rwly = rwly;
	}
	
	@Column(name="cydbh", length=100, nullable=true)
	public String getCydbh() {
		return cydbh;
	}

	public void setCydbh(String cydbh) {
		this.cydbh = cydbh;
	}

	@Column(name="ypyj", length=100, nullable=true)
	public Integer getYpyj() {
		return ypyj;
	}

	public void setYpyj(Integer ypyj) {
		this.ypyj = ypyj;
	}
	
	@Column(name="sjdwfrdb", length=100, nullable=true)
	public String getSjdwfrdb() {
		return sjdwfrdb;
	}

	public void setSjdwfrdb(String sjdwfrdb) {
		this.sjdwfrdb = sjdwfrdb;
	}

	@Column(name="sjdwgddh", length=100, nullable=true)
	public String getSjdwgddh() {
		return sjdwgddh;
	}

	public void setSjdwgddh(String sjdwgddh) {
		this.sjdwgddh = sjdwgddh;
	}

	@Column(name="jjlx", length=100, nullable=true)
	public String getJjlx() {
		return jjlx;
	}

	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}

	@Column(name="scdwfrdb", length=100, nullable=true)
	public String getScdwfrdb() {
		return scdwfrdb;
	}

	public void setScdwfrdb(String scdwfrdb) {
		this.scdwfrdb = scdwfrdb;
	}

	@Column(name="yyzz", length=100, nullable=true)
	public String getYyzz() {
		return yyzz;
	}

	public void setYyzz(String yyzz) {
		this.yyzz = yyzz;
	}

	@Column(name="jgdm", length=100, nullable=true)
	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	@Column(name="rs", length=100, nullable=true)
	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	@Column(name="cz", length=100, nullable=true)
	public String getCz() {
		return cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	@Column(name="cl", length=100, nullable=true)
	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	@Column(name="zslx", length=100, nullable=true)
	public Integer getZslx() {
		return zslx;
	}

	public void setZslx(Integer zslx) {
		this.zslx = zslx;
	}

	@Column(name="zsbh", length=100, nullable=true)
	public String getZsbh() {
		return zsbh;
	}

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	@Column(name="byljfcdd", length=300, nullable=true)
	public String getByljfcdd() {
		return byljfcdd;
	}

	public void setByljfcdd(String byljfcdd) {
		this.byljfcdd = byljfcdd;
	}

	@Column(name="jsydd", length=300, nullable=true)
	public String getJsydd() {
		return jsydd;
	}

	public void setJsydd(String jsydd) {
		this.jsydd = jsydd;
	}

	@Column(name="sfwckcp", length=100, nullable=true)
	public Integer getSfwckcp() {
		return sfwckcp;
	}

	public void setSfwckcp(Integer sfwckcp) {
		this.sfwckcp = sfwckcp;
	}

	@Column(name="jsyjzrq", length=100, nullable=true)
	public Date getJsyjzrq() {
		return jsyjzrq;
	}

	public void setJsyjzrq(Date jsyjzrq) {
		this.jsyjzrq = jsyjzrq;
	}

	@Column(name="cydwdz", length=300, nullable=true)
	public String getCydwdz() {
		return cydwdz;
	}

	public void setCydwdz(String cydwdz) {
		this.cydwdz = cydwdz;
	}

	@Column(name="cydwlxdh", length=100, nullable=true)
	public String getCydwlxdh() {
		return cydwlxdh;
	}

	public void setCydwlxdh(String cydwlxdh) {
		this.cydwlxdh = cydwlxdh;
	}

	@Column(name="cydwyzbm", length=100, nullable=true)
	public String getCydwyzbm() {
		return cydwyzbm;
	}

	public void setCydwyzbm(String cydwyzbm) {
		this.cydwyzbm = cydwyzbm;
	}

	@Column(name="czemail", length=100, nullable=true)
	public String getCzemail() {
		return czemail;
	}

	public void setCzemail(String czemail) {
		this.czemail = czemail;
	}

	@Column(name="cysl", length=100, nullable=true)
	public String getCysl() {
		return cysl;
	}

	public void setCysl(String cysl) {
		this.cysl = cysl;
	}

	@Column(name="wtdwgddh", length=100, nullable=true)
	public String getWtdwgddh() {
		return wtdwgddh;
	}

	public void setWtdwgddh(String wtdwgddh) {
		this.wtdwgddh = wtdwgddh;
	}

	@Column(name="scdwgddh", length=100, nullable=true)
	public String getScdwgddh() {
		return scdwgddh;
	}

	public void setScdwgddh(String scdwgddh) {
		this.scdwgddh = scdwgddh;
	}

	@Column(name="yjzt", length=100, nullable=true)
	public Integer getYjzt() {
		return yjzt;
	}

	public void setYjzt(Integer yjzt) {
		this.yjzt = yjzt;
	}
}
