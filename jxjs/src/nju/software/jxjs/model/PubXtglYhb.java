package nju.software.jxjs.model;

import java.io.Serializable;

public class PubXtglYhb implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int yhbh;
	
	//用户代码
	private String yhdm;
	//用户名
	private String yhmc;
	
	private String yhkl;
	
	private String yhbm;
	
	public PubXtglYhb()
	{
	}

	public int getYhbh()
	{
		return yhbh;
	}

	public void setYhbh(int yhbh)
	{
		this.yhbh = yhbh;
	}

	public String getYhdm()
	{
		return yhdm;
	}

	public void setYhdm(String yhdm)
	{
		this.yhdm = yhdm;
	}

	public String getYhmc()
	{
		return yhmc;
	}

	public void setYhmc(String yhmc)
	{
		this.yhmc = yhmc;
	}

	public String getYhkl()
	{
		return yhkl;
	}

	public void setYhkl(String yhkl)
	{
		this.yhkl = yhkl;
	}

	public String getYhbm()
	{
		return yhbm;
	}

	public void setYhbm(String yhbm)
	{
		this.yhbm = yhbm;
	}
	
	
}
