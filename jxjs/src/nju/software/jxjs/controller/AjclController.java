package nju.software.jxjs.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import nju.software.jxjs.logic.AjclLogic;

import nju.software.jxjs.service.MenuService;





import nju.software.jxjs.view.BthlbView;
import nju.software.jxjs.view.DsplbView;

import nju.software.jxjs.view.YlalbView;
import nju.software.jxjs.view.YsplbView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ajcl")
public class AjclController extends BaseController
{
	
	@Autowired
	private MenuService ms;
	
	@Autowired
	private AjclLogic al;
	
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
	@RequestMapping(value = "/bthlb", method = RequestMethod.GET)
	public ModelAndView bthlb(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-bthlb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "bthlb"));
		return mv;
	}
	
	@RequestMapping(value = "/dsplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getDsplb(){
		
		return al.getDsplb();
	}
	
	@RequestMapping(value = "/ysplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYsplb(){		
		return al.getYsplb();
	}
	@RequestMapping(value = "/ylalb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYlalb(){
		return al.getYlalb();
	}
	@RequestMapping(value = "/bthlb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getBthlb(){
		return al.getBthlb();
	}
	
	//立案
	@RequestMapping(value = "/la", method = RequestMethod.GET)
	@ResponseBody
	public Object la(@RequestParam("jxjsbhList") String jxjsbhList){
		al.la(jxjsbhList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	//审批
	@RequestMapping(value = "/approval", method = RequestMethod.POST)
	@ResponseBody
	public Object approval(@RequestParam("jxjsbhList") String jxjsbhList,@RequestParam("spyj") String spyj,
			@RequestParam("spsj") String spsj){
		al.approval(jxjsbhList, spyj, spsj);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	//退回

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	@ResponseBody
	public Object reject(@RequestParam("jxjsbhList") String jxjsbhList,@RequestParam("spyj") String spyj,
			@RequestParam("spsj") String spsj){
		al.reject(jxjsbhList, spyj, spsj);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/exportBthlbExcel", method = RequestMethod.GET)
    public ModelAndView exportBthlbExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("export excel for ajcl bthlb");
		
		List<BthlbView> bthlbList = (List<BthlbView>)getBthlb();
		
        return new ModelAndView("bthlbExcelView", "bthlbList", bthlbList);
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/exportDsplbExcel", method = RequestMethod.GET)
    public ModelAndView exportDsplbExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("export excel for ajcl dsplb");
		
		List<DsplbView> dsplbList = (List<DsplbView>)getDsplb();
		
        return new ModelAndView("dsplbExcelView", "dsplbList", dsplbList);
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/exportYlalbExcel", method = RequestMethod.GET)
    public ModelAndView exportYlalbExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("export excel for ajcl ylalb");
		
		List<YlalbView> ylalbList = (List<YlalbView>)getDsplb();
		
        return new ModelAndView("ylalbExcelView", "ylalbList", ylalbList);
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/exportYsplbExcel", method = RequestMethod.GET)
    public ModelAndView exportYsplbExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		logger.info("export excel for ajcl ysplb");
		
		List<YsplbView> ysplbList = (List<YsplbView>)getYsplb();
		
        return new ModelAndView("ysplbExcelView", "ysplbList", ysplbList);
    }
}
