package nju.software.jxjs.controller;

import nju.software.jxjs.service.MenuService;

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
		mav.addObject("menuWrapper", ms.makeMenu("fayuan", "xtdj", "xsajcs"));
		return mav;
	}

}
