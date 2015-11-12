package nju.software.jxjs.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import nju.software.jxjs.model.TLog;
import nju.software.jxjs.service.LogService;
import nju.software.jxjs.service.UserService;
import nju.software.jxjs.view.User;

import org.apache.shiro.SecurityUtils;
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
				log.setCzid(1);
				log.setCzsj(today);
				log.setRybh(rybh);
				log.setType("1");
				log.setCzip(ip);
				log.setBz(user.getRealname()+"审批减刑假释");
				logService.addLog(log);
			}
		}
          
    }
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
          
    }
	 @Around(value = "execution(* nju.software.jxjs.service.JxjsService.addJxjsByAjxhDsr(..))" )
     public void addAspect(ProceedingJoinPoint pjp) {
		 /* 获取request对象 */
		 int ajxh = (int) pjp.getArgs()[0];
		 String dsr = (String) pjp.getArgs()[1];
          
    }
	 
	 public String getIp(HttpServletRequest request){
		 String ip = request.getHeader("x-forwarded-for");  
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getHeader("Proxy-Client-IP");  
		    }  
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getHeader("WL-Proxy-Client-IP");  
		    }  
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getRemoteAddr();  
		    } 
		    return ip;
	 }

}
