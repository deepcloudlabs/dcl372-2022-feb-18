package com.example.imdb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProfilingAspect {

	@Around("execution(* *.*(..))")
//	@Before("")
//	@After("")
//	@AfterReturning("")
//	@AfterThrowing("")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		var start = System.nanoTime();
		var result = pjp.proceed();
		var stop = System.nanoTime();
		var duration = stop - start;
		System.out.println(String.format("%s runs %d ns.", 
				pjp.getSignature().getName(), duration));
		return result; 
	}
}
