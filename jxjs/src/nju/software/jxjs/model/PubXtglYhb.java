package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

public class PubXtglYhb implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int yhbh;
	
	//用户登录名
	private String yhdm;
	//用户姓名
	private String yhmc;
	//用户口令
	private String yhkl;
	//用户部门 USR206-99
	private String yhbm;
	
	private String klts;
	
	private String klda;
	//用户身份 直接显示，无字典
	private String yhsf;
	
	private Date klszsj;
	
	private Date qjkssj;
	
	private Date qjjssj;
	
	private String qjyy;
	
	private Integer grnzb;
	
	private Integer qtnzb;
	
	private Integer grbajs;
	
	private Integer fazt;
	
	private Integer fasl;
	
	private byte[] dzqm_img;
	
	private String jbxxj_code;
	
	private Integer dhhm;
	
	private String phonenum;
	
	private Integer fybh;
	
	private Integer yhzt;
	
	private String xfqx;
	
	private String ssfwzxqx;
	
	private String phone;
	
	public PubXtglYhb()
	{
	}

	public int getYhbh() {
		return yhbh;
	}

	public void setYhbh(int yhbh) {
		this.yhbh = yhbh;
	}

	public String getYhdm() {
		return yhdm;
	}

	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}

	public String getYhmc() {
		return yhmc;
	}

	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}

	public String getYhkl() {
		return yhkl;
	}

	public void setYhkl(String yhkl) {
		this.yhkl = yhkl;
	}

	public String getYhbm() {
		return yhbm;
	}

	public void setYhbm(String yhbm) {
		this.yhbm = yhbm;
	}

	public String getKlts() {
		return klts;
	}

	public void setKlts(String klts) {
		this.klts = klts;
	}

	public String getKlda() {
		return klda;
	}

	public void setKlda(String klda) {
		this.klda = klda;
	}

	public String getYhsf() {
		return yhsf;
	}

	public void setYhsf(String yhsf) {
		this.yhsf = yhsf;
	}

	public Date getKlszsj() {
		return klszsj;
	}

	public void setKlszsj(Date klszsj) {
		this.klszsj = klszsj;
	}

	public Date getQjkssj() {
		return qjkssj;
	}

	public void setQjkssj(Date qjkssj) {
		this.qjkssj = qjkssj;
	}

	public Date getQjjssj() {
		return qjjssj;
	}

	public void setQjjssj(Date qjjssj) {
		this.qjjssj = qjjssj;
	}

	public String getQjyy() {
		return qjyy;
	}

	public void setQjyy(String qjyy) {
		this.qjyy = qjyy;
	}

	public Integer getGrnzb() {
		return grnzb;
	}

	public void setGrnzb(Integer grnzb) {
		this.grnzb = grnzb;
	}

	public Integer getQtnzb() {
		return qtnzb;
	}

	public void setQtnzb(Integer qtnzb) {
		this.qtnzb = qtnzb;
	}

	public Integer getGrbajs() {
		return grbajs;
	}

	public void setGrbajs(Integer grbajs) {
		this.grbajs = grbajs;
	}

	public Integer getFazt() {
		return fazt;
	}

	public void setFazt(Integer fazt) {
		this.fazt = fazt;
	}

	public Integer getFasl() {
		return fasl;
	}

	public void setFasl(Integer fasl) {
		this.fasl = fasl;
	}

	public byte[] getDzqm_img() {
		return dzqm_img;
	}

	public void setDzqm_img(byte[] dzqm_img) {
		this.dzqm_img = dzqm_img;
	}

	public String getJbxxj_code() {
		return jbxxj_code;
	}

	public void setJbxxj_code(String jbxxj_code) {
		this.jbxxj_code = jbxxj_code;
	}

	public Integer getDhhm() {
		return dhhm;
	}

	public void setDhhm(Integer dhhm) {
		this.dhhm = dhhm;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Integer getFybh() {
		return fybh;
	}

	public void setFybh(Integer fybh) {
		this.fybh = fybh;
	}

	public Integer getYhzt() {
		return yhzt;
	}

	public void setYhzt(Integer yhzt) {
		this.yhzt = yhzt;
	}

	public String getXfqx() {
		return xfqx;
	}

	public void setXfqx(String xfqx) {
		this.xfqx = xfqx;
	}

	public String getSsfwzxqx() {
		return ssfwzxqx;
	}

	public void setSsfwzxqx(String ssfwzxqx) {
		this.ssfwzxqx = ssfwzxqx;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + yhbh;
		result = prime * result + ((yhbm == null) ? 0 : yhbm.hashCode());
		result = prime * result + ((yhdm == null) ? 0 : yhdm.hashCode());
		result = prime * result + ((yhkl == null) ? 0 : yhkl.hashCode());
		result = prime * result + ((yhmc == null) ? 0 : yhmc.hashCode());
		result = prime * result + ((yhsf == null) ? 0 : yhsf.hashCode());
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
		PubXtglYhb other = (PubXtglYhb) obj;
		if (yhbh != other.yhbh)
			return false;
		if (yhbm == null) {
			if (other.yhbm != null)
				return false;
		} else if (!yhbm.equals(other.yhbm))
			return false;
		if (yhdm == null) {
			if (other.yhdm != null)
				return false;
		} else if (!yhdm.equals(other.yhdm))
			return false;
		if (yhkl == null) {
			if (other.yhkl != null)
				return false;
		} else if (!yhkl.equals(other.yhkl))
			return false;
		if (yhmc == null) {
			if (other.yhmc != null)
				return false;
		} else if (!yhmc.equals(other.yhmc))
			return false;
		if (yhsf == null) {
			if (other.yhsf != null)
				return false;
		} else if (!yhsf.equals(other.yhsf))
			return false;
		return true;
	}

	
	
}
