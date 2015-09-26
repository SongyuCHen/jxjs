package nju.software.jxjs.model;

import java.io.Serializable;

public class TUser implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int userbh;
	
	private TDw dw;
	
	private String username;
	
	private String password;
	
	public TUser()
	{
	}

	public int getUserbh()
	{
		return userbh;
	}

	public void setUserbh(int userbh)
	{
		this.userbh = userbh;
	}

	public TDw getDw()
	{
		return dw;
	}

	public void setDw(TDw dw)
	{
		this.dw = dw;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
}
