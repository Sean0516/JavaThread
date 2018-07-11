package com.voicecyber.reentrantlock.condition;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        SimpleConditionService simpleConditionService=new SimpleConditionService();
        ThreadA threadA=new ThreadA(simpleConditionService);
        Thread thread=new Thread(threadA);
        thread.start();
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待2 S  唤醒线程");
        simpleConditionService.anotify();
    }
}
