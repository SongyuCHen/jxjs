package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubLaAy;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.service.PubLaAyService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.util.StringUtil;
import nju.software.jxjs.view.BthlbView;
import nju.software.jxjs.view.JajgfkView;
import nju.software.jxjs.view.JxjsApplyView;
import nju.software.jxjs.view.User;
import nju.software.jxjs.view.XsajcsView;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/xtdj")
public class XtdjController extends BaseController
{
	@Autowired
	private MenuService ms;
	@Autowired
	private PubAjJbService ajService;
	@Autowired
	private PubLaAyService ayService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private JxjsService jxjsService;
	@RequestMapping(value = "/xsajcs", method = RequestMethod.GET)
	public ModelAndView xsajcs(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-xsajcs");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "xsajcs"));
		return mav;
	}
	@RequestMapping(value = "/jxjssq", method = RequestMethod.GET)
	public ModelAndView jxjssq(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-jxjssq");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "jxjssq"));
		return mav;
	}
	@RequestMapping(value = "/jajgfk", method = RequestMethod.GET)
	public ModelAndView jajgfk(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-jajgfk");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "jajgfk"));
		return mav;
	}
	@RequestMapping(value = "/getInfoForApply", method = RequestMethod.POST)
	@ResponseBody
	public Object getInfoForApply(@RequestParam("ajxh") String ajxh){
		int i_ajxh = Integer.valueOf(ajxh);
		JxjsApplyView view = ajService.getApplyByAjxh(i_ajxh);
		return view;
	}
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@ResponseBody
	public Object apply(@RequestParam("ajxh") String ajxh,@RequestParam("dsr") String dsr,
			@RequestParam("sqlx") String sqlx,@RequestParam("sqsj") String sqsj,
			@RequestParam("sqkssj") String sqkssj,@RequestParam("sqjssj") String sqjssj){
		int i_ajxh = Integer.valueOf(ajxh);
		Date d_sqsj = DateUtil.parse(sqsj, DateUtil.webFormat);
		Date d_sqkssj = DateUtil.parse(sqkssj, DateUtil.webFormat);
		Date d_sqjssj = DateUtil.parse(sqjssj, DateUtil.webFormat);
		jxjsService.addJxjsByAjxhDsr(i_ajxh, dsr, sqlx,d_sqsj,d_sqkssj,d_sqjssj);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-jxjssq");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "jxjssq"));
		return mav;
	}
	
	@RequestMapping(value = "/xsajcs/transport", method = RequestMethod.POST)
	@ResponseBody
	public Object transport(@RequestParam("ajxhList") String ajxhList){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String csr = user.getUsername();
		Date cssj = new Date();
		int sum = ajService.addXsajTrans(ajxhList, csr, cssj);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("xtdj-jajgfk");
//		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "jajgfk"));
		return sum;
	}
	
	@RequestMapping(value = "/xsajcs/search", method = RequestMethod.GET)
	@ResponseBody
	public Object searchByDateOrAh(@RequestParam("ah") String ah,@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj){
		List<XsajcsView> ajcsView = new ArrayList<XsajcsView>();
		List<PubAjJb> ajList = new ArrayList<PubAjJb>();
		if(!StringUtil.isBlank(ah)){
			PubAjJb aj = ajService.getXsajByAh(ah);
			ajList.add(aj);
		}else{
			if(!StringUtil.isBlank(kssj) && !StringUtil.isAlpha(jssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getXsajByDate(begin, end);
			}else if(!StringUtil.isBlank(kssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				ajList = ajService.getXsajAfterDate(begin);
			}else if(!StringUtil.isBlank(jssj)){
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getXsajBeforeDate(end);
			}
			
		}
		for(PubAjJb aj:ajList){
			XsajcsView view = new XsajcsView();
			view.setAjxh(aj.getAjxh());
			view.setAh(aj.getAh());
			view.setAjmc(aj.getAjmc());
			PubLaAy ay = ayService.getAyByAjxh(aj.getAjxh());
			if(ay!=null)
				view.setAy(ay.getLaay());
			if(!StringUtil.isBlank(aj.getBafy())){
				PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", aj.getBafy().trim());
				view.setBafy(dmb.getDmms());
			}
			view.setLarq(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			view.setJarq(DateUtil.format(aj.getJarq(), DateUtil.webFormat));
			ajcsView.add(view);
		}
		
		return ajcsView;
	}
	
	
	@RequestMapping(value = "/jxjssq.json", method = RequestMethod.POST)
	@ResponseBody
	public Object getcsajlb(@RequestParam("ah") String ah,@RequestParam("dsr") String dsr,@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj){
		List<XsajcsView> ajcsView = new ArrayList<XsajcsView>();
		List<PubAjJb> ajList = new ArrayList<PubAjJb>();
		if(!StringUtil.isBlank(ah)){
			PubAjJb aj = ajService.getXsajByAh(ah);
			ajList.add(aj);
		}else if(!StringUtil.isBlank(dsr)){
			ajList = ajService.getXsajByDsr(dsr);
		}else{

			if(!StringUtil.isBlank(kssj) && !StringUtil.isAlpha(jssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getXsajByDate(begin, end);
			}else if(!StringUtil.isBlank(kssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				ajList = ajService.getXsajAfterDate(begin);
			}else if(!StringUtil.isBlank(jssj)){
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getXsajBeforeDate(end);
			}
			
		}
		for(PubAjJb aj:ajList){
			XsajcsView view = new XsajcsView();
			view.setAjxh(aj.getAjxh());
			view.setAh(aj.getAh());
			view.setAjmc(aj.getAjmc());
			PubLaAy ay = ayService.getAyByAjxh(aj.getAjxh());
			if(ay!=null)
				view.setAy(ay.getLaay());
			if(!StringUtil.isBlank(aj.getBafy())){
				PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", aj.getBafy().trim());
				view.setBafy(dmb.getDmms());
			}
			view.setLarq(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			view.setJarq(DateUtil.format(aj.getJarq(), DateUtil.webFormat));
			ajcsView.add(view);
		}
		
		return ajcsView;
	}

	
	@RequestMapping(value = "/jajgfk.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getJajgfk(){
		List<JajgfkView> jvList = new ArrayList<JajgfkView>();
		return jvList;
	}
}
