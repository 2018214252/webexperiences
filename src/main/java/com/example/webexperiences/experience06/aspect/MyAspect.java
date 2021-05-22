package com.example.webexperiences.experience06.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.example.webexperiences.experience06.service.UserService.buy*(..))")
    public void pointcut(){}

    @Around(("pointcut()"))
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object object = joinPoint.proceed();
        long end = System.nanoTime();
        log.debug("执行时间: {}",end-start);
        return object;
    }

    @Around(value = "@within(myInterceptor)||@annotation(myInterceptor)")
    public Object interceptorTarget(ProceedingJoinPoint joinPoint,MyInterceptor myInterceptor) throws Throwable {
        if(myInterceptor == null){
            myInterceptor = joinPoint.getTarget().getClass().getAnnotation(MyInterceptor.class);
        }
        for(MyInterceptor.MyAuthorityType t:myInterceptor.value()){
            log.debug(String.valueOf(t));
        }
        return joinPoint.proceed();
    }

}
