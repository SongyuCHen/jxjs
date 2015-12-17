package nju.software.jxjs.aop;

import java.util.Date;

import nju.software.jxjs.model.PubAjJb;
import nju.software.jxjs.model.TLog;
import nju.software.jxjs.service.LogService;
import nju.software.jxjs.service.UserService;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Autowired
	private LogService logService;
	@Autowired
	private UserService userService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 减刑假释审批切面
	 * @param pjp
	 */
	 @Around(value = "execution(* nju.software.jxjs.service.JxjsService.approval(..))" )
     public void approvalAspect(ProceedingJoinPoint pjp) {
		 /* 获取request对象 */
		String parm = (String) pjp.getArgs()[0];
		String[] jxjsbhList = parm.split(",");
		int[] jxjsbh = null;
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String ip = (String) SecurityUtils.getSubject().getSession().getAttribute("currentIP");
		int rybh = userService.getYhbByXM(user.getRealname()).getYhbh();
		TLog log;
		Date today = new Date();
		if(jxjsbhList!=null){
			jxjsbh = new int[jxjsbhList.length];
			for(int i=0;i<jxjsbhList.length;i++){
				jxjsbh[i] = Integer.parseInt(jxjsbhList[i]);
				log = new TLog();
				log.setCzid(jxjsbh[i]);
				log.setCzsj(today);
				log.setRybh(rybh);
				log.setType("1");
				log.setCzip(ip);
				log.setBz(user.getRealname()+"审批减刑假释");
				logService.addLog(log);
			}
		}
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("审批减刑假释切面错误");
			e.printStackTrace();
		}
          
    }
	 /**
	  * 减刑假释退回切面
	  * @param pjp
	  */
	 @Around(value = "execution(* nju.software.jxjs.service.JxjsService.reject(..))" )
     public void rejectAspect(ProceedingJoinPoint pjp) {
		 /* 获取request对象 */
		String parm = (String) pjp.getArgs()[0];
		String[] jxjsbhList = parm.split(",");
		int[] jxjsbh = null;
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		String ip = (String) SecurityUtils.getSubject().getSession().getAttribute("currentIP");
		int rybh = userService.getYhbByXM(user.getRealname()).getYhbh();
		TLog log;
		Date today = new Date();
		if(jxjsbhList!=null){
			jxjsbh = new int[jxjsbhList.length];
			for(int i=0;i<jxjsbhList.length;i++){
				jxjsbh[i] = Integer.parseInt(jxjsbhList[i]);
				log = new TLog();
				log.setCzid(1);
				log.setCzsj(today);
				log.setRybh(rybh);
				log.setType("0");
				log.setCzip(ip);
				log.setBz(user.getRealname()+"退回减刑假释");
				logService.addLog(log);
			}
		}
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("退回减刑假释切面错误");
			e.printStackTrace();
		}
          
    }
	 /**
	  * 减刑假释申请切面
	  * @param pjp
	  */
	 @Around(value = "execution(* nju.software.jxjs.service.JxjsService.addJxjsByAjxhDsr(..))" )
     public void addAspect(ProceedingJoinPoint pjp) {
		 /* 获取request对象 */
		 int ajxh = (int) pjp.getArgs()[0];
		 String dsr = (String) pjp.getArgs()[1];
		 String sqlx = (String)pjp.getArgs()[2];
		 User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		 int rybh = userService.getYhbByXM(user.getRealname()).getYhbh();
		 String ip = (String) SecurityUtils.getSubject().getSession().getAttribute("currentIP");
		 TLog log = new TLog();
		 log.setCzid(ajxh);
		 log.setCzip(ip);
		 log.setCzsj(new Date());
		 log.setRybh(rybh);
		 log.setType("6");
		 log.setBz(user.getRealname()+"申请减刑假释,申请类型:"+sqlx+",当事人:"+dsr);
		 logService.addLog(log);
		 try {
				pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error("申请减刑假释切面错误");
				e.printStackTrace();
			} 
    }
	 /**
	  * 减刑假释立案切面
	  */
	 @Around(value = "execution(* nju.software.jxjs.service.PubAjJbService.add(..))" ) 
	 public void laAspect(ProceedingJoinPoint pjp){
		 PubAjJb aj = (PubAjJb)pjp.getArgs()[0];
		 TLog log = new TLog();
		 User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		 int rybh = userService.getYhbByXM(user.getRealname()).getYhbh();
		 String ip = (String) SecurityUtils.getSubject().getSession().getAttribute("currentIP");
		 log.setCzip(ip);
		 log.setCzsj(new Date());
		 log.setRybh(rybh);
		 log.setType("2");
		 log.setBz(user.getRealname()+"减刑假释立案，案号为:"+aj.getAh());
		 logService.addLog(log);
		 try {
				pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error("减刑假释立案切面错误");
				e.printStackTrace();
			}
	 }
	 /**
	  * 案件传输切面
	  * @param pjp
	  */
	 @After(value = "execution(* nju.software.jxjs.service.PubAjJbService.addXsajTrans(..))" ) 
	 public void transAspect(JoinPoint pjp){
		 String ajxhList = (String)pjp.getArgs()[0];
		 TLog log = new TLog();
		 User user = (User)SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		 int rybh = userService.getYhbByXM(user.getRealname()).getYhbh();
		 String ip = (String) SecurityUtils.getSubject().getSession().getAttribute("currentIP");
		 log.setCzip(ip);
		 log.setCzsj(new Date());
		 log.setRybh(rybh);
		 log.setType("5");
		 log.setBz(user.getRealname()+"刑事案件传输:"+ajxhList);
		 logService.addLog(log);
		 try {
//				pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error("刑事案件传输切面错误");
				e.printStackTrace();
			}
	 }
}
