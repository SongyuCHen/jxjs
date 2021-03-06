package nju.software.jxjs.controller;

import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.UserService;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
	public ModelAndView login(@ModelAttribute("user") User user) {
		logger.info("@@@@@@@@"+user.getUsername()+","+user.getPassword());
		boolean success = us.tr_signIn(user);
		ModelAndView mv = new ModelAndView();
		if(success){
			Subject subject = SecurityUtils.getSubject();
			if(subject.hasRole("fayuan")){
				mv.setViewName("ajcl-dsplb");
				mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "dsplb"));
			}else if(subject.hasRole("jianyu")){
				mv.setViewName("xtdj-jxjssq");
				mv.addObject("menuWrapper", ms.makeMenu("jianyu", "xtdj", "jxjssq"));
			}
			
		}else{
			mv.setViewName("index");
			mv.addObject("errorMsg","单位/用户名/密码错误，请重新输入");
		}
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
