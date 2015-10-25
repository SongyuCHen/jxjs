package nju.software.jxjs.service;

import java.util.Date;

import nju.software.jxjs.dao.PubAjJbDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.model.PubDmb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubAjJbService {

	@Autowired
	private PubAjJbDao ajDao;
	@Autowired
	private XtglDmbDao dmbDao;
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
		
		return "";
	}
}
