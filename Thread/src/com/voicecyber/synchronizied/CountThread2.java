package com.voicecyber.synchronizied;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sean on 2018/6/22
 *
 * @author Sean
 */
public class CountThread2 implements Runnable {
    private CountNum2 countNum;
    private CountDownLatch countDownLatch;

    public CountThread2(CountNum2 countNum ,CountDownLatch countDownLatch) {
        this.countNum = countNum;
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                countNum.count();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countDownLatch.countDown();
    }
}

