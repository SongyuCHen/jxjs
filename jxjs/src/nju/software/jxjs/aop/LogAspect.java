package nju.software.jxjs.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 @After(value = "execution(* nju.software.jxjs.service.*.*(..))" )
     public void afterShow() {
          logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@after show." );
    }

}
