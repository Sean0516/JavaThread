package com.voicecyber.synchronizied;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sean on 2018/6/21
 *
 * @author Sean
 */
public class CountThread implements Runnable {
   private CountNum countNum;
   private CountDownLatch countDownLatch;

    public CountThread(CountNum countNum ,CountDownLatch countDownLatch) {
        this.countNum = countNum;
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            countNum.count();
            System.out.println(countNum.getNum()+Thread.currentThread().getName());
        }
        countDownLatch.countDown();
    }
}
