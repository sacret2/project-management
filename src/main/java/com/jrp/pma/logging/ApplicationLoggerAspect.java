package com.jrp.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.jrp.pma.controllers..*)" +
        "||within(com.jrp.pma.dao..*)")
    public void definePackagePointcuts(){
        //empty method just to name the location specified in the pointcut
    }

    @Before("definePackagePointcuts()")
    public void logBefore(JoinPoint jp) {
        log.debug(" -------------BEFORE ADVICE -------------------- \n" +
                "  {}.{} () with arg[s]: {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));
        log.debug(" ------------------------------------------------ \n \n");
    }

    @After("definePackagePointcuts()")
    public void log() {
        log.debug(" ----------------AFTER ADVICE------------------------------ \n");
    }
}
