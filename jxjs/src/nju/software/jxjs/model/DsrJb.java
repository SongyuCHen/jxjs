package nju.software.jxjs.model;

import java.util.Date;

public class DsrJb implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Integer ajxh;
	private Integer dsrbh;
	//当事人诉讼地位 1CFBSSSDW-XZ,1HFBSSSDW-SSFC,1IFBSSSDW-JXJS,1*FBS0040-97,2CFBS0096-97,2HFBSSSDW-SSFC,2GFBSSSDW-MSPC,2SFBSSSDW-SB,2TUSR708-02,2*FBS0095-97,1JFBSSSDW-JXJS,5*FBS0096-97,6*FBS0123-97,6CFBS0124-97,6HFBSSSDW-SSFC,7*FBS0132-97,8*FBS0147-97,A*FBSSSDW-QS
	private String dsrssdw;
	//当事人类别 FBS0002-TM
	private String dsrlb;
	//当事人姓名
	private String dsrjc;
	//是否诉讼代表人
	private String sfssdbr;
	//是否涉澳
	private String sfsa;
	//是否涉港
	private String sfsg;
	//是否涉侨
	private String sfsq;
	//是否涉台
	private String sfst;
	//是否涉外
	private String sfsw;

	
	public DsrJb()
	{
	}

	public DsrJb(Integer ajxh, Integer dsrbh, String dsrssdw, String dsrlb,
			String dsrjc, String sfssdbr, String dsrbgfs, String dsrbgyy,
			Date dsrbgsj, String sfsa, String sfsg, String sfsq, String sfst,
			String sfsw)
	{

		this.ajxh = ajxh;
		this.dsrbh = dsrbh;
		this.dsrssdw = dsrssdw;
		this.dsrlb = dsrlb;
		this.dsrjc = dsrjc;
		this.sfssdbr = sfssdbr;

		this.sfsa = sfsa;
		this.sfsg = sfsg;
		this.sfsq = sfsq;
		this.sfst = sfst;
		this.sfsw = sfsw;

	}

	public Integer getAjxh()
	{
		return ajxh;
	}

	public void setAjxh(Integer ajxh)
	{
		this.ajxh = ajxh;
	}

	public Integer getDsrbh()
	{
		return dsrbh;
	}

	public void setDsrbh(Integer dsrbh)
	{
		this.dsrbh = dsrbh;
	}

	public String getDsrssdw()
	{
		return dsrssdw;
	}

	public void setDsrssdw(String dsrssdw)
	{
		this.dsrssdw = dsrssdw;
	}

	public String getDsrlb()
	{
		return dsrlb;
	}

	public void setDsrlb(String dsrlb)
	{
		this.dsrlb = dsrlb;
	}

	public String getDsrjc()
	{
		return dsrjc;
	}

	public void setDsrjc(String dsrjc)
	{
		this.dsrjc = dsrjc;
	}

	public String getSfssdbr()
	{
		return sfssdbr;
	}

	public void setSfssdbr(String sfssdbr)
	{
		this.sfssdbr = sfssdbr;
	}

	

	public String getSfsa()
	{
		return sfsa;
	}

	public void setSfsa(String sfsa)
	{
		this.sfsa = sfsa;
	}

	public String getSfsg()
	{
		return sfsg;
	}

	public void setSfsg(String sfsg)
	{
		this.sfsg = sfsg;
	}

	public String getSfsq()
	{
		return sfsq;
	}

	public void setSfsq(String sfsq)
	{
		this.sfsq = sfsq;
	}

	public String getSfst()
	{
		return sfst;
	}

	public void setSfst(String sfst)
	{
		this.sfst = sfst;
	}

	public String getSfsw()
	{
		return sfsw;
	}

	public void setSfsw(String sfsw)
	{
		this.sfsw = sfsw;
	}

	
	
}
