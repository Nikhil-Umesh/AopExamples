package com.example.aop;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Service
public class Example1 {

    public void doSomething() {
        final String METHODNAME = "doSomething";
        String CLASSNAME="Example1";
        System.out.println("entering " + CLASSNAME + "." + METHODNAME);
        try {
        } catch (RuntimeException ex) {
            System.out.println("entering " + CLASSNAME + "." + METHODNAME);
            throw ex;
        } finally {
            System.out.println("entering " + CLASSNAME + "." + METHODNAME);
        }
    }
    public String aspectReturn(){
        return "String";
    }

    public int aspectAround(){
        return 10;
    }
}
