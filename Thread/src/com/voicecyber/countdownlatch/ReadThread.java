package com.voicecyber.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class ReadThread implements Runnable{
   private CountDownLatch countDownLatch;

    public ReadThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i <4 ; i++) {
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"ReadThread阅读书籍 " +i);
        }
        countDownLatch.countDown();

    }
}
