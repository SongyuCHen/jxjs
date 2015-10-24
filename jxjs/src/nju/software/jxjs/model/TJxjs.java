package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class TJxjs implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	//减刑假释编号
	private Integer jxjsbh;
	//生效案件序号，若原始案件不在我库，则为NULL
	private Integer sxajxh;
	//立案案件序号，若尚未立案，则为NULL
	private Integer laajxh;
	//生效案号
	private String sxah;
	//生效法院编号
	private String sxfybh;
	//申请类型编号（减刑、假释）
	private String sqlxbh;
	//申请时间
	private Date sqsj;
	//申请次数
	private Integer sqcs;
	//案件状态编号（已审批、被退回、已立案、已结案）
	private String ajztbh;
	//服刑地点（XXX监狱）
	private String fxdd;
	//原判开始时间（即服刑开始时间）
	private Date ypksrq;
	//原判结束时间（即服刑结束时间）
	private Date ypjsrq;
	//减刑开始时间
	private Date sqksrq;
	//减刑结束时间
	private Date sqjsrq;
	//入监日期
	private Date rjrq;
	//是否不得假释罪犯申请减刑
	private Integer sfjs;
	
	public TJxjs()
	{
	}

	
	public TJxjs(Integer jxjsbh, Integer sxajxh, Integer laajxh, String sxah,
			String sxfybh, String sqlxbh, Date sqsj, Integer sqcs,
			String ajztbh, String fxdd, Date ypksrq, Date ypjsrq, Date sqksrq,
			Date sqjsrq, Date rjrq, Integer sfjs) {
		super();
		this.jxjsbh = jxjsbh;
		this.sxajxh = sxajxh;
		this.laajxh = laajxh;
		this.sxah = sxah;
		this.sxfybh = sxfybh;
		this.sqlxbh = sqlxbh;
		this.sqsj = sqsj;
		this.sqcs = sqcs;
		this.ajztbh = ajztbh;
		this.fxdd = fxdd;
		this.ypksrq = ypksrq;
		this.ypjsrq = ypjsrq;
		this.sqksrq = sqksrq;
		this.sqjsrq = sqjsrq;
		this.rjrq = rjrq;
		this.sfjs = sfjs;
	}


	public Integer getJxjsbh() {
		return jxjsbh;
	}


	public void setJxjsbh(Integer jxjsbh) {
		this.jxjsbh = jxjsbh;
	}


	public Integer getSxajxh() {
		return sxajxh;
	}


	public void setSxajxh(Integer sxajxh) {
		this.sxajxh = sxajxh;
	}


	public Integer getLaajxh() {
		return laajxh;
	}


	public void setLaajxh(Integer laajxh) {
		this.laajxh = laajxh;
	}


	public String getSxah() {
		return sxah;
	}


	public void setSxah(String sxah) {
		this.sxah = sxah;
	}


	public String getSxfybh() {
		return sxfybh;
	}


	public void setSxfybh(String sxfybh) {
		this.sxfybh = sxfybh;
	}


	public String getSqlxbh() {
		return sqlxbh;
	}


	public void setSqlxbh(String sqlxbh) {
		this.sqlxbh = sqlxbh;
	}


	public Date getSqsj() {
		return sqsj;
	}


	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}


	public Integer getSqcs() {
		return sqcs;
	}


	public void setSqcs(Integer sqcs) {
		this.sqcs = sqcs;
	}


	public String getAjztbh() {
		return ajztbh;
	}


	public void setAjztbh(String ajztbh) {
		this.ajztbh = ajztbh;
	}


	public String getFxdd() {
		return fxdd;
	}


	public void setFxdd(String fxdd) {
		this.fxdd = fxdd;
	}


	public Date getYpksrq() {
		return ypksrq;
	}


	public void setYpksrq(Date ypksrq) {
		this.ypksrq = ypksrq;
	}


	public Date getYpjsrq() {
		return ypjsrq;
	}


	public void setYpjsrq(Date ypjsrq) {
		this.ypjsrq = ypjsrq;
	}


	public Date getSqksrq() {
		return sqksrq;
	}


	public void setSqksrq(Date sqksrq) {
		this.sqksrq = sqksrq;
	}


	public Date getSqjsrq() {
		return sqjsrq;
	}


	public void setSqjsrq(Date sqjsrq) {
		this.sqjsrq = sqjsrq;
	}


	public Date getRjrq() {
		return rjrq;
	}


	public void setRjrq(Date rjrq) {
		this.rjrq = rjrq;
	}


	public Integer getSfjs() {
		return sfjs;
	}


	public void setSfjs(Integer sfjs) {
		this.sfjs = sfjs;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ajztbh == null) ? 0 : ajztbh.hashCode());
		result = prime * result + ((fxdd == null) ? 0 : fxdd.hashCode());
		result = prime * result + ((jxjsbh == null) ? 0 : jxjsbh.hashCode());
		result = prime * result + ((laajxh == null) ? 0 : laajxh.hashCode());
		result = prime * result + ((rjrq == null) ? 0 : rjrq.hashCode());
		result = prime * result + ((sfjs == null) ? 0 : sfjs.hashCode());
		result = prime * result + ((sqcs == null) ? 0 : sqcs.hashCode());
		result = prime * result + ((sqjsrq == null) ? 0 : sqjsrq.hashCode());
		result = prime * result + ((sqksrq == null) ? 0 : sqksrq.hashCode());
		result = prime * result + ((sqlxbh == null) ? 0 : sqlxbh.hashCode());
		result = prime * result + ((sqsj == null) ? 0 : sqsj.hashCode());
		result = prime * result + ((sxah == null) ? 0 : sxah.hashCode());
		result = prime * result + ((sxajxh == null) ? 0 : sxajxh.hashCode());
		result = prime * result + ((sxfybh == null) ? 0 : sxfybh.hashCode());
		result = prime * result + ((ypjsrq == null) ? 0 : ypjsrq.hashCode());
		result = prime * result + ((ypksrq == null) ? 0 : ypksrq.hashCode());
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
		TJxjs other = (TJxjs) obj;
		if (ajztbh == null) {
			if (other.ajztbh != null)
				return false;
		} else if (!ajztbh.equals(other.ajztbh))
			return false;
		if (fxdd == null) {
			if (other.fxdd != null)
				return false;
		} else if (!fxdd.equals(other.fxdd))
			return false;
		if (jxjsbh == null) {
			if (other.jxjsbh != null)
				return false;
		} else if (!jxjsbh.equals(other.jxjsbh))
			return false;
		if (laajxh == null) {
			if (other.laajxh != null)
				return false;
		} else if (!laajxh.equals(other.laajxh))
			return false;
		if (rjrq == null) {
			if (other.rjrq != null)
				return false;
		} else if (!rjrq.equals(other.rjrq))
			return false;
		if (sfjs == null) {
			if (other.sfjs != null)
				return false;
		} else if (!sfjs.equals(other.sfjs))
			return false;
		if (sqcs == null) {
			if (other.sqcs != null)
				return false;
		} else if (!sqcs.equals(other.sqcs))
			return false;
		if (sqjsrq == null) {
			if (other.sqjsrq != null)
				return false;
		} else if (!sqjsrq.equals(other.sqjsrq))
			return false;
		if (sqksrq == null) {
			if (other.sqksrq != null)
				return false;
		} else if (!sqksrq.equals(other.sqksrq))
			return false;
		if (sqlxbh == null) {
			if (other.sqlxbh != null)
				return false;
		} else if (!sqlxbh.equals(other.sqlxbh))
			return false;
		if (sqsj == null) {
			if (other.sqsj != null)
				return false;
		} else if (!sqsj.equals(other.sqsj))
			return false;
		if (sxah == null) {
			if (other.sxah != null)
				return false;
		} else if (!sxah.equals(other.sxah))
			return false;
		if (sxajxh == null) {
			if (other.sxajxh != null)
				return false;
		} else if (!sxajxh.equals(other.sxajxh))
			return false;
		if (sxfybh == null) {
			if (other.sxfybh != null)
				return false;
		} else if (!sxfybh.equals(other.sxfybh))
			return false;
		if (ypjsrq == null) {
			if (other.ypjsrq != null)
				return false;
		} else if (!ypjsrq.equals(other.ypjsrq))
			return false;
		if (ypksrq == null) {
			if (other.ypksrq != null)
				return false;
		} else if (!ypksrq.equals(other.ypksrq))
			return false;
		return true;
	}


	

}
