package nju.software.jxjs.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.PubLaAy;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.PubAjJbService;
import nju.software.jxjs.service.PubLaAyService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.util.StringUtil;
import nju.software.jxjs.view.JxjsApplyView;
import nju.software.jxjs.view.User;
import nju.software.jxjs.view.XsajcsView;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Component
public class XtdjLogic {
	@Autowired
	private PubAjJbService ajService;
	@Autowired
	private PubLaAyService ayService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private JxjsService jxjsService;
	
	
	public Object getInfoForApply(String ajxh){
		int i_ajxh = Integer.valueOf(ajxh);
		JxjsApplyView view = ajService.getApplyByAjxh(i_ajxh);
		return view;
	}
	
	public void apply(String ajxh,String dsr,String sqlx,String sqsj,String sqkssj,String sqjssj){
		int i_ajxh = Integer.valueOf(ajxh);
		Date d_sqsj = DateUtil.parse(sqsj, DateUtil.webFormat);
		Date d_sqkssj = DateUtil.parse(sqkssj, DateUtil.webFormat);
		Date d_sqjssj = DateUtil.parse(sqjssj, DateUtil.webFormat);
		jxjsService.addJxjsByAjxhDsr(i_ajxh, dsr, sqlx,d_sqsj,d_sqkssj,d_sqjssj);
	}
	
	public Object transport(String ajxhList){
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String csr = user.getUsername();
		Date cssj = new Date();
		int sum = 0;
		sum = ajService.addXsajTrans(ajxhList, csr, cssj);
		Integer result = sum;
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("xtdj-jajgfk");
//		mav.addObject("menuWrapper", ms.makeMenu(user.getRole(), "xtdj", "jajgfk"));
		return result;
	}
	
	
	public Object searchByDateOrAh(String ah,String kssj,String jssj){
		List<XsajcsView> ajcsView = new ArrayList<XsajcsView>();
		List<PubAjJb> ajList = new ArrayList<PubAjJb>();
		if(!StringUtil.isBlank(ah)){
			PubAjJb aj = ajService.getXsajByAh(ah);
			ajList.add(aj);
		}else{
			if(!StringUtil.isBlank(kssj) && !StringUtil.isAlpha(jssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getXsajByDate(begin, end);
			}else if(!StringUtil.isBlank(kssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				ajList = ajService.getXsajAfterDate(begin);
			}else if(!StringUtil.isBlank(jssj)){
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getXsajBeforeDate(end);
			}
			
		}
		for(PubAjJb aj:ajList){
			XsajcsView view = new XsajcsView();
			view.setAjxh(aj.getAjxh());
			view.setAh(aj.getAh());
			view.setAjmc(aj.getAjmc());
			PubLaAy ay = ayService.getAyByAjxh(aj.getAjxh());
			if(ay!=null)
				view.setAy(ay.getLaay());
			if(!StringUtil.isBlank(aj.getBafy())){
				PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", aj.getBafy().trim());
				view.setBafy(dmb.getDmms());
			}
			view.setLarq(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			view.setJarq(DateUtil.format(aj.getJarq(), DateUtil.webFormat));
			ajcsView.add(view);
		}
		
		return ajcsView;
	}
	
	
	public Object getcsajlb(String ah,@RequestParam("dsr") String dsr,String kssj,String jssj){
		List<XsajcsView> ajcsView = new ArrayList<XsajcsView>();
		List<PubAjJb> ajList = new ArrayList<PubAjJb>();
		if(!StringUtil.isBlank(ah)){
			PubAjJb aj = ajService.getXsajByAh(ah);
			ajList.add(aj);
		}else if(!StringUtil.isBlank(dsr)){
			ajList = ajService.getXsajByDsr(dsr);
		}else{

			if(!StringUtil.isBlank(kssj) && !StringUtil.isAlpha(jssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getCsajByDate(begin, end);
			}else if(!StringUtil.isBlank(kssj)){
				Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
				ajList = ajService.getCsajAfterDate(begin);
			}else if(!StringUtil.isBlank(jssj)){
				Date end = DateUtil.parse(jssj, DateUtil.webFormat);
				ajList = ajService.getCasjBeforeDate(end);
			}
			
		}
		for(PubAjJb aj:ajList){
			XsajcsView view = new XsajcsView();
			view.setAjxh(aj.getAjxh());
			view.setAh(aj.getAh());
			view.setAjmc(aj.getAjmc());
			PubLaAy ay = ayService.getAyByAjxh(aj.getAjxh());
			if(ay!=null)
				view.setAy(ay.getLaay());
			if(!StringUtil.isBlank(aj.getBafy())){
				PubDmb dmb = dmbService.getDmbByLbbhAndDmbh("FBZ0001-97", aj.getBafy().trim());
				view.setBafy(dmb.getDmms());
			}
			view.setLarq(DateUtil.format(aj.getLarq(), DateUtil.webFormat));
			view.setJarq(DateUtil.format(aj.getJarq(), DateUtil.webFormat));
			ajcsView.add(view);
		}
		
		return ajcsView;
	}
}
