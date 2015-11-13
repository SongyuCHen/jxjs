package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.List;

import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TLog;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.LogService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.LogView;
import nju.software.jxjs.view.User;

@Controller
@RequestMapping("/xtgl")
public class XtglController extends BaseController {
	@Autowired
	private MenuService ms;
	@Autowired
	private LogService logService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private UserService userService;
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
		List<PubDmb> dmbList = dmbService.getDmbByLbbh("JXJS-LOGTYPE");
		List<String> conditionList = new ArrayList<String>();
		for(PubDmb dmb:dmbList){
			conditionList.add(dmb.getDmms());
		}
		mav.addObject("conditionList", conditionList);
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtgl", "rzgl"));
		return mav;
	}
	//日志查询
	@RequestMapping(value = "/rzcx", method = RequestMethod.POST)
	@ResponseBody
	public Object rzcx(@RequestParam("kssj") String kssj,@RequestParam("jssj") String jssj,
			@RequestParam("condition") String type){
		List<LogView> views = new ArrayList<LogView>();
		String logType = null;
		PubDmb dmb = dmbService.getDmbByLbbhAndDmms("JXJS-LOGTYPE", type);
		if(dmb!=null)
			logType = dmb.getDmbh();
		List<TLog> logs = logService.getLogByDateAndType(kssj, jssj, logType);
		for(TLog log:logs){
			LogView vo = new LogView();
			dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-LOGTYPE", log.getType());
			vo.setType(dmb.getDmms());
			vo.setCzsj(DateUtil.format(log.getCzsj(), DateUtil.webFormat));
			vo.setCzip(log.getCzip());
			vo.setBz(log.getBz());
			if(log.getType().equals("6"))//监狱用户只有申请，其余的操作都是法院用户
				vo.setCzr(userService.getUserById(log.getRybh()).getUsername());
			else
				vo.setCzr(userService.getYhbById(log.getRybh()).getYhmc());
			views.add(vo);
		}
		return views;
	}

}
