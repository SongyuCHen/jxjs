package nju.software.jxjs.controller;

import nju.software.jxjs.model.TUser;
import nju.software.jxjs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private UserService us;
	
	
	/**
	 * login
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("user") TUser user) {
		logger.info("@@@@@@@@"+user.getUsername()+","+user.getPassword());
		boolean success = us.tr_signIn(user);
		if(success){
			return "ajcl_dsplb";
		}else{
			return "index";
		}
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
