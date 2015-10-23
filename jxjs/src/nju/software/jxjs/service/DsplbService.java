package nju.software.jxjs.service;

import java.util.List;

import nju.software.jxjs.dao.JxjsDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TJxjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DsplbService {
	
	@Autowired
	private JxjsDao jd;
	@Autowired
	private XtglDmbDao dmbDao;
	public List<TJxjs> getDsplb(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已申请");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}

}
