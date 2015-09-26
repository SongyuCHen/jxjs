package nju.software.jxjs.model;

import java.io.Serializable;

public class TFy implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int fybh;
	
	private String fymc;
	
	private String fybm;
	
	public TFy()
	{
	}

	public TFy(int fybh, String fymc, String fybm)
	{
		super();
		this.fybh = fybh;
		this.fymc = fymc;
		this.fybm = fybm;
	}

	public int getFybh()
	{
		return fybh;
	}

	public void setFybh(int fybh)
	{
		this.fybh = fybh;
	}

	public String getFymc()
	{
		return fymc;
	}

	public void setFymc(String fymc)
	{
		this.fymc = fymc;
	}

	public String getFybm()
	{
		return fybm;
	}

	public void setFybm(String fybm)
	{
		this.fybm = fybm;
	}
	
	
}
