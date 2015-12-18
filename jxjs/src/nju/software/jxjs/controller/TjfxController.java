package nju.software.jxjs.controller;


import nju.software.jxjs.logic.TjfxLogic;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.view.TjfxSearchModel;
import nju.software.jxjs.view.User;




import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tjfx")
public class TjfxController extends BaseController
{
	
	@Autowired
	private MenuService ms;
	@Autowired
	private TjfxLogic tl;
	

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
		
		mav.addObject("conditionList", tl.jccx());
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
		
		mav.addObject("conditionList", tl.sjtj());
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "tjfx", "sjtj"));
		return mav;
	}
	
	
	
	
	
	/**
	 * 数据统计-统计时间段内不同状态的减刑假释申请  图
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sjtj/graph1", method = RequestMethod.POST)
	@ResponseBody
	public Object sjtjGraph1(@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj)
	{
		return tl.sjtjGraph1(kssj, jssj);
	}
	
	/**
	 * 数据统计-统计时间段内不同状态的减刑假释申请 图
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sjtj/graph2", method = RequestMethod.POST)
	@ResponseBody
	public Object sjtjGraph2(@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj,@RequestParam("condition") String condition)
	{
		return tl.sjtjGraph2(kssj, jssj, condition);
	}
	
	/**
	 * 数据统计-统计时间段内不同状态的减刑假释申请 图
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sjtj/graph3", method = RequestMethod.POST)
	@ResponseBody
	public Object sjtjGraph3(@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj,@RequestParam("condition") String condition)
	{
		return tl.sjtjGraph3(kssj, jssj, condition);
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
	@ResponseBody
	public Object cx(@ModelAttribute("model")TjfxSearchModel model)
	{
		logger.info("start date:" + model.getStartDate() + "  end date:" + model.getEndDate() + "  condition:" + model.getCondition());
		return tl.cx(model);
	}
}
