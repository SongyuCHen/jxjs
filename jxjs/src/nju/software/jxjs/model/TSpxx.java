package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

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
	 * 减刑假释编号
	 */
	private int jxjsbh;
	/**
	 * 审批人
	 */
	private PubXtglYhb spr;
	
	/**
	 * 审批意见
	 */
	private String spyj;
	/**
	 * 审批时间
	 */
	private Date spsj;
	/**
	 * 审批类型
	 */
	private String splx;
	public TSpxx()
	{
	}



	public TSpxx(int spxxbh, int jxjsbh, PubXtglYhb spr, String spyj,
			Date spsj, String splx) {
		super();
		this.spxxbh = spxxbh;
		this.jxjsbh = jxjsbh;
		this.spr = spr;
		this.spyj = spyj;
		this.spsj = spsj;
		this.splx = splx;
	}




	public int getSpxxbh() {
		return spxxbh;
	}



	public void setSpxxbh(int spxxbh) {
		this.spxxbh = spxxbh;
	}



	public int getJxjsbh() {
		return jxjsbh;
	}



	public void setJxjsbh(int jxjsbh) {
		this.jxjsbh = jxjsbh;
	}



	public PubXtglYhb getSpr() {
		return spr;
	}



	public void setSpr(PubXtglYhb spr) {
		this.spr = spr;
	}



	public String getSpyj() {
		return spyj;
	}



	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}



	public Date getSpsj() {
		return spsj;
	}



	public void setSpsj(Date spsj) {
		this.spsj = spsj;
	}



	public String getSplx() {
		return splx;
	}



	public void setSplx(String splx) {
		this.splx = splx;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jxjsbh;
		result = prime * result + ((splx == null) ? 0 : splx.hashCode());
		result = prime * result + ((spr == null) ? 0 : spr.hashCode());
		result = prime * result + ((spsj == null) ? 0 : spsj.hashCode());
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
		if (jxjsbh != other.jxjsbh)
			return false;
		if (splx == null) {
			if (other.splx != null)
				return false;
		} else if (!splx.equals(other.splx))
			return false;
		if (spr == null) {
			if (other.spr != null)
				return false;
		} else if (!spr.equals(other.spr))
			return false;
		if (spsj == null) {
			if (other.spsj != null)
				return false;
		} else if (!spsj.equals(other.spsj))
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
