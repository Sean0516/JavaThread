package com.voicecyber.reentrantlock;

/**
 * Created by Sean on 2018/7/6
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        GetNum getNum=new GetNum(0);
        Thread thread=new Thread(getNum);
        Thread thread1=new Thread(getNum);
        thread.start();
        thread1.start();
    }
}
