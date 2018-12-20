package com.voicecyber.executors.invokeAny;

import java.util.concurrent.Callable;

/**
 * Created by Sean on 2018/12/18
 *
 * @author Sean
 */
public class ThreadA implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+ "say hello world ThreadA");
        }
        return "ThreadA";
    }
}
