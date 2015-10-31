package nju.software.jxjs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.common.Constants;
import nju.software.jxjs.dao.DsrJbDao;
import nju.software.jxjs.dao.PubAjJbDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.dao.XtglYhbDao;
import nju.software.jxjs.model.DsrJb;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubXtglYhb;
import nju.software.jxjs.model.TXsaj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubAjJbService {

	@Autowired
	private PubAjJbDao ajDao;
	@Autowired
	private XtglDmbDao dmbDao;
	@Autowired
	private XtglYhbDao yhbDao;
	@Autowired
	private DsrJbDao dsrJbDao;
	@SuppressWarnings("deprecation")
	public String generateAh(){
		String tjzq = "";
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmbh("系统缺省", "统计时间");
		if(dmb != null){
			tjzq = dmb.getDmms().trim();
		}else{
			tjzq = "20";
		}
		int i_tjzq = Integer.parseInt(tjzq);
		Date today = new Date();
		String s_year = "";
		if(today.getMonth() == 12 && today.getDate() >i_tjzq)
			s_year=Integer.toString(today.getYear() + 1);
		else
			s_year=Integer.toString(today.getYear());
		
		dmb = dmbDao.getDmbByLbbhAndDmbh("系统确认", "法院简称");
		String fyjc = dmb.getDmms();
		dmb= dmbDao.getDmbByLbbhAndDmbh("USR416-99", Constants.BYCXDZ);
		String bycxdz = dmb.getDmms();
		String ah = "(".concat(s_year).concat(")").concat(fyjc).concat(bycxdz).concat("字第XX号");
		return ah;
	}
	
	public PubAjJb getAjByAjxh(int ajxh){
		return ajDao.getAjJbByAjxh(ajxh);
	}
	
	public PubAjJb getXsajByAh(String ah){
		return ajDao.getAjJbByAh(ah);
	}
	
	public List<PubAjJb> getXsajByDsr(String dsr){
		List<DsrJb> dsrList = dsrJbDao.findByDsrjc(dsr);
		if(dsrList!=null && dsrList.size()>0){
			List<PubAjJb> ajList = new ArrayList<PubAjJb>();
			for(DsrJb dsrjb:dsrList){
				ajList.add(ajDao.getAjJbByAjxh(dsrjb.getAjxh()));
			}
			return ajList;
		}else
			return null;
	}
	public PubAjJb add(PubAjJb aj){
		int ajxh = ajDao.getMaxBh();
		ajxh ++;
		aj.setAjxh(ajxh);
		ajDao.save(aj);
		return aj;
	}
	
	public List<PubAjJb> getXsajByDate(Date kssj,Date jssj){
		return ajDao.getXSajByLarq(kssj, jssj);
	}
	public List<PubAjJb> getXsajAfterDate(Date kssj){
		return ajDao.getXSajAfterLarq(kssj);
	}
	public List<PubAjJb> getXsajBeforeDate(Date jssj){
		return ajDao.getXSajBeforeLarq(jssj);
	}
	
	public int addXsajTrans(String ajxhList,String csr,Date cssj){
		String[] bhList = ajxhList.split(",");
		int ajxh;
		int sum = 0;
		PubXtglYhb yhb = new PubXtglYhb();
		List<PubXtglYhb> yhbs = yhbDao.findByYhdm(csr);
		if(yhbs != null && yhbs.size()>0)
			yhb = yhbs.get(0);
		for(String bh:bhList){
			ajxh = Integer.valueOf(bh);
			TXsaj xsaj = new TXsaj();
			xsaj.setAjxh(ajxh);
			xsaj.setCsrbh(yhb.getYhbh());
			xsaj.setCssj(cssj);
			ajDao.addXsajTrans(xsaj);
			sum ++;
		}
		return sum;
	}
	
	

}
