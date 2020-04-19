package com.example.aop;

import org.junit.*;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {As.class ,Example1.class,ExampleException.class})
public class Example {
    @Autowired
    private As as;
    @Autowired
    private Example1 example1;
    @Autowired
    private ExampleException exampleException;

    @Test
    public void test(){
        Assert.assertFalse(as.isAspectCalled());
        example1.doSomething();
        Assert.assertTrue(as.isAspectCalled());
    }

    @Test(expected = ArithmeticException.class)
    public void testException(){
        exampleException.divisonByZero();
    }
    @Test
    public void testReturn(){
       example1.aspectReturn();
    }


}
