package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class TLog implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int logid;
	
	private int czid;
	
	private String type;
	
	private int rybh;
	
	private Date czsj;
	
	private String czip;
	
	private String bz;
	
	public TLog()
	{
		
	}

	public int getLogid()
	{
		return logid;
	}

	public void setLogid(int logid)
	{
		this.logid = logid;
	}

	public int getCzid()
	{
		return czid;
	}

	public void setCzid(int czid)
	{
		this.czid = czid;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public int getRybh()
	{
		return rybh;
	}

	public void setRybh(int rybh)
	{
		this.rybh = rybh;
	}

	public Date getCzsj()
	{
		return czsj;
	}

	public void setCzsj(Date czsj)
	{
		this.czsj = czsj;
	}

	public String getCzip()
	{
		return czip;
	}

	public void setCzip(String czip)
	{
		this.czip = czip;
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
