package nju.software.jxjs.model;

import java.io.Serializable;

public class PubLaAy implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int ajxh;
	//立案案由编号 
	private int laaybh;
	//统计案由 FBS0022-97
	private String ay;
	//立案案由
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
