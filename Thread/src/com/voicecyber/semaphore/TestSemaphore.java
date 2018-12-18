package com.voicecyber.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Sean on 2018/7/17
 *
 * @author Sean
 */
public class TestSemaphore {
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
                    System.out.println("还有："+semaphore.getQueueLength() +" 个线程在等待信号量");
                    System.out.println("是否还有线程在等待信号量: "+semaphore.hasQueuedThreads());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
