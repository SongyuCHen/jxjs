package nju.software.jxjs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.service.DsplbService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.YlalbService;
import nju.software.jxjs.service.YsplbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ajcl")
public class AjclController extends BaseController
{
	
	@Autowired
	private MenuService ms;
	
	@Autowired
	private DsplbService dsplbService;
	
	@Autowired
	private YlalbService ylalbService;
	
	@Autowired
	private YsplbService ysplbService;

	
	/**
	 * export excel
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public ModelAndView exportExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("export excel for ajcl");
		
		List<TJxjs> ajclList = null;
		
        return new ModelAndView("ajclExcelView", "ajclList", ajclList);
    }
	
	@RequestMapping(value = "/dsplb", method = RequestMethod.GET)
	public ModelAndView dsplb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-dsplb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "dsplb"));
		return mv;
	}
	@RequestMapping(value = "/ysplb", method = RequestMethod.GET)
	public ModelAndView ysplb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ysplb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ysplb"));
		return mv;
	}
	@RequestMapping(value = "/ylalb", method = RequestMethod.GET)
	public ModelAndView ylalb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	
	@RequestMapping(value = "/dsplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getDsplb(){
		return dsplbService.getDsplb();
	}
	
	@RequestMapping(value = "/ysplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYsplb(){
		return ysplbService.getYsplb();
	}
	@RequestMapping(value = "/ylalb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYlalb(){
		return ylalbService.getYlalb();
	}
}
