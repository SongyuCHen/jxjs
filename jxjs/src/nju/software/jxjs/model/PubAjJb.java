package nju.software.jxjs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 案件基本信息
 * @author Administrator
 *
 */
public class PubAjJb implements Serializable
{
	private static final long serialVersionUID = 1L;
	//案件序号
	private Integer ajxh;
	//案号
	private String ah;
	//案件名称
	private String ajmc;
	//案件性质 FBS0021-97	
	private String ajxz;
	//案件来源 1AFBS0043-97,1BFBS0044-97,1CFBS0045-97,1DFBSAJLY-FH,1*FBSAJLY-JX,2AFBS0083-98,2BFBS0083-97,2CFBS0084-97,2DFBSAJLY-MT,2EFBSAJLY-MD,2FFBSAJLY-MC,2GFBSAJLY-MP,6AFBSAJLY_XZ,6BFBS0112-97,6CFBS0113-97,7*FBS0131-97,8*FBS0142-97,9*FBSAJLY-SB,A*FBSAJLY-QS
	private String ajly;
	//审判程序 1*FBS0041-97,2*FBS0081-97,6*FBS0111-97,7*FBSSPCX-PC,8*FBSSPCX-ZX,9*FBSSPCX-SB,A*FBSSPCX-QS	
	private String spcx;
	//审判程序待字 FBS0023-97	
	private String spcxdz;
	//适用程序 FBS0042-97
	private String sycx;
	//是否一审
	private String sfys;
	//是否重大案件
	private String sfzdaj;
	//是否交办案件
	private String sfjbaj;
	//是否发回重审案件
	private String sffhcs;
	//是否外地移交案件
	private String sfwdyj;
	//审限
	private Integer sx;
	//附加审限
	private Integer fjsx;
	//来源地区 GB2260-91
	private String lydq;
	//办案审判庭 USR206-99
	private String baspt;
	//简要案情
	private String jyaq;
	//立案日期
	private Date larq;
	//立案人
	private String lar;
	//办案法院 FBZ0001-97
	private String bafy;
	//公(抗)诉机关
	private String gksjg;
	//承办人意见
	private String cbryj;
	//合议庭意见
	private String hytyj;
	//庭长会意见
	private String tzhyj;
	//院长会意见
	private String yzhyj;
	//审委会意见
	private String swhyj;
	//结案日期
	private Date jarq;
	//结案方式 1AFBS0048-97,1*FBS0049-97,1HUSR0023-99,1DFBS0050-97,2AFBS0087-97,2*FBS0088-97,2FUSR0026-98,2GUSR706-02,2HUSR0023-99,2TUSR707,2SFBS0087-97,2ZFBS0087-97,6AFBS0117-97,6*FBS0118-97,6HUSR0023-99,7*FBS0133-97,8*FBS0144-97,8HUSR0023-99,A*USR0026-98	
	private String jafs;
	//结案原因
	private String jayy;
	//结案原因代码
	private String jayydm;
	//备注
	private String bz;
	//生效日期
	private Date sxrq;
	//归档标志
	private String gdbz;
	//案件状态 USR414-99
	private String ajzt;
	//本院程序代字 USR416-99
	private String bycxdz;
	//案件五涉情况  FBS0024-97
	private String ajwsqk;
	//归档日期
	private Date gdrq;
	//归档序列号
	private Integer gdxlh;
	//承办人报批日期
	private Date cbrbprq;
	//结案人
	private String cjar;
	//审判长审签日期
	private Date spzsqrq;
	//合议庭合议日期
	private Date hythyrq;
	//庭长审签日期
	private Date tzsqrq;
	//院长审签日期
	private Date yzsqrq;
	//审委会决定日期
	private Date swhjdrq;
	//院长签发日期
	private Date yzqfrq;
	//受理情况 USR603-02
	private String slqk;
	//上诉类型 USR617-02
	private String sslx;
	//是否公诉
	private String sfgs;
	//发回重审原因 2*FBS0099-97,1*FBS0062-97,6*FBS0128-97
	private String fhcsyy;
	//改判原因 1*FBS0061-97,2*FBS0098-97,6*FBS0127-97
	private String gpyy;
	
	private String sfzscq;
	//涉外类型  FBS0031-97
	private String swlx;
		
	//陪审员参与
	private String psycy;
	
	//是否小额诉讼
	private String sfxess;
	

	
	public PubAjJb()
	{
	}



	public PubAjJb(Integer ajxh, String ah, String ajmc, String ajxz,
			String ajly, String spcx, String spcxdz, String sycx, String sfys,
			String sfzdaj, String sfjbaj, String sffhcs, String sfwdyj,
			Integer sx, Integer fjsx, String lydq, String baspt, String jyaq,
			Date larq, String lar, String bafy, String gksjg, String cbryj,
			String hytyj, String tzhyj, String yzhyj, String swhyj, Date jarq,
			String jafs, String jayy, String jayydm, String bz, Date sxrq,
			String gdbz, String ajzt, String bycxdz, String ajwsqk, Date gdrq,
			Integer gdxlh, Date cbrbprq, String cjar, Date spzsqrq,
			Date hythyrq, Date tzsqrq, Date yzsqrq, Date swhjdrq, Date yzqfrq,
			String slqk, String sslx, String sfgs, String fhcsyy, String gpyy,
			String sfzscq, String swlx, String psycy, String sfxess) {
	
		this.ajxh = ajxh;
		this.ah = ah;
		this.ajmc = ajmc;
		this.ajxz = ajxz;
		this.ajly = ajly;
		this.spcx = spcx;
		this.spcxdz = spcxdz;
		this.sycx = sycx;
		this.sfys = sfys;
		this.sfzdaj = sfzdaj;
		this.sfjbaj = sfjbaj;
		this.sffhcs = sffhcs;
		this.sfwdyj = sfwdyj;
		this.sx = sx;
		this.fjsx = fjsx;
		this.lydq = lydq;
		this.baspt = baspt;
		this.jyaq = jyaq;
		this.larq = larq;
		this.lar = lar;
		this.bafy = bafy;
		this.gksjg = gksjg;
		this.cbryj = cbryj;
		this.hytyj = hytyj;
		this.tzhyj = tzhyj;
		this.yzhyj = yzhyj;
		this.swhyj = swhyj;
		this.jarq = jarq;
		this.jafs = jafs;
		this.jayy = jayy;
		this.jayydm = jayydm;
		this.bz = bz;
		this.sxrq = sxrq;
		this.gdbz = gdbz;
		this.ajzt = ajzt;
		this.bycxdz = bycxdz;
		this.ajwsqk = ajwsqk;
		this.gdrq = gdrq;
		this.gdxlh = gdxlh;
		this.cbrbprq = cbrbprq;
		this.cjar = cjar;
		this.spzsqrq = spzsqrq;
		this.hythyrq = hythyrq;
		this.tzsqrq = tzsqrq;
		this.yzsqrq = yzsqrq;
		this.swhjdrq = swhjdrq;
		this.yzqfrq = yzqfrq;
		this.slqk = slqk;
		this.sslx = sslx;
		this.sfgs = sfgs;
		this.fhcsyy = fhcsyy;
		this.gpyy = gpyy;
		this.sfzscq = sfzscq;
		this.swlx = swlx;
		this.psycy = psycy;
		this.sfxess = sfxess;
	}



	public Integer getAjxh() {
		return ajxh;
	}



	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}



	public String getAh() {
		return ah;
	}



	public void setAh(String ah) {
		this.ah = ah;
	}



	public String getAjmc() {
		return ajmc;
	}



	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}



	public String getAjxz() {
		return ajxz;
	}



	public void setAjxz(String ajxz) {
		this.ajxz = ajxz;
	}



	public String getAjly() {
		return ajly;
	}



	public void setAjly(String ajly) {
		this.ajly = ajly;
	}



	public String getSpcx() {
		return spcx;
	}



	public void setSpcx(String spcx) {
		this.spcx = spcx;
	}



	public String getSpcxdz() {
		return spcxdz;
	}



	public void setSpcxdz(String spcxdz) {
		this.spcxdz = spcxdz;
	}



	public String getSycx() {
		return sycx;
	}



	public void setSycx(String sycx) {
		this.sycx = sycx;
	}



	public String getSfys() {
		return sfys;
	}



	public void setSfys(String sfys) {
		this.sfys = sfys;
	}



	public String getSfzdaj() {
		return sfzdaj;
	}



	public void setSfzdaj(String sfzdaj) {
		this.sfzdaj = sfzdaj;
	}



	public String getSfjbaj() {
		return sfjbaj;
	}



	public void setSfjbaj(String sfjbaj) {
		this.sfjbaj = sfjbaj;
	}



	public String getSffhcs() {
		return sffhcs;
	}



	public void setSffhcs(String sffhcs) {
		this.sffhcs = sffhcs;
	}



	public String getSfwdyj() {
		return sfwdyj;
	}



	public void setSfwdyj(String sfwdyj) {
		this.sfwdyj = sfwdyj;
	}



	public Integer getSx() {
		return sx;
	}



	public void setSx(Integer sx) {
		this.sx = sx;
	}



	public Integer getFjsx() {
		return fjsx;
	}



	public void setFjsx(Integer fjsx) {
		this.fjsx = fjsx;
	}



	public String getLydq() {
		return lydq;
	}



	public void setLydq(String lydq) {
		this.lydq = lydq;
	}



	public String getBaspt() {
		return baspt;
	}



	public void setBaspt(String baspt) {
		this.baspt = baspt;
	}



	public String getJyaq() {
		return jyaq;
	}



	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}



	public Date getLarq() {
		return larq;
	}



	public void setLarq(Date larq) {
		this.larq = larq;
	}



	public String getLar() {
		return lar;
	}



	public void setLar(String lar) {
		this.lar = lar;
	}



	public String getBafy() {
		return bafy;
	}



	public void setBafy(String bafy) {
		this.bafy = bafy;
	}



	public String getGksjg() {
		return gksjg;
	}



	public void setGksjg(String gksjg) {
		this.gksjg = gksjg;
	}



	public String getCbryj() {
		return cbryj;
	}



	public void setCbryj(String cbryj) {
		this.cbryj = cbryj;
	}



	public String getHytyj() {
		return hytyj;
	}



	public void setHytyj(String hytyj) {
		this.hytyj = hytyj;
	}



	public String getTzhyj() {
		return tzhyj;
	}



	public void setTzhyj(String tzhyj) {
		this.tzhyj = tzhyj;
	}



	public String getYzhyj() {
		return yzhyj;
	}



	public void setYzhyj(String yzhyj) {
		this.yzhyj = yzhyj;
	}



	public String getSwhyj() {
		return swhyj;
	}



	public void setSwhyj(String swhyj) {
		this.swhyj = swhyj;
	}



	public Date getJarq() {
		return jarq;
	}



	public void setJarq(Date jarq) {
		this.jarq = jarq;
	}



	public String getJafs() {
		return jafs;
	}



	public void setJafs(String jafs) {
		this.jafs = jafs;
	}



	public String getJayy() {
		return jayy;
	}



	public void setJayy(String jayy) {
		this.jayy = jayy;
	}



	public String getJayydm() {
		return jayydm;
	}



	public void setJayydm(String jayydm) {
		this.jayydm = jayydm;
	}



	public String getBz() {
		return bz;
	}



	public void setBz(String bz) {
		this.bz = bz;
	}



	public Date getSxrq() {
		return sxrq;
	}



	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}



	public String getGdbz() {
		return gdbz;
	}



	public void setGdbz(String gdbz) {
		this.gdbz = gdbz;
	}



	public String getAjzt() {
		return ajzt;
	}



	public void setAjzt(String ajzt) {
		this.ajzt = ajzt;
	}



	public String getBycxdz() {
		return bycxdz;
	}



	public void setBycxdz(String bycxdz) {
		this.bycxdz = bycxdz;
	}



	public String getAjwsqk() {
		return ajwsqk;
	}



	public void setAjwsqk(String ajwsqk) {
		this.ajwsqk = ajwsqk;
	}



	public Date getGdrq() {
		return gdrq;
	}



	public void setGdrq(Date gdrq) {
		this.gdrq = gdrq;
	}



	public Integer getGdxlh() {
		return gdxlh;
	}



	public void setGdxlh(Integer gdxlh) {
		this.gdxlh = gdxlh;
	}



	public Date getCbrbprq() {
		return cbrbprq;
	}



	public void setCbrbprq(Date cbrbprq) {
		this.cbrbprq = cbrbprq;
	}



	public String getCjar() {
		return cjar;
	}



	public void setCjar(String cjar) {
		this.cjar = cjar;
	}



	public Date getSpzsqrq() {
		return spzsqrq;
	}



	public void setSpzsqrq(Date spzsqrq) {
		this.spzsqrq = spzsqrq;
	}



	public Date getHythyrq() {
		return hythyrq;
	}



	public void setHythyrq(Date hythyrq) {
		this.hythyrq = hythyrq;
	}



	public Date getTzsqrq() {
		return tzsqrq;
	}



	public void setTzsqrq(Date tzsqrq) {
		this.tzsqrq = tzsqrq;
	}



	public Date getYzsqrq() {
		return yzsqrq;
	}



	public void setYzsqrq(Date yzsqrq) {
		this.yzsqrq = yzsqrq;
	}



	public Date getSwhjdrq() {
		return swhjdrq;
	}



	public void setSwhjdrq(Date swhjdrq) {
		this.swhjdrq = swhjdrq;
	}



	public Date getYzqfrq() {
		return yzqfrq;
	}



	public void setYzqfrq(Date yzqfrq) {
		this.yzqfrq = yzqfrq;
	}



	public String getSlqk() {
		return slqk;
	}



	public void setSlqk(String slqk) {
		this.slqk = slqk;
	}



	public String getSslx() {
		return sslx;
	}



	public void setSslx(String sslx) {
		this.sslx = sslx;
	}



	public String getSfgs() {
		return sfgs;
	}



	public void setSfgs(String sfgs) {
		this.sfgs = sfgs;
	}



	public String getFhcsyy() {
		return fhcsyy;
	}



	public void setFhcsyy(String fhcsyy) {
		this.fhcsyy = fhcsyy;
	}



	public String getGpyy() {
		return gpyy;
	}



	public void setGpyy(String gpyy) {
		this.gpyy = gpyy;
	}



	public String getSfzscq() {
		return sfzscq;
	}



	public void setSfzscq(String sfzscq) {
		this.sfzscq = sfzscq;
	}



	public String getSwlx() {
		return swlx;
	}



	public void setSwlx(String swlx) {
		this.swlx = swlx;
	}



	public String getPsycy() {
		return psycy;
	}



	public void setPsycy(String psycy) {
		this.psycy = psycy;
	}



	public String getSfxess() {
		return sfxess;
	}



	public void setSfxess(String sfxess) {
		this.sfxess = sfxess;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ah == null) ? 0 : ah.hashCode());
		result = prime * result + ((ajly == null) ? 0 : ajly.hashCode());
		result = prime * result + ((ajmc == null) ? 0 : ajmc.hashCode());
		result = prime * result + ((ajwsqk == null) ? 0 : ajwsqk.hashCode());
		result = prime * result + ((ajxh == null) ? 0 : ajxh.hashCode());
		result = prime * result + ((ajxz == null) ? 0 : ajxz.hashCode());
		result = prime * result + ((ajzt == null) ? 0 : ajzt.hashCode());
		result = prime * result + ((bafy == null) ? 0 : bafy.hashCode());
		result = prime * result + ((baspt == null) ? 0 : baspt.hashCode());
		result = prime * result + ((bycxdz == null) ? 0 : bycxdz.hashCode());
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + ((cbrbprq == null) ? 0 : cbrbprq.hashCode());
		result = prime * result + ((cbryj == null) ? 0 : cbryj.hashCode());
		result = prime * result + ((cjar == null) ? 0 : cjar.hashCode());
		result = prime * result + ((fhcsyy == null) ? 0 : fhcsyy.hashCode());
		result = prime * result + ((fjsx == null) ? 0 : fjsx.hashCode());
		result = prime * result + ((gdbz == null) ? 0 : gdbz.hashCode());
		result = prime * result + ((gdrq == null) ? 0 : gdrq.hashCode());
		result = prime * result + ((gdxlh == null) ? 0 : gdxlh.hashCode());
		result = prime * result + ((gksjg == null) ? 0 : gksjg.hashCode());
		result = prime * result + ((gpyy == null) ? 0 : gpyy.hashCode());
		result = prime * result + ((hythyrq == null) ? 0 : hythyrq.hashCode());
		result = prime * result + ((hytyj == null) ? 0 : hytyj.hashCode());
		result = prime * result + ((jafs == null) ? 0 : jafs.hashCode());
		result = prime * result + ((jarq == null) ? 0 : jarq.hashCode());
		result = prime * result + ((jayy == null) ? 0 : jayy.hashCode());
		result = prime * result + ((jayydm == null) ? 0 : jayydm.hashCode());
		result = prime * result + ((jyaq == null) ? 0 : jyaq.hashCode());
		result = prime * result + ((lar == null) ? 0 : lar.hashCode());
		result = prime * result + ((larq == null) ? 0 : larq.hashCode());
		result = prime * result + ((lydq == null) ? 0 : lydq.hashCode());
		result = prime * result + ((psycy == null) ? 0 : psycy.hashCode());
		result = prime * result + ((sffhcs == null) ? 0 : sffhcs.hashCode());
		result = prime * result + ((sfgs == null) ? 0 : sfgs.hashCode());
		result = prime * result + ((sfjbaj == null) ? 0 : sfjbaj.hashCode());
		result = prime * result + ((sfwdyj == null) ? 0 : sfwdyj.hashCode());
		result = prime * result + ((sfxess == null) ? 0 : sfxess.hashCode());
		result = prime * result + ((sfys == null) ? 0 : sfys.hashCode());
		result = prime * result + ((sfzdaj == null) ? 0 : sfzdaj.hashCode());
		result = prime * result + ((sfzscq == null) ? 0 : sfzscq.hashCode());
		result = prime * result + ((slqk == null) ? 0 : slqk.hashCode());
		result = prime * result + ((spcx == null) ? 0 : spcx.hashCode());
		result = prime * result + ((spcxdz == null) ? 0 : spcxdz.hashCode());
		result = prime * result + ((spzsqrq == null) ? 0 : spzsqrq.hashCode());
		result = prime * result + ((sslx == null) ? 0 : sslx.hashCode());
		result = prime * result + ((swhjdrq == null) ? 0 : swhjdrq.hashCode());
		result = prime * result + ((swhyj == null) ? 0 : swhyj.hashCode());
		result = prime * result + ((swlx == null) ? 0 : swlx.hashCode());
		result = prime * result + ((sx == null) ? 0 : sx.hashCode());
		result = prime * result + ((sxrq == null) ? 0 : sxrq.hashCode());
		result = prime * result + ((sycx == null) ? 0 : sycx.hashCode());
		result = prime * result + ((tzhyj == null) ? 0 : tzhyj.hashCode());
		result = prime * result + ((tzsqrq == null) ? 0 : tzsqrq.hashCode());
		result = prime * result + ((yzhyj == null) ? 0 : yzhyj.hashCode());
		result = prime * result + ((yzqfrq == null) ? 0 : yzqfrq.hashCode());
		result = prime * result + ((yzsqrq == null) ? 0 : yzsqrq.hashCode());
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
		PubAjJb other = (PubAjJb) obj;
		if (ah == null) {
			if (other.ah != null)
				return false;
		} else if (!ah.equals(other.ah))
			return false;
		if (ajly == null) {
			if (other.ajly != null)
				return false;
		} else if (!ajly.equals(other.ajly))
			return false;
		if (ajmc == null) {
			if (other.ajmc != null)
				return false;
		} else if (!ajmc.equals(other.ajmc))
			return false;
		if (ajwsqk == null) {
			if (other.ajwsqk != null)
				return false;
		} else if (!ajwsqk.equals(other.ajwsqk))
			return false;
		if (ajxh == null) {
			if (other.ajxh != null)
				return false;
		} else if (!ajxh.equals(other.ajxh))
			return false;
		if (ajxz == null) {
			if (other.ajxz != null)
				return false;
		} else if (!ajxz.equals(other.ajxz))
			return false;
		if (ajzt == null) {
			if (other.ajzt != null)
				return false;
		} else if (!ajzt.equals(other.ajzt))
			return false;
		if (bafy == null) {
			if (other.bafy != null)
				return false;
		} else if (!bafy.equals(other.bafy))
			return false;
		if (baspt == null) {
			if (other.baspt != null)
				return false;
		} else if (!baspt.equals(other.baspt))
			return false;
		if (bycxdz == null) {
			if (other.bycxdz != null)
				return false;
		} else if (!bycxdz.equals(other.bycxdz))
			return false;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (cbrbprq == null) {
			if (other.cbrbprq != null)
				return false;
		} else if (!cbrbprq.equals(other.cbrbprq))
			return false;
		if (cbryj == null) {
			if (other.cbryj != null)
				return false;
		} else if (!cbryj.equals(other.cbryj))
			return false;
		if (cjar == null) {
			if (other.cjar != null)
				return false;
		} else if (!cjar.equals(other.cjar))
			return false;
		if (fhcsyy == null) {
			if (other.fhcsyy != null)
				return false;
		} else if (!fhcsyy.equals(other.fhcsyy))
			return false;
		if (fjsx == null) {
			if (other.fjsx != null)
				return false;
		} else if (!fjsx.equals(other.fjsx))
			return false;
		if (gdbz == null) {
			if (other.gdbz != null)
				return false;
		} else if (!gdbz.equals(other.gdbz))
			return false;
		if (gdrq == null) {
			if (other.gdrq != null)
				return false;
		} else if (!gdrq.equals(other.gdrq))
			return false;
		if (gdxlh == null) {
			if (other.gdxlh != null)
				return false;
		} else if (!gdxlh.equals(other.gdxlh))
			return false;
		if (gksjg == null) {
			if (other.gksjg != null)
				return false;
		} else if (!gksjg.equals(other.gksjg))
			return false;
		if (gpyy == null) {
			if (other.gpyy != null)
				return false;
		} else if (!gpyy.equals(other.gpyy))
			return false;
		if (hythyrq == null) {
			if (other.hythyrq != null)
				return false;
		} else if (!hythyrq.equals(other.hythyrq))
			return false;
		if (hytyj == null) {
			if (other.hytyj != null)
				return false;
		} else if (!hytyj.equals(other.hytyj))
			return false;
		if (jafs == null) {
			if (other.jafs != null)
				return false;
		} else if (!jafs.equals(other.jafs))
			return false;
		if (jarq == null) {
			if (other.jarq != null)
				return false;
		} else if (!jarq.equals(other.jarq))
			return false;
		if (jayy == null) {
			if (other.jayy != null)
				return false;
		} else if (!jayy.equals(other.jayy))
			return false;
		if (jayydm == null) {
			if (other.jayydm != null)
				return false;
		} else if (!jayydm.equals(other.jayydm))
			return false;
		if (jyaq == null) {
			if (other.jyaq != null)
				return false;
		} else if (!jyaq.equals(other.jyaq))
			return false;
		if (lar == null) {
			if (other.lar != null)
				return false;
		} else if (!lar.equals(other.lar))
			return false;
		if (larq == null) {
			if (other.larq != null)
				return false;
		} else if (!larq.equals(other.larq))
			return false;
		if (lydq == null) {
			if (other.lydq != null)
				return false;
		} else if (!lydq.equals(other.lydq))
			return false;
		if (psycy == null) {
			if (other.psycy != null)
				return false;
		} else if (!psycy.equals(other.psycy))
			return false;
		if (sffhcs == null) {
			if (other.sffhcs != null)
				return false;
		} else if (!sffhcs.equals(other.sffhcs))
			return false;
		if (sfgs == null) {
			if (other.sfgs != null)
				return false;
		} else if (!sfgs.equals(other.sfgs))
			return false;
		if (sfjbaj == null) {
			if (other.sfjbaj != null)
				return false;
		} else if (!sfjbaj.equals(other.sfjbaj))
			return false;
		if (sfwdyj == null) {
			if (other.sfwdyj != null)
				return false;
		} else if (!sfwdyj.equals(other.sfwdyj))
			return false;
		if (sfxess == null) {
			if (other.sfxess != null)
				return false;
		} else if (!sfxess.equals(other.sfxess))
			return false;
		if (sfys == null) {
			if (other.sfys != null)
				return false;
		} else if (!sfys.equals(other.sfys))
			return false;
		if (sfzdaj == null) {
			if (other.sfzdaj != null)
				return false;
		} else if (!sfzdaj.equals(other.sfzdaj))
			return false;
		if (sfzscq == null) {
			if (other.sfzscq != null)
				return false;
		} else if (!sfzscq.equals(other.sfzscq))
			return false;
		if (slqk == null) {
			if (other.slqk != null)
				return false;
		} else if (!slqk.equals(other.slqk))
			return false;
		if (spcx == null) {
			if (other.spcx != null)
				return false;
		} else if (!spcx.equals(other.spcx))
			return false;
		if (spcxdz == null) {
			if (other.spcxdz != null)
				return false;
		} else if (!spcxdz.equals(other.spcxdz))
			return false;
		if (spzsqrq == null) {
			if (other.spzsqrq != null)
				return false;
		} else if (!spzsqrq.equals(other.spzsqrq))
			return false;
		if (sslx == null) {
			if (other.sslx != null)
				return false;
		} else if (!sslx.equals(other.sslx))
			return false;
		if (swhjdrq == null) {
			if (other.swhjdrq != null)
				return false;
		} else if (!swhjdrq.equals(other.swhjdrq))
			return false;
		if (swhyj == null) {
			if (other.swhyj != null)
				return false;
		} else if (!swhyj.equals(other.swhyj))
			return false;
		if (swlx == null) {
			if (other.swlx != null)
				return false;
		} else if (!swlx.equals(other.swlx))
			return false;
		if (sx == null) {
			if (other.sx != null)
				return false;
		} else if (!sx.equals(other.sx))
			return false;
		if (sxrq == null) {
			if (other.sxrq != null)
				return false;
		} else if (!sxrq.equals(other.sxrq))
			return false;
		if (sycx == null) {
			if (other.sycx != null)
				return false;
		} else if (!sycx.equals(other.sycx))
			return false;
		if (tzhyj == null) {
			if (other.tzhyj != null)
				return false;
		} else if (!tzhyj.equals(other.tzhyj))
			return false;
		if (tzsqrq == null) {
			if (other.tzsqrq != null)
				return false;
		} else if (!tzsqrq.equals(other.tzsqrq))
			return false;
		if (yzhyj == null) {
			if (other.yzhyj != null)
				return false;
		} else if (!yzhyj.equals(other.yzhyj))
			return false;
		if (yzqfrq == null) {
			if (other.yzqfrq != null)
				return false;
		} else if (!yzqfrq.equals(other.yzqfrq))
			return false;
		if (yzsqrq == null) {
			if (other.yzsqrq != null)
				return false;
		} else if (!yzsqrq.equals(other.yzsqrq))
			return false;
		return true;
	}

	
	
	
	
}
