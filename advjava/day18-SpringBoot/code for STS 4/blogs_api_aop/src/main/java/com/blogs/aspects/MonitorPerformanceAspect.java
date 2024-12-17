package com.blogs.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP

@Aspect // to tell SC , class below contains cross cutting concerns(i.e repeatative
//		// task)
@Component // to tell SC : it's a spring bean (i.e manage it's life cycle)

public class MonitorPerformanceAspect {

	// intercept method calls to all of the controllers
	@Around("execution(* com.blogs.controller.*.*(..))")
	public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		// pre processing : before advice
		System.out.println("Begins monitoring ");
		long begin = System.currentTimeMillis();
		System.out.println("Proceeding to req handling method");
		Object ret = joinPoint.proceed();// proceed to controller method
		// post processing : after the method exec
		System.out.println("Time taken by method : " + joinPoint.getSignature() + " in "
				+ (System.currentTimeMillis() - begin) + "msec");
		return ret;
	}
}