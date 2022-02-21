package com.example.imdb.aop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CachingAspect {
	private Map<String, Map<Integer, Object>> caches = new HashMap<>();

	@Around("""
			  imdbPackage() &&
			     (
			       methodIsCachingAnnotated() ||
			       classIsCachingAnnotated()
			     )
			""")
	public Object cache(ProceedingJoinPoint pjp) throws Throwable {
		Map<Integer, Object> methodCache = caches.get(pjp.getSignature().getName());
		if (Objects.isNull(methodCache)) {
			methodCache = new HashMap<Integer, Object>();
			caches.put(pjp.getSignature().getName(), methodCache);
		} 
		int hash = Objects.hash(pjp.getArgs());
		Object result = methodCache.get(hash);
		if (Objects.isNull(result)) {
			result = pjp.proceed();
			methodCache.put(hash, result);
		}
		return result;

	}

	@Pointcut("@annotation(com.example.imdb.aop.Caching)")
	public void methodIsCachingAnnotated() {
	}

	@Pointcut("within(@com.example.imdb.aop.Caching *)")
	public void classIsCachingAnnotated() {
	}

	@Pointcut("execution( * com.example.imdb..*(..))")
	public void imdbPackage() {
	}

}
