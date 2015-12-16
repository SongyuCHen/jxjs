package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.jxjs.logic.XtglLogic;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TLog;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.LogService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.UserService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.LogView;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/xtgl")
public class XtglController extends BaseController {
	@Autowired
	private MenuService ms;
	
	@Autowired
	private XtglLogic xl;
	/**
	 * 日志管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rzgl", method = RequestMethod.GET)
	public ModelAndView rzgl()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xtgl-rzgl");
		
		mav.addObject("conditionList", xl.rzgl());
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtgl", "rzgl"));
		return mav;
	}
	//日志查询
	@RequestMapping(value = "/rzcx", method = RequestMethod.POST)
	@ResponseBody
	public Object rzcx(@RequestParam("kssj") String kssj,@RequestParam("jssj") String jssj,
			@RequestParam("condition") String type){
		return xl.rzcx(kssj, jssj, type);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/exportRzglExcel", method = RequestMethod.GET)
    public ModelAndView exportRzglExcel(HttpServletRequest request, HttpServletResponse response) 
	{
		String kssj = request.getParameter("kssj");
		String jssj = request.getParameter("jssj");
		String czlx = request.getParameter("czlx");
		
		logger.info("export excel for rzgl. parameters-kssj:" + kssj + ",jssj:" + jssj + ",czlx:" + czlx);
		List<LogView> logList;
		if(kssj != null && jssj != null && czlx != null)
		{
			logList = (List<LogView>)rzcx(kssj, jssj, czlx);
		}
		else
		{
			logList = new ArrayList<LogView>();
		}
		
        return new ModelAndView("rzglExcelView", "logList", logList);
    }
}
