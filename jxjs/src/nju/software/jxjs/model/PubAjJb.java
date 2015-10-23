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

	
	
	
	
}
