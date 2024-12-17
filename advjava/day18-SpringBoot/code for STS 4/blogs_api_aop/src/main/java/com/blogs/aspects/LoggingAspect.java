package com.blogs.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect//contains cross cutting concern=repeatative logic
@Component //managed by SC
@Slf4j
public class LoggingAspect {
	//Intercept all service layer calls to add logging advice before the method exec
	@Before("execution (* com.blogs.service.*.*(..))")
	public void logIt(JoinPoint joinpoint) {
		System.out.println("in before advice");
		log.info("Logging -"+joinpoint);
	}
	

}
