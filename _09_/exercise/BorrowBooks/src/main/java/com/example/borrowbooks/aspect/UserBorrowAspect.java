package com.example.borrowbooks.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class UserBorrowAspect {
    int count = 0;

    @Pointcut("execution(* com.example.borrowbooks.controller.BookController.create(..))")
    public void userBorrowPointCut() {
    }

    @AfterReturning("userBorrowPointCut()")
    public void userBorrowLog() {
        System.out.println("1 ng??i d�ng m??n s�ch th�nh c�ng, l�c " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.borrowbooks.controller.BookController.payBook(..))")
    public void payBookPointCut() {
    }

    @AfterReturning("payBookPointCut()")
    public void payBookLog() {
        System.out.println("1 ng??i d�ng tr? s�ch th�nh c�ng, l�c " + LocalDateTime.now());
    }

    @Pointcut("within(com.example.borrowbooks.controller.*)")
    public void allMethodPointCut() {
    }
    @After("allMethodPointCut()")
    public void writeAllAction() {
        count++;
        System.out.println("T�nh ??n l�c: " + LocalDateTime.now() + ", c� t?t c?: " + count + " thao t�c v?i th? vi?n");
    }
}
