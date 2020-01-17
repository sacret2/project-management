package com.jrp.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint pjp) {
        log.debug(" -------------AROUND ADVICE - BEFORE-------------------- \n" +
                        "  {}.{} () with arg[s]: {}",
                pjp.getSignature().getDeclaringTypeName(),
                pjp.getSignature().getName(),
                Arrays.toString(pjp.getArgs()));
        log.debug(" ------------------------------------------------ \n \n");

        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e){
            e.printStackTrace();
        }
        log.debug(" -------------AROUND ADVICE - AFTER-------------------- \n" +
                        "  {}.{} () with arg[s]: {}",
                pjp.getSignature().getDeclaringTypeName(),
                pjp.getSignature().getName(),
                Arrays.toString(pjp.getArgs()));
        log.debug(" ------------------------------------------------ \n \n");

        return o;
    }
}
