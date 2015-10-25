package nju.software.jxjs.service;

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
			tjzq = "21";
		}
		int year = Integer.parseInt(tjzq);
		return "";
	}
}
