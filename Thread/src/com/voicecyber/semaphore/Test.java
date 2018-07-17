package com.voicecyber.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class Test {
    private static  final  int THREAD_POOL_SIZE=20;
    private  static ExecutorService executorService= Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static Semaphore semaphore=new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i <THREAD_POOL_SIZE ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"save data");
                    Thread.sleep(2*1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
