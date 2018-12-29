package com.syw.log;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class LogUtil {
    public void logWrite(String methodClass,String method){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("log record:"+sdf.format(new Date())+"当前类:"+methodClass+" 方法:"+method);

    }
}
