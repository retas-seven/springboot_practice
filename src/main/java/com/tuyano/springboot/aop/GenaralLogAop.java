package com.tuyano.springboot.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GenaralLogAop {
	private static final Logger log = LoggerFactory.getLogger(GenaralLogAop.class);
	
    @Around("execution(* com.tuyano.springboot.service.*..*.*(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = null;
        try {
            String startLog = String.format("[START] %s#%s%n",
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName());
            log.info(startLog);
//            System.out.println(startLog);

            // 業務処理実行
            ret = proceedingJoinPoint.proceed();
            
        } finally {
        	String endLog = String.format("[END] %s#%s%n",
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName());
            log.info(endLog);
//            System.out.println(endLog);
        }
        
        return ret;
    }
}