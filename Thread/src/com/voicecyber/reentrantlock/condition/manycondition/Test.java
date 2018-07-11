package com.voicecyber.reentrantlock.condition.manycondition;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        ManyConditionService service=new ManyConditionService();
        ThreadA threadA=new ThreadA(service);
        ThreadB threadB=new ThreadB(service);
        Thread thread=new Thread(threadA);
        Thread thread1=new Thread(threadB);
        thread.start();
        thread1.start();
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.anotifyA();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.anotifyB();
    }
}
