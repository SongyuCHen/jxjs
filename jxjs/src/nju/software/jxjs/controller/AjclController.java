package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.jxjs.common.Constants;
import nju.software.jxjs.model.DsrGr;
import nju.software.jxjs.model.DsrJb;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;




import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.service.SpxxService;
import nju.software.jxjs.service.TDsrService;
import nju.software.jxjs.service.UserService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.BthlbView;
import nju.software.jxjs.view.DsplbView;
import nju.software.jxjs.view.User;
import nju.software.jxjs.view.YlalbView;
import nju.software.jxjs.view.YsplbView;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ajcl")
public class AjclController extends BaseController
{
	
	@Autowired
	private MenuService ms;
	
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
	private UserService userService;
	/**
	 * export excel
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public ModelAndView exportExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("export excel for ajcl");
		
		List<TJxjs> ajclList = null;
		
        return new ModelAndView("ajclExcelView", "ajclList", ajclList);
    }
	
	@RequestMapping(value = "/dsplb", method = RequestMethod.GET)
	public ModelAndView dsplb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-dsplb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "dsplb"));
		return mv;
	}
	@RequestMapping(value = "/ysplb", method = RequestMethod.GET)
	public ModelAndView ysplb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ysplb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ysplb"));
		return mv;
	}
	@RequestMapping(value = "/ylalb", method = RequestMethod.GET)
	public ModelAndView ylalb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	@RequestMapping(value = "/bthlb", method = RequestMethod.GET)
	public ModelAndView bthlb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-bthlb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "bthlb"));
		return mv;
	}
	
	@RequestMapping(value = "/dsplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getDsplb(){
		List<DsplbView> dsplbView = new ArrayList<DsplbView>();
		List<TJxjs> jxjsList = jxjsService.getDsplb();
		for(TJxjs jxjs:jxjsList){
			DsplbView vo = new DsplbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if(dsr != null)
				vo.setDsr(dsr.getXm());
			vo.setSqcs(jxjs.getSqcs());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(),DateUtil.webFormat));
			dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if(dmb != null)
				vo.setSxfy(dmb.getDmms());			
			vo.setYsah(jxjs.getSxah());
			dsplbView.add(vo);
			
		}
		return dsplbView;
	}
	
	@RequestMapping(value = "/ysplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYsplb(){		
		List<YsplbView> ysplbView = new ArrayList<YsplbView>();
		List<TJxjs> jxjsList = jxjsService.getYsplb();
		for(TJxjs jxjs:jxjsList){
			YsplbView vo = new YsplbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if(dsr != null)
				vo.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if(dmb != null)
				vo.setSxfy(dmb.getDmms());			
			vo.setYsah(jxjs.getSxah());
			List<TSpxx> spxxList = spxxService.getSPxxByJxjsbh(jxjs.getJxjsbh());
			if(spxxList != null && spxxList.size()>0){
				TSpxx spxx = spxxList.get(spxxList.size() - 1);
				vo.setSpsj(DateUtil.format(spxx.getSpsj(), DateUtil.webFormat));
			}
			ysplbView.add(vo);
			
		}
		return ysplbView;
	}
	@RequestMapping(value = "/ylalb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYlalb(){
		List<YlalbView> ylalbView = new ArrayList<YlalbView>();
		List<TJxjs> jxjsList = jxjsService.getYlalb();
		for(TJxjs jxjs:jxjsList){
			YlalbView vo = new YlalbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			PubAjJb aj = ajService.getAjByAjxh(jxjs.getLaajxh());
			vo.setAh(aj.getAh());
			vo.setAjmc(aj.getAjmc());
			vo.setLasj(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			ylalbView.add(vo);
			
		}
		return ylalbView;
	}
	@RequestMapping(value = "/bthlb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getBthlb(){
		List<BthlbView> bthlbView = new ArrayList<BthlbView>();
		List<TJxjs> jxjsList = jxjsService.getBthlb();
		for(TJxjs jxjs:jxjsList){
			BthlbView vo = new BthlbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if(dsr != null)
				vo.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if(dmb != null)
				vo.setSxfy(dmb.getDmms());			
			vo.setYsah(jxjs.getSxah());
			List<TSpxx> spxxList = spxxService.getSPxxByJxjsbh(jxjs.getJxjsbh());
			if(spxxList != null && spxxList.size()>0){
				TSpxx spxx = spxxList.get(spxxList.size() - 1);
				vo.setThsj(DateUtil.format(spxx.getSpsj(), DateUtil.webFormat));
			}
			bthlbView.add(vo);
			
		}
		return bthlbView;
	}
	
	//立案
	@RequestMapping(value = "/la", method = RequestMethod.GET)
	@ResponseBody
	public Object la(@RequestParam("jxjsbhList") String jxjsbhList){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String[] bhList = jxjsbhList.split(",");
		int jxjsbh;
		for(String bh:bhList){
			jxjsbh = Integer.valueOf(bh);
			TJxjs jxjs = jxjsService.getJxjsBybh(jxjsbh);
			PubAjJb aj = new PubAjJb();
			String spcx;
			aj.setBafy(Constants.BAFY);
			String ajxz=Constants.AJXZ;
			aj.setAjxz(Constants.AJXZ);
			if(jxjs.getSqlxbh().equals("1"))
			{
				aj.setSpcx(Constants.JXSPCX);
				spcx=Constants.JXSPCX;
			}
			else
			{
				aj.setSpcx(Constants.JSSPCX);
				spcx=Constants.JSSPCX;
			}
			aj.setSpcxdz(Constants.SPCXDZ);
			//需要特殊处理，还有撤销假释的
//			aj.setBycxdz(bycxdz);
			String ajly=Constants.AJLY;
			aj.setAjly(Constants.AJLY);
			aj.setSycx(Constants.SYCX);
			String ah = ajService.generateAh();
			aj.setAh(ah);
			aj.setAjmc("");

			aj.setAjzt(null);

			//aj.setFhcsyy(fhcsyy);
			
//			aj.setFjsx(fjsx);

	
			//,,/aj.setGksjg(gksjg);
		
			aj.setJyaq(null);

			aj.setLar(user.getUsername());
			java.util.Date larq = new java.util.Date();
			aj.setLarq(larq);
			PubDmb pub= dmbService.getDmbByLbbhAndDmbh("系统缺省","来源地区");
			String lydq=pub.getDmms();
			aj.setLydq(lydq);
//			aj.setPsycy();
//			aj.setSffhcs(sffhcs);
//			aj.setSfgs(sfgs);
			aj.setSfjbaj("N");
			//aj.setSfxess(sfxess);
			//aj.setSfys(sfys);
			aj.setSfzdaj("N");
			//aj.setSfzscq(sfzscq);
			//aj.setSlqk(slqk);
			//aj.setSpzsqrq(spzsqrq);
			String sslx = "4";
			if(spcx=="2"){
				switch(ajxz){
							case "1":
								if(ajly=="13"||ajly=="14"||ajly == "23"){ sslx = "2";}
								break;
							case "2":
								if(ajly == "102"){sslx = "2";}
								if(ajly == "103"){sslx = "1";}
								if(ajly == "104"){sslx ="3";}
								break;
							case "6":
								if(ajly == "101"){ sslx = "2";}
								if(ajly == "103"){ sslx = "1";}
								break;
								}
			}
			aj.setSslx(sslx);
		
			//aj.setSwlx(swlx);
//			aj.setSx(sx);

//			aj.setTzhyj(null);
			//aj.setTzsqrq(tzsqrq);
//			aj.setYzhyj(null);
			//aj.setYzqfrq(yzqfrq);
			//aj.setYzsqrq(yzsqrq);
			aj = ajService.add(aj);
			
			//DSR_JB 
			TDsr dsr=dsrService.getDsrByjxjsbh(jxjsbh);
			DsrJb dsrjb=new DsrJb();
			dsrjb.setAjxh(aj.getAjxh());
			dsrjb.setDsrbh(dsr.getDsrbh());
			//dsrjb.setDsrssdw(dsr.getds);
			//dsrjb.setDsrlb(dsr.getd);
			//dsrjb.setSfssdbr(dsr.gets);
			//dsrjb.setSfsa(dsr.gets);
			//dsrjb.setSfsg(dsr.gets);
			//dsrjb.setSfsq(dsr.getsfs);
			//dsrjb.setSfst(dsr.getsfs);
			//dsrjb.setSfsw(dsr.getsfs);
			
			
			//DSR_GR(T_DSR)
			DsrGr dsrgr=new DsrGr();
			dsrgr.setAjxh(aj.getAjxh());
			dsrgr.setDsrbh(dsr.getDsrbh());
			dsrgr.setCsnyr(dsr.getCsnyr());
			dsrgr.setDh(dsr.getDh());
			dsrgr.setDz(dsr.getDz());
			dsrgr.setGzdw(dsr.getGzdw());
			//dsrgr.setHyqk(dsr.geth);
			dsrgr.setJb(dsr.getJb());
			dsrgr.setJg(dsr.getJg());
			//dsrgr.setJkqk(dsr.getjk);
			//dsrgr.setJtqk(dsr.getjt);
			dsrgr.setMz(dsr.getMz());
			dsrgr.setSf(dsr.getSf());
			dsrgr.setSfzhm(dsr.getSfzhm());
			dsrgr.setSsgj(dsr.getSsgj());
			dsrgr.setWhcd(dsr.getWhcd());
			dsrgr.setXm(dsr.getXm());
			dsrgr.setXb(dsr.getXb());
			dsrgr.setYb(dsr.getYb());
			dsrgr.setZw(dsr.getZw());
			//dsrgr.setZy(dsr.getzy);
			//dsrgr.setZzmm(dsr.zz);
//			int ajxh_gr=Integer.parseInt(request.getParameter("id"));
//			int dsrbh_gr=Integer.parseInt(request.getParameter("dsrbh"));
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	//审批
	@RequestMapping(value = "/approval", method = RequestMethod.POST)
	@ResponseBody
	public Object approval(@RequestParam("jxjsbhList") String jxjsbhList,@RequestParam("spyj") String spyj,
			@RequestParam("spsj") String spsj){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String spr = user.getUsername();
		Date dSpsj = DateUtil.parse(spsj, DateUtil.webFormat);
		jxjsService.approval(jxjsbhList, spr, spyj, dSpsj);		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	//退回

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	@ResponseBody
	public Object reject(@RequestParam("jxjsbhList") String jxjsbhList,@RequestParam("spyj") String spyj,
			@RequestParam("spsj") String spsj){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String spr = user.getUsername();
		Date dSpsj = DateUtil.parse(spsj, DateUtil.webFormat);
		jxjsService.reject(jxjsbhList, spr, spyj, dSpsj);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
}
