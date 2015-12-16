package nju.software.jxjs.logic;

import java.util.ArrayList;
import java.util.List;

import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TLog;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.LogService;
import nju.software.jxjs.service.UserService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.LogView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class XtglLogic {
	@Autowired
	private LogService logService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private UserService userService;
	
	
	public List<String> rzgl(){
		List<PubDmb> dmbList = dmbService.getDmbByLbbh("JXJS-LOGTYPE");
		List<String> conditionList = new ArrayList<String>();
		for(PubDmb dmb:dmbList){
			conditionList.add(dmb.getDmms());
		}
		return conditionList;
	}
	
	
	public Object rzcx(String kssj,String jssj,String type){
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
