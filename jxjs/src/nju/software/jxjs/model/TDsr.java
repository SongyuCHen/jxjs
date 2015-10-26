package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class TDsr implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int dsrbh;
	private int jxjsbh;
	//姓名
	private String xm;
	//性别 GB2261-80
	private String xb;
	//出生年月日
	private Date csnyr;
	//民族 FBZ0002-97
	private String mz;
	//文化程度 GB4658-84
	private String whcd;
	//所属国家 GB2659-86
	private String ssgj;
	//职业 FBZ0128-97	
	private String jb;
	//政治面貌 GB4762-84
	private String zzmm;
	//身份 FBZ0130-97	
	private String sf;
	//邮编
	private String yb;
	//电话
	private String dh;
	//籍贯 GB2260-91
	private String jg;
	//职务 GB12403-90
	private String zw;
	//工作单位
	private String gzdw;
	//地址
	private String dz;
	//身份证号码
	private String sfzhm;
	
	
	public TDsr()
	{
	}


	public int getDsrbh() {
		return dsrbh;
	}


	public void setDsrbh(int dsrbh) {
		this.dsrbh = dsrbh;
	}


	public int getJxjsbh() {
		return jxjsbh;
	}


	public void setJxjsbh(int jxjsbh) {
		this.jxjsbh = jxjsbh;
	}


	public String getXm() {
		return xm;
	}


	public void setXm(String xm) {
		this.xm = xm;
	}


	public String getXb() {
		return xb;
	}


	public void setXb(String xb) {
		this.xb = xb;
	}


	public Date getCsnyr() {
		return csnyr;
	}


	public void setCsnyr(Date csnyr) {
		this.csnyr = csnyr;
	}


	public String getMz() {
		return mz;
	}


	public void setMz(String mz) {
		this.mz = mz;
	}


	public String getWhcd() {
		return whcd;
	}


	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}


	public String getSsgj() {
		return ssgj;
	}


	public void setSsgj(String ssgj) {
		this.ssgj = ssgj;
	}


	public String getJb() {
		return jb;
	}


	public void setJb(String jb) {
		this.jb = jb;
	}


	public String getZzmm() {
		return zzmm;
	}


	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}


	public String getSf() {
		return sf;
	}


	public void setSf(String sf) {
		this.sf = sf;
	}


	public String getYb() {
		return yb;
	}


	public void setYb(String yb) {
		this.yb = yb;
	}


	public String getDh() {
		return dh;
	}


	public void setDh(String dh) {
		this.dh = dh;
	}


	public String getJg() {
		return jg;
	}


	public void setJg(String jg) {
		this.jg = jg;
	}


	public String getZw() {
		return zw;
	}


	public void setZw(String zw) {
		this.zw = zw;
	}


	public String getGzdw() {
		return gzdw;
	}


	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}


	public String getDz() {
		return dz;
	}


	public void setDz(String dz) {
		this.dz = dz;
	}


	public String getSfzhm() {
		return sfzhm;
	}


	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}

	
	
	
}
