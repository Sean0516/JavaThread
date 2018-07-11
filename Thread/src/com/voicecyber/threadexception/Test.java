package com.voicecyber.threadexception;

/**
 * Created by Sean on 2018/7/11
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
//        ThreadException exception=new ThreadException();
//        Thread exceptionThread=new Thread(exception);
//        exceptionThread.setUncaughtExceptionHandler((t, e) -> System.out.println("线程：" +t.getName() +e.getMessage()));
//        exceptionThread.setName("exceptionThread");
//        exceptionThread.start();
        DefaultException.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() +"发生异常:"+e.getMessage());
        });
        DefaultException defaultException=new DefaultException();
        defaultException.setName("defaultException");
        DefaultException defaultException1=new DefaultException();
        defaultException1.setName("defaultException1");
        defaultException.start();
        defaultException1.start();
    }
}
