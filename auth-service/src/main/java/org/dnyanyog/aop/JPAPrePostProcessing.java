package org.dnyanyog.aop;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //indicates that class contain aspect
public class JPAPrePostProcessing {

	@Before("execution(* org.dnyanyog.repo.*.save(..))")
	public void beforeExecution(JoinPoint joinPoint) {
		long currentBeforeTimeMills=System.currentTimeMillis();
		Date date=new Date(currentBeforeTimeMills);
SimpleDateFormat sdf=new 	SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.sss");
String formattedDate=sdf.format(date);
System.out.println("Before Saving"+formattedDate);
	}
	
	@After("execution(* org.dnyanyog.repo.*.save(..))")
	public void afterExecution(JoinPoint joinPoint) {
		long currentBeforeTimeMills=System.currentTimeMillis();
		Date date=new Date(currentBeforeTimeMills);
SimpleDateFormat sdf=new 	SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.sss");
String formattedDate=sdf.format(date);
System.out.println("After Saving"+formattedDate);

}
}
