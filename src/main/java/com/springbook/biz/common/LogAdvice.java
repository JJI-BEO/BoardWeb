package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	// 위 포인트컷의 아이디값?
	private void allPointcut() {}
	
	@Before("allPointcut()")
	public void printLog1() {
		System.out.println("[공통 로드] 비즈니스 로직 수행 전 동작");
	}
	@After("allPointcut()")
	public void printLog2() {
		System.out.println("[공통 로드] 비즈니스 로직 수행 후 동작");
	}
	
	
}
