package com.syw.springaoptest;

import com.syw.log.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect//配置一个切面
public class TranscationImpl implements  Transcation {
    @Autowired
    private LogUtil logUtil ;

    @Pointcut("execution(* com.syw.action.*Manager.*(..))")//第一个*表示任意返回值类型,任意类的任意方法的任意参数
    public void txPoint(){

    }
    @Override
    public void begin() {
        System.out.println("开启事务");
    }

    @Override
    public void commit() {
        System.out.println("事务的提交");
    }

    @Override
    public void rollback() {
        System.out.println("事务的回滚");
    }

   @Around("txPoint()")//环绕增强
    public Object roundMethod(ProceedingJoinPoint pjp) {
        Object result=null;
     this.begin();
     try {
         result= pjp.proceed();
         System.out.println(logUtil);
         System.out.println(result);
         //logUtil.logWrite(result.getClass().getName(),result.getClass().getName());
         this.commit();
     }catch (Throwable throwable){
         throwable.printStackTrace();
         this.rollback();
     }finally {
         System.out.println("释放资源");
     }
     return result;
    }
}
