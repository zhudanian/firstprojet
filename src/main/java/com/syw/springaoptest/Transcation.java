package com.syw.springaoptest;

import org.aspectj.lang.ProceedingJoinPoint;

public interface Transcation {
    void begin();
    void commit();
    void rollback();
    Object roundMethod(ProceedingJoinPoint pjp);
}
