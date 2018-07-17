package com.voicecyber.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class Read2Thread implements Runnable {
    private CountDownLatch countDownLatch;

    public Read2Thread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i <4 ; i++) {
            System.out.println(Thread.currentThread().getName() +"Read2Thread 阅读书籍 " +i);
        }
        countDownLatch.countDown();
    }
}
