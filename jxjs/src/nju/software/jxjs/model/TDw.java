package nju.software.jxjs.model;

import java.io.Serializable;

public class TDw implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int dwbh;
	
	private String dwmc;
	
	private String dwbm;
	
	public TDw()
	{
	}

	public int getDwbh()
	{
		return dwbh;
	}

	public void setDwbh(int dwbh)
	{
		this.dwbh = dwbh;
	}

	public String getDwmc()
	{
		return dwmc;
	}

	public void setDwmc(String dwmc)
	{
		this.dwmc = dwmc;
	}

	public String getDwbm()
	{
		return dwbm;
	}

	public void setDwbm(String dwbm)
	{
		this.dwbm = dwbm;
	}
	
	
}
