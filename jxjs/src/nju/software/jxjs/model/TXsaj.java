package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class TXsaj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2460603548199571314L;
	//案件序号
	private Integer ajxh;
	//传输人编号
	private Integer csrbh;
	//传输时间
	private Date cssj;
	public TXsaj(){
		
	}
	public TXsaj(Integer ajxh, Integer csrbh, Date cssj) {
		super();
		this.ajxh = ajxh;
		this.csrbh = csrbh;
		this.cssj = cssj;
	}
	public Integer getAjxh() {
		return ajxh;
	}
	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}
	public Integer getCsrbh() {
		return csrbh;
	}
	public void setCsrbh(Integer csrbh) {
		this.csrbh = csrbh;
	}
	public Date getCssj() {
		return cssj;
	}
	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ajxh == null) ? 0 : ajxh.hashCode());
		result = prime * result + ((csrbh == null) ? 0 : csrbh.hashCode());
		result = prime * result + ((cssj == null) ? 0 : cssj.hashCode());
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
		TXsaj other = (TXsaj) obj;
		if (ajxh == null) {
			if (other.ajxh != null)
				return false;
		} else if (!ajxh.equals(other.ajxh))
			return false;
		if (csrbh == null) {
			if (other.csrbh != null)
				return false;
		} else if (!csrbh.equals(other.csrbh))
			return false;
		if (cssj == null) {
			if (other.cssj != null)
				return false;
		} else if (!cssj.equals(other.cssj))
			return false;
		return true;
	}
	
	
}
