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
	public TJxjs getJxjsBybh(int jxjsbh){
		return jd.getJxjsByBh(jxjsbh);
	}
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
	
//	public int getSumByDateAndType(Date kssj,Date jssj,String type){
//		int sz = 0;
//		switch(type){
//			case "1":
//				sz = jd.get
//		}
//		return jd.getSumByDateAndType(kssj, jssj, type);
//	}
	
	
	public TJxjs add(TJxjs jxjs){
		int jxjsbh = jd.getMaxBh();
		jxjsbh ++;
		jxjs.setJxjsbh(jxjsbh);
		jd.save(jxjs);
		return jxjs;
	}
	
	public void update(TJxjs jxjs){
		jd.updateJxjs(jxjs);
	}
	
	public void delete(TJxjs jxjs){
		jd.delete(jxjs);
	}
}
