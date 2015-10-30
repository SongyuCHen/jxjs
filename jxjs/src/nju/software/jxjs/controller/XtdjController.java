package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.util.StringUtil;
import nju.software.jxjs.view.User;
import nju.software.jxjs.view.XsajcsView;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/xtdj")
public class XtdjController extends BaseController
{
	@Autowired
	private MenuService ms;
	@Autowired
	private PubAjJbService ajService;
	
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
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchByDateOrAh(@RequestParam("ah") String ah,@RequestParam("kssj") String kssj,
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
			view.setAh(aj.getAh());
			view.setAjmc(aj.getAjmc());
//			ayService.
//			view.setAy();
//			view.setBafy(bafy);
			view.setLarq(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			view.setJarq(DateUtil.format(aj.getJarq(), DateUtil.webFormat));
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-xsajcs");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "xsajcs"));
		return mav;
	}

}
