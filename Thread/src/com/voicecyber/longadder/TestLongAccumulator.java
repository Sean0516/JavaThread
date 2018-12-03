package com.voicecyber.longadder;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * Created by Sean on 2018/12/3
 *
 * @author Sean
 */
public class TestLongAccumulator {
    public static void main(String[] args) {
        LongAccumulator longAccumulator=new LongAccumulator(Long::max,0L);
        CountDownLatch countDownLatch=new CountDownLatch(3);
        Random random=new Random();
        for (int i = 0; i <3 ; i++) {
            Thread thread=new Thread(()->{
                long l = random.nextLong();
                System.out.println(Thread.currentThread().getName()+"比较的随机数为："+l);
                longAccumulator.accumulate(l);
                System.out.println(Thread.currentThread().getName()+"当前值为"+longAccumulator.longValue());
                countDownLatch.countDown();
            });
            thread.setName("max num thread "+i);
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(longAccumulator.longValue());
    }
}
