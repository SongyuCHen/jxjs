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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + czid;
		result = prime * result + ((czip == null) ? 0 : czip.hashCode());
		result = prime * result + ((czsj == null) ? 0 : czsj.hashCode());
		result = prime * result + logid;
		result = prime * result + rybh;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TLog other = (TLog) obj;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (czid != other.czid)
			return false;
		if (czip == null) {
			if (other.czip != null)
				return false;
		} else if (!czip.equals(other.czip))
			return false;
		if (czsj == null) {
			if (other.czsj != null)
				return false;
		} else if (!czsj.equals(other.czsj))
			return false;
		if (logid != other.logid)
			return false;
		if (rybh != other.rybh)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
