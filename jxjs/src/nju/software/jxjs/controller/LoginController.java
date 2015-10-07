package nju.software.jxjs.controller;

import java.util.List;

import nju.software.jxjs.model.Menu;
import nju.software.jxjs.model.TUser;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private UserService us;
	
	@Autowired
	private MenuService ms;
	
	/**
	 * login
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(@ModelAttribute("user") TUser user) {
		logger.info("@@@@@@@@"+user.getUsername()+","+user.getPassword());
		boolean success = us.tr_signIn(user);
		String viewName = null;
		if(success){
			viewName =  "ajcl-dsplb";
		}else{
			viewName =  "index";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewName);
		mv.addObject("menuWrapper", ms.makeMenu("jianyu", "ajcl", "dsplb"));
		
		return mv;
	}
	
	
//	@RequestMapping(value = "/login2")
//	public ModelAndView login2(){
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("ajcl_dsplb");
//		mv.addObject("name", "saber");
//		return mv;
//	}
//	
//	@RequestMapping(value = "/shiro/test")
//	public String testShiro(){
//		return "shirotest";
//	}
}
