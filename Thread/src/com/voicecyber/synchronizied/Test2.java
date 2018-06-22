package com.voicecyber.synchronizied;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CountNum2 countNum = new CountNum2();
        CountThread2 countThread = new CountThread2(countNum, countDownLatch);
        CountThread2 countThread2 = new CountThread2(countNum, countDownLatch);
        ExecutorService executorService = Executors.newCachedThreadPool(r -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            t.setDaemon(true);
            return t;
        });
        executorService.submit(countThread);
        executorService.submit(countThread2);
        countDownLatch.await();
        System.out.println(countNum.getNum());
        System.out.println(countNum.getNum()+System.currentTimeMillis()-startTime);
    }
}
