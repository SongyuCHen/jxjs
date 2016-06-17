package nju.software.jxjs.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.common.Constants;
import nju.software.jxjs.model.DsrGr;
import nju.software.jxjs.model.DsrJb;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;
import nju.software.jxjs.model.YLaJxjs;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.DsrJbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.service.SpxxService;
import nju.software.jxjs.service.TDsrService;
import nju.software.jxjs.service.YLaJxjsService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.BthlbView;
import nju.software.jxjs.view.DsplbView;
import nju.software.jxjs.view.SqlbView;
import nju.software.jxjs.view.User;
import nju.software.jxjs.view.YlalbView;
import nju.software.jxjs.view.YsplbView;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AjclLogic {

	@Autowired
	private JxjsService jxjsService;

	@Autowired
	private PubAjJbService ajService;
	@Autowired
	private TDsrService dsrService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private SpxxService spxxService;
	@Autowired
	private DsrJbService dsrJbService;
	@Autowired
	private YLaJxjsService laJxjsService;
	public Object getDsplb() {
		List<DsplbView> dsplbView = new ArrayList<DsplbView>();
		List<TJxjs> jxjsList = jxjsService.getDsplb();
		for (TJxjs jxjs : jxjsList) {
			DsplbView vo = new DsplbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if (dsr != null)
				vo.setDsr(dsr.getXm());
			vo.setSqcs(jxjs.getSqcs());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX",
					jxjs.getSqlxbh());
			if (dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService
					.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if (dmb != null)
				vo.setSxfy(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			dsplbView.add(vo);

		}
		return dsplbView;
	}

	public Object getYsplb() {
		List<YsplbView> ysplbView = new ArrayList<YsplbView>();
		List<TJxjs> jxjsList = jxjsService.getYsplb();
		for (TJxjs jxjs : jxjsList) {
			YsplbView vo = new YsplbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if (dsr != null)
				vo.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX",
					jxjs.getSqlxbh());
			if (dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService
					.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if (dmb != null)
				vo.setSxfy(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			List<TSpxx> spxxList = spxxService
					.getSPxxByJxjsbh(jxjs.getJxjsbh());
			if (spxxList != null && spxxList.size() > 0) {
				TSpxx spxx = spxxList.get(spxxList.size() - 1);
				vo.setSpsj(DateUtil.format(spxx.getSpsj(), DateUtil.webFormat));
			}
			ysplbView.add(vo);

		}
		return ysplbView;
	}

	public Object getYlalb() {
		List<YlalbView> ylalbView = new ArrayList<YlalbView>();
		List<TJxjs> jxjsList = jxjsService.getYlalb();
		for (TJxjs jxjs : jxjsList) {
			YlalbView vo = new YlalbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			PubAjJb aj = ajService.getAjByAjxh(jxjs.getLaajxh());
			vo.setAh(aj.getAh());
			vo.setAjmc(aj.getAjmc());
			vo.setLasj(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX",
					jxjs.getSqlxbh());
			if (dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			ylalbView.add(vo);

		}
		return ylalbView;
	}

	public Object getBthlb() {
		List<BthlbView> bthlbView = new ArrayList<BthlbView>();
		List<TJxjs> jxjsList = jxjsService.getBthlb();
		for (TJxjs jxjs : jxjsList) {
			BthlbView vo = new BthlbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if (dsr != null)
				vo.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX",
					jxjs.getSqlxbh());
			if (dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService
					.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if (dmb != null)
				vo.setSxfy(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			List<TSpxx> spxxList = spxxService
					.getSPxxByJxjsbh(jxjs.getJxjsbh());
			if (spxxList != null && spxxList.size() > 0) {
				TSpxx spxx = spxxList.get(spxxList.size() - 1);
				vo.setThsj(DateUtil.format(spxx.getSpsj(), DateUtil.webFormat));
			}
			bthlbView.add(vo);

		}
		return bthlbView;
	}
	
	public Object getSqlb(Date begin, Date end){
		List<SqlbView> sqlbView = new ArrayList<SqlbView>();
		List<TJxjs> jxjsList = jxjsService.getSqlb(begin,end);
		for (TJxjs jxjs : jxjsList) {
			SqlbView vo = new SqlbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if (dsr != null)
				vo.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX",
					jxjs.getSqlxbh());
			if (dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService
					.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if (dmb != null)
				vo.setSxfy(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			int ajztbh = Integer.valueOf(jxjs.getAjztbh().trim());
			if(ajztbh<4 && ajztbh>1){//要么退回要么
				List<TSpxx> spxxList = spxxService
						.getSPxxByJxjsbh(jxjs.getJxjsbh());
				if (spxxList != null && spxxList.size() > 0) {
					TSpxx spxx = spxxList.get(spxxList.size() - 1);
					vo.setClsj(DateUtil.format(spxx.getSpsj(), DateUtil.webFormat));
				}
			}else if(ajztbh == 4){//立案
				PubAjJb aj = ajService.getAjByAjxh(jxjs.getLaajxh());
				vo.setClsj(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			}else if(ajztbh == 5){//结案
				PubAjJb aj = ajService.getAjByAjxh(jxjs.getLaajxh());
				vo.setClsj(DateUtil.format(aj.getJarq(), DateUtil.webFormat));
			}
			
			dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-AJZT", jxjs.getAjztbh());
			if(dmb != null)
				vo.setClzt(dmb.getDmms());
			sqlbView.add(vo);

		}
		return sqlbView;
	}

	public void la(String jxjsbhList) {
		User user = (User) SecurityUtils.getSubject().getSession()
				.getAttribute("currentUser");
		String[] bhList = jxjsbhList.split(",");
		int jxjsbh;
		for (String bh : bhList) {
			jxjsbh = Integer.valueOf(bh);
			TJxjs jxjs = jxjsService.getJxjsBybh(jxjsbh);
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjsbh);
			//1，每个减刑假释申请生成一个PubAjJb
			PubAjJb aj = new PubAjJb();
			String ajmc;
			aj.setBafy(Constants.BAFY);
			aj.setAjxz(Constants.AJXZ);
			aj.setSpcx(Constants.SPCX);
			aj.setSpcxdz(Constants.SPCXDZ);
			aj.setBycxdz(Constants.BYCXDZ);
			aj.setAjly(Constants.AJLY);
			aj.setSycx(Constants.SYCX);
			aj.setSslx(Constants.SSLX);
			aj.setSx(Constants.SX);
			//此处生成案号就是生成实际案号，不出现XX号
			String ah = "(2016)甘11刑更636号";//ajService.generateAh();
			aj.setAh(ah);
			if(jxjs.getSqlxbh().equals("1")){
				ajmc = dsr.getXm().concat("减刑");
			}else{
				ajmc = dsr.getXm().concat("假释");
			}
			aj.setAjmc(ajmc);
			aj.setLar(user.getUsername());
			Date today = new Date();
			aj.setLarq(today);
			aj.setLydq(Constants.LYDQ);
			
			aj.setSffhcs("N");
			aj.setSfjbaj("N");
			aj.setSfgs("N");
			aj.setSfys("N");
			aj.setSfzdaj("N");
			aj.setSfzdaj("N");
			aj.setSfwdyj("N");
			aj.setGksjg(Constants.GKSJG);
			aj = ajService.add(aj);
			TJxjs jxjs2 = jxjsService.getJxjsBybh(jxjsbh);
			//2，每个减刑假释申请生成一个DSR_JB DSR_GR
			DsrJb dsrjb = new DsrJb();
			dsrjb.setAjxh(aj.getAjxh());
			dsrjb.setDsrbh(1);
			dsrjb.setDsrssdw(Constants.DSRSSDW);
			dsrjb.setDsrlb(Constants.DSRLB);
			dsrjb.setSfssdbr("N");
			dsrjb.setDsrjc(dsr.getXm());
			dsrJbService.addDsrJb(dsrjb);
			
			// DSR_GR(T_DSR)
			DsrGr dsrgr = new DsrGr();
			dsrgr.setAjxh(aj.getAjxh());
			dsrgr.setDsrbh(1);
			dsrgr.setCsnyr(dsr.getCsnyr());
			dsrgr.setDh(dsr.getDh());
			dsrgr.setDz(dsr.getDz());
			dsrgr.setGzdw(dsr.getGzdw());

			dsrgr.setJb(dsr.getJb());
			dsrgr.setJg(dsr.getJg());
			dsrgr.setMz(dsr.getMz());
			dsrgr.setSf(dsr.getSf());
			dsrgr.setSfzhm(dsr.getSfzhm());
			dsrgr.setSsgj(dsr.getSsgj());
			dsrgr.setWhcd(dsr.getWhcd());
			dsrgr.setXm(dsr.getXm());
			dsrgr.setXb(dsr.getXb());
			dsrgr.setYb(dsr.getYb());
			dsrgr.setZw(dsr.getZw());
			dsrgr.setZzmm(dsr.getZzmm());
			dsrJbService.addDsrGr(dsrgr);
			
			
			//3.每个减刑假释申请生成一个YLaJxjs
			YLaJxjs laJxjs = new YLaJxjs();
			laJxjs.setAjxh(aj.getAjxh());
			laJxjs.setYsjjg(Constants.YSSJG);
			laJxjs.setSxah(jxjs.getSxah());
			laJxjs.setSxfy(jxjs.getSxfybh());
			laJxjs.setDcSxpjxf(jxjs.getSxpjxf());
			laJxjs.setDjcsq(jxjs.getSqcs());
			laJxjs.setDcYjxq(jxjs.getYjxq());
			int sfjx = jxjs.getSfjs();
			if(sfjx == 1){
				laJxjs.setSfbdjszfsqjx("Y");
			}else{
				laJxjs.setSfbdjszfsqjx("N");
			}
			laJxjs.setZffxdd(Constants.LYDQ);
			laJxjs.setBqjg(Constants.YSSJG);
			laJxjs.setSddjclrq(today);
			laJxjs.setDjryj("同意立案");
			laJxjs.setDjr(user.getUsername());
			laJxjs.setDjrq(today);
			laJxjsService.add(laJxjs);
		}
	}
	
	
	public void approval(String jxjsbhList,String spyj,String spsj){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String spr = user.getUsername();
		Date dSpsj = DateUtil.parse(spsj, DateUtil.webFormat);
		jxjsService.approval(jxjsbhList, spr, spyj, dSpsj);		
	}
	
	
	public void reject(String jxjsbhList,String spyj,String spsj){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String spr = user.getUsername();
		Date dSpsj = DateUtil.parse(spsj, DateUtil.webFormat);
		jxjsService.reject(jxjsbhList, spr, spyj, dSpsj);
	}

}
