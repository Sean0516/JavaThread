package com.voicecyber.baseatomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Sean on 2018/7/13
 *
 * @author Sean
 */
public class CountByAtomic implements Runnable {
    AtomicInteger atomicInteger=new AtomicInteger(1);
    AtomicLong atomicLong=new AtomicLong(1L);
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始更新数据");
        for (int i = 0; i <2 ; i++) {
//            atomicInteger.getAndIncrement();
            atomicLong.getAndIncrement();
        }
//        System.out.println(Thread.currentThread().getName()+"atomicInteger: "+atomicInteger.get());
        System.out.println(Thread.currentThread().getName()+"atomicLong: "+atomicLong.get());
        System.out.println(Thread.currentThread().getName()+" 数据更新结束");

    }
}
