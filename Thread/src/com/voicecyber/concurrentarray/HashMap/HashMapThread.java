package com.voicecyber.concurrentarray.HashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Sean on 2018/12/18
 *
 * @author Sean
 */
public class HashMapThread implements Runnable {
    private ConcurrentHashMap<String, String> concurrentHashMap;
    private CountDownLatch countDownLatch;

    public HashMapThread(ConcurrentHashMap<String, String> concurrentHashMap, CountDownLatch countDownLatch) {
        this.concurrentHashMap = concurrentHashMap;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            concurrentHashMap.put(Thread.currentThread().getName() + i, "hello word" + i);
            System.out.println("put data "+Thread.currentThread().getName() + i);
        }
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Thread thread=new Thread(new HashMapThread(concurrentHashMap,countDownLatch));
        thread.setName("threadA");
        Thread thread1=new Thread(new HashMapThread(concurrentHashMap,countDownLatch));
        thread1.setName("threadB");
        thread.start();
        thread1.start();
        countDownLatch.await();
        System.out.println("线程允许结束---------");
        for (String s : concurrentHashMap.keySet()) {
            System.out.println(s+"----------"+concurrentHashMap.get(s));
        }
    }
}
