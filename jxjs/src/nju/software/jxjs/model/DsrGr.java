package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class DsrGr implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer ajxh;
	private Integer dsrbh;
	//姓名
	private String xm;
	//性别 GB2261-80
	private String xb;
	//出生年月日
	private Date csnyr;
	//民族 FBZ0002-97
	private String mz;
	//籍贯 GB2260-91
	private String jg;
	//职业 FBZ0128-97	
	private String zy;
	//职务 GB12403-90
	private String zw;
	//文化程度 GB4658-84
	private String whcd;
	//工作单位
	private String gzdw;
	//政治面貌 GB4762-84	
	private String zzmm;
	//职务级别 FBZ0129-97
	private String jb;
	//身份 FBZ0130-97	
	private String sf;
	//婚姻情况 GB4766-84	
	private String hyqk;
	//家庭情况
	private String jtqk;
	//健康情况 GB4767-84
	private String jkqk;
	//所属国家 GB2659-86
	private String ssgj;
	//身份证号码
	private String sfzhm;
	//邮编
	private String yb;
	//电话
	private String dh;
	//地址
	private String dz;
	
	
	
	public DsrGr()
	{
	}

	public DsrGr(Integer ajxh, Integer dsrbh, String xm, String xb,
			Date csnyr, String mz, String jg, String zy, String zw,
			String whcd, String gzdw, String zzmm, String jb, String sf,
			String hyqk, String jtqk, String jkqk, String ssgj, String sfzhm,
			String yb, String dh, String dz)
	{

		this.ajxh = ajxh;
		this.dsrbh = dsrbh;
		this.xm = xm;
		this.xb = xb;
		this.csnyr = csnyr;
		this.mz = mz;
		this.jg = jg;
		this.zy = zy;
		this.zw = zw;
		this.whcd = whcd;
		this.gzdw = gzdw;
		this.zzmm = zzmm;
		this.jb = jb;
		this.sf = sf;
		this.hyqk = hyqk;
		this.jtqk = jtqk;
		this.jkqk = jkqk;
		this.ssgj = ssgj;
		this.sfzhm = sfzhm;
		this.yb = yb;
		this.dh = dh;
		this.dz = dz;

	}

	public Integer getAjxh()
	{
		return ajxh;
	}

	public void setAjxh(Integer ajxh)
	{
		this.ajxh = ajxh;
	}

	public Integer getDsrbh()
	{
		return dsrbh;
	}

	public void setDsrbh(Integer dsrbh)
	{
		this.dsrbh = dsrbh;
	}

	public String getXm()
	{
		return xm;
	}

	public void setXm(String xm)
	{
		this.xm = xm;
	}

	public String getXb()
	{
		return xb;
	}

	public void setXb(String xb)
	{
		this.xb = xb;
	}

	public Date getCsnyr()
	{
		return csnyr;
	}

	public void setCsnyr(Date csnyr)
	{
		this.csnyr = csnyr;
	}

	public String getMz()
	{
		return mz;
	}

	public void setMz(String mz)
	{
		this.mz = mz;
	}

	public String getJg()
	{
		return jg;
	}

	public void setJg(String jg)
	{
		this.jg = jg;
	}

	public String getZy()
	{
		return zy;
	}

	public void setZy(String zy)
	{
		this.zy = zy;
	}

	public String getZw()
	{
		return zw;
	}

	public void setZw(String zw)
	{
		this.zw = zw;
	}

	public String getWhcd()
	{
		return whcd;
	}

	public void setWhcd(String whcd)
	{
		this.whcd = whcd;
	}

	public String getGzdw()
	{
		return gzdw;
	}

	public void setGzdw(String gzdw)
	{
		this.gzdw = gzdw;
	}

	public String getZzmm()
	{
		return zzmm;
	}

	public void setZzmm(String zzmm)
	{
		this.zzmm = zzmm;
	}

	public String getJb()
	{
		return jb;
	}

	public void setJb(String jb)
	{
		this.jb = jb;
	}

	public String getSf()
	{
		return sf;
	}

	public void setSf(String sf)
	{
		this.sf = sf;
	}

	public String getHyqk()
	{
		return hyqk;
	}

	public void setHyqk(String hyqk)
	{
		this.hyqk = hyqk;
	}

	public String getJtqk()
	{
		return jtqk;
	}

	public void setJtqk(String jtqk)
	{
		this.jtqk = jtqk;
	}

	public String getJkqk()
	{
		return jkqk;
	}

	public void setJkqk(String jkqk)
	{
		this.jkqk = jkqk;
	}

	public String getSsgj()
	{
		return ssgj;
	}

	public void setSsgj(String ssgj)
	{
		this.ssgj = ssgj;
	}

	public String getSfzhm()
	{
		return sfzhm;
	}

	public void setSfzhm(String sfzhm)
	{
		this.sfzhm = sfzhm;
	}

	public String getYb()
	{
		return yb;
	}

	public void setYb(String yb)
	{
		this.yb = yb;
	}

	public String getDh()
	{
		return dh;
	}

	public void setDh(String dh)
	{
		this.dh = dh;
	}

	public String getDz()
	{
		return dz;
	}

	public void setDz(String dz)
	{
		this.dz = dz;
	}


}
