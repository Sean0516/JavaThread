package com.voicecyber.synchronizied;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        CountNum countNum=new CountNum();
        CountThread countThread=new CountThread(countNum,countDownLatch);
        CountThread countThread2=new CountThread(countNum,countDownLatch);
        Thread thread=new Thread(countThread);
        Thread thread2=new Thread(countThread2);
        thread.start();
        thread2.start();
        countDownLatch.await();
        System.out.println(countNum.getNum());
    }

}
