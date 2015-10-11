package nju.software.jxjs.controller;

import java.util.Arrays;
import java.util.List;

import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.view.TjfxSearchModel;

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
		mav.addObject("menuWrapper", ms.makeMenu("fayuan", "tjfx", "jccx"));
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
		mav.addObject("menuWrapper", ms.makeMenu("fayuan", "tjfx", "sjtj"));
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
		mav.addObject("menuWrapper", ms.makeMenu("fayuan", "tjfx", "tjfx-ylalb"));
		return mav;
	}
	
	@RequestMapping(value = "/cx", method = RequestMethod.POST)
	public ModelAndView cx(@ModelAttribute("model")TjfxSearchModel model)
	{
		logger.info("start date:" + model.getStartDate() + "  end date:" + model.getEndDate() + "  condition:" + model.getCondition());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tjfx-jccx");
		mav.addObject("menuWrapper", ms.makeMenu("fayuan", "tjfx", "jccx"));
		String[] conditionArr = {"申请", "已审批", "已立案", "已结案"};
		List<String> conditionList = Arrays.asList(conditionArr);
		
		mav.addObject("conditionList", conditionList);
		
		
		return mav;
	}
}
