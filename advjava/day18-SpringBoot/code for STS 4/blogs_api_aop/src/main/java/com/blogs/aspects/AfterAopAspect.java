package com.blogs.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//AOP

@Aspect
@Component
//@Slf4j
public class AfterAopAspect {

	// private Logger log = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.blogs.service.*.*(..))", returning = "result123")
	public void afterReturning(JoinPoint joinPoint, Object result123) {
		System.out.println("After Ret advice :" 
	+ joinPoint.getSignature() + "returned with value " + result123);
	}

	@After(value = "execution(* com.blogs.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		// getSignature() : rets entire method signature.
		System.out.println("After advice : after execution of -"+joinPoint.getSignature());
	}

	@AfterThrowing(value = "execution(* com.blogs.service.*.*(..))", throwing = "exc")
	public void afterThrowing(Exception exc) {
		System.out.println("After throwing advice : Exception occurred  : " + exc);
	}
}