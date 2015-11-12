package nju.software.jxjs.service;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.dao.DsrGrDao;
import nju.software.jxjs.dao.DsrJbDao;
import nju.software.jxjs.dao.JxjsDao;
import nju.software.jxjs.dao.PubAjJbDao;
import nju.software.jxjs.dao.SpxxDao;
import nju.software.jxjs.dao.TDsrDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.dao.XtglYhbDao;
import nju.software.jxjs.model.DsrGr;
import nju.software.jxjs.model.DsrJb;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubXtglYhb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
	@Autowired
	private PubAjJbDao ajDao;
	@Autowired
	private DsrGrDao dsrgrDao;
	@Autowired
	private TDsrDao dsrDao;
	@Cacheable(value="jxjsCache",key="'getjxjsbybh'")
	public TJxjs getJxjsBybh(int jxjsbh){
		return jd.getJxjsByBh(jxjsbh);
	}
	@Cacheable(value="jxjsCache",key="'dsplb'")
	public List<TJxjs> getDsplb(){
		//System.out.println("@@@@@@@dsplb");
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已申请");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	@Cacheable(value="jxjsCache",key="'ylalb'")
	public List<TJxjs> getYlalb(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已立案");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	@Cacheable(value="jxjsCache",key="'ysplb'")
	public List<TJxjs> getYsplb(){
		//System.out.println("#########ysplb");
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已审批");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	@Cacheable(value="jxjsCache",key="'bthlb'")
	public List<TJxjs> getBthlb(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "被退回");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	@Cacheable(value="jxjsCache",key="'getjajgfk'")
	public List<TJxjs> getJajgfk(){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已反馈");
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByAjztbh(ajztbh);
	}
	public List<TJxjs> getJxjsByDateAndType(Date begin,Date end,String type){
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", type);
		String ajztbh = dmb.getDmbh();
		return jd.getJxjsByDateAndAjztbh(begin, end, ajztbh);
	}
	
	public int getSumByDate(Date kssj,Date jssj,String type){
		int sz = 0;
		switch(type){
			case "1":
				sz = jd.getSqSumByDate(kssj, jssj);
				break;
			case "2":
				sz = jd.getSpSumByDate(kssj, jssj);
				break;
			case "3":
				sz = jd.getlaSumByDate(kssj, jssj);
				break;
			case "4":
				sz = jd.getjaSumByDate(kssj, jssj);
				break;
			case "5":
				sz = jd.getfkSumByDate(kssj, jssj);
				break;
			
		}
		return sz;
	}
	
	public int getSumByCondition(Date kssj,Date jssj,String type,String sqlx){
		if(sqlx.equals("全部"))
			return jd.getSumByCondition(kssj, jssj, type);
		else{
			PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-SQLX", sqlx);
			String sqlxbh = dmb.getDmbh();
			return jd.getSumByConditionAndLx(kssj, jssj, type, sqlxbh);
		}
	}
	
	public int getSpSumByDate(Date kssj,Date jssj){
		int sz = 0;
		
		return sz;
	}
	@CacheEvict(value="jxjsCache", allEntries=true)
	public void approval(String jxjsbhList,String spr,String spyj,Date spsj){
		String[] bhList = jxjsbhList.split(",");
		int jxjsbh;
		int spxxbh;
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "已审批");
		PubXtglYhb yhb = new PubXtglYhb();
		List<PubXtglYhb> yhbs = yhbDao.findByYhdm(spr);
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
	@CacheEvict(value="jxjsCache", allEntries=true)
	public void reject(String jxjsbhList,String spr,String spyj,Date spsj){
		String[] bhList = jxjsbhList.split(",");
		int jxjsbh;
		int spxxbh;
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-AJZT", "被退回");
		PubXtglYhb yhb = new PubXtglYhb();
		List<PubXtglYhb> yhbs = yhbDao.findByYhdm(spr);
		if(yhbs != null && yhbs.size()>0)
			yhb = yhbs.get(0);
		for(String bh:bhList){
			jxjsbh = Integer.valueOf(bh);
			TJxjs jxjs = jd.getJxjsByBh(jxjsbh);				
			jxjs.setAjztbh(dmb.getDmbh());
			jd.updateJxjs(jxjs);
			TSpxx spxx = new TSpxx();
			spxx.setJxjsbh(jxjsbh);
			spxx.setSplx("2");
			spxx.setSpr(yhb);
			spxx.setSpsj(new Date());
			spxx.setSpyj(spyj);
			spxxbh = spxxDao.getMaxBh();
			spxxbh ++;
			spxx.setSpxxbh(spxxbh);
			spxxDao.save(spxx);
		}
		 
	}
	@CacheEvict(value="jxjsCache", allEntries=true)
	public void addJxjsByAjxhDsr(int ajxh,String dsr,String sqlx,Date sqsj,Date sqkssj,Date sqjssj){
		TJxjs jxjs = new TJxjs();
		
		PubAjJb aj = ajDao.getAjJbByAjxh(ajxh);
		DsrGr dsrgr = dsrgrDao.getDsrgrByAjxhAndXm(ajxh, dsr);
		jxjs.setAjztbh("1");
		jxjs.setFxdd("定西市监狱");
		jxjs.setRjrq(new Date());
		jxjs.setSfjs(0);
		jxjs.setSqcs(getSqcs(dsr));
		jxjs.setSqksrq(sqkssj);
		jxjs.setSqjsrq(sqjssj);
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-SQLX", sqlx);
		if(dmb!=null)
			jxjs.setSqlxbh(dmb.getDmbh());
		jxjs.setSqsj(sqsj);
		jxjs.setSxah(aj.getAh());
		jxjs.setSxajxh(aj.getAjxh());
		jxjs.setSxfybh(aj.getBafy());
		jxjs.setYpjsrq(new Date());
		jxjs.setYpksrq(new Date());
		jxjs = add(jxjs);
		TDsr jxjsDsr = convertDsr(dsrgr);
		jxjsDsr.setJxjsbh(jxjs.getJxjsbh());
		int dsrbh = dsrDao.getMaxDsrbh();
		dsrbh ++;
		jxjsDsr.setDsrbh(dsrbh);
		dsrDao.save(jxjsDsr);
		
	}
	public TDsr convertDsr(DsrGr gr){
		TDsr dsr = new TDsr();
		dsr.setCsnyr(gr.getCsnyr());
		dsr.setDh(gr.getDh());
		dsr.setDz(gr.getDz());
		dsr.setGzdw(gr.getGzdw());
		dsr.setJb(gr.getJb());
		dsr.setJg(gr.getJg());
		dsr.setMz(gr.getMz());
		dsr.setSf(gr.getSf());
		dsr.setSfzhm(gr.getSfzhm());
		dsr.setSsgj(gr.getSsgj());
		dsr.setWhcd(gr.getWhcd());
		dsr.setXb(gr.getXb());
		dsr.setXm(gr.getXm());
		dsr.setZw(gr.getZw());
		dsr.setZzmm(gr.getZzmm());
		return dsr;
	}
	
	public int getSqcs(String dsr){
		return jd.getSqcs(dsr);
	}
	@CacheEvict(value="jxjsCache", allEntries=true)
	public TJxjs add(TJxjs jxjs){
		int jxjsbh = jd.getMaxBh();
		jxjsbh ++;
		jxjs.setJxjsbh(jxjsbh);
		jd.save(jxjs);
		return jxjs;
	}
	@CacheEvict(value="jxjsCache", allEntries=true)
	public void update(TJxjs jxjs){
		jd.updateJxjs(jxjs);
	}
	@CacheEvict(value="jxjsCache", allEntries=true)
	public void delete(TJxjs jxjs){
		jd.delete(jxjs);
	}
}
