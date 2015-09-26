package nju.software.jxjs.model;

import java.io.Serializable;

public class TDsr implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int dsrbh;
	
	private String dsrxm;
	
	private TDw dw; 
	
	public TDsr()
	{
	}

	public int getDsrbh()
	{
		return dsrbh;
	}

	public void setDsrbh(int dsrbh)
	{
		this.dsrbh = dsrbh;
	}

	public String getDsrxm()
	{
		return dsrxm;
	}

	public void setDsrxm(String dsrxm)
	{
		this.dsrxm = dsrxm;
	}

	public TDw getDw()
	{
		return dw;
	}

	public void setDw(TDw dw)
	{
		this.dw = dw;
	}
	
	
}
