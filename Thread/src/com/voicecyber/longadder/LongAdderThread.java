package com.voicecyber.longadder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Sean on 2018/12/3
 *
 * @author Sean
 */
public class LongAdderThread implements Runnable {
    private LongAdder longAdder;
    private CountDownLatch countDownLatch;

    public LongAdderThread(LongAdder longAdder, CountDownLatch countDownLatch) {
        this.longAdder = longAdder;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        long sum = longAdder.sum();
        while (sum<100){
            longAdder.increment();
            sum=longAdder.sum();
            System.out.println(Thread.currentThread().getName()+"num is : "+ sum);
        }
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        LongAdder longAdder=new LongAdder();
        CountDownLatch countDownLatch=new CountDownLatch(3);
        for (int i = 0; i <3 ; i++) {
            Thread thread=new Thread(new LongAdderThread( longAdder,countDownLatch));
            thread.setName("Add num Thread "+i);
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
