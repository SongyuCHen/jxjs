package nju.software.jxjs.view;

public class TjfxResultModel {
	String s_type;
	int i_sz;
	double d_sz;
	public TjfxResultModel(){
		
	}
	public TjfxResultModel(String s_type, int i_sz, double d_sz) {
		super();
		this.s_type = s_type;
		this.i_sz = i_sz;
		this.d_sz = d_sz;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public int getI_sz() {
		return i_sz;
	}
	public void setI_sz(int i_sz) {
		this.i_sz = i_sz;
	}
	public double getD_sz() {
		return d_sz;
	}
	public void setD_sz(double d_sz) {
		this.d_sz = d_sz;
	}
	

}
