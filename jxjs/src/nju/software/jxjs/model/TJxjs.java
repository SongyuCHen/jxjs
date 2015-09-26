package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class TJxjs implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int jxjsbh;
	
	private PubAjJb aj;
	
	private TDsr dsr;
	
	private TFy sxfy;
	
	private TGypz sqlx;
	
	private Date sqsj;
	
	private int sqcs;
	
	private TGypz ajzt;
	
	public TJxjs()
	{
	}

	public TJxjs(int jxjsbh, PubAjJb aj, TDsr dsr, TFy sxfy, TGypz sqlx,
			Date sqsj, int sqcs, TGypz ajzt)
	{
		super();
		this.jxjsbh = jxjsbh;
		this.aj = aj;
		this.dsr = dsr;
		this.sxfy = sxfy;
		this.sqlx = sqlx;
		this.sqsj = sqsj;
		this.sqcs = sqcs;
		this.ajzt = ajzt;
	}

	public int getJxjsbh()
	{
		return jxjsbh;
	}

	public void setJxjsbh(int jxjsbh)
	{
		this.jxjsbh = jxjsbh;
	}

	public PubAjJb getAj()
	{
		return aj;
	}

	public void setAj(PubAjJb aj)
	{
		this.aj = aj;
	}

	public TDsr getDsr()
	{
		return dsr;
	}

	public void setDsr(TDsr dsr)
	{
		this.dsr = dsr;
	}

	public TFy getSxfy()
	{
		return sxfy;
	}

	public void setSxfy(TFy sxfy)
	{
		this.sxfy = sxfy;
	}

	public TGypz getSqlx()
	{
		return sqlx;
	}

	public void setSqlx(TGypz sqlx)
	{
		this.sqlx = sqlx;
	}

	public Date getSqsj()
	{
		return sqsj;
	}

	public void setSqsj(Date sqsj)
	{
		this.sqsj = sqsj;
	}

	public int getSqcs()
	{
		return sqcs;
	}

	public void setSqcs(int sqcs)
	{
		this.sqcs = sqcs;
	}

	public TGypz getAjzt()
	{
		return ajzt;
	}

	public void setAjzt(TGypz ajzt)
	{
		this.ajzt = ajzt;
	}
	
	
}
