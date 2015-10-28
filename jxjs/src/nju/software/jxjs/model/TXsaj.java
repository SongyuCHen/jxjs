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
	
}
