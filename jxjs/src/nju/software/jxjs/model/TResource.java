package nju.software.jxjs.model;

// Generated Mar 27, 2015 2:10:41 PM by Hibernate Tools 3.4.0.CR1

/**
 * TResource generated by hbm2java
 */
public class TResource implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int resbh;
	private String resname;
	private String resurl;
	private String restype;

	public TResource()
	{
	}

	public TResource(int resbh, String resname, String resurl)
	{
		this.resbh = resbh;
		this.resname = resname;
		this.resurl = resurl;
	}

	public TResource(int resbh, String resname, String resurl, String restype)
	{
		this.resbh = resbh;
		this.resname = resname;
		this.resurl = resurl;
		this.restype = restype;
	}

	public int getResbh()
	{
		return this.resbh;
	}

	public void setResbh(int resbh)
	{
		this.resbh = resbh;
	}

	public String getResname()
	{
		return this.resname;
	}

	public void setResname(String resname)
	{
		this.resname = resname;
	}

	public String getResurl()
	{
		return this.resurl;
	}

	public void setResurl(String resurl)
	{
		this.resurl = resurl;
	}

	public String getRestype()
	{
		return this.restype;
	}

	public void setRestype(String restype)
	{
		this.restype = restype;
	}

}
