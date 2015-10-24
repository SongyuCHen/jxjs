package nju.software.jxjs.model;

import java.io.Serializable;

/**
 * 审批信息
 * @author Administrator
 *
 */
public class TSpxx implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**
	 * 审批信息编号
	 */
	private int spxxbh;
	
	/**
	 * 审批人
	 */
	private PubXtglYhb spr;
	
	/**
	 * 审批意见
	 */
	private String spyj;
	
	/**
	 * 案件编号
	 */
	private PubAjJb aj;
	
	public TSpxx()
	{
	}

	public TSpxx(int spxxbh, PubXtglYhb spr, String spyj, PubAjJb aj)
	{
		super();
		this.spxxbh = spxxbh;
		this.spr = spr;
		this.spyj = spyj;
		this.aj = aj;
	}

	public int getSpxxbh()
	{
		return spxxbh;
	}

	public void setSpxxbh(int spxxbh)
	{
		this.spxxbh = spxxbh;
	}

	public PubXtglYhb getSpr()
	{
		return spr;
	}

	public void setSpr(PubXtglYhb spr)
	{
		this.spr = spr;
	}

	public String getSpyj()
	{
		return spyj;
	}

	public void setSpyj(String spyj)
	{
		this.spyj = spyj;
	}

	public PubAjJb getAj()
	{
		return aj;
	}

	public void setAj(PubAjJb aj)
	{
		this.aj = aj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aj == null) ? 0 : aj.hashCode());
		result = prime * result + ((spr == null) ? 0 : spr.hashCode());
		result = prime * result + spxxbh;
		result = prime * result + ((spyj == null) ? 0 : spyj.hashCode());
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
		TSpxx other = (TSpxx) obj;
		if (aj == null) {
			if (other.aj != null)
				return false;
		} else if (!aj.equals(other.aj))
			return false;
		if (spr == null) {
			if (other.spr != null)
				return false;
		} else if (!spr.equals(other.spr))
			return false;
		if (spxxbh != other.spxxbh)
			return false;
		if (spyj == null) {
			if (other.spyj != null)
				return false;
		} else if (!spyj.equals(other.spyj))
			return false;
		return true;
	}
	
	
}
