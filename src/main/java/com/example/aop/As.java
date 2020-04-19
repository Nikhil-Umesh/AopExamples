package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Aspect
@EnableAspectJAutoProxy
public class As {
    boolean executed = false;
    @Before("execution(* *(..))")
    public void execute(JoinPoint joinPoint){
//        System.out.println(joinPoint.getSignature()+","+joinPoint.getStaticPart()+","+joinPoint.getThis());
        executed=true;
    }

    @After("execution( void doSomething(..))")
    public void afterExecute(){
        System.out.println("Called After execution");
    }

    @AfterThrowing(pointcut = "execution(void divisonByZero(..))", throwing = "er")
    public void afterExecuteException(ArithmeticException er){
        System.out.println("Executed After excpetion");
    }

    @AfterReturning(pointcut = "execution(* *(..))", returning = "string")
    public void afterReturningString(String string){
        System.out.println("after returning Aspect called");
    }

    @Around( "execution(int aspectAround(..))")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("called Around");
        System.out.println(proceedingJoinPoint.proceed());
        return proceedingJoinPoint.proceed();
    }

    public boolean isAspectCalled(){
        return executed;
    }
}
