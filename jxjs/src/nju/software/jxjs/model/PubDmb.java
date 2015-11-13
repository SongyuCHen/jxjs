package nju.software.jxjs.model;

import java.io.Serializable;

public class PubDmb implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String lbbh;
	
	private String dmbh;
	
	private String dmms;
	
	private String xgdm;
	
	private String bz;
	
	
	
	public PubDmb()
	{
	}

	

	public PubDmb(String lbbh, String dmbh, String dmms, String xgdm, String bz) {
		super();
		this.lbbh = lbbh;
		this.dmbh = dmbh;
		this.dmms = dmms;
		this.xgdm = xgdm;
		this.bz = bz;
	}



	public String getLbbh()
	{
		return lbbh;
	}

	public void setLbbh(String lbbh)
	{
		this.lbbh = lbbh;
	}

	public String getDmbh()
	{
		return dmbh;
	}

	public void setDmbh(String dmbh)
	{
		this.dmbh = dmbh;
	}

	public String getDmms()
	{
		return dmms;
	}

	public void setDmms(String dmms)
	{
		this.dmms = dmms;
	}

	public String getXgdm()
	{
		return xgdm;
	}

	public void setXgdm(String xgdm)
	{
		this.xgdm = xgdm;
	}

	public String getBz()
	{
		return bz;
	}

	public void setBz(String bz)
	{
		this.bz = bz;
	}

	
	
	
}
