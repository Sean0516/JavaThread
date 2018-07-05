package com.voicecyber.join;


import java.util.concurrent.locks.Lock;

/**
 * Created by Sean on 2018/7/5
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread=new JoinThread(0);
        Thread thread=new Thread(joinThread);
        Thread thread1=new Thread(joinThread);
        Thread thread2=new Thread(joinThread);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
