package nju.software.jxjs.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.jxjs.model.PubDmb;
import nju.software.jxjs.model.TDsr;
import nju.software.jxjs.model.TJxjs;
import nju.software.jxjs.service.DmbService;
import nju.software.jxjs.service.JxjsService;
import nju.software.jxjs.service.TDsrService;
import nju.software.jxjs.util.DateUtil;
import nju.software.jxjs.view.JccxView;
import nju.software.jxjs.view.TjfxResultModel;
import nju.software.jxjs.view.TjfxSearchModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class TjfxLogic {
	@Autowired
	private JxjsService jxjsService;
	@Autowired
	private DmbService dmbService;
	@Autowired
	private TDsrService dsrService;
	
	
	public List<String> jccx(){
		List<String> conditionList = new ArrayList<String>();
		List<PubDmb> dmbList = dmbService.getDmbByLbbh("JXJS-AJZT");
		
		for(PubDmb dmb:dmbList){
			conditionList.add(dmb.getDmms());
		}
		return conditionList;
	}
	
	public List<String> sjtj(){
		List<PubDmb> dmbList = dmbService.getDmbByLbbh("JXJS-SQLX");
		List<String> conditionList = new ArrayList<String>();
		conditionList.add("全部");
		for(PubDmb dmb:dmbList){
			conditionList.add(dmb.getDmms());
		}
		return conditionList;
		
	}
	
	
	
	public Object sjtjGraph1(String kssj,String jssj)
	{
		Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
		Date end = DateUtil.parse(jssj, DateUtil.webFormat);
		List<PubDmb> ajztDmb = dmbService.getDmbByLbbh("JXJS-AJZT");
		List<TjfxResultModel> resultList = new ArrayList<TjfxResultModel>();
		int sz;
		for(PubDmb dmb:ajztDmb){
			TjfxResultModel result = new TjfxResultModel();
			result.setS_type(dmb.getDmms());
			sz = jxjsService.getSumByDate(begin, end, dmb.getDmbh());
			result.setI_sz(sz);
			resultList.add(result);
		}
		return resultList;
	}
	
	
	public Object sjtjGraph2(String kssj,String jssj,String condition)
	{
		Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
		Date end = DateUtil.parse(jssj, DateUtil.webFormat);
		List<PubDmb> ajztDmb = dmbService.getDmbByLbbh("JXJS-AJZT");
		List<TjfxResultModel> resultList = new ArrayList<TjfxResultModel>();
		int sz;
		int sum = 0;
		for(PubDmb dmb:ajztDmb){
			TjfxResultModel result = new TjfxResultModel();
			result.setS_type(dmb.getDmms());
			sz = jxjsService.getSumByCondition(begin, end, dmb.getDmbh(),condition);
			sum += sz;
			result.setI_sz(sz);
			resultList.add(result);
		}
		for(TjfxResultModel result:resultList){
			Double d_sz = (result.getI_sz()+0.0)/sum;
			result.setD_sz(d_sz);
		}
		return resultList;
	}
	
	
	public Object sjtjGraph3(String kssj,String jssj,String condition)
	{
		Date begin = DateUtil.parse(kssj, DateUtil.webFormat);
		Date end = DateUtil.parse(jssj, DateUtil.webFormat);
		List<PubDmb> ajztDmb = dmbService.getDmbByLbbh("JXJS-AJZT");
		List<TjfxResultModel> resultList = new ArrayList<TjfxResultModel>();
		int sz;
		int sum = 0;
		for(PubDmb dmb:ajztDmb){
			TjfxResultModel result = new TjfxResultModel();
			result.setS_type(dmb.getDmms());
			sz = jxjsService.getSumByCondition(begin, end, dmb.getDmbh(),condition);
			sum += sz;
			result.setI_sz(sz);
			resultList.add(result);
		}
		for(TjfxResultModel result:resultList){
			Double d_sz = (result.getI_sz()+0.0)/sum;
			result.setD_sz(d_sz);
		}
		return resultList;
	}
	
	public Object cx(TjfxSearchModel model)
	{
		//logger.info("start date:" + model.getStartDate() + "  end date:" + model.getEndDate() + "  condition:" + model.getCondition());
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
			jv.setClzt(type);
			long days = DateUtil.getDiffDays(new Date(),jxjs.getYpksrq());
			jv.setYfxq(Long.toString(days).concat("天"));
			jccxList.add(jv);
		}
		return jccxList;
	}
}
