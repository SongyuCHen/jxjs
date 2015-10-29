package nju.software.jxjs.service;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.dao.JxjsDao;
import nju.software.jxjs.dao.SpxxDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.dao.XtglYhbDao;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubXtglYhb;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JxjsService {
	@Autowired
	private JxjsDao jd;
	@Autowired
	private XtglDmbDao dmbDao;
	@Autowired
	private XtglYhbDao yhbDao;
	@Autowired
	private SpxxDao spxxDao;
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
	
	public void approval(String jxjsbhList,String spr,String spyj,Date spsj){
		String[] bhList = jxjsbhList.split(",");
		int jxjsbh;
		int spxxbh;
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已审批");
		PubXtglYhb yhb = new PubXtglYhb();
		List<PubXtglYhb> yhbs = yhbDao.findByYhmc(spr);
		if(yhbs != null && yhbs.size()>0)
			yhb = yhbs.get(0);
		for(String bh:bhList){
			jxjsbh = Integer.valueOf(bh);
			TJxjs jxjs = jd.getJxjsByBh(jxjsbh);				
			jxjs.setAjztbh(dmb.getDmbh());
			jd.updateJxjs(jxjs);
			TSpxx spxx = new TSpxx();
			spxx.setJxjsbh(jxjsbh);
			spxx.setSplx("1");
			spxx.setSpr(yhb);
			spxx.setSpsj(new Date());
			spxx.setSpyj(spyj);
			spxxbh = spxxDao.getMaxBh();
			spxxbh ++;
			spxx.setSpxxbh(spxxbh);
			spxxDao.save(spxx);
		}
		 
	}
	
	
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
