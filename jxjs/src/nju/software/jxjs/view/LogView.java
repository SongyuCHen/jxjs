package nju.software.jxjs.view;

import java.io.Serializable;

public class LogView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5956249047277333286L;
	private String czr;//操作人
	private String type;//操作类型
	private String czsj;//操作时间
	private String czip;//操作IP
	private String bz;//备注
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCzsj() {
		return czsj;
	}
	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
	public String getCzip() {
		return czip;
	}
	public void setCzip(String czip) {
		this.czip = czip;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	

}
