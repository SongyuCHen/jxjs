package nju.software.jxjs.view;

import java.io.Serializable;

public class DsplbView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5010992946598417230L;
	
	//##############业务逻辑需要!!!######################
	//减刑假释编号
	private int jxjsbh;
	//##################################################
	
	
	
	
	
	
	
	//########################页面显示相关！！！！####################
	//序号    略
	//原审案号
	private String ysah;
	//当事人
	private String dsr;
	//生效法院
	private String sxfy;
	//申请类型
	private String sqlx;
	//申请时间
	private String sqsj;
	//申请次数
	private int sqcs;
	//####################################################
	public int getJxjsbh() {
		return jxjsbh;
	}
	public void setJxjsbh(int jxjsbh) {
		this.jxjsbh = jxjsbh;
	}
	public String getYsah() {
		return ysah;
	}
	public void setYsah(String ysah) {
		this.ysah = ysah;
	}
	public String getDsr() {
		return dsr;
	}
	public void setDsr(String dsr) {
		this.dsr = dsr;
	}
	public String getSxfy() {
		return sxfy;
	}
	public void setSxfy(String sxfy) {
		this.sxfy = sxfy;
	}
	public String getSqlx() {
		return sqlx;
	}
	public void setSqlx(String sqlx) {
		this.sqlx = sqlx;
	}
	public String getSqsj() {
		return sqsj;
	}
	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}
	public int getSqcs() {
		return sqcs;
	}
	public void setSqcs(int sqcs) {
		this.sqcs = sqcs;
	}
}
