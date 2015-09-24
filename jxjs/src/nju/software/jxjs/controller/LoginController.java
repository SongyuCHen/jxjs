package nju.software.jxjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/login")
	public String login() {
		return "ajcl_dsplb";
	}
	
	
	@RequestMapping(value = "/login2")
	public ModelAndView login2(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl_dsplb");
		mv.addObject("name", "saber");
		return mv;
	}
	
	@RequestMapping(value = "/shiro/test")
	public String testShiro(){
		return "shirotest";
	}
}
