package nju.software.jxjs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.jxjs.common.Constants;
import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.model.TSpxx;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.MenuService;




import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.service.SpxxService;
import nju.software.jxjs.service.TDsrService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.DsplbView;
import nju.software.jxjs.view.YlalbView;
import nju.software.jxjs.view.YsplbView;

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
	@Autowired
	private TDsrService dsrService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private SpxxService spxxService;
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
		List<DsplbView> dsplbView = new ArrayList<DsplbView>();
		List<TJxjs> jxjsList = jxjsService.getDsplb();
		for(TJxjs jxjs:jxjsList){
			DsplbView vo = new DsplbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if(dsr != null)
				vo.setDsr(dsr.getXm());
			vo.setSqcs(jxjs.getSqcs());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.getStandardFormat(jxjs.getSqsj()));
			dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if(dmb != null)
				vo.setSxfy(dmb.getDmms());			
			vo.setYsah(jxjs.getSxah());
			dsplbView.add(vo);
			
		}
		return dsplbView;
	}
	
	@RequestMapping(value = "/ysplb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYsplb(){		
		List<YsplbView> ysplbView = new ArrayList<YsplbView>();
		List<TJxjs> jxjsList = jxjsService.getYsplb();
		for(TJxjs jxjs:jxjsList){
			YsplbView vo = new YsplbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			TDsr dsr = dsrService.getDsrByjxjsbh(jxjs.getJxjsbh());
			if(dsr != null)
				vo.setDsr(dsr.getXm());
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setSqsj(DateUtil.getStandardFormat(jxjs.getSqsj()));
			dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", jxjs.getSxfybh());
			if(dmb != null)
				vo.setSxfy(dmb.getDmms());			
			vo.setYsah(jxjs.getSxah());
			List<TSpxx> spxxList = spxxService.getSPxxByJxjsbh(jxjs.getJxjsbh());
			if(spxxList != null && spxxList.size()>0){
				TSpxx spxx = spxxList.get(spxxList.size() - 1);
				vo.setSpsj(DateUtil.getStandardFormat(spxx.getSpsj()));
			}
			ysplbView.add(vo);
			
		}
		return ysplbView;
	}
	@RequestMapping(value = "/ylalb.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getYlalb(){
		List<YlalbView> ylalbView = new ArrayList<YlalbView>();
		List<TJxjs> jxjsList = jxjsService.getYlalb();
		for(TJxjs jxjs:jxjsList){
			YlalbView vo = new YlalbView();
			vo.setJxjsbh(jxjs.getJxjsbh());
			PubAjJb aj = ajService.getAjByAjxh(jxjs.getLaajxh());
			vo.setAh(aj.getAh());
			vo.setAjmc(aj.getAjmc());
			vo.setLasj(DateUtil.getStandardFormat(aj.getLarq()));
			PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("JXJS-SQLX", jxjs.getSqlxbh());
			if(dmb != null)
				vo.setSqlx(dmb.getDmms());
			vo.setYsah(jxjs.getSxah());
			ylalbView.add(vo);
			
		}
		return ylalbView;
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
		aj.setSycx(Constants.SYCX);
		String ah = ajService.generateAh();
		aj.setAh(ah);
		
		//DSR_JB DSR_GR(T_DSR)
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
