package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;
import nju.software.jxjs.service.SpxxService;
import nju.software.jxjs.service.TDsrService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.JccxView;
import nju.software.jxjs.view.TjfxResultModel;
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
	private JxjsService jxjsService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private TDsrService dsrService;

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
		List<PubDmb> dmbList = dmbService.getDmbByLbbh("JXJS-AJZT");
		List<String> conditionList = new ArrayList<String>();
		for(PubDmb dmb:dmbList){
			conditionList.add(dmb.getDmms());
		}
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
	public ModelAndView sjtj(@RequestParam("kssj") String kssj,
			@RequestParam("jssj") String jssj)
	{
		Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
		Date end = DateUtil.parse(jssj, DateUtil.webFormat);
		List<PubDmb> ajztDmb = dmbService.getDmbByLbbh("JXJS-AJZT");
		List<TjfxResultModel> resultList = new ArrayList<TjfxResultModel>();
		int sz;
		for(PubDmb dmb:ajztDmb){
//			TjfxResultModel result = new TjfxResultModel();
//			result.setS_type(dmb.getDmms());
//			sz = jxjsService.getSumByDateAndType(kssj, jssj, type)
//			result.setI_sz(i_sz);
		}
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
	@ResponseBody
	public Object cx(@ModelAttribute("model")TjfxSearchModel model)
	{
		logger.info("start date:" + model.getStartDate() + "  end date:" + model.getEndDate() + "  condition:" + model.getCondition());
		List<PubDmb> dmbList = dmbService.getDmbByLbbh("JXJS-AJZT");
		List<String> conditionList = new ArrayList<String>();
		for(PubDmb dmb:dmbList){
			conditionList.add(dmb.getDmms());
		}
		Date begin = model.getStartDate();
		Date end = model.getEndDate();
		String type = model.getCondition();
		List<TJxjs> jxjsList = jxjsService.getJxjsByDateAndType(begin, end, type);
		List<JccxView> jccxList = new ArrayList<JccxView>();
		for(TJxjs jxjs:jxjsList){
			JccxView jv = new JccxView();
			jv.setYsah(jxjs.getSxah());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if(dsr != null)
				jv.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				jv.setSqlx(dmb.getDmms());
			jv.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if(dmb != null)
				jv.setSxfy(dmb.getDmms());			
			jv.setSqsj(DateUtil.format(jxjs.getSqsj(), DateUtil.webFormat));
			jv.setSqcs(jxjs.getSqcs());
			
		}
		return jxjsList;
	}
}
