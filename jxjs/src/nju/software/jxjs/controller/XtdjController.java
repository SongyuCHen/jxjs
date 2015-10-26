package nju.software.jxjs.controller;

import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/xtdj")
public class XtdjController extends BaseController
{
	@Autowired
	private MenuService ms;
	
	
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
	public ModelAndView searchByAh(){
		String ah = "";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtdj-xsajcs");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "xsajcs"));
		return mav;
	}

}
