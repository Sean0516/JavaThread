package com.voicecyber.synchronizied;

import java.util.concurrent.*;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long startTime=System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CountNum countNum = new CountNum();
        CountThread countThread = new CountThread(countNum, countDownLatch);
        CountThread countThread2 = new CountThread(countNum, countDownLatch);
        ExecutorService executorService = Executors.newCachedThreadPool(r -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            t.setDaemon(true);
            return t;
        });
        executorService.submit(countThread);
        executorService.submit(countThread2);
        countDownLatch.await();
        System.out.println(countNum.getNum());
        System.out.println(System.currentTimeMillis()-startTime);

    }

}
