package nju.software.jxjs.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.view.TjfxSearchModel;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tjfx")
public class TjfxController extends BaseController
{
	
	@Autowired
	private MenuService ms;
	@Autowired
	private JxjsService jxjsService;
	@Autowired
	private DmbService dmbService;
	/**
	 * 基础查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/jccx", method = RequestMethod.GET)
	public ModelAndView jccx()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tjfx-jccx");
		
		String[] conditionArr = {"申请", "已审批", "已立案", "已结案"};
		List<String> conditionList = Arrays.asList(conditionArr);
		
		mav.addObject("conditionList", conditionList);
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "tjfx", "jccx"));
		return mav;
	}
	
	/**
	 * 数据统计
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sjtj", method = RequestMethod.GET)
	public ModelAndView sjtj()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tjfx-sjtj");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "tjfx", "sjtj"));
		return mav;
	}
	
	/**
	 * 已立案列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ylalb", method = RequestMethod.GET)
	public ModelAndView ylalb()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tjfx-ylalb");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "tjfx", "tjfx-ylalb"));
		return mav;
	}
	
	@RequestMapping(value = "/cx", method = RequestMethod.POST)
	public ModelAndView cx(@ModelAttribute("model")TjfxSearchModel model)
	{
		logger.info("start date:" + model.getStartDate() + "  end date:" + model.getEndDate() + "  condition:" + model.getCondition());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tjfx-jccx");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "tjfx", "jccx"));
		String[] conditionArr = {"申请", "已审批", "已立案", "已结案"};
		List<String> conditionList = Arrays.asList(conditionArr);
		Date begin = model.getStartDate();
		Date end = model.getEndDate();
		String type = model.getCondition();
		List<TJxjs> jxjsList = jxjsService.getJxjsByDateAndType(begin, end, type);
		mav.addObject("conditionList", conditionList);
		mav.addObject("jxjsList",jxjsList);
		
		return mav;
	}
}
