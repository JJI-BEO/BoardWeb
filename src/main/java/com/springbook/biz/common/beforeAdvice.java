package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
@Aspect
public class beforeAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	// 위 포인트컷의 아이디값?
	private void allPointcut() {}
	
	@Before("allPointcut()")
	public void before(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전 처리]" + method + "()메소드 ARGS정보" + args[0].toString());
	}
}
