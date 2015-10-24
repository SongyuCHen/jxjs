package nju.software.jxjs.service;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.dao.JxjsDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TJxjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JxjsService {
	@Autowired
	private JxjsDao jd;
	@Autowired
	private XtglDmbDao dmbDao;
	public List<TJxjs> getDsplb(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已申请");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	public List<TJxjs> getYlalb(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已立案");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	public List<TJxjs> getYsplb(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已审批");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	
	public List<TJxjs> getJxjsByDateAndType(Date begin,Date end,String type){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", type);
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByDateAndAjztbh(begin, end, ajztbh);
	}
}
