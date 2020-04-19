package com.example.aop;

import org.springframework.stereotype.Service;

@Service
public class ExampleException {
    public void divisonByZero(){
        int i= 10;
        System.out.println( i = 10 / 0);
    }
}
