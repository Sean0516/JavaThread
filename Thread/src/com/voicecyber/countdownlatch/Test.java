package com.voicecyber.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class Test {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        ReadThread readThread=new ReadThread(countDownLatch);
        new Thread(readThread).start();
        new Thread(readThread).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束等待");
    }

}
