package edu.cs544.eafinal.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	 @Pointcut("execution(* edu.cs544.eafinal.serviceImpl..*(..))")
	    public void applicationMethod() {}

	
	
	
		  @Before("applicationMethod()")
		  public void logResource(JoinPoint joinPoint) {
		  Logger log = Logger.getLogger("");
		    log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
		    System.out.println();
				    System.out.println( "   **********     TARGET CLASS : " + 
	    			joinPoint.getSignature().getDeclaringTypeName() + "." +
	    			joinPoint.getSignature().getName() + 
	    				    			"    **********");
	  }
	

}
