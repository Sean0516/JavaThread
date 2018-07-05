package com.voicecyber.waitandnotify;

/**
 * Created by Sean on 2018/7/4
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        Method method=new Method();
        Thread thread=new Thread(new Customer(method));
        thread.start();
        Thread thread2=new Thread(new Customer(method));
        thread2.start();
        Thread thread1=new Thread(new Producer(method));
        thread1.start();
    }
}
