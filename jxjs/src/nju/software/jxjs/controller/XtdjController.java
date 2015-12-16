package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.logic.XtdjLogic;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubLaAy;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.service.PubLaAyService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.util.StringUtil;
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
	private XtdjLogic xl;
	
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
		return xl.getInfoForApply(ajxh);
	}
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@ResponseBody
	public Object apply(@RequestParam("ajxh") String ajxh,@RequestParam("dsr") String dsr,
			@RequestParam("sqlx") String sqlx,@RequestParam("sqsj") String sqsj,
			@RequestParam("sqkssj") String sqkssj,@RequestParam("sqjssj") String sqjssj){
		xl.apply(ajxh, dsr, sqlx, sqsj, sqkssj, sqjssj);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-jxjssq");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "jxjssq"));
		return mav;
	}
	
	@RequestMapping(value = "/xsajcs/transport", method = RequestMethod.POST)
	@ResponseBody
	public Object transport(@RequestParam("ajxhList") String ajxhList){
		return xl.transport(ajxhList);
	}
	
	@RequestMapping(value = "/xsajcs/search", method = RequestMethod.GET)
	@ResponseBody
	public Object searchByDateOrAh(@RequestParam("ah") String ah,@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj){
		return xl.searchByDateOrAh(ah, kssj, jssj);
	}
	
	
	@RequestMapping(value = "/jxjssq.json", method = RequestMethod.POST)
	@ResponseBody
	public Object getcsajlb(@RequestParam("ah") String ah,@RequestParam("dsr") String dsr,@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj){
		return xl.getcsajlb(ah, dsr, kssj, jssj);
	}

	
	@RequestMapping(value = "/jajgfk.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getJajgfk(){
		List<JajgfkView> jvList = new ArrayList<JajgfkView>();
		return jvList;
	}
}
