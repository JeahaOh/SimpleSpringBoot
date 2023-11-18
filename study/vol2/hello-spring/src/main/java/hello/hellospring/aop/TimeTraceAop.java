package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by jeaha on 11/18/23
 */
@Aspect
@Component
public class TimeTraceAop {
    
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long bgnTime = System.currentTimeMillis();
    
        System.out.println("BGN : " + joinPoint.toString());
        
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long wasteTime = endTime - bgnTime;
    
            System.out.println("END : " + joinPoint.toString() + " " + wasteTime + "ms.");
        }
    }
}
