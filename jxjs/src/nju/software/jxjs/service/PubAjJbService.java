package nju.software.jxjs.service;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.common.Constants;
import nju.software.jxjs.dao.PubAjJbDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubAjJbService {

	@Autowired
	private PubAjJbDao ajDao;
	@Autowired
	private XtglDmbDao dmbDao;
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
	
	public PubAjJb getAjByAh(String ah){
		return ajDao.getAjJbByAh(ah);
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
	

}
