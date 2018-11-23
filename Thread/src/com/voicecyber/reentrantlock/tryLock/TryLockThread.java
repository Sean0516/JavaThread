package com.voicecyber.reentrantlock.tryLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sean on 2018/11/14
 *
 * @author Sean
 */
public class TryLockThread implements Runnable {
    private ReentrantLock reentrantLock;

    public TryLockThread(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        while (true){
            try {
                boolean b = reentrantLock.tryLock(1,TimeUnit.SECONDS);
                if ( b){
                   System.out.println(Thread.currentThread().getName()+"lock state is " +b );
                   Thread.sleep(4000);
               }else {
                   System.out.println("thread can not get lock");
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (reentrantLock.isHeldByCurrentThread()){
                    reentrantLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock=new ReentrantLock();
        Thread thread=new Thread(new TryLockThread(reentrantLock));
        thread.start();
        Thread thread1=new Thread(new TryLockThread(reentrantLock));
        thread1.start();
    }
}
