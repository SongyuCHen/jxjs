package nju.software.jxjs.service;

import java.util.Date;
import java.util.List;

import nju.software.jxjs.dao.DsrGrDao;
import nju.software.jxjs.dao.JxjsDao;
import nju.software.jxjs.dao.PubAjJbDao;
import nju.software.jxjs.dao.SpxxDao;
import nju.software.jxjs.dao.TDsrDao;
import nju.software.jxjs.dao.XtglDmbDao;
import nju.software.jxjs.dao.XtglYhbDao;
import nju.software.jxjs.model.DsrGr;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubXtglYhb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.JxjsApplyView;
import nju.software.jxjs.view.JxjsView;

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
	@Cacheable(value="jxjsCache",key="'dsplb'")
	public JxjsView getJxjsByBh(int jxjsbh){
		JxjsView view = new JxjsView();
		
		if(jxjsbh>0){
			TJxjs jxjs = jd.getJxjsByBh(jxjsbh);
			view.setAh(jxjs.getSxah());
			view.setAjmc(jxjs.getSxajmc());
			PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("FBZ0001-97", jxjs.getSxfybh());
			view.setBafy(dmb.getDmms());
			TDsr dsr = dsrDao.getDsrByJxjsbh(jxjsbh);
			view.setDsr(dsr.getXm());
			view.setFxdd(jxjs.getFxdd());
			view.setRjrq(DateUtil.format(jxjs.getRjrq(), DateUtil.webFormat));
			int sfjs = jxjs.getSfjs();
			if(sfjs == 1){
				view.setSfjs("是");
			}else{
				view.setSfjs("否");
			}
			view.setSqcs(jxjs.getSqcs());
			view.setSqjssj(DateUtil.format(jxjs.getSqjsrq(), DateUtil.webFormat));
			view.setSqkssj(DateUtil.format(jxjs.getSqksrq(), DateUtil.webFormat));
			dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-SQLX", jxjs.getSqlxbh());
			view.setSqlx(dmb.getDmms());
			view.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbDao.getDmbByLbbhAndDmms("FBS0068-97", jxjs.getSxpjxf());
			view.setSxpjxf(dmb.getDmms());
			view.setXqjssj(DateUtil.format(jxjs.getYpjsrq(), DateUtil.webFormat));
			view.setXqkssj(DateUtil.format(jxjs.getYpksrq(), DateUtil.webFormat));
			view.setYjxq(jxjs.getYjxq());
				
		}
		return view;
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
	@Cacheable(value="jxjsCache",key="'sqlb'")
	public List<TJxjs> getSqlb(Date begin, Date end){
		return jd.getJxjsByDate(begin,end);
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
				sz = jd.getThSumByDate(kssj, jssj);
				break;
			case "4":
				sz = jd.getlaSumByDate(kssj, jssj);
				break;
			case "5":
				sz = jd.getjaSumByDate(kssj, jssj);
				break;
			case "6":
				sz = jd.getfkSumByDate(kssj, jssj);
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
	public void addJxjsByAjxhDsr(int ajxh,String dsr,String sqlx,Date sqsj,Date sqkssj,Date sqjssj,
			String bafy,int sqcs,Date rjrq,Date xqkssj,Date xqjssj,int sfjs,String sxah,String sxajmc){
		TJxjs jxjs = new TJxjs();
		
//		PubAjJb aj = ajDao.getAjJbByAjxh(ajxh);
//		DsrGr dsrgr = dsrgrDao.getDsrgrByAjxhAndXm(ajxh, dsr);
		jxjs.setAjztbh("1");
		jxjs.setFxdd("定西市监狱");
		jxjs.setSfjs(0);
		jxjs.setSqcs(sqcs);
		jxjs.setSqksrq(sqkssj);
		jxjs.setSqjsrq(sqjssj);
		jxjs.setRjrq(rjrq);
		jxjs.setYpksrq(xqkssj);
		jxjs.setYpjsrq(xqjssj);
		jxjs.setSqcs(sqcs);
		PubDmb dmb = dmbDao.getDmbByLbbhAndDmms("JXJS-SQLX", sqlx);
		if(dmb!=null)
			jxjs.setSqlxbh(dmb.getDmbh());
		jxjs.setSqsj(sqsj);
		if(ajxh > 0){//从法综系统提取的案件
			PubAjJb aj = ajDao.getAjJbByAjxh(ajxh);
			DsrGr dsrgr = dsrgrDao.getDsrgrByAjxhAndXm(ajxh, dsr);
			jxjs.setSxah(aj.getAh());
			jxjs.setSxajxh(aj.getAjxh());
			jxjs.setSxfybh(aj.getBafy());
			jxjs.setSxajmc(aj.getAjmc());
			jxjs = add(jxjs);
			TDsr jxjsDsr = convertDsr(dsrgr);
			jxjsDsr.setJxjsbh(jxjs.getJxjsbh());
			int dsrbh = dsrDao.getMaxDsrbh();
			dsrbh ++;
			jxjsDsr.setDsrbh(dsrbh);
			dsrDao.save(jxjsDsr);
		}else{//案件不是定西的，无法从系统中获取，只能从界面传参
			jxjs.setSxah(sxah);
			jxjs.setSxajxh(0);
			jxjs.setSxfybh(bafy);
			jxjs.setSxajmc(sxajmc);
			jxjs = add(jxjs);
			TDsr jxjsDsr = new TDsr();
			//此处需要完善，从界面上获取当事人的常用信息
			jxjsDsr.setXm(dsr);
			
			int dsrbh = dsrDao.getMaxDsrbh();
			dsrbh ++;
			jxjsDsr.setDsrbh(dsrbh);
			dsrDao.save(jxjsDsr);
		}
		
		
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
