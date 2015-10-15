package nju.software.jxjs.model;

import java.io.Serializable;

public class PubLaAy implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int ajxh;
	
	private int laaybh;
	
	private String ay;
	
	private String laay;
	
	public PubLaAy()
	{
		
	}

	public int getAjxh()
	{
		return ajxh;
	}

	public void setAjxh(int ajxh)
	{
		this.ajxh = ajxh;
	}

	public int getLaaybh()
	{
		return laaybh;
	}

	public void setLaaybh(int laaybh)
	{
		this.laaybh = laaybh;
	}

	public String getAy()
	{
		return ay;
	}

	public void setAy(String ay)
	{
		this.ay = ay;
	}

	public String getLaay()
	{
		return laay;
	}

	public void setLaay(String laay)
	{
		this.laay = laay;
	}
	
}
