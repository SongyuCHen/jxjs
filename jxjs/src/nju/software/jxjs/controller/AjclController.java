package nju.software.jxjs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.jxjs.common.Constants;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;




import nju.software.jxjs.service.PubAjJbService;

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
	private JxjsService jxjsService;
	
	@Autowired
	private PubAjJbService ajService;

	
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
		return jxjsService.getDsplb();
	}
	
	@RequestMapping(value = "/ysplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYsplb(){
		return jxjsService.getYsplb();
	}
	@RequestMapping(value = "/ylalb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYlalb(){
		return jxjsService.getYlalb();
	}
	
	//立案
	@RequestMapping(value = "/la", method = RequestMethod.GET)
	public ModelAndView la(){
		int jxjsbh = 0;
		TJxjs jxjs = jxjsService.getJxjsBybh(jxjsbh);
		PubAjJb aj = new PubAjJb();
		aj.setBafy(Constants.BAFY);
		aj.setAjxz(Constants.AJXZ);
		if(jxjs.getSqlxbh().equals("1"))
			aj.setSpcx(Constants.JXSPCX);
		else
			aj.setSpcx(Constants.JSSPCX);
		aj.setSpcxdz(Constants.SPCXDZ);
		//需要特殊处理，还有撤销假释的
//		aj.setBycxdz(bycxdz);
		aj.setAjly(Constants.AJLY);
		String ah = ajService.generateAh();
		aj.setAh(ah);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	//审批
	@RequestMapping(value = "/approval", method = RequestMethod.GET)
	public ModelAndView approval(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
	
	//退回

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public ModelAndView reject(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajcl-ylalb");
		mv.addObject("menuWrapper", ms.makeMenu("fayuan", "ajcl", "ylalb"));
		return mv;
	}
}
