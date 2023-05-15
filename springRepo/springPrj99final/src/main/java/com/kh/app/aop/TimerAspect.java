package com.kh.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class TimerAspect {
	
	//간섭메소드
	
	/*
	 *	<시점>
	 *	@Before
	 *	@After 
	 *	@AfterReturning 
	 *	@AfterThrowing
	 *	@Around
	 */
	
	/*
	 *	<대상>
	 *	target		: 특정 인터페이스와 그 자식클래스
	 *	within		: 특정 패키지 또는 클래스 
	 *	execution	: 표현식으로 형태 지정 
	 */
	
	//@Before("target(com.kh.app.member.dao.MemberDao)")
	public void myAdvice() {
		log.info("before ~~~ !");
	}
	
	//@After("target(com.kh.app.member.dao.MemberDao)")
	//@AfterThrowing("target(com.kh.app.member.dao.MemberDao)")
	//@AfterReturning("target(com.kh.app.member.dao.MemberDao)")
	public void myAdviceAfter() {
		log.info("after ~~~ !");
	}
	
	
	// 메소드 형태가 지정되어 있음
	// 리턴타입 , 파라미터 , 예외
	//@Around("target(com.kh.app.member.dao.MemberDao)")
	@Around("execution( public * com.kh.app.member.dao.MemberDao.login(..) )")
//	@Around("execution( public * com.swy.app.aop.TestService.a() )") //리턴타입 무관
//	@Around("execution( public java.lang.String com.swy.app.aop.TestService.a() )") //리턴타입 String
//	@Around("execution( public * com.swy.app.aop.TestService.a(int) )")//매개변수 int
//	@Around("execution( public * com.swy.app.aop.TestService.a(*) )")//매개변수 1개
//	@Around("execution( public * com.swy.app.aop.TestService.a(..) )")//매개변수 갯수 상관 X
//	@Around("execution( public * com.swy.app.aop.TestService.a*() )") //메소드의 이름이 a로 시작
//	@Around("execution( public * com.swy.app.aop.TestService.*a() )") //메소드의 이름이 a로 끝남
//	@Around("execution( public * com.swy.app.aop.TestService.*() )")// 메소드 이름이 상관 X
//	@Around("execution( public * com.swy.app.aop.TestService.abc*() )")// 메소드 이름이 abc 로 시작
//	@Around("execution( public * com.swy.app.aop.*.*() )")// 해당 패키지의 모든 클래스의 모든 메소드
//	@Around("execution( public * com..*.*(..) )") //com 패키지 하위의 모든 메소드
//	@Around("execution( * com..*.*(..) )")	//접근제한자 안써도 됨 (pubic)
	public Object myAdviceAround(ProceedingJoinPoint jp) throws Throwable {
		
//		System.out.println(jp.getSignature().toShortString());
//		System.out.println(jp.getSignature().toString());
//		System.out.println(jp.getSignature().toLongString());
		
		long start = System.currentTimeMillis();
		Object jpResult = jp.proceed();
		long finish = System.currentTimeMillis();
		long time = finish - start;
		String methodName = jp.getSignature().toString();
		log.info("{} 메소드 실행에 걸린 시간 : {} ms" , methodName , time);
		
		return jpResult;
	}
	
	

}


















